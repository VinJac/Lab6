package ex3.part3;
/*
 * PART 3: Adding generic types
 */

public class Main {

	public static void main(String[] args) {
		Seq<String> seq = Seq.nil(); 
		Seq<String> seq2 = seq.prepend("world").prepend("hello"); 
		
		// Does not work anymore
		// Seq<String> seq2 = seq.prepend("world").prepend("3"); 
		
		seq2.forEach(System.out::println); 
		
	}
}
