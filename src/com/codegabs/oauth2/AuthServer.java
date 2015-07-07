package com.codegabs.oauth2;

public class AuthServer {

	private String name;
	
	private String address;
	
	private String username;
	
	private String password;
	
	private String clientID;
	
	private String clientPswd;
	
	private String accesstoken;
	
	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	
	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientPswd() {
		return clientPswd;
	}

	public void setClientPswd(String clientPswd) {
		this.clientPswd = clientPswd;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// It is Authirozation Endpoint, it authorizes the user and generate auth code
	public String authorizeUser(String response_type,String client_id,String usernm, String passwd){
		
		if(usernm.equals(this.username) && passwd.equals(this.password)){
			return "auth-code";
		}
		else{
			return "error";
		}
			
	}

	//It is TOken endpoint, it is to authorize client it generates access token
	public String authorizeClientApp(String client_id,String client_secret,String grant_type, String code, String redirect_uri){
		
		if(grant_type.equals("authorization_code") && code.equals("auth-code") && client_id.equals(this.clientID) && client_secret.equals(this.clientPswd)){
			this.setAccesstoken("access-token");
			return "access-token";
		}
		else{
			return "client validity error";
		}
			
	}
}
