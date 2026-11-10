package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u0004\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001A\u00020\u0002H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0002H\u0016J\f\u0010\u001D\u001A\u00020\u001B*\u00020\u001EH\u0016J\t\u0010\u001F\u001A\u00020\u0004HÂ\u0003J\t\u0010 \u001A\u00020\u0004HÂ\u0003J\t\u0010!\u001A\u00020\u0007HÂ\u0003J\t\u0010\"\u001A\u00020\tHÂ\u0003J\t\u0010#\u001A\u00020\u000BHÂ\u0003J\t\u0010$\u001A\u00020\rHÂ\u0003J\t\u0010%\u001A\u00020\u0004HÂ\u0003J\t\u0010&\u001A\u00020\u0010HÂ\u0003J\t\u0010\'\u001A\u00020\u0012HÂ\u0003J\t\u0010(\u001A\u00020\u0014HÂ\u0003J\u000B\u0010)\u001A\u0004\u0018\u00010\u0016HÂ\u0003Jy\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u00042\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010+\u001A\u00020\u00042\b\u0010,\u001A\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001A\u00020/HÖ\u0001J\t\u00100\u001A\u000201HÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "<init>", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldCoreModifier extends ModifierNodeElement {
    public static final int $stable;
    private final Brush cursorBrush;
    private final boolean isDragHovered;
    private final boolean isFocused;
    private final Orientation orientation;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final ToolbarRequester toolbarRequester;
    private final boolean writeable;

    static {
    }

    public TextFieldCoreModifier(boolean arg1, boolean arg2, TextLayoutState arg3, TransformedTextFieldState arg4, TextFieldSelectionState arg5, Brush arg6, boolean arg7, ScrollState arg8, Orientation arg9, ToolbarRequester arg10, PlatformSelectionBehaviors arg11) {
        super();
        this.isFocused = arg1;
        this.isDragHovered = arg2;
        this.textLayoutState = arg3;
        this.textFieldState = arg4;
        this.textFieldSelectionState = arg5;
        this.cursorBrush = arg6;
        this.writeable = arg7;
        this.scrollState = arg8;
        this.orientation = arg9;
        this.toolbarRequester = arg10;
        this.platformSelectionBehaviors = arg11;
    }

    private final boolean component1() {
        return this.isFocused;
    }

    private final ToolbarRequester component10() {
        return this.toolbarRequester;
    }

    private final PlatformSelectionBehaviors component11() {
        return this.platformSelectionBehaviors;
    }

    private final boolean component2() {
        return this.isDragHovered;
    }

    private final TextLayoutState component3() {
        return this.textLayoutState;
    }

    private final TransformedTextFieldState component4() {
        return this.textFieldState;
    }

    private final TextFieldSelectionState component5() {
        return this.textFieldSelectionState;
    }

    private final Brush component6() {
        return this.cursorBrush;
    }

    private final boolean component7() {
        return this.writeable;
    }

    private final ScrollState component8() {
        return this.scrollState;
    }

    private final Orientation component9() {
        return this.orientation;
    }

    public final TextFieldCoreModifier copy(boolean arg1, boolean arg2, TextLayoutState arg3, TransformedTextFieldState arg4, TextFieldSelectionState arg5, Brush arg6, boolean arg7, ScrollState arg8, Orientation arg9, ToolbarRequester arg10, PlatformSelectionBehaviors arg11) {
        return new TextFieldCoreModifier(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static TextFieldCoreModifier copy$default(TextFieldCoreModifier arg0, boolean arg1, boolean arg2, TextLayoutState arg3, TransformedTextFieldState arg4, TextFieldSelectionState arg5, Brush arg6, boolean arg7, ScrollState arg8, Orientation arg9, ToolbarRequester arg10, PlatformSelectionBehaviors arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.isFocused;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.isDragHovered;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.textLayoutState;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.textFieldState;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.textFieldSelectionState;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.cursorBrush;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.writeable;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.scrollState;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.orientation;
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.toolbarRequester;
        }

        if((arg12 & 0x400) != 0) {
            arg11 = arg0.platformSelectionBehaviors;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public TextFieldCoreModifierNode create() {
        return new TextFieldCoreModifierNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation, this.toolbarRequester, this.platformSelectionBehaviors);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextFieldCoreModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextFieldCoreModifier)) {
            return 0;
        }

        if(this.isFocused != ((TextFieldCoreModifier)arg5).isFocused) {
            return 0;
        }

        if(this.isDragHovered != ((TextFieldCoreModifier)arg5).isDragHovered) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textLayoutState, ((TextFieldCoreModifier)arg5).textLayoutState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldState, ((TextFieldCoreModifier)arg5).textFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldSelectionState, ((TextFieldCoreModifier)arg5).textFieldSelectionState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.cursorBrush, ((TextFieldCoreModifier)arg5).cursorBrush)) {
            return 0;
        }

        if(this.writeable != ((TextFieldCoreModifier)arg5).writeable) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scrollState, ((TextFieldCoreModifier)arg5).scrollState)) {
            return 0;
        }

        if(this.orientation != ((TextFieldCoreModifier)arg5).orientation) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.toolbarRequester, ((TextFieldCoreModifier)arg5).toolbarRequester)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformSelectionBehaviors, ((TextFieldCoreModifier)arg5).platformSelectionBehaviors)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = (((((((((Boolean.hashCode(this.isFocused) * 0x1F + Boolean.hashCode(this.isDragHovered)) * 0x1F + this.textLayoutState.hashCode()) * 0x1F + this.textFieldState.hashCode()) * 0x1F + this.textFieldSelectionState.hashCode()) * 0x1F + this.cursorBrush.hashCode()) * 0x1F + Boolean.hashCode(this.writeable)) * 0x1F + this.scrollState.hashCode()) * 0x1F + this.orientation.hashCode()) * 0x1F + this.toolbarRequester.hashCode()) * 0x1F;
        PlatformSelectionBehaviors v2 = this.platformSelectionBehaviors;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("TextFieldCoreModifier(isFocused=");
        v0.append(this.isFocused).append(", isDragHovered=").append(this.isDragHovered).append(", textLayoutState=").append(this.textLayoutState).append(", textFieldState=").append(this.textFieldState).append(", textFieldSelectionState=").append(this.textFieldSelectionState).append(", cursorBrush=").append(this.cursorBrush).append(", writeable=").append(this.writeable).append(", scrollState=").append(this.scrollState).append(", orientation=").append(this.orientation).append(", toolbarRequester=").append(this.toolbarRequester).append(", platformSelectionBehaviors=").append(this.platformSelectionBehaviors).append(')');
        return v0.toString();
    }

    public void update(TextFieldCoreModifierNode arg13) {
        arg13.updateNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation, this.toolbarRequester, this.platformSelectionBehaviors);
    }

    public void update(Node arg1) {
        this.update(((TextFieldCoreModifierNode)arg1));
    }
}

