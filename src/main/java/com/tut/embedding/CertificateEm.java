package com.tut.embedding;

import jakarta.persistence.Embeddable;

@Embeddable
public class CertificateEm {
	
	private String course;
	private String duration;

	public CertificateEm(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration + "]";
	}
	public CertificateEm() {
		super();
		// TODO Auto-generated constructor stub
	}
}
