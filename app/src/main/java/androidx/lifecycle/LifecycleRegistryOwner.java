package androidx.lifecycle;

@Deprecated public interface LifecycleRegistryOwner extends LifecycleOwner {
    default Lifecycle getLifecycle() {
        return this.getLifecycle();
    }

    LifecycleRegistry getLifecycle();
}

