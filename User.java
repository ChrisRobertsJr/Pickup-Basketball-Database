import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public abstract class User implements Serializable{
	protected String name;
	protected String username;
	protected String password;


	public User() {
        // You can initialize default values here if needed
        this.name = "";
        this.username = "";
        this.password = "";
    }
	//constructer
	public User(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}

	//getters
	public String getName(){
		return name;
	}
	//getters
	public String getUsername(){
		return username;
	}
	//getters
	public String getPassword(){
		return password;
	}

	public abstract void mainMenu();

	public boolean Equals(Object o){
		if (o instanceof User){
			User u = (User) o;
			if (u.getName().equals(this.name) && u.getUsername().equals(this.username) && u.getPassword().equals(this.password)){
				return true;
			}
		}
		return false;
	}

}
