public class MyList implements Collection {
    private int size;
    private int capacity;
    private String[] array;
    private static final int DEFAULT_CAPACITY = 10;


    public MyList() {
        capacity = DEFAULT_CAPACITY;
        this.array = new String[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        }
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.array = new String[this.capacity];
    }


    @Override
    public boolean add(String o) {
        add(size, o);
        return true;
    }


    @Override
    public void add(int index, String o) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        } // Objects.checkIndex(index, size) alternatively
        if (size == capacity) {
            array = makeLarger();
        }
        arrayCopy(array, index, array, index + 1, size - index);
        array[index] = o;
        size++;
    }

    private String[] makeLarger() {
        capacity = capacity * 2;
        String[] newArray = new String[capacity];
        arrayCopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public boolean set(int index, String o) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index < 0 || index >= size");
        }
        if (isEmpty()) {
            throw new IllegalStateException("list is empty");
        }
        if (o == null) {
            throw new IllegalArgumentException("o == null");
        }
        array[index] = o;
        return true;
    }

    /**
     * Deletes the first occurrence of the specified element from this list, if it is present.
     * Shifts all right-sided elements to the left.
     *
     * <p>If the specified element is not found, the method returns {@code false}
     * and the list will stay unchanged.</p>
     *
     * @param o the String element to delete (must not be {@code null})
     * @return {@code true} if the element was found and deleted; {@code false} otherwise
     * @throws IllegalArgumentException if {@code o} is {@code null}
     */
    @Override
    public boolean delete(String o) {
        if (o == null) {
            throw new IllegalArgumentException("o == null");
        }
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        arrayCopy(array, index + 1, array, index, size - 1 - index);
        array[--size] = null; // to delete last copied element
        return false;
    }

    public int indexOf(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) { // I remembered you explanation about null
                return i;           // we can write o.equals(array[i]) but what if o == null
            }                       // so thank you so much for this tip! :)
        }
        return -1;
    }


    /**
     * Copies elements from the source array to the destination array.
     * Correctly handles the case when src and dest are the same array.
     *
     * @param src     the source array
     * @param srcPos  starting position in the source array
     * @param dest    the destination array
     * @param destPos starting position in the destination array
     * @param length  the number of elements to copy
     * @throws NullPointerException           if src or dest is null
     * @throws ArrayIndexOutOfBoundsException if copying would cause access outside array bounds
     */
    private static void arrayCopy(String[] src, int srcPos, String[] dest, int destPos, int length) {
        if (src == dest && srcPos < destPos) {
            // copy backwards
            for (int i = length - 1; i >= 0; i--) {
                dest[destPos + i] = src[srcPos + i];
            }
        } else {
            // copy forwards
            for (int i = 0; i < length; i++) {
                dest[destPos + i] = src[srcPos + i];
            }
        }
    }


    // done
    @Override
    public String get(int index) {
        if (!isIndexCorrect(index)) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        return array[index];
    }

    private boolean isIndexCorrect(int index) {
        return (index >= 0) && (index < size);
    }

    @Override
    public boolean contain(String o) {
        if (o == null) {
            throw new IllegalArgumentException("o == null");
        }
        if (isEmpty()) {
            throw new IllegalStateException("list is empty");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if all elements of the internal {@code array}  are equals to all elements in the
     * argument's array
     *
     * @param collection can be only type of MyList
     * @return {@code true} only if argument {@code collection} has type of MyList and its elements are equal to
     * internal {@code array} elements. If argument's type isn't instance of MyList -> return {@code false}.
     * If the length of argument`s size doesn't equal to current collection size -> return {@code false}
     */
    @Override
    public boolean equals(Collection collection) {
        if (collection instanceof Collection list) {
            if (isEmpty() || (list.size() != this.size())) {
                return false;
            }

            for (int i = 0; i < size; i++) {
                if (!list.get(i).equals(array[i])) {
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
     */
    @Override
    public boolean clear() {
        array = new String[DEFAULT_CAPACITY];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString();
    }

}
