package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

final class CompositeOnPageChangeCallback extends OnPageChangeCallback {
    private final List mCallbacks;

    CompositeOnPageChangeCallback(int arg2) {
        super();
        this.mCallbacks = new ArrayList(arg2);
    }

    void addOnPageChangeCallback(OnPageChangeCallback arg1) {
        this.mCallbacks.add(arg1);
    }

    public void onPageScrollStateChanged(int arg3) {
        try {
            Iterator v0 = this.mCallbacks.iterator();
            while(v0.hasNext()) {
                v0.next().onPageScrollStateChanged(arg3);
            }
        }
        catch(ConcurrentModificationException v3) {
            goto label_9;
        }

        return;
    label_9:
        this.throwCallbackListModifiedWhileInUse(v3);
    }

    public void onPageScrolled(int arg3, float arg4, int arg5) {
        try {
            Iterator v0 = this.mCallbacks.iterator();
            while(v0.hasNext()) {
                v0.next().onPageScrolled(arg3, arg4, arg5);
            }
        }
        catch(ConcurrentModificationException v3) {
            goto label_9;
        }

        return;
    label_9:
        this.throwCallbackListModifiedWhileInUse(v3);
    }

    public void onPageSelected(int arg3) {
        try {
            Iterator v0 = this.mCallbacks.iterator();
            while(v0.hasNext()) {
                v0.next().onPageSelected(arg3);
            }
        }
        catch(ConcurrentModificationException v3) {
            goto label_9;
        }

        return;
    label_9:
        this.throwCallbackListModifiedWhileInUse(v3);
    }

    void removeOnPageChangeCallback(OnPageChangeCallback arg1) {
        this.mCallbacks.remove(arg1);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException arg2) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", ((Throwable)arg2));
    }
}

