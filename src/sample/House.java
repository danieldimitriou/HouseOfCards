package sample;

import java.util.ArrayList;

/**
 * This is the house class.
 * The house is characterised by its points history.
 */

public class House {
    /**
     * This is a private ArrayList attribute of type Integer for the house's points history.
     */
    private ArrayList<Integer> pointsHistory;

    /**
     * The non-default constructor accepts no parameters.
     */
    public House() {
        this.pointsHistory = new ArrayList<>();
    }

    /**
     * This method is used to add points to a house when it is not closed.
     * @param points the points to be added to the house.
     * @return the points that will be added to the house.
     */
    public int addPoints(int points) {
        if (!isClosed()) {
            pointsHistory.add(points);
        }
        return points;
    }

    /**
     * This method is used to calculate the sum of a house.
     * @return the sum of the house.
     */
    public int calculateSumOfHouse() {
        int sum = 0;
        for (int i = 0; i < pointsHistory.size(); i++) {
            sum += pointsHistory.get(i);
        }
        return sum;
    }

    /**
     * This method is used to check if a house is closed.
     * @return true or false depending on whether the sum of the house is greater than 31.
     */
    public boolean isClosed() {
        return calculateSumOfHouse() > 31;
    }

    /**
     * This method is used to check the total sum of the house and if it is 31, it clears the house.
     * @return true or false depending on whether the house was cleared or not.
     */
    public boolean clearHouse() {
        boolean flag = false;
        if (calculateSumOfHouse() == 31) {
            pointsHistory.clear();
            flag = true;
        }
        return flag;
    }

    /**
     * This method returns the points history ArrayList of a house.
     * @return the points history of the house.
     */
    public ArrayList<Integer> getPointsHistory() {
        return pointsHistory;
    }
}
