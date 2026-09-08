class Solution {
    //Edge class
    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    //Creating Graph
    private void createGraph(ArrayList<Edge> [] graph, List<List<Integer>> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            graph[i] = new ArrayList <> ();

            for (int k: rooms.get(i)) {
                graph[i].add(new Edge(i, k));
            }
        }
    }

    //BFS Traversal
    private void BFS(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue <Integer> q = new LinkedList <> ();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //Main Fnx
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Edge>[] graph = new ArrayList[rooms.size()];
        createGraph(graph, rooms);

        //BFS Traversal
        boolean[] vis = new boolean[rooms.size()];
        BFS(graph, vis);

        //Checking path
        for (boolean v: vis) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}