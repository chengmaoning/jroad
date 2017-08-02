package com.chengmaoning.jroad.jdbc;

import java.util.List;

public interface StudentDao {

	List<Student> findAllStudents();
	
	Student findById(long id);

}
