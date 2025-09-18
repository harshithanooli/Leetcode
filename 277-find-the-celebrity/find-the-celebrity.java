/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
       
        for(int i=0;i<n;i++){
            boolean isCelebrity = true;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(knows(i,j)){
                    isCelebrity=false;
                    break;
                }
            }

            if(isCelebrity){
                for(int j=0;j<n;j++){
                    if(!knows(j,i)){
                        isCelebrity=false;
                        break;
                    }
                }
            }
           if(isCelebrity){
            return i;
           }
        }
        return -1;
    }
}