import java.util.Scanner;
import java.util.ArrayList;

public class Authentication {

	public User welcome(){
		Scanner input = new Scanner(System.in); 
		ArrayList<Object> check = Filer.loadList("list.ser");
		
		System.out.println("Have you played at a Hoop session since 4/16/24? 1- Yes, 2 - No)");
		int played = input.nextInt();
		if (played == (1)) {
			System.out.println("1 - login\n2 - sign up");
			input.nextLine();
			if (input.nextLine().equals("1")) {
				return hooperLogin();
			} else {
				return hooperSignup();
			}
		} else {
			System.out.println("Enter your name like the following 'Chris Roberts': ");
			input.nextLine();
			String name = input.nextLine();
			System.out.println("loging in as Guest ...");
			return new Guest(name);
		}
	}	

	public User hooperLogin() {
		System.out.println("Hooper login---------------------------------");
		System.out.println("Enter your name like the following'Chris Roberts': ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("Enter your username: ");
		String username = input.nextLine();
		System.out.println("Enter your password: ");
		String password = input.nextLine();
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		for (Object o : check) {
			User t = (User) o;
			if (username.equals(t.getUsername()) && password.equals(t.getPassword())) {
				System.out.println("Login successful!");
				return t;
			}
		}
		System.out.println("Login failed. Please try again.");
		return hooperLogin();
	}

	public User hooperSignup(){
		System.out.println("Hooper Signup---------------------------------");
		System.out.println("Enter your name like the following'Chris Roberts': ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		ArrayList<Object> check1 = Filer.loadList("list.ser");
		boolean found = false;
		for (Object o: check1){
			User t = (User) o;
			if (name.equals(t.getName())) {
				found = true;
			}
		}
		if (!found) {
			System.out.println("You are not on the list. Signing up as Guest . . .");
			return new Guest(name);
		}
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		for (Object o: check){
			User t = (User) o;
			if (name.equals(t.getName())) {
				System.out.println("Name already in use. Please try again");
				return hooperSignup();
			}
		}
		System.out.println("Enter your username: ");
		String username = input.nextLine();
		for (Object o : check) {
			User t = (User) o;
			if (username.equals(t.getUsername())) {
				System.out.println("Username already in use. Please try again");
				return hooperSignup();
			}
		}
		System.out.println("Enter your password: ");
		String password = input.nextLine();
		System.out.println("Enter your age: ");
		int age = input.nextInt();
		System.out.println("Enter your height, for example ' 5'7' : ");
		input.nextLine();
		String height = input.nextLine();
		System.out.println("Enter your weight in pounds (or don't, up to you): ");
		int weight = input.nextInt();
		System.out.println("Enter your nickname: ");
		input.nextLine();
		String nickname = input.nextLine();
		System.out.println("Enter your bio, keepn it short though: ");
		String bio = input.nextLine();
		Hooper h = new Hooper(name, username, password, age, height, weight, nickname, bio);
		Filer.save(h, "hoopers.ser");
		System.out.println("Hooper added successfully!");
		return h;
	}
}