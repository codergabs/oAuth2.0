package com.codegabs.oauth2;

public class ResourceServer {

	private String name;
	
	private String address;
	
	private String username;
	
	private AuthServer authServer;

	public AuthServer getAuthServer() {
		return authServer;
	}

	public void setAuthServer(AuthServer authServer) {
		this.authServer = authServer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String accessData(String accesstoken){
		
		if(accesstoken.equals(this.authServer.getAccesstoken())){
			return this.name;
		}
		
		return null;
	}
	
}
