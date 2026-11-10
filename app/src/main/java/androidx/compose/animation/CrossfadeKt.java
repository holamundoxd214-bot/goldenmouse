package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001AX\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0017\u0010\u000B\u001A\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000E\u001AN\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\u000B\u001A\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000F\u001A\u0086\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f2&\u0010\u000B\u001A\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001A\u00020\bX\u008A\u0084\u0002"}, d2={"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation", "alpha"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CrossfadeKt {
    public static final void Crossfade(Transition arg17, Modifier arg18, FiniteAnimationSpec arg19, Function1 arg20, Function3 arg21, Composer arg22, int arg23, int arg24) {
        Object v18;
        Object v4;
        CrossfadeKt$Crossfade$3$1 v9_2;
        int v13;
        Function1 v12;
        int v11;
        FiniteAnimationSpec v10;
        int v9;
        Modifier v8;
        int v3;
        Transition v1 = arg17;
        Function3 v5 = arg21;
        int v6 = arg23;
        int v0 = 0x901999A2;
        Composer v2 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(Crossfade)P(3!1,2)100@4602L6,103@4692L64,104@4778L61,134@6037L111:Crossfade.kt#xbi5r1");
        if((v6 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v3 = v6;
        }

        int v7 = arg24 & 1;
        if(v7 != 0) {
            v3 |= 0x30;
            goto label_32;
        }
        else if((v6 & 0x30) == 0) {
            v8 = arg18;
            v9 = v2.changed(v8) ? 0x20 : 16;
            v3 |= v9;
        }
        else {
        label_32:
            v8 = arg18;
        }

        v9 = arg24 & 2;
        if(v9 != 0) {
            v3 |= 0x180;
            goto label_47;
        }
        else if((v6 & 0x180) == 0) {
            v10 = arg19;
            v11 = v2.changedInstance(v10) ? 0x100 : 0x80;
            v3 |= v11;
        }
        else {
        label_47:
            v10 = arg19;
        }

        v11 = arg24 & 4;
        if(v11 != 0) {
            v3 |= 0xC00;
            goto label_62;
        }
        else if((v6 & 0xC00) == 0) {
            v12 = arg20;
            v13 = v2.changedInstance(v12) ? 0x800 : 0x400;
            v3 |= v13;
        }
        else {
        label_62:
            v12 = arg20;
        }

        if((v6 & 0x6000) == 0) {
            v13 = v2.changedInstance(v5) ? 0x4000 : 0x2000;
            v3 |= v13;
        }

        boolean v13_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v13_1, v3 & 1)) {
            if(v7 != 0) {
                Companion v8_1 = Modifier.Companion;
            }

            if(v9 != 0) {
                TweenSpec v10_1 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }

            String v7_1 = "CC(remember):Crossfade.kt#9igjgp";
            if(v11 != 0) {
                ComposerKt.sourceInformationMarkerStart(v2, 0xF019CE28, v7_1);
                Object v9_1 = v2.rememberedValue();
                if(v9_1 == Composer.Companion.getEmpty()) {
                    v9_2 = CrossfadeKt$Crossfade$3$1.INSTANCE;
                    v2.updateRememberedValue(v9_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
            }
            else {
                Function1 v9_3 = v12;
            }

            int v12_1 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, v12_1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
            }

            ComposerKt.sourceInformationMarkerStart(v2, 0xF019D9A2, v7_1);
            Object v0_1 = v2.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                SnapshotStateList v0_2 = SnapshotStateKt.mutableStateListOf();
                v0_2.add(v1.getCurrentState());
                v2.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerStart(v2, 0xF019E45F, v7_1);
            Object v11_1 = v2.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                MutableScatterMap v11_2 = ScatterMapKt.mutableScatterMapOf();
                v2.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            String v14 = "";
            v12_1 = 0x12DA4980;
            if(Intrinsics.areEqual(v1.getCurrentState(), v1.getTargetState())) {
                v2.startReplaceGroup(0x13244968);
                ComposerKt.sourceInformation(v2, v14);
                if(((SnapshotStateList)v0_1).size() != 1 || !Intrinsics.areEqual(((SnapshotStateList)v0_1).get(0), v1.getTargetState())) {
                    v2.startReplaceGroup(0x1326563A);
                    ComposerKt.sourceInformation(v2, "109@5153L21");
                    v4 = v0_1;
                    ComposerKt.sourceInformationMarkerStart(v2, 0xF01A1317, v7_1);
                    v3 = (v3 & 14) == 4 ? 1 : 0;
                    Object v7_2 = v2.rememberedValue();
                    if(v3 != 0 || v7_2 == Composer.Companion.getEmpty()) {
                        CrossfadeKt$Crossfade$4$1 v7_3 = new CrossfadeKt$Crossfade$4$1(v1);
                        v2.updateRememberedValue(v7_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v2);
                    CollectionsKt.removeAll(((List)v4), ((Function1)v7_2));
                    ((MutableScatterMap)v11_1).clear();
                }
                else {
                    v2.startReplaceGroup(v12_1);
                }

                v2.endReplaceGroup();
            }
            else {
                v2.startReplaceGroup(v12_1);
            }

            v2.endReplaceGroup();
            if(!((MutableScatterMap)v11_1).contains(v1.getTargetState())) {
                v2.startReplaceGroup(0x132A41BB);
                ComposerKt.sourceInformation(v2, "*124@5720L295");
                Object v3_1 = v0_1;
                Iterator v4_1 = ((List)v3_1).iterator();
                v7 = 0;
                while(true) {
                    if(!v4_1.hasNext()) {
                        break;
                    }
                    else if(Intrinsics.areEqual(((Function1)v9_2).invoke(v4_1.next()), ((Function1)v9_2).invoke(v1.getTargetState()))) {
                    }
                    else {
                        ++v7;
                        continue;
                    }

                    goto label_197;
                }

                v7 = -1;
            label_197:
                if(v7 == -1) {
                    ((SnapshotStateList)v0_1).add(v1.getTargetState());
                }
                else {
                    ((SnapshotStateList)v0_1).set(v7, v1.getTargetState());
                }

                ((MutableScatterMap)v11_1).clear();
                int v4_2 = v3_1.size();
                v7 = 0;
                while(v7 < v4_2) {
                    Object v12_2 = ((List)v3_1).get(v7);
                    ((MutableScatterMap)v11_1).set(v12_2, ComposableLambdaKt.rememberComposableLambda(0xC84D180B, true, new CrossfadeKt$Crossfade$5$1(v1, v10, v12_2, v5), v2, 54));
                    ++v7;
                    v1 = arg17;
                    v0_1 = v0_1;
                }

                v18 = v0_1;
            }
            else {
                v18 = v0_1;
                v2.startReplaceGroup(v12_1);
            }

            v2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(v2, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v0_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v1_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v2, 0));
            CompositionLocalMap v3_2 = v2.getCurrentCompositionLocalMap();
            Modifier v4_3 = ComposedModifierKt.materializeModifier(v2, v8);
            Function0 v7_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v7_4);
            }
            else {
                v2.useNode();
            }

            Composer v7_5 = Updater.constructor-impl(v2);
            Updater.set-impl(v7_5, v0_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_5, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v7_5, Integer.valueOf(v1_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v7_5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v7_5, v4_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v2, -2039243542, "C:Crossfade.kt#xbi5r1");
            v2.startReplaceGroup(-1312707512);
            ComposerKt.sourceInformation(v2, v14);
            v0_1 = v18;
            v1_1 = v0_1.size();
            for(v3 = 0; v3 < v1_1; ++v3) {
                v4 = ((List)v0_1).get(v3);
                v2.startMovableGroup(0x45D4D0B9, ((Function1)v9_2).invoke(v4));
                ComposerKt.sourceInformation(v2, v14);
                v4 = ((MutableScatterMap)v11_1).get(v4);
                if(v4 == null) {
                    v2.startReplaceGroup(0x74C5D4D0);
                    v2.endReplaceGroup();
                }
                else {
                    v2.startReplaceGroup(0x45D4D551);
                    ComposerKt.sourceInformation(v2, "135@6130L8");
                    ((Function2)v4).invoke(v2, Integer.valueOf(0));
                    v2.endReplaceGroup();
                }

                v2.endMovableGroup();
            }

            v2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v9_2;
        }
        else {
            v2.skipToGroupEnd();
            Function1 v4_4 = v12;
        }

        FiniteAnimationSpec v3_3 = v10;
        ScopeUpdateScope v9_4 = v2.endRestartGroup();
        if(v9_4 != null) {
            v9_4.updateScope(new CrossfadeKt$Crossfade$7(arg17, v8, v3_3, ((Function1)v4), v5, v6, arg24));
        }
    }

    public static final void Crossfade(Object arg16, Modifier arg17, FiniteAnimationSpec arg18, String arg19, Function3 arg20, Composer arg21, int arg22, int arg23) {
        FiniteAnimationSpec v3_3;
        Modifier v2_3;
        String v4_1;
        TweenSpec v9;
        Modifier v8_2;
        int v10;
        int v8;
        FiniteAnimationSpec v7;
        int v5;
        Modifier v4;
        int v2_1;
        Object v1 = arg16;
        int v6 = arg22;
        int v0 = 0xE168F013;
        Composer v12 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(Crossfade)P(4,3!1,2)56@2427L36,57@2479L53:Crossfade.kt#xbi5r1");
        if((v6 & 6) == 0) {
            boolean v2 = (v6 & 8) == 0 ? v12.changed(v1) : v12.changedInstance(v1);
            v2_1 = v2 ? 4 : 2;
            v2_1 |= v6;
        }
        else {
            v2_1 = v6;
        }

        int v3 = arg23 & 2;
        if(v3 != 0) {
            v2_1 |= 0x30;
            goto label_35;
        }
        else if((v6 & 0x30) == 0) {
            v4 = arg17;
            v5 = v12.changed(v4) ? 0x20 : 16;
            v2_1 |= v5;
        }
        else {
        label_35:
            v4 = arg17;
        }

        v5 = arg23 & 4;
        if(v5 != 0) {
            v2_1 |= 0x180;
            goto label_50;
        }
        else if((v6 & 0x180) == 0) {
            v7 = arg18;
            v8 = v12.changedInstance(v7) ? 0x100 : 0x80;
            v2_1 |= v8;
        }
        else {
        label_50:
            v7 = arg18;
        }

        v8 = arg23 & 8;
        if(v8 != 0) {
            v2_1 |= 0xC00;
        }
        else if((v6 & 0xC00) == 0) {
            v10 = v12.changed(arg19) ? 0x800 : 0x400;
            v2_1 |= v10;
        }

        Function3 v11 = arg20;
        if((v6 & 0x6000) == 0) {
            v10 = v12.changedInstance(v11) ? 0x4000 : 0x2000;
            v2_1 |= v10;
        }

        boolean v10_1 = (v2_1 & 9363) != 9362 ? true : false;
        if(v12.shouldExecute(v10_1, v2_1 & 1)) {
            if(v3 != 0) {
                int v15 = v8;
                Companion v8_1 = Modifier.Companion;
                v3 = v15;
            }
            else {
                v3 = v8;
                v8_2 = v4;
            }

            if(v5 != 0) {
                v9 = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            else {
                FiniteAnimationSpec v9_1 = v7;
            }

            String v3_1 = v3 != 0 ? "Crossfade" : arg19;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2_1, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
            }

            CrossfadeKt.Crossfade(TransitionKt.updateTransition(v1, v3_1, v12, v2_1 & 14 | v2_1 >> 6 & 0x70, 0), v8_2, ((FiniteAnimationSpec)v9), null, v11, v12, v2_1 & 0xE3F0, 4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v3_1;
            Companion v2_2 = ((Companion)v8_2);
            TweenSpec v3_2 = v9;
        }
        else {
            v12.skipToGroupEnd();
            v2_3 = v4;
            v3_3 = v7;
            v4_1 = arg19;
        }

        ScopeUpdateScope v8_3 = v12.endRestartGroup();
        if(v8_3 != null) {
            v8_3.updateScope(new CrossfadeKt$Crossfade$1(v1, v2_3, v3_3, v4_1, arg20, v6, arg23));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Crossfade API now has a new label parameter added.") public static final void Crossfade(Object arg9, Modifier arg10, FiniteAnimationSpec arg11, Function3 arg12, Composer arg13, int arg14, int arg15) {
        FiniteAnimationSpec v12;
        Modifier v11_1;
        Function3 v13_2;
        TweenSpec v11;
        Companion v10;
        int v4;
        int v3;
        int v13_1;
        int v0 = 0xF6682030;
        Composer v6 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(Crossfade)P(3,2)69@2888L29,70@2933L53:Crossfade.kt#xbi5r1");
        int v1 = 2;
        if((arg14 & 6) == 0) {
            boolean v13 = (arg14 & 8) == 0 ? v6.changed(arg9) : v6.changedInstance(arg9);
            v13_1 = v13 ? 4 : v1;
            v13_1 |= arg14;
        }
        else {
            v13_1 = arg14;
        }

        int v2 = arg15 & 2;
        if(v2 != 0) {
            v13_1 |= 0x30;
        }
        else if((arg14 & 0x30) == 0) {
            v3 = v6.changed(arg10) ? 0x20 : 16;
            v13_1 |= v3;
        }

        v3 = arg15 & 4;
        if(v3 != 0) {
            v13_1 |= 0x180;
        }
        else if((arg14 & 0x180) == 0) {
            v4 = v6.changedInstance(arg11) ? 0x100 : 0x80;
            v13_1 |= v4;
        }

        if((arg14 & 0xC00) == 0) {
            v4 = v6.changedInstance(arg12) ? 0x800 : 0x400;
            v13_1 |= v4;
        }

        boolean v4_1 = (v13_1 & 0x493) != 1170 ? true : false;
        if(v6.shouldExecute(v4_1, v13_1 & 1)) {
            if(v2 != 0) {
                v10 = Modifier.Companion;
            }

            Modifier v2_1 = ((Modifier)v10);
            Easing v10_1 = null;
            if(v3 != 0) {
                v11 = AnimationSpecKt.tween$default(0, 0, v10_1, 7, v10_1);
            }

            FiniteAnimationSpec v3_1 = ((FiniteAnimationSpec)v11);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13_1, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:68)");
            }

            CrossfadeKt.Crossfade(TransitionKt.updateTransition(arg9, ((String)v10_1), v6, v13_1 & 14, v1), v2_1, v3_1, null, arg12, v6, v13_1 & 0x3F0 | v13_1 << 3 & 0xE000, 4);
            v13_2 = arg12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v11_1 = v2_1;
            v12 = v3_1;
        }
        else {
            v13_2 = arg12;
            v6.skipToGroupEnd();
            v12 = arg11;
            v11_1 = arg10;
        }

        ScopeUpdateScope v0_1 = v6.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new CrossfadeKt$Crossfade$2(arg9, v11_1, v12, v13_2, arg14, arg15));
        }
    }
}

