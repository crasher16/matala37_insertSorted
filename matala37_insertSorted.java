package ex1;
import unit4.collectionsLib.Node;

public class matala37_insertSorted {
    
    // Exercise 37: Insert number into sorted list
    // Keeps the list sorted after insertion
	// By: Idan Dror
	
    public static Node<Integer> insertSorted(Node<Integer> head, int num) {
        Node<Integer> newNode = new Node<>(num);
        
        // Case 1: Empty list OR insert at beginning
        if (head == null || num <= head.getValue()) {
            newNode.setNext(head);
            return newNode;
        }
        
        // Case 2: Insert in middle or end
        Node<Integer> current = head;
        
        // Find position: stop before the first element >= num
        while (current.getNext() != null && current.getNext().getValue() < num) {
            current = current.getNext();
        }
        
        // Insert after current
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        return head;
    }
    
    // ---------- helper methods ----------
    public static void printList(Node<Integer> head) {
        Node<Integer> tmp = head;
        System.out.print("[");
        while (tmp != null) {
            System.out.print(tmp.getValue());
            if (tmp.getNext() != null)
                System.out.print(", ");
            tmp = tmp.getNext();
        }
        System.out.println("]");
    }
    
    public static Node<Integer> createList(int[] arr) {
        if (arr.length == 0)
            return null;
        
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> tmp = head;
        
        for (int i = 1; i < arr.length; i++) {
            tmp.setNext(new Node<>(arr[i]));
            tmp = tmp.getNext();
        }
        return head;
    }
    
    // -------------------- main tests --------------------
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Exercise 37: Insert Sorted");
        System.out.println("====================================");
        System.out.println();
        
        // Test 1: Insert in middle
        System.out.println("Test 1: Insert 5 into [1, 3, 7, 9]");
        Node<Integer> h1 = createList(new int[]{1, 3, 7, 9});
        System.out.print("Before: ");
        printList(h1);
        h1 = insertSorted(h1, 5);
        System.out.print("After:  ");
        printList(h1);
        System.out.println("Expected: [1, 3, 5, 7, 9]");
        System.out.println();
        
        // Test 2: Insert at beginning
        System.out.println("Test 2: Insert 0 into [2, 4, 6, 8]");
        Node<Integer> h2 = createList(new int[]{2, 4, 6, 8});
        System.out.print("Before: ");
        printList(h2);
        h2 = insertSorted(h2, 0);
        System.out.print("After:  ");
        printList(h2);
        System.out.println("Expected: [0, 2, 4, 6, 8]");
        System.out.println();
        
        // Test 3: Insert at end
        System.out.println("Test 3: Insert 10 into [1, 3, 5, 7]");
        Node<Integer> h3 = createList(new int[]{1, 3, 5, 7});
        System.out.print("Before: ");
        printList(h3);
        h3 = insertSorted(h3, 10);
        System.out.print("After:  ");
        printList(h3);
        System.out.println("Expected: [1, 3, 5, 7, 10]");
        System.out.println();
        
        // Test 4: Insert into empty list
        System.out.println("Test 4: Insert 5 into []");
        Node<Integer> h4 = null;
        System.out.print("Before: ");
        printList(h4);
        h4 = insertSorted(h4, 5);
        System.out.print("After:  ");
        printList(h4);
        System.out.println("Expected: [5]");
        System.out.println();
        
        // Test 5: Insert duplicate
        System.out.println("Test 5: Insert 4 into [1, 3, 4, 7, 9]");
        Node<Integer> h5 = createList(new int[]{1, 3, 4, 7, 9});
        System.out.print("Before: ");
        printList(h5);
        h5 = insertSorted(h5, 4);
        System.out.print("After:  ");
        printList(h5);
        System.out.println("Expected: [1, 3, 4, 4, 7, 9]");
        System.out.println();
        
        // Test 6: Insert into single element (smaller)
        System.out.println("Test 6: Insert 3 into [5]");
        Node<Integer> h6 = createList(new int[]{5});
        System.out.print("Before: ");
        printList(h6);
        h6 = insertSorted(h6, 3);
        System.out.print("After:  ");
        printList(h6);
        System.out.println("Expected: [3, 5]");
        System.out.println();
        
        // Test 7: Insert into single element (larger)
        System.out.println("Test 7: Insert 8 into [5]");
        Node<Integer> h7 = createList(new int[]{5});
        System.out.print("Before: ");
        printList(h7);
        h7 = insertSorted(h7, 8);
        System.out.print("After:  ");
        printList(h7);
        System.out.println("Expected: [5, 8]");
        System.out.println();
        
        // Test 8: Multiple insertions
        System.out.println("Test 8: Multiple insertions");
        Node<Integer> h8 = createList(new int[]{1, 5, 9});
        System.out.print("Start:  ");
        printList(h8);
        h8 = insertSorted(h8, 3);
        System.out.print("After insert 3: ");
        printList(h8);
        h8 = insertSorted(h8, 7);
        System.out.print("After insert 7: ");
        printList(h8);
        h8 = insertSorted(h8, 0);
        System.out.print("After insert 0: ");
        printList(h8);
        h8 = insertSorted(h8, 10);
        System.out.print("After insert 10: ");
        printList(h8);
        System.out.println("Expected: [0, 1, 3, 5, 7, 9, 10]");
    }
}
