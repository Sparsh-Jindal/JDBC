package studentReport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
	private static Scanner sc = new Scanner(System.in);

	public static Student addDetails(Student s) {
		System.out.println();
		System.out.println("Enter the Roll Number:");
		int rollNumber = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the name:");
		String name = sc.nextLine();
		System.out.println("Enter the age:");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the course:");
		String course = sc.nextLine();
		System.out.println("Enter the marks:");
		Double marks = Double.parseDouble(sc.nextLine());
		System.out.println();

		s = new Student(rollNumber, name, age, course, marks);

		return s;
	}

	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		Student s = new Student();
		StudentReportManagement srm = new StudentReportManagement();

		int choice = 0;

		do {
			System.out.println("------ STUDENT REPORT MENU ------\n");
			System.out.println("1.Insert into the table");
			System.out.println("2.View Table");
			System.out.println("3.Delete specific student details");
			System.out.println("4.Update marks of specific student");
			System.out.println("5.Exit");
			System.out.print("Enter your choice:");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {

			case 1:
				s = addDetails(s);
				boolean ifAdded = srm.addStudent(s);
				if (ifAdded) {
					System.out.println("Data inserted successfully");
				} else {
					System.out.println("Data was not inserted successfully");
				}
				break;

			case 2:
				srm.viewStudent();
				System.out.println();
				break;

			case 3:
				if (srm.ifEmpty()) {
					System.out.println("\nTable is Empty.\n");
				} else {
					System.out.println("Enter the roll number of the student");
					int rollNumber = Integer.parseInt(sc.nextLine());
					if (srm.deleteSpecific(rollNumber)) {
						System.out.println("Succesfullly Deleted " + rollNumber + "'s details");
					} else {
						System.out.println("Unseccessful");
					}

				}

				break;

			case 4:
				if (srm.ifEmpty()) {
					System.out.println("\nTable is Empty.\n");
				} else {
					System.out.println("Enter the roll number of the student");
					int rollNumber = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the updated marks");
					Double marks = Double.parseDouble(sc.nextLine());
					if (srm.updateMarks(rollNumber, marks)) {
						System.out.println("Marks of " + rollNumber + " student updated successfully");
					} else {
						System.out.println("Unseccessful in Updating");
					}
				}
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Choice");

			}

		} while (choice != 5);

	}

}
