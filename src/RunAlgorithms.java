import java.io.FileNotFoundException;

public class RunAlgorithms {

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
