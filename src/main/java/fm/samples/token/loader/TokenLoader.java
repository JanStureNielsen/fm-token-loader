package fm.samples.token.loader;

import java.io.IOException;

public class TokenLoader {
    private final String browserCommand;
    private final int number;
    private final String url;

    public TokenLoader(String browserCommand, int number, String url) {
        this.browserCommand = browserCommand;
        this.number = number;
        this.url = url;
    }

    public void start() throws IOException {
        for (int i = 0; i < number; i++) {
            var browser = new ProcessBuilder(browserCommand, url).start();

            System.out.format("%d %s %s%n", i, browser, url);
        }
    }

}
