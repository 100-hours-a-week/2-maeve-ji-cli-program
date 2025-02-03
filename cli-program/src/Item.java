public class Item {
    private String name;
    private String effect;
    //    private int value;
    private int healAmount;

    public Item(String name, String effect, int healAmount) {
        this.name = name;
        this.effect = effect;
//        this.value = value;
        this.healAmount = healAmount;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
