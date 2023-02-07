package com.example.demo.utils;

import java.util.List;

public class ErrorResponse {
	
	 private List<ErrorDetails> errors;
	 
	 public static class ErrorDetails {
	        private String field;
	        private String message;

	        public String getField() {
	            return field;
	        }

	        public void setField(String field) {
	            this.field = field;
	        }

	        public String getMessage() {
	            return message;
	        }

	        public void setMessage(String message) {
	            this.message = message;
	        }

	    }

	 public List<ErrorDetails> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<ErrorDetails> errors) {
	        this.errors = errors;
	    }

}
