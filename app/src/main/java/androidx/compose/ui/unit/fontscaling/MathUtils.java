package androidx.compose.ui.unit.fontscaling;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005J\u001E\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005J.\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005¨\u0006\u0012"}, d2={"Landroidx/compose/ui/unit/fontscaling/MathUtils;", "", "<init>", "()V", "lerp", "", "start", "stop", "amount", "lerpInv", "a", "b", "value", "constrainedMap", "rangeMin", "rangeMax", "valueMin", "valueMax", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MathUtils {
    public static final int $stable;
    public static final MathUtils INSTANCE;

    static {
        MathUtils.INSTANCE = new MathUtils();
    }

    private MathUtils() {
        super();
    }

    public final float constrainedMap(float arg2, float arg3, float arg4, float arg5, float arg6) {
        return this.lerp(arg2, arg3, Math.max(0f, Math.min(1f, this.lerpInv(arg4, arg5, arg6))));
    }

    public final float lerp(float arg1, float arg2, float arg3) {
        return arg1 + (arg2 - arg1) * arg3;
    }

    public final float lerpInv(float arg1, float arg2, float arg3) {
        if(arg1 == arg2) {
            return 0;
        }

        return (arg3 - arg1) / (arg2 - arg1);
    }
}

