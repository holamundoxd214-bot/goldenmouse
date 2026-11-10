package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build$VERSION;
import android.view.inputmethod.CursorAnchorInfo$Builder;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u001Ad\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000FH\u0000\u001A,\u0010\u0013\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0002\u001A4\u0010\u0016\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0002\u001A\u001C\u0010\u0019\u001A\u00020\u000F*\u00020\f2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0000¨\u0006\u001D"}, d2={"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "containsInclusive", "x", "", "y", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LegacyCursorAnchorInfoBuilder_androidKt {
    private static final CursorAnchorInfo$Builder addCharacterBounds(CursorAnchorInfo$Builder arg17, int arg18, int arg19, OffsetMapping arg20, TextLayoutResult arg21, Rect arg22) {
        int v0 = arg19;
        OffsetMapping v1 = arg20;
        Rect v3 = arg22;
        int v4 = v1.originalToTransformed(arg18);
        int v5 = v1.originalToTransformed(v0);
        float[] v6 = new float[(v5 - v4) * 4];
        arg21.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(v4, v5), v6, 0);
        int v11;
        for(v11 = arg18; v11 < v0; ++v11) {
            int v2 = v1.originalToTransformed(v11);
            v5 = (v2 - v4) * 4;
            Rect v7 = new Rect(v6[v5], v6[v5 + 1], v6[v5 + 2], v6[v5 + 3]);
            boolean v5_1 = v3.overlaps(v7);
            if(!LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(v3, v7.getLeft(), v7.getTop()) || !LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(v3, v7.getRight(), v7.getBottom())) {
                v5 = (((int)v5_1)) | 2;
            }

            if(arg21.getBidiRunDirection(v2) == ResolvedTextDirection.Rtl) {
                v5 |= 4;
            }

            arg17.addCharacterBounds(v11, v7.getLeft(), v7.getTop(), v7.getRight(), v7.getBottom(), ((boolean)v5));
        }

        return arg17;
    }

    public static final CursorAnchorInfo build(CursorAnchorInfo$Builder arg6, TextFieldValue arg7, OffsetMapping arg8, TextLayoutResult arg9, Matrix arg10, Rect arg11, Rect arg12, boolean arg13, boolean arg14, boolean arg15, boolean arg16) {
        arg6.reset();
        arg6.setMatrix(arg10);
        int v10 = TextRange.getMin-impl(arg7.getSelection-d9O1mEE());
        arg6.setSelectionRange(v10, TextRange.getMax-impl(arg7.getSelection-d9O1mEE()));
        if(arg13) {
            LegacyCursorAnchorInfoBuilder_androidKt.setInsertionMarker(arg6, v10, arg8, arg9, arg11);
        }

        if(arg14) {
            TextRange v10_1 = arg7.getComposition-MzsxiRA();
            int v13 = -1;
            int v1 = v10_1 != null ? TextRange.getMin-impl(v10_1.unbox-impl()) : v13;
            v10_1 = arg7.getComposition-MzsxiRA();
            if(v10_1 != null) {
                v13 = TextRange.getMax-impl(v10_1.unbox-impl());
            }

            int v2 = v13;
            if(v1 < 0) {
                goto label_33;
            }

            if(v1 >= v2) {
                goto label_33;
            }

            arg6.setComposingText(v1, arg7.getText().subSequence(v1, v2));
            LegacyCursorAnchorInfoBuilder_androidKt.addCharacterBounds(arg6, v1, v2, arg8, arg9, arg11);
        }

    label_33:
        if(Build$VERSION.SDK_INT >= 33 && (arg15)) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(arg6, arg12);
        }

        if(Build$VERSION.SDK_INT >= 34 && (arg16)) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(arg6, arg9, arg11);
        }

        return arg6.build();
    }

    public static CursorAnchorInfo build$default(CursorAnchorInfo$Builder arg1, TextFieldValue arg2, OffsetMapping arg3, TextLayoutResult arg4, Matrix arg5, Rect arg6, Rect arg7, boolean arg8, boolean arg9, boolean arg10, boolean arg11, int arg12, Object arg13) {
        return LegacyCursorAnchorInfoBuilder_androidKt.build(arg1, arg2, arg3, arg4, arg5, arg6, arg7, true, true, true, true);
    }

    public static final boolean containsInclusive(Rect arg2, float arg3, float arg4) {
        float v0 = arg2.getLeft();
        if(arg3 <= arg2.getRight() && v0 <= arg3) {
            arg3 = arg2.getTop();
            if(arg4 <= arg2.getBottom() && arg3 <= arg4) {
                return 1;
            }
        }

        return 0;
    }

    private static final CursorAnchorInfo$Builder setInsertionMarker(CursorAnchorInfo$Builder arg9, int arg10, OffsetMapping arg11, TextLayoutResult arg12, Rect arg13) {
        if(arg10 < 0) {
            return arg9;
        }

        arg10 = arg11.originalToTransformed(arg10);
        Rect v11 = arg12.getCursorRect(arg10);
        float v4 = RangesKt.coerceIn(v11.getLeft(), 0f, ((float)(((int)(arg12.getSize-YbymL2g() >> 0x20)))));
        boolean v0 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(arg13, v4, v11.getTop());
        boolean v13 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(arg13, v4, v11.getBottom());
        int v1 = 1;
        arg10 = arg12.getBidiRunDirection(arg10) == ResolvedTextDirection.Rtl ? 1 : 0;
        if(!v0) {
            if(v13) {
            }
            else {
                v1 = 0;
            }
        }

        if(!v0 || !v13) {
            v1 |= 2;
        }

        if(arg10 != 0) {
            v1 |= 4;
        }

        arg9.setInsertionMarkerLocation(v4, v11.getTop(), v11.getBottom(), v11.getBottom(), v1);
        return arg9;
    }
}

