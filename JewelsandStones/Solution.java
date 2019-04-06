package JewelsandStones;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numJewelsInStones(String J, String S) {
        char chS[] = S.toCharArray();
        char chJ[] = J.toCharArray();
        int ans[] = new int['z' + 1];
        int result = 0;
        for (int i = 0; i < chS.length; i++) {
            ans[chS[i]]++;
        }
        for (int i = 0; i < chJ.length; i++) {
            result += ans[chJ[i]];
        }
        return result;
    }
}