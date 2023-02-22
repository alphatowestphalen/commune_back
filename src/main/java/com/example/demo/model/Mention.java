package com.example.demo.model;

import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedDate;

@Embeddable  
public class Mention {
	
	private String type;
	
	@CreatedDate
	private Instant createdDate;
	

	private ArrayList<MentionInfo> info = new ArrayList<MentionInfo>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public ArrayList<MentionInfo> getInfo() {
		return info;
	}

	public void setInfo(ArrayList<MentionInfo> info) {
		this.info = info;
	}

	public Mention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mention(String type, Instant createdDate) {
		super();
		this.type = type;
		this.createdDate = createdDate;
	}



	

}
