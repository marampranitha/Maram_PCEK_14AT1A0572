import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	//private LinkedList<Student> studentsLinkedList = null;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		
		if(null == students)
			throw new IllegalArgumentException("Students null");
		
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index <0 || index >= students.length) {
			throw new IllegalArgumentException("Index Out of range");
		}
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}
		
		if(index <0 || index >= students.length) {
			throw new IllegalArgumentException("Index Out of range");
		}
		this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}
		
		Student[] students = new Student[this.students.length + 1];
		students[0] = student;
		for(int i=0; i < this.students.length; i++) {
			students[i+1] = this.students[i];
		}
		
		this.students = students;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}
		
		Student[] students = new Student[this.students.length + 1];
		for(int i=0; i < this.students.length; i++) {
			students[i] = this.students[i];
		}
		
		//Adding last element.
		students[this.students.length] = student;
		this.students = students;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}
		
		if(index <0 || index >= students.length) {
			throw new IllegalArgumentException("Index Out of range");
		}
		
		Student[] students = new Student[this.students.length + 1];
		for(int i=0; i < index; i++) {
			students[i] = this.students[i];
		}

		students[index] = student;
		
		for(int i=index; i < this.students.length; i++) {
			students[i+1] = this.students[i];
		}
		this.students = students;
	}

	@Override
	public void remove(int index) {
		if(index <0 || index >= students.length) {
			throw new IllegalArgumentException("Index Out of range");
		}

		
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(this.students));
		list.remove(index);
		
		Student []array = new Student[list.size()];
		this.students = list.toArray(array);
	}

	@Override
	public void remove(Student student) {
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}
		
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(this.students));
		list.remove(student);
		
		Student []array = new Student[list.size()];
		this.students = list.toArray(array);
	}

	@Override
	public void removeFromIndex(int index) {
		if(index <0 || index >= students.length) {
			throw new IllegalArgumentException("Index Out of range");
		}
		
		ArrayList<Student> list = new ArrayList<Student>(index+1);
		
		for(int i=0 ; i <= index; i++) {
			list.add(this.students[i]);
		}
		
		Student []array = new Student[list.size()];
		this.students = list.toArray(array);

	}

	@Override
	public void removeFromElement(Student student) {
		if(student == null) {
			throw new IllegalArgumentException("Student to be set is null");
		}

		int matchIndex = -1;
		for(int i=0 ; i < this.students.length; i++) {
			if(student.equals(this.students[i])) {
				matchIndex = i;
				break;
			}
		}
		
		if(matchIndex != -1)
			this.removeFromIndex(matchIndex);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {

        int n = this.students.length;  
        Student temp = null;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(this.students[j-1].compareTo(this.students[j]) > 0){  
                                 //swap elements  
                                 temp = this.students[j-1];  
                                 this.students[j-1] = this.students[j];  
                                 this.students[j] = temp;  
                         }  
                          
                 }  
         }       

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		
		if(date == null)
			throw new IllegalArgumentException("input date is null");
		
		LinkedList<Student> list = new LinkedList<Student>();
		
		for(int i=0; i < this.students.length; i++) {
			if(date.equals(this.students[i].getBirthDate())) {
				list.add(this.students[i]);
			}
		}
		
		Student []array = new Student[list.size()];
		return list.toArray(array);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		
		if(firstDate == null)
			throw new IllegalArgumentException("firstDate is null");

		if(lastDate == null)
			throw new IllegalArgumentException("lastDate is null");
		
		LinkedList<Student> list = new LinkedList<Student>();
		
		for(int i=0; i < this.students.length; i++) {
			if(this.students[i].getBirthDate().compareTo(firstDate) >= 0 && this.students[i].getBirthDate().compareTo(lastDate) <= 0) {
				list.add(this.students[i]);
			}
		}
		
		Student []array = new Student[list.size()];
		return list.toArray(array);
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date == null)
			throw new IllegalArgumentException("date is null");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(date); // Now use today date.
		c.add(Calendar.DATE, days); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);

		LinkedList<Student> list = new LinkedList<Student>();

		for(int i=0; i < this.students.length; i++) {
			if(date.equals(this.students[i].getBirthDate()) || this.students[i].getBirthDate().equals(new Date(c.getTimeInMillis()))) {
				list.add(this.students[i]);
			}
		}
		
		Student []array = new Student[list.size()];
		return list.toArray(array);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		
		if(indexOfStudent == 0)
			throw new IllegalArgumentException("index of student null");
		
		
		Student student = this.students[indexOfStudent];
		
		Date current = new Date();
		Date dbo = student.getBirthDate();
		
	    Calendar a = getCalendar(dbo);
	    Calendar b = getCalendar(current);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
	        diff--;
	    }
	    return diff;

	}

	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}    
	    
	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		if(student == null)
			throw new IllegalArgumentException("Student is null");
		
		for(int i=0; i < this.students.length-1; i++) {
			
			if(this.students[i].equals(student)) {
				return this.students[i+1];
				
			}
		}
		return null;
	}
}
