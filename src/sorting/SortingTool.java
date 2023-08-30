package sorting;

import java.util.*;

public class SortingTool {
    public SortingTool() {
    }

    public String sortLong(Scanner sc) {
        ArrayList<Long> numbers = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            // write your code here
            numbers.add(number);
        }
        numbers.sort(Long::compare);
        stringBuilder.append(String.format("Total numbers: %d.\n", numbers.size()));
        long max = numbers.get(numbers.size() - 1);
        long count = numbers.stream().filter(l -> l == max).count();
        long percentage = count * 100 / numbers.size();
        stringBuilder.append(String.format("The greatest number: %d (%d time(s), %d%%).", max, count, percentage));
        return stringBuilder.toString();
    }

    public String sortLine(Scanner sc) {
        ArrayList<String> lines = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // write your code here
            lines.add(line);
        }
        lines.sort(Comparator.comparingInt(String::length));
        stringBuilder.append(String.format("Total lines: %d.\n", lines.size()));
        String max = lines.get(lines.size() - 1);
        long count = lines.stream().filter(l -> l.equals(max)).count();
        long percentage = count * 100 / lines.size();
        stringBuilder.append(String.format("The longest line:\n%s\n(%d time(s), %d%%).", max, count, percentage));
        return stringBuilder.toString();
    }

    public String sortWord(Scanner sc) {
        ArrayList<String> words = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNext()) {
            String word = sc.next();
            // write your code here
            words.add(word);
        }
        words.sort(Comparator.comparingInt(String::length));
        stringBuilder.append(String.format("Total words: %d.\n", words.size()));
        String max = words.get(words.size() - 1);
        long count = words.stream().filter(l -> l.equals(max)).count();
        long percentage = count * 100 / words.size();
        stringBuilder.append(String.format("The longest word: %s (%d time(s), %d%%).", max, count, percentage));
        return stringBuilder.toString();
    }

    public StringBuilder sortIntegers(Scanner sc) {
        ArrayList<Integer> numbers = new ArrayList<>();//added
        StringBuilder stringBuilder = new StringBuilder();
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            // write your code here
            numbers.add(number);
        }
        stringBuilder.append(String.format("Total numbers: %d.\nSorted data:", numbers.size()));
        mergeSort(numbers).forEach(number -> stringBuilder.append(String.format(" %d", number)));
        stringBuilder.append("\n");
        return stringBuilder;
    }

    private ArrayList<Integer> mergeSort(List<Integer> numbers) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        if (numbers.size() > 1) {
            int middle = numbers.size() / 2;

            ArrayList<Integer> leftArray = mergeSort(numbers.subList(0, middle));
            ArrayList<Integer> rightArray = mergeSort(numbers.subList(middle, numbers.size()));

            sortedList.addAll(merge(leftArray, rightArray));
        } else {
            sortedList.addAll(numbers);
        }
        return sortedList;
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
