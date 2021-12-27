package mockito.vogella;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */
public class MockitoSpyWithListTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    @DisplayName("5.2")
    void ensureSpyForListWorks(){
        var list = new ArrayList<String>();
        var spy = spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls real methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");


        doReturn("42").when(spy).get(99); // 99.index =  "42"
        String value = spy.get(99);

        assertEquals(value, "42");
    }
}
