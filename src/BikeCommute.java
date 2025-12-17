import java.lang.reflect.Array;

public class BikeCommute {
    String[] monthArray = {"april", "maj", "juni", "juli", "august", "septemper", "oktober", "november", "december", "januar", "februar", "marts"};
    private String currentMonth;
    int totalAmount = 0;
    int bikeTrips;

    public int checkArrayPlace(String input) {
        String search = input.toLowerCase().trim();
        boolean equal = false;
        int i;
        for (i = 0; !equal; i++) {
            equal = search.equals(monthArray[i]);
        }
        return i;
    }
 public void addTrips(int added){
        bikeTrips += added;
 }
 public int getBikeTrips(){
        return bikeTrips;
 }
    public void addToTotal(int added) {
        totalAmount += added;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

 public void setCurrentMonth(int month){
    currentMonth = monthArray[month-1];
  }
  public String getCurrentMonth(){
        return currentMonth;
  }
}
