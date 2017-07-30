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
import org.springframework.util.Assert;

/**
 * @author chengmaoning
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class JdbcStudentDaoTest {

	@Autowired
	StudentDao studentDao;

	/**
	 * Test method for
	 * {@link com.chengmaoning.jroad.jdbc.JdbcStudentDao#findAllStudents()}.
	 */
	@Test
	public void testFindAllStudents() {
		List<Student> students = studentDao.findAllStudents();
		System.out.println(students);
		Assert.isTrue(true, null);
	}

}
