package algorithm.Greedy.express;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 派件有起始时间和结束时间，用最少的车运送完所有派件
 * 局部最优：一辆车在送完一个快件后就送接下来时间最接近的一个即可。
 * 本题本应先进行排序，则有两种思路，
 * 1：按照开始送货时间进行排序
 * 2：按照结束时间进行排序
 * ？到底如何判断该选择哪一种排序方式。
 */
public class GreedTest {
    public static void main(String[] args) {
        List<Foods> foodsList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        foodsList.add(new Foods("快件1",1,4));
        foodsList.add(new Foods("快件2",3,5));
        foodsList.add(new Foods("快件3",0,6));
        foodsList.add(new Foods("快件4",5,7));
        foodsList.add(new Foods("快件5",3,8));
        foodsList.add(new Foods("快件6",5,9));
        foodsList.add(new Foods("快件7",6,10));
        foodsList.add(new Foods("快件8",8,11));
        foodsList.add(new Foods("快件9",8,12));
        foodsList.add(new Foods("快件10",2,13));
        foodsList.add(new Foods("快件11",12,14));
        greedy(carList,0,foodsList);
        System.out.println("总共需要:"+carList.size()+"辆车");
        for(int i = 0;i<carList.size();i++){
            System.out.println("第"+(i+1)+"辆车：");
            for(Iterator<Foods> foodsIterator=carList.get(i).getFoodsList().iterator();foodsIterator.hasNext();){
                Foods foods = foodsIterator.next();
                System.out.println(foods.getName());
            }
        }
    }
    public static void greedy(List<Car> carList,int carNum,List<Foods> foodsList){
        Car car = new Car();
        //如果已经没有需要运送的快件了，则直接返回
        if(foodsList.size() == 0){
            return;
        }
        //当前车结束时间
        int endTime = foodsList.get(0).getEndTime();
        //将快递放上车
        car.addThing(foodsList.get(0));
        //移除掉已经被运送的快件
        foodsList.remove(0);
        //把这一辆车可以运送的货物拉完
        for(Iterator<Foods> t = foodsList.iterator();t.hasNext();){
            Foods food = t.next();
            if(food.getStartTime()>=endTime){
                endTime = food.getEndTime();
                car.addThing(food);
                //直接用迭代器移除可以移除在对应的list中的当前元素
                t.remove();
            }
        }
        carList.add(car);
        if(foodsList.size() != 0){
            greedy(carList,carNum+1,foodsList);
        }
    }
}
