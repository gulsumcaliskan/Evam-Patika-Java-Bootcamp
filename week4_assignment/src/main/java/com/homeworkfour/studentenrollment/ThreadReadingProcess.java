package com.homeworkfour.studentenrollment;

import java.io.File;
import java.io.FileReader;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.homeworkfour.studentenrollment.Path;
import com.homeworkfour.studentenrollment.Student;
/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/
public class ThreadReadingProcess implements Runnable{

	public static List<Student> students;
	private File file;
	private static boolean isRead = false;

	//Constructor
	public ThreadReadingProcess(File file, List<Student> students) throws IOException{
		this.file = file;
		this.students = students;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		isRead = false; // with this boolean, we check the process is finish or not.
		
		ObjectMapper mapper = new ObjectMapper(); // creating new object
//		JSONParser jsonParser = new JSONParser();
		try {
			
			//Read student.json file 
			FileReader reader = new FileReader(Path.path);
			System.out.println("The reading process is started....");
			Thread.sleep(3000); // Will be waited for 3 sec.
			
			students = mapper.readValue(reader, new TypeReference<List<Student>>() {}); // by object mapper we cast from json data to List of Student
			// or
//			students = mapper.readValue(file, new TypeReference<List<Student>>() {});
				
//			Object obj = jsonParser.parse(reader);		
//			JSONArray students = (JSONArray) obj;
//			System.out.println(students.get("students"));
			
			// Iterated the students and will be processed. 
			for(Student element : students) {
//				System.out.println(element.getName() + " " + element.getSurname() + " " + element.getAge());
				System.out.println(element.getName() + " is processing...");
			}
			
			isRead = true;
			
			/*
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			*/
		}catch(IOException e) {
			throw new RuntimeException(e);
		} /*catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
