package studentReport;

public class Student {

	private int rollNumber;
	private String name;
	private int age;
	private String course;
	private double marks;

	public Student(int rollNumber, String name, int age, String course, double marks) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.course = course;
		this.marks = marks;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}
