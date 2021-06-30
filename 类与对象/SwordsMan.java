
//父类role非私有的资源（属性和方法）给子类
//继承的特点是什么？
public class SwordsMan extends Role{

    //拥有父类的7个方法
    //在创建子类对象的同时，会默认的创建父类对象。

    public SwordsMan() {
        super();
    }

    public SwordsMan(String name, Integer level, Integer blood) {
        //调用父类的构造, super只能写在代码得第一行
        //public Role(String name, Integer level, Integer blood) {
        super(name, level, blood);
    }

    //扩展父类的方法
    @Override
    public void fight() {
        //删除父类方法调用
        System.out.println("战士"+getName()+"发起攻击");
    }
}
