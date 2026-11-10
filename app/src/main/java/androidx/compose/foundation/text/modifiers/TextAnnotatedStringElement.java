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

@Metadata(d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BÓ\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0012\u0012\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001E\b\u0002\u0010\u0018\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\u0016\b\u0002\u0010 \u001A\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0004\b\"\u0010#J\b\u0010%\u001A\u00020\u0002H\u0016J\u0010\u0010&\u001A\u00020\f2\u0006\u0010\'\u001A\u00020\u0002H\u0016J\u0013\u0010(\u001A\u00020\u00102\b\u0010)\u001A\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001A\u00020\u0012H\u0016J\f\u0010,\u001A\u00020\f*\u00020-H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010 \u001A\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2={"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "node", "equals", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextAnnotatedStringElement extends ModifierNodeElement {
    public static final int $stable;
    private final TextAutoSize autoSize;
    private final ColorProducer color;
    private final Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1 onPlaceholderLayout;
    private final Function1 onShowTranslation;
    private final Function1 onTextLayout;
    private final int overflow;
    private final List placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    static {
    }

    public TextAnnotatedStringElement(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, Function1 arg14, DefaultConstructorMarker arg15) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    private TextAnnotatedStringElement(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, Function1 arg14) {
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
        this.onShowTranslation = arg14;
    }

    public TextAnnotatedStringElement(AnnotatedString arg20, TextStyle arg21, Resolver arg22, Function1 arg23, int arg24, boolean arg25, int arg26, int arg27, List arg28, Function1 arg29, SelectionController arg30, ColorProducer arg31, TextAutoSize arg32, Function1 arg33, int arg34, DefaultConstructorMarker arg35) {
        int v0 = arg34;
        Function1 v2 = null;
        Function1 v7 = (v0 & 8) != 0 ? v2 : arg23;
        int v8 = (v0 & 16) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg24;
        boolean v9 = (v0 & 0x20) != 0 ? true : arg25;
        int v10 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg26;
        int v11 = (v0 & 0x80) != 0 ? 1 : arg27;
        List v12 = (v0 & 0x100) != 0 ? ((List)v2) : arg28;
        Function1 v13 = (v0 & 0x200) != 0 ? v2 : arg29;
        SelectionController v14 = (v0 & 0x400) != 0 ? ((SelectionController)v2) : arg30;
        ColorProducer v15 = (v0 & 0x800) != 0 ? ((ColorProducer)v2) : arg31;
        TextAutoSize v16 = (v0 & 0x1000) != 0 ? ((TextAutoSize)v2) : arg32;
        Function1 v17 = (v0 & 0x2000) != 0 ? v2 : arg33;
        this(arg20, arg21, arg22, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, null);
    }

    public TextAnnotatedStringNode create() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, this.autoSize, this.onShowTranslation, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextAnnotatedStringElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextAnnotatedStringElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.color, ((TextAnnotatedStringElement)arg5).color)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((TextAnnotatedStringElement)arg5).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.style, ((TextAnnotatedStringElement)arg5).style)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.placeholders, ((TextAnnotatedStringElement)arg5).placeholders)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, ((TextAnnotatedStringElement)arg5).fontFamilyResolver)) {
            return 0;
        }

        if(this.onTextLayout != ((TextAnnotatedStringElement)arg5).onTextLayout) {
            return 0;
        }

        if(this.onShowTranslation != ((TextAnnotatedStringElement)arg5).onShowTranslation) {
            return 0;
        }

        if(!TextOverflow.equals-impl0(this.overflow, ((TextAnnotatedStringElement)arg5).overflow)) {
            return 0;
        }

        if(this.softWrap != ((TextAnnotatedStringElement)arg5).softWrap) {
            return 0;
        }

        if(this.maxLines != ((TextAnnotatedStringElement)arg5).maxLines) {
            return 0;
        }

        if(this.minLines != ((TextAnnotatedStringElement)arg5).minLines) {
            return 0;
        }

        if(this.onPlaceholderLayout != ((TextAnnotatedStringElement)arg5).onPlaceholderLayout) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.selectionController, ((TextAnnotatedStringElement)arg5).selectionController)) {
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
        ColorProducer v1_4 = this.color;
        v1_1 = v1_4 != null ? v1_4.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        Function1 v3 = this.onShowTranslation;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(TextAnnotatedStringNode arg12) {
        arg12.doInvalidations(arg12.updateDraw(this.color, this.style), arg12.updateText$foundation(this.text), arg12.updateLayoutRelatedArgs-y0k-MQk(this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.autoSize), arg12.updateCallbacks(this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.onShowTranslation));
    }

    public void update(Node arg1) {
        this.update(((TextAnnotatedStringNode)arg1));
    }
}

