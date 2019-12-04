package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class ShipComparator implements Comparator<AbstractSpaceShip>{

	public int compare(AbstractSpaceShip self, AbstractSpaceShip otr) {
		if(self.getFirePower() != otr.getFirePower()) {
			return otr.getFirePower() - self.getFirePower();
		}
		if(self.getCommissionYear() != otr.getCommissionYear()) {
			return otr.getCommissionYear() - self.getCommissionYear();
		}
		return self.getName().compareTo(otr.getName());
	}
}
