package com.example.administrator.mvprxjavaretrofit.base;


import com.example.administrator.mvprxjavaretrofit.bean.IPHttpResult;
import com.example.administrator.mvprxjavaretrofit.bean.IpInfo;
import com.example.administrator.mvprxjavaretrofit.bean.Movies;
import com.example.administrator.mvprxjavaretrofit.bean.TokenResult;
import com.example.administrator.mvprxjavaretrofit.bean.UserHttpResult;
import com.squareup.okhttp.ResponseBody;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * API--接口  服务[这里处理的是同一的返回格式 resultCode  resultInfo Data<T> --->这里的data才是返回的结果,T就是泛型 具体返回的been对象或集合]
 * Created by HDL on 2016/8/3.
 */
public interface APIService {
    /**
     * 用户登录的接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return RxJava 对象
     */
    @POST("okhttp/UserInfoServlert")
    Observable<UserHttpResult<TokenResult>> userLogin(@Query("username") String username, @Query("pwd") String pwd);

    /**
     * 查询ip地址信息的接口
     *
     * @param ip 需查询的ip
     * @return RxJava 对象
     */
    @GET("service/getIpInfo.php")
    Observable<IPHttpResult<IpInfo>> queryIp(@Query("ip") String ip);

    /**
     * 查询豆瓣排名前250的电影
     *
     * @param start 从第几部开始
     * @param count 几页(一页有12部)
     * @return
     */
    @GET("v2/movie/top250")
    Observable<Movies> getMovies(@Query("start") int start, @Query("count") int count);

    @GET("v2/movie/top250")
    Observable<ResponseBody> getMoviesJson(@Query("start") int start, @Query("count") int count);
}
