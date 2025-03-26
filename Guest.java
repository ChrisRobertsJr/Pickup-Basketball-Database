import java.util.ArrayList;
import java.util.Scanner;

import java.io.Serializable;

public class Guest extends User{
	//constructer
	public Guest(String name){
		super(name, "", "");
	}

	public void mainMenu(){
		System.out.println("Welcome " + name + "!");
		System.out.println("Guest Main menu---------------------------------");
		System.out.println("1 - Gamelogs\n2 - Standings\n3 - view Hoopers\n4 - Logout");
		Scanner selection = new Scanner(System.in);
		int choice = selection.nextInt();
		switch(choice){
			case 1:
				gameLog();
				break;
			case 2:
				standing();
				break;
			case 3:
				viewHoopers();
				break;
			case 4:
				logout();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
	}

	public void standing() {
		System.out.println("Standing---------------------------------");
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		ArrayList<Hooper> hoopers = new ArrayList<Hooper>();
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				hoopers.add(s);
			}
		}
		hoopers.sort((Hooper h1, Hooper h2) -> {
			if (h1.getWins() < h2.getWins()) {
				return 1;
			} else if (h1.getWins() > h2.getWins()) {
				return -1;
			} else {
				return 0;
			}
		});
		for (int i = 0; i < hoopers.size(); i++){
			Hooper h = hoopers.get(i);
			double winLoss = 100*((double) h.getWins() / (h.getWins() + h.getLosses()));
			winLoss = Math.round(winLoss * 100.0) / 100.0;
			if (h.getLosses() == 0) {
				winLoss = 1.0;
			}
			if (h.getWins() + h.getLosses() == 0) {
				winLoss = 0.0;
			}
			System.out.println((i+1) + ".) " + h.getName()+" |Wins: "+ h.getWins() + " |Losses: "+h.getLosses() + " |Win/Loss: " + winLoss+ "%");
		}
	mainMenu();
	}

	public static void gameLog() {
		System.out.println("gameLog---------------------------------");
		System.out.println("underscontruction");
	}

	public static void viewHoopers() {
		System.out.println("viewHoopers---------------------------------");
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				System.out.println(t.getName());
			}
		}
	}

	public static void logout(){
		System.out.println("Logging out...");
	}	
	
}
