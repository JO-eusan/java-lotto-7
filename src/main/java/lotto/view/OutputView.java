package lotto.view;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] ";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_FORMAT + e.getMessage());
	}
}
