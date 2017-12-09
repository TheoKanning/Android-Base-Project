package theo.base.dagger

import dagger.Module
import dagger.Provides
import theo.base.AppInitializer
import theo.base.DebugAppInitializer
import javax.inject.Singleton

@Module
class BuildVariantModule {

    @Singleton
    @Provides
    internal fun provideDebugAppInitializer(): AppInitializer {
        return DebugAppInitializer()
    }
}
