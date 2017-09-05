package Algo.Assignment;

public class Particle {
	private double fitnessValue;
	private Velocity velocity;
	private Location location;
	private Server server;
	public Hub hub;
	
	
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void setFitnessValue(double fitnessValue) {
		this.fitnessValue = fitnessValue;
	}

	public Particle() {
		super();
	}

	public Particle(double fitnessValue, Velocity velocity, Location location) {
		super();
		this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.location = location;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public double getFitnessValue(Hub hub,Location location,Server server) {
		fitnessValue = ProblemSet.evaluate(hub,location,server);
		return fitnessValue;
	}
}