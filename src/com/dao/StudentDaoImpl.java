package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mapper.StudentMapper;
import com.model.Student;

import Queries.StudentsQueries;

public class StudentDaoImpl implements StudentDao {
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	@Override
	public void create(String name, Integer age) {
		jdbcTemplateObject.update(StudentsQueries.insertStudent,name,age);
		System.out.println("Created Record Name"+name+" "+age);
		return;
	}
	@Override
	public Student getStudent(Integer id) {
	Student student=jdbcTemplateObject.queryForObject(StudentsQueries.selectStudent,new Object[]{id},new StudentMapper());
	return student;
	}
	@Override
	public List<Student> listStudents() {
	List<Student> students=jdbcTemplateObject.query(StudentsQueries.getListofStudent,new StudentMapper());
		return students;
	}
	@Override
	public void delete(Integer id) {
		jdbcTemplateObject.update(StudentsQueries.removeStudent,id);
		System.out.println("Deleted Record id : "+id);
	}
	@Override
	public void update(Integer id, Integer age) {
		jdbcTemplateObject.update(StudentsQueries.updateStudent,age,id);
		System.out.println("Updated Record id : "+id);
	}
	
	   
	   
}
