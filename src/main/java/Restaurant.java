import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    private LocalTime  currentTime = null;

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        if(currentTime == null)
        {
            currentTime = getCurrentTime();
        }

        int i = openingTime.compareTo(currentTime);
        int j = closingTime.compareTo(currentTime);

        if( currentTime.isBefore(closingTime) && currentTime.isAfter(openingTime))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public LocalTime getCurrentTime(){
        return  LocalTime.now();
    }

    public List<Item> getMenu() {

        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public void setCurrentTime(int hours,int min,int sec)
    {
        currentTime = LocalTime.of(hours,min,sec);
    }

    public int getTotalCostOfOrder(List<Item> selectedItemsFromMenu) throws selectedItemsIsEmptyException
    {
        if(selectedItemsFromMenu == null)
            throw new selectedItemsIsEmptyException("The list of selected items is empty");
        
        int total = 0;
        for(Item i : selectedItemsFromMenu)
        {
            total += i.getPrice();
        }
        return total;
    }
}
