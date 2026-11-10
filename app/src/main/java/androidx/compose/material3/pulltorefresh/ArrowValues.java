package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\b\u0003\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/material3/pulltorefresh/ArrowValues;", "", "rotation", "", "startAngle", "endAngle", "scale", "<init>", "(FFFF)V", "getRotation", "()F", "getStartAngle", "getEndAngle", "getScale", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ArrowValues {
    private final float endAngle;
    private final float rotation;
    private final float scale;
    private final float startAngle;

    public ArrowValues(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.rotation = arg1;
        this.startAngle = arg2;
        this.endAngle = arg3;
        this.scale = arg4;
    }

    public final float getEndAngle() {
        return this.endAngle;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }
}

