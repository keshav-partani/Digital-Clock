import java.util.Scanner;

public class UseNode {

    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        Node<Integer> n5 = new Node<>(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }
    
        public static Node<Integer> takeInput(){
            Scanner sc = new Scanner(System.in);
            int data = sc.nextInt();
            Node<Integer> head = null;
            Node<Integer> tail = null;
            while(data != -1){
                Node<Integer> currNode = new Node<>(data);
                if(head==null){
                    head = currNode;
                    tail = currNode;
                }
                else{
                    tail.next = currNode;
                    tail = currNode;
                }
                data = sc.nextInt();
            }
            return head;
        }
    
    public static void print(Node<Integer> head){
        while( head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static int lenght(Node<Integer> head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static void printIthNode(Node<Integer> head, int i){
        int postion = 0;
        while(head != null){
            postion++;
            if(postion == i+1){
                System.out.println(head.data);
                return;
            }
            head = head.next;
        }
        System.out.println("not exist position");
    }

    public static void main(String[] args) {
        // Node<Integer> head = createLinkedList();
        Node<Integer> head = takeInput();
        print(head);
        //int l = lenght(head);
        // printIthNode(head, 4);
    }
}
