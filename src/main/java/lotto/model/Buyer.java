package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
	private final List<Lotto> lottoStore;

	public Buyer() {
		this.lottoStore = new ArrayList<>();
	}

	public List<Lotto> getLottoStore() {
		return lottoStore;
	}

	public void addLotto(Lotto lotto) {
		lottoStore.add(lotto);
	}

}
