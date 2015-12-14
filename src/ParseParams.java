import org.apache.commons.cli.*;

public class ParseParams {

    Option leftParam;
    Option rightParam;
    Option signOperation;

    public ParseParams() {
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

    public void parse(String[] commandLineArguments) {
        Options posixOptions = new Options();

        posixOptions.addOption(this.leftParam);
        posixOptions.addOption(this.rightParam);
        posixOptions.addOption(this.signOperation);

        CommandLineParser cmdLinePosixParser = new PosixParser();
        CommandLine commandLine = null;

        try {
            commandLine = cmdLinePosixParser.parse(posixOptions, commandLineArguments);
        } catch (ParseException e) {
            e.getStackTrace();
        }
        String[] params = new String[3];

        if (commandLine.hasOption("l") && commandLine.hasOption("r") && commandLine.hasOption("o")) {
            params[0] = commandLine.getOptionValues("l")[0];
            params[1] = commandLine.getOptionValues("r")[0];
            params[2] = commandLine.getOptionValues("o")[0];
        }
        setValueParams(params[0], params[1], params[2]);
    }

    private int valueLeftParam;
    private int valueRightParam;
    private String symbolSignOperation;

    public int getValueLeftParam() {
        return valueLeftParam;
    }

    public int getValueRightParam() {
        return valueRightParam;
    }

    public String getSymbolSignOperation() {
        return symbolSignOperation;
    }

    private void setValueParams(String leftParam, String rightParam, String signOperation) {
        this.valueLeftParam = Integer.valueOf(leftParam);
        this.valueRightParam = Integer.valueOf(rightParam);
        this.symbolSignOperation = signOperation;
    }
}