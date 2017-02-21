package theo.base.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import theo.base.AppInitializer;
import theo.base.DebugAppInitializer;

@Module
public class BuildVariantModule {

    @Singleton
    @Provides
    AppInitializer provideDebugAppInitializer(){
        return new DebugAppInitializer();
    }
}
