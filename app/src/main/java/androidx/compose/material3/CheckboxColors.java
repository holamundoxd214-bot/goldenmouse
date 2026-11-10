package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0085\u0001\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u0003¢\u0006\u0004\b \u0010!J\u001D\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010$\u001A\u00020%H\u0001¢\u0006\u0004\b&\u0010\'J%\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001A\u00020*2\u0006\u0010$\u001A\u00020%H\u0001¢\u0006\u0004\b+\u0010,J%\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001A\u00020*2\u0006\u0010$\u001A\u00020%H\u0001¢\u0006\u0004\b.\u0010,J\u001B\u0010/\u001A\b\u0012\u0004\u0012\u00020\u0003002\u0006\u0010$\u001A\u00020%H\u0003¢\u0006\u0002\u00101J\u0013\u00102\u001A\u00020*2\b\u00103\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00104\u001A\u000205H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001A\u0010\u0012R\u0013\u0010\u000B\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001B\u0010\u0012R\u0013\u0010\f\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001C\u0010\u0012R\u0013\u0010\r\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001D\u0010\u0012R\u0013\u0010\u000E\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001E\u0010\u0012¨\u00066"}, d2={"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedCheckmarkColor-0d7_KjU", "()J", "J", "getUncheckedCheckmarkColor-0d7_KjU", "getCheckedBoxColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getCheckedBorderColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "checkmarkColor", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/ui/state/ToggleableState;", "checkmarkColor$material3", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "enabled", "", "boxColor$material3", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "borderColor", "borderColor$material3", "colorAnimationSpecForState", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/AnimationSpec;", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CheckboxColors {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ToggleableState.values().length];
            try {
                v0[ToggleableState.On.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ToggleableState.Indeterminate.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ToggleableState.Off.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    static {
    }

    private CheckboxColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23) {
        super();
        this.checkedCheckmarkColor = arg1;
        this.uncheckedCheckmarkColor = arg3;
        this.checkedBoxColor = arg5;
        this.uncheckedBoxColor = arg7;
        this.disabledCheckedBoxColor = arg9;
        this.disabledUncheckedBoxColor = arg11;
        this.disabledIndeterminateBoxColor = arg13;
        this.checkedBorderColor = arg15;
        this.uncheckedBorderColor = arg17;
        this.disabledBorderColor = arg19;
        this.disabledUncheckedBorderColor = arg21;
        this.disabledIndeterminateBorderColor = arg23;
    }

    public CheckboxColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, DefaultConstructorMarker arg25) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23);
    }

    public final State borderColor$material3(boolean arg12, ToggleableState arg13, Composer arg14, int arg15) {
        State v11;
        Composer v8;
        long v0_1;
        int v3;
        int v1 = 1009643462;
        ComposerKt.sourceInformationMarkerStart(arg14, v1, "C(borderColor)N(enabled,state):Checkbox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg15, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:657)");
        }

        int v0 = 2;
        int v2 = 3;
        if(arg12) {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg13.ordinal()];
            if(v3 != 1 && v3 != v0) {
                if(v3 == v2) {
                    v0_1 = this.uncheckedBorderColor;
                    goto label_39;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            v0_1 = this.checkedBorderColor;
        }
        else {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg13.ordinal()];
            if(v3 != 1) {
                if(v3 != v0) {
                    if(v3 == v2) {
                        v0_1 = this.disabledUncheckedBorderColor;
                        goto label_39;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                v0_1 = this.disabledIndeterminateBorderColor;
                goto label_39;
            }

            v0_1 = this.disabledBorderColor;
        }

    label_39:
        long v3_1 = v0_1;
        if(arg12) {
            arg14.startReplaceGroup(0x25BE58C6);
            ComposerKt.sourceInformation(arg14, "676@30610L33,676@30582L62");
            v8 = arg14;
            v11 = SingleValueAnimationKt.animateColorAsState-euL9pac(v3_1, this.colorAnimationSpecForState(arg13, arg14, arg15 >> 3 & 0x7E), null, null, v8, 0, 12);
            v8.endReplaceGroup();
        }
        else {
            v8 = arg14;
            v8.startReplaceGroup(0x25BFB928);
            ComposerKt.sourceInformation(v8, "678@30674L28");
            v11 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3_1), v8, 0);
            v8.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v8);
        return v11;
    }

    public final State boxColor$material3(boolean arg12, ToggleableState arg13, Composer arg14, int arg15) {
        State v11;
        Composer v8;
        long v0_1;
        int v3;
        int v1 = 0x15804D09;
        ComposerKt.sourceInformationMarkerStart(arg14, v1, "C(boxColor)N(enabled,state):Checkbox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg15, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:625)");
        }

        int v0 = 2;
        int v2 = 3;
        if(arg12) {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg13.ordinal()];
            if(v3 != 1 && v3 != v0) {
                if(v3 == v2) {
                    v0_1 = this.uncheckedBoxColor;
                    goto label_39;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            v0_1 = this.checkedBoxColor;
        }
        else {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg13.ordinal()];
            if(v3 != 1) {
                if(v3 != v0) {
                    if(v3 == v2) {
                        v0_1 = this.disabledUncheckedBoxColor;
                        goto label_39;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                v0_1 = this.disabledIndeterminateBoxColor;
                goto label_39;
            }

            v0_1 = this.disabledCheckedBoxColor;
        }

    label_39:
        long v3_1 = v0_1;
        if(arg12) {
            arg14.startReplaceGroup(0x1D912603);
            ComposerKt.sourceInformation(arg14, "644@29378L33,644@29350L62");
            v8 = arg14;
            v11 = SingleValueAnimationKt.animateColorAsState-euL9pac(v3_1, this.colorAnimationSpecForState(arg13, arg14, arg15 >> 3 & 0x7E), null, null, v8, 0, 12);
            v8.endReplaceGroup();
        }
        else {
            v8 = arg14;
            v8.startReplaceGroup(0x1D928665);
            ComposerKt.sourceInformation(v8, "646@29442L28");
            v11 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3_1), v8, 0);
            v8.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v8);
        return v11;
    }

    public final State checkmarkColor$material3(ToggleableState arg11, Composer arg12, int arg13) {
        int v1 = -507585681;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(checkmarkColor)N(state)614@28208L33,614@28180L62:Checkbox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:606)");
        }

        long v0 = arg11 == ToggleableState.Off ? this.uncheckedCheckmarkColor : this.checkedCheckmarkColor;
        Composer v7 = arg12;
        State v10 = SingleValueAnimationKt.animateColorAsState-euL9pac(v0, this.colorAnimationSpecForState(arg11, arg12, arg13 & 0x7E), null, null, v7, 0, 12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        return v10;
    }

    private final AnimationSpec colorAnimationSpecForState(ToggleableState arg3, Composer arg4, int arg5) {
        FiniteAnimationSpec v2;
        int v0 = 0xBFE5D70B;
        ComposerKt.sourceInformationMarkerStart(arg4, v0, "C(colorAnimationSpecForState)N(state):Checkbox.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.material3.CheckboxColors.colorAnimationSpecForState (Checkbox.kt:684)");
        }

        arg5 = 6;
        if(arg3 == ToggleableState.Off) {
            arg4.startReplaceGroup(0x5BBF473F);
            ComposerKt.sourceInformation(arg4, "688@31089L7");
            v2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, arg4, arg5);
            arg4.endReplaceGroup();
        }
        else {
            arg4.startReplaceGroup(0x5BC0B3BD);
            ComposerKt.sourceInformation(arg4, "691@31185L7");
            v2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg4, arg5);
            arg4.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((AnimationSpec)v2);
    }

    public final CheckboxColors copy-2qZNXz8(long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54) {
        CheckboxColors v0 = this;
        long v1 = 16;
        long v6 = arg32 != v1 ? arg32 : v0.checkedCheckmarkColor;
        long v8 = arg34 != v1 ? arg34 : v0.uncheckedCheckmarkColor;
        long v10 = arg36 != v1 ? arg36 : v0.checkedBoxColor;
        long v12 = arg38 != v1 ? arg38 : v0.uncheckedBoxColor;
        long v14 = arg40 != v1 ? arg40 : v0.disabledCheckedBoxColor;
        long v16 = arg42 != v1 ? arg42 : v0.disabledUncheckedBoxColor;
        long v18 = arg44 != v1 ? arg44 : v0.disabledIndeterminateBoxColor;
        long v20 = arg46 != v1 ? arg46 : v0.checkedBorderColor;
        long v22 = arg48 != v1 ? arg48 : v0.uncheckedBorderColor;
        long v24 = arg50 != v1 ? arg50 : v0.disabledBorderColor;
        long v26 = arg52 != v1 ? arg52 : v0.disabledUncheckedBorderColor;
        long v28 = arg54 != v1 ? arg54 : v0.disabledIndeterminateBorderColor;
        return new CheckboxColors(v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v28, null);
    }

    public static CheckboxColors copy-2qZNXz8$default(CheckboxColors arg18, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, int arg43, Object arg44) {
        long v42;
        long v40;
        CheckboxColors v0 = arg18;
        int v1 = arg43;
        long v2 = (v1 & 1) != 0 ? v0.checkedCheckmarkColor : arg19;
        long v4 = (v1 & 2) != 0 ? v0.uncheckedCheckmarkColor : arg21;
        long v6 = (v1 & 4) != 0 ? v0.checkedBoxColor : arg23;
        long v8 = (v1 & 8) != 0 ? v0.uncheckedBoxColor : arg25;
        long v10 = (v1 & 16) != 0 ? v0.disabledCheckedBoxColor : arg27;
        long v12 = (v1 & 0x20) != 0 ? v0.disabledUncheckedBoxColor : arg29;
        long v14 = (v1 & 0x40) != 0 ? v0.disabledIndeterminateBoxColor : arg31;
        long v16 = v2;
        v2 = (v1 & 0x80) != 0 ? v0.checkedBorderColor : arg33;
        arg19 = v2;
        v2 = (v1 & 0x100) != 0 ? v0.uncheckedBorderColor : arg35;
        arg21 = v2;
        v2 = (v1 & 0x200) != 0 ? v0.disabledBorderColor : arg37;
        arg23 = v2;
        v2 = (v1 & 0x400) != 0 ? v0.disabledUncheckedBorderColor : arg39;
        if((v1 & 0x800) != 0) {
            v40 = v2;
            v42 = v0.disabledIndeterminateBorderColor;
        }
        else {
            v42 = arg41;
            v40 = v2;
        }

        return v0.copy-2qZNXz8(v16, v4, v6, v8, v10, v12, v14, arg19, arg21, arg23, v40, v42);
    }

    public boolean equals(Object arg7) {
        if(this == (((CheckboxColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof CheckboxColors)) {
            }
            else if(!Color.equals-impl0(this.checkedCheckmarkColor, ((CheckboxColors)arg7).checkedCheckmarkColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.uncheckedCheckmarkColor, ((CheckboxColors)arg7).uncheckedCheckmarkColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.checkedBoxColor, ((CheckboxColors)arg7).checkedBoxColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.uncheckedBoxColor, ((CheckboxColors)arg7).uncheckedBoxColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledCheckedBoxColor, ((CheckboxColors)arg7).disabledCheckedBoxColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledUncheckedBoxColor, ((CheckboxColors)arg7).disabledUncheckedBoxColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledIndeterminateBoxColor, ((CheckboxColors)arg7).disabledIndeterminateBoxColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.checkedBorderColor, ((CheckboxColors)arg7).checkedBorderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.uncheckedBorderColor, ((CheckboxColors)arg7).uncheckedBorderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledBorderColor, ((CheckboxColors)arg7).disabledBorderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledUncheckedBorderColor, ((CheckboxColors)arg7).disabledUncheckedBorderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledIndeterminateBorderColor, ((CheckboxColors)arg7).disabledIndeterminateBorderColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getCheckedBorderColor-0d7_KjU() {
        return this.checkedBorderColor;
    }

    public final long getCheckedBoxColor-0d7_KjU() {
        return this.checkedBoxColor;
    }

    public final long getCheckedCheckmarkColor-0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    public final long getDisabledBorderColor-0d7_KjU() {
        return this.disabledBorderColor;
    }

    public final long getDisabledCheckedBoxColor-0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    public final long getDisabledIndeterminateBorderColor-0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    public final long getDisabledIndeterminateBoxColor-0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    public final long getDisabledUncheckedBorderColor-0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    public final long getDisabledUncheckedBoxColor-0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    public final long getUncheckedBorderColor-0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    public final long getUncheckedBoxColor-0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    public final long getUncheckedCheckmarkColor-0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    public int hashCode() {
        return ((((((((((Color.hashCode-impl(this.checkedCheckmarkColor) * 0x1F + Color.hashCode-impl(this.uncheckedCheckmarkColor)) * 0x1F + Color.hashCode-impl(this.checkedBoxColor)) * 0x1F + Color.hashCode-impl(this.uncheckedBoxColor)) * 0x1F + Color.hashCode-impl(this.disabledCheckedBoxColor)) * 0x1F + Color.hashCode-impl(this.disabledUncheckedBoxColor)) * 0x1F + Color.hashCode-impl(this.disabledIndeterminateBoxColor)) * 0x1F + Color.hashCode-impl(this.checkedBorderColor)) * 0x1F + Color.hashCode-impl(this.uncheckedBorderColor)) * 0x1F + Color.hashCode-impl(this.disabledBorderColor)) * 0x1F + Color.hashCode-impl(this.disabledUncheckedBorderColor)) * 0x1F + Color.hashCode-impl(this.disabledIndeterminateBorderColor);
    }
}

