package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u001D\u001A\u00020\u0002H\u0016J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0002H\u0016J\f\u0010!\u001A\u00020\u001F*\u00020\"H\u0016J\t\u0010#\u001A\u00020\u0004HÆ\u0003J\t\u0010$\u001A\u00020\u0006HÆ\u0003J\t\u0010%\u001A\u00020\bHÆ\u0003J\t\u0010&\u001A\u00020\nHÆ\u0003J\t\u0010\'\u001A\u00020\fHÆ\u0003J\u000B\u0010(\u001A\u0004\u0018\u00010\u000EHÆ\u0003JG\u0010)\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EHÆ\u0001J\u0013\u0010*\u001A\u00020\u00062\b\u0010+\u001A\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001A\u00020.HÖ\u0001J\t\u0010/\u001A\u000200HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001C¨\u00061"}, d2={"Landroidx/compose/ui/draw/PainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/PainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PainterElement extends ModifierNodeElement {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public PainterElement(Painter arg1, boolean arg2, Alignment arg3, ContentScale arg4, float arg5, ColorFilter arg6) {
        super();
        this.painter = arg1;
        this.sizeToIntrinsics = arg2;
        this.alignment = arg3;
        this.contentScale = arg4;
        this.alpha = arg5;
        this.colorFilter = arg6;
    }

    public final Painter component1() {
        return this.painter;
    }

    public final boolean component2() {
        return this.sizeToIntrinsics;
    }

    public final Alignment component3() {
        return this.alignment;
    }

    public final ContentScale component4() {
        return this.contentScale;
    }

    public final float component5() {
        return this.alpha;
    }

    public final ColorFilter component6() {
        return this.colorFilter;
    }

    public final PainterElement copy(Painter arg1, boolean arg2, Alignment arg3, ContentScale arg4, float arg5, ColorFilter arg6) {
        return new PainterElement(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static PainterElement copy$default(PainterElement arg0, Painter arg1, boolean arg2, Alignment arg3, ContentScale arg4, float arg5, ColorFilter arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.painter;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.sizeToIntrinsics;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.alignment;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.contentScale;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.alpha;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.colorFilter;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public Node create() {
        return this.create();
    }

    public PainterNode create() {
        return new PainterNode(this.painter, this.sizeToIntrinsics, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    public boolean equals(Object arg5) {
        if(this == (((PainterElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PainterElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.painter, ((PainterElement)arg5).painter)) {
            return 0;
        }

        if(this.sizeToIntrinsics != ((PainterElement)arg5).sizeToIntrinsics) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.alignment, ((PainterElement)arg5).alignment)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.contentScale, ((PainterElement)arg5).contentScale)) {
            return 0;
        }

        if(Float.compare(this.alpha, ((PainterElement)arg5).alpha) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colorFilter, ((PainterElement)arg5).colorFilter)) {
            return 0;
        }

        return 1;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public int hashCode() {
        int v0 = ((((this.painter.hashCode() * 0x1F + Boolean.hashCode(this.sizeToIntrinsics)) * 0x1F + this.alignment.hashCode()) * 0x1F + this.contentScale.hashCode()) * 0x1F + Float.hashCode(this.alpha)) * 0x1F;
        ColorFilter v2 = this.colorFilter;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("paint");
        arg4.getProperties().set("painter", this.painter);
        arg4.getProperties().set("sizeToIntrinsics", Boolean.valueOf(this.sizeToIntrinsics));
        arg4.getProperties().set("alignment", this.alignment);
        arg4.getProperties().set("contentScale", this.contentScale);
        arg4.getProperties().set("alpha", Float.valueOf(this.alpha));
        arg4.getProperties().set("colorFilter", this.colorFilter);
    }

    public String toString() {
        return "PainterElement(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public void update(Node arg1) {
        this.update(((PainterNode)arg1));
    }

    public void update(PainterNode arg5) {
        int v0_1;
        boolean v0 = arg5.getSizeToIntrinsics();
        boolean v1 = this.sizeToIntrinsics;
        if(v0 == v1) {
            if((v1) && !Size.equals-impl0(arg5.getPainter().getIntrinsicSize-NH-jbRc(), this.painter.getIntrinsicSize-NH-jbRc())) {
                goto label_13;
            }

            v0_1 = 0;
        }
        else {
        label_13:
            v0_1 = 1;
        }

        arg5.setPainter(this.painter);
        arg5.setSizeToIntrinsics(this.sizeToIntrinsics);
        arg5.setAlignment(this.alignment);
        arg5.setContentScale(this.contentScale);
        arg5.setAlpha(this.alpha);
        arg5.setColorFilter(this.colorFilter);
        if(v0_1 != 0) {
            LayoutModifierNodeKt.invalidateMeasurement(arg5);
        }

        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)arg5));
    }
}

