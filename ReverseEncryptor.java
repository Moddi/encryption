
public class ReverseEncryptor implements EncryptStrategy {

	@Override
	public String encrypt(String string) {
		return new StringBuilder(string).reverse().toString();
	}

	@Override
	public String decrypt(String string) {
		return new StringBuilder(string).reverse().toString();
	}
}
