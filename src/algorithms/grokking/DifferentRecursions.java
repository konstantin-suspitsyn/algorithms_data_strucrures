package algorithms.grokking;

import java.util.ArrayList;

public class DifferentRecursions {
    /**
     * Sum of elements in ArrayList using recursion
     * @param numbersToSum ArrayList<Integer> with different ints
     * @return int Sum
     */
    public static int sumUsingRecursion(ArrayList<Integer> numbersToSum) {
        if (numbersToSum.size() == 1) {
            return numbersToSum.get(0);
        } else {
            ArrayList<Integer> numbersToSumCopy = new ArrayList<>(numbersToSum.subList(1, numbersToSum.size()));
            return numbersToSum.get(0) + sumUsingRecursion(numbersToSumCopy);
        }
    }

    /**
     * Counting number of elements using recursion
     * @param numbersToCount ArrayList<Integer> with different ints
     * @return counted ints
     */
    public static int countUsingRecursion(ArrayList<Integer> numbersToCount) {
        if (numbersToCount.isEmpty()) {
            return 0;
        } else {
            numbersToCount.remove(0);
            return 1 + countUsingRecursion(numbersToCount);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbersToSum = new ArrayList<>();
        numbersToSum.add(1);
        numbersToSum.add(2);
        numbersToSum.add(3);
        numbersToSum.add(4);
        numbersToSum.add(5);

        System.out.println(sumUsingRecursion(numbersToSum));

        System.out.println(countUsingRecursion(numbersToSum));


    }

}
