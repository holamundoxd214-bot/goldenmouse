package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\u001A_\u0010\b\u001A?\u0012\u0014\u0012\u0012\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000B0\n\u0012%\u0012#\u0012\u001F\u0012\u001D\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\t*\u00020\r2\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000FH\u0000\u001A\f\u0010\u0011\u001A\u00020\u0012*\u00020\rH\u0000\u001A>\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\r2\'\u0010\u0015\u001A#\u0012\u001F\u0012\u001D\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\nH\u0001¢\u0006\u0002\u0010\u0016\"K\u0010\u0017\u001A?\u0012\u0014\u0012\u0012\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000B0\n\u0012%\u0012#\u0012\u001F\u0012\u001D\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*:\b\u0000\u0010\u0003\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u00012\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001¨\u0006\u0018"}, d2={"PlaceholderRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "InlineContentRange", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "resolveInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/foundation/text/PlaceholderRange;", "Landroidx/compose/foundation/text/InlineContentRange;", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "hasInlineContent", "", "InlineChildren", "text", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "EmptyInlineContent", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnnotatedStringResolveInlineContentKt {
    private static final Pair EmptyInlineContent;

    static {
        AnnotatedStringResolveInlineContentKt.EmptyInlineContent = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public static final void InlineChildren(AnnotatedString arg16, List arg17, Composer arg18, int arg19) {
        AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 v10_1;
        int v6;
        int v5;
        AnnotatedString v0 = arg16;
        List v1 = arg17;
        int v2 = arg19;
        int v3 = 0x95089FA9;
        Composer v4 = arg18.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(InlineChildren)N(text,inlineContents)*69@2714L269,69@2649L334:AnnotatedStringResolveInlineContent.kt#423gt5");
        if((v2 & 6) == 0) {
            v5 = v4.changed(v0) ? 4 : 2;
            v5 |= v2;
        }
        else {
            v5 = v2;
        }

        if((v2 & 0x30) == 0) {
            v6 = v4.changedInstance(v1) ? 0x20 : 16;
            v5 |= v6;
        }

        int v8 = 0;
        boolean v6_1 = (v5 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v6_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:67)");
            }

            v3 = v1.size();
            v5 = 0;
            while(v5 < v3) {
                Object v6_2 = v1.get(v5);
                Object v7 = ((Range)v6_2).component1();
                int v9 = ((Range)v6_2).component2();
                v6 = ((Range)v6_2).component3();
                ComposerKt.sourceInformationMarkerStart(v4, 0xDEBE10A0, "CC(remember):AnnotatedStringResolveInlineContent.kt#9igjgp");
                Object v10 = v4.rememberedValue();
                if(v10 == Composer.Companion.getEmpty()) {
                    v10_1 = AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1.INSTANCE;
                    v4.updateRememberedValue(v10_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerStart(v4, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                Companion v11 = Modifier.Companion;
                int v12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v4, v8));
                CompositionLocalMap v13 = v4.getCurrentCompositionLocalMap();
                Modifier v11_1 = ComposedModifierKt.materializeModifier(v4, ((Modifier)v11));
                Function0 v14 = ComposeUiNode.Companion.getConstructor();
                int v18 = v8;
                ComposerKt.sourceInformationMarkerStart(v4, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v14);
                }
                else {
                    v4.useNode();
                }

                Composer v8_1 = Updater.constructor-impl(v4);
                Updater.set-impl(v8_1, v10_1, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v8_1, v13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(v8_1, Integer.valueOf(v12), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(v8_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v8_1, v11_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x164C690F, "C69@2668L42:AnnotatedStringResolveInlineContent.kt#423gt5");
                ((Function3)v7).invoke(v0.subSequence(v9, v6).getText(), v4, Integer.valueOf(v18));
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ++v5;
                v8 = v18;
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_119;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_119:
        ScopeUpdateScope v3_1 = v4.endRestartGroup();
        if(v3_1 != null) {
            v3_1.updateScope(new AnnotatedStringResolveInlineContentKt$$ExternalSyntheticLambda0(v0, v1, v2));
        }
    }

    static final Unit InlineChildren$lambda$1(AnnotatedString arg0, List arg1, int arg2, Composer arg3, int arg4) {
        AnnotatedStringResolveInlineContentKt.InlineChildren(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean hasInlineContent(AnnotatedString arg3) {
        return arg3.hasStringAnnotations("androidx.compose.foundation.text.inlineContent", 0, arg3.getText().length());
    }

    public static final Pair resolveInlineContent(AnnotatedString arg10, Map arg11) {
        if(arg11 != null) {
            if(arg11.isEmpty()) {
            }
            else {
                int v2 = 0;
                List v10 = arg10.getStringAnnotations("androidx.compose.foundation.text.inlineContent", 0, arg10.getText().length());
                ArrayList v0 = new ArrayList();
                ArrayList v1 = new ArrayList();
                int v3 = v10.size();
                while(v2 < v3) {
                    Object v4 = v10.get(v2);
                    Object v5 = arg11.get(((Range)v4).getItem());
                    if(v5 != null) {
                        ((List)v0).add(new Range(((InlineTextContent)v5).getPlaceholder(), ((Range)v4).getStart(), ((Range)v4).getEnd()));
                        ((List)v1).add(new Range(((InlineTextContent)v5).getChildren(), ((Range)v4).getStart(), ((Range)v4).getEnd()));
                    }

                    ++v2;
                }

                return new Pair(v0, v1);
            }
        }

        return AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
    }
}

