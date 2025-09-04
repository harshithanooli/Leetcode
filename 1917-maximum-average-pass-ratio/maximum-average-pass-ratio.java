
class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // [[3,5],[3,9],[4,5],[3,11]], 

        // 0.5/ 0.066
        // 0.333    0.0666
        // 0.8 0.0333
        // 0.2   0.06
        // 1.63

        PriorityQueue<double[]> pq=new PriorityQueue<double[]>((a,b) -> Double.compare(b[0],a[0]));

        for(int i=0;i<classes.length;i++){
           double pass = (double)classes[i][0];
           double total = (double)classes[i][1]; 
           double initialRatio = (double) (pass/total);

           double addedRatio = (double) ((pass+1.0)/(total+1.0));
            pq.add(new double[]{addedRatio-initialRatio, pass, total});
        }
        int students = extraStudents;
        while(students>0 && pq.size()>0){
            double[] top = pq.poll();
           // System.out.println(top[0] + " : "+top[1]);
           double initialRatio = (double) ((top[1]+1.0)/(top[2]+1.0));

           double addedRatio = (double) ((top[1]+2.0)/(top[2]+2.0));
            pq.add(new double[]{addedRatio-initialRatio, top[1]+1.0, top[2]+1.0});
            students--;
        }

        double res = 0.0;

        while(!pq.isEmpty()){
            double[] top = pq.poll();
            res=res+(double)(top[1]/top[2]);
        }

        return res/(double)classes.length;


    }
}