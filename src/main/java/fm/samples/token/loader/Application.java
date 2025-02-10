package fm.samples.token.loader;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

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
        names = {"--browser-command"},
        description = "Launch browser command.",
        defaultValue = "google-chrome")
    private String browserCommand;

    @Override
    public void run() {
        var loader = new TokenLoader(browserCommand, url);

        try {
            loader.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);

        System.exit(exitCode);
    }

}
