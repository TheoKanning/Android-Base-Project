package theo.base.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;
import icepick.Icepick;

import static dagger.internal.Preconditions.checkNotNull;


public abstract class BaseFragment extends Fragment implements BaseActivity.OnBackPressedListener{

    private Unbinder unbinder = Unbinder.EMPTY;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Icepick.restoreInstanceState(this, savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Icepick.saveInstanceState(this, outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    /**
     * Override and return true to consume back press event.
     */
    @Override
    public boolean onBackPressed() {
        return false;
    }

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    /**
     * Sets the unbinder that will be used to unbind all views in onDestroyView
     * @param unbinder Butterknife Unbinder
     */
    protected void setUnbinder(Unbinder unbinder) {
        this.unbinder = checkNotNull(unbinder, "unbinder == null");
    }
}