package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \'2\u00020\u0001:\u0003%&\'B\u0013\b\u0007\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002J\u0016\u0010\u001D\u001A\u00020\u00112\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u0010#\u001A\u00020\u00182\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0010\u0010$\u001A\u00020\u00112\u0006\u0010\u001B\u001A\u00020\u001CH\u0003R \u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\"\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020 0\u001F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006("}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "Landroidx/window/layout/adapter/WindowBackend;", "windowExtension", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "<init>", "(Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;)V", "getWindowExtension", "()Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "setWindowExtension", "windowLayoutChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "getWindowLayoutChangeCallbacks$annotations", "()V", "getWindowLayoutChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "registerLayoutChangeCallback", "", "context", "Landroid/content/Context;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "isActivityRegistered", "", "activity", "Landroid/app/Activity;", "unregisterLayoutChangeCallback", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "getCurrentWindowLayoutInfo", "callbackRemovedForActivity", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SidecarWindowBackend implements WindowBackend {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u000EJ\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\r\u001A\u00020\u000EJ\u0012\u0010\u0011\u001A\u00020\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007J\b\u0010\u0014\u001A\u00020\u0015H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$Companion;", "", "<init>", "()V", "DEBUG", "", "globalInstance", "Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "initAndVerifyExtension", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "isSidecarVersionSupported", "sidecarVersion", "Landroidx/window/core/Version;", "resetInstance", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SidecarWindowBackend getInstance(Context arg2) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            if(SidecarWindowBackend.globalInstance == null) {
                ReentrantLock v1 = SidecarWindowBackend.globalLock;
                ((Lock)v1).lock();
                try {
                    if(SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(arg2));
                    }
                }
                catch(Throwable v2) {
                    ((Lock)v1).unlock();
                    throw v2;
                }

                ((Lock)v1).unlock();
            }

            SidecarWindowBackend v1_1 = SidecarWindowBackend.globalInstance;
            Intrinsics.checkNotNull(v1_1);
            return v1_1;
        }

        public final ExtensionInterfaceCompat initAndVerifyExtension(Context arg3) {
            SidecarCompat v2;
            Intrinsics.checkNotNullParameter(arg3, "context");
            ExtensionInterfaceCompat v0 = null;
            try {
                if(!this.isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion())) {
                    return v0;
                }

                v2 = new SidecarCompat(arg3);
                if(v2.validateExtensionInterface()) {
                    goto label_13;
                }
            }
            catch(Throwable ) {
                return v0;
            }

            return v0;
        label_13:
            return ((ExtensionInterfaceCompat)v2);
        }

        public final boolean isSidecarVersionSupported(Version arg2) {
            boolean v1 = false;
            if(arg2 == null) {
                return 0;
            }

            if(arg2.compareTo(Version.Companion.getVERSION_0_1()) >= 0) {
                v1 = true;
            }

            return v1;
        }

        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;)V", "onWindowLayoutChanged", "", "activity", "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtensionListenerImpl implements ExtensionCallbackInterface {
        public ExtensionListenerImpl(SidecarWindowBackend arg1) {
            SidecarWindowBackend.this = arg1;
            super();
        }

        public void onWindowLayoutChanged(Activity arg3, WindowLayoutInfo arg4) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            Intrinsics.checkNotNullParameter(arg4, "newLayout");
            Iterator v2 = SidecarWindowBackend.this.getWindowLayoutChangeCallbacks().iterator();
            Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
            while(v2.hasNext()) {
                Object v0 = v2.next();
                if(!Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper)v0).getActivity(), arg3)) {
                    continue;
                }

                ((WindowLayoutChangeCallbackWrapper)v0).accept(arg4);
            }
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Landroidx/core/util/Consumer;", "lastInfo", "getLastInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "(Landroidx/window/layout/WindowLayoutInfo;)V", "accept", "", "newLayoutInfo", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowLayoutChangeCallbackWrapper {
        private final Activity activity;
        private final Consumer callback;
        private final Executor executor;
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(Activity arg2, Executor arg3, Consumer arg4) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            Intrinsics.checkNotNullParameter(arg3, "executor");
            Intrinsics.checkNotNullParameter(arg4, "callback");
            super();
            this.activity = arg2;
            this.executor = arg3;
            this.callback = arg4;
        }

        public final void accept(WindowLayoutInfo arg3) {
            Intrinsics.checkNotNullParameter(arg3, "newLayoutInfo");
            this.lastInfo = arg3;
            this.executor.execute(new SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(this, arg3));
        }

        static final void accept$lambda$0(WindowLayoutChangeCallbackWrapper arg0, WindowLayoutInfo arg1) {
            arg0.callback.accept(arg1);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Consumer getCallback() {
            return this.callback;
        }

        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(WindowLayoutInfo arg1) {
            this.lastInfo = arg1;
        }
    }

    public static final Companion Companion = null;
    public static final boolean DEBUG = false;
    private static final String TAG = "WindowServer";
    private static volatile SidecarWindowBackend globalInstance;
    private static final ReentrantLock globalLock;
    private ExtensionInterfaceCompat windowExtension;
    private final CopyOnWriteArrayList windowLayoutChangeCallbacks;

    static {
        SidecarWindowBackend.Companion = new Companion(null);
        SidecarWindowBackend.globalLock = new ReentrantLock();
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat arg2) {
        super();
        this.windowExtension = arg2;
        this.windowLayoutChangeCallbacks = new CopyOnWriteArrayList();
        arg2 = this.windowExtension;
        if(arg2 != null) {
            arg2.setExtensionCallback(new ExtensionListenerImpl(this));
        }
    }

    public static final SidecarWindowBackend access$getGlobalInstance$cp() {
        return SidecarWindowBackend.globalInstance;
    }

    public static final ReentrantLock access$getGlobalLock$cp() {
        return SidecarWindowBackend.globalLock;
    }

    public static final void access$setGlobalInstance$cp(SidecarWindowBackend arg0) {
        SidecarWindowBackend.globalInstance = arg0;
    }

    private final void callbackRemovedForActivity(Activity arg3) {
        CopyOnWriteArrayList v0 = this.windowLayoutChangeCallbacks;
        if(!(v0 instanceof Collection) || !v0.isEmpty()) {
            Iterator v0_1 = ((Iterable)v0).iterator();
            do {
                if(v0_1.hasNext()) {
                    if(!Intrinsics.areEqual(v0_1.next().getActivity(), arg3)) {
                        continue;
                    }

                    return;
                }

                goto label_15;
            }
            while(true);

            return;
        }
        else {
        }

    label_15:
        ExtensionInterfaceCompat v2 = this.windowExtension;
        if(v2 != null) {
            v2.onWindowLayoutChangeListenerRemoved(arg3);
        }
    }

    public WindowLayoutInfo getCurrentWindowLayoutInfo(Context arg1) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        throw new UnsupportedOperationException("Must be called from extensions.");
    }

    public List getSupportedPostures() {
        throw new UnsupportedOperationException("Must be called from extensions.");
    }

    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    public final CopyOnWriteArrayList getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    public static void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity arg3) {
        CopyOnWriteArrayList v2 = this.windowLayoutChangeCallbacks;
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!Intrinsics.areEqual(v2_1.next().getActivity(), arg3));

        return 1;
    }

    public void registerLayoutChangeCallback(Context arg6, Executor arg7, Consumer arg8) {
        Object v7;
        ExtensionInterfaceCompat v2;
        Intrinsics.checkNotNullParameter(arg6, "context");
        Intrinsics.checkNotNullParameter(arg7, "executor");
        Intrinsics.checkNotNullParameter(arg8, "callback");
        WindowLayoutInfo v1 = null;
        if((arg6 instanceof Activity)) {
        }
        else {
            arg6 = ((Context)v1);
        }

        if(arg6 == null) {
            goto label_51;
        }

        ReentrantLock v0 = SidecarWindowBackend.globalLock;
        ((Lock)v0).lock();
        try {
            v2 = this.windowExtension;
            if(v2 != null) {
                goto label_22;
            }

            arg8.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
        }
        catch(Throwable v5) {
            goto label_49;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_22:
            boolean v3 = this.isActivityRegistered(((Activity)arg6));
            WindowLayoutChangeCallbackWrapper v4 = new WindowLayoutChangeCallbackWrapper(((Activity)arg6), arg7, arg8);
            this.windowLayoutChangeCallbacks.add(v4);
            if(!v3) {
                v2.onWindowLayoutChangeListenerAdded(((Activity)arg6));
            }
            else {
                Iterator v5_1 = this.windowLayoutChangeCallbacks.iterator();
                do {
                    if(v5_1.hasNext()) {
                        v7 = v5_1.next();
                        if(!Intrinsics.areEqual(arg6, v7.getActivity())) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_40;
                    }
                }
                while(true);

                goto label_41;
            label_40:
                v7 = v1;
            label_41:
                if(v7 != null) {
                    v1 = ((WindowLayoutChangeCallbackWrapper)v7).getLastInfo();
                }

                if(v1 == null) {
                    goto label_45;
                }

                v4.accept(v1);
            }

        label_45:
        }
        catch(Throwable v5) {
            goto label_49;
        }

        ((Lock)v0).unlock();
        return;
    label_49:
        ((Lock)v0).unlock();
        throw v5;
    label_51:
        arg8.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
    }

    public final void setWindowExtension(ExtensionInterfaceCompat arg1) {
        this.windowExtension = arg1;
    }

    public void unregisterLayoutChangeCallback(Consumer arg6) {
        Intrinsics.checkNotNullParameter(arg6, "callback");
        ReentrantLock v0 = SidecarWindowBackend.globalLock;
        __monitor_enter(v0);
        try {
            if(this.windowExtension != null) {
                goto label_8;
            }
        }
        catch(Throwable v5) {
            goto label_36;
        }

        __monitor_exit(v0);
        return;
        try {
        label_8:
            ArrayList v1 = new ArrayList();
            Iterator v2 = this.windowLayoutChangeCallbacks.iterator();
            Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
            while(v2.hasNext()) {
                Object v3 = v2.next();
                if(((WindowLayoutChangeCallbackWrapper)v3).getCallback() != arg6) {
                    continue;
                }

                Intrinsics.checkNotNull(v3);
                ((List)v1).add(v3);
            }

            this.windowLayoutChangeCallbacks.removeAll(v1);
            Iterator v6 = ((List)v1).iterator();
            while(v6.hasNext()) {
                this.callbackRemovedForActivity(v6.next().getActivity());
            }
        }
        catch(Throwable v5) {
            goto label_36;
        }

        __monitor_exit(v0);
        return;
    label_36:
        __monitor_exit(v0);
        throw v5;
    }
}

