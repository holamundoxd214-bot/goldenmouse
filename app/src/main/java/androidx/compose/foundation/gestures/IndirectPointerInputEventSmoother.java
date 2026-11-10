package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\f\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "", "<init>", "()V", "eventRotatingIndex", "", "eventRotatingArray", "", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "smoothEventPosition", "Landroidx/compose/ui/geometry/Offset;", "change", "smoothEventPosition-tuRUvjQ", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)J", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerInputEventSmoother {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother$Companion;", "", "<init>", "()V", "SmoothingFactor", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int SmoothingFactor = 3;
    private List eventRotatingArray;
    private int eventRotatingIndex;

    static {
        IndirectPointerInputEventSmoother.Companion = new Companion(null);
        IndirectPointerInputEventSmoother.$stable = 8;
    }

    public IndirectPointerInputEventSmoother() {
        super();
        this.eventRotatingArray = new ArrayList();
    }

    public final long smoothEventPosition-tuRUvjQ(IndirectPointerInputChange arg12) {
        int v2 = 0x20;
        float v0 = Float.intBitsToFloat(((int)(arg12.getPosition-F1C5BW0() >> v2)));
        long v5 = 0xFFFFFFFFL;
        float v1 = Float.intBitsToFloat(((int)(arg12.getPosition-F1C5BW0() & v5)));
        int v4 = 0;
        if(IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(arg12)) {
            this.eventRotatingIndex = 0;
            this.eventRotatingArray.clear();
        }

        if(!IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(arg12) && !IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(arg12)) {
            int v0_1 = this.eventRotatingArray.size();
            List v1_1 = this.eventRotatingArray;
            int v3 = 3;
            if(v0_1 == v3) {
                v0_1 = this.eventRotatingIndex;
                this.eventRotatingIndex = v0_1 + 1;
                v1_1.set(v0_1, arg12);
            }
            else {
                v1_1.add(arg12);
            }

            if(this.eventRotatingIndex == v3) {
                this.eventRotatingIndex = 0;
            }

            List v12 = this.eventRotatingArray;
            ArrayList v0_2 = new ArrayList(v12.size());
            int v1_2 = v12.size();
            for(v3 = 0; v3 < v1_2; ++v3) {
                v0_2.add(Float.valueOf(Float.intBitsToFloat(((int)(v12.get(v3).getPosition-F1C5BW0() >> v2)))));
            }

            v0 = ((float)CollectionsKt.averageOfFloat(((Iterable)v0_2)));
            List v11 = this.eventRotatingArray;
            ArrayList v12_1 = new ArrayList(v11.size());
            v1_2 = v11.size();
            while(v4 < v1_2) {
                v12_1.add(Float.valueOf(Float.intBitsToFloat(((int)(v11.get(v4).getPosition-F1C5BW0() & v5)))));
                ++v4;
            }

            v1 = ((float)CollectionsKt.averageOfFloat(((Iterable)v12_1)));
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v2 | (((long)Float.floatToRawIntBits(v1))) & v5);
    }
}

