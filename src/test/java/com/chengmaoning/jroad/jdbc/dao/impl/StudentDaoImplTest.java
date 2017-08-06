/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.chengmaoning.jroad.jdbc.dao.StudentDao;
import com.chengmaoning.jroad.jdbc.dataobject.Student;

/**
 * @author chengmaoning
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional(value = "txManager")
public class StudentDaoImplTest {

	@Autowired
	StudentDao studentDao;

	/**
	 * Test method for
	 * {@link com.chengmaoning.jroad.jdbc.dao.impl.StudentDaoImpl#findAllStudents()}.
	 */
	@Test
	public void testFindAllStudents() {
		List<Student> students = studentDao.findAllStudents();
		System.out.println(students);
		Assert.isTrue(true, null);
	}

	@Test
	public void testFindById() {
		Student student = studentDao.findById(8);
		System.out.println(student);
	}

}
