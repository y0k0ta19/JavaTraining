package ex21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ShortStrings implements ListIterator<String> {
	private ListIterator<String> strings;
	private String prevShort;
	private String nextShort;
	private final int maxLen;

	public ShortStrings(ListIterator<String> strings, int maxLen) {
		//super(strings, maxLen);
		this.strings = strings;
		this.maxLen = maxLen;
		this.prevShort = null;
	}

	public boolean hasPrevious() {
		if (prevShort != null)
			return true;
		while (strings.hasPrevious()) {
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen)
				return true;
		}
		prevShort = null;
		return false;
	}

	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String n = prevShort;
		prevShort = null;
		return n;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	public int nextIndex() {
		return strings.nextIndex();
	}

	public int previousIndex() {
		return strings.previousIndex();
	}

	public void add(String arg0) {
		throw new UnsupportedOperationException();
	}

	public void set(String arg0) {
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNext() {
		if (nextShort != null)
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;
		return false;
	}
	
	public String next() {
		if (nextShort == null & !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;
		nextShort = null;
		return n;
	}
}