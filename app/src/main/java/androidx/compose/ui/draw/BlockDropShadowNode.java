package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B(\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010@\u001A\u00020\tH\u0016J\b\u0010A\u001A\u00020\tH\u0016J\b\u0010B\u001A\u00020\tH\u0002J\'\u0010C\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00062\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nJ\f\u0010D\u001A\u00020\t*\u00020EH\u0016J\b\u0010F\u001A\u00020\u0012H\u0002J\b\u0010G\u001A\u00020\tH\u0016J\b\u0010H\u001A\u00020\tH\u0002J\u0013\u0010I\u001A\u00020\u00142\b\u0010J\u001A\u0004\u0018\u00010KH\u0096\u0002J\b\u0010L\u001A\u00020MH\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R@\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001BR$\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0019@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u001B\"\u0004\b \u0010!R$\u0010\"\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0019@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001B\"\u0004\b$\u0010!R&\u0010&\u001A\u00020%2\u0006\u0010\u0015\u001A\u00020%@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010+\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R&\u0010-\u001A\u00020,2\u0006\u0010\u0015\u001A\u00020,@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010+\u001A\u0004\b.\u0010(\"\u0004\b/\u0010*R(\u00101\u001A\u0004\u0018\u0001002\b\u0010\u0015\u001A\u0004\u0018\u000100@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0019@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u001B\"\u0004\b8\u0010!R&\u0010:\u001A\u0002092\u0006\u0010\u0015\u001A\u000209@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010?\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006N"}, d2={"Landroidx/compose/ui/draw/BlockDropShadowNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/draw/DropShadowScope;", "shape", "Landroidx/compose/ui/graphics/Shape;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;)V", "densityObject", "Landroidx/compose/ui/unit/Density;", "targetShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "blockRead", "", "value", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "radius", "getRadius", "setRadius", "(F)V", "spread", "getSpread", "setSpread", "Landroidx/compose/ui/geometry/Offset;", "offset", "getOffset-F1C5BW0", "()J", "setOffset-k-4lQ0M", "(J)V", "J", "Landroidx/compose/ui/graphics/Color;", "color", "getColor-0d7_KjU", "setColor-8_81llA", "Landroidx/compose/ui/graphics/Brush;", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "alpha", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "onAttach", "onDensityChange", "updateDensity", "update", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "obtainPainter", "onObservedReadsChanged", "invalidateShadow", "equals", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BlockDropShadowNode extends Node implements DropShadowScope, DrawModifierNode, ObserverModifierNode {
    public static final int $stable;
    private float alpha;
    private int blendMode;
    private Function1 block;
    private boolean blockRead;
    private Brush brush;
    private long color;
    private Density densityObject;
    private long offset;
    private float radius;
    private DropShadowPainter shadowPainter;
    private Shape shape;
    private float spread;
    private Shadow targetShadow;

    static {
    }

    public BlockDropShadowNode(Shape arg1, Function1 arg2) {
        super();
        this.shape = arg1;
        this.block = arg2;
        this.offset = Offset.Companion.getZero-F1C5BW0();
        this.color = Color.Companion.getBlack-0d7_KjU();
        this.alpha = 1f;
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    public static final Function1 access$getBlock$p(BlockDropShadowNode arg0) {
        return arg0.block;
    }

    public void draw(ContentDrawScope arg9) {
        Painter.draw-x_KDEd0$default(this.obtainPainter(), arg9, arg9.getSize-NH-jbRc(), 0f, null, 6, null);
        arg9.drawContent();
    }

    public boolean equals(Object arg7) {
        if(this == (((BlockDropShadowNode)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof BlockDropShadowNode)) {
            }
            else if(this.getAlpha() == ((BlockDropShadowNode)arg7).getAlpha()) {
                if(!Intrinsics.areEqual(this.shape, ((BlockDropShadowNode)arg7).shape)) {
                    return 0;
                }
                else if(this.block != ((BlockDropShadowNode)arg7).block) {
                    return 0;
                }
                else if(this.getRadius() == ((BlockDropShadowNode)arg7).getRadius() && this.getSpread() == ((BlockDropShadowNode)arg7).getSpread()) {
                    if(!Offset.equals-impl0(this.getOffset-F1C5BW0(), ((BlockDropShadowNode)arg7).getOffset-F1C5BW0())) {
                        return 0;
                    }
                    else if(!Color.equals-impl0(this.getColor-0d7_KjU(), ((BlockDropShadowNode)arg7).getColor-0d7_KjU())) {
                        return 0;
                    }
                    else if(!Intrinsics.areEqual(this.getBrush(), ((BlockDropShadowNode)arg7).getBrush())) {
                        return 0;
                    }
                    else if(!BlendMode.equals-impl0(this.getBlendMode-0nO6VwU(), ((BlockDropShadowNode)arg7).getBlendMode-0nO6VwU())) {
                        return 0;
                    }
                    else {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public Brush getBrush() {
        return this.brush;
    }

    public long getColor-0d7_KjU() {
        return this.color;
    }

    public float getDensity() {
        Density v0 = this.densityObject;
        if(v0 != null) {
            return v0.getDensity();
        }

        return 1f;
    }

    public float getFontScale() {
        Density v0 = this.densityObject;
        if(v0 != null) {
            return v0.getFontScale();
        }

        return 1f;
    }

    public long getOffset-F1C5BW0() {
        return this.offset;
    }

    public float getRadius() {
        return this.radius;
    }

    public float getSpread() {
        return this.spread;
    }

    public int hashCode() {
        int v0 = ((((((Float.hashCode(this.getAlpha()) * 0x1F + this.shape.hashCode()) * 0x1F + this.block.hashCode()) * 0x1F + Float.hashCode(this.getRadius())) * 0x1F + Float.hashCode(this.getSpread())) * 0x1F + Offset.hashCode-impl(this.getOffset-F1C5BW0())) * 0x1F + Color.hashCode-impl(this.getColor-0d7_KjU())) * 0x1F;
        Brush v1 = this.getBrush();
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (v0 + v1_1) * 0x1F + BlendMode.hashCode-impl(this.getBlendMode-0nO6VwU());
    }

    private final void invalidateShadow() {
        this.targetShadow = null;
        this.shadowPainter = null;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    private final DropShadowPainter obtainPainter() {
        if(!this.blockRead) {
            this.blockRead = true;
            ShadowKt.access$resetShadow(this);
            ObserverModifierNodeKt.observeReads(this, new BlockDropShadowNode$obtainPainter$1(this));
        }

        Shadow v0 = this.targetShadow;
        DropShadowPainter v1 = this.shadowPainter;
        Brush v4 = this.getBrush();
        float v3 = this.toDp-u2uoSUM(this.getRadius());
        float v5 = this.toDp-u2uoSUM(this.getSpread());
        long v6 = DpOffset.constructor-impl((((long)Float.floatToRawIntBits(this.toDp-u2uoSUM(Float.intBitsToFloat(((int)(this.getOffset-F1C5BW0() & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.toDp-u2uoSUM(Float.intBitsToFloat(((int)(this.getOffset-F1C5BW0() >> 0x20))))))) << 0x20);
        if(v1 != null && v0 != null && (Dp.equals-impl0(v0.getRadius-D9Ej5fM(), v3)) && (Dp.equals-impl0(v0.getSpread-D9Ej5fM(), v5)) && (Color.equals-impl0(v0.getColor-0d7_KjU(), this.getColor-0d7_KjU())) && (Intrinsics.areEqual(v0.getBrush(), v4)) && v0.getAlpha() == this.getAlpha() && (BlendMode.equals-impl0(v0.getBlendMode-0nO6VwU(), this.getBlendMode-0nO6VwU()))) {
            if(!DpOffset.equals-impl0(v0.getOffset-RKDOV3M(), v6)) {
            }
            else {
                return v1;
            }
        }

        Shadow v2 = v4 != null ? new Shadow(v3, v4, v5, v6, this.getAlpha(), this.getBlendMode-0nO6VwU(), null) : new Shadow(v3, this.getColor-0d7_KjU(), v5, v6, this.getAlpha(), this.getBlendMode-0nO6VwU(), null);
        this.targetShadow = v2;
        DropShadowPainter v0_1 = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(this.shape, v2);
        this.shadowPainter = v0_1;
        return v0_1;
    }

    public void onAttach() {
        super.onAttach();
        this.updateDensity();
    }

    public void onDensityChange() {
        if(this.isAttached()) {
            this.updateDensity();
        }
    }

    public void onObservedReadsChanged() {
        this.blockRead = false;
        this.invalidateShadow();
    }

    public void setAlpha(float arg2) {
        if(this.alpha == arg2) {
            return;
        }

        this.alpha = arg2;
        this.invalidateShadow();
    }

    public void setBlendMode-s9anfk8(int arg2) {
        if(!BlendMode.equals-impl0(this.blendMode, arg2)) {
            this.blendMode = arg2;
            this.invalidateShadow();
        }
    }

    private final void setBlock(Function1 arg2) {
        if(this.block != arg2) {
            this.block = arg2;
            this.blockRead = false;
            DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
        }
    }

    public void setBrush(Brush arg2) {
        if(!Intrinsics.areEqual(this.brush, arg2)) {
            this.brush = arg2;
            this.invalidateShadow();
        }
    }

    public void setColor-8_81llA(long arg3) {
        if(arg3 != 16) {
        }
        else {
            arg3 = Color.Companion.getBlack-0d7_KjU();
        }

        if(!Color.equals-impl0(this.color, arg3)) {
            this.color = arg3;
            this.invalidateShadow();
        }
    }

    public void setOffset-k-4lQ0M(long arg3) {
        if(!Offset.equals-impl0(this.offset, arg3)) {
            this.offset = arg3;
            DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
        }
    }

    public void setRadius(float arg2) {
        if(this.radius == arg2) {
            return;
        }

        this.radius = arg2;
        this.invalidateShadow();
    }

    public void setSpread(float arg2) {
        if(this.spread == arg2) {
            return;
        }

        this.spread = arg2;
        this.invalidateShadow();
    }

    public final void update(Shape arg1, Function1 arg2) {
        this.shape = arg1;
        this.setBlock(arg2);
    }

    private final void updateDensity() {
        Density v0 = DelegatableNodeKt.requireDensity(this);
        if(!Intrinsics.areEqual(this.densityObject, v0)) {
            this.densityObject = v0;
            this.blockRead = false;
            this.invalidateShadow();
        }
    }
}

