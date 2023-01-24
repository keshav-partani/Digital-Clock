import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        for(int i=0; i<5; i++){
            s1.push(i);
        }
        Stack<Integer> s2 = new Stack<>();
        rec(s1,s2);
        for(int i=0; i<s1.size(); i++){
            System.out.println(s1.pop());
        }
    }

    private static void rec(Stack<Integer> s1, Stack<Integer> s2) {
        if(s1.size() <= 1){
            return;
        }
        int last = s1.pop();
        rec(s1,s2);
        while(s1.isEmpty() != true){
            int top = s1.pop();
            s2.push(top);
        }
        s1.push(last);
        while(s2.isEmpty() != true){
            int top = s2.pop();
            s1.push(top);
        }
    }
}
