package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001Ao\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001A%\u0010\u001A\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0000¢\u0006\u0004\b\u001F\u0010 \u001A\u0014\u0010!\u001A\u00020\"*\u00020\u00022\u0006\u0010#\u001A\u00020\fH\u0000¨\u0006$"}, d2={"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Z", "isPositionInsideSelection", "position", "Landroidx/compose/ui/geometry/Offset;", "selectionRange", "Landroidx/compose/ui/text/TextRange;", "isPositionInsideSelection-uaM50fQ", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/text/TextRange;)Z", "getLineHeight", "", "offset", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLayoutHelperKt {
    public static final boolean canReuse-7_7YC6M(TextLayoutResult arg2, AnnotatedString arg3, TextStyle arg4, List arg5, int arg6, boolean arg7, int arg8, Density arg9, LayoutDirection arg10, Resolver arg11, long arg12) {
        TextLayoutInput v0 = arg2.getLayoutInput();
        if(arg2.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return 0;
        }

        if((Intrinsics.areEqual(v0.getText(), arg3)) && (v0.getStyle().hasSameLayoutAffectingAttributes(arg4)) && (Intrinsics.areEqual(v0.getPlaceholders(), arg5)) && v0.getMaxLines() == arg6 && v0.getSoftWrap() == arg7 && (TextOverflow.equals-impl0(v0.getOverflow-gIe3tQ8(), arg8)) && (Intrinsics.areEqual(v0.getDensity(), arg9)) && v0.getLayoutDirection() == arg10) {
            if(!Intrinsics.areEqual(v0.getFontFamilyResolver(), arg11)) {
            }
            else if(Constraints.getMinWidth-impl(arg12) != Constraints.getMinWidth-impl(v0.getConstraints-msEJaDk())) {
                return 0;
            }
            else {
                if(!arg7 && !TextOverflow.equals-impl0(arg8, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                    return 1;
                }

                if(Constraints.getMaxWidth-impl(arg12) != Constraints.getMaxWidth-impl(v0.getConstraints-msEJaDk())) {
                    return 0;
                }

                if(Constraints.getMaxHeight-impl(arg12) != Constraints.getMaxHeight-impl(v0.getConstraints-msEJaDk())) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public static final float getLineHeight(TextLayoutResult arg6, int arg7) {
        if(arg7 >= 0) {
            if(arg6.getLayoutInput().getText().length() == 0) {
            }
            else {
                int v1 = Math.min(arg6.getMultiParagraph().getLineForOffset(arg7), Math.min(arg6.getMultiParagraph().getMaxLines() - 1, arg6.getMultiParagraph().getLineCount() - 1));
                if(arg7 > MultiParagraph.getLineEnd$default(arg6.getMultiParagraph(), v1, false, 2, null)) {
                    return 0;
                }
                else {
                    return arg6.getMultiParagraph().getLineHeight(v1);
                }
            }
        }

        return 0;
    }

    public static final boolean isPositionInsideSelection-uaM50fQ(TextLayoutResult arg4, long arg5, TextRange arg7) {
        if(arg7 != null) {
            if(TextRange.getCollapsed-impl(arg7.unbox-impl())) {
            }
            else {
                int v1 = arg4.getOffsetForPosition-k-4lQ0M(arg5);
                if(!TextLayoutHelperKt.isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(arg7, arg4, arg5, v1)) {
                    if(TextLayoutHelperKt.isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(arg7, arg4, arg5, v1 - 1)) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    private static final boolean isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(TextRange arg2, TextLayoutResult arg3, long arg4, int arg6) {
        if((TextRange.contains-impl(arg2.unbox-impl(), arg6)) && (arg3.getBoundingBox(arg6).contains-k-4lQ0M(arg4))) {
            return 1;
        }

        return 0;
    }
}

