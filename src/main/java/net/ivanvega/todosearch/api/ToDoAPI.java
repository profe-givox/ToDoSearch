package net.ivanvega.todosearch.api;


import net.ivanvega.todosearch.ToDo;

import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;


@Headers("Accept: application/json")
public interface ToDoAPI {

    @RequestLine("GET /todoitems/Search")
    public List<ToDo> tareasBusqueda
            (@QueryMap Map<String,Object> queryMap);

}
