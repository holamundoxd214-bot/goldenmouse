package kotlin.io.path;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1={"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u001Ay\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012Q\b\u0002\u0010\u0003\u001AK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000B0\u00042\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0087\u0080\b\u001A¶\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012Q\b\u0002\u0010\u0003\u001AK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000B0\u00042\u0006\u0010\f\u001A\u00020\r2C\b\u0002\u0010\u000F\u001A=\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0002\b\u0012H\u0087\u0080\b\u001A\u0013\u0010\u0013\u001A\u00020\u0014*\u00020\u0011H\u0083\u0080\u0004¢\u0006\u0002\b\u0015\u001A\u0013\u0010\u0013\u001A\u00020\u0014*\u00020\u000BH\u0083\u0080\u0004¢\u0006\u0002\b\u0015\u001A\u000E\u0010\u0016\u001A\u00020\u0017*\u00020\u0001H\u0087\u0080\u0004\u001A\u001D\u0010\u0018\u001A\f\u0012\b\u0012\u00060\bj\u0002`\n0\u0019*\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001A\u001A%\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u001D2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00170\u001FH\u0082\u0088\u0004¢\u0006\u0002\b \u001A\'\u0010!\u001A\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\"0\u001FH\u0082\u0088\u0004¢\u0006\u0004\b#\u0010$\u001A3\u0010%\u001A\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001A\u00020\u00012\b\u0010\'\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u001C\u001A\u00020\u001DH\u0082\u0080\u0004¢\u0006\u0002\b(\u001A)\u0010)\u001A\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u001DH\u0082\u0080\u0004¢\u0006\u0002\b*\u001A7\u0010+\u001A\u00020\r*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010,\u001A\u00020\u00012\u0012\u0010-\u001A\n\u0012\u0006\b\u0001\u0012\u00020/0.\"\u00020/H\u0082\u0080\u0004¢\u0006\u0004\b0\u00101\u001A)\u00102\u001A\u00020\u00172\u0006\u00103\u001A\u00020\u00012\b\u0010\'\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u001C\u001A\u00020\u001DH\u0082\u0080\u0004¢\u0006\u0002\b4\u001A\u001F\u00105\u001A\u00020\u00172\u0006\u00106\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u001DH\u0082\u0080\u0004¢\u0006\u0002\b7\u001A\u000E\u00108\u001A\u00020\u0017*\u00020\u0001H\u0080\u0080\u0004\u001A\u001B\u00109\u001A\u00020\u0017*\u00020\u00012\u0006\u0010\'\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b:¨\u0006;"}, d2={"copyToRecursively", "Ljava/nio/file/Path;", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "exception", "Lkotlin/Exception;", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "deleteRecursively", "", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "collectIfThrows", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "handleEntry", "Ljava/nio/file/SecureDirectoryStream;", "parent", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/path/PathsKt") class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CopyActionResult.values().length];
            try {
                v0[CopyActionResult.CONTINUE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[CopyActionResult.TERMINATE.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        v0 = new int[OnErrorResult.values().length];
                        try {
                            v0[OnErrorResult.TERMINATE.ordinal()] = 1;
                            goto label_22;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_22:
                                v0[OnErrorResult.SKIP_SUBTREE.ordinal()] = v2;
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

    public static CopyActionResult $r8$lambda$3VYkoVP17knpGuiVw5BoXBQ_zc8(boolean arg0, CopyActionContext arg1, Path arg2, Path arg3) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3);
    }

    public static CopyActionResult $r8$lambda$A3AggpeIcVTXny9TWGNUBxfCgaU(boolean arg0, CopyActionContext arg1, Path arg2, Path arg3) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3);
    }

    public static OnErrorResult $r8$lambda$De4yXv8T0vx7waJvVzG_4HFVSss(Path arg0, Path arg1, Exception arg2) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2);
    }

    public static FileVisitResult $r8$lambda$IkZ125cv9leHdM_R4zOtmPWi6nc(ArrayList arg0, Function3 arg1, Path arg2, Path arg3, Path arg4, Path arg5, IOException arg6) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static FileVisitResult $r8$lambda$Q20yqNtXDRXNb_l9dEjE2GC-B44(ArrayList arg0, Function3 arg1, Path arg2, Path arg3, Path arg4, Function3 arg5, Path arg6, BasicFileAttributes arg7) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static OnErrorResult $r8$lambda$RTX0Ejym-JswkQvhEjqK7fQVJOQ(Path arg0, Path arg1, Exception arg2) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$iE84oOjPIAfm60pr-kh4MNeINmU(ArrayList arg0, Function3 arg1, Path arg2, Path arg3, Path arg4, Function3 arg5, FileVisitorBuilder arg6) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$5$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public PathsKt__PathRecursiveFunctionsKt() {
        super();
    }

    public static final FileVisitResult access$copyToRecursively$copy(ArrayList arg0, Function3 arg1, Path arg2, Path arg3, Path arg4, Function3 arg5, Path arg6, BasicFileAttributes arg7) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final FileVisitResult access$copyToRecursively$error(Function3 arg0, Path arg1, Path arg2, Path arg3, Path arg4, Exception arg5) {
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final void checkFileName(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        String v0 = PathsKt.getName(arg3);
        int v1 = v0.hashCode();
        if(v1 != 46) {
            if(v1 != 0x5EE) {
                if(v1 != 0xB26F) {
                    if(v1 != 0xB29C) {
                        if(v1 != 0x5C0) {
                            if(v1 != 0x5C1) {
                                return;
                            }
                            else if(!v0.equals("./")) {
                                return;
                            }
                        }
                        else if(!v0.equals("..")) {
                            return;
                        }
                    }
                    else if(!v0.equals("..\\")) {
                        return;
                    }
                }
                else if(!v0.equals("../")) {
                    return;
                }
            }
            else if(!v0.equals(".\\")) {
                return;
            }
        }
        else if(!v0.equals(".")) {
            return;
        }

        throw new IllegalFileNameException(arg3);
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path arg1, Path arg2) {
        if(!Files.isSymbolicLink(arg1)) {
            if(!Files.isSameFile(arg1, arg2)) {
            }
            else {
                throw new FileSystemLoopException(arg1.toString());
            }
        }
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector arg0, Function0 arg1) {
        try {
            arg1.invoke();
            return;
        }
        catch(Exception v1) {
            arg0.collect(v1);
            return;
        }
    }

    @IgnorableReturnValue public static final Path copyToRecursively(Path arg9, Path arg10, Function3 arg11, boolean arg12, Function3 arg13) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        Intrinsics.checkNotNullParameter(arg10, "target");
        Intrinsics.checkNotNullParameter(arg11, "onError");
        Intrinsics.checkNotNullParameter(arg13, "copyAction");
        LinkOption[] v1 = LinkFollowing.INSTANCE.toLinkOptions(arg12);
        Object[] v1_1 = Arrays.copyOf(((Object[])v1), v1.length);
        if(Files.exists(arg9, Arrays.copyOf(v1_1, v1_1.length))) {
            boolean v1_2 = false;
            if((Files.exists(arg9, Arrays.copyOf(new LinkOption[0], 0))) && ((arg12) || !Files.isSymbolicLink(arg9))) {
                int v3 = !Files.exists(arg10, Arrays.copyOf(new LinkOption[0], 0)) || (Files.isSymbolicLink(arg10)) ? 0 : 1;
                if(v3 != 0 && (Files.isSameFile(arg9, arg10))) {
                    goto label_70;
                }

                if(!Intrinsics.areEqual(arg9.getFileSystem(), arg10.getFileSystem())) {
                }
                else if(v3 != 0) {
                    v1_2 = arg10.toRealPath(new LinkOption[0]).startsWith(arg9.toRealPath(new LinkOption[0]));
                }
                else {
                    Path v3_1 = arg10.getParent();
                    if(v3_1 != null && (Files.exists(v3_1, Arrays.copyOf(new LinkOption[0], 0))) && (v3_1.toRealPath(new LinkOption[0]).startsWith(arg9.toRealPath(new LinkOption[0])))) {
                        v1_2 = true;
                    }
                }

                if(!v1_2) {
                    goto label_70;
                }

                throw new FileSystemException(arg9.toString(), arg10.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
            }

        label_70:
            PathsKt.visitFileTree$default(arg9, 0, arg12, new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda3(new ArrayList(), arg13, arg9, arg10, arg10.normalize(), arg11), 1, null);
            return arg10;
        }

        throw new NoSuchFileException(arg9.toString(), arg10.toString(), "The source file doesn\'t exist.");
    }

    @IgnorableReturnValue public static final Path copyToRecursively(Path arg7, Path arg8, Function3 arg9, boolean arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "target");
        Intrinsics.checkNotNullParameter(arg9, "onError");
        if(arg11) {
            return PathsKt.copyToRecursively(arg7, arg8, arg9, arg10, new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda2(arg10));
        }

        return PathsKt.copyToRecursively$default(arg7, arg8, arg9, arg10, null, 8, null);
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList arg1, Function3 arg2, Path arg3, Path arg4, Path arg5, Function3 arg6, Path arg7, BasicFileAttributes arg8) {
        try {
            if(!arg1.isEmpty()) {
                PathsKt.checkFileName(arg7);
                Object v1 = CollectionsKt.last(((List)arg1));
                Intrinsics.checkNotNullExpressionValue(v1, "last(...)");
                PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(arg7, ((Path)v1));
            }

            return PathsKt__PathRecursiveFunctionsKt.toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(arg2.invoke(DefaultCopyActionContext.INSTANCE, arg7, PathsKt__PathRecursiveFunctionsKt.copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(arg3, arg4, arg5, arg7)));
        }
        catch(Exception v0) {
            return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(arg6, arg3, arg4, arg5, arg7, v0);
        }
    }

    public static Path copyToRecursively$default(Path arg0, Path arg1, Function3 arg2, boolean arg3, Function3 arg4, int arg5, Object arg6) {
        PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda1 v4;
        PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda0 v2;
        if((arg5 & 2) != 0) {
            v2 = new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda0();
        }

        if((arg5 & 8) != 0) {
            v4 = new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda1(arg3);
        }

        return PathsKt.copyToRecursively(arg0, arg1, ((Function3)v2), arg3, ((Function3)v4));
    }

    public static Path copyToRecursively$default(Path arg0, Path arg1, Function3 arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda6 v2;
        if((arg5 & 2) != 0) {
            v2 = new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda6();
        }

        return PathsKt.copyToRecursively(arg0, arg1, ((Function3)v2), arg3, arg4);
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path arg0, Path arg1, Path arg2, Path arg3) {
        arg0 = arg1.resolve(PathsKt.relativeTo(arg3, arg0).toString());
        if(arg0.normalize().startsWith(arg2)) {
            Intrinsics.checkNotNull(arg0);
            return arg0;
        }

        throw new IllegalFileNameException(arg3, arg0, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3 arg0, Path arg1, Path arg2, Path arg3, Path arg4, Exception arg5) {
        return PathsKt__PathRecursiveFunctionsKt.toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(arg0.invoke(arg4, PathsKt__PathRecursiveFunctionsKt.copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(arg1, arg2, arg3, arg4), arg5));
    }

    private static final OnErrorResult copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(Path arg1, Path arg2, Exception arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<unused var>");
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "exception");
        throw arg3;
    }

    private static final CopyActionResult copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(boolean arg3, CopyActionContext arg4, Path arg5, Path arg6) {
        Intrinsics.checkNotNullParameter(arg4, "$this$copyToRecursively");
        Intrinsics.checkNotNullParameter(arg5, "src");
        Intrinsics.checkNotNullParameter(arg6, "dst");
        LinkOption[] v3 = LinkFollowing.INSTANCE.toLinkOptions(arg3);
        boolean v4 = Files.isDirectory(arg6, Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        Object[] v0 = Arrays.copyOf(((Object[])v3), v3.length);
        if(!Files.isDirectory(arg5, Arrays.copyOf(v0, v0.length)) || !v4) {
            if(v4) {
                PathsKt.deleteRecursively(arg6);
            }

            SpreadBuilder v4_1 = new SpreadBuilder(2);
            v4_1.addSpread(v3);
            v4_1.add(StandardCopyOption.REPLACE_EXISTING);
            Object[] v3_1 = v4_1.toArray(new CopyOption[v4_1.size()]);
            Intrinsics.checkNotNullExpressionValue(Files.copy(arg5, arg6, Arrays.copyOf(v3_1, v3_1.length)), "copy(...)");
        }

        return CopyActionResult.CONTINUE;
    }

    private static final OnErrorResult copyToRecursively$lambda$2$PathsKt__PathRecursiveFunctionsKt(Path arg1, Path arg2, Exception arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<unused var>");
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "exception");
        throw arg3;
    }

    private static final CopyActionResult copyToRecursively$lambda$3$PathsKt__PathRecursiveFunctionsKt(boolean arg1, CopyActionContext arg2, Path arg3, Path arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "src");
        Intrinsics.checkNotNullParameter(arg4, "dst");
        return arg2.copyToIgnoringExistingDirectory(arg3, arg4, arg1);
    }

    private static final FileVisitResult copyToRecursively$lambda$5$0$PathsKt__PathRecursiveFunctionsKt(ArrayList arg1, Function3 arg2, Path arg3, Path arg4, Path arg5, Function3 arg6, Path arg7, BasicFileAttributes arg8) {
        Intrinsics.checkNotNullParameter(arg7, "directory");
        Intrinsics.checkNotNullParameter(arg8, "attributes");
        FileVisitResult v2 = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        if(v2 == FileVisitResult.CONTINUE) {
            arg1.add(arg7);
        }

        return v2;
    }

    private static final FileVisitResult copyToRecursively$lambda$5$1$PathsKt__PathRecursiveFunctionsKt(ArrayList arg1, Function3 arg2, Path arg3, Path arg4, Path arg5, Path arg6, IOException arg7) {
        Intrinsics.checkNotNullParameter(arg6, "directory");
        CollectionsKt.removeLast(((List)arg1));
        if(arg7 == null) {
            return FileVisitResult.CONTINUE;
        }

        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(arg2, arg3, arg4, arg5, arg6, ((Exception)arg7));
    }

    private static final Unit copyToRecursively$lambda$5$PathsKt__PathRecursiveFunctionsKt(ArrayList arg9, Function3 arg10, Path arg11, Path arg12, Path arg13, Function3 arg14, FileVisitorBuilder arg15) {
        Intrinsics.checkNotNullParameter(arg15, "$this$visitFileTree");
        arg15.onPreVisitDirectory(new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda4(arg9, arg10, arg11, arg12, arg13, arg14));
        arg15.onVisitFile(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(arg9, arg10, arg11, arg12, arg13, arg14));
        arg15.onVisitFileFailed(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(arg14, arg11, arg12, arg13));
        arg15.onPostVisitDirectory(new PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda5(arg9, arg14, arg11, arg12, arg13));
        return Unit.INSTANCE;
    }

    public static final void deleteRecursively(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        List v3 = PathsKt__PathRecursiveFunctionsKt.deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(arg3);
        if(!v3.isEmpty()) {
            FileSystemException v0 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterator v3_1 = ((Iterable)v3).iterator();
            while(v3_1.hasNext()) {
                ExceptionsKt.addSuppressed(v0, v3_1.next());
            }

            throw v0;
        }
    }

    private static final List deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path arg9) {
        DirectoryStream v6;
        int v1 = 0;
        int v2 = 1;
        DefaultConstructorMarker v3 = null;
        ExceptionsCollector v0 = new ExceptionsCollector(0, 1, v3);
        Path v4 = arg9.getFileName();
        if(v4 != null) {
            Path v5 = arg9.getParent();
            if(v5 == null) {
                v5 = arg9.getFileSystem().getPath("", new String[0]);
            }

            try {
                v6 = Files.newDirectoryStream(v5);
            }
            catch(Throwable ) {
                v6 = ((DirectoryStream)v3);
            }

            if(v6 == null) {
                goto label_33;
            }

            try {
                DirectoryStream v7 = v6;
                if((v7 instanceof SecureDirectoryStream)) {
                    v0.setPath(v5);
                    PathsKt__PathRecursiveFunctionsKt.handleEntry$PathsKt__PathRecursiveFunctionsKt(((SecureDirectoryStream)v7), v4, ((Path)v3), v0);
                }
                else {
                    v1 = 1;
                }
            }
            catch(Throwable v9) {
                try {
                    throw v9;
                }
                catch(Throwable v0_1) {
                    CloseableKt.closeFinally(((Closeable)v6), v9);
                    throw v0_1;
                }
            }

            CloseableKt.closeFinally(((Closeable)v6), ((Throwable)v3));
            v2 = v1;
        }

    label_33:
        if(v2 != 0) {
            PathsKt__PathRecursiveFunctionsKt.insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(arg9, ((Path)v3), v0);
        }

        return v0.getCollectedExceptions();
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream arg4, Path arg5, ExceptionsCollector arg6) {
        Throwable v1 = null;
        try {
            arg4 = arg4.newDirectoryStream(arg5, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            goto label_11;
        }
        catch(Exception v4) {
        }
        catch(NoSuchFileException ) {
            arg4 = ((SecureDirectoryStream)v1);
        label_11:
            if(arg4 == null) {
                return;
            }

            SecureDirectoryStream v5 = arg4;
            try {
                Iterator v0 = v5.iterator();
                Intrinsics.checkNotNullExpressionValue(v0, "iterator(...)");
                while(v0.hasNext()) {
                    Path v2 = v0.next().getFileName();
                    Intrinsics.checkNotNullExpressionValue(v2, "getFileName(...)");
                    PathsKt__PathRecursiveFunctionsKt.handleEntry$PathsKt__PathRecursiveFunctionsKt(v5, v2, arg6.getPath(), arg6);
                }
            }
            catch(Throwable v5_1) {
                goto label_29;
            }

            try {
                CloseableKt.closeFinally(((Closeable)arg4), v1);
                return;
            }
            catch(Exception v4) {
                goto label_33;
            }

            try {
            label_29:
                throw v5_1;
            }
            catch(Throwable v0_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)arg4), v5_1);
                    throw v0_1;
                }
                catch(Exception v4) {
                label_33:
                    arg6.collect(v4);
                }
            }
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream arg2, Path arg3, Path arg4, ExceptionsCollector arg5) {
        arg5.enterEntry(arg3);
        if(arg4 != null) {
            try {
                Path v0 = arg5.getPath();
                Intrinsics.checkNotNull(v0);
                PathsKt.checkFileName(v0);
                PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(v0, arg4);
            label_6:
                if(!PathsKt__PathRecursiveFunctionsKt.isDirectory$PathsKt__PathRecursiveFunctionsKt(arg2, arg3, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                    goto label_20;
                }

                int v4 = arg5.getTotalExceptions();
                PathsKt__PathRecursiveFunctionsKt.enterDirectory$PathsKt__PathRecursiveFunctionsKt(arg2, arg3, arg5);
                if(v4 != arg5.getTotalExceptions()) {
                    goto label_25;
                }

                try {
                    arg2.deleteDirectory(arg3);
                    goto label_25;
                label_20:
                    arg2.deleteFile(arg3);
                }
                catch(NoSuchFileException ) {
                }
            }
            catch(Exception v2) {
                arg5.collect(v2);
            }
        }
        else {
            goto label_6;
        }

    label_25:
        arg5.exitEntry(arg3);
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path arg4, ExceptionsCollector arg5) {
        DirectoryStream v1;
        Throwable v0 = null;
        try {
            v1 = Files.newDirectoryStream(arg4);
            goto label_6;
        }
        catch(Exception v4) {
        }
        catch(NoSuchFileException ) {
            v1 = ((DirectoryStream)v0);
        label_6:
            if(v1 == null) {
                return;
            }

            DirectoryStream v2 = v1;
            try {
                Iterator v2_1 = v2.iterator();
                Intrinsics.checkNotNullExpressionValue(v2_1, "iterator(...)");
                while(v2_1.hasNext()) {
                    Object v3 = v2_1.next();
                    Intrinsics.checkNotNull(v3);
                    PathsKt__PathRecursiveFunctionsKt.insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(((Path)v3), arg4, arg5);
                }
            }
            catch(Throwable v4_1) {
                goto label_21;
            }

            try {
                CloseableKt.closeFinally(((Closeable)v1), v0);
                return;
            }
            catch(Exception v4) {
                goto label_25;
            }

            try {
            label_21:
                throw v4_1;
            }
            catch(Throwable v0) {
                try {
                    CloseableKt.closeFinally(((Closeable)v1), v4_1);
                    throw v0;
                }
                catch(Exception v4) {
                label_25:
                    arg5.collect(v4);
                }
            }
        }
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path arg3, Path arg4, ExceptionsCollector arg5) {
        if(arg4 != null) {
            try {
                PathsKt.checkFileName(arg3);
                PathsKt__PathRecursiveFunctionsKt.checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(arg3, arg4);
            label_3:
                if(Files.isDirectory(arg3, Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    int v4 = arg5.getTotalExceptions();
                    PathsKt__PathRecursiveFunctionsKt.insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(arg3, arg5);
                    if(v4 == arg5.getTotalExceptions()) {
                        Files.deleteIfExists(arg3);
                    }

                    return;
                }

                Files.deleteIfExists(arg3);
                return;
            }
            catch(Exception v3) {
                arg5.collect(v3);
                return;
            }
        }

        goto label_3;
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream arg2, Path arg3, LinkOption[] arg4) {
        Boolean v2;
        try {
            v2 = Boolean.valueOf(arg2.getFileAttributeView(arg3, BasicFileAttributeView.class, Arrays.copyOf(((Object[])arg4), arg4.length)).readAttributes().isDirectory());
        }
        catch(NoSuchFileException ) {
            v2 = null;
        }

        boolean v2_1 = v2 != null ? v2.booleanValue() : false;
        return v2_1;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult arg1) {
        int v1 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
        if(v1 != 1) {
            if(v1 != 2) {
                if(v1 == 3) {
                    return FileVisitResult.SKIP_SUBTREE;
                }

                throw new NoWhenBranchMatchedException();
            }

            return FileVisitResult.TERMINATE;
        }

        return FileVisitResult.CONTINUE;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult arg1) {
        int v1 = WhenMappings.$EnumSwitchMapping$1[arg1.ordinal()];
        if(v1 != 1) {
            if(v1 == 2) {
                return FileVisitResult.SKIP_SUBTREE;
            }

            throw new NoWhenBranchMatchedException();
        }

        return FileVisitResult.TERMINATE;
    }

    private static final Object tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0 arg0) {
        try {
            return arg0.invoke();
        }
        catch(NoSuchFileException ) {
            return null;
        }
    }
}

