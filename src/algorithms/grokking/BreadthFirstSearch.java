package algorithms.grokking;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {

    int vertex;
    LinkedList<Integer> list[];

    public BreadthFirstSearch(int vertex) {
        this.vertex = vertex;

        list = new LinkedList[vertex];

        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }

    }

    public void addEdgeOneDirection(int start, int end) {
        // for bidirectional graphs
        list[start].addFirst(end);
    }

    public void addEdgeBiDirectional(int start, int end) {
        // for bidirectional graphs
        list[start].addFirst(end);
        list[end].addFirst(start);
    }

    public void printBreadthFirstSearch() {
        System.out.println("Graph representation:");
        for (int i = 0; i < list.length; i++) {
            String lineOut = i + " → ";
            for(int j = 0; j < list[i].size(); j++) {
                lineOut = lineOut + list[i].get(j) + " ";
            }
            System.out.println(lineOut);
        }
    }

    public int searchFromStartToFinish(int start, int finish) {

        boolean wasFound = false;

        int numberOfSteps = 0;
        // Values that were checked already
        ArrayList<Integer> checkedValues = new ArrayList<>();
        ArrayList<Integer> toCheckValues = new ArrayList<>();

        toCheckValues.add(start);

        System.out.println("We have searched way from " + start + " to " + finish);

        while (!toCheckValues.isEmpty() & !wasFound) {
            numberOfSteps ++;

            // Filling this list with values to check next time
            ArrayList<Integer> toCheckValuesNext = new ArrayList<>();

            int currentSize = toCheckValues.size();
            for (int i = 0; i < currentSize; i++) {
                int currentValue = toCheckValues.get(i);
                checkedValues.add(currentValue);
                for (int j = 0; j < list[currentValue].size(); j++) {
                    if (list[currentValue].get(j) == finish) {
                        System.out.println("Value was found. You need " + numberOfSteps + " steps \n");
                        wasFound = true;
                        return numberOfSteps;
                    } else {
                        if (!checkedValues.contains(list[currentValue].get(j))) {
                            toCheckValuesNext.add(list[currentValue].get(j));
                        }
                    }
                }
            }
            toCheckValues = toCheckValuesNext;
        }

        if (wasFound == false) {
            System.out.println("There is no way \n");
        }
        return -1;
    }

    public static void main (String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(5);
        // Adding edges
        breadthFirstSearch.addEdgeOneDirection(0, 1);
        breadthFirstSearch.addEdgeOneDirection(0, 4);
        breadthFirstSearch.addEdgeOneDirection(1, 3);
        breadthFirstSearch.addEdgeOneDirection(1, 4);
        breadthFirstSearch.addEdgeOneDirection(2, 3);
        breadthFirstSearch.addEdgeOneDirection(3, 4);
        // Graph representation
        breadthFirstSearch.printBreadthFirstSearch();
        // Searching
        breadthFirstSearch.searchFromStartToFinish(0, 1);
        // Searching
        breadthFirstSearch.searchFromStartToFinish(0, 3);
        // Searching
        breadthFirstSearch.searchFromStartToFinish(0, 2);
    }

}
