package entity;

public class author {
	private int AuthorID;
	private String Name;
	private int Age;
	private String Country;
	
	
	@Override
	public String toString() {
		return "author [AuthorID=" + AuthorID + ", Name=" + Name + ", Age="
				+ Age + ", Country=" + Country + "]";
	}

	public author(){
		
	}
	
	public author(int authorID, String name, int age, String country) {
		//super();
		AuthorID = authorID;
		Name = name;
		Age = age;
		Country = country;
	}

	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public void add(){
		
	}
}
