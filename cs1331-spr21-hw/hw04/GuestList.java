import java.util.ArrayList;

/**
 * @author akwok6
 * @version 1.0
 */

public class GuestList {
    private ArrayList<Monster> guests;
    private DancingMonster bestDancer;

    /**
     * Accessor for guests.
     * @return guest list
     */

    public ArrayList getGuests() {
        return guests;
    }

    /**
     * Mutator for guests.
     * @param guests guest list
     */

    public void setGuests(ArrayList guests) {
        this.guests = guests;
    }

    /**
     * Accessor for the best dancer.
     * @return the best dancer
     */

    public DancingMonster getBestDancer() {
        return bestDancer;
    }

    /**
     * Mutator for the best dancer.
     * @param bestDancer the best dancer
     */

    public void setBestDancer(DancingMonster bestDancer) {
        this.bestDancer = bestDancer;
    }

    /**
     * Constructor for GuestList.
     * @param guests the list of guests
     */

    public GuestList(ArrayList<Monster> guests) {
        this.guests = guests;
        this.bestDancer = null;
        for (Monster monster : guests) {
            if (monster instanceof DancingMonster && (this.bestDancer == null || monster.compareTo(bestDancer) > 0)) {
                this.bestDancer = (DancingMonster) monster;
            }
        }
    }



    /**
     * Constructor with no arguments.
     */

    public GuestList() {
        this(new ArrayList<Monster>());
    }

    /**
     * Adds a guest to the list of guests.
     * @param monster the monster being added
     */

    public void addGuest(Monster monster) {
        guests.add(monster);
        if (monster instanceof DancingMonster
                && (bestDancer == null  || (monster.compareTo(bestDancer) > 0))) {
            DancingMonster dancing = (DancingMonster) monster;
            bestDancer = dancing;
        }
    }

    /**
     * Overrides Object's toString() method.
     * @return a String that describes the guest list
     */

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < guests.size(); i++) {
            Monster monster = (Monster) guests.get(i);
            string += monster.getName() + ", ";
        }
        return string;
    }

    /**
     * Creates a dance battle.
     * @param monster1 the first monster in the battle
     * @param monster2 the second monster in the battle
     */

    public void danceBattle(Monster monster1, Monster monster2) {
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        if (!(monster1 instanceof DancingMonster) && !(monster2 instanceof DancingMonster)) {
            System.out.println("And this dance battle is a tie!");
        } else if (!(monster2 instanceof DancingMonster)) {
            System.out.println(monster1.getName() + " won the dance battle!");
            ((DancingMonster) monster1).wonDance();
        } else if (!(monster1 instanceof DancingMonster)) {
            System.out.println(monster2.getName() + " won the dance battle!");
            ((DancingMonster) monster2).wonDance();
        } else {
            DancingMonster dancing1 = (DancingMonster) monster1;
            DancingMonster dancing2 = (DancingMonster) monster2;
            if (dancing1.dance() < dancing2.dance()) {
                System.out.println(dancing2.getName() + " won the dance battle!");
                dancing2.wonDance();
            } else if (dancing1.dance() > dancing2.dance()) {
                System.out.println(dancing1.getName() + " won the dance battle!");
                dancing1.wonDance();
            } else if (dancing1.dance() == dancing2.dance()) {
                System.out.println("And this dance battle is a tie!");
            }
        }

    }

}
