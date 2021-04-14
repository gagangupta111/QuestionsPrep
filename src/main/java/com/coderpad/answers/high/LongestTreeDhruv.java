package com.coderpad.answers.high;

/**
 * *  Given a forest ( one or more disconnected trees ), find the root of largest tree
 * *  and return its Id. If there are multiple such roots, return the smallest Id of them.
 * *
 * *  Complete the largestTree function in the editor below.
 * *  It has one parameter, immediateParent, which is a map containing key-value pair indicating
 * *  child -> parent relationship. The key is child and value is the corresponding
 * *  immediate parent.
 * *  Constraints
 * *    - Child cannot have more than one immediate parent. : //TODO: who will enforce this??? Is it edge cases to be considered.....
 * *    - Parent can have more than one immediate child.
 * *    - The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
 * *
 * *  Example:
 * *
 * *  Input:
 * *  { { 1 -> 2 }, { 3 -> 4} }
 * *
 * *  Expected output: 2
 * *  Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
 * *  Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.
 */
import java.util.*;
        import java.util.stream.Collectors;



public class LongestTreeDhruv {

    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        //What are all possible root from given map,
   /*
    * // 2->3 ->1
         // (7,9)->8->
         // 5->[12,13,11] ->15
            put( 2, 3 );
            put( 7, 8 );
            put( 12, 15 );
            put( 3, 1 );
            put( 13, 15 );
            put( 11, 15 );
            put( 9, 8 );put( 5, 12 );
             {33=28, 34=31, 35=33, 21=23, 22=29, 25=21, 28=25, 29=27, 31=22}
            // 35 ->33 ->28 ->25->21 ->23
            //  34 ->31 ->22 ->29 ->27            */
        // create a map with mapping from parent to child
        Map<Integer, HashSet<Integer>> parentToChildMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            int parent = entry.getValue();
            int child = entry.getKey();
            // if parent is already present add the child to existing set of children else create a new entry
            if (parentToChildMap.containsKey(parent)) {
                parentToChildMap.get(parent).add(child);
            } else {
                parentToChildMap.put(parent, new HashSet<>(Arrays.asList(child)));
            }
            // if the child is present as parent in map, add all the children associated with it to the parent
            if (parentToChildMap.containsKey(child)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.addAll(parentToChildMap.get(child));
                while (!queue.isEmpty()) {
                    int val = queue.poll();
                    if (parentToChildMap.containsKey(val)) {
                        queue.addAll(parentToChildMap.get(val));
                    }
                    parentToChildMap.get(parent).add(val);
                }
            }
            // get a list of parents where the above parent is a child to them
            List<Integer> parentsList = parentToChildMap.entrySet().stream().filter(e -> e.getValue().contains(parent)).map(Map.Entry::getKey).collect(Collectors.toList());
            // for the above parents add all the childrent to them
            for (Integer parentKey : parentsList) {
                parentToChildMap.get(parentKey).addAll(parentToChildMap.get(parent));
            }
        }
        System.out.println(parentToChildMap);
        // create a map with key as the size of the hashset and value as the list of parents with that size
        Map<Integer, List<Integer>> countMap = parentToChildMap.entrySet().stream().collect(Collectors.groupingBy(e -> e.getValue().size(), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(countMap);
        // get the max key from the above map
        int maxKey = countMap.keySet().stream().mapToInt(key -> key).max().orElse(0);
        // get the min value for the max key
        return countMap.get(maxKey).stream().mapToInt(val -> val).min().orElse(0);
    }
    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // map of test cases to expected results
        final Map<Map<Integer, Integer>, Integer> testCases = new HashMap<>();
        // example
        final Map<Integer, Integer> testCaseOneKey = new HashMap<Integer, Integer>() {
            {
                put(1, 2);
                put(3, 4);
            }
        };
        testCases.put(testCaseOneKey, 2);
        // More than two trees
        final Map<Integer, Integer> testCaseTwoKey = new HashMap<Integer, Integer>() {{
            // 2->3 ->1
            // (7,9)->8->
            // 5->[12,13,11] ->15
            put(2, 3);
            put(7, 8);
            put(12, 15);
            put(3, 1);
            put(13, 15);
            put(11, 15);
            put(9, 8);
            put(5, 12);
        }};
        testCases.put(testCaseTwoKey, 15);
        // really large index values
        final Map<Integer, Integer> testCaseThreeKey = new HashMap<Integer, Integer>() {{
            put(200000000, 300000000); //5 ,(2,7), 3
            put(500000000, 200000000);
            put(700000000, 300000000); //
            put(600000000, 700000000); //8,9,10,100 ->4
            put(900000000, 400000000); //
            put(100000000, 400000000);
            put(800000000, 400000000);
            put(1000000000, 400000000);
        }};
        testCases.put(testCaseThreeKey, 300000000);
        // two trees of same size
        final Map<Integer, Integer> testCaseFourKey = new HashMap<Integer, Integer>() {{
            put(9, 4);
            put(1, 4); // (1,8,9,10) ->4
            put(5, 2); //  5 ->2
            put(8, 4);
            put(7, 3); // (6 ->7 ,2) ->3
            put(2, 3);
            put(6, 7);
            put(10, 4);
        }};
        testCases.put(testCaseFourKey, 3);
        // tree sizes differ by one
        final Map<Integer, Integer> testCaseFiveKey = new HashMap<Integer, Integer>() {{
            put(35, 33); // 35 ->33 ->28 ->25->21 ->23
            put(33, 28);
            put(31, 22); // 34 ->31 ->22 ->29 ->27
            put(28, 25);
            put(34, 31);
            put(29, 27);
            put(21, 77);
            put(25, 21);
            put(22, 29);
        }};
        testCases.put(testCaseFiveKey, 77);
        boolean passed = true;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
            final Integer actual = largestTree(entry.getKey());
            if (!actual.equals(entry.getValue())) {
                passed = false;
                System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }
        return passed;
    }
    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}