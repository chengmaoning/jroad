/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
@Transactional(value = "txManager", rollbackFor = { Exception.class })
@Rollback(true)
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

	@Test
	public void testBatchUpdate() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			Student student = new Student();
			student.setName("student_" + i);
			student.setId(8 + i);
			students.add(student);
		}
		int[] updateCounts = studentDao.batchUpdate(students);
		System.out.println(updateCounts[0] + ", " + updateCounts[1]);
	}

	@Test
	public void testBatchInsert() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			Student student = new Student();
			student.setName("student_" + i);
			student.setId(8 + i);
			students.add(student);
		}
		List<Long> ids = studentDao.batchInsert(students);
		System.out.println(ids);
	}
}
