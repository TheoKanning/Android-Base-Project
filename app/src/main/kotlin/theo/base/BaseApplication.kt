package theo.base


import android.app.Application
import com.squareup.leakcanary.LeakCanary
import theo.base.dagger.BaseGraph
import theo.base.dagger.DaggerBaseComponent
import javax.inject.Inject

class BaseApplication : Application() {

    @Inject
    lateinit var appInitializer: AppInitializer

    var component: BaseGraph? = null
        private set

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        buildComponentAndInject()

        appInitializer.init(this)
    }

    private fun buildComponentAndInject() {
        component = DaggerBaseComponent.create()
        component!!.inject(this)
    }
}
