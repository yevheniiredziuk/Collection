public class MyList implements Collection{


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
        return 0;
    }
}
