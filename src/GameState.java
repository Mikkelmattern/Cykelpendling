public class GameState {
    TextUI textUI = new TextUI();
    BikeCommute bc = new BikeCommute();
    int startMonth;

    public void run() {
        doContinue();
    }

    public boolean continueRegister() {
        textUI.displayMsg("Klimarabat for " + bc.getCurrentMonth() + ": " + String.valueOf(bc.getTotalAmount())+ "kr");
        String choice = textUI.stringInput("Fortsæt registrering? (J/N)");
        char cleanChoice = choice.toUpperCase().charAt(0);
        switch (cleanChoice) {
            case 'J':
                doContinue();
            case 'N':
                return calcSession();
            default:
                textUI.displayMsg("Vælg (J/N)");
        }
        return false;
    }

    private int chooseMonth() {
        String input = textUI.stringInput("Indtast måned:");
        int month = bc.checkArrayPlace(input);
        bc.setCurrentMonth(month);
        return month;
    }

    private int calcSeason() {
        int month = chooseMonth();
        int season = month / 6;
        int multiplier = 0;
        switch (season) {
            case 0:
                multiplier = 10;
                break;
            case 1:
                multiplier = 15;
                break;
            default:
                textUI.displayMsg("Noget gik galt i calcSeason()");
        }
        return multiplier;

    }

    private void doContinue() {
        int i = calcSeason();
        int t = Integer.parseInt(textUI.stringInput("Antal cykelture:"));
        bc.addToTotal(i * t);
        bc.addTrips(t);
        continueRegister();
    }
    private boolean calcSession(){
        int carbonDioxid = (int) (bc.getBikeTrips()*2.6);
        String tree = ""+carbonDioxid/20;
       String s =""+ bc.getTotalAmount();

        textUI.displayMsg("Flot arbejde! Du har sparet klimaet for " + String.valueOf(carbonDioxid)+ "kg CO2 (svarende til "+ tree + " træer)"
        , "Din klimarabat: " + s+"kr overførers til din NemKonto!");
        return false;

    }

}
