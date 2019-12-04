package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class BattleShip extends AbstractSpaceShip{

	private List<Weapon> weapons;
	
	BattleShip(String name, int commissionYear, float maximalSpeed,
			Set<? extends CrewMember> crewMembers, List<Weapon> weapons,
			int basiclMaintenanceCost){
		super(name, commissionYear, maximalSpeed, crewMembers, basiclMaintenanceCost);
		this.weapons = weapons;
	}
	
	public List<Weapon> getWeapon(){
		return weapons;
	}
	
	@Override
	public int getFirePower() {
		int weaponPower = 0;
		for(Weapon weapon : weapons) {
			weaponPower += weapon.getFirePower();
		}
		return super.getFirePower() + weaponPower;
	}


	public int getAnnualweaponsMaintenanceCost() {
		int res = 0;
		for(Weapon weapon : weapons) {
			res += weapon.getAnnualMaintenanceCost();
		}
		return res;
	}
	
	public String weaponsToString() {
		String res = "";
		if (weapons == null || weapons.size() == 0) return res;
		res += "[Weapon [name=" + weapons.get(0).getName() + ", firePower="
				+ weapons.get(0).getFirePower() + ", annualMaintenanceCost=" +
				weapons.get(0).getAnnualMaintenanceCost() + "]";
		for(Weapon weapon : weapons) {
			if(weapon == weapons.get(0)) continue;
			res += ", Weapon [name=" + weapon.getName() + ", firePower="
					+ weapon.getFirePower() + ", annualMaintenanceCost=" +
					weapon.getAnnualMaintenanceCost() + "]";
		}
		res += "]";
		return res;
	}
	
	@Override
	public String toString(String className) {
		return super.toString(className) + lnt + "WeaponArray=" + weaponsToString();
	}
	
	public Set<String> getWeaponsNames(){
		Set<String> names = new HashSet<>();
		for(Weapon weapon : weapons) {
			names.add(weapon.getName());
		}
		return names;
	}
}
