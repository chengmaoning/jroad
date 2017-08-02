/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.util.List;

/**
 * @author chengmaoning
 *
 */
public interface TeacherDao {

	List<Teacher> findByNameAndAge(String name,int age);
}
