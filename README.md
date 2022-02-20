# Algorithms and data structures from scratch

This code was made after reading book <b>"Grokking Algorithms"</b>

All code is in ```algorithms.grockking``` package
#### Chapter 1
- [x] Binary search in ordered list (```algorithms.grokking.BinarySearchOrderedList.java```)
<br>Each turn you are dividing dataset in two parts in the middle, then taking one of the parts where your searched 
item should be, based on ordering, until the value in the middle == your searched value or no data was left for you to search
#### Chapter 2
- [x] Sorting by choice (```SelectionSort.java```)<br>Simple algorithm when you go through the dataset over and over,
popping out biggest or smallest number each time

#### Chapter 3
- [x] Recursion (```algorithms.grokking.DifferentRecursions.java```)
<br>Self-calling algorithms with two stages — final stage and self-calling stage 
#### Chapter 4
- [x] Quick Sort (```QuickSort.java```)
<br>Recursion algorithm where you take out one value from dataset and split other data in two parts. 
<br>One part with data more or equal with picked number. Second part will have lesser numbers
<br>We do this over and over unless we have one element in data
#### Chapter 5
- Theoretical :smiley:
#### Chapter 6
- [x] Breadth-First Search (```BreadthFirstSearch.java```)
<br>This is the graph algorithm. I'll use Adjacency List (based on LinkedList) for graphs data representation.