package theo.base.dagger;

import android.content.Context;

import dagger.Module;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }
}
