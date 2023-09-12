package com.back.commune.model.auth;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		@JsonIgnore
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

        public Role(String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
        public Role(String name) {
            this.name = name.toUpperCase();
            this.description = name;
        }
        public Role() {
        }

        @Override
        public String toString() {
            return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
        }
    }
