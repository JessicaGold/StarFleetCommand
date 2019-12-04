package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{

	private static final int BASE_ANNUAL_COST_CYLONR = 3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons, BASE_ANNUAL_COST_CYLONR);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 500 * getCrewMembers().size() + super.getAnnualMaintenanceCost(1200);
	}
	
	public String toString() {
		return super.toString("CylonRaider");
	}

}
