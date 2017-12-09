package theo.base.dagger

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import theo.base.AppInitializer
import theo.base.ReleaseAppInitializer

@Module
class BuildVariantModule {

    @Singleton
    @Provides
    internal fun provideReleaseAppInitializer(): AppInitializer {
        return ReleaseAppInitializer()
    }
}
