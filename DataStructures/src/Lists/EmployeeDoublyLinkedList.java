package Lists;

public class EmployeeDoublyLinkedList {
    private EmployeeDualNode head;
    private EmployeeDualNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDualNode node = new EmployeeDualNode(employee);

        if (head == null) {
            tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeDualNode node = new EmployeeDualNode(employee);
        if (tail == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

        // return true if you were able to successfully add the employee
        // into the list before the existing employee. Return false
        // if the existing employee doesn't exist in the list

        // add your code here
        EmployeeDualNode current = head;
        if (current != null) {
            if (head.getEmployee() == existingEmployee) {
                this.addToFront(newEmployee);
            }
            else {
                while(current.getNext() != null) {
                    if (current.getEmployee() == existingEmployee ) {
                        break;
                    }
                    current = current.getNext();
                }
                if (current == null) {
                    return false;
                }
                EmployeeDualNode newNode = new EmployeeDualNode(newEmployee);
                current.getPrevious().setNext(newNode);
                newNode.setPrevious(current);
                current.setPrevious(newNode);
                newNode.setNext(current);
                size++;
            }
            return true;
        }

        return false;
    }

    public EmployeeDualNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }
        if (head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrevious(null);
        }
        EmployeeDualNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeDualNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeDualNode removedNode = tail;
        if (tail.getPrevious() == null) {
            head = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeDualNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
