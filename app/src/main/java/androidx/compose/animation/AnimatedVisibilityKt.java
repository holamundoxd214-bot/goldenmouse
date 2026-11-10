package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001A[\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001A_\u0010\u0000\u001A\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001A_\u0010\u0000\u001A\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001Aa\u0010\u0000\u001A\u00020\u00012\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001Ae\u0010\u0000\u001A\u00020\u0001*\u00020\u00122\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0019\u001Ae\u0010\u0000\u001A\u00020\u0001*\u00020\u00142\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001A\u001Am\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u001B*\b\u0012\u0004\u0012\u0002H\u001B0\u001C2\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001D\u001Ak\u0010\u001E\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u001B2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u001B0\u001C2\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010 \u001A\u0091\u0001\u0010!\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u001B2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u001B0\u001C2\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0018\u0010\"\u001A\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010&2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\'\u001A9\u0010+\u001A\u00020$\"\u0004\b\u0000\u0010\u001B*\b\u0012\u0004\u0012\u0002H\u001B0\u001C2\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010,\u001A\u0002H\u001BH\u0003¢\u0006\u0002\u0010-\"\u001E\u0010(\u001A\u00020\u0003*\b\u0012\u0004\u0012\u00020$0\u001C8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b)\u0010*¨\u0006.²\u0006\u001C\u0010/\u001A\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#X\u008A\u0084\u0002²\u0006\n\u00100\u001A\u00020\u0003X\u008A\u0084\u0002"}, d2={"AnimatedVisibility", "", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "T", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "transition", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedEnterExitImpl", "shouldDisposeBlock", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exitFinished", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimatedVisibilityKt {
    public static final void AnimatedEnterExitImpl(Transition arg23, Function1 arg24, Modifier arg25, EnterTransition arg26, ExitTransition arg27, Function2 arg28, OnLookaheadMeasured arg29, Function3 arg30, Composer arg31, int arg32, int arg33) {
        Composer v11;
        AnimatedEnterExitMeasurePolicy v4_3;
        Companion v0_6;
        Modifier v0_5;
        AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1 v0_4;
        AnimatedVisibilityScopeImpl v2_4;
        int v21;
        int v5;
        int v3;
        Transition v0 = arg23;
        Function1 v6 = arg24;
        Modifier v7 = arg25;
        Function2 v8 = arg28;
        OnLookaheadMeasured v1 = arg29;
        Function3 v9 = arg30;
        int v10 = arg32;
        int v2 = 0x72039C2F;
        Composer v4 = arg31.startRestartGroup(v2);
        ComposerKt.sourceInformation(v4, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4):AnimatedVisibility.kt#xbi5r1");
        if((v10 & 6) == 0) {
            v3 = v4.changed(v0) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        if((v10 & 0x30) == 0) {
            v5 = v4.changedInstance(v6) ? 0x20 : 16;
            v3 |= v5;
        }

        if((v10 & 0x180) == 0) {
            v5 = v4.changed(v7) ? 0x100 : 0x80;
            v3 |= v5;
        }

        EnterTransition v12 = arg26;
        if((v10 & 0xC00) == 0) {
            v5 = v4.changed(v12) ? 0x800 : 0x400;
            v3 |= v5;
        }

        ExitTransition v13 = arg27;
        if((v10 & 0x6000) == 0) {
            v5 = v4.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v5;
        }

        if((0x30000 & v10) == 0) {
            v5 = v4.changedInstance(v8) ? 0x20000 : 0x10000;
            v3 |= v5;
        }

        v5 = arg33 & 0x40;
        int v19 = 0x200000;
        int v15 = 0x180000;
        if(v5 != 0) {
        label_69:
            v3 |= v15;
        }
        else if((v15 & v10) == 0) {
            boolean v15_1 = (v10 & v19) == 0 ? v4.changed(v1) : v4.changedInstance(v1);
            if(v15_1) {
                v15 = 0x100000;
                goto label_69;
            }

            v15 = 0x80000;
            goto label_69;
        }

        if((0xC00000 & v10) == 0) {
            v15 = v4.changedInstance(v9) ? 0x800000 : 0x400000;
            v3 |= v15;
        }

        v15 = v3;
        int v20 = 1;
        boolean v3_1 = (0x492493 & v15) != 4793490 ? true : false;
        if(v4.shouldExecute(v3_1, v15 & 1)) {
            if(v5 != 0) {
                v1 = null;
            }

            v5 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v15, v5, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:715)");
            }

            v3 = 0xEFC48613;
            if((v6.invoke(v0.getTargetState()).booleanValue()) || (v6.invoke(v0.getCurrentState()).booleanValue()) || (v0.isSeeking()) || (v0.getHasInitialValueAnimations())) {
                v4.startReplaceGroup(0xF225A69D);
                ComposerKt.sourceInformation(v4, "723@40225L124,727@40392L40,733@40641L529,730@40484L686");
                v2 = v15 & 14;
                int v17 = v2 | 0x30;
                ComposerKt.sourceInformationMarkerStart(v4, 0xDFDABA57, "CC(createChildTransition)N(label,transformToChildState)1768@75281L36,1769@75341L74,1770@75438L39,1771@75489L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart(v4, 1410701659, "CC(remember):Transition.kt#9igjgp");
                v3 = v17 & 14;
                v5 = 4;
                v5 = (v3 ^ 6) > v5 && (v4.changed(v0)) || (v17 & 6) == v5 ? 1 : 0;
                Object v14 = v4.rememberedValue();
                if(v5 != 0 || v14 == Composer.Companion.getEmpty()) {
                    v14 = v0.getCurrentState();
                    v4.updateRememberedValue(v14);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                if(v0.isSeeking()) {
                    v14 = v0.getCurrentState();
                }

                v4.startReplaceGroup(0x6DEFB3B0);
                String v5_1 = "C724@40307L28:AnimatedVisibility.kt#xbi5r1";
                ComposerKt.sourceInformation(v4, v5_1);
                OnLookaheadMeasured v22 = v1;
                String v1_1 = "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)";
                if(ComposerKt.isTraceInProgress()) {
                    v21 = v2;
                    ComposerKt.traceEventStart(0x6DEFB3B0, 0, -1, v1_1);
                }
                else {
                    v21 = v2;
                }

                v2 = v15 & 0x7E;
                EnterExitState v10_1 = AnimatedVisibilityKt.targetEnterExit(v0, v6, v14, v4, v2);
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v4.endReplaceGroup();
                v14 = v0.getTargetState();
                int v11_1 = 0x6DEFB3B0;
                v4.startReplaceGroup(v11_1);
                ComposerKt.sourceInformation(v4, v5_1);
                EnterExitState v17_1 = v10_1;
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(v11_1, 0, -1, v1_1);
                }

                EnterExitState v2_1 = AnimatedVisibilityKt.targetEnterExit(v0, v6, v14, v4, v2);
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v4.endReplaceGroup();
                v10 = v21;
                v11_1 = 0xEFC48613;
                Transition v1_2 = TransitionKt.createChildTransitionInternal(v0, v17_1, v2_1, "EnterExitTransition", v4, v3 | 0xC00);
                ComposerKt.sourceInformationMarkerEnd(v4);
                State v0_1 = SnapshotStateKt.rememberUpdatedState(v8, v4, v15 >> 15 & 14);
                Object v2_2 = v8.invoke(v1_2.getCurrentState(), v1_2.getTargetState());
                v5_1 = "CC(remember):AnimatedVisibility.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v4, 0xFF8DCE20, v5_1);
                v3 = v4.changed(v1_2) | v4.changed(v0_1);
                v14 = v4.rememberedValue();
                if(v3 != 0 || v14 == Composer.Companion.getEmpty()) {
                    AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 v14_1 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(v1_2, v0_1, null);
                    v4.updateRememberedValue(v14_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                State v2_3 = SnapshotStateKt.produceState(v2_2, ((Function2)v14), v4, 0);
                if(!AnimatedVisibilityKt.getExitFinished(v1_2) || !AnimatedVisibilityKt.AnimatedEnterExitImpl$lambda$3(v2_3)) {
                    v4.startReplaceGroup(0xF2355E13);
                    ComposerKt.sourceInformation(v4, "749@41268L69,755@41536L47,769@42351L50,750@41350L1066");
                    ComposerKt.sourceInformationMarkerStart(v4, 0xFF8E1AB4, v5_1);
                    v10 = v10 == 4 ? 1 : 0;
                    v2_2 = v4.rememberedValue();
                    if(v10 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                        v2_4 = new AnimatedVisibilityScopeImpl(v1_2);
                        v4.updateRememberedValue(v2_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v3 = v15 >> 6;
                    v17 = v3 & 0x70 | 0x6000 | v3 & 0x380;
                    v3 = v15;
                    Transition v11_2 = v1_2;
                    Composer v16 = v4;
                    v1 = v22;
                    int v0_2 = 0x100000;
                    Modifier v4_1 = EnterExitTransitionKt.createModifier(v11_2, v12, v13, null, "Built-in", v16, v17, 4);
                    v11 = v16;
                    if(v1 != null) {
                        v11.startReplaceGroup(-230964196);
                        ComposerKt.sourceInformation(v11, "758@41738L479");
                        Companion v12_1 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart(v11, 0xFF8E570E, v5_1);
                        if((0x380000 & v3) != v0_2 && ((v3 & v19) == 0 || !v11.changedInstance(v1))) {
                            v20 = 0;
                        }

                        Object v0_3 = v11.rememberedValue();
                        if(v20 != 0 || v0_3 == Composer.Companion.getEmpty()) {
                            v0_4 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1(v1);
                            v11.updateRememberedValue(v0_4);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v11);
                        v0_5 = LayoutModifierKt.layout(((Modifier)v12_1), ((Function3)v0_4));
                        v11.endReplaceGroup();
                    }
                    else {
                        v11.startReplaceGroup(0xFF8E9617);
                        v11.endReplaceGroup();
                        v0_6 = Modifier.Companion;
                    }

                    v0_5 = v7.then(v4_1.then(((Modifier)v0_6)));
                    ComposerKt.sourceInformationMarkerStart(v11, 0xFF8EA201, v5_1);
                    Object v4_2 = v11.rememberedValue();
                    if(v4_2 == Composer.Companion.getEmpty()) {
                        v4_3 = new AnimatedEnterExitMeasurePolicy(v2_4);
                        v11.updateRememberedValue(v4_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v11);
                    ComposerKt.sourceInformationMarkerStart(v11, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    v5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v11, 0));
                    CompositionLocalMap v10_2 = v11.getCurrentCompositionLocalMap();
                    v0_5 = ComposedModifierKt.materializeModifier(v11, v0_5);
                    Function0 v12_2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(v11, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if(!(v11.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }

                    v11.startReusableNode();
                    if(v11.getInserting()) {
                        v11.createNode(v12_2);
                    }
                    else {
                        v11.useNode();
                    }

                    Composer v12_3 = Updater.constructor-impl(v11);
                    Updater.set-impl(v12_3, v4_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(v12_3, v10_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl(v12_3, Integer.valueOf(v5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl(v12_3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl(v12_3, v0_5, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(v11, -1766274760, "C751@41392L9:AnimatedVisibility.kt#xbi5r1");
                    v9.invoke(v2_4, v11, Integer.valueOf(v3 >> 18 & 0x70));
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    v11.endNode();
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    v11.endReplaceGroup();
                }
                else {
                    v4.startReplaceGroup(v11_1);
                    v4.endReplaceGroup();
                    v11 = v4;
                    v1 = v22;
                }

                v11.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(v3);
                v4.endReplaceGroup();
                v11 = v4;
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_380;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11 = v4;
            v11.skipToGroupEnd();
        }

    label_380:
        ScopeUpdateScope v11_3 = v11.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new AnimatedVisibilityKt$AnimatedEnterExitImpl$4(arg23, v6, v7, arg26, arg27, v8, v1, v9, arg32, arg33));
        }
    }

    private static final Function2 AnimatedEnterExitImpl$lambda$1(State arg0) {
        return arg0.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$3(State arg0) {
        return arg0.getValue().booleanValue();
    }

    public static final void AnimatedVisibility(MutableTransitionState arg23, Modifier arg24, EnterTransition arg25, ExitTransition arg26, String arg27, Function3 arg28, Composer arg29, int arg30, int arg31) {
        Modifier v2_3;
        ExitTransition v4_1;
        EnterTransition v3_2;
        String v5_1;
        AnimatedVisibilityKt$AnimatedVisibility$7$1 v0_1;
        Modifier v10_2;
        int v12;
        int v10;
        ExitTransition v9;
        int v8;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v2_1;
        MutableTransitionState v1 = arg23;
        int v7 = arg30;
        Composer v14 = arg29.startRestartGroup(0x272964F3);
        ComposerKt.sourceInformation(v14, "C(AnimatedVisibility)P(5,4,1,2,3)377@21247L39,378@21326L6,378@21291L84:AnimatedVisibility.kt#xbi5r1");
        if((v7 & 6) == 0) {
            boolean v2 = (v7 & 8) == 0 ? v14.changed(v1) : v14.changedInstance(v1);
            v2_1 = v2 ? 4 : 2;
            v2_1 |= v7;
        }
        else {
            v2_1 = v7;
        }

        int v3 = arg31 & 2;
        if(v3 != 0) {
            v2_1 |= 0x30;
            goto label_35;
        }
        else if((v7 & 0x30) == 0) {
            v4 = arg24;
            v5 = v14.changed(v4) ? 0x20 : 16;
            v2_1 |= v5;
        }
        else {
        label_35:
            v4 = arg24;
        }

        v5 = arg31 & 4;
        if(v5 != 0) {
            v2_1 |= 0x180;
            goto label_50;
        }
        else if((v7 & 0x180) == 0) {
            v6 = arg25;
            v8 = v14.changed(v6) ? 0x100 : 0x80;
            v2_1 |= v8;
        }
        else {
        label_50:
            v6 = arg25;
        }

        v8 = arg31 & 8;
        if(v8 != 0) {
            v2_1 |= 0xC00;
            goto label_65;
        }
        else if((v7 & 0xC00) == 0) {
            v9 = arg26;
            v10 = v14.changed(v9) ? 0x800 : 0x400;
            v2_1 |= v10;
        }
        else {
        label_65:
            v9 = arg26;
        }

        v10 = arg31 & 16;
        if(v10 != 0) {
            v2_1 |= 0x6000;
        }
        else if((v7 & 0x6000) == 0) {
            v12 = v14.changed(arg27) ? 0x4000 : 0x2000;
            v2_1 |= v12;
        }

        Function3 v13 = arg28;
        if((0x30000 & v7) == 0) {
            v12 = v14.changedInstance(v13) ? 0x20000 : 0x10000;
            v2_1 |= v12;
        }

        boolean v12_1 = (74899 & v2_1) != 74898 ? true : false;
        if(v14.shouldExecute(v12_1, v2_1 & 1)) {
            if(v3 != 0) {
                int v22 = v10;
                Companion v10_1 = Modifier.Companion;
                v3 = v22;
            }
            else {
                v3 = v10;
                v10_2 = v4;
            }

            v12 = 3;
            FiniteAnimationSpec v15 = null;
            EnterTransition v11 = v5 != 0 ? EnterExitTransitionKt.fadeIn$default(v15, 0f, v12, v15).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : v6;
            ExitTransition v12_2 = v8 != 0 ? EnterExitTransitionKt.fadeOut$default(v15, 0f, v12, v15).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null)) : v9;
            String v3_1 = v3 != 0 ? "AnimatedVisibility" : arg27;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x272964F3, v2_1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
            }

            Transition v8_1 = TransitionKt.rememberTransition(v1, v3_1, v14, MutableTransitionState.$stable | v2_1 & 14 | v2_1 >> 9 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v14.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = AnimatedVisibilityKt$AnimatedVisibility$7$1.INSTANCE;
                v14.updateRememberedValue(v0_1);
            }

            Object v9_1 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v14);
            int v0_2 = v2_1 << 3;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v8_1, ((Function1)v9_1), v10_2, v11, v12_2, v13, v14, v0_2 & 0xE000 | (v0_2 & 0x380 | 0x30 | v0_2 & 0x1C00) | v2_1 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v3_1;
            Companion v2_2 = ((Companion)v10_2);
            v3_2 = v11;
            v4_1 = v12_2;
        }
        else {
            v14.skipToGroupEnd();
            v5_1 = arg27;
            v2_3 = v4;
            v3_2 = v6;
            v4_1 = v9;
        }

        ScopeUpdateScope v9_2 = v14.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$8(v1, v2_3, v3_2, v4_1, v5_1, arg28, v7, arg31));
        }
    }

    public static final void AnimatedVisibility(Transition arg21, Function1 arg22, Modifier arg23, EnterTransition arg24, ExitTransition arg25, Function3 arg26, Composer arg27, int arg28, int arg29) {
        ExitTransition v5_1;
        EnterTransition v4_1;
        Modifier v10_1;
        int v11;
        int v6;
        EnterTransition v5;
        int v4;
        Modifier v3;
        int v2;
        int v1;
        int v7 = arg28;
        int v0 = 0x9AAFE98E;
        Composer v14 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(AnimatedVisibility)P(4,3,1,2)593@34536L79:AnimatedVisibility.kt#xbi5r1");
        Transition v8 = arg21;
        if((v7 & 6) == 0) {
            v1 = v14.changed(v8) ? 4 : 2;
            v1 |= v7;
        }
        else {
            v1 = v7;
        }

        Function1 v9 = arg22;
        if((v7 & 0x30) == 0) {
            v2 = v14.changedInstance(v9) ? 0x20 : 16;
            v1 |= v2;
        }

        v2 = arg29 & 2;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_40;
        }
        else if((v7 & 0x180) == 0) {
            v3 = arg23;
            v4 = v14.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_40:
            v3 = arg23;
        }

        v4 = arg29 & 4;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_55;
        }
        else if((v7 & 0xC00) == 0) {
            v5 = arg24;
            v6 = v14.changed(v5) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_55:
            v5 = arg24;
        }

        v6 = arg29 & 8;
        if(v6 != 0) {
            v1 |= 0x6000;
        }
        else if((v7 & 0x6000) == 0) {
            v11 = v14.changed(arg25) ? 0x4000 : 0x2000;
            v1 |= v11;
        }

        Function3 v13 = arg26;
        if((0x30000 & v7) == 0) {
            v11 = v14.changedInstance(v13) ? 0x20000 : 0x10000;
            v1 |= v11;
        }

        boolean v11_1 = (74899 & v1) != 74898 ? true : false;
        if(v14.shouldExecute(v11_1, v1 & 1)) {
            if(v2 != 0) {
                Companion v10 = Modifier.Companion;
            }
            else {
                v10_1 = v3;
            }

            v2 = 3;
            FiniteAnimationSpec v11_2 = null;
            v4_1 = v4 != 0 ? EnterExitTransitionKt.fadeIn$default(v11_2, 0f, v2, v11_2).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : v5;
            ExitTransition v12 = v6 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(v11_2, 0f, v2, v11_2)) : arg25;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
            }

            EnterTransition v11_3 = v4_1;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v8, v9, v10_1, v11_3, v12, v13, v14, v1 & 0x7FFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v3_1 = ((Companion)v10_1);
            v4_1 = v11_3;
            v5_1 = v12;
        }
        else {
            v14.skipToGroupEnd();
            v4_1 = v5;
            v5_1 = arg25;
        }

        ScopeUpdateScope v9_1 = v14.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$13(arg21, arg22, v3, v4_1, v5_1, arg26, v7, arg29));
        }
    }

    public static final void AnimatedVisibility(ColumnScope arg23, MutableTransitionState arg24, Modifier arg25, EnterTransition arg26, ExitTransition arg27, String arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        ExitTransition v5_1;
        EnterTransition v4_2;
        Companion v3_2;
        String v6_1;
        Companion v11_1;
        int v12;
        int v10;
        ExitTransition v9;
        int v7;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v1_1;
        MutableTransitionState v2 = arg24;
        int v8 = arg31;
        Composer v15 = arg30.startRestartGroup(-1238803325);
        ComposerKt.sourceInformation(v15, "C(AnimatedVisibility)P(5,4,1,2,3)523@30218L39,524@30297L6,524@30262L84:AnimatedVisibility.kt#xbi5r1");
        if((v8 & 0x30) == 0) {
            boolean v1 = (v8 & 0x40) == 0 ? v15.changed(v2) : v15.changedInstance(v2);
            v1_1 = v1 ? 0x20 : 16;
            v1_1 |= v8;
        }
        else {
            v1_1 = v8;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v1_1 |= 0x180;
            goto label_35;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg25;
            v5 = v15.changed(v4) ? 0x100 : 0x80;
            v1_1 |= v5;
        }
        else {
        label_35:
            v4 = arg25;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v1_1 |= 0xC00;
            goto label_50;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg26;
            v7 = v15.changed(v6) ? 0x800 : 0x400;
            v1_1 |= v7;
        }
        else {
        label_50:
            v6 = arg26;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v1_1 |= 0x6000;
            goto label_65;
        }
        else if((v8 & 0x6000) == 0) {
            v9 = arg27;
            v10 = v15.changed(v9) ? 0x4000 : 0x2000;
            v1_1 |= v10;
        }
        else {
        label_65:
            v9 = arg27;
        }

        v10 = arg32 & 16;
        int v11 = 0x30000;
        if(v10 != 0) {
            v1_1 |= v11;
        }
        else if((v11 & v8) == 0) {
            v12 = v15.changed(arg28) ? 0x20000 : 0x10000;
            v1_1 |= v12;
        }

        Function3 v14 = arg29;
        if((0x180000 & v8) == 0) {
            v12 = v15.changedInstance(v14) ? 0x100000 : 0x80000;
            v1_1 |= v12;
        }

        boolean v12_1 = (0x92491 & v1_1) != 0x92490 ? true : false;
        if(v15.shouldExecute(v12_1, v1_1 & 1)) {
            if(v3 != 0) {
                v11_1 = Modifier.Companion;
            }
            else {
                Modifier v11_2 = v4;
            }

            int v4_1 = 3;
            FiniteAnimationSpec v12_2 = null;
            if(v5 != 0) {
                v6 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(v12_2, 0f, v4_1, v12_2));
            }

            ExitTransition v13 = v7 != 0 ? EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(v12_2, 0f, v4_1, v12_2)) : v9;
            String v3_1 = v10 != 0 ? "AnimatedVisibility" : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1238803325, v1_1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
            }

            v7 = v1_1 >> 3;
            Transition v9_1 = TransitionKt.rememberTransition(v2, v3_1, v15, MutableTransitionState.$stable | v7 & 14 | v1_1 >> 12 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v15, 0xD1448009, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v15.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                AnimatedVisibilityKt$AnimatedVisibility$11$1 v0_1 = AnimatedVisibilityKt$AnimatedVisibility$11$1.INSTANCE;
                v15.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EnterTransition v12_3 = v6;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v9_1, v0, ((Modifier)v11_1), v12_3, v13, v14, v15, v1_1 & 0x380 | 0x30 | v1_1 & 0x1C00 | v1_1 & 0xE000 | 0x70000 & v7);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v3_1;
            v3_2 = v11_1;
            v4_2 = v12_3;
            v5_1 = v13;
        }
        else {
            v15.skipToGroupEnd();
            Modifier v3_3 = v4;
            v4_2 = v6;
            v5_1 = v9;
            v6_1 = arg28;
        }

        ScopeUpdateScope v10_1 = v15.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$12(arg23, v2, ((Modifier)v3_2), v4_2, v5_1, v6_1, arg29, v8, arg32));
        }
    }

    public static final void AnimatedVisibility(ColumnScope arg23, boolean arg24, Modifier arg25, EnterTransition arg26, ExitTransition arg27, String arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        Modifier v3_3;
        ExitTransition v5_1;
        EnterTransition v4_2;
        String v6_1;
        AnimatedVisibilityKt$AnimatedVisibility$5$1 v0_1;
        Modifier v11_2;
        int v12;
        int v10;
        ExitTransition v9;
        int v7;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v1;
        int v8 = arg31;
        Composer v15 = arg30.startRestartGroup(0x6B47FAAB);
        ComposerKt.sourceInformation(v15, "C(AnimatedVisibility)P(5,4,1,2,3)278@15785L32,279@15857L6,279@15822L84:AnimatedVisibility.kt#xbi5r1");
        boolean v2 = arg24;
        if((v8 & 0x30) == 0) {
            v1 = v15.changed(v2) ? 0x20 : 16;
            v1 |= v8;
        }
        else {
            v1 = v8;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v1 |= 0x180;
            goto label_31;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg25;
            v5 = v15.changed(v4) ? 0x100 : 0x80;
            v1 |= v5;
        }
        else {
        label_31:
            v4 = arg25;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v1 |= 0xC00;
            goto label_46;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg26;
            v7 = v15.changed(v6) ? 0x800 : 0x400;
            v1 |= v7;
        }
        else {
        label_46:
            v6 = arg26;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v1 |= 0x6000;
            goto label_61;
        }
        else if((v8 & 0x6000) == 0) {
            v9 = arg27;
            v10 = v15.changed(v9) ? 0x4000 : 0x2000;
            v1 |= v10;
        }
        else {
        label_61:
            v9 = arg27;
        }

        v10 = arg32 & 16;
        int v11 = 0x30000;
        if(v10 != 0) {
            v1 |= v11;
        }
        else if((v11 & v8) == 0) {
            v12 = v15.changed(arg28) ? 0x20000 : 0x10000;
            v1 |= v12;
        }

        Function3 v14 = arg29;
        if((0x180000 & v8) == 0) {
            v12 = v15.changedInstance(v14) ? 0x100000 : 0x80000;
            v1 |= v12;
        }

        boolean v12_1 = (0x92491 & v1) != 0x92490 ? true : false;
        if(v15.shouldExecute(v12_1, v1 & 1)) {
            if(v3 != 0) {
                Companion v11_1 = Modifier.Companion;
            }
            else {
                v11_2 = v4;
            }

            int v4_1 = 3;
            FiniteAnimationSpec v12_2 = null;
            if(v5 != 0) {
                v6 = EnterExitTransitionKt.fadeIn$default(v12_2, 0f, v4_1, v12_2).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
            }

            ExitTransition v13 = v7 != 0 ? EnterExitTransitionKt.fadeOut$default(v12_2, 0f, v4_1, v12_2).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)) : v9;
            String v3_1 = v10 != 0 ? "AnimatedVisibility" : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x6B47FAAB, v1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
            }

            v5 = v1 >> 3;
            Transition v9_1 = TransitionKt.updateTransition(Boolean.valueOf(v2), v3_1, v15, v5 & 14 | v1 >> 12 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v15, 0xB9342F71, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v15.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = AnimatedVisibilityKt$AnimatedVisibility$5$1.INSTANCE;
                v15.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EnterTransition v12_3 = v6;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v9_1, v0_1, v11_2, v12_3, v13, v14, v15, v1 & 0x380 | 0x30 | v1 & 0x1C00 | v1 & 0xE000 | 0x70000 & v5);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v3_1;
            Companion v3_2 = ((Companion)v11_2);
            v4_2 = v12_3;
            v5_1 = v13;
        }
        else {
            v15.skipToGroupEnd();
            v3_3 = v4;
            v4_2 = v6;
            v5_1 = v9;
            v6_1 = arg28;
        }

        ScopeUpdateScope v10_1 = v15.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$6(arg23, v2, v3_3, v4_2, v5_1, v6_1, arg29, v8, arg32));
        }
    }

    public static final void AnimatedVisibility(RowScope arg23, MutableTransitionState arg24, Modifier arg25, EnterTransition arg26, ExitTransition arg27, String arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        ExitTransition v5_1;
        EnterTransition v4_2;
        Companion v3_2;
        String v6_1;
        AnimatedVisibilityKt$AnimatedVisibility$9$1 v0_1;
        Modifier v11_2;
        int v12;
        int v10;
        ExitTransition v9;
        int v7;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v1_1;
        MutableTransitionState v2 = arg24;
        int v8 = arg31;
        Composer v15 = arg30.startRestartGroup(1763490971);
        ComposerKt.sourceInformation(v15, "C(AnimatedVisibility)P(5,4,1,2,3)449@25685L39,450@25764L6,450@25729L84:AnimatedVisibility.kt#xbi5r1");
        if((v8 & 0x30) == 0) {
            boolean v1 = (v8 & 0x40) == 0 ? v15.changed(v2) : v15.changedInstance(v2);
            v1_1 = v1 ? 0x20 : 16;
            v1_1 |= v8;
        }
        else {
            v1_1 = v8;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v1_1 |= 0x180;
            goto label_35;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg25;
            v5 = v15.changed(v4) ? 0x100 : 0x80;
            v1_1 |= v5;
        }
        else {
        label_35:
            v4 = arg25;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v1_1 |= 0xC00;
            goto label_50;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg26;
            v7 = v15.changed(v6) ? 0x800 : 0x400;
            v1_1 |= v7;
        }
        else {
        label_50:
            v6 = arg26;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v1_1 |= 0x6000;
            goto label_65;
        }
        else if((v8 & 0x6000) == 0) {
            v9 = arg27;
            v10 = v15.changed(v9) ? 0x4000 : 0x2000;
            v1_1 |= v10;
        }
        else {
        label_65:
            v9 = arg27;
        }

        v10 = arg32 & 16;
        int v11 = 0x30000;
        if(v10 != 0) {
            v1_1 |= v11;
        }
        else if((v11 & v8) == 0) {
            v12 = v15.changed(arg28) ? 0x20000 : 0x10000;
            v1_1 |= v12;
        }

        Function3 v14 = arg29;
        if((0x180000 & v8) == 0) {
            v12 = v15.changedInstance(v14) ? 0x100000 : 0x80000;
            v1_1 |= v12;
        }

        boolean v12_1 = (0x92491 & v1_1) != 0x92490 ? true : false;
        if(v15.shouldExecute(v12_1, v1_1 & 1)) {
            if(v3 != 0) {
                Companion v11_1 = Modifier.Companion;
            }
            else {
                v11_2 = v4;
            }

            int v4_1 = 3;
            FiniteAnimationSpec v12_2 = null;
            if(v5 != 0) {
                v6 = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(v12_2, 0f, v4_1, v12_2));
            }

            ExitTransition v13 = v7 != 0 ? EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(v12_2, 0f, v4_1, v12_2)) : v9;
            String v3_1 = v10 != 0 ? "AnimatedVisibility" : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1763490971, v1_1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
            }

            v7 = v1_1 >> 3;
            Transition v9_1 = TransitionKt.rememberTransition(v2, v3_1, v15, MutableTransitionState.$stable | v7 & 14 | v1_1 >> 12 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v15, 0x94E03A41, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v15.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = AnimatedVisibilityKt$AnimatedVisibility$9$1.INSTANCE;
                v15.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EnterTransition v12_3 = v6;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v9_1, v0_1, v11_2, v12_3, v13, v14, v15, v1_1 & 0x380 | 0x30 | v1_1 & 0x1C00 | v1_1 & 0xE000 | 0x70000 & v7);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v3_1;
            v3_2 = ((Companion)v11_2);
            v4_2 = v12_3;
            v5_1 = v13;
        }
        else {
            v15.skipToGroupEnd();
            Modifier v3_3 = v4;
            v4_2 = v6;
            v5_1 = v9;
            v6_1 = arg28;
        }

        ScopeUpdateScope v10_1 = v15.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$10(arg23, v2, ((Modifier)v3_2), v4_2, v5_1, v6_1, arg29, v8, arg32));
        }
    }

    public static final void AnimatedVisibility(RowScope arg23, boolean arg24, Modifier arg25, EnterTransition arg26, ExitTransition arg27, String arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        Modifier v3_3;
        ExitTransition v5_1;
        EnterTransition v4_2;
        String v6_1;
        AnimatedVisibilityKt$AnimatedVisibility$3$1 v0_1;
        Modifier v11_2;
        int v12;
        int v10;
        ExitTransition v9;
        int v7;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v1;
        int v8 = arg31;
        Composer v15 = arg30.startRestartGroup(234057107);
        ComposerKt.sourceInformation(v15, "C(AnimatedVisibility)P(5,4,1,2,3)205@11418L32,206@11490L6,206@11455L84:AnimatedVisibility.kt#xbi5r1");
        boolean v2 = arg24;
        if((v8 & 0x30) == 0) {
            v1 = v15.changed(v2) ? 0x20 : 16;
            v1 |= v8;
        }
        else {
            v1 = v8;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v1 |= 0x180;
            goto label_31;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg25;
            v5 = v15.changed(v4) ? 0x100 : 0x80;
            v1 |= v5;
        }
        else {
        label_31:
            v4 = arg25;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v1 |= 0xC00;
            goto label_46;
        }
        else if((v8 & 0xC00) == 0) {
            v6 = arg26;
            v7 = v15.changed(v6) ? 0x800 : 0x400;
            v1 |= v7;
        }
        else {
        label_46:
            v6 = arg26;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v1 |= 0x6000;
            goto label_61;
        }
        else if((v8 & 0x6000) == 0) {
            v9 = arg27;
            v10 = v15.changed(v9) ? 0x4000 : 0x2000;
            v1 |= v10;
        }
        else {
        label_61:
            v9 = arg27;
        }

        v10 = arg32 & 16;
        int v11 = 0x30000;
        if(v10 != 0) {
            v1 |= v11;
        }
        else if((v11 & v8) == 0) {
            v12 = v15.changed(arg28) ? 0x20000 : 0x10000;
            v1 |= v12;
        }

        Function3 v14 = arg29;
        if((0x180000 & v8) == 0) {
            v12 = v15.changedInstance(v14) ? 0x100000 : 0x80000;
            v1 |= v12;
        }

        boolean v12_1 = (0x92491 & v1) != 0x92490 ? true : false;
        if(v15.shouldExecute(v12_1, v1 & 1)) {
            if(v3 != 0) {
                Companion v11_1 = Modifier.Companion;
            }
            else {
                v11_2 = v4;
            }

            int v4_1 = 3;
            FiniteAnimationSpec v12_2 = null;
            if(v5 != 0) {
                v6 = EnterExitTransitionKt.fadeIn$default(v12_2, 0f, v4_1, v12_2).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
            }

            ExitTransition v13 = v7 != 0 ? EnterExitTransitionKt.fadeOut$default(v12_2, 0f, v4_1, v12_2).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null)) : v9;
            String v3_1 = v10 != 0 ? "AnimatedVisibility" : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(234057107, v1, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
            }

            v5 = v1 >> 3;
            Transition v9_1 = TransitionKt.updateTransition(Boolean.valueOf(v2), v3_1, v15, v5 & 14 | v1 >> 12 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v15, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v15.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = AnimatedVisibilityKt$AnimatedVisibility$3$1.INSTANCE;
                v15.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EnterTransition v12_3 = v6;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v9_1, v0_1, v11_2, v12_3, v13, v14, v15, v1 & 0x380 | 0x30 | v1 & 0x1C00 | v1 & 0xE000 | 0x70000 & v5);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v3_1;
            Companion v3_2 = ((Companion)v11_2);
            v4_2 = v12_3;
            v5_1 = v13;
        }
        else {
            v15.skipToGroupEnd();
            v3_3 = v4;
            v4_2 = v6;
            v5_1 = v9;
            v6_1 = arg28;
        }

        ScopeUpdateScope v10_1 = v15.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$4(arg23, v2, v3_3, v4_2, v5_1, v6_1, arg29, v8, arg32));
        }
    }

    public static final void AnimatedVisibility(boolean arg23, Modifier arg24, EnterTransition arg25, ExitTransition arg26, String arg27, Function3 arg28, Composer arg29, int arg30, int arg31) {
        ExitTransition v4_1;
        EnterTransition v3_2;
        Companion v2_1;
        String v5_1;
        AnimatedVisibilityKt$AnimatedVisibility$1$1 v0_1;
        Companion v10_1;
        int v12;
        int v10;
        ExitTransition v9;
        int v8;
        EnterTransition v6;
        int v5;
        Modifier v4;
        int v2;
        boolean v1;
        int v7 = arg30;
        Composer v14 = arg29.startRestartGroup(0xA9A6203B);
        ComposerKt.sourceInformation(v14, "C(AnimatedVisibility)P(5,4,1,2,3)131@7032L32,132@7104L6,132@7069L84:AnimatedVisibility.kt#xbi5r1");
        if((v7 & 6) == 0) {
            v1 = arg23;
            v2 = v14.changed(v1) ? 4 : 2;
            v2 |= v7;
        }
        else {
            v1 = arg23;
            v2 = v7;
        }

        int v3 = arg31 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v7 & 0x30) == 0) {
            v4 = arg24;
            v5 = v14.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg24;
        }

        v5 = arg31 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v7 & 0x180) == 0) {
            v6 = arg25;
            v8 = v14.changed(v6) ? 0x100 : 0x80;
            v2 |= v8;
        }
        else {
        label_47:
            v6 = arg25;
        }

        v8 = arg31 & 8;
        if(v8 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v7 & 0xC00) == 0) {
            v9 = arg26;
            v10 = v14.changed(v9) ? 0x800 : 0x400;
            v2 |= v10;
        }
        else {
        label_62:
            v9 = arg26;
        }

        v10 = arg31 & 16;
        if(v10 != 0) {
            v2 |= 0x6000;
        }
        else if((v7 & 0x6000) == 0) {
            v12 = v14.changed(arg27) ? 0x4000 : 0x2000;
            v2 |= v12;
        }

        Function3 v13 = arg28;
        if((0x30000 & v7) == 0) {
            v12 = v14.changedInstance(v13) ? 0x20000 : 0x10000;
            v2 |= v12;
        }

        boolean v12_1 = (74899 & v2) != 74898 ? true : false;
        if(v14.shouldExecute(v12_1, v2 & 1)) {
            if(v3 != 0) {
                int v22 = v10;
                v10_1 = Modifier.Companion;
                v3 = v22;
            }
            else {
                v3 = v10;
                Modifier v10_2 = v4;
            }

            v12 = 3;
            FiniteAnimationSpec v15 = null;
            EnterTransition v11 = v5 != 0 ? EnterExitTransitionKt.fadeIn$default(v15, 0f, v12, v15).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : v6;
            ExitTransition v12_2 = v8 != 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(v15, 0f, v12, v15)) : v9;
            String v3_1 = v3 != 0 ? "AnimatedVisibility" : arg27;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xA9A6203B, v2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
            }

            Transition v8_1 = TransitionKt.updateTransition(Boolean.valueOf(v1), v3_1, v14, v2 & 14 | v2 >> 9 & 0x70, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0xD89F2DE1, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v0 = v14.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                v0_1 = AnimatedVisibilityKt$AnimatedVisibility$1$1.INSTANCE;
                v14.updateRememberedValue(v0_1);
            }

            Object v9_1 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v14);
            int v0_2 = v2 << 3;
            AnimatedVisibilityKt.AnimatedVisibilityImpl(v8_1, ((Function1)v9_1), ((Modifier)v10_1), v11, v12_2, v13, v14, v0_2 & 0xE000 | (v0_2 & 0x380 | 0x30 | v0_2 & 0x1C00) | v2 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v3_1;
            v2_1 = v10_1;
            v3_2 = v11;
            v4_1 = v12_2;
        }
        else {
            v14.skipToGroupEnd();
            v5_1 = arg27;
            Modifier v2_2 = v4;
            v3_2 = v6;
            v4_1 = v9;
        }

        ScopeUpdateScope v9_2 = v14.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new AnimatedVisibilityKt$AnimatedVisibility$2(v1, ((Modifier)v2_1), v3_2, v4_1, v5_1, arg28, v7, arg31));
        }
    }

    public static final void AnimatedVisibilityImpl(Transition arg17, Function1 arg18, Modifier arg19, EnterTransition arg20, ExitTransition arg21, Function3 arg22, Composer arg23, int arg24) {
        AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1 v6_2;
        int v9;
        ExitTransition v7_1;
        int v5;
        int v3;
        Transition v0 = arg17;
        Function1 v1 = arg18;
        Modifier v11 = arg19;
        int v12 = arg24;
        int v2 = 1706321816;
        Composer v8 = arg23.startRestartGroup(v2);
        ComposerKt.sourceInformation(v8, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)682@38821L423,694@39319L62,678@38691L724:AnimatedVisibility.kt#xbi5r1");
        int v4 = 4;
        if((v12 & 6) == 0) {
            v3 = v8.changed(v0) ? v4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v6 = 0x20;
        if((v12 & 0x30) == 0) {
            v5 = v8.changedInstance(v1) ? v6 : 16;
            v3 |= v5;
        }

        if((v12 & 0x180) == 0) {
            v5 = v8.changed(v11) ? 0x100 : 0x80;
            v3 |= v5;
        }

        if((v12 & 0xC00) == 0) {
            int v7 = v8.changed(arg20) ? 0x800 : 0x400;
            v3 |= v7;
        }

        if((v12 & 0x6000) == 0) {
            v7_1 = arg21;
            v9 = v8.changed(v7_1) ? 0x4000 : 0x2000;
            v3 |= v9;
        }
        else {
            v7_1 = arg21;
        }

        v9 = 0x30000;
        if((v12 & v9) == 0) {
            int v13 = v8.changedInstance(arg22) ? 0x20000 : 0x10000;
            v3 |= v13;
        }

        int v15 = 0;
        boolean v13_1 = (74899 & v3) != 74898 ? true : false;
        if(v8.shouldExecute(v13_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v3, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:677)");
            }

            String v13_2 = "CC(remember):AnimatedVisibility.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, -902229601, v13_2);
            v2 = v3 & 0x70;
            v6 = v2 == v6 ? 1 : 0;
            int v14 = v3 & 14;
            if(v14 == v4) {
                v15 = 1;
            }

            v4 = v6 | v15;
            Object v6_1 = v8.rememberedValue();
            if(v4 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = new AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1(v1, v0);
                v8.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v4_1 = LayoutModifierKt.layout(v11, ((Function3)v6_2));
            ComposerKt.sourceInformationMarkerStart(v8, -902214026, v13_2);
            v6_1 = v8.rememberedValue();
            if(v6_1 == Composer.Companion.getEmpty()) {
                AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1 v6_3 = AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1.INSTANCE;
                v8.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            AnimatedVisibilityKt.AnimatedEnterExitImpl(v0, v1, v4_1, arg20, v7_1, v6_1, null, arg22, v8, v2 | (v9 | v14) | v3 & 0x1C00 | 0xE000 & v3 | v3 << 6 & 0x1C00000, 0x40);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_144;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8.skipToGroupEnd();
        }

    label_144:
        ScopeUpdateScope v8_1 = v8.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new AnimatedVisibilityKt$AnimatedVisibilityImpl$3(arg17, arg18, v11, arg20, arg21, arg22, v12));
        }
    }

    public static final Function2 access$AnimatedEnterExitImpl$lambda$1(State arg0) {
        return AnimatedVisibilityKt.AnimatedEnterExitImpl$lambda$1(arg0);
    }

    public static final boolean access$getExitFinished(Transition arg0) {
        return AnimatedVisibilityKt.getExitFinished(arg0);
    }

    private static final boolean getExitFinished(Transition arg2) {
        if(arg2.getCurrentState() == EnterExitState.PostExit && arg2.getTargetState() == EnterExitState.PostExit) {
            return 1;
        }

        return 0;
    }

    private static final EnterExitState targetEnterExit(Transition arg3, Function1 arg4, Object arg5, Composer arg6, int arg7) {
        MutableState v7_1;
        EnterExitState v3;
        int v1 = 0x158D233E;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:833)");
        }

        arg6.startMovableGroup(0xE6D15D27, arg3);
        ComposerKt.sourceInformation(arg6, "");
        if(arg3.isSeeking()) {
            arg6.startReplaceGroup(0xF35A989F);
            arg6.endReplaceGroup();
            if(arg4.invoke(arg5).booleanValue()) {
                v3 = EnterExitState.Visible;
            }
            else if(arg4.invoke(arg3.getCurrentState()).booleanValue()) {
                v3 = EnterExitState.PostExit;
            }
            else {
                v3 = EnterExitState.PreEnter;
            }
        }
        else {
            arg6.startReplaceGroup(0xF35EC774);
            ComposerKt.sourceInformation(arg6, "845@44894L34");
            ComposerKt.sourceInformationMarkerStart(arg6, 0xE6D184A0, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object v7 = arg6.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                v7_1 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
                arg6.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            if(arg4.invoke(arg3.getCurrentState()).booleanValue()) {
                v7_1.setValue(Boolean.valueOf(true));
            }

            if(arg4.invoke(arg5).booleanValue()) {
                v3 = EnterExitState.Visible;
            }
            else if(v7_1.getValue().booleanValue()) {
                v3 = EnterExitState.PostExit;
            }
            else {
                v3 = EnterExitState.PreEnter;
            }

            arg6.endReplaceGroup();
        }

        arg6.endMovableGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3;
    }
}

