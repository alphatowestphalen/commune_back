package com.back.commune.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {

	 @NotBlank
	    @Size(min = 3, max = 20)
	    private String username;

	    @NotBlank
	    @Size(max = 10)
	    private String phone;

	    private Set<String> role;

	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Set<String> getRole() {
			return role;
		}

		public void setRole(Set<String> role) {
			this.role = role;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}



}
