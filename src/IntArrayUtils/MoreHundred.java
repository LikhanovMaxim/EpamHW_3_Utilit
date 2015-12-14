package IntArrayUtils;

final class MoreHundred implements PredicateIntArr {

    @Override
    public boolean apply(int value) {
        if (value > 100) {
            return true;
        }
        return false;
    }
}
