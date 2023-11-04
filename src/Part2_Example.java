import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.Seat;
import CourseSchedule.SeatAssignment;
import Persona.Person;
import Persona.Faculty.FacultyProfile;

public class Part2_Example {
	
	public static void main(String[] args) {
		// Create a course schedule for Fall 2023 semester
		CourseLoad courseLoad = new CourseLoad("2023");
		// Create course offerings for each course for the semester
		Course c = new Course("N001", "course name 1", 10);
		CourseOffer co = new CourseOffer(c);
		Seat s = new Seat(co, 1);
		SeatAssignment seatAssignment = new SeatAssignment(courseLoad, s);
		courseLoad.registerStudent(seatAssignment);
		// Create 25 seats for each course offering
		co.generateSeats(25);
		// Register students for the courses
		courseLoad.registerStudent(seatAssignment);
		// Assign teachers (faculty) to course offerings
		FacultyProfile fp = new FacultyProfile(new Person("tid-1", "teacher-1" ));
		co.AssignAsTeacher(fp);
		// Assign grades to students
		System.out.println(seatAssignment.GetCourseStudentScore());
	}
}
