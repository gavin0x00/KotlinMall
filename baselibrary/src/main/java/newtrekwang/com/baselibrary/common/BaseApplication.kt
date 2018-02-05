package newtrekwang.com.baselibrary.common

import android.app.Application
import newtrekwang.com.baselibrary.injection.component.AppComponent
import newtrekwang.com.baselibrary.injection.component.DaggerAppComponent
import newtrekwang.com.baselibrary.injection.module.AppModule

/**
 * Created by Newterk on 2018/2/5.
 */
class BaseApplication :Application() {
lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}