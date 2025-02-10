package fm.samples.token.loader;

import java.io.IOException;

public class TokenLoader {
    private final String url;
    private final boolean chrome;

    public TokenLoader(String url, boolean noChrome) {
        this.url = url;
        this.chrome = !noChrome;
    }

    public void start() throws IOException {
        var chrome = new ProcessBuilder("google-chrome", url).start();

        System.out.format("Launching %s in chrome %s%n", url, chrome);
    }

}
