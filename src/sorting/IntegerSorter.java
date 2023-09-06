package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegerSorter implements Sorter<Integer>{
    @Override
    public StringBuilder run(Scanner sc, String sortingType) {
        ArrayList<Integer> numbers = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            // write your code here
            numbers.add(number);
        }
        stringBuilder.append(String.format("Total numbers: %d.\nSorted data:", numbers.size()));
        sort(numbers).forEach(number -> stringBuilder.append(String.format(" %d", number)));
        stringBuilder.append("\n");
        return stringBuilder;    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        if (arrayList.size() > 1) {
            int middle = arrayList.size() / 2;

            ArrayList<Integer> leftArray = sort(new ArrayList<>(arrayList.subList(0, middle)));
            ArrayList<Integer> rightArray = sort(new ArrayList<>(arrayList.subList(middle, arrayList.size())));

            sortedList.addAll(merge(leftArray, rightArray));
        } else {
            sortedList.addAll(arrayList);
        }
        return sortedList;
    }

    @Override
    public StringBuilder naturalSort(ArrayList<Integer> arrayList) {
        return null;
    }

    @Override
    public StringBuilder sortByCount(ArrayList<Integer> arrayList) {
        return null;
    }

    private ArrayList<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (left.size() != 0 && right.size() != 0) {
            if (left.get(0) < right.get(0)) {
                sortedList.add(left.remove(0));
            } else {
                sortedList.add(right.remove(0));
            }
        }
        if (left.size() == 0) {
            sortedList.addAll(right);
        } else {
            sortedList.addAll(left);
        }
        return sortedList;
    }
}
