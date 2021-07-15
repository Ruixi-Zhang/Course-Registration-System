import java.io.*;
import java.util.ArrayList;



public class CRS  implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Courses> Courselist=new ArrayList<Courses>();
	//ArrayList<Student> Studentlist = new ArrayList<Student>();
	
	public ArrayList<Courses> getCourselist() {
		return Courselist;
	}
	
	//public ArrayList<Student> getStudentlist() {
	//	return Studentlist;
	//}


	public static void main(String [] args) throws IOException {
		CRS courselist=new CRS();
		File file = new File("MyUniversityCourses.ser");
		if (file.exists()) {
			 try{
			      FileInputStream fis = new FileInputStream("MyUniversityCourses.ser");
			      
			      ObjectInputStream ois = new ObjectInputStream(fis);
			      
			      
			      courselist = (CRS)ois.readObject();
			      
			      //System.out.println("Success");
			      ois.close();
			      fis.close();
			      //Admin thisAdmin=new Admin();
			      //thisAdmin.viewAllCourses(courselist.getCourselist());
			      
			    }
			    catch(IOException ioe) {
			    	System.out.println("File not found");
			       return;
			    }
			 catch(ClassNotFoundException cnfe) {
				 System.out.println("Class not found");
			       return;
			     }	


			 
		}
		
		else {
			//System.out.println("Found csv");
			try (BufferedReader br = new BufferedReader(new FileReader("MyUniversityCourses.csv"))){
				String line;
				br.readLine();
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					Courses newCourse=new Courses();
					newCourse.setCoursename(values[0]);
					newCourse.setCourseid(values[1]);
					newCourse.setMaxreg(values[2]);
					newCourse.setInstructor(values[5]);
					newCourse.setSecnumber(values[6]);
					newCourse.setLocation(values[7]);
					courselist.getCourselist().add(newCourse);
					}
				br.close();
				}
			catch(FileNotFoundException e) {
				System.out.println("File file not found");
			}
		}
		
		System.out.println("Welcome to the University's Course Registration System");
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		String mode="0";
		while (!mode.contentEquals("3")) {
		System.out.println("Enter '1' if you are a student.");
		System.out.println("Enter '2' if you are an admin.");
		System.out.println("Enter '3' to exit");
		System.out.println();
		mode = input.readLine();
		//student mode
		if (mode.contentEquals("1")){
			String studentoption="start";
			System.out.println("Enter your first name");
			String firstname = input.readLine();
			System.out.println("Enter your last name");
			String lastname = input.readLine();
			int courselistcounter=-1;
			int studentlistcounter=-1;
			for (int i = 0; i < courselist.getCourselist().size(); i++) {
				for (int j=0; j<courselist.getCourselist().get(i).getStudentlist().size();j++) {
					if (courselist.getCourselist().get(i).getStudentlist().get(j).getFirstname().equalsIgnoreCase(firstname)&&courselist.getCourselist().get(i).getStudentlist().get(j).getLastname().equalsIgnoreCase(lastname)){
						courselistcounter=i;
						studentlistcounter=j;
						}
					}	
			}
			if (courselistcounter==-1&&studentlistcounter==-1) {
				System.out.println("You haven't registered to any course contact an admin to register your first course!");
				System.out.println("You are returning back to the home page");
				System.out.println();
			}
			else {
				Student thisStudent=courselist.getCourselist().get(courselistcounter).getStudentlist().get(studentlistcounter);
				String correctusername;
				String correctpassward;
				if(thisStudent.getUsername()==null||thisStudent.getPassward()==null) {
					System.out.println("You are a first time user");
					System.out.println("Enter your desired username");
					String username = input.readLine();
					System.out.println("Enter your desired passward");
					String passward = input.readLine();
					thisStudent.setUsername(username);
					thisStudent.setPassward(passward);
					correctusername=thisStudent.getUsername();
					correctpassward=thisStudent.getPassward();
					}
				else {
					correctusername=thisStudent.getUsername();
					correctpassward=thisStudent.getPassward();
				}
				
				String insertusername = null;
				String insertpassward=null;
				do {
					System.out.println();
					System.out.println("Student Login Page \n");
					System.out.println("Enter your username");
					insertusername = input.readLine();
					System.out.println("Enter your passward");
					insertpassward = input.readLine();
					if (!correctusername.contentEquals(insertusername)||!correctpassward.contentEquals(insertpassward))
					{System.out.println("Incorrect username");
					System.out.println("Enter 1 if you want to return to the previous page, enter 0 if otherwise");
					String answer=input.readLine();
					if(answer.contentEquals("1"))
						{studentoption="6";
						break;
						}
					}
				}while(!correctusername.contentEquals(insertusername)||!correctpassward.contentEquals(insertpassward));
		
			
			//student home page
			while (!studentoption.contentEquals("6")) {
			System.out.println("Welcome to the student home page, "+thisStudent.getFirstname()+" "+thisStudent.getLastname());
			System.out.println();
			System.out.println("Enter '1' to view all courses.");
			System.out.println("Enter '2' to view all courses that are not full.");
			System.out.println("Enter '3' to register a course");
			System.out.println("Enter '4' to withdraw from a course.");
			System.out.println("Enter '5' to view all courses that you are registered in.");
			System.out.println("Enter '6' to exit and return to student login page");
			System.out.println();
			studentoption = input.readLine();
			
			//view all courses
			if (studentoption.contentEquals("1")) {
				thisStudent.viewAllCourses(courselist.getCourselist());
			}
			
			//view all courses that are not full
			else if (studentoption.contentEquals("2")) {
				thisStudent.viewNotFullCourses(courselist.getCourselist());
			}
			
			//register a course
			else if (studentoption.contentEquals("3")) {
				System.out.println("Enter the following information for your desired course");
				System.out.println("Course id: ");
				String desirecoursename = input.readLine();
				System.out.println("section number: ");
				String desiresecnumber = input.readLine();
				thisStudent.regCourse(courselist.getCourselist(), desirecoursename, desiresecnumber);
				System.out.println();
			}
			
			//withdraw from a course
			else if (studentoption.contentEquals("4")) {
				System.out.println("Enter the following information for your desired course");
				System.out.println("Course id: ");
				String desirecoursename = input.readLine();
				System.out.println("section number: ");
				String desiresecnumber = input.readLine();
				thisStudent.withdrawCourse(courselist.getCourselist(), desirecoursename, desiresecnumber);
				System.out.println();
			}
			
			//view all courses that you are registered in
			else if (studentoption.contentEquals("5")) {
				thisStudent.viewRegCourse(courselist.getCourselist());
			}
			
			//return
			else if (studentoption.contentEquals("6")) {
				System.out.println("You are returning to student login page");
				System.out.println();
			}
			
			else {
				System.out.println("invalid input");
			}
			
			}
			}	
			}		
		
		//admin mode
		else if (mode.contentEquals("2")){
			Admin thisAdmin=new Admin();
			String acorrectusername="Admin01";
			String acorrectpassward="Admin01";
			String ainsertusername = null;
			String ainsertpassward=null;
			System.out.println("Welcome to the admin login page");
			String adminoption = "0";
			do {
				System.out.println("Enter your username");
				ainsertusername = input.readLine();
				System.out.println("Enter your passward");
				ainsertpassward = input.readLine();
				System.out.println();
				if (!acorrectusername.contentEquals(ainsertusername)||!acorrectpassward.contentEquals(ainsertpassward))
					{System.out.println("Incorrect username");
					System.out.println("Enter 1 if you want to return to homepage, enter 0 if otherwise");
					String answer=input.readLine();
					if(answer.contentEquals("1"))
						{adminoption="3";
						break;
						}
					}
			}while(!acorrectusername.contentEquals(ainsertusername)||!acorrectpassward.contentEquals(ainsertpassward));
			
			
			while (!adminoption.contentEquals("3")) {
			System.out.println("Welcome to the admin home page. ");
			System.out.println();
			System.out.println("Enter '1' to go to the Reports page.");
			System.out.println("Enter '2' to go to the Course Management page");
			System.out.println("Enter '3' to exit and return to the home page");
			System.out.println();
			adminoption = input.readLine();
			if (adminoption.contentEquals("1")) {
				String cmoption="start";
				while (!cmoption.contentEquals("6")) {
				System.out.println("Welcome to the course management page");
				System.out.println();
				System.out.println("Enter '1' to create a new course.");
				System.out.println("Enter '2' to delete a course.");
				System.out.println("Enter '3' to edit a course.");
				System.out.println("Enter '4' to display information for a given course.");
				System.out.println("Enter '5' to register a student.");
				System.out.println("Enter '6' to exit and return to the admin home page");
				System.out.println();
				cmoption = input.readLine();
				
				//create a new course
				if (cmoption.contentEquals("1")) {
					System.out.println("Enter the Course Name: ");
					String coursename = input.readLine();
					
					System.out.println("Enter the Course ID: ");
					String courseid = input.readLine();
					
					System.out.println("Enter the maximum enrollment number: ");
					int maxreg = Integer.parseInt(input.readLine());
					
					System.out.println("Enter the instructor name: ");
					String instructor = input.readLine();
					
					System.out.println("Enter the section number: ");
					int secnumber = Integer.parseInt(input.readLine());
					
					System.out.println("Enter the location: ");
					String location = input.readLine();
					
					Courses newCourse= new Courses(coursename, courseid, maxreg, instructor, secnumber, location);
					
					thisAdmin.createCourse(courselist.getCourselist(), newCourse);
					
				}
				
				//delete a course
				else if (cmoption.contentEquals("2")) {
					System.out.println("Enter the following information for the desired course");
					System.out.println("Course id: ");
					String desirecoursename = input.readLine();
					System.out.println("section number: ");
					String desiresecnumber = input.readLine();
					thisAdmin.deleteCourse(courselist.getCourselist(), desirecoursename, desiresecnumber);
					System.out.println();
				}
				
				//edit a course
				else if (cmoption.contentEquals("3")) {
					System.out.println("Enter the following information for the desired course");
					System.out.println("Course id: ");
					String desirecoursename = input.readLine();
					System.out.println("section number: ");
					String desiresecnumber = input.readLine();
					thisAdmin.editCourse(courselist.getCourselist(), desirecoursename, desiresecnumber);
					System.out.println();
	
				}
				
				//display information for a given course
				else if (cmoption.contentEquals("4")) {
					System.out.println("Enter the following information for the desired course");
					System.out.println("Course id: ");
					String desirecoursename = input.readLine();
					System.out.println("section number: ");
					String desiresecnumber = input.readLine();
					thisAdmin.displayInfo(courselist.getCourselist(), desirecoursename, desiresecnumber);
					System.out.println();
				
				}
				
				//register a student
				else if (cmoption.contentEquals("5")) {
					System.out.println("Enter the following information for the desired student");
					System.out.println("First name: ");
					String firstname = input.readLine();
					System.out.println("Last name: ");
					String lastname = input.readLine();
//					int counter=0;
//					for(int i=0; i<courselist.getStudentlist().size();i++) {
//						if (courselist.getStudentlist().get(i).getFirstname().contentEquals(firstname)&&courselist.getStudentlist().get(i).getLastname().contentEquals(lastname)) {
//							counter+=1;
//						}
//					}
//					if (counter==1) {
//						Student thisStudent =new Student(firstname,lastname);
//						courselist.getStudentlist().add(thisStudent);
//					}
					
					System.out.println("Enter the following information for the desired course");
					System.out.println("Course id: ");
					String desirecoursename = input.readLine();
					System.out.println("section number: ");
					String desiresecnumber = input.readLine();
					thisAdmin.registerStudent(courselist.getCourselist(), desirecoursename, desiresecnumber,firstname,lastname);
					System.out.println();
					
				}
				
				//return
				else if (cmoption.contentEquals("6")) {
					System.out.println("You are returning to the admin home page");
					System.out.println();
				}
				
				else {
					System.out.println("invalid input");
				}
			
				}}
			else if (adminoption.contentEquals("2")) {
				String roption="Start";
				while (!roption.contentEquals("7")) {
				System.out.println("Welcome to the course management page");
				System.out.println();
				System.out.println("Enter '1' to view all courses.");
				System.out.println("Enter '2' to view all courses that are full.");
				System.out.println("Enter '3' to write to a file the list of course that are Full.");
				System.out.println("Enter '4' to view the names of the students being registered in a specific course.");
				System.out.println("Enter '5' to view the list of courses that a given student is being registered on.");
				System.out.println("Enter '6' to sort courses based on the current number of student registers");
				System.out.println("Enter '7' to exit and return to the admin home page");
				System.out.println();
				roption = input.readLine();
				
				//View all courses
				if (roption.contentEquals("1")) {
					thisAdmin.viewAllCourses(courselist.getCourselist());
					System.out.println();
				}
				
				//View all courses that are FULL
				else if (roption.contentEquals("2")) {
					thisAdmin.viewFullCourses(courselist.getCourselist());
					System.out.println();
				}
				
				//.Write to a file the list of course that are Full
				else if (roption.contentEquals("3")) {
					thisAdmin.writeFullCourses(courselist.getCourselist());
					System.out.println();

				}
				
				//View the names of the students being registered in a specific course
				else if (roption.contentEquals("4")) {
					System.out.println("Enter the following information for the desired course");
					System.out.println("Course id: ");
					String desirecoursename = input.readLine();
					System.out.println("section number: ");
					String desiresecnumber = input.readLine();
					thisAdmin.viewStudentReg(courselist.getCourselist(), desirecoursename, desiresecnumber);
					System.out.println();
				
				}
				
				//View the list of courses that a given student is being registered on
				else if (roption.contentEquals("5")) {
					System.out.println("Enter the following information for the desired student");
					System.out.println("First name: ");
					String firstname = input.readLine();
					System.out.println("Last name: ");
					String lastname = input.readLine();
					thisAdmin.viewRegCourse(courselist.getCourselist(), firstname,lastname);
					System.out.println();
				}
				
				// Sort courses based on the current number of student registers
				else if (roption.contentEquals("6")) {
					thisAdmin.sort(courselist.getCourselist());
					System.out.println();
				}
				//return
				else if (roption.contentEquals("7")) {
					System.out.println("You are returning to the admin home page");
					System.out.println();
				}
				
				else {
					System.out.println("invalid input");
				}
			
				}
			}
			
			else if (adminoption.contentEquals("3")) {
				System.out.println("You are returning to the home page");
				System.out.println();
			}

			else {
				System.out.println("Invalid input");
				System.out.println();
			}
			}
		}
		
		//exit
		else if (mode.contentEquals("3")){
			
			try {
				FileOutputStream fos = new FileOutputStream("MyUniversityCourses.ser");
				
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(courselist);
				
				oos.close();
				fos.close();
				System.out.println("Serialization complete");

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			System.out.println("Bye");
			

		}
		else
			System.out.println("Invalid input");
		}
		
		
		
		
		
		
	}

	

}
