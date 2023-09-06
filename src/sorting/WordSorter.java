package sorting;

import java.util.*;

public class WordSorter implements Sorter<String>{
    @Override
    public StringBuilder run(Scanner sc, String sortingType) {
        ArrayList<String> words = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNext()) {
            String word = sc.next();
            // write your code here
            words.add(word);
        }
        words = sort(words);
        stringBuilder.append(String.format("Total words: %d.\n", words.size()));
        String max = words.get(words.size() - 1);
        long count = words.stream().filter(l -> l.equals(max)).count();
        long percentage = count * 100 / words.size();
        //stringBuilder.append(String.format("The longest word: %s (%d time(s), %d%%).", max, count, percentage));
        stringBuilder.append(sortingType.equals("natural") ? naturalSort(words) : sortByCount(words));
        return stringBuilder;    }

    @Override
    public ArrayList<String> sort(ArrayList<String> arrayList) {
        arrayList.sort(Comparator.comparingInt(String::length));
        return arrayList;
    }

    @Override
    public StringBuilder naturalSort(ArrayList<String> arrayList) {
        ArrayList<String> sortedList = sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sorted data:");
        sortedList.forEach(word -> stringBuilder.append(String.format(" %s", word)));
        //stringBuilder.append("\n");
        return stringBuilder;
    }

    @Override
    public StringBuilder sortByCount(ArrayList<String> arrayList) {

        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<String, Long> countMap = new TreeMap<>();
        int count = arrayList.size();
        arrayList.forEach(word -> countMap.put(word, countMap.getOrDefault(word, 0L) + 1));
        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(set -> stringBuilder.append(String.format("%s: %d time(s), %d%%\n", set.getKey(), set.getValue(), set.getValue() / count)));
        //countMap.entrySet().stream().sorted().forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        //countMap.forEach((key, value) -> stringBuilder.append(String.format("%d: %d time(s), %d%%\n", key, value, key / count)));
        return stringBuilder;

    }
}
