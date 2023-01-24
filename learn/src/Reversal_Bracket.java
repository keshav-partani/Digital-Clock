import java.util.Scanner;
import java.util.Stack;

public class Reversal_Bracket {

    public static int reversal(String str){
        
        if(str.length()==0){
            return 0;
        }

        if(str.length()%2 != 0){
            return -1;
        }
        Stack<Character> s1 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='{'){
                s1.push(str.charAt(i));
            }
            else if(!s1.isEmpty() && s1.peek()=='{'){
                s1.pop();
            }
            else{
                s1.push(str.charAt(i));
            }
        }

        int count = 0;

        while(s1.isEmpty() != true){
           char c1 = s1.pop();
           char c2 = s1.pop();
           if(c1 != c2){
            count += 2;
           }
           else{
            count += 1;
           }
        }
        return count;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();
            int count = reversal(str);
            System.out.println(count);
        }
    }
}
