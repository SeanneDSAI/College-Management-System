
public class Employee extends Person{
	
	private String jobTitle;
	private double salary;
	private boolean isCurrentEmployee;
	
	public Employee() {
		
	}

	public Employee(int personID, String firstName, String lastName, int age, String address, String jobTitle,
			double salary, boolean isCurrentEmployee, String type) {
		super(personID, firstName, lastName, age, address,type);
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.isCurrentEmployee = isCurrentEmployee;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isCurrentEmployee() {
		return isCurrentEmployee;
	}

	public void setCurrentEmployee(boolean isCurrentEmployee) {
		this.isCurrentEmployee = isCurrentEmployee;
	}
	
	
	

}
