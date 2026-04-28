import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_4 {

    /*


theres total amnt of courses you have to take from 0 to numcourses-1
given an array of preeqs
prereq[i] = [ai, bi] where bi is the prereq to take the course ai
    ex. [0,1] means you have to take course 1 first to take course 0


i should return the order of courses you have to take to take numCourses-1 in the right order
    if many valid answers you can return any of the right ones
    if impossible to finish all courses return empty array


     */

    public static void main(String[] args) {

        int numCourses= 4;
        int[][]prereq = {
                //{course, prereq}
                {0, 1},
                {2, 0},
                {3, 1},
                {3, 2},
        }; // output should be 0,2,1,3


    }// END MAIN


    // input is numCourses and prerequesite double array
    // so numCourses -1 variable is equal to the number of rows and numCourses length is the realtime number starting at 1


    public int[] findOrder(int numCourses, int[][] prereq) {

        int[] orderClassesArray = new int[numCourses-1];
        List<List<Integer>> list = new ArrayList<>(); // so i can do my thing of the prereqs as a list all of them for the one course int

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] x : prereq) {
            list.get(x[1]).add(x[0]); // adding the def prereqs to my list then i need to make the list comprehensive
        } //so these are all the prereqs

        int [] visited = new int [numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {


        }// end for loop


        // either dfs or bfs but if i were to visually represent this graph should i go deep or wide
        // it would be the node with no prereq at the start like but it could branch into multiple
        // so if two were at the same level it would mean they have the same prereq for their course so i would want to go
        // so i go deeper so i can see all the prereqs i need for the fatherst course down and then i can do that for each one


        /*
        so if i start at one of the courses i would go to the other courses and see if they are connected
        but is this a graph representation like are teh no the connections are like by should i do like a search vibe or if statemtn
         */

        // so what i want to do is traverse the array kind of like the reconstruction of dijkstra to me
        // so im going to like traverse the list starting at the course i want to take a make a list of prereqs?
    // so im thinking of i look at the courses and make sure the graph is connected and not a cycle
        // so im just checking for cycles ? basically or if disconnected like if i wanted to take class 3 but theres no way tot take it
        // or i dont think that is possible because they come in pairs


        /*

        so can i just make a separate list, loop through the graph and see who has which prereqs, and then like put it in a stack that numerical like sorting my stack?
       no cause even on the eample i put you need two like they arent always going to be in numerical order

         */


        return orderClassesArray;
    }// END FINDORDER



    public boolean DFSMethod(int node, List<List<Integer>> prereq, int[] visited, Stack<Integer> stack) {

        return false;
    } // END DFSMETHOD

} //LAST BRACKET END CLASS
