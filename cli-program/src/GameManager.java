import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("캐릭터 이름: ");
        String name = scanner.nextLine();
        System.out.print("직업 (전사/마법사): ");
        String job = scanner.nextLine();

        Player player = new Player(name, job);
        player.showStats();

        while (true) {
            Item potion = new Item("체력 포션", "HP +15", 15);
            Monster monster = new Monster("고블린", 50, 8, 5, potion);
            System.out.println("🔥 야생의 " + monster.name + "이(가) 나타났다!");

            while (player.isAlive() && monster.isAlive()) {
                System.out.println("\n⚔ 행동을 선택하세요: (1) 공격  (2) 방어  (3) 아이템 사용  (4) 도망");
                System.out.print("선택: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        player.attack(monster);
                        if (monster.isAlive()) {
                            monster.attack(player, false);
                        }
                        break;
                    case 2:
                        if (monster.isAlive()) {
                            monster.attack(player, true);
                        }
                        break;
                    case 3:
                        System.out.println(player.name + "이(가) " + potion.getName() + "을(를) 사용하여 HP 회복!");
                        player.heal(potion.getHealAmount());
                        break;
                    case 4:
                        System.out.println("🏃‍♂️ " + player.name + "이(가) 도망쳤습니다!");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                        continue;
                }

                if (!player.isAlive()) {
                    System.out.println("💀 " + player.name + "이(가) 쓰러졌습니다... 게임 오버!");
                    return;
                }
            }

            System.out.println("🎉 " + monster.name + "을(를) 처치했습니다!");
            player.gainExp(monster.getExpDrop());

            System.out.println("\n📢 계속해서 전투를 진행하시겠습니까? (Y/N)");
            String next = scanner.next();
            if (!next.equalsIgnoreCase("Y")) {
                System.out.println("게임 종료!");
                break;
            }
        }
        scanner.close();
    }
}