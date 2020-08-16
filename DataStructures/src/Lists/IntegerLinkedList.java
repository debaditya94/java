package Lists;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        IntegerNode insertNode = new IntegerNode(value);
        if (head == null) {
            head = insertNode;
        }
        else {
            if(head.getValue() > value) {
                addToFront(value);
            }
            else {
                IntegerNode current = head;
                if (current.getNext() == null) {
                    insertNode.setNext(current.getNext());
                    current.setNext(insertNode);
                }
                else {
                    while (current.getNext() != null && current.getNext().getValue() <= value) {
                        current = current.getNext();
                    }
                    insertNode.setNext(current.getNext());
                    current.setNext(insertNode);
                }
            }
        }
        size++;

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
