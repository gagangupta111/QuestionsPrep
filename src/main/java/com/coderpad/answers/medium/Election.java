package com.coderpad.answers.medium;

import java.util.*;

/**
 * Implement whoIsElected() correctly.
 */
public class Election {

    /**
     * A group of students are sitting in a circle. The teacher is electing a new class president.
     * The teacher does this by singing a song while walking around the circle. After the song is
     * finished the student at which the teacher stopped is removed from the circle.
     *
     * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
     * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
     *
     * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
     *
     * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
     * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
     *
     * @param n the number of students sitting in a circle.
     * @param k the length (in students) of each song.
     * @return the number of the student that is elected.

    Analysis :

    Create a list of all students like : 1, 2, 3 , 4, 5
    create a recursive function :

    removeStudent And Give Index to start again ( List students, int startIndex, int            length of song )
    this function will go through the list will remove the student and pass. back the current index.
    if index == length of students then index = 0 and return

    call above function recursively till the length of studnets > 1

     */

    public static int removeStudentReturnCurrentIndex(List<Integer> students, int startIndex, int k) {


        while( k-- > 1){

            startIndex++;
            if(startIndex == students.size()){

                startIndex = 0;
            }

        }


        students.remove(startIndex);

        if(startIndex == students.size()){

            startIndex = 0;
        }

        return startIndex;


    }
    public static int whoIsElected(int n, int k) {



        List<Integer> students = new ArrayList<>();

        for ( int i = 1; i <= n ; i++){

            students.add(i);

        }

        int startIndex = 0;
        while(students.size() > 1){

            startIndex = removeStudentReturnCurrentIndex(students,startIndex, k );

        }

        //your code

        return students.get(0);
    }

    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass() {

        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}

        int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };

        for (int[] testCase : testCases) {
            int answer = whoIsElected(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    /**
     * Execution entry point.
     */
    public static void main(String args[]) {
        doTestsPass();
    }
}