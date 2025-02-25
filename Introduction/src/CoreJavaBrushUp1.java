
public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 2;
		String revision = "Selenium Revision";
		char letter1 = 'n';
		char letter2 = 'd';

		System.out.println("This is my " + num + letter1 + letter2 + " " + revision + "\n");

		// Loop 1
		System.out.println("Loop 1");
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();

		// Loop 2
		System.out.println("Loop 2");
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println();

		// Loop 3
		System.out.println("Loop 3");
		String[] word = { "Tushar", "Gaur", "Selenium", "Practice" };
		for (int i = 0; i < word.length; i++) {
			System.out.println(word[i]);
		}
		System.out.println();

		// Loop 4
		System.out.println("Loop 4");
		for (String s : word) {
			System.out.println(s);
		}
		System.out.println();
	}

}
