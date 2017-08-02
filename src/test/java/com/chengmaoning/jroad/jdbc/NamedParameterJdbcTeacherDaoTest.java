/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengmaoning
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class NamedParameterJdbcTeacherDaoTest {

	@Autowired
	TeacherDao teacherDao;

	/**
	 * Test method for
	 * {@link com.chengmaoning.jroad.jdbc.NamedParameterJdbcTeacherDao#findByNameAndAge(java.lang.String, int)}.
	 */
	@Test
	public void testFindByNameAndAge() {

		String name = "Hanmeimei";
		int age = 28;

		List<Teacher> teachers = teacherDao.findByNameAndAge(name, age);

		System.out.println(teachers);

	}

	@Test
	public void testInsert() {
		Teacher teacher = new Teacher();
		teacher.setAge(30);
		teacher.setName("Jack");
		teacher.setSex("male");

		long id = teacherDao.insert(teacher);

		System.out.println("id: " + id);
	}

}
