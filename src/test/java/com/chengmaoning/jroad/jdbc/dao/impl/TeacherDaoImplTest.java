/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.chengmaoning.jroad.jdbc.dao.TeacherDao;
import com.chengmaoning.jroad.jdbc.dataobject.Teacher;

/**
 * @author chengmaoning
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional(value = "txManager")
public class TeacherDaoImplTest {

	@Autowired
	TeacherDao teacherDao;

	/**
	 * Test method for
	 * {@link com.chengmaoning.jroad.jdbc.dao.impl.TeacherDaoImpl#findByNameAndAge(java.lang.String, int)}.
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
