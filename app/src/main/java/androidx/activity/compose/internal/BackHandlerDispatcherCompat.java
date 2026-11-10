package androidx.activity.compose.internal;

import androidx.activity.OnBackPressedDispatcher;
import androidx.navigationevent.NavigationEventDispatcher;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BR\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/activity/compose/internal/BackHandlerDispatcherCompat;", "", "navigationEventDispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "<init>", "(Landroidx/navigationevent/NavigationEventDispatcher;Landroidx/activity/OnBackPressedDispatcher;)V", "addHandler", "", "handler", "Landroidx/activity/compose/internal/BackHandlerCompat;", "removeHandler", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BackHandlerDispatcherCompat {
    public static final int $stable = 8;
    private final NavigationEventDispatcher navigationEventDispatcher;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    static {
    }

    public BackHandlerDispatcherCompat(NavigationEventDispatcher arg1, OnBackPressedDispatcher arg2) {
        super();
        this.navigationEventDispatcher = arg1;
        this.onBackPressedDispatcher = arg2;
        if(arg1 == null) {
            OnBackPressedDispatcher v1 = arg2;
        }

        if((((NavigationEventDispatcher)v1)) != null) {
            return;
        }

        throw new IllegalArgumentException("At least one dispatcher (NavigationEventDispatcher or OnBackPressedDispatcher) must be non-null.".toString());
    }

    public final void addHandler(BackHandlerCompat arg4) {
        NavigationEventDispatcher v0 = this.navigationEventDispatcher;
        if(v0 != null) {
            NavigationEventDispatcher.addHandler$default(v0, arg4.getNavigationEventHandler(), 0, 2, null);
            return;
        }

        OnBackPressedDispatcher v3 = this.onBackPressedDispatcher;
        if(v3 != null) {
            v3.addCallback(arg4.getOnBackPressedCallback());
            return;
        }

        throw new IllegalStateException("Unreachable".toString());
    }

    public final void removeHandler(BackHandlerCompat arg2) {
        if(this.navigationEventDispatcher != null) {
            arg2.getNavigationEventHandler().remove();
            return;
        }

        if(this.onBackPressedDispatcher != null) {
            arg2.getOnBackPressedCallback().remove();
            return;
        }

        throw new IllegalStateException("Unreachable".toString());
    }
}

