package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u0011R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchJournalDescriptor;", "", "<init>", "()V", "localLeases", "", "", "adopt", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "fd", "Landroid/os/ParcelFileDescriptor;", "owner", "", "device", "", "inode", "directory", "Ljava/io/File;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchJournalDescriptor {
    public static final int $stable;
    public static final AndroidStretchJournalDescriptor INSTANCE;
    private static final Set localLeases;

    static {
        AndroidStretchJournalDescriptor.INSTANCE = new AndroidStretchJournalDescriptor();
        AndroidStretchJournalDescriptor.localLeases = new LinkedHashSet();
        AndroidStretchJournalDescriptor.$stable = 8;
    }

    private AndroidStretchJournalDescriptor() {
        super();
    }

    public final StretchCandidateJournal adopt(ParcelFileDescriptor arg21, int arg22, long arg23, long arg25, File arg27) {
        Unit v6_3;
        Object v0_5;
        Unit v0_4;
        Function1 v8_2;
        DefaultConstructorMarker v11;
        int v10;
        Function0 v7_2;
        FileInputStream v23;
        FileOutputStream v24;
        FileChannel v26;
        String v27;
        AndroidStretchJournalDescriptor$$ExternalSyntheticLambda0 v22;
        ParcelFileDescriptor v25;
        FileChannel v5_2;
        FileOutputStream v13;
        FileInputStream v8_1;
        FileChannel v4_1;
        FileChannel v3_2;
        FileInputStream v12_1;
        FileInputStream v5_1;
        FileOutputStream v4;
        FileInputStream v3_1;
        FileLock v6_2;
        FileChannel v2_1;
        Set v2;
        String v1_1;
        File v6_1;
        int v0 = arg22;
        long v1 = arg23;
        long v3 = arg25;
        File v5 = arg27;
        ParcelFileDescriptor v7 = arg21;
        Intrinsics.checkNotNullParameter(v7, "fd");
        Intrinsics.checkNotNullParameter(v5, "directory");
        try {
            StructStat v8 = Os.fstat(v7.getFileDescriptor());
            int v9 = Os.fcntlInt(v7.getFileDescriptor(), OsConstants.F_GETFL, 0);
            if(v0 >= 10000 && v8.st_uid == v0 && v8.st_dev == v1 && v8.st_ino == v3) {
                if(OsConstants.S_ISREG(v8.st_mode)) {
                    long v14 = 1;
                    if(v8.st_nlink == v14) {
                        int v12 = 0x180;
                        if((v8.st_mode & 0x1FF) == v12) {
                            long v16 = 0;
                            if(v8.st_size != v16) {
                                if(v8.st_size == 0x10010) {
                                }
                                else {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                            }

                            if((OsConstants.O_ACCMODE & v9) == OsConstants.O_RDWR && (OsConstants.O_APPEND & v9) == 0) {
                                if(!v5.exists()) {
                                    Files.createDirectory(v5.toPath(), new FileAttribute[]{PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"))});
                                }

                                StructStat v6 = Os.lstat(v5.getAbsolutePath());
                                if((OsConstants.S_ISDIR(v6.st_mode)) && v6.st_uid == Process.myUid() && (v6.st_mode & 0x1FF) == 0x1C0) {
                                    v6_1 = new File(v5, v0 + "-" + v1 + "-" + v3 + ".lock");
                                    v1_1 = v6_1.getCanonicalPath();
                                    v2 = AndroidStretchJournalDescriptor.localLeases;
                                    __monitor_enter(v2);
                                    goto label_91;
                                }

                                goto label_226;
                            }

                            goto label_231;
                        }
                    }
                }

                goto label_236;
            }

            goto label_241;
        }
        catch(Exception v0_1) {
            goto label_247;
        }

        try {
        label_91:
            Intrinsics.checkNotNull(v1_1);
            if(v2.add(v1_1)) {
            }
            else {
                goto label_212;
            }
        }
        catch(Throwable v0_2) {
            goto label_216;
        }

        try {
            __monitor_exit(v2);
            if(!v6_1.exists()) {
                Files.createFile(v6_1.toPath(), new FileAttribute[]{PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"))});
            }

            StructStat v0_3 = Os.lstat(v6_1.getAbsolutePath());
            if((OsConstants.S_ISREG(v0_3.st_mode)) && v0_3.st_uid == Process.myUid() && v0_3.st_nlink == v14 && (v0_3.st_mode & 0x1FF) == v12 && v0_3.st_size == v16) {
                v2_1 = FileChannel.open(v6_1.toPath(), new OpenOption[]{StandardOpenOption.READ, StandardOpenOption.WRITE, LinkOption.NOFOLLOW_LINKS});
                goto label_131;
            }

            goto label_205;
        }
        catch(Exception v0_1) {
            goto label_220;
        }

        try {
        label_131:
            v6_2 = v2_1.tryLock();
            if(v6_2 != null) {
                v3_1 = new FileInputStream(arg21.getFileDescriptor());
            }
            else {
                goto label_196;
            }
        }
        catch(Exception v0_1) {
            goto label_200;
        }

        try {
            v4 = new FileOutputStream(arg21.getFileDescriptor());
            v5_1 = v3_1;
        }
        catch(Exception v0_1) {
            v12_1 = v3_1;
            v3_2 = v2_1;
            v4 = null;
            goto label_203;
        }

        FileOutputStream v7_1 = v4;
        goto label_142;
        v12_1 = v5_1;
        v3_2 = v2_1;
        goto label_203;
        try {
        label_142:
            v4_1 = v5_1.getChannel();
            Intrinsics.checkNotNullExpressionValue(v4_1, "getChannel(...)");
            v8_1 = v5_1;
        }
        catch(Exception v0_1) {
            v12_1 = v5_1;
            v13 = v7_1;
            goto label_183;
        }

        try {
            v5_2 = v7_1.getChannel();
            Intrinsics.checkNotNullExpressionValue(v5_2, "getChannel(...)");
            v25 = arg21;
            v22 = null;
            v27 = v1_1;
            v26 = v2_1;
            v24 = v7_1;
            v23 = v8_1;
        }
        catch(Exception v0_1) {
            v13 = v7_1;
            v12_1 = v8_1;
            goto label_183;
        }

        try {
            super(v23, v24, v25, v26, v27);
            v7_2 = ((Function0)v22);
            v12_1 = v23;
            v13 = v24;
            v2_1 = v26;
            v1_1 = v27;
            v10 = 0x30;
            v11 = null;
            v8_2 = null;
        }
        catch(Exception v0_1) {
            v12_1 = v23;
            v13 = v24;
            v2_1 = v26;
            v1_1 = v27;
            goto label_183;
        }

        try {
            return new StretchCandidateJournal(v4_1, v5_2, v6_2, v7_2, v8_2, false, v10, v11);
        }
        catch(Exception v0_1) {
        }

    label_183:
        v3_2 = v2_1;
        v4 = v13;
        goto label_203;
        try {
        label_196:
            throw new OverlappingFileLockException();
        }
        catch(Exception v0_1) {
        label_200:
            v3_2 = v2_1;
            v4 = null;
            v12_1 = null;
        }

    label_203:
        String v2_2 = v1_1;
        goto label_224;
        try {
        label_205:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Exception v0_1) {
            goto label_220;
        }

        try {
        label_212:
            throw new OverlappingFileLockException();
        }
        catch(Throwable v0_2) {
        label_216:
            v1_1 = null;
        }

        try {
            __monitor_exit(v2);
            throw v0_2;
        }
        catch(Exception v0_1) {
        label_220:
            v2_2 = v1_1;
            v3_2 = null;
            v4 = null;
            v12_1 = null;
        }

    label_224:
        Exception v1_2 = v0_1;
        goto label_252;
        try {
        label_226:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_231:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_236:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_241:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Exception v0_1) {
        label_247:
            v1_2 = v0_1;
            v2_2 = null;
            v3_2 = null;
            v4 = null;
            v12_1 = null;
        }

        try {
        label_252:
            if(v12_1 != null) {
                v12_1.close();
                v0_4 = Unit.INSTANCE;
            }
            else {
                v0_5 = null;
            }

            Result.constructor-impl(v0_5);
        }
        catch(Throwable v0_2) {
            Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        try {
            if(v4 != null) {
                v4.close();
                v0_4 = Unit.INSTANCE;
            }
            else {
                v0_5 = null;
            }

            Result.constructor-impl(v0_5);
        }
        catch(Throwable v0_2) {
            Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        try {
            arg21.close();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0_2) {
            Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        try {
            if(v3_2 != null) {
                v3_2.close();
                v6_3 = Unit.INSTANCE;
            }
            else {
                Object v6_4 = null;
            }

            Result.constructor-impl(v6_3);
        }
        catch(Throwable v0_2) {
            Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        if(v2_2 != null) {
            Set v3_3 = AndroidStretchJournalDescriptor.localLeases;
            __monitor_enter(v3_3);
            try {
                v3_3.remove(v2_2);
            }
            catch(Throwable v0_2) {
                __monitor_exit(v3_3);
                throw v0_2;
            }

            __monitor_exit(v3_3);
        }

        throw v1_2;
    }

    public static StretchCandidateJournal adopt$default(AndroidStretchJournalDescriptor arg10, ParcelFileDescriptor arg11, int arg12, long arg13, long arg15, File arg17, int arg18, Object arg19) {
        File v9 = (arg18 & 16) != 0 ? new File("/data/local/tmp/golden_stretch_journal_locks") : arg17;
        return arg10.adopt(arg11, arg12, arg13, arg15, v9);
    }

    static final Unit adopt$lambda$2(FileInputStream arg0, FileOutputStream arg1, ParcelFileDescriptor arg2, FileChannel arg3, String arg4) {
        Set v1;
        try {
            arg0.close();
        }
        catch(Throwable v0) {
            try {
                arg1.close();
            }
            catch(Throwable v0) {
                try {
                    arg2.close();
                }
                catch(Throwable v0) {
                    try {
                        arg3.close();
                    }
                    catch(Throwable v0) {
                        v1 = AndroidStretchJournalDescriptor.localLeases;
                        __monitor_enter(v1);
                        try {
                            AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                        }
                        catch(Throwable v0) {
                            __monitor_exit(v1);
                            throw v0;
                        }

                        __monitor_exit(v1);
                        throw v0;
                    }

                    v1 = AndroidStretchJournalDescriptor.localLeases;
                    __monitor_enter(v1);
                    try {
                        AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                    }
                    catch(Throwable v0) {
                        __monitor_exit(v1);
                        throw v0;
                    }

                    __monitor_exit(v1);
                    throw v0;
                }

                try {
                    arg3.close();
                }
                catch(Throwable v0) {
                    v1 = AndroidStretchJournalDescriptor.localLeases;
                    __monitor_enter(v1);
                    try {
                        AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                    }
                    catch(Throwable v0) {
                        __monitor_exit(v1);
                        throw v0;
                    }

                    __monitor_exit(v1);
                    throw v0;
                }

                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            try {
                arg2.close();
            }
            catch(Throwable v0) {
                try {
                    arg3.close();
                }
                catch(Throwable v0) {
                    v1 = AndroidStretchJournalDescriptor.localLeases;
                    __monitor_enter(v1);
                    try {
                        AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                    }
                    catch(Throwable v0) {
                        __monitor_exit(v1);
                        throw v0;
                    }

                    __monitor_exit(v1);
                    throw v0;
                }

                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            try {
                arg3.close();
            }
            catch(Throwable v0) {
                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            v1 = AndroidStretchJournalDescriptor.localLeases;
            __monitor_enter(v1);
            try {
                AndroidStretchJournalDescriptor.localLeases.remove(arg4);
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            throw v0;
        }

        try {
            arg1.close();
        }
        catch(Throwable v0) {
            try {
                arg2.close();
            }
            catch(Throwable v0) {
                try {
                    arg3.close();
                }
                catch(Throwable v0) {
                    v1 = AndroidStretchJournalDescriptor.localLeases;
                    __monitor_enter(v1);
                    try {
                        AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                    }
                    catch(Throwable v0) {
                        __monitor_exit(v1);
                        throw v0;
                    }

                    __monitor_exit(v1);
                    throw v0;
                }

                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            try {
                arg3.close();
            }
            catch(Throwable v0) {
                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            v1 = AndroidStretchJournalDescriptor.localLeases;
            __monitor_enter(v1);
            try {
                AndroidStretchJournalDescriptor.localLeases.remove(arg4);
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            throw v0;
        }

        try {
            arg2.close();
        }
        catch(Throwable v0) {
            try {
                arg3.close();
            }
            catch(Throwable v0) {
                v1 = AndroidStretchJournalDescriptor.localLeases;
                __monitor_enter(v1);
                try {
                    AndroidStretchJournalDescriptor.localLeases.remove(arg4);
                }
                catch(Throwable v0) {
                    __monitor_exit(v1);
                    throw v0;
                }

                __monitor_exit(v1);
                throw v0;
            }

            v1 = AndroidStretchJournalDescriptor.localLeases;
            __monitor_enter(v1);
            try {
                AndroidStretchJournalDescriptor.localLeases.remove(arg4);
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            throw v0;
        }

        try {
            arg3.close();
        }
        catch(Throwable v0) {
            v1 = AndroidStretchJournalDescriptor.localLeases;
            __monitor_enter(v1);
            try {
                AndroidStretchJournalDescriptor.localLeases.remove(arg4);
            }
            catch(Throwable v0) {
                __monitor_exit(v1);
                throw v0;
            }

            __monitor_exit(v1);
            throw v0;
        }

        Set v0_1 = AndroidStretchJournalDescriptor.localLeases;
        __monitor_enter(v0_1);
        try {
            v0_1.remove(arg4);
        }
        catch(Throwable v1_1) {
            __monitor_exit(v0_1);
            throw v1_1;
        }

        __monitor_exit(v0_1);
        return Unit.INSTANCE;
    }
}

