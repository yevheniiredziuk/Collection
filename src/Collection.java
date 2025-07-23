public interface Collection <T> {
    boolean add(T o); //- add element
    void add(int index, T o); //- add element by index
    boolean set(int index, T o);
    boolean delete (T o);
    T get(int index);
    boolean contain(T o);
    boolean equals (Collection <T> collection);
    boolean clear();
    int size();
}
