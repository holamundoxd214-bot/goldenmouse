package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A/\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldMagnifierKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Handle.values().length];
            try {
                v0[Handle.Cursor.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Handle.SelectionStart.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Handle.SelectionEnd.ordinal()] = 3;
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

    public static final long calculateSelectionMagnifierCenterAndroid-hUlJWOE(TransformedTextFieldState arg7, TextFieldSelectionState arg8, TextLayoutState arg9, long arg10) {
        long v0 = arg8.getHandleDragPosition-F1C5BW0();
        if((0x7FFFFFFF7FFFFFFFL & v0) == 0x7FC000007FC00000L) {
        }
        else {
            if(arg7.getVisualText().length() == 0) {
                goto label_9;
            }

            goto label_12;
        }

    label_9:
        return Offset.Companion.getUnspecified-F1C5BW0();
    label_12:
        long v2 = arg7.getVisualText().getSelection-d9O1mEE();
        Handle v7 = arg8.getDraggingHandle();
        int v8 = -1;
        int v7_1 = v7 == null ? v8 : WhenMappings.$EnumSwitchMapping$0[v7.ordinal()];
        if(v7_1 != v8) {
            int v4 = 2;
            if(v7_1 == 1 || v7_1 == v4) {
                v7_1 = TextRange.getStart-impl(v2);
            }
            else if(v7_1 == 3) {
                v7_1 = TextRange.getEnd-impl(v2);
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            TextLayoutResult v8_1 = arg9.getLayoutResult();
            if(v8_1 == null) {
                return Offset.Companion.getUnspecified-F1C5BW0();
            }

            int v2_1 = 0x20;
            float v0_1 = Float.intBitsToFloat(((int)(v0 >> v2_1)));
            v7_1 = v8_1.getLineForOffset(v7_1);
            float v1 = v8_1.getLineLeft(v7_1);
            float v3 = v8_1.getLineRight(v7_1);
            v1 = RangesKt.coerceIn(v0_1, Math.min(v1, v3), Math.max(v1, v3));
            if(!IntSize.equals-impl0(arg10, IntSize.Companion.getZero-YbymL2g()) && Math.abs(v0_1 - v1) > (((float)((((int)(arg10 >> v2_1))) / v4)))) {
                return Offset.Companion.getUnspecified-F1C5BW0();
            }

            float v10 = v8_1.getLineTop(v7_1);
            long v7_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits((v8_1.getLineBottom(v7_1) - v10) / 2f + v10))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v1))) << v2_1);
            LayoutCoordinates v10_1 = arg9.getTextLayoutNodeCoordinates();
            if(v10_1 != null) {
                if(v10_1.isAttached()) {
                }
                else {
                    v10_1 = null;
                }

                if(v10_1 == null) {
                    goto label_88;
                }

                v7_2 = TextLayoutStateKt.coerceIn-3MmeM6k(v7_2, SelectionManagerKt.visibleBounds(v10_1));
            }

        label_88:
            return TextLayoutStateKt.fromTextLayoutToCore-Uv8p0NA(arg9, v7_2);
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }
}

