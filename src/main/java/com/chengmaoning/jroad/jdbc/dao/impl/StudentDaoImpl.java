/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chengmaoning.jroad.jdbc.dao.StudentDao;
import com.chengmaoning.jroad.jdbc.dataobject.Student;

/**
 * @author chengmaoning
 *
 */

@Repository
public class StudentDaoImpl implements StudentDao {

	// JdbcTemplate 不支持批量插入并批量返回id列表
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> findAllStudents() {

		List<Student> students = jdbcTemplate.query("select * from student", new StudentRowMapper());

		return students;
	}

	@Override
	public Student findById(long id) {
		Student student = jdbcTemplate.queryForObject("select * from student where id=?", new Object[] { id },
				new StudentRowMapper());
		return student;
	}

	private static class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setAddress(rs.getString("address"));
			student.setAge(rs.getInt("age"));
			student.setId(rs.getLong("id"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getLong("phone"));
			student.setTeacherId(rs.getLong("teacherId"));
			return student;
		}

	}

	@Override
	public int[] batchUpdate(List<Student> students) {
		int[] counts = jdbcTemplate.batchUpdate("update student set name=? where id=?",
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, students.get(i).getName());
						ps.setLong(2, students.get(i).getId());
					}

					@Override
					public int getBatchSize() {
						return students.size();
					}
				});
		return counts;
	}

}
