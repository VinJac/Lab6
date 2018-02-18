package ex3.part1;

import java.util.function.Consumer;

/*
 * Seq interface, implemented by both intermediate and end links
 */
public interface Seq {
	
	/* Question 1 & 2.
	 * forEach method => executes on each element of the sequence the implemented
	 * action for the passed Consumer
	 * In API Documentation, we see that this functional interface presents the method
	 * void accept(T t). => The action performed will therefore return nothing, and will
	 * take place on the data element stored in each link. Here the data element is
	 * an Object object, this is why we expect a Consumer<Object>
	 */
	void forEach(Consumer<Object> cons);
	
}
