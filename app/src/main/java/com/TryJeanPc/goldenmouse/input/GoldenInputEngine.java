package com.TryJeanPc.goldenmouse.input;

import android.util.Log;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline$Budget;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0003\\]^B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AJ\u0006\u0010\u001E\u001A\u00020\u001CJ\u0006\u0010\u001F\u001A\u00020\u001CJ\u000E\u0010;\u001A\u00020\u001C2\u0006\u0010<\u001A\u00020,J\u0006\u0010=\u001A\u00020\u001CJ\u0006\u0010>\u001A\u00020\u001AJ\u0010\u0010?\u001A\u00020\u001C2\u0006\u0010@\u001A\u00020AH\u0002J\u000E\u0010B\u001A\b\u0012\u0004\u0012\u00020\r0%H\u0002J\u001E\u0010C\u001A\u00020\u001C2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020E0%2\u0006\u0010F\u001A\u00020EH\u0002J\u001E\u0010G\u001A\u00020\u001C2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\r0%2\u0006\u0010@\u001A\u00020AH\u0002J\u0018\u0010I\u001A\u00020\u001C2\u0006\u0010@\u001A\u00020A2\u0006\u0010J\u001A\u00020KH\u0002J\u0010\u0010L\u001A\u00020\u001C2\u0006\u0010J\u001A\u00020KH\u0002J\u0012\u0010M\u001A\u0004\u0018\u00010\u000F2\u0006\u0010J\u001A\u00020KH\u0002J\u0012\u0010N\u001A\u0004\u0018\u00010\u00112\u0006\u0010J\u001A\u00020KH\u0002J\u0010\u0010O\u001A\u00020\u001C2\u0006\u0010J\u001A\u00020KH\u0002J\u0010\u0010P\u001A\u00020\u001C2\u0006\u00104\u001A\u000205H\u0002J\b\u0010Q\u001A\u00020\u001CH\u0002J\b\u0010R\u001A\u00020\u001CH\u0002J\b\u0010S\u001A\u00020\u001CH\u0002J\u0010\u0010T\u001A\u00020\u001C2\u0006\u0010@\u001A\u00020AH\u0002J\u0010\u0010U\u001A\u00020\r2\u0006\u0010V\u001A\u00020EH\u0002J\u0016\u0010W\u001A\b\u0012\u0004\u0012\u00020\f0%2\u0006\u0010X\u001A\u00020\fH\u0002J\u0016\u0010Y\u001A\u00020E2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020E0%H\u0002J \u0010Z\u001A\u0004\u0018\u00010E2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020E0%2\u0006\u0010[\u001A\u00020EH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000F0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010$\u001A\b\u0012\u0004\u0012\u00020#0%X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010&\u001A\b\u0012\u0004\u0012\u00020\r0%X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\'\u001A\u0004\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010)\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010*\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010+\u001A\u0004\u0018\u00010,X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010-\u001A\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001A\b\u0012\u0004\u0012\u00020/01¢\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u0011\u00104\u001A\u0002058F¢\u0006\u0006\u001A\u0004\b6\u00107R\u0011\u00108\u001A\u00020/8F¢\u0006\u0006\u001A\u0004\b9\u0010:¨\u0006_"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine;", "", "backendSupervisor", "Lcom/TryJeanPc/goldenmouse/input/BackendSupervisor;", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/BackendSupervisor;)V", "discoveryDeadline", "Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline;", "deviceDiscovery", "Lcom/TryJeanPc/goldenmouse/input/GetEventDeviceDiscovery;", "captureSessions", "", "", "Lcom/TryJeanPc/goldenmouse/input/DeviceCaptureSession;", "mouseSessions", "Lcom/TryJeanPc/goldenmouse/input/MouseCaptureSession;", "keyboardSessions", "Lcom/TryJeanPc/goldenmouse/input/KeyboardCaptureSession;", "sessionsLock", "lifecycleLock", "eventDispatchLock", "eventSequence", "Ljava/util/concurrent/atomic/AtomicLong;", "engineGeneration", "capturePolicyLock", "captureSuspended", "", "requestCaptureSuspended", "", "suspended", "recoverCapture", "applyCapturePolicy", "running", "stopRequested", "supervisorThread", "Ljava/lang/Thread;", "readerThreads", "", "activeCaptureSessions", "discoveryStream", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "activeMouseSession", "activeKeyboardSession", "eventListener", "Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine$CaptureListener;", "_snapshotFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/TryJeanPc/goldenmouse/input/InputSnapshot;", "snapshotFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSnapshotFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "state", "Lcom/TryJeanPc/goldenmouse/input/InputState;", "getState", "()Lcom/TryJeanPc/goldenmouse/input/InputState;", "snapshot", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/input/InputSnapshot;", "start", "listener", "stop", "isRunning", "captureLoop", "generation", "", "prepareCaptureSessions", "rebuildRoleSessions", "devices", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "selectedMouse", "readCaptureSessions", "sessions", "acceptRawEvent", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "routeInputEvent", "findMouseSession", "findKeyboardSession", "emitInputEvent", "updateSnapshot", "closeActiveCaptureSessions", "interruptReaderThreads", "closeDiscoveryStream", "finishCapture", "createSession", "descriptor", "runDiscoveryCommand", "command", "selectMouseDevice", "selectKeyboardDevice", "mouseDevice", "CaptureListener", "ReaderResult", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenInputEngine {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H\u0016J\b\u0010\u0004\u001A\u00020\u0003H\u0016J\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000BÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine$CaptureListener;", "", "onCaptureStarted", "", "onCaptureStopped", "onCaptureError", "error", "", "onInputEvent", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface CaptureListener {
        @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
            @Deprecated public static void onCaptureError(CaptureListener arg1, Throwable arg2) {
                Intrinsics.checkNotNullParameter(arg2, "error");
                arg1.onCaptureError(arg2);
            }

            @Deprecated public static void onCaptureStarted(CaptureListener arg0) {
                arg0.onCaptureStarted();
            }

            @Deprecated public static void onCaptureStopped(CaptureListener arg0) {
                arg0.onCaptureStopped();
            }

            @Deprecated public static void onInputEvent(CaptureListener arg1, InputEvent arg2) {
                Intrinsics.checkNotNullParameter(arg2, "event");
                arg1.onInputEvent(arg2);
            }
        }

        static void access$onCaptureError$jd(CaptureListener arg0, Throwable arg1) {
            super.onCaptureError(arg1);
        }

        static void access$onCaptureStarted$jd(CaptureListener arg0) {
            super.onCaptureStarted();
        }

        static void access$onCaptureStopped$jd(CaptureListener arg0) {
            super.onCaptureStopped();
        }

        static void access$onInputEvent$jd(CaptureListener arg0, InputEvent arg1) {
            super.onInputEvent(arg1);
        }

        default void onCaptureError(Throwable arg1) {
            Intrinsics.checkNotNullParameter(arg1, "error");
        }

        default void onCaptureStarted() {
        }

        default void onCaptureStopped() {
        }

        default void onInputEvent(InputEvent arg1) {
            Intrinsics.checkNotNullParameter(arg1, "event");
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine$Companion;", "", "<init>", "()V", "TAG", "", "CAPTURE_RETRY_DELAY_MS", "", "READER_JOIN_TIMEOUT_MS", "STOP_JOIN_TIMEOUT_MS", "mouseNameRegex", "Lkotlin/text/Regex;", "getMouseNameRegex", "()Lkotlin/text/Regex;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Regex getMouseNameRegex() {
            return GoldenInputEngine.mouseNameRegex;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine$ReaderResult;", "", "error", "", "<init>", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ReaderResult {
        private final Throwable error;

        public ReaderResult(Throwable arg2) {
            Intrinsics.checkNotNullParameter(arg2, "error");
            super();
            this.error = arg2;
        }

        public final Throwable component1() {
            return this.error;
        }

        public final ReaderResult copy(Throwable arg1) {
            Intrinsics.checkNotNullParameter(arg1, "error");
            return new ReaderResult(arg1);
        }

        public static ReaderResult copy$default(ReaderResult arg0, Throwable arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.error;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((ReaderResult)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof ReaderResult)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.error, ((ReaderResult)arg4).error)) {
                return 0;
            }

            return 1;
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "ReaderResult(error=" + this.error + ")";
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[InputDeviceRole.values().length];
            try {
                v0[InputDeviceRole.MOUSE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[InputDeviceRole.KEYBOARD.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 0;
    @Deprecated public static final long CAPTURE_RETRY_DELAY_MS = 1000;
    private static final Companion Companion = null;
    @Deprecated public static final long READER_JOIN_TIMEOUT_MS = 500;
    @Deprecated public static final long STOP_JOIN_TIMEOUT_MS = 2000;
    @Deprecated public static final String TAG = "GOLDEN_INPUT_ENGINE";
    private final MutableStateFlow _snapshotFlow;
    private volatile List activeCaptureSessions;
    private volatile KeyboardCaptureSession activeKeyboardSession;
    private volatile MouseCaptureSession activeMouseSession;
    private final BackendSupervisor backendSupervisor;
    private final Object capturePolicyLock;
    private final Map captureSessions;
    private volatile boolean captureSuspended;
    private final GetEventDeviceDiscovery deviceDiscovery;
    private TransportDeadline discoveryDeadline;
    private volatile CaptureStream discoveryStream;
    private final AtomicLong engineGeneration;
    private final Object eventDispatchLock;
    private volatile CaptureListener eventListener;
    private final AtomicLong eventSequence;
    private final Map keyboardSessions;
    private final Object lifecycleLock;
    private static final Regex mouseNameRegex;
    private final Map mouseSessions;
    private volatile List readerThreads;
    private volatile boolean running;
    private final Object sessionsLock;
    private final StateFlow snapshotFlow;
    private volatile boolean stopRequested;
    private volatile Thread supervisorThread;

    static {
        GoldenInputEngine.Companion = new Companion(null);
        GoldenInputEngine.$stable = 8;
        GoldenInputEngine.mouseNameRegex = new Regex("mouse|trackball|pointer|receiver", RegexOption.IGNORE_CASE);
    }

    public GoldenInputEngine(BackendSupervisor arg1, int arg2, DefaultConstructorMarker arg3) {
        DefaultBackendSupervisor v1;
        if((arg2 & 1) != 0) {
            v1 = DefaultBackendSupervisor.INSTANCE;
        }

        this(((BackendSupervisor)v1));
    }

    public GoldenInputEngine() {
        this(null, 1, null);
    }

    public GoldenInputEngine(BackendSupervisor arg7) {
        Intrinsics.checkNotNullParameter(arg7, "backendSupervisor");
        super();
        this.backendSupervisor = arg7;
        this.discoveryDeadline = new TransportDeadline("GoldenDiscovery");
        this.deviceDiscovery = new GetEventDeviceDiscovery(new GoldenInputEngine$deviceDiscovery$1(this));
        this.captureSessions = new LinkedHashMap();
        this.mouseSessions = new LinkedHashMap();
        this.keyboardSessions = new LinkedHashMap();
        this.sessionsLock = new Object();
        this.lifecycleLock = new Object();
        this.eventDispatchLock = new Object();
        this.eventSequence = new AtomicLong(0);
        this.engineGeneration = new AtomicLong(0);
        this.capturePolicyLock = new Object();
        this.readerThreads = CollectionsKt.emptyList();
        this.activeCaptureSessions = CollectionsKt.emptyList();
        MutableStateFlow v7 = StateFlowKt.MutableStateFlow(new InputSnapshot(null, null, null, 7, null));
        this._snapshotFlow = v7;
        this.snapshotFlow = FlowKt.asStateFlow(v7);
    }

    private final void acceptRawEvent(long arg4, InputEvent arg6) {
        Object v0 = this.eventDispatchLock;
        __monitor_enter(v0);
        try {
            if(arg4 == this.engineGeneration.get() && !this.stopRequested) {
                if(!this.running) {
                }
                else {
                    this.routeInputEvent(arg6.withSequenceNumber(this.eventSequence.incrementAndGet()));
                    goto label_15;
                }
            }

            goto label_17;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

    label_15:
        __monitor_exit(v0);
        return;
    label_17:
        __monitor_exit(v0);
    }

    public static final void access$emitInputEvent(GoldenInputEngine arg0, InputEvent arg1) {
        arg0.emitInputEvent(arg1);
    }

    public static final Regex access$getMouseNameRegex$cp() {
        return GoldenInputEngine.mouseNameRegex;
    }

    public static final List access$runDiscoveryCommand(GoldenInputEngine arg0, String arg1) {
        return arg0.runDiscoveryCommand(arg1);
    }

    public final void applyCapturePolicy() {
        Throwable v4_2;
        Object v5_2;
        CaptureMode v2;
        BooleanRef v1;
        Object v0 = this.capturePolicyLock;
        __monitor_enter(v0);
        try {
            v1 = new BooleanRef();
            do {
            label_4:
                v1.element = this.captureSuspended;
                v2 = v1.element ? CaptureMode.SHARED : CaptureMode.EXCLUSIVE;
                String v3 = "GOLDEN_INPUT_ENGINE";
                boolean v4 = v1.element;
                List v5 = this.activeCaptureSessions;
                ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5), 10));
                Iterator v5_1 = ((Iterable)v5).iterator();
                while(v5_1.hasNext()) {
                    ((Collection)v6).add(v5_1.next().getDescriptor().getPath());
                }

                Log.i(v3, "phase=capture-policy suspended=" + v4 + " requestedMode=" + v2 + " sessions=" + v6);
                List v3_1 = this.activeCaptureSessions;
                ArrayList v4_1 = new ArrayList();
                Iterator v3_2 = ((Iterable)v3_1).iterator();
                while(v3_2.hasNext()) {
                    v5_2 = v3_2.next();
                    Object v6_1 = v5_2;
                    if(!((DeviceCaptureSession)v6_1).getDescriptor().getHasRelX()) {
                        continue;
                    }

                    if(!((DeviceCaptureSession)v6_1).getDescriptor().getHasRelY()) {
                        continue;
                    }

                    ((Collection)v4_1).add(v5_2);
                }

                v3_2 = ((Iterable)v4_1).iterator();
                v4_2 = null;
                while(true) {
                label_57:
                    if(!v3_2.hasNext()) {
                        goto label_78;
                    }

                    v5_2 = v3_2.next();
                    break;
                }
            }
            while(true);
        }
        catch(Throwable v8) {
            goto label_89;
        }

        try {
            ((DeviceCaptureSession)v5_2).changeCaptureMode(v2, new GoldenInputEngine$$ExternalSyntheticLambda2(v1, this, ((DeviceCaptureSession)v5_2), v2), new GoldenInputEngine$$ExternalSyntheticLambda3(this, v1));
            v5_2 = Result.constructor-impl(Unit.INSTANCE);
            goto label_74;
        }
        catch(Throwable v5_3) {
            try {
                v5_2 = Result.constructor-impl(ResultKt.createFailure(v5_3));
            label_74:
                v5_3 = Result.exceptionOrNull-impl(v5_2);
                if(v5_3 == null) {
                    goto label_57;
                }

                v4_2 = v5_3;
                goto label_57;
            label_78:
                if(v4_2 != null) {
                    goto label_87;
                }

                if(v1.element != this.captureSuspended && !this.stopRequested) {
                    goto label_4;
                }
            }
            catch(Throwable v8) {
                goto label_89;
            }
        }

        __monitor_exit(v0);
        return;
        try {
        label_87:
            throw v4_2;
        }
        catch(Throwable v8) {
        label_89:
            __monitor_exit(v0);
            throw v8;
        }
    }

    static final CaptureStream applyCapturePolicy$lambda$8$lambda$6$lambda$4$lambda$2(BooleanRef arg0, GoldenInputEngine arg1, DeviceCaptureSession arg2, CaptureMode arg3) {
        if(arg0.element) {
            return arg1.backendSupervisor.openPassiveDeviceStream(arg2.getDescriptor().getPath());
        }

        return arg1.backendSupervisor.openDeviceStream(arg2.getDescriptor().getPath(), arg3);
    }

    static final boolean applyCapturePolicy$lambda$8$lambda$6$lambda$4$lambda$3(GoldenInputEngine arg1, BooleanRef arg2) {
        if(arg1.captureSuspended == arg2.element && !arg1.stopRequested) {
            return 1;
        }

        return 0;
    }

    private final void captureLoop(long arg11) {
        Object v1_2;
        Object v2;
        List v1_1;
        String v0_1;
        try {
            while(true) {
            label_0:
                if(this.stopRequested) {
                    goto label_144;
                }

                if(!this.running) {
                    goto label_144;
                }

                this.updateSnapshot(InputState.WAITING);
                v0_1 = "backend-discovery";
                break;
            }
        }
        catch(Throwable v0) {
            goto label_147;
        }

        try {
            v1_1 = this.prepareCaptureSessions();
            this.activeCaptureSessions = v1_1;
            v2 = this.capturePolicyLock;
            __monitor_enter(v2);
        }
        catch(Throwable v1) {
            goto label_97;
        }

        try {
            Iterator v3 = v1_1.iterator();
            while(true) {
                if(!v3.hasNext()) {
                    goto label_75;
                }

                Object v4 = v3.next();
                if(this.stopRequested) {
                    break;
                }

                int v5 = !((DeviceCaptureSession)v4).getDescriptor().getHasRelX() || !((DeviceCaptureSession)v4).getDescriptor().getHasRelY() ? 0 : 1;
                v0_1 = "device-open path=" + ((DeviceCaptureSession)v4).getDescriptor().getPath();
                String v6 = "GOLDEN_INPUT_ENGINE";
                CaptureMode v7 = (this.captureSuspended) || v5 == 0 ? CaptureMode.SHARED : CaptureMode.EXCLUSIVE;
                Log.i(v6, v0_1 + " requestedMode=" + v7);
                CaptureMode v5_1 = (this.captureSuspended) || v5 == 0 ? CaptureMode.SHARED : CaptureMode.EXCLUSIVE;
                ((DeviceCaptureSession)v4).start(v5_1);
                Log.i("GOLDEN_INPUT_ENGINE", "phase=device-opened path=" + ((DeviceCaptureSession)v4).getDescriptor().getPath() + " state=" + ((DeviceCaptureSession)v4).getState());
            }

            throw new InterruptedException();
        label_75:
            v0_1 = "capture-policy";
            this.applyCapturePolicy();
        }
        catch(Throwable v1) {
            goto label_94;
        }

        try {
            __monitor_exit(v2);
            if(!this.stopRequested) {
                v0_1 = "readers";
                this.readCaptureSessions(v1_1, arg11);
                if(this.stopRequested) {
                    goto label_0;
                }

                throw new IllegalStateException("Captura finalizada inesperadamente");
            }

            throw new InterruptedException();
        label_94:
            __monitor_exit(v2);
            throw v1;
        }
        catch(Throwable v1) {
            try {
            label_97:
                if(!this.stopRequested) {
                    String v3_1 = v1.getMessage();
                    if(v3_1 == null) {
                        v3_1 = v1.getClass().getSimpleName();
                    }

                    IllegalStateException v2_1 = new IllegalStateException("phase=" + v0_1 + ": " + v3_1, v1);
                    this.updateSnapshot(InputState.ERROR);
                    Log.e("GOLDEN_INPUT_ENGINE", "Backend de captura no disponible; se reintentará", v2_1);
                    CaptureListener v0_2 = this.eventListener;
                    if(v0_2 == null) {
                        goto label_123;
                    }

                    v0_2.onCaptureError(((Throwable)v2_1));
                }

            label_123:
                this.closeActiveCaptureSessions();
                this.interruptReaderThreads();
                Iterator v0_3 = this.readerThreads.iterator();
                while(true) {
                label_127:
                    if(!v0_3.hasNext()) {
                        goto label_135;
                    }

                    v1_2 = v0_3.next();
                    if(v1_2 == Thread.currentThread()) {
                        continue;
                    }

                    break;
                }
            }
            catch(Throwable v0) {
                goto label_147;
            }

            long v2_2 = 500;
            try {
                ((Thread)v1_2).join(v2_2);
            }
            catch(InterruptedException ) {
            }

            goto label_127;
        label_135:
            this.readerThreads = CollectionsKt.emptyList();
            if(this.stopRequested) {
                goto label_144;
            }

            long v0_4 = 1000;
            try {
                Thread.sleep(v0_4);
                goto label_0;
            }
            catch(InterruptedException ) {
                if(!this.stopRequested) {
                    goto label_0;
                }

                goto label_144;
            }
        }

    label_147:
        this.finishCapture(arg11);
        throw v0;
    label_144:
        this.finishCapture(arg11);
    }

    private final void closeActiveCaptureSessions() {
        List v0 = this.activeCaptureSessions;
        this.activeCaptureSessions = CollectionsKt.emptyList();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            String v3 = "GOLDEN_INPUT_ENGINE";
            Log.i(v3, "phase=device-close path=" + ((DeviceCaptureSession)v1).getDescriptor().getPath() + " mode=" + ((DeviceCaptureSession)v1).getCaptureMode());
            try {
                ((DeviceCaptureSession)v1).stop();
                v1 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v1_1) {
                v1 = Result.constructor-impl(ResultKt.createFailure(v1_1));
            }

            v1_1 = Result.exceptionOrNull-impl(v1);
            if(v1_1 == null) {
                continue;
            }

            Log.w(v3, "Cierre de captura pendiente", v1_1);
        }
    }

    private final void closeDiscoveryStream() {
        CaptureStream v0 = this.discoveryStream;
        this.discoveryStream = null;
        if(v0 != null) {
            v0.close();
        }
    }

    private final DeviceCaptureSession createSession(InputDeviceDescriptor arg5) {
        CaptureMode v0 = (this.captureSuspended) || !arg5.getHasRelX() || !arg5.getHasRelY() ? CaptureMode.SHARED : CaptureMode.EXCLUSIVE;
        Log.i("GOLDEN_INPUT_ENGINE", "Sesión " + arg5.getPath() + " captureMode=" + v0);
        ObjectRef v1 = new ObjectRef();
        v1.element = new DeviceCaptureSession(arg5, v0, new GoldenInputEngine$$ExternalSyntheticLambda6(this, v1));
        if(v1.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
            return null;
        }

        return v1.element;
    }

    static final CaptureStream createSession$lambda$41(GoldenInputEngine arg1, ObjectRef arg2, InputDeviceDescriptor arg3) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg3, "device");
        BackendSupervisor v1 = arg1.backendSupervisor;
        String v3 = arg3.getPath();
        if(arg2.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
            DeviceCaptureSession v2 = null;
        }
        else {
            v2_1 = arg2.element;
        }

        return v1.openDeviceStream(v3, ((DeviceCaptureSession)v2_1).getCaptureMode());
    }

    private final void emitInputEvent(InputEvent arg9) {
        InputEvent v2 = arg9;
        KeyboardRouteDiagnostics.key$default(KeyboardRouteDiagnostics.INSTANCE, Stage.CAPTURE_EMIT, v2, null, null, null, 28, null);
        CaptureListener v8 = this.eventListener;
        if(v8 != null) {
            v8.onInputEvent(v2);
        }
    }

    private final KeyboardCaptureSession findKeyboardSession(InputEvent arg2) {
        String v2 = arg2.getDevicePath();
        if(v2 == null) {
            return this.activeKeyboardSession;
        }

        Object v0 = this.sessionsLock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.keyboardSessions.get(v2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }

    private final MouseCaptureSession findMouseSession(InputEvent arg2) {
        String v2 = arg2.getDevicePath();
        if(v2 == null) {
            return this.activeMouseSession;
        }

        Object v0 = this.sessionsLock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.mouseSessions.get(v2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }

    private final void finishCapture(long arg4) {
        Thread v5;
        CaptureListener v4;
        this.closeDiscoveryStream();
        this.closeActiveCaptureSessions();
        this.interruptReaderThreads();
        Object v0 = this.lifecycleLock;
        __monitor_enter(v0);
        try {
            if(arg4 == this.engineGeneration.get()) {
                goto label_10;
            }
        }
        catch(Throwable v3) {
            goto label_50;
        }

        __monitor_exit(v0);
        return;
        try {
        label_10:
            v4 = this.eventListener;
            this.running = false;
            v5 = null;
            this.supervisorThread = v5;
            this.readerThreads = CollectionsKt.emptyList();
            this.eventListener = ((CaptureListener)v5);
        }
        catch(Throwable v3) {
        label_50:
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        v0 = this.sessionsLock;
        __monitor_enter(v0);
        try {
            Iterator v1 = this.captureSessions.values().iterator();
            while(v1.hasNext()) {
                v1.next().stop();
            }

            this.captureSessions.clear();
            this.mouseSessions.clear();
            this.keyboardSessions.clear();
            this.activeMouseSession = ((MouseCaptureSession)v5);
            this.activeKeyboardSession = ((KeyboardCaptureSession)v5);
        }
        catch(Throwable v3) {
            goto label_47;
        }

        __monitor_exit(v0);
        this.discoveryDeadline.close();
        this.updateSnapshot(InputState.DISCONNECTED);
        if(v4 != null) {
            v4.onCaptureStopped();
        }

        return;
    label_47:
        __monitor_exit(v0);
        throw v3;
    }

    public final InputSnapshot getSnapshot() {
        return this.snapshotFlow.getValue();
    }

    public final StateFlow getSnapshotFlow() {
        return this.snapshotFlow;
    }

    public final InputState getState() {
        return this.getSnapshot().getState();
    }

    private final void interruptReaderThreads() {
        Iterator v1 = this.readerThreads.iterator();
        while(v1.hasNext()) {
            v1.next().interrupt();
        }
    }

    public final boolean isRunning() {
        return this.running;
    }

    private final List prepareCaptureSessions() {
        ArrayList v5_4;
        Object v4_2;
        Object v6;
        Object v5;
        Object v3;
        Log.i("GOLDEN_INPUT_ENGINE", "phase=backend-check");
        if(!this.backendSupervisor.isAvailable()) {
            goto label_210;
        }

        Log.i("GOLDEN_INPUT_ENGINE", "phase=discovery-start");
        List v0 = this.deviceDiscovery.listDevices();
        HashSet v1 = new HashSet();
        ArrayList v2 = new ArrayList();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            v3 = v0_1.next();
            if(!v1.add(v3.getPath())) {
                continue;
            }

            v2.add(v3);
        }

        Log.i("GOLDEN_INPUT_ENGINE", "phase=discovery-result devices=" + ((List)v2).size());
        ArrayList v0_2 = v2;
        Iterator v1_1 = ((Iterable)v0_2).iterator();
        while(v1_1.hasNext()) {
            v3 = v1_1.next();
            Log.d("GOLDEN_INPUT_ENGINE", "Input detectado: " + ((InputDeviceDescriptor)v3).getPath() + " (" + ((InputDeviceDescriptor)v3).getName() + ") EV_KEY=" + ((InputDeviceDescriptor)v3).getHasKeys() + " REL_X=" + ((InputDeviceDescriptor)v3).getHasRelX() + " REL_Y=" + ((InputDeviceDescriptor)v3).getHasRelY() + " roles=" + ((InputDeviceDescriptor)v3).getRoles());
        }

        InputDeviceDescriptor v1_2 = this.selectMouseDevice(((List)v2));
        InputDeviceDescriptor v3_1 = this.selectKeyboardDevice(((List)v2), v1_2);
        if(v3_1 == null) {
            Log.w("GOLDEN_INPUT_ENGINE", "phase=keyboard-missing: ningún descriptor fue clasificado como teclado");
        }

        KeyboardRouteDiagnostics.INSTANCE.selection(((List)v2), v3_1);
        LinkedHashSet v4 = new LinkedHashSet();
        v0_1 = ((Iterable)v0_2).iterator();
        while(v0_1.hasNext()) {
            ((Collection)v4).add(v0_1.next().getPath());
        }

        Object v0_3 = this.sessionsLock;
        __monitor_enter(v0_3);
        try {
            Iterator v4_1 = SetsKt.minus(this.captureSessions.keySet(), ((Iterable)v4)).iterator();
            while(v4_1.hasNext()) {
                v5 = this.captureSessions.remove(v4_1.next());
                if(v5 == null) {
                    continue;
                }

                ((DeviceCaptureSession)v5).stop();
            }

            v4_1 = v2.iterator();
            while(v4_1.hasNext()) {
                v5 = v4_1.next();
                v6 = this.captureSessions.get(((InputDeviceDescriptor)v5).getPath());
                if(v6 != null && (Intrinsics.areEqual(((DeviceCaptureSession)v6).getDescriptor(), v5))) {
                    continue;
                }

                if(v6 != null) {
                    ((DeviceCaptureSession)v6).stop();
                }

                this.captureSessions.put(((InputDeviceDescriptor)v5).getPath(), this.createSession(((InputDeviceDescriptor)v5)));
            }

            this.rebuildRoleSessions(((List)v2), v1_2);
            this.activeMouseSession = MapsKt.getValue(this.mouseSessions, v1_2.getPath());
            DeviceCaptureSession v2_1 = null;
            if(v3_1 != null) {
                v4_2 = this.keyboardSessions.get(v3_1.getPath());
            }
            else {
                KeyboardCaptureSession v4_3 = ((KeyboardCaptureSession)v2_1);
            }

            this.activeKeyboardSession = ((KeyboardCaptureSession)v4_2);
            DeviceCaptureSession[] v4_4 = new DeviceCaptureSession[2];
            MouseCaptureSession v5_1 = this.activeMouseSession;
            DeviceCaptureSession v5_2 = v5_1 != null ? v5_1.getDeviceSession() : v2_1;
            v4_4[0] = v5_2;
            KeyboardCaptureSession v5_3 = this.activeKeyboardSession;
            if(v5_3 != null) {
                v2_1 = v5_3.getDeviceSession();
            }

            v4_4[1] = v2_1;
            List v2_2 = CollectionsKt.listOfNotNull(((Object[])v4_4));
            Collection v4_5 = this.keyboardSessions.values();
            v5_4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4_5), 10));
            v4_1 = ((Iterable)v4_5).iterator();
            while(v4_1.hasNext()) {
                ((Collection)v5_4).add(v4_1.next().getDeviceSession());
            }

            v2_2 = CollectionsKt.plus(((Collection)v2_2), ((Iterable)v5_4));
            HashSet v4_6 = new HashSet();
            v5_4 = new ArrayList();
            Iterator v2_3 = ((Iterable)v2_2).iterator();
            while(v2_3.hasNext()) {
                v6 = v2_3.next();
                if(!v4_6.add(v6.getDescriptor().getPath())) {
                    continue;
                }

                v5_4.add(v6);
            }

            __monitor_exit(v0_3);
        }
        catch(Throwable v12) {
            goto label_208;
        }

        Log.i("GOLDEN_INPUT_ENGINE", "Mouse detectado: " + v1_2.getPath() + " (" + v1_2.getName() + ")");
        if(v3_1 != null) {
            Log.i("GOLDEN_INPUT_ENGINE", "Teclado detectado: " + v3_1.getPath() + " (" + v3_1.getName() + ")");
        }

        this.updateSnapshot(InputState.WAITING);
        return ((List)v5_4);
    label_208:
        __monitor_exit(v0_3);
        throw v12;
    label_210:
        throw new IllegalStateException("No hay backend de captura con permisos disponibles");
    }

    private final void readCaptureSessions(List arg9, long arg10) {
        LinkedBlockingQueue v3 = new LinkedBlockingQueue();
        ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg9), 10));
        Iterator v9 = ((Iterable)arg9).iterator();
        while(v9.hasNext()) {
            Object v1 = v9.next();
            ((Collection)v6).add(new Thread(new GoldenInputEngine$$ExternalSyntheticLambda9(((DeviceCaptureSession)v1), this, v3, arg10), "GoldenRaw-" + StringsKt.substringAfterLast$default(((DeviceCaptureSession)v1).getDescriptor().getPath(), '/', null, 2, null)));
            this = this;
            arg10 = arg10;
        }

        GoldenInputEngine v2 = this;
        v2.readerThreads = ((List)v6);
        Iterator v8 = v6.iterator();
        while(v8.hasNext()) {
            v8.next().start();
        }

        Object v8_1 = v3.poll();
        if(v8_1 == null) {
            v2.updateSnapshot(InputState.CONNECTED);
            Log.i("GOLDEN_INPUT_ENGINE", "phase=capture-ready readers=" + ((List)v6).size() + " mouse=" + v2.getSnapshot().getMouse().getConnected() + " keyboard=" + v2.getSnapshot().getKeyboard().getConnected());
            CaptureListener v8_2 = v2.eventListener;
            if(v8_2 != null) {
                v8_2.onCaptureStarted();
            }

            throw v3.take().getError();
        }

        throw ((ReaderResult)v8_1).getError();
    }

    static final void readCaptureSessions$lambda$28$lambda$27(DeviceCaptureSession arg4, GoldenInputEngine arg5, LinkedBlockingQueue arg6, long arg7) {
        IllegalStateException v7_2;
        Object v7_1;
        String v0 = "Stream finalizado: ";
        Log.i("GOLDEN_INPUT_ENGINE", "phase=reader-running path=" + arg4.getDescriptor().getPath());
        try {
            new RawInputReader(arg4, new GoldenInputEngine$$ExternalSyntheticLambda7(arg5, arg7)).read();
            if(arg5.stopRequested) {
                v7_1 = Result.constructor-impl(Unit.INSTANCE);
                goto label_34;
            }

            throw new IllegalStateException(v0 + arg4.getDescriptor().getPath());
        }
        catch(Throwable v7) {
            v7_1 = Result.constructor-impl(ResultKt.createFailure(v7));
        }

    label_34:
        if(!arg5.stopRequested) {
            v7 = Result.exceptionOrNull-impl(v7_1);
            if(v7 == null) {
                v7_2 = new IllegalStateException("Captura finalizada: " + arg4.getDescriptor().getPath());
            }

            arg6.offer(new ReaderResult(((Throwable)v7_2)));
        }
    }

    static final Unit readCaptureSessions$lambda$28$lambda$27$lambda$26$lambda$25(GoldenInputEngine arg1, long arg2, InputEvent arg4) {
        Intrinsics.checkNotNullParameter(arg4, "event");
        arg1.acceptRawEvent(arg2, arg4);
        return Unit.INSTANCE;
    }

    private final void rebuildRoleSessions(List arg7, InputDeviceDescriptor arg8) {
        this.mouseSessions.clear();
        this.keyboardSessions.clear();
        Iterator v7 = ((Iterable)arg7).iterator();
        while(v7.hasNext()) {
            Object v0 = v7.next();
            Object v1 = MapsKt.getValue(this.captureSessions, ((InputDeviceDescriptor)v0).getPath());
            if((((InputDeviceDescriptor)v0).getRoles().contains(InputDeviceRole.MOUSE)) || (Intrinsics.areEqual(((InputDeviceDescriptor)v0).getPath(), arg8.getPath()))) {
                this.mouseSessions.put(((InputDeviceDescriptor)v0).getPath(), new MouseCaptureSession(((DeviceCaptureSession)v1), new GoldenInputEngine$rebuildRoleSessions$1$1(this)));
            }

            if(!((InputDeviceDescriptor)v0).getRoles().contains(InputDeviceRole.KEYBOARD)) {
                continue;
            }

            this.keyboardSessions.put(((InputDeviceDescriptor)v0).getPath(), new KeyboardCaptureSession(((DeviceCaptureSession)v1), new GoldenInputEngine$rebuildRoleSessions$1$2(this)));
        }
    }

    public final void recoverCapture() {
        Log.w("GOLDEN_INPUT_ENGINE", "phase=policy-recovery: se cierran lectores para recuperación supervisada");
        this.closeActiveCaptureSessions();
        this.interruptReaderThreads();
        Thread v2 = this.supervisorThread;
        if(v2 != null) {
            v2.interrupt();
        }
    }

    public final void requestCaptureSuspended(boolean arg1) {
        this.captureSuspended = arg1;
    }

    private final void routeInputEvent(InputEvent arg4) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg4.getSourceRole().ordinal()];
        if(v0 == 1) {
            MouseCaptureSession v0_2 = this.findMouseSession(arg4);
            if(v0_2 != null && (v0_2.onEvent(arg4))) {
                return;
            }
        }
        else if(v0 == 2) {
            KeyboardCaptureSession v0_1 = this.findKeyboardSession(arg4);
            if(v0_1 != null && (v0_1.onEvent(arg4))) {
                return;
            }
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        this.emitInputEvent(arg4);
    }

    private final List runDiscoveryCommand(String arg8) {
        Object v1_1;
        String v0 = "phase=discovery-output lines=";
        Budget v1 = new Budget(5000);
        CaptureStream v8 = this.backendSupervisor.openStream(arg8);
        this.discoveryStream = v8;
        CaptureStream v2 = null;
        try {
            v1_1 = this.discoveryDeadline.call(v1.remainingMillis(), new GoldenInputEngine$$ExternalSyntheticLambda0(this, v8), new GoldenInputEngine$$ExternalSyntheticLambda1(this, v8));
            Log.i("GOLDEN_INPUT_ENGINE", v0 + ((List)v1_1).size() + " sample=" + CollectionsKt.take(v1_1, 6));
        }
        catch(Throwable v0_1) {
            if(this.discoveryStream == v8) {
                this.discoveryStream = v2;
            }

            v8.close();
            throw v0_1;
        }

        if(this.discoveryStream == v8) {
            this.discoveryStream = v2;
        }

        v8.close();
        return ((List)v1_1);
    }

    static final Unit runDiscoveryCommand$lambda$43(GoldenInputEngine arg1, CaptureStream arg2) {
        arg1.discoveryDeadline.closeAsync(new GoldenInputEngine$$ExternalSyntheticLambda5(arg2));
        return Unit.INSTANCE;
    }

    static final Unit runDiscoveryCommand$lambda$43$lambda$42(CaptureStream arg0) {
        arg0.close();
        return Unit.INSTANCE;
    }

    static final List runDiscoveryCommand$lambda$45(GoldenInputEngine arg2, CaptureStream arg3) {
        List v0 = CollectionsKt.createListBuilder();
        while(!arg2.stopRequested) {
            String v1 = arg3.readLine();
            if(v1 == null) {
            }
            else {
                v0.add(v1);
                continue;
            }

            break;
        }

        return CollectionsKt.build(v0);
    }

    private final InputDeviceDescriptor selectKeyboardDevice(List arg6, InputDeviceDescriptor arg7) {
        Object v6;
        Object v0;
        InputDeviceDescriptor v1;
        Iterator v5 = ((Iterable)arg6).iterator();
        do {
            v1 = null;
            if(v5.hasNext()) {
                v0 = v5.next();
                Object v2 = v0;
                if(Intrinsics.areEqual(((InputDeviceDescriptor)v2).getPath(), arg7.getPath())) {
                    continue;
                }

                if(!((InputDeviceDescriptor)v2).getRoles().contains(InputDeviceRole.KEYBOARD)) {
                    continue;
                }

                break;
            }
            else {
                goto label_15;
            }
        }
        while(true);

        goto label_16;
    label_15:
        v0 = v1;
    label_16:
        if(v0 != null) {
            return ((InputDeviceDescriptor)v0);
        }

        if(arg7.getRoles().contains(InputDeviceRole.KEYBOARD)) {
            return arg7;
        }

        v5 = ((Iterable)arg6).iterator();
        do {
            if(v5.hasNext()) {
                v6 = v5.next();
                if(!v6.getRoles().contains(InputDeviceRole.KEYBOARD)) {
                    continue;
                }

                break;
            }

            goto label_33;
        }
        while(true);

        Object v1_1 = v6;
    label_33:
        return ((InputDeviceDescriptor)v1_1);
    }

    private final InputDeviceDescriptor selectMouseDevice(List arg10) {
        Object v1;
        ArrayList v9 = new ArrayList();
        Iterator v10 = ((Iterable)arg10).iterator();
        while(v10.hasNext()) {
            Object v0 = v10.next();
            v1 = v0;
            if(!((InputDeviceDescriptor)v1).getHasRelX()) {
                continue;
            }

            if(!((InputDeviceDescriptor)v1).getHasRelY()) {
                continue;
            }

            ((Collection)v9).add(v0);
        }

        ArrayList v0_1 = v9;
        v9 = new ArrayList();
        v10 = ((Iterable)v0_1).iterator();
        while(v10.hasNext()) {
            v1 = v10.next();
            Object v2 = v1;
            if(!((InputDeviceDescriptor)v2).getRoles().contains(InputDeviceRole.MOUSE) && !GoldenInputEngine.mouseNameRegex.containsMatchIn(((InputDeviceDescriptor)v2).getName())) {
                continue;
            }

            ((Collection)v9).add(v1);
        }

        Object v9_1 = CollectionsKt.firstOrNull(CollectionsKt.sortedWith(((Iterable)v9), new GoldenInputEngine$selectMouseDevice$$inlined$thenByDescending$1(new GoldenInputEngine$selectMouseDevice$$inlined$compareByDescending$1())));
        if(v9_1 != null) {
            return ((InputDeviceDescriptor)v9_1);
        }

        throw new IllegalStateException("No se encontró un mouse con EV_REL, REL_X y REL_Y. Candidatos relativos: " + CollectionsKt.joinToString$default(((Iterable)v0_1), null, null, null, 0, null, new GoldenInputEngine$$ExternalSyntheticLambda4(), 0x1F, null));
    }

    static final CharSequence selectMouseDevice$lambda$50(InputDeviceDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg2.getPath() + " (" + arg2.getName() + ")";
    }

    public final void start(CaptureListener arg5) {
        Intrinsics.checkNotNullParameter(arg5, "listener");
        Object v0 = this.lifecycleLock;
        __monitor_enter(v0);
        try {
            if(!this.running) {
                goto label_8;
            }
        }
        catch(Throwable v4) {
            goto label_37;
        }

        __monitor_exit(v0);
        return;
        try {
        label_8:
            if(this.stopRequested) {
                this.discoveryDeadline = new TransportDeadline("GoldenDiscovery");
            }

            this.eventListener = arg5;
            this.stopRequested = false;
            this.running = true;
            this.eventSequence.set(0);
            this.updateSnapshot(InputState.WAITING);
            Thread v5 = new Thread(new GoldenInputEngine$$ExternalSyntheticLambda8(this, this.engineGeneration.incrementAndGet()), "GoldenInputSupervisor");
            this.supervisorThread = v5;
            v5.start();
        }
        catch(Throwable v4) {
        label_37:
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
    }

    static final void start$lambda$10$lambda$9(GoldenInputEngine arg0, long arg1) {
        arg0.captureLoop(arg1);
    }

    public final void stop() {
        Thread v1;
        Object v0 = this.lifecycleLock;
        __monitor_enter(v0);
        try {
            if(this.running) {
                goto label_7;
            }
        }
        catch(Throwable v4) {
            goto label_27;
        }

        __monitor_exit(v0);
        return;
        try {
        label_7:
            this.stopRequested = true;
            v1 = this.supervisorThread;
        }
        catch(Throwable v4) {
        label_27:
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        this.closeDiscoveryStream();
        this.closeActiveCaptureSessions();
        this.interruptReaderThreads();
        if(v1 != null) {
            v1.interrupt();
        }

        if(v1 != null && v1 != Thread.currentThread()) {
            v1.join(2000);
            if(v1.isAlive()) {
                Log.w("GOLDEN_INPUT_ENGINE", "El supervisor de entrada no terminó dentro del timeout");
            }
        }
    }

    private final void updateSnapshot(InputState arg20) {
        String v14;
        boolean v13;
        String v11_1;
        String v10_1;
        boolean v6_1;
        InputState v1 = arg20;
        MouseCaptureSession v2 = this.activeMouseSession;
        KeyboardCaptureSession v3 = this.activeKeyboardSession;
        MutableStateFlow v0 = this._snapshotFlow;
        String v9 = null;
        if(v1 == InputState.CONNECTED) {
            InputState v6 = v2 != null ? v2.getState() : ((InputState)v9);
            if(v6 != InputState.CONNECTED) {
                goto label_20;
            }

            v6_1 = true;
        }
        else {
        label_20:
            v6_1 = false;
        }

        if(v2 != null) {
            InputDeviceDescriptor v10 = v2.getDescriptor();
            if(v10 != null) {
                v10_1 = v10.getPath();
            }
            else {
                goto label_26;
            }
        }
        else {
        label_26:
            v10_1 = v9;
        }

        if(v2 != null) {
            InputDeviceDescriptor v11 = v2.getDescriptor();
            if(v11 != null) {
                v11_1 = v11.getName();
            }
            else {
                goto label_32;
            }
        }
        else {
        label_32:
            v11_1 = v9;
        }

        InputDeviceDescriptor v2_1 = v2 != null ? v2.getDescriptor() : ((InputDeviceDescriptor)v9);
        InputDeviceStatus v5 = new InputDeviceStatus(v6_1, v10_1, v11_1, v2_1);
        if(v1 == InputState.CONNECTED) {
            InputState v2_2 = v3 != null ? v3.getState() : ((InputState)v9);
            if(v2_2 != InputState.CONNECTED) {
                goto label_49;
            }

            v13 = true;
        }
        else {
        label_49:
            v13 = false;
        }

        if(v3 != null) {
            v2_1 = v3.getDescriptor();
            if(v2_1 != null) {
                v14 = v2_1.getPath();
            }
            else {
                goto label_56;
            }
        }
        else {
        label_56:
            v14 = v9;
        }

        if(v3 != null) {
            v2_1 = v3.getDescriptor();
            if(v2_1 != null) {
                v9 = v2_1.getName();
            }
        }

        v0.setValue(new InputSnapshot(v5, new InputDeviceStatus(v13, v14, v9, null, 8, null), v1));
    }
}

