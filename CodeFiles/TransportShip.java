package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceShip{

	private static final int  BASE_ANNUAL_COST_TRANSPORT = 3000;
	
	private int cargoCapacity;
	private int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers, BASE_ANNUAL_COST_TRANSPORT);
		this.passengerCapacity = passengerCapacity;
		this.cargoCapacity = cargoCapacity;
	}
	
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + 5 * cargoCapacity + 3 * passengerCapacity;
	}
	
	public String toString() {
		return super.toString("TransportShip") + lnt + "CargoCapacity=" + 
				cargoCapacity + lnt + "PassengerCapacity=" + passengerCapacity;
	}

}
