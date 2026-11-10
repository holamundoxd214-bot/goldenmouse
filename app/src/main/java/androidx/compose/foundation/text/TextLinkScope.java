package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation$Clickable;
import androidx.compose.ui.text.LinkAnnotation$Url;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\u001F\u001A\u00020 *\u00020 2\u0010\u0010!\u001A\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001E\u0010%\u001A\u00020 *\u00020 2\u0010\u0010!\u001A\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001C\u0010&\u001A\u0004\u0018\u00010\'2\u0010\u0010!\u001A\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001C\u0010(\u001A\u0004\u0018\u00010)2\u0010\u0010!\u001A\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J0\u0010*\u001A\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0004\u0018\u0001`$2\u0010\u0010!\u001A\f\u0012\u0004\u0012\u00020#0\"j\u0002`$2\u0006\u0010\n\u001A\u00020\tH\u0002J\r\u0010+\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010,J\u001A\u0010-\u001A\u0004\u0018\u00010.*\u0004\u0018\u00010.2\b\u0010/\u001A\u0004\u0018\u00010.H\u0002J\u0018\u00100\u001A\u00020\u00182\u0006\u0010!\u001A\u00020#2\u0006\u00101\u001A\u000202H\u0002J\r\u00103\u001A\u00020\u0003H\u0000¢\u0006\u0002\b4J>\u00105\u001A\u00020\u00182\u0016\u00106\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000107\"\u0004\u0018\u00010\u00012\u0017\u00108\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u00109R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R/\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\b\u001A\u0004\u0018\u00010\t8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0011\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0005R%\u0010\u0014\u001A\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u00190\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001B8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006:"}, d2={"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getInitialText$foundation", "()Landroidx/compose/ui/text/AnnotatedString;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "text", "getText$foundation", "setText$foundation", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "textRange", "Landroidx/compose/ui/Modifier;", "link", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "clipLink", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "calculateVisibleLinkRange", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "handleLink", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "applyAnnotators", "applyAnnotators$foundation", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLinkScope {
    public static final int $stable = 8;
    private final SnapshotStateList annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;
    private final MutableState textLayoutResult$delegate;

    public static Unit $r8$lambda$FPTb8JTi1saQebza20LwZZi5mjY(SemanticsPropertyReceiver arg0) {
        return TextLinkScope.LinksComposables$lambda$0$1$0(arg0);
    }

    public static Unit $r8$lambda$G8m739v6sJJhAUWtdAvixQb71kM(TextLinkScope arg0, Range arg1, LinkStateInteractionSourceObserver arg2, TextAnnotatorScope arg3) {
        return TextLinkScope.LinksComposables$lambda$0$5$0(arg0, arg1, arg2, arg3);
    }

    public static DisposableEffectResult $r8$lambda$HsvqaTf9wcDE7-Vw2EsaDS-SXLM(TextLinkScope arg0, Function1 arg1, DisposableEffectScope arg2) {
        return TextLinkScope.StyleAnnotation$lambda$0$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$LdJ0RmGAyplUEvERXJi489ZkdnQ(TextLinkScope arg0, Range arg1, UriHandler arg2) {
        return TextLinkScope.LinksComposables$lambda$0$2$0(arg0, arg1, arg2);
    }

    public static IntOffset $r8$lambda$XpbHTUu8qaJDdMQ0y7s8MJrFsbE() {
        return TextLinkScope.textRange$lambda$0$0();
    }

    public static IntOffset $r8$lambda$alLwZrB_BzQd4GX4NdiWYSgrjUc() {
        return TextLinkScope.textRange$lambda$0$1();
    }

    public static IntOffset $r8$lambda$s0O0NfPjbGeY9TTqirfBI_-yh04(IntRect arg0) {
        return TextLinkScope.textRange$lambda$0$2(arg0);
    }

    static {
    }

    public TextLinkScope(AnnotatedString arg3) {
        super();
        this.initialText = arg3;
        this.textLayoutResult$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.text = arg3.flatMapAnnotations(new TextLinkScope$$ExternalSyntheticLambda9());
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    public final void LinksComposables(Composer arg29, int arg30) {
        TextLinkScope$$ExternalSyntheticLambda12 v14_5;
        SpanStyle v5_2;
        SpanStyle v20;
        SpanStyle v19;
        SpanStyle v18;
        TextLinkScope$LinksComposables$1$3$1 v15_3;
        LinkStateInteractionSourceObserver v12_2;
        TextLinkScope$$ExternalSyntheticLambda10 v14_1;
        MutableInteractionSource v12_1;
        int v4;
        TextLinkScope v0 = this;
        int v1 = arg30;
        int v2 = 0x44D294DA;
        Composer v3 = arg29.startRestartGroup(v2);
        ComposerKt.sourceInformation(v3, "C(LinksComposables)215@9182L7:TextLinkScope.kt#423gt5");
        int v5 = 2;
        if((v1 & 6) == 0) {
            v4 = v3.changedInstance(v0) ? 4 : v5;
            v4 |= v1;
        }
        else {
            v4 = v1;
        }

        int v7 = 1;
        boolean v6 = (v4 & 3) != v5 ? true : false;
        if(v3.shouldExecute(v6, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
            }

            ProvidableCompositionLocal v2_1 = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = v3.consume(((CompositionLocal)v2_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            List v6_1 = v0.text.getLinkAnnotations(0, v0.text.length());
            int v9 = v6_1.size();
            int v10 = 0;
            while(v10 < v9) {
                Object v11 = v6_1.get(v10);
                if(((Range)v11).getStart() != ((Range)v11).getEnd()) {
                    v3.startReplaceGroup(0x2B3DEE17);
                    ComposerKt.sourceInformation(v3, "220@9372L39,224@9514L180,234@10047L38,222@9429L701");
                    String v13 = "CC(remember):TextLinkScope.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(v3, 0x32F1750B, v13);
                    Object v12 = v3.rememberedValue();
                    if(v12 == Composer.Companion.getEmpty()) {
                        v12_1 = InteractionSourceKt.MutableInteractionSource();
                        v3.updateRememberedValue(v12_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    Modifier v15 = v0.clipLink(Modifier.Companion, ((Range)v11));
                    ComposerKt.sourceInformationMarkerStart(v3, 0x32F18758, v13);
                    Object v14 = v3.rememberedValue();
                    if(v14 == Composer.Companion.getEmpty()) {
                        v14_1 = new TextLinkScope$$ExternalSyntheticLambda10();
                        v3.updateRememberedValue(v14_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    Object v5_1 = null;
                    Modifier v7_1 = PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(v0.textRange(SemanticsModifierKt.semantics$default(v15, false, ((Function1)v14_1), v7, v5_1), ((Range)v11)), v12_1, false, 2, v5_1), PointerIcon.Companion.getHand(), false, 2, v5_1);
                    ComposerKt.sourceInformationMarkerStart(v3, 0x32F1C96A, v13);
                    int v14_2 = v3.changedInstance(v0) | v3.changed(v11) | v3.changedInstance(v2_2);
                    Object v15_1 = v3.rememberedValue();
                    if(v14_2 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                        TextLinkScope$$ExternalSyntheticLambda11 v15_2 = new TextLinkScope$$ExternalSyntheticLambda11(v0, ((Range)v11), ((UriHandler)v2_2));
                        v3.updateRememberedValue(v15_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    Object v16 = v12_1;
                    BoxKt.Box(ClickableKt.combinedClickable-auXiCPI$default(v7_1, ((MutableInteractionSource)v16), null, false, null, null, null, null, null, false, v15_1, 508, null), v3, 0);
                    if(!TextLinkScopeKt.access$isNullOrEmpty(((Range)v11).getItem().getStyles())) {
                        v3.startReplaceGroup(726303039);
                        ComposerKt.sourceInformation(v3, "243@10493L110,246@10645L51,246@10624L72,256@11137L1144,248@10718L1563");
                        ComposerKt.sourceInformationMarkerStart(v3, 0x32F20172, v13);
                        v12 = v3.rememberedValue();
                        if(v12 == Composer.Companion.getEmpty()) {
                            v12_2 = new LinkStateInteractionSourceObserver(v16);
                            v3.updateRememberedValue(v12_2);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v3);
                        Unit v14_3 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(v3, 0x32F21437, v13);
                        v15_1 = v3.rememberedValue();
                        if(v15_1 == Composer.Companion.getEmpty()) {
                            v15_3 = new TextLinkScope$LinksComposables$1$3$1(v12_2, ((Continuation)v5_1));
                            v3.updateRememberedValue(v15_3);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v3);
                        EffectsKt.LaunchedEffect(v14_3, ((Function2)v15_3), v3, 6);
                        Boolean v15_4 = Boolean.valueOf(v12_2.isHovered());
                        Boolean v16_1 = Boolean.valueOf(v12_2.isFocused());
                        Boolean v17 = Boolean.valueOf(v12_2.isPressed());
                        TextLinkStyles v14_4 = ((Range)v11).getItem().getStyles();
                        if(v14_4 != null) {
                            v18 = v14_4.getStyle();
                        }
                        else {
                            Object v18_1 = v5_1;
                        }

                        v14_4 = ((Range)v11).getItem().getStyles();
                        if(v14_4 != null) {
                            v19 = v14_4.getFocusedStyle();
                        }
                        else {
                            Object v19_1 = v5_1;
                        }

                        v14_4 = ((Range)v11).getItem().getStyles();
                        if(v14_4 != null) {
                            v20 = v14_4.getHoveredStyle();
                        }
                        else {
                            Object v20_1 = v5_1;
                        }

                        v14_4 = ((Range)v11).getItem().getStyles();
                        if(v14_4 != null) {
                            v5_2 = v14_4.getPressedStyle();
                        }

                        Object[] v5_3 = new Object[]{v15_4, v16_1, v17, v18, v19, v20, v5_2};
                        ComposerKt.sourceInformationMarkerStart(v3, 0x32F255FC, v13);
                        int v13_1 = v3.changedInstance(v0) | v3.changed(v11);
                        v14 = v3.rememberedValue();
                        if(v13_1 != 0 || v14 == Composer.Companion.getEmpty()) {
                            v14_5 = new TextLinkScope$$ExternalSyntheticLambda12(v0, ((Range)v11), v12_2);
                            v3.updateRememberedValue(v14_5);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v3);
                        v0.StyleAnnotation(v5_3, ((Function1)v14_5), v3, v4 << 6 & 0x380);
                    }
                    else {
                        v3.startReplaceGroup(716130110);
                    }

                    v3.endReplaceGroup();
                }
                else {
                    v3.startReplaceGroup(716130110);
                }

                v3.endReplaceGroup();
                ++v10;
                v7 = 1;
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_216;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v3.skipToGroupEnd();
        }

    label_216:
        ScopeUpdateScope v2_3 = v3.endRestartGroup();
        if(v2_3 != null) {
            v2_3.updateScope(new TextLinkScope$$ExternalSyntheticLambda1(v0, v1));
        }
    }

    private static final Unit LinksComposables$lambda$0$1$0(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getLinkTestMarker(), Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final Unit LinksComposables$lambda$0$2$0(TextLinkScope arg0, Range arg1, UriHandler arg2) {
        arg0.handleLink(arg1.getItem(), arg2);
        return Unit.INSTANCE;
    }

    private static final Unit LinksComposables$lambda$0$5$0(TextLinkScope arg3, Range arg4, LinkStateInteractionSourceObserver arg5, TextAnnotatorScope arg6) {
        SpanStyle v2_1;
        TextLinkStyles v2;
        TextLinkStyles v0 = arg4.getItem().getStyles();
        SpanStyle v1 = null;
        SpanStyle v0_1 = v0 != null ? v0.getStyle() : v1;
        if(arg5.isFocused()) {
            v2 = arg4.getItem().getStyles();
            if(v2 != null) {
                v2_1 = v2.getFocusedStyle();
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            v2_1 = v1;
        }

        v0_1 = arg3.mergeOrUse(v0_1, v2_1);
        if(arg5.isHovered()) {
            v2 = arg4.getItem().getStyles();
            if(v2 != null) {
                v2_1 = v2.getHoveredStyle();
            }
            else {
                goto label_23;
            }
        }
        else {
        label_23:
            v2_1 = v1;
        }

        v0_1 = arg3.mergeOrUse(v0_1, v2_1);
        if(arg5.isPressed()) {
            TextLinkStyles v5 = arg4.getItem().getStyles();
            if(v5 != null) {
                v1 = v5.getPressedStyle();
            }
        }

        arg6.replaceStyle(arg4, arg3.mergeOrUse(v0_1, v1));
        return Unit.INSTANCE;
    }

    static final Unit LinksComposables$lambda$1(TextLinkScope arg0, int arg1, Composer arg2, int arg3) {
        arg0.LinksComposables(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private final void StyleAnnotation(Object[] arg9, Function1 arg10, Composer arg11, int arg12) {
        TextLinkScope$$ExternalSyntheticLambda7 v2_2;
        int v3;
        int v1;
        int v0 = -2083052099;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(StyleAnnotation)N(keys,block)316@13856L89,316@13825L120:TextLinkScope.kt#423gt5");
        int v2 = 0x20;
        if((arg12 & 0x30) == 0) {
            v1 = arg11.changedInstance(arg10) ? v2 : 16;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(this) ? 0x100 : 0x80;
            v1 |= v3;
        }

        arg11.startMovableGroup(0xEAA4AD0E, Integer.valueOf(arg9.length));
        int v4 = 4;
        v3 = arg11.changed(arg9.length) ? v4 : 0;
        v1 |= v3;
        v3 = arg9.length;
        int v6;
        for(v6 = 0; v6 < v3; ++v6) {
            int v7 = arg11.changedInstance(arg9[v6]) ? v4 : 0;
            v1 |= v7;
        }

        arg11.endMovableGroup();
        if((v1 & 14) == 0) {
            v1 |= 2;
        }

        v6 = 1;
        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
            }

            SpreadBuilder v0_1 = new SpreadBuilder(2);
            v0_1.add(arg10);
            v0_1.addSpread(arg9);
            Object[] v0_2 = v0_1.toArray(new Object[v0_1.size()]);
            ComposerKt.sourceInformationMarkerStart(arg11, -358303338, "CC(remember):TextLinkScope.kt#9igjgp");
            v3_1 = arg11.changedInstance(this);
            if((v1 & 0x70) == v2) {
            }
            else {
                v6 = 0;
            }

            Object v2_1 = arg11.rememberedValue();
            if(((((int)v3_1)) | v6) != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new TextLinkScope$$ExternalSyntheticLambda7(this, arg10);
                arg11.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            EffectsKt.DisposableEffect(v0_2, ((Function1)v2_2), arg11, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_99;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_99:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new TextLinkScope$$ExternalSyntheticLambda8(this, arg9, arg10, arg12));
        }
    }

    private static final DisposableEffectResult StyleAnnotation$lambda$0$0(TextLinkScope arg0, Function1 arg1, DisposableEffectScope arg2) {
        arg0.annotators.add(arg1);
        return new TextLinkScope$StyleAnnotation$lambda$0$0$$inlined$onDispose$1(arg0, arg1);
    }

    static final Unit StyleAnnotation$lambda$1(TextLinkScope arg0, Object[] arg1, Function1 arg2, int arg3, Composer arg4, int arg5) {
        arg0.StyleAnnotation(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final boolean _get_shouldMeasureLinks_$lambda$0(TextLinkScope arg1) {
        AnnotatedString v1_2;
        AnnotatedString v0 = arg1.text;
        TextLayoutResult v1 = arg1.getTextLayoutResult();
        if(v1 != null) {
            TextLayoutInput v1_1 = v1.getLayoutInput();
            if(v1_1 != null) {
                v1_2 = v1_1.getText();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            Object v1_3 = null;
        }

        return Intrinsics.areEqual(v0, v1_2);
    }

    static final List _init_$lambda$0(Range arg27) {
        ArrayList v0_2;
        SpanStyle v3_2;
        if((arg27.getItem() instanceof LinkAnnotation)) {
            Object v0 = arg27.getItem();
            String v3 = "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation";
            Intrinsics.checkNotNull(v0, v3);
            if(!TextLinkScopeKt.access$isNullOrEmpty(((LinkAnnotation)v0).getStyles())) {
                Range[] v0_1 = new Range[2];
                v0_1[0] = arg27;
                Object v4 = arg27.getItem();
                Intrinsics.checkNotNull(v4, v3);
                TextLinkStyles v3_1 = ((LinkAnnotation)v4).getStyles();
                if(v3_1 != null) {
                    v3_2 = v3_1.getStyle();
                    if(v3_2 == null) {
                        goto label_21;
                    }
                }
                else {
                label_21:
                    v3_2 = new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFF, null);
                }

                v0_1[1] = new Range(v3_2, arg27.getStart(), arg27.getEnd());
                v0_2 = CollectionsKt.arrayListOf(((Object[])v0_1));
            }
            else {
                goto label_48;
            }
        }
        else {
        label_48:
            v0_2 = CollectionsKt.arrayListOf(new Range[]{arg27});
        }

        return ((List)v0_2);
    }

    public static final SnapshotStateList access$getAnnotators$p(TextLinkScope arg0) {
        return arg0.annotators;
    }

    public final AnnotatedString applyAnnotators$foundation() {
        AnnotatedString v0;
        if(this.annotators.isEmpty()) {
            v0 = this.text;
        }
        else {
            TextAnnotatorScope v0_1 = new TextAnnotatorScope(this.text);
            SnapshotStateList v1 = this.annotators;
            int v2 = v1.size();
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                ((List)v1).get(v3).invoke(v0_1);
            }

            v0 = v0_1.getStyledText();
        }

        this.text = v0;
        return v0;
    }

    private final Range calculateVisibleLinkRange(Range arg8, TextLayoutResult arg9) {
        Object v2 = null;
        int v7 = TextLayoutResult.getLineEnd$default(arg9, arg9.getLineCount() - 1, false, 2, v2);
        if(arg8.getStart() < v7) {
            return Range.copy$default(arg8, null, 0, Math.min(arg8.getEnd(), v7), null, 11, null);
        }

        return ((Range)v2);
    }

    private final Modifier clipLink(Modifier arg2, Range arg3) {
        return GraphicsLayerModifierKt.graphicsLayer(arg2, new TextLinkScope$$ExternalSyntheticLambda0(this, arg3));
    }

    static final Unit clipLink$lambda$0(TextLinkScope arg0, Range arg1, GraphicsLayerScope arg2) {
        Shape v0 = arg0.shapeForRange(arg1);
        if(v0 != null) {
            arg2.setShape(v0);
            arg2.setClip(true);
        }

        return Unit.INSTANCE;
    }

    public final AnnotatedString getInitialText$foundation() {
        return this.initialText;
    }

    public final Function0 getShouldMeasureLinks() {
        return new TextLinkScope$$ExternalSyntheticLambda2(this);
    }

    public final AnnotatedString getText$foundation() {
        return this.text;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult$delegate.getValue();
    }

    private final void handleLink(LinkAnnotation arg1, UriHandler arg2) {
        LinkInteractionListener v0;
        if((arg1 instanceof Url)) {
            v0 = arg1.getLinkInteractionListener();
            if(v0 != null) {
                v0.onClick(arg1);
                return;
            }

            try {
                arg2.openUri(((Url)arg1).getUrl());
                return;
            }
            catch(IllegalArgumentException ) {
                return;
            }
        }

        if((arg1 instanceof Clickable)) {
            v0 = arg1.getLinkInteractionListener();
            if(v0 != null) {
                v0.onClick(arg1);
            }
        }
    }

    private final SpanStyle mergeOrUse(SpanStyle arg1, SpanStyle arg2) {
        if(arg1 != null) {
            SpanStyle v0 = arg1.merge(arg2);
            if(v0 == null) {
            }
            else {
                return v0;
            }
        }

        return arg2;
    }

    private final Path pathForRangeInRangeCoordinates(Range arg8) {
        Path v1 = null;
        if(!this.getShouldMeasureLinks().invoke().booleanValue()) {
            return v1;
        }

        TextLayoutResult v0 = this.getTextLayoutResult();
        if(v0 != null) {
            Range v7 = this.calculateVisibleLinkRange(arg8, v0);
            if(v7 == null) {
                return v1;
            }

            Path v8 = v0.getPathForRange(v7.getStart(), v7.getEnd());
            Rect v1_1 = v0.getBoundingBox(v7.getStart());
            Rect v2 = v0.getBoundingBox(v7.getEnd() - 1);
            float v7_1 = v0.getLineForOffset(v7.getStart()) == v0.getLineForOffset(v7.getEnd() - 1) ? Math.min(v2.getLeft(), v1_1.getLeft()) : 0f;
            v8.translate-k-4lQ0M(Offset.constructor-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(v7_1))) << 0x20 | (((long)Float.floatToRawIntBits(v1_1.getTop()))) & 0xFFFFFFFFL) ^ -9223372034707292160L));
            return v8;
        }

        return v1;
    }

    public final void setText$foundation(AnnotatedString arg1) {
        this.text = arg1;
    }

    public final void setTextLayoutResult(TextLayoutResult arg1) {
        this.textLayoutResult$delegate.setValue(arg1);
    }

    private final Shape shapeForRange(Range arg1) {
        Shape v1_1;
        Path v0 = this.pathForRangeInRangeCoordinates(arg1);
        if(v0 != null) {
            TextLinkScope$shapeForRange$1$1 v1 = new TextLinkScope$shapeForRange$1$1(v0);
        }
        else {
            v1_1 = null;
        }

        return v1_1;
    }

    private final Modifier textRange(Modifier arg3, Range arg4) {
        return arg3.then(new TextRangeLayoutModifier(new TextLinkScope$$ExternalSyntheticLambda3(this, arg4)));
    }

    static final TextRangeLayoutMeasureResult textRange$lambda$0(TextLinkScope arg2, Range arg3, TextRangeLayoutMeasureScope arg4) {
        TextLayoutResult v0 = arg2.getTextLayoutResult();
        if(v0 == null) {
            return arg4.layout(0, 0, new TextLinkScope$$ExternalSyntheticLambda4());
        }

        Range v2 = arg2.calculateVisibleLinkRange(arg3, v0);
        if(v2 == null) {
            return arg4.layout(0, 0, new TextLinkScope$$ExternalSyntheticLambda5());
        }

        IntRect v2_1 = IntRectKt.roundToIntRect(v0.getPathForRange(v2.getStart(), v2.getEnd()).getBounds());
        return arg4.layout(v2_1.getWidth(), v2_1.getHeight(), new TextLinkScope$$ExternalSyntheticLambda6(v2_1));
    }

    private static final IntOffset textRange$lambda$0$0() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    private static final IntOffset textRange$lambda$0$1() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    private static final IntOffset textRange$lambda$0$2(IntRect arg2) {
        return IntOffset.box-impl(arg2.getTopLeft-nOcc-ac());
    }
}

