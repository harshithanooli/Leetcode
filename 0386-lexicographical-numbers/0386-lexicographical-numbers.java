class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            generate(i, n, res);
        }

        return res;
    }

    void generate(int num, int n,List<Integer> res){
        if(num>n){
            return;
        }
        res.add(num);
        for(int j=0;j<=9;j++){
            int temp = num*10+j;
            generate(temp, n, res);
        }
    }
}