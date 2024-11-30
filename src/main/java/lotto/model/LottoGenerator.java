package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.constant.ErrorMessage;

public class LottoGenerator {
	private int money;

	public LottoGenerator(String money) {
		validateNumber(money);
		validateDivisible(money);

		this.money = Integer.parseInt(money);
	}

	public int getCounter() {
		return money / 1000;
	}

	public Lotto generateLotto() {
		return new Lotto(createNumbers());
	}

	private List<Integer> createNumbers() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
