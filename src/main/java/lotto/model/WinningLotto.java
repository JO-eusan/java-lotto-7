package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Value;

public class WinningLotto {
	private List<Integer> winningNumbers;
	private int bonusNumber;

	public WinningLotto(String winningNumbers, String bonusNumber) {
		String[] numbers = winningNumbers.split(",");
		validateSize(numbers);
		validateNumber(numbers);
		validateDuplicate(numbers);
		this.winningNumbers = createWinningNumbers(numbers);

		validateNumber(bonusNumber);
		validateDuplicate(bonusNumber);
		this.bonusNumber = Integer.parseInt(bonusNumber);
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private List<Integer> createWinningNumbers(String[] numbers) {
		List<Integer> tmp = new ArrayList<>();
		for (String number : numbers) {
			tmp.add(Integer.parseInt(number));
		}
		return tmp;
	}

	private void validateSize(String[] numbers) {
		if (numbers.length != Value.LOTTO_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR_MESSAGE);
		}
	}

	private void validateNumber(String[] numbers) {
		for (String number : numbers) {
			try {
				Integer.parseInt(number);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
			}
		}
	}

	private void validateDuplicate(String[] numbers) {
		List<Integer> tmp = new ArrayList<>();
		for (String number : numbers) {
			if (tmp.contains(Integer.parseInt(number))) {
				throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE);
			}
			tmp.add(Integer.parseInt(number));
		}
	}

	private void validateNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(String number) {
		if (winningNumbers.contains(Integer.parseInt(number))) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE);
		}
	}
}
