
import java.util.ArrayList;



public class Courses implements Comparable<Courses> , java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String coursename;
	private String courseid;
	private int maxreg;
	private String instructor;
	private int secnumber;
	private String location;
	private ArrayList<Student> studentlist=new ArrayList<Student>();
	private int curreg;
	
	Courses(){
		
	}
	
	Courses(String coursename, String courseid, int maxreg,  String instructor, int secnumber,String location){
		this.coursename=coursename;
		this.courseid=courseid;
		this.maxreg=maxreg;
		this.instructor=instructor;
		this.secnumber=secnumber;
		this.location=location;
		this.curreg=0;
		
	}
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public int getCurreg() {
		return curreg;
	}
	
	public void setCurreg() {
		this.curreg=studentlist.size();
		//curreg+=1;
	}
	
	public void setCurreg(int curreg) {
		this.curreg=curreg;
	}
	public void setCurreg(String curregx) {
		int curreg = Integer.parseInt(curregx);
		this.curreg=curreg;
	}
	
	public int getMaxreg() {
		return maxreg;
	}
	
	public void setMaxreg(String maxregx) {
		int maxreg = Integer.parseInt(maxregx);
		this.maxreg = maxreg;
	}
	
	public void setMaxreg(int maxreg) {
		this.maxreg = maxreg;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSecnumber() {
		return secnumber;
	}
	public void setSecnumber(String secnumberx) {
		int secnumber = Integer.parseInt(secnumberx);
		this.secnumber = secnumber;
	}
	
	public void setSecnumber(int secnumber) {
		this.secnumber = secnumber;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(ArrayList<Student> studentlist) {
		this.studentlist = studentlist;
	}

	@Override
	public int compareTo(Courses o) {
		if (getCurreg()>o.getCurreg())
			return 1;
		else if (getCurreg()<o.getCurreg())
			return -1;
		else
			return 0;
	}
	
	
	
}
