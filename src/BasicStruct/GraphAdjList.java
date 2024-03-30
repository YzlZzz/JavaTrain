package BasicStruct;

import java.util.*;

public class GraphAdjList {
    Map<Vertex, List<Vertex>> adjList;

    public GraphAdjList(Vertex[][] edges){
        this.adjList = new HashMap<>();

        for (Vertex[] edge : edges) {
            if(!adjList.containsKey(edge[0])){
                addVertex(edge[0]);
            }
            if(!adjList.containsKey(edge[1])){
                addVertex(edge[1]);
            }

            addEdge(edge[0], edge[1]);
        }
    }

    public List<Vertex> graphBFS(Vertex startVertex){
        List<Vertex> list = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();

        visited.add(startVertex);

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(startVertex);

        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            list.add(v);
            for (Vertex adjVertex : adjList.get(v)) {
                if(visited.contains(adjVertex)) continue;

                queue.offer(adjVertex);
                visited.add(adjVertex);
            }
        }
        return list;
    }

    public List<Vertex> graphDFS(Vertex startVertex){
        List<Vertex> list = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();

        dfs(list, visited, startVertex);
        return list;
    }

    private void dfs(List<Vertex> list, Set<Vertex> visited, Vertex startVertex){
        list.add(startVertex);
        visited.add(startVertex);

        for (Vertex adjVertex : adjList.get(startVertex)) {
            if(visited.contains(adjVertex)) continue;

            dfs(list, visited, adjVertex);
        }
    }

    public int size(){
        return adjList.size();
    }

    public void addEdge(Vertex v1, Vertex v2){
        if(!adjList.containsKey(v1) || !adjList.containsKey(v2)){
            throw new IllegalArgumentException();
        }

        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public void removeEdge(Vertex v1, Vertex v2){
        if(!adjList.containsKey(v1) || !adjList.containsKey(v2)){
            throw new IllegalArgumentException();
        }

        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
    }

    public void addVertex(Vertex v){
        if(adjList.containsKey(v)){
            throw new IllegalArgumentException();
        }

        adjList.put(v, new ArrayList<>());
    }

    public void removeVertex(Vertex v){
        if(!adjList.containsKey(v)){
            throw new IllegalArgumentException();
        }
        adjList.remove(v);

        for (List<Vertex> value : adjList.values()) {
            adjList.remove(v);
        }
    }

    public void print(){
        System.out.println(" Adjacency graph =");
        for (Map.Entry<Vertex, List<Vertex>> entry :adjList.entrySet()){
            List<Integer> temp = new ArrayList<>();
            for (Vertex vertex : entry.getValue()) {
                temp.add(vertex.val);
            }
            System.out.println(entry.getKey().val + " : " + temp + ",");
        }
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[] { 1, 3, 2, 5, 4 });
        Vertex[][] edges = { { v[0], v[1] }, { v[0], v[3] }, { v[1], v[2] },
                { v[2], v[3] }, { v[2], v[4] }, { v[3], v[4] } };
        GraphAdjList graph = new GraphAdjList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 即 v[0], v[2]
        graph.addEdge(v[0], v[2]);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 即 v[0], v[1]
        graph.removeEdge(v[0], v[1]);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        Vertex v5 = new Vertex(6);
        graph.addVertex(v5);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 即 v[1]
        graph.removeVertex(v[1]);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
