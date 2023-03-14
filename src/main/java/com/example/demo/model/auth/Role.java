package com.example.demo.model.auth;

import java.util.List;

import javax.persistence.*;

	@Entity
	public class Role {

	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private long id;

	    @Column
	    private String name;

	    @Column
	    private String description;

		@OneToMany(mappedBy = "roles")
		private List<User> user;


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

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

		public List<User> getUser() {
			return user;
		}

		public void setUser(List<User> user) {
			this.user = user;
		}

		
	}
