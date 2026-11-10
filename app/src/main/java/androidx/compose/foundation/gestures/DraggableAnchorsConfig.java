package androidx.compose.foundation.gestures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u000F\u001A\u00020\u0010*\u00028\u00002\u0006\u0010\u0011\u001A\u00020\u0012H\u0086\u0004¢\u0006\u0002\u0010\u0013J\r\u0010\u0014\u001A\u00020\nH\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001A\u00020\u0010H\u0002R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "T", "", "<init>", "()V", "keys", "", "getKeys$foundation", "()Ljava/util/List;", "positions", "", "getPositions$foundation", "()[F", "setPositions$foundation", "([F)V", "at", "", "position", "", "(Ljava/lang/Object;F)V", "buildPositions", "buildPositions$foundation", "buildKeys", "", "buildKeys$foundation", "expandPositions", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DraggableAnchorsConfig {
    public static final int $stable = 8;
    private final List keys;
    private float[] positions;

    static {
    }

    public DraggableAnchorsConfig() {
        super();
        this.keys = new ArrayList();
        int v0 = 5;
        float[] v1 = new float[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = NaNf;
        }

        this.positions = v1;
    }

    public final void at(Object arg2, float arg3) {
        this.keys.add(arg2);
        if(this.positions.length < this.keys.size()) {
            this.expandPositions();
        }

        this.positions[this.keys.size() - 1] = arg3;
    }

    public final List buildKeys$foundation() {
        return this.keys;
    }

    public final float[] buildPositions$foundation() {
        return ArraysKt.copyOfRange(this.positions, 0, this.keys.size());
    }

    private final void expandPositions() {
        float[] v0 = Arrays.copyOf(this.positions, this.keys.size() + 2);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        this.positions = v0;
    }

    public final List getKeys$foundation() {
        return this.keys;
    }

    public final float[] getPositions$foundation() {
        return this.positions;
    }

    public final void setPositions$foundation(float[] arg1) {
        this.positions = arg1;
    }
}

