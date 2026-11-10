package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u0004\u0018\u00010\bJ\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0006J\u000E\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0006J\u000E\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\bJ\u0006\u0010\u000F\u001A\u00020\u000BR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/activity/contextaware/ContextAwareHelper;", "", "<init>", "()V", "listeners", "", "Landroidx/activity/contextaware/OnContextAvailableListener;", "context", "Landroid/content/Context;", "peekAvailableContext", "addOnContextAvailableListener", "", "listener", "removeOnContextAvailableListener", "dispatchOnContextAvailable", "clearAvailableContext", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ContextAwareHelper {
    private volatile Context context;
    private final Set listeners;

    public ContextAwareHelper() {
        super();
        this.listeners = new CopyOnWriteArraySet();
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        Context v0 = this.context;
        if(v0 != null) {
            arg2.onContextAvailable(v0);
        }

        this.listeners.add(arg2);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        this.context = arg2;
        Iterator v1 = this.listeners.iterator();
        while(v1.hasNext()) {
            v1.next().onContextAvailable(arg2);
        }
    }

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.listeners.remove(arg2);
    }
}

