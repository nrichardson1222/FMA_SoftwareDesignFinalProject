import java.util.ArrayList;
import java.util.List;

public class Forum {
	
    String subject;
	String text;
	String username;
	public static List<Forum> listOfForums = new ArrayList<>(); //this stores all of the forums in one list
    public static List<String> listOfSubjects = new ArrayList<>(); //this stores all of the subjects of each of the forums as a string in one list. the indexes of each of these will be consist
    public List<String> listOfComments;
    static int forumIndex=0;

    public Forum(String subjectInput, String textInput){
    	//when a forum is made it takes a subject as input and the forum text itself as input.
        subject = subjectInput;
        text = textInput;
        listOfComments = new ArrayList<>();//each forum will also have its own list of comments that other students can add to
        listOfComments.add(text);
        forumIndex++;
        

    }

    public static int getNumForums() {//returns to forum number
		return forumIndex;
	}

    public List<String> getAllForumSubjects(){ //returns all of the subjects of the the forums

        return listOfSubjects;


    }

    public String getForumSubject(){ //gets the subject of a forum of interest

        return subject;


    }

    public void setComment(String comment){ //creates a comment and adds it to the listOfComments of a forum object

        listOfComments.add(comment);

    }

    public static void makeComment(String subjectInput, String comment){ // the makeComment method. The user must enter the subject of the forum and then if it is found they can enter a comment to that forum

        boolean found = false;
		for (int i= 0; i < forumIndex; i++) {
            
			if (listOfForums.get(i).getForumSubject().equals(subjectInput) ){
				
				listOfForums.get(i).setComment(comment);
				found = true;
                System.out.println("Comment successfully made");
                
				
			}
			
			
		}
		if(!found) {
			System.out.println("Subject not found. Comment was not made");
		}



    }
    public static List<String> viewForum(String subjectInput){ //This method allows the user to view all of the comments on a forum with the subject of the forum as the input to the method
        System.out.println("Hello");
        for (int i= 0; i < forumIndex; i++) {
            System.out.println(listOfForums.get(i).getForumSubject());
			if (listOfForums.get(i).getForumSubject().equals(subjectInput) ){
				return listOfForums.get(i).listOfComments;
				
                
				
			}
			
		}
        return null;

    }
    public static List<String> viewForumSubject(){ //prints out all of the subjects to the forums
    	listOfSubjects.clear();
    	for (int i= 0; i < forumIndex; i++) {
            System.out.println(listOfForums.get(i).getForumSubject());
            listOfSubjects.add(listOfForums.get(i).getForumSubject());
    	}
    	return listOfSubjects;
    	
    }


}
