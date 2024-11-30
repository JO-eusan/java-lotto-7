package lotto.model;

import lotto.model.constant.ErrorMessage;

public class LottoGenerator {
	private int money;

	public LottoGenerator(String money) {
		validateNumber(money);
		validateDivisible(money);

		this.money = Integer.parseInt(money);
	}

	public int calculateCounter() {
		return this.money / 1000;
	}

	private void validateNumber(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	private void validateDivisible(String money) {
		int buyingMoney = Integer.parseInt(money);

		if (buyingMoney % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE);
		}
	}
}
