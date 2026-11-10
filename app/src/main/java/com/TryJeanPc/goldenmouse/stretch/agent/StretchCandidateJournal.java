package com.TryJeanPc.goldenmouse.stretch.agent;

import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\"BQ\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\u0018\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0018\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u001E\u001A\u00020\u001FH\u0002J\u0018\u0010 \u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002J\b\u0010!\u001A\u00020\u000BH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;", "read", "Ljava/nio/channels/FileChannel;", "write", "lock", "Ljava/nio/channels/FileLock;", "closeChannels", "Lkotlin/Function0;", "", "fault", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateWriteStage;", "readOnly", "", "<init>", "(Ljava/nio/channels/FileChannel;Ljava/nio/channels/FileChannel;Ljava/nio/channels/FileLock;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "closed", "load", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "commit", "record", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "expectedRevision", "", "bytes", "", "offset", "size", "", "put", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCandidateJournal implements StretchPhysicalJournal, AutoCloseable {
    @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\n \u000F*\u0004\u0018\u00010\u000E0\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0002J5\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0014\b\u0002\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u001AH\u0000¢\u0006\u0002\b\u001BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal$Companion;", "", "<init>", "()V", "TOTAL", "", "HEADER", "SLOT", "MAGIC", "CANDIDATE_SCOPE", "localHosts", "", "", "digest", "", "kotlin.jvm.PlatformType", "bytes", "host", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "file", "Ljava/io/File;", "fault", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateWriteStage;", "", "readOnly", "", "host$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final byte[] access$digest(Companion arg0, byte[] arg1) {
            return arg0.digest(arg1);
        }

        private final byte[] digest(byte[] arg1) {
            return MessageDigest.getInstance("SHA-256").digest(arg1);
        }

        public final StretchCandidateJournal host$app(File arg17, Function1 arg18, boolean arg19) {
            FileChannel v1_1;
            FileChannel v0_5;
            Path v4;
            File v1 = arg17;
            Intrinsics.checkNotNullParameter(v1, "file");
            Function1 v6 = arg18;
            Intrinsics.checkNotNullParameter(v6, "fault");
            String v8 = v1.getCanonicalPath();
            Set v2 = StretchCandidateJournal.localHosts;
            __monitor_enter(v2);
            try {
                Set v0_1 = StretchCandidateJournal.localHosts;
                Intrinsics.checkNotNull(v8);
                if(!v0_1.add(v8)) {
                    goto label_125;
                }
            }
            catch(Throwable v0) {
                goto label_131;
            }

            __monitor_exit(v2);
            ObjectRef v9 = new ObjectRef();
            try {
                if(!v1.exists()) {
                    if(!arg19) {
                        Files.createFile(v1.toPath(), new FileAttribute[]{PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"))});
                    }
                    else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }

                if(!Files.isSymbolicLink(v1.toPath()) && (Intrinsics.areEqual(Files.getPosixFilePermissions(v1.toPath(), new LinkOption[0]), PosixFilePermissions.fromString("rw-------")))) {
                    int v0_3 = 2;
                    if(arg19) {
                        v4 = v1.toPath();
                        OpenOption[] v0_4 = new OpenOption[v0_3];
                        v0_4[0] = StandardOpenOption.READ;
                        v0_4[1] = LinkOption.NOFOLLOW_LINKS;
                        v0_5 = FileChannel.open(v4, v0_4);
                    }
                    else {
                        v4 = v1.toPath();
                        OpenOption[] v5 = new OpenOption[3];
                        v5[0] = StandardOpenOption.READ;
                        v5[1] = StandardOpenOption.WRITE;
                        v5[v0_3] = LinkOption.NOFOLLOW_LINKS;
                        v0_5 = FileChannel.open(v4, v5);
                    }

                    v9.element = v0_5;
                    if(!arg19) {
                        v1_1 = FileChannel.open(v1.toPath().toAbsolutePath().getParent(), new OpenOption[]{StandardOpenOption.READ});
                        goto label_75;
                    }

                    goto label_87;
                }

                goto label_107;
            }
            catch(Exception v0_2) {
                goto label_113;
            }

        label_75:
            v0_5 = v1_1;
            try {
                v0_5.force(true);
                v0 = null;
                goto label_79;
            }
            catch(Throwable v0) {
                Throwable v2_1 = v0;
                try {
                    throw v2_1;
                }
                catch(Throwable v0) {
                    try {
                        CloseableKt.closeFinally(((Closeable)v1_1), v2_1);
                        throw v0;
                    label_79:
                        CloseableKt.closeFinally(((Closeable)v1_1), v0);
                    label_87:
                        FileLock v4_1 = v9.element.tryLock(0, 0x7FFFFFFFFFFFFFFFL, arg19);
                        Object v0_6 = v9.element;
                        Intrinsics.checkNotNullExpressionValue(v0_6, "element");
                        Object v2_2 = v0_6;
                        v0_6 = v9.element;
                        Intrinsics.checkNotNullExpressionValue(v0_6, "element");
                        return new StretchCandidateJournal(((FileChannel)v2_2), v0_6, v4_1, new StretchCandidateJournal$Companion$$ExternalSyntheticLambda1(v9, v8), v6, arg19);
                    label_107:
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    catch(Exception v0_2) {
                    label_113:
                        Object v1_2 = v9.element;
                        if(v1_2 != null) {
                            ((FileChannel)v1_2).close();
                        }

                        Set v1_3 = StretchCandidateJournal.localHosts;
                        __monitor_enter(v1_3);
                        try {
                            StretchCandidateJournal.localHosts.remove(v8);
                        }
                        catch(Throwable v0) {
                            __monitor_exit(v1_3);
                            throw v0;
                        }

                        __monitor_exit(v1_3);
                        throw v0_2;
                    }
                }
            }

            try {
            label_125:
                throw new IllegalArgumentException("Journal already owned in this process".toString());
            }
            catch(Throwable v0) {
            label_131:
                __monitor_exit(v2);
                throw v0;
            }
        }

        public static StretchCandidateJournal host$app$default(Companion arg0, File arg1, Function1 arg2, boolean arg3, int arg4, Object arg5) {
            StretchCandidateJournal$Companion$$ExternalSyntheticLambda0 v2;
            if((arg4 & 2) != 0) {
                v2 = new StretchCandidateJournal$Companion$$ExternalSyntheticLambda0();
            }

            return arg0.host$app(arg1, ((Function1)v2), false);
        }

        static final Unit host$lambda$0(CandidateWriteStage arg1) {
            Intrinsics.checkNotNullParameter(arg1, "it");
            return Unit.INSTANCE;
        }

        static final Unit host$lambda$5(ObjectRef arg2, String arg3) {
            try {
                arg2.element.close();
            }
            catch(Throwable v2) {
                Set v0 = StretchCandidateJournal.localHosts;
                __monitor_enter(v0);
                try {
                    StretchCandidateJournal.localHosts.remove(arg3);
                }
                catch(Throwable v2) {
                    __monitor_exit(v0);
                    throw v2;
                }

                __monitor_exit(v0);
                throw v2;
            }

            Set v2_1 = StretchCandidateJournal.localHosts;
            __monitor_enter(v2_1);
            try {
                StretchCandidateJournal.localHosts.remove(arg3);
            }
            catch(Throwable v3) {
                __monitor_exit(v2_1);
                throw v3;
            }

            __monitor_exit(v2_1);
            return Unit.INSTANCE;
        }
    }

    public static final int $stable = 0;
    private static final int CANDIDATE_SCOPE = 0x43414E44;
    public static final Companion Companion = null;
    private static final int HEADER = 16;
    private static final int MAGIC = 0x47534231;
    private static final int SLOT = 0x8000;
    public static final int TOTAL = 0x10010;
    private final Function0 closeChannels;
    private boolean closed;
    private final Function1 fault;
    private static final Set localHosts;
    private final FileLock lock;
    private final FileChannel read;
    private final boolean readOnly;
    private final FileChannel write;

    static {
        StretchCandidateJournal.Companion = new Companion(null);
        StretchCandidateJournal.$stable = 8;
        StretchCandidateJournal.localHosts = new LinkedHashSet();
    }

    public StretchCandidateJournal(FileChannel arg8, FileChannel arg9, FileLock arg10, Function0 arg11, Function1 arg12, boolean arg13, int arg14, DefaultConstructorMarker arg15) {
        StretchCandidateJournal$$ExternalSyntheticLambda0 v12;
        if((arg14 & 16) != 0) {
            v12 = new StretchCandidateJournal$$ExternalSyntheticLambda0();
        }

        this(arg8, arg9, arg10, arg11, ((Function1)v12), false);
    }

    public StretchCandidateJournal(FileChannel arg2, FileChannel arg3, FileLock arg4, Function0 arg5, Function1 arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg2, "read");
        Intrinsics.checkNotNullParameter(arg3, "write");
        Intrinsics.checkNotNullParameter(arg5, "closeChannels");
        Intrinsics.checkNotNullParameter(arg6, "fault");
        super();
        this.read = arg2;
        this.write = arg3;
        this.lock = arg4;
        this.closeChannels = arg5;
        this.fault = arg6;
        this.readOnly = arg7;
    }

    static final Unit _init_$lambda$0(CandidateWriteStage arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public static final Set access$getLocalHosts$cp() {
        return StretchCandidateJournal.localHosts;
    }

    private final byte[] bytes(long arg4, int arg6) {
        ByteBuffer v6 = ByteBuffer.allocate(arg6);
        while(true) {
            if(!v6.hasRemaining()) {
                goto label_15;
            }

            if(this.read.read(v6, (((long)v6.position())) + arg4) <= 0) {
                break;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    label_15:
        byte[] v3 = v6.array();
        Intrinsics.checkNotNullExpressionValue(v3, "array(...)");
        return v3;
    }

    public void close() {
        __monitor_enter(this);
        try {
            if(!this.closed) {
                goto label_6;
            }
        }
        catch(Throwable v0) {
            goto label_19;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            this.closed = true;
        }
        catch(Throwable v0) {
            goto label_19;
        }

        try {
            FileLock v0_1 = this.lock;
            if(v0_1 != null) {
                v0_1.release();
            }

            goto label_10;
        }
        catch(Throwable v0) {
            try {
                this.closeChannels.invoke();
                throw v0;
            label_10:
                this.closeChannels.invoke();
                goto label_12;
            label_19:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_19;
            }
        }

        throw v0;
    label_12:
        __monitor_exit(this);
    }

    public boolean commit(StretchCandidateRecord arg20, long arg21) {
        StretchCandidateRecord v6_1;
        long v9;
        Object v6;
        CandidateJournalRead v2_1;
        long v7;
        boolean v3;
        StretchCandidateJournal v1 = this;
        StretchCandidateRecord v0 = arg20;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "record");
            v3 = false;
            if(!v1.closed && !v1.readOnly) {
                FileLock v2 = v1.lock;
                if(v2 != null && (v2.isValid()) && arg21 != 0x7FFFFFFFFFFFFFFFL) {
                    v7 = 1;
                    if(v0.getRevision() != arg21 + v7) {
                    }
                    else {
                        v2_1 = v1.load();
                        if((v2_1 instanceof Blocked)) {
                            goto label_25;
                        }
                        else {
                            goto label_27;
                        }
                    }
                }
            }

            goto label_138;
        }
        catch(Throwable v0_1) {
            goto label_141;
        }

    label_25:
        __monitor_exit(this);
        return 0;
        try {
        label_27:
            v6 = null;
            if((v2_1 instanceof Present)) {
            }
            else {
                v2_1 = ((CandidateJournalRead)v6);
            }

            StretchCandidateRecord v2_2 = v2_1 != null ? ((Present)v2_1).getRecord() : ((StretchCandidateRecord)v6);
            v9 = 0;
            long v11 = v2_2 != null ? v2_2.getRevision() : v9;
            if(v11 == arg21) {
                if(v2_2 == null && v0.getPhase() != CandidatePhase.CAPTURED) {
                    goto label_136;
                }

                if(v2_2 != null && !StretchCandidateRecordCodec.INSTANCE.preserves(v2_2, v0)) {
                    goto label_50;
                }

                goto label_51;
            }

            goto label_136;
        }
        catch(Throwable v0_1) {
            goto label_141;
        }

    label_50:
        goto label_136;
        try {
        label_51:
            byte[] v5 = StretchCandidateRecordCodec.INSTANCE.encode(v0);
            if(Intrinsics.areEqual(StretchCandidateRecordCodec.INSTANCE.decode(v5), v0)) {
                int v11_1 = 0x8000;
                byte[] v13 = new byte[v11_1];
                ByteBuffer.wrap(v13).putLong(v0.getRevision()).putInt(v5.length).put(v5);
                byte[] v12 = Companion.access$digest(StretchCandidateJournal.Companion, ArraysKt.copyOfRange(v13, 0, 0x7FE0));
                Intrinsics.checkNotNullExpressionValue(v12, "access$digest(...)");
                ArraysKt.copyInto$default(v12, v13, 0x7FE0, 0, 0, 12, null);
                v1.fault.invoke(CandidateWriteStage.BEFORE_SLOT);
                if(v2_2 == null) {
                    v1.put(0x1000F, new byte[]{0});
                    byte[] v2_3 = ByteBuffer.allocate(16).putInt(0x47534231).putInt(1).putInt(v11_1).putInt(0x43414E44).array();
                    Intrinsics.checkNotNullExpressionValue(v2_3, "array(...)");
                    v1.put(v9, v2_3);
                }

                v9 = (v0.getRevision() - v7) % 2 * 0x8000;
                v1.put(16 + v9, ArraysKt.copyOfRange(v13, 0, 0x4000));
                v1.fault.invoke(CandidateWriteStage.AFTER_HALF_SLOT);
                v1.put(v9 + 0x4010, ArraysKt.copyOfRange(v13, 0x4000, v11_1));
                v1.write.force(true);
                v1.fault.invoke(CandidateWriteStage.AFTER_SYNC);
                v2_1 = v1.load();
                if((v2_1 instanceof Present)) {
                }
                else {
                    v2_1 = ((CandidateJournalRead)v6);
                }

                if(v2_1 != null) {
                    v6_1 = ((Present)v2_1).getRecord();
                }

                v3 = Intrinsics.areEqual(v6_1, v0);
                goto label_134;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Throwable v0_1) {
            try {
            label_141:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_141;
            }

            throw v0_1;
        }
        catch(Exception ) {
        label_134:
            __monitor_exit(this);
            return v3;
        }

    label_136:
        __monitor_exit(this);
        return 0;
    label_138:
        __monitor_exit(this);
        return 0;
    }

    public CandidateJournalRead load() {
        Blocked v1_1;
        StretchCandidateRecord v5_1;
        long v4;
        __monitor_enter(this);
        try {
            if(this.closed) {
                __monitor_exit(this);
                return new Blocked(CandidateJournalError.CLOSED);
            }

            FileLock v0_1 = this.lock;
            if(v0_1 != null && (v0_1.isValid())) {
                try {
                    v4 = 0;
                    if(this.read.size() == v4) {
                        __monitor_exit(this);
                        return Missing.INSTANCE;
                    }
                    else {
                        goto label_20;
                    }

                    goto label_164;
                }
                catch(Exception ) {
                    goto label_158;
                }
            }

            goto label_164;
        }
        catch(Throwable v0) {
            goto label_170;
        }

    label_20:
        int v0_2 = 4;
        try {
            int v2 = ByteBuffer.wrap(this.bytes(v4, v0_2)).getInt();
            if(v2 == 0x47535233) {
                __monitor_exit(this);
                return new Blocked(CandidateJournalError.SIMULATION_RECORD_REJECTED);
            }
            else {
                goto label_31;
            }

            goto label_164;
        }
        catch(Throwable v0) {
            goto label_170;
        }
        catch(Exception ) {
            goto label_158;
        }

    label_31:
        if(v2 == 0x47534231) {
            long v2_1 = 4;
            try {
                if(ByteBuffer.wrap(this.bytes(v2_1, v0_2)).getInt() != 1) {
                    __monitor_exit(this);
                    return new Blocked(CandidateJournalError.VERSION_UNSUPPORTED);
                }
                else {
                    goto label_43;
                }

                goto label_164;
            }
            catch(Throwable v0) {
                goto label_170;
            }
            catch(Exception ) {
                goto label_158;
            }

        label_43:
            v0_2 = 16;
            try {
                ByteBuffer v0_3 = ByteBuffer.wrap(this.bytes(v4, v0_2));
                v0_3.getInt();
                v0_3.getInt();
                int v3 = 0x8000;
                if(v0_3.getInt() == v3 && v0_3.getInt() == 0x43414E44 && this.read.size() == 0x10010) {
                    IntRange v0_4 = new IntRange(0, 1);
                    ArrayList v4_1 = new ArrayList();
                    Iterator v0_5 = ((Iterable)v0_4).iterator();
                    while(v0_5.hasNext()) {
                        byte[] v5 = this.bytes((((long)(v0_5.nextInt() * v3))) + 16, v3);
                        int v6 = v5.length;
                        int v7 = 0;
                        while(true) {
                            if(v7 >= v6) {
                                goto label_115;
                            }
                            else if(v5[v7] == 0) {
                                ++v7;
                                continue;
                            }
                            else {
                                break;
                            }
                        }

                        ByteBuffer v6_1 = ByteBuffer.wrap(v5);
                        long v7_1 = v6_1.getLong();
                        int v9 = v6_1.getInt();
                        if(1 <= v9 && v9 < 0x2001) {
                            byte[] v9_1 = new byte[v9];
                            v6_1.get(v9_1);
                            if(MessageDigest.isEqual(ArraysKt.copyOfRange(v5, 0x7FE0, v3), Companion.access$digest(StretchCandidateJournal.Companion, ArraysKt.copyOfRange(v5, 0, 0x7FE0)))) {
                                v5_1 = StretchCandidateRecordCodec.INSTANCE.decode(v9_1);
                                if(v5_1.getRevision() == v7_1) {
                                    goto label_116;
                                }
                                else {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                            }
                            else {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                        }

                        throw new IllegalArgumentException("Failed requirement.".toString());
                    label_115:
                        v5_1 = null;
                    label_116:
                        if(v5_1 == null) {
                            continue;
                        }

                        ((Collection)v4_1).add(v5_1);
                    }

                    List v0_6 = CollectionsKt.sortedWith(((Iterable)v4_1), new StretchCandidateJournal$load$$inlined$sortedBy$1());
                    if(!v0_6.isEmpty()) {
                        if(v0_6.size() == 2) {
                            if(StretchCandidateRecordCodec.INSTANCE.preserves(v0_6.get(0), v0_6.get(1))) {
                            }
                            else {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                        }

                        Present v1 = new Present(CollectionsKt.last(v0_6));
                        goto label_162;
                    }

                    throw new IllegalArgumentException("Failed requirement.".toString());
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            label_153:
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            catch(Exception ) {
            label_158:
                v1_1 = new Blocked(CandidateJournalError.CORRUPT);
                goto label_162;
            }
        }
        else {
            goto label_153;
        label_162:
            __monitor_exit(this);
            return ((CandidateJournalRead)v1_1);
        }

    label_164:
        __monitor_exit(this);
        return new Blocked(CandidateJournalError.BUSY);
        try {
        label_170:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_170;
        }

        throw v0;
    }

    private final void put(long arg4, byte[] arg6) {
        ByteBuffer v6 = ByteBuffer.wrap(arg6);
        while(true) {
            if(!v6.hasRemaining()) {
                return;
            }

            if(this.write.write(v6, (((long)v6.position())) + arg4) <= 0) {
                break;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

