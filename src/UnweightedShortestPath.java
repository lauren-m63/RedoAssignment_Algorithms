import java.util.*;

public class UnweightedShortestPath {
// similar to 4 in assignment 7 but the other one another recursive method
    // resurive not as good since im gdoing the levels and using FIFI queue -recusrion wants last in first out


    public static void main (String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int start = 0;
        int end = 4;

        List<Integer> path = getShortestPath(graph, start, end);
        if  (path.isEmpty()) {
            System.out.println("main: No path found");
        }
        else{
            System.out.println("main: Shortest path found");
        }



    }//END MAIN


    public static List<Integer> getShortestPath (int[][] graph, int start, int end) {
        // for bfs you are given a adjacency matrix, the starting node, and the goal node



        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[]parents = new int[n]; // parent[i] is the node you came from the reach i - like the prev hashmap in dijktra or just the same thing maybe

        Arrays.fill(parents, -1); // helper so everything is -1 so its like no parents no visited yet because if they havent been visited they stay -1

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start); // adding it because i am about to visit it, queue is what i will need to process and visited is what i have already processed

        while (!queue.isEmpty()) {
            int current = queue.poll(); // get the node, fifo so you process them in order like traffic

            if (current == end) {
                break; // if im at the goal
            }

            for (int i=0; i<n; i++){// for the entire adjancey matrix since im searching for a goal
                if (graph[current][i] !=0  && !visited[i]) {  // if the row im on is a neighbor and it has not been visited yet
                        // graph current = row, i is the column of the so you are looking at one node and checking it against the other nodes to see if its a neighbor
                    visited[i] = true;
                    parents[i] = current;
                    queue.add(i);
                }// end if
            }


        }// end while loop

        //if (ive visited all of them so queue is empty)
            // there is no way to get to connection return

        if (!visited[end]) {
            return new ArrayList<Integer>();
        }

        // returning the path for parents[child]= parent  so it goes from end to start since its added as i go
        // i want to make a new list returnign this so im going to go through the parents array and add the child

        List<Integer> pathFound = new ArrayList<>();
//        for (int i= 0; i<parents.length; i++){
//            if (parents[i] != -1){
//                pathFound.add(i);
//            } //
//        }
        // this was just giving me all the nodes i looked at but not the path

        int curr = end;
        while (curr != -1) {
            pathFound.add(curr);
            curr = parents[curr];
        }

        System.out.println("Shortest path found from end(goal) to start");
        for (int node: pathFound) {
            System.out.print(node + " ");
        }
        System.out.println("");
        System.out.println("the matrix represenation");

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();// to separate my rows
        }


        return pathFound;

    }//END GETSHORTEST PATH


}// END CLASS LAST BRACKET











/*


Breadth first search (BFS)
It starts at a vertex then it visits all of them with a distance of 1 from it, then from 2, then so on  - so it goes to adjacent ones (distance of 1), then the ones with one in between (distance of 2), then the ones with two in between
Also not unique since if they have the same distance it is just random which one is visited first
Kind of the same as the other one, it stars at one then puts there adjacent ones in queue (enqueues) if they are not already in the visit set and then repeats
The vertices in the queue are called frontier- discovered but not visited yet
Uses a hashmap to store the distances
Uses add() method to put a vertex to frontierQueue since its a linked list that adds to the back of the queue since it visits the oldest ones first so the first in first out traffic vibe

Differences
BFS: uses queue, based on vertexes, inefficient for memory, wide and short tree, oldest unvisited vertices are explored first, best for finding the shortest distance not in cost
So this one explores each level in full first before going down
Uses FIFO- firs in first out
Since you visit all the closest neighbors first before going down another level and process them in the same order you discovered them- so you see its on the same level and immediately go to it - since it goes to your neighbor then your neighbors neighbor and so on you have to take the shortest edge to get there/ shortest distance
This is only true if the edges are unweighted it doesn't think about cost its just like actual distance
Its inefficient for memory because if theres a bunch of nodes on that level then the queue gets really big and you have to keep adding things to the queue - the enqueue operation is just 1 for time but the space gets crazy because it stores the whole level where with the other one it just stores the one chain all the way down- so for this one it has to store the whole level across so if it branches hella then it can get really big, but the other one will just do the height of the tree in the stack at one time and explore all of them and pop as it goes
DFS: stack, efficient for memory, makes a narrow and long tree, vertices along edge are explored at the beginning
This one goes all the way down one
Uses LIFO- last in first out
Since it uses the oldest node added to explore more neighbors it doesn’t go to like the closest one it picks one close on then looks at all their neighbors and picks one of those and adds all their neighbors so you end up going like all the way down



the parent array is back pointers not list of relationships i can follow
frog - girl - dog
        |
        rabbit


parents[frog] = -1
parents[girl] = frog
parents [rabbit] = girl
parents [dog] = girl

so me reading through my parents list would give me this but what i actually
would want is the frog girl dog because that is an actual chain not everything that is connected
parents doesnt store a path it is my for each node who did i come from so i cant just list it
then when i print im showing all the nodes with a parent in my og one so


 */