package lotto.view;

import lotto.model.Buyer;
import lotto.model.Lotto;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] ";
	private static final String BUYING_MESSAGE = "%d개를 구매했습니다.";

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_FORMAT + e.getMessage());
	}

	public void printLotto(int counter, Buyer buyer) {
		System.out.println();
		System.out.printf(BUYING_MESSAGE, counter);
		System.out.println();

		for(Lotto lotto : buyer.getLottoStore()) {
			System.out.println(lotto);
		}
	}


}
