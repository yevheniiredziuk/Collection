import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add(0,"a");
        list.add(1,"b");
        list.add("e");
        list.add(1,"f");
        list.set(0,"g");
        list.delete("d");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.contain("f"));

        MyList<Dummy> dummyObjects = new MyList<>();
        dummyObjects.add(new Dummy("test1"));
        dummyObjects.add(new Dummy("test2"));
        dummyObjects.add(0, new Dummy("test3"));

        System.out.println(dummyObjects.get(0).value);


    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Dummy{
        private String value;
    }
}