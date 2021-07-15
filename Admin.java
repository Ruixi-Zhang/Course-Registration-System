
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Admin extends User implements AdminInterface, Comparable<Courses>,  java.io.Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Admin(){
		setUsername("Admin01");
		setPassward("Admin01");
		setFirstname("There is only one admin");
		setLastname("There is only one admin");
		
	}
	
	@Override
	public void createCourse(ArrayList<Courses> Courselist, Courses course) {
		Courselist.add(course);
		
	}

	@Override
	public void deleteCourse(ArrayList<Courses> Courselist, String id, int secnumber) {
		int j=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {Courselist.remove(Courselist.get(i));
			 	 j=1;}}
		successindicator(j);
	}
	
	public void deleteCourse(ArrayList<Courses> Courselist, String id, String secnumberx) {
		int secnumber = Integer.parseInt(secnumberx);
		int j=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {Courselist.remove(Courselist.get(i));
			 	 j=1;}}
		successindicator(j);
	}

	@Override
	public void editCourse(ArrayList<Courses> Courselist, String id, int secnumber) throws IOException {
		BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));
		int j=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {//2Courses thisCourse=Courselist.get(i);
		 	 j=1;
			 	 
					System.out.println("Enter '1' to change the maximum enrollment number.");
					System.out.println("Enter '2' to change the section number.");
					System.out.println("Enter '3' to change the instructor.");
					System.out.println("Enter '4' to change the location.");
					String mode = inp.readLine();
					if (mode.contentEquals("1")){
						System.out.println("Enter the new maximum enrollment number.");
						String max = inp.readLine();
						Courselist.get(i).setMaxreg(max);
						
					}
					
					else if (mode.contentEquals("2")){
						System.out.println("Enter the new section number");
						String sec = inp.readLine();
						Courselist.get(i).setSecnumber(sec);
					}
				
					else if (mode.contentEquals("3")){
						System.out.println("Enter the new instructor");
						String instru = inp.readLine();
						Courselist.get(i).setInstructor(instru);
					}
					
					else if (mode.contentEquals("4")){
						System.out.println("Enter the new location");
						String loc = inp.readLine();
						Courselist.get(i).setLocation(loc);
					}
					
					else
						System.out.println("Invalid input");
			 	 
			 	 break;}}
		if (j==0) {
			System.out.println("Course Not Found");
		}
		
	}
	
	public void editCourse(ArrayList<Courses> Courselist, String id, String secnumberx)throws IOException {
		int secnumber = Integer.parseInt(secnumberx);
		int j=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {//Courses thisCourse=Courselist.get(i);
			 	 j=1;
			 	 
					BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Enter '1' to change the maximum enrollment number.");
					System.out.println("Enter '2' to change the section number.");
					System.out.println("Enter '3' to change the instructor.");
					System.out.println("Enter '4' to change the location.");
					String mode = inp.readLine();
					if (mode.contentEquals("1")){
						System.out.println("Enter the new maximum enrollment number.");
						String max = inp.readLine();
						Courselist.get(i).setMaxreg(max);
						
					}
					
					else if (mode.contentEquals("2")){
						System.out.println("Enter the new section number");
						String sec = inp.readLine();
						Courselist.get(i).setSecnumber(sec);
					}
					
					else if (mode.contentEquals("3")){
						System.out.println("Enter the new instructor");
						String instru = inp.readLine();
						Courselist.get(i).setInstructor(instru);
					}
					
					else if (mode.contentEquals("4")){
						System.out.println("Enter the new location");
						String loc = inp.readLine();
						Courselist.get(i).setLocation(loc);
					}
					
					else
						System.out.println("Invalid input");
			 	 
			 	 break;}}
		if (j==0) {
			System.out.println("Course Not Found");
		}
		

		
	}

	@Override
	public void displayInfo(ArrayList<Courses> Courselist, String id, int secnumber) {
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {super.printACourse(Courselist.get(i));
				 x+=1;
				 }}
		if (x==0) {
			System.out.println("Course Not Found");
		}
	}
	
	public void displayInfo(ArrayList<Courses> Courselist, String id, String secnumberx) {
		int secnumber = Integer.parseInt(secnumberx);
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 {super.printACourse(Courselist.get(i));
				 x+=1;
				 }}
		if (x==0) {
			System.out.println("Course Not Found");
		}
	}


	@Override
	public void registerStudent(ArrayList<Courses> Courselist, String id, int secnumber, String firstname,String lastname) {
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
		 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
			 {x=1;
			 if (Courselist.get(i).getCurreg()>=Courselist.get(i).getMaxreg())
				 System.out.println("Sorry, this class is full");
			 else
		 		{Student newStudent=new Student(firstname,lastname);
				 Courselist.get(i).getStudentlist().add(newStudent);
				 Courselist.get(i). setCurreg();
				 System.out.println("Success");
				 break;	 
			}
		}}
		if (x==0) {
			System.out.println("Course Not Found");
		}
		
	}
	
	public void registerStudent(ArrayList<Courses> Courselist, String id, String secnumberx, String firstname,String lastname) {
		int secnumber = Integer.parseInt(secnumberx);
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
		 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
			 {x=1;
			 if (Courselist.get(i).getCurreg()>=Courselist.get(i).getMaxreg())
				 System.out.println("Sorry, this class is full");
			 else
		 		{Student newStudent=new Student(firstname,lastname);
				 Courselist.get(i).getStudentlist().add(newStudent);
				 Courselist.get(i). setCurreg();
				 System.out.println("Success");
				 break;	 
			}
		}}
		if (x==0) {
			System.out.println("Course Not Found");
		}
		
	}
	

	@Override
	public void viewAllCourses(ArrayList<Courses> Courselist) {
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) { 
			super.printACourse(Courselist.get(i));	
			x+=1;
		}
		if(x==0)
			System.out.println("There are no courses");
	}

	@Override
	public void viewFullCourses(ArrayList<Courses> Courselist) {
		int counter=0;
		for (int i = 0; i < Courselist.size(); i++) { 
			if (Courselist.get(i).getCurreg()==Courselist.get(i).getMaxreg())
				{super.printACourse(Courselist.get(i));	
				counter+=1;
				}
		}
		if (counter==0) {
			System.out.println("Sorry, there are no full courses");
		}
		
	}

	@Override
	public void writeFullCourses(ArrayList<Courses> Courselist) {
		String content="";
		int counter=0;
		for (int i = 0; i < Courselist.size(); i++) { 
			if (Courselist.get(i).getCurreg()==Courselist.get(i).getMaxreg())
				{content=content+"\n"+ "Course Name: "+Courselist.get(i).getCoursename()+"\n"+"Course ID: "+Courselist.get(i).getCourseid()+"\n"+"Course Section: "+Courselist.get(i).getSecnumber()+"\n"+"\n";
				counter+=1;
				}
			}
		if (counter==0) {
			System.out.println("Sorry, there are no full courses");
		}
		else {
		 try {
		      FileWriter file = new FileWriter("Full Classes.txt");

		      BufferedWriter output = new BufferedWriter(file);

		      output.write(content);
		      output.close();
		    }

		    catch (Exception e) {
		      e.getStackTrace();
		    }
		 System.out.println("Full classes are printed in the file: Full Classes.txt ");
		 }
		
	}
	

	@Override
	public void viewStudentReg(ArrayList<Courses> Courselist, String id, int secnumber) {
		int counter=0;
		for (int i = 0; i < Courselist.size(); i++) {
			for (int j=0; j<Courselist.get(i).getStudentlist().size();j++) {
				 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 { System.out.println(Courselist.get(i).getStudentlist().get(j).getFirstname()+" "+Courselist.get(i).getStudentlist().get(j).getLastname());
				 counter+=1;
				 }
				 }
			
			}
		if (counter==0) {
			System.out.println("This course has no students yet");
		}
		System.out.println();
		}
	
	public void viewStudentReg(ArrayList<Courses> Courselist, String id, String secnumberx) {
		int counter=0;
		int secnumber = Integer.parseInt(secnumberx);
		for (int i = 0; i < Courselist.size(); i++) {
			for (int j=0; j<Courselist.get(i).getStudentlist().size();j++) {
				 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
					{System.out.println(Courselist.get(i).getStudentlist().get(j).getFirstname()+" "+Courselist.get(i).getStudentlist().get(j).getLastname());
					counter+=1;
					}
					}
			
			}
		if (counter==0) {
			System.out.println("This course has no students yet");
		}
		System.out.println();
		}
	

	@Override
	public void viewRegCourse(ArrayList<Courses> Courselist, String firstname,String lastname) {
		int x=0;
		System.out.println("Following are the courses that this student registered: ");
		for (int i = 0; i < Courselist.size(); i++) {
			for (int j=0; j<Courselist.get(i).getStudentlist().size();j++) {
				if (Courselist.get(i).getStudentlist().get(j).getFirstname().equalsIgnoreCase(firstname)&&Courselist.get(i).getStudentlist().get(j).getLastname().equalsIgnoreCase(lastname)){
					super.printACourse(Courselist.get(i));
					x+=1;
				}
			}
		}
		if (x==0) {
			System.out.println("That student haven't registered to any course");
		}
		
		
	}

	@Override
	public void sort(ArrayList<Courses> Courselist) {
		Collections.sort(Courselist);
	}

}
