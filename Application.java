import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Scanner input = new Scanner(System.in);
	static ArrayList<Person> everyOne = new ArrayList<Person>();
	static ArrayList<Module> allModules = new ArrayList<Module>();
	static ArrayList<Course> allCourses = new ArrayList<Course>();
	static int centralID = 1007;

	public static void main(String[] args) {
		prePopulate();
		mainMenu();
	}

	private static void mainMenu() {
		System.out.println("Press 1 for Student Menu");
		System.out.println("Press 2 for Employee Menu");
		System.out.println("Press 3 for Admin Menu");
		System.out.println("Press 4 to Print Everyone");
		
		String choice = input.next();
		
		switch(choice) {
			case "1":{
				studentMenu();
				break;
			}
			
			case "2":{
				employeeMenu();
				break;
			}
			
			case "3":{
				adminMenu();
				break;
			}
			
			case "4":{
				printEveryone();
				break;
			}
			
			case "5":{
				printPeople();
				break;
			}
			
			default:{
				System.out.println("Invalid Choice. Try Again");
			}
		}
		
		mainMenu();
	}

	private static void adminMenu() {
		
	}

	private static void employeeMenu() {
		System.out.println("Press 1 to create Employee");
		System.out.println("Press 2 to Edit Employee");
		System.out.println("Press 3 to Find Employee");
		System.out.println("Press 4 to Delete Employee");
		System.out.println("Press 5 to Print all Employees");
		System.out.println("Press 6 to Print Teachers");
		System.out.println("Press m to return to main menu");
		
		String choice = input.next();
		
		switch(choice) {
			case "1":{
				try {
					createEmployee();
				} catch (Exception e) {
					System.out.println();
				}
				break;
			}
			
			case "2":{
				editEmployee();
				break;
			}
			
			case "3":{
				findEmployee();
				break;
			}
			
			case "4":{
				deleteEmployee();
				break;
			}
			
			case "5":{
				printEmployees();
				break;
			}
			
			case "6":{
				printTeachers();
				break;
			}
			
			case "m":{
				mainMenu();
				break;
			}
			default:{
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
	private static void createEmployee() throws Exception {
		System.out.println("Press 1 to create New Employee");
		System.out.println("Press 2 to create New Teacher");
		
		String choice = input.next();
		
		switch(choice) {
			case "1":{
				Employee e = new Employee();
				e.setPersonID(centralID);
				centralID++;
				
				System.out.println("Enter First Name");
				e.setFirstName(reader.readLine());
				
				System.out.println("Enter Last Name");
				e.setLastName(reader.readLine());
				
				System.out.println("Enter age");
				e.setAge(input.nextInt());
				
				System.out.println("Enter job title");
				e.setJobTitle(reader.readLine());
				
				System.out.println("Enter salary");
				e.setSalary(input.nextDouble());
				
				e.setCurrentEmployee(true);
				everyOne.add(e);
			}
			
			case "2":{
				Teacher t = new Teacher();
				t.setPersonID(centralID);
				centralID++;
				
				System.out.println("Enter First Name");
				t.setFirstName(reader.readLine());
				
				System.out.println("Enter Last Name");
				t.setLastName(reader.readLine());
				
				System.out.println("Enter age");
				t.setAge(input.nextInt());
				
				System.out.println("Enter job title");
				t.setJobTitle(reader.readLine());
				
				System.out.println("Enter salary");
				t.setSalary(input.nextDouble());
				
				t.setCurrentEmployee(true);
				t.setCourseCoordinator(true);
				everyOne.add(t);
				break;
			}
		}
	}
	
	private static void editEmployee() {
		Employee toEdit = findEmployee();
		
		System.out.println("press 1 to edit first name");
		System.out.println("Press 2 to edit last name");
		System.out.println("Press 3 to edit age");
		System.out.println("Press 4 to change job title");
		System.out.println("Press 5 to change salary");
		
		String choice = input.next();
		
		switch (choice) {
			case "1":{
				System.out.println("Enter new first name to replace " + toEdit.getFirstName());
				toEdit.setFirstName(input.next());
					break;
			}
			
			case "2":{
				System.out.println("Enter new last name to replace " + toEdit.getLastName());
				toEdit.setLastName(input.next());
					break;
			}
			
			case "3":{
				System.out.println("Enter new age to replace " + toEdit.getAge());
				toEdit.setAge(input.nextInt());
					break;
			}
			
			case "4": {
				System.out.println("Enter a new job title to replace" + toEdit.getJobTitle());
				toEdit.setJobTitle(input.next());
				break;
			}
			
			case "5":{
				System.out.println("Enter new salary to replace " + toEdit.getSalary());
				toEdit.setSalary(input.nextDouble());
				break;
			}
			
			default:{
				System.out.println("invalid choice");
				break;
			}
		}
	}
	
	private static Employee findEmployee() {
		printEmployees();
		System.out.println("Enter Id of Employee");
		
		int chosenID = input.nextInt();
		boolean isFound = false;
		
		Employee foundEmployee = null;
		
		for (Person p: everyOne) {
			if (Employee.class.equals(p.getClass())) {
				if (chosenID == p.getPersonID()) {
					foundEmployee = (Employee) p;
					isFound = true;
				}	
			}
		}
		
		if (isFound == false) {
			System.out.println("No ID found. Try again.");
			findEmployee();
		}
		
		return foundEmployee;
	}
	
	
	private static void deleteEmployee() {
		everyOne.remove(findEmployee());
		System.out.println(findEmployee().getFirstName() + " has been removed "); 
	}
	
	private static void printEmployees() {
		for (Person p: everyOne) {
			if (Employee.class.equals(p.getClass())) {
				Employee e = (Employee) p;
				System.out.println(e.getPersonID());
				System.out.println("\t" + e.getFirstName() + " " + e.getLastName());
				System.out.println("\t" + e.getJobTitle());
				System.out.println("\t" + e.getSalary());
			}
		}
		
	}

	private static void printTeachers() {
		for (Person p: everyOne) {
			if(Teacher.class.equals(p.getClass())) {
				Teacher t = (Teacher) p;
				System.out.print(t.getPersonID());
				System.out.print("\t" + t.getFirstName() + " " + t.getLastName());
				System.out.println("\t" + t.getJobTitle());
				
				if(t.isCourseCoordinator()) {
					System.out.println("\t Course Coordinator");
				}
				
				System.out.println("\t" + t.getSalary());
			}
		}
	}

	private static void studentMenu() {
		System.out.println("Press 1 to create Student");
		System.out.println("Press 2 to Edit Student");
		System.out.println("Press 3 to Delete Student");
		System.out.println("Press 4 to Print Students");
		System.out.println("Press 5 to Print Students by Course");
		System.out.println("Press m to return to main menu");
		
		String choice = input.next();
		
		switch(choice) {
			case "1":{
				try {
					createStudent();
				} catch (Exception e) {
					System.out.println("An error was logged creating a student.");
				}
				break;
			}
			
			case "2":{
				editStudent();
				break;
			}
			
			case "3":{
				deleteStudent();
				break;
			}
			
			case "4":{
				printStudents();
				break;
			}
			
			case "5":{
				printStudentByCourse();
				break;
			}
			
			default:{
				System.out.println("Invalid Choice. Try Again");
			}
		}
		
		mainMenu();
		
	}
	
	private static void createStudent() throws Exception{
		Student s = new Student();
		s.setPersonID(centralID);
		centralID++;
		
		System.out.println("Enter student first name");
		s.setFirstName(reader.readLine());
		System.out.println("Enter student last name");
		s.setLastName(reader.readLine());
		System.out.println("Enter student age");
		s.setAge(input.nextInt());
		System.out.println("Enter address");
		s.setAddress(reader.readLine());
		s.setCurrent(true);
		s.setType("Student");
		
		Course chosenCourse = findCourse();
		s.setStudentCourse(chosenCourse);
		chosenCourse.addStudent(s);
		everyOne.add(s);
	}
	
	private static void editStudent() {
		Student toEdit = findStudent();
		
		System.out.println("press 1 to edit first name");
		System.out.println("Press 2 to edit last name");
		System.out.println("Press 3 to edit age");
		System.out.println("Press 4 to change course");
		
		String choice = input.next();
		
		switch (choice) {
			case "1":{
				System.out.println("Enter new first name to replace " + toEdit.getFirstName());
				toEdit.setFirstName(input.next());
					break;
			}
			
			case "2":{
				System.out.println("Enter new last name to replace " + toEdit.getLastName());
				toEdit.setLastName(input.next());
					break;
			}
			
			case "3":{
				System.out.println("Enter new age to replace " + toEdit.getAge());
				toEdit.setAge(input.nextInt());
					break;
			}
			
			case "4": {
				System.out.println("Enter a new course by ID number to replace it to replace " + toEdit.getStudentCourse().getCourseName());
				Course newCourse = findCourse();
				toEdit.getStudentCourse().removeStudent(toEdit);
				newCourse.addStudent(toEdit);
				toEdit.setStudentCourse(newCourse);
				System.out.println("New Course is " + newCourse.getCourseName());
				break;
			}
		}
	}
	
	private static void deleteStudent() {
		Student toRemove = findStudent();
		toRemove.getStudentCourse().removeStudent(toRemove);
		everyOne.remove(toRemove);	
	}
	
	private static Student findStudent() {
		printStudents();
		System.out.println("Enter student id");
		int chosenStudentID = input.nextInt();
		boolean isFound = false;
		Student foundStudent = null;
		
		for (Person p: everyOne) {
			if (chosenStudentID == p.getPersonID()) {
				isFound = true;
				foundStudent = (Student)p; //cast back to Student
			}
			
		}
		
		if (isFound == false) {
			System.out.println("No ID found. Try again.");
			findStudent();
		}
		
		return foundStudent;
	}

	private static void printStudentByCourse() {
		
		Course chosenCourse = findCourse();
		System.out.println(chosenCourse.getCourseName());
		
		for (Student s: chosenCourse.getEnrolledStudents()) {
			System.out.println(s.getFirstName() + " " + s.getLastName());
		}
	}

	private static Course findCourse() {
		Course chosenCourse = null;
		boolean isFound = false;
		viewCourses();
		System.out.println("Please enter course by id number");
		int chosenCourseID = input.nextInt();
		
		for(Course c: allCourses) {
			if(c.getCourseID() == chosenCourseID) {
				chosenCourse = c;
				isFound = true;
			}
		}
		
		if(isFound == false) { 
			System.out.println("No course with that id found, try again.");
				findCourse();
		}
		
		return chosenCourse;
	}

	private static void viewCourses() {
			for(Course c: allCourses){
				System.out.println(c.getCourseID() + "\t" + c.getCourseName());
			}
	}
	
	private static void printStudents() {
		System.out.println("*****************************************");
		for (Person p: everyOne) {
			if (p.getType().equals("Student")) {
				System.out.print(p.getPersonID());
				System.out.print("\t" + p.getFirstName() + " " + p.getLastName());
				System.out.print("\t" + p.getAge());
				System.out.print("\t" + p.getAddress());
				Student s = (Student) p; 
				System.out.println("\t" + s.getStudentCourse().getCourseName());
				
				if(s.isCurrent()) {
					System.out.println("\t - Current Student.");
				}
				
				else {
					System.out.println("\t - Past Student.");
				}
			}
		}
		System.out.println("*****************************************");
	}

	private static void printEveryone() {
		for (Person p: everyOne) {
			System.out.println(p.getPersonID());
			System.out.println(p.getFirstName() + " " + p.getLastName());
			System.out.println(p.getAge());
			System.out.println(p.getAddress());
			
			if (Student.class.equals(p.getClass())) {
				Student s = (Student) p; //Cast Person as Student
				System.out.println(s.getStudentCourse().getCourseName());
			}
			
			else if (Employee.class.equals(p.getClass())) {
				Employee e = (Employee) p; //Cast as Employee
				System.out.println(e.getJobTitle());
				System.out.println(e.getSalary());
			}
			
			else {
				Teacher t = (Teacher) p; //Cast as Teacher 
				System.out.println("Subjects Taught");
				
				for (Module m: t.getSubjectsTaught()) {
					System.out.println(m.getModuleName());
				}
			}
		}
		
	}

	private static void printPeople() {
		for(Person p: everyOne) {
			System.out.println("---------------------------------------------");
			System.out.println("ID: \t" + p.getPersonID());
			System.out.println("Name: \t " + p.getFirstName() + " " + p.getLastName());
			System.out.println("Age: \t" + p.getAge());
			System.out.println("Address: " + p.getAddress());
			System.out.println("Type: " + p.getClass());
			System.out.println("---------------------------------------------");
		}
	}

	private static void prePopulate() {
		
		Module programming = new Module(10, "Programming");
		Module softwareArch = new Module(11, "Software Architecture");
		Module webDesign = new Module(12,"Web Design");
		Module contractLaw = new Module(13,"Contract Law");
		Module criminalLaw = new Module(14, "Criminal Law");
		Module familyLaw = new Module(15, "Family Law");
		
		Course computerScience = new Course(101, "Computer Science");
			computerScience.addModule(programming);
			computerScience.addModule(softwareArch);
			computerScience.addModule(webDesign);
			
		Course law = new Course(102,"Pre University Law");
			law.addModule(contractLaw);
			law.addModule(criminalLaw);
			law.addModule(familyLaw);
			
		Student sam = new Student(1001,"Sam", "Jones", 18, "11 the Avenue", true, "Student");
			computerScience.addStudent(sam);
			sam.setStudentCourse(computerScience);
		Student mary = new Student(1002,"Mary", "Adams", 20, "51 The Park", true, "Student"); 
			computerScience.addStudent(mary);
			mary.setStudentCourse(computerScience);
		Student jim = new Student(1003, "Jim", "Jones", 18, "11 The Avenue", true, "Student");
			law.addStudent(jim);
			jim.setStudentCourse(law);
		Student joan = new Student(1004, "Joan", "Byrne", 21, "55 The Road", true, "Student");
			law.addStudent(joan);
			joan.setStudentCourse(law);
			
			
		Employee eddie = new Employee(1002, "Eddie", "Smith", 25, "21 The Crescent", "Caretaker", 25000, true, "Employee");
		Teacher tanya = new Teacher(1003, "Tanya", "Bloggs", 30, "A House", "Teacher", 40000, true, "Teacher", false);
			tanya.addModule(familyLaw);
			tanya.addModule(criminalLaw);
		
		everyOne.add(sam);
		everyOne.add(mary);
		everyOne.add(jim);
		everyOne.add(joan);
		everyOne.add(eddie);
		everyOne.add(tanya);
		
		allModules.add(programming);
		allModules.add(softwareArch);
		allModules.add(webDesign);
		allModules.add(contractLaw);
		allModules.add(criminalLaw);
		allModules.add(familyLaw);

		allCourses.add(computerScience);
		allCourses.add(law);
}
	
}
