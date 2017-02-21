package theo.base.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        BuildVariantModule.class
})
public interface BaseComponent extends BaseGraph {

    final class Initializer {
        private Initializer() {
            throw new AssertionError("No Instances.");
        }

        public static BaseGraph init(Application app) {
            return DaggerBaseComponent.builder()
                    .build();
        }
    }
}

