package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final int nButton;
	private final List<Integer> values;

	public LogicsImpl(int size) {
		this.nButton = size;
		values = new ArrayList<>();
		for (int i = 0; i < nButton; i++) {
			values.add(0);
		}
	}

	@Override
	public int size() {
		return this.nButton;
	}

	@Override
	public List<Integer> values() {
		return Collections.unmodifiableList(values);
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream().map(e -> e < nButton).toList();
	}

	@Override
	public int hit(int elem) {
		this.values.set(elem, this.values.get(elem) + 1);
		return this.values.get(elem);
	}

	@Override
	public String result() {
		return values.stream()
			.map(e-> e.toString())
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.values.stream()
			.allMatch(i -> i.equals(values.get(0)));
	}
}
