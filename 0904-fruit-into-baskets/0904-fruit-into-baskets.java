class Solution {
    public int totalFruit(int[] fruits) {
        int res=0, l=0, r=0;
        int n=fruits.length;
        HashSet<Integer> hs=new HashSet<>();
        while(r<n){
            hs.add(fruits[r]);
            if(hs.size()>2 && hs.contains(fruits[l])){
                    hs.remove(fruits[l]);
                    l++;
            }

            if(hs.size()<=2){
                res=Math.max(res, r-l+1);
            }
            r++;
        }

        return res;
    }
}