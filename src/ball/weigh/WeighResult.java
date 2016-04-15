package ball.weigh;

public enum WeighResult {
	HEAVIER,
	EQUALS,
	LIGHTER;
	
	public boolean isHeavier () {
		return HEAVIER.equals(this);
	}
	
	public boolean isEquals () {
		return EQUALS.equals(this);
	}
	
	public boolean isLighter () {
		return LIGHTER.equals(this);
	}
}
