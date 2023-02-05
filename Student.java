import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String name; //The name of the student. This would be first and last name
	String password; //Password of the individual student user
	String username; //Username of the individual student user
	boolean isLoggedIn; //This boolean tells what the status of the user is. If it is false then it prompts to user to login or sign up
	
	public static List<Student> listOfStudents = new ArrayList<>(); //This stores all of the student objects into one list which we access using the index
	
	public  List<Student> followers = new ArrayList<>(); //This is how the Observer design pattern was implemented. For each student, they have their own list of followers
//	public  List<Student> following = new ArrayList<>();
	
	static int studentIndex=0; //Tells which of the student objects from the list to use.
	static int numStudent=-1; //Essentially the length of the listOfStudents list
	
	public static int getNumStudents() { //returns the number of students - 1 so for traversing the list
		return studentIndex;
	}
	
	public static int numStudent() { //get the index of the student in the list
		return numStudent;
	} 
	
	public Student(String nameInput, String usernameInput, String passwordInput) { //
		name = nameInput; //name of the student
		password = passwordInput; //password of the student
		username = usernameInput; //username of the student
//		System.out.println("Student made"); 
		isLoggedIn = false; //automatically set to false. Will change to true when the student logins
		studentIndex++; //increases the index which is the index of the last student in the list
		
	}
	
	public String getPassword() { //getter for password
		return password;
	}
	
	public String getUsername() { //getter for username
		return username;
	}
	
	public static boolean login (String usernameInput, String passwordInput) { //the method for how the student logins
		boolean found = false;
		for (int i= 0; i < studentIndex; i++) {//loops over the list of students and sees if the entered username and password matches one of the student objects in the list
			if (listOfStudents.get(i).getUsername().equals(usernameInput) ){ //
				if (listOfStudents.get(i).getPassword().equals(passwordInput)) {
					System.out.println("Login Successful"); //prints to console that Login was successful and changes the status to isLoggedIn to true
					numStudent = i;
					listOfStudents.get(i).isLoggedIn = true;
				}
				
			}
			
		}
		

		
		return true;
	}
	
	public void logout() {
		listOfStudents.get(numStudent).isLoggedIn = false; //changes status to isLoggedIn to false so it prompts the menu for student login or signup
	}
	
	
	public void attach(String username) {//the implementation of the Observer pattern. 
		for (int i = 0; i<studentIndex; i++) { //Based on the username that the student wants to follow, if this username is in the list of students, then that student object is added to the list of followers
			if (username.equals(listOfStudents.get(i).getUsername())) {
				followers.add(listOfStudents.get(i));
				System.out.println("This follower is now added");//This message is printed to show that the attach was a success.
			}
		}
		
	}
	
	public void detach(Student s) { 
		followers.remove(s);
	}

	public void notify(String s) {//This is the notify method and it alerts to the students followers that a forum was posted
		for(Student stud: followers) {
			System.out.println(stud.getUsername()+" your follower posted "+s);
		}
	}
}
