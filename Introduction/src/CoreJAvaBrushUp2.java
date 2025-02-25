import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJAvaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 8, 12, 15, 60, 80, 90, 110, 123, 120, 125 };

		for (int num : arr) {
			if (num % 4 == 0) {
				System.out.println(num + " is divisible by 4");
				break;
			} else {
				System.out.println(num + " is not divisible by 4");
			}
		}

		System.out.println();

		double[] numbers = { 1.3, 4.3, 4, 2, 5.0 };

		System.out.println(numbers[0]);
		System.out.println(numbers[numbers.length - 1]);

		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.println(numbers[i]);
		}

		System.out.println(numbers.length);

		System.out.println("*************");

		ArrayList<String> a = new ArrayList<String>();
		a.add("Tushar");
		a.add("Gaur");
		a.add("Selennium");
		a.add("Selenium");
		System.out.println(a);

		a.remove(2);
		System.out.println(a);

		System.out.println(a.contains("Selenium"));

		String[] arry = { "Tushar", "Gaur", "New", "Array" };
		List<String> name = Arrays.asList(arry);
		System.out.println(name.size());
	}

}
