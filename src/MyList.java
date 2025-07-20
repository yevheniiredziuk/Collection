public class MyList implements Collection{
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

    // done
    @Override
    public String get(int index) {
        if(!isIndexCorrect(index)){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        return array[index];
    }

    private boolean isIndexCorrect(int index) {
        return (index >= 0) && (index < size);
    }

    @Override
    public boolean contain(String o) {
        if(o == null){
            throw new IllegalArgumentException("o == null");
        }
        if(isEmpty()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(){
        return size == 0;
    }
    @Override
    public boolean equals(Collection collection) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    //done
    @Override
    public int size() {
        return size;
    }
}
