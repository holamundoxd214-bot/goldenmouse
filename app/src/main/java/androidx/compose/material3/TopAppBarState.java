package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR$\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00038F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\n\"\u0004\b\u0010\u0010\fR+\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u0011\u0010\u0017\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\nR\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/material3/TopAppBarState;", "", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "<init>", "(FFF)V", "heightOffsetLimit", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "contentOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "collapsedFraction", "getCollapsedFraction", "overlappedFraction", "getOverlappedFraction", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TopAppBarState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/material3/TopAppBarState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TopAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return TopAppBarState.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private float heightOffsetLimit;

    static {
        TopAppBarState.Companion = new Companion(null);
        TopAppBarState.Saver = ListSaverKt.listSaver(new TopAppBarState$$ExternalSyntheticLambda0(), new TopAppBarState$$ExternalSyntheticLambda1());
    }

    public TopAppBarState(float arg1, float arg2, float arg3) {
        super();
        this.heightOffsetLimit = arg1;
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg3);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg2);
    }

    static final List Saver$lambda$0(SaverScope arg2, TopAppBarState arg3) {
        return CollectionsKt.listOf(new Float[]{Float.valueOf(arg3.heightOffsetLimit), Float.valueOf(arg3.getHeightOffset()), Float.valueOf(arg3.getContentOffset())});
    }

    static final TopAppBarState Saver$lambda$1(List arg4) {
        return new TopAppBarState(arg4.get(0).floatValue(), arg4.get(1).floatValue(), arg4.get(2).floatValue());
    }

    public static final Saver access$getSaver$cp() {
        return TopAppBarState.Saver;
    }

    public final float getCollapsedFraction() {
        if(this.heightOffsetLimit == 0f) {
            return 0;
        }

        return this.getHeightOffset() / this.heightOffsetLimit;
    }

    public final float getContentOffset() {
        return this.contentOffset$delegate.getFloatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public final float getHeightOffsetLimit() {
        return this.heightOffsetLimit;
    }

    public final float getOverlappedFraction() {
        float v0 = this.heightOffsetLimit;
        if(v0 == 0f) {
            return 0;
        }

        return 1f - RangesKt.coerceIn(v0 - this.getContentOffset(), this.heightOffsetLimit, 0f) / this.heightOffsetLimit;
    }

    public final void setContentOffset(float arg1) {
        this.contentOffset$delegate.setFloatValue(arg1);
    }

    public final void setHeightOffset(float arg3) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(arg3, this.heightOffsetLimit, 0f));
    }

    public final void setHeightOffsetLimit(float arg1) {
        this.heightOffsetLimit = arg1;
    }
}

