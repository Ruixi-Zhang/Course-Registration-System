

public class User extends Courses implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String passward;
	private String firstname;
	private String lastname;
	
	User(){
		
	}
	
	
	public void printACourse(Courses Course) {
		System.out.println("Course Name: "+Course.getCoursename());
		System.out.println("Course ID: "+Course.getCourseid());
		System.out.println("Course Section: "+Course.getSecnumber());
		System.out.println("Instructor: "+Course.getInstructor());
		System.out.println("Maximum Enrollment: "+Course.getMaxreg());
		System.out.println("Current Enrollment: "+Course.getCurreg());
		System.out.println("Location: "+Course.getLocation());	
		System.out.println();
		}
	
	public void successindicator (int i) {
		if (i==0)
			System.out.println("Course Not found"); 
		else
			System.out.println("Success");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		
	}
	

