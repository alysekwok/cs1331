public class GTSandwich {
    private String bread;
    private String meat;
    private String[] extras;
    private int numMeat;
    private double price;
    private boolean hasSauce;
    private boolean makeCombo;

    public GTSandwich(String bread, String meat, String[] extras, int numMeat,
                      double price, boolean hasSauce, boolean makeCombo) {
        this.bread = bread;
        this.meat = meat;
        this.extras = extras;
        this.numMeat = numMeat;
        this.price = price;
        this.hasSauce = hasSauce;
        this.makeCombo = makeCombo;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String[] getExtras() {
        return extras;
    }

    public void setExtras(String[] extras) {
        this.extras = extras;
    }

    public int getNumMeat() {
        return numMeat;
    }

    public void setNumMeat(int numMeat) {
        this.numMeat = numMeat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getHasSauce() {
        return hasSauce;
    }

    public void setHasSauce(boolean hasSauce) {
        this.hasSauce = hasSauce;
    }

    public boolean getMakeCombo() {
        return makeCombo;
    }

    public void setMakeCombo(boolean makeCombo) {
        if (!this.makeCombo && makeCombo) {
            price += 2;
        }
        if (this.makeCombo && !makeCombo) {
            price -= 2;
        }
        this.makeCombo = makeCombo;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public GTSandwich(String bread, String meat, boolean makeCombo) {
        this.bread = bread;
        this.meat = meat;
        this.makeCombo = makeCombo;
        numMeat = 4;
        price = 8.75;
        hasSauce = true;
        extras = new String[0];
    }

    public GTSandwich() {
        bread = "Rye";
        meat = "Turkey";
        extras = new String[0];
        numMeat = 4;
        price = 8.75;
        hasSauce = true;
        makeCombo = true;
    }

    public void applyCoupon(String coupon) {
        if (coupon.equals("CS1331") && makeCombo) {
            price = price / 2;
            price = Math.round(price * 100.0) / 100.0;
            numMeat = numMeat * 2;
            System.out.println("Coupon Applied");
        } else {
            System.out.println("Coupon Not Applied");
        }

    }

    public void applyCoupon() {
        if (price >= 20) {
            price = price - 5;
            makeCombo = true;
            System.out.println("Discount Applied");
        } else {
            System.out.println("Discount Not Applied");
        }

    }

    public void printExtras() {
        if (extras.length == 0) {
            System.out.println("The customer wants no extras.");
        } else {
            System.out.print("The customer wants these extras: ");
            for (int i = 0; i < extras.length; i++) {
                if (i < extras.length - 1) {
                    System.out.print(extras[i] + ", ");
                }
                if (i == extras.length - 1) {
                    System.out.println(extras[i]);
                }
            }

        }
    }
    public String toString() {
        String newString = "", finalString;
        if (extras.length != 0) {
            for (int i = 0; i < extras.length; i++) {
                newString += extras[i] + ", ";

            }
        }
        finalString = "GT Sandwich that costs " + price + " with " + bread + ", " + meat  + ", " + newString + numMeat
                + " slices of meat, Sauce: " + hasSauce + ", Combo: " + makeCombo;
        return finalString;
    }

    public static void main(String[] args) {
        GTSandwich houseSpecial = new GTSandwich("French", "Turkey",
                new String[] {"Banana Peppers", "Spinach", "Chipotle Mayo"}, 4, 10.75, true, true);
        GTSandwich javaSandwich = new GTSandwich();
        houseSpecial.applyCoupon("CS1331");
        javaSandwich.applyCoupon();
        houseSpecial.printExtras();

        System.out.println(houseSpecial);
        System.out.println(javaSandwich);

    }


}
