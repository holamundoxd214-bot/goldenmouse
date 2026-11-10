package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\b\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0003H\u0086\b\u001A\n\u0010\u0004\u001A\u00020\u0003*\u00020\u0001¨\u0006\u0005"}, d2={"toUri", "Landroid/net/Uri;", "", "Ljava/io/File;", "toFile", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class UriKt {
    public static final File toFile(Uri arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(Intrinsics.areEqual(arg2.getScheme(), "file")) {
            String v0 = arg2.getPath();
            if(v0 != null) {
                return new File(v0);
            }

            throw new IllegalArgumentException("Uri path is null: " + arg2.toString());
        }

        throw new IllegalArgumentException("Uri lacks \'file\' scheme: " + arg2.toString());
    }

    public static final Uri toUri(File arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Uri v1 = Uri.fromFile(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "fromFile(...)");
        return v1;
    }

    public static final Uri toUri(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Uri v1 = Uri.parse(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "parse(...)");
        return v1;
    }
}

