package com.example.notepad;

public class LongWrapper {

	private Object key = new Object();
	private long l;

	public LongWrapper(long l) {
		this.l = l;
	}

	public long getValue() {
		synchronized (key) {
			return l;
		}
	}

	public long getDouble(long l) {
		return 2*l;
	}

	public void incrementValue() {
		synchronized (key) {
			l = l + 1;
		}
	}
}
