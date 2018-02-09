package newtrekwang.com.usercenter.data.repository


import newtrekwang.com.baselibrary.data.net.RetrofitFactory
import newtrekwang.com.baselibrary.data.protocal.BaseResp
import newtrekwang.com.usercenter.data.api.UserApi
import newtrekwang.com.usercenter.data.protocol.LoginReq
import newtrekwang.com.usercenter.data.protocol.RegisterReq
import newtrekwang.com.usercenter.data.protocol.UserInfo
import retrofit2.http.Path
import rx.Observable
import javax.inject.Inject

/**
 * Created by WJX on 2018/2/3.
 *
 */
class   UserResipository @Inject constructor(){
    fun register( virifyCode:String,phone:String,pwd:String): Observable<BaseResp<String>> {
     return   RetrofitFactory.instance.create(UserApi::class.java)
             .register(RegisterReq(mobile =phone,verifyCode = virifyCode,pwd = pwd ))
    }


    fun login(mobile: String,pwd: String,pushId: String): Observable<BaseResp<UserInfo>>{
        return  RetrofitFactory.instance.create(UserApi::class.java)
                .login(loginReq = LoginReq(mobile=mobile,pwd = pwd,pushId = pushId))
    }

}