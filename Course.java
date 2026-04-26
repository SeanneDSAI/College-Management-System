import java.util.ArrayList;

public class Course {

	private int courseID;
	private String courseName;
	private ArrayList<Module> courseModules = new ArrayList<Module>();
	private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
	
	public Course() {
		
	}
	public Course(int courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}

	public Course(int courseID, String courseName, ArrayList<Module> courseModules) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseModules = courseModules;
	}
	public void removeStudent(Student s) {
		enrolledStudents.remove(s);
		
		for(Module m: courseModules) {
			m.removeStudent(s);
		}
		System.out.println(s.getFirstName() + " " + s.getLastName() + 
				" has been removed from the " + courseName + " course.");
	}
	
	public void addStudent(Student s) {
		enrolledStudents.add(s);
		
		for(Module m: courseModules) {
			m.addStudent(s);
		}
		System.out.println(s.getFirstName() + " " + s.getLastName() + 
				" has been enrolled on the " + courseName + " course.");
	}
	public ArrayList<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	public void addModule(Module m) {
		courseModules.add(m);
	}
	
	public void removeModule(Module m) {
		courseModules.remove(m);
	}
	

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public ArrayList<Module> getCourseModules() {
		return courseModules;
	}

	public void setCourseModules(ArrayList<Module> courseModules) {
		this.courseModules = courseModules;
	}
	
	
}
