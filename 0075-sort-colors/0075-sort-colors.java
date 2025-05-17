class Solution {
    public void sortColors(int[] a) {
        int it=0, l=0, r=a.length-1;

        while(l<=r && it<=r){
            if(a[it]==0){
                int temp=a[l];
                a[l]=a[it];
                a[it]=temp;
                l++;
                it++;

            }
            else if(a[it]==2){
                int temp=a[r];
                a[r]=a[it];
                a[it]=temp;
                r--;

            }
            else{
            it++;
            }
            
        }
    }
}