package com.example.demo.model;

import javax.persistence.Embeddable;


public class MentionInfo {
	
	private String header;
	
	private String value;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MentionInfo(String header, String value) {
		super();
		this.header = header;
		this.value = value;
	}
	
	

}
