package theo.base;


import com.squareup.leakcanary.LeakCanary;

import net.danlew.android.joda.JodaTimeAndroid;

public abstract class AppInitializer {

    void init(BaseApplication app){
        JodaTimeAndroid.init(app);
        LeakCanary.install(app);
        buildTypeDependentInitialization(app);
    }

    abstract void buildTypeDependentInitialization(BaseApplication app);
}
