package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class AbstractSpaceShip implements Spaceship{
	
	public static final int BASE_FIRE_POWER = 10;
	
	private String name;
	private int commissionYear;
	private float maximalSpeed;
	private Set<? extends CrewMember> crewMembers;
	private int annualMaintenanceCost;
	
	public AbstractSpaceShip(String name, int commissionYear, float maximalSpeed,
			Set<? extends CrewMember> crewMembers, int annualMaintenanceCost) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
		this.annualMaintenanceCost = annualMaintenanceCost;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCommissionYear() {
		return commissionYear;
	}
	
	public float getMaximalSpeed() {
		return maximalSpeed;
	}
	
	public int getFirePower() {
		return BASE_FIRE_POWER;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceShip other = (AbstractSpaceShip) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}

	public Set<? extends CrewMember> getCrewMembers(){
		return crewMembers;
	}
	
	public int getAnnualMaintenanceCost() {
		return annualMaintenanceCost;
	}
	
	
	public static String ln = System.lineSeparator();
	public static String lnt = ln + "\t";
	
	public String toString(String className) {
		String res = className + lnt + "Name=" + name + lnt + "CommissionYear=" +
				commissionYear + lnt + "MaximalSpeed=" + maximalSpeed + lnt + 
				"FirePower=" + getFirePower() + lnt + "CrewMembers=" +
				getCrewMembers().size() + lnt + "AnnualMaintenanceCost=" +
				getAnnualMaintenanceCost();
		return res;
	}

}
