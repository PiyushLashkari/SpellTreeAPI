package org.enableindia.spelltree.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Initializes and loads application.yml file into a PropertySource (represents
 * a name & value property pairs)
 * 
 */
@ConfigurationProperties(prefix = "application")
public class ApplicationConfigParams {

	// Defines the key for encryption algorithm
	public String decryptionKey;

	public String getDecryptionKey() {
		return decryptionKey;
	}

	public void setDecryptionKey(String decryptionKey) {
		this.decryptionKey = decryptionKey;
	}
}
