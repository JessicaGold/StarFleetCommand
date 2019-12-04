package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		
		List<AbstractSpaceShip> ships = new ArrayList<>();
		for(Spaceship ship : fleet) {
			ships.add((AbstractSpaceShip)ship);
		}
		ships.sort(new ShipComparator());
		List<String> reps = new ArrayList<String>();
		for(AbstractSpaceShip ship : ships) {
			reps.add(ship.toString());
		}
		return reps;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		
		Map<String, Integer> instances = new HashMap<String, Integer>();
		String name;
		for(Spaceship ship : fleet) {
			name = ship.getClass().getSimpleName();
			if(!instances.containsKey(name)) {
				instances.put(name, 1);
			}
			else {
				instances.replace(name, instances.get(name) + 1);
			}
		}
		return instances;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int res = 0;
		for(Spaceship ship : fleet) {
			res += ship.getAnnualMaintenanceCost();
		}
		return res;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<>();
		for(Spaceship ship : fleet) {
			if(ship.getClass().getSimpleName().equals("TransportShip")) continue;
			for(String name : ((BattleShip)ship).getWeaponsNames()) {
				weaponNames.add(name);
			}
		}
		return weaponNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int members = 0;
		for(Spaceship ship : fleet) {
			members += ship.getCrewMembers().size();
		}
		return members;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		if(fleet.size() == 0) return 0;
		float sum = 0f;
		int personal = 0;
		Officer ofcr = new Officer("Name", 0, 0, OfficerRank.Admiral);
		for(Spaceship ship : fleet) {
			if(ship.getCrewMembers().size() == 0) continue;
			for(CrewMember member : ship.getCrewMembers()) {
				if(member.getClass() != ofcr.getClass()) continue;
				sum += member.getAge();
				personal++;
			}
		}
		return sum/personal;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		List<Officer> officersOnShip = new ArrayList<>();
		Officer ofcr = new Officer("Name", 0, 0, OfficerRank.Admiral);
		Map<Officer, Spaceship> res = new HashMap<>();
		for(Spaceship ship : fleet) {
			for(CrewMember member : ship.getCrewMembers()) {
				if(member.getClass() != ofcr.getClass()) continue;
				officersOnShip.add((Officer)member);
			}
			if(officersOnShip.size() == 0) continue;
			ofcr = officersOnShip.get(0);
			for(Officer officer : officersOnShip) {
				if(officer.getRank().compareTo(ofcr.getRank()) > 0) {
					ofcr = officer;
				}
			}
			res.put(ofcr, ship);
			officersOnShip.clear();
		}
		
		return res;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankMap = new HashMap<>();
		Officer ofcr = new Officer("Name", 0, 0, OfficerRank.Admiral);
		OfficerRank curRank;
		for(Spaceship ship : fleet) {
			for(CrewMember officer : ship.getCrewMembers()) {
				if(officer.getClass() != ofcr.getClass()) continue;
				curRank = ((Officer)officer).getRank();
				if(!rankMap.containsKey(curRank)) {
				rankMap.put(curRank, 1);
				}
				else {
					rankMap.replace(curRank, rankMap.get(curRank) + 1);
				}
			}
		}
		Set<Map.Entry<OfficerRank, Integer>> rankSet = rankMap.entrySet();
		List<Map.Entry<OfficerRank, Integer>> rankList = new ArrayList<>();
		for(Map.Entry<OfficerRank, Integer> entry : rankSet) {
			rankList.add(entry);
		}
		rankList.sort(new RankPopularityComparator());
		
		return rankList;
	}
	
	public static class RankPopularityComparator implements Comparator<Map.Entry<OfficerRank, Integer>>{
		public int compare(Map.Entry<OfficerRank, Integer> self, Map.Entry<OfficerRank, Integer> otr) {
			int res = self.getValue().compareTo(otr.getValue()) != 0 ? 
					self.getValue().compareTo(otr.getValue()) : 
						self.getKey().compareTo(otr.getKey());
			return res;
		}
	}

}
