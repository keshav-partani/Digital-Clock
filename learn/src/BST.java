public class BST {

    public static UseBinary<Integer> makeBST(int[] arr, int start, int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        UseBinary<Integer> root = new UseBinary<Integer>(arr[mid]);
        root.left = makeBST(arr, start, mid-1);
        root.right = makeBST(arr, mid+1, end);
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

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        UseBinary<Integer> root = makeBST(a, 0, a.length-1);
        print(root);  
    }
}
