package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WordSorter implements Sorter<String>{
    @Override
    public StringBuilder run(Scanner sc) {
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
        stringBuilder.append(String.format("The longest word: %s (%d time(s), %d%%).", max, count, percentage));
        return stringBuilder;    }

    @Override
    public ArrayList<String> sort(ArrayList<String> arrayList) {
        arrayList.sort(Comparator.comparingInt(String::length));
        return arrayList;
    }
}
