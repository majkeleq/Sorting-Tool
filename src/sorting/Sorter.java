package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public interface Sorter<T> {
    StringBuilder run(Scanner sc);
    ArrayList<T> sort(ArrayList<T> arrayList);
}
