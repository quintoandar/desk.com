package br.com.quintoandar.desk.com.oauth;

public abstract class OAuthCallbackRS {
	public abstract String getCallbackUrl();

	public abstract String processCallback(String authKey);
}
