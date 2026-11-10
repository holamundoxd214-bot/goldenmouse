package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000EH\u0016J\u001A\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001A\u00020\u000EH\u0016J\u0017\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001E\u0010\u001CR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/ui/graphics/AndroidPathMeasure;", "Landroidx/compose/ui/graphics/PathMeasure;", "internalPathMeasure", "Landroid/graphics/PathMeasure;", "<init>", "(Landroid/graphics/PathMeasure;)V", "length", "", "getLength", "()F", "positionArray", "", "tangentArray", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "setPath", "", "path", "forceClosed", "getPosition", "Landroidx/compose/ui/geometry/Offset;", "distance", "getPosition-tuRUvjQ", "(F)J", "getTangent", "getTangent-tuRUvjQ", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPathMeasure implements PathMeasure {
    public static final int $stable = 8;
    private final android.graphics.PathMeasure internalPathMeasure;
    private float[] positionArray;
    private float[] tangentArray;

    static {
    }

    public AndroidPathMeasure(android.graphics.PathMeasure arg1) {
        super();
        this.internalPathMeasure = arg1;
    }

    public float getLength() {
        return this.internalPathMeasure.getLength();
    }

    public long getPosition-tuRUvjQ(float arg5) {
        float[] v0 = this.positionArray;
        int v1 = 2;
        if(v0 == null) {
            v0 = new float[v1];
            this.positionArray = v0;
        }

        float[] v2 = this.tangentArray;
        if(v2 == null) {
            v2 = new float[v1];
            this.tangentArray = v2;
        }

        if(this.internalPathMeasure.getPosTan(arg5, v0, v2)) {
            float[] v5 = this.positionArray;
            Intrinsics.checkNotNull(v5);
            arg5 = v5[0];
            float[] v4 = this.positionArray;
            Intrinsics.checkNotNull(v4);
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(v4[1]))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg5))) << 0x20);
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public boolean getSegment(float arg2, float arg3, Path arg4, boolean arg5) {
        android.graphics.PathMeasure v1 = this.internalPathMeasure;
        if((arg4 instanceof AndroidPath)) {
            return v1.getSegment(arg2, arg3, ((AndroidPath)arg4).getInternalPath(), arg5);
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public long getTangent-tuRUvjQ(float arg5) {
        float[] v0 = this.positionArray;
        int v1 = 2;
        if(v0 == null) {
            v0 = new float[v1];
            this.positionArray = v0;
        }

        float[] v2 = this.tangentArray;
        if(v2 == null) {
            v2 = new float[v1];
            this.tangentArray = v2;
        }

        if(this.internalPathMeasure.getPosTan(arg5, v0, v2)) {
            float[] v5 = this.tangentArray;
            Intrinsics.checkNotNull(v5);
            arg5 = v5[0];
            float[] v4 = this.tangentArray;
            Intrinsics.checkNotNull(v4);
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(v4[1]))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg5))) << 0x20);
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public void setPath(Path arg2, boolean arg3) {
        android.graphics.Path v2;
        android.graphics.PathMeasure v1 = this.internalPathMeasure;
        if(arg2 == null) {
            v2 = null;
        }
        else if((arg2 instanceof AndroidPath)) {
            v2 = ((AndroidPath)arg2).getInternalPath();
        }
        else {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }

        v1.setPath(v2, arg3);
    }
}

