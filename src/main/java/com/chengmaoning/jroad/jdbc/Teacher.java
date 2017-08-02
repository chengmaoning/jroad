/**
 * 
 */
package com.chengmaoning.jroad.jdbc;

/**
 * @author chengmaoning
 *
 */
public class Teacher {

	private long id;

	private String name;

	private int age;

	private String sex;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
