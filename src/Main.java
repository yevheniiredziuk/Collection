import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(0,"a");
        list.add(1,"b");
        list.add(2,"c");
        list.add(3,"d");
        list.add("e");
        list.add(1,"f");
        System.out.println(list);
        //list.clear();

        list.set(0,"g");
        list.delete("d");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.contain("f"));


    }
}