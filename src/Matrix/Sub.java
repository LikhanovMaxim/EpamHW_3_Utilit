package Matrix;

final class Sub implements OperationMatrix {
    @Override
    public double calculation(double left, double right) {
        return left - right;
    }

}