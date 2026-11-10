package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.window.area.adapter.WindowAreaAdapter;
import androidx.window.core.BuildConfig;
import androidx.window.core.ExtensionsUtil;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.reflection.Consumer2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 62\u00020\u0001:\u0003456B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\bH\u0002J\u0010\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001EH\u0002J \u0010\u001F\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020!2\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\"\u001A\u00020#H\u0002J\u0010\u0010$\u001A\u00020\r2\u0006\u0010%\u001A\u00020\u0012H\u0002J(\u0010&\u001A\u00020\u001A2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.H\u0016J(\u0010/\u001A\u00020\u001A2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u00100\u001A\u000201H\u0016J \u00102\u001A\u00020\u001A2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.H\u0002J \u00103\u001A\u00020\u001A2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u00100\u001A\u000201H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R*\u0010\u000F\u001A\u001E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u00067"}, d2={"Landroidx/window/area/WindowAreaControllerImpl;", "Landroidx/window/area/WindowAreaController;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;)V", "rearDisplaySessionConsumer", "Landroidx/window/reflection/Consumer2;", "", "currentRearDisplayModeStatus", "Landroidx/window/area/WindowAreaCapability$Status;", "currentRearDisplayPresentationStatus", "activeWindowAreaSession", "", "presentationSessionActive", "currentWindowAreaInfoMap", "Ljava/util/HashMap;", "", "Landroidx/window/area/WindowAreaInfo;", "Lkotlin/collections/HashMap;", "windowAreaInfos", "Lkotlinx/coroutines/flow/Flow;", "", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "updateRearDisplayAvailability", "", "status", "updateRearDisplayPresentationAvailability", "extensionWindowAreaStatus", "Landroidx/window/extensions/area/ExtensionWindowAreaStatus;", "updateRearDisplayWindowArea", "operation", "Landroidx/window/area/WindowAreaCapability$Operation;", "metrics", "Landroidx/window/layout/WindowMetrics;", "shouldRemoveWindowAreaInfo", "windowAreaInfo", "transferActivityToWindowArea", "token", "Landroid/os/Binder;", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "windowAreaSessionCallback", "Landroidx/window/area/WindowAreaSessionCallback;", "presentContentOnWindowArea", "windowAreaPresentationSessionCallback", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "startRearDisplayMode", "startRearDisplayPresentationMode", "RearDisplaySessionConsumer", "RearDisplayPresentationSessionConsumer", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaControllerImpl extends WindowAreaController {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/window/area/WindowAreaControllerImpl$Companion;", "", "<init>", "()V", "TAG", "", "REAR_DISPLAY_BINDER_DESCRIPTOR", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0002X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/window/area/WindowAreaControllerImpl$RearDisplayPresentationSessionConsumer;", "Landroidx/window/reflection/Consumer2;", "", "executor", "Ljava/util/concurrent/Executor;", "windowAreaPresentationSessionCallback", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "<init>", "(Landroidx/window/area/WindowAreaControllerImpl;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;Landroidx/window/extensions/area/WindowAreaComponent;)V", "lastReportedSessionStatus", "accept", "", "value", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RearDisplayPresentationSessionConsumer implements Consumer2 {
        private final Executor executor;
        private int lastReportedSessionStatus;
        private final WindowAreaComponent windowAreaComponent;
        private final WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback;

        public RearDisplayPresentationSessionConsumer(WindowAreaControllerImpl arg2, Executor arg3, WindowAreaPresentationSessionCallback arg4, WindowAreaComponent arg5) {
            Intrinsics.checkNotNullParameter(arg3, "executor");
            Intrinsics.checkNotNullParameter(arg4, "windowAreaPresentationSessionCallback");
            Intrinsics.checkNotNullParameter(arg5, "windowAreaComponent");
            WindowAreaControllerImpl.this = arg2;
            super();
            this.executor = arg3;
            this.windowAreaPresentationSessionCallback = arg4;
            this.windowAreaComponent = arg5;
        }

        public void accept(int arg5) {
            int v0 = this.lastReportedSessionStatus;
            this.lastReportedSessionStatus = arg5;
            this.executor.execute(new WindowAreaControllerImpl$RearDisplayPresentationSessionConsumer$$ExternalSyntheticLambda0(arg5, v0, this, WindowAreaControllerImpl.this));
        }

        public void accept(Object arg1) {
            this.accept(((Number)arg1).intValue());
        }

        static final void accept$lambda$0(int arg2, int arg3, RearDisplayPresentationSessionConsumer arg4, WindowAreaControllerImpl arg5) {
            if(arg2 != 0) {
                int v5 = 2;
                if(arg2 != 1) {
                    if(arg2 != v5) {
                        Log.e(WindowAreaControllerImpl.TAG, "Invalid session state value received: " + arg2);
                        return;
                    }

                    arg4.windowAreaPresentationSessionCallback.onContainerVisibilityChanged(true);
                    return;
                }

                if(arg3 == v5) {
                    arg4.windowAreaPresentationSessionCallback.onContainerVisibilityChanged(false);
                    return;
                }

                WindowAreaPresentationSessionCallback v2 = arg4.windowAreaPresentationSessionCallback;
                WindowAreaComponent v4 = arg4.windowAreaComponent;
                ExtensionWindowAreaPresentation v5_1 = v4.getRearDisplayPresentation();
                Intrinsics.checkNotNull(v5_1);
                v2.onSessionStarted(new RearDisplayPresentationSessionPresenterImpl(v4, v5_1, ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()));
                return;
            }

            arg5.presentationSessionActive = false;
            arg4.windowAreaPresentationSessionCallback.onSessionEnded(null);
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\b\u0010\u0010\u001A\u00020\u000EH\u0002J\b\u0010\u0011\u001A\u00020\u000EH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/window/area/WindowAreaControllerImpl$RearDisplaySessionConsumer;", "Landroidx/window/reflection/Consumer2;", "", "executor", "Ljava/util/concurrent/Executor;", "appCallback", "Landroidx/window/area/WindowAreaSessionCallback;", "extensionsComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "<init>", "(Landroidx/window/area/WindowAreaControllerImpl;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;Landroidx/window/extensions/area/WindowAreaComponent;)V", "session", "Landroidx/window/area/WindowAreaSession;", "accept", "", "value", "onSessionStarted", "onSessionFinished", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RearDisplaySessionConsumer implements Consumer2 {
        private final WindowAreaSessionCallback appCallback;
        private final Executor executor;
        private final WindowAreaComponent extensionsComponent;
        private WindowAreaSession session;

        public RearDisplaySessionConsumer(WindowAreaControllerImpl arg2, Executor arg3, WindowAreaSessionCallback arg4, WindowAreaComponent arg5) {
            Intrinsics.checkNotNullParameter(arg3, "executor");
            Intrinsics.checkNotNullParameter(arg4, "appCallback");
            Intrinsics.checkNotNullParameter(arg5, "extensionsComponent");
            WindowAreaControllerImpl.this = arg2;
            super();
            this.executor = arg3;
            this.appCallback = arg4;
            this.extensionsComponent = arg5;
        }

        public void accept(int arg4) {
            if(arg4 != 0) {
                if(arg4 != 1) {
                    if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.STRICT) {
                        Log.d(WindowAreaControllerImpl.TAG, "Received an unknown session status value: " + arg4);
                    }

                    this.onSessionFinished();
                    return;
                }

                this.onSessionStarted();
                return;
            }

            this.onSessionFinished();
        }

        public void accept(Object arg1) {
            this.accept(((Number)arg1).intValue());
        }

        private final void onSessionFinished() {
            WindowAreaControllerImpl.this.activeWindowAreaSession = false;
            this.session = null;
            this.executor.execute(new WindowAreaControllerImpl$RearDisplaySessionConsumer$$ExternalSyntheticLambda1(this));
        }

        static final void onSessionFinished$lambda$2(RearDisplaySessionConsumer arg1) {
            arg1.appCallback.onSessionEnded(null);
        }

        private final void onSessionStarted() {
            RearDisplaySessionImpl v0 = new RearDisplaySessionImpl(this.extensionsComponent);
            this.session = ((WindowAreaSession)v0);
            this.executor.execute(new WindowAreaControllerImpl$RearDisplaySessionConsumer$$ExternalSyntheticLambda0(this, ((WindowAreaSession)v0)));
        }

        static final void onSessionStarted$lambda$1$lambda$0(RearDisplaySessionConsumer arg0, WindowAreaSession arg1) {
            arg0.appCallback.onSessionStarted(arg1);
        }
    }

    public static final Companion Companion = null;
    private static final String REAR_DISPLAY_BINDER_DESCRIPTOR = "WINDOW_AREA_REAR_DISPLAY";
    private static final String TAG;
    private boolean activeWindowAreaSession;
    private Status currentRearDisplayModeStatus;
    private Status currentRearDisplayPresentationStatus;
    private final HashMap currentWindowAreaInfoMap;
    private boolean presentationSessionActive;
    private Consumer2 rearDisplaySessionConsumer;
    private final WindowAreaComponent windowAreaComponent;

    static {
        WindowAreaControllerImpl.Companion = new Companion(null);
        WindowAreaControllerImpl.TAG = Reflection.getOrCreateKotlinClass(WindowAreaControllerImpl.class).getSimpleName();
    }

    public WindowAreaControllerImpl(WindowAreaComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "windowAreaComponent");
        super();
        this.windowAreaComponent = arg2;
        this.currentRearDisplayModeStatus = Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release();
        this.currentRearDisplayPresentationStatus = Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release();
        this.currentWindowAreaInfoMap = new HashMap();
    }

    public static final HashMap access$getCurrentWindowAreaInfoMap$p(WindowAreaControllerImpl arg0) {
        return arg0.currentWindowAreaInfoMap;
    }

    public static final String access$getTAG$cp() {
        return WindowAreaControllerImpl.TAG;
    }

    public static final WindowAreaComponent access$getWindowAreaComponent$p(WindowAreaControllerImpl arg0) {
        return arg0.windowAreaComponent;
    }

    public static final void access$setActiveWindowAreaSession$p(WindowAreaControllerImpl arg0, boolean arg1) {
        arg0.activeWindowAreaSession = arg1;
    }

    public static final void access$setPresentationSessionActive$p(WindowAreaControllerImpl arg0, boolean arg1) {
        arg0.presentationSessionActive = arg1;
    }

    public static final void access$updateRearDisplayAvailability(WindowAreaControllerImpl arg0, int arg1) {
        arg0.updateRearDisplayAvailability(arg1);
    }

    public static final void access$updateRearDisplayPresentationAvailability(WindowAreaControllerImpl arg0, ExtensionWindowAreaStatus arg1) {
        arg0.updateRearDisplayPresentationAvailability(arg1);
    }

    public Flow getWindowAreaInfos() {
        return FlowKt.callbackFlow(new WindowAreaControllerImpl$windowAreaInfos$1(this, null));
    }

    public void presentContentOnWindowArea(Binder arg2, Activity arg3, Executor arg4, WindowAreaPresentationSessionCallback arg5) {
        Intrinsics.checkNotNullParameter(arg2, "token");
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Intrinsics.checkNotNullParameter(arg4, "executor");
        Intrinsics.checkNotNullParameter(arg5, "windowAreaPresentationSessionCallback");
        if(!Intrinsics.areEqual(arg2.getInterfaceDescriptor(), "WINDOW_AREA_REAR_DISPLAY")) {
            arg4.execute(new WindowAreaControllerImpl$$ExternalSyntheticLambda0(arg5));
            return;
        }

        this.startRearDisplayPresentationMode(arg3, arg4, arg5);
    }

    static final void presentContentOnWindowArea$lambda$2(WindowAreaPresentationSessionCallback arg2) {
        arg2.onSessionEnded(new IllegalArgumentException("Invalid WindowAreaInfo token"));
    }

    private final boolean shouldRemoveWindowAreaInfo(WindowAreaInfo arg2) {
        Iterator v1 = arg2.getCapabilityMap$window_release().values().iterator();
        do {
            if(!v1.hasNext()) {
                return 1;
            }

            Object v2 = v1.next();
            Intrinsics.checkNotNullExpressionValue(v2, "next(...)");
        }
        while(Intrinsics.areEqual(((WindowAreaCapability)v2).getStatus(), Status.WINDOW_AREA_STATUS_UNSUPPORTED));

        return 0;
    }

    private final void startRearDisplayMode(Activity arg3, Executor arg4, WindowAreaSessionCallback arg5) {
        if(Intrinsics.areEqual(this.currentRearDisplayModeStatus, Status.WINDOW_AREA_STATUS_ACTIVE)) {
            arg5.onSessionEnded(new IllegalStateException("The WindowArea feature is currently active, WindowAreaInfo#getActiveSessioncan be used to get an instance of the current active session"));
            return;
        }

        if(!Intrinsics.areEqual(this.currentRearDisplayModeStatus, Status.WINDOW_AREA_STATUS_AVAILABLE)) {
            arg5.onSessionEnded(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
            return;
        }

        this.activeWindowAreaSession = true;
        RearDisplaySessionConsumer v0 = new RearDisplaySessionConsumer(this, arg4, arg5, this.windowAreaComponent);
        this.rearDisplaySessionConsumer = ((Consumer2)v0);
        this.windowAreaComponent.startRearDisplaySession(arg3, ((Consumer)v0));
    }

    private final void startRearDisplayPresentationMode(Activity arg4, Executor arg5, WindowAreaPresentationSessionCallback arg6) {
        if(!Intrinsics.areEqual(this.currentRearDisplayPresentationStatus, Status.WINDOW_AREA_STATUS_AVAILABLE)) {
            arg6.onSessionEnded(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
            return;
        }

        this.presentationSessionActive = true;
        this.windowAreaComponent.startRearDisplayPresentationSession(arg4, new RearDisplayPresentationSessionConsumer(this, arg5, arg6, this.windowAreaComponent));
    }

    public void transferActivityToWindowArea(Binder arg2, Activity arg3, Executor arg4, WindowAreaSessionCallback arg5) {
        Intrinsics.checkNotNullParameter(arg2, "token");
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Intrinsics.checkNotNullParameter(arg4, "executor");
        Intrinsics.checkNotNullParameter(arg5, "windowAreaSessionCallback");
        if(!Intrinsics.areEqual(arg2.getInterfaceDescriptor(), "WINDOW_AREA_REAR_DISPLAY")) {
            arg4.execute(new WindowAreaControllerImpl$$ExternalSyntheticLambda1(arg5));
            return;
        }

        this.startRearDisplayMode(arg3, arg4, arg5);
    }

    static final void transferActivityToWindowArea$lambda$1(WindowAreaSessionCallback arg2) {
        arg2.onSessionEnded(new IllegalArgumentException("Invalid WindowAreaInfo token"));
    }

    private final void updateRearDisplayAvailability(int arg8) {
        androidx.window.layout.WindowMetricsCalculator$Companion v0 = WindowMetricsCalculator.Companion;
        DisplayMetrics v1 = this.windowAreaComponent.getRearDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(v1, "getRearDisplayMetrics(...)");
        WindowMetrics v0_1 = v0.fromDisplayMetrics$window_release(v1);
        this.currentRearDisplayModeStatus = WindowAreaAdapter.translate$window_release$default(WindowAreaAdapter.INSTANCE, arg8, this.activeWindowAreaSession, 0, 4, null);
        this.updateRearDisplayWindowArea(Operation.OPERATION_TRANSFER_ACTIVITY_TO_AREA, this.currentRearDisplayModeStatus, v0_1);
    }

    private final void updateRearDisplayPresentationAvailability(ExtensionWindowAreaStatus arg7) {
        this.currentRearDisplayPresentationStatus = WindowAreaAdapter.translate$window_release$default(WindowAreaAdapter.INSTANCE, arg7.getWindowAreaStatus(), this.presentationSessionActive, 0, 4, null);
        androidx.window.layout.WindowMetricsCalculator$Companion v0 = WindowMetricsCalculator.Companion;
        DisplayMetrics v7 = arg7.getWindowAreaDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(v7, "getWindowAreaDisplayMetrics(...)");
        this.updateRearDisplayWindowArea(Operation.OPERATION_PRESENT_ON_AREA, this.currentRearDisplayPresentationStatus, v0.fromDisplayMetrics$window_release(v7));
    }

    private final void updateRearDisplayWindowArea(Operation arg6, Status arg7, WindowMetrics arg8) {
        String v1 = "WINDOW_AREA_REAR_DISPLAY";
        Object v0 = this.currentWindowAreaInfoMap.get(v1);
        if(Intrinsics.areEqual(arg7, Status.WINDOW_AREA_STATUS_UNSUPPORTED)) {
            if(v0 != null) {
                if(this.shouldRemoveWindowAreaInfo(((WindowAreaInfo)v0))) {
                    this.currentWindowAreaInfoMap.remove(v1);
                    return;
                }
                else {
                    ((WindowAreaInfo)v0).getCapabilityMap$window_release().put(arg6, new WindowAreaCapability(arg6, arg7));
                }
            }

            return;
        }

        if(v0 == null) {
            WindowAreaInfo v0_1 = new WindowAreaInfo(arg8, Type.TYPE_REAR_FACING, new Binder(v1), this.windowAreaComponent);
        }

        ((WindowAreaInfo)v0).getCapabilityMap$window_release().put(arg6, new WindowAreaCapability(arg6, arg7));
        ((WindowAreaInfo)v0).setMetrics(arg8);
        this.currentWindowAreaInfoMap.put(v1, v0);
    }
}

