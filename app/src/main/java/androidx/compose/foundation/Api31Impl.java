package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tJ\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000BJ\u000E\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/Api31Impl;", "", "<init>", "()V", "create", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onPullDistance", "", "edgeEffect", "deltaDistance", "displacement", "getDistance", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api31Impl {
    public static final Api31Impl INSTANCE;

    static {
        Api31Impl.INSTANCE = new Api31Impl();
    }

    private Api31Impl() {
        super();
    }

    public final EdgeEffect create(Context arg1, AttributeSet arg2) {
        try {
            return new EdgeEffect(arg1, arg2);
        }
        catch(Throwable ) {
            return new EdgeEffect(arg1);
        }
    }

    public final float getDistance(EdgeEffect arg1) {
        try {
            return arg1.getDistance();
        }
        catch(Throwable ) {
            return 0;
        }
    }

    public final float onPullDistance(EdgeEffect arg1, float arg2, float arg3) {
        try {
            return arg1.onPullDistance(arg2, arg3);
        }
        catch(Throwable ) {
            arg1.onPull(arg2, arg3);
            return 0;
        }
    }
}

