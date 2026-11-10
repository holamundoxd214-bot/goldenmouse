package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\r\u001A\u00020\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/gestures/OffsetSmoother;", "", "<init>", "()V", "eventRotatingIndex", "", "eventRotatingArray", "", "Landroidx/compose/ui/geometry/Offset;", "smoothEventPosition", "offset", "smoothEventPosition-MK-Hz9U", "(J)J", "reset", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OffsetSmoother {
    public static final int $stable = 8;
    private List eventRotatingArray;
    private int eventRotatingIndex;

    static {
    }

    public OffsetSmoother() {
        super();
        this.eventRotatingArray = new ArrayList();
    }

    public final void reset() {
        this.eventRotatingIndex = 0;
        this.eventRotatingArray.clear();
    }

    public final long smoothEventPosition-MK-Hz9U(long arg10) {
        long v4;
        int v3;
        int v0 = this.eventRotatingArray.size();
        List v1 = this.eventRotatingArray;
        int v2 = 3;
        if(v0 == v2) {
            v0 = this.eventRotatingIndex;
            this.eventRotatingIndex = v0 + 1;
            v1.set(v0, Offset.box-impl(arg10));
        }
        else {
            v1.add(Offset.box-impl(arg10));
        }

        int v11 = 0;
        if(this.eventRotatingIndex == v2) {
            this.eventRotatingIndex = 0;
        }

        List v10 = this.eventRotatingArray;
        ArrayList v0_1 = new ArrayList(v10.size());
        int v1_1 = v10.size();
        for(v2 = 0; true; ++v2) {
            v3 = 0x20;
            if(v2 >= v1_1) {
                break;
            }

            v0_1.add(Float.valueOf(Float.intBitsToFloat(((int)(v10.get(v2).unbox-impl() >> v3)))));
        }

        float v10_1 = ((float)CollectionsKt.averageOfFloat(((Iterable)v0_1)));
        List v9 = this.eventRotatingArray;
        v0_1 = new ArrayList(v9.size());
        v1_1 = v9.size();
        while(true) {
            v4 = 0xFFFFFFFFL;
            if(v11 >= v1_1) {
                break;
            }

            v0_1.add(Float.valueOf(Float.intBitsToFloat(((int)(v4 & v9.get(v11).unbox-impl())))));
            ++v11;
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v10_1))) << v3 | (((long)Float.floatToRawIntBits(((float)CollectionsKt.averageOfFloat(((Iterable)v0_1)))))) & v4);
    }
}

