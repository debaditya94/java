package Hashtables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class HashtableRemoveDuplicates {
    public static void main(String[] args) {

        LinkedList<EmployeeChallenge> employees = new LinkedList<>();
        employees.add(new EmployeeChallenge("Jane", "Jones", 123));
        employees.add(new EmployeeChallenge("John", "Doe", 5678));
        employees.add(new EmployeeChallenge("Mike", "Wilson", 45));
        employees.add(new EmployeeChallenge("Mary", "Smith", 5555));
        employees.add(new EmployeeChallenge("John", "Doe", 5678));
        employees.add(new EmployeeChallenge("Bill", "End", 3948));
        employees.add(new EmployeeChallenge("Jane", "Jones", 123));

        Map<Integer, EmployeeChallenge> hashMap = new HashMap<Integer, EmployeeChallenge>();

        Iterator iterator = employees.iterator();
        for (EmployeeChallenge employee: employees) {
            hashMap.putIfAbsent(employee.getId(),employee);
        }
        employees.clear();
        hashMap.forEach((k, v) -> employees.add(v));

        employees.forEach(e -> System.out.println(e));

    }

//    public static int hash(int value) {
//        return Math.abs(value % 10);
//    }
}
