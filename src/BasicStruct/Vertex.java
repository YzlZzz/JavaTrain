package BasicStruct;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public int val;

    public Vertex(int val){
        this.val = val;
    }

    public static Vertex[] valsToVets(int[] vals){
        int n = vals.length;
        Vertex[] vertices = new Vertex[n];

        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(vals[i]);
        }
        return vertices;
    }

    public static List<Integer> vetsToVals(List<Vertex> vertices){
        List<Integer> vals = new ArrayList<>();
        for (Vertex v : vertices) {
            vals.add(v.val);
        }
        return vals;
    }
}
