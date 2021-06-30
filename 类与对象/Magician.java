public class Magician {
    //属性名称、等级、血量
    private String name;
    private Integer level;
    private Integer blood;

    //如果类中没有构造，默认提供无参构造
    //如果有 有参构造，将不提供无参构造

    public Magician() {
    }

    public Magician(String name, Integer level, Integer blood) {
        this.name = name;
        this.level = level;
        this.blood = blood;
    }

    //攻击
    public void fight(){
        System.out.println("法师"+name+"发起攻击");
    }

    //魔法治疗
    public void cure(){
        System.out.println("法师"+name+"治疗");
    }
}
