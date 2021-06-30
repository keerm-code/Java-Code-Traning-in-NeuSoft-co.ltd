public class Role {
    //属性名称、等级、血量
    private String name;
    private Integer level;
    private Integer blood;

    public Role() {
        System.out.println("Role()");
    }

    public Role(String name, Integer level, Integer blood) {
        this.name = name;
        this.level = level;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    //攻击
    public void fight(){
        System.out.println(name+"发起攻击");
    }
}
