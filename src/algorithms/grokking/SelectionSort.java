package algorithms.grokking;

import java.util.ArrayList;

public class SelectionSort {
    public ArrayList<Integer> getSortedArray() {
        return sortedArray;
    }

    public ArrayList<Integer> getUnsortedArray() {
        return unsortedArray;
    }

    ArrayList<Integer> unsortedArray = new ArrayList<>();
    ArrayList<Integer> sortedArray = new ArrayList<>();

    public SelectionSort(ArrayList<Integer> unsortedArray) {
        this.unsortedArray = unsortedArray;
        sortIt();
    }

    /**
     * Super-simple sorting algorithm
     */
    private void sortIt() {
        while (this.unsortedArray.size() > 0) {
            Integer toCompare = this.unsortedArray.get(0);
            int position = 0;
            for (int i = 1; i < this.unsortedArray.size(); i++) {
                if (this.unsortedArray.get(i) < toCompare) {
                    toCompare = this.unsortedArray.get(i);
                    position = i;
                }
            }
            this.sortedArray.add(toCompare);
            this.unsortedArray.remove(position);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<>();
        unsortedArray.add(5);
        unsortedArray.add(-6);
        unsortedArray.add(-12);
        System.out.println("Unsorted:");
        System.out.println(unsortedArray);
        SelectionSort selectionSort = new SelectionSort(unsortedArray);
        System.out.println("Sorted:");
        System.out.println(selectionSort.getSortedArray());
    }

}
