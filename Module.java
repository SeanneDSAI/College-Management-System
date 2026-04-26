import java.util.ArrayList;

public class Module {

	private int moduleID;
	private String moduleName;
	private ArrayList<Student> moduleStudents = new ArrayList<Student>();
	
	public Module() {
		
	}

	public Module(int moduleID, String moduleName) {
		this.moduleID = moduleID;
		this.moduleName = moduleName; 
	}
	
	public Module(int moduleID, String moduleName, ArrayList<Student> moduleStudents) {
		this.moduleID = moduleID;
		this.moduleName = moduleName;
		this.moduleStudents = moduleStudents;
	}

	public void addStudent(Student s) {
		moduleStudents.add(s);
	}
	public void removeStudent(Student s) {
		moduleStudents.remove(s);
	}
	
	public int getModuleID() {
		return moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public ArrayList<Student> getModuleStudents() {
		return moduleStudents;
	}

	public void setModuleStudents(ArrayList<Student> moduleStudents) {
		this.moduleStudents = moduleStudents;
	}
	
	
	 
}
