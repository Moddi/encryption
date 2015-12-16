
public class Encryptor {
	private EncryptStrategy strategy;
	private EncryptorUI ui;
	
	
	public void setEncryptionStrategy(EncryptStrategy encryption) {
		this.strategy = encryption;
	}
	
	public String encrypt(String string) {
		return strategy.encrypt(string);
	}
	
	public String decrypt(String string) {
		return strategy.decrypt(string);
	}
	
}
