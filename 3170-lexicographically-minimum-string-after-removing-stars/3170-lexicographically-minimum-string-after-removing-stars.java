class Pair implements Comparable<Pair>{
    char ch;
    int index;

    Pair(char ch, int index){
        this.ch=ch;
        this.index=index;
    }

    public int compareTo(Pair o){
        if(this.ch!=o.ch){
            return this.ch-o.ch;
        }
        else{
            return o.index-this.index;
        }
    }
}

class Solution {

    public String clearStars(String s) {
       int n=s.length();
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                Pair pair=pq.remove();

                int index=pair.index;
                hs.add(index);
                hs.add(i);
            }
            else{
                pq.add(new Pair(s.charAt(i), i));
            }
        }

        for(int i=0;i<n;i++){
            

            if(!hs.contains(i)){
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}