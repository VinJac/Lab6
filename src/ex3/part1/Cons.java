package ex3.part1;
/*
 * PART 1: Before Cons and Nil being nested classes
 */

import java.util.Objects;
import java.util.function.Consumer;

/*
 * Cons class implementing Seq, an intermediate link that
 * stores data and a reference to the next link of the sequence
 */
public class Cons implements Seq {
	
	private final Object element;	// the data stored
	private final Seq next; 		// the next link in the sequence (Cons or Nil)
	
	// we can't specify NULL values in the constructor, since a "NULL link" is
	// already represented by a NIL object
	public Cons(Object element, Seq next) {
		this.element = Objects.requireNonNull(element);
		this.next = Objects.requireNonNull(next);
	}
	
	/* Question 3.
	 * We perform the consumer's operation on each link's data element 
	 * recursively in the sequence
	 */
	@Override
	public void forEach(Consumer<Object> cons) {
		cons.accept(element);	// perform action
		next.forEach(cons);		// propagate in the sequence
	}
}
