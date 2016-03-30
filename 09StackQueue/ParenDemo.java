public class ParenDemo {

    public static boolean isMatching(String s) {
	MyStack<Character> stack = new MyStack<Character>();
	char[] chars = s.toCharArray();
	
	for (char c : chars ) {
	    if ( isOpenParen(c) ) {
		stack.push(c);
	    } else if ( isCloseParen(c) ) {
		if ( stack.isEmpty() || stack.pop() != getOpenParen(c) ) {
		    return false;
		} 
	    }
	}
	
	return stack.isEmpty();
    }

    private static boolean isOpenParen(char c) {
	if ( c == '(' || c == '{' || c == '[' || c == '<') {
	    return true;
	} 
	return false;
    }

    private static boolean isCloseParen(char c) {
	if ( c == ')' || c == '}' || c == ']' || c == '>') {
	    return true;
	} 
	return false;
    }

    private static char getOpenParen(char close) {
	if ( close == ')' ) {
	    return '(';
	} else if ( close == '}' ) {
	    return '{';
	} else if ( close == ']' ) {
	    return '[';
	} else if ( close == '>' ) {
	    return '<';
	}
	return '.';
    }

    public static void main(String[] args) {
	String input = "()()(([[]]))";
	
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }

}
