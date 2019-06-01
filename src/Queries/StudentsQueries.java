package Queries;

public class StudentsQueries {
	public static final String insertStudent="insert into Student (name, age) values (?, ?)";
	public static final String selectStudent="select * from Student where id = ?";
	public static final String getListofStudent="select * from Student";
	public static final String removeStudent="delete from Student where id = ?";
	public static final String updateStudent="update Student set age = ? where id = ?";
}
