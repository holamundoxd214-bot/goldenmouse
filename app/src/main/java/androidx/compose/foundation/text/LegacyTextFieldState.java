package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0007\u0010\u0087\u0001\u001A\u00020\u001DJx\u0010\u0088\u0001\u001A\u00020j2\u0006\u0010<\u001A\u00020=2\u0007\u0010\u0089\u0001\u001A\u00020=2\b\u0010\u008A\u0001\u001A\u00030\u008B\u00012\u0007\u0010\u008C\u0001\u001A\u00020\u001D2\b\u0010\u008D\u0001\u001A\u00030\u008E\u00012\b\u0010\u008F\u0001\u001A\u00030\u0090\u00012\u0012\u0010k\u001A\u000E\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0h2\b\u0010\u0091\u0001\u001A\u00030\u0092\u00012\b\u0010\u0093\u0001\u001A\u00030\u0094\u00012\u0006\u0010w\u001A\u00020x¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR+\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R+\u0010&\u001A\u00020%2\u0006\u0010\u001C\u001A\u00020%8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b+\u0010$\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0010\u0010,\u001A\u0004\u0018\u00010-X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010/\u001A\u0004\u0018\u00010-2\b\u0010.\u001A\u0004\u0018\u00010-8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010605X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00107\u001A\u0004\u0018\u0001062\b\u0010.\u001A\u0004\u0018\u0001068F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\u001C\u0010<\u001A\u0004\u0018\u00010=X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010C\u001A\u00020B2\u0006\u0010\u001C\u001A\u00020B8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bH\u0010$\u001A\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010I\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bL\u0010$\u001A\u0004\bJ\u0010 \"\u0004\bK\u0010\"R+\u0010M\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bP\u0010$\u001A\u0004\bN\u0010 \"\u0004\bO\u0010\"R+\u0010Q\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bT\u0010$\u001A\u0004\bR\u0010 \"\u0004\bS\u0010\"R+\u0010U\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bX\u0010$\u001A\u0004\bV\u0010 \"\u0004\bW\u0010\"R\u001E\u0010Y\u001A\u00020\u001D2\u0006\u0010.\u001A\u00020\u001D@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\bY\u0010 R+\u0010Z\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\\\u0010$\u001A\u0004\bZ\u0010 \"\u0004\b[\u0010\"R\u000E\u0010]\u001A\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010_\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bb\u0010$\u001A\u0004\b`\u0010 \"\u0004\ba\u0010\"R+\u0010c\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001D8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bf\u0010$\u001A\u0004\bd\u0010 \"\u0004\be\u0010\"R\u001A\u0010g\u001A\u000E\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0hX\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010k\u001A\u000E\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020j0h¢\u0006\b\n\u0000\u001A\u0004\bl\u0010mR\u001D\u0010n\u001A\u000E\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020j0h¢\u0006\b\n\u0000\u001A\u0004\bp\u0010mR\u001D\u0010q\u001A\u000E\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\u001D0h¢\u0006\b\n\u0000\u001A\u0004\br\u0010mR\u0011\u0010s\u001A\u00020t¢\u0006\b\n\u0000\u001A\u0004\bu\u0010vR\u001C\u0010w\u001A\u00020xX\u0086\u000E¢\u0006\u0010\n\u0002\u0010}\u001A\u0004\by\u0010z\"\u0004\b{\u0010|R.\u0010\u007F\u001A\u00020~2\u0006\u0010\u001C\u001A\u00020~8F@FX\u0086\u008E\u0002¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010$\u001A\u0005\b\u0080\u0001\u0010z\"\u0005\b\u0081\u0001\u0010|R/\u0010\u0083\u0001\u001A\u00020~2\u0006\u0010\u001C\u001A\u00020~8F@FX\u0086\u008E\u0002¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010$\u001A\u0005\b\u0084\u0001\u0010z\"\u0005\b\u0085\u0001\u0010|¨\u0006\u0097\u0001"}, d2={"Landroidx/compose/foundation/text/LegacyTextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "<set-?>", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "isLayoutResultStale", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "justAutofilled", "getJustAutofilled", "setJustAutofilled", "justAutofilled$delegate", "onValueChangeOriginal", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "onValueChange", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "getOnImeActionPerformed", "onImeActionPerformedWithResult", "getOnImeActionPerformedWithResult", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "getHighlightPaint", "()Landroidx/compose/ui/graphics/Paint;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "()J", "setSelectionBackgroundColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/text/TextRange;", "selectionPreviewHighlightRange", "getSelectionPreviewHighlightRange-d9O1mEE", "setSelectionPreviewHighlightRange-5zc-tL8", "selectionPreviewHighlightRange$delegate", "deletionPreviewHighlightRange", "getDeletionPreviewHighlightRange-d9O1mEE", "setDeletionPreviewHighlightRange-5zc-tL8", "deletionPreviewHighlightRange$delegate", "hasHighlight", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyTextFieldState {
    public static final int $stable = 8;
    private LayoutCoordinates _layoutCoordinates;
    private final MutableState autofillHighlightOn$delegate;
    private final MutableState deletionPreviewHighlightRange$delegate;
    private final MutableState handleState$delegate;
    private final MutableState hasFocus$delegate;
    private final Paint highlightPaint;
    private TextInputSession inputSession;
    private final MutableState isInTouchMode$delegate;
    private boolean isLayoutResultStale;
    private final MutableState justAutofilled$delegate;
    private final KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final MutableState layoutResultState;
    private final MutableState minHeightForSingleLineField$delegate;
    private final Function1 onImeActionPerformed;
    private final Function1 onImeActionPerformedWithResult;
    private final Function1 onValueChange;
    private Function1 onValueChangeOriginal;
    private final EditProcessor processor;
    private final RecomposeScope recomposeScope;
    private long selectionBackgroundColor;
    private final MutableState selectionPreviewHighlightRange$delegate;
    private final MutableState showCursorHandle$delegate;
    private final MutableState showFloatingToolbar$delegate;
    private final MutableState showSelectionHandleEnd$delegate;
    private final MutableState showSelectionHandleStart$delegate;
    private TextDelegate textDelegate;
    private AnnotatedString untransformedText;

    static {
    }

    public LegacyTextFieldState(TextDelegate arg4, RecomposeScope arg5, SoftwareKeyboardController arg6) {
        super();
        this.textDelegate = arg4;
        this.recomposeScope = arg5;
        this.keyboardController = arg6;
        this.processor = new EditProcessor();
        Boolean v4 = Boolean.valueOf(false);
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0f)), null, 2, null);
        this.layoutResultState = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.handleState$delegate = SnapshotStateKt.mutableStateOf$default(HandleState.None, null, 2, null);
        this.showFloatingToolbar$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.showSelectionHandleStart$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.showSelectionHandleEnd$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.isLayoutResultStale = true;
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.keyboardActionRunner = new KeyboardActionRunner(arg6);
        this.autofillHighlightOn$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.justAutofilled$delegate = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.onValueChangeOriginal = new LegacyTextFieldState$$ExternalSyntheticLambda0();
        this.onValueChange = new LegacyTextFieldState$$ExternalSyntheticLambda1(this);
        this.onImeActionPerformed = new LegacyTextFieldState$$ExternalSyntheticLambda2(this);
        this.onImeActionPerformedWithResult = new LegacyTextFieldState$$ExternalSyntheticLambda3(this);
        this.highlightPaint = AndroidPaint_androidKt.Paint();
        this.selectionBackgroundColor = Color.Companion.getUnspecified-0d7_KjU();
        this.selectionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(TextRange.Companion.getZero-d9O1mEE()), null, 2, null);
        this.deletionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(TextRange.Companion.getZero-d9O1mEE()), null, 2, null);
    }

    public final boolean getAutofillHighlightOn() {
        return this.autofillHighlightOn$delegate.getValue().booleanValue();
    }

    public final long getDeletionPreviewHighlightRange-d9O1mEE() {
        return this.deletionPreviewHighlightRange$delegate.getValue().unbox-impl();
    }

    public final HandleState getHandleState() {
        return this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return this.hasFocus$delegate.getValue().booleanValue();
    }

    public final Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final boolean getJustAutofilled() {
        return this.justAutofilled$delegate.getValue().booleanValue();
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates v2 = this._layoutCoordinates;
        LayoutCoordinates v0 = null;
        if(v2 != null && (v2.isAttached())) {
            return v2;
        }

        return v0;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return this.layoutResultState.getValue();
    }

    public final float getMinHeightForSingleLineField-D9Ej5fM() {
        return this.minHeightForSingleLineField$delegate.getValue().unbox-impl();
    }

    public final Function1 getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Function1 getOnImeActionPerformedWithResult() {
        return this.onImeActionPerformedWithResult;
    }

    public final Function1 getOnValueChange() {
        return this.onValueChange;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    public final long getSelectionBackgroundColor-0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    public final long getSelectionPreviewHighlightRange-d9O1mEE() {
        return this.selectionPreviewHighlightRange$delegate.getValue().unbox-impl();
    }

    public final boolean getShowCursorHandle() {
        return this.showCursorHandle$delegate.getValue().booleanValue();
    }

    public final boolean getShowFloatingToolbar() {
        return this.showFloatingToolbar$delegate.getValue().booleanValue();
    }

    public final boolean getShowSelectionHandleEnd() {
        return this.showSelectionHandleEnd$delegate.getValue().booleanValue();
    }

    public final boolean getShowSelectionHandleStart() {
        return this.showSelectionHandleStart$delegate.getValue().booleanValue();
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final boolean hasHighlight() {
        if(TextRange.getCollapsed-impl(this.getSelectionPreviewHighlightRange-d9O1mEE())) {
            if(!TextRange.getCollapsed-impl(this.getDeletionPreviewHighlightRange-d9O1mEE())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isInTouchMode() {
        return this.isInTouchMode$delegate.getValue().booleanValue();
    }

    public final boolean isLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    static final Unit onImeActionPerformed$lambda$0(LegacyTextFieldState arg0, ImeAction arg1) {
        arg0.keyboardActionRunner.runAction-KlQnJC8(arg1.unbox-impl());
        return Unit.INSTANCE;
    }

    static final boolean onImeActionPerformedWithResult$lambda$0(LegacyTextFieldState arg0, ImeAction arg1) {
        return arg0.keyboardActionRunner.runAction-KlQnJC8(arg1.unbox-impl());
    }

    static final Unit onValueChange$lambda$0(LegacyTextFieldState arg2, TextFieldValue arg3) {
        String v0 = arg3.getText();
        AnnotatedString v1 = arg2.untransformedText;
        if(v1 != null) {
            String v1_1 = v1.getText();
        }
        else {
            Object v1_2 = null;
        }

        if(!Intrinsics.areEqual(v0, v1_1)) {
            arg2.setHandleState(HandleState.None);
            if(arg2.getJustAutofilled()) {
                arg2.setJustAutofilled(false);
            }
            else {
                arg2.setAutofillHighlightOn(false);
            }
        }

        arg2.setSelectionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        arg2.setDeletionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        arg2.onValueChangeOriginal.invoke(arg3);
        arg2.recomposeScope.invalidate();
        return Unit.INSTANCE;
    }

    static final Unit onValueChangeOriginal$lambda$0(TextFieldValue arg0) {
        return Unit.INSTANCE;
    }

    public final void setAutofillHighlightOn(boolean arg1) {
        this.autofillHighlightOn$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setDeletionPreviewHighlightRange-5zc-tL8(long arg1) {
        this.deletionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(arg1));
    }

    public final void setHandleState(HandleState arg1) {
        this.handleState$delegate.setValue(arg1);
    }

    public final void setHasFocus(boolean arg1) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setInTouchMode(boolean arg1) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setInputSession(TextInputSession arg1) {
        this.inputSession = arg1;
    }

    public final void setJustAutofilled(boolean arg1) {
        this.justAutofilled$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setLayoutCoordinates(LayoutCoordinates arg1) {
        this._layoutCoordinates = arg1;
    }

    public final void setLayoutResult(TextLayoutResultProxy arg2) {
        this.layoutResultState.setValue(arg2);
        this.isLayoutResultStale = false;
    }

    public final void setMinHeightForSingleLineField-0680j_4(float arg1) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.box-impl(arg1));
    }

    public final void setSelectionBackgroundColor-8_81llA(long arg1) {
        this.selectionBackgroundColor = arg1;
    }

    public final void setSelectionPreviewHighlightRange-5zc-tL8(long arg1) {
        this.selectionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(arg1));
    }

    public final void setShowCursorHandle(boolean arg1) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setShowFloatingToolbar(boolean arg1) {
        this.showFloatingToolbar$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setShowSelectionHandleEnd(boolean arg1) {
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setShowSelectionHandleStart(boolean arg1) {
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setTextDelegate(TextDelegate arg1) {
        this.textDelegate = arg1;
    }

    public final void setUntransformedText(AnnotatedString arg1) {
        this.untransformedText = arg1;
    }

    public final void update-fnh65Uc(AnnotatedString arg13, AnnotatedString arg14, TextStyle arg15, boolean arg16, Density arg17, Resolver arg18, Function1 arg19, KeyboardActions arg20, FocusManager arg21, long arg22) {
        this.onValueChangeOriginal = arg19;
        this.selectionBackgroundColor = arg22;
        KeyboardActionRunner v0 = this.keyboardActionRunner;
        v0.setKeyboardActions(arg20);
        v0.setFocusManager(arg21);
        this.untransformedText = arg13;
        TextDelegate v0_1 = TextDelegateKt.updateTextDelegate-rm0N8CA$default(this.textDelegate, arg14, arg15, arg17, arg18, arg16, 0, 0, 0, CollectionsKt.emptyList(), 0x1C0, null);
        if(this.textDelegate != v0_1) {
            this.isLayoutResultStale = true;
        }

        this.textDelegate = v0_1;
    }
}

