package theo.base;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import theo.base.dagger.BaseComponent;
import theo.base.dagger.BaseGraph;

public class BaseApplication extends Application {

    @Inject AppInitializer appInitializer;

    private BaseGraph component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        buildComponentAndInject();

        appInitializer.init(this);
    }

    private void buildComponentAndInject() {
        component = BaseComponent.Initializer.init(this);
        component.inject(this);
    }

    public BaseGraph getComponent() {
        return component;
    }
}
