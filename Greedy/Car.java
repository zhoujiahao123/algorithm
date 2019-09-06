package algorithm.Greedy;

import algorithm.Greedy.course.Things;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Foods> foodsList = new ArrayList<>();

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
    public Integer addThing(Foods foods) // 车子跑一趟, 返回跑了多少趟，包括此趟
    {
        foodsList.add(foods);
        return foodsList.size();
    }
}
