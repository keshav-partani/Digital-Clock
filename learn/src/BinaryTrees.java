import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BinaryTrees {

    public static UseBinary<Integer> input(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter roots data");
        }
        else{
            if(isLeft){
                System.out.println("Enter left child of " + parentData);
            }
            else{
                System.out.println("Enter right child of " + parentData);
            }
        }

        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        if(value==-1){
            return null;
        }

        UseBinary<Integer> root = new UseBinary<Integer>(value);
        UseBinary<Integer> left = input(false, value, true);
        UseBinary<Integer> right = input(false, value, false);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void print(UseBinary<Integer> root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data + ": ");
        if (root.left != null){
            System.out.print("L" + root.left.data);
        }
        if(root.right != null){
            System.out.print(", R" + root.right.data);
        }
        System.out.println("");
        
        print(root.left);
        print(root.right);
    }

    public static UseDiameter diameter(UseBinary<Integer> root){
        if(root == null){
            UseDiameter ans = new UseDiameter();
            ans.dia = 0;
            ans.height = 0;
            ans.max = 0;
            return ans;
        }

        UseDiameter leftHeight = diameter(root.left);
        UseDiameter rightHeight = diameter(root.right);
        int dia = leftHeight.height + rightHeight.height;
        int height = Math.max(rightHeight.height, leftHeight.height) + 1;

        UseDiameter ans = new UseDiameter();
        ans.dia = dia;
        ans.height = height;
        ans.max = Math.max(rightHeight.max, leftHeight.max);

        if(dia > ans.max){
            ans.max = dia;
        }
        return ans;
    }

    public static UseBinary<Integer> inputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data :");
        int rootData = sc.nextInt();
        UseBinary<Integer> root = new UseBinary<Integer>(rootData);
        Queue<UseBinary<Integer>> leftElement = new LinkedList<UseBinary<Integer>>(); 
        leftElement.add(root);

        while (!leftElement.isEmpty()){
            UseBinary<Integer> front = leftElement.poll();
            System.out.println("Enter left child of " + front.data);
            int leftData = sc.nextInt();
            if(leftData != -1){
                UseBinary<Integer> left = new UseBinary<>(leftData);
                front.left = left;
                leftElement.add(left);
            }
            System.out.println("Enter right child of " + front.data);
            int rightData = sc.nextInt();
            if(rightData != -1){
                UseBinary<Integer> right = new UseBinary<Integer>(rightData);
                front.right = right;
                leftElement.add(right);
            }
        }
        return root;
    }

    public static void printLevelWise(UseBinary<Integer> root){
        if (root == null){
            return;
        }
        Queue<UseBinary<Integer>> nextElement = new LinkedList<UseBinary<Integer>>();
        nextElement.add(root);
        while(!nextElement.isEmpty()){
            UseBinary<Integer> front = nextElement.poll();
            System.out.print(front.data + " :");
            if(front.left != null){
                System.out.print("L" + front.left.data + ", ");
                nextElement.add(front.left);
            }
            else{
                System.out.print("L-1, ");
            }
            if(front.right != null){
                System.out.print("R" + front.right.data);
                nextElement.add(front.right);
            }
            else{
                System.out.print("R-1");
            }
            System.out.println("");
        }
    }


    public static UseBinary<Integer> InAndPreOrder(int[] preOrder, int[]inOrder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        int rootValue = preOrder[preStart];
        UseBinary<Integer> root = new UseBinary<>(rootValue);
        int count = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(rootValue == inOrder[i]){
                count = i;
                break;
            }
        }

        int eiPreLeft = preStart + (count - inStart);
         int siPreRight = eiPreLeft +1;

        UseBinary<Integer> left = InAndPreOrder(preOrder, inOrder, preStart+1, eiPreLeft, inStart, count-1);
        UseBinary<Integer> right = InAndPreOrder(preOrder, inOrder, siPreRight, preEnd, count+1, inEnd);
        root.left = left;
        root.right = right;

        return root;
    }


    public static UseBinary<Integer> makeTreePreIn(int[] preOrder, int[] inOrder){
        return InAndPreOrder(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }


    public static void main(String[] args) {
        // UseBinary<Integer> root = input(true, 0, true);
        // UseBinary<Integer> root = inputLevelWise();
        // print(root);
        // printLevelWise(root);
        // System.out.println(diameter(root).max);

        //making tree using preOrder and inOreder
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        UseBinary<Integer> root = makeTreePreIn(pre, in);
        print(root);
    }
}
