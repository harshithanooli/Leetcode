class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<ArrayList<Integer>> horizontal=new ArrayList<ArrayList<Integer>>();
        List<ArrayList<Integer>> vertical=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<rectangles.length;i++){
            ArrayList<Integer> al=new ArrayList<Integer>();
            al.add(rectangles[i][0]);
            al.add(rectangles[i][2]);
            horizontal.add(al);

            al=new ArrayList<>();
            al.add(rectangles[i][1]);
            al.add(rectangles[i][3]);
            vertical.add(al);
        }

        Collections.sort(horizontal, (x,y) -> Integer.compare(x.get(0), y.get(0)));
        Collections.sort(vertical, (x,y) -> Integer.compare(x.get(0), y.get(0)));
        int horizontalCount=0, verticalCount=0;
        int start=horizontal.get(0).get(0), end=horizontal.get(0).get(1);
        for(int i=1;i<horizontal.size();i++){
            if(horizontal.get(i).get(0)<end){
                end=Math.max(end, horizontal.get(i).get(1));
            }
            else{
                horizontalCount++;
                start=horizontal.get(i).get(0);
                end=horizontal.get(i).get(1);
            }
        }
        System.out.println(horizontalCount);
        if(horizontalCount>=2){
            return true;
        }
        start=vertical.get(0).get(0);
        end=vertical.get(0).get(1);
        for(int i=1;i<vertical.size();i++){
            if(vertical.get(i).get(0)<end){
                end=Math.max(end, vertical.get(i).get(1));
            }
            else{
                verticalCount++;
                start=vertical.get(i).get(0);
                end=vertical.get(i).get(1);
            }
        }
        if(verticalCount>=2){
            return true;
        }

        return false;
    }
}