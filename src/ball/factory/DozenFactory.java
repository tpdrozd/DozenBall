package ball.factory;

import ball.Abnormality;
import ball.Ball;
import ball.Dozen;
import ball.factory.WeightsGenerator.Weights;

public class DozenFactory {
	
	private RandomGenerator		randomGenerator		= new RandomGenerator();
	
	private WeightsGenerator	weightsGenerator	= new WeightsGenerator();
	
	public Dozen createAbnormal () {
		Abnormality abnormality = randomGenerator.randomAbnormality();
		System.out.print(abnormality.toString() + "\t");
		Dozen dozen = createAbnormal(abnormality);
		return dozen;
	}
	
	public Dozen createAbnormal ( Abnormality abnormality ) {
		Weights weights = weightsGenerator.generateWeights(abnormality.getAnomaly());
		Dozen dozen = create(abnormality.getPosition(), weights);
		return dozen;
	}
	
	private Dozen create ( int position, Weights weights ) {
		RealDozen dozen = new RealDozen();
		
		dozen.b01 = new RealBall(position == 1 ? weights.abnormal : weights.normal);
		dozen.b02 = new RealBall(position == 2 ? weights.abnormal : weights.normal);
		dozen.b03 = new RealBall(position == 3 ? weights.abnormal : weights.normal);
		dozen.b04 = new RealBall(position == 4 ? weights.abnormal : weights.normal);
		dozen.b05 = new RealBall(position == 5 ? weights.abnormal : weights.normal);
		dozen.b06 = new RealBall(position == 6 ? weights.abnormal : weights.normal);
		dozen.b07 = new RealBall(position == 7 ? weights.abnormal : weights.normal);
		dozen.b08 = new RealBall(position == 8 ? weights.abnormal : weights.normal);
		dozen.b09 = new RealBall(position == 9 ? weights.abnormal : weights.normal);
		dozen.b10 = new RealBall(position == 10 ? weights.abnormal : weights.normal);
		dozen.b11 = new RealBall(position == 11 ? weights.abnormal : weights.normal);
		dozen.b12 = new RealBall(position == 12 ? weights.abnormal : weights.normal);
		
		return dozen;
	}
	
	private class RealBall implements Ball {
		
		private double	weight;
		
		RealBall ( double weight ) {
			this.weight = weight;
		}
		
		@Override
		public double getWeight () {
			return weight;
		}
	} //end of inner class RealBall
	
	private class RealDozen implements Dozen {
		
		Ball	b01, b02, b03, b04, b05, b06, b07, b08, b09, b10, b11, b12;
		
		@Override
		public Ball b01 () {
			return b01;
		}
		
		@Override
		public Ball b02 () {
			return b02;
		}
		
		@Override
		public Ball b03 () {
			return b03;
		}
		
		@Override
		public Ball b04 () {
			return b04;
		}
		
		@Override
		public Ball b05 () {
			return b05;
		}
		
		@Override
		public Ball b06 () {
			return b06;
		}
		
		@Override
		public Ball b07 () {
			return b07;
		}
		
		@Override
		public Ball b08 () {
			return b08;
		}
		
		@Override
		public Ball b09 () {
			return b09;
		}
		
		@Override
		public Ball b10 () {
			return b10;
		}
		
		@Override
		public Ball b11 () {
			return b11;
		}
		
		@Override
		public Ball b12 () {
			return b12;
		}
		
	}
}
