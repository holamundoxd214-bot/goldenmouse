package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nH\u0002J\u0018\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rH\u0002J\b\u0010\u0011\u001A\u00020\bH\u0002J7\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ7\u0010\u001F\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001A\u00020#2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\u0018\u0010$\u001A\u00020%2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010&\u001A\u00020\'H\u0016R\"\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0004\u0018\u0001`\nX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u000B\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext;", "Landroidx/compose/ui/graphics/shadow/PlatformShadowContext;", "Landroidx/compose/ui/graphics/shadow/DropShadowRendererProvider;", "Landroidx/compose/ui/graphics/shadow/InnerShadowRendererProvider;", "<init>", "()V", "dropShadowCache", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/DropShadowCache;", "innerShadowCache", "Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/InnerShadowCache;", "shadowKey", "obtainDropShadowCache", "obtainInnerShadowCache", "obtainShadowKey", "obtainDropShadowRenderer", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "obtainDropShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "obtainInnerShadowRenderer", "obtainInnerShadowRenderer-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "createDropShadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "createInnerShadowPainter", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "clearCache", "", "ShadowKey", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidShadowContext implements DropShadowRendererProvider, InnerShadowRendererProvider, PlatformShadowContext {
    @Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001A\u00020\u0003HÆ\u0003J\u0010\u0010$\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b%\u0010\u0013J\t\u0010&\u001A\u00020\u0007HÆ\u0003J\t\u0010\'\u001A\u00020\tHÆ\u0003J\u000B\u0010(\u001A\u0004\u0018\u00010\u000BHÆ\u0003JD\u0010)\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001A\u00020-2\b\u0010.\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001A\u000200HÖ\u0001J\t\u00101\u001A\u000202HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u00063"}, d2={"Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "<init>", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getDensity", "()F", "setDensity", "(F)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "setShadow", "(Landroidx/compose/ui/graphics/shadow/Shadow;)V", "component1", "component2", "component2-NH-jbRc", "component3", "component4", "component5", "copy", "copy-eZhPAX0", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;FLandroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/graphics/shadow/AndroidShadowContext$ShadowKey;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShadowKey {
        public static final int $stable = 8;
        private float density;
        private LayoutDirection layoutDirection;
        private Shadow shadow;
        private Shape shape;
        private long size;

        static {
        }

        public ShadowKey(Shape arg8, long arg9, LayoutDirection arg11, float arg12, Shadow arg13, int arg14, DefaultConstructorMarker arg15) {
            Shape v0 = (arg14 & 1) != 0 ? RectangleShapeKt.getRectangleShape() : arg8;
            long v1 = (arg14 & 2) != 0 ? Size.Companion.getZero-NH-jbRc() : arg9;
            LayoutDirection v3 = (arg14 & 4) != 0 ? LayoutDirection.Ltr : arg11;
            float v4 = (arg14 & 8) != 0 ? 1f : arg12;
            Shadow v5 = (arg14 & 16) != 0 ? null : arg13;
            this(v0, v1, v3, v4, v5, null);
        }

        private ShadowKey(Shape arg1, long arg2, LayoutDirection arg4, float arg5, Shadow arg6) {
            super();
            this.shape = arg1;
            this.size = arg2;
            this.layoutDirection = arg4;
            this.density = arg5;
            this.shadow = arg6;
        }

        public ShadowKey(Shape arg1, long arg2, LayoutDirection arg4, float arg5, Shadow arg6, DefaultConstructorMarker arg7) {
            this(arg1, arg2, arg4, arg5, arg6);
        }

        public final Shape component1() {
            return this.shape;
        }

        public final long component2-NH-jbRc() {
            return this.size;
        }

        public final LayoutDirection component3() {
            return this.layoutDirection;
        }

        public final float component4() {
            return this.density;
        }

        public final Shadow component5() {
            return this.shadow;
        }

        public final ShadowKey copy-eZhPAX0(Shape arg9, long arg10, LayoutDirection arg12, float arg13, Shadow arg14) {
            return new ShadowKey(arg9, arg10, arg12, arg13, arg14, null);
        }

        public static ShadowKey copy-eZhPAX0$default(ShadowKey arg0, Shape arg1, long arg2, LayoutDirection arg4, float arg5, Shadow arg6, int arg7, Object arg8) {
            if((arg7 & 1) != 0) {
                arg1 = arg0.shape;
            }

            if((arg7 & 2) != 0) {
                arg2 = arg0.size;
            }

            if((arg7 & 4) != 0) {
                arg4 = arg0.layoutDirection;
            }

            if((arg7 & 8) != 0) {
                arg5 = arg0.density;
            }

            if((arg7 & 16) != 0) {
                arg6 = arg0.shadow;
            }

            return arg0.copy-eZhPAX0(arg1, arg2, arg4, arg5, arg6);
        }

        public boolean equals(Object arg8) {
            if(this == (((ShadowKey)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof ShadowKey)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.shape, ((ShadowKey)arg8).shape)) {
                return 0;
            }

            if(!Size.equals-impl0(this.size, ((ShadowKey)arg8).size)) {
                return 0;
            }

            if(this.layoutDirection != ((ShadowKey)arg8).layoutDirection) {
                return 0;
            }

            if(Float.compare(this.density, ((ShadowKey)arg8).density) != 0) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.shadow, ((ShadowKey)arg8).shadow)) {
                return 0;
            }

            return 1;
        }

        public final float getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final Shadow getShadow() {
            return this.shadow;
        }

        public final Shape getShape() {
            return this.shape;
        }

        public final long getSize-NH-jbRc() {
            return this.size;
        }

        public int hashCode() {
            int v0 = (((this.shape.hashCode() * 0x1F + Size.hashCode-impl(this.size)) * 0x1F + this.layoutDirection.hashCode()) * 0x1F + Float.hashCode(this.density)) * 0x1F;
            Shadow v3 = this.shadow;
            int v3_1 = v3 == null ? 0 : v3.hashCode();
            return v0 + v3_1;
        }

        public final void setDensity(float arg1) {
            this.density = arg1;
        }

        public final void setLayoutDirection(LayoutDirection arg1) {
            this.layoutDirection = arg1;
        }

        public final void setShadow(Shadow arg1) {
            this.shadow = arg1;
        }

        public final void setShape(Shape arg1) {
            this.shape = arg1;
        }

        public final void setSize-uvyYCjk(long arg1) {
            this.size = arg1;
        }

        public String toString() {
            return "ShadowKey(shape=" + this.shape + ", size=" + Size.toString-impl(this.size) + ", layoutDirection=" + this.layoutDirection + ", density=" + this.density + ", shadow=" + this.shadow + ')';
        }
    }

    private MutableScatterMap dropShadowCache;
    private MutableScatterMap innerShadowCache;
    private ShadowKey shadowKey;

    public AndroidShadowContext() {
        super();
    }

    public void clearCache() {
        __monitor_enter(this);
        try {
            MutableScatterMap v0_1 = this.dropShadowCache;
            if(v0_1 != null) {
                v0_1.clear();
            }

            v0_1 = this.innerShadowCache;
            if(v0_1 != null) {
                v0_1.clear();
            }

            this.shadowKey = null;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }

    public DropShadowPainter createDropShadowPainter(Shape arg2, Shadow arg3) {
        return new DropShadowPainter(arg2, arg3, ((DropShadowRendererProvider)this));
    }

    public InnerShadowPainter createInnerShadowPainter(Shape arg2, Shadow arg3) {
        return new InnerShadowPainter(arg2, arg3, ((InnerShadowRendererProvider)this));
    }

    private final MutableScatterMap obtainDropShadowCache() {
        MutableScatterMap v0 = this.dropShadowCache;
        if(v0 == null) {
            v0 = new MutableScatterMap(0, 1, null);
            this.dropShadowCache = v0;
        }

        return v0;
    }

    public DropShadowRenderer obtainDropShadowRenderer-eZhPAX0(Shape arg10, long arg11, LayoutDirection arg13, Density arg14, Shadow arg15) {
        DropShadowRenderer v1_1;
        __monitor_enter(this);
        try {
            ShadowKey v0_1 = this.obtainShadowKey();
            v0_1.setShape(arg10);
            v0_1.setSize-uvyYCjk(arg11);
            v0_1.setLayoutDirection(arg13);
            v0_1.setDensity(arg14.getDensity());
            v0_1.setShadow(arg15.copyWithoutOffset$ui_graphics());
            Object v1 = this.obtainDropShadowCache().get(v0_1);
            if(v1 == null) {
                DropShadowRenderer v11 = new DropShadowRenderer(arg15, arg10.createOutline-Pq9zytI(arg11, arg13, arg14));
                this.obtainDropShadowCache().set(ShadowKey.copy-eZhPAX0$default(v0_1, null, 0, null, 0f, null, 0x1F, null), v11);
                v1_1 = v11;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v1_1;
    }

    private final MutableScatterMap obtainInnerShadowCache() {
        MutableScatterMap v0 = this.innerShadowCache;
        if(v0 == null) {
            v0 = new MutableScatterMap(0, 1, null);
            this.innerShadowCache = v0;
        }

        return v0;
    }

    public InnerShadowRenderer obtainInnerShadowRenderer-eZhPAX0(Shape arg10, long arg11, LayoutDirection arg13, Density arg14, Shadow arg15) {
        Object v1;
        __monitor_enter(this);
        try {
            ShadowKey v0_1 = this.obtainShadowKey();
            v0_1.setShape(arg10);
            v0_1.setSize-uvyYCjk(arg11);
            v0_1.setLayoutDirection(arg13);
            v0_1.setDensity(arg14.getDensity());
            v0_1.setShadow(arg15);
            v1 = this.obtainInnerShadowCache().get(v0_1);
            if(v1 == null) {
                InnerShadowRenderer v11 = new InnerShadowRenderer(arg15, arg10.createOutline-Pq9zytI(arg11, arg13, arg14));
                this.obtainInnerShadowCache().set(ShadowKey.copy-eZhPAX0$default(v0_1, null, 0, null, 0f, null, 0x1F, null), v11);
                InnerShadowRenderer v1_1 = v11;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return ((InnerShadowRenderer)v1);
    }

    private final ShadowKey obtainShadowKey() {
        ShadowKey v0 = this.shadowKey;
        if(v0 == null) {
            ShadowKey v1 = new ShadowKey(null, 0, null, 0f, null, 0x1F, null);
            this.shadowKey = v1;
            return v1;
        }

        return v0;
    }
}

