package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends BattleShip{
	
	private static final int BASE_ANNUAL_COST_FIGHTER = 2500;
	
	
	public Fighter(String name, int commissionYear, float maximalSpeed,
			Set<? extends CrewMember> crewMembers, List<Weapon> weapons, int basiclMaintenanceCost) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons, basiclMaintenanceCost);

	}
	
	public Fighter(String name, int commissionYear, float maximalSpeed,
			Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		this(name, commissionYear, maximalSpeed, crewMembers, weapons, BASE_ANNUAL_COST_FIGHTER);
	}


	public int getAnnualMaintenanceCost(int multeplier) {
		int engineCost = Math.round(multeplier * super.getMaximalSpeed());
		return super.getAnnualMaintenanceCost() + getAnnualweaponsMaintenanceCost() + engineCost;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return getAnnualMaintenanceCost(1000);
	}
	
	public String toString() {
		return super.toString("Fighter");
	}
	
}
