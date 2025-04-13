class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++){
            String num=Integer.toString(i);
            if(num.length()%2==0){
                String first=num.substring(0, num.length()/2);
                String second=num.substring(num.length()/2, num.length());
                int firstSum=0, secondSum=0;
                for(int j=0;j<num.length()/2;j++){
                    firstSum=firstSum+Integer.valueOf(first.charAt(j));
                    secondSum=secondSum+Integer.valueOf(second.charAt(j));
                }
                if(firstSum==secondSum){
                    res++;
                }
            }
        }

        return res;
    }
}