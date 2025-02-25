package JavaStreamsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Test1 {

	public static void main(String[] args) {

		// Count names starting with A

		ArrayList<String> names = new ArrayList<String>();
		names.add("Bhuvan");
		names.add("Abhijeet");
		names.add("Adam");
		names.add("Don");
		names.add("Aman");
		names.add("Karan");


		// 1. Print all names starting with A
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("1. count of names starting with A : "+c);
		
		// 2. Print all names with length > 4
		Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").filter(s->s.length()>4).forEach(s->System.out.println("2. names with length > 4 : "+s));
		
		// 3. Print only the first result of all names with length > 4
		Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").filter(s->s.length()>4).limit(1).forEach(s->System.out.println("3. first result of all names with length > 4 : "+s));
		
		// 4. Print names ending with 'n' in UPPERCASE
		Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println("4. names ending with 'n' in UPPERCASE : " + s));
		
		// 5. Print all names
		Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").forEach(s->System.out.println("5. all names : "+ s));;
		
		// 6. Print all names in UPPERCASE
		Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").map(s->s.toUpperCase()).forEach(s->System.out.println("6. all names in UPPERCASE : " +s));
		
		// 7. Print names starting with 'a' and in sorted order
		List<String> nameList = Arrays.asList("Azhar", "Bhuvan", "Karan", "Don","Adam", "Aman");
		nameList.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("7. names starting with 'a' and in sorted order : "+s));
		
		// 8. Merge two lists 'names' and 'names1'
		List<String> names1  = Arrays.asList("Cat","Cow","Dog");
		Stream<String> mergedStream =	Stream.concat(names.stream(), names1.stream());
		mergedStream.sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("8. merged stream : " + s));
		
		// 9. Check if 'Adam' is present in the merged list
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		Boolean match = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(match);
		System.out.println("9. " + match);
		
		// 10. Collect stream and convert back to list
		List<String> newList = Stream.of("Abhijeet", "Bhuvan", "Karan", "Don", "Aman").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("10. " + newList.get(0));
		
	}

}
