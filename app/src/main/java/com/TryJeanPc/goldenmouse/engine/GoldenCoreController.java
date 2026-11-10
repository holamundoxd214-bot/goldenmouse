package com.TryJeanPc.goldenmouse.engine;

import android.content.SharedPreferences;
import android.util.Log;
import com.TryJeanPc.goldenmouse.activation.ActivationManager;
import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Request;
import com.TryJeanPc.goldenmouse.aim.AimModeTransition$Status;
import com.TryJeanPc.goldenmouse.aim.CameraDiagnostics;
import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture;
import com.TryJeanPc.goldenmouse.controls.VistaInlineRawCapture;
import com.TryJeanPc.goldenmouse.injector.InjectionBackend;
import com.TryJeanPc.goldenmouse.injector.KadbInjectionBackend;
import com.TryJeanPc.goldenmouse.injector.SessionInjectionBackend;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.GoldenInputEngine;
import com.TryJeanPc.goldenmouse.input.InputDeviceStatus;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseMove;
import com.TryJeanPc.goldenmouse.input.InputState;
import com.TryJeanPc.goldenmouse.input.KeyboardRouteDiagnostics;
import com.TryJeanPc.goldenmouse.input.MouseMovementRegulator$Context;
import com.TryJeanPc.goldenmouse.input.MouseMovementRegulator;
import com.TryJeanPc.goldenmouse.input.MouseMovementTimer;
import com.TryJeanPc.goldenmouse.input.MousePollingPreferences;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import com.TryJeanPc.goldenmouse.input.MouseReportRate$Reading;
import com.TryJeanPc.goldenmouse.input.MouseReportRate;
import com.TryJeanPc.goldenmouse.macro.TurboEngine;
import com.TryJeanPc.goldenmouse.macro.execution.MacroPlaybackEngine;
import com.TryJeanPc.goldenmouse.mapper.FreeLookBindings;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import com.TryJeanPc.goldenmouse.mapper.MapperEngine;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettings;
import com.TryJeanPc.goldenmouse.shizuku.GoldenInputServiceConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002gj\b\u0007\u0018\u0000 \u009E\u00012\u00020\u0001:\u0002\u009E\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001A\u00020#H\u0002J\u000E\u0010@\u001A\u00020\f2\u0006\u0010A\u001A\u00020BJ\u0006\u0010C\u001A\u00020\fJ\b\u0010D\u001A\u00020\u000EH\u0002J\u0010\u0010V\u001A\u00020\u000E2\u0006\u0010W\u001A\u00020SH\u0002J\u000E\u0010X\u001A\u00020\f2\u0006\u0010Y\u001A\u00020ZJ\u0016\u0010[\u001A\u00020\f2\u0006\u0010Y\u001A\u00020Z2\u0006\u0010W\u001A\u00020SJ\n\u0010\\\u001A\u0004\u0018\u00010]H\u0002J\u0018\u0010^\u001A\u00020\f2\u0006\u0010_\u001A\u00020`2\u0006\u0010a\u001A\u00020]H\u0002J(\u0010b\u001A\u00020\f2 \u0010c\u001A\u001C\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\f\u0018\u00010MJ\u0006\u0010d\u001A\u00020eJ \u0010l\u001A\u00020\f2\u0018\u0010c\u001A\u0014\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\f0mJ \u0010o\u001A\u00020\f2\u0018\u0010p\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020n0q0\u0010J\u0014\u0010r\u001A\u00020\f2\f\u0010p\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0010J\u001C\u0010s\u001A\u00020\f2\u0014\u0010i\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ \u0010t\u001A\b\u0012\u0004\u0012\u00020\f0\u00102\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nJ \u0010u\u001A\b\u0012\u0004\u0012\u00020\f0\u00102\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nJ\u0006\u0010v\u001A\u00020\fJ\u000E\u0010w\u001A\u00020\f2\u0006\u0010x\u001A\u00020\u000EJ\u0006\u0010y\u001A\u00020\u000EJ\u001A\u0010z\u001A\u00020\f2\u0012\u0010i\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\f0\nJ\u000E\u0010{\u001A\u00020\f2\u0006\u0010|\u001A\u00020\u000EJ\u000E\u0010}\u001A\u00020\f2\u0006\u0010~\u001A\u00020\u000EJ&\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u00012\b\u0010\u0081\u0001\u001A\u00030\u0082\u00012\b\u0010\u0083\u0001\u001A\u00030\u0080\u00012\u0007\u0010A\u001A\u00030\u0084\u0001J\'\u0010\u0085\u0001\u001A\u0005\u0018\u00010\u0080\u00012\b\u0010\u0081\u0001\u001A\u00030\u0082\u00012\b\u0010\u0083\u0001\u001A\u00030\u0080\u00012\u0007\u0010\u0086\u0001\u001A\u00020\u000BJ%\u0010\u0087\u0001\u001A\u00020\f2\b\u0010\u0081\u0001\u001A\u00030\u0082\u00012\b\u0010\u0088\u0001\u001A\u00030\u0089\u00012\b\u0010\u008A\u0001\u001A\u00030\u0089\u0001J\u000E\u0010\u008B\u0001\u001A\t\u0012\u0004\u0012\u00020\u000E0\u008C\u0001J\u000F\u0010\u008E\u0001\u001A\u00020\f2\u0006\u0010|\u001A\u00020\u000EJ\b\u0010\u008F\u0001\u001A\u00030\u0090\u0001J\u0007\u0010\u0091\u0001\u001A\u00020\u001DJ\b\u0010\u0092\u0001\u001A\u00030\u0090\u0001J\b\u0010\u0093\u0001\u001A\u00030\u0090\u0001J\n\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u0080\u0001J\b\u0010\u0095\u0001\u001A\u00030\u0096\u0001J\u0007\u0010\u0097\u0001\u001A\u00020IJ\t\u0010\u009B\u0001\u001A\u00020\fH\u0002J\u0012\u0010\u009C\u0001\u001A\u00020\f2\u0007\u0010\u009D\u0001\u001A\u00020:H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010%\u001A\n \'*\u0004\u0018\u00010&0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010(\u001A\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b*\u0010+R\u001B\u0010.\u001A\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001A\u0004\b0\u00101R\u001B\u00103\u001A\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010-\u001A\u0004\b5\u00106R\u0017\u00108\u001A\b\u0012\u0004\u0012\u00020:098F¢\u0006\u0006\u001A\u0004\b;\u0010<R\u0017\u0010=\u001A\b\u0012\u0004\u0012\u00020>098F¢\u0006\u0006\u001A\u0004\b?\u0010<R\u000E\u0010E\u001A\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010H\u001A\u00020I8F¢\u0006\u0006\u001A\u0004\bJ\u0010KR(\u0010L\u001A\u001C\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\f\u0018\u00010MX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010O\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010P\u001A\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010R\u001A\u00020S8F¢\u0006\u0006\u001A\u0004\bT\u0010UR\u0010\u0010f\u001A\u00020gX\u0082\u0004¢\u0006\u0004\n\u0002\u0010hR\u0010\u0010i\u001A\u00020jX\u0082\u0004¢\u0006\u0004\n\u0002\u0010kR\u000F\u0010\u008D\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001A\u00030\u0099\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010\u009A\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u009F\u0001"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController;", "", "<init>", "()V", "requested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "totalEvents", "Ljava/util/concurrent/atomic/AtomicLong;", "bindingCaptureListener", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "backendReady", "", "cursorClickOverrideProvider", "Lkotlin/Function0;", "injectionBackend", "Lcom/TryJeanPc/goldenmouse/injector/SessionInjectionBackend;", "sharedInjector", "Lcom/TryJeanPc/goldenmouse/injector/TouchInjector;", "goldenEngine", "Lcom/TryJeanPc/goldenmouse/engine/GoldenEngine;", "inputEngine", "Lcom/TryJeanPc/goldenmouse/input/GoldenInputEngine;", "gameForeground", "actionExecutor", "Lcom/TryJeanPc/goldenmouse/engine/ActionExecutor;", "turboEngine", "Lcom/TryJeanPc/goldenmouse/macro/TurboEngine;", "macroEngine", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroPlaybackEngine;", "mapperEngine", "Lcom/TryJeanPc/goldenmouse/mapper/MapperEngine;", "freeLook", "Lcom/TryJeanPc/goldenmouse/engine/FreeLookController;", "createFreeLook", "backendMonitor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "quickChange", "Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator;", "getQuickChange", "()Lcom/TryJeanPc/goldenmouse/engine/VistaQuickChangeCoordinator;", "quickChange$delegate", "Lkotlin/Lazy;", "sniper", "Lcom/TryJeanPc/goldenmouse/engine/VistaSniperController;", "getSniper", "()Lcom/TryJeanPc/goldenmouse/engine/VistaSniperController;", "sniper$delegate", "inputSessionManager", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager;", "getInputSessionManager", "()Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager;", "inputSessionManager$delegate", "sessionSnapshotFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Snapshot;", "getSessionSnapshotFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "inputSnapshotFlow", "Lcom/TryJeanPc/goldenmouse/input/InputSnapshot;", "getInputSnapshotFlow", "configureRecoil", "settings", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "cancelRecoil", "recoilAuthorized", "mouseReportRate", "Lcom/TryJeanPc/goldenmouse/input/MouseReportRate;", "cursorModeEpoch", "mouseModeEpoch", "", "getMouseModeEpoch", "()J", "cursorScrollCallback", "Lkotlin/Function3;", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Scroll;", "pollingSettingsLock", "mouseMovement", "Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator;", "mousePollingSelection", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "getMousePollingSelection", "()Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "supportedGgPolling", "value", "loadMousePolling", "prefs", "Landroid/content/SharedPreferences;", "setMousePolling", "movementContext", "Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Context;", "deliverMouseMovement", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$MouseMove;", "context", "setCursorScrollCallback", "callback", "observedMouseRate", "Lcom/TryJeanPc/goldenmouse/input/MouseReportRate$Reading;", "runtime", "com/TryJeanPc/goldenmouse/engine/GoldenCoreController$runtime$1", "Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController$runtime$1;", "listener", "com/TryJeanPc/goldenmouse/engine/GoldenCoreController$listener$1", "Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController$listener$1;", "setCursorCallback", "Lkotlin/Function2;", "", "setCursorPositionProvider", "provider", "Lkotlin/Pair;", "setCursorClickOverrideProvider", "setInputBindingCaptureListener", "captureInputBindingForVista", "captureInlineInputBindingForVista", "toggleAimMode", "setAimActive", "active", "isAimActive", "setAimModeListener", "setAimInputEnabled", "enabled", "setGameForeground", "foreground", "vistaSettingsConflict", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "ownerId", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "freeLookBindingConflict", "binding", "applyGameProfile", "viewportWidth", "", "viewportHeight", "prepareProfileIdentityRepair", "Ljava/util/concurrent/CompletableFuture;", "editorRequested", "setUiInteractionMode", "iniciar", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$State;", "getTurboEngine", "detener", "getState", "getErrorMessage", "getInputState", "Lcom/TryJeanPc/goldenmouse/input/InputState;", "getTotalEvents", "lastBackend", "Lcom/TryJeanPc/goldenmouse/engine/InputSessionManager$Backend;", "lastReady", "checkBackend", "logSession", "snapshot", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCoreController {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController$Companion;", "", "<init>", "()V", "TAG", "", "sessionExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getSessionExecutor", "()Ljava/util/concurrent/ExecutorService;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ExecutorService getSessionExecutor() {
            return GoldenCoreController.sessionExecutor;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ActivationStatus.values().length];
            try {
                v0[ActivationStatus.ACTIVE_KADB.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[ActivationStatus.ACTIVE_SHIZUKU.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    v0 = new int[Backend.values().length];
                    try {
                        v0[Backend.KADB.ordinal()] = 1;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            v0[Backend.SHIZUKU.ordinal()] = v2;
                            goto label_21;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_21:
                                v0[Backend.NONE.ordinal()] = 3;
                                goto label_25;
                            }
                            catch(NoSuchFieldError ) {
                            label_25:
                                WhenMappings.$EnumSwitchMapping$1 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final String TAG = "GOLDEN_CORE";
    private final ActionExecutor actionExecutor;
    private final ScheduledExecutorService backendMonitor;
    private volatile boolean backendReady;
    private final AtomicReference bindingCaptureListener;
    private volatile Function0 cursorClickOverrideProvider;
    private final AtomicLong cursorModeEpoch;
    private volatile Function3 cursorScrollCallback;
    private volatile boolean editorRequested;
    private volatile FreeLookController freeLook;
    private volatile boolean gameForeground;
    private final GoldenEngine goldenEngine;
    private final SessionInjectionBackend injectionBackend;
    private final GoldenInputEngine inputEngine;
    private final Lazy inputSessionManager$delegate;
    private Backend lastBackend;
    private boolean lastReady;
    private final GoldenCoreController$listener$1 listener;
    private final MacroPlaybackEngine macroEngine;
    private final MapperEngine mapperEngine;
    private final MouseMovementRegulator mouseMovement;
    private final MouseReportRate mouseReportRate;
    private final Object pollingSettingsLock;
    private final Lazy quickChange$delegate;
    private final AtomicBoolean requested;
    private final GoldenCoreController$runtime$1 runtime;
    private static final ExecutorService sessionExecutor;
    private final TouchInjector sharedInjector;
    private final Lazy sniper$delegate;
    private final AtomicLong totalEvents;
    private final TurboEngine turboEngine;

    public static void $r8$lambda$k0r-ZLxPPUQtPnipkg0_BvykKpw(GoldenCoreController arg0) {
        arg0.checkBackend();
    }

    static {
        GoldenCoreController.Companion = new Companion(null);
        GoldenCoreController.$stable = 8;
        GoldenCoreController.sessionExecutor = Executors.newSingleThreadExecutor(new GoldenCoreController$$ExternalSyntheticLambda4());
    }

    public GoldenCoreController() {
        super();
        this.requested = new AtomicBoolean(false);
        this.totalEvents = new AtomicLong();
        this.bindingCaptureListener = new AtomicReference(null);
        SessionInjectionBackend v2 = new SessionInjectionBackend(null, null, new GoldenCoreController$$ExternalSyntheticLambda10(this), 3, null);
        this.injectionBackend = v2;
        TouchInjector v4 = new TouchInjector(((InjectionBackend)v2), null, 2, null);
        this.sharedInjector = v4;
        GoldenEngine v0 = new GoldenEngine(v4, new GoldenCoreController$$ExternalSyntheticLambda12(this));
        this.goldenEngine = v0;
        this.inputEngine = new GoldenInputEngine(null, 1, null);
        this.gameForeground = true;
        ActionExecutor v0_1 = new ActionExecutor(v4, null, new GoldenCoreController$actionExecutor$1(this), v0.fireCoordinator(), null, 18, null);
        this.actionExecutor = v0_1;
        this.turboEngine = new TurboEngine(v4);
        MacroPlaybackEngine v3 = new MacroPlaybackEngine(v4, null, null, null, new GoldenCoreController$$ExternalSyntheticLambda13(), 14, null);
        this.macroEngine = v3;
        MapperEngine v1 = new MapperEngine(v0_1, new GoldenCoreController$mapperEngine$1(this), v3);
        v1.setAimActiveProvider(new GoldenCoreController$$ExternalSyntheticLambda14(this));
        this.mapperEngine = v1;
        this.backendMonitor = Executors.newSingleThreadScheduledExecutor(new GoldenCoreController$$ExternalSyntheticLambda15());
        this.quickChange$delegate = LazyKt.lazy(new GoldenCoreController$$ExternalSyntheticLambda16(this));
        this.sniper$delegate = LazyKt.lazy(new GoldenCoreController$$ExternalSyntheticLambda17(this));
        this.inputSessionManager$delegate = LazyKt.lazy(new GoldenCoreController$$ExternalSyntheticLambda18(this));
        this.mouseReportRate = new MouseReportRate();
        this.cursorModeEpoch = new AtomicLong();
        this.pollingSettingsLock = new Object();
        this.mouseMovement = new MouseMovementRegulator(GoldenCoreController$mouseMovement$1.INSTANCE, new MouseMovementTimer(), new GoldenCoreController$mouseMovement$2(this), new GoldenCoreController$mouseMovement$3(this), new GoldenCoreController$$ExternalSyntheticLambda19(this));
        this.runtime = new GoldenCoreController$runtime$1(this);
        this.listener = new GoldenCoreController$listener$1(this);
        this.lastBackend = Backend.NONE;
    }

    public static final FreeLookController access$createFreeLook(GoldenCoreController arg0) {
        return arg0.createFreeLook();
    }

    public static final void access$deliverMouseMovement(GoldenCoreController arg0, MouseMove arg1, Context arg2) {
        arg0.deliverMouseMovement(arg1, arg2);
    }

    public static final boolean access$getBackendReady$p(GoldenCoreController arg0) {
        return arg0.backendReady;
    }

    public static final AtomicReference access$getBindingCaptureListener$p(GoldenCoreController arg0) {
        return arg0.bindingCaptureListener;
    }

    public static final Function0 access$getCursorClickOverrideProvider$p(GoldenCoreController arg0) {
        return arg0.cursorClickOverrideProvider;
    }

    public static final Function3 access$getCursorScrollCallback$p(GoldenCoreController arg0) {
        return arg0.cursorScrollCallback;
    }

    public static final FreeLookController access$getFreeLook$p(GoldenCoreController arg0) {
        return arg0.freeLook;
    }

    public static final boolean access$getGameForeground$p(GoldenCoreController arg0) {
        return arg0.gameForeground;
    }

    public static final GoldenEngine access$getGoldenEngine$p(GoldenCoreController arg0) {
        return arg0.goldenEngine;
    }

    public static final SessionInjectionBackend access$getInjectionBackend$p(GoldenCoreController arg0) {
        return arg0.injectionBackend;
    }

    public static final GoldenInputEngine access$getInputEngine$p(GoldenCoreController arg0) {
        return arg0.inputEngine;
    }

    public static final InputSessionManager access$getInputSessionManager(GoldenCoreController arg0) {
        return arg0.getInputSessionManager();
    }

    public static final GoldenCoreController$listener$1 access$getListener$p(GoldenCoreController arg0) {
        return arg0.listener;
    }

    public static final MapperEngine access$getMapperEngine$p(GoldenCoreController arg0) {
        return arg0.mapperEngine;
    }

    public static final MouseMovementRegulator access$getMouseMovement$p(GoldenCoreController arg0) {
        return arg0.mouseMovement;
    }

    public static final MouseReportRate access$getMouseReportRate$p(GoldenCoreController arg0) {
        return arg0.mouseReportRate;
    }

    public static final VistaQuickChangeCoordinator access$getQuickChange(GoldenCoreController arg0) {
        return arg0.getQuickChange();
    }

    public static final AtomicBoolean access$getRequested$p(GoldenCoreController arg0) {
        return arg0.requested;
    }

    public static final ExecutorService access$getSessionExecutor$cp() {
        return GoldenCoreController.sessionExecutor;
    }

    public static final VistaSniperController access$getSniper(GoldenCoreController arg0) {
        return arg0.getSniper();
    }

    public static final AtomicLong access$getTotalEvents$p(GoldenCoreController arg0) {
        return arg0.totalEvents;
    }

    public static final void access$logSession(GoldenCoreController arg0, Snapshot arg1) {
        arg0.logSession(arg1);
    }

    public static final Context access$movementContext(GoldenCoreController arg0) {
        return arg0.movementContext();
    }

    public static final boolean access$recoilAuthorized(GoldenCoreController arg0) {
        return arg0.recoilAuthorized();
    }

    public static final void access$setFreeLook$p(GoldenCoreController arg0, FreeLookController arg1) {
        arg0.freeLook = arg1;
    }

    public final void applyGameProfile(GameProfile arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "profile");
        this.getInputSessionManager().applyProfile(arg2, arg3, arg4).thenAccept(new GoldenCoreController$$ExternalSyntheticLambda9(new GoldenCoreController$applyGameProfile$1(this)));
    }

    static final void applyGameProfile$lambda$24(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    static final Thread backendMonitor$lambda$8(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenSessionBackend");
        v0.setDaemon(true);
        return v0;
    }

    public final void cancelRecoil() {
        this.goldenEngine.cancelRecoil$app();
    }

    public final Function0 captureInlineInputBindingForVista(Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg8, "listener");
        return VistaActivationCapture.Companion.captureRaw(this.bindingCaptureListener, new VistaInlineRawCapture(arg8, 0, 2, null));
    }

    public final Function0 captureInputBindingForVista(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        return VistaActivationCapture.Companion.captureRaw(this.bindingCaptureListener, arg2);
    }

    private final void checkBackend() {
        Boolean v1_4;
        Object v1_3;
        boolean v1_2;
        Backend v0_1;
        if(this.requested.get()) {
            int v0 = WhenMappings.$EnumSwitchMapping$0[ActivationManager.INSTANCE.getStatus().getValue().ordinal()];
            int v1 = 2;
            boolean v2 = true;
            if(v0 == 1) {
                v0_1 = Backend.KADB;
            }
            else if(v0 != v1) {
                v0_1 = Backend.NONE;
            }
            else {
                v0_1 = Backend.SHIZUKU;
            }

            try {
                int v4 = WhenMappings.$EnumSwitchMapping$1[v0_1.ordinal()];
                if(v4 == 1) {
                    v1_2 = KadbInjectionBackend.connect$default(KadbInjectionBackend.INSTANCE, 0, 1, null);
                }
                else if(v4 == v1) {
                    v1_2 = GoldenInputServiceConnection.INSTANCE.awaitConnected(500);
                }
                else if(v4 == 3) {
                    v1_2 = false;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }

                v1_3 = Result.constructor-impl(Boolean.valueOf(v1_2));
            }
            catch(Throwable v1_1) {
                v1_3 = Result.constructor-impl(ResultKt.createFailure(v1_1));
            }

            Boolean v4_1 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v1_3)) {
                v1_4 = v4_1;
            }

            v1_2 = v1_4.booleanValue();
            if(!this.requested.get()) {
                return;
            }

            this.backendReady = v1_2;
            Snapshot v4_2 = this.getInputSessionManager().getSnapshot();
            CameraDiagnostics.INSTANCE.backend(v0_1.name(), v1_2, v4_2.getCleanupPending());
            if(!v1_2 || this.injectionBackend.getRecoveryError() != null || (this.getInputSessionManager().getTransitionPending())) {
            label_80:
                v2 = false;
            }
            else if(v4_2.getInjectorReady()) {
                if(v4_2.getState() != State.RECOVERING) {
                    goto label_80;
                }
                else if(v4_2.getCleanupPending()) {
                }
                else {
                    goto label_80;
                }
            }

            if(v0_1 == this.lastBackend && v1_2 == this.lastReady && !v2) {
                return;
            }

            Log.i("GOLDEN_CORE", "request=backend backend=" + v0_1 + " ready=" + v1_2 + " retryCleanup=" + v2);
            this.lastBackend = v0_1;
            this.lastReady = v1_2;
            this.getInputSessionManager().backendChanged(v0_1, v1_2).thenAccept(new GoldenCoreController$$ExternalSyntheticLambda20(new GoldenCoreController$checkBackend$1(this)));
        }
    }

    static final void checkBackend$lambda$32(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    public final void configureRecoil(RecoilSettings arg3) {
        Intrinsics.checkNotNullParameter(arg3, "settings");
        this.goldenEngine.configureRecoil$app(arg3, new GoldenCoreController$configureRecoil$1(this));
    }

    private final FreeLookController createFreeLook() {
        return new FreeLookController(this.sharedInjector, new GoldenCoreController$createFreeLook$1(this.goldenEngine), new GoldenCoreController$createFreeLook$2(this.goldenEngine), new GoldenCoreController$$ExternalSyntheticLambda27(this), new GoldenCoreController$createFreeLook$4(this.mapperEngine), new GoldenCoreController$$ExternalSyntheticLambda1(this), null, 0x40, null);
    }

    static final boolean createFreeLook$lambda$5(GoldenCoreController arg3, long arg4, InputBinding arg6) {
        Intrinsics.checkNotNullParameter(arg6, "binding");
        Snapshot v0 = arg3.getInputSessionManager().getSnapshot();
        if((arg3.requested.get()) && (arg3.gameForeground) && !arg3.editorRequested && arg3.bindingCaptureListener.get() == null && (arg3.backendReady) && v0.getSessionId() == arg4 && v0.getState() == State.ACTIVE && !v0.getCleanupPending() && !v0.getContextPaused() && !v0.getEditor() && (v0.getMouseConnected()) && (v0.getInjectorReady()) && (v0.getProfileLoaded()) && (v0.getMapperReady()) && (v0.getCameraReady()) && (arg3.goldenEngine.isAimActive()) && (arg6.getSource() != InputBindingSource.KEYBOARD || (v0.getKeyboardConnected()))) {
            return 1;
        }

        return 0;
    }

    static final Unit createFreeLook$lambda$6(GoldenCoreController arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        Log.e("GOLDEN_CORE", arg2);
        if(!arg1.getInputSessionManager().getSnapshot().getCleanupPending()) {
            arg1.getInputSessionManager().injectionFailed(arg2);
        }

        return Unit.INSTANCE;
    }

    private final void deliverMouseMovement(MouseMove arg9, Context arg10) {
        if(!this.goldenEngine.isAimActive()) {
            if(!Intrinsics.areEqual(this.movementContext(), arg10)) {
            }
            else {
                this.goldenEngine.recibirMovimientoCursor$app(arg9.getDeltaX(), arg9.getDeltaY(), arg10.getSessionId(), arg9.getTimestampNanos());
            }
        }
    }

    public final State detener() {
        this.cancelRecoil();
        if(!this.requested.getAndSet(false)) {
            return this.getState();
        }

        this.mouseMovement.discard();
        this.getQuickChange().invalidate(true);
        this.getSniper().setAdmitted(false);
        this.backendMonitor.shutdownNow();
        this.turboEngine.close();
        this.getInputSessionManager().stop().thenAccept(new GoldenCoreController$$ExternalSyntheticLambda7(new GoldenCoreController$detener$1(this)));
        return this.getState();
    }

    static final void detener$lambda$29(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    public final String freeLookBindingConflict(GameProfile arg3, String arg4, InputBinding arg5) {
        Intrinsics.checkNotNullParameter(arg3, "profile");
        Intrinsics.checkNotNullParameter(arg4, "ownerId");
        Intrinsics.checkNotNullParameter(arg5, "binding");
        return FreeLookBindings.INSTANCE.conflict(arg3, arg4, arg5, new GoldenCoreController$freeLookBindingConflict$1(this.mapperEngine));
    }

    public final String getErrorMessage() {
        String v0 = this.injectionBackend.getRecoveryError();
        if(v0 == null) {
            Snapshot v1 = this.getInputSessionManager().getSnapshot();
            v0 = v1.getError();
            if(v0 == null) {
                return v1.getCaptureError();
            }
        }

        return v0;
    }

    private final InputSessionManager getInputSessionManager() {
        return this.inputSessionManager$delegate.getValue();
    }

    public final StateFlow getInputSnapshotFlow() {
        return this.inputEngine.getSnapshotFlow();
    }

    public final InputState getInputState() {
        return this.inputEngine.getState();
    }

    public final long getMouseModeEpoch() {
        return this.cursorModeEpoch.get();
    }

    public final MousePollingSelection getMousePollingSelection() {
        return this.goldenEngine.getMousePollingSelection$app();
    }

    private final VistaQuickChangeCoordinator getQuickChange() {
        return this.quickChange$delegate.getValue();
    }

    public final StateFlow getSessionSnapshotFlow() {
        return this.getInputSessionManager().getSnapshotFlow();
    }

    private final VistaSniperController getSniper() {
        return this.sniper$delegate.getValue();
    }

    public final State getState() {
        return this.getInputSessionManager().getSnapshot().getState();
    }

    public final long getTotalEvents() {
        return this.totalEvents.get();
    }

    public final TurboEngine getTurboEngine() {
        return this.turboEngine;
    }

    static final Unit goldenEngine$lambda$1(GoldenCoreController arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        arg1.getInputSessionManager().injectionFailed(arg2);
        Log.e("GOLDEN_CORE", arg2);
        return Unit.INSTANCE;
    }

    public final State iniciar() {
        if(!this.requested.compareAndSet(false, true)) {
            return this.getState();
        }

        this.getInputSessionManager().start().thenAccept(new GoldenCoreController$$ExternalSyntheticLambda21(new GoldenCoreController$iniciar$1(this)));
        this.backendMonitor.scheduleWithFixedDelay(new GoldenCoreController$$ExternalSyntheticLambda22(this), 0, 1, TimeUnit.SECONDS);
        return this.getState();
    }

    static final void iniciar$lambda$28(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    static final Unit injectionBackend$lambda$0(GoldenCoreController arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        arg1.getInputSessionManager().injectionFailed(arg2);
        Log.e("GOLDEN_CORE", arg2);
        return Unit.INSTANCE;
    }

    static final InputSessionManager inputSessionManager_delegate$lambda$16(GoldenCoreController arg3) {
        GoldenCoreController$runtime$1 v3 = arg3.runtime;
        ExecutorService v1 = GoldenCoreController.sessionExecutor;
        Intrinsics.checkNotNullExpressionValue(v1, "sessionExecutor");
        return new InputSessionManager(((Runtime)v3), v1, false);
    }

    public final boolean isAimActive() {
        return this.goldenEngine.isAimActive();
    }

    public final void loadMousePolling(SharedPreferences arg9) {
        String v0 = "GG FPS: ";
        Intrinsics.checkNotNullParameter(arg9, "prefs");
        Object v1 = this.pollingSettingsLock;
        __monitor_enter(v1);
        try {
            MousePollingSelection v2 = MousePollingPreferences.INSTANCE.load(arg9);
            DefaultConstructorMarker v4 = null;
            MousePollingSelection v3 = this.supportedGgPolling(v2) ? v2 : ((MousePollingSelection)v4);
            if(v3 == null) {
                v3 = new MousePollingSelection(0x7D, false, 2, v4);
            }

            if(!Intrinsics.areEqual(v3, v2)) {
                MousePollingPreferences.INSTANCE.save(arg9, v3);
                TouchInjector.Companion.showDiagnosticToast(v0 + v2.getLabel() + " no compatible; seleccionado 125 Hz");
            }

            this.mouseMovement.configure(v3);
            this.goldenEngine.configurePolling$app(v3);
        }
        catch(Throwable v8) {
            __monitor_exit(v1);
            throw v8;
        }

        __monitor_exit(v1);
    }

    private final void logSession(Snapshot arg15) {
        Log.i("GOLDEN_CORE", "sessionId=" + arg15.getSessionId() + " state=" + arg15.getState() + " contextPaused=" + arg15.getContextPaused() + " target=" + arg15.getTargetPackage() + " mouse=" + arg15.getMouseConnected() + " keyboard=" + arg15.getKeyboardConnected() + " requiredKeyboard=" + arg15.getKeyboardRequired() + " profile=" + arg15.getProfileLoaded() + " injector=" + arg15.getInjectorReady() + " cleanup=" + arg15.getCleanupPending() + " transitionPending=" + this.getInputSessionManager().getTransitionPending() + " error=" + arg15.getError() + " captureError=" + arg15.getCaptureError());
    }

    static final Unit macroEngine$lambda$2(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        Log.e("GoldenMacro", arg1);
        TouchInjector.Companion.showDiagnosticToast(arg1);
        return Unit.INSTANCE;
    }

    static final boolean mapperEngine$lambda$4$lambda$3(GoldenCoreController arg0) {
        return arg0.isAimActive();
    }

    static final Unit mouseMovement$lambda$17(GoldenCoreController arg2, Throwable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "error");
        Log.e("GOLDEN_CORE", "Fallo en la entrega Hz del mouse", arg3);
        InputSessionManager v2 = arg2.getInputSessionManager();
        String v3 = arg3.getMessage();
        if(v3 == null) {
            v3 = "Error de movimiento del mouse";
        }

        v2.injectionFailed(v3);
        return Unit.INSTANCE;
    }

    private final Context movementContext() {
        Snapshot v0 = this.getInputSessionManager().getSnapshot();
        if(!this.goldenEngine.isAimActive() && (this.requested.get()) && (this.gameForeground) && !v0.getContextPaused() && !v0.getCleanupPending() && (v0.getState() == State.ACTIVE || v0.getState() == State.EDITOR)) {
            return new Context(v0.getSessionId(), this.getMouseModeEpoch());
        }

        return null;
    }

    public final Reading observedMouseRate() {
        InputDeviceStatus v0 = this.inputEngine.getSnapshot().getMouse();
        return MouseReportRate.reading$default(this.mouseReportRate, v0.getDevicePath(), this.getInputSessionManager().getSnapshot().getSessionId(), v0.getConnected(), 0, 8, null);
    }

    public final CompletableFuture prepareProfileIdentityRepair() {
        CompletableFuture v2 = this.getInputSessionManager().setEditor(true).thenApply(new GoldenCoreController$$ExternalSyntheticLambda3(new GoldenCoreController$$ExternalSyntheticLambda2(this)));
        Intrinsics.checkNotNullExpressionValue(v2, "thenApply(...)");
        return v2;
    }

    static final Boolean prepareProfileIdentityRepair$lambda$25(GoldenCoreController arg1, Snapshot arg2) {
        boolean v1 = !arg2.getEditor() || (arg2.getCleanupPending()) || (arg1.getInputSessionManager().getTransitionPending()) ? false : true;
        return Boolean.valueOf(v1);
    }

    static final Boolean prepareProfileIdentityRepair$lambda$26(Function1 arg0, Object arg1) {
        return arg0.invoke(arg1);
    }

    static final VistaQuickChangeCoordinator quickChange_delegate$lambda$14(GoldenCoreController arg8) {
        ExecutorService v1 = GoldenCoreController.sessionExecutor;
        Intrinsics.checkNotNullExpressionValue(v1, "sessionExecutor");
        return new VistaQuickChangeCoordinator(((Executor)v1), new GoldenCoreController$$ExternalSyntheticLambda23(arg8), new GoldenCoreController$quickChange$2$2(arg8.goldenEngine), new GoldenCoreController$$ExternalSyntheticLambda24(arg8), new GoldenCoreController$quickChange$2$4(arg8.mapperEngine), new GoldenCoreController$quickChange$2$5(arg8.goldenEngine), new GoldenCoreController$$ExternalSyntheticLambda25(arg8));
    }

    static final CompletableFuture quickChange_delegate$lambda$14$lambda$10(GoldenCoreController arg4, Request arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "request");
        Intrinsics.checkNotNullParameter(arg6, "authorized");
        arg4.getSniper().invalidate();
        FreeLookController v0 = arg4.freeLook;
        if(v0 != null && !FreeLookController.cancelAndDrain$default(v0, false, 1, null)) {
            CompletableFuture v4 = CompletableFuture.completedFuture(new com.TryJeanPc.goldenmouse.aim.AimModeTransition$Result(arg5, -1, Status.FAILED));
            Intrinsics.checkNotNullExpressionValue(v4, "completedFuture(...)");
            return v4;
        }

        return arg4.goldenEngine.setAimActiveConfirmed$app(arg5, arg6);
    }

    static final Function0 quickChange_delegate$lambda$14$lambda$13(GoldenCoreController arg1, long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        return new GoldenCoreController$$ExternalSyntheticLambda11(arg1.backendMonitor.schedule(new GoldenCoreController$$ExternalSyntheticLambda0(arg4), arg2, TimeUnit.MILLISECONDS));
    }

    static final void quickChange_delegate$lambda$14$lambda$13$lambda$11(Function0 arg0) {
        arg0.invoke();
    }

    static final Unit quickChange_delegate$lambda$14$lambda$13$lambda$12(ScheduledFuture arg1) {
        arg1.cancel(false);
        return Unit.INSTANCE;
    }

    static final Snapshot quickChange_delegate$lambda$14$lambda$9(GoldenCoreController arg0) {
        return arg0.getInputSessionManager().getSnapshot();
    }

    private final boolean recoilAuthorized() {
        Snapshot v0 = this.getInputSessionManager().getSnapshot();
        if((this.requested.get()) && (this.gameForeground) && !this.editorRequested && this.bindingCaptureListener.get() == null && (this.backendReady) && v0.getState() == State.ACTIVE && !v0.getContextPaused() && !v0.getCleanupPending() && !v0.getEditor() && (v0.getMouseConnected()) && (v0.getInjectorReady()) && (v0.getProfileLoaded()) && (v0.getCameraReady()) && (v0.getMapperReady()) && (this.inputEngine.getSnapshot().getMouse().getConnected()) && (this.goldenEngine.isAimActive())) {
            return 1;
        }

        return 0;
    }

    static final Thread sessionExecutor$lambda$34(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenInputSession");
        v0.setDaemon(true);
        return v0;
    }

    public final void setAimActive(boolean arg5) {
        FreeLookController v0 = this.freeLook;
        Object v1 = null;
        if(v0 != null && !FreeLookController.cancelAndDrain$default(v0, false, 1, v1)) {
            return;
        }

        VistaQuickChangeCoordinator.invalidate$default(this.getQuickChange(), false, 1, v1);
        this.getSniper().invalidate();
        this.goldenEngine.setAimActive(arg5);
    }

    public final void setAimInputEnabled(boolean arg7) {
        boolean v0 = false;
        if(!arg7) {
            FreeLookController v2 = this.freeLook;
            if(v2 != null) {
                FreeLookController.cancel$default(v2, false, 1, null);
            }

            this.getQuickChange().invalidate(true);
        }

        Snapshot v2_1 = this.getInputSessionManager().getSnapshot();
        VistaSniperController v3 = this.getSniper();
        boolean v4 = !arg7 || v2_1.getState() != State.ACTIVE || (v2_1.getCleanupPending()) ? false : true;
        v3.setAdmitted(v4);
        GoldenEngine v3_1 = this.goldenEngine;
        if((arg7) && (this.gameForeground) && v2_1.getState() == State.ACTIVE && !v2_1.getCleanupPending()) {
            v0 = true;
        }

        v3_1.setAimInputEnabled(v0);
    }

    public final void setAimModeListener(Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "listener");
        this.goldenEngine.setAimModeListener(new GoldenCoreController$$ExternalSyntheticLambda6(this, arg3));
    }

    static final Unit setAimModeListener$lambda$22(GoldenCoreController arg1, Function1 arg2, boolean arg3) {
        arg1.getSniper().invalidate();
        arg1.cursorModeEpoch.incrementAndGet();
        arg1.mouseMovement.discard();
        arg1.getInputSessionManager().mouseModeChanged();
        arg2.invoke(Boolean.valueOf(arg3));
        return Unit.INSTANCE;
    }

    public final void setCursorCallback(Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "callback");
        this.goldenEngine.setCursorCallback(new GoldenCoreController$$ExternalSyntheticLambda8(this, arg3));
    }

    static final Unit setCursorCallback$lambda$21(GoldenCoreController arg2, Function2 arg3, float arg4, float arg5) {
        Snapshot v0 = arg2.getInputSessionManager().getSnapshot();
        if((arg2.gameForeground) && !v0.getContextPaused() && !v0.getCleanupPending() && (v0.getState() == State.ACTIVE || v0.getState() == State.EDITOR)) {
            arg3.invoke(Float.valueOf(arg4), Float.valueOf(arg5));
        }

        return Unit.INSTANCE;
    }

    public final void setCursorClickOverrideProvider(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.cursorClickOverrideProvider = arg2;
    }

    public final void setCursorPositionProvider(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.goldenEngine.setCursorPositionProvider(arg2);
    }

    public final void setCursorScrollCallback(Function3 arg1) {
        this.cursorScrollCallback = arg1;
    }

    public final void setGameForeground(boolean arg3) {
        this.gameForeground = arg3;
        if(!arg3) {
            this.cancelRecoil();
        }

        if(!arg3) {
            this.mouseMovement.discard();
        }

        this.inputEngine.requestCaptureSuspended((((int)arg3)) ^ 1);
        this.getInputSessionManager().setPaused((((int)arg3)) ^ 1).thenAccept(new GoldenCoreController$$ExternalSyntheticLambda26(new GoldenCoreController$setGameForeground$1(this)));
    }

    static final void setGameForeground$lambda$23(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    public final void setInputBindingCaptureListener(Function1 arg1) {
        this.bindingCaptureListener.set(arg1);
    }

    public final void setMousePolling(SharedPreferences arg4, MousePollingSelection arg5) {
        MousePollingSelection v0_1;
        String v0 = "GG FPS admite 125, 250, 500 Hz o Nativo (sin límite). ";
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        Intrinsics.checkNotNullParameter(arg5, "value");
        Object v1 = this.pollingSettingsLock;
        __monitor_enter(v1);
        try {
            if(!this.supportedGgPolling(arg5)) {
                goto label_24;
            }

            v0_1 = this.goldenEngine.getMousePollingSelection$app();
            MousePollingPreferences.INSTANCE.save(arg4, arg5);
        }
        catch(Throwable v3) {
            goto label_36;
        }

        try {
            this.mouseMovement.configure(arg5);
            this.goldenEngine.configurePolling$app(arg5);
            goto label_17;
        }
        catch(Throwable v3) {
            try {
                MousePollingPreferences.INSTANCE.save(arg4, v0_1);
                throw v3;
            label_17:
            }
            catch(Throwable v3) {
                goto label_36;
            }
        }

        __monitor_exit(v1);
        return;
        try {
        label_24:
            throw new IllegalArgumentException(v0 + arg5.getLabel() + " no es un modo GG nativo.".toString());
        }
        catch(Throwable v3) {
        label_36:
            __monitor_exit(v1);
            throw v3;
        }
    }

    public final void setUiInteractionMode(boolean arg2) {
        this.editorRequested = arg2;
        if(arg2) {
            this.cancelRecoil();
        }

        this.getInputSessionManager().setEditor(arg2).thenAccept(new GoldenCoreController$$ExternalSyntheticLambda5(new GoldenCoreController$setUiInteractionMode$1(this)));
    }

    static final void setUiInteractionMode$lambda$27(Function1 arg0, Object arg1) {
        arg0.invoke(arg1);
    }

    static final VistaSniperController sniper_delegate$lambda$15(GoldenCoreController arg4) {
        return new VistaSniperController(new GoldenCoreController$sniper$2$1(arg4.goldenEngine), new GoldenCoreController$sniper$2$2(arg4.goldenEngine), new GoldenCoreController$sniper$2$3(arg4.mapperEngine));
    }

    private final boolean supportedGgPolling(MousePollingSelection arg3) {
        return SetsKt.setOf(new Integer[]{Integer.valueOf(0), Integer.valueOf(0x7D), Integer.valueOf(0xFA), Integer.valueOf(500)}).contains(Integer.valueOf(arg3.getHz()));
    }

    public final void toggleAimMode() {
        FreeLookController v0 = this.freeLook;
        Object v1 = null;
        if(v0 != null && !FreeLookController.cancelAndDrain$default(v0, false, 1, v1)) {
            return;
        }

        VistaQuickChangeCoordinator.invalidate$default(this.getQuickChange(), false, 1, v1);
        this.getSniper().invalidate();
        boolean v0_1 = this.goldenEngine.isAimActive();
        this.goldenEngine.toggleAimMode();
        KeyboardRouteDiagnostics.INSTANCE.callback(v0_1, this.goldenEngine.isAimActive());
        Log.i("GOLDEN_F1", "AIM toggle active=" + this.goldenEngine.isAimActive());
    }

    public final String vistaSettingsConflict(GameProfile arg3, String arg4, ViewComponent arg5) {
        Intrinsics.checkNotNullParameter(arg3, "profile");
        Intrinsics.checkNotNullParameter(arg4, "ownerId");
        Intrinsics.checkNotNullParameter(arg5, "settings");
        return VistaSettingsValidation.INSTANCE.conflict(arg3, arg4, arg5, new GoldenCoreController$vistaSettingsConflict$1(this.mapperEngine));
    }
}

