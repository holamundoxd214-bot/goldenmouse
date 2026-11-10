package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
        super();
    }

    public static Cursor query(ContentResolver arg1, Uri arg2, String[] arg3, String arg4, String[] arg5, String arg6, CancellationSignal arg7) {
        try {
            return arg1.query(arg2, arg3, arg4, arg5, arg6, arg7);
        }
        catch(Exception v0) {
            Exception v1 = v0;
            if((v1 instanceof OperationCanceledException)) {
                throw new androidx.core.os.OperationCanceledException();
            }

            throw v1;
        }
    }

    @Deprecated public static Cursor query(ContentResolver arg7, Uri arg8, String[] arg9, String arg10, String[] arg11, String arg12, androidx.core.os.CancellationSignal arg13) {
        Object v13 = arg13 != null ? arg13.getCancellationSignalObject() : null;
        return ContentResolverCompat.query(arg7, arg8, arg9, arg10, arg11, arg12, v13);
    }
}

