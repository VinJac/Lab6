package ex3.part1;
/*
 * PART 1: Before Cons and Nil being inner classes
 */

import java.util.function.Consumer;

/*
 * Nil class implementing Seq, analogous to a "NULL link", that rather than storing data
 * indicates the end of the sequence.
 */
public class Nil implements Seq {
	
	/* Question 3.
	 * This will be called when we will arrive at the end of the sequence
	 * we simply do nothing here, this is the end of the process
	 */
	@Override
	public void forEach(Consumer<Object> cons) {}
}
