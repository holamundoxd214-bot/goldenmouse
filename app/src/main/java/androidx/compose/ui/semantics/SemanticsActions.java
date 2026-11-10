package androidx.compose.ui.semantics;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R/\u0010\u0004\u001A \u0012\u001C\u0012\u001A\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR#\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR#\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\fRM\u0010\u0012\u001A>\u0012:\u00128\u00124\u00122\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\n0\u00130\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\fRB\u0010\u001A\u001A3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u001B¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001B0\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\fR)\u0010\u001F\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\fR4\u0010\"\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b$\u0010\u0003\u001A\u0004\b%\u0010\fR)\u0010&\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\fR8\u0010)\u001A)\u0012%\u0012#\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\fR5\u0010,\u001A&\u0012\"\u0012 \u0012\u001C\u0012\u001A\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0-0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b.\u0010\fR)\u0010/\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b0\u0010\fR)\u00101\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b2\u0010\fR)\u00103\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b4\u0010\fR#\u00105\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b6\u0010\fR)\u00107\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b8\u0010\fR#\u00109\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b:\u0010\fR.\u0010;\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b<\u0010\u0003\u001A\u0004\b=\u0010\fR#\u0010>\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b?\u0010\fR#\u0010@\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bA\u0010\fR#\u0010B\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bC\u0010\fR#\u0010D\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bE\u0010\fR#\u0010F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bG\u0010\fR#\u0010H\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bI\u0010\fR#\u0010J\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bK\u0010\fR\u001D\u0010L\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0M0\u0005¢\u0006\b\n\u0000\u001A\u0004\bO\u0010\fR#\u0010P\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bQ\u0010\fR#\u0010R\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bS\u0010\fR#\u0010T\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bU\u0010\fR#\u0010V\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000E0\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bW\u0010\fR/\u0010X\u001A \u0012\u001C\u0012\u001A\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b\u0012\u0004\u0012\u00020\n0\u00070\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\bY\u0010\f¨\u0006Z"}, d2={"Landroidx/compose/ui/semantics/SemanticsActions;", "", "<init>", "()V", "GetTextLayoutResult", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "", "getGetTextLayoutResult", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "OnClick", "Lkotlin/Function0;", "getOnClick", "OnLongClick", "getOnLongClick", "ScrollBy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "getScrollBy", "ScrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "getScrollByOffset", "ScrollToIndex", "", "getScrollToIndex", "OnAutofillText", "Landroidx/compose/ui/text/AnnotatedString;", "getOnAutofillText$annotations", "getOnAutofillText", "OnFillData", "Landroidx/compose/ui/autofill/FillableData;", "getOnFillData", "SetProgress", "progress", "getSetProgress", "SetSelection", "Lkotlin/Function3;", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ClearTextSubstitution", "getClearTextSubstitution", "InsertTextAtCursor", "getInsertTextAtCursor", "OnImeAction", "getOnImeAction", "PerformImeAction", "getPerformImeAction$annotations", "getPerformImeAction", "CopyText", "getCopyText", "CutText", "getCutText", "PasteText", "getPasteText", "Expand", "getExpand", "Collapse", "getCollapse", "Dismiss", "getDismiss", "RequestFocus", "getRequestFocus", "CustomActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "PageUp", "getPageUp", "PageLeft", "getPageLeft", "PageDown", "getPageDown", "PageRight", "getPageRight", "GetScrollViewportLength", "getGetScrollViewportLength", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsActions {
    public static final int $stable;
    private static final SemanticsPropertyKey ClearTextSubstitution;
    private static final SemanticsPropertyKey Collapse;
    private static final SemanticsPropertyKey CopyText;
    private static final SemanticsPropertyKey CustomActions;
    private static final SemanticsPropertyKey CutText;
    private static final SemanticsPropertyKey Dismiss;
    private static final SemanticsPropertyKey Expand;
    private static final SemanticsPropertyKey GetScrollViewportLength;
    private static final SemanticsPropertyKey GetTextLayoutResult;
    public static final SemanticsActions INSTANCE;
    private static final SemanticsPropertyKey InsertTextAtCursor;
    private static final SemanticsPropertyKey OnAutofillText;
    private static final SemanticsPropertyKey OnClick;
    private static final SemanticsPropertyKey OnFillData;
    private static final SemanticsPropertyKey OnImeAction;
    private static final SemanticsPropertyKey OnLongClick;
    private static final SemanticsPropertyKey PageDown;
    private static final SemanticsPropertyKey PageLeft;
    private static final SemanticsPropertyKey PageRight;
    private static final SemanticsPropertyKey PageUp;
    private static final SemanticsPropertyKey PasteText;
    private static final SemanticsPropertyKey PerformImeAction;
    private static final SemanticsPropertyKey RequestFocus;
    private static final SemanticsPropertyKey ScrollBy;
    private static final SemanticsPropertyKey ScrollByOffset;
    private static final SemanticsPropertyKey ScrollToIndex;
    private static final SemanticsPropertyKey SetProgress;
    private static final SemanticsPropertyKey SetSelection;
    private static final SemanticsPropertyKey SetText;
    private static final SemanticsPropertyKey SetTextSubstitution;
    private static final SemanticsPropertyKey ShowTextSubstitution;

    static {
        SemanticsActions.INSTANCE = new SemanticsActions();
        SemanticsActions.GetTextLayoutResult = new SemanticsPropertyKey("GetTextLayoutResult", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.OnClick = new SemanticsPropertyKey("OnClick", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.OnLongClick = new SemanticsPropertyKey("OnLongClick", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.ScrollBy = new SemanticsPropertyKey("ScrollBy", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.ScrollByOffset = new SemanticsPropertyKey("ScrollByOffset", null, 2, null);
        SemanticsActions.ScrollToIndex = new SemanticsPropertyKey("ScrollToIndex", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.OnAutofillText = new SemanticsPropertyKey("OnAutofillText", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.OnFillData = new SemanticsPropertyKey("OnFillData", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.SetProgress = new SemanticsPropertyKey("SetProgress", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.SetSelection = new SemanticsPropertyKey("SetSelection", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.SetText = new SemanticsPropertyKey("SetText", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.SetTextSubstitution = new SemanticsPropertyKey("SetTextSubstitution", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.ShowTextSubstitution = new SemanticsPropertyKey("ShowTextSubstitution", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.ClearTextSubstitution = new SemanticsPropertyKey("ClearTextSubstitution", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.InsertTextAtCursor = new SemanticsPropertyKey("InsertTextAtCursor", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.OnImeAction = new SemanticsPropertyKey("PerformImeAction", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.PerformImeAction = new SemanticsPropertyKey("PerformImeAction", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.CopyText = new SemanticsPropertyKey("CopyText", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.CutText = new SemanticsPropertyKey("CutText", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.PasteText = new SemanticsPropertyKey("PasteText", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.Expand = new SemanticsPropertyKey("Expand", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.Collapse = new SemanticsPropertyKey("Collapse", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.Dismiss = new SemanticsPropertyKey("Dismiss", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.RequestFocus = new SemanticsPropertyKey("RequestFocus", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.CustomActions = new SemanticsPropertyKey("CustomActions", true, SemanticsActions$CustomActions$1.INSTANCE, null, 8, null);
        SemanticsActions.PageUp = new SemanticsPropertyKey("PageUp", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.PageLeft = new SemanticsPropertyKey("PageLeft", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.PageDown = new SemanticsPropertyKey("PageDown", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.PageRight = new SemanticsPropertyKey("PageRight", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.GetScrollViewportLength = new SemanticsPropertyKey("GetScrollViewportLength", true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
        SemanticsActions.$stable = 8;
    }

    private SemanticsActions() {
        super();
    }

    public final SemanticsPropertyKey getClearTextSubstitution() {
        return SemanticsActions.ClearTextSubstitution;
    }

    public final SemanticsPropertyKey getCollapse() {
        return SemanticsActions.Collapse;
    }

    public final SemanticsPropertyKey getCopyText() {
        return SemanticsActions.CopyText;
    }

    public final SemanticsPropertyKey getCustomActions() {
        return SemanticsActions.CustomActions;
    }

    public final SemanticsPropertyKey getCutText() {
        return SemanticsActions.CutText;
    }

    public final SemanticsPropertyKey getDismiss() {
        return SemanticsActions.Dismiss;
    }

    public final SemanticsPropertyKey getExpand() {
        return SemanticsActions.Expand;
    }

    public final SemanticsPropertyKey getGetScrollViewportLength() {
        return SemanticsActions.GetScrollViewportLength;
    }

    public final SemanticsPropertyKey getGetTextLayoutResult() {
        return SemanticsActions.GetTextLayoutResult;
    }

    public final SemanticsPropertyKey getInsertTextAtCursor() {
        return SemanticsActions.InsertTextAtCursor;
    }

    public final SemanticsPropertyKey getOnAutofillText() {
        return SemanticsActions.OnAutofillText;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use `SemanticsActions.OnFillData` instead.", replaceWith="<_subannotation>") public static void getOnAutofillText$annotations() {
    }

    public final SemanticsPropertyKey getOnClick() {
        return SemanticsActions.OnClick;
    }

    public final SemanticsPropertyKey getOnFillData() {
        return SemanticsActions.OnFillData;
    }

    public final SemanticsPropertyKey getOnImeAction() {
        return SemanticsActions.OnImeAction;
    }

    public final SemanticsPropertyKey getOnLongClick() {
        return SemanticsActions.OnLongClick;
    }

    public final SemanticsPropertyKey getPageDown() {
        return SemanticsActions.PageDown;
    }

    public final SemanticsPropertyKey getPageLeft() {
        return SemanticsActions.PageLeft;
    }

    public final SemanticsPropertyKey getPageRight() {
        return SemanticsActions.PageRight;
    }

    public final SemanticsPropertyKey getPageUp() {
        return SemanticsActions.PageUp;
    }

    public final SemanticsPropertyKey getPasteText() {
        return SemanticsActions.PasteText;
    }

    public final SemanticsPropertyKey getPerformImeAction() {
        return SemanticsActions.PerformImeAction;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use `SemanticsActions.OnImeAction` instead.", replaceWith="<_subannotation>") public static void getPerformImeAction$annotations() {
    }

    public final SemanticsPropertyKey getRequestFocus() {
        return SemanticsActions.RequestFocus;
    }

    public final SemanticsPropertyKey getScrollBy() {
        return SemanticsActions.ScrollBy;
    }

    public final SemanticsPropertyKey getScrollByOffset() {
        return SemanticsActions.ScrollByOffset;
    }

    public final SemanticsPropertyKey getScrollToIndex() {
        return SemanticsActions.ScrollToIndex;
    }

    public final SemanticsPropertyKey getSetProgress() {
        return SemanticsActions.SetProgress;
    }

    public final SemanticsPropertyKey getSetSelection() {
        return SemanticsActions.SetSelection;
    }

    public final SemanticsPropertyKey getSetText() {
        return SemanticsActions.SetText;
    }

    public final SemanticsPropertyKey getSetTextSubstitution() {
        return SemanticsActions.SetTextSubstitution;
    }

    public final SemanticsPropertyKey getShowTextSubstitution() {
        return SemanticsActions.ShowTextSubstitution;
    }
}

