package lotto.view;

import java.util.HashMap;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] ";
	private static final String BUYING_MESSAGE = "%d개를 구매했습니다.";
	private static final String STATICS_START_MESSAGE = "당첨 통계";
	private static final String DASH = "---";
	private static final String RANKING_DEFAULT_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
	private static final String RANKING_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
	private static final String STATICS_MESSAGE = "총 수익률은 %.1f%%입니다.";

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

	public void printStaticsStart() {
		System.out.println();
		System.out.println(STATICS_START_MESSAGE);
		System.out.println(DASH);
	}

	public void printRank(Buyer buyer) {
		HashMap<Rank, Integer> result = buyer.getRankResult();
		for(Rank rank : Rank.values()) {
			if(rank == Rank.SECOND) {
				System.out.printf(RANKING_BONUS_MESSAGE, rank.correctCounter, rank.winningMoney, result.get(rank));
			}
			if(rank != Rank.NOTHING) {
				System.out.printf(RANKING_DEFAULT_MESSAGE, rank.correctCounter, rank.winningMoney, result.get(rank));
			}
		}
	}

	public void printStatics(double rate) {
		System.out.printf(STATICS_MESSAGE, rate);
	}
}
