package com.cetin.unit.mockito.stub;

import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-22
 */
public interface ToDoService {
    List<String> retrieveTodos(String user);
}
