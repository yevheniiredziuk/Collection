public interface Collection {
    boolean add(String o); //- add element
    boolean add(int index, String o); //- add element by index
    boolean set(int index, String o);
    boolean delete (String o);
    String get(int index);
    boolean contain(String o);
    boolean equals (Collection collection);
    boolean clear();
    int size();
}
