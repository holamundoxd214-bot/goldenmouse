package androidx.compose.material3;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(level=DeprecationLevel.WARNING, message="Maintained for binary compatibility. Use the chipBorder functions instead") @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001A\u00020\u000F2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/material3/ChipBorder;", "", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "<init>", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "borderStroke", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderStroke$material3", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChipBorder {
    public static final int $stable;
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;

    static {
    }

    public ChipBorder(long arg1, long arg3, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg5);
    }

    private ChipBorder(long arg1, long arg3, float arg5) {
        super();
        this.borderColor = arg1;
        this.disabledBorderColor = arg3;
        this.borderWidth = arg5;
    }

    public final State borderStroke$material3(boolean arg4, Composer arg5, int arg6) {
        int v1 = 0x7139ED50;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(borderStroke)N(enabled)2916@136011L120:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.ChipBorder.borderStroke (Chip.kt:2915)");
        }

        float v6 = this.borderWidth;
        long v3 = arg4 ? this.borderColor : this.disabledBorderColor;
        State v3_1 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.BorderStroke-cXLIe8U(v6, v3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v3_1;
    }

    public boolean equals(Object arg7) {
        if(this == (((ChipBorder)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof ChipBorder)) {
            }
            else if(!Color.equals-impl0(this.borderColor, ((ChipBorder)arg7).borderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledBorderColor, ((ChipBorder)arg7).disabledBorderColor)) {
                return 0;
            }
            else if(!Dp.equals-impl0(this.borderWidth, ((ChipBorder)arg7).borderWidth)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.borderColor) * 0x1F + Color.hashCode-impl(this.disabledBorderColor)) * 0x1F + Dp.hashCode-impl(this.borderWidth);
    }
}

