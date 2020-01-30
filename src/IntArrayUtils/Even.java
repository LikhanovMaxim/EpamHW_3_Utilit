package IntArrayUtils;


final class Even implements PredicateInt {

    @Override
    public boolean apply(int value) {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }
}