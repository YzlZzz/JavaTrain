package Ch28;

import java.util.ArrayList;
import java.util.List;

public class NineTailModel {
    public final static int NUMBER_OF_NODES = 512;
    protected UnweightedGraph<Integer>.SearchTree tree;

    public NineTailModel(){
        List<Edge> edges = getEdges();

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_NODES);

        tree = graph.bfs(511);
    }

    private List<Edge> getEdges(){
        List<Edge> edges = new ArrayList<>();

        for(int u = 0; u < NUMBER_OF_NODES; u++){
            for(int k = 0; k < 9; k++){
                char[] node = getNode(u);
                if(node[k] == 'H'){
                    int v = getFlippedNode(node, k);
                    edges.add(new Edge(v, u));
                }
            }
        }
        return edges;
    }

    public static int getFlippedNode(char[] node, int position){
        int row = position / 3;
        int column = position % 3;

        flipACell(node, row, column);
        flipACell(node, row - 1, column);
        flipACell(node, row, column - 1);
        flipACell(node, row + 1, column);
        flipACell(node, row, column + 1);

        return getIndex(node);
    }

    public static int getIndex(char[] node){
        int result = 0;

        for(int i =0; i < 9; i++){
            if(node[i] == 'T') result = result * 2 + 1;
            else result = result * 2 + 0;
        }

        return result;
    }

    public static void flipACell(char[] node, int row, int column){
        if(row  >= 0 && row <= 2 && column >= 0 && column <= 2){
            if(node[row * 3 + column] == 'H') node[row * 3 + column] = 'T';
            else node[row * 3 + column] = 'H';
        }
    }

    public static char[] getNode(int index){
        char[] result = new char[9];

        for(int i = 0; i < 9; i++){
            int digit = index % 2;
            if(digit == 0) result[8-i] = 'H';
            else result[8-i] = 'T';
            index  /= 2;
        }
        return result;
    }

    public List<Integer> getShortestPath(int nodeIndex){
        return tree.getPath(nodeIndex);
    }

    public static void printNode(char[] node){
        for(int i = 0; i < 9; i++){
            if(i % 3 != 2) System.out.print(node[i]);
            else System.out.println(node[i]);
        }
        System.out.println();
    }
}
