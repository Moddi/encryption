
public class CopyEncryptor implements EncryptStrategy{

	@Override
	public String encrypt(String string) {
		return string;
	}

	@Override
	public String decrypt(String string) {
		return "";
	}
}
