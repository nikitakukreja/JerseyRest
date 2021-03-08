package net.codejava.ws;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	private static StudentDAO instance;
	private static List<Student>data=new ArrayList<>();
	
	static {
		data.add(new Student(1,"Ellina",12-10-1992,10-01-2020));
		data.add(new Student(2,"Aiyna",22-11-1993,11-11-2020));
		data.add(new Student(3,"Emma",19-03-1994,02-10-2020));
		data.add(new Student(4,"Kia",25-10-1995,10-01-2021));
		data.add(new Student(5,"Toral",21-01-1996,12-02-2021));
	}
	
	private StudentDAO() { }
	
	public static StudentDAO getInstance() {
		
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	public List<Student>listAll(){
		return new ArrayList<Student>(data);
	}
	
	public int add(Student student) {
		int newNo = data.size() + 1;
		student.setNo(newNo);
		data.add(student);
		
		return newNo;
	}
	
	public Student get(int no) {
		Student studentToFind = new Student(no);
		
		int index =data.indexOf(studentToFind);
		
		if(index >= 0) {
			return data.get(index);
		}
		return null;
	}
	
	public boolean update(Student student) {
		int index = data.indexOf(student);
		
		if(index >= 0) {
			data.set(index, student);
			
			return true;
		}
		return false;
	}
	
	public boolean delete(int no) {
		Student studentToFind = new Student(no);
		int index = data.indexOf(studentToFind);
		
		if (index >= 0) {
			data.remove(index);
			return true;
		}
		return false;
	}

}
