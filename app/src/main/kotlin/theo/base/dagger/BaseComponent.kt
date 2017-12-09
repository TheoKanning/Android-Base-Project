package theo.base.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, BuildVariantModule::class))
interface BaseComponent : BaseGraph

