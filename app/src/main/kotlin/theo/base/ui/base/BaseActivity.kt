package theo.base.ui.base


import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import theo.base.R

abstract class BaseActivity : AppCompatActivity() {

    val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragment_container) as BaseFragment

    private val currentFragmentName: String
        get() = currentFragment!!.javaClass.canonicalName

    interface OnBackPressedListener {
        fun onBackPressed(): Boolean
    }

    override fun onBackPressed() {
        if (backPressEventConsumedByFragment()) {
            return
        }

        super.onBackPressed()
    }

    fun setFragment(fragment: BaseFragment?, animate: Boolean) {
        // First, get the current fragment. If there isn't a current fragment, then add the new
        // fragment.  If there is, then potentially replace the current fragment with the new one.
        // However, if the user tries to navigate to the exact same fragment, that will look silly,
        // so only do so if the new fragment has a different canonical name than the current one.
        if (fragment != null) {
            if (currentFragment == null) {
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit()
            } else if (currentFragmentName != fragment.javaClass.canonicalName) {
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fragment_container, fragment)
                ft.addToBackStack(fragment.javaClass.simpleName)
                if (animate) {
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                }
                ft.commit()
            }
        }
    }

    /**
     * @return true if event is consumed by fragment
     */
    private fun backPressEventConsumedByFragment(): Boolean {
        val currentFragment = currentFragment ?: return false

        return currentFragment.onBackPressed()
    }
}
