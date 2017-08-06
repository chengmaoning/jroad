package com.chengmaoning.jroad.jdbc.dao;

import java.util.List;

import com.chengmaoning.jroad.jdbc.dataobject.Student;

public interface StudentDao {

	List<Student> findAllStudents();

	Student findById(long id);

	/**
	 * 
	 * @param students
	 * @return
	 */
	int[] batchUpdate(List<Student> students);

}
