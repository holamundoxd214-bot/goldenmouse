package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001A\u00020\nX\u008A\u0084\u0002²\u0006\n\u0010\u000B\u001A\u00020\nX\u008A\u0084\u0002"}, d2={"Landroidx/compose/material3/DefaultModalWideNavigationRailOverride;", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "<init>", "()V", "ModalWideNavigationRail", "", "Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "(Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "isCollapsed", "", "modalExpanded"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultModalWideNavigationRailOverride implements ModalWideNavigationRailOverride {
    public static final int $stable;
    public static final DefaultModalWideNavigationRailOverride INSTANCE;

    static {
        DefaultModalWideNavigationRailOverride.INSTANCE = new DefaultModalWideNavigationRailOverride();
    }

    private DefaultModalWideNavigationRailOverride() {
        super();
    }

    public void ModalWideNavigationRail(ModalWideNavigationRailOverrideScope arg30, Composer arg31, int arg32) {
        ModalWideNavigationRailOverrideScope v0_5;
        DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda4 v8_8;
        DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda2 v12_7;
        int v12_6;
        CoroutineScope v3_3;
        int v7_1;
        Object v8_1;
        BufferOverflow v4_1;
        int v27;
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1 v12_3;
        State v11_2;
        ModalWideNavigationRailState v13_1;
        Object v0_3;
        Function2 v10_1;
        Object v10;
        Function2 v0_1;
        int v2_1;
        ModalWideNavigationRailOverrideScope v1 = arg30;
        int v9 = arg32;
        int v0 = 0x6861BC89;
        Composer v15 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(ModalWideNavigationRail)509@25093L7,511@25254L14,513@25306L230,524@25833L7,521@25580L275,526@25892L60,527@25991L62,528@26105L132,535@26304L176,557@27012L48:WideNavigationRail.kt#uh7d8r");
        int v3 = 2;
        int v4 = 4;
        if((v9 & 6) == 0) {
            boolean v2 = (v9 & 8) == 0 ? v15.changed(v1) : v15.changedInstance(v1);
            v2_1 = v2 ? v4 : v3;
            v2_1 |= v9;
        }
        else {
            v2_1 = v9;
        }

        boolean v5 = (v2_1 & 3) != v3 ? true : false;
        if(v15.shouldExecute(v5, v2_1 & 1)) {
            int v8 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2_1, v8, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail (WideNavigationRail.kt:503)");
            }

            String v5_1 = "CC(remember):WideNavigationRail.kt#9igjgp";
            if(v1.getShouldHideOnCollapse()) {
                v15.startReplaceGroup(0x5B58352);
                v15.endReplaceGroup();
                v0_1 = v1.getContent();
            }
            else {
                v15.startReplaceGroup(95826602);
                ComposerKt.sourceInformation(v15, "507@25009L47");
                v0_1 = v1.getContent();
                ComposerKt.sourceInformationMarkerStart(v15, -689645480, v5_1);
                boolean v0_2 = v15.changed(v0_1);
                v10 = v15.rememberedValue();
                if((v0_2) || v10 == Composer.Companion.getEmpty()) {
                    v10_1 = MovableContentKt.movableContentOf(v1.getContent());
                    v15.updateRememberedValue(v10_1);
                }

                v0_3 = v10_1;
                ComposerKt.sourceInformationMarkerEnd(v15);
                v15.endReplaceGroup();
            }

            Function2 v18 = v0_1;
            ProvidableCompositionLocal v0_4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_3 = v15.consume(((CompositionLocal)v0_4));
            ComposerKt.sourceInformationMarkerEnd(v15);
            int v11 = 6;
            FiniteAnimationSpec v10_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v15, v11);
            WideNavigationRailState v12 = v1.getState();
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6E4FE2F, v5_1);
            boolean v12_1 = v15.changed(v12);
            Object v13 = v15.rememberedValue();
            if((v12_1) || v13 == Composer.Companion.getEmpty()) {
                v13_1 = new ModalWideNavigationRailState(v1.getState(), ((Density)v0_3), ((AnimationSpec)v10_2));
                v15.updateRememberedValue(v13_1);
            }

            v0_3 = v13_1;
            ComposerKt.sourceInformationMarkerEnd(v15);
            float v10_3 = !WideNavigationRailStateKt.isExpanded(v1.getState().getTargetValue()) ? 0f : 1f;
            v3 = v11;
            State v10_4 = AnimateAsStateKt.animateFloatAsState(v10_3, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v15, v11), 0f, null, null, v15, 0, 28);
            ComposerKt.sourceInformationMarkerStart(v15, 0xD6E546C5, v5_1);
            Object v11_1 = v15.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                v11_2 = SnapshotStateKt.derivedStateOf(new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda0(v10_4));
                v15.updateRememberedValue(v11_2);
            }

            Object v21 = v11_2;
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerStart(v15, -689614041, v5_1);
            v11_1 = v15.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                v11_2 = SnapshotStateKt.derivedStateOf(new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda1(v10_4));
                v15.updateRememberedValue(v11_2);
            }

            Object v22 = v11_1;
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerStart(v15, -689610323, v5_1);
            int v10_5 = v2_1 & 14;
            if(v10_5 != v4) {
                if((v2_1 & 8) != 0 && (v15.changedInstance(v1))) {
                    goto label_147;
                }

                v11 = 0;
            }
            else {
            label_147:
                v11 = 1;
            }

            v11 |= v15.changedInstance(v0_3);
            Object v12_2 = v15.rememberedValue();
            Continuation v13_2 = null;
            if(v11 != 0 || v12_2 == Composer.Companion.getEmpty()) {
                v12_3 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(v1, ((ModalWideNavigationRailState)v0_3), v13_2);
                v15.updateRememberedValue(v12_3);
            }

            Object v23 = v12_3;
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerStart(v15, -689603911, v5_1);
            if(v10_5 != v4) {
                if((v2_1 & 8) != 0 && (v15.changedInstance(v1))) {
                    goto label_172;
                }

                v11 = 0;
            }
            else {
            label_172:
                v11 = 1;
            }

            v11 |= v15.changedInstance(v0_3);
            v12_2 = v15.rememberedValue();
            if(v11 != 0 || v12_2 == Composer.Companion.getEmpty()) {
                DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 v12_4 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(v1, ((ModalWideNavigationRailState)v0_3), v13_2);
                v15.updateRememberedValue(v12_4);
            }

            Object v24 = v12_2;
            ComposerKt.sourceInformationMarkerEnd(v15);
            if((v1.getShouldHideOnCollapse()) || !DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$4(((State)v21))) {
                v27 = v10_5;
                v4_1 = ((BufferOverflow)v13_2);
                v15.startReplaceGroup(0x5D42199);
                v15.endReplaceGroup();
            }
            else {
                v15.startReplaceGroup(97400069);
                ComposerKt.sourceInformation(v15, "544@26598L380");
                v27 = v10_5;
                v4_1 = v13_2;
                WideNavigationRailKt.access$WideNavigationRailLayout(v1.getModifier(), false, false, v1.getColors(), v1.getCollapsedShape(), v1.getHeader(), v1.getWindowInsets(), v1.getArrangement(), v18, v15, 0x1B0);
                v15 = v15;
                v15.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v15, 0xD6E5D2B9, v5_1);
            v10 = v15.rememberedValue();
            if(v10 == Composer.Companion.getEmpty()) {
                Channel v10_6 = ChannelKt.Channel$default(v8, v4_1, ((Function1)v4_1), v3, v4_1);
                v15.updateRememberedValue(v10_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            if(v1.getShouldHideOnCollapse()) {
                v15.startReplaceGroup(0x5D5F6D6);
                ComposerKt.sourceInformation(v15, "559@27133L403,559@27109L427");
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E5E33C, v5_1);
                v3 = v15.changedInstance(v10) | v15.changedInstance(v0_3);
                v8_1 = v15.rememberedValue();
                if(v3 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                    DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 v8_2 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(((Channel)v10), ((ModalWideNavigationRailState)v0_3), ((Continuation)v4_1));
                    v15.updateRememberedValue(v8_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                EffectsKt.LaunchedEffect(v10, ((Function2)v8_1), v15, 0);
                v15.endReplaceGroup();
            }
            else {
                v15.startReplaceGroup(0x5DC93D9);
                v15.endReplaceGroup();
            }

            if(!DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$4(((State)v21))) {
                v15.startReplaceGroup(0x5DF2D80);
                ComposerKt.sourceInformation(v15, "583@28043L24,584@28109L42,585@28190L38,587@28253L49,587@28242L60,591@28431L37,592@28505L110,595@28661L93,599@28829L1724,589@28316L2237");
                if(!v1.getShouldHideOnCollapse()) {
                    v15.startReplaceGroup(0x5DE931B);
                    ComposerKt.sourceInformation(v15, "578@27806L197");
                    Modifier v3_1 = BackgroundKt.background-bw27NRU(Modifier.Companion, v1.getColors().getContainerColor-0d7_KjU(), v1.getCollapsedShape());
                    ComposerKt.sourceInformationMarkerStart(v15, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy v8_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(v15, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    v11 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
                    CompositionLocalMap v12_5 = v15.getCurrentCompositionLocalMap();
                    v3_1 = ComposedModifierKt.materializeModifier(v15, v3_1);
                    Function0 v13_3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(v15, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if(!(v15.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }

                    v15.startReusableNode();
                    if(v15.getInserting()) {
                        v15.createNode(v13_3);
                    }
                    else {
                        v15.useNode();
                    }

                    Composer v7 = Updater.constructor-impl(v15);
                    Updater.set-impl(v7, v8_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(v7, v12_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 v8_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if((v7.getInserting()) || !Intrinsics.areEqual(v7.rememberedValue(), Integer.valueOf(v11))) {
                        v7.updateRememberedValue(Integer.valueOf(v11));
                        v7.apply(Integer.valueOf(v11), v8_4);
                    }

                    Updater.set-impl(v7, v3_1, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(v15, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                    ComposerKt.sourceInformationMarkerStart(v15, 0xB4FCC679, "C579@27908L77:WideNavigationRail.kt#uh7d8r");
                    v7_1 = 1;
                    SpacerKt.Spacer(SizeKt.fillMaxHeight$default(SizeKt.widthIn-VpY3zN4$default(v1.getModifier(), WideNavigationRailKt.access$getCollapsedRailWidth$p(), 0f, 2, v4_1), 0f, 1, v4_1), v15, 0);
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    v15.endNode();
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    v15.endReplaceGroup();
                }
                else {
                    v7_1 = 1;
                    v15.startReplaceGroup(98809081);
                    v15.endReplaceGroup();
                }

                ComposerKt.sourceInformationMarkerStart(v15, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(v15, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
                Object v3_2 = v15.rememberedValue();
                if(v3_2 == Composer.Companion.getEmpty()) {
                    v3_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v15);
                    v15.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E65BD3, v5_1);
                v8_1 = v15.rememberedValue();
                if(v8_1 == Composer.Companion.getEmpty()) {
                    Animatable v8_5 = AnimatableKt.Animatable$default(0f, 0f, 2, v4_1);
                    v15.updateRememberedValue(v8_5);
                }

                Object v4_2 = v8_1;
                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E665EF, v5_1);
                Object v6 = v15.rememberedValue();
                if(v6 == Composer.Companion.getEmpty()) {
                    RailPredictiveBackState v6_1 = new RailPredictiveBackState();
                    v15.updateRememberedValue(v6_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerStart(v15, -689541670, v5_1);
                boolean v8_6 = v15.changedInstance(v10);
                v11 = v27;
                if(v11 != 4) {
                    if((v2_1 & 8) != 0 && (v15.changedInstance(v1))) {
                        goto label_397;
                    }

                    v12_6 = 0;
                }
                else {
                label_397:
                    v12_6 = v7_1;
                }

                v8 = (((int)v8_6)) | v12_6;
                v12_2 = v15.rememberedValue();
                if(v8 != 0 || v12_2 == Composer.Companion.getEmpty()) {
                    v12_7 = new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda2(((Channel)v10), v1);
                    v15.updateRememberedValue(v12_7);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                v8 = 0;
                EffectsKt.SideEffect(((Function0)v12_7), v15, 0);
                ModalWideNavigationRailProperties v10_7 = v1.getExpandedProperties();
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E6840E, v5_1);
                v12_1 = v15.changedInstance(v3_3);
                if(v11 == 4 || (v2_1 & 8) != 0 && (v15.changedInstance(v1))) {
                    v8 = v7_1;
                }

                v2_1 = (((int)v12_1)) | v8;
                v8_1 = v15.rememberedValue();
                if(v2_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                    DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda3 v8_7 = new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda3(v3_3, v1);
                    v15.updateRememberedValue(v8_7);
                }

                v11_1 = v8_1;
                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E68D97, v5_1);
                v2_1 = v15.changedInstance(v3_3) | v15.changedInstance(v4_2);
                v8_1 = v15.rememberedValue();
                if(v2_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                    v8_8 = new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda4(v3_3, ((Animatable)v4_2));
                    v15.updateRememberedValue(v8_8);
                }

                v12_2 = v8_8;
                ComposerKt.sourceInformationMarkerEnd(v15);
                ComposerKt.sourceInformationMarkerStart(v15, 0xD6E6A106, v5_1);
                v2_1 = v15.changedInstance(v3_3) | v15.changedInstance(v4_2);
                Object v5_2 = v15.rememberedValue();
                if(v2_1 != 0 || v5_2 == Composer.Companion.getEmpty()) {
                    DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda5 v5_3 = new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda5(v3_3, ((Animatable)v4_2));
                    v15.updateRememberedValue(v5_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                ModalWideNavigationRailOverrideScope v28 = v1;
                DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7 v1_1 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7(v1, v0_3, v23, ((Animatable)v4_2), v6, v24, v18, v22);
                v0_5 = v28;
                WideNavigationRail_androidKt.ModalWideNavigationRailDialog(v11_1, v10_7, v12_2, v5_2, v6, ComposableLambdaKt.rememberComposableLambda(1345045690, ((boolean)v7_1), v1_1, v15, 54), v15, 0x36000);
                v15.endReplaceGroup();
            }
            else {
                v0_5 = v1;
                v15.startReplaceGroup(0x60A3EB9);
                v15.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_497;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0_5 = v1;
            v15.skipToGroupEnd();
        }

    label_497:
        ScopeUpdateScope v1_2 = v15.endRestartGroup();
        if(v1_2 != null) {
            v1_2.updateScope(new DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda6(this, v0_5, v9));
        }
    }

    static final Unit ModalWideNavigationRail$lambda$16$lambda$15(Channel arg0, ModalWideNavigationRailOverrideScope arg1) {
        arg0.trySend-JP2dKIU(Boolean.valueOf(WideNavigationRailStateKt.isExpanded(arg1.getState().getTargetValue())));
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$18$lambda$17(CoroutineScope arg8, ModalWideNavigationRailOverrideScope arg9) {
        BuildersKt.launch$default(arg8, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$4$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$20$lambda$19(CoroutineScope arg8, Animatable arg9, float arg10) {
        BuildersKt.launch$default(arg8, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$5$1$1(arg9, arg10, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$22$lambda$21(CoroutineScope arg8, Animatable arg9) {
        BuildersKt.launch$default(arg8, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$6$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$23(DefaultModalWideNavigationRailOverride arg0, ModalWideNavigationRailOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.ModalWideNavigationRail(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final boolean ModalWideNavigationRail$lambda$3$lambda$2(State arg1) {
        if(arg1.getValue().floatValue() == 0f) {
            return 1;
        }

        return 0;
    }

    private static final boolean ModalWideNavigationRail$lambda$4(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final boolean ModalWideNavigationRail$lambda$6$lambda$5(State arg1) {
        if(arg1.getValue().floatValue() >= 0.3f) {
            return 1;
        }

        return 0;
    }

    private static final boolean ModalWideNavigationRail$lambda$7(State arg0) {
        return arg0.getValue().booleanValue();
    }

    public static final boolean access$ModalWideNavigationRail$lambda$7(State arg0) {
        return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$7(arg0);
    }
}

