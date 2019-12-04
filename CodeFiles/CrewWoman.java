package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman implements CrewMember {

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
		CrewWoman other = (CrewWoman) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}

	private String name;
	private int age;
	private int yearsInService;
	
	public CrewWoman(int age, int yearsInService, String name){
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getYearsInService() {
		return yearsInService;
	}
	
	public static String ln = System.lineSeparator();
	public static String lnt = ln + "\t";
	
	public String toString(String className) {
		String res = className + lnt + "Name=" + name + lnt + "Age=" +
				age + lnt + "YearsInService=" + yearsInService;
		return res;
	}
	
	public String toString() {
		return this.toString("CrewWoman");
	}

}
