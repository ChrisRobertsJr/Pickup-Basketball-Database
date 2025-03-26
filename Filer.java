import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
/*
 * Files:
 * 	1. hoopers.dat
 * - name, height, age, weight, nickname, bio
 * 	2. gamelog.dat
 * - date of game, players, winner, loser, score
 * 	3. stats(NOT IMPOrtaNT)
 * - their name w/ their stats
 * 4. list.dat
 * - name
 * 
 */

public class Filer {
	public static void saveList(ArrayList<Object> list, String fileName) {
		try { 
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(list);

			out.close();
		} catch (Exception e) {
			System.out.println("SAVE error");
		}
	}
	public static void delete(Object o, String fileName) {
		try { 
			ArrayList<Object> list = loadList(fileName);
			list.remove(o);

			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(list);

			out.close();
		} catch (Exception e) {
			System.out.println("DELETE error");
		}
	}
	
	
	public static void save(Object o, String fileName) {
		try { 
			ArrayList<Object> list = loadList(fileName);
			list.add(o);

			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(list);

			out.close();
		} catch (Exception e) {
			System.out.println("SAVE error");
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Object> loadList (String fileName) {
		ArrayList<Object> users = new ArrayList<Object>();
		try{
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			users = (ArrayList<Object>)in.readObject();

			in.close();
			file.close();
			return users;
		} catch (Exception e) {

			return users;
		}	
	}
}
