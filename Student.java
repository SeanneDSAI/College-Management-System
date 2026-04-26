
public class Student extends Person{
	
	private Course studentCourse;
	private double scoreAverage;
	private String courseGrade;
	private boolean isCurrent;
	
	public Student() {
		
	}	

	public Student(int personID, String firstName, String lastName, int age, String address, boolean isCurrent, String type) {
		super(personID, firstName, lastName, age, address, type);
		this.isCurrent = isCurrent;
	}
	
	public Student(int personID, String firstName, String lastName, int age, String address, Course studentCourse,
			double scoreAverage, String courseGrade, boolean isCurrent, String type) {
		super(personID, firstName, lastName, age, address, type);
		this.studentCourse = studentCourse;
		this.scoreAverage = scoreAverage;
		this.courseGrade = courseGrade;
		this.isCurrent = isCurrent;
	}

	public Course getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Course studentCourse) {
		this.studentCourse = studentCourse;
	}

	public double getScoreAverage() {
		return scoreAverage;
	}

	public void setScoreAverage(double scoreAverage) {
		this.scoreAverage = scoreAverage;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
}
