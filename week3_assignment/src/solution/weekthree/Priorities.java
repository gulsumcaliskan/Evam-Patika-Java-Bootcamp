package solution.weekthree;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;


public class Priorities {
	
	// Create a Priority Queue of Student type.
	
			public List<Student> getStudents(List<String> events){
				
				//PriorityQueue is a queue that have some priorities.
				
				// Turned a list as a Student type, by getting a list taken parameter as a String type 
				PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(new Comparator<Student>() {
					
					public int compare(Student st1, Student st2) {
						
						// The order conditions
						
						if(st1.getCGPA() < st2.getCGPA()) { // Sort CGPA ascending order
							return 1;
						}else if(st1.getCGPA() > st2.getCGPA()) {
							return -1;
						}else {
							if(st1.getName().compareTo(st2.getName()) == 0) { // Sort name by ascending order
								if(st1.getID() > st2.getID()) {
									return 1;
								}else if(st1.getID() < st2.getID()) { // Sort ID by ascending order
									return -1;
								}else {
									return 0;
								}
							}else {
								return st1.getName().compareTo(st2.getName());
							}
						}
					}
								
				});
				
					
					// Iterate in the event list
					for(String event : events) {
							// Have been served or not
						if(event.equals("SERVED")) {
							priorityQueue.poll();
						}else {
								//Split even by regex
							String[] details = event.split("\\s");
							
							// from the latest to first value that came is id, cgpa, and name.
							// details[3] : id; details[1] : cgpa; details[2] : name
							priorityQueue.add(new Student(Integer.parseInt(details[3]), details[1], Double.parseDouble(details[2])));
								
						}
					}
				
					// Student list initialize
				List<Student> students = new ArrayList<>();
				// if the list is not empty, add them
				//set Student to the head item of the priority queue and then add it to the list.
				while(!priorityQueue.isEmpty()) {
					students.add(priorityQueue.poll());
				}
				
				return students;
			}

}
