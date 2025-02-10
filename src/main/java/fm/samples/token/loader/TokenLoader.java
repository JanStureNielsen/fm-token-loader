package fm.samples.token.loader;

import java.io.IOException;
import java.time.Duration;

public class TokenLoader {
    private final String browserCommand;
    private final int number;
    private final int secondsDelay;
    private final String url;

    public TokenLoader(String browserCommand, int number, int secondsDelay, String url) {
        this.browserCommand = browserCommand;
        this.number = number;
        this.secondsDelay = secondsDelay;
        this.url = url;
    }

    public void start() throws IOException, InterruptedException {
        for (int i = 0; i < number; i++) {
            var browser = new ProcessBuilder(browserCommand, url).start();
            Thread.sleep(Duration.ofSeconds(secondsDelay));
            System.out.format("%d %s %s%n", i, browser, url);
        }
    }

}
