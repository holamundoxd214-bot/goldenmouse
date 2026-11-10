package androidx.core.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u0017\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b\u001A\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0007\u001A\u001C\u0010\b\u001A\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\n\u001A\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\f\u001A\u001C\u0010\r\u001A\u0004\u0018\u00010\u000E*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000F\u001A\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012\u001A\u0017\u0010\u0013\u001A\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b¨\u0006\u0015"}, d2={"getBlobOrNull", "", "Landroid/database/Cursor;", "index", "", "getDoubleOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Double;", "getFloatOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/database/Cursor;I)Ljava/lang/Integer;", "getLongOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Long;", "getShortOrNull", "", "(Landroid/database/Cursor;I)Ljava/lang/Short;", "getStringOrNull", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return arg1.getBlob(arg2);
    }

    public static final Double getDoubleOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return Double.valueOf(arg1.getDouble(arg2));
    }

    public static final Float getFloatOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return Float.valueOf(arg1.getFloat(arg2));
    }

    public static final Integer getIntOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return Integer.valueOf(arg1.getInt(arg2));
    }

    public static final Long getLongOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return Long.valueOf(arg1.getLong(arg2));
    }

    public static final Short getShortOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return Short.valueOf(arg1.getShort(arg2));
    }

    public static final String getStringOrNull(Cursor arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isNull(arg2)) {
            return null;
        }

        return arg1.getString(arg2);
    }
}

