package excercise6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);

        a.add(2);
        a.add(2);

        a.add(6);
        a.add(6);
        a.add(6);
        a.add(6);

        a.add(3);
        a.add(10);

        a.add(100);
        a.add(100);

        a.add(33);
        a.add(33);
        a.add(33);

        System.out.println(findDuplicates(a, 2));


    }

    public static List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {

        List<Integer> duplicates = new ArrayList<>();


        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size(); j++) {
                if(i != j) {
                    if(integers.get(i).equals(integers.get(j))) {
                        duplicates.add(integers.get(i));
                    }
                }

            }

        }

        Set<Integer> setOfDuplicates = new HashSet<>(duplicates);

        List<Integer> allDuplicates = new ArrayList<>(setOfDuplicates);

        Map<Integer, Integer> mapOfNumbers = new HashMap<Integer, Integer>();

        for (Integer duplikat: duplicates) {
            mapOfNumbers.put(duplikat, Integer.valueOf(1));
            int a = 0;
            for (int i = 0; i < integers.size(); i++) {
                if(duplikat == integers.get(i)) {
                    a++;

                }

                mapOfNumbers.put(duplikat, a);
            }
        }


        Set<Integer> keys = mapOfNumbers.keySet();

        List<Integer> onlyTwoExist = checkWhereIsOnlyTwoDuplicates(keys, mapOfNumbers);

        System.out.println("Every duplicates: " + allDuplicates);

        System.out.println(numberOfDuplicates == onlyTwoExist.size());

        return onlyTwoExist;
    }


    public static List<Integer> checkWhereIsOnlyTwoDuplicates(Set<Integer> keys, Map<Integer, Integer> mapOfNumbers) {
        List<Integer> onlyTwoExist = new ArrayList<>();
        for (Integer key: keys) {
            if(mapOfNumbers.get(key) == 2) {
                onlyTwoExist.add(key);
            }
        }

        return onlyTwoExist;
    }
}
