package model.Lists;

import model.Objects.Restaurant;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantList implements Serializable, ListObject{
    private ArrayList<Restaurant> theList;

    public RestaurantList(){
        theList = new ArrayList<>();
        theList.add(new Restaurant("One"));
        theList.add(new Restaurant("Two"));
    }

    public ArrayList<Restaurant> getTheList() {
        return theList;
    }

    public void setTheList(ArrayList<Restaurant> theList) {
        this.theList = theList;
    }

    @Override
    public void add(Object obj) {
        theList.add((Restaurant) obj);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Restaurant r : theList){
            sb.append(r.toString());
        }

        return sb.toString();
    }
}
