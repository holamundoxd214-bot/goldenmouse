package com.TryJeanPc.goldenmouse.input;

import android.util.Log;
import com.TryJeanPc.goldenmouse.bridge.KadbBridge;
import com.TryJeanPc.goldenmouse.bridge.ShizukuBridge;
import com.TryJeanPc.goldenmouse.transport.TransportDeadline;
import com.flyfishxu.kadb.shell.AdbShellPacket$Exit;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdError;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdOut;
import com.flyfishxu.kadb.shell.AdbShellPacket;
import com.flyfishxu.kadb.shell.AdbShellStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap$KeySetView;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004,-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0000¢\u0006\u0002\b\u0011J \u0010\u0015\u001A\u00020\f2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\f0\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0002J\b\u0010\u001D\u001A\u00020\u000EH\u0016J\u0010\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\u0019H\u0016J\u0010\u0010 \u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\u0019H\u0002J\u0018\u0010!\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020$H\u0016J\u0010\u0010%\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\u0019H\u0016J\u0018\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u001CH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000RN\u0010\n\u001AB\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000E0\u000E \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000E0\u000E\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R~\u0010\u001A\u001Ar\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001C \r*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001B0\u001B\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000E0\u000E \r*8\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001C \r*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u001B0\u001B\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000E0\u000E\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2={"Lcom/TryJeanPc/goldenmouse/input/DefaultBackendSupervisor;", "Lcom/TryJeanPc/goldenmouse/input/BackendSupervisor;", "<init>", "()V", "calls", "Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline;", "controlCalls", "START_TIMEOUT_MS", "", "CLOSE_TIMEOUT_MS", "closingStreams", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "kotlin.jvm.PlatformType", "", "supervisedStream", "stream", "supervisedStream$app", "captureClosePending", "getCaptureClosePending$app", "()Z", "handshake", "create", "Lkotlin/Function0;", "ready", "", "pendingReleases", "Lkotlin/Pair;", "", "isAvailable", "openStream", "command", "openRawStream", "openDeviceStream", "devicePath", "captureMode", "Lcom/TryJeanPc/goldenmouse/input/CaptureMode;", "openPassiveDeviceStream", "releaseExclusiveHelper", "", "token", "pid", "TAG", "EXCLUSIVE_READY_LINE", "BoundedStream", "ExclusiveHandshakeStream", "ShizukuEventStream", "KadbEventStream", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class DefaultBackendSupervisor implements BackendSupervisor {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/input/DefaultBackendSupervisor$BoundedStream;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "delegate", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/CaptureStream;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "readLine", "", "close", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class BoundedStream implements CaptureStream {
        private final AtomicBoolean closed;
        private final CaptureStream delegate;

        public BoundedStream(CaptureStream arg2) {
            Intrinsics.checkNotNullParameter(arg2, "delegate");
            super();
            this.delegate = arg2;
            this.closed = new AtomicBoolean();
        }

        public void close() {
            if(!this.closed.compareAndSet(false, true)) {
                if(!DefaultBackendSupervisor.closingStreams.contains(this)) {
                    return;
                }

                throw new IllegalStateException("Cierre de captura todavía pendiente".toString());
            }

            DefaultBackendSupervisor.closingStreams.add(this);
            DefaultBackendSupervisor.calls.closeWithin(2000, new DefaultBackendSupervisor$BoundedStream$$ExternalSyntheticLambda0(this));
        }

        static final Unit close$lambda$1(BoundedStream arg2) {
            try {
                arg2.delegate.close();
            }
            catch(Throwable v0) {
                DefaultBackendSupervisor.closingStreams.remove(arg2);
                throw v0;
            }

            DefaultBackendSupervisor.closingStreams.remove(arg2);
            return Unit.INSTANCE;
        }

        public String readLine() {
            return this.delegate.readLine();
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000E\u001A\u00020\u000FJ\n\u0010\u0010\u001A\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0011\u001A\u00020\u000FH\u0016R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/input/DefaultBackendSupervisor$ExclusiveHandshakeStream;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "delegate", "readyLine", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/input/CaptureStream;Ljava/lang/String;)V", "pending", "Ljava/util/ArrayDeque;", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "owner", "Lkotlin/Pair;", "", "awaitReady", "", "readLine", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ExclusiveHandshakeStream implements CaptureStream {
        private final AtomicBoolean closed;
        private final CaptureStream delegate;
        private Pair owner;
        private final ArrayDeque pending;
        private final String readyLine;

        public ExclusiveHandshakeStream(CaptureStream arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg2, "delegate");
            Intrinsics.checkNotNullParameter(arg3, "readyLine");
            super();
            this.delegate = arg2;
            this.readyLine = arg3;
            this.pending = new ArrayDeque();
            this.closed = new AtomicBoolean();
        }

        public ExclusiveHandshakeStream(CaptureStream arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = "GOLDEN_EXCLUSIVE READY=1";
            }

            this(arg1, arg2);
        }

        public final void awaitReady() {
            Object v3;
            int v2;
            String v0_1;
            try {
                while(true) {
                label_0:
                    v0_1 = this.delegate.readLine();
                    if(v0_1 == null) {
                        goto label_88;
                    }

                    v2 = 2;
                    v3 = null;
                    boolean v1 = StringsKt.startsWith$default(v0_1, "GOLDEN_EXCLUSIVE", false, v2, v3);
                    break;
                }
            }
            catch(Throwable v0) {
                goto label_99;
            }

            String v5 = "GOLDEN_RAW";
            if(v1) {
                try {
                    Log.i(v5, v0_1);
                label_11:
                    if(Intrinsics.areEqual(v0_1, this.readyLine)) {
                        Log.i(v5, "phase=capture-handshake ready=" + this.readyLine);
                        return;
                    }

                    if(StringsKt.startsWith$default(v0_1, "GOLDEN_CAPTURE_OWNER=", false, v2, v3)) {
                        List v5_1 = StringsKt.split$default(StringsKt.substringAfter$default(v0_1, '=', ((String)v3), v2, v3), new char[]{':'}, false, 0, 6, null);
                        Object v1_1 = CollectionsKt.getOrNull(v5_1, 1);
                        Integer v1_2 = v1_1 != null ? StringsKt.toIntOrNull(((String)v1_1)) : ((Integer)v3);
                        if(v5_1.size() != v2) {
                            goto label_57;
                        }

                        if(!new Regex("^[a-f0-9]{32}$").matches(v5_1.get(0))) {
                            goto label_57;
                        }

                        if(v1_2 == null) {
                            goto label_57;
                        }

                        if(v1_2.intValue() <= 0) {
                            goto label_57;
                        }

                        this.owner = TuplesKt.to(v5_1.get(0), v1_2);
                    }

                label_57:
                    if(!Intrinsics.areEqual(v0_1, "GOLDEN_SHARED_ERROR")) {
                        if((StringsKt.startsWith$default(v0_1, "GOLDEN_EVENT", false, v2, v3)) || (StringsKt.contains$default(v0_1, "EV_", false, v2, v3))) {
                            this.pending.add(v0_1);
                        }

                        if(!StringsKt.contains$default(v0_1, "_ERROR=", false, v2, v3) && !StringsKt.contains$default(v0_1, "ERRNO=", false, v2, v3) && !StringsKt.contains$default(v0_1, "UNSUPPORTED=", false, v2, v3)) {
                            goto label_0;
                        }

                        throw new IllegalStateException(v0_1);
                    }

                    throw new IllegalStateException(v0_1);
                label_88:
                    throw new IllegalStateException("El stream terminó antes de confirmar " + this.readyLine);
                }
                catch(Throwable v0) {
                label_99:
                    Throwable v1_3 = v0;
                    try {
                        this.close();
                        Result.constructor-impl(Unit.INSTANCE);
                    }
                    catch(Throwable v0) {
                        Result.constructor-impl(ResultKt.createFailure(v0));
                    }

                    throw v1_3;
                }
            }

            goto label_11;
        }

        public void close() {
            if(!this.closed.compareAndSet(false, true)) {
                return;
            }

            try {
                Pair v0_1 = this.owner;
                if(v0_1 != null) {
                    DefaultBackendSupervisor.pendingReleases.add(v0_1);
                    DefaultBackendSupervisor.INSTANCE.releaseExclusiveHelper(v0_1.getFirst(), v0_1.getSecond().intValue());
                    DefaultBackendSupervisor.pendingReleases.remove(v0_1);
                }
            }
            catch(Throwable v0) {
                this.delegate.close();
                throw v0;
            }

            this.delegate.close();
        }

        public String readLine() {
            if(this.pending.isEmpty()) {
                return this.delegate.readLine();
            }

            return this.pending.removeFirst();
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\r\u001A\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00060\u000Bj\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/input/DefaultBackendSupervisor$KadbEventStream;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "command", "", "<init>", "(Ljava/lang/String;)V", "stream", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "lines", "Ljava/util/ArrayDeque;", "pendingBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "readLine", "close", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class KadbEventStream implements CaptureStream {
        private final ArrayDeque lines;
        private final StringBuilder pendingBuffer;
        private final AdbShellStream stream;

        public KadbEventStream(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "command");
            super();
            this.stream = KadbBridge.INSTANCE.abrirShell(arg2);
            this.lines = new ArrayDeque();
            this.pendingBuffer = new StringBuilder();
        }

        public void close() {
            try {
                this.stream.close();
                Result.constructor-impl(Unit.INSTANCE);
                return;
            }
            catch(Throwable v1) {
                Result.constructor-impl(ResultKt.createFailure(v1));
                return;
            }
        }

        public String readLine() {
            String v1;
            while(true) {
            label_0:
                if(!this.lines.isEmpty()) {
                    goto label_55;
                }

                AdbShellPacket v0 = this.stream.read();
                if((v0 instanceof StdOut)) {
                    this.pendingBuffer.append(new String(((StdOut)v0).getPayload(), Charsets.UTF_8));
                    goto label_13;
                }

                if(!(v0 instanceof StdError)) {
                    break;
                }

                v1 = new String(((StdError)v0).getPayload(), Charsets.UTF_8);
                if(StringsKt.isBlank(v1)) {
                    continue;
                }

                Log.w("GOLDEN_RAW", "KADB stderr: ".concat(v1));
            }

            if((v0 instanceof Exit)) {
                return null;
            }

            throw new NoWhenBranchMatchedException();
        label_55:
            return this.lines.removeFirst();
            while(true) {
            label_13:
                int v0_1 = StringsKt.indexOf$default(this.pendingBuffer, '\n', 0, false, 6, null);
                if(v0_1 < 0) {
                    goto label_0;
                }

                v1 = this.pendingBuffer.substring(0, v0_1);
                this.pendingBuffer.delete(0, v0_1 + 1);
                ArrayDeque v0_2 = this.lines;
                Intrinsics.checkNotNull(v1);
                v0_2.add(StringsKt.trim(((CharSequence)v1)).toString());
            }
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001A\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/input/DefaultBackendSupervisor$ShizukuEventStream;", "Lcom/TryJeanPc/goldenmouse/input/CaptureStream;", "command", "", "<init>", "(Ljava/lang/String;)V", "process", "Ljava/lang/Process;", "reader", "Ljava/io/BufferedReader;", "readLine", "close", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ShizukuEventStream implements CaptureStream {
        private final Process process;
        private final BufferedReader reader;

        public ShizukuEventStream(String arg10) {
            String v0 = "No se pudo abrir proceso Shizuku";
            Intrinsics.checkNotNullParameter(arg10, "command");
            super();
            try {
                Class v1 = Shizuku.class;
                Class[] v4 = new Class[3];
                Class v5 = String[].class;
                v4[0] = v5;
                v4[1] = v5;
                v4[2] = String.class;
                Method v1_1 = v1.getDeclaredMethod("newProcess", v4);
                v1_1.setAccessible(true);
                Object v10 = v1_1.invoke(null, new String[]{"sh", "-c", arg10}, null, null);
                Intrinsics.checkNotNull(v10, "null cannot be cast to non-null type java.lang.Process");
                this.process = ((Process)v10);
                this.reader = new BufferedReader(new InputStreamReader(((Process)v10).getInputStream()));
                return;
            }
            catch(Exception v9) {
                throw new IllegalStateException(v0, ((Throwable)v9));
            }
            catch(InvocationTargetException v9_1) {
                throw new IllegalStateException(v0, v9_1.getTargetException());
            }
        }

        public void close() {
            BackendSupervisorKt.closeCaptureProcess(this.process, this.reader);
        }

        public String readLine() {
            String v0 = "Shizuku stderr tras EOF: ";
            String v1 = this.reader.readLine();
            if(v1 == null) {
                try {
                    InputStream v7_1 = this.process.getErrorStream();
                    int v2 = RangesKt.coerceAtMost(v7_1.available(), 0x800);
                    if(v2 > 0) {
                        byte[] v2_1 = new byte[v2];
                        int v7_2 = v7_1.read(v2_1);
                        if(v7_2 > 0) {
                            Log.e("GOLDEN_RAW", v0.concat(new String(v2_1, 0, v7_2, Charsets.UTF_8)));
                        }
                    }

                    Result.constructor-impl(Unit.INSTANCE);
                    return v1;
                }
                catch(Throwable v7) {
                    Result.constructor-impl(ResultKt.createFailure(v7));
                }
            }

            return v1;
        }
    }

    public static final int $stable = 0;
    private static final long CLOSE_TIMEOUT_MS = 2000;
    private static final String EXCLUSIVE_READY_LINE = "GOLDEN_EXCLUSIVE READY=1";
    public static final DefaultBackendSupervisor INSTANCE = null;
    private static final long START_TIMEOUT_MS = 5000;
    private static final String TAG = "GOLDEN_RAW";
    private static final TransportDeadline calls;
    private static final ConcurrentHashMap$KeySetView closingStreams;
    private static final TransportDeadline controlCalls;
    private static final ConcurrentHashMap$KeySetView pendingReleases;

    static {
        DefaultBackendSupervisor.INSTANCE = new DefaultBackendSupervisor();
        DefaultBackendSupervisor.calls = new TransportDeadline("GoldenCapture");
        DefaultBackendSupervisor.controlCalls = new TransportDeadline("GoldenCaptureRelease");
        DefaultBackendSupervisor.closingStreams = ConcurrentHashMap.newKeySet();
        DefaultBackendSupervisor.pendingReleases = ConcurrentHashMap.newKeySet();
        DefaultBackendSupervisor.$stable = 8;
    }

    private DefaultBackendSupervisor() {
        super();
    }

    public static final TransportDeadline access$getCalls$p() {
        return DefaultBackendSupervisor.calls;
    }

    public static final ConcurrentHashMap$KeySetView access$getClosingStreams$p() {
        return DefaultBackendSupervisor.closingStreams;
    }

    public static final ConcurrentHashMap$KeySetView access$getPendingReleases$p() {
        return DefaultBackendSupervisor.pendingReleases;
    }

    public static final void access$releaseExclusiveHelper(DefaultBackendSupervisor arg0, String arg1, int arg2) {
        arg0.releaseExclusiveHelper(arg1, arg2);
    }

    public final boolean getCaptureClosePending$app() {
        ConcurrentHashMap$KeySetView v1 = DefaultBackendSupervisor.closingStreams;
        Intrinsics.checkNotNullExpressionValue(v1, "closingStreams");
        return ((Collection)v1).isEmpty() ^ 1;
    }

    private final CaptureStream handshake(Function0 arg5, String arg6) {
        return new BoundedStream(DefaultBackendSupervisor.calls.open(5000, new DefaultBackendSupervisor$$ExternalSyntheticLambda3(arg5, arg6), new DefaultBackendSupervisor$$ExternalSyntheticLambda4()));
    }

    static CaptureStream handshake$default(DefaultBackendSupervisor arg0, Function0 arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = "GOLDEN_EXCLUSIVE READY=1";
        }

        return arg0.handshake(arg1, arg2);
    }

    static final ExclusiveHandshakeStream handshake$lambda$0(Function0 arg1, String arg2) {
        return new ExclusiveHandshakeStream(arg1.invoke(), arg2);
    }

    static final Unit handshake$lambda$1(ExclusiveHandshakeStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        arg1.awaitReady();
        return Unit.INSTANCE;
    }

    public boolean isAvailable() {
        Object v8;
        if(!this.getCaptureClosePending$app()) {
            boolean v0 = TransportDeadline.call$default(DefaultBackendSupervisor.calls, 5000, null, new DefaultBackendSupervisor$$ExternalSyntheticLambda2(), 2, null).booleanValue();
            ConcurrentHashMap$KeySetView v1 = DefaultBackendSupervisor.pendingReleases;
            String v3 = "GOLDEN_RAW";
            Log.i(v3, "phase=backend-availability available=" + v0 + " pendingReleases=" + v1.size());
            if(!v0) {
                return 0;
            }

            try {
                Intrinsics.checkNotNullExpressionValue(v1, "pendingReleases");
                Iterator v0_2 = CollectionsKt.toList(((Iterable)v1)).iterator();
                while(v0_2.hasNext()) {
                    Object v1_1 = v0_2.next();
                    Object v2 = ((Pair)v1_1).component1();
                    int v1_2 = ((Pair)v1_1).component2().intValue();
                    this.releaseExclusiveHelper(((String)v2), v1_2);
                    DefaultBackendSupervisor.pendingReleases.remove(TuplesKt.to(v2, Integer.valueOf(v1_2)));
                }

                v8 = Result.constructor-impl(Boolean.valueOf(true));
            }
            catch(Throwable v0_1) {
                v8 = Result.constructor-impl(ResultKt.createFailure(v0_1));
            }

            v0_1 = Result.exceptionOrNull-impl(v8);
            if(v0_1 == null) {
                return ((Boolean)v8).booleanValue();
            }

            Log.w(v3, "Liberación exclusiva pendiente", v0_1);
            throw new IllegalStateException("Liberación exclusiva pendiente: " + v0_1.getMessage(), v0_1);
        }

        throw new IllegalStateException("Cierre de captura anterior no confirmado".toString());
    }

    static final boolean isAvailable$lambda$3() {
        if((ShizukuBridge.INSTANCE.servidorActivo()) && (ShizukuBridge.INSTANCE.permisoConcedido()) || (KadbBridge.INSTANCE.estaConectado())) {
            return 1;
        }

        return 0;
    }

    public CaptureStream openDeviceStream(String arg14, CaptureMode arg15) {
        CaptureStream v13;
        Intrinsics.checkNotNullParameter(arg14, "devicePath");
        Intrinsics.checkNotNullParameter(arg15, "captureMode");
        if(!this.getCaptureClosePending$app()) {
            String v1 = "getevent -l ";
            if(arg15 == CaptureMode.SHARED) {
                return this.openStream(v1 + arg14);
            }

            String v15 = ExclusiveEvdevCapture.INSTANCE.command(arg14);
            int v2 = 2;
            String v3 = "GOLDEN_RAW";
            String v4 = null;
            if(TransportDeadline.call$default(DefaultBackendSupervisor.calls, 5000, null, new DefaultBackendSupervisor$$ExternalSyntheticLambda8(), 2, null).booleanValue()) {
                try {
                    v13 = DefaultBackendSupervisor.handshake$default(this, new DefaultBackendSupervisor$$ExternalSyntheticLambda9(v15), v4, v2, v4);
                    return v13;
                }
                catch(Exception v0) {
                    if(!(v0 instanceof TimeoutException)) {
                        Log.w(v3, "Captura exclusiva Shizuku no disponible, usando fallback SHARED", ((Throwable)v0));
                        goto label_41;
                    }

                    throw v0;
                }
            }

        label_41:
            if(TransportDeadline.call$default(DefaultBackendSupervisor.calls, 5000, null, new DefaultBackendSupervisor$$ExternalSyntheticLambda10(), 2, null).booleanValue()) {
                try {
                    return DefaultBackendSupervisor.handshake$default(((DefaultBackendSupervisor)v13), new DefaultBackendSupervisor$$ExternalSyntheticLambda11(v15), v4, v2, v4);
                }
                catch(Exception v0) {
                    Exception v15_1 = v0;
                    if(!(v15_1 instanceof TimeoutException)) {
                        Log.w(v3, "Captura exclusiva KADB no disponible, usando fallback SHARED", ((Throwable)v15_1));
                        goto label_63;
                    }

                    throw v15_1;
                }
            }

        label_63:
            Log.i(v3, "Fallback a captura compartida (SHARED) para " + arg14);
            return ((DefaultBackendSupervisor)v13).openStream(v1 + arg14);
        }

        throw new IllegalStateException("Cierre de captura anterior no confirmado".toString());
    }

    static final CaptureStream openDeviceStream$lambda$10(String arg1) {
        return new ShizukuEventStream(arg1);
    }

    static final boolean openDeviceStream$lambda$11() {
        return KadbBridge.INSTANCE.estaConectado();
    }

    static final CaptureStream openDeviceStream$lambda$12(String arg1) {
        return new KadbEventStream(arg1);
    }

    static final boolean openDeviceStream$lambda$9() {
        if((ShizukuBridge.INSTANCE.servidorActivo()) && (ShizukuBridge.INSTANCE.permisoConcedido())) {
            return 1;
        }

        return 0;
    }

    public CaptureStream openPassiveDeviceStream(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "devicePath");
        if(new Regex("^/dev/input/event[0-9]+$").matches(arg3)) {
            return this.handshake(new DefaultBackendSupervisor$$ExternalSyntheticLambda0("getevent -l \'" + arg3 + "\' & capture_pid=$!; trap \'kill \"$capture_pid\" 2>/dev/null\' EXIT HUP TERM; capture_ready=0; for attempt in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20; do for fd in /proc/$capture_pid/fd/*; do if [ \"$(readlink \"$fd\")\" = \'" + arg3 + "\' ]; then capture_ready=1; break; fi; done; [ \"$capture_ready\" = 1 ] && break; sleep 0.01; done; if [ \"$capture_ready\" = 1 ]; then echo GOLDEN_SHARED_READY; wait \"$capture_pid\"; else echo GOLDEN_SHARED_ERROR; exit 1; fi"), "GOLDEN_SHARED_READY");
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    static final CaptureStream openPassiveDeviceStream$lambda$13(String arg1) {
        return DefaultBackendSupervisor.INSTANCE.openRawStream(arg1);
    }

    private final CaptureStream openRawStream(String arg3) {
        if((ShizukuBridge.INSTANCE.servidorActivo()) && (ShizukuBridge.INSTANCE.permisoConcedido())) {
            try {
                return new ShizukuEventStream(arg3);
            }
            catch(Exception v2) {
                Log.w("GOLDEN_RAW", "No se pudo abrir stream con Shizuku", ((Throwable)v2));
            }
        }

        if(KadbBridge.INSTANCE.estaConectado()) {
            return new KadbEventStream(arg3);
        }

        throw new IllegalStateException("No hay backend de captura con permisos disponibles");
    }

    public CaptureStream openStream(String arg8) {
        Intrinsics.checkNotNullParameter(arg8, "command");
        return new BoundedStream(TransportDeadline.open$default(DefaultBackendSupervisor.calls, 5000, new DefaultBackendSupervisor$$ExternalSyntheticLambda1(arg8), null, 4, null));
    }

    static final CaptureStream openStream$lambda$7(String arg1) {
        return DefaultBackendSupervisor.INSTANCE.openRawStream(arg1);
    }

    private final void releaseExclusiveHelper(String arg5, int arg6) {
        String v4 = "/data/local/tmp/golden_evdev_capture_" + arg5 + "_" + arg6;
        DefaultBackendSupervisor.controlCalls.closeWithin(2000, new DefaultBackendSupervisor$$ExternalSyntheticLambda7(DefaultBackendSupervisor.controlCalls.open(5000, new DefaultBackendSupervisor$$ExternalSyntheticLambda5("capture_exe=$(readlink /proc/" + arg6 + "/exe 2>/dev/null); case \"$capture_exe\" in \'" + v4 + "\'|\'" + v4 + " (deleted)\') kill -TERM " + arg6 + " 2>/dev/null;; esac; for attempt in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20; do capture_exe=$(readlink /proc/" + arg6 + "/exe 2>/dev/null); case \"$capture_exe\" in \'" + v4 + "\'|\'" + v4 + " (deleted)\') sleep 0.01;; \'\') if [ ! -d /proc/" + arg6 + " ] || [ \"$(cut -d\' \' -f3 /proc/" + arg6 + "/stat 2>/dev/null)\" = Z ]; then echo GOLDEN_CAPTURE_RELEASED; exit 0; else echo GOLDEN_CAPTURE_RELEASE_ERROR; exit 1; fi;; *) echo GOLDEN_CAPTURE_RELEASED; exit 0;; esac; done; echo GOLDEN_CAPTURE_RELEASE_ERROR"), new DefaultBackendSupervisor$$ExternalSyntheticLambda6(arg6, arg5))));
    }

    static final CaptureStream releaseExclusiveHelper$lambda$14(String arg1) {
        return DefaultBackendSupervisor.INSTANCE.openRawStream(arg1);
    }

    static final Unit releaseExclusiveHelper$lambda$16(int arg2, String arg3, CaptureStream arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        String v4 = arg4.readLine();
        if(Intrinsics.areEqual(v4, "GOLDEN_CAPTURE_RELEASED")) {
            return Unit.INSTANCE;
        }

        throw new IllegalStateException("No se confirmó el cierre del helper exclusivo pid=" + arg2 + " token=" + arg3 + " response=" + v4.toString());
    }

    static final Unit releaseExclusiveHelper$lambda$17(CaptureStream arg0) {
        arg0.close();
        return Unit.INSTANCE;
    }

    public final CaptureStream supervisedStream$app(CaptureStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "stream");
        return new BoundedStream(arg1);
    }
}

