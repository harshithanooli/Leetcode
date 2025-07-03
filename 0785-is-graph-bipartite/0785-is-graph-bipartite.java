class Solution {

    public boolean dfs(int[][] graph,int[] color, int node, int c){
        color[node]=c;

        for(int adjNode : graph[node]){
            if(color[adjNode]==-1){
                if(dfs(graph, color, adjNode, 1-c)==false){
                    return false;
                }
            }

            else if(color[adjNode] == c){
                return false;
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++)
            color[i]=-1;
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1 && dfs(graph, color, i, 0)==false){
                return false;
            }
        }

        return true;


    }
}