
import java.io.IOException;
import java.util.ArrayList;

public interface AdminInterface {
	//course management
	public void createCourse(ArrayList<Courses> Courselist, Courses course);//Create a new course
	void deleteCourse(ArrayList<Courses> Courselist, String coursename, int secnumber);//Delete a course
	void editCourse(ArrayList<Courses> Courselist, String coursename, int secnumber) throws IOException;//Edit a course (this will allow the admin to edit any information on the course except for course ID and name)
	void displayInfo(ArrayList<Courses> Courselist, String coursename, int secnumber);//Display information for a given course (by course ID)
	void registerStudent(ArrayList<Courses> Courselist, String coursename, int secnumber, String firstname,String lastname);//Register a student
	
	//reports
	void viewAllCourses(ArrayList<Courses> Courselist);//View all courses
	void viewFullCourses(ArrayList<Courses> Courselist);//.View all courses that are FULL 
	void writeFullCourses(ArrayList<Courses> Courselist);//Write to a file the list of course that are Full
	void viewStudentReg(ArrayList<Courses> Courselist, String coursename, int secnumber);//View the names of the students being registered in a specific course
	void viewRegCourse(ArrayList<Courses> Courselist, String firstname,String lastname);//View the list of courses that a given student is being registered on
	void sort(ArrayList<Courses> Courselist);//Sort courses based on the current number of student registers
	
}
