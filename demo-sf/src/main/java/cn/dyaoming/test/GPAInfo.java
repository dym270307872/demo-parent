package cn.dyaoming.test;


import java.util.List;


class GPAInfo {
	private String			name;
	private List<Course>	courseInfo;
	private String			gpa;



	public String getName() {
		return this.name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Course> getCourseInfo() {
		return this.courseInfo;
	}



	public void setCourseInfo(List<Course> courseInfo) {
		this.courseInfo = courseInfo;
	}



	public String getGpa() {
		return this.gpa;
	}



	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
}