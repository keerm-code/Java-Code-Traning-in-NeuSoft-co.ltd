
public class Main {

    public static void main(String[] args) {
        SwordsMan sm = new SwordsMan("张三",22,260);
        sm.fight();
        Magician fs =new Magician("name", 5, 90);
        fs.cure();
        fs.fight();
        //创建fs 攻击 治疗
    }
}
