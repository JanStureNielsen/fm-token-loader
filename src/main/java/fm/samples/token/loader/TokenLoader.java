package fm.samples.token.loader;

import java.io.IOException;

public class TokenLoader {
    private final String url;
    private final String browserCommand;

    public TokenLoader(String browserCommand, String url) {
        this.url = url;
        this.browserCommand = browserCommand;
    }

    public void start() throws IOException {
        var browser = new ProcessBuilder(browserCommand, url).start();

        System.out.format("%s %s%n", browser, url);
    }

}
