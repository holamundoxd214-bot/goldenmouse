package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import kotlin.Metadata;

@Metadata(d1={"\u0000v\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u001A\u001B\u0010\u0003\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001A\f\u0010\t\u001A\u00020\n*\u00020\u0001H\u0002\u001A\f\u0010\u000B\u001A\u00020\n*\u00020\u0001H\u0002\u001A\f\u0010\f\u001A\u00020\n*\u00020\u0001H\u0002\u001A\f\u0010\r\u001A\u00020\n*\u00020\u0001H\u0002\u001A\u0011\u0010\u000E\u001A\u00020\u000F*\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001A+\u0010\u0012\u001A\u00020\u0004*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001A\u0010\u001B\u001A3\u0010\u001C\u001A\u00020\u0004*\u00020\u00132\u0006\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001F\u0010 \u001A+\u0010\u0012\u001A\u00020\u0004*\u00020!2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001A\u0010\"\u001A3\u0010\u001C\u001A\u00020\u0004*\u00020!2\u0006\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001F\u0010#\u001A\u0019\u0010$\u001A\u00020\u0004*\u00020\u00062\u0006\u0010%\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010&\u001A%\u0010\'\u001A\u00020\u0001*\u00020\u00132\u0006\u0010(\u001A\u00020\u000F2\b\u0010)\u001A\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b+\u0010,\u001A#\u0010\'\u001A\u00020\u0001*\u00020!2\u0006\u0010(\u001A\u00020\u000F2\u0006\u0010)\u001A\u00020*H\u0002¢\u0006\u0004\b+\u0010-\u001A\u0014\u0010.\u001A\u00020\n*\u00020/2\u0006\u0010%\u001A\u00020\u0001H\u0002\u001A7\u0010\u0012\u001A\u00020\u0004*\u0004\u0018\u0001002\u0006\u0010\u0014\u001A\u00020\u00152\b\u00101\u001A\u0004\u0018\u0001022\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b3\u00104\u001A/\u0010\'\u001A\u00020\u0001*\u0002002\u0006\u0010(\u001A\u00020\u000F2\b\u00101\u001A\u0004\u0018\u0001022\b\u0010)\u001A\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b5\u00106\u001A9\u00107\u001A\u00020\u0004*\u0004\u0018\u00010/2\u0006\u00108\u001A\u00020\u000F2\u0006\u00109\u001A\u00020\u000F2\b\u00101\u001A\u0004\u0018\u0001022\b\u0010)\u001A\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b:\u0010;\u001A%\u0010<\u001A\u00020\u0001*\u0002002\u0006\u0010=\u001A\u00020\u000F2\b\u0010)\u001A\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b>\u0010?\u001A!\u0010@\u001A\u00020A2\u0012\u0010B\u001A\n\u0012\u0006\b\u0001\u0012\u00020A0C\"\u00020AH\u0002¢\u0006\u0002\u0010D\u001A\u001F\u0010E\u001A\u00020\u00042\u0006\u0010F\u001A\u00020\u00042\u0006\u0010G\u001A\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010I\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, d2={"LINE_FEED_CODE_POINT", "", "NBSP_CODE_POINT", "adjustHandwritingDeleteGestureRange", "Landroidx/compose/ui/text/TextRange;", "text", "", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "isNewline", "", "isWhitespace", "isWhitespaceExceptNewline", "isPunctuation", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "getRangeForScreenRect", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "rangeOfWhitespaces", "offset", "(Ljava/lang/CharSequence;I)J", "getOffsetForHandwritingGesture", "pointInScreen", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "isBiDiBoundary", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/MultiParagraph;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getLineForHandwritingGesture", "localPoint", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "a", "b", "enclosure-pWDy79M", "(JJ)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HandwritingGesture_androidKt {
    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 0xA0;

    public static final long access$adjustHandwritingDeleteGestureRange-72CqOWE(long arg0, CharSequence arg2) {
        return HandwritingGesture_androidKt.adjustHandwritingDeleteGestureRange-72CqOWE(arg0, arg2);
    }

    public static final EditCommand access$compoundEditCommand(EditCommand[] arg0) {
        return HandwritingGesture_androidKt.compoundEditCommand(arg0);
    }

    public static final int access$getOffsetForHandwritingGesture-d-4ec7I(LegacyTextFieldState arg0, long arg1, ViewConfiguration arg3) {
        return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-d-4ec7I(arg0, arg1, arg3);
    }

    public static final int access$getOffsetForHandwritingGesture-d-4ec7I(TextLayoutState arg0, long arg1, ViewConfiguration arg3) {
        return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-d-4ec7I(arg0, arg1, arg3);
    }

    public static final long access$getRangeForRemoveSpaceGesture-5iVPX68(TextLayoutResult arg0, long arg1, long arg3, LayoutCoordinates arg5, ViewConfiguration arg6) {
        return HandwritingGesture_androidKt.getRangeForRemoveSpaceGesture-5iVPX68(arg0, arg1, arg3, arg5, arg6);
    }

    public static final long access$getRangeForScreenRect-OH9lIzo(LegacyTextFieldState arg0, Rect arg1, int arg2, TextInclusionStrategy arg3) {
        return HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg0, arg1, arg2, arg3);
    }

    public static final long access$getRangeForScreenRect-OH9lIzo(TextLayoutState arg0, Rect arg1, int arg2, TextInclusionStrategy arg3) {
        return HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg0, arg1, arg2, arg3);
    }

    public static final long access$getRangeForScreenRects-O048IG0(LegacyTextFieldState arg0, Rect arg1, Rect arg2, int arg3, TextInclusionStrategy arg4) {
        return HandwritingGesture_androidKt.getRangeForScreenRects-O048IG0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final long access$getRangeForScreenRects-O048IG0(TextLayoutState arg0, Rect arg1, Rect arg2, int arg3, TextInclusionStrategy arg4) {
        return HandwritingGesture_androidKt.getRangeForScreenRects-O048IG0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final boolean access$isBiDiBoundary(TextLayoutResult arg0, int arg1) {
        return HandwritingGesture_androidKt.isBiDiBoundary(arg0, arg1);
    }

    public static final long access$rangeOfWhitespaces(CharSequence arg0, int arg1) {
        return HandwritingGesture_androidKt.rangeOfWhitespaces(arg0, arg1);
    }

    public static final long access$toOffset(PointF arg2) {
        return HandwritingGesture_androidKt.toOffset(arg2);
    }

    private static final long adjustHandwritingDeleteGestureRange-72CqOWE(long arg5, CharSequence arg7) {
        int v0 = TextRange.getStart-impl(arg5);
        int v1 = TextRange.getEnd-impl(arg5);
        int v2 = 10;
        int v3 = v0 > 0 ? Character.codePointBefore(arg7, v0) : v2;
        if(v1 < arg7.length()) {
            v2 = Character.codePointAt(arg7, v1);
        }

        if(HandwritingGesture_androidKt.isWhitespaceExceptNewline(v3)) {
            if(!HandwritingGesture_androidKt.isWhitespace(v2)) {
                if(HandwritingGesture_androidKt.isPunctuation(v2)) {
                    goto label_16;
                }

                goto label_24;
            }

            do {
            label_16:
                v0 -= Character.charCount(v3);
                if(v0 == 0) {
                    break;
                }

                v3 = Character.codePointBefore(arg7, v0);
            }
            while(HandwritingGesture_androidKt.isWhitespaceExceptNewline(v3));

            return TextRangeKt.TextRange(v0, v1);
        }

    label_24:
        if(HandwritingGesture_androidKt.isWhitespaceExceptNewline(v2)) {
            if(!HandwritingGesture_androidKt.isWhitespace(v3)) {
                if(HandwritingGesture_androidKt.isPunctuation(v3)) {
                    goto label_30;
                }

                return arg5;
            }

            do {
            label_30:
                v1 += Character.charCount(v2);
                if(v1 == arg7.length()) {
                    break;
                }

                v2 = Character.codePointAt(arg7, v1);
            }
            while(HandwritingGesture_androidKt.isWhitespaceExceptNewline(v2));

            arg5 = TextRangeKt.TextRange(v0, v1);
        }

        return arg5;
    }

    private static final EditCommand compoundEditCommand(EditCommand[] arg1) {
        return new HandwritingGesture_androidKt$compoundEditCommand$1(arg1);
    }

    private static final long enclosure-pWDy79M(long arg1, long arg3) {
        return TextRangeKt.TextRange(Math.min(TextRange.getStart-impl(arg1), TextRange.getStart-impl(arg1)), Math.max(TextRange.getEnd-impl(arg3), TextRange.getEnd-impl(arg3)));
    }

    private static final int getLineForHandwritingGesture-d-4ec7I(MultiParagraph arg4, long arg5, ViewConfiguration arg7) {
        float v7 = arg7 != null ? arg7.getHandwritingGestureLineMargin() : 0f;
        int v0 = ((int)(0xFFFFFFFFL & arg5));
        int v1 = arg4.getLineForVerticalPosition(Float.intBitsToFloat(v0));
        int v3 = -1;
        if(Float.compare(Float.intBitsToFloat(v0), arg4.getLineTop(v1) - v7) >= 0) {
            if(Float.intBitsToFloat(v0) > arg4.getLineBottom(v1) + v7) {
            }
            else {
                int v5 = ((int)(arg5 >> 0x20));
                if(Float.intBitsToFloat(v5) >= -v7) {
                    if(Float.intBitsToFloat(v5) > arg4.getWidth() + v7) {
                    }
                    else {
                        return v1;
                    }
                }
            }
        }

        return v3;
    }

    private static final int getOffsetForHandwritingGesture-d-4ec7I(LegacyTextFieldState arg1, long arg2, ViewConfiguration arg4) {
        TextLayoutResultProxy v0 = arg1.getLayoutResult();
        if(v0 != null) {
            TextLayoutResult v0_1 = v0.getValue();
            if(v0_1 != null) {
                MultiParagraph v0_2 = v0_1.getMultiParagraph();
                if(v0_2 != null) {
                    return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-ubNVwUQ(v0_2, arg2, arg1.getLayoutCoordinates(), arg4);
                }
            }
        }

        return -1;
    }

    private static final int getOffsetForHandwritingGesture-d-4ec7I(TextLayoutState arg1, long arg2, ViewConfiguration arg4) {
        TextLayoutResult v0 = arg1.getLayoutResult();
        if(v0 != null) {
            MultiParagraph v0_1 = v0.getMultiParagraph();
            if(v0_1 != null) {
                return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-ubNVwUQ(v0_1, arg2, arg1.getTextLayoutNodeCoordinates(), arg4);
            }
        }

        return -1;
    }

    private static final int getOffsetForHandwritingGesture-ubNVwUQ(MultiParagraph arg7, long arg8, LayoutCoordinates arg10, ViewConfiguration arg11) {
        int v0 = -1;
        if(arg10 != null) {
            long v1 = arg10.screenToLocal-MK-Hz9U(arg8);
            int v8 = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I(arg7, v1, arg11);
            if(v8 == v0) {
                return v0;
            }

            return arg7.getOffsetForPosition-k-4lQ0M(Offset.copy-dBAh8RU$default(v1, 0f, (arg7.getLineTop(v8) + arg7.getLineBottom(v8)) / 2f, 1, null));
        }

        return v0;
    }

    private static final long getRangeForRemoveSpaceGesture-5iVPX68(TextLayoutResult arg1, long arg2, long arg4, LayoutCoordinates arg6, ViewConfiguration arg7) {
        if(arg1 != null) {
            if(arg6 == null) {
            }
            else {
                arg2 = arg6.screenToLocal-MK-Hz9U(arg2);
                arg4 = arg6.screenToLocal-MK-Hz9U(arg4);
                int v6 = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I(arg1.getMultiParagraph(), arg2, arg7);
                int v7 = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I(arg1.getMultiParagraph(), arg4, arg7);
                int v0 = -1;
                if(v6 != v0) {
                    if(v7 == v0) {
                    }
                    else {
                        v6 = Math.min(v6, v7);
                    }

                    v7 = v6;
                }
                else if(v7 == v0) {
                    return TextRange.Companion.getZero-d9O1mEE();
                }

                float v6_1 = (arg1.getLineTop(v7) + arg1.getLineBottom(v7)) / 2f;
                int v2 = ((int)(arg2 >> 0x20));
                int v4 = ((int)(arg4 >> 0x20));
                return arg1.getMultiParagraph().getRangeForRect-8-6BmAI(new Rect(Math.min(Float.intBitsToFloat(v2), Float.intBitsToFloat(v4)), v6_1 - 0.1f, Math.max(Float.intBitsToFloat(v2), Float.intBitsToFloat(v4)), v6_1 + 0.1f), TextGranularity.Companion.getCharacter-DRrd7Zo(), TextInclusionStrategy.Companion.getAnyOverlap());
            }
        }

        return TextRange.Companion.getZero-d9O1mEE();
    }

    private static final long getRangeForScreenRect-O048IG0(MultiParagraph arg2, Rect arg3, LayoutCoordinates arg4, int arg5, TextInclusionStrategy arg6) {
        if(arg2 != null) {
            if(arg4 == null) {
            }
            else {
                return arg2.getRangeForRect-8-6BmAI(arg3.translate-k-4lQ0M(arg4.screenToLocal-MK-Hz9U(Offset.Companion.getZero-F1C5BW0())), arg5, arg6);
            }
        }

        return TextRange.Companion.getZero-d9O1mEE();
    }

    private static final long getRangeForScreenRect-OH9lIzo(LegacyTextFieldState arg1, Rect arg2, int arg3, TextInclusionStrategy arg4) {
        MultiParagraph v0_2;
        TextLayoutResultProxy v0 = arg1.getLayoutResult();
        if(v0 != null) {
            TextLayoutResult v0_1 = v0.getValue();
            if(v0_1 != null) {
                v0_2 = v0_1.getMultiParagraph();
            }
            else {
                goto label_6;
            }
        }
        else {
        label_6:
            v0_2 = null;
        }

        return HandwritingGesture_androidKt.getRangeForScreenRect-O048IG0(v0_2, arg2, arg1.getLayoutCoordinates(), arg3, arg4);
    }

    private static final long getRangeForScreenRect-OH9lIzo(TextLayoutState arg1, Rect arg2, int arg3, TextInclusionStrategy arg4) {
        TextLayoutResult v0 = arg1.getLayoutResult();
        MultiParagraph v0_1 = v0 != null ? v0.getMultiParagraph() : null;
        return HandwritingGesture_androidKt.getRangeForScreenRect-O048IG0(v0_1, arg2, arg1.getTextLayoutNodeCoordinates(), arg3, arg4);
    }

    private static final long getRangeForScreenRects-O048IG0(LegacyTextFieldState arg2, Rect arg3, Rect arg4, int arg5, TextInclusionStrategy arg6) {
        long v0 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg2, arg3, arg5, arg6);
        if(TextRange.getCollapsed-impl(v0)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        long v2 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg2, arg4, arg5, arg6);
        if(TextRange.getCollapsed-impl(v2)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        return HandwritingGesture_androidKt.enclosure-pWDy79M(v0, v2);
    }

    private static final long getRangeForScreenRects-O048IG0(TextLayoutState arg2, Rect arg3, Rect arg4, int arg5, TextInclusionStrategy arg6) {
        long v0 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg2, arg3, arg5, arg6);
        if(TextRange.getCollapsed-impl(v0)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        long v2 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo(arg2, arg4, arg5, arg6);
        if(TextRange.getCollapsed-impl(v2)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        return HandwritingGesture_androidKt.enclosure-pWDy79M(v0, v2);
    }

    private static final boolean isBiDiBoundary(TextLayoutResult arg5, int arg6) {
        int v0 = arg5.getLineForOffset(arg6);
        if(arg6 != arg5.getLineStart(v0)) {
            if(arg6 == TextLayoutResult.getLineEnd$default(arg5, v0, false, 2, null)) {
            }
            else if(arg5.getBidiRunDirection(arg6) != arg5.getBidiRunDirection(arg6 - 1)) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(arg5.getParagraphDirection(arg6) != arg5.getBidiRunDirection(arg6)) {
            return 1;
        }

        return 0;
    }

    private static final boolean isNewline(int arg2) {
        int v0 = Character.getType(arg2);
        if(v0 != 14 && v0 != 13) {
            if(arg2 == 10) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isPunctuation(int arg1) {
        arg1 = Character.getType(arg1);
        if(arg1 != 23 && arg1 != 20 && arg1 != 22 && arg1 != 30 && arg1 != 29 && arg1 != 24) {
            if(arg1 == 21) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isWhitespace(int arg1) {
        if(!Character.isWhitespace(arg1)) {
            if(arg1 == 0xA0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isWhitespaceExceptNewline(int arg1) {
        if((HandwritingGesture_androidKt.isWhitespace(arg1)) && !HandwritingGesture_androidKt.isNewline(arg1)) {
            return 1;
        }

        return 0;
    }

    private static final long rangeOfWhitespaces(CharSequence arg3, int arg4) {
        int v1;
        int v0 = arg4;
        while(v0 > 0) {
            v1 = CodepointHelpers_jvmKt.codePointBefore(arg3, v0);
            if(!HandwritingGesture_androidKt.isWhitespace(v1)) {
            }
            else {
                v0 -= Character.charCount(v1);
                continue;
            }

            break;
        }

        while(arg4 < arg3.length()) {
            v1 = CodepointHelpers_jvmKt.codePointAt(arg3, arg4);
            if(!HandwritingGesture_androidKt.isWhitespace(v1)) {
            }
            else {
                arg4 += CodepointHelpers_jvmKt.charCount(v1);
                continue;
            }

            break;
        }

        return TextRangeKt.TextRange(v0, arg4);
    }

    private static final long toOffset(PointF arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.x))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.y))) & 0xFFFFFFFFL);
    }
}

