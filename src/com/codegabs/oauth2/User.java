package com.codegabs.oauth2;

public class User {

	public static void main(String args[]){
	
		//register User with Auth Server - say google
		AuthServer as = new AuthServer();
		as.setUsername("gabs");
		as.setPassword("1234");
		//register client with auth-server		
		as.setClientID("clientapp");
		as.setClientPswd("clientpassword");

		// add user data into ResouceServer
		ResourceServer rs = new ResourceServer();
		rs.setName("gabs");
		rs.setAddress("bangalore");
		rs.setAuthServer(as);
		rs.setUsername("gabs");
		
		
		// try to login client app - with Auth Server credential
		ClientApp ca = new ClientApp();
		System.out.println("Client App request");
		String response = ca.authorize();
		System.out.println("Client App request - "+response);
	
		//send request to auth server for auth-code
		System.out.println("Auth Server request");
		String authcode = as.authorizeUser("code", "clientapp", "gabs", "1234");
		System.out.println("Auth Server response - " + authcode);
		
		//send request to client app for token
		System.out.println("Token request");
		String accesstoken = ca.accessFromUser(as, authcode);
		System.out.println("Token response - " + accesstoken);
		
		//send request to resouce server for resource data
		System.out.println("Resouce data request");
		String data = ca.getDataFromResourceServer(rs, accesstoken);
		System.out.println("Resouce data response - " + data);
		
	}
	
	
	
}
