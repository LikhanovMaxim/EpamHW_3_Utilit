public interface Operation {
    double getResult(double left, double right);

    final class Add implements Operation {
        @Override
        public double getResult(double left, double right) {
            return left + right;
        }

    }

    final class Sub implements Operation {
        @Override
        public double getResult(double left, double right) {
            return left - right;
        }

    }
}
