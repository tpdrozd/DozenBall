package ball;

import ball.factory.DozenFactory;
import ball.finder.AbnormalityFinderService;

public class Main {
	
	DozenFactory				dozenFactory	= new DozenFactory();
	
	AbnormalityFinderService	finderService	= new AbnormalityFinderService();
	
	public void execute () {
		Dozen dozen = dozenFactory.createAbnormal();
		
		try {
			Abnormality abnormality = finderService.find(dozen);
			System.out.println("Ball at position " + abnormality.getPosition() + " is " + abnormality.getAnomaly() + ".");
		}
		catch ( Exception e ) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public static void main ( String argv[] ) {
		Main main = new Main();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();
		main.execute();

		main.execute();
		main.execute();
	}
	
}
