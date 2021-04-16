package closeable;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        try (MyCloseable c = new MyCloseable()) {
            c.run();
        }
        MyCloseable r = null;
        try {
            r = new MyCloseable();
            r.run();
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
