package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.constant.ErrorMessage;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR_MESSAGE);
		}
	}

	@Override
	public String toString() {
		List<Integer> copy = new ArrayList<>(numbers);
		Collections.sort(copy);
		return copy.toString();
	}
}
