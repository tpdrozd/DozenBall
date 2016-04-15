package ball;

public class Abnormality {
	
	private int		position;
	
	private Anomaly	anomaly;
	
	public Abnormality ( int position, Anomaly anomaly ) {
		this.position = position;
		this.anomaly = anomaly;
	}
	
	public int getPosition () {
		return position;
	}
	
	public Anomaly getAnomaly () {
		return anomaly;
	}
	
	public enum Anomaly {
		HEAVIER,
		LIGHTER
	}
	
	@Override
	public String toString () {
		StringBuffer sb = new StringBuffer();
		sb.append(position).append(" ").append(anomaly);
		return sb.toString();
	}
	
	@Override
	public boolean equals ( Object obj ) {
		if ( this == obj )
			return true;
		
		if ( obj instanceof Abnormality ) {
			Abnormality that = (Abnormality) obj;
			return this.position == that.position && this.anomaly.equals(that.anomaly);
		}
		else
			return false;
	}
	
}
