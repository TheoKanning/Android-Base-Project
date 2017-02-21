package theo.base.ui.main;

import android.os.Bundle;

import theo.base.R;
import theo.base.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(new MainFragment(), true);
    }
}
