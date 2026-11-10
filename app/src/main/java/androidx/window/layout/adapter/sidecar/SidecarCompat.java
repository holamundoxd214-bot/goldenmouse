package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface$SidecarCallback;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u0000 \'2\u00020\u0001:\u0004$%&\'B\u001B\b\u0007\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0010H\u0007J\u0010\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0010H\u0016J\u0016\u0010\u001D\u001A\u00020\u00172\u0006\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u0010J\u0010\u0010\u001F\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0010H\u0002J\u0010\u0010 \u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0010H\u0016J\u0010\u0010!\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0010H\u0002J\b\u0010\"\u001A\u00020#H\u0017R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u00038G¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarCompat;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/adapter/sidecar/SidecarAdapter;", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/adapter/sidecar/SidecarAdapter;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "", "Landroid/os/IBinder;", "Landroid/app/Activity;", "componentCallbackMap", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "extensionCallback", "Landroidx/window/layout/adapter/sidecar/SidecarCompat$DistinctElementCallback;", "setExtensionCallback", "", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "onWindowLayoutChangeListenerAdded", "register", "windowToken", "registerConfigurationChangeListener", "onWindowLayoutChangeListenerRemoved", "unregisterComponentCallback", "validateExtensionInterface", "", "FirstAttachAdapter", "TranslatingCallback", "DistinctElementCallback", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SidecarCompat implements ExtensionInterfaceCompat {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\u000EJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0014"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarCompat$Companion;", "", "<init>", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", "context", "Landroid/content/Context;", "getSidecarCompat$window_release", "getActivityWindowToken", "Landroid/os/IBinder;", "activity", "Landroid/app/Activity;", "getActivityWindowToken$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final IBinder getActivityWindowToken$window_release(Activity arg1) {
            if(arg1 != null) {
                Window v0 = arg1.getWindow();
                if(v0 != null) {
                    WindowManager$LayoutParams v0_1 = v0.getAttributes();
                    if(v0_1 != null) {
                        return v0_1.token;
                    }
                }
            }

            return null;
        }

        public final SidecarInterface getSidecarCompat$window_release(Context arg1) {
            Intrinsics.checkNotNullParameter(arg1, "context");
            return SidecarProvider.getSidecarImpl(arg1.getApplicationContext());
        }

        public final Version getSidecarVersion() {
            Version v2 = null;
            try {
                String v0 = SidecarProvider.getApiVersion();
                if(!TextUtils.isEmpty(v0)) {
                    v2 = Version.Companion.parse(v0);
                }

                return v2;
            }
            catch(UnsupportedOperationException ) {
                return v2;
            }
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\nH\u0016J\u000E\u0010\u000F\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\tR\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "<init>", "(Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "onWindowLayoutChanged", "", "activity", "newLayout", "clearWindowLayoutInfo", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class DistinctElementCallback implements ExtensionCallbackInterface {
        private final WeakHashMap activityWindowLayoutInfo;
        private final ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock globalLock;

        public DistinctElementCallback(ExtensionCallbackInterface arg2) {
            Intrinsics.checkNotNullParameter(arg2, "callbackInterface");
            super();
            this.callbackInterface = arg2;
            this.globalLock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap();
        }

        public final void clearWindowLayoutInfo(Activity arg3) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            ReentrantLock v0 = this.globalLock;
            ((Lock)v0).lock();
            try {
                this.activityWindowLayoutInfo.put(arg3, null);
            }
            catch(Throwable v2) {
                ((Lock)v0).unlock();
                throw v2;
            }

            ((Lock)v0).unlock();
        }

        public void onWindowLayoutChanged(Activity arg3, WindowLayoutInfo arg4) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            Intrinsics.checkNotNullParameter(arg4, "newLayout");
            ReentrantLock v0 = this.globalLock;
            ((Lock)v0).lock();
            try {
                if(!Intrinsics.areEqual(arg4, this.activityWindowLayoutInfo.get(arg3))) {
                    goto label_12;
                }
            }
            catch(Throwable v2) {
                goto label_19;
            }

            ((Lock)v0).unlock();
            return;
            try {
            label_12:
                this.activityWindowLayoutInfo.put(arg3, arg4);
                ((Lock)v0).unlock();
            }
            catch(Throwable v2) {
            label_19:
                ((Lock)v0).unlock();
                throw v2;
            }

            this.callbackInterface.onWindowLayoutChanged(arg3, arg4);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0010\u0010\u000F\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "sidecarCompat", "Landroidx/window/layout/adapter/sidecar/SidecarCompat;", "activity", "Landroid/app/Activity;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarCompat;Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class FirstAttachAdapter implements View$OnAttachStateChangeListener {
        private final WeakReference activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat arg2, Activity arg3) {
            Intrinsics.checkNotNullParameter(arg2, "sidecarCompat");
            Intrinsics.checkNotNullParameter(arg3, "activity");
            super();
            this.sidecarCompat = arg2;
            this.activityWeakReference = new WeakReference(arg3);
        }

        public void onViewAttachedToWindow(View arg2) {
            Intrinsics.checkNotNullParameter(arg2, "view");
            arg2.removeOnAttachStateChangeListener(this);
            Object v2 = this.activityWeakReference.get();
            IBinder v0 = SidecarCompat.Companion.getActivityWindowToken$window_release(((Activity)v2));
            if(v2 == null) {
            }
            else {
                if(v0 == null) {
                    return;
                }

                goto label_12;
            }

            return;
        label_12:
            this.sidecarCompat.register(v0, ((Activity)v2));
        }

        public void onViewDetachedFromWindow(View arg1) {
            Intrinsics.checkNotNullParameter(arg1, "view");
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016¨\u0006\r"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TranslatingCallback implements SidecarInterface$SidecarCallback {
        public TranslatingCallback(SidecarCompat arg1) {
            SidecarCompat.this = arg1;
            super();
        }

        public void onDeviceStateChanged(SidecarDeviceState arg6) {
            Intrinsics.checkNotNullParameter(arg6, "newDeviceState");
            Collection v0 = SidecarCompat.this.windowListenerRegisteredContexts.values();
            SidecarCompat v5 = SidecarCompat.this;
            Iterator v0_1 = ((Iterable)v0).iterator();
            while(v0_1.hasNext()) {
                Object v1 = v0_1.next();
                IBinder v2 = SidecarCompat.Companion.getActivityWindowToken$window_release(((Activity)v1));
                SidecarWindowLayoutInfo v3 = null;
                if(v2 != null) {
                    SidecarInterface v4 = v5.getSidecar();
                    if(v4 != null) {
                        v3 = v4.getWindowLayoutInfo(v2);
                    }
                }

                DistinctElementCallback v2_1 = v5.extensionCallback;
                if(v2_1 == null) {
                    continue;
                }

                v2_1.onWindowLayoutChanged(((Activity)v1), v5.sidecarAdapter.translate(v3, arg6));
            }
        }

        public void onWindowLayoutChanged(IBinder arg3, SidecarWindowLayoutInfo arg4) {
            SidecarDeviceState v1_1;
            Intrinsics.checkNotNullParameter(arg3, "windowToken");
            Intrinsics.checkNotNullParameter(arg4, "newLayout");
            Object v3 = SidecarCompat.this.windowListenerRegisteredContexts.get(arg3);
            if(v3 == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }

            SidecarAdapter v0 = SidecarCompat.this.sidecarAdapter;
            SidecarInterface v1 = SidecarCompat.this.getSidecar();
            if(v1 != null) {
                v1_1 = v1.getDeviceState();
                if(v1_1 == null) {
                    goto label_19;
                }
            }
            else {
            label_19:
                v1_1 = new SidecarDeviceState();
            }

            WindowLayoutInfo v4 = v0.translate(arg4, v1_1);
            DistinctElementCallback v2 = SidecarCompat.this.extensionCallback;
            if(v2 != null) {
                v2.onWindowLayoutChanged(((Activity)v3), v4);
            }
        }
    }

    public static final Companion Companion = null;
    private static final String TAG = "SidecarCompat";
    private final Map componentCallbackMap;
    private DistinctElementCallback extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map windowListenerRegisteredContexts;

    static {
        SidecarCompat.Companion = new Companion(null);
    }

    public SidecarCompat(Context arg4) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        this(SidecarCompat.Companion.getSidecarCompat$window_release(arg4), new SidecarAdapter(null, 1, null));
    }

    public SidecarCompat(SidecarInterface arg2, SidecarAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg3, "sidecarAdapter");
        super();
        this.sidecar = arg2;
        this.sidecarAdapter = arg3;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    public static final DistinctElementCallback access$getExtensionCallback$p(SidecarCompat arg0) {
        return arg0.extensionCallback;
    }

    public static final SidecarAdapter access$getSidecarAdapter$p(SidecarCompat arg0) {
        return arg0.sidecarAdapter;
    }

    public static final Map access$getWindowListenerRegisteredContexts$p(SidecarCompat arg0) {
        return arg0.windowListenerRegisteredContexts;
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity arg2) {
        SidecarDeviceState v1_1;
        Intrinsics.checkNotNullParameter(arg2, "activity");
        IBinder v2 = SidecarCompat.Companion.getActivityWindowToken$window_release(arg2);
        if(v2 == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }

        SidecarInterface v0 = this.sidecar;
        SidecarWindowLayoutInfo v2_1 = v0 != null ? v0.getWindowLayoutInfo(v2) : null;
        SidecarAdapter v0_1 = this.sidecarAdapter;
        SidecarInterface v1 = this.sidecar;
        if(v1 != null) {
            v1_1 = v1.getDeviceState();
            if(v1_1 == null) {
                goto label_19;
            }
        }
        else {
        label_19:
            v1_1 = new SidecarDeviceState();
        }

        return v0_1.translate(v2_1, v1_1);
    }

    public void onWindowLayoutChangeListenerAdded(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        IBinder v0 = SidecarCompat.Companion.getActivityWindowToken$window_release(arg2);
        if(v0 != null) {
            this.register(v0, arg2);
            return;
        }

        arg2.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, arg2));
    }

    public void onWindowLayoutChangeListenerRemoved(Activity arg4) {
        Intrinsics.checkNotNullParameter(arg4, "activity");
        IBinder v0 = SidecarCompat.Companion.getActivityWindowToken$window_release(arg4);
        if(v0 == null) {
        }
        else {
            SidecarInterface v1 = this.sidecar;
            if(v1 != null) {
                v1.onWindowLayoutChangeListenerRemoved(v0);
            }

            this.unregisterComponentCallback(arg4);
            DistinctElementCallback v1_1 = this.extensionCallback;
            if(v1_1 != null) {
                v1_1.clearWindowLayoutInfo(arg4);
            }

            int v4 = this.windowListenerRegisteredContexts.size() == 1 ? 1 : 0;
            this.windowListenerRegisteredContexts.remove(v0);
            if(v4 == 0) {
                return;
            }

            SidecarInterface v3 = this.sidecar;
            if(v3 == null) {
                return;
            }

            v3.onDeviceStateListenersChanged(true);
        }
    }

    public final void register(IBinder arg2, Activity arg3) {
        Intrinsics.checkNotNullParameter(arg2, "windowToken");
        Intrinsics.checkNotNullParameter(arg3, "activity");
        this.windowListenerRegisteredContexts.put(arg2, arg3);
        SidecarInterface v0 = this.sidecar;
        if(v0 != null) {
            v0.onWindowLayoutChangeListenerAdded(arg2);
        }

        if(this.windowListenerRegisteredContexts.size() == 1) {
            SidecarInterface v2 = this.sidecar;
            if(v2 != null) {
                v2.onDeviceStateListenersChanged(false);
            }
        }

        DistinctElementCallback v2_1 = this.extensionCallback;
        if(v2_1 != null) {
            v2_1.onWindowLayoutChanged(arg3, this.getWindowLayoutInfo(arg3));
        }

        this.registerConfigurationChangeListener(arg3);
    }

    private final void registerConfigurationChangeListener(Activity arg2) {
        if(this.componentCallbackMap.get(arg2) == null && ((arg2 instanceof OnConfigurationChangedProvider))) {
            SidecarCompat$$ExternalSyntheticLambda0 v0 = new SidecarCompat$$ExternalSyntheticLambda0(this, arg2);
            this.componentCallbackMap.put(arg2, v0);
            ((OnConfigurationChangedProvider)arg2).addOnConfigurationChangedListener(((Consumer)v0));
        }
    }

    static final void registerConfigurationChangeListener$lambda$0(SidecarCompat arg0, Activity arg1, Configuration arg2) {
        DistinctElementCallback v2 = arg0.extensionCallback;
        if(v2 != null) {
            v2.onWindowLayoutChanged(arg1, arg0.getWindowLayoutInfo(arg1));
        }
    }

    public void setExtensionCallback(ExtensionCallbackInterface arg4) {
        Intrinsics.checkNotNullParameter(arg4, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(arg4);
        SidecarInterface v4 = this.sidecar;
        if(v4 != null) {
            v4.setSidecarCallback(new DistinctElementSidecarCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        }
    }

    private final void unregisterComponentCallback(Activity arg3) {
        Object v0 = this.componentCallbackMap.get(arg3);
        if(v0 == null) {
            return;
        }

        if((arg3 instanceof OnConfigurationChangedProvider)) {
            arg3.removeOnConfigurationChangedListener(((Consumer)v0));
        }

        this.componentCallbackMap.remove(arg3);
    }

    public boolean validateExtensionInterface() {
        List v11_6;
        Object v11_4;
        Class v6_1;
        Method v11_2;
        Object v2_4;
        Method v2_3;
        Class v2_2;
        Method v3_3;
        Class v3_2;
        Object v5_3;
        Method v5_2;
        Class v5_1;
        String v0 = "Illegal return type for \'onWindowLayoutChangeListenerRemoved\': ";
        String v1 = "Illegal return type for \'onWindowLayoutChangeListenerAdded\': ";
        String v2 = "Illegal return type for \'getWindowLayoutInfo\': ";
        String v3 = "Illegal return type for \'setSidecarCallback\': ";
        boolean v4 = false;
        try {
            SidecarInterface v5 = this.sidecar;
            Object v6 = null;
            if(v5 != null) {
                v5_1 = v5.getClass();
                if(v5_1 != null) {
                    v5_2 = v5_1.getMethod("setSidecarCallback", SidecarInterface$SidecarCallback.class);
                }
                else {
                    goto label_17;
                }
            }
            else {
            label_17:
                v5_2 = ((Method)v6);
            }

            if(v5_2 != null) {
                v5_1 = v5_2.getReturnType();
            }
            else {
                v5_3 = v6;
            }

            if(!Intrinsics.areEqual(v5_3, Void.TYPE)) {
                goto label_171;
            }

            SidecarInterface v3_1 = this.sidecar;
            if(v3_1 != null) {
                v3_1.getDeviceState();
            }

            v3_1 = this.sidecar;
            if(v3_1 != null) {
                v3_1.onDeviceStateListenersChanged(true);
            }

            v3_1 = this.sidecar;
            if(v3_1 != null) {
                v3_2 = v3_1.getClass();
                if(v3_2 != null) {
                    v3_3 = v3_2.getMethod("getWindowLayoutInfo", IBinder.class);
                }
                else {
                    goto label_41;
                }
            }
            else {
            label_41:
                v3_3 = ((Method)v6);
            }

            if(v3_3 != null) {
                v3_2 = v3_3.getReturnType();
            }
            else {
                Object v3_4 = v6;
            }

            if(!Intrinsics.areEqual(v3_2, SidecarWindowLayoutInfo.class)) {
                goto label_164;
            }

            SidecarInterface v2_1 = this.sidecar;
            if(v2_1 != null) {
                v2_2 = v2_1.getClass();
                if(v2_2 != null) {
                    v2_3 = v2_2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
                }
                else {
                    goto label_59;
                }
            }
            else {
            label_59:
                v2_3 = ((Method)v6);
            }

            if(v2_3 != null) {
                v2_2 = v2_3.getReturnType();
            }
            else {
                v2_4 = v6;
            }

            if(!Intrinsics.areEqual(v2_4, Void.TYPE)) {
                goto label_157;
            }

            SidecarInterface v11 = this.sidecar;
            if(v11 != null) {
                Class v11_1 = v11.getClass();
                if(v11_1 != null) {
                    v11_2 = v11_1.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
                }
                else {
                    goto label_77;
                }
            }
            else {
            label_77:
                v11_2 = ((Method)v6);
            }

            if(v11_2 != null) {
                v6_1 = v11_2.getReturnType();
            }

            if(!Intrinsics.areEqual(v6_1, Void.TYPE)) {
                goto label_150;
            }

            SidecarDeviceState v11_3 = new SidecarDeviceState();
            int v0_1 = 3;
            try {
                v11_3.posture = v0_1;
            }
            catch(NoSuchFieldError ) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(v11_3, Integer.valueOf(v0_1));
                v11_4 = SidecarDeviceState.class.getMethod("getPosture").invoke(v11_3);
                Intrinsics.checkNotNull(v11_4, "null cannot be cast to non-null type kotlin.Int");
                if(((Integer)v11_4).intValue() == v0_1) {
                    goto label_107;
                }

                throw new Exception("Invalid device posture getter/setter");
            }

        label_107:
            SidecarDisplayFeature v11_5 = new SidecarDisplayFeature();
            Rect v0_2 = v11_5.getRect();
            Intrinsics.checkNotNullExpressionValue(v0_2, "getRect(...)");
            v11_5.setRect(v0_2);
            v11_5.getType();
            v11_5.setType(1);
            SidecarWindowLayoutInfo v0_3 = new SidecarWindowLayoutInfo();
            try {
                v11_6 = v0_3.displayFeatures;
            }
            catch(NoSuchFieldError ) {
                ArrayList v1_1 = new ArrayList();
                ((List)v1_1).add(v11_6);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(v0_3, v1_1);
                v11_4 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures").invoke(v0_3);
                Intrinsics.checkNotNull(v11_4, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if(!Intrinsics.areEqual(v1_1, v11_4)) {
                    goto label_142;
                }
            }

            return true;
        label_142:
            throw new Exception("Invalid display feature getter/setter");
        label_150:
            throw new NoSuchMethodException(v0 + v6_1);
        label_157:
            throw new NoSuchMethodException(v1 + v2_4);
        label_164:
            throw new NoSuchMethodException(v2 + v3_2);
        label_171:
            throw new NoSuchMethodException(v3 + v5_3);
        }
        catch(Throwable ) {
            return v4;
        }
    }
}

