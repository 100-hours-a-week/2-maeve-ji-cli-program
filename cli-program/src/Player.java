public class Player extends Character {
    private String job;

    public Player(String name, String job) {
        super(name, 100, 10);
        this.job = job;
    }

    public void showStats() {
        System.out.println("[ " + name + " | 직업: " + job + " | 레벨: " + level + " ]");
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > 100) {
            hp = 100;
            System.out.println(name + "이(가) HP를 최대치로 회복하였습니다! 현재 HP: " + hp);
        }
        System.out.println(name + "이(가) HP를 " + amount + " 회복했습니다! 현재 HP: " + hp);
    }
}
