package com.cosc.com.server;

import com.cosc.com.client.GreetingService;
import com.cosc.com.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.testing.project1.FileUtility;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 10 characters long");
		}

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		
		String[] repeatedWords = FileUtility.getDublicateWords(input);
		StringBuffer buffer = new StringBuffer();
		for(String string: repeatedWords){
			String[] strings = string.split(":");
			buffer.append("The repeated word found in Line =[" + strings[1] + "] = [" + strings[0] + "] <br/>");
		}
		input = buffer.toString();
		return "Hello, " + input + "!";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
