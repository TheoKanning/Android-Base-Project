package theo.base;


import android.app.Application;

import javax.inject.Inject;

import theo.base.dagger.BaseComponent;
import theo.base.dagger.BaseGraph;

public class BaseApplication extends Application {

    @Inject AppInitializer appInitializer;

    private BaseGraph component;

    @Override
    public void onCreate() {
        super.onCreate();

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
