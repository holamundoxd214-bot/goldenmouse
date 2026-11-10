package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\n\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0016J\u001F\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\n\u0010$\u001A\u0004\u0018\u00010\u0006H\u0016J\n\u0010%\u001A\u0004\u0018\u00010\bH\u0016J\b\u0010&\u001A\u00020\'H\u0016J\u0010\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\u0013H\u0016J\u0010\u0010+\u001A\u00020,2\u0006\u0010*\u001A\u00020\u0013H\u0016J\u0010\u0010-\u001A\u00020,2\u0006\u0010*\u001A\u00020\u0013H\u0016J\u0010\u0010.\u001A\u00020,2\u0006\u0010*\u001A\u00020\u0013H\u0016J\u0017\u0010/\u001A\u0002002\u0006\u0010*\u001A\u00020\u0013H\u0016¢\u0006\u0004\b1\u00102J\b\u0010\u0015\u001A\u00020\u0013H\u0016J\u0010\u00103\u001A\u00020,2\u0006\u0010*\u001A\u00020\u0013H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00060\u000Ej\u0002`\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001A\u00020\u0013*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u00064"}, d2={"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getSelectableId", "()J", "lock", "", "Landroidx/compose/foundation/platform/SynchronizedObject;", "Ljava/lang/Object;", "_previousTextLayoutResult", "_previousLastVisibleOffset", "", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getSelectAllSelection", "Landroidx/compose/foundation/text/selection/Selection;", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "textLayoutResult", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getLineLeft", "", "getLineRight", "getCenterYForOffset", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getLineHeight", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private int _previousLastVisibleOffset;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0 coordinatesCallback;
    private final Function0 layoutResultCallback;
    private final Object lock;
    private final long selectableId;

    static {
    }

    public MultiWidgetSelectionDelegate(long arg1, Function0 arg3, Function0 arg4) {
        super();
        this.selectableId = arg1;
        this.coordinatesCallback = arg3;
        this.layoutResultCallback = arg4;
        this.lock = this;
        this._previousLastVisibleOffset = -1;
    }

    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder arg11) {
        Object v3;
        LayoutCoordinates v0 = this.getLayoutCoordinates();
        if(v0 == null) {
        }
        else {
            v3 = this.layoutResultCallback.invoke();
            if(v3 == null) {
                return;
            }

            goto label_8;
        }

        return;
    label_8:
        long v0_1 = arg11.getContainerCoordinates().localPositionOf-R5De75A(v0, Offset.Companion.getZero-F1C5BW0());
        long v4 = Offset.minus-MK-Hz9U(arg11.getCurrentPosition-F1C5BW0(), v0_1);
        v0_1 = (arg11.getPreviousHandlePosition-F1C5BW0() & 0x7FFFFFFF7FFFFFFFL) == 0x7FC000007FC00000L ? Offset.Companion.getUnspecified-F1C5BW0() : Offset.minus-MK-Hz9U(arg11.getPreviousHandlePosition-F1C5BW0(), v0_1);
        MultiWidgetSelectionDelegateKt.appendSelectableInfo-Parwq6A(arg11, ((TextLayoutResult)v3), v4, v0_1, this.getSelectableId());
    }

    public Rect getBoundingBox(int arg4) {
        Object v3 = this.layoutResultCallback.invoke();
        if(v3 == null) {
            return Rect.Companion.getZero();
        }

        int v0 = ((TextLayoutResult)v3).getLayoutInput().getText().length();
        if(v0 < 1) {
            return Rect.Companion.getZero();
        }

        return ((TextLayoutResult)v3).getBoundingBox(RangesKt.coerceIn(arg4, 0, v0 - 1));
    }

    public float getCenterYForOffset(int arg3) {
        Object v2 = this.layoutResultCallback.invoke();
        float v0 = -1f;
        if(v2 == null) {
            return v0;
        }

        arg3 = ((TextLayoutResult)v2).getLineForOffset(arg3);
        if(arg3 >= ((TextLayoutResult)v2).getLineCount()) {
            return v0;
        }

        v0 = ((TextLayoutResult)v2).getLineTop(arg3);
        return (((TextLayoutResult)v2).getLineBottom(arg3) - v0) / 2f + v0;
    }

    public long getHandlePosition-dBAh8RU(Selection arg5, boolean arg6) {
        if((arg6) && arg5.getStart().getSelectableId() != this.getSelectableId() || !arg6 && arg5.getEnd().getSelectableId() != this.getSelectableId()) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        if(this.getLayoutCoordinates() == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        Object v0 = this.layoutResultCallback.invoke();
        if(v0 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        AnchorInfo v1 = arg6 ? arg5.getStart() : arg5.getEnd();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(((TextLayoutResult)v0), RangesKt.coerceIn(v1.getOffset(), 0, this.getLastVisibleOffset(((TextLayoutResult)v0))), arg6, arg5.getHandlesCrossed());
    }

    private final int getLastVisibleOffset(TextLayoutResult arg10) {
        int v9_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this._previousTextLayoutResult != arg10) {
                if(!arg10.getDidOverflowHeight() || (arg10.getMultiParagraph().getDidExceedMaxLines())) {
                    v1 = arg10.getLineCount() - 1;
                }
                else {
                    long v5 = 0xFFFFFFFFL;
                    int v1;
                    for(v1 = RangesKt.coerceAtMost(arg10.getLineForVerticalPosition(((float)(((int)(arg10.getSize-YbymL2g() & v5))))), arg10.getLineCount() - 1); v1 >= 0; --v1) {
                        if(arg10.getLineTop(v1) < (((float)(((int)(arg10.getSize-YbymL2g() & v5)))))) {
                            break;
                        }
                    }

                    v1 = RangesKt.coerceAtLeast(v1, 0);
                }

                this._previousLastVisibleOffset = arg10.getLineEnd(v1, true);
                this._previousTextLayoutResult = arg10;
            }

            v9_1 = this._previousLastVisibleOffset;
        }
        catch(Throwable v9) {
            __monitor_exit(v0);
            throw v9;
        }

        __monitor_exit(v0);
        return v9_1;
    }

    public int getLastVisibleOffset() {
        Object v0 = this.layoutResultCallback.invoke();
        if(v0 == null) {
            return 0;
        }

        return this.getLastVisibleOffset(((TextLayoutResult)v0));
    }

    public LayoutCoordinates getLayoutCoordinates() {
        Object v1 = this.coordinatesCallback.invoke();
        if(v1 != null) {
            if(!((LayoutCoordinates)v1).isAttached()) {
            }
            else {
                return ((LayoutCoordinates)v1);
            }
        }

        return null;
    }

    public float getLineHeight(int arg1) {
        Object v0 = this.layoutResultCallback.invoke();
        if(v0 != null) {
            return TextLayoutHelperKt.getLineHeight(((TextLayoutResult)v0), arg1);
        }

        return 0;
    }

    public float getLineLeft(int arg3) {
        Object v2 = this.layoutResultCallback.invoke();
        float v0 = -1f;
        if(v2 == null) {
            return v0;
        }

        arg3 = ((TextLayoutResult)v2).getLineForOffset(arg3);
        if(arg3 >= ((TextLayoutResult)v2).getLineCount()) {
            return v0;
        }

        return ((TextLayoutResult)v2).getLineLeft(arg3);
    }

    public float getLineRight(int arg3) {
        Object v2 = this.layoutResultCallback.invoke();
        float v0 = -1f;
        if(v2 == null) {
            return v0;
        }

        arg3 = ((TextLayoutResult)v2).getLineForOffset(arg3);
        if(arg3 >= ((TextLayoutResult)v2).getLineCount()) {
            return v0;
        }

        return ((TextLayoutResult)v2).getLineRight(arg3);
    }

    public long getRangeOfLineContaining--jx7JFs(int arg4) {
        Object v0 = this.layoutResultCallback.invoke();
        if(v0 == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        int v3 = this.getLastVisibleOffset(((TextLayoutResult)v0));
        if(v3 < 1) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        v3 = ((TextLayoutResult)v0).getLineForOffset(RangesKt.coerceIn(arg4, 0, v3 - 1));
        return TextRangeKt.TextRange(((TextLayoutResult)v0).getLineStart(v3), ((TextLayoutResult)v0).getLineEnd(v3, true));
    }

    public Selection getSelectAllSelection() {
        Object v0 = this.layoutResultCallback.invoke();
        if(v0 == null) {
            return null;
        }

        int v1 = ((TextLayoutResult)v0).getLayoutInput().getText().length();
        return new Selection(new AnchorInfo(((TextLayoutResult)v0).getBidiRunDirection(0), 0, this.getSelectableId()), new AnchorInfo(((TextLayoutResult)v0).getBidiRunDirection(Math.max(v1 - 1, 0)), v1, this.getSelectableId()), false);
    }

    public long getSelectableId() {
        return this.selectableId;
    }

    public AnnotatedString getText() {
        Object v3 = this.layoutResultCallback.invoke();
        if(v3 == null) {
            return new AnnotatedString("", null, 2, null);
        }

        return ((TextLayoutResult)v3).getLayoutInput().getText();
    }

    public TextLayoutResult textLayoutResult() {
        return this.layoutResultCallback.invoke();
    }
}

