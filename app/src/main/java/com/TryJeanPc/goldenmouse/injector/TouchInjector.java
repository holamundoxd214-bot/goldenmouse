package com.TryJeanPc.goldenmouse.injector;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0007\u0018\u0000 j2\u00020\u0001:\u0005fghijB!\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001A\u00020\u0013H\u0002J\b\u0010\u0014\u001A\u00020\u0013H\u0002J\u0010\u0010\"\u001A\u00020\u00162\u0006\u0010#\u001A\u00020\u0016H\u0002J\u0010\u0010$\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016H\u0002J\u0016\u0010&\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J \u0010\'\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u00162\u0006\u0010(\u001A\u00020\u0006H\u0002J\u0016\u0010)\u001A\u00020\u00132\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010*\u001A\u00020\u00132\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\b\u00100\u001A\u00020\u001CH\u0002J\u0016\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u00012\u0006\u00103\u001A\u00020\u001CJ\u000E\u00104\u001A\u00020\u00132\u0006\u00102\u001A\u00020\u0001J\b\u00105\u001A\u00020\u0013H\u0002J!\u00106\u001A\u0004\u0018\u0001072\u0006\u00108\u001A\u00020,2\n\b\u0002\u00109\u001A\u0004\u0018\u00010\u001C¢\u0006\u0002\u0010:J\u0010\u0010;\u001A\u0004\u0018\u0001072\u0006\u00108\u001A\u00020,J\u001E\u0010<\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001E\u0010>\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0012\u0010?\u001A\u0004\u0018\u00010\u001D2\u0006\u0010=\u001A\u000207H\u0002J\u000E\u0010@\u001A\u00020\u000E2\u0006\u0010=\u001A\u000207J\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u001C0BJ\u001E\u0010C\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J(\u0010D\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u00162\b\b\u0002\u0010E\u001A\u00020\u000EJ\u001E\u0010F\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001E\u0010G\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001E\u0010H\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u000E\u0010I\u001A\u00020\u000E2\u0006\u0010=\u001A\u000207J\u000E\u0010J\u001A\u00020\u000E2\u0006\u00108\u001A\u00020,J>\u0010K\u001A\u00020\u000E2\u0006\u0010=\u001A\u0002072\u0006\u0010L\u001A\u00020\u001D2\u0006\u0010M\u001A\u00020N2\b\b\u0002\u0010#\u001A\u00020\u00162\b\b\u0002\u0010%\u001A\u00020\u00162\b\b\u0002\u0010E\u001A\u00020\u000EH\u0002J\u001E\u0010C\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u001C2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001E\u0010H\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u001C2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u000E\u0010I\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u001CJ\u0006\u0010O\u001A\u00020\u000EJ\b\u0010P\u001A\u00020\u000EH\u0002J\u001E\u0010Q\u001A\u00020\u000E2\u0006\u0010R\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001E\u0010S\u001A\u00020\u000E2\u0006\u0010R\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010T\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010U\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0006\u0010V\u001A\u00020\u000EJ\u0016\u0010W\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010X\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0018\u0010Y\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016H\u0002J\u0016\u0010Z\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010[\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u001D\u0010\\\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016H\u0000¢\u0006\u0002\b]J \u0010^\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u00162\u0006\u0010_\u001A\u00020\u000EH\u0002J\u0016\u0010`\u001A\u00020\u00132\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010a\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010b\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010c\u001A\u00020\u00132\u0006\u0010#\u001A\u00020\u00162\u0006\u0010%\u001A\u00020\u0016J\u0006\u0010d\u001A\u00020\u000EJ\u0006\u0010e\u001A\u00020\u000ER\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R*\u0010\u001A\u001A\u001E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D0\u001Bj\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D`\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010-\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001C0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006k"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "", "injectionBackend", "Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "uptimeMillis", "Lkotlin/Function0;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;Lkotlin/jvm/functions/Function0;)V", "tag", "", "fpsPointerState", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$FpsPointerState;", "mouseClickActivo", "", "mouseContactUncertain", "mouseEpoch", "fpsEpoch", "refreshMouseEpochLocked", "", "refreshFpsEpochLocked", "ultimoX", "", "ultimoY", "ultimoClickX", "ultimoClickY", "mappedPointers", "Ljava/util/LinkedHashMap;", "", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerPosition;", "Lkotlin/collections/LinkedHashMap;", "cameraLock", "mouseLock", "mappedLock", "resolveX", "x", "resolveY", "y", "injectTap", "injectTapLocked", "epoch", "touch", "tocar", "legacyOwner", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;", "capacityQuotas", "Ljava/util/IdentityHashMap;", "mappedEpoch", "chargedCapacityLocked", "reserveCapacity", "key", "count", "releaseCapacity", "refreshMappedEpochLocked", "reservePointer", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "owner", "pointerId", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "reserveMacroPointer", "macroDown", "lease", "macroMove", "ownedPositionLocked", "ownsPointer", "uncertainMappedPointerIds", "", "pointerDown", "pointerDownPixels", "confirmed", "pointerMovePixels", "pointerUpPixels", "pointerMove", "pointerUp", "releaseOwner", "executeMappedLocked", "current", "action", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand$Action;", "releaseMappedPointers", "cancelFpsWithoutOtherContacts", "mouseButton", "pressed", "mouseButtonPixels", "mouseMove", "mouseMovePixels", "isMouseClickActivo", "iniciarFPS", "iniciarFPSPixels", "startFpsLocked", "move", "movePixels", "moveGgPixels", "moveGgPixels$app", "moveFpsPixels", "gg", "mover", "release", "releasePixels", "soltar", "releaseActive", "releaseAllActive", "FpsPointerState", "PointerOwner", "PointerLease", "PointerPosition", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TouchInjector {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010\u001F\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0007J\u0006\u0010!\u001A\u00020\u001CR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u000F\"\u0004\b\u0014\u0010\u0011R\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$Companion;", "", "<init>", "()V", "MOUSE_POINTER_ID", "", "MOUSE_DOWN_TRACE_TAG", "", "FPS_POINTER_ID", "FIRST_MAPPED_POINTER_ID", "LAST_POINTER_ID", "TAP_HOLD_TIME_MS", "", "screenWidthPx", "getScreenWidthPx", "()I", "setScreenWidthPx", "(I)V", "screenHeightPx", "getScreenHeightPx", "setScreenHeightPx", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "updateScreenDimensions", "", "width", "height", "showDiagnosticToast", "message", "closeSharedBackend", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void closeSharedBackend() {
            DefaultInjectionBackend.INSTANCE.close();
        }

        public final Context getAppContext() {
            return TouchInjector.appContext;
        }

        public final int getScreenHeightPx() {
            return TouchInjector.screenHeightPx;
        }

        public final int getScreenWidthPx() {
            return TouchInjector.screenWidthPx;
        }

        public final void setAppContext(Context arg1) {
            TouchInjector.appContext = arg1;
        }

        public final void setScreenHeightPx(int arg1) {
            TouchInjector.screenHeightPx = arg1;
        }

        public final void setScreenWidthPx(int arg1) {
            TouchInjector.screenWidthPx = arg1;
        }

        public final void showDiagnosticToast(String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "message");
            Context v2 = this.getAppContext();
            if(v2 == null) {
            }
            else {
                try {
                    Looper v0 = Looper.getMainLooper();
                    if(v0 == null) {
                    }
                    else {
                        new Handler(v0).post(new TouchInjector$Companion$$ExternalSyntheticLambda0(v2, arg3));
                    }

                    return;
                }
                catch(Throwable ) {
                    return;
                }
            }
        }

        static final void showDiagnosticToast$lambda$0(Context arg1, String arg2) {
            try {
                Toast.makeText(arg1, ((CharSequence)arg2), 0).show();
                return;
            }
            catch(Throwable ) {
                return;
            }
        }

        public final void updateScreenDimensions(int arg1, int arg2) {
            this.setScreenWidthPx(arg1);
            this.setScreenHeightPx(arg2);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$FpsPointerState;", "", "<init>", "(Ljava/lang/String;I)V", "INACTIVE", "DOWN_PENDING", "ACTIVE", "RECOVERING", "RELEASED", "app"}, k=1, mv={2, 2, 0}, xi=0x30) enum FpsPointerState {
        public static final enum FpsPointerState ACTIVE;
        public static final enum FpsPointerState DOWN_PENDING;
        public static final enum FpsPointerState INACTIVE;
        public static final enum FpsPointerState RECOVERING;
        public static final enum FpsPointerState RELEASED;

        private static final FpsPointerState[] $values() {
            return new FpsPointerState[]{FpsPointerState.INACTIVE, FpsPointerState.DOWN_PENDING, FpsPointerState.ACTIVE, FpsPointerState.RECOVERING, FpsPointerState.RELEASED};
        }

        static {
            FpsPointerState.INACTIVE = new FpsPointerState("INACTIVE", 0);
            FpsPointerState.DOWN_PENDING = new FpsPointerState("DOWN_PENDING", 1);
            FpsPointerState.ACTIVE = new FpsPointerState("ACTIVE", 2);
            FpsPointerState.RECOVERING = new FpsPointerState("RECOVERING", 3);
            FpsPointerState.RELEASED = new FpsPointerState("RELEASED", 4);
            FpsPointerState[] v0 = FpsPointerState.$values();
            FpsPointerState.$VALUES = v0;
            FpsPointerState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private FpsPointerState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return FpsPointerState.$ENTRIES;
        }

        public static FpsPointerState valueOf(String arg1) {
            return Enum.valueOf(FpsPointerState.class, arg1);
        }

        public static FpsPointerState[] values() {
            return FpsPointerState.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "", "pointerId", "", "owner", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;", "epoch", "", "<init>", "(ILcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;J)V", "getPointerId", "()I", "getOwner", "()Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;", "getEpoch$app", "()J", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PointerLease {
        public static final int $stable = 8;
        private final long epoch;
        private final PointerOwner owner;
        private final int pointerId;

        static {
        }

        public PointerLease(int arg2, PointerOwner arg3, long arg4) {
            Intrinsics.checkNotNullParameter(arg3, "owner");
            super();
            this.pointerId = arg2;
            this.owner = arg3;
            this.epoch = arg4;
        }

        public final long getEpoch$app() {
            return this.epoch;
        }

        public final PointerOwner getOwner() {
            return this.owner;
        }

        public final int getPointerId() {
            return this.pointerId;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0011\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u001EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerOwner;", "", "componentId", "", "actionId", "", "sessionId", "capacityKey", "<init>", "(Ljava/lang/String;JJLjava/lang/Object;)V", "getComponentId", "()Ljava/lang/String;", "getActionId", "()J", "getSessionId", "getCapacityKey$app", "()Ljava/lang/Object;", "epoch", "getEpoch$app", "()Ljava/lang/Long;", "setEpoch$app", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "injector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "getInjector$app", "()Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "setInjector$app", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;)V", "retired", "", "getRetired$app", "()Z", "setRetired$app", "(Z)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PointerOwner {
        public static final int $stable = 8;
        private final long actionId;
        private final Object capacityKey;
        private final String componentId;
        private Long epoch;
        private TouchInjector injector;
        private boolean retired;
        private final long sessionId;

        static {
        }

        public PointerOwner(String arg2, long arg3, long arg5, Object arg7) {
            Intrinsics.checkNotNullParameter(arg2, "componentId");
            super();
            this.componentId = arg2;
            this.actionId = arg3;
            this.sessionId = arg5;
            this.capacityKey = arg7;
        }

        public PointerOwner(String arg8, long arg9, long arg11, Object arg13, int arg14, DefaultConstructorMarker arg15) {
            if((arg14 & 8) != 0) {
                arg13 = null;
            }

            this(arg8, arg9, arg11, arg13);
        }

        public final long getActionId() {
            return this.actionId;
        }

        public final Object getCapacityKey$app() {
            return this.capacityKey;
        }

        public final String getComponentId() {
            return this.componentId;
        }

        public final Long getEpoch$app() {
            return this.epoch;
        }

        public final TouchInjector getInjector$app() {
            return this.injector;
        }

        public final boolean getRetired$app() {
            return this.retired;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public final void setEpoch$app(Long arg1) {
            this.epoch = arg1;
        }

        public final void setInjector$app(TouchInjector arg1) {
            this.injector = arg1;
        }

        public final void setRetired$app(boolean arg1) {
            this.retired = arg1;
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u001A\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J\t\u0010\u001E\u001A\u00020\bHÆ\u0003J;\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bHÆ\u0001J\u0013\u0010 \u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020%HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\t\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006&"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerPosition;", "", "x", "", "y", "lease", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "active", "", "uncertain", "<init>", "(FFLcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;ZZ)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "getLease", "()Lcom/TryJeanPc/goldenmouse/injector/TouchInjector$PointerLease;", "getActive", "()Z", "setActive", "(Z)V", "getUncertain", "setUncertain", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class PointerPosition {
        private boolean active;
        private final PointerLease lease;
        private boolean uncertain;
        private float x;
        private float y;

        public PointerPosition(float arg2, float arg3, PointerLease arg4, boolean arg5, boolean arg6, int arg7, DefaultConstructorMarker arg8) {
            this(arg2, arg3, arg4, false, false);
        }

        public PointerPosition(float arg2, float arg3, PointerLease arg4, boolean arg5, boolean arg6) {
            Intrinsics.checkNotNullParameter(arg4, "lease");
            super();
            this.x = arg2;
            this.y = arg3;
            this.lease = arg4;
            this.active = arg5;
            this.uncertain = arg6;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final PointerLease component3() {
            return this.lease;
        }

        public final boolean component4() {
            return this.active;
        }

        public final boolean component5() {
            return this.uncertain;
        }

        public final PointerPosition copy(float arg7, float arg8, PointerLease arg9, boolean arg10, boolean arg11) {
            Intrinsics.checkNotNullParameter(arg9, "lease");
            return new PointerPosition(arg7, arg8, arg9, arg10, arg11);
        }

        public static PointerPosition copy$default(PointerPosition arg0, float arg1, float arg2, PointerLease arg3, boolean arg4, boolean arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.y;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.lease;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.active;
            }

            if((arg6 & 16) != 0) {
                arg5 = arg0.uncertain;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean equals(Object arg5) {
            if(this == (((PointerPosition)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof PointerPosition)) {
                return 0;
            }

            if(Float.compare(this.x, ((PointerPosition)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((PointerPosition)arg5).y) != 0) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.lease, ((PointerPosition)arg5).lease)) {
                return 0;
            }

            if(this.active != ((PointerPosition)arg5).active) {
                return 0;
            }

            if(this.uncertain != ((PointerPosition)arg5).uncertain) {
                return 0;
            }

            return 1;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final PointerLease getLease() {
            return this.lease;
        }

        public final boolean getUncertain() {
            return this.uncertain;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return (((Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y)) * 0x1F + this.lease.hashCode()) * 0x1F + Boolean.hashCode(this.active)) * 0x1F + Boolean.hashCode(this.uncertain);
        }

        public final void setActive(boolean arg1) {
            this.active = arg1;
        }

        public final void setUncertain(boolean arg1) {
            this.uncertain = arg1;
        }

        public final void setX(float arg1) {
            this.x = arg1;
        }

        public final void setY(float arg1) {
            this.y = arg1;
        }

        public String toString() {
            return "PointerPosition(x=" + this.x + ", y=" + this.y + ", lease=" + this.lease + ", active=" + this.active + ", uncertain=" + this.uncertain + ")";
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int FIRST_MAPPED_POINTER_ID = 3;
    private static final int FPS_POINTER_ID = 2;
    private static final int LAST_POINTER_ID = 30;
    private static final String MOUSE_DOWN_TRACE_TAG = "GOLDEN_MOUSE_DOWN";
    private static final int MOUSE_POINTER_ID = 0;
    public static final long TAP_HOLD_TIME_MS = 45;
    private static volatile Context appContext;
    private final Object cameraLock;
    private final IdentityHashMap capacityQuotas;
    private long fpsEpoch;
    private FpsPointerState fpsPointerState;
    private final InjectionBackend injectionBackend;
    private final PointerOwner legacyOwner;
    private long mappedEpoch;
    private final Object mappedLock;
    private final LinkedHashMap mappedPointers;
    private boolean mouseClickActivo;
    private boolean mouseContactUncertain;
    private long mouseEpoch;
    private final Object mouseLock;
    private static volatile int screenHeightPx;
    private static volatile int screenWidthPx;
    private final String tag;
    private float ultimoClickX;
    private float ultimoClickY;
    private float ultimoX;
    private float ultimoY;
    private final Function0 uptimeMillis;

    static {
        TouchInjector.Companion = new Companion(null);
        TouchInjector.$stable = 8;
    }

    public TouchInjector(InjectionBackend arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        com.TryJeanPc.goldenmouse.injector.TouchInjector$1 v2;
        DefaultInjectionBackend v1;
        if((arg3 & 1) != 0) {
            v1 = DefaultInjectionBackend.INSTANCE;
        }

        if((arg3 & 2) != 0) {
            v2 = com.TryJeanPc.goldenmouse.injector.TouchInjector$1.INSTANCE;
        }

        this(((InjectionBackend)v1), ((Function0)v2));
    }

    public TouchInjector() {
        this(null, null, 3, null);
    }

    public TouchInjector(InjectionBackend arg10, Function0 arg11) {
        Intrinsics.checkNotNullParameter(arg10, "injectionBackend");
        Intrinsics.checkNotNullParameter(arg11, "uptimeMillis");
        super();
        this.injectionBackend = arg10;
        this.uptimeMillis = arg11;
        this.tag = "GOLDEN_INJECTOR";
        this.fpsPointerState = FpsPointerState.INACTIVE;
        this.mouseEpoch = arg10.getConfirmedCancelEpoch();
        this.fpsEpoch = arg10.getConfirmedCancelEpoch();
        this.mappedPointers = new LinkedHashMap();
        this.cameraLock = new Object();
        this.mouseLock = new Object();
        this.mappedLock = new Object();
        this.legacyOwner = new PointerOwner("legacy-mapped", 0, 0, null, 8, null);
        this.capacityQuotas = new IdentityHashMap();
        this.mappedEpoch = arg10.getConfirmedCancelEpoch();
    }

    public static final Context access$getAppContext$cp() {
        return TouchInjector.appContext;
    }

    public static final int access$getScreenHeightPx$cp() {
        return TouchInjector.screenHeightPx;
    }

    public static final int access$getScreenWidthPx$cp() {
        return TouchInjector.screenWidthPx;
    }

    public static final void access$setAppContext$cp(Context arg0) {
        TouchInjector.appContext = arg0;
    }

    public static final void access$setScreenHeightPx$cp(int arg0) {
        TouchInjector.screenHeightPx = arg0;
    }

    public static final void access$setScreenWidthPx$cp(int arg0) {
        TouchInjector.screenWidthPx = arg0;
    }

    private final boolean cancelFpsWithoutOtherContacts() {
        boolean v12;
        Object v2;
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            this.refreshMappedEpochLocked();
            v2 = this.mouseLock;
            __monitor_enter(v2);
        }
        catch(Throwable v0) {
            goto label_51;
        }

        try {
            this.refreshMouseEpochLocked();
            Collection v0_1 = this.mappedPointers.values();
            Intrinsics.checkNotNullExpressionValue(v0_1, "<get-values>(...)");
            if(!(v0_1 instanceof Collection) || !v0_1.isEmpty()) {
                Iterator v0_2 = ((Iterable)v0_1).iterator();
                do {
                    if(v0_2.hasNext()) {
                        Object v3 = v0_2.next();
                        if(!((PointerPosition)v3).getActive()) {
                            if(!((PointerPosition)v3).getUncertain()) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_27;
                        }
                    }
                    else {
                        goto label_25;
                    }

                    goto label_42;
                }
                while(true);

                goto label_27;
            label_25:
                if(this.mouseClickActivo) {
                label_27:
                    v12 = false;
                }
                else {
                    v12 = this.injectionBackend.execute(new TouchCommand(Action.ACTION_CANCEL, this.ultimoX, this.ultimoY, 2, this.uptimeMillis.invoke().longValue(), Long.valueOf(this.fpsEpoch)));
                }
            }
            else {
                goto label_25;
            }

            goto label_42;
        }
        catch(Throwable v0) {
            Throwable v12_1 = v0;
            try {
                __monitor_exit(v2);
                throw v12_1;
            label_42:
                __monitor_exit(v2);
            }
            catch(Throwable v0) {
            label_51:
                __monitor_exit(v1);
                throw v0;
            }
        }

        __monitor_exit(v1);
        return v12;
    }

    private final int chargedCapacityLocked() {
        int v6_1;
        String v4;
        Set v0 = this.capacityQuotas.entrySet();
        Intrinsics.checkNotNullExpressionValue(v0, "<get-entries>(...)");
        Iterator v0_1 = ((Iterable)v0).iterator();
        int v1 = 0;
        int v2;
        for(v2 = 0; true; v2 += Math.max(v3_1, v6_1)) {
            v4 = "<get-values>(...)";
            if(!v0_1.hasNext()) {
                break;
            }

            Object v3 = v0_1.next();
            Intrinsics.checkNotNull(v3);
            Object v5 = ((Map$Entry)v3).getKey();
            v3 = ((Map$Entry)v3).getValue();
            Intrinsics.checkNotNull(v3);
            int v3_1 = ((Integer)v3).intValue();
            Collection v6 = this.mappedPointers.values();
            Intrinsics.checkNotNullExpressionValue(v6, v4);
            if(!(v6 instanceof Collection) || !v6.isEmpty()) {
                Iterator v4_1 = ((Iterable)v6).iterator();
                v6_1 = 0;
                while(v4_1.hasNext()) {
                    if(v4_1.next().getLease().getOwner().getCapacityKey$app() != v5) {
                        continue;
                    }

                    ++v6_1;
                    if(v6_1 >= 0) {
                        continue;
                    }

                    CollectionsKt.throwCountOverflow();
                }
            }
            else {
                v6_1 = 0;
            }
        }

        Collection v0_2 = this.mappedPointers.values();
        Intrinsics.checkNotNullExpressionValue(v0_2, v4);
        if(v0_2.isEmpty()) {
        }
        else {
            v0_1 = ((Iterable)v0_2).iterator();
            while(v0_1.hasNext()) {
                if(this.capacityQuotas.containsKey(v0_1.next().getLease().getOwner().getCapacityKey$app())) {
                    continue;
                }

                ++v1;
                if(v1 >= 0) {
                    continue;
                }

                CollectionsKt.throwCountOverflow();
            }
        }

        return v2 + v1;
    }

    private final boolean executeMappedLocked(PointerLease arg10, PointerPosition arg11, Action arg12, float arg13, float arg14, boolean arg15) {
        Boolean v9_3;
        Object v9_2;
        boolean v9_1;
        TouchCommand v1;
        try {
            v1 = new TouchCommand(arg12, arg13, arg14, arg10.getPointerId(), this.uptimeMillis.invoke().longValue(), Long.valueOf(arg10.getEpoch$app()));
        }
        catch(Throwable v0) {
            goto label_25;
        }

        InjectionBackend v9 = this.injectionBackend;
        if(arg15) {
            try {
                v9_1 = v9.executeConfirmed(v1);
                goto label_18;
            label_17:
                v9_1 = v9.execute(v1);
            label_18:
                v9_2 = Result.constructor-impl(Boolean.valueOf(v9_1));
            }
            catch(Throwable v0) {
            label_25:
                v9_2 = Result.constructor-impl(ResultKt.createFailure(v0));
            }
        }
        else {
            goto label_17;
        }

        Boolean v10 = Boolean.valueOf(false);
        if(Result.isFailure-impl(v9_2)) {
            v9_3 = v10;
        }

        v9_1 = v9_3.booleanValue();
        if(!v9_1) {
            arg11.setUncertain(true);
        }

        return v9_1;
    }

    static boolean executeMappedLocked$default(TouchInjector arg7, PointerLease arg8, PointerPosition arg9, Action arg10, float arg11, float arg12, boolean arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg11 = arg9.getX();
        }

        float v4 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = arg9.getY();
        }

        return arg7.executeMappedLocked(arg8, arg9, arg10, v4, arg12, false);
    }

    public final boolean iniciarFPS(float arg1, float arg2) {
        return this.iniciarFPSPixels(this.resolveX(arg1), this.resolveY(arg2));
    }

    public final boolean iniciarFPSPixels(float arg2, float arg3) {
        boolean v1_1;
        Object v0 = this.cameraLock;
        __monitor_enter(v0);
        try {
            v1_1 = this.startFpsLocked(arg2, arg3);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final boolean injectTap(float arg8, float arg9) {
        boolean v8;
        boolean v2;
        Object v0 = this.mouseLock;
        __monitor_enter(v0);
        try {
            this.refreshMouseEpochLocked();
            v2 = false;
            if(!this.mouseContactUncertain) {
                if(this.mouseClickActivo) {
                }
                else {
                    this.mouseClickActivo = true;
                    this.ultimoClickX = this.resolveX(arg8);
                    this.ultimoClickY = this.resolveY(arg9);
                    long v3 = this.mouseEpoch;
                    v8 = this.injectTapLocked(arg8, arg9, v3);
                    if(v3 != this.injectionBackend.getConfirmedCancelEpoch()) {
                        this.refreshMouseEpochLocked();
                    }
                    else {
                        if(v8) {
                            this.mouseClickActivo = false;
                        }
                        else {
                            this.mouseContactUncertain = true;
                        }

                        goto label_26;
                    }
                }
            }

            goto label_27;
        }
        catch(Throwable v7) {
            __monitor_exit(v0);
            throw v7;
        }

    label_26:
        v2 = v8;
    label_27:
        __monitor_exit(v0);
        return v2;
    }

    private final boolean injectTapLocked(float arg19, float arg20, long arg21) {
        boolean v2_3;
        TouchInjector v1 = this;
        String v0 = "Error Inyección: UpRejected - Falló UP en [";
        String v2 = "Error Inyección: DownRejected - Tap no inyectado en [";
        float v5 = this.resolveX(arg19);
        float v6 = v1.resolveY(arg20);
        long v8 = v1.uptimeMillis.invoke().longValue();
        try {
            boolean v3 = v1.injectionBackend.execute(new TouchCommand(Action.ACTION_DOWN, v5, v6, 0, v8, Long.valueOf(arg21)));
        }
        catch(Throwable v0_1) {
            goto label_74;
        }

        String v12 = "]";
        String v13 = ", ";
        if(!v3) {
            try {
                Log.e(v1.tag, "No se pudo inyectar ACTION_DOWN");
                TouchInjector.Companion.showDiagnosticToast(v2 + (((int)v5)) + v13 + (((int)v6)) + v12);
                return 0;
            }
            catch(Throwable v0_1) {
                goto label_74;
            }
        }

        long v2_1 = 45;
        try {
            Thread.sleep(v2_1);
            goto label_40;
        }
        catch(Throwable v0_1) {
        }
        catch(InterruptedException ) {
            try {
                Thread.currentThread().interrupt();
            label_40:
                long v14 = v1.uptimeMillis.invoke().longValue();
                long v16 = v2_1;
                InjectionBackend v2_2 = v1.injectionBackend;
                Action v4 = Action.ACTION_UP;
                if(v14 <= v8) {
                    v14 = v8 + v16;
                }

                v2_3 = v2_2.execute(new TouchCommand(v4, v5, v6, 0, v14, Long.valueOf(arg21)));
                if(!v2_3) {
                    Log.e(v1.tag, "No se pudo inyectar ACTION_UP");
                    TouchInjector.Companion.showDiagnosticToast(v0 + (((int)v5)) + v13 + (((int)v6)) + v12);
                }
            }
            catch(Throwable v0_1) {
            label_74:
                Log.e(v1.tag, "Excepción inyectando tap", v0_1);
                TouchInjector.Companion.showDiagnosticToast("Error Inyección: " + v0_1.getClass().getSimpleName() + " - " + v0_1.getMessage());
                return 0;
            }
        }

        return v2_3;
    }

    public final boolean isMouseClickActivo() {
        boolean v1_1;
        Object v0 = this.mouseLock;
        __monitor_enter(v0);
        try {
            this.refreshMouseEpochLocked();
            v1_1 = this.mouseClickActivo;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final boolean macroDown(PointerLease arg12, float arg13, float arg14) {
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg12, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg12);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!arg12.getOwner().getRetired$app() && !v4.getUncertain() && !v4.getActive()) {
                float v3 = 3.402823E+38f;
                if(Math.abs(arg13) <= v3 && Math.abs(arg14) <= v3) {
                    v4.setX(arg13);
                    v4.setY(arg14);
                    v4.setActive(true);
                    v0_1 = TouchInjector.executeMappedLocked$default(this, arg12, v4, Action.ACTION_DOWN, 0f, 0f, true, 24, null);
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final boolean macroMove(PointerLease arg10, float arg11, float arg12) {
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg10, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg10);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!arg10.getOwner().getRetired$app() && !v4.getUncertain() && (v4.getActive())) {
                float v3 = 3.402823E+38f;
                if(Math.abs(arg11) <= v3 && Math.abs(arg12) <= v3) {
                    float v6 = arg11;
                    float v7 = arg12;
                    v0_1 = this.executeMappedLocked(arg10, v4, Action.ACTION_MOVE, v6, v7, true);
                    if(v0_1) {
                        v4.setX(v6);
                        v4.setY(v7);
                    }
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final boolean mouseButton(boolean arg1, float arg2, float arg3) {
        return this.mouseButtonPixels(arg1, this.resolveX(arg2), this.resolveY(arg3));
    }

    public final boolean mouseButtonPixels(boolean arg18, float arg19, float arg20) {
        boolean v3_1;
        long v8;
        boolean v4_1;
        boolean v16;
        Action v4;
        InjectionBackend v15;
        TouchInjector v1 = this;
        boolean v2 = arg18;
        float v5 = arg19;
        float v6 = arg20;
        String v0 = "Error Inyección: MouseDownRejected en [";
        String v11 = "Error Inyección: ";
        String v3 = "stage=TouchInjector x=";
        Object v12 = v1.mouseLock;
        __monitor_enter(v12);
        try {
            v1.refreshMouseEpochLocked();
            if(!v1.mouseContactUncertain) {
                goto label_15;
            }
        }
        catch(Throwable v0_1) {
            goto label_118;
        }

        __monitor_exit(v12);
        return 0;
        try {
        label_15:
            if(v2 != v1.mouseClickActivo) {
                goto label_20;
            }
        }
        catch(Throwable v0_1) {
            goto label_118;
        }

        __monitor_exit(v12);
        return 1;
    label_20:
        if(v2) {
            try {
                Log.i("GOLDEN_MOUSE_DOWN", v3 + v5 + " y=" + v6 + " screenWidth=" + TouchInjector.screenWidthPx + " screenHeight=" + TouchInjector.screenHeightPx + " pointerId=0 action=ACTION_DOWN");
            }
            catch(Throwable v0_1) {
                goto label_118;
            }
        }

        try {
            v15 = v1.injectionBackend;
            if(v2) {
            }
            else {
                goto label_49;
            }
        }
        catch(Throwable v0_1) {
            goto label_95;
        }

        try {
            v4 = Action.ACTION_DOWN;
            goto label_50;
        }
        catch(Throwable v0_1) {
            v16 = false;
            v4_1 = true;
            goto label_97;
        }

        try {
        label_49:
            v4 = Action.ACTION_UP;
        label_50:
            v8 = v1.uptimeMillis.invoke().longValue();
            v16 = false;
        }
        catch(Throwable v0_1) {
        label_95:
            v16 = false;
            goto label_96;
        }

        try {
            v3_1 = v15.execute(new TouchCommand(v4, v5, v6, 0, v8, Long.valueOf(v1.mouseEpoch)));
            if(v3_1) {
                v1.mouseClickActivo = v2;
                v1.ultimoClickX = v5;
                v1.ultimoClickY = v6;
            }
            else {
                v1.mouseContactUncertain = true;
                v1.mouseClickActivo = true;
            }

            if((v2) && !v3_1) {
                Log.e("GOLDEN_MOUSE_DOWN", "stage=TouchInjector result=false reason=backend_rejected");
                TouchInjector.Companion.showDiagnosticToast(v0 + (((int)v5)) + ", " + (((int)v6)) + "]");
            }
            else if(v2) {
                Log.i("GOLDEN_MOUSE_DOWN", "stage=TouchInjector result=true");
            }

            goto label_90;
        }
        catch(Throwable v0_1) {
        }

    label_96:
        v4_1 = true;
        try {
        label_97:
            v1.mouseContactUncertain = v4_1;
            v1.mouseClickActivo = v4_1;
            Log.e(v1.tag, "Excepción inyectando mouse click", v0_1);
            if(v2) {
                TouchInjector.Companion.showDiagnosticToast(v11 + v0_1.getClass().getSimpleName() + " - " + v0_1.getMessage());
            }
        }
        catch(Throwable v0_1) {
        label_118:
            __monitor_exit(v12);
            throw v0_1;
        }

        __monitor_exit(v12);
        return v16;
    label_90:
        __monitor_exit(v12);
        return v3_1;
    }

    public final boolean mouseMove(float arg1, float arg2) {
        return this.mouseMovePixels(this.resolveX(arg1), this.resolveY(arg2));
    }

    public final boolean mouseMovePixels(float arg13, float arg14) {
        boolean v13;
        Object v1 = this.mouseLock;
        __monitor_enter(v1);
        try {
            this.refreshMouseEpochLocked();
            if(!this.mouseContactUncertain) {
                goto label_8;
            }
        }
        catch(Throwable v0) {
            goto label_50;
        }

        __monitor_exit(v1);
        return 0;
        try {
        label_8:
            if(this.mouseClickActivo) {
                goto label_12;
            }
        }
        catch(Throwable v0) {
            goto label_50;
        }

        __monitor_exit(v1);
        return 0;
        try {
        label_12:
            if(Float.compare(arg13, this.ultimoClickX) == 0 && arg14 == this.ultimoClickY) {
                goto label_18;
            }

            goto label_20;
        }
        catch(Throwable v0) {
            goto label_50;
        }

    label_18:
        __monitor_exit(v1);
        return 1;
        try {
        label_20:
            float v6 = arg13;
            float v7 = arg14;
            v13 = this.injectionBackend.execute(new TouchCommand(Action.ACTION_MOVE, v6, v7, 0, this.uptimeMillis.invoke().longValue(), Long.valueOf(this.mouseEpoch)));
            if(v13) {
                this.ultimoClickX = v6;
                this.ultimoClickY = v7;
            }
            else {
                this.mouseContactUncertain = true;
            }

            goto label_38;
        }
        catch(Throwable v0) {
            Throwable v13_1 = v0;
            try {
                this.mouseContactUncertain = true;
                Log.e(this.tag, "Excepción inyectando mouse move", v13_1);
            }
            catch(Throwable v0) {
            label_50:
                __monitor_exit(v1);
                throw v0;
            }
        }

        __monitor_exit(v1);
        return 0;
    label_38:
        __monitor_exit(v1);
        return v13;
    }

    public final boolean move(float arg1, float arg2) {
        return this.movePixels(this.resolveX(arg1), this.resolveY(arg2));
    }

    private final boolean moveFpsPixels(float arg13, float arg14, boolean arg15) {
        long v8;
        long v13;
        TouchCommand v4;
        float v7;
        float v6;
        boolean v3;
        Object v1 = this.cameraLock;
        __monitor_enter(v1);
        try {
            this.refreshFpsEpochLocked();
            v3 = false;
            if(this.fpsPointerState == FpsPointerState.ACTIVE) {
                long v9 = this.uptimeMillis.invoke().longValue();
                if(!arg15 && arg13 == this.ultimoX && arg14 == this.ultimoY) {
                    v3 = true;
                    goto label_56;
                }

                v6 = arg13;
                v7 = arg14;
                v4 = new TouchCommand(Action.ACTION_MOVE, v6, v7, 2, v9, Long.valueOf(this.fpsEpoch));
                v13 = 0;
                if(arg15) {
                    v8 = GgPerformanceDiagnostics.INSTANCE.confirmedCallStarted();
                }
                else {
                    goto label_34;
                }

                goto label_35;
            }
            else if(arg15) {
            }
            else {
                v3 = this.startFpsLocked(arg13, arg14);
            }

            goto label_56;
        }
        catch(Throwable v0) {
            goto label_66;
        }

    label_34:
        v8 = v13;
    label_35:
        InjectionBackend v0_1 = this.injectionBackend;
        if(arg15) {
            try {
                arg15 = v0_1.executeConfirmed(v4);
                goto label_40;
            label_39:
                arg15 = v0_1.executeMove(v4);
            }
            catch(Throwable v0) {
                Throwable v12 = v0;
                if(v8 != v13) {
                    try {
                        GgPerformanceDiagnostics.INSTANCE.confirmedCallFinished(v8, false);
                    label_63:
                        throw v12;
                    }
                    catch(Throwable v0) {
                        goto label_66;
                    }
                }

                goto label_63;
            }
        }
        else {
            goto label_39;
        }

    label_40:
        v3 = arg15;
        if(v8 != v13) {
            try {
                GgPerformanceDiagnostics.INSTANCE.confirmedCallFinished(v8, v3);
            label_44:
                if(v3) {
                    this.ultimoX = v6;
                    this.ultimoY = v7;
                    InjectionDiagnostics.INSTANCE.recordPointer2(Action.ACTION_MOVE);
                }
                else {
                    this.fpsPointerState = FpsPointerState.RECOVERING;
                }

                InjectionDiagnostics.INSTANCE.reportIfDue("touch-injector");
                goto label_56;
            }
            catch(Throwable v0) {
            label_66:
                __monitor_exit(v1);
                throw v0;
            }
        }

        goto label_44;
    label_56:
        __monitor_exit(v1);
        return v3;
    }

    public final boolean moveGgPixels$app(float arg2, float arg3) {
        return this.moveFpsPixels(arg2, arg3, true);
    }

    public final boolean movePixels(float arg2, float arg3) {
        return this.moveFpsPixels(arg2, arg3, false);
    }

    public final void mover(float arg1, float arg2) {
        this.move(arg1, arg2);
    }

    private final PointerPosition ownedPositionLocked(PointerLease arg5) {
        this.refreshMappedEpochLocked();
        Object v0 = this.mappedPointers.get(Integer.valueOf(arg5.getPointerId()));
        PointerPosition v1 = null;
        if(v0 != null && ((PointerPosition)v0).getLease() == arg5 && arg5.getEpoch$app() == this.mappedEpoch) {
            return ((PointerPosition)v0);
        }

        return v1;
    }

    public final boolean ownsPointer(PointerLease arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lease");
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            if(this.ownedPositionLocked(arg2) == null) {
                goto label_8;
            }
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        boolean v1_1 = true;
        goto label_9;
    label_8:
        v1_1 = false;
    label_9:
        __monitor_exit(v0);
        return v1_1;
    }

    public final boolean pointerDown(PointerLease arg10, float arg11, float arg12) {
        boolean v9;
        Intrinsics.checkNotNullParameter(arg10, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            v9 = TouchInjector.pointerDownPixels$default(this, arg10, this.resolveX(arg11), this.resolveY(arg12), false, 8, null);
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v9;
    }

    public final boolean pointerDown(int arg5, float arg6, float arg7) {
        boolean v2;
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        if(3 <= arg5 && arg5 < 0x1F) {
            try {
                this.refreshMappedEpochLocked();
                Object v1 = this.mappedPointers.get(Integer.valueOf(arg5));
                v2 = false;
                if(v1 == null) {
                    PointerLease v5 = this.reservePointer(this.legacyOwner, Integer.valueOf(arg5));
                    if(v5 == null) {
                    }
                    else {
                        v2 = this.pointerDown(v5, arg6, arg7);
                    }
                }
                else if(((PointerPosition)v1).getLease().getOwner() != this.legacyOwner) {
                }
                else {
                    v2 = this.pointerMove(((PointerPosition)v1).getLease(), arg6, arg7);
                }
            }
            catch(Throwable v4) {
                goto label_35;
            }

            __monitor_exit(v0);
            return v2;
        }

        try {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Throwable v4) {
        label_35:
            __monitor_exit(v0);
            throw v4;
        }
    }

    public final boolean pointerDownPixels(PointerLease arg12, float arg13, float arg14, boolean arg15) {
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg12, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg12);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!arg12.getOwner().getRetired$app() && !v4.getUncertain()) {
                if(v4.getActive()) {
                }
                else {
                    v4.setX(arg13);
                    v4.setY(arg14);
                    v4.setActive(true);
                    v0_1 = TouchInjector.executeMappedLocked$default(this, arg12, v4, Action.ACTION_DOWN, 0f, 0f, arg15, 24, null);
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public static boolean pointerDownPixels$default(TouchInjector arg0, PointerLease arg1, float arg2, float arg3, boolean arg4, int arg5, Object arg6) {
        return arg0.pointerDownPixels(arg1, arg2, arg3, false);
    }

    public final boolean pointerMove(PointerLease arg12, float arg13, float arg14) {
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg12, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg12);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!arg12.getOwner().getRetired$app() && !v4.getUncertain()) {
                if(!v4.getActive()) {
                }
                else {
                    float v6 = this.resolveX(arg13);
                    float v7 = this.resolveY(arg14);
                    v0_1 = TouchInjector.executeMappedLocked$default(this, arg12, v4, Action.ACTION_MOVE, v6, v7, false, 0x20, null);
                    if(v0_1) {
                        v4.setX(v6);
                        v4.setY(v7);
                    }
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final boolean pointerMove(int arg5, float arg6, float arg7) {
        boolean v1;
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.refreshMappedEpochLocked();
            Object v5 = this.mappedPointers.get(Integer.valueOf(arg5));
            v1 = false;
            if(v5 != null) {
                PointerLease v5_1 = ((PointerPosition)v5).getLease();
                if(v5_1 == null) {
                }
                else if(v5_1.getOwner() != this.legacyOwner) {
                }
                else {
                    v1 = this.pointerMove(v5_1, arg6, arg7);
                }
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        return v1;
    }

    public final boolean pointerMovePixels(PointerLease arg12, float arg13, float arg14) {
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg12, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg12);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!arg12.getOwner().getRetired$app() && !v4.getUncertain() && (v4.getActive())) {
                float v3 = 3.402823E+38f;
                if(Math.abs(arg13) <= v3 && Math.abs(arg14) <= v3) {
                    float v6 = arg13;
                    float v7 = arg14;
                    v0_1 = TouchInjector.executeMappedLocked$default(this, arg12, v4, Action.ACTION_MOVE, v6, v7, false, 0x20, null);
                    if(v0_1) {
                        v4.setX(v6);
                        v4.setY(v7);
                    }
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v0_1;
    }

    public final boolean pointerUp(PointerLease arg12) {
        PointerLease v3;
        TouchInjector v2;
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg12, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg12);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(v4.getUncertain()) {
            }
            else {
                if(v4.getActive()) {
                    v2 = this;
                    v3 = arg12;
                    if(!TouchInjector.executeMappedLocked$default(v2, v3, v4, Action.ACTION_UP, 0f, 0f, false, 56, null)) {
                        goto label_31;
                    }
                }
                else {
                    v2 = this;
                    v3 = arg12;
                }

                v2.mappedPointers.remove(Integer.valueOf(v3.getPointerId()));
                v0_1 = true;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

    label_31:
        __monitor_exit(v1);
        return v0_1;
    }

    public final boolean pointerUp(int arg4) {
        boolean v3_1;
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.refreshMappedEpochLocked();
            Object v4 = this.mappedPointers.get(Integer.valueOf(arg4));
            if(v4 != null) {
                PointerLease v4_1 = ((PointerPosition)v4).getLease();
                if(v4_1 == null) {
                    goto label_17;
                }
                else if(v4_1.getOwner() != this.legacyOwner) {
                    v3_1 = false;
                }
                else {
                    v3_1 = this.pointerUp(v4_1);
                }
            }
            else {
                goto label_17;
            }

            goto label_18;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

    label_17:
        v3_1 = true;
    label_18:
        __monitor_exit(v0);
        return v3_1;
    }

    public final boolean pointerUpPixels(PointerLease arg10, float arg11, float arg12) {
        PointerLease v3_1;
        TouchInjector v2;
        boolean v0_1;
        Intrinsics.checkNotNullParameter(arg10, "lease");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            PointerPosition v4 = this.ownedPositionLocked(arg10);
            v0_1 = false;
            if(v4 == null) {
            }
            else if(!v4.getUncertain()) {
                float v3 = 3.402823E+38f;
                if(Math.abs(arg11) <= v3 && Math.abs(arg12) <= v3) {
                    if(v4.getActive()) {
                        v2 = this;
                        v3_1 = arg10;
                        if(!v2.executeMappedLocked(v3_1, v4, Action.ACTION_UP, arg11, arg12, true)) {
                            goto label_33;
                        }
                    }
                    else {
                        v2 = this;
                        v3_1 = arg10;
                    }

                    v2.mappedPointers.remove(Integer.valueOf(v3_1.getPointerId()));
                    v0_1 = true;
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

    label_33:
        __monitor_exit(v1);
        return v0_1;
    }

    private final void refreshFpsEpochLocked() {
        long v0 = this.injectionBackend.getConfirmedCancelEpoch();
        if(this.fpsEpoch != v0) {
            this.fpsPointerState = FpsPointerState.INACTIVE;
            this.fpsEpoch = v0;
        }
    }

    private final void refreshMappedEpochLocked() {
        long v0 = this.injectionBackend.getConfirmedCancelEpoch();
        if(this.mappedEpoch != v0) {
            this.mappedPointers.clear();
            this.mappedEpoch = v0;
            this.legacyOwner.setEpoch$app(Long.valueOf(v0));
        }
    }

    private final void refreshMouseEpochLocked() {
        long v0 = this.injectionBackend.getConfirmedCancelEpoch();
        if(this.mouseEpoch != v0) {
            this.mouseClickActivo = false;
            this.mouseContactUncertain = false;
            this.mouseEpoch = v0;
        }
    }

    public final boolean release(float arg1, float arg2) {
        return this.releasePixels(this.resolveX(arg1), this.resolveY(arg2));
    }

    public final boolean releaseActive() {
        return this.releasePixels(this.ultimoX, this.ultimoY);
    }

    public final boolean releaseAllActive() {
        boolean v2;
        boolean v0 = this.releaseMappedPointers();
        Object v1 = this.mouseLock;
        __monitor_enter(v1);
        try {
            if(this.mouseClickActivo) {
                v2 = this.mouseButtonPixels(false, this.ultimoClickX, this.ultimoClickY);
            }
            else {
                goto label_11;
            }

            goto label_12;
        }
        catch(Throwable v7) {
            __monitor_exit(v1);
            throw v7;
        }

    label_11:
        v2 = true;
    label_12:
        __monitor_exit(v1);
        v1 = this.cameraLock;
        __monitor_enter(v1);
        try {
            boolean v7_1 = this.releasePixels(this.ultimoX, this.ultimoY);
        }
        catch(Throwable v7) {
            __monitor_exit(v1);
            throw v7;
        }

        __monitor_exit(v1);
        if((v0) && (v2) && (v7_1)) {
            return 1;
        }

        return 0;
    }

    public final void releaseCapacity(Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.capacityQuotas.remove(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public final boolean releaseMappedPointers() {
        boolean v3_1;
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.refreshMappedEpochLocked();
            Collection v1 = this.mappedPointers.values();
            Intrinsics.checkNotNullExpressionValue(v1, "<get-values>(...)");
            ArrayList v2 = new ArrayList();
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                Object v3 = v1_1.next();
                if(v3.getLease().getOwner() != this.legacyOwner) {
                    continue;
                }

                ((Collection)v2).add(v3);
            }

            ArrayList v1_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2), 10));
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                ((Collection)v1_2).add(v2_1.next().getLease());
            }

            v1_1 = CollectionsKt.asReversed(((List)v1_2)).iterator();
            while(true) {
            label_34:
                v3_1 = true;
                while(true) {
                label_35:
                    if(!v1_1.hasNext()) {
                        goto label_44;
                    }

                    if(this.pointerUp(v1_1.next())) {
                        break;
                    }

                    goto label_42;
                }
            }
        }
        catch(Throwable v6) {
            goto label_47;
        }

        if(v3_1) {
            goto label_34;
        }

    label_42:
        v3_1 = false;
        goto label_35;
    label_44:
        __monitor_exit(v0);
        return v3_1;
    label_47:
        __monitor_exit(v0);
        throw v6;
    }

    public final boolean releaseOwner(PointerOwner arg7) {
        boolean v2_2;
        Intrinsics.checkNotNullParameter(arg7, "owner");
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.refreshMappedEpochLocked();
            arg7.setRetired$app(true);
            Collection v2 = this.mappedPointers.values();
            Intrinsics.checkNotNullExpressionValue(v2, "<get-values>(...)");
            ArrayList v3 = new ArrayList();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                Object v4 = v2_1.next();
                if(v4.getLease().getOwner() != arg7) {
                    continue;
                }

                ((Collection)v3).add(v4);
            }

            ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), 10));
            v2_1 = ((Iterable)v3).iterator();
            while(v2_1.hasNext()) {
                ((Collection)v7).add(v2_1.next().getLease());
            }

            Iterator v7_1 = ((Iterable)v7).iterator();
            while(true) {
            label_35:
                v2_2 = true;
                while(true) {
                label_36:
                    if(!v7_1.hasNext()) {
                        goto label_45;
                    }

                    if(this.pointerUp(v7_1.next())) {
                        break;
                    }

                    goto label_43;
                }
            }
        }
        catch(Throwable v6) {
            goto label_48;
        }

        if(v2_2) {
            goto label_35;
        }

    label_43:
        v2_2 = false;
        goto label_36;
    label_45:
        __monitor_exit(v0);
        return v2_2;
    label_48:
        __monitor_exit(v0);
        throw v6;
    }

    public final boolean releasePixels(float arg11, float arg12) {
        boolean v11;
        Object v1 = this.cameraLock;
        __monitor_enter(v1);
        try {
            this.refreshFpsEpochLocked();
            if(this.fpsPointerState == FpsPointerState.INACTIVE) {
                goto label_46;
            }
            else if(this.fpsPointerState == FpsPointerState.RELEASED) {
                goto label_46;
            }
            else if(this.fpsPointerState == FpsPointerState.RECOVERING) {
                v11 = this.cancelFpsWithoutOtherContacts();
                if(v11) {
                    this.fpsPointerState = FpsPointerState.RELEASED;
                    InjectionDiagnostics.INSTANCE.recordPointer2(Action.ACTION_CANCEL);
                }
            }
            else {
                float v4 = arg11;
                float v5 = arg12;
                v11 = this.injectionBackend.execute(new TouchCommand(Action.ACTION_UP, v4, v5, 2, this.uptimeMillis.invoke().longValue(), Long.valueOf(this.fpsEpoch)));
                if(v11) {
                    this.fpsPointerState = FpsPointerState.RELEASED;
                    InjectionDiagnostics.INSTANCE.recordPointer2(Action.ACTION_UP);
                }
                else {
                    this.fpsPointerState = FpsPointerState.RECOVERING;
                }

                this.ultimoX = v4;
                this.ultimoY = v5;
            }

            goto label_47;
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

    label_46:
        v11 = true;
    label_47:
        __monitor_exit(v1);
        return v11;
    }

    public final boolean reserveCapacity(Object arg6, int arg7) {
        int v2;
        boolean v3;
        Intrinsics.checkNotNullParameter(arg6, "key");
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        if(arg7 < 0) {
            goto label_56;
        }

        try {
            this.refreshMappedEpochLocked();
            Collection v1 = this.mappedPointers.values();
            Intrinsics.checkNotNullExpressionValue(v1, "<get-values>(...)");
            v3 = false;
            if(!(v1 instanceof Collection) || !v1.isEmpty()) {
                Iterator v1_1 = ((Iterable)v1).iterator();
                v2 = 0;
                while(v1_1.hasNext()) {
                    if(v1_1.next().getLease().getOwner().getCapacityKey$app() != arg6) {
                        continue;
                    }

                    ++v2;
                    if(v2 >= 0) {
                        continue;
                    }

                    CollectionsKt.throwCountOverflow();
                }
            }
            else {
                v2 = 0;
            }

            Object v1_2 = this.capacityQuotas.get(arg6);
            int v1_3 = v1_2 != null ? ((Integer)v1_2).intValue() : 0;
            if(this.chargedCapacityLocked() - Math.max(v1_3, v2) + Math.max(arg7, v2) > 14) {
            }
            else {
                goto label_45;
            }
        }
        catch(Throwable v5) {
            goto label_61;
        }

        goto label_52;
    label_45:
        IdentityHashMap v5_1 = this.capacityQuotas;
        if(arg7 == 0) {
            try {
                v5_1.remove(arg6);
                goto label_51;
            label_49:
                ((Map)v5_1).put(arg6, Integer.valueOf(arg7));
            }
            catch(Throwable v5) {
                goto label_61;
            }
        }
        else {
            goto label_49;
        }

    label_51:
        v3 = true;
    label_52:
        __monitor_exit(v0);
        return v3;
        try {
        label_56:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Throwable v5) {
        label_61:
            __monitor_exit(v0);
            throw v5;
        }
    }

    public final PointerLease reserveMacroPointer(PointerOwner arg3) {
        Intrinsics.checkNotNullParameter(arg3, "owner");
        return TouchInjector.reservePointer$default(this, arg3, null, 2, null);
    }

    public final PointerLease reservePointer(PointerOwner arg11, Integer arg12) {
        Object v0_4;
        List v12;
        PointerLease v2;
        Intrinsics.checkNotNullParameter(arg11, "owner");
        Object v1 = this.mappedLock;
        __monitor_enter(v1);
        try {
            this.refreshMappedEpochLocked();
            v2 = null;
            if(!arg11.getRetired$app()) {
                TouchInjector v0_1 = arg11.getInjector$app();
                if(v0_1 != null && v0_1 != this) {
                    goto label_103;
                }

                Long v0_2 = arg11.getEpoch$app();
                if(v0_2 != null && ((Number)v0_2).longValue() != this.mappedEpoch) {
                    goto label_103;
                }

                int v0_3 = 30;
                int v3 = 3;
                if(arg12 != null && !new IntRange(v3, v0_3).contains(arg12.intValue())) {
                    goto label_103;
                }

                Object v4 = this.capacityQuotas.get(arg11.getCapacityKey$app());
                if(v4 != null) {
                    Collection v5 = this.mappedPointers.values();
                    Intrinsics.checkNotNullExpressionValue(v5, "<get-values>(...)");
                    int v7 = 0;
                    if(!(v5 instanceof Collection) || !v5.isEmpty()) {
                        Iterator v5_1 = ((Iterable)v5).iterator();
                        while(v5_1.hasNext()) {
                            if(v5_1.next().getLease().getOwner().getCapacityKey$app() != arg11.getCapacityKey$app()) {
                                continue;
                            }

                            ++v7;
                            if(v7 >= 0) {
                                continue;
                            }

                            CollectionsKt.throwCountOverflow();
                        }
                    }
                    else {
                    }

                    if(v7 < ((Integer)v4).intValue()) {
                        goto label_62;
                    }
                }
                else if(this.chargedCapacityLocked() < 14) {
                    goto label_62;
                }

                goto label_103;
            label_62:
                if(arg12 != null) {
                    v12 = CollectionsKt.listOf(Integer.valueOf(((Number)arg12).intValue()));
                    if(v12 == null) {
                        goto label_67;
                    }
                }
                else {
                label_67:
                    v12 = CollectionsKt.toList(new IntRange(v3, v0_3));
                }

                Iterator v12_1 = ((Iterable)v12).iterator();
                do {
                    if(v12_1.hasNext()) {
                        v0_4 = v12_1.next();
                        if(this.mappedPointers.containsKey(Integer.valueOf(v0_4.intValue()))) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_81;
                    }
                }
                while(true);

                goto label_82;
            label_81:
                v0_4 = v2;
            label_82:
                if(v0_4 == null) {
                    goto label_103;
                }

                int v12_2 = ((Integer)v0_4).intValue();
                arg11.setEpoch$app(Long.valueOf(this.mappedEpoch));
                arg11.setInjector$app(this);
                PointerLease v5_2 = new PointerLease(v12_2, arg11, this.mappedEpoch);
                this.mappedPointers.put(Integer.valueOf(v12_2), new PointerPosition(0f, 0f, v5_2, false, false, 24, null));
                v2 = v5_2;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

    label_103:
        __monitor_exit(v1);
        return v2;
    }

    public static PointerLease reservePointer$default(TouchInjector arg0, PointerOwner arg1, Integer arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return arg0.reservePointer(arg1, arg2);
    }

    private final float resolveX(float arg3) {
        float v2 = ((float)TouchInjector.screenWidthPx);
        if(v2 > 0f && arg3 > 0f && arg3 <= 1f) {
            arg3 *= v2;
        }

        return arg3;
    }

    private final float resolveY(float arg3) {
        float v2 = ((float)TouchInjector.screenHeightPx);
        if(v2 > 0f && arg3 > 0f && arg3 <= 1f) {
            arg3 *= v2;
        }

        return arg3;
    }

    public final void soltar(float arg1, float arg2) {
        this.release(arg1, arg2);
    }

    private final boolean startFpsLocked(float arg10, float arg11) {
        this.refreshFpsEpochLocked();
        if(this.fpsPointerState == FpsPointerState.ACTIVE) {
            return 1;
        }

        if(this.fpsPointerState == FpsPointerState.DOWN_PENDING) {
            return 0;
        }

        if(this.fpsPointerState == FpsPointerState.RECOVERING) {
            if(!this.cancelFpsWithoutOtherContacts()) {
                return 0;
            }
            else {
                InjectionDiagnostics.INSTANCE.recordPointer2(Action.ACTION_CANCEL);
                this.refreshFpsEpochLocked();
            }
        }

        float v3 = arg10;
        float v4 = arg11;
        TouchCommand v1 = new TouchCommand(Action.ACTION_DOWN, v3, v4, 2, this.uptimeMillis.invoke().longValue(), Long.valueOf(this.fpsEpoch));
        this.fpsPointerState = FpsPointerState.DOWN_PENDING;
        boolean v10 = this.injectionBackend.execute(v1);
        if(v10) {
            this.fpsPointerState = FpsPointerState.ACTIVE;
            this.ultimoX = v3;
            this.ultimoY = v4;
            InjectionDiagnostics.INSTANCE.recordPointer2(Action.ACTION_DOWN);
            return v10;
        }

        this.fpsPointerState = FpsPointerState.RECOVERING;
        return v10;
    }

    public final void tocar(float arg1, float arg2) {
        this.touch(arg1, arg2);
    }

    public final void touch(float arg1, float arg2) {
        this.injectTap(arg1, arg2);
    }

    public final Set uncertainMappedPointerIds() {
        Set v4_3;
        Object v0 = this.mappedLock;
        __monitor_enter(v0);
        try {
            this.refreshMappedEpochLocked();
            LinkedHashMap v4_1 = this.mappedPointers;
            LinkedHashMap v1 = new LinkedHashMap();
            Iterator v4_2 = ((Map)v4_1).entrySet().iterator();
            while(v4_2.hasNext()) {
                Object v2 = v4_2.next();
                if(!((Map$Entry)v2).getValue().getUncertain()) {
                    continue;
                }

                v1.put(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue());
            }

            v4_3 = CollectionsKt.toSet(((Map)v1).keySet());
        }
        catch(Throwable v4) {
            goto label_23;
        }

        __monitor_exit(v0);
        return v4_3;
    label_23:
        __monitor_exit(v0);
        throw v4;
    }
}

