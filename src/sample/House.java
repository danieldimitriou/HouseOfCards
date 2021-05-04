package sample;

import java.util.ArrayList;

public class House {
    //Fields
    private ArrayList<Integer> pointsHistory;

    //Constructors
    public House() {
        this.pointsHistory = new ArrayList<>();
    }

    //Methods
    public int addPoints(int points) { // when house is not closed, give points
        if (!isClosed()) {
            pointsHistory.add(points);
        }
        return points;
    }

    public int calculateSumOfHouse() {
        int sum = 0;
        for (int i = 0; i < pointsHistory.size(); i++) {
            sum += pointsHistory.get(i);
        }
        return sum;
    }

    public boolean isClosed() { //check if house is closed
        return calculateSumOfHouse() > 31;
    }

    public boolean clearHouse() { //empty the house when total is 31, which means that the arraylist is emptied
        boolean flag = false;
        if (calculateSumOfHouse() == 31) {
            pointsHistory.clear();
            flag = true;
        }
        return flag;
    }


    //toString method
    @Override
    public String toString() {
        return "House{Total = " + calculateSumOfHouse() + " pointsHistory=" + pointsHistory + '}';
    }
}
