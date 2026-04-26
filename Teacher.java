import java.util.ArrayList;

public class Teacher extends Employee{
	
	private ArrayList<Module> subjectsTaught = new ArrayList<Module>();
	private boolean isCourseCoordinator;
	
	public Teacher() {
		
	}

	
	
	public Teacher(int personID, String firstName, String lastName, int age, String address, String jobTitle,
			double salary, boolean isCurrentEmployee, String type,	boolean isCourseCoordinator) {
		super(personID, firstName, lastName, age, address, jobTitle, salary, isCurrentEmployee, type);
	
		this.isCourseCoordinator = isCourseCoordinator;
	}



	



	public void addModule(Module m) {
		subjectsTaught.add(m);
	}
	public void removeModule(Module m) {
		subjectsTaught.remove(m);
	}

	public ArrayList<Module> getSubjectsTaught() {
		return subjectsTaught;
	}

	public void setSubjectsTaught(ArrayList<Module> subjectsTaught) {
		this.subjectsTaught = subjectsTaught;
	}

	public boolean isCourseCoordinator() {
		return isCourseCoordinator;
	}

	public void setCourseCoordinator(boolean isCourseCoordinator) {
		this.isCourseCoordinator = isCourseCoordinator;
	}
	
	
	
}
