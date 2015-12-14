public class Division implements Operation {

    @Override
    public int makeOperation(int left, int right) {
        if (right == 0) {
            throw new ArithmeticException();
        }
        return left / right;
    }
}
