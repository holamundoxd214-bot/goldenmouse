package androidx.activity.compose.internal;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\r\u001A\u00020\tH&J\b\u0010\u000E\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u00108W@WX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u001A¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2={"Landroidx/activity/compose/internal/BackHandlerCompat;", "", "info", "Landroidx/navigationevent/NavigationEventInfo;", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;)V", "getInfo", "()Landroidx/navigationevent/NavigationEventInfo;", "onBackStarted", "", "event", "Landroidx/activity/BackEventCompat;", "onBackProgressed", "onBackCompleted", "onBackCancelled", "value", "", "isBackEnabled", "()Z", "setBackEnabled", "(Z)V", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getOnBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "navigationEventHandler", "Landroidx/navigationevent/NavigationEventHandler;", "getNavigationEventHandler", "()Landroidx/navigationevent/NavigationEventHandler;", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class BackHandlerCompat {
    public static final int $stable = 8;
    private final NavigationEventInfo info;
    private final NavigationEventHandler navigationEventHandler;
    private final OnBackPressedCallback onBackPressedCallback;

    static {
    }

    public BackHandlerCompat(NavigationEventInfo arg2) {
        super();
        this.info = arg2;
        this.onBackPressedCallback = new BackHandlerCompat$onBackPressedCallback$1(this);
        this.navigationEventHandler = new BackHandlerCompat$navigationEventHandler$1(this, arg2);
    }

    public final NavigationEventInfo getInfo() {
        return this.info;
    }

    public final NavigationEventHandler getNavigationEventHandler() {
        return this.navigationEventHandler;
    }

    public final OnBackPressedCallback getOnBackPressedCallback() {
        return this.onBackPressedCallback;
    }

    public boolean isBackEnabled() {
        if((this.onBackPressedCallback.isEnabled()) && (this.navigationEventHandler.isBackEnabled())) {
            return 1;
        }

        return 0;
    }

    public void onBackCancelled() {
    }

    public abstract void onBackCompleted();

    public void onBackProgressed(BackEventCompat arg1) {
    }

    public void onBackStarted(BackEventCompat arg1) {
    }

    public void setBackEnabled(boolean arg2) {
        this.onBackPressedCallback.setEnabled(arg2);
        this.navigationEventHandler.setBackEnabled(arg2);
    }
}

