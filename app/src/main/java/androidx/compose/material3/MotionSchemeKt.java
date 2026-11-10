package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001\u001A\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"fromToken", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "T", "Landroidx/compose/material3/MotionScheme;", "value", "Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;", "(Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MotionSchemeKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[MotionSchemeKeyTokens.values().length];
            try {
                v0[MotionSchemeKeyTokens.DefaultSpatial.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[MotionSchemeKeyTokens.FastSpatial.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[MotionSchemeKeyTokens.SlowSpatial.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[MotionSchemeKeyTokens.DefaultEffects.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[MotionSchemeKeyTokens.FastEffects.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[MotionSchemeKeyTokens.SlowEffects.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                label_27:
                                    WhenMappings.$EnumSwitchMapping$0 = v0;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final FiniteAnimationSpec fromToken(MotionScheme arg1, MotionSchemeKeyTokens arg2) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()]) {
            case 1: {
                goto label_17;
            }
            case 2: {
                goto label_15;
            }
            case 3: {
                goto label_13;
            }
            case 4: {
                goto label_11;
            }
            case 5: {
                goto label_9;
            }
            case 6: {
                goto label_7;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_17:
        return arg1.defaultSpatialSpec();
    label_7:
        return arg1.slowEffectsSpec();
    label_9:
        return arg1.fastEffectsSpec();
    label_11:
        return arg1.defaultEffectsSpec();
    label_13:
        return arg1.slowSpatialSpec();
    label_15:
        return arg1.fastSpatialSpec();
    }

    public static final FiniteAnimationSpec value(MotionSchemeKeyTokens arg3, Composer arg4, int arg5) {
        int v1 = 0xFED171DB;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(value)288@11440L12:MotionScheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.value (MotionScheme.kt:288)");
        }

        FiniteAnimationSpec v3 = MotionSchemeKt.fromToken(MaterialTheme.INSTANCE.getMotionScheme(arg4, 6), arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }
}

