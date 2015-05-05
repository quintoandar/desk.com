package br.com.quintoandar.desk.com.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class OAuthHelperTest {

	/**
	 * Test data from: https://support.desk.com/customer/portal/articles/476380-how-do-i-test-my-oauth-request-
	 * @see 
	 */
	@Test
	public void test() {
		OAuthHelper helper = new OAuthHelper("nMu4u9pLRfDrxhPVK5yn", "vLr9MjzowzVwbvREpWhIVQMJQI0G7Pin6KHCoXak", "ivouGxpsJbyIU5viPKOO", "igQY0L2bcbwonZTC4kG5ulZxTMTDW0K0zIyceSuF");
		long timestamp = 1321473112l;
		String nonce = "937459123";
		assertEquals("OAuth oauth_version=\"1.0\",oauth_timestamp=1321473112,oauth_nonce=937459123,oauth_signature_method=\"PLAINTEXT\",oauth_consumer_key=\"nMu4u9pLRfDrxhPVK5yn\",oauth_token=\"ivouGxpsJbyIU5viPKOO\",oauth_signature=\"vLr9MjzowzVwbvREpWhIVQMJQI0G7Pin6KHCoXak%26igQY0L2bcbwonZTC4kG5ulZxTMTDW0K0zIyceSuF\"", helper.genAuthorizationHeader(timestamp,nonce));
	}

}
