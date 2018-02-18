package ex1;

import java.util.TreeSet;

public class Ex1 {
	
	
	
	
	public static void main(String[] args) {
		/* Question 1.
		 * instead of using an anonymous class, we use a lambda expression to specify
		 * the run() method of the Runnable interface (no argument, no return)
		 */
		(new Thread(() -> System.out.println("Hello world!"))).start();
		/* Question 2.
		 * Since Java 8, a functional interface is an interface that has only one abstract
		 * method. We could cite for instance interfaces ActionListener (only has 
		 * an actionPerformed() method), or Comparable<T> (only has a compareTo() method)
		 */
		
		/* Question 3.
		 * The presented code is uselessly complicated since the String class already
		 * natively implements Comparable<String>, that does exactly the same as what
		 * we are doing on the compare() method.
		 * -> A TreeSet already knows how to sort String objects in this way
		 * 
		 * Making the assumption that a Comparator of String should be passed, we can
		 * re-write this code the following way, anonymously referring to Comparator's
		 * compare() method:
		 */
		TreeSet<String> treeSet1 = new TreeSet<String>((s1, s2) -> s1.compareTo(s2));
		/* Question 4.
		 * Since we are only calling the existing method compareTo() of the String class
		 * here, we can effectively replace the previous lambda expression with a 
		 * method reference:
		 */
		TreeSet<String> treeSet2 = new TreeSet<String>(String::compareTo);
	}
}
