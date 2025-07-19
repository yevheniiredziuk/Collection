import java.util.ArrayList;

public class MyList implements Collection{
    ArrayList myList;
    private int size;
    private int capacity;
    private String[] array;
    private static final int DEFAULT_CAPACITY = 10;

    {
        size = 0;
    }

    public MyList(){
        array = new String[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("capacity < 0");
        }
        this.capacity = capacity;
    }

    @Override
    public boolean add(String o) {
        return false;
    }

    @Override
    public boolean add(int index, String o) {
        return false;
    }

    @Override
    public boolean set(int index, String o) {
        return false;
    }

    @Override
    public boolean delete(String o) {
        return false;
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public boolean contain(String o) {
        return false;
    }

    @Override
    public boolean equals(Collection collection) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
