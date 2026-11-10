package androidx.compose.material3.internal.colorUtil;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0002¨\u0006\u0005"}, d2={"lerp", "", "start", "stop", "amount", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Frame_androidKt {
    public static final float access$lerp(float arg0, float arg1, float arg2) {
        return Frame_androidKt.lerp(arg0, arg1, arg2);
    }

    private static final float lerp(float arg1, float arg2, float arg3) {
        return (1f - arg3) * arg1 + arg3 * arg2;
    }
}

