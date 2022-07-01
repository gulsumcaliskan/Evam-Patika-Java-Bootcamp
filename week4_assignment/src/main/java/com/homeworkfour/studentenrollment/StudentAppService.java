package com.homeworkfour.studentenrollment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentAppService {
	
	// By ObjectMapper we cast the json data to List of Student.
	public List<Student> getAllStudents(File file) throws IOException{
		return new ObjectMapper().readValue(file, new TypeReference<List<Student>>() {});
	}
	
	public Student addStudent(File file, Student student) {
		
		try {
			List<Student> students = getAllStudents(file);
			students.add(student);
			new ObjectMapper().writeValue(file, students);
			return student;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
