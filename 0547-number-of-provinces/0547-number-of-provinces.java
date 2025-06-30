class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];

        Stack<Integer> s=new Stack<>();
        
        int res=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){

                res++;
                s.push(i);

                while(!s.isEmpty()){
                    int node = s.peek();
                    s.pop();
                    visited[node]=true;
                    for(int j=0;j<isConnected[node].length;j++){
                        if(isConnected[node][j]==1 && !visited[j]){
                            s.push(j);
                        }
                    }
                }
            }
        }
        return res;
    }
}