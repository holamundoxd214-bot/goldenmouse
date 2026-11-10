package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0014H\u0016J\b\u0010\u0016\u001A\u00020\u0014H\u0016J\u000E\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001CJ\u000E\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u001E\u001A\u00020\u001FR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2={"Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/runtime/RememberObserver;", "selectableId", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "backgroundSelectionColor", "Landroidx/compose/ui/graphics/Color;", "params", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "<init>", "(JLandroidx/compose/foundation/text/selection/SelectionRegistrar;JLandroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onRemembered", "", "onForgotten", "onAbandoned", "updateTextLayout", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "updateGlobalPosition", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionController implements RememberObserver {
    public static final int $stable = 8;
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    static {
    }

    public SelectionController(long arg9, SelectionRegistrar arg11, long arg12, StaticTextSelectionParams arg14, int arg15, DefaultConstructorMarker arg16) {
        if((arg15 & 8) != 0) {
            arg14 = StaticTextSelectionParams.Companion.getEmpty();
        }

        this(arg9, arg11, arg12, arg14, null);
    }

    private SelectionController(long arg1, SelectionRegistrar arg3, long arg4, StaticTextSelectionParams arg6) {
        super();
        this.selectableId = arg1;
        this.selectionRegistrar = arg3;
        this.backgroundSelectionColor = arg4;
        this.params = arg6;
        this.modifier = PointerIconKt.pointerHoverIcon$default(SelectionController_androidKt.makeSelectionModifier(arg3, arg1, new SelectionController$$ExternalSyntheticLambda2(this)), PointerIcon.Companion.getText(), false, 2, null);
    }

    public SelectionController(long arg1, SelectionRegistrar arg3, long arg4, StaticTextSelectionParams arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg4, arg6);
    }

    public final void draw(DrawScope arg15) {
        Path v5;
        Object v1 = this.selectionRegistrar.getSubselections().get(this.selectableId);
        if(v1 == null) {
        }
        else {
            int v2 = !((Selection)v1).getHandlesCrossed() ? ((Selection)v1).getStart().getOffset() : ((Selection)v1).getEnd().getOffset();
            int v1_1 = !((Selection)v1).getHandlesCrossed() ? ((Selection)v1).getEnd().getOffset() : ((Selection)v1).getStart().getOffset();
            if(v2 == v1_1) {
                return;
            }

            Selectable v3 = this.selectable;
            int v3_1 = v3 != null ? v3.getLastVisibleOffset() : 0;
            v5 = this.params.getPathForRange(RangesKt.coerceAtMost(v2, v3_1), RangesKt.coerceAtMost(v1_1, v3_1));
            if(v5 != null) {
                goto label_33;
            }
        }

        return;
    label_33:
        if(this.params.getShouldClip()) {
            float v9 = Float.intBitsToFloat(((int)(arg15.getSize-NH-jbRc() >> 0x20)));
            float v10 = Float.intBitsToFloat(((int)(arg15.getSize-NH-jbRc() & 0xFFFFFFFFL)));
            int v11 = ClipOp.Companion.getIntersect-rtfAjoo();
            DrawContext v1_2 = arg15.getDrawContext();
            long v2_1 = v1_2.getSize-NH-jbRc();
            v1_2.getCanvas().save();
            try {
                v1_2.getTransform().clipRect-N_I0leg(0f, 0f, v9, v10, v11);
                DrawScope.drawPath-LG529CI$default(arg15, v5, this.backgroundSelectionColor, 0f, null, null, 0, 60, null);
            }
            catch(Throwable v0) {
                v1_2.getCanvas().restore();
                v1_2.setSize-uvyYCjk(v2_1);
                throw v0;
            }

            v1_2.getCanvas().restore();
            v1_2.setSize-uvyYCjk(v2_1);
            return;
        }

        DrawScope.drawPath-LG529CI$default(arg15, v5, this.backgroundSelectionColor, 0f, null, null, 0, 60, null);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    static final LayoutCoordinates modifier$lambda$0(SelectionController arg0) {
        return arg0.params.getLayoutCoordinates();
    }

    public void onAbandoned() {
        Selectable v0 = this.selectable;
        if(v0 != null) {
            this.selectionRegistrar.unsubscribe(v0);
            this.selectable = null;
        }
    }

    public void onForgotten() {
        Selectable v0 = this.selectable;
        if(v0 != null) {
            this.selectionRegistrar.unsubscribe(v0);
            this.selectable = null;
        }
    }

    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new SelectionController$$ExternalSyntheticLambda0(this), new SelectionController$$ExternalSyntheticLambda1(this)));
    }

    static final LayoutCoordinates onRemembered$lambda$0(SelectionController arg0) {
        return arg0.params.getLayoutCoordinates();
    }

    static final TextLayoutResult onRemembered$lambda$1(SelectionController arg0) {
        return arg0.params.getTextLayoutResult();
    }

    public final void updateGlobalPosition(LayoutCoordinates arg4) {
        this.params = StaticTextSelectionParams.copy$default(this.params, arg4, null, 2, null);
        this.selectionRegistrar.notifyPositionChange(this.selectableId);
    }

    public final void updateTextLayout(TextLayoutResult arg4) {
        TextLayoutResult v0 = this.params.getTextLayoutResult();
        if(v0 != null && !Intrinsics.areEqual(v0.getLayoutInput().getText(), arg4.getLayoutInput().getText())) {
            this.selectionRegistrar.notifySelectableChange(this.selectableId);
        }

        this.params = StaticTextSelectionParams.copy$default(this.params, null, arg4, 1, null);
    }
}

