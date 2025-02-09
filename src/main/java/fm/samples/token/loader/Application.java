package fm.samples.token.loader;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String who = "world";

        if (0 < args.length) {
            who = String.join(" ", Arrays.asList(args));
        }

        System.out.println(String.format("Hello %s!", who));
    }

}
