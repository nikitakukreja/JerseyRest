package net.codejava.ws;

public class Student {
	private int no;
	private String name;
	private int DOB;
	private int DOJ;
	public Student() {
		
	
		// TODO Auto-generated constructor stub
	}
	
	public Student(int no) {
		this.no = no;
	}

	public Student(int no, String name, int dOB, int dOJ) {
		
		this.no = no;
		this.name = name;
		DOB = dOB;
		DOJ = dOJ;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDOB() {
		return DOB;
	}
	public void setDOB(int dOB) {
		DOB = dOB;
	}
	public int getDOJ() {
		return DOJ;
	}
	public void setDOJ(int dOJ) {
		DOJ = dOJ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (no != other.no)
			return false;
		return true;
	}
	
	

}
