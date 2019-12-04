package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class StealthCruiser extends Fighter{
	
	private static int numOfStealthCruisers = 0;
	private static final int COST_PER_ENGINE = 50;
	
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numOfStealthCruisers++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, createLaserCannon());
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return numOfStealthCruisers * COST_PER_ENGINE + super.getAnnualMaintenanceCost();
	}

	private static ArrayList<Weapon> createLaserCannon(){
		ArrayList<Weapon> res = new ArrayList<Weapon>();
		res.add(new Weapon("Laser Cannons",10,100));
		return res;
	}
	
	public String toString() {
		return super.toString("StealthCruiser");
	}
}
