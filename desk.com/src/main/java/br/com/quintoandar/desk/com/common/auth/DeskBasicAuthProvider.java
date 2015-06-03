package br.com.quintoandar.desk.com.common.auth;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class DeskBasicAuthProvider implements DeskAuthProvider {

	private String authorizationHeader;

	public DeskBasicAuthProvider(String user, String password) {
		String token = user + ":" + password;
		try {
			authorizationHeader = "Basic " + Base64.encodeBase64String(token.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Could not convert using UTF-8",e);
		}
	}

	@Override
	public String genAuthorizationHeader() {
		return authorizationHeader;
	}

}
