class Pair{
    String word;
    int steps;

    Pair(String word, int steps){
        this.word=word;
        this.steps=steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.length()!=endWord.length()){
            return 0;
        }
        Set<String> s = new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            s.add(wordList.get(i));
        }

        Queue<Pair> q =new LinkedList<>();

        q.add(new Pair(beginWord, 1));

        s.remove(beginWord);

        while(!q.isEmpty()){
            
            String word = q.peek().word;
            int steps = q.peek().steps;

            q.poll();

            if(word.equals(endWord))
                return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){             
                    String replacedWord = word.substring(0, i)+ch+word.substring(i+1, word.length());
                    if(s.contains(replacedWord)) {
                        s.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
            
        }

        return 0;


    }
}