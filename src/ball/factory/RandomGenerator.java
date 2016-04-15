package ball.factory;

import java.util.Random;

import ball.Abnormality;
import ball.Abnormality.Anomaly;

class RandomGenerator {
	
	private static final Random	RANDOM	= new Random();
	
	int randomPosition () {
		return RANDOM.nextInt(12) + 1;
	}
	
	Anomaly randomAnomaly () {
		return RANDOM.nextBoolean() ? Anomaly.HEAVIER : Anomaly.LIGHTER;
	}
	
	Abnormality randomAbnormality () {
		int position = randomPosition();
		Anomaly anomaly = randomAnomaly();
		Abnormality abnormality = new Abnormality(position, anomaly);
		return abnormality;
	}
	
	double randomWeight () {
		return RANDOM.nextDouble() + 1;
	}
	
}
