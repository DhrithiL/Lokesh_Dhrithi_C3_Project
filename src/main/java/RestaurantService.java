import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName){

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        for(Restaurant r : restaurants)
        {
            if(restaurantName.equalsIgnoreCase(r.getName()))
            {
                return r;
            }
        }

        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved == null)
            throw new restaurantNotFoundException("Removing a restaurant that does not exist :"+restaurantName);

        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }



}
