package algorithm.javatest.ClassRef;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
//    Toy() {
//    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy(int i) {
        super(i);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name:" + cc.getName() + "is Interfaces?" + cc.isInterface());
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class cc = null;
        try {
            cc = Class.forName("algorithm.javatest.ClassRef.FancyToy");
            while ((cc=cc.getSuperclass())!=null){
                printInfo(cc);
            }
            System.exit(0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        printInfo(cc);
        for (Class face : cc.getInterfaces()) {
            printInfo(face);
        }
        Class up = cc.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
            printInfo(obj.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
