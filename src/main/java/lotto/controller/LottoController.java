package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private InputView inputView;
	private OutputView outputView;
	private LottoGenerator lottoGenerator;

	public LottoController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		enterMoney();

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

}
