package ex3.part2;
/*
 * PART 2: After Cons and Nil being nested classes
 */

import java.util.Objects;
import java.util.function.Consumer;

/* Question 5.
 * A non-static nested class (inner class) will be instantiated relatively to its outer object.
 * An instance of an inner class can therefore access to non-static states of its host.
 * 
 * A static nested class will be instantiated independently from its outer object, therefore
 * it is simply a class "stored" in another, with no link what so ever with the non-static
 * states of its outer class.
 * 
 * Here, no class outside of the Seq interface will implement it, 
 * so we can effectively encapsulate the two classes by making them non-static nested classes.
 * Despite them being public, we won't be able to access them outside of the Seq interface,
 * because they would have to be linked to an outer object implementing Seq.
 */
public interface Seq {
	
	// the forEach method, to perform action for each elements of the sequence
	void forEach(Consumer<Object> cons);
	
	/* Question 7.
	 * prepend() method, that remains the same whatever the object implementing Seq
	 * => As suggested by the main sample, this returns the result, rather than
	 * modifying the content
	 */
	default Seq prepend(Object element) {
		// prepending always creates an intermediate link, that has as its next the previous root
		return new Cons(element, this);
	}

	// Nil class - the end link
	public class Nil implements Seq {
		@Override
		public void forEach(Consumer<Object> cons) {}
	}
	
	// Cons class - an intermediate link
	public class Cons implements Seq {

		private final Object element;	// the data stored
		private final Seq next; 		// the next link in the sequence (Cons or Nil)
		
		public Cons(Object element, Seq next) {
			this.element = Objects.requireNonNull(element);
			this.next = Objects.requireNonNull(next);
		}
		
		@Override
		public void forEach(Consumer<Object> cons) {
			cons.accept(element);	// perform action
			next.forEach(cons);		// propagate in the sequence
		}
	}
	
	/* Question 6.
	 * nil() method initializing an empty sequence (returns the root link, which is also the end)
	 */
	public static Seq nil() { return new Nil(); }
}
