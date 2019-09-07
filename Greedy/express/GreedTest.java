package algorithm.Greedy.express;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �ɼ�����ʼʱ��ͽ���ʱ�䣬�����ٵĳ������������ɼ�
 * �ֲ����ţ�һ����������һ���������ͽ�����ʱ����ӽ���һ�����ɡ�
 * ���ⱾӦ�Ƚ���������������˼·��
 * 1�����տ�ʼ�ͻ�ʱ���������
 * 2�����ս���ʱ���������
 * ����������жϸ�ѡ����һ������ʽ��
 */
public class GreedTest {
    public static void main(String[] args) {
        List<Foods> foodsList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        foodsList.add(new Foods("���1",1,4));
        foodsList.add(new Foods("���2",3,5));
        foodsList.add(new Foods("���3",0,6));
        foodsList.add(new Foods("���4",5,7));
        foodsList.add(new Foods("���5",3,8));
        foodsList.add(new Foods("���6",5,9));
        foodsList.add(new Foods("���7",6,10));
        foodsList.add(new Foods("���8",8,11));
        foodsList.add(new Foods("���9",8,12));
        foodsList.add(new Foods("���10",2,13));
        foodsList.add(new Foods("���11",12,14));
        greedy(carList,0,foodsList);
        System.out.println("�ܹ���Ҫ:"+carList.size()+"����");
        for(int i = 0;i<carList.size();i++){
            System.out.println("��"+(i+1)+"������");
            for(Iterator<Foods> foodsIterator=carList.get(i).getFoodsList().iterator();foodsIterator.hasNext();){
                Foods foods = foodsIterator.next();
                System.out.println(foods.getName());
            }
        }
    }
    public static void greedy(List<Car> carList,int carNum,List<Foods> foodsList){
        Car car = new Car();
        //����Ѿ�û����Ҫ���͵Ŀ���ˣ���ֱ�ӷ���
        if(foodsList.size() == 0){
            return;
        }
        //��ǰ������ʱ��
        int endTime = foodsList.get(0).getEndTime();
        //����ݷ��ϳ�
        car.addThing(foodsList.get(0));
        //�Ƴ����Ѿ������͵Ŀ��
        foodsList.remove(0);
        //����һ�����������͵Ļ�������
        for(Iterator<Foods> t = foodsList.iterator();t.hasNext();){
            Foods food = t.next();
            if(food.getStartTime()>=endTime){
                endTime = food.getEndTime();
                car.addThing(food);
                //ֱ���õ������Ƴ������Ƴ��ڶ�Ӧ��list�еĵ�ǰԪ��
                t.remove();
            }
        }
        carList.add(car);
        if(foodsList.size() != 0){
            greedy(carList,carNum+1,foodsList);
        }
    }
}
