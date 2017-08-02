/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author chengmaoning
 *
 */

@Repository
public class JdbcStudentDao implements StudentDao {

	private JdbcTemplate jdbcTemplate;


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public List<Student> findAllStudents() {

		List<Student> students = jdbcTemplate.query("select * from student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int age = rs.getInt("age");
				long phone = rs.getLong("phone");
				Student student = new Student();
				student.setAddress(address);
				student.setAge(age);
				student.setId(id);
				student.setName(name);
				student.setPhone(phone);
				student.setTeacherId(rs.getLong("teacherId"));
				return student;
			}
		});

		return students;
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
