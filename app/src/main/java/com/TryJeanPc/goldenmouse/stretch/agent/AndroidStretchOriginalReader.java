package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.IBinder;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u001A\u001B\u001CB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0013J\u0018\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0011H\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "reader", "Ljava/util/concurrent/ThreadPoolExecutor;", "capture", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "baseline", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "agentGeneration", "", "ownerGeneration", "progress", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentProgress;", "includeInformativeDumps", "", "dump", "Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$Dump;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$Query;", "close", "", "DumpSteps", "Query", "Dump", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchOriginalReader implements AutoCloseable {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$Dump;", "", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "text", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;Ljava/lang/String;)V", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Dump {
        private final OriginalReadCode code;
        private final String text;

        public Dump(OriginalReadCode arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = "";
            }

            this(arg1, arg2);
        }

        public Dump(OriginalReadCode arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg2, "code");
            Intrinsics.checkNotNullParameter(arg3, "text");
            super();
            this.code = arg2;
            this.text = arg3;
        }

        public final OriginalReadCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.text;
        }

        public final Dump copy(OriginalReadCode arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "code");
            Intrinsics.checkNotNullParameter(arg2, "text");
            return new Dump(arg1, arg2);
        }

        public static Dump copy$default(Dump arg0, OriginalReadCode arg1, String arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.code;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.text;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Dump)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Dump)) {
                return 0;
            }

            if(this.code != ((Dump)arg5).code) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.text, ((Dump)arg5).text)) {
                return 0;
            }

            return 1;
        }

        public final OriginalReadCode getCode() {
            return this.code;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.code.hashCode() * 0x1F + this.text.hashCode();
        }

        public String toString() {
            return "Dump(code=" + this.code + ", text=" + this.text + ")";
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003JO\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\r¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$DumpSteps;", "", "pipe", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "service", "submit", "dump", "close", "wait", "cleanup", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;)V", "getPipe", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "getService", "getSubmit", "getDump", "getClose", "getWait", "getCleanup", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class DumpSteps {
        private final StretchOriginalAgentStep cleanup;
        private final StretchOriginalAgentStep close;
        private final StretchOriginalAgentStep dump;
        private final StretchOriginalAgentStep pipe;
        private final StretchOriginalAgentStep service;
        private final StretchOriginalAgentStep submit;
        private final StretchOriginalAgentStep wait;

        public DumpSteps(StretchOriginalAgentStep arg2, StretchOriginalAgentStep arg3, StretchOriginalAgentStep arg4, StretchOriginalAgentStep arg5, StretchOriginalAgentStep arg6, StretchOriginalAgentStep arg7, StretchOriginalAgentStep arg8) {
            Intrinsics.checkNotNullParameter(arg2, "pipe");
            Intrinsics.checkNotNullParameter(arg3, "service");
            Intrinsics.checkNotNullParameter(arg4, "submit");
            Intrinsics.checkNotNullParameter(arg5, "dump");
            Intrinsics.checkNotNullParameter(arg6, "close");
            Intrinsics.checkNotNullParameter(arg7, "wait");
            Intrinsics.checkNotNullParameter(arg8, "cleanup");
            super();
            this.pipe = arg2;
            this.service = arg3;
            this.submit = arg4;
            this.dump = arg5;
            this.close = arg6;
            this.wait = arg7;
            this.cleanup = arg8;
        }

        public final StretchOriginalAgentStep component1() {
            return this.pipe;
        }

        public final StretchOriginalAgentStep component2() {
            return this.service;
        }

        public final StretchOriginalAgentStep component3() {
            return this.submit;
        }

        public final StretchOriginalAgentStep component4() {
            return this.dump;
        }

        public final StretchOriginalAgentStep component5() {
            return this.close;
        }

        public final StretchOriginalAgentStep component6() {
            return this.wait;
        }

        public final StretchOriginalAgentStep component7() {
            return this.cleanup;
        }

        public final DumpSteps copy(StretchOriginalAgentStep arg9, StretchOriginalAgentStep arg10, StretchOriginalAgentStep arg11, StretchOriginalAgentStep arg12, StretchOriginalAgentStep arg13, StretchOriginalAgentStep arg14, StretchOriginalAgentStep arg15) {
            Intrinsics.checkNotNullParameter(arg9, "pipe");
            Intrinsics.checkNotNullParameter(arg10, "service");
            Intrinsics.checkNotNullParameter(arg11, "submit");
            Intrinsics.checkNotNullParameter(arg12, "dump");
            Intrinsics.checkNotNullParameter(arg13, "close");
            Intrinsics.checkNotNullParameter(arg14, "wait");
            Intrinsics.checkNotNullParameter(arg15, "cleanup");
            return new DumpSteps(arg9, arg10, arg11, arg12, arg13, arg14, arg15);
        }

        public static DumpSteps copy$default(DumpSteps arg0, StretchOriginalAgentStep arg1, StretchOriginalAgentStep arg2, StretchOriginalAgentStep arg3, StretchOriginalAgentStep arg4, StretchOriginalAgentStep arg5, StretchOriginalAgentStep arg6, StretchOriginalAgentStep arg7, int arg8, Object arg9) {
            if((arg8 & 1) != 0) {
                arg1 = arg0.pipe;
            }

            if((arg8 & 2) != 0) {
                arg2 = arg0.service;
            }

            if((arg8 & 4) != 0) {
                arg3 = arg0.submit;
            }

            if((arg8 & 8) != 0) {
                arg4 = arg0.dump;
            }

            if((arg8 & 16) != 0) {
                arg5 = arg0.close;
            }

            if((arg8 & 0x20) != 0) {
                arg6 = arg0.wait;
            }

            if((arg8 & 0x40) != 0) {
                arg7 = arg0.cleanup;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public boolean equals(Object arg5) {
            if(this == (((DumpSteps)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof DumpSteps)) {
                return 0;
            }

            if(this.pipe != ((DumpSteps)arg5).pipe) {
                return 0;
            }

            if(this.service != ((DumpSteps)arg5).service) {
                return 0;
            }

            if(this.submit != ((DumpSteps)arg5).submit) {
                return 0;
            }

            if(this.dump != ((DumpSteps)arg5).dump) {
                return 0;
            }

            if(this.close != ((DumpSteps)arg5).close) {
                return 0;
            }

            if(this.wait != ((DumpSteps)arg5).wait) {
                return 0;
            }

            if(this.cleanup != ((DumpSteps)arg5).cleanup) {
                return 0;
            }

            return 1;
        }

        public final StretchOriginalAgentStep getCleanup() {
            return this.cleanup;
        }

        public final StretchOriginalAgentStep getClose() {
            return this.close;
        }

        public final StretchOriginalAgentStep getDump() {
            return this.dump;
        }

        public final StretchOriginalAgentStep getPipe() {
            return this.pipe;
        }

        public final StretchOriginalAgentStep getService() {
            return this.service;
        }

        public final StretchOriginalAgentStep getSubmit() {
            return this.submit;
        }

        public final StretchOriginalAgentStep getWait() {
            return this.wait;
        }

        public int hashCode() {
            return (((((this.pipe.hashCode() * 0x1F + this.service.hashCode()) * 0x1F + this.submit.hashCode()) * 0x1F + this.dump.hashCode()) * 0x1F + this.close.hashCode()) * 0x1F + this.wait.hashCode()) * 0x1F + this.cleanup.hashCode();
        }

        public String toString() {
            return "DumpSteps(pipe=" + this.pipe + ", service=" + this.service + ", submit=" + this.submit + ", dump=" + this.dump + ", close=" + this.close + ", wait=" + this.wait + ", cleanup=" + this.cleanup + ")";
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\'\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$Query;", "", "service", "", "arguments", "", "steps", "Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$DumpSteps;", "<init>", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$DumpSteps;)V", "getService", "()Ljava/lang/String;", "getArguments", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSteps", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader$DumpSteps;", "DISPLAY", "WINDOW", "app"}, k=1, mv={2, 2, 0}, xi=0x30) enum Query {
        public static final enum Query DISPLAY;
        public static final enum Query WINDOW;
        private final String[] arguments;
        private final String service;
        private final DumpSteps steps;

        private static final Query[] $values() {
            return new Query[]{Query.DISPLAY, Query.WINDOW};
        }

        static {
            Query.DISPLAY = new Query("DISPLAY", 0, "display", new String[0], new DumpSteps(StretchOriginalAgentStep.DISPLAY_PIPE, StretchOriginalAgentStep.DISPLAY_SERVICE, StretchOriginalAgentStep.DISPLAY_READER_SUBMIT, StretchOriginalAgentStep.DISPLAY_DUMP_ASYNC, StretchOriginalAgentStep.DISPLAY_WRITE_CLOSE, StretchOriginalAgentStep.DISPLAY_READ_WAIT, StretchOriginalAgentStep.DISPLAY_CLEANUP));
            Query.WINDOW = new Query("WINDOW", 1, "window", new String[]{"displays"}, new DumpSteps(StretchOriginalAgentStep.WINDOW_PIPE, StretchOriginalAgentStep.WINDOW_SERVICE, StretchOriginalAgentStep.WINDOW_READER_SUBMIT, StretchOriginalAgentStep.WINDOW_DUMP_ASYNC, StretchOriginalAgentStep.WINDOW_WRITE_CLOSE, StretchOriginalAgentStep.WINDOW_READ_WAIT, StretchOriginalAgentStep.WINDOW_CLEANUP));
            Query[] v0 = Query.$values();
            Query.$VALUES = v0;
            Query.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Query(String arg1, int arg2, String arg3, String[] arg4, DumpSteps arg5) {
            super(arg1, arg2);
            this.service = arg3;
            this.arguments = arg4;
            this.steps = arg5;
        }

        public final String[] getArguments() {
            return this.arguments;
        }

        public static EnumEntries getEntries() {
            return Query.$ENTRIES;
        }

        public final String getService() {
            return this.service;
        }

        public final DumpSteps getSteps() {
            return this.steps;
        }

        public static Query valueOf(String arg1) {
            return Enum.valueOf(Query.class, arg1);
        }

        public static Query[] values() {
            return Query.$VALUES.clone();
        }
    }

    public static final int $stable = 8;
    private final Context context;
    private final ThreadPoolExecutor reader;

    static {
    }

    public AndroidStretchOriginalReader(Context arg10) {
        Intrinsics.checkNotNullParameter(arg10, "context");
        super();
        this.context = arg10;
        this.reader = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda0());
    }

    public final StretchOriginalEvidence capture(StretchAgentBaseline arg19, String arg20, String arg21, StretchOriginalAgentProgress arg22, boolean arg23) {
        AndroidStretchOriginalReader v1 = this;
        StretchOriginalAgentProgress v6 = arg22;
        StretchAgentBaseline v12 = arg19;
        Intrinsics.checkNotNullParameter(v12, "baseline");
        String v13 = arg20;
        Intrinsics.checkNotNullParameter(v13, "agentGeneration");
        String v14 = arg21;
        Intrinsics.checkNotNullParameter(v14, "ownerGeneration");
        Intrinsics.checkNotNullParameter(v6, "progress");
        StretchOriginalDisplayState v2 = v12.getSnapshot().getOriginal();
        int v0 = 2;
        String v3 = null;
        Dump v4 = arg23 ? v1.dump(Query.DISPLAY, v6) : new Dump(OriginalReadCode.NOT_REQUESTED, v3, v0, ((DefaultConstructorMarker)v3));
        Object v15 = v6.step(StretchOriginalAgentStep.PARSE_VIEWPORT, new AndroidStretchOriginalReader$$ExternalSyntheticLambda12(v4, v2));
        Dump v16 = arg23 ? v1.dump(Query.WINDOW, v6) : new Dump(OriginalReadCode.NOT_REQUESTED, v3, v0, ((DefaultConstructorMarker)v3));
        AndroidStretchWindowStateReader v3_1 = new AndroidStretchWindowStateReader(v1.context);
        Object v10 = v6.step(StretchOriginalAgentStep.PARSE_OVERRIDE, new AndroidStretchOriginalReader$$ExternalSyntheticLambda13(v3_1));
        v6.step(StretchOriginalAgentStep.READ_SCALING, new AndroidStretchOriginalReader$$ExternalSyntheticLambda1(((StretchWindowState)v10)));
        Object v0_1 = v6.step(StretchOriginalAgentStep.RECHECK_BASELINE, new AndroidStretchOriginalReader$$ExternalSyntheticLambda2(v1, v2, v3_1, v10, v12));
        return v6.step(StretchOriginalAgentStep.BUILD_EVIDENCE, new AndroidStretchOriginalReader$$ExternalSyntheticLambda3(((Triple)v0_1).component1(), v2, ((StretchWindowState)v10), ((Triple)v0_1).component3(), arg19, v13, v14, ((OriginalViewportRead)v15), v16, ((Triple)v0_1).component2()));
    }

    public static StretchOriginalEvidence capture$default(AndroidStretchOriginalReader arg6, StretchAgentBaseline arg7, String arg8, String arg9, StretchOriginalAgentProgress arg10, boolean arg11, int arg12, Object arg13) {
        return arg6.capture(arg7, arg8, arg9, arg10, true);
    }

    static final OriginalViewportRead capture$lambda$2(Dump arg2, StretchOriginalDisplayState arg3) {
        if(arg2.getCode() == OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY) {
            StretchOriginalEvidenceParser v0 = StretchOriginalEvidenceParser.INSTANCE;
            String v2 = arg2.getText();
            Object v1 = arg3.getPhysicalIdentity().getValue();
            Object v3 = arg3.getRotation().getValue();
            int v3_1 = v3 != null ? ((Integer)v3).intValue() : -1;
            return v0.viewport(v2, ((String)v1), v3_1);
        }

        return new OriginalViewportRead(arg2.getCode(), null, 2, null);
    }

    static final StretchWindowState capture$lambda$3(AndroidStretchWindowStateReader arg0) {
        return arg0.capture();
    }

    static final RecoveryDatum capture$lambda$4(StretchWindowState arg0) {
        return arg0.getScaling();
    }

    static final Triple capture$lambda$6(AndroidStretchOriginalReader arg2, StretchOriginalDisplayState arg3, AndroidStretchWindowStateReader arg4, StretchWindowState arg5, StretchAgentBaseline arg6) {
        Object v2_1;
        StretchCompositorRead v3 = new AndroidStretchCompositorReader(arg2.reader).capture(arg3.getPhysicalIdentity().getValue());
        StretchWindowState v4 = arg4.capture();
        try {
            v2_1 = Result.constructor-impl(new AndroidStretchBaselineProbe(arg2.context).capture(arg6.getSnapshot().getSessionId()).getSnapshot().getOriginal());
        }
        catch(Throwable v2) {
            v2_1 = Result.constructor-impl(ResultKt.createFailure(v2));
        }

        if(Result.isFailure-impl(v2_1)) {
            v2_1 = null;
        }

        return new Triple(v2_1, v3, StretchWindowState.Companion.stable(arg5, v4));
    }

    static final StretchOriginalEvidence capture$lambda$7(StretchOriginalDisplayState arg16, StretchOriginalDisplayState arg17, StretchWindowState arg18, StretchWindowState arg19, StretchAgentBaseline arg20, String arg21, String arg22, OriginalViewportRead arg23, Dump arg24, StretchCompositorRead arg25) {
        boolean v0;
        if(!Intrinsics.areEqual(arg16, arg17) || !Intrinsics.areEqual(arg18, arg19)) {
        label_15:
            v0 = false;
        }
        else {
            if(arg19.getDensity().getValue() != null && !Intrinsics.areEqual(arg19.getDensity().getValue(), arg17.getDensity().getValue())) {
                goto label_15;
            }

            v0 = true;
        }

        boolean v9 = v0;
        StretchRecoverySnapshot v2 = arg20.getSnapshot();
        RecoveryDatum v6 = arg19.getScaling();
        RecoveryDatum v7 = arg19.getOverride();
        OriginalReadCode v8 = arg24.getCode();
        StretchCompositorRead v10 = v9 ? arg25 : new StretchCompositorRead(CompositorReadCode.UNSTABLE, null, false, 6, null);
        return new StretchOriginalEvidence(v2, arg21, arg22, arg23, v6, v7, v8, v9, v10);
    }

    public void close() {
        this.reader.shutdownNow();
    }

    private final Dump dump(Query arg9, StretchOriginalAgentProgress arg10) {
        DumpSteps v9_2;
        Dump v5_1;
        Object v5;
        Object v4;
        ObjectRef v0 = new ObjectRef();
        int v1 = 0;
        int v2 = 2;
        String v3 = null;
        try {
            v4 = arg10.step(arg9.getSteps().getPipe(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda5(v0));
            v0 = null;
        }
        catch(Exception ) {
            return new Dump(OriginalReadCode.READ_FAILED, v3, v2, ((DefaultConstructorMarker)v3));
        }
        catch(StretchOriginalProgressFailure v8) {
            Object v9 = v0.element;
            if(v9 != null) {
                int v10 = v9.length;
                while(v1 < v10) {
                    ParcelFileDescriptor v0_1 = v9[v1];
                    try {
                        v0_1.close();
                        Result.constructor-impl(Unit.INSTANCE);
                    }
                    catch(Throwable v0_2) {
                        Result.constructor-impl(ResultKt.createFailure(v0_2));
                    }

                    ++v1;
                }
            }

            throw v8;
        }

        ParcelFileDescriptor$AutoCloseInputStream v0_3 = new ParcelFileDescriptor$AutoCloseInputStream(v4[0]);
        ObjectRef v1_1 = new ObjectRef();
        try {
            v5 = arg10.step(arg9.getSteps().getService(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda7(arg9));
            if(v5 == null) {
                v5_1 = new Dump(OriginalReadCode.METHOD_UNAVAILABLE, v3, v2, ((DefaultConstructorMarker)v3));
            }
            else {
                goto label_30;
            }
        }
        catch(TimeoutException ) {
            goto label_83;
        }
        catch(ReflectiveOperationException ) {
            goto label_67;
        }
        catch(Throwable v2_1) {
            goto label_94;
        }
        catch(SecurityException ) {
            goto label_75;
        }
        catch(Exception ) {
            goto label_59;
        }
        catch(StretchOriginalProgressFailure v2_2) {
            goto label_93;
        }

        StretchOriginalAgentStep v9_1 = arg9.getSteps().getCleanup();
        AndroidStretchOriginalReader$$ExternalSyntheticLambda6 v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
        goto label_28;
        try {
        label_30:
            v1_1.element = arg10.step(arg9.getSteps().getSubmit(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda8(this, v0_3, arg9));
            arg10.step(arg9.getSteps().getDump(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda9(((IBinder)v5), ((ParcelFileDescriptor[])v4), arg9));
            arg10.step(arg9.getSteps().getClose(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda10(((ParcelFileDescriptor[])v4)));
            v5 = arg10.step(arg9.getSteps().getWait(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda11(v1_1));
            Intrinsics.checkNotNull(v5);
            v9_2 = arg9.getSteps();
        }
        catch(Throwable v2_1) {
        label_94:
            arg10.cleanup(((Query)v9_2).getSteps().getCleanup(), new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4)));
            throw v2_1;
        }
        catch(Exception ) {
            try {
            label_59:
                v5_1 = new Dump(OriginalReadCode.READ_FAILED, v3, v2, ((DefaultConstructorMarker)v3));
            }
            catch(Throwable v2_1) {
                goto label_94;
            }

            v9_1 = ((Query)v9_2).getSteps().getCleanup();
            v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
        label_90:
            arg10.cleanup(v9_1, ((Function0)v2_3));
            return v5_1;
        }
        catch(ReflectiveOperationException ) {
            try {
            label_67:
                v5_1 = new Dump(OriginalReadCode.METHOD_UNAVAILABLE, v3, v2, ((DefaultConstructorMarker)v3));
            }
            catch(Throwable v2_1) {
                goto label_94;
            }

            v9_1 = ((Query)v9_2).getSteps().getCleanup();
            v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
            goto label_90;
        }
        catch(SecurityException ) {
            try {
            label_75:
                v5_1 = new Dump(OriginalReadCode.PERMISSION_DENIED, v3, v2, ((DefaultConstructorMarker)v3));
            }
            catch(Throwable v2_1) {
                goto label_94;
            }

            v9_1 = ((Query)v9_2).getSteps().getCleanup();
            v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
            goto label_90;
        }
        catch(TimeoutException ) {
        label_86:
            v9_1 = ((Query)v9_2).getSteps().getCleanup();
            v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
            goto label_90;
        }
        catch(StretchOriginalProgressFailure v2_2) {
            try {
            label_93:
                throw v2_2;
            label_83:
                v5_1 = new Dump(OriginalReadCode.TIMED_OUT, v3, v2, ((DefaultConstructorMarker)v3));
                goto label_86;
            }
            catch(Throwable v2_1) {
                goto label_94;
            }
        }

        v9_1 = v9_2.getCleanup();
        v2_3 = new AndroidStretchOriginalReader$$ExternalSyntheticLambda6(v1_1, this, v0_3, ((ParcelFileDescriptor[])v4));
    label_28:
        arg10.cleanup(v9_1, ((Function0)v2_3));
        return ((Dump)v5);
    }

    static final IBinder dump$lambda$12(Query arg4) {
        Object v1 = null;
        Object v4 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(v1, arg4.getService());
        if((v4 instanceof IBinder)) {
            return ((IBinder)v4);
        }

        return ((IBinder)v1);
    }

    static final Future dump$lambda$15(AndroidStretchOriginalReader arg1, ParcelFileDescriptor$AutoCloseInputStream arg2, Query arg3) {
        return arg1.reader.submit(new AndroidStretchOriginalReader$$ExternalSyntheticLambda4(arg2, arg3));
    }

    static final Dump dump$lambda$15$lambda$14(ParcelFileDescriptor$AutoCloseInputStream arg6, Query arg7) {
        Dump v1_1;
        Dump v7_3;
        int v3;
        byte[] v1;
        ByteArrayOutputStream v7_2;
        Dump v0_1;
        Throwable v2;
        ParcelFileDescriptor$AutoCloseInputStream v0;
        try {
            v0 = arg6;
            v2 = null;
            if(arg7 != Query.DISPLAY) {
                goto label_12;
            }

            com.TryJeanPc.goldenmouse.stretch.agent.StretchViewportDumpReader$Result v7_1 = StretchViewportDumpReader.INSTANCE.read(((InputStream)v0));
            v0_1 = new Dump(v7_1.getCode(), v7_1.getText());
        }
        catch(Throwable v7) {
            goto label_49;
        }

        CloseableKt.closeFinally(((Closeable)arg6), v2);
        return v0_1;
        try {
        label_12:
            v7_2 = new ByteArrayOutputStream();
            v1 = new byte[0x800];
            while(true) {
            label_16:
                v3 = v0.read(v1);
                if(v3 < 0) {
                    goto label_31;
                }

                if(v7_2.size() + v3 <= 0x20000) {
                    goto label_29;
                }

                v7_3 = new Dump(OriginalReadCode.OUTPUT_LIMIT, ((String)v2), 2, ((DefaultConstructorMarker)v2));
                break;
            }
        }
        catch(Throwable v7) {
            goto label_49;
        }

        CloseableKt.closeFinally(((Closeable)arg6), v2);
        return v7_3;
        try {
        label_29:
            v7_2.write(v1, 0, v3);
            goto label_16;
        label_31:
            CharsetDecoder v0_2 = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
            OriginalReadCode v3_1 = OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY;
            String v7_4 = v0_2.decode(ByteBuffer.wrap(v7_2.toByteArray())).toString();
            Intrinsics.checkNotNullExpressionValue(v7_4, "toString(...)");
            v1_1 = new Dump(v3_1, v7_4);
        }
        catch(Throwable v7) {
            goto label_49;
        }

        CloseableKt.closeFinally(((Closeable)arg6), v2);
        return v1_1;
        try {
        label_49:
            throw v7;
        }
        catch(Throwable v0_3) {
            CloseableKt.closeFinally(((Closeable)arg6), v7);
            throw v0_3;
        }
    }

    static final Unit dump$lambda$16(IBinder arg1, ParcelFileDescriptor[] arg2, Query arg3) {
        arg1.dumpAsync(arg2[1].getFileDescriptor(), arg3.getArguments());
        return Unit.INSTANCE;
    }

    static final Unit dump$lambda$17(ParcelFileDescriptor[] arg1) {
        arg1[1].close();
        return Unit.INSTANCE;
    }

    static final Dump dump$lambda$18(ObjectRef arg3) {
        Object v3 = arg3.element;
        if(v3 != null) {
            return ((Future)v3).get(800, TimeUnit.MILLISECONDS);
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static final Unit dump$lambda$21(ObjectRef arg0, AndroidStretchOriginalReader arg1, ParcelFileDescriptor$AutoCloseInputStream arg2, ParcelFileDescriptor[] arg3) {
        Object v0 = arg0.element;
        if(v0 != null) {
            ((Future)v0).cancel(true);
        }

        try {
            arg2.close();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0_1) {
            Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        try {
            arg3[1].close();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0_1) {
            Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        return Unit.INSTANCE;
    }

    static final ParcelFileDescriptor[] dump$lambda$9(ObjectRef arg1) {
        ParcelFileDescriptor[] v0 = ParcelFileDescriptor.createPipe();
        arg1.element = v0;
        return v0;
    }

    static final Thread reader$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchOriginalDump");
        v0.setDaemon(true);
        return v0;
    }
}

