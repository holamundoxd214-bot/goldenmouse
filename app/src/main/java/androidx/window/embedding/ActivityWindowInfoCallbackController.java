package androidx.window.embedding;

import android.app.Activity;
import android.graphics.Rect;
import android.util.ArrayMap;
import androidx.core.util.Consumer;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0011\u0018\u00002\u00020\u0001:\u0001\u001FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\rJ\u0014\u0010\u001B\u001A\u00020\u00172\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\rJ\u0015\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\nH\u0011¢\u0006\u0002\b\u001ER\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R:\u0010\u000B\u001A\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r\u0012\b\u0012\u00060\u000FR\u00020\u00000\f8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2={"Landroidx/window/embedding/ActivityWindowInfoCallbackController;", "", "embeddingExtension", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;)V", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "extensionsCallback", "Landroidx/window/extensions/core/util/function/Consumer;", "Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;", "callbacks", "", "Landroidx/core/util/Consumer;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "Landroidx/window/embedding/ActivityWindowInfoCallbackController$CallbackWrapper;", "getCallbacks$window_release$annotations", "()V", "getCallbacks$window_release", "()Ljava/util/Map;", "setCallbacks$window_release", "(Ljava/util/Map;)V", "addCallback", "", "activity", "Landroid/app/Activity;", "callback", "removeCallback", "translate", "info", "translate$window_release", "CallbackWrapper", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class ActivityWindowInfoCallbackController {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0081\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0006H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0017"}, d2={"Landroidx/window/embedding/ActivityWindowInfoCallbackController$CallbackWrapper;", "", "activity", "Landroid/app/Activity;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "<init>", "(Landroidx/window/embedding/ActivityWindowInfoCallbackController;Landroid/app/Activity;Landroidx/core/util/Consumer;)V", "getCallback", "()Landroidx/core/util/Consumer;", "lastReportedInfo", "getLastReportedInfo", "()Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "setLastReportedInfo", "(Landroidx/window/embedding/EmbeddedActivityWindowInfo;)V", "accept", "", "extensionsActivityWindowInfo", "Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;", "shouldReportInfo", "", "newInfo", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CallbackWrapper {
        private final Activity activity;
        private final Consumer callback;
        private EmbeddedActivityWindowInfo lastReportedInfo;

        public CallbackWrapper(ActivityWindowInfoCallbackController arg2, Activity arg3, Consumer arg4) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            Intrinsics.checkNotNullParameter(arg4, "callback");
            ActivityWindowInfoCallbackController.this = arg2;
            super();
            this.activity = arg3;
            this.callback = arg4;
        }

        public final void accept(androidx.window.extensions.embedding.EmbeddedActivityWindowInfo arg3) {
            Intrinsics.checkNotNullParameter(arg3, "extensionsActivityWindowInfo");
            Activity v0 = arg3.getActivity();
            Intrinsics.checkNotNullExpressionValue(v0, "getActivity(...)");
            if(!Intrinsics.areEqual(this.activity, v0)) {
            }
            else {
                EmbeddedActivityWindowInfo v3 = ActivityWindowInfoCallbackController.this.translate$window_release(arg3);
                if(this.shouldReportInfo(v3)) {
                    this.lastReportedInfo = v3;
                    this.callback.accept(v3);
                }
            }
        }

        public final Consumer getCallback() {
            return this.callback;
        }

        public final EmbeddedActivityWindowInfo getLastReportedInfo() {
            return this.lastReportedInfo;
        }

        public final void setLastReportedInfo(EmbeddedActivityWindowInfo arg1) {
            this.lastReportedInfo = arg1;
        }

        private final boolean shouldReportInfo(EmbeddedActivityWindowInfo arg4) {
            EmbeddedActivityWindowInfo v3 = this.lastReportedInfo;
            if(v3 != null) {
                if(v3.isEmbedded() != arg4.isEmbedded()) {
                    return 1;
                }

                if(!arg4.isEmbedded()) {
                    return 0;
                }

                return Intrinsics.areEqual(v3, arg4) ^ 1;
            }

            return arg4.isEmbedded();
        }
    }

    private Map callbacks;
    private final ActivityEmbeddingComponent embeddingExtension;
    private final androidx.window.extensions.core.util.function.Consumer extensionsCallback;
    private final ReentrantLock globalLock;

    public ActivityWindowInfoCallbackController(ActivityEmbeddingComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingExtension");
        super();
        this.embeddingExtension = arg2;
        this.globalLock = new ReentrantLock();
        this.callbacks = new ArrayMap();
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        this.extensionsCallback = new ActivityWindowInfoCallbackController$$ExternalSyntheticLambda0(this);
    }

    static final void _init_$lambda$1(ActivityWindowInfoCallbackController arg2, androidx.window.extensions.embedding.EmbeddedActivityWindowInfo arg3) {
        Intrinsics.checkNotNullParameter(arg3, "info");
        ReentrantLock v0 = arg2.globalLock;
        ((Lock)v0).lock();
        try {
            Iterator v2_1 = arg2.callbacks.values().iterator();
            while(v2_1.hasNext()) {
                v2_1.next().accept(arg3);
            }
        }
        catch(Throwable v2) {
            goto label_16;
        }

        ((Lock)v0).unlock();
        return;
    label_16:
        ((Lock)v0).unlock();
        throw v2;
    }

    public final void addCallback(Activity arg5, Consumer arg6) {
        Intrinsics.checkNotNullParameter(arg5, "activity");
        Intrinsics.checkNotNullParameter(arg6, "callback");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            if(this.callbacks.isEmpty()) {
                this.embeddingExtension.setEmbeddedActivityWindowInfoCallback(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), this.extensionsCallback);
            }

            CallbackWrapper v1 = new CallbackWrapper(this, arg5, arg6);
            this.callbacks.put(arg6, v1);
            androidx.window.extensions.embedding.EmbeddedActivityWindowInfo v4_1 = this.embeddingExtension.getEmbeddedActivityWindowInfo(arg5);
            if(v4_1 != null) {
                v1.accept(v4_1);
            }
        }
        catch(Throwable v4) {
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
    }

    public final Map getCallbacks$window_release() {
        return this.callbacks;
    }

    public static void getCallbacks$window_release$annotations() {
    }

    public final void removeCallback(Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg3, "callback");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            if(this.callbacks.remove(arg3) != null) {
                goto label_9;
            }
        }
        catch(Throwable v2) {
            goto label_18;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_9:
            if(this.callbacks.isEmpty()) {
                this.embeddingExtension.clearEmbeddedActivityWindowInfoCallback();
            }
        }
        catch(Throwable v2) {
        label_18:
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public final void setCallbacks$window_release(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.callbacks = arg2;
    }

    public EmbeddedActivityWindowInfo translate$window_release(androidx.window.extensions.embedding.EmbeddedActivityWindowInfo arg4) {
        Intrinsics.checkNotNullParameter(arg4, "info");
        Rect v3 = new Rect(arg4.getTaskBounds());
        Rect v0 = new Rect(arg4.getActivityStackBounds());
        v0.offset(-v3.left, -v3.top);
        return new EmbeddedActivityWindowInfo(arg4.isEmbedded(), v3, v0);
    }
}

