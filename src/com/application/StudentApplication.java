package com.application;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.Student;

public class StudentApplication {
public static void main(String[] args) {
	
	ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
	StudentDao eDao=(StudentDao)ctx.getBean("edao");
	//inserting
	eDao.create("Mayur", 25);
	eDao.create("Vinay", 25);
	
	//retrieve 1 object
	Student stud=eDao.getStudent(1);
	System.out.println("one Record:"+stud.getName());
	//retrieve all object
	System.out.println("Multiple Records");
	ArrayList<Student> stud1=(ArrayList<Student>)eDao.listStudents();
	for(Student s:stud1)
	{
		System.out.println(s.getId()+" "+s.getName()+" "+s.getAge());
	}
	
	//update record
	eDao.update(1, 24);
	
}
}
