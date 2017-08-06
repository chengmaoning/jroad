/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao;

import java.util.List;

import com.chengmaoning.jroad.jdbc.dataobject.Teacher;

/**
 * @author chengmaoning
 *
 */
public interface TeacherDao {

	/**
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	List<Teacher> findByNameAndAge(String name, int age);

	
	/**
	 * 
	 * @param teacher
	 * @return
	 */
	long insert(Teacher teacher);
	
}
