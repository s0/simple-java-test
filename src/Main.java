import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

class Main {

	public String foo;
	public String bar;
	private String baz;

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
		System.out.println("Hello World" + new Main().baz);
		System.out.println("Hello World" + new Main().baz);
		System.out.println("Hello World" + new Main().baz);

		// BAD: A new 'Random' object is created every time
		// a pseudo-random integer is required.
		// java/random-used-once
		int notReallyRandom = new Random().nextInt();
		int notReallyRandom2 = new Random().nextInt();
		int notReallyRandom3 = new Random().nextInt();

		// BAD: DES is a weak algorithm
		// java/weak-cryptographic-algorithm
		Cipher des = Cipher.getInstance("DES");
		Cipher des2 = Cipher.getInstance("DES");
	}

	// java/unsafe-sync-on-field
	public class A {
		private Object field;

		public void setField(Object o) {
			// BAD: synchronize on the field to be updated
			synchronized (field) {
				field = o;
			}
		}
	}

}