package Algo.Assignment;

import java.util.ArrayList;

/* author: gandhi - gandhi.mtm [at] gmail [dot] com - Depok, Indonesia */

// this is the heart of the PSO program
// the code is for 2-dimensional space problem
// but you can easily modify it to solve higher dimensional space problem

import java.util.Random;
import java.util.Vector;

public class PSOProcess implements PSOConstants {
	private ArrayList<Particle> swarm = new ArrayList<Particle>();
	private double[] pBest = new double[SWARM_SIZE];
	private ArrayList<Location> pBestLocation = new ArrayList<Location>();
	private double gBest;
	private Location gBestLocation;
	private double[] fitnessValueList = new double[SWARM_SIZE];
	public Hub h; 
	int lastBest;
	
	Random generator = new Random();
	
	public void execute() {
		h = new Hub();
		h.setRequirement(requirement);
		h.setHubX((int) (ProblemSet.LOC_X_LOW + generator.nextDouble() * (ProblemSet.LOC_X_HIGH - ProblemSet.LOC_X_LOW)));
		h.setHubY((int) (ProblemSet.LOC_Y_LOW + generator.nextDouble() * (ProblemSet.LOC_Y_HIGH - ProblemSet.LOC_Y_LOW)));
		initializeSwarm();
		updateFitnessList(h,swarm);
		int k = 0;
		
		for(int i=0; i<SWARM_SIZE; i++) {
			pBest[i] = fitnessValueList[i];
			pBestLocation.add(swarm.get(i).getLocation());
		}
		
		int t = 0;
		double w;
		double err = 9999;
		
		while(t < MAX_ITERATION )
		{
			for(int i=0; i<SWARM_SIZE; i++) {
				if(fitnessValueList[i] < pBest[i]) {
					pBest[i] = fitnessValueList[i];
					pBestLocation.set(i, swarm.get(i).getLocation());
				}
			}
				
			// step 2 - update gBest
			int bestParticleIndex = PSOUtility.getMinPos(fitnessValueList);
			if(t == 0 || fitnessValueList[bestParticleIndex] < gBest) {
				gBest = fitnessValueList[bestParticleIndex];
				gBestLocation = swarm.get(bestParticleIndex).getLocation();
				//gBestLocation = swarm.get(bestParticleIndex).getServer();
			}
			
	
	   w = 1;	
			for(int i=0; i<SWARM_SIZE; i++) {
				double r1 = generator.nextDouble();
				double r2 = generator.nextDouble();
				
				Particle p = swarm.get(i);
				
		
				
				double[] newVel = new double[PROBLEM_DIMENSION];
				newVel[0] = (w * p.getVelocity().getPos()[0]) + 
						(r1 * C1) * (pBestLocation.get(i).getLoc()[0] - p.getLocation().getLoc()[0]) +
						(r2 * C2) * (gBestLocation.getLoc()[0] - p.getLocation().getLoc()[0]);
			newVel[1] = (w * p.getVelocity().getPos()[1]) + 
						(r1 * C1) * (pBestLocation.get(i).getLoc()[1] - p.getLocation().getLoc()[1]) +
						(r2 * C2) * (gBestLocation.getLoc()[1] - p.getLocation().getLoc()[1]);
			Velocity vel = new Velocity(newVel);
								
				
			
			
			double[] newLoc = new double[PROBLEM_DIMENSION];
			newLoc[0] = p.getLocation().getLoc()[0] + newVel[0];
			newLoc[1] = p.getLocation().getLoc()[1] + newVel[1];
			Location loc = new Location(newLoc);
			
			
			p.setLocation(loc);

			
			
		
//				if (i == 0)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//
//				if (i == 1)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 2)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//
//				if (i == 3)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 4)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 5)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 6)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 7)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 8)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				if (i == 9)
//				{
//					//double x = p.getLocation().getLoc()[0];
//					//double y = p.getLocation().getLoc()[1];
//					int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//					int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//					int distance= (int) Math.sqrt(x + y);
//					System.out.print(distance+"\t");
//					
//				}
//				
				
			
			
			
//			if (i == 0)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow((p.getLocation().getLoc()[0]), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1]), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//
//			if (i == 1)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 2)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//
//			if (i == 3)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 4)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 5)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 6)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 7)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 8)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			if (i == 9)
//			{
//				//double x = p.getLocation().getLoc()[0];
//				//double y = p.getLocation().getLoc()[1];
//				int x = (int) Math.pow(((p.getLocation().getLoc()[0])-h.getHubX()), 2);
//				int y = (int) Math.pow((p.getLocation().getLoc()[1])-h.getHubY(), 2);
//				int distance= (int) Math.sqrt(x + y);
//				System.out.print(distance+"\t");
//				
//			}
//			
//			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
			
	
			
			
		    System.out.println("ITERATION " + t + ": ");
			System.out.println("     Best X: " + gBestLocation.getLoc()[0]);
			System.out.println("     Best Y: " + gBestLocation.getLoc()[1]);
			System.out.println("Best Server Chosen:"+swarm.get(bestParticleIndex).getServer().getServerID());
			System.out.println("     Value: " + ProblemSet.evaluate(h,gBestLocation,swarm.get(bestParticleIndex).getServer()));
			
			t++;
			updateFitnessList(h,swarm);
			lastBest = bestParticleIndex;
			System.out.print(k+"\t");
			k = k + 1;
			System.out.println();
		}
		
	   System.out.println("\nSolution found at iteration " + (t - 1) + ", the solutions is:");
		System.out.println("     Best X: " + gBestLocation.getLoc()[0]);
		System.out.println("     Best Y: " + gBestLocation.getLoc()[1]);
		System.out.println("Best Server Chosen:"+swarm.get(lastBest).getServer().getServerID());
	
	}
	
	public void initializeSwarm() {
		Particle p;
		
		int k = 500;
		double[] serverLocation= new double[PROBLEM_DIMENSION];
		serverLocation[0] =  h.getHubX();
		serverLocation[1] = h.getHubY();
		
		Location hubLocation=new Location(serverLocation);
		for(int i=0; i<SWARM_SIZE; i++) {
			p = new Particle();
			Server s = new Server();
			s.setServerID(i);
			s.setServerOffering(k);
			 k = k + 100; 
			// randomize location inside a space defined in Problem Set
			double[] loc = new double[PROBLEM_DIMENSION];
			loc[0] = ProblemSet.LOC_X_LOW + generator.nextDouble() * (ProblemSet.LOC_X_HIGH - ProblemSet.LOC_X_LOW);
			loc[1] = ProblemSet.LOC_Y_LOW + generator.nextDouble() * (ProblemSet.LOC_Y_HIGH - ProblemSet.LOC_Y_LOW);
			s.setServerX((int) loc[0]);
			s.setServerY((int) loc[1]);
			
			Location location = new Location(loc);
			
		
			
			// randomize velocity in the range defined in Problem Set
			double[] vel = new double[PROBLEM_DIMENSION];
			vel[0] = ProblemSet.VEL_LOW + generator.nextDouble() * (ProblemSet.VEL_HIGH - ProblemSet.VEL_LOW);
			vel[1] = ProblemSet.VEL_LOW + generator.nextDouble() * (ProblemSet.VEL_HIGH - ProblemSet.VEL_LOW);
			Velocity velocity = new Velocity(vel);
			
			p.setServer(s);
			p.setLocation(hubLocation);
			p.setVelocity(velocity);
			System.out.println("SERVER id:"+s.getServerID() +"     "+"SERVER offering:"+s.getServerOffering()+
					            "       "+"Server Distance from hub:"+getDistance(p.getServer().getServerX(),p.getServer()
					            		.getServerY())
					            		 );
			swarm.add(p);
		}
	}
	
	public void updateFitnessList(Hub hub,ArrayList<Particle> ser) {
		for(int i=0; i<SWARM_SIZE; i++) {
			fitnessValueList[i] = swarm.get(i).getFitnessValue(hub,ser.get(i).getLocation(),ser.get(i).getServer());
		}
	}
	
	public int getDistance(int x1,int y1)
	{
		int x = (int) Math.pow((h.getHubX()-x1), 2);
		int y = (int) Math.pow((h.getHubY()-y1), 2);
		int distance= (int) Math.sqrt(x + y);
		return distance;
	}
}