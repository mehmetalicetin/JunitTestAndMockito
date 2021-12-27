package mockito.vogella;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */
public class MockitoThrowsTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    void testMockitoThrows() {
        Properties properties = mock(Properties.class);
        Mockito.when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("stuff"));

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> properties.get("A"));

        Assertions.assertEquals(exception.getMessage(), "stuff");

    }

    @Test
    void testForIOException() throws IOException {
        //create and configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();

        //use mock
        OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);

        Assertions.assertThrows(IOException.class, ()-> streamWriter.close());

    }
}
