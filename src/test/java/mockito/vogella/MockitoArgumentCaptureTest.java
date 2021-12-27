package mockito.vogella;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-27
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Captured Arguments")
public class MockitoArgumentCaptureTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public final void shouldContainCertainListItem(@Mock List<String> mockedList){
        var asList = Arrays.asList("someElement_test","someElement");

        mockedList.addAll(asList);

        Mockito.verify(mockedList).addAll(captor.capture());

        List<String> capturedArgument = captor.getValue();

        assertThat(capturedArgument, hasItem("someElement"));
    }
}
