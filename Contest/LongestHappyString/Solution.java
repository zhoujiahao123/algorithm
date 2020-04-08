package algorithm.Contest.LongestHappyString;

public class Solution {
        public String longestDiverseString(int a, int b, int c) {
            return rec(a, b, c, 0, 0, 0, new StringBuilder());
        }

        public String rec(int a, int b, int c, int repeatA, int repeatB, int repeatC, StringBuilder res) {
            //判断哪个数是最大的
            if ((a >= b && a >= c || repeatB == 2 && a >= c || repeatC == 2 && a >= b) && repeatA < 2&&a>0) {
                return rec(a-1, b, c, repeatA + 1, 0, 0, res.append("a"));
            } else if ((b >= a && b >= c || repeatA == 2 && b >= c || repeatC == 2 && b >= a) && repeatB < 2&&b>0) {
                return rec(a, b-1, c, 0, repeatB + 1, 0, res.append("b"));
            } else if ((c >= a && c >= b || repeatA == 2 && c >= b || repeatB == 2 && c >= a) && repeatC < 2&&c>0) {
                return rec(a, b, c-1, 0, 0, repeatC + 1, res.append("c"));
            }
            return res.toString();
        }
}
