package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Value;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != Value.LOTTO_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.subList(0, i).contains(numbers.get(i))) {
				throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		List<Integer> copy = new ArrayList<>(numbers);
		Collections.sort(copy);
		return copy.toString();
	}
}
