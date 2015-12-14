public class DemoProgect {

    public static void main(String[] args) {
        ParserParams parserParams = new ParserParams();

        try {
            parserParams.parse(args);
        }
        catch (Throwable e) {
            System.out.println("Error Parse");
        }
        Operation operation = null;

        switch (parserParams.getSymbolSignOperation()) {
            case "+":
                operation = new Addition();
                break;
            case "-":
                operation = new Subtraction();
                break;
            case "*":
                operation = new Multiplication();
                break;
            case "/":
                operation = new Division();
                break;
        }
        System.out.println(operation.makeOperation(parserParams.getValueLeftParam(),
                parserParams.getValueRightParam()));
    }
}
