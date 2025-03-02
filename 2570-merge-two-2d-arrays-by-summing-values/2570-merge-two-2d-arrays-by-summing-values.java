class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1=0, p2=0;
        List<int[]> res=new ArrayList<int[]>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1][0]==nums2[p2][0]){
                int[] ans=new int[2];
                ans[0]=nums1[p1][0];
                ans[1]=nums1[p1][1]+nums2[p2][1];
                res.add(ans);
                p1++;
                p2++;
            }
            else if(nums1[p1][0]>nums2[p2][0]){
                int[] ans=new int[2];
                ans[0]=nums2[p2][0];
                ans[1]=nums2[p2][1];
                res.add(ans);
                p2++;
            }
            else{
                int[] ans=new int[2];
                ans[0]=nums1[p1][0];
                ans[1]=nums1[p1][1];
                res.add(ans);
                p1++;
            }           
        }

        while(p1<nums1.length){
            int[] ans=new int[2];
                ans[0]=nums1[p1][0];
                ans[1]=nums1[p1][1];
                res.add(ans);
                p1++;
        }
         while(p2<nums2.length){
            int[] ans=new int[2];
                ans[0]=nums2[p2][0];
                ans[1]=nums2[p2][1];
                res.add(ans);
                p2++;
        }
        // int[][] result=new int[res.size()][2];
        // for(int i=0;i<res.size();i++){
        //     result[i]=res.get(i);
        // }
        return res.toArray(int[][]::new);
    }
}