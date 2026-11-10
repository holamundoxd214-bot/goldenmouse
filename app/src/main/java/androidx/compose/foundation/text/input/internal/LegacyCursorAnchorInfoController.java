package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo$Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\fJ.\u0010$\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019J\u0006\u0010%\u001A\u00020\u0005J\b\u0010&\u001A\u00020\u0005H\u0002R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001ER\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "lock", "monitorEnabled", "", "hasPendingImmediateRequest", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "matrix", "[F", "androidMatrix", "Landroid/graphics/Matrix;", "requestUpdate", "immediate", "monitor", "updateTextLayoutResult", "invalidate", "updateCursorAnchorInfo", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyCursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo$Builder builder;
    private Rect decorationBoxBounds;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private Rect innerTextFieldBounds;
    private final InputMethodManager inputMethodManager;
    private final Function1 localToScreen;
    private final Object lock;
    private final float[] matrix;
    private boolean monitorEnabled;
    private OffsetMapping offsetMapping;
    private TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;

    static {
    }

    public LegacyCursorAnchorInfoController(Function1 arg1, InputMethodManager arg2) {
        super();
        this.localToScreen = arg1;
        this.inputMethodManager = arg2;
        this.lock = new Object();
        this.builder = new CursorAnchorInfo$Builder();
        this.matrix = androidx.compose.ui.graphics.Matrix.constructor-impl$default(null, 1, null);
        this.androidMatrix = new Matrix();
    }

    public final void invalidate() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        TextFieldValue v1 = null;
        try {
            this.textFieldValue = v1;
            this.offsetMapping = ((OffsetMapping)v1);
            this.textLayoutResult = ((TextLayoutResult)v1);
            this.innerTextFieldBounds = ((Rect)v1);
            this.decorationBoxBounds = ((Rect)v1);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void requestUpdate(boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.includeInsertionMarker = arg4;
            this.includeCharacterBounds = arg5;
            this.includeEditorBounds = arg6;
            this.includeLineBounds = arg7;
            if(arg2) {
                this.hasPendingImmediateRequest = true;
                if(this.textFieldValue != null) {
                    this.updateCursorAnchorInfo();
                }
            }

            this.monitorEnabled = arg3;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    private final void updateCursorAnchorInfo() {
        if((this.inputMethodManager.isActive()) && this.textFieldValue != null && this.offsetMapping != null && this.textLayoutResult != null && this.innerTextFieldBounds != null) {
            if(this.decorationBoxBounds == null) {
            }
            else {
                androidx.compose.ui.graphics.Matrix.reset-impl(this.matrix);
                this.localToScreen.invoke(androidx.compose.ui.graphics.Matrix.box-impl(this.matrix));
                float[] v0 = this.matrix;
                Rect v1 = this.decorationBoxBounds;
                Intrinsics.checkNotNull(v1);
                float v1_1 = -v1.getLeft();
                Rect v2 = this.decorationBoxBounds;
                Intrinsics.checkNotNull(v2);
                androidx.compose.ui.graphics.Matrix.translate-impl(v0, v1_1, -v2.getTop(), 0f);
                AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(this.androidMatrix, this.matrix);
                InputMethodManager v0_1 = this.inputMethodManager;
                CursorAnchorInfo$Builder v1_2 = this.builder;
                TextFieldValue v2_1 = this.textFieldValue;
                Intrinsics.checkNotNull(v2_1);
                OffsetMapping v3 = this.offsetMapping;
                Intrinsics.checkNotNull(v3);
                TextLayoutResult v4 = this.textLayoutResult;
                Intrinsics.checkNotNull(v4);
                Matrix v5 = this.androidMatrix;
                Rect v6 = this.innerTextFieldBounds;
                Intrinsics.checkNotNull(v6);
                Rect v7 = this.decorationBoxBounds;
                Intrinsics.checkNotNull(v7);
                v0_1.updateCursorAnchorInfo(LegacyCursorAnchorInfoBuilder_androidKt.build(v1_2, v2_1, v3, v4, v5, v6, v7, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
                this.hasPendingImmediateRequest = false;
            }
        }
    }

    public final void updateTextLayoutResult(TextFieldValue arg2, OffsetMapping arg3, TextLayoutResult arg4, Rect arg5, Rect arg6) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.textFieldValue = arg2;
            this.offsetMapping = arg3;
            this.textLayoutResult = arg4;
            this.innerTextFieldBounds = arg5;
            this.decorationBoxBounds = arg6;
            if((this.hasPendingImmediateRequest) || (this.monitorEnabled)) {
                this.updateCursorAnchorInfo();
            }
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }
}

