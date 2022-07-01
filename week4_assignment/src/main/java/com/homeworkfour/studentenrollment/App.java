package com.homeworkfour.studentenrollment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	// The path of the file that will be read the data
    	File file = new File(Path.path);
    	
    	// Created the Students lists
    	List<Student> students = new ArrayList<Student>();
    	
    	// Created the Threads that will be read and written
    	ThreadReadingProcess threadRead = new ThreadReadingProcess(file, students);
    	Thread threadR = new Thread(threadRead);
    	ThreadWritingProcess threadWrite = new ThreadWritingProcess(students);
    	Thread threadW = new Thread(threadWrite);
    	
    	// Started the threads
    	threadR.start();
    	try {
    		threadR.join();
    		threadW.start();
    	}catch(InterruptedException e) {
    		throw new RuntimeException(e);
    	}
    	
    }

}
