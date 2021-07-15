

import java.util.ArrayList;

public class Student extends User implements StudentInterface , java.io.Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Student(){
		
	}

	Student(String firstname, String lastname){
		setFirstname(firstname);
		setLastname(lastname);
	}

	Student(String username, String passward, String firstname, String lastname) {
		setUsername(username);
		setPassward(passward);
		setFirstname(firstname);
		setLastname(lastname);
	}
	
	@Override
	public void viewAllCourses(ArrayList<Courses> Courselist) {
		for (int i = 0; i < Courselist.size(); i++) { 
			super.printACourse(Courselist.get(i));	
		}
		
	}

	@Override
	public void viewNotFullCourses(ArrayList<Courses> Courselist) {
		int counter=0;
		for (int i = 0; i < Courselist.size(); i++) { 
			if (Courselist.get(i).getCurreg()!=Courselist.get(i).getMaxreg())
				{super.printACourse(Courselist.get(i));	
				counter+=1;
				}
		}
		if (counter==0) {
			System.out.println("Sorry, all fourses are full");
		}
		
	}

	@Override
	public void regCourse(ArrayList<Courses> Courselist, String id, int secnumber) {
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
		 
			if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 x=1; 
				if (Courselist.get(i).getCurreg()>=Courselist.get(i).getMaxreg())
					 System.out.println("Sorry, this class is full");
				 else
			 		{Student newStudent=new Student(getFirstname(),getLastname());
					 Courselist.get(i).getStudentlist().add(newStudent);
					 Courselist.get(i). setCurreg();
					 System.out.println("Success");
					 break;	 
				}
		}
		if (x==0) {
			System.out.println("Course Not Found");
		}
		
	}
	//overload
	public void regCourse(ArrayList<Courses> Courselist, String id, String secnumberx) {
		int secnumber = Integer.parseInt(secnumberx);
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 x=1;
			if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				 if (Courselist.get(i).getCurreg()>=Courselist.get(i).getMaxreg())
					 System.out.println("Sorry, this class is full");
				 else
			 		{Student newStudent=new Student(getFirstname(),getLastname());
					 Courselist.get(i).getStudentlist().add(newStudent);
					 Courselist.get(i). setCurreg();
					 System.out.println("Success");
					 break;	 
				}
		}
		if (x==0) {
			System.out.println("Course Not Found");
		}

		
	}
	

	@Override
	public void withdrawCourse(ArrayList<Courses> Courselist, String id, int secnumber) {
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				{for (int j=0; j<Courselist.get(i).getStudentlist().size();i++) {
					if (Courselist.get(i).getStudentlist().get(j).getFirstname().equalsIgnoreCase(getFirstname())&&Courselist.get(i).getStudentlist().get(j).getLastname().equalsIgnoreCase(getLastname())){
						{Courselist.get(i).getStudentlist().remove(j);
						Courselist.get(i). setCurreg();	
						x=1;}}}}}
		successindicator(x);
				 
						
	}
	
	public void withdrawCourse(ArrayList<Courses> Courselist, String id, String secnumberx) {
		int secnumber = Integer.parseInt(secnumberx);
		int x=0;
		for (int i = 0; i < Courselist.size(); i++) {
			 if ((Courselist.get(i).getCourseid().equalsIgnoreCase(id))&&(Courselist.get(i).getSecnumber()==secnumber))
				{for (int j=0; j<Courselist.get(i).getStudentlist().size();i++) {
					if (Courselist.get(i).getStudentlist().get(j).getFirstname().equalsIgnoreCase(getFirstname())&&Courselist.get(i).getStudentlist().get(j).getLastname().equalsIgnoreCase(getLastname())){
						{Courselist.get(i).getStudentlist().remove(j);
						Courselist.get(i). setCurreg();	
						x=1;}}}}}
		successindicator(x);
				 
						
	}

	@Override
	public void viewRegCourse(ArrayList<Courses> Courselist) {
		int x=0;
		System.out.println("Following are the courses that you registered: ");
		for (int i = 0; i < Courselist.size(); i++) {
			for (int j=0; j<Courselist.get(i).getStudentlist().size();j++) {
				if (Courselist.get(i).getStudentlist().get(j).getFirstname().equalsIgnoreCase(getFirstname())&&Courselist.get(i).getStudentlist().get(j).getLastname().equalsIgnoreCase(getLastname())){
					super.printACourse(Courselist.get(i));
					x+=1;
				}
			}
		}
		if (x==0) {
			System.out.println("You haven't registered to any course");
		}
		
	}



}
