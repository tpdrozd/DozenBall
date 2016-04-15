package ball.weigh;

import ball.Ball;

public class WeighService {
	
	public WeighResult weigh ( Ball[] leftBalls, Ball[] rightBalls ) {
		double leftsWeight = 0;
		for ( Ball ball: leftBalls )
			leftsWeight += ball.getWeight();
		
		double rightsWeight = 0;
		for ( Ball ball: rightBalls )
			rightsWeight += ball.getWeight();
		
		if ( leftsWeight > rightsWeight )
			return WeighResult.HEAVIER;
		else if ( leftsWeight == rightsWeight )
			return WeighResult.EQUALS;
		else
			return WeighResult.LIGHTER;
	}
	
	public WeighingContext left ( Ball... balls ) {
		return new WeighingContext(this, balls);
	}
	
	public class WeighingContext {
		
		private WeighService	service;
		
		private Ball[]			leftBalls;
		
		private WeighingContext ( WeighService service, Ball... leftBalls ) {
			this.service = service;
			this.leftBalls = leftBalls;
		}
		
		public WeighResult right ( Ball... rightBalls ) {
			return service.weigh(leftBalls, rightBalls);
		}
		
	}
	
}
