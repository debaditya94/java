package Lists;

public class EmployeeDualNode {
    private Employee employee;
    private EmployeeDualNode next;
    private EmployeeDualNode previous;

    public EmployeeDualNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDualNode getNext() {
        return next;
    }

    public void setNext(EmployeeDualNode next) {
        this.next = next;
    }

    public EmployeeDualNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDualNode previous) {
        this.previous = previous;
    }

    public String toString() {
        return employee.toString();
    }
}
