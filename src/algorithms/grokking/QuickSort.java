package algorithms.grokking;

import java.util.ArrayList;

public class QuickSort {

    ArrayList<Integer> unsortedList = new ArrayList<>();

    public QuickSort() {
        for (int i = 0; i < 21; i++) {
            unsortedList.add((int) (Math.random()*1000));
        }
    }

    /**
     * Quick sort with pivot in index = 0
     * @param unsortedList ArrayList of integers. Creates randomly using random function
     * @return
     */
    public ArrayList<Integer> quickSort(ArrayList<Integer> unsortedList) {
        if (unsortedList.size() < 2) {
            return unsortedList;
        } else {
            int baseInt = unsortedList.get(0);
            unsortedList.remove(0);
            ArrayList<Integer> smaller = new ArrayList<>();
            ArrayList<Integer> bigger = new ArrayList<>();

            for (int value:
                 unsortedList) {
                if (value > baseInt) {
                    bigger.add(value);
                } else {
                    smaller.add(value);
                }
            }

            ArrayList<Integer> sm = quickSort(smaller);
            ArrayList<Integer> b = quickSort(bigger);

            sm.add(baseInt);
            sm.addAll(b);

            return sm;

        }
    }

    public ArrayList<Integer> getUnsortedList() {
        return unsortedList;
    }

    public static void main (String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println("Unsorted list:");
        System.out.println(quickSort.getUnsortedList());
        System.out.println("Sorted list:");
        System.out.println(quickSort.quickSort(quickSort.getUnsortedList()));
    }

}
