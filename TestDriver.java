import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);// Scanner object initialized to receive text input
		
		Context context = new Context();
		
		SignInState signInState = new SignInState();
		signInState.promptUser(context);
		
		LoggedInState loggedInState = new LoggedInState();
		
		
		while(true) {
			
			if (!SignInState.isLoggedIn()) {
				signInState.promptUser(context);
				
			}else {
				loggedInState.promptUser(context);
			}
		}
		
		
	}
				
}
			
		





