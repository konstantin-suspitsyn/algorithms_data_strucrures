package algorithms.grokking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchOrderedList {

    ArrayList<Integer> searchIntegersHere = new ArrayList<>();
    ArrayList<String> searchStringsHere = new ArrayList<>();

    /** Reads file with list of integers and returns ArrayList
     *
     * @param pathToListOfIntegers path to file with list of integers. Integers have to be ordered A->Z
     * @throws FileNotFoundException if File is not found
     */
    public void setSearchIntegersHere(String pathToListOfIntegers) throws FileNotFoundException {

        Scanner file = new Scanner(new File(pathToListOfIntegers));

        while (file.hasNext()){
            searchIntegersHere.add(Integer.valueOf(file.next()));
        }
        file.close();

    }

    /** Reads file with list of integers and returns ArrayList
     *
     * @param pathToListOfStrings path to file with list of string. Integers have to be ordered A->Z
     * @throws FileNotFoundException if File is not found
     */
    public void setSearchStringsHere(String pathToListOfStrings) throws FileNotFoundException {

        Scanner file = new Scanner(new File(pathToListOfStrings));

        while (file.hasNext()){
            searchStringsHere.add(file.nextLine());
        }
        file.close();

    }

    /**
     *
     * @param wasFound
     * @param searchForValue
     * @param stepsCount
     * @param foundPosition
     * @return
     */
    private String printOfFoundData(boolean wasFound, String searchForValue, int stepsCount, int foundPosition) {
        String printer;

        if (wasFound) {
            printer = "Value '" + searchForValue + "' was found on position " +
                    foundPosition + ". Made " + stepsCount + " steps";
        } else {
            printer = "Value '" + searchForValue + "' was NOT found. Made " + stepsCount + " steps";
        }

        return printer;

    }

    private String printOfFoundData(boolean wasFound, int searchForValue, int stepsCount, int foundPosition) {
        return printOfFoundData(wasFound, String.valueOf(searchForValue), stepsCount, foundPosition);
    }

    /** Compares two words
     *
     * @param wordToCompare Word we are looking for in @wordCompareWith
     * @param wordCompareWith Word we are comparing @wordToCompare with
     * @return If wordToCompare == wordCompareWith returns 0
     *         -1 means we should continue search from the left part (middle -1) in function isInOrderedList
     *         1 means we should continue search from the left part (middle +1) in function isInOrderedList
     *         6 is error
     */
    private int stringComparison(String wordToCompare, String wordCompareWith) {
        if (wordCompareWith.equals(wordToCompare)) {
            return 0;
        }

        int minWordLength = Math.min(wordToCompare.length(), wordCompareWith.length());

        // if smallest word equals to same part of another word
        if (wordToCompare.substring(0, minWordLength).equals(wordCompareWith.substring(0, minWordLength))) {

            if (wordToCompare.length() > wordCompareWith.length()) {
                return 1;
            } else if (wordToCompare.length() < wordCompareWith.length()) {
                return -1;
            }
        }

        String[] partsWordToCompare = wordToCompare.split("");
        String[] partsWordCompareWith = wordCompareWith.split("");

        for (int i=0; i < minWordLength; i++) {
            // I'm splitting by every character, so the length of each string = 1
            if (partsWordCompareWith[i].charAt(0) > partsWordToCompare[i].charAt(0)) {
                return -1;
            }
            if (partsWordCompareWith[i].charAt(0) < partsWordToCompare[i].charAt(0)) {
                return 1;
            }
        }

        // Should never get here
        return 6;
    }

    /** Binary search in Ordered List
     *
     * @param searchForValue searched value
     * @param searchHere ArrayList Integers have to be ordered A->Z
     * @param printSolution if true will print where int was found (or not) and number of steps maid
     * @return true if value was found
     */
    public boolean isInOrderedList(int searchForValue, ArrayList<Integer> searchHere, boolean printSolution) {

        int stepsCount = 0;

        int start = 0;
        int end = searchHere.size() - 1;
        int middle = (start + end) / 2;

        while (start <= end) {

            stepsCount++;

            if (searchForValue > searchHere.get(middle)) {
                start = middle + 1;
                middle = (start + end) / 2;
            } else if (searchForValue < searchHere.get(middle)) {
                end = middle - 1;
                middle = (start + end) / 2;
            } else if ((searchForValue == searchHere.get(middle))) {

                if (printSolution) {
                    System.out.println(printOfFoundData(true, searchForValue, stepsCount, middle));
                }

                return true;

            }
        }

        if (printSolution) {
            System.out.println(printOfFoundData(false, searchForValue, stepsCount, 0));
        }

        return false;

    }

    /** Binary search in Ordered List
     *
     * @param searchForValue searched value
     * @param searchHere ArrayList Integers have to be ordered A->Z
     * @param printSolution if true will print where int was found (or not) and number of steps maid
     * @return true if value was found
     */

    public boolean isInOrderedList(String searchForValue, ArrayList<String> searchHere, boolean printSolution) {

        searchForValue = searchForValue.toLowerCase();

        int stepsCount = 0;

        int start = 0;
        int end = searchHere.size() - 1;
        int middle = (start + end) / 2;

        while (start <= end) {

            stepsCount++;

            int comparedValue = stringComparison(searchForValue, searchHere.get(middle));

            if (comparedValue == 1) {
                start = middle + 1;
                middle = (start + end) / 2;
            } else if (comparedValue == -1) {
                end = middle - 1;
                middle = (start + end) / 2;
            } else if (comparedValue == 0) {

                if (printSolution) {
                    System.out.println(printOfFoundData(true, searchForValue, stepsCount, middle));
                }

                return true;

            }
        }

        if (printSolution) {
            System.out.println(printOfFoundData(false, searchForValue, stepsCount, 0));
        }

        return false;

    }

    public static void main(String[] args) throws FileNotFoundException {

            BinarySearchOrderedList binSearch = new BinarySearchOrderedList();

            // Search in integer ordered list
            binSearch.setSearchIntegersHere(System.getProperty("user.dir") + "\\src\\ordered_numbers.txt");
            System.out.println(binSearch.isInOrderedList(1000, binSearch.searchIntegersHere, true));

            // Search in string ordered list
            binSearch.setSearchStringsHere(System.getProperty("user.dir") + "\\src\\oscar_movies.txt");
            System.out.println(binSearch.isInOrderedList("all that jazz", binSearch.searchStringsHere, true));

    }


}
