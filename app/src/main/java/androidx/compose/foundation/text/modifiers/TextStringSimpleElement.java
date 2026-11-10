package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u000E\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0002H\u0016J\u0013\u0010\u0019\u001A\u00020\f2\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u000EH\u0016J\f\u0010\u001D\u001A\u00020\u0017*\u00020\u001EH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "", "node", "equals", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextStringSimpleElement extends ModifierNodeElement {
    public static final int $stable;
    private final ColorProducer color;
    private final Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private final boolean softWrap;
    private final TextStyle style;
    private final String text;

    static {
    }

    public TextStringSimpleElement(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, ColorProducer arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    private TextStringSimpleElement(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, ColorProducer arg8) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.color = arg8;
    }

    public TextStringSimpleElement(String arg13, TextStyle arg14, Resolver arg15, int arg16, boolean arg17, int arg18, int arg19, ColorProducer arg20, int arg21, DefaultConstructorMarker arg22) {
        int v0 = arg21;
        int v6 = (v0 & 8) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg16;
        boolean v7 = (v0 & 16) != 0 ? true : arg17;
        int v8 = (v0 & 0x20) != 0 ? 0x7FFFFFFF : arg18;
        int v9 = (v0 & 0x40) != 0 ? 1 : arg19;
        ColorProducer v10 = (v0 & 0x80) != 0 ? null : arg20;
        this(arg13, arg14, arg15, v6, v7, v8, v9, v10, null);
    }

    public TextStringSimpleNode create() {
        return new TextStringSimpleNode(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.color, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextStringSimpleElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextStringSimpleElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.color, ((TextStringSimpleElement)arg5).color)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((TextStringSimpleElement)arg5).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.style, ((TextStringSimpleElement)arg5).style)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, ((TextStringSimpleElement)arg5).fontFamilyResolver)) {
            return 0;
        }

        if(!TextOverflow.equals-impl0(this.overflow, ((TextStringSimpleElement)arg5).overflow)) {
            return 0;
        }

        if(this.softWrap != ((TextStringSimpleElement)arg5).softWrap) {
            return 0;
        }

        if(this.maxLines != ((TextStringSimpleElement)arg5).maxLines) {
            return 0;
        }

        if(this.minLines != ((TextStringSimpleElement)arg5).minLines) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = ((((((this.text.hashCode() * 0x1F + this.style.hashCode()) * 0x1F + this.fontFamilyResolver.hashCode()) * 0x1F + TextOverflow.hashCode-impl(this.overflow)) * 0x1F + Boolean.hashCode(this.softWrap)) * 0x1F + this.maxLines) * 0x1F + this.minLines) * 0x1F;
        ColorProducer v2 = this.color;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(TextStringSimpleNode arg10) {
        arg10.doInvalidations(arg10.updateDraw(this.color, this.style), arg10.updateText(this.text), arg10.updateLayoutRelatedArgs-HuAbxIM(this.style, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow));
    }

    public void update(Node arg1) {
        this.update(((TextStringSimpleNode)arg1));
    }
}

