import java.util.ArrayList;
import java.util.Scanner;

import java.io.Serializable;
import java.lang.reflect.Array;

public class Admin extends Hooper{
	private int age;
	private String height;
	private int weight;
	private String nickname;
	private String bio;
	private int wins;
	private int losses;
	
	/*
	 * This is the admin class where they can:
	 * 1. view all general data and game data of a player
	 * 2. edit a players general data
	 * 3. update game data of a player, games, and 
	 * 4. delete a player
	 * 5. allow people to sign up 
	 * - add people to the list of potenial players that can sign up
	 *
	 * methods:
	 - myCareer(): shows the all-time win/loss record 
	 - Standing():Shows all hoopers, type in a name and get there personal data to view
	 - gameLog():Shows all the dates, type in a date, each date shows the games that were played and the winners/loser of each
	 - viewHoopers():
	 - addHooper(): add a hooper to the list of potential players
	 - deleteHooper(): delete a hooper from the list of potential players
	 - editGameLog(): edit the game log
	 - editStandings(): edit the standings

	 */

	public Admin(String name, String username, String password){
		super(name, username, password);
	}

	public Admin(String name, String username, String password,int age, String height, int weight, String nickname, String bio){
		super(name, username, password, age, height, weight, nickname, bio);
	}

	public void mainMenu(){
		System.out.println("Welcome " + name + "!");
		System.out.println("Admin Main menu---------------------------------");
		System.out.println("1 - myCareer\n2 - gamelog\n3 - edit games\n4 - standings\n5 - edit standings\n6 - view Hoopers\n7 - add Hooper\n8 - delete Hooper\n9 - Logout");
		Scanner selection = new Scanner(System.in);
		int choice = selection.nextInt();
		switch(choice){
			case 1:
				myCareer();
				break;
			case 2:
				gameLog();
				break;
			case 3:
				editGameLog();
				break;
			case 4:
				Standing();
				break;
			case 5:
				editStandings();
				break;
			case 6:
				viewHoopers();
				break;
			case 7:
				addHooper();
				break;
			case 8:
				deleteHooper();
				break;
			case 9:
				logout();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
	}

	public void addHooper() {
		System.out.println("addHooper---------------------------------");
		Scanner	input = new Scanner(System.in);	
		ArrayList<Object> check = Filer.loadList("list.ser");
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				System.out.println(t.getName());
			}
		}

		System.out.println("Enter the name of the player you would like to add: ");
		String name = input.nextLine();
		Hooper s = new Hooper(name);
		System.out.println("Confirm Hooper details: ");
		System.out.println("Name: "+s.getName());
		System.out.println("1 - Confirm\n2 - Cancel");
		int choice = input.nextInt();
		if (choice == 2) {
			System.out.println("Hooper addition cancelled.");
			mainMenu();
			}
		Filer.save(s, "list.ser");
		System.out.println("Hooper added successfully.");
		mainMenu();
	}

	public void deleteHooper() {
		System.out.println("deleteHooper---------------------------------");
		Scanner	input = new Scanner(System.in);
		ArrayList<Object> check = Filer.loadList("list.ser");
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				System.out.println(t.getName());
			}
		}
		System.out.println("Enter the name of the player you would like to delete: ");
		String name = input.nextLine();
		Hooper s = new Hooper(name);
		System.out.println("Confirm Hooper details: ");
		System.out.println("Name: "+s.getName());
		System.out.println("1 - Confirm\n2 - Cancel");
		int choice = input.nextInt();
		if (choice == 2) {
			System.out.println("Hooper deletion cancelled.");
			mainMenu();
			return;
			}
		Filer.delete(s, "list.ser");
		Filer.delete(s, "hoopers.ser");
		System.out.println("Hooper deleted successfully.");
		mainMenu();
	}

	public void editGameLog() {
		System.out.println("editGameLog---------------------------------");
	}

	public void editStandings() {
		System.out.println("editStandings---------------------------------");
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		System.out.println("Enter the name of the player you would like to edit: ");
		Scanner	input = new Scanner(System.in);
		String name = input.nextLine();
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				if (name.equals(t.getName())) {
					System.out.println("Enter the new wins: ");
					int wins = input.nextInt();
					System.out.println("Enter the new losses: ");
					int losses = input.nextInt();
					s.setWins(wins);
					s.setLosses(losses);
					System.out.println("confirm win/loss record: ");
					double winLoss = (double) s.getWins() / (s.getWins() + s.getLosses());
					System.out.println("Name: "+s.getName()+"\n"+"Wins: "+s.getWins()+"\n"+"Losses: "+s.getLosses() + "\n" + "Win/Loss: " + winLoss);
					System.out.println("1 - Confirm\n2 - Cancel");
					int choice = input.nextInt();
					if (choice == 2) {
						System.out.println("Win/loss record update cancelled.");
						mainMenu();
					}
					Filer.delete(s, "hoopers.ser");
					Filer.save(s, "hoopers.ser");
					System.out.println("Win/loss record updated successfully.");
					break;
				}
			}
			System.out.println("Player not found.");
			editStandings();
		}
	mainMenu();
	}

}
