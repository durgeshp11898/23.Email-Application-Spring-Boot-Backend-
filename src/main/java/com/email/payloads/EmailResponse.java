package com.email.payloads;

public class EmailResponse {

	private String token;
	
	 public EmailResponse() {
		// TODO Auto-generated constructor stub
	}

	public EmailResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "EmailResponse [token=" + token + "]";
	}
	 
	 
	
}
