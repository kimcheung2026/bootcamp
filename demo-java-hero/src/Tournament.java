import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tournament {

    // 隨機產生職業的輔助方法
    public static Human createRandomHero(String name) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return new Warrior3(name + "(戰士)");
        } else {
            return new Mage(name + "(法師)");
        }
    }

    public static Human startMatch(Human p1, Human p2) {
        System.out.println("\n🔥 戰鬥開始：" + p1.getName() + " VS " + p2.getName());

        while (p1.isAlive() && p2.isAlive()) {
            // P1 攻擊 P2
            p1.action(p2);
            if (!p2.isAlive())
                break;

            // P2 攻擊 P1
            p2.action(p1);

            System.out.println(">> " + p1.getName() + " HP: " + p1.getHp() + " | "
                    + p2.getName() + " HP: " + p2.getHp());
        }

        Human winner = p1.isAlive() ? p1 : p2;
        System.out.println("🏆 勝利者是: " + winner.getName());

        // --- 升級與回血效果 ---
        if (winner instanceof Levelup) {
            ((Levelup) winner).levelup();
            // 假設升級後 HP 補滿 (或額外加成)
            System.out.println(" 升級神力：HP 已恢復並提升！");
        }
        return winner;
    }

    public static void main(String[] args) {
        // 1. 初始化 4 位隨機職業選手
        List<Human> players = new ArrayList<>();
        players.add(createRandomHero("Player_A"));
        players.add(createRandomHero("Player_B"));
        players.add(createRandomHero("Player_C"));
        players.add(createRandomHero("Player_D"));

        Collections.shuffle(players); // 隨機洗牌決定對手

        System.out.println("=== 第一回合：準決賽 ===");
        Human winner1 = startMatch(players.get(0), players.get(1));
        Human winner2 = startMatch(players.get(2), players.get(3));

        System.out.println("=== 第二回合：總決賽 ===");
        System.out.println("晉級選手：" + winner1.getName() + " 與 " + winner2.getName());

        // 確保進入決賽時狀態是健康的 (升級回血已在 startMatch 處理)
        Human champion = startMatch(winner1, winner2);

        System.out.println(" 本屆大賽總冠軍為：" + champion.getName() + " 🎉");
    }
}