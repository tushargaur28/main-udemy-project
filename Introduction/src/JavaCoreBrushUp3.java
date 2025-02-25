
public class JavaCoreBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Tushar";
		String s2 = "Tushar";
		String s3 = "Gaur";

		String s4 = new String("Tushar");
		String s5 = new String("Gaur");
		String s6 = new String("Selenium");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);

		String s = ("Tushar Gaur Selenium Gaur Practice");
		System.out.println(s);

		String[] ss = s.split("Gaur");
		System.out.println(ss[0].trim());
		System.out.println(ss[1].trim());
		System.out.println(ss[2].trim());

		System.out.println("Using Loop");

		System.out.println("Reverse 1: ");
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
		}

		System.out.println("Reverse 2: ");
		String alphabet = "abcdefg";
		for (int j = alphabet.length() - 1; j >= 0; j--) {
			System.out.println(alphabet.charAt(j));
		}

		String password = new String("Please use temporary password 'rahulshettyacademy' to Login.");
		String[] splittedString = password.split("'");
		String newPassword = (splittedString[1]);
		System.out.println(newPassword);

	}

}
