package ex3.part2;
/*
 * PART 2: After Cons and Nil being nested classes
 */

public class Main {

	public static void main(String[] args) {
		Seq seq = Seq.nil(); 
		Seq seq2 = seq.prepend("world").prepend(3); 
		
		seq2.forEach(System.out::println); 
	}
}
