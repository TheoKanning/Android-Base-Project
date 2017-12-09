package theo.base.ui.base.mvp

class ViewNotAttachedException : RuntimeException("Must attach view to presenter before attempting to perform view operations")