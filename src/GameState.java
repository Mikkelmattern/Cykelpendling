public class GameState {
    TextUI textUI = new TextUI();
    BikeCommute bc = new BikeCommute();
    int startMonth;

    public void run() {
        while (true) {
            calcAmount();
            if (!loopYesNo()) {
                break;
            }


        }
        calcSession();
    }

    public boolean loopYesNo() {

        while (true) {
            String choice = textUI.stringInput("Fortsæt registrering? (J/N)");

            if (choice == null || choice.trim().isEmpty()) {
                textUI.displayMsg("Vælg (J/N)");
                continue;
            }
            char cleanChoice = choice.toUpperCase().charAt(0);
            switch (cleanChoice) {
                case 'J': {
                    return true;
                }
                case 'N': {
                    return false;
                }
                default: {
                    textUI.displayMsg("Vælg (J/N)");
                }
            }
        }
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

    private void calcAmount() {
        int i = calcSeason();
        int t = Integer.parseInt(textUI.stringInput("Antal cykelture:"));
        bc.addToTotal(i * t);
        bc.addTrips(t);
        textUI.displayMsg("Klimarabat for " + bc.getCurrentMonth() + ": " + String.valueOf(bc.getTotalAmount()) + "kr");
    }

    private void calcSession() {
        int carbonDioxid = (int) (bc.getBikeTrips() * 2.6);
        int ent = carbonDioxid / 20;
        String tree = "" + ent;
        String s = "" + bc.getTotalAmount();
        switch (ent) {
            case 0: {
                textUI.displayMsg("Flot arbejde! Du har sparet klimaet for " + String.valueOf(carbonDioxid) + "kg CO2), desværre var det ikke engang et helt træs værd af CO2", "Din klimarabat: " + s + "kr overførers til din NemKonto!");
            }
            case 1: {
                textUI.displayMsg("Flot arbejde! Du har sparet klimaet for " + String.valueOf(carbonDioxid) + "kg CO2 (svarende til " + tree + " træ)"
                        , "Din klimarabat: " + s + "kr overførers til din NemKonto!");
            }
            default: {
                textUI.displayMsg("Flot arbejde! Du har sparet klimaet for " + String.valueOf(carbonDioxid) + "kg CO2 (svarende til " + tree + " træer)"
                        , "Din klimarabat: " + s + "kr overførers til din NemKonto!");
            }
        }

    }

}
