package br.com.quintoandar.desk.com.common;

/**
 * @see https://support.desk.com/customer/portal/articles/476380-how-do-i-test-my-oauth-request-
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * 
 */
public class OAuthHelper {

	public static final String PARAM_NAME = "Authorization";
	
	private String accessKey;
	private String accessSecret;
	private String tokenKey;
	private String tokenSecret;

	public OAuthHelper(String accessKey, String accessSecret, String tokenKey, String tokenSecret) {
		super();
		this.accessKey = accessKey;
		this.accessSecret = accessSecret;
		this.tokenKey = tokenKey;
		this.tokenSecret = tokenSecret;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public String genAuthorizationHeader() {
		return genAuthorizationHeader(System.currentTimeMillis());
	}

	public String genAuthorizationHeader(long timestamp) {
		String nonce = (timestamp / 1000) + "";
		return genAuthorizationHeader(timestamp,nonce);
	}
	
	public String genAuthorizationHeader(long timestamp, String nonce) {
		return String
				.format("OAuth oauth_version=\"1.0\",oauth_timestamp=%d,oauth_nonce=%s,oauth_signature_method=\"PLAINTEXT\",oauth_consumer_key=\"%s\",oauth_token=\"%s\",oauth_signature=\"%s%%26%s\"",
						timestamp, nonce, accessKey, tokenKey, accessSecret, tokenSecret);
	}
}
