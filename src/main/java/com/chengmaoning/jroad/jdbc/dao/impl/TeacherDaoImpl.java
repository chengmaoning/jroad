/**
 * 
 */
package com.chengmaoning.jroad.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.chengmaoning.jroad.jdbc.dao.TeacherDao;
import com.chengmaoning.jroad.jdbc.dataobject.Teacher;

/**
 * @author chengmaoning
 *
 */

@Repository
public class TeacherDaoImpl implements TeacherDao {

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

	@Override
	public long insert(Teacher teacher) {

		String sql = "insert into teacher (name, age, sex) values (:name,:age,:sex)";

		SqlParameterSource paramSource = new MapSqlParameterSource("name", teacher.getName())
				.addValue("age", Integer.valueOf(teacher.getAge())).addValue("sex", teacher.getSex());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(sql, paramSource, keyHolder);

		return keyHolder.getKey().intValue();
	}

}
