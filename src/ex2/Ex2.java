package ex2;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2 {

	public static void main(String[] args) {
		/* Question 1.
		 * We use method IntStream ints(size, origin, bound) of the Random class, which
		 * returns an IntStream of "size" random integers randomly generated between
		 * origin (inclusive) and bound (exclusive).
		 * On this IntStream, we compute the average (terminal operation), which gives us
		 * an OptionalDouble, that we display in the console if present (will always be
		 * the case here because the stream is non-empty)
		 */
		(new Random()).ints(1000, 1, 101).average().ifPresent(System.out::println);
		
		/* Question 2.
		 * We use Collectors.groupingBy() to collect a map, grouping lists of elements
		 * according to a classification function: here Teacher::getGender() since we want
		 * to group by gender. (Each teacher showing the same output to the getGender()
		 * function will be grouped together, along with this output as the map key) 
		 */
		// getting the map
		Map<Gender, List<Teacher>> map = Stream.of(
			new Teacher("Ravaut" , Gender.MALE),
			new Teacher("Soukane" , Gender.FEMALE),
			new Teacher("Palasi" , Gender.FEMALE),
			new Teacher("Segado" , Gender.MALE),
			new Teacher("Diedler" , Gender.MALE))
				.collect(Collectors.groupingBy(Teacher::getGender));
		
		// printing the map for verification
		for(Map.Entry<Gender, List<Teacher>> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " => ");
			for(Teacher t : entry.getValue()) 
				System.out.print(t.getName() + " ");
			System.out.println();
		}	
	}
}
