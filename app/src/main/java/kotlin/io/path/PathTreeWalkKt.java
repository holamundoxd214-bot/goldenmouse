package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\'\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A\u000E\u0010\b\u001A\u00020\t*\u00020\nH\u0082\u0080\u0004¨\u0006\u000B"}, d2={"keyOf", "", "path", "Ljava/nio/file/Path;", "linkOptions", "", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", "", "Lkotlin/io/path/PathNode;", "kotlin-stdlib-jdk7"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PathTreeWalkKt {
    public static final boolean access$createsCycle(PathNode arg0) {
        return PathTreeWalkKt.createsCycle(arg0);
    }

    public static final Object access$keyOf(Path arg0, LinkOption[] arg1) {
        return PathTreeWalkKt.keyOf(arg0, arg1);
    }

    private static final boolean createsCycle(PathNode arg4) {
        PathNode v0;
        for(v0 = arg4.getParent(); v0 != null; v0 = v0.getParent()) {
            if(v0.getKey() == null) {
                try {
                label_12:
                    if(Files.isSameFile(v0.getPath(), arg4.getPath())) {
                        return 1;
                    }
                }
                catch(SecurityException ) {
                }

                goto label_17;
                return 1;
            }
            else if(arg4.getKey() == null) {
                goto label_12;
            }
            else if(Intrinsics.areEqual(v0.getKey(), arg4.getKey())) {
                return 1;
            }

        label_17:
        }

        return 0;
    }

    private static final Object keyOf(Path arg2, LinkOption[] arg3) {
        try {
            Object[] v3 = Arrays.copyOf(((Object[])arg3), arg3.length);
            BasicFileAttributes v2 = Files.readAttributes(arg2, BasicFileAttributes.class, Arrays.copyOf(v3, v3.length));
            Intrinsics.checkNotNullExpressionValue(v2, "readAttributes(...)");
            return v2.fileKey();
        }
        catch(Throwable ) {
            return null;
        }
    }
}

