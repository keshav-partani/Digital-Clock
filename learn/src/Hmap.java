import java.util.HashMap;

public class Hmap {

    public static void maxFreq(char[] arr){
        HashMap<Character, Integer> h = new HashMap<>();
        for (char i : arr){
            h.put(i, h.getOrDefault(i, 0)+1);
        }
        char ans = 'a';
        int max = 0;
        for (char i : arr){
            if (h.get(i) > max){
                max = h.get(i);
                ans = i;
            }
        }
        System.out.println(ans);
    }

    public static void sumZero(int[] arr){
        HashMap<Integer, Integer> h = new HashMap<>();
        for( int i : arr){
            h.put(i, h.getOrDefault(i, 0)+1);
        }
        int count = 0;
        for(int i : arr){
            if(i<0){
                int f1 = h.getOrDefault(-i, 0);
                count = count + f1*1;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // char[] a = {'a', 'b', 'f', 'a', 'a'};
        // maxFreq(a);

        int[] a = {-2, 2, 6, -2, 2, -6, 3};
        sumZero(a);
    }
}
