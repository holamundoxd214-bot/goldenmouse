package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u001D\u001A\u00020\u0002H\u0016J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0002H\u0016J\f\u0010!\u001A\u00020\u001F*\u00020\"H\u0016J\t\u0010#\u001A\u00020\u0004HÆ\u0003J\t\u0010$\u001A\u00020\u0004HÆ\u0003J\t\u0010%\u001A\u00020\u0007HÆ\u0003J\u000B\u0010&\u001A\u0004\u0018\u00010\tHÆ\u0003J\u000B\u0010\'\u001A\u0004\u0018\u00010\u000BHÆ\u0003J\u0010\u0010(\u001A\u00020\rHÆ\u0003¢\u0006\u0004\b)\u0010\u001AJ\u0010\u0010*\u001A\u00020\rHÆ\u0003¢\u0006\u0004\b+\u0010\u001AJZ\u0010,\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\rHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001A\u00020\u00042\b\u00100\u001A\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001A\u000203HÖ\u0001J\t\u00104\u001A\u000205HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001A\u00020\r¢\u0006\n\n\u0002\u0010\u001B\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\u000E\u001A\u00020\r¢\u0006\n\n\u0002\u0010\u001B\u001A\u0004\b\u001C\u0010\u001A¨\u00066"}, d2={"Landroidx/compose/material3/IndicatorLineElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/IndicatorLineNode;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "textFieldShape", "Landroidx/compose/ui/graphics/Shape;", "focusedIndicatorLineThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedIndicatorLineThickness", "<init>", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getColors", "()Landroidx/compose/material3/TextFieldColors;", "getTextFieldShape", "()Landroidx/compose/ui/graphics/Shape;", "getFocusedIndicatorLineThickness-D9Ej5fM", "()F", "F", "getUnfocusedIndicatorLineThickness-D9Ej5fM", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "component7", "component7-D9Ej5fM", "copy", "copy-gv0btCI", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/material3/IndicatorLineElement;", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndicatorLineElement extends ModifierNodeElement {
    public static final int $stable;
    private final TextFieldColors colors;
    private final boolean enabled;
    private final float focusedIndicatorLineThickness;
    private final InteractionSource interactionSource;
    private final boolean isError;
    private final Shape textFieldShape;
    private final float unfocusedIndicatorLineThickness;

    static {
    }

    private IndicatorLineElement(boolean arg1, boolean arg2, InteractionSource arg3, TextFieldColors arg4, Shape arg5, float arg6, float arg7) {
        super();
        this.enabled = arg1;
        this.isError = arg2;
        this.interactionSource = arg3;
        this.colors = arg4;
        this.textFieldShape = arg5;
        this.focusedIndicatorLineThickness = arg6;
        this.unfocusedIndicatorLineThickness = arg7;
    }

    public IndicatorLineElement(boolean arg1, boolean arg2, InteractionSource arg3, TextFieldColors arg4, Shape arg5, float arg6, float arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final boolean component2() {
        return this.isError;
    }

    public final InteractionSource component3() {
        return this.interactionSource;
    }

    public final TextFieldColors component4() {
        return this.colors;
    }

    public final Shape component5() {
        return this.textFieldShape;
    }

    public final float component6-D9Ej5fM() {
        return this.focusedIndicatorLineThickness;
    }

    public final float component7-D9Ej5fM() {
        return this.unfocusedIndicatorLineThickness;
    }

    public final IndicatorLineElement copy-gv0btCI(boolean arg10, boolean arg11, InteractionSource arg12, TextFieldColors arg13, Shape arg14, float arg15, float arg16) {
        return new IndicatorLineElement(arg10, arg11, arg12, arg13, arg14, arg15, arg16, null);
    }

    public static IndicatorLineElement copy-gv0btCI$default(IndicatorLineElement arg0, boolean arg1, boolean arg2, InteractionSource arg3, TextFieldColors arg4, Shape arg5, float arg6, float arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.enabled;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.isError;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.interactionSource;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.colors;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.textFieldShape;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.focusedIndicatorLineThickness;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.unfocusedIndicatorLineThickness;
        }

        return arg0.copy-gv0btCI(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public IndicatorLineNode create() {
        return new IndicatorLineNode(this.enabled, this.isError, this.interactionSource, this.colors, this.textFieldShape, this.focusedIndicatorLineThickness, this.unfocusedIndicatorLineThickness, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((IndicatorLineElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof IndicatorLineElement)) {
            return 0;
        }

        if(this.enabled != ((IndicatorLineElement)arg5).enabled) {
            return 0;
        }

        if(this.isError != ((IndicatorLineElement)arg5).isError) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((IndicatorLineElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colors, ((IndicatorLineElement)arg5).colors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldShape, ((IndicatorLineElement)arg5).textFieldShape)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.focusedIndicatorLineThickness, ((IndicatorLineElement)arg5).focusedIndicatorLineThickness)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.unfocusedIndicatorLineThickness, ((IndicatorLineElement)arg5).unfocusedIndicatorLineThickness)) {
            return 0;
        }

        return 1;
    }

    public final TextFieldColors getColors() {
        return this.colors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getFocusedIndicatorLineThickness-D9Ej5fM() {
        return this.focusedIndicatorLineThickness;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final Shape getTextFieldShape() {
        return this.textFieldShape;
    }

    public final float getUnfocusedIndicatorLineThickness-D9Ej5fM() {
        return this.unfocusedIndicatorLineThickness;
    }

    public int hashCode() {
        int v0 = ((Boolean.hashCode(this.enabled) * 0x1F + Boolean.hashCode(this.isError)) * 0x1F + this.interactionSource.hashCode()) * 0x1F;
        TextFieldColors v1 = this.colors;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Shape v1_2 = this.textFieldShape;
        if(v1_2 == null) {
        }
        else {
            v2 = v1_2.hashCode();
        }

        return ((v0 + v2) * 0x1F + Dp.hashCode-impl(this.focusedIndicatorLineThickness)) * 0x1F + Dp.hashCode-impl(this.unfocusedIndicatorLineThickness);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("indicatorLine");
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("isError", Boolean.valueOf(this.isError));
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("colors", this.colors);
        arg4.getProperties().set("textFieldShape", this.textFieldShape);
        arg4.getProperties().set("focusedIndicatorLineThickness", Dp.box-impl(this.focusedIndicatorLineThickness));
        arg4.getProperties().set("unfocusedIndicatorLineThickness", Dp.box-impl(this.unfocusedIndicatorLineThickness));
    }

    public final boolean isError() {
        return this.isError;
    }

    public String toString() {
        return "IndicatorLineElement(enabled=" + this.enabled + ", isError=" + this.isError + ", interactionSource=" + this.interactionSource + ", colors=" + this.colors + ", textFieldShape=" + this.textFieldShape + ", focusedIndicatorLineThickness=" + Dp.toString-impl(this.focusedIndicatorLineThickness) + ", unfocusedIndicatorLineThickness=" + Dp.toString-impl(this.unfocusedIndicatorLineThickness) + ')';
    }

    public void update(IndicatorLineNode arg9) {
        arg9.update-gv0btCI(this.enabled, this.isError, this.interactionSource, this.colors, this.textFieldShape, this.focusedIndicatorLineThickness, this.unfocusedIndicatorLineThickness);
    }

    public void update(Node arg1) {
        this.update(((IndicatorLineNode)arg1));
    }
}

