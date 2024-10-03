package learning.collections;

import java.util.*;

public class CollectionsDemo00 {
    public void arrayList() {
//        about constructors

        List<Integer> arrayList1 = new ArrayList<>();                       // to create an empty list
        List<Integer> arrayList2 = new ArrayList<>(10);         // to create a empty list with specified capacity

        addElements(arrayList1);

        System.out.println("arrayList1: " + arrayList1);

        List<Integer> arrayList3 = new ArrayList<>(arrayList1);             // to create a list with the specified collection. Note you have to pass any object that is the object of collection and sub-class or same class of E (element).
        System.out.println("arrayList3: " + arrayList3);

//        to add elements we have 4 methods
        arrayList2.add(1);
        System.out.println("arrayList2: " + arrayList2);

        arrayList2.add(0, 2);
        System.out.println("arrayList2: " + arrayList2);

        arrayList2.addAll(arrayList1);
        System.out.println("arrayList2: " + arrayList2);

        arrayList2.addAll(0, arrayList1);
        System.out.println("arrayList2: " + arrayList2);

        arrayList3.forEach(no -> System.out.print(no + " "));

        System.out.println("\n" + arrayList1.contains(1));

        int no = arrayList1.get(3);

        System.out.println(arrayList1);
        boolean isRemoved = arrayList1.removeIf(no1 -> no1 == 3);
        System.out.println(arrayList1);
    }

    public void hashMap() {
        Map<String, String> map = new HashMap<>();

//        adding values to the map
        map.put("name", "tarun");
        map.put("age", "23");
        map.put("role", "java developer");

        Set<String> keySet = map.keySet();
        System.out.println("keys: " + keySet);

        Collection<String> valueCollection = map.values();
        System.out.println(valueCollection);

        map.forEach((key, value) -> System.out.print(key + " : " + value + ", "));              // remove all the elemnts
    }

    private void addElements(List<Integer> list) {
        for(int i = 0; i <= 10; i++) {
            list.add(i);
        }

        list.add(0, 3);
    }
}
