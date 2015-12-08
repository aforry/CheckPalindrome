import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// This loop reads all of the lines of input from System.in
		while (true) {
			// Prompt the user
			System.out.println("Type something and click 'enter' to see if it's a palindrome:\n(Type 'quit' to stop)\n");

			// Read a line
			String line = reader.readLine();

			// Type only 'quit' to force exit
			if (line.toLowerCase().equals("quit")) {
				break;
			}

			// Check to see if line is a palindrome
			// and print "Palindrome" or "Not a palindrome"
			// to System.out.

			//  - Ignore characters that aren't letters:
			//    Character.isLetter(char) method
			//    determines which characters are letters
			//  - Character.toLowerCase(char) method converts
			//    a letter to lower case

			Stack<Character> stack = new Stack<Character>();
			Queue<Character> queue = new LinkedList<Character>();

			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);

				if(Character.isLetter(c)){
					c = Character.toLowerCase(c);
					queue.add(c);
					stack.push(c);
				}
			}
			boolean isPalindrome = true;
			
			while(!stack.isEmpty()){
				//stack pops off most recent
				//queue removes least recent
				//can be used to compare the string to itself in reverse
				//if any two characters don't match, not a palindrome
				char checkQueue = queue.remove();
				char checkStack = stack.pop();
				
				if(checkQueue != checkStack){
					isPalindrome = false;
				}
			}
			
			if(!isPalindrome){
				System.out.println("*** NOT A PALINDROME ***\n");
			}else{
				System.out.println("*** PALINDROME ***\n");
			}
		}
	}
}
