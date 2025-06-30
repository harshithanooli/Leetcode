class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
       
            visited[node]=true;

            for(int adjNode : adjList.get(node)){
                if(!visited[adjNode])
                    dfs(adjNode, adjList, visited);
            }
        

        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean visited[]= new boolean[isConnected.length];
        // Stack<Integer> s = new Stack<>();
        // for(int i=0;i<isConnected.length;i++){
        //     if(!visited[i]){
        //         res++;
        //         s.push(i);

        //         while(!s.isEmpty()){
        //             Integer node = s.pop();
        //             visited[node]=true;

        //             for(int j=0;j<isConnected[node].length;j++){
        //                 if(isConnected[i][j]==1 && !visited[j]){
        //                     s.push(j);
        //                 }
        //             }
        //         }
        //     }
        // }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<Integer>());
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1)
                    adjList.get(i).add(j);
            }
        }

        for(int i=0;i<adjList.size();i++){

            if(!visited[i]){
                res++;
                dfs(i, adjList, visited);
            }
        }

        return res;
    }
}