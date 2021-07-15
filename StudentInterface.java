
import java.util.ArrayList;

public interface StudentInterface {
	//course management
	void viewAllCourses(ArrayList<Courses> Courselist);//View all courses
	void viewNotFullCourses(ArrayList<Courses> Courselist);//.View all courses that are not FULL 
	void regCourse(ArrayList<Courses> Courselist, String coursename, int secnumber);//Register on a course (in this case the student must enter the course name, section, and student full name, the name will be added to the appropriate course)
	void withdrawCourse(ArrayList<Courses> Courselist, String coursename, int secnumber);//Withdrawfromacourse(inthiscasethestudentwillbeaskedtoenterher/hisstudent name and the course, then the name of the student will be taken off from the given course’ list)
	public void viewRegCourse(ArrayList<Courses> Courselist);//View all courses that the current student is being registered in
	
}
