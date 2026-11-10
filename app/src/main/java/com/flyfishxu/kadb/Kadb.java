package com.flyfishxu.kadb;

import com.flyfishxu.kadb.cert.platform.DefaultDeviceName_androidKt;
import com.flyfishxu.kadb.core.AdbConnection;
import com.flyfishxu.kadb.forwarding.TcpForwarder;
import com.flyfishxu.kadb.shell.AdbPtyShellSession;
import com.flyfishxu.kadb.shell.AdbShellResponse;
import com.flyfishxu.kadb.shell.AdbShellStream;
import com.flyfishxu.kadb.stream.AdbStream;
import com.flyfishxu.kadb.stream.AdbSyncStream;
import com.flyfishxu.kadb.transport.TransportChannel;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 t2\u00060\u0001j\u0002`\u0002:\u0002stB+\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nB1\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u0012\u001A\u00020\u0013J\u000E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0004J\u000E\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u0004J\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0004J\u0010\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001B\u001A\u00020\u0004J\u001A\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\u001B\u001A\u00020\u00042\b\b\u0002\u0010 \u001A\u00020\u0004J*\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020\u00042\b\b\u0002\u0010&\u001A\u00020\u00062\b\b\u0002\u0010\'\u001A\u00020(J&\u0010!\u001A\u00020\"2\u0006\u0010)\u001A\u00020*2\u0006\u0010%\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u00062\u0006\u0010\'\u001A\u00020(J\u0016\u0010+\u001A\u00020\"2\u0006\u0010,\u001A\u00020$2\u0006\u0010%\u001A\u00020\u0004J\u0016\u0010+\u001A\u00020\"2\u0006\u0010-\u001A\u00020.2\u0006\u0010%\u001A\u00020\u0004J\u0006\u0010/\u001A\u000200J\'\u00101\u001A\u00020\"2\u0006\u00102\u001A\u00020$2\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u00104J/\u00101\u001A\u00020\"2\u0006\u0010)\u001A\u00020*2\u0006\u00105\u001A\u00020(2\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u00106J)\u00107\u001A\u00020\"2\u0006\u0010%\u001A\u00020\u00042\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u00108J)\u00109\u001A\u00020\"2\u0006\u00102\u001A\u00020$2\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u00104J-\u0010:\u001A\u00020\"2\f\u0010;\u001A\b\u0012\u0004\u0012\u00020$0<2\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010=J\u000E\u0010>\u001A\u00020\"2\u0006\u0010?\u001A\u00020\u0004J\u001F\u0010@\u001A\u00020\u00152\u0012\u0010\u001B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010AJ\u001F\u0010B\u001A\u00020\u00152\u0012\u0010\u001B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004¢\u0006\u0002\u0010AJ\u0006\u0010C\u001A\u00020\u0004J\u0006\u0010D\u001A\u00020\u0004J\b\u0010E\u001A\u00020\"H\u0016J\u0006\u0010F\u001A\u00020\"J\b\u0010\u000E\u001A\u00020\u0010H\u0002J\u0014\u0010G\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FH\u0002J&\u0010H\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000F2\u0006\u0010\u0016\u001A\u00020\u00042\b\b\u0002\u0010I\u001A\u00020\u0013H\u0002J\u0010\u0010J\u001A\u00020\"2\u0006\u0010K\u001A\u00020\u0010H\u0002J\u0010\u0010L\u001A\u00020\u00132\u0006\u0010M\u001A\u00020NH\u0002J\u0010\u0010O\u001A\u00020\u00042\u0006\u0010P\u001A\u00020\u0004H\u0002J\b\u0010Q\u001A\u00020RH\u0002J&\u0010S\u001A\u00020\u00042\u0006\u0010T\u001A\u00020(2\f\u0010U\u001A\b\u0012\u0004\u0012\u00020\u00040<2\u0006\u0010V\u001A\u00020RH\u0002J \u0010W\u001A\u00020\u00042\u0006\u0010X\u001A\u00020$2\u0006\u0010Y\u001A\u00020\u00042\u0006\u0010V\u001A\u00020RH\u0002J)\u0010Z\u001A\u00020\u00152\u0006\u0010V\u001A\u00020R2\u0012\u0010\u001B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403\"\u00020\u0004H\u0002¢\u0006\u0002\u0010[J \u0010\\\u001A\u00020\u00042\u0006\u0010X\u001A\u00020$2\u0006\u0010Y\u001A\u00020\u00042\u0006\u0010]\u001A\u00020\u0006H\u0002J\u0010\u0010^\u001A\u00020\"2\u0006\u0010%\u001A\u00020\u0004H\u0002J\"\u0010_\u001A\u00020\"2\u0006\u0010Y\u001A\u00020\u00042\b\u0010M\u001A\u0004\u0018\u00010\u00042\u0006\u0010V\u001A\u00020RH\u0002J#\u0010`\u001A\b\u0012\u0004\u0012\u00020\u00040<2\u000E\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000403H\u0002¢\u0006\u0002\u0010aJ\u0016\u0010b\u001A\u00020\u00042\f\u0010c\u001A\b\u0012\u0004\u0012\u00020\u00040<H\u0002J\u0016\u0010d\u001A\u00020\u00042\f\u0010c\u001A\b\u0012\u0004\u0012\u00020\u00040<H\u0002J\u0010\u0010e\u001A\u00020\u00042\u0006\u0010%\u001A\u00020\u0004H\u0002J\u0010\u0010f\u001A\u00020\u00042\u0006\u0010g\u001A\u00020\u0004H\u0002J\u0010\u0010h\u001A\u00020\"2\u0006\u0010i\u001A\u00020\u0004H\u0002J\u0010\u0010j\u001A\u00020\"2\u0006\u0010k\u001A\u00020\u0004H\u0002J0\u0010l\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010m\u001A\u00020\u00132\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010n\u001A\u0004\u0018\u00010\u0004H\u0002J\u001A\u0010o\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010p\u001A\u00020\u00062\u0006\u0010q\u001A\u00020\u0006J\u0010\u0010r\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0004H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006u"}, d2={"Lcom/flyfishxu/kadb/Kadb;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "host", "", "port", "", "connectTimeout", "socketTimeout", "<init>", "(Ljava/lang/String;III)V", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "(Ljava/lang/String;IIILcom/flyfishxu/kadb/KadbOptions;)V", "connection", "Lkotlin/Pair;", "Lcom/flyfishxu/kadb/core/AdbConnection;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "connectionCheck", "", "open", "Lcom/flyfishxu/kadb/stream/AdbStream;", "destination", "supportsFeature", "feature", "shell", "Lcom/flyfishxu/kadb/shell/AdbShellResponse;", "command", "openShell", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "openPtyShellSession", "Lcom/flyfishxu/kadb/shell/AdbPtyShellSession;", "term", "push", "", "src", "Ljava/io/File;", "remotePath", "mode", "lastModifiedMs", "", "source", "Lokio/Source;", "pull", "dst", "sink", "Lokio/Sink;", "openSync", "Lcom/flyfishxu/kadb/stream/AdbSyncStream;", "install", "file", "", "(Ljava/io/File;[Ljava/lang/String;)V", "size", "(Lokio/Source;J[Ljava/lang/String;)V", "pmInstallRemote", "(Ljava/lang/String;[Ljava/lang/String;)V", "pmInstall", "installMultiple", "apks", "", "(Ljava/util/List;[Ljava/lang/String;)V", "uninstall", "packageName", "execCmd", "([Ljava/lang/String;)Lcom/flyfishxu/kadb/stream/AdbStream;", "abbExec", "root", "unroot", "close", "resetConnection", "newConnection", "openStream", "retryOnStaleTransport", "discardConnection", "failedConnection", "isRecoverableTransportOpenFailure", "error", "", "extractSessionId", "response", "installSessionMode", "Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;", "createInstallSession", "totalLength", "installOptions", "sessionMode", "streamInstallWrite", "apk", "sessionId", "openInstallCommand", "(Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;[Ljava/lang/String;)Lcom/flyfishxu/kadb/stream/AdbStream;", "pushAndWrite", "index", "cleanupRemoteTempFile", "finalizeSession", "nonBlankOptions", "([Ljava/lang/String;)Ljava/util/List;", "buildShellCommand", "parts", "buildExecCmdService", "buildDeleteDeviceFileCommand", "escapeArg", "arg", "enforceLegacyShellServiceLength", "service", "requireShellV2", "apiName", "buildShellService", "useShellProtocol", "typeArg", "tcpForward", "hostPort", "targetPort", "restartAdb", "InstallSessionMode", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Kadb implements AutoCloseable {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00062\b\b\u0002\u0010\u0014\u001A\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0015J4\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0018\u001A\u00020\u00122\b\b\u0002\u0010\u0019\u001A\u00020\u00122\b\b\u0002\u0010\u001A\u001A\u00020\u001BJ\"\u0010\u001C\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u001A\u001A\u00020\u001BJ\"\u0010\u001D\u001A\u00060\u001Ej\u0002`\u001F2\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u0012R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Lcom/flyfishxu/kadb/Kadb$Companion;", "", "<init>", "()V", "OPEN_TRANSPORT_FAILURE_MARKERS", "", "", "SHELL_V2_FEATURE", "SHELL_SERVICE_BASE", "SHELL_ARG_V2", "SHELL_ARG_TERM_PREFIX", "SHELL_TYPE_RAW", "SHELL_TYPE_PTY", "DEFAULT_TERM_TYPE", "pair", "", "host", "port", "", "pairingCode", "name", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lcom/flyfishxu/kadb/Kadb;", "connectTimeout", "socketTimeout", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "tryConnection", "tcpForward", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "targetPort", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Kadb create(String arg8, int arg9, int arg10, int arg11, KadbOptions arg12) {
            Intrinsics.checkNotNullParameter(arg8, "host");
            Intrinsics.checkNotNullParameter(arg12, "options");
            return new Kadb(arg8, arg9, arg10, arg11, arg12, null);
        }

        public static Kadb create$default(Companion arg1, String arg2, int arg3, int arg4, int arg5, KadbOptions arg6, int arg7, Object arg8) {
            if((arg7 & 16) != 0) {
                arg6 = new KadbOptions(null, 1, null);
            }

            return arg1.create(arg2, arg3, 0, 0, arg6);
        }

        public final Object pair(String arg7, int arg8, String arg9, String arg10, Continuation arg11) {
            Object v6 = BuildersKt.withContext(Dispatchers.getDefault(), new Kadb$Companion$pair$2(arg7, arg8, arg9, arg10, null), arg11);
            if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v6;
            }

            return Unit.INSTANCE;
        }

        public static Object pair$default(Companion arg6, String arg7, int arg8, String arg9, String arg10, Continuation arg11, int arg12, Object arg13) {
            if((arg12 & 8) != 0) {
                arg10 = DefaultDeviceName_androidKt.defaultDeviceName$default(null, 1, null);
            }

            return arg6.pair(arg7, arg8, arg9, arg10, arg11);
        }

        public final AutoCloseable tcpForward(String arg8, int arg9, int arg10) {
            Intrinsics.checkNotNullParameter(arg8, "host");
            return new Kadb(arg8, arg9, 0, 0, 12, null).tcpForward(arg9, arg10);
        }

        public final Kadb tryConnection(String arg11, int arg12, KadbOptions arg13) {
            Object v1_1;
            Object v10_1;
            Object v11;
            Kadb v10;
            Intrinsics.checkNotNullParameter(arg11, "host");
            Intrinsics.checkNotNullParameter(arg13, "options");
            Kadb v1 = null;
            try {
                v10 = Companion.create$default(this, arg11, arg12, 0, 0, arg13, 12, null);
            }
            catch(Throwable v0) {
                goto label_45;
            }

            try {
                v11 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(v10.shell("echo success").getAllOutput(), "success\n")));
                goto label_30;
            }
            catch(Throwable v0) {
                Throwable v11_1 = v0;
                try {
                    v11 = Result.constructor-impl(ResultKt.createFailure(v11_1));
                label_30:
                    Throwable v12 = Result.exceptionOrNull-impl(v11);
                    if(v12 == null) {
                        if(((Boolean)v11).booleanValue()) {
                        }
                        else {
                            v10.close();
                            v10_1 = v1;
                        }

                        v10_1 = Result.constructor-impl(v10);
                        goto label_46;
                    }

                    v10.close();
                    throw v12;
                }
                catch(Throwable v0) {
                label_45:
                    v10_1 = Result.constructor-impl(ResultKt.createFailure(v0));
                }
            }

        label_46:
            if(Result.isFailure-impl(v10_1)) {
            }
            else {
                v1_1 = v10_1;
            }

            return ((Kadb)v1_1);
        }

        public static Kadb tryConnection$default(Companion arg0, String arg1, int arg2, KadbOptions arg3, int arg4, Object arg5) {
            if((arg4 & 4) != 0) {
                arg3 = new KadbOptions(null, 1, null);
            }

            return arg0.tryConnection(arg1, arg2, arg3);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Lcom/flyfishxu/kadb/Kadb$InstallSessionMode;", "", "usesStreaming", "", "<init>", "(Ljava/lang/String;IZ)V", "getUsesStreaming", "()Z", "ABB_EXEC", "EXEC_CMD", "PM_SHELL", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) enum InstallSessionMode {
        public static final enum InstallSessionMode ABB_EXEC;
        public static final enum InstallSessionMode EXEC_CMD;
        public static final enum InstallSessionMode PM_SHELL;
        private final boolean usesStreaming;

        private static final InstallSessionMode[] $values() {
            return new InstallSessionMode[]{InstallSessionMode.ABB_EXEC, InstallSessionMode.EXEC_CMD, InstallSessionMode.PM_SHELL};
        }

        static {
            InstallSessionMode.ABB_EXEC = new InstallSessionMode("ABB_EXEC", 0, true);
            InstallSessionMode.EXEC_CMD = new InstallSessionMode("EXEC_CMD", 1, true);
            InstallSessionMode.PM_SHELL = new InstallSessionMode("PM_SHELL", 2, false);
            InstallSessionMode[] v0 = InstallSessionMode.$values();
            InstallSessionMode.$VALUES = v0;
            InstallSessionMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private InstallSessionMode(String arg1, int arg2, boolean arg3) {
            super(arg1, arg2);
            this.usesStreaming = arg3;
        }

        public static EnumEntries getEntries() {
            return InstallSessionMode.$ENTRIES;
        }

        public final boolean getUsesStreaming() {
            return this.usesStreaming;
        }

        public static InstallSessionMode valueOf(String arg1) {
            return Enum.valueOf(InstallSessionMode.class, arg1);
        }

        public static InstallSessionMode[] values() {
            return InstallSessionMode.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[InstallSessionMode.values().length];
            try {
                v0[InstallSessionMode.ABB_EXEC.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[InstallSessionMode.EXEC_CMD.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[InstallSessionMode.PM_SHELL.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final Companion Companion = null;
    private static final String DEFAULT_TERM_TYPE = "xterm-256color";
    private static final List OPEN_TRANSPORT_FAILURE_MARKERS = null;
    private static final String SHELL_ARG_TERM_PREFIX = "TERM=";
    private static final String SHELL_ARG_V2 = "v2";
    private static final String SHELL_SERVICE_BASE = "shell";
    private static final String SHELL_TYPE_PTY = "pty";
    private static final String SHELL_TYPE_RAW = "raw";
    private static final String SHELL_V2_FEATURE = "shell_v2";
    private final int connectTimeout;
    private Pair connection;
    private final String host;
    private KadbOptions options;
    private final int port;
    private final int socketTimeout;

    static {
        Kadb.Companion = new Companion(null);
        Kadb.OPEN_TRANSPORT_FAILURE_MARKERS = CollectionsKt.listOf(new String[]{"broken pipe", "connection reset", "connection aborted", "socket closed", "stream closed", "transport closed", "closed", "eof", "disconnected", "connection closed"});
    }

    public Kadb(String arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg2, "host");
        super();
        this.host = arg2;
        this.port = arg3;
        this.connectTimeout = arg4;
        this.socketTimeout = arg5;
        this.options = new KadbOptions(null, 1, null);
    }

    public Kadb(String arg2, int arg3, int arg4, int arg5, int arg6, DefaultConstructorMarker arg7) {
        this(arg2, arg3, 0, 0);
    }

    private Kadb(String arg1, int arg2, int arg3, int arg4, KadbOptions arg5) {
        this(arg1, arg2, arg3, arg4);
        this.options = arg5;
    }

    public Kadb(String arg1, int arg2, int arg3, int arg4, KadbOptions arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public final AdbStream abbExec(String[] arg11) {
        Intrinsics.checkNotNullParameter(arg11, "command");
        return this.open("abb_exec:" + ArraysKt.joinToString$default(arg11, "\u0000", null, null, 0, null, null, 62, null));
    }

    public static final int access$getConnectTimeout$p(Kadb arg0) {
        return arg0.connectTimeout;
    }

    public static final String access$getHost$p(Kadb arg0) {
        return arg0.host;
    }

    public static final KadbOptions access$getOptions$p(Kadb arg0) {
        return arg0.options;
    }

    public static final int access$getPort$p(Kadb arg0) {
        return arg0.port;
    }

    public static final int access$getSocketTimeout$p(Kadb arg0) {
        return arg0.socketTimeout;
    }

    private final String buildDeleteDeviceFileCommand(String arg2) {
        return "rm " + this.escapeArg(arg2) + " </dev/null";
    }

    private final String buildExecCmdService(List arg11) {
        ArrayList v0 = new ArrayList();
        Iterator v11 = ((Iterable)arg11).iterator();
        while(v11.hasNext()) {
            Object v1 = v11.next();
            if(StringsKt.isBlank(v1)) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        String v10 = CollectionsKt.joinToString$default(v0, " ", null, null, 0, null, new Kadb$$ExternalSyntheticLambda0(this), 30, null);
        if(v10.length() == 0) {
            return "exec:cmd";
        }

        return "exec:cmd " + v10;
    }

    static final CharSequence buildExecCmdService$lambda$1(Kadb arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.escapeArg(arg2);
    }

    private final String buildShellCommand(List arg11) {
        ArrayList v0 = new ArrayList();
        Iterator v11 = ((Iterable)arg11).iterator();
        while(v11.hasNext()) {
            Object v1 = v11.next();
            if(StringsKt.isBlank(v1)) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        return CollectionsKt.joinToString$default(v0, " ", null, null, 0, null, new Kadb$$ExternalSyntheticLambda1(this), 30, null);
    }

    static final CharSequence buildShellCommand$lambda$1(Kadb arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.escapeArg(arg2);
    }

    private final String buildShellService(String arg10, boolean arg11, String arg12, String arg13) {
        ArrayList v9 = new ArrayList();
        if(arg11) {
            ArrayList v11 = v9;
            ((Collection)v11).add("v2");
            String v0 = arg12;
            if(v0 != null) {
                if(StringsKt.isBlank(((CharSequence)v0))) {
                }
                else {
                    ((Collection)v11).add("TERM=" + arg12);
                }
            }
        }

        String v11_1 = arg13;
        if(v11_1 != null) {
            if(StringsKt.isBlank(((CharSequence)v11_1))) {
            }
            else {
                v9.add(arg13);
            }
        }

        String v9_1 = ((List)v9).isEmpty() ? "shell" : "shell," + CollectionsKt.joinToString$default(v9, ",", null, null, 0, null, null, 62, null);
        return v9_1 + ":" + arg10;
    }

    static String buildShellService$default(Kadb arg1, String arg2, boolean arg3, String arg4, String arg5, int arg6, Object arg7) {
        String v0 = null;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = v0;
        }

        return arg1.buildShellService(arg2, arg3, arg4, arg5);
    }

    private final void cleanupRemoteTempFile(String arg2) {
        try {
            Result.constructor-impl(this.shell(this.buildDeleteDeviceFileCommand(arg2)));
            return;
        }
        catch(Throwable v1) {
            Result.constructor-impl(ResultKt.createFailure(v1));
            return;
        }
    }

    public void close() {
        Pair v0 = this.connection;
        if(v0 != null) {
            Object v0_1 = v0.getFirst();
            if(v0_1 != null) {
                ((AdbConnection)v0_1).close();
            }
        }

        this.connection = null;
    }

    private final AdbConnection connection() {
        Pair v0 = this.connection;
        if(v0 != null) {
            if(!v0.getSecond().isOpen()) {
            }
            else {
                return v0.getFirst();
            }
        }

        v0 = this.newConnection();
        this.connection = v0;
        return v0.getFirst();
    }

    public final boolean connectionCheck() {
        Pair v2 = this.connection;
        if(v2 != null) {
            Object v2_1 = v2.getSecond();
            if(v2_1 != null && (((TransportChannel)v2_1).isOpen())) {
                return 1;
            }
        }

        return 0;
    }

    private final String createInstallSession(long arg8, List arg10, InstallSessionMode arg11) {
        String v9;
        String v8;
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg11.ordinal()];
        String v2 = "-S";
        String v3 = "install-create";
        if(v0 != 1) {
            int v5 = 2;
            if(v0 != v5) {
                int v11 = 3;
                if(v0 == v11) {
                    String[] v0_1 = new String[4];
                    v0_1[0] = "pm";
                    v0_1[1] = v3;
                    v0_1[v5] = v2;
                    v0_1[v11] = String.valueOf(arg8);
                    v8 = this.shell(this.buildShellCommand(CollectionsKt.plus(CollectionsKt.listOf(((Object[])v0_1)), ((Iterable)arg10)))).getAllOutput();
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else {
                goto label_29;
            }
        }
        else {
        label_29:
            SpreadBuilder v0_2 = new SpreadBuilder(5);
            v0_2.add("package");
            v0_2.add(v3);
            v0_2.add(v2);
            v0_2.add(String.valueOf(arg8));
            v0_2.addSpread(((Collection)arg10).toArray(new String[0]));
            AdbStream v8_1 = this.openInstallCommand(arg11, v0_2.toArray(new String[v0_2.size()]));
            try {
                v9 = v8_1.getSource().readUtf8();
            }
            catch(Throwable v7) {
                try {
                    throw v7;
                }
                catch(Throwable v9_1) {
                    AutoCloseableKt.closeFinally(((AutoCloseable)v8_1), v7);
                    throw v9_1;
                }
            }

            AutoCloseableKt.closeFinally(((AutoCloseable)v8_1), null);
            v8 = v9;
        }

        return this.extractSessionId(v8);
    }

    private final void discardConnection(AdbConnection arg2) {
        Object v1_1;
        Pair v0 = this.connection;
        if(v0 != null) {
            Object v0_1 = v0.getFirst();
        }
        else {
            AdbConnection v0_2 = null;
        }

        if((((AdbConnection)v0_1)) == arg2) {
            this.resetConnection();
            return;
        }

        try {
            arg2.close();
            v1_1 = Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v1) {
            v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        Result.box-impl(v1_1);
    }

    private final void enforceLegacyShellServiceLength(String arg1) {
        if(StringsKt.encodeToByteArray(arg1).length <= 0x1000) {
            return;
        }

        throw new IllegalArgumentException("error: shell command too long".toString());
    }

    private final String escapeArg(String arg7) {
        return "\'" + StringsKt.replace$default(arg7, "\'", "\'\\\'\'", false, 4, null) + "\'";
    }

    public final AdbStream execCmd(String[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "command");
        return this.open(this.buildExecCmdService(ArraysKt.asList(((Object[])arg2))));
    }

    private final String extractSessionId(String arg4) {
        MatchResult v3 = Regex.find$default(new Regex("\\[(\\w+)]"), ((CharSequence)arg4), 0, 2, null);
        if(v3 != null) {
            List v3_1 = v3.getGroupValues();
            if(v3_1 != null) {
                Object v3_2 = v3_1.get(1);
                if(v3_2 != null) {
                    return ((String)v3_2);
                }
            }
        }

        throw new IOException("Failed to create session");
    }

    private final void finalizeSession(String arg8, String arg9, InstallSessionMode arg10) {
        String v7;
        String v0 = arg9 == null ? "install-commit" : "install-abandon";
        int v1 = WhenMappings.$EnumSwitchMapping$0[arg10.ordinal()];
        Throwable v2 = null;
        int v4 = 3;
        int v6 = 2;
        if(v1 == 1 || v1 == v6) {
            String[] v1_1 = new String[v4];
            v1_1[0] = "package";
            v1_1[1] = v0;
            v1_1[v6] = arg8;
            AdbStream v7_1 = this.openInstallCommand(arg10, v1_1);
            try {
                arg8 = v7_1.getSource().readUtf8();
            }
            catch(Throwable v8) {
                try {
                    throw v8;
                }
                catch(Throwable v9) {
                    AutoCloseableKt.closeFinally(((AutoCloseable)v7_1), v8);
                    throw v9;
                }
            }

            AutoCloseableKt.closeFinally(((AutoCloseable)v7_1), v2);
            v7 = arg8;
        }
        else if(v1 == v4) {
            String[] v10 = new String[v4];
            v10[0] = "pm";
            v10[1] = v0;
            v10[v6] = arg8;
            v7 = this.shell(this.buildShellCommand(CollectionsKt.listOf(((Object[])v10)))).getAllOutput();
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        if(StringsKt.startsWith$default(v7, "Success", false, v6, v2)) {
            if(arg9 == null) {
                return;
            }

            throw new IOException("Install failed: " + arg9);
        }

        throw new IllegalStateException("Failed to finalize session: " + v7.toString());
    }

    public final void install(File arg4, String[] arg5) {
        Intrinsics.checkNotNullParameter(arg4, "file");
        Intrinsics.checkNotNullParameter(arg5, "options");
        if(this.supportsFeature("cmd")) {
            this.install(Okio.source(arg4), arg4.length(), Arrays.copyOf(((Object[])arg5), arg5.length));
            return;
        }

        this.pmInstall(arg4, Arrays.copyOf(((Object[])arg5), arg5.length));
    }

    public final void install(Source arg8, long arg9, String[] arg11) {
        Source v2;
        Kadb v1_2;
        int v4;
        long v5;
        Object v1_1;
        String v8;
        String v0 = "Install failed: ";
        Intrinsics.checkNotNullParameter(arg8, "source");
        Intrinsics.checkNotNullParameter(arg11, "options");
        if(!this.supportsFeature("cmd")) {
            goto label_55;
        }

        SpreadBuilder v1 = new SpreadBuilder(5);
        v1.add("package");
        v1.add("install");
        v1.add("-S");
        v1.add(String.valueOf(arg9));
        v1.addSpread(arg11);
        AdbStream v7 = this.execCmd(v1.toArray(new String[v1.size()]));
        try {
            v7.getSink().writeAll(arg8);
            v7.getSink().flush();
            v8 = v7.getSource().readUtf8();
            v1_1 = null;
            if(!StringsKt.startsWith$default(v8, "Success", false, 2, v1_1)) {
                goto label_40;
            }
        }
        catch(Throwable v0_1) {
            goto label_49;
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v7), ((Throwable)v1_1));
        return;
        try {
        label_40:
            throw new IllegalStateException(v0 + v8.toString());
        }
        catch(Throwable v0_1) {
        label_49:
            Throwable v8_1 = v0_1;
            try {
                throw v8_1;
            }
            catch(Throwable v0_1) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v7), v8_1);
                throw v0_1;
            }
        }

    label_55:
        String v3 = "/data/local/tmp/kadb-install-" + System.nanoTime() + ".apk";
        try {
            v5 = System.currentTimeMillis();
            v4 = 420;
            v1_2 = this;
            v2 = arg8;
        }
        catch(Throwable v0_1) {
            v1_2 = this;
            goto label_77;
        }

        try {
            v1_2.push(v2, v3, v4, v5);
            v1_2.pmInstallRemote(v3, Arrays.copyOf(((Object[])arg11), arg11.length));
            goto label_71;
        }
        catch(Throwable v0_1) {
        }

    label_77:
        v1_2.cleanupRemoteTempFile(v3);
        throw v0_1;
    label_71:
        v1_2.cleanupRemoteTempFile(v3);
    }

    public final void installMultiple(List arg10, String[] arg11) {
        String v5_1;
        String v1_2;
        Iterator v10;
        Intrinsics.checkNotNullParameter(arg10, "apks");
        Intrinsics.checkNotNullParameter(arg11, "options");
        List v11 = this.nonBlankOptions(arg11);
        InstallSessionMode v0 = this.installSessionMode();
        Iterator v1 = ((Iterable)arg10).iterator();
        long v2;
        for(v2 = 0; v1.hasNext(); v2 += v1.next().length()) {
        }

        String v11_1 = this.createInstallSession(v2, v11, v0);
        int v2_1 = 2;
        String v3 = "Success";
        Object v5 = null;
        if(v0.getUsesStreaming()) {
            v10 = ((Iterable)arg10).iterator();
            goto label_22;
        }
        else {
            ArrayList v1_1 = new ArrayList();
            v10 = ((Iterable)arg10).iterator();
            int v6;
            for(v6 = 0; v10.hasNext(); v6 = v8) {
                Object v7 = v10.next();
                int v8 = v6 + 1;
                if(v6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                String v6_1 = this.pushAndWrite(((File)v7), v11_1, v6);
                if(!StringsKt.startsWith$default(v6_1, v3, false, v2_1, v5)) {
                }
                else {
                    v6_1 = ((String)v5);
                }

                if(v6_1 != null) {
                    ((Collection)v1_1).add(v6_1);
                }
            }

            v5 = CollectionsKt.firstOrNull(((List)v1_1));
            goto label_54;
            do {
            label_22:
                if(!v10.hasNext()) {
                    goto label_54;
                }

                v1_2 = this.streamInstallWrite(v10.next(), v11_1, v0);
                if(!StringsKt.startsWith$default(v1_2, v3, false, v2_1, v5)) {
                }
                else {
                    v1_2 = ((String)v5);
                }
            }
            while(v1_2 == null);

            v5_1 = v1_2;
        }

    label_54:
        this.finalizeSession(v11_1, v5_1, v0);
    }

    private final InstallSessionMode installSessionMode() {
        if(this.supportsFeature("abb_exec")) {
            return InstallSessionMode.ABB_EXEC;
        }

        if(this.supportsFeature("cmd")) {
            return InstallSessionMode.EXEC_CMD;
        }

        return InstallSessionMode.PM_SHELL;
    }

    private final boolean isRecoverableTransportOpenFailure(Throwable arg9) {
        if((arg9 instanceof EOFException)) {
            return 1;
        }

        if(!(arg9 instanceof IOException)) {
            if((arg9 instanceof IllegalStateException)) {
            }
            else {
                arg9 = arg9.getCause();
                if(arg9 != null && (this.isRecoverableTransportOpenFailure(arg9))) {
                    return 1;
                }

                return 0;
            }
        }

        String v0 = arg9.getMessage();
        if(v0 == null) {
            v0 = "";
        }

        v0 = v0.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
        List v3 = Kadb.OPEN_TRANSPORT_FAILURE_MARKERS;
        if(!(v3 instanceof Collection) || !v3.isEmpty()) {
            Iterator v3_1 = ((Iterable)v3).iterator();
            do {
                if(v3_1.hasNext()) {
                    if(!StringsKt.contains$default(v0, v3_1.next(), false, 2, null)) {
                        continue;
                    }

                    return 1;
                }
                else {
                    goto label_40;
                }
            }
            while(true);

            return 1;
        label_40:
            arg9 = arg9.getCause();
            if(arg9 != null && (this.isRecoverableTransportOpenFailure(arg9))) {
                return 1;
            }

            return 0;
        }
        else {
            goto label_40;
        }

        return 1;
    }

    private final Pair newConnection() {
        return BuildersKt.runBlocking$default(null, new Kadb$newConnection$1(this, null), 1, null);
    }

    private final List nonBlankOptions(String[] arg5) {
        ArrayList v4 = new ArrayList();
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            String v2 = arg5[v1];
            if(!StringsKt.isBlank(v2)) {
                ((Collection)v4).add(v2);
            }
        }

        return ((List)v4);
    }

    public final AdbStream open(String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "destination");
        return Kadb.openStream$default(this, arg4, false, 2, null).getSecond();
    }

    private final AdbStream openInstallCommand(InstallSessionMode arg2, String[] arg3) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }

                throw new IllegalStateException("Legacy pm shell path does not open streamed install commands".toString());
            }

            return this.execCmd(Arrays.copyOf(((Object[])arg3), arg3.length));
        }

        return this.abbExec(Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    public final AdbPtyShellSession openPtyShellSession(String arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "command");
        Intrinsics.checkNotNullParameter(arg4, "term");
        this.requireShellV2("openPtyShellSession");
        return new AdbPtyShellSession(new AdbShellStream(this.open(this.buildShellService(arg3, true, arg4, "pty"))));
    }

    public static AdbPtyShellSession openPtyShellSession$default(Kadb arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = "";
        }

        if((arg3 & 2) != 0) {
            arg2 = "xterm-256color";
        }

        return arg0.openPtyShellSession(arg1, arg2);
    }

    public final AdbShellStream openShell(String arg9) {
        Intrinsics.checkNotNullParameter(arg9, "command");
        this.requireShellV2("openShell");
        return new AdbShellStream(this.open(Kadb.buildShellService$default(this, arg9, true, null, "raw", 4, null)));
    }

    public static AdbShellStream openShell$default(Kadb arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = "";
        }

        return arg0.openShell(arg1);
    }

    private final Pair openStream(String arg4, boolean arg5) {
        Pair v3;
        AdbConnection v0 = this.connection();
        try {
            v3 = TuplesKt.to(v0, v0.open(arg4));
            return v3;
        }
        catch(Throwable v1) {
            if(((Kadb)v3).isRecoverableTransportOpenFailure(v1)) {
                ((Kadb)v3).discardConnection(v0);
                if(arg5) {
                    return ((Kadb)v3).openStream(arg4, false);
                }

                throw v1;
            }

            throw v1;
        }
    }

    static Pair openStream$default(Kadb arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.openStream(arg1, true);
    }

    public final AdbSyncStream openSync() {
        Pair v4 = Kadb.openStream$default(this, "sync:", false, 2, null);
        return new AdbSyncStream(v4.component2(), v4.component1().featureSnapshot$kadb());
    }

    private final void pmInstall(File arg8, String[] arg9) {
        String v3 = "/data/local/tmp/" + arg8.getName();
        int v4 = Kadb_androidKt.readMode(this, arg8);
        long v5 = arg8.lastModified();
        Kadb v1 = this;
        File v2 = arg8;
        try {
            v1.push(v2, v3, v4, v5);
            v1.pmInstallRemote(v3, Arrays.copyOf(((Object[])arg9), arg9.length));
        }
        catch(Throwable v0) {
            v1.cleanupRemoteTempFile(v3);
            throw v0;
        }

        v1.cleanupRemoteTempFile(v3);
    }

    private final void pmInstallRemote(String arg6, String[] arg7) {
        AdbShellResponse v5 = this.shell(this.buildShellCommand(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.listOf(new String[]{"pm", "install"}), this.nonBlankOptions(arg7)), arg6)));
        if(StringsKt.startsWith$default(v5.getAllOutput(), "Success", false, 2, null)) {
            return;
        }

        throw new IllegalStateException("Install failed: " + v5.getAllOutput().toString());
    }

    public final void pull(File arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "dst");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        this.pull(Okio.sink(arg2, false), arg3);
    }

    public final void pull(Sink arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        AdbSyncStream v1 = this.openSync();
        try {
            v1.recv(arg2, arg3);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v1), v2);
                throw v3;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v1), null);
    }

    public final void push(File arg2, String arg3, int arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg2, "src");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        this.push(Okio.source(arg2), arg3, arg4, arg5);
    }

    public final void push(Source arg7, String arg8, int arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg7, "source");
        Intrinsics.checkNotNullParameter(arg8, "remotePath");
        AdbSyncStream v6 = this.openSync();
        try {
            v6.send(arg7, arg8, arg9, arg10);
        }
        catch(Throwable v0) {
            Throwable v7 = v0;
            try {
                throw v7;
            }
            catch(Throwable v0) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v6), v7);
                throw v0;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v6), null);
    }

    public static void push$default(Kadb arg6, File arg7, String arg8, int arg9, long arg10, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg9 = Kadb_androidKt.readMode(arg6, arg7);
        }

        int v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = arg7.lastModified();
        }

        arg6.push(arg7, arg8, v3, arg10);
    }

    private final String pushAndWrite(File arg8, String arg9, int arg10) {
        String v7;
        String v3 = "/data/local/tmp/" + arg8.getName();
        int v4 = Kadb_androidKt.readMode(this, arg8);
        long v5 = arg8.lastModified();
        Kadb v1 = this;
        File v2 = arg8;
        try {
            v1.push(v2, v3, v4, v5);
            v7 = v1.shell(v1.buildShellCommand(CollectionsKt.listOf(new String[]{"pm", "install-write", "-S", String.valueOf(v2.length()), arg9, String.valueOf(arg10), v3}))).getAllOutput();
        }
        catch(Throwable v0) {
            v1.cleanupRemoteTempFile(v3);
            throw v0;
        }

        v1.cleanupRemoteTempFile(v3);
        return v7;
    }

    private final void requireShellV2(String arg2) {
        if(this.supportsFeature("shell_v2")) {
            return;
        }

        throw new IllegalStateException(arg2 + " requires peer feature \'shell_v2\'; use shell(command) for legacy shell fallback.".toString());
    }

    public final void resetConnection() {
        Pair v0 = this.connection;
        if(v0 != null) {
            Object v0_1 = v0.getFirst();
            if(v0_1 != null) {
                ((AdbConnection)v0_1).close();
            }
        }

        this.connection = null;
    }

    private final String restartAdb(String arg2) {
        AdbStream v1 = this.open(arg2);
        try {
            arg2 = KadbKt.access$readUntil(v1.getSource(), 10).readString(Charsets.UTF_8);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v0) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v1), v2);
                throw v0;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v1), null);
        return arg2;
    }

    public final String root() {
        return this.restartAdb("root:");
    }

    public final AdbShellResponse shell(String arg10) {
        AdbShellResponse v0_1;
        Throwable v10_1;
        AdbShellResponse v10;
        Intrinsics.checkNotNullParameter(arg10, "command");
        Throwable v1 = null;
        if(this.supportsFeature("shell_v2")) {
            AdbShellStream v9 = this.openShell(arg10);
            try {
                v10 = v9.readAll();
            }
            catch(Throwable v0) {
                v10_1 = v0;
                try {
                    throw v10_1;
                }
                catch(Throwable v0) {
                    AutoCloseableKt.closeFinally(((AutoCloseable)v9), v10_1);
                    throw v0;
                }
            }

            AutoCloseableKt.closeFinally(((AutoCloseable)v9), v1);
            return v10;
        }

        Kadb v2 = this;
        String v9_1 = Kadb.buildShellService$default(v2, arg10, false, null, null, 12, null);
        v2.enforceLegacyShellServiceLength(v9_1);
        AdbStream v9_2 = v2.open(v9_1);
        try {
            v0_1 = new AdbShellResponse(v9_2.getSource().readUtf8(), "", 0);
        }
        catch(Throwable v0) {
            v10_1 = v0;
            try {
                throw v10_1;
            }
            catch(Throwable v0) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v9_2), v10_1);
                throw v0;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v9_2), v1);
        return v0_1;
    }

    private final String streamInstallWrite(File arg4, String arg5, InstallSessionMode arg6) {
        String v4_1;
        String[] v0 = new String[7];
        v0[0] = "package";
        v0[1] = "install-write";
        v0[2] = "-S";
        v0[3] = String.valueOf(arg4.length());
        v0[4] = arg5;
        arg5 = arg4.getName();
        Intrinsics.checkNotNullExpressionValue(arg5, "getName(...)");
        v0[5] = arg5;
        v0[6] = "-";
        AdbStream v3 = this.openInstallCommand(arg6, v0);
        try {
            v3.getSink().writeAll(Okio.source(arg4));
            v3.getSink().flush();
            v4_1 = v3.getSource().readUtf8();
        }
        catch(Throwable v4) {
            try {
                throw v4;
            }
            catch(Throwable v5) {
                AutoCloseableKt.closeFinally(((AutoCloseable)v3), v4);
                throw v5;
            }
        }

        AutoCloseableKt.closeFinally(((AutoCloseable)v3), null);
        return v4_1;
    }

    public final boolean supportsFeature(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "feature");
        return this.connection().supportsFeature(arg2);
    }

    public final AutoCloseable tcpForward(int arg2, int arg3) throws InterruptedException {
        TcpForwarder v0 = new TcpForwarder(this, arg2, arg3);
        v0.start();
        return ((AutoCloseable)v0);
    }

    public final void uninstall(String arg8) {
        List v8;
        Intrinsics.checkNotNullParameter(arg8, "packageName");
        String v0 = "cmd";
        int v2 = 2;
        String v3 = "uninstall";
        int v6 = 3;
        if(this.supportsFeature(v0)) {
            String[] v1 = new String[4];
            v1[0] = v0;
            v1[1] = "package";
            v1[v2] = v3;
            v1[v6] = arg8;
            v8 = CollectionsKt.listOf(((Object[])v1));
        }
        else {
            String[] v0_1 = new String[v6];
            v0_1[0] = "pm";
            v0_1[1] = v3;
            v0_1[v2] = arg8;
            v8 = CollectionsKt.listOf(((Object[])v0_1));
        }

        AdbShellResponse v7 = this.shell(this.buildShellCommand(v8));
        if(v7.getExitCode() == 0) {
            return;
        }

        throw new IllegalStateException("Uninstall failed: " + v7.getAllOutput().toString());
    }

    public final String unroot() {
        return this.restartAdb("unroot:");
    }
}

