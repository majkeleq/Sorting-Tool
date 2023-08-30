package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LineSorter implements Sorter<String>{
    @Override
    public StringBuilder run(Scanner sc) {
        ArrayList<String> lines = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // write your code here
            lines.add(line);
        }
        lines = sort(lines);
        stringBuilder.append(String.format("Total lines: %d.\n", lines.size()));
        String max = lines.get(lines.size() - 1);
        long count = lines.stream().filter(l -> l.equals(max)).count();
        long percentage = count * 100 / lines.size();
        stringBuilder.append(String.format("The longest line:\n%s\n(%d time(s), %d%%).", max, count, percentage));
        return stringBuilder;
    }

    @Override
    public ArrayList<String> sort(ArrayList<String> arrayList) {
        arrayList.sort(Comparator.comparingInt(String::length));
        return arrayList;
    }
}
