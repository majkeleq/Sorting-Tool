package sorting;

import java.util.*;

public class LineSorter implements Sorter<String>{
    @Override
    public StringBuilder run(Scanner sc, String sortingType) {
        ArrayList<String> lines = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // write your code here
            lines.add(line);
        }
        lines = sort(lines);
        stringBuilder.append(String.format("Total lines: %d.\n", lines.size()));
        //String max = lines.get(lines.size() - 1);
        //long count = lines.stream().filter(l -> l.equals(max)).count();
        //long percentage = count * 100 / lines.size();
        //stringBuilder.append(String.format("The longest line:\n%s\n(%d time(s), %d%%).", max, count, percentage));
        //lines.forEach(line -> stringBuilder.append(String.format(" %s", line)));
        //stringBuilder.append("\n");
        stringBuilder.append(sortingType.equals("natural") ? naturalSort(lines) : sortByCount(lines));
        return stringBuilder;
    }

    @Override
    public ArrayList<String> sort(ArrayList<String> arrayList) {
        arrayList.sort(Comparator.comparingInt(String::length));
        return arrayList;
    }

    @Override
    public StringBuilder naturalSort(ArrayList<String> arrayList) {
        ArrayList<String> sortedList = sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sorted data:\n");
        sortedList.forEach(line -> stringBuilder.append(String.format("%s\n", line)));
        //stringBuilder.append("\n");
        return stringBuilder;
    }

    @Override
    public StringBuilder sortByCount(ArrayList<String> arrayList) {

        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<String, Long> countMap = new TreeMap<>();
        int count = arrayList.size();
        arrayList.forEach(line -> countMap.put(line, countMap.getOrDefault(line, 0L) + 1));
        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(set -> stringBuilder.append(String.format("%s: %d time(s), %d%%\n", set.getKey(), set.getValue(), set.getValue() / count)));
        //countMap.entrySet().stream().sorted().forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        //countMap.forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        return stringBuilder;

    }
}
