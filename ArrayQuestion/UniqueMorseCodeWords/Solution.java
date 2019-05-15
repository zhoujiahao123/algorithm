package ArrayQuestion.UniqueMorseCodeWords;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    String []morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Set<String> set = new HashSet<>();
    public int uniqueMorseRepresentations(String[] words) {
        for(String s :words){
            StringBuilder builder = new StringBuilder();
            for(char c :s.toCharArray()){
                builder.append(morse[c - 97]);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
