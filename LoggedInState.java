import java.util.Scanner;

public class LoggedInState implements State{

	Scanner input = new Scanner(System.in);
	public void promptUser(Context context) {
		// TODO Auto-generated method stub
		
		context.setState(this);
		
			System.out.println("What would you like to do. \nType 'search' to view all users, \n'view subjects' to view the subjects of forums, \n'view forums' to see the forums of a given subject \n'create forum' to create a forum, 'create comment' to comment on a forum \n'logout' to logout");
			String decision  = input.nextLine(); 
			if(decision.equalsIgnoreCase("create forum")) {

				System.out.println("Enter Forum Subject");
				String subject  = input.nextLine(); 
				System.out.println("Enter Forum Post");
				String forum  = input.nextLine(); 
				Forum.listOfForums.add(Forum.getNumForums(), new Forum(subject, forum));
				Student.listOfStudents.get(Student.numStudent).notify(forum);

			}else if (decision.equalsIgnoreCase("create comment")){
				System.out.println("Enter Forum Subject");
				String subject  = input.nextLine(); 
				System.out.println("Enter Forum Post");
				String comment  = input.nextLine(); 
				Forum.makeComment(subject, comment);
			}else if (decision.equalsIgnoreCase("view forums")){
				System.out.println("Enter Forum Subject you want to view");
				String subject  = input.nextLine(); 
				System.out.println(Forum.viewForum(subject));

			}else if (decision.equalsIgnoreCase("view subjects")){
				System.out.println(Forum.viewForumSubject());

			}else if (decision.equalsIgnoreCase("logout")){
				
				Student.listOfStudents.get(Student.numStudent).logout();
				SignInState.isLoggedIn = false;
			}else if (decision.equalsIgnoreCase("search")){
				
				for(int i = 0; i< Student.getNumStudents(); i++) {
					System.out.println(Student.listOfStudents.get(i).getUsername());
				}
			}else if (decision.equalsIgnoreCase("add")){
				System.out.println("Enter the username of the student you want to add");
				String student  = input.nextLine(); 
				Student.listOfStudents.get(Student.numStudent).attach(student);
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
