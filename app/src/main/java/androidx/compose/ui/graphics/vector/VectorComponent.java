package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter$Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000E\u001A\u00020\u000FH\u0002J\u001C\u00108\u001A\u00020\u000F*\u0002062\u0006\u00109\u001A\u0002022\b\u0010:\u001A\u0004\u0018\u00010\u001FJ\f\u00108\u001A\u00020\u000F*\u000206H\u0016J\b\u0010;\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0019X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR/\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001F8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010\'\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010)\u001A\u00020(2\u0006\u0010\u001E\u001A\u00020(8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b.\u0010&\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0010\u0010/\u001A\u00020(X\u0082\u000E¢\u0006\u0004\n\u0002\u00100R\u000E\u00101\u001A\u000202X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u000202X\u0082\u000E¢\u0006\u0002\n\u0000R\u001F\u00104\u001A\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000F05¢\u0006\u0002\b7X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2={"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "doInvalidate", "", "isDirty", "", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "cacheBitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getCacheBitmapConfig-_sVssgQ$ui", "()I", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "tintFilter", "Landroidx/compose/ui/geometry/Size;", "viewportSize", "getViewportSize-NH-jbRc$ui", "()J", "setViewportSize-uvyYCjk$ui", "(J)V", "viewportSize$delegate", "previousDrawSize", "J", "rootScaleX", "", "rootScaleY", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "draw", "alpha", "colorFilter", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VectorComponent extends VNode {
    public static final int $stable = 8;
    private final DrawCache cacheDrawScope;
    private final Function1 drawVectorBlock;
    private final MutableState intrinsicColorFilter$delegate;
    private Function0 invalidateCallback;
    private boolean isDirty;
    private String name;
    private long previousDrawSize;
    private final GroupComponent root;
    private float rootScaleX;
    private float rootScaleY;
    private ColorFilter tintFilter;
    private final MutableState viewportSize$delegate;

    static {
    }

    public VectorComponent(GroupComponent arg4) {
        super(null);
        this.root = arg4;
        arg4.setInvalidateListener$ui(new Function1() {
            public Object invoke(Object arg1) {
                this.invoke(((VNode)arg1));
                return Unit.INSTANCE;
            }

            public final void invoke(VNode arg1) {
                VectorComponent.access$doInvalidate(VectorComponent.this);
            }
        });
        this.name = "";
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
        this.intrinsicColorFilter$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewportSize$delegate = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), null, 2, null);
        this.previousDrawSize = Size.Companion.getUnspecified-NH-jbRc();
        this.rootScaleX = 1f;
        this.rootScaleY = 1f;
        this.drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    }

    public static final void access$doInvalidate(VectorComponent arg0) {
        arg0.doInvalidate();
    }

    public static final float access$getRootScaleX$p(VectorComponent arg0) {
        return arg0.rootScaleX;
    }

    public static final float access$getRootScaleY$p(VectorComponent arg0) {
        return arg0.rootScaleY;
    }

    private final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public void draw(DrawScope arg3) {
        this.draw(arg3, 1f, null);
    }

    public final void draw(DrawScope arg12, float arg13, ColorFilter arg14) {
        int v0 = !this.root.isTintable() || this.root.getTintColor-0d7_KjU() == 16 || !VectorKt.tintableWithAlphaMask(this.getIntrinsicColorFilter$ui()) || !VectorKt.tintableWithAlphaMask(arg14) ? ImageBitmapConfig.Companion.getArgb8888-_sVssgQ() : ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
        int v2 = v0;
        if((this.isDirty) || !Size.equals-impl0(this.previousDrawSize, arg12.getSize-NH-jbRc()) || !ImageBitmapConfig.equals-impl0(v2, this.getCacheBitmapConfig-_sVssgQ$ui())) {
            ColorFilter v0_1 = ImageBitmapConfig.equals-impl0(v2, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ()) ? Companion.tint-xETnrds$default(ColorFilter.Companion, VectorKt.toOpaque-8_81llA(this.root.getTintColor-0d7_KjU()), 0, 2, null) : null;
            this.tintFilter = v0_1;
            this.rootScaleX = Float.intBitsToFloat(((int)(arg12.getSize-NH-jbRc() >> 0x20))) / Float.intBitsToFloat(((int)(this.getViewportSize-NH-jbRc$ui() >> 0x20)));
            this.rootScaleY = Float.intBitsToFloat(((int)(arg12.getSize-NH-jbRc() & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(this.getViewportSize-NH-jbRc$ui() & 0xFFFFFFFFL)));
            this.cacheDrawScope.drawCachedImage-FqjB98A(v2, IntSize.constructor-impl((((long)(((int)(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg12.getSize-NH-jbRc() & 0xFFFFFFFFL))))))))))) & 0xFFFFFFFFL | (((long)(((int)(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg12.getSize-NH-jbRc() >> 0x20))))))))))) << 0x20), arg12, arg12.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = arg12.getSize-NH-jbRc();
        }

        if(arg14 != null) {
        }
        else if(this.getIntrinsicColorFilter$ui() != null) {
            arg14 = this.getIntrinsicColorFilter$ui();
        }
        else {
            arg14 = this.tintFilter;
        }

        this.cacheDrawScope.drawInto(arg12, arg13, arg14);
    }

    public final int getCacheBitmapConfig-_sVssgQ$ui() {
        ImageBitmap v0 = this.cacheDrawScope.getMCachedImage();
        if(v0 != null) {
            return v0.getConfig-_sVssgQ();
        }

        return ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
    }

    public final ColorFilter getIntrinsicColorFilter$ui() {
        return this.intrinsicColorFilter$delegate.getValue();
    }

    public final Function0 getInvalidateCallback$ui() {
        return this.invalidateCallback;
    }

    public final String getName() {
        return this.name;
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    public final long getViewportSize-NH-jbRc$ui() {
        return this.viewportSize$delegate.getValue().unbox-impl();
    }

    public final void setIntrinsicColorFilter$ui(ColorFilter arg1) {
        this.intrinsicColorFilter$delegate.setValue(arg1);
    }

    public final void setInvalidateCallback$ui(Function0 arg1) {
        this.invalidateCallback = arg1;
    }

    public final void setName(String arg1) {
        this.name = arg1;
    }

    public final void setViewportSize-uvyYCjk$ui(long arg1) {
        this.viewportSize$delegate.setValue(Size.box-impl(arg1));
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("Params: \tname: ");
        v0.append(this.name).append("\n\tviewportWidth: ");
        v0.append(Float.intBitsToFloat(((int)(this.getViewportSize-NH-jbRc$ui() >> 0x20)))).append("\n\tviewportHeight: ");
        v0.append(Float.intBitsToFloat(((int)(this.getViewportSize-NH-jbRc$ui() & 0xFFFFFFFFL)))).append("\n");
        String v5 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }
}

