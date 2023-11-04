import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseOffer;
import Department.Department;
import Persona.Person;
import Persona.StudentDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

public class Part1_Example {

	public static void main(String[] args) {
		// 1(one) Department.
		Department dept = new Department("Department First");
		// 5(five) courses per program.
		for (int i = 0; i < 5; i++) {
			CourseCatalog courseCatalog = new CourseCatalog(dept);
			Course course = courseCatalog.newCourse("N00" + i, "course name " + i, 10 + i);
			//1(one) faculty for each course
			FacultyDirectory facultyDirectory = new FacultyDirectory(dept);
			FacultyProfile fp = facultyDirectory.newFacultyProfile(new Person("tid-" + i, "teacher-" + i));
			CourseOffer co = new CourseOffer(course);
			co.AssignAsTeacher(fp);
		}
		// 10(ten) students in each program.
		StudentDirectory studentdirectory = new StudentDirectory(dept);
		for (int i = 0; i < 10; i++) {
			studentdirectory.newStudentProfile(new Person("sid-" + i, "student-" + i));
		}
		// 1(one) college
		College college = new College("College Name");
		college.addDepartment(dept);
		
	}

}
