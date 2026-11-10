package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u001B\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0003\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0006\u0010\u0017\u001A\u00020\u0003\u0012\u0006\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\u0003\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u0003\u0012\u0006\u0010\u001C\u001A\u00020\u0003\u0012\u0006\u0010\u001D\u001A\u00020\u0003\u0012\u0006\u0010\u001E\u001A\u00020\u0003\u0012\u0006\u0010\u001F\u001A\u00020\u0003\u0012\u0006\u0010 \u001A\u00020\u0003\u0012\u0006\u0010!\u001A\u00020\u0003\u0012\u0006\u0010\"\u001A\u00020\u0003\u0012\u0006\u0010#\u001A\u00020\u0003\u0012\u0006\u0010$\u001A\u00020\u0003\u0012\u0006\u0010%\u001A\u00020\u0003\u0012\u0006\u0010&\u001A\u00020\u0003\u0012\u0006\u0010\'\u001A\u00020\u0003\u0012\u0006\u0010(\u001A\u00020\u0003\u0012\u0006\u0010)\u001A\u00020\u0003\u0012\u0006\u0010*\u001A\u00020\u0003\u0012\u0006\u0010+\u001A\u00020\u0003\u0012\u0006\u0010,\u001A\u00020\u0003\u0012\u0006\u0010-\u001A\u00020\u0003\u0012\u0006\u0010.\u001A\u00020\u0003¢\u0006\u0004\b/\u00100J½\u0003\u0010_\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u00032\b\b\u0002\u0010\'\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\u00032\b\b\u0002\u0010)\u001A\u00020\u00032\b\b\u0002\u0010*\u001A\u00020\u00032\b\b\u0002\u0010+\u001A\u00020\u00032\b\b\u0002\u0010,\u001A\u00020\u00032\b\b\u0002\u0010-\u001A\u00020\u00032\b\b\u0002\u0010.\u001A\u00020\u0003¢\u0006\u0004\b`\u0010aJ!\u0010b\u001A\u00020\u000E*\u0004\u0018\u00010\u000E2\f\u0010c\u001A\b\u0012\u0004\u0012\u00020\u000E0dH\u0000¢\u0006\u0002\beJ\'\u0010f\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bk\u0010lJ\'\u0010m\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bn\u0010lJ\'\u0010o\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bp\u0010lJ\'\u0010q\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\br\u0010lJ\'\u0010s\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bt\u0010lJ\'\u0010u\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bv\u0010lJ\'\u0010w\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bx\u0010lJ\'\u0010y\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\bz\u0010lJ\'\u0010{\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\b|\u0010lJ\'\u0010}\u001A\u00020\u00032\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020h2\u0006\u0010j\u001A\u00020hH\u0001¢\u0006\u0004\b~\u0010lJ\u0018\u0010\u000B\u001A\u00020\u00032\u0006\u0010i\u001A\u00020hH\u0001¢\u0006\u0005\b\u007F\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001A\u00020h2\t\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\n\u0010\u0083\u0001\u001A\u00030\u0084\u0001H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b1\u00102R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b4\u00102R\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b5\u00102R\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b6\u00102R\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b7\u00102R\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b8\u00102R\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b9\u00102R\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b:\u00102R\u0013\u0010\u000B\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b;\u00102R\u0013\u0010\f\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b<\u00102R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b=\u0010>R\u0013\u0010\u000F\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b?\u00102R\u0013\u0010\u0010\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b@\u00102R\u0013\u0010\u0011\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bA\u00102R\u0013\u0010\u0012\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bB\u00102R\u0013\u0010\u0013\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bC\u00102R\u0013\u0010\u0014\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bD\u00102R\u0013\u0010\u0015\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bE\u00102R\u0013\u0010\u0016\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bF\u00102R\u0013\u0010\u0017\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bG\u00102R\u0013\u0010\u0018\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bH\u00102R\u0013\u0010\u0019\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bI\u00102R\u0013\u0010\u001A\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bJ\u00102R\u0013\u0010\u001B\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bK\u00102R\u0013\u0010\u001C\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bL\u00102R\u0013\u0010\u001D\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bM\u00102R\u0013\u0010\u001E\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bN\u00102R\u0013\u0010\u001F\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bO\u00102R\u0013\u0010 \u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bP\u00102R\u0013\u0010!\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bQ\u00102R\u0013\u0010\"\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bR\u00102R\u0013\u0010#\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bS\u00102R\u0013\u0010$\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bT\u00102R\u0013\u0010%\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bU\u00102R\u0013\u0010&\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bV\u00102R\u0013\u0010\'\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bW\u00102R\u0013\u0010(\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bX\u00102R\u0013\u0010)\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bY\u00102R\u0013\u0010*\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\bZ\u00102R\u0013\u0010+\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b[\u00102R\u0013\u0010,\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b\\\u00102R\u0013\u0010-\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b]\u00102R\u0013\u0010.\u001A\u00020\u0003¢\u0006\n\n\u0002\u00103\u001A\u0004\b^\u00102¨\u0006\u0085\u0001"}, d2={"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "<init>", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFocusedTextColor-0d7_KjU", "()J", "J", "getUnfocusedTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getUnfocusedContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getCursorColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getFocusedIndicatorColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "leadingIconColor", "enabled", "", "isError", "focused", "leadingIconColor-XeAY9LY$material3", "(ZZZ)J", "trailingIconColor", "trailingIconColor-XeAY9LY$material3", "indicatorColor", "indicatorColor-XeAY9LY$material3", "containerColor", "containerColor-XeAY9LY$material3", "placeholderColor", "placeholderColor-XeAY9LY$material3", "labelColor", "labelColor-XeAY9LY$material3", "textColor", "textColor-XeAY9LY$material3", "supportingTextColor", "supportingTextColor-XeAY9LY$material3", "prefixColor", "prefixColor-XeAY9LY$material3", "suffixColor", "suffixColor-XeAY9LY$material3", "cursorColor-vNxB06k$material3", "(Z)J", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldColors {
    public static final int $stable;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    static {
    }

    public TextFieldColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, TextSelectionColors arg21, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, long arg78, long arg80, long arg82, long arg84, DefaultConstructorMarker arg86) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg22, arg24, arg26, arg28, arg30, arg32, arg34, arg36, arg38, arg40, arg42, arg44, arg46, arg48, arg50, arg52, arg54, arg56, arg58, arg60, arg62, arg64, arg66, arg68, arg70, arg72, arg74, arg76, arg78, arg80, arg82, arg84);
    }

    private TextFieldColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, TextSelectionColors arg21, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, long arg78, long arg80, long arg82, long arg84) {
        super();
        this.focusedTextColor = arg1;
        this.unfocusedTextColor = arg3;
        this.disabledTextColor = arg5;
        this.errorTextColor = arg7;
        this.focusedContainerColor = arg9;
        this.unfocusedContainerColor = arg11;
        this.disabledContainerColor = arg13;
        this.errorContainerColor = arg15;
        this.cursorColor = arg17;
        this.errorCursorColor = arg19;
        this.textSelectionColors = arg21;
        this.focusedIndicatorColor = arg22;
        this.unfocusedIndicatorColor = arg24;
        this.disabledIndicatorColor = arg26;
        this.errorIndicatorColor = arg28;
        this.focusedLeadingIconColor = arg30;
        this.unfocusedLeadingIconColor = arg32;
        this.disabledLeadingIconColor = arg34;
        this.errorLeadingIconColor = arg36;
        this.focusedTrailingIconColor = arg38;
        this.unfocusedTrailingIconColor = arg40;
        this.disabledTrailingIconColor = arg42;
        this.errorTrailingIconColor = arg44;
        this.focusedLabelColor = arg46;
        this.unfocusedLabelColor = arg48;
        this.disabledLabelColor = arg50;
        this.errorLabelColor = arg52;
        this.focusedPlaceholderColor = arg54;
        this.unfocusedPlaceholderColor = arg56;
        this.disabledPlaceholderColor = arg58;
        this.errorPlaceholderColor = arg60;
        this.focusedSupportingTextColor = arg62;
        this.unfocusedSupportingTextColor = arg64;
        this.disabledSupportingTextColor = arg66;
        this.errorSupportingTextColor = arg68;
        this.focusedPrefixColor = arg70;
        this.unfocusedPrefixColor = arg72;
        this.disabledPrefixColor = arg74;
        this.errorPrefixColor = arg76;
        this.focusedSuffixColor = arg78;
        this.unfocusedSuffixColor = arg80;
        this.disabledSuffixColor = arg82;
        this.errorSuffixColor = arg84;
    }

    public final long containerColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledContainerColor;
        }

        if(arg2) {
            return this.errorContainerColor;
        }

        if(arg3) {
            return this.focusedContainerColor;
        }

        return this.unfocusedContainerColor;
    }

    public final TextFieldColors copy-ejIjP34(long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, TextSelectionColors arg113, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170, long arg172, long arg174, long arg176) {
        TextFieldColors v0 = this;
        long v1 = 16;
        long v6 = arg93 != v1 ? arg93 : v0.focusedTextColor;
        long v8 = arg95 != v1 ? arg95 : v0.unfocusedTextColor;
        long v10 = arg97 != v1 ? arg97 : v0.disabledTextColor;
        long v12 = arg99 != v1 ? arg99 : v0.errorTextColor;
        long v14 = arg101 != v1 ? arg101 : v0.focusedContainerColor;
        long v16 = arg103 != v1 ? arg103 : v0.unfocusedContainerColor;
        long v18 = arg105 != v1 ? arg105 : v0.disabledContainerColor;
        long v20 = arg107 != v1 ? arg107 : v0.errorContainerColor;
        long v22 = arg109 != v1 ? arg109 : v0.cursorColor;
        long v24 = arg111 != v1 ? arg111 : v0.errorCursorColor;
        TextSelectionColors v26 = v0.takeOrElse$material3(arg113, new TextFieldColors$$ExternalSyntheticLambda0(v0));
        long v27 = arg114 != v1 ? arg114 : v0.focusedIndicatorColor;
        long v29 = arg116 != v1 ? arg116 : v0.unfocusedIndicatorColor;
        long v31 = arg118 != v1 ? arg118 : v0.disabledIndicatorColor;
        long v33 = arg120 != v1 ? arg120 : v0.errorIndicatorColor;
        long v35 = arg122 != v1 ? arg122 : v0.focusedLeadingIconColor;
        long v37 = arg124 != v1 ? arg124 : v0.unfocusedLeadingIconColor;
        long v39 = arg126 != v1 ? arg126 : v0.disabledLeadingIconColor;
        long v41 = arg128 != v1 ? arg128 : v0.errorLeadingIconColor;
        long v43 = arg130 != v1 ? arg130 : v0.focusedTrailingIconColor;
        long v45 = arg132 != v1 ? arg132 : v0.unfocusedTrailingIconColor;
        long v47 = arg134 != v1 ? arg134 : v0.disabledTrailingIconColor;
        long v49 = arg136 != v1 ? arg136 : v0.errorTrailingIconColor;
        long v51 = arg138 != v1 ? arg138 : v0.focusedLabelColor;
        long v53 = arg140 != v1 ? arg140 : v0.unfocusedLabelColor;
        long v55 = arg142 != v1 ? arg142 : v0.disabledLabelColor;
        long v57 = arg144 != v1 ? arg144 : v0.errorLabelColor;
        long v59 = arg146 != v1 ? arg146 : v0.focusedPlaceholderColor;
        long v61 = arg148 != v1 ? arg148 : v0.unfocusedPlaceholderColor;
        long v63 = arg150 != v1 ? arg150 : v0.disabledPlaceholderColor;
        long v65 = arg152 != v1 ? arg152 : v0.errorPlaceholderColor;
        long v67 = arg154 != v1 ? arg154 : v0.focusedSupportingTextColor;
        long v69 = arg156 != v1 ? arg156 : v0.unfocusedSupportingTextColor;
        long v71 = arg158 != v1 ? arg158 : v0.disabledSupportingTextColor;
        long v73 = arg160 != v1 ? arg160 : v0.errorSupportingTextColor;
        long v75 = arg162 != v1 ? arg162 : v0.focusedPrefixColor;
        long v77 = arg164 != v1 ? arg164 : v0.unfocusedPrefixColor;
        long v79 = arg166 != v1 ? arg166 : v0.disabledPrefixColor;
        long v81 = arg168 != v1 ? arg168 : v0.errorPrefixColor;
        long v83 = arg170 != v1 ? arg170 : v0.focusedSuffixColor;
        long v85 = arg172 != v1 ? arg172 : v0.unfocusedSuffixColor;
        long v87 = arg174 != v1 ? arg174 : v0.disabledSuffixColor;
        long v89 = arg176 != v1 ? arg176 : v0.errorSuffixColor;
        return new TextFieldColors(v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, v81, v83, v85, v87, v89, null);
    }

    public static TextFieldColors copy-ejIjP34$default(TextFieldColors arg18, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, TextSelectionColors arg39, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, long arg78, long arg80, long arg82, long arg84, long arg86, long arg88, long arg90, long arg92, long arg94, long arg96, long arg98, long arg100, long arg102, int arg104, int arg105, Object arg106) {
        long v15;
        TextFieldColors v0 = arg18;
        int v1 = arg104;
        int v2 = arg105;
        long v3 = (v1 & 1) != 0 ? v0.focusedTextColor : arg19;
        long v5 = (v1 & 2) != 0 ? v0.unfocusedTextColor : arg21;
        long v7 = (v1 & 4) != 0 ? v0.disabledTextColor : arg23;
        long v9 = (v1 & 8) != 0 ? v0.errorTextColor : arg25;
        long v11 = (v1 & 16) != 0 ? v0.focusedContainerColor : arg27;
        long v13 = (v1 & 0x20) != 0 ? v0.unfocusedContainerColor : arg29;
        if((v1 & 0x40) != 0) {
            v15 = v3;
            v3 = v0.disabledContainerColor;
        }
        else {
            v15 = v3;
            v3 = arg31;
        }

        arg19 = v3;
        v3 = (v1 & 0x80) != 0 ? v0.errorContainerColor : arg33;
        arg21 = v3;
        v3 = (v1 & 0x100) != 0 ? v0.cursorColor : arg35;
        arg23 = v3;
        v3 = (v1 & 0x200) != 0 ? v0.errorCursorColor : arg37;
        arg25 = v3;
        TextSelectionColors v3_1 = (v1 & 0x400) != 0 ? v0.textSelectionColors : arg39;
        TextSelectionColors v27 = v3_1;
        v3 = (v1 & 0x800) != 0 ? v0.focusedIndicatorColor : arg40;
        long v28 = v3;
        v3 = (v1 & 0x1000) != 0 ? v0.unfocusedIndicatorColor : arg42;
        long v30 = v3;
        v3 = (v1 & 0x2000) != 0 ? v0.disabledIndicatorColor : arg44;
        long v32 = v3;
        v3 = (v1 & 0x4000) != 0 ? v0.errorIndicatorColor : arg46;
        long v34 = v3;
        v3 = (v1 & 0x8000) != 0 ? v0.focusedLeadingIconColor : arg48;
        long v36 = v3;
        v3 = (v1 & 0x10000) != 0 ? v0.unfocusedLeadingIconColor : arg50;
        long v38 = v3;
        v3 = (v1 & 0x20000) != 0 ? v0.disabledLeadingIconColor : arg52;
        arg40 = v3;
        v3 = (v1 & 0x40000) != 0 ? v0.errorLeadingIconColor : arg54;
        arg42 = v3;
        v3 = (v1 & 0x80000) != 0 ? v0.focusedTrailingIconColor : arg56;
        arg44 = v3;
        v3 = (v1 & 0x100000) != 0 ? v0.unfocusedTrailingIconColor : arg58;
        arg46 = v3;
        v3 = (v1 & 0x200000) != 0 ? v0.disabledTrailingIconColor : arg60;
        arg48 = v3;
        v3 = (v1 & 0x400000) != 0 ? v0.errorTrailingIconColor : arg62;
        arg50 = v3;
        v3 = (v1 & 0x800000) != 0 ? v0.focusedLabelColor : arg64;
        arg52 = v3;
        v3 = (v1 & 0x1000000) != 0 ? v0.unfocusedLabelColor : arg66;
        arg54 = v3;
        v3 = (v1 & 0x2000000) != 0 ? v0.disabledLabelColor : arg68;
        arg56 = v3;
        v3 = (v1 & 0x4000000) != 0 ? v0.errorLabelColor : arg70;
        arg58 = v3;
        v3 = (v1 & 0x8000000) != 0 ? v0.focusedPlaceholderColor : arg72;
        arg60 = v3;
        v3 = (v1 & 0x10000000) != 0 ? v0.unfocusedPlaceholderColor : arg74;
        arg62 = v3;
        v3 = (v1 & 0x20000000) != 0 ? v0.disabledPlaceholderColor : arg76;
        arg64 = v3;
        v3 = (v1 & 0x40000000) != 0 ? v0.errorPlaceholderColor : arg78;
        arg66 = v3;
        v3 = (v1 & 0x80000000) != 0 ? v0.focusedSupportingTextColor : arg80;
        arg68 = v3;
        v3 = (v2 & 1) != 0 ? v0.unfocusedSupportingTextColor : arg82;
        arg70 = v3;
        v3 = (v2 & 2) != 0 ? v0.disabledSupportingTextColor : arg84;
        arg72 = v3;
        v3 = (v2 & 4) != 0 ? v0.errorSupportingTextColor : arg86;
        arg74 = v3;
        v3 = (v2 & 8) != 0 ? v0.focusedPrefixColor : arg88;
        arg76 = v3;
        v3 = (v2 & 16) != 0 ? v0.unfocusedPrefixColor : arg90;
        arg78 = v3;
        v3 = (v2 & 0x20) != 0 ? v0.disabledPrefixColor : arg92;
        arg80 = v3;
        v3 = (v2 & 0x40) != 0 ? v0.errorPrefixColor : arg94;
        arg82 = v3;
        v3 = (v2 & 0x80) != 0 ? v0.focusedSuffixColor : arg96;
        arg84 = v3;
        v3 = (v2 & 0x100) != 0 ? v0.unfocusedSuffixColor : arg98;
        arg86 = v3;
        v3 = (v2 & 0x200) != 0 ? v0.disabledSuffixColor : arg100;
        long v103 = (v2 & 0x400) != 0 ? v0.errorSuffixColor : arg102;
        return v0.copy-ejIjP34(v15, v5, v7, v9, v11, v13, arg19, arg21, arg23, arg25, v27, v28, v30, v32, v34, v36, v38, arg40, arg42, arg44, arg46, arg48, arg50, arg52, arg54, arg56, arg58, arg60, arg62, arg64, arg66, arg68, arg70, arg72, arg74, arg76, arg78, arg80, arg82, arg84, arg86, v3, v103);
    }

    static final TextSelectionColors copy_ejIjP34$lambda$10(TextFieldColors arg0) {
        return arg0.textSelectionColors;
    }

    public final long cursorColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.errorCursorColor;
        }

        return this.cursorColor;
    }

    public boolean equals(Object arg7) {
        if(this == (((TextFieldColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof TextFieldColors)) {
            }
            else if(!Color.equals-impl0(this.focusedTextColor, ((TextFieldColors)arg7).focusedTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedTextColor, ((TextFieldColors)arg7).unfocusedTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTextColor, ((TextFieldColors)arg7).disabledTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorTextColor, ((TextFieldColors)arg7).errorTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedContainerColor, ((TextFieldColors)arg7).focusedContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedContainerColor, ((TextFieldColors)arg7).unfocusedContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledContainerColor, ((TextFieldColors)arg7).disabledContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorContainerColor, ((TextFieldColors)arg7).errorContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.cursorColor, ((TextFieldColors)arg7).cursorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorCursorColor, ((TextFieldColors)arg7).errorCursorColor)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.textSelectionColors, ((TextFieldColors)arg7).textSelectionColors)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedIndicatorColor, ((TextFieldColors)arg7).focusedIndicatorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedIndicatorColor, ((TextFieldColors)arg7).unfocusedIndicatorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledIndicatorColor, ((TextFieldColors)arg7).disabledIndicatorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorIndicatorColor, ((TextFieldColors)arg7).errorIndicatorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedLeadingIconColor, ((TextFieldColors)arg7).focusedLeadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedLeadingIconColor, ((TextFieldColors)arg7).unfocusedLeadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledLeadingIconColor, ((TextFieldColors)arg7).disabledLeadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorLeadingIconColor, ((TextFieldColors)arg7).errorLeadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedTrailingIconColor, ((TextFieldColors)arg7).focusedTrailingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedTrailingIconColor, ((TextFieldColors)arg7).unfocusedTrailingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTrailingIconColor, ((TextFieldColors)arg7).disabledTrailingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorTrailingIconColor, ((TextFieldColors)arg7).errorTrailingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedLabelColor, ((TextFieldColors)arg7).focusedLabelColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedLabelColor, ((TextFieldColors)arg7).unfocusedLabelColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledLabelColor, ((TextFieldColors)arg7).disabledLabelColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorLabelColor, ((TextFieldColors)arg7).errorLabelColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedPlaceholderColor, ((TextFieldColors)arg7).focusedPlaceholderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedPlaceholderColor, ((TextFieldColors)arg7).unfocusedPlaceholderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledPlaceholderColor, ((TextFieldColors)arg7).disabledPlaceholderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorPlaceholderColor, ((TextFieldColors)arg7).errorPlaceholderColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedSupportingTextColor, ((TextFieldColors)arg7).focusedSupportingTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedSupportingTextColor, ((TextFieldColors)arg7).unfocusedSupportingTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledSupportingTextColor, ((TextFieldColors)arg7).disabledSupportingTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorSupportingTextColor, ((TextFieldColors)arg7).errorSupportingTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedPrefixColor, ((TextFieldColors)arg7).focusedPrefixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedPrefixColor, ((TextFieldColors)arg7).unfocusedPrefixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledPrefixColor, ((TextFieldColors)arg7).disabledPrefixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorPrefixColor, ((TextFieldColors)arg7).errorPrefixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.focusedSuffixColor, ((TextFieldColors)arg7).focusedSuffixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unfocusedSuffixColor, ((TextFieldColors)arg7).unfocusedSuffixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledSuffixColor, ((TextFieldColors)arg7).disabledSuffixColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.errorSuffixColor, ((TextFieldColors)arg7).errorSuffixColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getCursorColor-0d7_KjU() {
        return this.cursorColor;
    }

    public final long getDisabledContainerColor-0d7_KjU() {
        return this.disabledContainerColor;
    }

    public final long getDisabledIndicatorColor-0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    public final long getDisabledLabelColor-0d7_KjU() {
        return this.disabledLabelColor;
    }

    public final long getDisabledLeadingIconColor-0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    public final long getDisabledPlaceholderColor-0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    public final long getDisabledPrefixColor-0d7_KjU() {
        return this.disabledPrefixColor;
    }

    public final long getDisabledSuffixColor-0d7_KjU() {
        return this.disabledSuffixColor;
    }

    public final long getDisabledSupportingTextColor-0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getDisabledTrailingIconColor-0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    public final long getErrorContainerColor-0d7_KjU() {
        return this.errorContainerColor;
    }

    public final long getErrorCursorColor-0d7_KjU() {
        return this.errorCursorColor;
    }

    public final long getErrorIndicatorColor-0d7_KjU() {
        return this.errorIndicatorColor;
    }

    public final long getErrorLabelColor-0d7_KjU() {
        return this.errorLabelColor;
    }

    public final long getErrorLeadingIconColor-0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    public final long getErrorPlaceholderColor-0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    public final long getErrorPrefixColor-0d7_KjU() {
        return this.errorPrefixColor;
    }

    public final long getErrorSuffixColor-0d7_KjU() {
        return this.errorSuffixColor;
    }

    public final long getErrorSupportingTextColor-0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    public final long getErrorTextColor-0d7_KjU() {
        return this.errorTextColor;
    }

    public final long getErrorTrailingIconColor-0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    public final long getFocusedContainerColor-0d7_KjU() {
        return this.focusedContainerColor;
    }

    public final long getFocusedIndicatorColor-0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    public final long getFocusedLabelColor-0d7_KjU() {
        return this.focusedLabelColor;
    }

    public final long getFocusedLeadingIconColor-0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    public final long getFocusedPlaceholderColor-0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    public final long getFocusedPrefixColor-0d7_KjU() {
        return this.focusedPrefixColor;
    }

    public final long getFocusedSuffixColor-0d7_KjU() {
        return this.focusedSuffixColor;
    }

    public final long getFocusedSupportingTextColor-0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    public final long getFocusedTextColor-0d7_KjU() {
        return this.focusedTextColor;
    }

    public final long getFocusedTrailingIconColor-0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    public final long getUnfocusedContainerColor-0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    public final long getUnfocusedIndicatorColor-0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    public final long getUnfocusedLabelColor-0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    public final long getUnfocusedLeadingIconColor-0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    public final long getUnfocusedPlaceholderColor-0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    public final long getUnfocusedPrefixColor-0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    public final long getUnfocusedSuffixColor-0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    public final long getUnfocusedSupportingTextColor-0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    public final long getUnfocusedTextColor-0d7_KjU() {
        return this.unfocusedTextColor;
    }

    public final long getUnfocusedTrailingIconColor-0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.hashCode-impl(this.focusedTextColor) * 0x1F + Color.hashCode-impl(this.unfocusedTextColor)) * 0x1F + Color.hashCode-impl(this.disabledTextColor)) * 0x1F + Color.hashCode-impl(this.errorTextColor)) * 0x1F + Color.hashCode-impl(this.focusedContainerColor)) * 0x1F + Color.hashCode-impl(this.unfocusedContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledContainerColor)) * 0x1F + Color.hashCode-impl(this.errorContainerColor)) * 0x1F + Color.hashCode-impl(this.cursorColor)) * 0x1F + Color.hashCode-impl(this.errorCursorColor)) * 0x1F + this.textSelectionColors.hashCode()) * 0x1F + Color.hashCode-impl(this.focusedIndicatorColor)) * 0x1F + Color.hashCode-impl(this.unfocusedIndicatorColor)) * 0x1F + Color.hashCode-impl(this.disabledIndicatorColor)) * 0x1F + Color.hashCode-impl(this.errorIndicatorColor)) * 0x1F + Color.hashCode-impl(this.focusedLeadingIconColor)) * 0x1F + Color.hashCode-impl(this.unfocusedLeadingIconColor)) * 0x1F + Color.hashCode-impl(this.disabledLeadingIconColor)) * 0x1F + Color.hashCode-impl(this.errorLeadingIconColor)) * 0x1F + Color.hashCode-impl(this.focusedTrailingIconColor)) * 0x1F + Color.hashCode-impl(this.unfocusedTrailingIconColor)) * 0x1F + Color.hashCode-impl(this.disabledTrailingIconColor)) * 0x1F + Color.hashCode-impl(this.errorTrailingIconColor)) * 0x1F + Color.hashCode-impl(this.focusedLabelColor)) * 0x1F + Color.hashCode-impl(this.unfocusedLabelColor)) * 0x1F + Color.hashCode-impl(this.disabledLabelColor)) * 0x1F + Color.hashCode-impl(this.errorLabelColor)) * 0x1F + Color.hashCode-impl(this.focusedPlaceholderColor)) * 0x1F + Color.hashCode-impl(this.unfocusedPlaceholderColor)) * 0x1F + Color.hashCode-impl(this.disabledPlaceholderColor)) * 0x1F + Color.hashCode-impl(this.errorPlaceholderColor)) * 0x1F + Color.hashCode-impl(this.focusedSupportingTextColor)) * 0x1F + Color.hashCode-impl(this.unfocusedSupportingTextColor)) * 0x1F + Color.hashCode-impl(this.disabledSupportingTextColor)) * 0x1F + Color.hashCode-impl(this.errorSupportingTextColor)) * 0x1F + Color.hashCode-impl(this.focusedPrefixColor)) * 0x1F + Color.hashCode-impl(this.unfocusedPrefixColor)) * 0x1F + Color.hashCode-impl(this.disabledPrefixColor)) * 0x1F + Color.hashCode-impl(this.errorPrefixColor)) * 0x1F + Color.hashCode-impl(this.focusedSuffixColor)) * 0x1F + Color.hashCode-impl(this.unfocusedSuffixColor)) * 0x1F + Color.hashCode-impl(this.disabledSuffixColor)) * 0x1F + Color.hashCode-impl(this.errorSuffixColor);
    }

    public final long indicatorColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledIndicatorColor;
        }

        if(arg2) {
            return this.errorIndicatorColor;
        }

        if(arg3) {
            return this.focusedIndicatorColor;
        }

        return this.unfocusedIndicatorColor;
    }

    public final long labelColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledLabelColor;
        }

        if(arg2) {
            return this.errorLabelColor;
        }

        if(arg3) {
            return this.focusedLabelColor;
        }

        return this.unfocusedLabelColor;
    }

    public final long leadingIconColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledLeadingIconColor;
        }

        if(arg2) {
            return this.errorLeadingIconColor;
        }

        if(arg3) {
            return this.focusedLeadingIconColor;
        }

        return this.unfocusedLeadingIconColor;
    }

    public final long placeholderColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledPlaceholderColor;
        }

        if(arg2) {
            return this.errorPlaceholderColor;
        }

        if(arg3) {
            return this.focusedPlaceholderColor;
        }

        return this.unfocusedPlaceholderColor;
    }

    public final long prefixColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledPrefixColor;
        }

        if(arg2) {
            return this.errorPrefixColor;
        }

        if(arg3) {
            return this.focusedPrefixColor;
        }

        return this.unfocusedPrefixColor;
    }

    public final long suffixColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledSuffixColor;
        }

        if(arg2) {
            return this.errorSuffixColor;
        }

        if(arg3) {
            return this.focusedSuffixColor;
        }

        return this.unfocusedSuffixColor;
    }

    public final long supportingTextColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledSupportingTextColor;
        }

        if(arg2) {
            return this.errorSupportingTextColor;
        }

        if(arg3) {
            return this.focusedSupportingTextColor;
        }

        return this.unfocusedSupportingTextColor;
    }

    public final TextSelectionColors takeOrElse$material3(TextSelectionColors arg1, Function0 arg2) {
        if(arg1 == null) {
            return arg2.invoke();
        }

        return arg1;
    }

    public final long textColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledTextColor;
        }

        if(arg2) {
            return this.errorTextColor;
        }

        if(arg3) {
            return this.focusedTextColor;
        }

        return this.unfocusedTextColor;
    }

    public final long trailingIconColor-XeAY9LY$material3(boolean arg1, boolean arg2, boolean arg3) {
        if(!arg1) {
            return this.disabledTrailingIconColor;
        }

        if(arg2) {
            return this.errorTrailingIconColor;
        }

        if(arg3) {
            return this.focusedTrailingIconColor;
        }

        return this.unfocusedTrailingIconColor;
    }
}

