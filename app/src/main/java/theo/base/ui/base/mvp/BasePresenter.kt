package theo.base.ui.base.mvp

class BasePresenter<V : BaseView> {

    private var view: V? = null

    val isViewAttached: Boolean
        get() = this.view != null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun getView(): V {
        if (isViewAttached) {
            return this.view!!
        }

        throw ViewNotAttachedException()
    }
}