package theo.base.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import theo.base.AppInitializer;
import theo.base.ReleaseAppInitializer;

@Module
public class BuildVariantModule {

    @Singleton
    @Provides
    AppInitializer provideReleaseAppInitializer(){
        return new ReleaseAppInitializer();
    }
}
