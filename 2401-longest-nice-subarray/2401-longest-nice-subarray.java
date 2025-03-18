class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        ArrayList<Long> al=new ArrayList<Long>();
        al.add((long)nums[0]);
        int res=al.size();
        for(int i=1;i<nums.length;i++){
            System.out.println(al);
            if(!al.isEmpty()){
                boolean flag=true;
                while(al.size()> 0 && (al.get(0)&nums[i])!=0){
                    al.remove(0);
                }
                for(int j=0;j<al.size();j++){
                    if((al.get(j)&nums[i])!=0){
                        flag=false;
                        break;
                    }
                }
                if(flag==false){
                    al=new ArrayList<Long>();
                }               
            }
            al.add((long)nums[i]);
            res=Math.max(res, al.size());
            
        }
        return res;
    }
}