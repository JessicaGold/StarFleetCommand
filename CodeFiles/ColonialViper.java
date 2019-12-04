package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {
	
	private static final int BASE_ANNUAL_COST_COLONIAL = 4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons, BASE_ANNUAL_COST_COLONIAL);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return 500 * getCrewMembers().size() + super.getAnnualMaintenanceCost(500);
	}
	
	public String toString() {
		return super.toString("ColonialViper");
	}

}
