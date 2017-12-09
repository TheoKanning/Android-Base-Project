package theo.base.ui.main

import android.os.Bundle

import theo.base.R
import theo.base.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(MainFragment(), true)
    }
}
