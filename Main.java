import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		
		StudentArrayOperation studentGroup = new StudentGroup(0);
		
		System.out.println("studentGroup.getStudents() " + Arrays.toString(studentGroup.getStudents()));
		
		studentGroup.addFirst(new Student(1, "test full name", new Date(2012-1900, 1,2), 50));
		studentGroup.addFirst(new Student(2, "test full name2", new Date(2013-1900, 1,1), 60));
		studentGroup.addFirst(new Student(3, "test full name3", new Date(2013-1900, 1,1), 60));
		studentGroup.addLast(new Student(4, "test full name4", new Date(2012-1900, 1,1), 70));
		studentGroup.add(new Student(5, "test full name5", new Date(2014-1900, 1,1), 65), 0);
		studentGroup.add(new Student(6, "test full name6", new Date(2014-1900, 1,1), 65), 1);
		
		//studentGroup.remove(2);
		//studentGroup.removeFromIndex(2);
		//studentGroup.removeFromElement(new Student(6, "test full name6", new Date(2012, 1,1), 65));
		studentGroup.bubbleSort();
		//studentGroup.getByBirthDate(new Date(2013, 1,1));
		//studentGroup.getBetweenBirthDates(new Date(2010, 1,1), new Date(2013, 1,1));

		System.out.println("studentGroup.getStudents() " + Arrays.toString(studentGroup.getStudents()));
		System.out.println("studentGroup.getStudents() " + studentGroup.getStudents().length);
		System.out.println("studentGroup by brith date" + Arrays.toString(studentGroup.getByBirthDate(new Date(2013-1900, 1,1))));
		System.out.println("studentGroup between brith date" + Arrays.toString(studentGroup.getBetweenBirthDates(new Date(2010-1900, 1,1), new Date(2013-1900, 1,1))));
		System.out.println("studentGroup near brith date" + Arrays.toString(studentGroup.getNearBirthDate(new Date(2012-1900, 1,1), 1)));
		System.out.println("studentGroup current age , " + studentGroup.getCurrentAgeByDate(1));
		System.out.println("next student " + studentGroup.getNextStudent(new Student(5, "test full name5", new Date(2014-1900, 1,1), 65)));
		
		
	}

}
