package Hashtables;

import Hashtables.Employee;

public class HashtableMain {

    public static void main (String[] args) {

        Hashtables.Employee janeJones = new Hashtables.Employee("Jane","Jones",123);
        Hashtables.Employee johnDoe = new Hashtables.Employee("John","Doe",4567);
        Hashtables.Employee marySmith = new Hashtables.Employee("Mary","Smith",22);
        Hashtables.Employee mikeWilson = new Hashtables.Employee("Mike","Wilson",3245);
//        Hashtables.Employee billEnd = new Hashtables.Employee("Bill", "End", 78);

        ChainedHashtable ht = new ChainedHashtable();
        ht.put("Jones",janeJones);
        ht.put("Doe",johnDoe);
        ht.put("Wilson",mikeWilson);
        ht.put("Smith",marySmith);

//        ht.printHashtable();

//        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
////
//        ht.remove("Wilson");
//        ht.remove("Jones");
        ht.printHashtable();
//
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

    }
}
