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
    public Integer addThing(Foods foods) // ������һ��, �������˶����ˣ���������
    {
        foodsList.add(foods);
        return foodsList.size();
    }
}
