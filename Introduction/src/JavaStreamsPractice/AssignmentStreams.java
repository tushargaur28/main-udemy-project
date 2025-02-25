package JavaStreamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {3,2,2,7,5,1,9,7};
		// 1. Print unique numbers
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s->System.out.println("unique numbers : " + s));
		
		// 2. Sort the array
		values.stream().distinct().sorted().forEach(s->System.out.println("sorted unique values : " + s));;
		
		// 3. Give the third value after sorting
		List<Integer> sortedList = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedList.get(2));
		
		
	}

}
