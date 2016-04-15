package ball.finder;

import ball.Abnormality;
import ball.Abnormality.Anomaly;
import ball.Ball;
import ball.Dozen;
import ball.weigh.WeighResult;
import ball.weigh.WeighService;

public class AbnormalityFinderService {
	
	private WeighService	weighService	= new WeighService();
	
	public Abnormality find ( Dozen dozen ) throws Exception {
		return find(dozen.b01(), dozen.b02(), dozen.b03(), dozen.b04(), dozen.b05(), dozen.b06(), dozen.b07(), dozen.b08(), dozen.b09(), dozen.b10(), dozen.b11(), dozen.b12());
	}
	
	public Abnormality find ( Ball b01, Ball b02, Ball b03, Ball b04, Ball b05, Ball b06, Ball b07, Ball b08, Ball b09, Ball b10, Ball b11, Ball b12 ) throws Exception {
		Abnormality abnormality = null;
		
		// first weighing
		WeighResult firstResult = weighService.left(b01, b02, b03, b04).right(b05, b06, b07, b08);
		
		if ( firstResult.isHeavier() ) {
			// second weighing
			WeighResult secondResult = weighService.left(b01, b02, b06, b07).right(b05, b03, b11, b12);
			
			if ( secondResult.isHeavier() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b01).right(b02);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(1, Anomaly.HEAVIER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(5, Anomaly.LIGHTER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(2, Anomaly.HEAVIER);
			}
			
			if ( secondResult.isEquals() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b04).right(b12);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(4, Anomaly.HEAVIER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(8, Anomaly.LIGHTER);
				if ( thirdResult.isLighter() )
					throw new Exception("heavier equal lighter");
			}
			
			if ( secondResult.isLighter() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b06).right(b07);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(7, Anomaly.LIGHTER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(3, Anomaly.HEAVIER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(6, Anomaly.LIGHTER);
			}
		}
		
		if ( firstResult.isEquals() ) {
			// second weighing
			WeighResult secondResult = weighService.left(b09, b10).right(b11, b01);
			
			if ( secondResult.isHeavier() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b09).right(b10);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(9, Anomaly.HEAVIER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(11, Anomaly.LIGHTER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(10, Anomaly.HEAVIER);
			}
			
			if ( secondResult.isEquals() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b12).right(b01);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(12, Anomaly.HEAVIER);
				if ( thirdResult.isEquals() )
					throw new Exception("equal equal equal");
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(12, Anomaly.LIGHTER);
			}
			
			if ( secondResult.isLighter() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b09).right(b10);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(10, Anomaly.LIGHTER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(11, Anomaly.HEAVIER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(9, Anomaly.LIGHTER);
			}
		}
		
		if ( firstResult.isLighter() ) {
			// second weighing
			WeighResult secondResult = weighService.left(b01, b02, b06, b07).right(b05, b03, b11, b12);
			
			if ( secondResult.isHeavier() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b06).right(b07);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(6, Anomaly.HEAVIER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(3, Anomaly.LIGHTER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(7, Anomaly.HEAVIER);
			}
			
			if ( secondResult.isEquals() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b04).right(b12);
				
				if ( thirdResult.isHeavier() )
					throw new Exception("lighter equal heavier");
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(8, Anomaly.HEAVIER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(4, Anomaly.LIGHTER);
			}
			
			if ( secondResult.isLighter() ) {
				// third weighing
				WeighResult thirdResult = weighService.left(b01).right(b02);
				
				if ( thirdResult.isHeavier() )
					abnormality = new Abnormality(2, Anomaly.LIGHTER);
				if ( thirdResult.isEquals() )
					abnormality = new Abnormality(5, Anomaly.HEAVIER);
				if ( thirdResult.isLighter() )
					abnormality = new Abnormality(1, Anomaly.LIGHTER);
			}
		}
		
		return abnormality;
	}
}
