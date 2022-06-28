package solution.weekthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HomeworkThree {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Priorities priorities = new Priorities();
		
		// The Hackerrank part of the Solution
		
		System.out.println("Please write the test cases (with inputs) at the console!!!\n"
				+ "The inputs are:\n"
				+ "12\r\n" + 
				"ENTER John 3.75 50\r\n" + 
				"ENTER Mark 3.8 24\r\n" + 
				"ENTER Shafaet 3.7 35\r\n" + 
				"SERVED\r\n" + 
				"SERVED\r\n" + 
				"ENTER Samiha 3.85 36\r\n" + 
				"SERVED\r\n" + 
				"ENTER Ashley 3.9 42\r\n" + 
				"ENTER Maria 3.6 46\r\n" + 
				"ENTER Anik 3.95 49\r\n" + 
				"ENTER Dan 3.95 50\r\n" + 
				"SERVED");
		
		//Scanning size of the entries 
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();
		
		//Scanning the entries
		while(totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}
		
		List<Student> students = priorities.getStudents(events);
		
		// Written the list on console if list is not empty.
		if(students.isEmpty()) {
			System.out.println("EMPTY");
		}else {
			for(Student stu : students) {
				System.out.println(stu.getName());
			}
		}
		
		scan.close();
	}

}
