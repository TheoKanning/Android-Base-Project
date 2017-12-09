package theo.base


import com.squareup.leakcanary.LeakCanary

import net.danlew.android.joda.JodaTimeAndroid

abstract class AppInitializer {

    fun init(app: BaseApplication) {
        JodaTimeAndroid.init(app)
        LeakCanary.install(app)
        buildTypeDependentInitialization(app)
    }

    protected abstract fun buildTypeDependentInitialization(app: BaseApplication)
}
