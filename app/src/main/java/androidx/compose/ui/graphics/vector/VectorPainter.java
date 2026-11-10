package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010@\u001A\u000204*\u00020AH\u0014J\u0010\u0010B\u001A\u00020\u000F2\u0006\u0010C\u001A\u00020<H\u0014J\u0012\u0010D\u001A\u00020\u000F2\b\u0010E\u001A\u0004\u0018\u00010\u0017H\u0014R+\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR+\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0006\u001A\u00020\u000F8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00178@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00078@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\n\"\u0004\b\u001F\u0010\fR$\u0010!\u001A\u00020 2\u0006\u0010\u0016\u001A\u00020 8@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\'X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020+8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b,\u0010-R\u001C\u0010.\u001A\u0004\u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R+\u00105\u001A\u0002042\u0006\u0010\u0006\u001A\u0002048B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b:\u0010\u000E\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u000E\u0010;\u001A\u00020<X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010=\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010>\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b?\u0010\n¨\u0006F"}, d2={"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc$ui", "()J", "setSize-uvyYCjk$ui", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "", "autoMirror", "getAutoMirror$ui", "()Z", "setAutoMirror$ui", "(Z)V", "autoMirror$delegate", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "viewportSize", "getViewportSize-NH-jbRc$ui", "setViewportSize-uvyYCjk$ui", "", "name", "getName$ui", "()Ljava/lang/String;", "setName$ui", "(Ljava/lang/String;)V", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getBitmapConfig-_sVssgQ$ui", "()I", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui", "()Landroidx/compose/runtime/Composition;", "setComposition$ui", "(Landroidx/compose/runtime/Composition;)V", "", "drawInvalidation", "getDrawInvalidation", "()Lkotlin/Unit;", "setDrawInvalidation", "(Lkotlin/Unit;)V", "drawInvalidation$delegate", "currentAlpha", "", "currentColorFilter", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorPainter extends Painter {
    public static final int $stable = 8;
    private final MutableState autoMirror$delegate;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private final MutableState drawInvalidation$delegate;
    private final MutableState size$delegate;
    private final VectorComponent vector;

    static {
    }

    public VectorPainter() {
        this(null, 1, null);
    }

    public VectorPainter(GroupComponent arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new GroupComponent();
        }

        this(arg1);
    }

    public VectorPainter(GroupComponent arg4) {
        super();
        this.size$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), null, 2, null);
        this.autoMirror$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        VectorComponent v0 = new VectorComponent(arg4);
        v0.setInvalidateCallback$ui(new VectorPainter$vector$1$1(this));
        this.vector = v0;
        this.drawInvalidation$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.currentAlpha = 1f;
    }

    public static final void access$setDrawInvalidation(VectorPainter arg0, Unit arg1) {
        arg0.setDrawInvalidation(arg1);
    }

    protected boolean applyAlpha(float arg1) {
        this.currentAlpha = arg1;
        return 1;
    }

    protected boolean applyColorFilter(ColorFilter arg1) {
        this.currentColorFilter = arg1;
        return 1;
    }

    public final boolean getAutoMirror$ui() {
        return this.autoMirror$delegate.getValue().booleanValue();
    }

    public final int getBitmapConfig-_sVssgQ$ui() {
        return this.vector.getCacheBitmapConfig-_sVssgQ$ui();
    }

    public final Composition getComposition$ui() {
        return this.composition;
    }

    private final Unit getDrawInvalidation() {
        this.drawInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }

    public final ColorFilter getIntrinsicColorFilter$ui() {
        return this.vector.getIntrinsicColorFilter$ui();
    }

    public long getIntrinsicSize-NH-jbRc() {
        return this.getSize-NH-jbRc$ui();
    }

    public final String getName$ui() {
        return this.vector.getName();
    }

    public final long getSize-NH-jbRc$ui() {
        return this.size$delegate.getValue().unbox-impl();
    }

    public final VectorComponent getVector$ui() {
        return this.vector;
    }

    public final long getViewportSize-NH-jbRc$ui() {
        return this.vector.getViewportSize-NH-jbRc$ui();
    }

    protected void onDraw(DrawScope arg11) {
        VectorComponent v0 = this.vector;
        ColorFilter v1 = this.currentColorFilter;
        if(v1 == null) {
            v1 = v0.getIntrinsicColorFilter$ui();
        }

        if(!this.getAutoMirror$ui() || arg11.getLayoutDirection() != LayoutDirection.Rtl) {
            v0.draw(arg11, this.currentAlpha, v1);
        }
        else {
            long v2 = arg11.getCenter-F1C5BW0();
            DrawContext v4 = arg11.getDrawContext();
            long v5 = v4.getSize-NH-jbRc();
            v4.getCanvas().save();
            try {
                v4.getTransform().scale-0AR0LA0(-1f, 1f, v2);
                v0.draw(arg11, this.currentAlpha, v1);
            }
            catch(Throwable v10) {
                v4.getCanvas().restore();
                v4.setSize-uvyYCjk(v5);
                throw v10;
            }

            v4.getCanvas().restore();
            v4.setSize-uvyYCjk(v5);
        }

        this.getDrawInvalidation();
    }

    public final void setAutoMirror$ui(boolean arg1) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setComposition$ui(Composition arg1) {
        this.composition = arg1;
    }

    private final void setDrawInvalidation(Unit arg1) {
        this.drawInvalidation$delegate.setValue(arg1);
    }

    public final void setIntrinsicColorFilter$ui(ColorFilter arg1) {
        this.vector.setIntrinsicColorFilter$ui(arg1);
    }

    public final void setName$ui(String arg1) {
        this.vector.setName(arg1);
    }

    public final void setSize-uvyYCjk$ui(long arg1) {
        this.size$delegate.setValue(Size.box-impl(arg1));
    }

    public final void setViewportSize-uvyYCjk$ui(long arg1) {
        this.vector.setViewportSize-uvyYCjk$ui(arg1);
    }
}

