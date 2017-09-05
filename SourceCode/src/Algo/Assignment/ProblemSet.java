package Algo.Assignment;


public class ProblemSet {
	public static final double LOC_X_LOW = -1400;
	public static final double LOC_X_HIGH = 1400;
	public static final double LOC_Y_LOW = -1400;
	public static final double LOC_Y_HIGH = 1400;
	public static final double VEL_LOW = -200;
	public static final double VEL_HIGH = 200;
	public ProblemSet()
	{
		
		
	}
	public static double evaluate(Hub hub,Location loc,Server server) {
		double result = 0;

	
		int constraint= hub.getPacketConstraint();	
		double  requirement=hub.getRequirement();
		int x = (int) Math.pow((server.getServerX()-loc.getLoc()[0]), 2);
		int y = (int) Math.pow((server.getServerY()-loc.getLoc()[1]), 2);
		int distance= (int) Math.sqrt(x + y);
		double offering=server.getServerOffering();
		result=Math.abs((distance - (distance*offering/(requirement))));
	 

		return result;
	}
}
