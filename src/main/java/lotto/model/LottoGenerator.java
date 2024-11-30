package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Value;

public class LottoGenerator {
	private int money;

	public LottoGenerator(String money) {
		validateNumber(money);
		validateDivisible(money);

		this.money = Integer.parseInt(money);
	}

	public int getMoney() {
		return money;
	}

	public int getCounter() {
		return money / Value.MONEY_DIVISION;
	}

	public Lotto generateLotto() {
		return new Lotto(createNumbers());
	}

	private List<Integer> createNumbers() {
		return Randoms.pickUniqueNumbersInRange(Value.LOTTO_MIN, Value.LOTTO_MAX, Value.LOTTO_SIZE);
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

		if (buyingMoney % Value.MONEY_DIVISION != 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE);
		}
	}
}
