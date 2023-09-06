package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public interface Sorter<T> {
    StringBuilder run(Scanner sc, String sortingType);
    ArrayList<T> sort(ArrayList<T> arrayList);
    StringBuilder naturalSort(ArrayList<T> arrayList);
    StringBuilder sortByCount(ArrayList<T> arrayList);
}
