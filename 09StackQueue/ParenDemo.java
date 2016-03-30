public class ParenDemo<T> extends MyStack<T> {
	public static boolean isMatching(String s) {
		String sNew = "";
		String letter;
		MyStack<String> MS = new MyStack<String>();
		
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length()-1) {
				letter = s.substring(i, i+1);
			}
			else {
				letter = s.substring(i);
			}
			
			if (isAll(letter)){
				sNew += letter;
			}
		}
		System.out.println("check");
		for (int i = 0; i < sNew.length(); i++) {
			if (i < sNew.length()-1) {
				letter = sNew.substring(i, i+1);
			}
			else {
				letter = s.substring(i);
			}
			System.out.println("letter: " + letter);
			if (MS.isEmpty()) {
				if (isClose(letter)) {
					return false;	
				}
				else {
					MS.push(letter);
				}
			}
			else {
				System.out.println("peek: " + MS.peek());
				if (MS.peek() == "(") {
					if (!(letter.equals(")"))) {
						return false;
					}
					else {
						MS.pop();
					}
				}
				if (MS.peek() == "{") {
					if (!(letter.equals("}"))) {
						return false;
					}
					else {
						MS.pop();
					}
				}
				if (MS.peek() == "[") {
					if (!(letter.equals("]"))) {
						return false;
					}
					else {
						MS.pop();
					}
				}
				if (MS.peek() == "<") {
					if (!(letter.equals(">"))) {
						return false;
					}
					else {
						MS.pop();
					}
				}
			}	
		}
		System.out.println(MS.peek());
		if (!(MS.isEmpty())) {
			return false;
		}
		System.out.println("check3");
		return true;
	}
	
	public static boolean isAll(String letter) {
		return (letter.equals("(") || letter.equals("{") || letter.equals("[") || letter.equals("<") || 
				letter.equals(")") || letter.equals("}") || letter.equals("]") || letter.equals(">"));
	}
	
	public static boolean isOpen(String letter) {
		return (letter.equals("(") || letter.equals("{") || letter.equals("[") || letter.equals("<"));
	}
	
	public static boolean isClose(String letter) {
		return (letter.equals(")") || letter.equals("}") || letter.equals("]") || letter.equals(">"));
	}
	
	
	public static void main(String[]args){
		String input = "()()(([[]]))";
		if(args.length > 0){
			input = args[0];
			System.out.println( isMatching(input)); 
		}
		else{
			System.out.println("Usage:"); 
			System.out.println("java ParenDemo \"text\""); 
		}
	}
}