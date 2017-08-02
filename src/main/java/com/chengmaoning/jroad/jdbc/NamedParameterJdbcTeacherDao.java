/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * @author chengmaoning
 *
 */

@Repository
public class NamedParameterJdbcTeacherDao implements TeacherDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Teacher> findByNameAndAge(String name, int age) {

		String sql = "select * from teacher where name=:name and age=:age";

		SqlParameterSource paramSource = new MapSqlParameterSource("name", name).addValue("age", age);

		List<Teacher> teachers = namedParameterJdbcTemplate.query(sql, paramSource, new RowMapper<Teacher>() {

			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher teacher = new Teacher();
				teacher.setAge(rs.getInt("age"));
				teacher.setId(rs.getLong("id"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getString("sex"));
				return teacher;
			}
		});

		return teachers;
	}

}