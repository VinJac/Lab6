package ex3.part1;
/*
 * PART 1: Before Cons and Nil being inner classes
 */

public class Main {

	public static void main(String[] args) {
		
		/* Question 4.
		 * Initialize the sequence with 2 intermediate links and one final link.
		 */
		Seq seq = new Cons("hello", new Cons("world", new Nil()));
		
		// we call the forEach method defined earlier where we specify that the action
		// to make on elements is displaying them
		seq.forEach(System.out::println);
	}

}
