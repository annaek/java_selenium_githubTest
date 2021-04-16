package closeable;

import java.io.Closeable;
import java.io.IOException;

public class MyCloseable implements AutoCloseable {
    public void close() {
        System.out.println("closing");
    }

    public void run() throws Exception {
        System.out.println("running");
        //throw new Exception();
    }

}
