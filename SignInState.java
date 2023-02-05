import java.util.Scanner;

public class SignInState implements State {


	Scanner input = new Scanner(System.in);
	
	static boolean isLoggedIn = false; //This variable is what determines which of the states to call in the TestDriver
	public void promptUser(Context context) {
		// TODO Auto-generated method stub
		
		context.setState(this);
		System.out.println("Welcome to F=MA. What would you like to do. Enter things like 'student signup' 'mentor signup' student login' 'mentor login'"); //
		String command = input.nextLine(); //This waits for the command of the user
		if(command.equalsIgnoreCase("student signup")) {
			
			//For a student to signup, they will enter their name, username, password
			System.out.println("Welcome to Student Signup Page");
			System.out.println("Enter First and Last name on one line");
			String name  = input.nextLine(); 
			
			System.out.println("Enter username");
			String username  = input.nextLine(); 
			
			System.out.println("Enter Password");
			String password  = input.nextLine(); 
			//This line creates the student object and puts it into the list of student objects
			//each of these student objects is accessed using the .get(i) of the list
			Student.listOfStudents.add(Student.getNumStudents(), new Student(name, username, password));
		
		}else if(command.equalsIgnoreCase("student login")) {
			System.out.println("Enter username");
			String username  = input.nextLine(); 
			
			System.out.println("Enter Password");
			String password  = input.nextLine(); 
			if (Student.login(username,password)) {
				isLoggedIn = true;
				isLoggedIn();
			}
			
		}
	

	}
	
	
	public static boolean isLoggedIn() {
		
		return isLoggedIn;
	}
}
