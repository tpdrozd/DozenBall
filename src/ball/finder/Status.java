package ball.finder;

public enum Status {
	UNKNOWN ( true, false ),
	LIGHTABLE ( false, false ),
	HEAVYABLE ( false, false ),
	STANDARD ( false, true ),
	LIGHTER ( false, true ),
	HEAVIER ( false, true );
	
	private boolean	initial;
	
	private boolean	finals;
	
	private Status ( boolean start, boolean finals ) {
		this.initial = start;
		this.finals = finals;
	}
	
	public boolean isInitial () {
		return initial;
	}
	
	public boolean isFinal () {
		return finals;
	}
	
	public boolean isUnknown () {
		return UNKNOWN.equals(this);
	}
	
	public boolean isLightable () {
		return LIGHTABLE.equals(this);
	}
	
	public boolean isHeavyable () {
		return HEAVYABLE.equals(this);
	}
	
}
