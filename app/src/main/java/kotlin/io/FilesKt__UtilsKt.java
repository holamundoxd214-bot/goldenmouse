package kotlin.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001A,\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0087\u0080\u0004\u001A,\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0087\u0080\u0004\u001A\u0016\u0010\u000E\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010\u0010\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u001D\u0010\u0013\u001A\u0004\u0018\u00010\u0003*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0014\u001A*\u0010\u0015\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00012\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001AH\u0087\u0080\b\u001A<\u0010\u001B\u001A\u00020\u0018*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00012\b\b\u0002\u0010\u0017\u001A\u00020\u00182\u001A\b\u0002\u0010\u001C\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001F0\u001DH\u0087\u0080\b\u001A\u000E\u0010 \u001A\u00020\u0018*\u00020\u0001H\u0087\u0080\b\u001A\u0016\u0010!\u001A\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010!\u001A\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u0016\u0010#\u001A\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010#\u001A\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u000E\u0010$\u001A\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001A\u0013\u0010$\u001A\u00020%*\u00020%H\u0082\u0080\u0004¢\u0006\u0002\b&\u001A\u001F\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00010\'*\b\u0012\u0004\u0012\u00020\u00010\'H\u0082\u0080\u0004¢\u0006\u0002\b&\u001A\u0016\u0010(\u001A\u00020\u0001*\u00020\u00012\u0006\u0010)\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010(\u001A\u00020\u0001*\u00020\u00012\u0006\u0010)\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u0016\u0010*\u001A\u00020\u0001*\u00020\u00012\u0006\u0010)\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010*\u001A\u00020\u0001*\u00020\u00012\u0006\u0010)\u001A\u00020\u0003H\u0086\u0080\u0004\"\u0019\u0010\u0007\u001A\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\b\u0010\t\"\u0019\u0010\n\u001A\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t\"\u0019\u0010\f\u001A\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\r\u0010\t¨\u0006+"}, d2={"createTempDir", "Ljava/io/File;", "prefix", "", "suffix", "directory", "createTempFile", "extension", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "toRelativeString", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "copyTo", "target", "overwrite", "", "bufferSize", "", "copyRecursively", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "deleteRecursively", "startsWith", "other", "endsWith", "normalize", "Lkotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", "", "resolve", "relative", "resolveSibling", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/FilesKt") class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static OnErrorAction $r8$lambda$PN4W4m_bMsOvVN4PKSOdmJGtU3Q(File arg0, IOException arg1) {
        return FilesKt__UtilsKt.copyRecursively$lambda$0$FilesKt__UtilsKt(arg0, arg1);
    }

    public static Unit $r8$lambda$lnI-AFWpcqImJk9omrkfsWa50BI(Function2 arg0, File arg1, IOException arg2) {
        return FilesKt__UtilsKt.copyRecursively$lambda$1$FilesKt__UtilsKt(arg0, arg1, arg2);
    }

    public FilesKt__UtilsKt() {
        super();
    }

    @IgnorableReturnValue public static final boolean copyRecursively(File arg12, File arg13, boolean arg14, Function2 arg15) {
        boolean v7;
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        Intrinsics.checkNotNullParameter(arg13, "target");
        Intrinsics.checkNotNullParameter(arg15, "onError");
        if(!arg12.exists()) {
            if(arg15.invoke(arg12, new NoSuchFileException(arg12, null, "The source file doesn\'t exist.", 2, null)) != OnErrorAction.TERMINATE) {
                return 1;
            }

            return 0;
        }

        File v4 = arg12;
        try {
            Iterator v12 = FilesKt.walkTopDown(v4).onFail(new FilesKt__UtilsKt$$ExternalSyntheticLambda0(arg15)).iterator();
            while(true) {
            label_28:
                if(!v12.hasNext()) {
                    return 1;
                }

                Object v5 = v12.next();
                if(!((File)v5).exists()) {
                    if(arg15.invoke(v5, new NoSuchFileException(v5, null, "The source file doesn\'t exist.", 2, null)) != OnErrorAction.TERMINATE) {
                        continue;
                    }

                    return 0;
                }

                File v6 = new File(arg13, FilesKt.toRelativeString(v5, v4));
                if((v6.exists()) && (!((File)v5).isDirectory() || !v6.isDirectory())) {
                    if(!arg14) {
                    }
                    else if(!v6.isDirectory()) {
                        if(!v6.delete()) {
                            goto label_64;
                        }

                        goto label_71;
                    }
                    else if(!FilesKt.deleteRecursively(v6)) {
                    }
                    else {
                        goto label_71;
                    }

                label_64:
                    if(arg15.invoke(v6, new FileAlreadyExistsException(((File)v5), v6, "The destination file already exists.")) != OnErrorAction.TERMINATE) {
                        continue;
                    }

                    return 0;
                }

            label_71:
                if(((File)v5).isDirectory()) {
                    v6.mkdirs();
                    continue;
                }

                v7 = arg14;
                File v14 = FilesKt.copyTo$default(((File)v5), v6, v7, 0, 4, null);
                Object v6_1 = v5;
                if(v14.length() != ((File)v6_1).length() && arg15.invoke(v6_1, new IOException("Source file wasn\'t copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                    return 0;
                }

                goto label_91;
            }
        }
        catch(TerminateException ) {
            return 0;
        }

        return 0;
    label_91:
        arg14 = v7;
        goto label_28;
        return 1;
    }

    public static boolean copyRecursively$default(File arg0, File arg1, boolean arg2, Function2 arg3, int arg4, Object arg5) {
        FilesKt__UtilsKt$$ExternalSyntheticLambda1 v3;
        if((arg4 & 4) != 0) {
            v3 = new FilesKt__UtilsKt$$ExternalSyntheticLambda1();
        }

        return FilesKt.copyRecursively(arg0, arg1, false, ((Function2)v3));
    }

    private static final OnErrorAction copyRecursively$lambda$0$FilesKt__UtilsKt(File arg1, IOException arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<unused var>");
        Intrinsics.checkNotNullParameter(arg2, "exception");
        throw arg2;
    }

    private static final Unit copyRecursively$lambda$1$FilesKt__UtilsKt(Function2 arg1, File arg2, IOException arg3) {
        Intrinsics.checkNotNullParameter(arg2, "f");
        Intrinsics.checkNotNullParameter(arg3, "e");
        if(arg1.invoke(arg2, arg3) != OnErrorAction.TERMINATE) {
            return Unit.INSTANCE;
        }

        throw new TerminateException(arg2);
    }

    @IgnorableReturnValue public static final File copyTo(File arg6, File arg7, boolean arg8, int arg9) {
        Throwable v6_1;
        FileOutputStream v1;
        FileInputStream v6;
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "target");
        if(arg6.exists()) {
            if(arg7.exists()) {
                if(!arg8) {
                    throw new FileAlreadyExistsException(arg6, arg7, "The destination file already exists.");
                }
                else if(arg7.delete()) {
                }
                else {
                    throw new FileAlreadyExistsException(arg6, arg7, "Tried to overwrite the destination, but failed to delete it.");
                }
            }

            if(arg6.isDirectory()) {
                if(arg7.mkdirs()) {
                    return arg7;
                }

                throw new FileSystemException(arg6, arg7, "Failed to create target directory.");
            }

            File v8 = arg7.getParentFile();
            if(v8 != null) {
                v8.mkdirs();
            }

            FileInputStream v8_1 = new FileInputStream(arg6);
            try {
                v6 = v8_1;
                v1 = new FileOutputStream(arg7);
            }
            catch(Throwable v0) {
                goto label_54;
            }

            FileOutputStream v0_1 = v1;
            try {
                ByteStreamsKt.copyTo(((InputStream)v6), ((OutputStream)v0_1), arg9);
                v6_1 = null;
                goto label_42;
            }
            catch(Throwable v0) {
                v6_1 = v0;
                try {
                    throw v6_1;
                }
                catch(Throwable v0) {
                    Throwable v7 = v0;
                    try {
                        CloseableKt.closeFinally(((Closeable)v1), v6_1);
                        throw v7;
                    label_42:
                        CloseableKt.closeFinally(((Closeable)v1), v6_1);
                    }
                    catch(Throwable v0) {
                    label_54:
                        v6_1 = v0;
                        try {
                            throw v6_1;
                        }
                        catch(Throwable v0) {
                            CloseableKt.closeFinally(((Closeable)v8_1), v6_1);
                            throw v0;
                        }
                    }
                }
            }

            CloseableKt.closeFinally(((Closeable)v8_1), v6_1);
            return arg7;
        }

        throw new NoSuchFileException(arg6, null, "The source file doesn\'t exist.", 2, null);
    }

    public static File copyTo$default(File arg0, File arg1, boolean arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = 0x2000;
        }

        return FilesKt.copyTo(arg0, arg1, false, arg3);
    }

    @Deprecated(message="Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.") @DeprecatedSinceKotlin(errorSince="2.3", warningSince="1.4") public static final File createTempDir(String arg1, String arg2, File arg3) {
        Intrinsics.checkNotNullParameter(arg1, "prefix");
        File v1 = File.createTempFile(arg1, arg2, arg3);
        v1.delete();
        if(v1.mkdir()) {
            Intrinsics.checkNotNull(v1);
            return v1;
        }

        throw new IOException("Unable to create temporary directory " + v1 + '.');
    }

    public static File createTempDir$default(String arg1, String arg2, File arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = "tmp";
        }

        String v0 = null;
        if((arg4 & 2) != 0) {
            arg2 = v0;
        }

        if((arg4 & 4) != 0) {
            arg3 = ((File)v0);
        }

        return FilesKt.createTempDir(arg1, arg2, arg3);
    }

    @Deprecated(message="Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.") @DeprecatedSinceKotlin(errorSince="2.3", warningSince="1.4") public static final File createTempFile(String arg1, String arg2, File arg3) {
        Intrinsics.checkNotNullParameter(arg1, "prefix");
        File v1 = File.createTempFile(arg1, arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "createTempFile(...)");
        return v1;
    }

    public static File createTempFile$default(String arg1, String arg2, File arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = "tmp";
        }

        String v0 = null;
        if((arg4 & 2) != 0) {
            arg2 = v0;
        }

        if((arg4 & 4) != 0) {
            arg3 = ((File)v0);
        }

        return FilesKt.createTempFile(arg1, arg2, arg3);
    }

    @IgnorableReturnValue public static final boolean deleteRecursively(File arg4) {
        boolean v1;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Iterator v4 = FilesKt.walkBottomUp(arg4).iterator();
        while(true) {
        label_5:
            v1 = true;
            while(true) {
            label_6:
                if(!v4.hasNext()) {
                    return v1;
                }

                Object v2 = v4.next();
                if(((((File)v2).delete()) || !((File)v2).exists()) && (v1)) {
                    goto label_5;
                }

                break;
            }
        }

        v1 = false;
        goto label_6;
        return v1;
    }

    public static final boolean endsWith(File arg3, File arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        FilePathComponents v0 = FilesKt.toComponents(arg3);
        FilePathComponents v1 = FilesKt.toComponents(arg4);
        if(v1.isRooted()) {
            return Intrinsics.areEqual(arg3, arg4);
        }

        int v3 = v0.getSize() - v1.getSize();
        if(v3 < 0) {
            return 0;
        }

        return v0.getSegments().subList(v3, v0.getSize()).equals(v1.getSegments());
    }

    public static final boolean endsWith(File arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        return FilesKt.endsWith(arg1, new File(arg2));
    }

    public static final String getExtension(File arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        String v2 = arg2.getName();
        Intrinsics.checkNotNullExpressionValue(v2, "getName(...)");
        return StringsKt.substringAfterLast(v2, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        String v2 = "getPath(...)";
        if(File.separatorChar != 0x2F) {
            String v3 = arg9.getPath();
            Intrinsics.checkNotNullExpressionValue(v3, v2);
            return StringsKt.replace$default(v3, File.separatorChar, '/', false, 4, null);
        }

        String v9 = arg9.getPath();
        Intrinsics.checkNotNullExpressionValue(v9, v2);
        return v9;
    }

    public static final String getNameWithoutExtension(File arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        String v3 = arg3.getName();
        Intrinsics.checkNotNullExpressionValue(v3, "getName(...)");
        return StringsKt.substringBeforeLast$default(v3, ".", null, 2, null);
    }

    public static final File normalize(File arg10) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        FilePathComponents v10 = FilesKt.toComponents(arg10);
        File v0 = v10.getRoot();
        List v1 = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(v10.getSegments());
        String v10_1 = File.separator;
        Intrinsics.checkNotNullExpressionValue(v10_1, "separator");
        return FilesKt.resolve(v0, CollectionsKt.joinToString$default(((Iterable)v1), v10_1, null, null, 0, null, null, 62, null));
    }

    private static final List normalize$FilesKt__UtilsKt(List arg4) {
        ArrayList v0 = new ArrayList(arg4.size());
        Iterator v4 = arg4.iterator();
        while(v4.hasNext()) {
            Object v1 = v4.next();
            String v2 = ((File)v1).getName();
            if(Intrinsics.areEqual(v2, ".")) {
                continue;
            }

            String v3 = "..";
            if(Intrinsics.areEqual(v2, v3)) {
                if(!((List)v0).isEmpty() && !Intrinsics.areEqual(CollectionsKt.last(((List)v0)).getName(), v3)) {
                    ((List)v0).remove(((List)v0).size() - 1);
                    continue;
                }

                Boolean.valueOf(((List)v0).add(v1));
                continue;
            }

            Boolean.valueOf(((List)v0).add(v1));
        }

        return ((List)v0);
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents arg2) {
        return new FilePathComponents(arg2.getRoot(), FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(arg2.getSegments()));
    }

    public static final File relativeTo(File arg1, File arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "base");
        return new File(FilesKt.toRelativeString(arg1, arg2));
    }

    public static final File relativeToOrNull(File arg1, File arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "base");
        String v1 = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt(arg1, arg2);
        if(v1 != null) {
            return new File(v1);
        }

        return null;
    }

    public static final File relativeToOrSelf(File arg1, File arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "base");
        String v2 = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt(arg1, arg2);
        if(v2 != null) {
            arg1 = new File(v2);
        }

        return arg1;
    }

    public static final File resolve(File arg5, File arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "relative");
        if(FilesKt.isRooted(arg6)) {
            return arg6;
        }

        String v5 = arg5.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        String v0 = v5;
        if(((CharSequence)v0).length() == 0) {
        }
        else {
            if(StringsKt.endsWith$default(((CharSequence)v0), File.separatorChar, false, 2, null)) {
                goto label_20;
            }

            goto label_28;
        }

    label_20:
        return new File(v5 + arg6);
    label_28:
        return new File(v5 + File.separatorChar + arg6);
    }

    public static final File resolve(File arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "relative");
        return FilesKt.resolve(arg1, new File(arg2));
    }

    public static final File resolveSibling(File arg2, File arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "relative");
        FilePathComponents v2 = FilesKt.toComponents(arg2);
        File v0 = v2.getSize() == 0 ? new File("..") : v2.subPath(0, v2.getSize() - 1);
        return FilesKt.resolve(FilesKt.resolve(v2.getRoot(), v0), arg3);
    }

    public static final File resolveSibling(File arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "relative");
        return FilesKt.resolveSibling(arg1, new File(arg2));
    }

    public static final boolean startsWith(File arg3, File arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "other");
        FilePathComponents v3 = FilesKt.toComponents(arg3);
        FilePathComponents v4 = FilesKt.toComponents(arg4);
        if(!Intrinsics.areEqual(v3.getRoot(), v4.getRoot())) {
            return 0;
        }

        if(v3.getSize() < v4.getSize()) {
            return 0;
        }

        return v3.getSegments().subList(0, v4.getSize()).equals(v4.getSegments());
    }

    public static final boolean startsWith(File arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        return FilesKt.startsWith(arg1, new File(arg2));
    }

    public static final String toRelativeString(File arg3, File arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "base");
        String v0 = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt(arg3, arg4);
        if(v0 != null) {
            return v0;
        }

        throw new IllegalArgumentException("this and base files have different roots: " + arg3 + " and " + arg4 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File arg14, File arg15) {
        FilePathComponents v14 = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents(arg14));
        FilePathComponents v15 = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents(arg15));
        String v1 = null;
        if(!Intrinsics.areEqual(v14.getRoot(), v15.getRoot())) {
            return v1;
        }

        int v0 = v15.getSize();
        int v2 = v14.getSize();
        int v3 = Math.min(v2, v0);
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            if(!Intrinsics.areEqual(v14.getSegments().get(v4), v15.getSegments().get(v4))) {
                break;
            }
        }

        StringBuilder v3_1 = new StringBuilder();
        int v5 = v0 - 1;
        if(v4 <= v5) {
            while(true) {
                String v7 = "..";
                if(Intrinsics.areEqual(v15.getSegments().get(v5).getName(), v7)) {
                    return v1;
                }

                v3_1.append(v7);
                if(v5 != v4) {
                    v3_1.append(File.separatorChar);
                }

                if(v5 == v4) {
                    goto label_41;
                }

                --v5;
            }

            return v1;
        }

    label_41:
        if(v4 < v2) {
            if(v4 < v0) {
                v3_1.append(File.separatorChar);
            }

            List v4_1 = CollectionsKt.drop(v14.getSegments(), v4);
            String v14_1 = File.separator;
            Intrinsics.checkNotNullExpressionValue(v14_1, "separator");
            CollectionsKt.joinTo$default(((Iterable)v4_1), v3_1, v14_1, null, null, 0, null, null, 0x7C, null);
        }

        return v3_1.toString();
    }
}

