package com.codegabs.oauth2;

public class ClientApp {
	
	private String clientID;
	
	private String clientPswd;

	public String authorize(){
		
		return "login via AuthServer";
		
	}
	//access from user via redirecturl and send auth request to auth server for access token
	public String accessFromUser(AuthServer as,String authcode){		
		return as.authorizeClientApp("clientapp", "clientpassword", "authorization_code", authcode, null);
	}

	//it is to get data from Reource Server
	public String getDataFromResourceServer(ResourceServer rs, String accesstoken){
		return rs.accessData(accesstoken);
	}
}
