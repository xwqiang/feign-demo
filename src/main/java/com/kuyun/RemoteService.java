package com.kuyun;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by xuwuqiang on 2018/10/10.
 */
public interface RemoteService {

    @RequestLine("GET /test?name={name}")
    String getOwner(@Param(value = "name") String name);


    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @RequestLine("POST /users/list")
    User getOwner(User user);

}
