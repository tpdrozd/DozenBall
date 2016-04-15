package ball.factory;

import ball.Abnormality.Anomaly;

class WeightsGenerator {
	
	private RandomGenerator	generator	= new RandomGenerator();
	
	Weights generateWeights () {
		Weights weights = new Weights();
		
		weights.normal = generator.randomWeight();
		weights.abnormal = generator.randomWeight();
		
		while ( weights.normal == weights.abnormal )
			weights.abnormal = generator.randomWeight();
		
		return weights;
	}
	
	Weights generateWeights ( Anomaly anomaly ) {
		Weights weights = generateWeights();
		
		if ( anomaly.equals(Anomaly.HEAVIER) && weights.normal > weights.abnormal )
			replaceEachOther(weights);
		
		if ( anomaly.equals(Anomaly.LIGHTER) && weights.normal < weights.abnormal )
			replaceEachOther(weights);
		
		return weights;
	}
	
	private void replaceEachOther ( Weights weight ) {
		double memory = weight.normal;
		weight.normal = weight.abnormal;
		weight.abnormal = memory;
	}
	
	class Weights {
		
		double	normal;
		
		double	abnormal;
	}
	
}
