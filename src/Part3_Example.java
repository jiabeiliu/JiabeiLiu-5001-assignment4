import java.util.ArrayList;

import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.Seat;
import Department.Department;

public class Part3_Example {

	public static void main(String[] args) {
		/**
		 Implement a method to print the Course scheshowing all courses taught this 
		 semesteshowing Course information, teachers, 
		 number of registered students and remaining empty seats 
		 **/
		Department dept = new Department("Department First");
		String semester = "semester";
		CourseCatalog cc = new CourseCatalog(dept);
		CourseSchedule courseSchedule = new CourseSchedule(semester, cc);
		// add a method of getCourseOffer() at CourseSchedule object
		ArrayList<CourseOffer> schedule = courseSchedule.getCourseOffer();
		CourseLoad courseLoad = new CourseLoad("2023");
		int seatCount = 0;
		for (int i = 0; i < schedule.size(); i++) {
			CourseOffer courseOffer = schedule.get(i);
			// add a method of getPerson() at FacultyProfile object
			String teacherName = courseOffer.getFacultyProfile().getPerson().getName();
			String courseNumber = courseOffer.getSubjectCourse().getCourseName();
			Seat seat = courseOffer.getEmptySeat();
			if(null != seat) {
				seatCount ++;
			}
			System.out.println(teacherName + " : " + courseNumber);
		}
		courseLoad.print();
		System.out.println("seatCount : " + seatCount);
		
		/**lmplement a method to calculate Department revenue (or use one if exists) 
		 for Fall 2023semester showing breakdown by Course offerings**/
		// Implement a method to calculate department revenue for the autumn semester of 2023
		int totalRevenues = courseSchedule.calculateTotalRevenues();
		System.out.println("totalRevenues : " + totalRevenues);
	}

}
