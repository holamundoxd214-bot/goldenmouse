package androidx.compose.ui.res;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\t2\b\b\u0001\u0010\n\u001A\u00020\u000BJ\u0006\u0010\f\u001A\u00020\rR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/res/ResourceIdCache;", "", "<init>", "()V", "resIdPathMap", "Landroidx/collection/MutableIntObjectMap;", "Landroid/util/TypedValue;", "resolveResourcePath", "res", "Landroid/content/res/Resources;", "id", "", "clear", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ResourceIdCache {
    public static final int $stable = 8;
    private final MutableIntObjectMap resIdPathMap;

    static {
    }

    public ResourceIdCache() {
        super();
        this.resIdPathMap = new MutableIntObjectMap(0, 1, null);
    }

    public final void clear() {
        __monitor_enter(this);
        try {
            this.resIdPathMap.clear();
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }

    public final TypedValue resolveResourcePath(Resources arg3, int arg4) {
        TypedValue v0_1;
        __monitor_enter(this);
        try {
            Object v0 = this.resIdPathMap.get(arg4);
            if(v0 == null) {
                v0_1 = new TypedValue();
                arg3.getValue(arg4, v0_1, true);
                this.resIdPathMap.put(arg4, v0_1);
            }
        }
        catch(Throwable v3) {
            __monitor_exit(this);
            throw v3;
        }

        __monitor_exit(this);
        return v0_1;
    }
}

