import java.util.ArrayList;

/**
 * @author akwok6
 * @version 1.0
 */

public class UndercoverTourist {

    /**
     * Method that calculates max number of activities that can be done with the given budget.
     * @param list a list of activities
     * @param budget the budget
     * @param activities the number of activties done
     * @return max number of activities that can be done
     */

    public static int calculateNumActivities(ArrayList<TravelActivity> list, double budget, int activities) {
        TravelActivity activity = findCheapest(list);
        if (budget < activity.getPrice() | list.size() <= 0) {
            return activities;
        } else {
            list.remove(activity);
            return calculateNumActivities(list, budget - activity.getPrice(), activities + 1);

        }

    }

    /**
     * Helper method that returns the TravelActivity that costs the least.
     * @param travelList list of activities
     * @return the cheapest activity
     */

    public static TravelActivity findCheapest(ArrayList<TravelActivity> travelList) {
        TravelActivity temp = new TravelActivity("name", 999);
        for (int i = 0; i < travelList.size(); i++) {
            if (travelList.get(i).getPrice() < temp.getPrice()) {
                temp = travelList.get(i);
            }
        }
        return temp;
    }
}

