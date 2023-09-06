package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        String dataType = "word";
        //String dataType = "long";
        String sortingType = "natural";
        //String dataType = "sortIntegers";
        if(args.length != 0) {
            for (int i = 0; i < args.length; i += 2) {
                /*if (args[i].equals("-sortIntegers") || dataType.equals("sortIntegers")) {
                    dataType = "sortIntegers";
                } else*/ if (args[i].equals("-dataType")) dataType = args[i + 1];
                if (args[i].equals("-sortingType")) sortingType = args[i + 1];
            }
        }
        switch (dataType) {
            case "long" -> {
                LongSorter longSorter = new LongSorter();
                System.out.println(longSorter.run(sc, sortingType));
            }
            case "line" -> {
                LineSorter lineSorter = new LineSorter();
                System.out.println(lineSorter.run(sc, sortingType));
            }
            case "sortIntegers" -> {
                IntegerSorter integerSorter = new IntegerSorter();
                System.out.println(integerSorter.run(sc, sortingType));
            }
            default -> {
                WordSorter wordSorter = new WordSorter();
                System.out.println(wordSorter.run(sc, sortingType));
            }
        }

    }
}
