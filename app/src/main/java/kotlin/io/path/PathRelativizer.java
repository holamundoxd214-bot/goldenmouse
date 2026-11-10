package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005H\u0086\u0080\u0004R\u0017\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/io/path/PathRelativizer;", "", "<init>", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) final class PathRelativizer {
    public static final PathRelativizer INSTANCE;
    private static final Path emptyPath;
    private static final Path parentPath;

    static {
        PathRelativizer.INSTANCE = new PathRelativizer();
        PathRelativizer.emptyPath = Paths.get("", new String[0]);
        PathRelativizer.parentPath = Paths.get("..", new String[0]);
    }

    private PathRelativizer() {
        super();
    }

    public final Path tryRelativeTo(Path arg6, Path arg7) {
        Intrinsics.checkNotNullParameter(arg6, "path");
        Intrinsics.checkNotNullParameter(arg7, "base");
        Path v5 = arg7.normalize();
        arg6 = arg6.normalize();
        arg7 = v5.relativize(arg6);
        int v0 = Math.min(v5.getNameCount(), arg6.getNameCount());
        int v2 = 0;
        while(true) {
            if(v2 < v0) {
                Path v3 = v5.getName(v2);
                Path v4 = PathRelativizer.parentPath;
                if(Intrinsics.areEqual(v3, v4)) {
                    if(Intrinsics.areEqual(arg6.getName(v2), v4)) {
                        ++v2;
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }

            goto label_26;
        }

        throw new IllegalArgumentException("Unable to compute relative path");
    label_26:
        if((Intrinsics.areEqual(arg6, v5)) || !Intrinsics.areEqual(v5, PathRelativizer.emptyPath)) {
            String v5_1 = arg7.toString();
            String v6 = arg7.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(v6, "getSeparator(...)");
            arg6 = StringsKt.endsWith$default(v5_1, v6, false, 2, null) ? arg7.getFileSystem().getPath(StringsKt.dropLast(v5_1, arg7.getFileSystem().getSeparator().length()), new String[0]) : arg7;
        }
        else {
        }

        Intrinsics.checkNotNull(arg6);
        return arg6;
    }
}

