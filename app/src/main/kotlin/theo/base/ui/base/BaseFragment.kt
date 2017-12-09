package theo.base.ui.base

import android.support.v4.app.Fragment

import butterknife.Unbinder

import dagger.internal.Preconditions.checkNotNull


abstract class BaseFragment : Fragment(), BaseActivity.OnBackPressedListener {

    private var unbinder = Unbinder.EMPTY

    protected val baseActivity: BaseActivity
        get() = activity as BaseActivity

    override fun onDestroyView() {
        unbinder.unbind()
        super.onDestroyView()
    }

    /**
     * Override and return true to consume back press event.
     */
    override fun onBackPressed(): Boolean {
        return false
    }

    /**
     * Sets the unbinder that will be used to unbind all views in onDestroyView
     * @param unbinder Butterknife Unbinder
     */
    protected fun setUnbinder(unbinder: Unbinder) {
        this.unbinder = checkNotNull(unbinder, "unbinder == null")
    }
}