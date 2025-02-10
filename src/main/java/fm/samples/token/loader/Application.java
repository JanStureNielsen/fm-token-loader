package fm.samples.token.loader;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(
        name = "FM Token Loader",
        mixinStandardHelpOptions = true,
        version = "greet 0.1",
        description = "Use FM token API to sign-in users."
)
public class Application implements Runnable {
    @Parameters(
        index = "0",
        description = "URL to deep-link")
    private String url;

    @Option(
            names = {"--chrome"},
            description = "Launch each user in chrome.",
            defaultValue = "false")
    private boolean chrome;

    @Override
    public void run() {
        System.out.format("Launching %s in chrome %s%n", url, chrome);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);

        System.exit(exitCode);
    }

}
