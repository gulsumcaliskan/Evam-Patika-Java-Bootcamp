package com.homeworkfour.studentenrollment;

import java.util.List;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.homeworkfour.studentenrollment.Student;

//import static java.lang.System.out;

public class ThreadWritingProcess implements Runnable{

//	public static boolean readProcess = false;
	private List<Student> students;
	
	public ThreadWritingProcess(List<Student> students) {
		this.students = students;
	}
	
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			Thread.sleep(3000); // will be waited 3 sec after the reading process
			System.out.println();
		
			System.out.println("The reading process finished, and then are written...");
			Student.printList(ThreadReadingProcess.students);
			System.out.println();
			System.out.println("The writing process finished");			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
