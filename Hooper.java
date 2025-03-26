import java.util.ArrayList;
import java.util.Scanner;

import java.io.Serializable;

public class Hooper extends User {
	private int age;
	private String height;
	private int weight;
	private String nickname;
	private String bio;
	private int wins;
	private int losses;
	/*
	methods:personal data (that they can edited) and game data
	 - myCareer(): shows the all-time win/loss record 
	 - Standing():Shows all hoopers, type in a name and get there personal data to view
	 - gameLog():Shows all the dates, type in a date, each date shows the games that were played and the winners/loser of each
	 - viewHoopers():
	  */
	
	//constructer
	public Hooper(String name, String username, String password){
		super(name, username, password);
	}

	public Hooper(String name){
		super(name, "", "");
	}

	public Hooper(String name, String username, String password,int age, String height, int weight, String nickname, String bio){
		super(name, username, password);
		this.age = age;	
		this.height = height;
		this.weight = weight;
		this.nickname = nickname;
		this.bio = bio;
	}

	//getters
	public int getAge(){
		return age;
	}

	public String getHeight(){
		return height;
	}

	public int getWeight(){
		return weight;
	}

	public String getNickname(){
		return nickname;
	}

	public String getBio(){
		return bio;
	}

	public int getWins(){
		return wins;
	}

	public int getLosses(){
		return losses;
	}
	
	public void setWins(int wins){
		this.wins = wins;
	}

	public void setLosses(int losses){
		this.losses = losses;
	}

	//setters
	public void setAge(int age){
		this.age = age;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public void setBio(String bio){
		this.bio = bio;
	}


	public void mainMenu(){
		System.out.println("Welcome " + name + "!");
		System.out.println("Hooper Main menu---------------------------------");
		System.out.println("1 - mycareer\n2 - edit personal data\n3 - gamelog\n4 - standings\n5 - view Hoopers\n6 - Logout");
		Scanner selection = new Scanner(System.in);
		int choice = selection.nextInt();
		switch(choice){
			case 1:
				myCareer();
				break;
			case 2:
				editPersonalData();
				break;
			case 3:
				gameLog();
				break;
			case 4:
				Standing();
				break;
			case 5:
				viewHoopers();
				break;
			case 6:
				logout();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
		}
	}

	public void myCareer() {
		System.out.println("myCareer of : " + name + "---------------------------------");
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper && t.getName().equals(name)) {
				Hooper s = (Hooper) t;
				System.out.println("name: " + t.getName()+"\n"+ "nickname :"+ s.getNickname() + "\n" + "age: " + s.getAge() + "\n" + "height: " + s.getHeight() + "\n" + "weight: " + s.getWeight() + "\n" + "bio: " + s.getBio() + "\n");
			}
		}
	mainMenu();
	}

	public static void editPersonalData(){
		System.out.println("Edit personal data---------------------------------");
		System.out.println("1 - Edit age\n2 - Edit height\n3 - Edit weight\n4 - Edit nickname\n5 - Edit bio\n6 - Exit");
		System.out.println("under construction");
		// Scanner selection = new Scanner(System.in);
		// int choice = selection.nextInt();
		// switch(choice){
		// 	case 1:
		// 		editAge();
		// 		break;
		// 	case 2:
		// 		editHeight();
		// 		break;
		// 	case 3:
		// 		editWeight();
		// 		break;
		// 	case 4:
		// 		editNickname();
		// 		break;
		// 	case 5:
		// 		editBio();
		// 		break;
		// 	case 6:
		// 		break;
		// 	default:
		// 		System.out.println("Invalid choice. Please try again.");
		// 		break;
		// }
	}

	public void Standing() {
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
			System.out.println((i+1) + ".) " + h.getName()+" |Wins: "+ h.getWins() + " |Losses: "+h.getLosses() + " |Win/Loss: " + winLoss + "%");
		}
	mainMenu();
	}

	public void gameLog() {
		System.out.println("gameLog---------------------------------");
		System.out.println("underscontruction");
		mainMenu();
	}

	public void viewHoopers() {
		System.out.println("viewHoopers---------------------------------");
		ArrayList<Object> check = Filer.loadList("hoopers.ser");
		for (Object o : check) {
			User t = (User) o;
			if (t instanceof Hooper) {
				Hooper s = (Hooper) t;
				System.out.println(t.getName()+ ": " + s.getNickname());
			}
		}
	mainMenu();
	}

	public void logout(){
		System.out.println("Logging out...");
	}
}

	 

