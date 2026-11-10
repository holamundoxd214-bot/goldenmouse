package okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0014\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u001C\u0010\u0007\u001A\u00020\b*\u00020\u00022\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0006H\u0000\u001A\u001C\u0010\u000B\u001A\u00020\b*\u00020\u00022\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u0004H\u0000\u001A\u001C\u0010\u000E\u001A\u00020\b*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0006H\u0000\u001A\"\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020\u00022\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0006H\u0000\u001AF\u0010\u0014\u001A\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001A\u00020\u00022\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u001A\u001A\u0016\u0010\u001B\u001A\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000¨\u0006\u001C"}, d2={"commonMetadata", "Lokio/FileMetadata;", "Lokio/FileSystem;", "path", "Lokio/Path;", "commonExists", "", "commonCreateDirectories", "", "dir", "mustCreate", "commonCopy", "source", "target", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonListRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "collectRecursively", "Lkotlin/sequences/SequenceScope;", "fileSystem", "stack", "Lkotlin/collections/ArrayDeque;", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "symlinkTarget", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -FileSystem {
    public static final Object collectRecursively(SequenceScope arg15, FileSystem arg16, ArrayDeque arg17, Path arg18, boolean arg19, boolean arg20, Continuation arg21) {
        Object v11;
        Object v10;
        Object v9;
        Object v6_1;
        Object v2_1;
        boolean v1_1;
        boolean v0;
        Object v1_2;
        Continuation v6_3;
        boolean v4_2;
        Object v15;
        Object v16;
        Object v17;
        Iterator v2_2;
        Path v3_5;
        boolean v10_1;
        ArrayDeque v6_2;
        FileSystem v3_3;
        -FileSystem$collectRecursively$1 v4_1;
        int v6;
        Continuation v4;
        Path v1 = arg18;
        boolean v2 = arg20;
        Continuation v3 = arg21;
        if((v3 instanceof -FileSystem$collectRecursively$1)) {
            v4 = v3;
            v6 = 0x80000000;
            if((((-FileSystem$collectRecursively$1)v4).label & v6) != 0) {
                ((-FileSystem$collectRecursively$1)v4).label -= v6;
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            v4_1 = new -FileSystem$collectRecursively$1(v3);
        }

        Object v3_1 = v4_1.result;
        Object v5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v6 = v4_1.label;
        int v7 = 3;
        int v8 = 2;
        if(v6 == 0) {
            ResultKt.throwOnFailure(v3_1);
            if(!v2) {
                v4_1.L$0 = arg15;
                v3_3 = arg16;
                v4_1.L$1 = v3_3;
                v6_2 = arg17;
                v4_1.L$2 = v6_2;
                v4_1.L$3 = v1;
                v10_1 = arg19;
                v4_1.Z$0 = v10_1;
                v4_1.Z$1 = v2;
                v4_1.label = 1;
                if(arg15.yield(v1, ((Continuation)v4_1)) == v5) {
                    return v5;
                }
            }
            else {
                v3_3 = arg16;
                v6_2 = arg17;
                v10_1 = arg19;
            }

            FileSystem v9_1 = v3_3;
            v0 = v10_1;
            SequenceScope v10_2 = arg15;
        label_83:
            List v3_4 = ((FileSystem)v9).listOrNull(((Path)v1_2));
            if(v3_4 == null) {
                v3_4 = CollectionsKt.emptyList();
            }

            if(v3_4.isEmpty()) {
                goto label_160;
            }

            int v11_1 = 0;
            Path v12;
            for(v12 = ((Path)v1_2); true; v12 = v13) {
                if(v0) {
                    if(!v6_2.contains(v12)) {
                    }
                    else {
                        throw new IOException("symlink cycle at " + v1_2);
                    }
                }

                Path v13 = -FileSystem.symlinkTarget(((FileSystem)v9), v12);
                if(v13 == null) {
                    if(!v0 && v11_1 != 0) {
                        goto label_160;
                    }

                    v6_2.addLast(v12);
                    try {
                        Iterator v14_1 = v3_4.iterator();
                        v3_5 = ((Path)v1_2);
                        v1_1 = v2;
                        v2_2 = v14_1;
                        goto label_113;
                    }
                    catch(Throwable v0_1) {
                        goto label_154;
                    }
                }

                ++v11_1;
            }

        label_44:
            v6_1 = v9;
            v9 = v10;
            v10 = v11;
            try {
            label_113:
                if(!v2_2.hasNext()) {
                    goto label_146;
                }

                v11 = v2_2.next();
                v4_1.L$0 = v10_2;
                v4_1.L$1 = v9;
                v4_1.L$2 = v6_2;
                v4_1.L$3 = v3_5;
                v4_1.L$4 = v2_2;
                v4_1.Z$0 = v0;
                v4_1.Z$1 = v1_1;
                v4_1.label = v8;
                arg19 = v0;
                arg20 = v1_1;
                arg21 = ((Continuation)v4_1);
                v17 = v6_2;
                v16 = v9;
                v15 = v10_2;
                Object v18 = v11;
            }
            catch(Throwable v0_1) {
                goto label_154;
            }

            try {
                v11 = v15;
                v10 = v16;
                v9 = v17;
                v4_2 = arg19;
                v1_1 = arg20;
                v6_3 = arg21;
                if(-FileSystem.collectRecursively(((SequenceScope)v15), ((FileSystem)v16), ((ArrayDeque)v17), ((Path)v18), arg19, arg20, arg21) != v5) {
                    goto label_140;
                }
            }
            catch(Throwable v0_1) {
                goto label_144;
            }

            return v5;
        label_140:
            v0 = v4_2;
            v4 = v6_3;
            goto label_44;
        label_144:
            v9 = v17;
            goto label_155;
        label_146:
            v6_2.removeLast();
            v2 = v1_1;
            v1_2 = v3_5;
            goto label_160;
        label_154:
            v9 = v6_2;
        label_155:
            ((ArrayDeque)v9).removeLast();
            throw v0_1;
        label_160:
            if(v2) {
                v4_1.L$0 = null;
                v4_1.L$1 = null;
                v4_1.L$2 = null;
                v4_1.L$3 = null;
                v4_1.L$4 = null;
                v4_1.label = v7;
                if(v10_2.yield(v1_2, ((Continuation)v4_1)) != v5) {
                    goto label_171;
                }
            }
            else {
                return Unit.INSTANCE;
            }

            return v5;
        }
        else if(v6 == 1) {
            v0 = v4_1.Z$1;
            v1_1 = v4_1.Z$0;
            v2_1 = v4_1.L$3;
            v6_1 = v4_1.L$2;
            v9 = v4_1.L$1;
            v10 = v4_1.L$0;
            ResultKt.throwOnFailure(v3_1);
            Object v14 = v2_1;
            v2 = v0;
            v0 = v1_1;
            v1_2 = v14;
            goto label_83;
        }
        else if(v6 == v8) {
            v0 = v4_1.Z$1;
            v1_1 = v4_1.Z$0;
            v2_1 = v4_1.L$4;
            v6_1 = v4_1.L$3;
            v9 = v4_1.L$2;
            v10 = v4_1.L$1;
            v11 = v4_1.L$0;
            try {
                ResultKt.throwOnFailure(v3_1);
                boolean v3_2 = v1_1;
                v1_1 = v0;
                v0 = v3_2;
                v3_1 = v6_1;
                goto label_44;
            }
            catch(Throwable v0_1) {
                goto label_155;
            }
        }
        else if(v6 == v7) {
            ResultKt.throwOnFailure(v3_1);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_171:
        return Unit.INSTANCE;
    }

    public static final void commonCopy(FileSystem arg5, Path arg6, Path arg7) throws IOException {
        Long v7_2;
        BufferedSink v5_1;
        Source v1;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "source");
        Intrinsics.checkNotNullParameter(arg7, "target");
        Source v6 = arg5.source(arg6);
        Object v0 = null;
        try {
            v1 = v6;
            v5_1 = Okio.buffer(FileSystem.sink$default(arg5, arg7, false, 2, v0));
        }
        catch(Throwable v5) {
            goto label_44;
        }

        BufferedSink v7 = v5_1;
        try {
            v7_2 = Long.valueOf(v7.writeAll(v1));
            if(v5_1 == null) {
                goto label_21;
            }
        }
        catch(Throwable v7_1) {
            if(v5_1 != null) {
                try {
                    ((Closeable)v5_1).close();
                    goto label_29;
                }
                catch(Throwable v5) {
                    try {
                        ExceptionsKt.addSuppressed(v7_1, v5);
                    label_29:
                        v5 = v7_1;
                        Number v7_3 = ((Number)v0);
                        goto label_31;
                    }
                    catch(Throwable v5) {
                        goto label_44;
                    }
                }
            }
            else {
                goto label_29;
            }

            goto label_21;
        }

        try {
            ((Closeable)v5_1).close();
        }
        catch(Throwable v5) {
            goto label_31;
        }

    label_21:
        v5 = ((Throwable)v0);
        try {
        label_31:
            if(v5 != null) {
                goto label_42;
            }

            Long v5_2 = Long.valueOf(((Number)v7_2).longValue());
            if(v6 == null) {
                goto label_38;
            }
        }
        catch(Throwable v5) {
            goto label_44;
        }

        try {
            ((Closeable)v6).close();
        }
        catch(Throwable v0_1) {
        }

    label_38:
        v5 = ((Throwable)v0);
        goto label_49;
        try {
        label_42:
            throw v5;
        }
        catch(Throwable v5) {
        label_44:
            if(v6 == null) {
                goto label_49;
            }

            try {
                ((Closeable)v6).close();
            }
            catch(Throwable v6_1) {
                ExceptionsKt.addSuppressed(v5, v6_1);
            }
        }

    label_49:
        if(v5 == null) {
            return;
        }

        throw v5;
    }

    public static final void commonCreateDirectories(FileSystem arg3, Path arg4, boolean arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "dir");
        ArrayDeque v0 = new ArrayDeque();
        Path v1;
        for(v1 = arg4; v1 != null; v1 = v1.parent()) {
            if(arg3.exists(v1)) {
                break;
            }

            v0.addFirst(v1);
        }

        if(arg5) {
            if(!v0.isEmpty()) {
            }
            else {
                throw new IOException(arg4 + " already exists.");
            }
        }

        Iterator v4 = v0.iterator();
        while(v4.hasNext()) {
            FileSystem.createDirectory$default(arg3, v4.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(FileSystem arg2, Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "fileOrDirectory");
        Iterator v3 = SequencesKt.sequence(new -FileSystem$commonDeleteRecursively$sequence$1(arg2, arg3, null)).iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            boolean v1 = !arg4 || (v3.hasNext()) ? false : true;
            arg2.delete(((Path)v0), v1);
        }
    }

    public static final boolean commonExists(FileSystem arg1, Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "path");
        if(arg1.metadataOrNull(arg2) != null) {
            return 1;
        }

        return 0;
    }

    public static final Sequence commonListRecursively(FileSystem arg2, Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "dir");
        return SequencesKt.sequence(new -FileSystem$commonListRecursively$1(arg3, arg2, arg4, null));
    }

    public static final FileMetadata commonMetadata(FileSystem arg2, Path arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "path");
        FileMetadata v2 = arg2.metadataOrNull(arg3);
        if(v2 != null) {
            return v2;
        }

        throw new FileNotFoundException("no such file: " + arg3);
    }

    public static final Path symlinkTarget(FileSystem arg1, Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "path");
        Path v1 = arg1.metadata(arg2).getSymlinkTarget();
        if(v1 == null) {
            return null;
        }

        arg2 = arg2.parent();
        Intrinsics.checkNotNull(arg2);
        return arg2.resolve(v1);
    }
}

