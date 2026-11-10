package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0019\u001A\u0013\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0\u001A¢\u0006\u0002\b\u001DH\u0002J\b\u0010\u001E\u001A\u00020\u0002H\u0016J\u0010\u0010\u001F\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u0002H\u0016J\f\u0010!\u001A\u00020\u001C*\u00020\"H\u0016J\u0010\u0010#\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b$\u0010\u000FJ\t\u0010%\u001A\u00020\u0006HÆ\u0003J\t\u0010&\u001A\u00020\bHÆ\u0003J\u0010\u0010\'\u001A\u00020\nHÆ\u0003¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001A\u00020\nHÆ\u0003¢\u0006\u0004\b*\u0010\u0016JB\u0010+\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\nHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001A\u00020\b2\b\u0010/\u001A\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001A\u000202HÖ\u0001J\t\u00103\u001A\u000204HÖ\u0001R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001A\u00020\n¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000B\u001A\u00020\n¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0018\u0010\u0016¨\u00065"}, d2={"Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/BlockGraphicsLayerModifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "<init>", "(FLandroidx/compose/ui/graphics/Shape;ZJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElevation-D9Ej5fM", "()F", "F", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getClip", "()Z", "getAmbientColor-0d7_KjU", "()J", "J", "getSpotColor-0d7_KjU", "createBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component1-D9Ej5fM", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "copy", "copy-gNMxBKI", "(FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/draw/ShadowGraphicsLayerElement;", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ShadowGraphicsLayerElement extends ModifierNodeElement {
    public static final int $stable;
    private final long ambientColor;
    private final boolean clip;
    private final float elevation;
    private final Shape shape;
    private final long spotColor;

    static {
    }

    private ShadowGraphicsLayerElement(float arg1, Shape arg2, boolean arg3, long arg4, long arg6) {
        super();
        this.elevation = arg1;
        this.shape = arg2;
        this.clip = arg3;
        this.ambientColor = arg4;
        this.spotColor = arg6;
    }

    public ShadowGraphicsLayerElement(float arg1, Shape arg2, boolean arg3, long arg4, long arg6, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg6);
    }

    public final float component1-D9Ej5fM() {
        return this.elevation;
    }

    public final Shape component2() {
        return this.shape;
    }

    public final boolean component3() {
        return this.clip;
    }

    public final long component4-0d7_KjU() {
        return this.ambientColor;
    }

    public final long component5-0d7_KjU() {
        return this.spotColor;
    }

    public final ShadowGraphicsLayerElement copy-gNMxBKI(float arg10, Shape arg11, boolean arg12, long arg13, long arg15) {
        return new ShadowGraphicsLayerElement(arg10, arg11, arg12, arg13, arg15, null);
    }

    public static ShadowGraphicsLayerElement copy-gNMxBKI$default(ShadowGraphicsLayerElement arg0, float arg1, Shape arg2, boolean arg3, long arg4, long arg6, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.elevation;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.shape;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.clip;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.ambientColor;
        }

        if((arg8 & 16) != 0) {
            arg6 = arg0.spotColor;
        }

        return arg0.copy-gNMxBKI(arg1, arg2, arg3, arg4, arg6);
    }

    public Node create() {
        return this.create();
    }

    public BlockGraphicsLayerModifier create() {
        return new BlockGraphicsLayerModifier(this.createBlock());
    }

    private final Function1 createBlock() {
        return new ShadowGraphicsLayerElement$createBlock$1(this);
    }

    public boolean equals(Object arg8) {
        if(this == (((ShadowGraphicsLayerElement)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof ShadowGraphicsLayerElement)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.elevation, ((ShadowGraphicsLayerElement)arg8).elevation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((ShadowGraphicsLayerElement)arg8).shape)) {
            return 0;
        }

        if(this.clip != ((ShadowGraphicsLayerElement)arg8).clip) {
            return 0;
        }

        if(!Color.equals-impl0(this.ambientColor, ((ShadowGraphicsLayerElement)arg8).ambientColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.spotColor, ((ShadowGraphicsLayerElement)arg8).spotColor)) {
            return 0;
        }

        return 1;
    }

    public final long getAmbientColor-0d7_KjU() {
        return this.ambientColor;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final long getSpotColor-0d7_KjU() {
        return this.spotColor;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.elevation) * 0x1F + this.shape.hashCode()) * 0x1F + Boolean.hashCode(this.clip)) * 0x1F + Color.hashCode-impl(this.ambientColor)) * 0x1F + Color.hashCode-impl(this.spotColor);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("shadow");
        arg4.getProperties().set("elevation", Dp.box-impl(this.elevation));
        arg4.getProperties().set("shape", this.shape);
        arg4.getProperties().set("clip", Boolean.valueOf(this.clip));
        arg4.getProperties().set("ambientColor", Color.box-impl(this.ambientColor));
        arg4.getProperties().set("spotColor", Color.box-impl(this.spotColor));
    }

    public String toString() {
        return "ShadowGraphicsLayerElement(elevation=" + Dp.toString-impl(this.elevation) + ", shape=" + this.shape + ", clip=" + this.clip + ", ambientColor=" + Color.toString-impl(this.ambientColor) + ", spotColor=" + Color.toString-impl(this.spotColor) + ')';
    }

    public void update(Node arg1) {
        this.update(((BlockGraphicsLayerModifier)arg1));
    }

    public void update(BlockGraphicsLayerModifier arg1) {
        arg1.setLayerBlock(this.createBlock());
        arg1.invalidateLayerBlock();
    }
}

