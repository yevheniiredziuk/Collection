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
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
    }

    // todo
    @Override
    public boolean add(String o) {
        return false;
    }

    // todo
    @Override
    public boolean add(int index, String o) {
        return false;
    }

    @Override
    public boolean set(int index, String o) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index < 0 || index >= size");
        }
        if(isEmpty()){
            throw new IllegalStateException("list is empty");
        }
        if(o == null){
            throw new IllegalArgumentException("o == null");
        }
        array[index] = o;
        return true;
    }

    // todo
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
            throw new IllegalStateException("list is empty");
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

    // todo
    @Override
    public boolean equals(Collection collection) {
        return false;
    }

    /**
     * Removes all elements from this collection.
     * After calling this method, the collection will be empty
     * and {@link #size()} will return 0
     *
     * @return false when collection is already empty otherwise return true
     *
     * <p>Note: This operation only removes references to the elements
     * stored in this collection. The objects themselves are not destroyed,
     * but may be garbage-collected if there are no other references to them</p>
     */
    @Override
    public boolean clear() {
        if(isEmpty()){
            return false;
        }
        int oldSize = size;
        size = 0;
        for(int i = oldSize; i > 0; i--){
            array[i] = null;
        }
        return true;
    }


    @Override
    public int size() {
        return size;
    }
}
