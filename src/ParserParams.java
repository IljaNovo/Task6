import org.apache.commons.cli.*;

public class ParserParams {

    private Option leftParam;
    private Option rightParam;
    private Option signOperation;

    public ParserParams() {
        this.leftParam = createOption("l", true, "LeftParam");
        this.rightParam = createOption("r", true, "RightParam");
        this.signOperation = createOption("o", true, "SignOperation");
    }

    private Option createOption(String opt, boolean hasArg, String description) {
        Option newOption = new Option(opt, hasArg, description);
        newOption.setArgs(1);
        newOption.setOptionalArg(false);

        return newOption;
    }

    public void parse(String[] commandLineArguments) throws ParseException{
        Options posixOptions = new Options();

        posixOptions.addOption(this.leftParam);
        posixOptions.addOption(this.rightParam);
        posixOptions.addOption(this.signOperation);

        CommandLineParser cmdLinePosixParser = new PosixParser();
        CommandLine commandLine = null;
        String[] params = new String[3];

        try {
            commandLine = cmdLinePosixParser.parse(posixOptions, commandLineArguments);

            if (commandLine.hasOption("l") && commandLine.hasOption("r") && commandLine.hasOption("o")) {
                params[0] = commandLine.getOptionValues("l")[0];
                params[1] = commandLine.getOptionValues("r")[0];
                params[2] = commandLine.getOptionValues("o")[0];
            }

            setValueParams(params[0], params[1], params[2]);
        }
        catch (ParseException e) {
            throw new ParseException("Error Parse");
        }
        catch (Throwable e) {
            throw new ParseCommandLineExeption("Error Parse");
        }
    }

    private Integer valueLeftParam = null;
    private Integer valueRightParam = null;
    private String symbolSignOperation = null;

    public int getValueLeftParam(){
        if (valueLeftParam == null) {
            throw new NullPointerException();
        }
        return valueLeftParam;
    }

    public int getValueRightParam() {
        if (valueRightParam == null) {
            throw new NullPointerException();
        }
        return valueRightParam;
    }

    public String getSymbolSignOperation() {
        if (symbolSignOperation == null) {
            throw new NullPointerException();
        }
        return symbolSignOperation;
    }

    private void setValueParams(String leftParam, String rightParam, String signOperation) {
        this.valueLeftParam = Integer.valueOf(leftParam);
        this.valueRightParam = Integer.valueOf(rightParam);
        this.symbolSignOperation = signOperation;
    }
}