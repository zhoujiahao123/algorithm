package algorithm.getMoney.money5;

import java.util.HashMap;
import java.util.Map;

public class Movie {
    private String name;
    private Map<Integer,Integer> map = new HashMap<>();
    private String MPAARating;
    public Movie(String name,String MPAARating){
        this.name = name;
        this.MPAARating = MPAARating;
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
    }
    public void addRating(int rate){
        if(rate < 1 || rate >5) {
            System.out.println("Incorrect rating entered");
            return;
        }
        map.merge(rate,1,Integer::sum);
    }
    public double getAverage(){
        int sum = 0;
        int size = map.size();
        for(Integer key : map.keySet()){
            sum += map.get(key) * key;
        }
        return (double) sum/ size;
    }

    public String getName() {
        return name;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("movie1","PG");
        movie1.addRating(1);
        movie1.addRating(2);
        movie1.addRating(3);
        movie1.addRating(4);
        movie1.addRating(5);
        System.out.println("Movie title:"+movie1.getName());
        System.out.println("the filmMPAARating:"+movie1.getMPAARating());
        System.out.println("Average rating of movies:"+movie1.getAverage());

        Movie movie2 = new Movie("movie2","G");
        movie2.addRating(2);
        movie2.addRating(2);
        movie2.addRating(2);
        movie2.addRating(2);
        movie2.addRating(4);
        System.out.println("Movie title:"+movie2.getName());
        System.out.println("the filmMPAARating:"+movie2.getMPAARating());
        System.out.println("Average movie rating:"+movie2.getAverage());
    }
}