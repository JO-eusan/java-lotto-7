package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {
	private final List<Lotto> lottoStore;
	private HashMap<Rank, Integer> rankResult;

	public Buyer() {
		this.lottoStore = new ArrayList<>();
		this.rankResult = new HashMap<>();

		for(Rank rank : Rank.values()) {
			rankResult.put(rank, 0);
		}
	}

	public List<Lotto> getLottoStore() {
		return lottoStore;
	}

	public HashMap<Rank, Integer> getRankResult() {
		return rankResult;
	}

	public void addLotto(Lotto lotto) {
		lottoStore.add(lotto);
	}

	public void calculateRank(WinningLotto winningLotto) {
		for(Lotto lotto : lottoStore) {
			Rank rank = Rank.checkRank(lotto, winningLotto);
			rankResult.put(rank, rankResult.get(rank) + 1);
		}
	}

	public long calculateProfit() {
		long total = 0;
		for(Rank rank : Rank.values()) {
			total += (rankResult.get(rank) * rank.winningMoney);
		}
		return total;
	}
}
