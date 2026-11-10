package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\b\u0003\u001A\u000E\u0010\u000E\u001A\u00020\u000F*\u00020\u0005H\u0080\u0080\u0004\u001A\u001E\u0010\u0010\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\u0080\u0004\"\u0019\u0010\u0004\u001A\u00020\u0002*\u00020\u00058@X\u0080\u0084\b¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007\"\u0019\u0010\b\u001A\u00020\u0005*\u00020\u00058@X\u0080\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\n\"\u0019\u0010\u000B\u001A\u00020\f*\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\r¨\u0006\u0013"}, d2={"getRootLength", "", "", "getRootLength$FilesKt__FilePathComponentsKt", "rootName", "Ljava/io/File;", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "isRooted", "", "(Ljava/io/File;)Z", "toComponents", "Lkotlin/io/FilePathComponents;", "subPath", "beginIndex", "endIndex", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/FilesKt") class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
        super();
    }

    public static final File getRoot(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new File(FilesKt.getRootName(arg1));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String arg7) {
        String v0 = arg7;
        int v1 = StringsKt.indexOf$default(((CharSequence)v0), File.separatorChar, 0, false, 4, null);
        if(v1 == 0) {
            if(arg7.length() > 1 && arg7.charAt(1) == File.separatorChar) {
                v1 = StringsKt.indexOf$default(((CharSequence)v0), File.separatorChar, 2, false, 4, null);
                if(v1 >= 0) {
                    int v0_1 = StringsKt.indexOf$default(((CharSequence)v0), File.separatorChar, v1 + 1, false, 4, null);
                    if(v0_1 >= 0) {
                        return v0_1 + 1;
                    }
                    else {
                        return arg7.length();
                    }
                }
            }

            return 1;
        }

        char v2 = ':';
        if(v1 > 0 && arg7.charAt(v1 - 1) == v2) {
            return v1 + 1;
        }

        if(v1 == -1 && (StringsKt.endsWith$default(((CharSequence)v0), v2, false, 2, null))) {
            return arg7.length();
        }

        return 0;
    }

    public static final String getRootName(File arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        String v0 = arg2.getPath();
        Intrinsics.checkNotNullExpressionValue(v0, "getPath(...)");
        String v2 = arg2.getPath();
        Intrinsics.checkNotNullExpressionValue(v2, "getPath(...)");
        v2 = v0.substring(0, FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(v2));
        Intrinsics.checkNotNullExpressionValue(v2, "substring(...)");
        return v2;
    }

    public static final boolean isRooted(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        String v1 = arg1.getPath();
        Intrinsics.checkNotNullExpressionValue(v1, "getPath(...)");
        if(FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(v1) > 0) {
            return 1;
        }

        return 0;
    }

    public static final File subPath(File arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return FilesKt.toComponents(arg1).subPath(arg2, arg3);
    }

    public static final FilePathComponents toComponents(File arg10) {
        List v10_1;
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        String v10 = arg10.getPath();
        Intrinsics.checkNotNull(v10);
        int v0 = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(v10);
        String v2 = v10.substring(0, v0);
        Intrinsics.checkNotNullExpressionValue(v2, "substring(...)");
        v10 = v10.substring(v0);
        Intrinsics.checkNotNullExpressionValue(v10, "substring(...)");
        String v4 = v10;
        if(((CharSequence)v4).length() == 0) {
            v10_1 = CollectionsKt.emptyList();
        }
        else {
            v10_1 = StringsKt.split$default(((CharSequence)v4), new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList v0_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10_1), 10));
            Iterator v10_2 = ((Iterable)v10_1).iterator();
            while(v10_2.hasNext()) {
                ((Collection)v0_1).add(new File(v10_2.next()));
            }

            ArrayList v10_3 = v0_1;
        }

        return new FilePathComponents(new File(v2), v10_1);
    }
}

