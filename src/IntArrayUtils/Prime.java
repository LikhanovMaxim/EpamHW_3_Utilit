package IntArrayUtils;

final class Prime implements PredicateInt {

    @Override
    public boolean apply(int value) {
        value = Math.abs(value);
        if (value == 0) {
            return false;
        }
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
