package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PBS\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\f\u0010$\u001A\u00020 *\u00020%H\u0002J\r\u0010\"\u001A\u00020 H\u0003¢\u0006\u0002\b&J\u0018\u0010\'\u001A\u00020\u000E2\b\u0010(\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001A\u00020\bJ\u000E\u0010)\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u0006J=\u0010*\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b+\u0010,J\u001E\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u000E2\u0006\u00101\u001A\u00020\u000EJ\u0010\u00108\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u0006H\u0002J\b\u0010:\u001A\u00020.H\u0002J\f\u0010;\u001A\u00020.*\u00020<H\u0016J\b\u0010=\u001A\u00020.H\u0002J#\u0010>\u001A\u00020?*\u00020@2\u0006\u0010A\u001A\u00020B2\u0006\u0010C\u001A\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u001C\u0010G\u001A\u00020\u0010*\u00020%2\u0006\u0010A\u001A\u00020H2\u0006\u0010I\u001A\u00020\u0010H\u0016J\u001C\u0010J\u001A\u00020\u0010*\u00020%2\u0006\u0010A\u001A\u00020H2\u0006\u0010K\u001A\u00020\u0010H\u0016J\u001C\u0010L\u001A\u00020\u0010*\u00020%2\u0006\u0010A\u001A\u00020H2\u0006\u0010I\u001A\u00020\u0010H\u0016J\u001C\u0010M\u001A\u00020\u0010*\u00020%2\u0006\u0010A\u001A\u00020H2\u0006\u0010K\u001A\u00020\u0010H\u0016J\f\u0010N\u001A\u00020.*\u00020OH\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\"\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001BX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u001D\u0010\u001ER\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010!\u001A\u00020 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\"\u00102\u001A\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020504\u0012\u0004\u0012\u00020\u000E\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00106\u001A\u0004\u0018\u000107X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006Q"}, d2={"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "getLayoutCacheForMeasure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "getLayoutCacheOrSubstitute", "updateDraw", "color", "updateText", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "doInvalidations", "", "drawChanged", "textChanged", "layoutChanged", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "setSubstitution", "updatedText", "clearSubstitution", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invalidateForTranslate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "TextSubstitutionValue", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextStringSimpleNode extends Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001A\u00020\u0003H\u0016J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0006HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u00062\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\f\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2={"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "", "original", "", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "getOriginal", "()Ljava/lang/String;", "getSubstitution", "setSubstitution", "(Ljava/lang/String;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private ParagraphLayoutCache layoutCache;
        private final String original;
        private String substitution;

        static {
        }

        public TextSubstitutionValue(String arg1, String arg2, boolean arg3, ParagraphLayoutCache arg4, int arg5, DefaultConstructorMarker arg6) {
            if((arg5 & 8) != 0) {
                arg4 = null;
            }

            this(arg1, arg2, false, arg4);
        }

        public TextSubstitutionValue(String arg1, String arg2, boolean arg3, ParagraphLayoutCache arg4) {
            super();
            this.original = arg1;
            this.substitution = arg2;
            this.isShowingSubstitution = arg3;
            this.layoutCache = arg4;
        }

        public final String component1() {
            return this.original;
        }

        public final String component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final ParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(String arg1, String arg2, boolean arg3, ParagraphLayoutCache arg4) {
            return new TextSubstitutionValue(arg1, arg2, arg3, arg4);
        }

        public static TextSubstitutionValue copy$default(TextSubstitutionValue arg0, String arg1, String arg2, boolean arg3, ParagraphLayoutCache arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.original;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.substitution;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.isShowingSubstitution;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.layoutCache;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((TextSubstitutionValue)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof TextSubstitutionValue)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.original, ((TextSubstitutionValue)arg5).original)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.substitution, ((TextSubstitutionValue)arg5).substitution)) {
                return 0;
            }

            if(this.isShowingSubstitution != ((TextSubstitutionValue)arg5).isShowingSubstitution) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.layoutCache, ((TextSubstitutionValue)arg5).layoutCache)) {
                return 0;
            }

            return 1;
        }

        public final ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final String getOriginal() {
            return this.original;
        }

        public final String getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int v0 = ((this.original.hashCode() * 0x1F + this.substitution.hashCode()) * 0x1F + Boolean.hashCode(this.isShowingSubstitution)) * 0x1F;
            ParagraphLayoutCache v2 = this.layoutCache;
            int v2_1 = v2 == null ? 0 : v2.hashCode();
            return v0 + v2_1;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(ParagraphLayoutCache arg1) {
            this.layoutCache = arg1;
        }

        public final void setShowingSubstitution(boolean arg1) {
            this.isShowingSubstitution = arg1;
        }

        public final void setSubstitution(String arg1) {
            this.substitution = arg1;
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.layoutCache + ", isShowingSubstitution=" + this.isShowingSubstitution + ')';
        }
    }

    public static final int $stable = 8;
    private ParagraphLayoutCache _layoutCache;
    private Map baselineCache;
    private Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private Function1 semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;
    private TextSubstitutionValue textSubstitution;

    public static Unit $r8$lambda$hi7gD20Tu0XAGFzjijkNuVrHmTY(Placeable arg0, PlacementScope arg1) {
        return TextStringSimpleNode.measure_3p2s80s$lambda$0$0(arg0, arg1);
    }

    static {
    }

    public TextStringSimpleNode(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, ColorProducer arg8, DefaultConstructorMarker arg9) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    private TextStringSimpleNode(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, ColorProducer arg8) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.overrideColor = arg8;
    }

    public TextStringSimpleNode(String arg13, TextStyle arg14, Resolver arg15, int arg16, boolean arg17, int arg18, int arg19, ColorProducer arg20, int arg21, DefaultConstructorMarker arg22) {
        int v0 = arg21;
        int v6 = (v0 & 8) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg16;
        boolean v7 = (v0 & 16) != 0 ? true : arg17;
        int v8 = (v0 & 0x20) != 0 ? 0x7FFFFFFF : arg18;
        int v9 = (v0 & 0x40) != 0 ? 1 : arg19;
        ColorProducer v10 = (v0 & 0x80) != 0 ? null : arg20;
        this(arg13, arg14, arg15, v6, v7, v8, v9, v10, null);
    }

    public void applySemantics(SemanticsPropertyReceiver arg6) {
        Function1 v0 = this.semanticsTextLayoutResult;
        if(v0 == null) {
            TextStringSimpleNode$$ExternalSyntheticLambda0 v0_1 = new TextStringSimpleNode$$ExternalSyntheticLambda0(this);
            this.semanticsTextLayoutResult = ((Function1)v0_1);
        }

        List v3 = null;
        int v4 = 2;
        SemanticsPropertiesKt.setText(arg6, new AnnotatedString(this.text, v3, v4, ((DefaultConstructorMarker)v3)));
        TextSubstitutionValue v1 = this.textSubstitution;
        if(v1 != null) {
            SemanticsPropertiesKt.setShowingTextSubstitution(arg6, v1.isShowingSubstitution());
            SemanticsPropertiesKt.setTextSubstitution(arg6, new AnnotatedString(v1.getSubstitution(), v3, v4, ((DefaultConstructorMarker)v3)));
        }

        SemanticsPropertiesKt.setTextSubstitution$default(arg6, ((String)v3), new TextStringSimpleNode$$ExternalSyntheticLambda1(this), 1, v3);
        SemanticsPropertiesKt.showTextSubstitution$default(arg6, ((String)v3), new TextStringSimpleNode$$ExternalSyntheticLambda2(this), 1, v3);
        SemanticsPropertiesKt.clearTextSubstitution$default(arg6, ((String)v3), new TextStringSimpleNode$$ExternalSyntheticLambda3(this), 1, v3);
        SemanticsPropertiesKt.getTextLayoutResult$default(arg6, ((String)v3), v0, 1, v3);
    }

    static final boolean applySemantics$lambda$0(TextStringSimpleNode arg34, List arg35) {
        ParagraphLayoutCache v1 = arg34.getLayoutCache();
        TextStyle v2 = arg34.style;
        ColorProducer v0 = arg34.overrideColor;
        long v3 = v0 != null ? v0.invoke-0d7_KjU() : Color.Companion.getUnspecified-0d7_KjU();
        TextLayoutResult v0_1 = v1.slowCreateTextLayoutResultOrNull(TextStyle.merge-dA7vx0o$default(v2, v3, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, 0, 0, null, null, 0xFFFFFE, null));
        if(v0_1 != null) {
            arg35.add(v0_1);
        }
        else {
            v0_1 = null;
        }

        if(v0_1 != null) {
            return 1;
        }

        return 0;
    }

    static final boolean applySemantics$lambda$1(TextStringSimpleNode arg0, AnnotatedString arg1) {
        arg0.setSubstitution(arg1.getText());
        arg0.invalidateForTranslate();
        return 1;
    }

    static final boolean applySemantics$lambda$2(TextStringSimpleNode arg1, boolean arg2) {
        TextSubstitutionValue v0 = arg1.textSubstitution;
        if(v0 == null) {
            return 0;
        }

        if(v0 != null) {
            v0.setShowingSubstitution(arg2);
        }

        arg1.invalidateForTranslate();
        return 1;
    }

    static final boolean applySemantics$lambda$3(TextStringSimpleNode arg0) {
        arg0.clearSubstitution();
        arg0.invalidateForTranslate();
        return 1;
    }

    private final void clearSubstitution() {
        this.textSubstitution = null;
    }

    public final void doInvalidations(boolean arg9, boolean arg10, boolean arg11) {
        if((arg10) || (arg11)) {
            this.getLayoutCache().update-L6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        }

        if(!this.isAttached()) {
        }
        else {
            if((arg10) || (arg9) && this.semanticsTextLayoutResult != null) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }

            if((arg10) || (arg11)) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }

            if(!arg9) {
                return;
            }

            DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
        }
    }

    public void draw(ContentDrawScope arg12) {
        Fill v0_5;
        if(!this.isAttached()) {
        }
        else {
            ParagraphLayoutCache v0 = this.getLayoutCacheOrSubstitute();
            Paragraph v1 = v0.getParagraph$foundation();
            if(v1 != null) {
                Canvas v2 = ((DrawScope)arg12).getDrawContext().getCanvas();
                boolean v12 = v0.getDidOverflow$foundation();
                if(v12) {
                    float v5 = ((float)(((int)(v0.getLayoutSize-YbymL2g$foundation() >> 0x20))));
                    float v6 = ((float)(((int)(v0.getLayoutSize-YbymL2g$foundation() & 0xFFFFFFFFL))));
                    v2.save();
                    Canvas.clipRect-N_I0leg$default(v2, 0f, 0f, v5, v6, 0, 16, null);
                }

                try {
                    TextDecoration v0_2 = this.style.getTextDecoration();
                    if(v0_2 == null) {
                        v0_2 = TextDecoration.Companion.getNone();
                    }

                    TextDecoration v6_1 = v0_2;
                    Shadow v0_3 = this.style.getShadow();
                    if(v0_3 == null) {
                        v0_3 = Shadow.Companion.getNone();
                    }

                    Shadow v5_1 = v0_3;
                    DrawStyle v0_4 = this.style.getDrawStyle();
                    if(v0_4 == null) {
                        v0_5 = Fill.INSTANCE;
                    }

                    DrawStyle v7 = ((DrawStyle)v0_5);
                    Brush v3 = this.style.getBrush();
                    if(v3 != null) {
                        Paragraph.paint-hn5TExg$default(v1, v2, v3, this.style.getAlpha(), v5_1, v6_1, v7, 0, 0x40, null);
                    }
                    else {
                        ColorProducer v0_6 = this.overrideColor;
                        long v3_1 = v0_6 != null ? v0_6.invoke-0d7_KjU() : Color.Companion.getUnspecified-0d7_KjU();
                        long v8 = 16;
                        if(v3_1 != v8) {
                        }
                        else if(this.style.getColor-0d7_KjU() != v8) {
                            v3_1 = this.style.getColor-0d7_KjU();
                        }
                        else {
                            v3_1 = Color.Companion.getBlack-0d7_KjU();
                        }

                        Paragraph.paint-LG529CI$default(v1, v2, v3_1, v5_1, v6_1, v7, 0, 0x20, null);
                    }
                }
                catch(Throwable v0_1) {
                    Throwable v11 = v0_1;
                    if(v12) {
                        v2.restore();
                    }

                    throw v11;
                }

                if(!v12) {
                    return;
                }

                v2.restore();
            }
            else {
                goto label_83;
            }
        }

        return;
    label_83:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Internal Error: ParagraphLayoutCache could not provide a Paragraph during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: (layoutCache=" + this._layoutCache + ", textSubstitution=" + this.textSubstitution + ')');
        throw new KotlinNothingValueException();
    }

    private static void getBaselineCache$annotations() {
    }

    private final ParagraphLayoutCache getLayoutCache() {
        ParagraphLayoutCache v0 = this._layoutCache;
        if(v0 == null) {
            ParagraphLayoutCache v1 = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
            this._layoutCache = v1;
            v0 = v1;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private final ParagraphLayoutCache getLayoutCacheForMeasure(IntrinsicMeasureScope arg1) {
        ParagraphLayoutCache v0 = this.getLayoutCacheOrSubstitute();
        v0.setDensity$foundation(((Density)arg1));
        return v0;
    }

    private final ParagraphLayoutCache getLayoutCacheOrSubstitute() {
        TextSubstitutionValue v0 = this.textSubstitution;
        if(v0 != null) {
            if(v0.isShowingSubstitution()) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                goto label_11;
            }

            ParagraphLayoutCache v0_1 = v0.getLayoutCache();
            if(v0_1 == null) {
                goto label_11;
            }

            return v0_1;
        }

    label_11:
        return this.getLayoutCache();
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCacheForMeasure(arg1).intrinsicHeight(arg3, arg1.getLayoutDirection());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCacheForMeasure(arg1).maxIntrinsicWidth(arg1.getLayoutDirection());
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg5, Measurable arg6, long arg7) {
        MeasureResult v4_2;
        Trace.beginSection("TextStringSimpleNode::measure");
        try {
            ParagraphLayoutCache v0 = this.getLayoutCacheForMeasure(arg5);
            boolean v7 = v0.layoutWithConstraints-K40F9xA(arg7, arg5.getLayoutDirection());
            v0.getObserveFontChanges$foundation();
            Paragraph v8 = v0.getParagraph$foundation();
            Intrinsics.checkNotNull(v8);
            long v0_1 = v0.getLayoutSize-YbymL2g$foundation();
            if(v7) {
                LayoutModifierNodeKt.invalidateLayer(this);
                Map v7_1 = this.baselineCache;
                if(v7_1 == null) {
                    HashMap v7_2 = new HashMap(2);
                    this.baselineCache = ((Map)v7_2);
                }

                v7_1.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(v8.getFirstBaseline())));
                v7_1.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(v8.getLastBaseline())));
            }

            int v8_1 = ((int)(v0_1 >> 0x20));
            int v0_2 = ((int)(v0_1 & 0xFFFFFFFFL));
            Placeable v6 = arg6.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(v8_1, v8_1, v0_2, v0_2));
            Map v4_1 = this.baselineCache;
            Intrinsics.checkNotNull(v4_1);
            v4_2 = arg5.layout(v8_1, v0_2, v4_1, new TextStringSimpleNode$$ExternalSyntheticLambda4(v6));
        }
        catch(Throwable v4) {
            Trace.endSection();
            throw v4;
        }

        Trace.endSection();
        return v4_2;
    }

    private static final Unit measure_3p2s80s$lambda$0$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCacheForMeasure(arg1).intrinsicHeight(arg3, arg1.getLayoutDirection());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCacheForMeasure(arg1).minIntrinsicWidth(arg1.getLayoutDirection());
    }

    private final boolean setSubstitution(String arg12) {
        TextSubstitutionValue v2 = this.textSubstitution;
        if(v2 == null) {
            TextSubstitutionValue v10 = new TextSubstitutionValue(this.text, arg12, false, null, 12, null);
            ParagraphLayoutCache v1 = new ParagraphLayoutCache(arg12, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
            v1.setDensity$foundation(this.getLayoutCache().getDensity$foundation());
            v10.setLayoutCache(v1);
            this.textSubstitution = v10;
        }
        else if(Intrinsics.areEqual(arg12, v2.getSubstitution())) {
            return 0;
        }
        else {
            v2.setSubstitution(arg12);
            ParagraphLayoutCache v2_1 = v2.getLayoutCache();
            if(v2_1 != null) {
                v2_1.update-L6sJoHM(arg12, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean updateDraw(ColorProducer arg2, TextStyle arg3) {
        boolean v0 = Intrinsics.areEqual(arg2, this.overrideColor);
        this.overrideColor = arg2;
        if(v0) {
            if(!arg3.hasSameDrawAffectingAttributes(this.style)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean updateLayoutRelatedArgs-HuAbxIM(TextStyle arg3, int arg4, int arg5, boolean arg6, Resolver arg7, int arg8) {
        boolean v0_1;
        int v0 = this.style.hasSameLayoutAffectingAttributes(arg3) ^ 1;
        this.style = arg3;
        if(this.minLines != arg4) {
            this.minLines = arg4;
            v0_1 = true;
        }

        if(this.maxLines != arg5) {
            this.maxLines = arg5;
            v0_1 = true;
        }

        if(this.softWrap != arg6) {
            this.softWrap = arg6;
            v0_1 = true;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, arg7)) {
            this.fontFamilyResolver = arg7;
            v0_1 = true;
        }

        if(!TextOverflow.equals-impl0(this.overflow, arg8)) {
            this.overflow = arg8;
            return 1;
        }

        return v0_1;
    }

    public final boolean updateText(String arg2) {
        if(Intrinsics.areEqual(this.text, arg2)) {
            return 0;
        }

        this.text = arg2;
        this.clearSubstitution();
        return 1;
    }
}

