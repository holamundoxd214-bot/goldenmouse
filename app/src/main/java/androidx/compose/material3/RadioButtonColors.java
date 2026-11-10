package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u00152\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000E\u0010\n¨\u0006\u001D"}, d2={"Landroidx/compose/material3/RadioButtonColors;", "", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedColor-0d7_KjU", "()J", "J", "getUnselectedColor-0d7_KjU", "getDisabledSelectedColor-0d7_KjU", "getDisabledUnselectedColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RadioButtonColors;", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "radioColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RadioButtonColors {
    public static final int $stable;
    private final long disabledSelectedColor;
    private final long disabledUnselectedColor;
    private final long selectedColor;
    private final long unselectedColor;

    static {
    }

    private RadioButtonColors(long arg1, long arg3, long arg5, long arg7) {
        super();
        this.selectedColor = arg1;
        this.unselectedColor = arg3;
        this.disabledSelectedColor = arg5;
        this.disabledUnselectedColor = arg7;
    }

    public RadioButtonColors(long arg1, long arg3, long arg5, long arg7, DefaultConstructorMarker arg9) {
        this(arg1, arg3, arg5, arg7);
    }

    public final RadioButtonColors copy-jRlVdoo(long arg15, long arg17, long arg19, long arg21) {
        long v0 = 16;
        long v5 = arg15 != v0 ? arg15 : this.selectedColor;
        long v7 = arg17 != v0 ? arg17 : this.unselectedColor;
        long v9 = arg19 != v0 ? arg19 : this.disabledSelectedColor;
        long v11 = arg21 != v0 ? arg21 : this.disabledUnselectedColor;
        return new RadioButtonColors(v5, v7, v9, v11, null);
    }

    public static RadioButtonColors copy-jRlVdoo$default(RadioButtonColors arg9, long arg10, long arg12, long arg14, long arg16, int arg18, Object arg19) {
        if((arg18 & 1) != 0) {
            arg10 = arg9.selectedColor;
        }

        long v1 = arg10;
        if((arg18 & 2) != 0) {
            arg12 = arg9.unselectedColor;
        }

        long v3 = arg12;
        if((arg18 & 4) != 0) {
            arg14 = arg9.disabledSelectedColor;
        }

        long v5 = arg14;
        long v7 = (arg18 & 8) != 0 ? arg9.disabledUnselectedColor : arg16;
        return arg9.copy-jRlVdoo(v1, v3, v5, v7);
    }

    public boolean equals(Object arg7) {
        if(this == (((RadioButtonColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof RadioButtonColors)) {
            }
            else if(!Color.equals-impl0(this.selectedColor, ((RadioButtonColors)arg7).selectedColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unselectedColor, ((RadioButtonColors)arg7).unselectedColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledSelectedColor, ((RadioButtonColors)arg7).disabledSelectedColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledUnselectedColor, ((RadioButtonColors)arg7).disabledUnselectedColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getDisabledSelectedColor-0d7_KjU() {
        return this.disabledSelectedColor;
    }

    public final long getDisabledUnselectedColor-0d7_KjU() {
        return this.disabledUnselectedColor;
    }

    public final long getSelectedColor-0d7_KjU() {
        return this.selectedColor;
    }

    public final long getUnselectedColor-0d7_KjU() {
        return this.unselectedColor;
    }

    public int hashCode() {
        return ((Color.hashCode-impl(this.selectedColor) * 0x1F + Color.hashCode-impl(this.unselectedColor)) * 0x1F + Color.hashCode-impl(this.disabledSelectedColor)) * 0x1F + Color.hashCode-impl(this.disabledUnselectedColor);
    }

    public final State radioColor$material3(boolean arg11, boolean arg12, Composer arg13, int arg14) {
        State v10;
        Composer v7;
        long v0;
        int v1 = -1840145292;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(radioColor)N(enabled,selected):RadioButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.material3.RadioButtonColors.radioColor (RadioButton.kt:223)");
        }

        if(!arg11 || !arg12) {
            if((arg11) && !arg12) {
                v0 = this.unselectedColor;
                goto label_11;
            }

            if(!arg11 && (arg12)) {
                v0 = this.disabledSelectedColor;
                goto label_11;
            }

            v0 = this.disabledUnselectedColor;
        }
        else {
            v0 = this.selectedColor;
        }

    label_11:
        long v2 = v0;
        if(arg11) {
            arg13.startReplaceGroup(0x47359F1D);
            ComposerKt.sourceInformation(arg13, "236@10353L7,236@10288L73");
            v7 = arg13;
            v10 = SingleValueAnimationKt.animateColorAsState-euL9pac(v2, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg13, 6), null, null, v7, 0, 12);
            v7.endReplaceGroup();
        }
        else {
            v7 = arg13;
            v7.startReplaceGroup(0x4738551A);
            ComposerKt.sourceInformation(v7, "238@10391L28");
            v10 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v2), v7, 0);
            v7.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        return v10;
    }
}

