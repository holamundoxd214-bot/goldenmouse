package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B»\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0012\u0012\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001E\b\u0002\u0010\u0018\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F¢\u0006\u0004\b \u0010!J\b\u0010#\u001A\u00020\u0002H\u0016J\u0010\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\u0002H\u0016J\u0013\u0010&\u001A\u00020\u00102\b\u0010\'\u001A\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001A\u00020\u0012H\u0016J\f\u0010*\u001A\u00020\f*\u00020+H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "node", "equals", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement {
    public static final int $stable;
    private final TextAutoSize autoSize;
    private final ColorProducer color;
    private final Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1 onPlaceholderLayout;
    private final Function1 onTextLayout;
    private final int overflow;
    private final List placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    static {
    }

    public SelectableTextAnnotatedStringElement(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, DefaultConstructorMarker arg14) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    private SelectableTextAnnotatedStringElement(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.onTextLayout = arg4;
        this.overflow = arg5;
        this.softWrap = arg6;
        this.maxLines = arg7;
        this.minLines = arg8;
        this.placeholders = arg9;
        this.onPlaceholderLayout = arg10;
        this.selectionController = arg11;
        this.color = arg12;
        this.autoSize = arg13;
    }

    public SelectableTextAnnotatedStringElement(AnnotatedString arg19, TextStyle arg20, Resolver arg21, Function1 arg22, int arg23, boolean arg24, int arg25, int arg26, List arg27, Function1 arg28, SelectionController arg29, ColorProducer arg30, TextAutoSize arg31, int arg32, DefaultConstructorMarker arg33) {
        int v0 = arg32;
        Function1 v2 = null;
        Function1 v7 = (v0 & 8) != 0 ? v2 : arg22;
        int v8 = (v0 & 16) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg23;
        boolean v9 = (v0 & 0x20) != 0 ? true : arg24;
        int v10 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg25;
        int v11 = (v0 & 0x80) != 0 ? 1 : arg26;
        List v12 = (v0 & 0x100) != 0 ? ((List)v2) : arg27;
        Function1 v13 = (v0 & 0x200) != 0 ? v2 : arg28;
        SelectionController v14 = (v0 & 0x400) != 0 ? ((SelectionController)v2) : arg29;
        ColorProducer v15 = (v0 & 0x800) != 0 ? ((ColorProducer)v2) : arg30;
        TextAutoSize v16 = (v0 & 0x1000) != 0 ? ((TextAutoSize)v2) : arg31;
        this(arg19, arg20, arg21, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, null);
    }

    public SelectableTextAnnotatedStringNode create() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, this.autoSize, null, 0x2000, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((SelectableTextAnnotatedStringElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SelectableTextAnnotatedStringElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.color, ((SelectableTextAnnotatedStringElement)arg5).color)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((SelectableTextAnnotatedStringElement)arg5).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.style, ((SelectableTextAnnotatedStringElement)arg5).style)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.placeholders, ((SelectableTextAnnotatedStringElement)arg5).placeholders)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, ((SelectableTextAnnotatedStringElement)arg5).fontFamilyResolver)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.autoSize, ((SelectableTextAnnotatedStringElement)arg5).autoSize)) {
            return 0;
        }

        if(this.onTextLayout != ((SelectableTextAnnotatedStringElement)arg5).onTextLayout) {
            return 0;
        }

        if(!TextOverflow.equals-impl0(this.overflow, ((SelectableTextAnnotatedStringElement)arg5).overflow)) {
            return 0;
        }

        if(this.softWrap != ((SelectableTextAnnotatedStringElement)arg5).softWrap) {
            return 0;
        }

        if(this.maxLines != ((SelectableTextAnnotatedStringElement)arg5).maxLines) {
            return 0;
        }

        if(this.minLines != ((SelectableTextAnnotatedStringElement)arg5).minLines) {
            return 0;
        }

        if(this.onPlaceholderLayout != ((SelectableTextAnnotatedStringElement)arg5).onPlaceholderLayout) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.selectionController, ((SelectableTextAnnotatedStringElement)arg5).selectionController)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = ((this.text.hashCode() * 0x1F + this.style.hashCode()) * 0x1F + this.fontFamilyResolver.hashCode()) * 0x1F;
        Function1 v1 = this.onTextLayout;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (((((v0 + v1_1) * 0x1F + TextOverflow.hashCode-impl(this.overflow)) * 0x1F + Boolean.hashCode(this.softWrap)) * 0x1F + this.maxLines) * 0x1F + this.minLines) * 0x1F;
        List v1_2 = this.placeholders;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.onPlaceholderLayout;
        v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        SelectionController v1_3 = this.selectionController;
        v1_1 = v1_3 != null ? v1_3.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        TextAutoSize v1_4 = this.autoSize;
        v1_1 = v1_4 != null ? v1_4.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        ColorProducer v3 = this.color;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(SelectableTextAnnotatedStringNode arg15) {
        arg15.update-7NebLg4(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color, this.autoSize);
    }

    public void update(Node arg1) {
        this.update(((SelectableTextAnnotatedStringNode)arg1));
    }
}

