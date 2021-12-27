package mockito.vogella;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */

@ExtendWith(MockitoExtension.class)
public class MockitoSpyTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Spy
    List<String> spy = new LinkedList<>();

    @BeforeEach
    void setUp(){
        // Alternative way of creating a spy
        // List<String> list = new LinkedList<>();
        // List<String> spy = spy(list);
    }

    @Test
    @DisplayName("6")
    void testLinkedListSpyCorrecy(){
        // when(spy.get(0)).thenReturn("foo");
        // would not work as the delegate it called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)

        // you have to use doReturn() for stubbing

        Mockito.doReturn("foo").when(spy).get(0);

        Assertions.assertEquals("foo",spy.get(0));

    }
}
