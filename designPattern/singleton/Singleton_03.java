package algorithm.designPattern.singleton;

/**
 * 饿汉模式,线程安全
 * 问题在于其在类加载的时候就会对类进行创建
 * 具体一点的说，如果Main类中有使用到该类，那么该类会被加载，那也就是说还没有
 * 运行到创建实例的时候，该实例已经被创建了
 * 举个例子说，你玩游戏的时候，才进入游戏就把所有地图都加载完了，很容易导致超负荷
 */
public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }
}
