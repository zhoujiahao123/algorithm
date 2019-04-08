package HammingDistance;

class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        //注意例如x = 1,y = 4，如果直接用下面的方法，得出的sx = 1,sy = 100.这样比较会出错啊！
        String sx = Integer.toBinaryString(x);
        String sy = Integer.toBinaryString(y);
        int lenX = sx.length();
        int lenY = sy.length();
        //为避免出现该问题，补0.
        if (lenX < lenY) {
            for (int i = 0; i < lenY - lenX; i++) {
                sx = '0' + sx;
            }
        } else if (lenY < lenX) {
            for (int i = 0; i < lenX - lenY; i++) {
                sy = '0' + sy;
            }
        }
        for (int i = 0; i < sx.length(); i++) {
            if (sx.charAt(i) != sy.charAt(i))
                result++;
        }
        return result;
    }
}