package lotto.controller;

import lotto.model.Buyer;
import lotto.model.LottoGenerator;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private InputView inputView;
	private OutputView outputView;
	private LottoGenerator lottoGenerator;
	private Buyer buyer;
	private WinningLotto winningLotto;

	public LottoController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		enterMoney();
		purchaseLotto();
		showLotto();
		enterWinningLotto();
		ranking();
		showStatics();
	}

	private void enterMoney() {
		String input = inputView.readMoney();
		try {
			this.lottoGenerator = new LottoGenerator(input);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			enterMoney();
		}
	}

	private void purchaseLotto() {
		this.buyer = new Buyer();
		for (int i = 0; i < lottoGenerator.getCounter(); i++) {
			buyer.addLotto(lottoGenerator.generateLotto());
		}
	}

	private void showLotto() {
		outputView.printLotto(lottoGenerator.getCounter(), buyer);
	}

	private void enterWinningLotto() {
		String winningNumbers = inputView.readWinningNumbers();
		String bonusNumber = inputView.readBonusNumber();
		try {
			this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			enterWinningLotto();
		}
	}

	private void ranking() {
		buyer.calculateRank(winningLotto);
		outputView.printStaticsStart();
		outputView.printRank(buyer);
	}

	private void showStatics() {
		long profit = buyer.calculateProfit();
		long money = lottoGenerator.getMoney();
		double rate = (double)profit / money * 100;
		outputView.printStatics(rate);
	}
}
