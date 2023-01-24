import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(System.in);{}
            String str = sc.next();
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                    st.push(str.charAt(i));
                }
                else if(str.charAt(i)==')' || str.charAt(i)==']' || str.charAt(i)=='}'){
                    if(st.isEmpty()== true){
                        System.out.println("false");
                        break;
                    }
                    char top = st.pop();
                    if(top=='(' || str.charAt(i)==')'){
                        continue;
                    }
                    else if(top == '[' || str.charAt(i)==']'){
                        continue;
                    }
                    else if(top == '{' || str.charAt(i)=='}'){
                        continue;
                    }
                    else{
                        System.out.println("false");
                        break;
                    }
                }
            }
        if(st.isEmpty()==true){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }        
    }
}
