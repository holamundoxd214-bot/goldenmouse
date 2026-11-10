package com.TryJeanPc.goldenmouse.aim;

import android.util.Log;
import com.TryJeanPc.goldenmouse.aim.gg.ExactRawCoalescer$Mode;
import com.TryJeanPc.goldenmouse.aim.gg.ExactRawCoalescer$Motion;
import com.TryJeanPc.goldenmouse.aim.gg.ExactRawCoalescer;
import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel$TouchSink;
import com.TryJeanPc.goldenmouse.aim.gg.FpsCameraKernel;
import com.TryJeanPc.goldenmouse.injector.GgPerformanceDiagnostics;
import com.TryJeanPc.goldenmouse.injector.InjectionBackend;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics$Stage;
import com.TryJeanPc.goldenmouse.input.InputPipelineDiagnostics;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import com.TryJeanPc.goldenmouse.recoil.RecoilCoordinator$Step;
import com.TryJeanPc.goldenmouse.recoil.RecoilCoordinator;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettings;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 \u0085\u00012\u00020\u0001:\r\u007F\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B;\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0004\b\f\u0010\rJ\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\nJ\u0015\u0010@\u001A\u00020\u000B2\u0006\u0010A\u001A\u00020=H\u0000¢\u0006\u0002\bBJ1\u0010C\u001A\u00020\u00102\u0006\u0010D\u001A\u00020E2\f\u0010F\u001A\b\u0012\u0004\u0012\u00020G0 2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u000B04H\u0000¢\u0006\u0002\bIJ\u0015\u0010J\u001A\u00020\u00102\u0006\u0010K\u001A\u00020GH\u0000¢\u0006\u0002\bLJ\u0010\u0010M\u001A\u00020\u000B2\u0006\u0010N\u001A\u00020OH\u0002J\u0018\u0010P\u001A\u00020\u000B2\u0006\u0010Q\u001A\u00020\u001C2\u0006\u0010R\u001A\u00020\u0010H\u0002J\u0006\u0010S\u001A\u00020\u000BJ\u000E\u0010T\u001A\u00020\u00102\u0006\u0010U\u001A\u00020$J\u000E\u0010V\u001A\u00020\u000B2\u0006\u0010W\u001A\u00020\u0010J\'\u0010X\u001A\u00020\u000B2\u0006\u0010Y\u001A\u00020Z2\u0006\u0010[\u001A\u00020Z2\n\b\u0002\u0010\\\u001A\u0004\u0018\u00010$¢\u0006\u0002\u0010]J1\u0010^\u001A\u00020\u000B2\u0006\u0010_\u001A\u00020`2\u0006\u0010a\u001A\u00020`2\n\b\u0002\u0010\\\u001A\u0004\u0018\u00010$2\b\b\u0002\u0010b\u001A\u00020$¢\u0006\u0002\u0010cJ\b\u0010d\u001A\u00020\u000BH\u0002J\u001B\u0010e\u001A\b\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010f\u001A\u00020$H\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001A\u00020\u00102\u0006\u0010f\u001A\u00020$H\u0000¢\u0006\u0002\biJ\b\u0010j\u001A\u00020\u000BH\u0002J\u001E\u0010k\u001A\u00020\u000B2\u0006\u0010l\u001A\u00020\u00102\u0006\u0010m\u001A\u00020Z2\u0006\u0010n\u001A\u00020ZJ\u0016\u0010o\u001A\u00020\u000B2\u0006\u0010m\u001A\u00020Z2\u0006\u0010n\u001A\u00020ZJ\u001C\u0010p\u001A\u00020\u000B2\u0006\u0010q\u001A\u00020r2\f\u0010s\u001A\b\u0012\u0004\u0012\u00020\u001004J(\u0010t\u001A\u00020\u000B2\u0006\u0010l\u001A\u00020\u00102\u0006\u0010s\u001A\u00020\u00102\u0006\u0010f\u001A\u00020$2\b\b\u0002\u0010b\u001A\u00020$J\u0006\u0010u\u001A\u00020\u000BJ\u0006\u0010v\u001A\u00020\u000BJ\b\u0010w\u001A\u00020\u000BH\u0002J\u0010\u0010x\u001A\u00020\u001C2\u0006\u0010Q\u001A\u00020yH\u0002J\u0010\u0010z\u001A\u00020\u00102\u0006\u0010Q\u001A\u00020\u001CH\u0002J\b\u0010{\u001A\u00020\u000BH\u0002J\b\u0010|\u001A\u00020\u0010H\u0002J\n\u0010}\u001A\u0004\u0018\u00010\u001CH\u0002J\b\u0010~\u001A\u00020\u000BH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100 0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010,\u001A\u0004\u0018\u00010-X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010/\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001A\b\u0012\u0004\u0012\u00020\u001004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00107\u001A\u0004\u0018\u000108X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010:\u001A\u0004\u0018\u00010;X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010<\u001A\u00020=8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b>\u0010?¨\u0006\u0086\u0001"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher;", "", "touchInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "fpsCameraEngine", "Lcom/TryJeanPc/goldenmouse/aim/FpsCameraEngine;", "fireAimCoordinator", "Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;", "onFailure", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;Lcom/TryJeanPc/goldenmouse/aim/FpsCameraEngine;Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;Lkotlin/jvm/functions/Function1;)V", "failurePending", "isFailureCurrent", "", "failure", "lock", "Ljava/lang/Object;", "metrics", "Lcom/TryJeanPc/goldenmouse/aim/FpsPipelineMetrics;", "getMetrics$app", "()Lcom/TryJeanPc/goldenmouse/aim/FpsPipelineMetrics;", "coalescer", "Lcom/TryJeanPc/goldenmouse/aim/gg/ExactRawCoalescer;", "reports", "Ljava/util/ArrayDeque;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Queued;", "buttons", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseButton;", "resets", "Ljava/util/concurrent/CompletableFuture;", "rawBarriers", "rawSuspended", "rawAcceptedSince", "", "running", "aimEnabled", "sessionId", "cameraRevision", "activatedAtNanos", "activatePending", "releasePending", "mouseDrag", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseDrag;", "mouseDown", "worker", "Ljava/lang/Thread;", "recoil", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilCoordinator;", "recoilAuthorization", "Lkotlin/Function0;", "cameraContactPresent", "recoilYieldToRaw", "activeKernel", "Lcom/TryJeanPc/goldenmouse/aim/gg/FpsCameraKernel;", "dispatchRevision", "confirmation", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Confirmation;", "pollingSelection", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "getPollingSelection$app", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "configurePolling", "selection", "configurePolling$app", "confirmTransition", "request", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "completion", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "operation", "confirmTransition$app", "isTransitionCurrent", "result", "isTransitionCurrent$app", "invalidate", "status", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Status;", "finish", "command", "success", "start", "resetSession", "id", "setAimEnabled", "enabled", "engageAtCenter", "centerX", "", "centerY", "expectedSessionId", "(FFLjava/lang/Long;)V", "offerDelta", "dx", "", "dy", "timestampNanos", "(IILjava/lang/Long;J)V", "reportQueue", "suspendRawForFreeLook", "expectedSession", "suspendRawForFreeLook$app", "resumeRawFromFreeLook", "resumeRawFromFreeLook$app", "cancelRawBarriers", "offerMouseButton", "pressed", "x", "y", "offerMouseDrag", "configureRecoil", "settings", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "authorized", "observeRecoilButton", "cancelRecoil", "stop", "clearReports", "queued", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "current", "requireCurrentContact", "releaseCamera", "takeNext", "runLoop", "Failure", "Confirmation", "Command", "Queued", "BackendFailure", "StaleContact", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AimTouchDispatcher {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$BackendFailure;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class BackendFailure extends IllegalStateException {
        public BackendFailure() {
            super("Backend táctil rechazó contacto GG");
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000B\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "", "<init>", "()V", "Failed", "Activate", "Release", "Tick", "Recoil", "Raw", "RawBarrier", "Reset", "MouseButton", "MouseDrag", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Activate;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Failed;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseButton;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseDrag;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Raw;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$RawBarrier;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Recoil;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Release;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Reset;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Tick;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) abstract class Command {
        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Activate;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Activate extends Command {
            public static final int $stable;
            public static final Activate INSTANCE;

            static {
                Activate.INSTANCE = new Activate();
            }

            private Activate() {
                super(null);
            }

            public boolean equals(Object arg2) {
                if(this == (((Activate)arg2))) {
                    return 1;
                }

                if(!(arg2 instanceof Activate)) {
                    return 0;
                }

                return 1;
            }

            public int hashCode() {
                return 0xD595F723;
            }

            public String toString() {
                return "Activate";
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Failed;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "failure", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;", "<init>", "(Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;)V", "getFailure", "()Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Failed extends Command {
            public static final int $stable;
            private final Failure failure;

            static {
            }

            public Failed(Failure arg2) {
                Intrinsics.checkNotNullParameter(arg2, "failure");
                super(null);
                this.failure = arg2;
            }

            public final Failure component1() {
                return this.failure;
            }

            public final Failed copy(Failure arg1) {
                Intrinsics.checkNotNullParameter(arg1, "failure");
                return new Failed(arg1);
            }

            public static Failed copy$default(Failed arg0, Failure arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.failure;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((Failed)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof Failed)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.failure, ((Failed)arg4).failure)) {
                    return 0;
                }

                return 1;
            }

            public final Failure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failed(failure=" + this.failure + ")";
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00032\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseButton;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "pressed", "", "x", "", "y", "<init>", "(ZFF)V", "getPressed", "()Z", "getX", "()F", "getY", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseButton extends Command {
            public static final int $stable;
            private final boolean pressed;
            private final float x;
            private final float y;

            static {
            }

            public MouseButton(boolean arg2, float arg3, float arg4) {
                super(null);
                this.pressed = arg2;
                this.x = arg3;
                this.y = arg4;
            }

            public final boolean component1() {
                return this.pressed;
            }

            public final float component2() {
                return this.x;
            }

            public final float component3() {
                return this.y;
            }

            public final MouseButton copy(boolean arg1, float arg2, float arg3) {
                return new MouseButton(arg1, arg2, arg3);
            }

            public static MouseButton copy$default(MouseButton arg0, boolean arg1, float arg2, float arg3, int arg4, Object arg5) {
                if((arg4 & 1) != 0) {
                    arg1 = arg0.pressed;
                }

                if((arg4 & 2) != 0) {
                    arg2 = arg0.x;
                }

                if((arg4 & 4) != 0) {
                    arg3 = arg0.y;
                }

                return arg0.copy(arg1, arg2, arg3);
            }

            public boolean equals(Object arg5) {
                if(this == (((MouseButton)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof MouseButton)) {
                    return 0;
                }

                if(this.pressed != ((MouseButton)arg5).pressed) {
                    return 0;
                }

                if(Float.compare(this.x, ((MouseButton)arg5).x) != 0) {
                    return 0;
                }

                if(Float.compare(this.y, ((MouseButton)arg5).y) != 0) {
                    return 0;
                }

                return 1;
            }

            public final boolean getPressed() {
                return this.pressed;
            }

            public final float getX() {
                return this.x;
            }

            public final float getY() {
                return this.y;
            }

            public int hashCode() {
                return (Boolean.hashCode(this.pressed) * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y);
            }

            public String toString() {
                return "MouseButton(pressed=" + this.pressed + ", x=" + this.x + ", y=" + this.y + ")";
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$MouseDrag;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseDrag extends Command {
            public static final int $stable;
            private final float x;
            private final float y;

            static {
            }

            public MouseDrag(float arg2, float arg3) {
                super(null);
                this.x = arg2;
                this.y = arg3;
            }

            public final float component1() {
                return this.x;
            }

            public final float component2() {
                return this.y;
            }

            public final MouseDrag copy(float arg1, float arg2) {
                return new MouseDrag(arg1, arg2);
            }

            public static MouseDrag copy$default(MouseDrag arg0, float arg1, float arg2, int arg3, Object arg4) {
                if((arg3 & 1) != 0) {
                    arg1 = arg0.x;
                }

                if((arg3 & 2) != 0) {
                    arg2 = arg0.y;
                }

                return arg0.copy(arg1, arg2);
            }

            public boolean equals(Object arg5) {
                if(this == (((MouseDrag)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof MouseDrag)) {
                    return 0;
                }

                if(Float.compare(this.x, ((MouseDrag)arg5).x) != 0) {
                    return 0;
                }

                if(Float.compare(this.y, ((MouseDrag)arg5).y) != 0) {
                    return 0;
                }

                return 1;
            }

            public final float getX() {
                return this.x;
            }

            public final float getY() {
                return this.y;
            }

            public int hashCode() {
                return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
            }

            public String toString() {
                return "MouseDrag(x=" + this.x + ", y=" + this.y + ")";
            }
        }

        @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Raw;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "dx", "", "dy", "timestamp", "", "<init>", "(IIJ)V", "getDx", "()I", "getDy", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Raw extends Command {
            public static final int $stable;
            private final int dx;
            private final int dy;
            private final long timestamp;

            static {
            }

            public Raw(int arg2, int arg3, long arg4) {
                super(null);
                this.dx = arg2;
                this.dy = arg3;
                this.timestamp = arg4;
            }

            public final int component1() {
                return this.dx;
            }

            public final int component2() {
                return this.dy;
            }

            public final long component3() {
                return this.timestamp;
            }

            public final Raw copy(int arg1, int arg2, long arg3) {
                return new Raw(arg1, arg2, arg3);
            }

            public static Raw copy$default(Raw arg0, int arg1, int arg2, long arg3, int arg5, Object arg6) {
                if((arg5 & 1) != 0) {
                    arg1 = arg0.dx;
                }

                if((arg5 & 2) != 0) {
                    arg2 = arg0.dy;
                }

                if((arg5 & 4) != 0) {
                    arg3 = arg0.timestamp;
                }

                return arg0.copy(arg1, arg2, arg3);
            }

            public boolean equals(Object arg6) {
                if(this == (((Raw)arg6))) {
                    return 1;
                }

                if(!(arg6 instanceof Raw)) {
                    return 0;
                }

                if(this.dx != ((Raw)arg6).dx) {
                    return 0;
                }

                if(this.dy != ((Raw)arg6).dy) {
                    return 0;
                }

                if(this.timestamp != ((Raw)arg6).timestamp) {
                    return 0;
                }

                return 1;
            }

            public final int getDx() {
                return this.dx;
            }

            public final int getDy() {
                return this.dy;
            }

            public final long getTimestamp() {
                return this.timestamp;
            }

            public int hashCode() {
                return (Integer.hashCode(this.dx) * 0x1F + Integer.hashCode(this.dy)) * 0x1F + Long.hashCode(this.timestamp);
            }

            public String toString() {
                return "Raw(dx=" + this.dx + ", dy=" + this.dy + ", timestamp=" + this.timestamp + ")";
            }
        }

        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$RawBarrier;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "completion", "Ljava/util/concurrent/CompletableFuture;", "", "<init>", "(Ljava/util/concurrent/CompletableFuture;)V", "getCompletion", "()Ljava/util/concurrent/CompletableFuture;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RawBarrier extends Command {
            public static final int $stable = 8;
            private final CompletableFuture completion;

            static {
            }

            public RawBarrier(CompletableFuture arg2) {
                Intrinsics.checkNotNullParameter(arg2, "completion");
                super(null);
                this.completion = arg2;
            }

            public final CompletableFuture component1() {
                return this.completion;
            }

            public final RawBarrier copy(CompletableFuture arg1) {
                Intrinsics.checkNotNullParameter(arg1, "completion");
                return new RawBarrier(arg1);
            }

            public static RawBarrier copy$default(RawBarrier arg0, CompletableFuture arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.completion;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((RawBarrier)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof RawBarrier)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.completion, ((RawBarrier)arg4).completion)) {
                    return 0;
                }

                return 1;
            }

            public final CompletableFuture getCompletion() {
                return this.completion;
            }

            public int hashCode() {
                return this.completion.hashCode();
            }

            public String toString() {
                return "RawBarrier(completion=" + this.completion + ")";
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Recoil;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "epoch", "", "<init>", "(J)V", "getEpoch", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Recoil extends Command {
            public static final int $stable;
            private final long epoch;

            static {
            }

            public Recoil(long arg2) {
                super(null);
                this.epoch = arg2;
            }

            public final long component1() {
                return this.epoch;
            }

            public final Recoil copy(long arg1) {
                return new Recoil(arg1);
            }

            public static Recoil copy$default(Recoil arg0, long arg1, int arg3, Object arg4) {
                if((arg3 & 1) != 0) {
                    arg1 = arg0.epoch;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg6) {
                if(this == (((Recoil)arg6))) {
                    return 1;
                }

                if(!(arg6 instanceof Recoil)) {
                    return 0;
                }

                if(this.epoch != ((Recoil)arg6).epoch) {
                    return 0;
                }

                return 1;
            }

            public final long getEpoch() {
                return this.epoch;
            }

            public int hashCode() {
                return Long.hashCode(this.epoch);
            }

            public String toString() {
                return "Recoil(epoch=" + this.epoch + ")";
            }
        }

        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Release;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Release extends Command {
            public static final int $stable;
            public static final Release INSTANCE;

            static {
                Release.INSTANCE = new Release();
            }

            private Release() {
                super(null);
            }

            public boolean equals(Object arg2) {
                if(this == (((Release)arg2))) {
                    return 1;
                }

                if(!(arg2 instanceof Release)) {
                    return 0;
                }

                return 1;
            }

            public int hashCode() {
                return 0x42D1FFD7;
            }

            public String toString() {
                return "Release";
            }
        }

        @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Reset;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "completion", "Ljava/util/concurrent/CompletableFuture;", "", "<init>", "(Ljava/util/concurrent/CompletableFuture;)V", "getCompletion", "()Ljava/util/concurrent/CompletableFuture;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Reset extends Command {
            public static final int $stable = 8;
            private final CompletableFuture completion;

            static {
            }

            public Reset(CompletableFuture arg2) {
                Intrinsics.checkNotNullParameter(arg2, "completion");
                super(null);
                this.completion = arg2;
            }

            public final CompletableFuture component1() {
                return this.completion;
            }

            public final Reset copy(CompletableFuture arg1) {
                Intrinsics.checkNotNullParameter(arg1, "completion");
                return new Reset(arg1);
            }

            public static Reset copy$default(Reset arg0, CompletableFuture arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.completion;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((Reset)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof Reset)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.completion, ((Reset)arg4).completion)) {
                    return 0;
                }

                return 1;
            }

            public final CompletableFuture getCompletion() {
                return this.completion;
            }

            public int hashCode() {
                return this.completion.hashCode();
            }

            public String toString() {
                return "Reset(completion=" + this.completion + ")";
            }
        }

        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command$Tick;", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Tick extends Command {
            public static final int $stable;
            public static final Tick INSTANCE;

            static {
                Tick.INSTANCE = new Tick();
            }

            private Tick() {
                super(null);
            }

            public boolean equals(Object arg2) {
                if(this == (((Tick)arg2))) {
                    return 1;
                }

                if(!(arg2 instanceof Tick)) {
                    return 0;
                }

                return 1;
            }

            public int hashCode() {
                return 0x11C90BCD;
            }

            public String toString() {
                return "Tick";
            }
        }

        private Command() {
            super();
        }

        public Command(DefaultConstructorMarker arg1) {
            this();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "MAX_POSTED_REPORTS", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÆ\u0003J\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Confirmation;", "", "request", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "revision", "", "completion", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "<init>", "(Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;JLjava/util/concurrent/CompletableFuture;)V", "getRequest", "()Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "getRevision", "()J", "getCompletion", "()Ljava/util/concurrent/CompletableFuture;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Confirmation {
        private final CompletableFuture completion;
        private final Request request;
        private final long revision;

        public Confirmation(Request arg2, long arg3, CompletableFuture arg5) {
            Intrinsics.checkNotNullParameter(arg2, "request");
            Intrinsics.checkNotNullParameter(arg5, "completion");
            super();
            this.request = arg2;
            this.revision = arg3;
            this.completion = arg5;
        }

        public final Request component1() {
            return this.request;
        }

        public final long component2() {
            return this.revision;
        }

        public final CompletableFuture component3() {
            return this.completion;
        }

        public final Confirmation copy(Request arg1, long arg2, CompletableFuture arg4) {
            Intrinsics.checkNotNullParameter(arg1, "request");
            Intrinsics.checkNotNullParameter(arg4, "completion");
            return new Confirmation(arg1, arg2, arg4);
        }

        public static Confirmation copy$default(Confirmation arg0, Request arg1, long arg2, CompletableFuture arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.request;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.revision;
            }

            if((arg5 & 4) != 0) {
                arg4 = arg0.completion;
            }

            return arg0.copy(arg1, arg2, arg4);
        }

        public boolean equals(Object arg8) {
            if(this == (((Confirmation)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Confirmation)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.request, ((Confirmation)arg8).request)) {
                return 0;
            }

            if(this.revision != ((Confirmation)arg8).revision) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.completion, ((Confirmation)arg8).completion)) {
                return 0;
            }

            return 1;
        }

        public final CompletableFuture getCompletion() {
            return this.completion;
        }

        public final Request getRequest() {
            return this.request;
        }

        public final long getRevision() {
            return this.revision;
        }

        public int hashCode() {
            return (this.request.hashCode() * 0x1F + Long.hashCode(this.revision)) * 0x1F + this.completion.hashCode();
        }

        public String toString() {
            return "Confirmation(request=" + this.request + ", revision=" + this.revision + ", completion=" + this.completion + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Failure;", "", "session", "", "revision", "reason", "", "<init>", "(JJLjava/lang/String;)V", "getSession", "()J", "getRevision", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Failure {
        public static final int $stable;
        private final String reason;
        private final long revision;
        private final long session;

        static {
        }

        public Failure(long arg2, long arg4, String arg6) {
            Intrinsics.checkNotNullParameter(arg6, "reason");
            super();
            this.session = arg2;
            this.revision = arg4;
            this.reason = arg6;
        }

        public final long component1() {
            return this.session;
        }

        public final long component2() {
            return this.revision;
        }

        public final String component3() {
            return this.reason;
        }

        public final Failure copy(long arg7, long arg9, String arg11) {
            Intrinsics.checkNotNullParameter(arg11, "reason");
            return new Failure(arg7, arg9, arg11);
        }

        public static Failure copy$default(Failure arg6, long arg7, long arg9, String arg11, int arg12, Object arg13) {
            if((arg12 & 1) != 0) {
                arg7 = arg6.session;
            }

            long v1 = arg7;
            if((arg12 & 2) != 0) {
                arg9 = arg6.revision;
            }

            long v3 = arg9;
            if((arg12 & 4) != 0) {
                arg11 = arg6.reason;
            }

            return arg6.copy(v1, v3, arg11);
        }

        public boolean equals(Object arg8) {
            if(this == (((Failure)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Failure)) {
                return 0;
            }

            if(this.session != ((Failure)arg8).session) {
                return 0;
            }

            if(this.revision != ((Failure)arg8).revision) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.reason, ((Failure)arg8).reason)) {
                return 0;
            }

            return 1;
        }

        public final String getReason() {
            return this.reason;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final long getSession() {
            return this.session;
        }

        public int hashCode() {
            return (Long.hashCode(this.session) * 0x1F + Long.hashCode(this.revision)) * 0x1F + this.reason.hashCode();
        }

        public String toString() {
            return "Failure(session=" + this.session + ", revision=" + this.revision + ", reason=" + this.reason + ")";
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J1\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Queued;", "", "session", "", "revision", "command", "Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "queuedAtNanos", "<init>", "(JJLcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;J)V", "getSession", "()J", "getRevision", "getCommand", "()Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$Command;", "getQueuedAtNanos", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Queued {
        private final Command command;
        private final long queuedAtNanos;
        private final long revision;
        private final long session;

        public Queued(long arg2, long arg4, Command arg6, long arg7) {
            Intrinsics.checkNotNullParameter(arg6, "command");
            super();
            this.session = arg2;
            this.revision = arg4;
            this.command = arg6;
            this.queuedAtNanos = arg7;
        }

        public final long component1() {
            return this.session;
        }

        public final long component2() {
            return this.revision;
        }

        public final Command component3() {
            return this.command;
        }

        public final long component4() {
            return this.queuedAtNanos;
        }

        public final Queued copy(long arg9, long arg11, Command arg13, long arg14) {
            Intrinsics.checkNotNullParameter(arg13, "command");
            return new Queued(arg9, arg11, arg13, arg14);
        }

        public static Queued copy$default(Queued arg8, long arg9, long arg11, Command arg13, long arg14, int arg16, Object arg17) {
            if((arg16 & 1) != 0) {
                arg9 = arg8.session;
            }

            long v1 = arg9;
            if((arg16 & 2) != 0) {
                arg11 = arg8.revision;
            }

            long v3 = arg11;
            if((arg16 & 4) != 0) {
                arg13 = arg8.command;
            }

            Command v5 = arg13;
            if((arg16 & 8) != 0) {
                arg14 = arg8.queuedAtNanos;
            }

            return arg8.copy(v1, v3, v5, arg14);
        }

        public boolean equals(Object arg8) {
            if(this == (((Queued)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Queued)) {
                return 0;
            }

            if(this.session != ((Queued)arg8).session) {
                return 0;
            }

            if(this.revision != ((Queued)arg8).revision) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.command, ((Queued)arg8).command)) {
                return 0;
            }

            if(this.queuedAtNanos != ((Queued)arg8).queuedAtNanos) {
                return 0;
            }

            return 1;
        }

        public final Command getCommand() {
            return this.command;
        }

        public final long getQueuedAtNanos() {
            return this.queuedAtNanos;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final long getSession() {
            return this.session;
        }

        public int hashCode() {
            return ((Long.hashCode(this.session) * 0x1F + Long.hashCode(this.revision)) * 0x1F + this.command.hashCode()) * 0x1F + Long.hashCode(this.queuedAtNanos);
        }

        public String toString() {
            return "Queued(session=" + this.session + ", revision=" + this.revision + ", command=" + this.command + ", queuedAtNanos=" + this.queuedAtNanos + ")";
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimTouchDispatcher$StaleContact;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class StaleContact extends IllegalStateException {
        public StaleContact() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int MAX_POSTED_REPORTS = 0x1000;
    private static final String TAG = "GOLDEN_GG_CAMERA";
    private boolean activatePending;
    private long activatedAtNanos;
    private FpsCameraKernel activeKernel;
    private volatile boolean aimEnabled;
    private final ArrayDeque buttons;
    private volatile boolean cameraContactPresent;
    private volatile long cameraRevision;
    private final ExactRawCoalescer coalescer;
    private Confirmation confirmation;
    private long dispatchRevision;
    private Failure failurePending;
    private final FireAimCoordinator fireAimCoordinator;
    private final FpsCameraEngine fpsCameraEngine;
    private final Object lock;
    private final FpsPipelineMetrics metrics;
    private boolean mouseDown;
    private MouseDrag mouseDrag;
    private final Function1 onFailure;
    private long rawAcceptedSince;
    private final ArrayDeque rawBarriers;
    private boolean rawSuspended;
    private final RecoilCoordinator recoil;
    private volatile Function0 recoilAuthorization;
    private boolean recoilYieldToRaw;
    private boolean releasePending;
    private final ArrayDeque reports;
    private final ArrayDeque resets;
    private volatile boolean running;
    private volatile long sessionId;
    private final TouchInjector touchInjector;
    private Thread worker;

    public static void $r8$lambda$hZOxKV6qtv21SMU66bDUQ2XCh7M(AimTouchDispatcher arg0) {
        arg0.runLoop();
    }

    static {
        AimTouchDispatcher.Companion = new Companion(null);
        AimTouchDispatcher.$stable = 8;
    }

    public AimTouchDispatcher() {
        this(null, null, null, null, 15, null);
    }

    public AimTouchDispatcher(TouchInjector arg8, FpsCameraEngine arg9, FireAimCoordinator arg10, Function1 arg11, int arg12, DefaultConstructorMarker arg13) {
        AimTouchDispatcher$$ExternalSyntheticLambda2 v11;
        InjectionBackend v0 = null;
        if((arg12 & 1) != 0) {
            arg8 = new TouchInjector(v0, ((Function0)v0), 3, ((DefaultConstructorMarker)v0));
        }

        if((arg12 & 2) != 0) {
            arg9 = new FpsCameraEngine(((Function0)v0), 1, ((DefaultConstructorMarker)v0));
        }

        if((arg12 & 4) != 0) {
            arg10 = new FireAimCoordinator(0, null, null, 7, null);
        }

        if((arg12 & 8) != 0) {
            v11 = new AimTouchDispatcher$$ExternalSyntheticLambda2();
        }

        this(arg8, arg9, arg10, ((Function1)v11));
    }

    public AimTouchDispatcher(TouchInjector arg2, FpsCameraEngine arg3, FireAimCoordinator arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg2, "touchInjector");
        Intrinsics.checkNotNullParameter(arg3, "fpsCameraEngine");
        Intrinsics.checkNotNullParameter(arg4, "fireAimCoordinator");
        Intrinsics.checkNotNullParameter(arg5, "onFailure");
        super();
        this.touchInjector = arg2;
        this.fpsCameraEngine = arg3;
        this.fireAimCoordinator = arg4;
        this.onFailure = arg5;
        this.lock = new Object();
        this.metrics = new FpsPipelineMetrics();
        this.coalescer = new ExactRawCoalescer();
        this.reports = new ArrayDeque();
        this.buttons = new ArrayDeque();
        this.resets = new ArrayDeque();
        this.rawBarriers = new ArrayDeque();
        this.recoil = new RecoilCoordinator();
        this.recoilAuthorization = new AimTouchDispatcher$$ExternalSyntheticLambda3();
        this.dispatchRevision = -1;
        arg3.attachSink$app(new TouchSink() {
            public int down(int arg2, int arg3) {
                AimTouchDispatcher.access$requireCurrentContact(AimTouchDispatcher.this);
                boolean v2 = AimTouchDispatcher.access$getTouchInjector$p(AimTouchDispatcher.this).iniciarFPSPixels(((float)arg2), ((float)arg3));
                CameraDiagnostics.INSTANCE.contact("DOWN_CONFIRMED", v2);
                if(v2) {
                    AimTouchDispatcher.access$setCameraContactPresent$p(AimTouchDispatcher.this, true);
                    return 2;
                }

                throw new BackendFailure();
            }

            public void move(int arg1, int arg2, int arg3) {
                AimTouchDispatcher.access$requireCurrentContact(AimTouchDispatcher.this);
                boolean v0 = AimTouchDispatcher.access$getTouchInjector$p(AimTouchDispatcher.this).moveGgPixels$app(((float)arg2), ((float)arg3));
                CameraDiagnostics.INSTANCE.contact("MOVE_OFFER", v0);
                if(v0) {
                    return;
                }

                throw new BackendFailure();
            }

            public void up(int arg1, int arg2, int arg3) {
                boolean v1 = AimTouchDispatcher.access$getTouchInjector$p(AimTouchDispatcher.this).releasePixels(((float)arg2), ((float)arg3));
                CameraDiagnostics.INSTANCE.contact("UP_CONFIRMED", v1);
                if(v1) {
                    AimTouchDispatcher.access$setCameraContactPresent$p(AimTouchDispatcher.this, false);
                    return;
                }

                throw new BackendFailure();
            }
        });
    }

    static final Unit _init_$lambda$0(Failure arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public static final TouchInjector access$getTouchInjector$p(AimTouchDispatcher arg0) {
        return arg0.touchInjector;
    }

    public static final void access$requireCurrentContact(AimTouchDispatcher arg0) {
        arg0.requireCurrentContact();
    }

    public static final void access$setCameraContactPresent$p(AimTouchDispatcher arg0, boolean arg1) {
        arg0.cameraContactPresent = arg1;
    }

    private final void cancelRawBarriers() {
        Iterator v0 = this.rawBarriers.iterator();
        while(v0.hasNext()) {
            Command v1 = v0.next().getCommand();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.aim.AimTouchDispatcher.Command.RawBarrier");
            ((RawBarrier)v1).getCompletion().complete(Boolean.valueOf(false));
        }

        this.rawBarriers.clear();
    }

    public final void cancelRecoil() {
        this.recoil.cancel();
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.lock.notifyAll();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    private final void clearReports() {
        GgPerformanceDiagnostics.INSTANCE.cleared(this.reports.size());
        this.reports.clear();
        this.coalescer.discardPending();
        this.reportQueue();
        this.metrics.backlog(0, 0, 0);
    }

    public final void configurePolling$app(MousePollingSelection arg5) {
        Mode v5;
        String v0 = "GG FPS admite 125, 250, 500 Hz o Nativo (sin límite); no admite ";
        Intrinsics.checkNotNullParameter(arg5, "selection");
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            int v2 = arg5.getHz();
            if(v2 == 0) {
                v5 = Mode.NO_LIMIT;
            }
            else if(v2 == 0x7D) {
                v5 = Mode.RATE_125HZ;
            }
            else if(v2 == 0xFA) {
                v5 = Mode.RATE_250HZ;
            }
            else if(v2 == 500) {
                v5 = Mode.RATE_500HZ;
            }
            else {
                throw new IllegalStateException(v0 + arg5.getHz() + " Hz".toString());
            }

            this.coalescer.configure(v5);
        }
        catch(Throwable v4) {
            __monitor_exit(v1);
            throw v4;
        }

        __monitor_exit(v1);
    }

    public final void configureRecoil(RecoilSettings arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "settings");
        Intrinsics.checkNotNullParameter(arg3, "authorized");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.recoilAuthorization = arg3;
            this.recoil.configure(arg2);
            this.lock.notifyAll();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public final boolean confirmTransition$app(Request arg6, CompletableFuture arg7, Function0 arg8) {
        boolean v5_1;
        Intrinsics.checkNotNullParameter(arg6, "request");
        Intrinsics.checkNotNullParameter(arg7, "completion");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.running || arg6.getSessionId() != this.sessionId) {
                long v1 = this.cameraRevision;
                Status v5_2 = this.running ? Status.STALE : Status.CANCELLED;
                arg7.complete(new Result(arg6, v1, v5_2));
                v5_1 = false;
            }
            else {
                arg8.invoke();
                this.confirmation = new Confirmation(arg6, this.cameraRevision, arg7);
                this.lock.notifyAll();
                v5_1 = true;
            }
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
        return v5_1;
    }

    private final boolean current(Queued arg5) {
        if((this.running) && (this.aimEnabled) && (this.fpsCameraEngine.getHasValidAnchor()) && arg5.getSession() == this.sessionId && arg5.getRevision() == this.cameraRevision) {
            return 1;
        }

        return 0;
    }

    public final void engageAtCenter(float arg3, float arg4, Long arg5) {
        Object v3 = this.lock;
        __monitor_enter(v3);
        try {
            if((this.running) && (this.aimEnabled) && (this.fpsCameraEngine.getHasValidAnchor()) && (arg5 == null || arg5.longValue() == this.sessionId)) {
                this.activatePending = true;
                this.lock.notifyAll();
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v3);
            throw v2;
        }

        __monitor_exit(v3);
    }

    public static void engageAtCenter$default(AimTouchDispatcher arg0, float arg1, float arg2, Long arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.engageAtCenter(arg1, arg2, arg3);
    }

    private final void finish(Queued arg7, boolean arg8) {
        Status v7;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            Confirmation v1 = this.confirmation;
            if(v1 == null) {
            }
            else if(v1.getRevision() == arg7.getRevision()) {
                if(!Intrinsics.areEqual(arg7.getCommand(), Activate.INSTANCE) && !Intrinsics.areEqual(arg7.getCommand(), Release.INSTANCE)) {
                    goto label_40;
                }

                if(v1.getRequest().getActive() != Intrinsics.areEqual(arg7.getCommand(), Activate.INSTANCE)) {
                    goto label_40;
                }

                if(!this.running) {
                    v7 = Status.CANCELLED;
                }
                else {
                    if(arg7.getSession() == this.sessionId) {
                        if(arg7.getRevision() != this.cameraRevision) {
                        }
                        else {
                            v7 = !arg8 ? Status.FAILED : Status.COMPLETED;
                            goto label_39;
                        }
                    }

                    v7 = Status.STALE;
                }

            label_39:
                this.invalidate(v7);
            }

        label_40:
        }
        catch(Throwable v6) {
            __monitor_exit(v0);
            throw v6;
        }

        __monitor_exit(v0);
    }

    public final FpsPipelineMetrics getMetrics$app() {
        return this.metrics;
    }

    public final MousePollingSelection getPollingSelection$app() {
        MousePollingSelection v1;
        int v7_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            long v2 = this.coalescer.intervalNanos;
            if(Long.compare(v2, 8000000) == 0) {
                v7_1 = 0x7D;
            }
            else if(v2 == 4000000) {
                v7_1 = 0xFA;
            }
            else if(v2 == 2000000) {
                v7_1 = 500;
            }
            else {
                v7_1 = 0;
            }

            v1 = new MousePollingSelection(v7_1, false, 2, null);
        }
        catch(Throwable v7) {
            __monitor_exit(v0);
            throw v7;
        }

        __monitor_exit(v0);
        return v1;
    }

    private final void invalidate(Status arg7) {
        Confirmation v0 = this.confirmation;
        if(v0 != null) {
            v0.getCompletion().complete(new Result(v0.getRequest(), v0.getRevision(), arg7));
        }

        this.confirmation = null;
    }

    public final boolean isFailureCurrent(Failure arg5) {
        Intrinsics.checkNotNullParameter(arg5, "failure");
        if((this.running) && !this.aimEnabled && arg5.getSession() == this.sessionId && arg5.getRevision() == this.cameraRevision) {
            return 1;
        }

        return 0;
    }

    public final boolean isTransitionCurrent$app(Result arg5) {
        Intrinsics.checkNotNullParameter(arg5, "result");
        if(arg5.getStatus() == Status.COMPLETED && (this.running) && arg5.getRequest().getSessionId() == this.sessionId && arg5.getCameraRevision() == this.cameraRevision && arg5.getRequest().getActive() == this.aimEnabled) {
            return 1;
        }

        return 0;
    }

    public final void observeRecoilButton(boolean arg13, boolean arg14, long arg15, long arg17) {
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            RecoilCoordinator v2 = this.recoil;
            arg14 = !arg14 || !this.running || !this.aimEnabled || arg15 != this.sessionId || arg17 - this.activatedAtNanos < 0 ? false : true;
            v2.observeButton(arg13, arg14, this.sessionId, this.cameraRevision, this.cameraContactPresent, System.nanoTime());
            this.lock.notifyAll();
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
    }

    public static void observeRecoilButton$default(AimTouchDispatcher arg7, boolean arg8, boolean arg9, long arg10, long arg12, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg12 = System.nanoTime();
        }

        arg7.observeRecoilButton(arg8, arg9, arg10, arg12);
    }

    public final void offerDelta(int arg14, int arg15, Long arg16, long arg17) {
        Object v12 = this.lock;
        __monitor_enter(v12);
        try {
            if((this.running) && (this.aimEnabled) && (arg16 == null || arg16.longValue() == this.sessionId) && !this.rawSuspended) {
                long v1 = this.rawAcceptedSince;
                long v3 = 0;
                if(v1 != v3 && arg17 - v1 < v3) {
                    goto label_46;
                }

                if(arg17 - this.activatedAtNanos < v3) {
                    CameraDiagnostics.INSTANCE.reject(Rejection.STALE_COMMAND);
                    goto label_46;
                }

                this.metrics.offered(arg17, ((long)this.reports.size()), ((long)arg14), ((long)arg15), arg14, arg15);
                this.coalescer.accept(arg14, arg15, System.nanoTime(), new AimTouchDispatcher$$ExternalSyntheticLambda0(this, arg17));
                this.reportQueue();
                this.lock.notifyAll();
            }

        label_46:
        }
        catch(Throwable v0) {
            __monitor_exit(v12);
            throw v0;
        }

        __monitor_exit(v12);
    }

    public static void offerDelta$default(AimTouchDispatcher arg6, int arg7, int arg8, Long arg9, long arg10, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg9 = null;
        }

        Long v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = System.nanoTime();
        }

        arg6.offerDelta(arg7, arg8, v3, arg10);
    }

    static final void offerDelta$lambda$14$lambda$13(AimTouchDispatcher arg8, long arg9, LinkedList arg11) {
        if(arg8.reports.size() >= 0x1000) {
            GgPerformanceDiagnostics.INSTANCE.overflow();
            arg8.aimEnabled = false;
            ++arg8.cameraRevision;
            arg8.activatePending = false;
            arg8.releasePending = true;
            arg8.invalidate(Status.FAILED);
            arg8.clearReports();
            Failure v0 = new Failure(arg8.sessionId, arg8.cameraRevision, "Cámara GG suspendida: cola táctil bloqueada");
            arg8.failurePending = v0;
            Log.e("GOLDEN_GG_CAMERA", v0.getReason());
            return;
        }

        Iterator v11 = arg11.iterator();
        Intrinsics.checkNotNullExpressionValue(v11, "iterator(...)");
        while(v11.hasNext()) {
            Object v0_1 = v11.next();
            Queued v0_2 = arg8.queued(new Raw(((Motion)v0_1).x, ((Motion)v0_1).y, arg9));
            arg8.reports.addLast(v0_2);
            GgPerformanceDiagnostics v2 = GgPerformanceDiagnostics.INSTANCE;
            int v3 = arg8.reports.size();
            Object v1 = arg8.reports.peekFirst();
            long v4 = v1 != null ? ((Queued)v1).getQueuedAtNanos() : 0;
            v2.enqueued(v3, v4, v0_2.getQueuedAtNanos());
        }
    }

    public final void offerMouseButton(boolean arg4, float arg5, float arg6) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.running) {
                this.mouseDown = arg4;
                if(!arg4) {
                    this.mouseDrag = null;
                }

                this.buttons.addLast(new MouseButton(arg4, arg5, arg6));
                this.lock.notifyAll();
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
    }

    public final void offerMouseDrag(float arg3, float arg4) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.running) {
                if(!this.mouseDown) {
                }
                else {
                    this.mouseDrag = new MouseDrag(arg3, arg4);
                    this.lock.notifyAll();
                }
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    private final Queued queued(Command arg9) {
        long v1 = this.sessionId;
        long v3 = this.cameraRevision;
        long v5 = (arg9 instanceof Raw) ? GgPerformanceDiagnostics.INSTANCE.start() : 0;
        return new Queued(v1, v3, arg9, v5);
    }

    static final boolean recoilAuthorization$lambda$1() {
        return 0;
    }

    private final boolean releaseCamera() {
        Object v1_2;
        this.recoil.cancel();
        boolean v0 = false;
        this.cameraContactPresent = false;
        FpsCameraKernel v1 = this.activeKernel;
        this.activeKernel = null;
        try {
            if(v1 != null) {
                v1.stop();
            }

            v1_2 = kotlin.Result.constructor-impl(Boolean.valueOf(true));
        }
        catch(Throwable v1_1) {
            v1_2 = kotlin.Result.constructor-impl(ResultKt.createFailure(v1_1));
        }

        Boolean v3 = Boolean.valueOf(false);
        if(kotlin.Result.isFailure-impl(v1_2)) {
            Boolean v1_3 = v3;
        }

        boolean v1_4 = ((Boolean)v1_2).booleanValue();
        if((this.touchInjector.releaseActive()) && (v1_4)) {
            v0 = true;
        }

        return v0;
    }

    private final void reportQueue() {
        FpsPipelineMetrics v0 = this.metrics;
        int v1 = this.reports.size();
        Object v4 = this.reports.peekFirst();
        Command v2 = null;
        Command v4_1 = v4 != null ? ((Queued)v4).getCommand() : v2;
        if((v4_1 instanceof Raw)) {
            v2 = v4_1;
        }

        long v2_1 = v2 != null ? ((Raw)v2).getTimestamp() : 0;
        v0.queue(v1, v2_1);
    }

    private final void requireCurrentContact() {
        if((this.running) && (this.aimEnabled) && this.dispatchRevision == this.cameraRevision) {
            return;
        }

        throw new StaleContact();
    }

    public final boolean resetSession(long arg5) {
        Boolean v4_2;
        Object v4_1;
        CompletableFuture v0 = new CompletableFuture();
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            this.recoil.cancel();
            this.sessionId = arg5;
            ++this.cameraRevision;
            this.aimEnabled = false;
            this.activatePending = false;
            this.releasePending = false;
            this.invalidate(Status.CANCELLED);
            this.failurePending = null;
            this.clearReports();
            this.buttons.clear();
            this.mouseDrag = null;
            this.mouseDown = false;
            this.rawSuspended = false;
            this.rawAcceptedSince = 0;
            this.cancelRawBarriers();
            this.fireAimCoordinator.onFireUp();
            if(this.running) {
                goto label_35;
            }
        }
        catch(Throwable v4) {
            goto label_58;
        }

        __monitor_exit(v1);
        return 1;
        try {
        label_35:
            this.resets.addLast(v0);
            this.lock.notifyAll();
        }
        catch(Throwable v4) {
        label_58:
            __monitor_exit(v1);
            throw v4;
        }

        __monitor_exit(v1);
        try {
            v4_1 = kotlin.Result.constructor-impl(v0.get(2, TimeUnit.SECONDS));
        }
        catch(Throwable v4) {
            v4_1 = kotlin.Result.constructor-impl(ResultKt.createFailure(v4));
        }

        Boolean v5 = Boolean.valueOf(false);
        if(kotlin.Result.isFailure-impl(v4_1)) {
            v4_2 = v5;
        }

        return v4_2.booleanValue();
    }

    public final boolean resumeRawFromFreeLook$app(long arg6) {
        boolean v2;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v2 = false;
            if(this.running) {
                if(arg6 != this.sessionId) {
                }
                else {
                    this.clearReports();
                    this.rawAcceptedSince = System.nanoTime();
                    this.rawSuspended = false;
                    this.lock.notifyAll();
                    v2 = true;
                }
            }
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
        return v2;
    }

    private final void runLoop() {
        Object v7_2;
        FpsCameraKernel v0_6;
        boolean v7;
        Object v0_3;
        boolean v6;
        long v13;
        Command v5;
        Iterator v0_1;
        Object v4_1;
        Queued v4;
        Thread v2;
        AimTouchDispatcher v1 = this;
        while(true) {
            v2 = null;
            try {
                v4 = v1.takeNext();
                if(v4 != null) {
                    goto label_50;
                }
            }
            catch(Throwable v0) {
                goto label_328;
            }

            try {
                kotlin.Result.constructor-impl(Boolean.valueOf(v1.releaseCamera()));
            }
            catch(Throwable v0) {
                kotlin.Result.constructor-impl(ResultKt.createFailure(v0));
            }

            try {
                kotlin.Result.constructor-impl(Boolean.valueOf(v1.touchInjector.releaseAllActive()));
            }
            catch(Throwable v0) {
                kotlin.Result.constructor-impl(ResultKt.createFailure(v0));
            }

            v4_1 = v1.lock;
            __monitor_enter(v4_1);
            try {
                v1.running = false;
                v1.clearReports();
                v1.invalidate(Status.CANCELLED);
                v0_1 = v1.resets.iterator();
                break;
            }
            catch(Throwable v0) {
                goto label_48;
            }

            try {
            label_50:
                v5 = v4.getCommand();
                if((((v5 instanceof Raw)) || (Intrinsics.areEqual(v5, Activate.INSTANCE)) || (Intrinsics.areEqual(v5, Tick.INSTANCE)) || ((v5 instanceof Recoil))) && !v1.current(v4)) {
                    if(!(v5 instanceof Raw)) {
                        continue;
                    }

                    GgPerformanceDiagnostics.INSTANCE.stale();
                    continue;
                }

                v1.dispatchRevision = v4.getRevision();
                v13 = System.nanoTime();
                v6 = true;
                try {
                    if(!(v5 instanceof Failed)) {
                        goto label_97;
                    }

                    if(!v1.isFailureCurrent(v5.getFailure())) {
                        goto label_304;
                    }
                }
                catch(Exception v0_2) {
                    goto label_252;
                }
                catch(StaleContact ) {
                    goto label_302;
                }
            }
            catch(Throwable v0) {
                goto label_328;
            }

            try {
                v1.onFailure.invoke(v5.getFailure());
                v0_3 = kotlin.Result.constructor-impl(Unit.INSTANCE);
                goto label_91;
            }
            catch(Throwable v0) {
                try {
                    v0_3 = kotlin.Result.constructor-impl(ResultKt.createFailure(v0));
                label_91:
                    v0 = kotlin.Result.exceptionOrNull-impl(v0_3);
                    if(v0 == null) {
                        goto label_304;
                    }

                    Log.e("GOLDEN_GG_CAMERA", "No se pudo publicar el fallo de cámara", v0);
                    goto label_304;
                label_97:
                    if((v5 instanceof RawBarrier)) {
                        CompletableFuture v0_4 = v5.getCompletion();
                        v7 = !v1.current(v4) || !v1.rawSuspended ? false : true;
                        v0_4.complete(Boolean.valueOf(v7));
                        goto label_304;
                    }

                    if((v5 instanceof Reset)) {
                        boolean v0_5 = v1.releaseCamera();
                        v7 = v1.touchInjector.releaseAllActive();
                        v0_5 = !v0_5 || !v7 ? false : true;
                        v5.getCompletion().complete(Boolean.valueOf(v0_5));
                        v6 = v0_5;
                        goto label_304;
                    }

                    if(Intrinsics.areEqual(v5, Release.INSTANCE)) {
                        v6 = v1.releaseCamera();
                        goto label_304;
                    }

                    if(Intrinsics.areEqual(v5, Activate.INSTANCE)) {
                        if(v1.releaseCamera()) {
                            if(!v1.current(v4)) {
                                goto label_303;
                            }

                            v0_6 = v1.fpsCameraEngine.dispatchKernel$app();
                            v1.activeKernel = v0_6;
                            if(v0_6 != null) {
                                v0_6.start(System.currentTimeMillis());
                            }

                            if(v1.activeKernel == null) {
                                goto label_303;
                            }

                            goto label_304;
                        }

                        throw new BackendFailure();
                    }

                    if(Intrinsics.areEqual(v5, Tick.INSTANCE)) {
                        v0_6 = v1.activeKernel;
                        if(v0_6 == null) {
                            goto label_304;
                        }

                        v0_6.tick(System.currentTimeMillis());
                        goto label_304;
                    }

                    if(!(v5 instanceof Recoil)) {
                        goto label_199;
                    }

                    v0_6 = v1.activeKernel;
                }
                catch(Throwable v0) {
                    goto label_328;
                }
                catch(Exception v0_2) {
                    goto label_252;
                }
                catch(StaleContact ) {
                    goto label_302;
                }
            }

            RecoilCoordinator v15 = v1.recoil;
            if(v0_6 != null) {
                goto label_166;
            }

            try {
                v15.cancel();
                goto label_304;
            label_166:
                Step v26 = v15.step(v5.getEpoch(), v1.recoilAuthorization.invoke().booleanValue(), v4.getSession(), v4.getRevision(), System.nanoTime());
                if(v26 == null) {
                    goto label_304;
                }

                int v7_1 = v1.fpsCameraEngine.recoilVerticalDelta$app(v26.getDelta().getVertical());
                if(!v1.current(v4)) {
                    goto label_304;
                }

                if(!v1.recoil.current(v26, v1.recoilAuthorization.invoke().booleanValue(), v1.sessionId, v1.cameraRevision, System.nanoTime())) {
                    goto label_304;
                }

                v0_6.moveIntegers(v26.getDelta().getHorizontal(), v7_1, System.currentTimeMillis());
                goto label_304;
            label_199:
                if((v5 instanceof Raw)) {
                    GgPerformanceDiagnostics.INSTANCE.processed();
                    Pair v0_7 = v1.fireAimCoordinator.filterCameraDelta(v5.getDx(), v5.getDy());
                    v7_1 = v0_7.component1().intValue();
                    int v0_8 = v0_7.component2().intValue();
                    v1.metrics.stepped(v5.getTimestamp(), 1, v13);
                    FpsCameraKernel v8 = v1.activeKernel;
                    if(v8 != null) {
                        v1.fpsCameraEngine.applySensitivityTo$app(v8);
                        v8.acceptRaw(v7_1, v0_8, System.currentTimeMillis());
                    }

                    InputPipelineDiagnostics.INSTANCE.count(Stage.QUEUED);
                    goto label_304;
                }

                if((v5 instanceof MouseButton)) {
                    v6 = v1.touchInjector.mouseButtonPixels(v5.getPressed(), v5.getX(), v5.getY());
                    goto label_304;
                }

                if((v5 instanceof MouseDrag)) {
                    v6 = v1.touchInjector.mouseMovePixels(v5.getX(), v5.getY());
                    goto label_304;
                }

                throw new NoWhenBranchMatchedException();
            }
            catch(Throwable v0) {
            }
            catch(Exception v0_2) {
                try {
                label_252:
                    Log.e("GOLDEN_GG_CAMERA", "Fallo de contacto GG", v0_2);
                    v7_2 = v1.lock;
                    __monitor_enter(v7_2);
                }
                catch(Throwable v0) {
                    goto label_328;
                }

                try {
                    if(v4.getRevision() == v1.cameraRevision) {
                        v1.aimEnabled = false;
                        ++v1.cameraRevision;
                        v1.activatePending = false;
                        v1.releasePending = v6;
                        v1.invalidate(Status.FAILED);
                        v1.clearReports();
                        long v8_1 = v1.sessionId;
                        long v10 = v1.cameraRevision;
                        String v0_9 = v0_2.getMessage();
                        if(v0_9 == null) {
                            v0_9 = "Fallo de cámara GG";
                        }

                        v1.failurePending = new Failure(v8_1, v10, v0_9);
                        v1.lock.notifyAll();
                    }

                    goto label_285;
                }
                catch(Throwable v0) {
                    try {
                        __monitor_exit(v7_2);
                        throw v0;
                    label_285:
                        __monitor_exit(v7_2);
                        if((v5 instanceof Reset)) {
                            v5.getCompletion().complete(Boolean.valueOf(false));
                        }

                        if((v5 instanceof RawBarrier)) {
                            v5.getCompletion().complete(Boolean.valueOf(false));
                        }

                    label_303:
                        v6 = false;
                    label_304:
                        if(v1.recoil.getRunning()) {
                            v1.recoil.observeContact(v1.cameraContactPresent);
                        }

                        if((((v5 instanceof Raw)) || (Intrinsics.areEqual(v5, Tick.INSTANCE)) || ((v5 instanceof Recoil))) && !v1.current(v4)) {
                            v1.releaseCamera();
                        }

                        v1.finish(v4, v6);
                        v1.metrics.dispatched(v13, System.nanoTime());
                        v1.metrics.reportIfDue();
                        continue;
                    }
                    catch(Throwable v0) {
                    label_328:
                        Throwable v4_2 = v0;
                        try {
                            kotlin.Result.constructor-impl(Boolean.valueOf(v1.releaseCamera()));
                        }
                        catch(Throwable v0) {
                            kotlin.Result.constructor-impl(ResultKt.createFailure(v0));
                        }

                        try {
                            kotlin.Result.constructor-impl(Boolean.valueOf(v1.touchInjector.releaseAllActive()));
                        }
                        catch(Throwable v0) {
                            kotlin.Result.constructor-impl(ResultKt.createFailure(v0));
                        }

                        Object v5_1 = v1.lock;
                        __monitor_enter(v5_1);
                        try {
                            v1.running = false;
                            v1.clearReports();
                            v1.invalidate(Status.CANCELLED);
                            v0_1 = v1.resets.iterator();
                            while(v0_1.hasNext()) {
                                v0_1.next().complete(Boolean.valueOf(false));
                            }

                            v1.resets.clear();
                            v1.cancelRawBarriers();
                            v1.worker = v2;
                        }
                        catch(Throwable v0) {
                            goto label_370;
                        }

                        __monitor_exit(v5_1);
                        throw v4_2;
                    label_370:
                        __monitor_exit(v5_1);
                        throw v0;
                    }
                }
            }
            catch(StaleContact ) {
                try {
                label_302:
                    v1.releaseCamera();
                    goto label_303;
                }
                catch(Throwable v0) {
                    goto label_328;
                }
            }
        }

        try {
            while(v0_1.hasNext()) {
                v0_1.next().complete(Boolean.valueOf(false));
            }

            v1.resets.clear();
            v1.cancelRawBarriers();
            v1.worker = v2;
        }
        catch(Throwable v0) {
            goto label_48;
        }

        __monitor_exit(v4_1);
        return;
    label_48:
        __monitor_exit(v4_1);
        throw v0;
    }

    public final void setAimEnabled(boolean arg7) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.aimEnabled != arg7) {
                this.recoil.cancel();
                this.aimEnabled = arg7;
                ++this.cameraRevision;
                this.failurePending = null;
                if(arg7) {
                    this.activatedAtNanos = System.nanoTime();
                }

                this.invalidate(Status.STALE);
                CameraDiagnostics.INSTANCE.context(this.sessionId, this.cameraRevision);
                this.clearReports();
                if(!arg7) {
                    this.activatePending = false;
                    this.releasePending = true;
                }

                this.lock.notifyAll();
            }
        }
        catch(Throwable v6) {
            __monitor_exit(v0);
            throw v6;
        }

        __monitor_exit(v0);
    }

    public final void start() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.running) {
                Thread v1 = this.worker;
                if(v1 != null && (v1.isAlive())) {
                    goto label_23;
                }

                this.running = true;
                ++this.cameraRevision;
                this.clearReports();
                v1 = new Thread(new AimTouchDispatcher$$ExternalSyntheticLambda1(this), "GoldenGgCamera");
                v1.start();
                this.worker = v1;
            }

        label_23:
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
    }

    public final void stop() {
        Thread v5_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.recoil.cancel();
            this.running = false;
            ++this.cameraRevision;
            this.clearReports();
            this.invalidate(Status.CANCELLED);
            this.lock.notifyAll();
            v5_1 = this.worker;
        }
        catch(Throwable v5) {
            __monitor_exit(v0);
            throw v5;
        }

        __monitor_exit(v0);
        if(v5_1 != Thread.currentThread() && v5_1 != null) {
            v5_1.join(2000);
        }
    }

    public final CompletableFuture suspendRawForFreeLook$app(long arg5) {
        CompletableFuture v1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = new CompletableFuture();
            if(!this.running || !this.aimEnabled || arg5 != this.sessionId) {
                v1.complete(Boolean.valueOf(false));
            }
            else {
                this.rawSuspended = true;
                this.clearReports();
                this.rawBarriers.addLast(this.queued(new RawBarrier(v1)));
                this.lock.notifyAll();
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        return v1;
    }

    private final Queued takeNext() {
        long v16;
        Object v2_1;
        Queued v3_2;
        Object v3_1;
        Failure v3;
        AimTouchDispatcher v0 = this;
        Object v1 = v0.lock;
        __monitor_enter(v1);
        try {
            while(true) {
                v3 = null;
                if(v0.running) {
                    if(!v0.resets.isEmpty()) {
                        v3_1 = v0.resets.removeFirst();
                        Intrinsics.checkNotNullExpressionValue(v3_1, "removeFirst(...)");
                        v3_2 = v0.queued(new Reset(((CompletableFuture)v3_1)));
                    }
                    else {
                        Failure v2 = v0.failurePending;
                        if(v2 != null) {
                            v0.failurePending = v3;
                            v3_2 = v0.queued(new Failed(v2));
                        }
                        else if(!v0.rawBarriers.isEmpty()) {
                            v3_1 = v0.rawBarriers.removeFirst();
                        }
                        else if(v0.releasePending) {
                            v0.releasePending = false;
                            v3_2 = v0.queued(Release.INSTANCE);
                        }
                        else if(!v0.buttons.isEmpty()) {
                            v2_1 = v0.buttons.removeFirst();
                            Intrinsics.checkNotNullExpressionValue(v2_1, "removeFirst(...)");
                            v3_2 = v0.queued(((Command)v2_1));
                        }
                        else {
                            MouseDrag v2_2 = v0.mouseDrag;
                            if(v2_2 != null) {
                                v0.mouseDrag = ((MouseDrag)v3);
                                v3_2 = v0.queued(((Command)v2_2));
                            }
                            else {
                                if(v0.aimEnabled) {
                                    if(v0.activatePending) {
                                        v0.activatePending = false;
                                        v3_2 = v0.queued(Activate.INSTANCE);
                                        break;
                                    }
                                    else {
                                        FpsCameraKernel v2_3 = v0.activeKernel;
                                        long v5 = 0x7FFFFFFFFFFFFFFFL;
                                        long v2_4 = v2_3 != null ? v2_3.nextTimerMillis() : v5;
                                        long v7 = System.currentTimeMillis();
                                        if(v2_4 <= v7) {
                                            v3_2 = v0.queued(Tick.INSTANCE);
                                            break;
                                        }

                                        long v9 = v0.recoil.getRunning() ? v0.recoil.nextWakeNanos(v0.recoilAuthorization.invoke().booleanValue(), v0.sessionId, v0.cameraRevision) : v5;
                                        int v11 = Long.compare(v9, v5);
                                        long v12 = 0;
                                        long v14 = v11 != 0 ? System.nanoTime() : v12;
                                        if(v11 == 0 || v9 > v14) {
                                            v16 = v5;
                                        }
                                        else {
                                            v16 = v5;
                                            if((v0.recoilYieldToRaw) && !v0.reports.isEmpty()) {
                                                goto label_106;
                                            }

                                            v0.recoilYieldToRaw = true;
                                            v3_2 = v0.queued(new Recoil(v0.recoil.getEpoch()));
                                            break;
                                        }

                                    label_106:
                                        if(!v0.reports.isEmpty()) {
                                            v2_1 = v0.reports.removeFirst();
                                            v0.recoilYieldToRaw = false;
                                            v0.reportQueue();
                                            GgPerformanceDiagnostics v5_1 = GgPerformanceDiagnostics.INSTANCE;
                                            long v6 = v2_1.getQueuedAtNanos();
                                            int v8 = v0.reports.size();
                                            Object v0_2 = v0.reports.peekFirst();
                                            if(v0_2 != null) {
                                                v12 = ((Queued)v0_2).getQueuedAtNanos();
                                            }

                                            v5_1.dequeued(v6, v8, v12);
                                            v3_1 = v2_1;
                                            break;
                                        }

                                        long v4 = 1;
                                        if(v11 != 0) {
                                            v9 = RangesKt.coerceAtLeast((v9 - v14 + 0xF423F) / 1000000, v4);
                                            v5 = v2_4 == v16 ? v16 : RangesKt.coerceAtLeast(v2_4 - v7, v4);
                                            v0.lock.wait(Math.min(v9, v5));
                                            continue;
                                        }

                                        if(v2_4 == v16) {
                                            goto label_149;
                                        }

                                        v0.lock.wait(RangesKt.coerceAtLeast(v2_4 - v7, v4));
                                        continue;
                                    }
                                }

                            label_149:
                                v0.lock.wait();
                                continue;
                            }
                        }
                    }
                }

                break;
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v1);
            throw v0_1;
        }

        __monitor_exit(v1);
        return ((Queued)v3);
    }
}

