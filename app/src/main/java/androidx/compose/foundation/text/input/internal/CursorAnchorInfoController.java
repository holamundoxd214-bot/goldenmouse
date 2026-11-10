package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build$VERSION;
import android.view.inputmethod.CursorAnchorInfo$Builder;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FJ8\u0010\u001C\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\rH\u0002J\b\u0010\"\u001A\u00020\u001DH\u0002J\n\u0010#\u001A\u0004\u0018\u00010$H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "monitorEnabled", "", "hasPendingImmediateRequest", "monitorJob", "Lkotlinx/coroutines/Job;", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "androidMatrix", "Landroid/graphics/Matrix;", "requestUpdates", "", "cursorUpdateMode", "", "immediate", "monitor", "startOrStopMonitoring", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CursorAnchorInfoController {
    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo$Builder builder;
    private final ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private final float[] matrix;
    private boolean monitorEnabled;
    private Job monitorJob;
    private final CoroutineScope monitorScope;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;

    static {
    }

    public CursorAnchorInfoController(TransformedTextFieldState arg1, TextLayoutState arg2, ComposeInputMethodManager arg3, CoroutineScope arg4) {
        super();
        this.textFieldState = arg1;
        this.textLayoutState = arg2;
        this.composeImm = arg3;
        this.monitorScope = arg4;
        this.builder = new CursorAnchorInfo$Builder();
        this.matrix = androidx.compose.ui.graphics.Matrix.constructor-impl$default(null, 1, null);
        this.androidMatrix = new Matrix();
    }

    public static final CursorAnchorInfo access$calculateCursorAnchorInfo(CursorAnchorInfoController arg0) {
        return arg0.calculateCursorAnchorInfo();
    }

    public static final ComposeInputMethodManager access$getComposeImm$p(CursorAnchorInfoController arg0) {
        return arg0.composeImm;
    }

    private final CursorAnchorInfo calculateCursorAnchorInfo() {
        CursorAnchorInfoController v0 = this;
        LayoutCoordinates v1 = v0.textLayoutState.getTextLayoutNodeCoordinates();
        CursorAnchorInfo v2 = null;
        if(v1 != null) {
            if(v1.isAttached()) {
            }
            else {
                v1 = ((LayoutCoordinates)v2);
            }

            if(v1 == null) {
                return v2;
            }

            LayoutCoordinates v3 = v0.textLayoutState.getCoreNodeCoordinates();
            if(v3 == null) {
                return v2;
            }

            if(v3.isAttached()) {
            }
            else {
                v3 = ((LayoutCoordinates)v2);
            }

            if(v3 == null) {
                return v2;
            }

            LayoutCoordinates v4 = v0.textLayoutState.getDecoratorNodeCoordinates();
            if(v4 == null) {
                return v2;
            }

            if(v4.isAttached()) {
            }
            else {
                v4 = ((LayoutCoordinates)v2);
            }

            if(v4 == null) {
                return v2;
            }

            TextLayoutResult v11 = v0.textLayoutState.getLayoutResult();
            if(v11 == null) {
                return v2;
            }

            TextFieldCharSequence v2_1 = v0.textFieldState.getVisualText();
            androidx.compose.ui.graphics.Matrix.reset-impl(v0.matrix);
            v1.transformToScreen-58bKbWc(v0.matrix);
            AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(v0.androidMatrix, v0.matrix);
            return CursorAnchorInfoBuilder_androidKt.build-vxqZcH0(v0.builder, v2_1, v2_1.getSelection-d9O1mEE(), v2_1.getComposition-MzsxiRA(), v11, v0.androidMatrix, SelectionManagerKt.visibleBounds(v3).translate-k-4lQ0M(v1.localPositionOf-R5De75A(v3, Offset.Companion.getZero-F1C5BW0())), SelectionManagerKt.visibleBounds(v4).translate-k-4lQ0M(v1.localPositionOf-R5De75A(v4, Offset.Companion.getZero-F1C5BW0())), v0.includeInsertionMarker, v0.includeCharacterBounds, v0.includeEditorBounds, v0.includeLineBounds);
        }

        return v2;
    }

    private final void requestUpdates(boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6) {
        this.includeInsertionMarker = arg3;
        this.includeCharacterBounds = arg4;
        this.includeEditorBounds = arg5;
        this.includeLineBounds = arg6;
        if(arg1) {
            this.hasPendingImmediateRequest = true;
            CursorAnchorInfo v1 = this.calculateCursorAnchorInfo();
            if(v1 != null) {
                this.composeImm.updateCursorAnchorInfo(v1);
            }
        }

        this.monitorEnabled = arg2;
        this.startOrStopMonitoring();
    }

    public final void requestUpdates(int arg11) {
        boolean v9;
        boolean v8_1;
        boolean v7;
        CursorAnchorInfoController v3_1;
        boolean v6;
        boolean v1 = false;
        boolean v4 = (arg11 & 1) != 0 ? true : false;
        boolean v5 = (arg11 & 2) != 0 ? true : false;
        if(Build$VERSION.SDK_INT >= 33) {
            boolean v0 = (arg11 & 16) != 0 ? true : false;
            boolean v3 = (arg11 & 8) != 0 ? true : false;
            v6 = (arg11 & 4) != 0 ? true : false;
            int v8 = 34;
            if(Build$VERSION.SDK_INT >= v8 && (arg11 & 0x20) != 0) {
                v1 = true;
            }

            if(!v0 && !v3 && !v6 && !v1) {
                v3_1 = this;
                if(Build$VERSION.SDK_INT >= v8) {
                    v6 = true;
                    v7 = true;
                    v8_1 = true;
                    v9 = true;
                }
                else {
                    v9 = v1;
                    v6 = true;
                    v7 = true;
                    v8_1 = true;
                }

                goto label_64;
            }

            v9 = v1;
            v7 = v3;
            v8_1 = v6;
            v3_1 = this;
            v6 = v0;
        }
        else {
            v3_1 = this;
            v8_1 = false;
            v9 = false;
            v6 = true;
            v7 = true;
        }

    label_64:
        v3_1.requestUpdates(v4, v5, v6, v7, v8_1, v9);
    }

    private final void startOrStopMonitoring() {
        boolean v0 = this.monitorEnabled;
        Job v1 = this.monitorJob;
        Continuation v3 = null;
        if(v0) {
            if(v1 != null && (v1.isActive())) {
                return;
            }

            this.monitorJob = BuildersKt.launch$default(this.monitorScope, null, CoroutineStart.UNDISPATCHED, new CursorAnchorInfoController$startOrStopMonitoring$1(this, v3), 1, null);
            return;
        }

        if(v1 != null) {
            DefaultImpls.cancel$default(v1, ((CancellationException)v3), 1, v3);
        }

        this.monitorJob = ((Job)v3);
    }
}

