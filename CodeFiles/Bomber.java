package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends BattleShip {
	
	private static final int BASE_ANUAML_COST_BOMBER = 5000;
	
	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons, BASE_ANUAML_COST_BOMBER);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int weaponMaintenance = getAnnualweaponsMaintenanceCost();
		weaponMaintenance = Math.round(((float)weaponMaintenance - 
				((float)numberOfTechnicians)*(float)0.1*((float)weaponMaintenance)));
		return super.getAnnualMaintenanceCost() +  weaponMaintenance;
	}
	
	public String toString() {
		return super.toString("Bomber") + lnt + "NumberOfTechnicians=" + 
				numberOfTechnicians;
	}
	
}
