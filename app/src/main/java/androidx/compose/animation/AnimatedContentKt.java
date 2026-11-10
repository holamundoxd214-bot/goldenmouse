package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A´\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u001F\b\u0002\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2%\b\u0002\u0010\u000F\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001A-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001AP\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2>\b\u0002\u0010\u001C\u001A8\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001E\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001D0 0\u0014\u001A\u0015\u0010!\u001A\u00020\t*\u00020\"2\u0006\u0010#\u001A\u00020$H\u0086\u0004\u001A\u0015\u0010%\u001A\u00020\t*\u00020\"2\u0006\u0010#\u001A\u00020$H\u0087\u0004\u001A¬\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020(2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u001F\b\u0002\u0010\u0006\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2%\b\u0002\u0010\u000F\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001A-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010)\"\u0010\u0010&\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\'¨\u0006*"}, d2={"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "UnspecifiedSize", "J", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimatedContentKt {
    private static final long UnspecifiedSize;

    static {
        AnimatedContentKt.UnspecifiedSize = IntSize.constructor-impl(-9223372034707292160L);
    }

    public static final void AnimatedContent(Transition arg18, Modifier arg19, Function1 arg20, Alignment arg21, Function1 arg22, Function4 arg23, Composer arg24, int arg25, int arg26) {
        Modifier v2_3;
        AnimatedContentMeasurePolicy v1_2;
        Object v5_2;
        Function1 v3_2;
        String v14_2;
        SnapshotStateList v12_2;
        Object v13_1;
        Object v4_1;
        Companion v15_1;
        Function4 v14_1;
        Function1 v13;
        int v12;
        Alignment v11;
        int v10;
        Function1 v9;
        int v6;
        Modifier v5;
        int v2;
        Transition v1 = arg18;
        int v7 = arg25;
        Composer v8 = arg24.startRestartGroup(0x1E804E2F);
        ComposerKt.sourceInformation(v8, "C(AnimatedContent)P(3,4,1,2)765@38134L226,771@38459L6,774@38592L7,776@38628L114,780@38830L51,781@38903L69,867@43438L58,868@43530L45,874@43785L52,869@43580L264:AnimatedContent.kt#xbi5r1");
        if((v7 & 6) == 0) {
            v2 = v8.changed(v1) ? 4 : 2;
            v2 |= v7;
        }
        else {
            v2 = v7;
        }

        int v4 = arg26 & 1;
        if(v4 != 0) {
            v2 |= 0x30;
            goto label_31;
        }
        else if((v7 & 0x30) == 0) {
            v5 = arg19;
            v6 = v8.changed(v5) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_31:
            v5 = arg19;
        }

        v6 = arg26 & 2;
        if(v6 != 0) {
            v2 |= 0x180;
            goto label_46;
        }
        else if((v7 & 0x180) == 0) {
            v9 = arg20;
            v10 = v8.changedInstance(v9) ? 0x100 : 0x80;
            v2 |= v10;
        }
        else {
        label_46:
            v9 = arg20;
        }

        v10 = arg26 & 4;
        if(v10 != 0) {
            v2 |= 0xC00;
            goto label_61;
        }
        else if((v7 & 0xC00) == 0) {
            v11 = arg21;
            v12 = v8.changed(v11) ? 0x800 : 0x400;
            v2 |= v12;
        }
        else {
        label_61:
            v11 = arg21;
        }

        v12 = arg26 & 8;
        if(v12 != 0) {
            v2 |= 0x6000;
            goto label_76;
        }
        else if((v7 & 0x6000) == 0) {
            v13 = arg22;
            int v14 = v8.changedInstance(v13) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_76:
            v13 = arg22;
        }

        if((0x30000 & v7) == 0) {
            v14_1 = arg23;
            int v15 = v8.changedInstance(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
            v14_1 = arg23;
        }

        boolean v3 = (74899 & v2) != 74898 ? true : false;
        if(v8.shouldExecute(v3, v2 & 1)) {
            if(v4 != 0) {
                v15_1 = Modifier.Companion;
            }
            else {
                Modifier v15_2 = v5;
            }

            String v3_1 = "CC(remember):AnimatedContent.kt#9igjgp";
            if(v6 != 0) {
                ComposerKt.sourceInformationMarkerStart(v8, 0x7FA59271, v3_1);
                v4_1 = v8.rememberedValue();
                if(v4_1 == Composer.Companion.getEmpty()) {
                    AnimatedContentKt$AnimatedContent$4$1 v4_2 = AnimatedContentKt$AnimatedContent$4$1.INSTANCE;
                    v8.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                Object v9_1 = v4_1;
            }

            if(v10 != 0) {
                v11 = Alignment.Companion.getTopStart();
            }

            if(v12 != 0) {
                ComposerKt.sourceInformationMarkerStart(v8, 0x7FA5BA35, v3_1);
                v4_1 = v8.rememberedValue();
                if(v4_1 == Composer.Companion.getEmpty()) {
                    AnimatedContentKt$AnimatedContent$5$1 v4_3 = AnimatedContentKt$AnimatedContent$5$1.INSTANCE;
                    v8.updateRememberedValue(v4_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v13_1 = v4_1;
            }

            int v5_1 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1E804E2F, v2, v5_1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:773)");
            }

            ProvidableCompositionLocal v4_4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v4_1 = v8.consume(((CompositionLocal)v4_4));
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0x7FA5CFC1, v3_1);
            v2 &= 14;
            v6 = v2 == 4 ? 1 : 0;
            Object v10_1 = v8.rememberedValue();
            if(v6 != 0 || v10_1 == Composer.Companion.getEmpty()) {
                AnimatedContentTransitionScopeImpl v10_2 = new AnimatedContentTransitionScopeImpl(v1, v11, ((LayoutDirection)v4_1));
                v8.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0x7FA5E8C2, v3_1);
            v6 = v2 == 4 ? 1 : 0;
            Object v12_1 = v8.rememberedValue();
            if(v6 != 0 || v12_1 == Composer.Companion.getEmpty()) {
                v12_2 = SnapshotStateKt.mutableStateListOf(new Object[]{v1.getCurrentState()});
                v8.updateRememberedValue(v12_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0x7FA5F1F4, v3_1);
            v2 = v2 == 4 ? 1 : 0;
            Object v6_1 = v8.rememberedValue();
            if(v2 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                MutableScatterMap v6_2 = ScatterMapKt.mutableScatterMapOf();
                v8.updateRememberedValue(v6_2);
            }

            Object v2_1 = v6_1;
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(!v12_2.contains(v1.getCurrentState())) {
                v12_2.clear();
                v12_2.add(v1.getCurrentState());
            }

            if(Intrinsics.areEqual(v1.getCurrentState(), v1.getTargetState())) {
                if(v12_2.size() != 1 || !Intrinsics.areEqual(v12_2.get(0), v1.getCurrentState())) {
                    v12_2.clear();
                    v12_2.add(v1.getCurrentState());
                }

                if(((MutableScatterMap)v2_1).getSize() != 1 || (((MutableScatterMap)v2_1).containsKey(v1.getCurrentState()))) {
                    ((MutableScatterMap)v2_1).clear();
                }

                ((AnimatedContentTransitionScopeImpl)v10_1).setContentAlignment(v11);
                ((AnimatedContentTransitionScopeImpl)v10_1).setLayoutDirection$animation(((LayoutDirection)v4_1));
            }

            if(!Intrinsics.areEqual(v1.getCurrentState(), v1.getTargetState()) && !v12_2.contains(v1.getTargetState())) {
                Iterator v4_5 = v12_2.iterator();
                v5_1 = 0;
                while(true) {
                    if(!v4_5.hasNext()) {
                        break;
                    }
                    else if(Intrinsics.areEqual(((Function1)v13_1).invoke(v4_5.next()), ((Function1)v13_1).invoke(v1.getTargetState()))) {
                    }
                    else {
                        ++v5_1;
                        continue;
                    }

                    goto label_245;
                }

                v5_1 = -1;
            label_245:
                if(v5_1 == -1) {
                    v12_2.add(v1.getTargetState());
                    goto label_252;
                }

                v12_2.set(v5_1, v1.getTargetState());
            }

        label_252:
            if(!((MutableScatterMap)v2_1).containsKey(v1.getTargetState()) || !((MutableScatterMap)v2_1).containsKey(v1.getCurrentState())) {
                v8.startReplaceGroup(0x75350AD1);
                ComposerKt.sourceInformation(v8, "*817@40849L2545");
                ((MutableScatterMap)v2_1).clear();
                Object v0 = v12_2;
                v4 = v0.size();
                v5_1 = 0;
                while(v5_1 < v4) {
                    v6_1 = v2_1;
                    v2_1 = ((List)v0).get(v5_1);
                    v6_1.set(v2_1, ComposableLambdaKt.rememberComposableLambda(0xFE931559, true, new AnimatedContentKt$AnimatedContent$6$1(v1, v2_1, v9, v10_1, v12_2, v14_1), v8, 54));
                    v1 = arg18;
                    v9 = v9;
                    v2_1 = v6_1;
                    v3_1 = v3_1;
                    v14_1 = arg23;
                    v10_1 = v10_1;
                    v4 = v4;
                    v12_1 = v12_2;
                    ++v5_1;
                    v0 = v0;
                }

                v14_2 = v3_1;
                v3_2 = v9;
                v4_1 = v10_1;
                v5_2 = v12_2;
                v10_1 = v2_1;
                v8.endReplaceGroup();
            }
            else {
                v8.startReplaceGroup(0x72CB6333);
                v8.endReplaceGroup();
                v14_2 = v3_1;
                v3_2 = v9;
                v4_1 = v10_1;
                v5_2 = v12_2;
                v10_1 = v2_1;
            }

            Segment v0_1 = arg18.getSegment();
            ComposerKt.sourceInformationMarkerStart(v8, 0x7FA828C9, v14_2);
            int v0_2 = v8.changed(v0_1) | v8.changed(v4_1);
            Object v1_1 = v8.rememberedValue();
            if(v0_2 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                v1_1 = v3_2.invoke(v4_1);
                v8.updateRememberedValue(v1_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v0_3 = ((Modifier)v15_1).then(((AnimatedContentTransitionScopeImpl)v4_1).createSizeAnimationModifier$animation(((ContentTransform)v1_1), v8, 0));
            ComposerKt.sourceInformationMarkerStart(v8, 0x7FA85423, v14_2);
            v1_1 = v8.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = new AnimatedContentMeasurePolicy(((AnimatedContentTransitionScopeImpl)v4_1));
                v8.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v8, 0));
            CompositionLocalMap v4_6 = v8.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v8, v0_3);
            Function0 v6_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v8, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v6_3);
            }
            else {
                v8.useNode();
            }

            Composer v6_4 = Updater.constructor-impl(v8);
            Updater.set-impl(v6_4, v1_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_4, v4_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v6_4, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v6_4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v6_4, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, -895590996, "C:AnimatedContent.kt#xbi5r1");
            v8.startReplaceGroup(-860173498);
            String v0_4 = "";
            ComposerKt.sourceInformation(v8, v0_4);
            v12_1 = v5_2;
            int v1_3 = v12_1.size();
            for(v2 = 0; v2 < v1_3; ++v2) {
                v4_1 = ((List)v12_1).get(v2);
                v8.startMovableGroup(-2026002954, ((Function1)v13_1).invoke(v4_1));
                ComposerKt.sourceInformation(v8, v0_4);
                v4_1 = ((MutableScatterMap)v10_1).get(v4_1);
                if(v4_1 == null) {
                    v8.startReplaceGroup(0x6077A733);
                    v8.endReplaceGroup();
                }
                else {
                    v8.startReplaceGroup(-2026001778);
                    ComposerKt.sourceInformation(v8, "872@43737L8");
                    ((Function2)v4_1).invoke(v8, Integer.valueOf(0));
                    v8.endReplaceGroup();
                }

                v8.endMovableGroup();
            }

            v8.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_2 = v15_1;
        }
        else {
            v8.skipToGroupEnd();
            v2_3 = v5;
            v3_2 = v9;
        }

        Alignment v4_7 = v11;
        Function1 v5_3 = ((Function1)v13_1);
        ScopeUpdateScope v9_2 = v8.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new AnimatedContentKt$AnimatedContent$9(arg18, v2_3, v3_2, v4_7, v5_3, arg23, v7, arg26));
        }
    }

    public static final void AnimatedContent(Object arg19, Modifier arg20, Function1 arg21, Alignment arg22, String arg23, Function1 arg24, Function4 arg25, Composer arg26, int arg27, int arg28) {
        Modifier v2_3;
        Alignment v4;
        String v5_3;
        Object v13_2;
        Object v3_2;
        Alignment v12_1;
        Object v11;
        AnimatedContentKt$AnimatedContent$1$1 v5_2;
        int v0_1;
        Companion v10_1;
        int v18;
        Function4 v14_1;
        Function1 v13_1;
        int v12;
        int v10;
        Alignment v9;
        int v7;
        Function1 v6;
        int v5;
        int v2_1;
        Object v1 = arg19;
        int v8 = arg27;
        Composer v15 = arg26.startRestartGroup(0x598416E0);
        ComposerKt.sourceInformation(v15, "C(AnimatedContent)P(5,4,6,1,3,2)131@7139L226,138@7503L6,141@7610L58,142@7684L137:AnimatedContent.kt#xbi5r1");
        if((v8 & 6) == 0) {
            boolean v2 = (v8 & 8) == 0 ? v15.changed(v1) : v15.changedInstance(v1);
            v2_1 = v2 ? 4 : 2;
            v2_1 |= v8;
        }
        else {
            v2_1 = v8;
        }

        int v3 = arg28 & 2;
        if(v3 != 0) {
            v2_1 |= 0x30;
        }
        else if((v8 & 0x30) == 0) {
            v5 = v15.changed(arg20) ? 0x20 : 16;
            v2_1 |= v5;
        }

        v5 = arg28 & 4;
        if(v5 != 0) {
            v2_1 |= 0x180;
            goto label_50;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg21;
            v7 = v15.changedInstance(v6) ? 0x100 : 0x80;
            v2_1 |= v7;
        }
        else {
        label_50:
            v6 = arg21;
        }

        v7 = arg28 & 8;
        if(v7 != 0) {
            v2_1 |= 0xC00;
            goto label_65;
        }
        else if((v8 & 0xC00) == 0) {
            v9 = arg22;
            v10 = v15.changed(v9) ? 0x800 : 0x400;
            v2_1 |= v10;
        }
        else {
        label_65:
            v9 = arg22;
        }

        v10 = arg28 & 16;
        if(v10 != 0) {
            v2_1 |= 0x6000;
        }
        else if((v8 & 0x6000) == 0) {
            v12 = v15.changed(arg23) ? 0x4000 : 0x2000;
            v2_1 |= v12;
        }

        v12 = arg28 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v2_1 |= v13;
            goto label_96;
        }
        else if((v13 & v8) == 0) {
            v13_1 = arg24;
            int v14 = v15.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v2_1 |= v14;
        }
        else {
        label_96:
            v13_1 = arg24;
        }

        if((0x180000 & v8) == 0) {
            v14_1 = arg25;
            int v16 = v15.changedInstance(v14_1) ? 0x100000 : 0x80000;
            v2_1 |= v16;
        }
        else {
            v14_1 = arg25;
        }

        int v26 = v3;
        boolean v0 = (v2_1 & 0x92493) != 0x92492 ? true : false;
        if(v15.shouldExecute(v0, v2_1 & 1)) {
            if(v26 != 0) {
                v18 = v10;
                v10_1 = Modifier.Companion;
                v0_1 = v18;
            }
            else {
                v0_1 = v10;
                Modifier v10_2 = arg20;
            }

            String v3_1 = "CC(remember):AnimatedContent.kt#9igjgp";
            if(v5 != 0) {
                ComposerKt.sourceInformationMarkerStart(v15, 148501410, v3_1);
                Object v5_1 = v15.rememberedValue();
                if(v5_1 == Composer.Companion.getEmpty()) {
                    v5_2 = AnimatedContentKt$AnimatedContent$1$1.INSTANCE;
                    v15.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                v11 = v5_2;
            }
            else {
                Function1 v11_1 = v6;
            }

            if(v7 != 0) {
                v18 = v12;
                v12_1 = Alignment.Companion.getTopStart();
                v5 = v18;
            }
            else {
                v5 = v12;
                v12_1 = v9;
            }

            String v0_2 = v0_1 != 0 ? "AnimatedContent" : arg23;
            if(v5 != 0) {
                ComposerKt.sourceInformationMarkerStart(v15, 0x8DA2046, v3_1);
                v3_2 = v15.rememberedValue();
                if(v3_2 == Composer.Companion.getEmpty()) {
                    AnimatedContentKt$AnimatedContent$2$1 v3_3 = AnimatedContentKt$AnimatedContent$2$1.INSTANCE;
                    v15.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                v13_2 = v3_2;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x598416E0, v2_1, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
            }

            Transition v9_1 = TransitionKt.updateTransition(v1, v0_2, v15, v2_1 & 14 | v2_1 >> 9 & 0x70, 0);
            v3 = v2_1 & 0x1FF0;
            v2_1 >>= 3;
            AnimatedContentKt.AnimatedContent(v9_1, ((Modifier)v10_1), ((Function1)v11), v12_1, ((Function1)v13_2), v14_1, v15, v3 | 0xE000 & v2_1 | v2_1 & 0x70000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_3 = v0_2;
            Companion v2_2 = v10_1;
            v3_2 = v11;
            v4 = v12_1;
        }
        else {
            v15.skipToGroupEnd();
            v2_3 = arg20;
            v5_3 = arg23;
            Function1 v3_4 = v6;
            v4 = v9;
        }

        v6 = v13_1;
        ScopeUpdateScope v10_3 = v15.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new AnimatedContentKt$AnimatedContent$3(v1, v2_3, ((Function1)v3_2), v4, v5_3, v6, arg25, v8, arg28));
        }
    }

    public static final SizeTransform SizeTransform(boolean arg1, Function2 arg2) {
        return new SizeTransformImpl(arg1, arg2);
    }

    public static SizeTransform SizeTransform$default(boolean arg0, Function2 arg1, int arg2, Object arg3) {
        AnimatedContentKt$SizeTransform$1 v1;
        if((arg2 & 2) != 0) {
            v1 = AnimatedContentKt$SizeTransform$1.INSTANCE;
        }

        return AnimatedContentKt.SizeTransform(true, ((Function2)v1));
    }

    public static final long access$getUnspecifiedSize$p() {
        return AnimatedContentKt.UnspecifiedSize;
    }

    public static final ContentTransform togetherWith(EnterTransition arg7, ExitTransition arg8) {
        return new ContentTransform(arg7, arg8, 0f, null, 12, null);
    }

    @Deprecated(message="Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith="<_subannotation>") public static final ContentTransform with(EnterTransition arg7, ExitTransition arg8) {
        return new ContentTransform(arg7, arg8, 0f, null, 12, null);
    }
}

