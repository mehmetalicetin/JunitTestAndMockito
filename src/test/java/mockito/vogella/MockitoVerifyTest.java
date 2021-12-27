package mockito.vogella;

import com.cetin.vogella.DataBase;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.*;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */

@ExtendWith(MockitoExtension.class)
public class MockitoVerifyTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    @DisplayName("6.1")
    public void testVerify(@Mock DataBase dataBase) {
        // create and configure mock
        when(dataBase.getUniqueId()).thenReturn(43);

        // call method testing on the mock with parameter 12
        dataBase.setUniqueId(12);
        dataBase.getUniqueId();
        dataBase.getUniqueId();


        // now check if method testing was called with the parameter 12
        verify(dataBase).setUniqueId(ArgumentMatchers.eq(12));

        // was the method call twice
        verify(dataBase, times(2)).getUniqueId();

        // other alternatives for verifiying the number of method calls for a method
        verify(dataBase, never()).isAvailable();
        verify(dataBase, never()).setUniqueId(13);
        verify(dataBase, atLeastOnce()).setUniqueId(12);
        verify(dataBase, atLeast(2)).getUniqueId();

        // more options are
        // times(numberOfTimes)
        // atMost(numberOfTimes)
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        verifyNoMoreInteractions(dataBase);

    }
}
