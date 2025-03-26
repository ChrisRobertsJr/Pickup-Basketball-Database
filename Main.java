import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		ArrayList<User> users = (ArrayList)Filer.loadList("hoopers.ser");
		for (User u : users) {
			System.out.println(u.getName()+" "+ u.getUsername()+" "+ u.getPassword());
		}
		if (users.size() == 0) {
			Admin a = new Admin("Chris Roberts", "admin", "admin", 20, "5'7", 140 , "Chris da goat", "6 and O");
			Filer.save(a, "hoopers.ser");
		}
		
		System.out.println("Hoop Central ---------------------------------");
		System.out.println("Welcome to Hoop Central! Providing you with all of your Hoop data! ");

		//Admin myAdmin = new Admin();
		Authentication auth = new Authentication();
		User user = auth.welcome();
		user.mainMenu();
		
	}
}
