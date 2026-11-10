package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0004H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2={"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Icon v1 = Icon.createWithAdaptiveBitmap(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "createWithAdaptiveBitmap(...)");
        return v1;
    }

    public static final Icon toIcon(Bitmap arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Icon v1 = Icon.createWithBitmap(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "createWithBitmap(...)");
        return v1;
    }

    public static final Icon toIcon(Uri arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Icon v1 = Icon.createWithContentUri(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "createWithContentUri(...)");
        return v1;
    }

    public static final Icon toIcon(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Icon v2 = Icon.createWithData(arg2, 0, arg2.length);
        Intrinsics.checkNotNullExpressionValue(v2, "createWithData(...)");
        return v2;
    }
}

