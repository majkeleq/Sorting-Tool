package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class LongSorter implements Sorter<Long>{
    @Override
    public StringBuilder run(Scanner sc) {
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
        stringBuilder.append(String.format("The greatest number: %d (%d time(s), %d%%).", max, count, percentage));
        return stringBuilder;
    }

    @Override
    public ArrayList<Long> sort(ArrayList<Long> arrayList) {
        arrayList.sort(Long::compare);
        return arrayList;
    }
}
