package sorting;

import java.util.*;

public class LongSorter implements Sorter<Long> {
    @Override
    public StringBuilder run(Scanner sc, String sortingType) {
        ArrayList<Long> numbers = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            // write your code here
            numbers.add(number);
        }
        numbers = sort(numbers);
        stringBuilder.append(String.format("Total numbers: %d.\n", numbers.size()));
        long max = numbers.get(numbers.size() - 1);
        long count = numbers.stream().filter(l -> l == max).count();
        long percentage = count * 100 / numbers.size();
        //stringBuilder.append(String.format("The greatest number: %d (%d time(s), %d%%).", max, count, percentage));
        stringBuilder.append(sortingType.equals("natural") ? naturalSort(numbers) : sortByCount(numbers));
        return stringBuilder;
    }

    @Override
    public ArrayList<Long> sort(ArrayList<Long> arrayList) {
        ArrayList<Long> sortedList = new ArrayList<>();
        if (arrayList.size() > 1) {
            int middle = arrayList.size() / 2;

            ArrayList<Long> leftArray = sort(new ArrayList<>(arrayList.subList(0, middle)));
            ArrayList<Long> rightArray = sort(new ArrayList<>(arrayList.subList(middle, arrayList.size())));

            sortedList.addAll(merge(leftArray, rightArray));
        } else {
            sortedList.addAll(arrayList);
        }
        return sortedList;
    }

    private ArrayList<Long> merge(List<Long> left, List<Long> right) {
        ArrayList<Long> sortedList = new ArrayList<>();
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

    @Override
    public StringBuilder naturalSort(ArrayList<Long> arrayList) {
        ArrayList<Long> sortedList = sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sorted data:");
        sortedList.forEach(number -> stringBuilder.append(String.format(" %d", number)));
        //stringBuilder.append("\n");
        return stringBuilder;
    }

    @Override
    public StringBuilder sortByCount(ArrayList<Long> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<Long, Long> countMap = new TreeMap<>();
        int count = arrayList.size();
        arrayList.forEach(number -> countMap.put(number, countMap.getOrDefault(number, 0L) + 1));
        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(set -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", set.getKey(), set.getValue(), set.getValue() / count)));
        //countMap.entrySet().stream().sorted().forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        //countMap.forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        return stringBuilder;
    }
}
