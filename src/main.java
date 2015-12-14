import org.apache.commons.cli.*;

public class main {

    public static void main(String[] args) {
        String[] answers = "-l / 22 -r -33 22".split(" ");

        Option ret = new Option("l", true, "Login");
        Option ret1 = new Option("r", true, "Right");

        ret.setArgs(2);
        ret.setOptionalArg(false);
        ret.setArgName("login ");

        ret1.setArgs(2);
        ret1.setOptionalArg(false);
        ret1.setArgName("login ");


        Options posixOptions = new Options();

        posixOptions.addOption(ret);
        posixOptions.addOption(ret1);

        CommandLineParser cmdLinePosixParser = new PosixParser();
        CommandLine commandLine = null;

        try {
            commandLine = cmdLinePosixParser.parse(posixOptions, answers);
        } catch (ParseException e) {
            e.getStackTrace();
        }

        String[] argums = null;

        if (commandLine.hasOption("l")) {
            argums = commandLine.getOptionValues("l");

            System.out.println("We try to Login with: " + argums[0] + " " + argums[1]);
        }

        if (commandLine.hasOption("r")) {
            argums = commandLine.getOptionValues("r");

            System.out.println("We try to Login with: " + argums[0] + " " + argums[1]);
        }
    }
}
