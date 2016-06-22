package com.junbaole.kindergartern.domain;

import com.junbaole.kindergartern.data.model.UserInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liangrenwang on 16/6/22.
 */
public interface Action {

    @GET("/")
    List<UserInfo> getUserInfo(String info);

}
