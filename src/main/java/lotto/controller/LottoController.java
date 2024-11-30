package lotto.controller;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private InputView inputView;
	private OutputView outputView;
	private LottoGenerator lottoGenerator;
	private Buyer buyer;

	public LottoController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		enterMoney();
		purchaseLotto();
		showLotto();


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
		for(int i=0; i< lottoGenerator.getCounter(); i++) {
			buyer.addLotto(lottoGenerator.generateLotto());
		}
	}

	private void showLotto() {
		outputView.printLotto(lottoGenerator.getCounter(), buyer);
	}

}
