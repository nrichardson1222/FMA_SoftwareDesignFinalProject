import java.util.ArrayList;
import java.util.List;

public class Mentor {
	
	String name;//name of the mentor
	String password;//password of mentor account
	String username; //username of mentor account
	boolean isLoggedIn; //true or false depending on if mentor is logged in or not
	public static List<Mentor> listOfMentors = new ArrayList<>();
	
	static int mentorIndex=0; //the number of mentor accounts
	static int numMentor=-1; //
	
	public static int getNumMentors() {
		return mentorIndex;
	}
	
	public static int numMentor() {
		return numMentor;
	}
	
	
	public Mentor(String nameInput, String usernameInput, String passwordInput) {
		name = nameInput;
		password = passwordInput;
		username = usernameInput;
		isLoggedIn = false;
		System.out.println("Mentor made");
		mentorIndex++;
		
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public static boolean login (String usernameInput, String passwordInput) {
		boolean found = false;
		for (int i= 0; i < mentorIndex; i++) {
			if (listOfMentors.get(i).getUsername().equals(usernameInput) ){
				if (listOfMentors.get(i).getPassword().equals(passwordInput)) {
					System.out.println("Login Successful");
					numMentor = i;
					listOfMentors.get(i).isLoggedIn = true;
				}else{
					System.out.println("Password incorrect");
				}
				
				
			}
			
		}
		
		

		
		return true;
	}
	
	public void logout() {
		listOfMentors.get(numMentor).isLoggedIn = false;
	}

}
