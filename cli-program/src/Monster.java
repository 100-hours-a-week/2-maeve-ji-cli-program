public class Monster extends Character {
    private int expDrop;
    private Item dropItem;

    public Monster(String name, int hp, int attack, int expDrop, Item dropItem) {
        super(name, hp, attack);
        this.expDrop = expDrop;
        this.dropItem = dropItem;
    }

    public int getExpDrop() {
        return expDrop;
    }

    public Item getDropItem() {
        return dropItem;
    }
    public void attack(Character target, boolean targetDefending) {
        int damage = targetDefending ? attack / 2 : attack; // 방어 시 피해 절반
        if (targetDefending) {
            System.out.println("방어를 하여 피해가 절반으로 줄었습니다! (8 -> 4)");
        }
        System.out.println(name + "이(가) " + target.name + "을(를) 공격! (" + damage + " 피해)");
        target.takeDamage(damage);
    }
}
