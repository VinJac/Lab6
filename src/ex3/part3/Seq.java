package ex3.part3;
/*
 * PART 3: Adding generic types
 */

import java.util.Objects;
import java.util.function.Consumer;

/* Question 8.
 * We parameterize the sequence - The stored data is not an Object object anymore, but
 * is now of a generic type T, that the user can specify.
 */
public interface Seq<T> {
	
	// the performed action is now on an element of type T
	void forEach(Consumer<T> cons);
	
	// we now prepend a link with a stored data of type T
	default Seq<T> prepend(T element) {
		return new Cons<T>(element, this);
	}

	// We have to add T here, even if the Nil class does not manipulate any data
	public class Nil<T> implements Seq<T> {
		@Override
		public void forEach(Consumer<T> cons) {}
	}
	
	// The Cons class also becomes parameterize with the type of the data it holds
	public class Cons<T> implements Seq<T> {

		private final T element;		// the data stored
		private final Seq<T> next; 		// the next link in the sequence (Cons or Nil)
		
		public Cons(T element, Seq<T> next) {
			this.element = Objects.requireNonNull(element);
			this.next = Objects.requireNonNull(next);
		}
		
		@Override
		public void forEach(Consumer<T> cons) {
			cons.accept(element);	// perform action
			next.forEach(cons);		// propagate in the sequence
		}
	}
	
	/* Question 9.
	 * the nil() method being static, it will be executed regardless of T. (Because T
	 * is the matter of the interface). Therefore, we cannot associate T to nil() in order
	 * to make it generic.
	 * => What we do instead is parameterize the method itself, regardless of whether the
	 * hosting interface is parameterized or not. (We put U here to emphasize the fact that
	 * we are using a parameter which is distinct from T, the one of the interface)
	 */
	public static <U> Seq<U> nil() { return new Nil<U>(); }
}
