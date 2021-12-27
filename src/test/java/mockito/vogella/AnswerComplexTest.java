package mockito.vogella;

import com.cetin.vogella.ApiService;
import com.cetin.vogella.Callback;
import com.cetin.vogella.User;
import com.cetin.vogella.UserDao;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-27
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Answers")
//@RunWith(MockitoJUnitRunner.Silent.class) // This Mockito JUnit Runner implementation ignores unused stubs
public class AnswerComplexTest {

    // activate the strict subs rule
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    List<String> list ;

    @Test
    public final void answerTest(){
        //with doAnswer():
        doAnswer(returnsFirstArg()).when(list).add(anyString());

        // with thenAnswer():
        when(list.add(anyString())).thenAnswer(returnsFirstArg());

        //with then() alias:
        when(list.add(anyString())).then(returnsFirstArg());
    }

    //if you need to do a callback on your argument:
    @Test
    public final void callbackTest(){
        ApiService service = mock(ApiService.class);
        when(service.login(any(Callback.class))).thenAnswer(i->{
            Callback callback = i.getArgument(0);
            callback.notify("Success");
            return null;
        });
    }


    @Test
    public final void daoTest(){
        List<User> userMap = new ArrayList<>();
        UserDao dao = mock(UserDao.class);
        Mockito.when(dao.save(any(User.class))).thenAnswer(i -> {
            User user = i.getArgument(0);
            userMap.add(user.getId(), user);
            return null;
        });
        when(dao.find(any(Integer.class))).thenAnswer(i -> {
            int id = i.getArgument(0);
            return userMap.get(id);
        });
    }
}
