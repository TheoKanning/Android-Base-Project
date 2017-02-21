package theo.base;


import net.danlew.android.joda.JodaTimeAndroid;

public abstract class AppInitializer {

    void init(BaseApplication app){
        JodaTimeAndroid.init(app);
        buildTypeDependentInitialization(app);
    }

    abstract void buildTypeDependentInitialization(BaseApplication app);
}
