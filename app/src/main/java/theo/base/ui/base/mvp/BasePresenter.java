package theo.base.ui.base.mvp;

public class BasePresenter<V extends BaseView>{

    private V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    public V getView() {
        if (isViewAttached()) {
            return this.view;
        }

        throw new ViewNotAttachedException();
    }
}