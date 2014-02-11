package fav_classes;
import java.util.*;

public class Students {
	private Map<String, String> studentInfo;

	public Students(){
		studentInfo = new HashMap<String, String>();
	}

	public void add(String student_name, String fav_class){
		studentInfo.put(student_name, fav_class);
	}

	public void printStudentInfo(){
		Set<String> student_names = studentInfo.keySet();
		for (String name : student_names){
			System.out.println(name + " likes " + studentInfo.get(name));
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
