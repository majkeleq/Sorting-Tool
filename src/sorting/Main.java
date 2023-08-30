package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        SortingTool sortingTool = new SortingTool();
        //String dataType = "word";
        String dataType = "word";
        if(args.length != 0) {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-sortIntegers") || dataType.equals("sortIntegers")) {
                    dataType = "sortIntegers";
                } else if (args[i].equals("-dataType")) dataType = args[i + 1];
            }
        }
        switch (dataType) {
            case "long" -> System.out.println(sortingTool.sortLong(sc));
            case "line" -> System.out.println(sortingTool.sortLine(sc));
            case "sortIntegers" -> System.out.println(sortingTool.sortIntegers(sc));
            default -> System.out.println(sortingTool.sortWord(sc));
        }

    }
}
