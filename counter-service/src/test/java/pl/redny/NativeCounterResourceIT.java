package pl.redny;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeCounterResourceIT extends CounterResourceTest {

    // Execute the same tests but in native mode.
}