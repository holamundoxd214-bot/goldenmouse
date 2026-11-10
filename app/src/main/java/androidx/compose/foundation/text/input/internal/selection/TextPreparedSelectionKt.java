package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A%\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", "cursor", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextPreparedSelectionKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[IndexTransformationType.values().length];
            try {
                v0[IndexTransformationType.Untransformed.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[IndexTransformationType.Deletion.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[IndexTransformationType.Replacement.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[IndexTransformationType.Insertion.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int arg5, int arg6, TransformedTextFieldState arg7) {
        IndexTransformationType v7;
        if(arg5 == -1) {
            return CursorAndWedgeAffinity.constructor-impl(arg6);
        }

        arg6 = arg5 > arg6 ? 1 : 0;
        long v1 = arg7.mapFromTransformed--jx7JFs(arg5);
        long v3 = arg7.mapToTransformed-GEjPoXI(v1);
        if(!TextRange.getCollapsed-impl(v1) || !TextRange.getCollapsed-impl(v3)) {
            if(!TextRange.getCollapsed-impl(v1) && !TextRange.getCollapsed-impl(v3)) {
                v7 = IndexTransformationType.Replacement;
                goto label_30;
            }

            if((TextRange.getCollapsed-impl(v1)) && !TextRange.getCollapsed-impl(v3)) {
                v7 = IndexTransformationType.Insertion;
                goto label_30;
            }

            v7 = IndexTransformationType.Deletion;
        }
        else {
            v7 = IndexTransformationType.Untransformed;
        }

    label_30:
        int v7_1 = WhenMappings.$EnumSwitchMapping$0[v7.ordinal()];
        if(v7_1 != 1) {
            if(v7_1 != 2) {
                if(v7_1 != 3) {
                    if(v7_1 == 4) {
                        if(arg6 != 0) {
                            if(arg5 == TextRange.getStart-impl(v3)) {
                                return CursorAndWedgeAffinity.constructor-impl(arg5, WedgeAffinity.Start);
                            }

                            return CursorAndWedgeAffinity.constructor-impl(TextRange.getEnd-impl(v3), WedgeAffinity.End);
                        }

                        if(arg5 == TextRange.getEnd-impl(v3)) {
                            return CursorAndWedgeAffinity.constructor-impl(arg5, WedgeAffinity.End);
                        }

                        return CursorAndWedgeAffinity.constructor-impl(TextRange.getStart-impl(v3), WedgeAffinity.Start);
                    }

                    throw new NoWhenBranchMatchedException();
                }

                if(arg6 != 0) {
                    return CursorAndWedgeAffinity.constructor-impl(TextRange.getEnd-impl(v3), WedgeAffinity.Start);
                }

                return CursorAndWedgeAffinity.constructor-impl(TextRange.getStart-impl(v3), WedgeAffinity.End);
            }

            return CursorAndWedgeAffinity.constructor-impl(arg5);
        }

        WedgeAffinity v6 = arg6 != 0 ? WedgeAffinity.Start : WedgeAffinity.End;
        return CursorAndWedgeAffinity.constructor-impl(arg5, v6);
    }
}

