package mockito.stub.business;

import com.cetin.unit.mockito.stub.ToDoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public class ToDoServiceStub implements ToDoService {

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
    }


}
