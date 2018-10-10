package com.kuyun;

import feign.Feign;
import feign.Request.Options;
import feign.Retryer;

/**
 * Created by xuwuqiang on 2018/10/10.
 */
public class Test {

    static RemoteService service = Feign.builder()
        .options(new Options(1000, 3500))//connectTimeout,readTimeout
        .retryer(new Retryer.Default(5000, 5000, 3))
        .target(RemoteService.class, "http://localhost:10080");

    /*
    static RemoteService service1 = Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .options(new Options(1000, 3500))
        .retryer(new Retryer.Default(5000, 5000, 3))
        .target(RemoteService.class, "http://127.0.0.1:10080");

    */
    public static void main(String[] args) {
        String result = service.getOwner("scott");
        System.out.println(result);

    }

}
