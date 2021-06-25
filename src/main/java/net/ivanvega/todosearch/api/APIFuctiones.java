package net.ivanvega.todosearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFuctiones {

    static <T> T buildAPI(Class<T> api,
                          String url){
        return Feign
                .builder()
                .decoder(new GsonDecoder())
                .target(api,url);
    }

}
