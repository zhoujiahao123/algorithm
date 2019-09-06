package algorithm.Coruse;

import java.util.Stack;

public class StableMatching {

    public static void main(String[] args) {
        //男人数组，manArrays[1][0]代表第二个男人最喜欢的女人,女人同理
        int manArray[][] = {{2, 3, 1, 0}, {2, 1, 3, 0}, {0, 2, 3, 1}, {1, 3, 2, 0}};
        int ladyArray[][] = {{0, 3, 2, 1}, {0, 1, 2, 3}, {0, 2, 3, 1}, {1, 0, 3, 2}};
        //男人选择的女人
        int ladyIsChooseByMan[] = new int[4];
        //男人准备求婚的女人
        int ladyIsReadyChooseByMan[] = new int[4];
        //一轮循环后还处于单身的男人
        Stack<Integer> singleDog = new Stack<>();
        //女性选择的男性，若未-1则代表还没有被追求过
        int ladyChoose[] = {-1, -1, -1, -1, -1};
        //第一轮循环，每个男人都像自己最喜欢的女生进行求婚
        for (int manNum = 0; manNum < 4; manNum++) {
            propose(manArray,ladyArray,ladyIsChooseByMan,ladyIsReadyChooseByMan,singleDog,manNum,ladyChoose);
        }
        //第二轮循环，剩余单身的人再进行第二轮求婚
        while (!singleDog.empty()) {
            int manNum = singleDog.pop();
            propose(manArray,ladyArray,ladyIsChooseByMan,ladyIsReadyChooseByMan,singleDog,manNum,ladyChoose);
        }
        //输出男人所对应选择的女人
        for(int i = 0;i<4;i++){
            System.out.println(i +" : "+ ladyIsChooseByMan[i]);
        }
    }
    /**
     * @param manArrays
     * @param ladyArray
     * @param ladyIsChooseByMan
     * @param ladyIsReadyChooseByMan
     * @param singleDog
     * @param manNum                 标志现在是哪个男人在进行求婚
     */
    public static void propose(int manArrays[][], int ladyArray[][], int ladyIsChooseByMan[], int ladyIsReadyChooseByMan[], Stack<Integer> singleDog, int manNum, int ladyChoose[]) {
        //该男人准备求婚的女性
        int preferLady = manArrays[manNum][ladyIsReadyChooseByMan[manNum]];
        //该女性还未被求婚，那么直接答应男性
        if (ladyChoose[preferLady] == -1) {
            //设置女性的爱人为该男性
            ladyChoose[preferLady] = manNum;
            //设置男性的爱人为该女性
            ladyIsChooseByMan[manNum] = preferLady;
        } else {
            //标志位，若未true表示接受新男友，false则拒绝新男友
            boolean flag = false;
            int i = ladyChoose[preferLady];
            for (int k = 0; k < 4; k++) {
                //对不起，我以及有男朋友了
                if(i == ladyArray[preferLady][k]){
                    flag = false;
                    break;
                }
                //成功被挖墙脚
                if(manNum == ladyArray[preferLady][k]){
                    flag = true;
                    break;
                }
            }
            //开始换男友
            if(flag){
                ladyChoose[preferLady] = manNum;
                ladyIsChooseByMan[manNum] = preferLady;
                //被抛弃的这个男人需要从下一个女孩开始追了,并将其放入单身狗栈中
                ladyIsReadyChooseByMan[i]++;
                singleDog.push(i);
            }else{
                //挖墙脚失败，女孩看不上你
                ladyIsReadyChooseByMan[manNum]++;
                singleDog.push(manNum);
            }
        }
    }
}
