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

    /**
     * Copies elements from the source String array to the destination String array
     *
     * <p>The number of elements copied is equal to {@code length},
     * starting from {@code srcPos} in the source array
     * and placing them into the destination array starting from {@code destPos}.</p>
     *
     * @param src the source array of Strings
     * @param srcPos starting position in the source array
     * @param dest the destination array of Strings
     * @param destPos starting position in the destination array
     * @param length the number of elements to copy
     * @throws NullPointerException if {@code src} or {@code dest} is {@code null}
     */
    private static void arrayCopy(String[] src, int srcPos, String[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
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

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Check if all elements of the internal array are equals to all elements in the
     * argument's array
     *
     * @param collection can be only type of MyList
     *
     * @return true only if argument has type of MyList and its elements are equal to
     * internal array elements. If argument's type isn't instance of MyList -> return false.
     * If the length of argument`s size doesn't equal to current collection size -> return false
     */
    @Override
    public boolean equals(Collection collection) {
        if(collection instanceof MyList list){
            if(isEmpty() || (list.size() != this.size()) ){
                return false;
            }

            for(int i = 0; i < size; i++){
                if(!list.get(i).equals(array[i])){
                    return false;
                }
            }
            return true;
        }
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
