package algorithm.Coruse;

import java.util.Stack;

public class StableMatching {

    public static void main(String[] args) {
        //�������飬manArrays[1][0]����ڶ���������ϲ����Ů��,Ů��ͬ��
        int manArray[][] = {{2, 3, 1, 0}, {2, 1, 3, 0}, {0, 2, 3, 1}, {1, 3, 2, 0}};
        int ladyArray[][] = {{0, 3, 2, 1}, {0, 1, 2, 3}, {0, 2, 3, 1}, {1, 0, 3, 2}};
        //����ѡ���Ů��
        int ladyIsChooseByMan[] = new int[4];
        //����׼������Ů��
        int ladyIsReadyChooseByMan[] = new int[4];
        //һ��ѭ���󻹴��ڵ��������
        Stack<Integer> singleDog = new Stack<>();
        //Ů��ѡ������ԣ���δ-1�����û�б�׷���
        int ladyChoose[] = {-1, -1, -1, -1, -1};
        //��һ��ѭ����ÿ�����˶����Լ���ϲ����Ů���������
        for (int manNum = 0; manNum < 4; manNum++) {
            propose(manArray,ladyArray,ladyIsChooseByMan,ladyIsReadyChooseByMan,singleDog,manNum,ladyChoose);
        }
        //�ڶ���ѭ����ʣ�൥������ٽ��еڶ������
        while (!singleDog.empty()) {
            int manNum = singleDog.pop();
            propose(manArray,ladyArray,ladyIsChooseByMan,ladyIsReadyChooseByMan,singleDog,manNum,ladyChoose);
        }
        //�����������Ӧѡ���Ů��
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
     * @param manNum                 ��־�������ĸ������ڽ������
     */
    public static void propose(int manArrays[][], int ladyArray[][], int ladyIsChooseByMan[], int ladyIsReadyChooseByMan[], Stack<Integer> singleDog, int manNum, int ladyChoose[]) {
        //������׼������Ů��
        int preferLady = manArrays[manNum][ladyIsReadyChooseByMan[manNum]];
        //��Ů�Ի�δ����飬��ôֱ�Ӵ�Ӧ����
        if (ladyChoose[preferLady] == -1) {
            //����Ů�Եİ���Ϊ������
            ladyChoose[preferLady] = manNum;
            //�������Եİ���Ϊ��Ů��
            ladyIsChooseByMan[manNum] = preferLady;
        } else {
            //��־λ����δtrue��ʾ���������ѣ�false��ܾ�������
            boolean flag = false;
            int i = ladyChoose[preferLady];
            for (int k = 0; k < 4; k++) {
                //�Բ������Լ�����������
                if(i == ladyArray[preferLady][k]){
                    flag = false;
                    break;
                }
                //�ɹ�����ǽ��
                if(manNum == ladyArray[preferLady][k]){
                    flag = true;
                    break;
                }
            }
            //��ʼ������
            if(flag){
                ladyChoose[preferLady] = manNum;
                ladyIsChooseByMan[manNum] = preferLady;
                //�����������������Ҫ����һ��Ů����ʼ׷��,��������뵥��ջ��
                ladyIsReadyChooseByMan[i]++;
                singleDog.push(i);
            }else{
                //��ǽ��ʧ�ܣ�Ů����������
                ladyIsReadyChooseByMan[manNum]++;
                singleDog.push(manNum);
            }
        }
    }
}
