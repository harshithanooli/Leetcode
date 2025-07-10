class Solution {
    public boolean dfs(boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjList, int node){
        visited[node]=true;
        pathVisited[node]=true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                if(dfs(visited, pathVisited, adjList, adjNode)){
                    return true;
                }
            }

            else if(pathVisited[adjNode]){
                return true;
            }
        }

        pathVisited[node]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList  =  new ArrayList<>();
        for(int i=0;i<=numCourses;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // Stack<Integer> st =new Stack<>();
        boolean[] visited = new boolean[numCourses+1];
        boolean[] pathVisited = new boolean[numCourses+1];
        for(int i=0;i<=numCourses; i++){
            if(!visited[i]){
                if(dfs(visited, pathVisited, adjList, i))
                    return false;
            }           
        }

        return true;
    }
}