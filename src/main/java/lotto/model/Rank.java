package lotto.model;

import java.util.List;

public enum Rank {
	FIFTH(3, false, 5000),
	FOURTH(4, false, 50000),
	THIRD(5, false, 1500000),
	SECOND(5, true, 30000000),
	FIRST(6, false, 2000000000),
	NOTHING(0, false, 0);

	public int correctCounter;
	public boolean bonusCounter;
	public int winningMoney;

	private Rank(int correctCounter, boolean bonusCounter, int winningMoney) {
		this.correctCounter = correctCounter;
		this.bonusCounter = bonusCounter;
		this.winningMoney = winningMoney;
	}

	public static Rank checkRank(Lotto lotto, WinningLotto winningLotto) {
		List<Integer> myNumbers = lotto.getNumbers();
		List<Integer> winningNumbers = winningLotto.getWinningNumbers();
		int bonusNumber = winningLotto.getBonusNumber();

		int counter = 0;
		for(int num : myNumbers) {
			if(winningNumbers.contains(num)) {
				counter++;
			}
		}
		return getRank(counter, myNumbers.contains(bonusNumber));
	}

	private static Rank getRank(int counter, boolean bonusCounter) {
		for(Rank rank : values()) {
			if(rank.correctCounter == counter && rank.bonusCounter == bonusCounter) {
				return rank;
			}
		}
		return NOTHING;
	}

}
