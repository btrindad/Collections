package fav_classes;
import java.util.*;

/*
 * Changing the implementation to TreeMap organized the entries alphabetically
 * by Key. Since the Keys are Strings, it uses the String class comparable implementation
 * to organize them alphabetically. The really cool thing is that I only had to change the
 * constructor. I didn't have to change any of the other functions in order to switch the
 * type of map.
 */

/*
 * When I ran the code using Map in place of Tree map I got the following error:
 * 	Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
 *	Cannot instantiate the type Map<String,String>
 *
 *	at fav_classes.Students.<init>(Students.java:20)
 *	at fav_classes.Students.main(Students.java:37)
 *
 * This error occurs because Map is	in interface, not a class. You can't instantiate
 * an interface, you can only make classes to implement them. TreeMap and HashMap are
 * classes that implement the map interface differently for different results
 */

public class Students {
	private Map<String, String> studentInfo;

	public Students(){
		studentInfo = new HashMap<String, String>();
		//studentInfo = new TreeMap<String, String>();
		//studentInfo = new Map<String, String>();
	}

	public void add(String student_name, String fav_class){
		studentInfo.put(student_name, fav_class);
	}

	public void printStudentInfo(){
		/*Set<String> student_names = studentInfo.keySet();
		for (String name : student_names){
			System.out.println(name + " likes " + studentInfo.get(name));
		}
		*/
		
		/*
		 * Using the values function of the Map interface returns only the values of the
		 * Map implementation. It sorts the values based on the keys put the values()
		 * function returns a collection of just the values without their keys.
		 * Iterating over the returned collection of Strings prints out all of the
		 * favorite classes inserted. Also the favorite classes can be duplicates,
		 * only the keys must be unique therefore the returned collection may include
		 * duplicates if more than one student has the same favorite class
		 */
		
		Collection<String> val = studentInfo.values();
		for (String value : val){
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		String studentName = new String();
		String fav_class = new String();
		Students class_list = new Students();
		Scanner scn = new Scanner(System.in);

		while(true){
			System.out.println("Please enter the Student's name or 'Q' to quit:");
			studentName = scn.nextLine();

			if(studentName.toUpperCase().contentEquals("Q")){
				System.out.println("Quitting...");
				break;
			}
			else{

				System.out.println("Please enter the student's favorite class:");
				fav_class = scn.nextLine();

				class_list.add(studentName, fav_class);
			}
		}

		class_list.printStudentInfo();

	}

}
