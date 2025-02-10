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
    @Option(
        names = {"--browser"},
        description = "Launch browser command.",
        defaultValue = "google-chrome")
    private String browser;

    @Option(
        names = {"--number"},
        description = "Number of URLs to launch.",
        defaultValue = "5")
    private int launchNumber;

    @Option(
        names = {"--delay"},
        description = "Seconds delay between launches.",
        defaultValue = "5")
    private int secondsDelay;

    @Parameters(
        index = "0",
        description = "URL to deep-link",
        defaultValue = "https://www.example.com")
    private String url;

    @Override
    public void run() {
        var loader = new TokenLoader(browser, launchNumber, secondsDelay, url);

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
