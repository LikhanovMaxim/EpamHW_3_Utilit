package Matrix;

final class Add implements OperationMatrix {
    @Override
    public double calculation(double left, double right) {
        return left + right;
    }

}