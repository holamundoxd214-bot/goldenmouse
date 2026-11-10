package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build$VERSION;
import android.view.inputmethod.CursorAnchorInfo$Builder;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001Au\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u00102\b\b\u0002\u0010\u0013\u001A\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001A$\u0010\u0016\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0002\u001A,\u0010\u0019\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0002¨\u0006\u001C"}, d2={"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CursorAnchorInfoBuilder_androidKt {
    private static final CursorAnchorInfo$Builder addCharacterBounds(CursorAnchorInfo$Builder arg14, int arg15, int arg16, TextLayoutResult arg17, Rect arg18) {
        int v0 = arg16;
        Rect v1 = arg18;
        float[] v2 = new float[(v0 - arg15) * 4];
        arg17.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(arg15, arg16), v2, 0);
        int v8;
        for(v8 = arg15; v8 < v0; ++v8) {
            int v3 = (v8 - arg15) * 4;
            Rect v4 = new Rect(v2[v3], v2[v3 + 1], v2[v3 + 2], v2[v3 + 3]);
            boolean v3_1 = v1.overlaps(v4);
            if(!LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(v1, v4.getLeft(), v4.getTop()) || !LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(v1, v4.getRight(), v4.getBottom())) {
                v3 = (((int)v3_1)) | 2;
            }

            if(arg17.getBidiRunDirection(v8) == ResolvedTextDirection.Rtl) {
                v3 |= 4;
            }

            arg14.addCharacterBounds(v8, v4.getLeft(), v4.getTop(), v4.getRight(), v4.getBottom(), ((boolean)v3));
        }

        return arg14;
    }

    public static final CursorAnchorInfo build-vxqZcH0(CursorAnchorInfo$Builder arg0, CharSequence arg1, long arg2, TextRange arg4, TextLayoutResult arg5, Matrix arg6, Rect arg7, Rect arg8, boolean arg9, boolean arg10, boolean arg11, boolean arg12) {
        arg0.reset();
        arg0.setMatrix(arg6);
        int v6 = TextRange.getMin-impl(arg2);
        arg0.setSelectionRange(v6, TextRange.getMax-impl(arg2));
        if(arg9) {
            CursorAnchorInfoBuilder_androidKt.setInsertionMarker(arg0, v6, arg5, arg7);
        }

        if(arg10) {
            int v2 = -1;
            int v3 = arg4 != null ? TextRange.getMin-impl(arg4.unbox-impl()) : v2;
            if(arg4 != null) {
                v2 = TextRange.getMax-impl(arg4.unbox-impl());
            }

            if(v3 < 0) {
                goto label_22;
            }

            if(v3 >= v2) {
                goto label_22;
            }

            arg0.setComposingText(v3, arg1.subSequence(v3, v2));
            CursorAnchorInfoBuilder_androidKt.addCharacterBounds(arg0, v3, v2, arg5, arg7);
        }

    label_22:
        if(Build$VERSION.SDK_INT >= 33 && (arg11)) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(arg0, arg8);
        }

        if(Build$VERSION.SDK_INT >= 34 && (arg12)) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(arg0, arg5, arg7);
        }

        return arg0.build();
    }

    public static CursorAnchorInfo build-vxqZcH0$default(CursorAnchorInfo$Builder arg1, CharSequence arg2, long arg3, TextRange arg5, TextLayoutResult arg6, Matrix arg7, Rect arg8, Rect arg9, boolean arg10, boolean arg11, boolean arg12, boolean arg13, int arg14, Object arg15) {
        return CursorAnchorInfoBuilder_androidKt.build-vxqZcH0(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, true, true, true, true);
    }

    private static final CursorAnchorInfo$Builder setInsertionMarker(CursorAnchorInfo$Builder arg10, int arg11, TextLayoutResult arg12, Rect arg13) {
        if(arg11 < 0) {
            return arg10;
        }

        Rect v0 = arg12.getCursorRect(arg11);
        float v5 = RangesKt.coerceIn(v0.getLeft(), 0f, ((float)(((int)(arg12.getSize-YbymL2g() >> 0x20)))));
        boolean v1 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(arg13, v5, v0.getTop());
        boolean v13 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(arg13, v5, v0.getBottom());
        int v2 = 1;
        arg11 = arg12.getBidiRunDirection(arg11) == ResolvedTextDirection.Rtl ? 1 : 0;
        if(!v1) {
            if(v13) {
            }
            else {
                v2 = 0;
            }
        }

        if(!v1 || !v13) {
            v2 |= 2;
        }

        if(arg11 != 0) {
            v2 |= 4;
        }

        arg10.setInsertionMarkerLocation(v5, v0.getTop(), v0.getBottom(), v0.getBottom(), v2);
        return arg10;
    }
}

