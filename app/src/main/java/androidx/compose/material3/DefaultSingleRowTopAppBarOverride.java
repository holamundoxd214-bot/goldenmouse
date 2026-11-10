package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001A\u00020\nX\u008A\u0084\u0002"}, d2={"Landroidx/compose/material3/DefaultSingleRowTopAppBarOverride;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "<init>", "()V", "SingleRowTopAppBar", "", "Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;", "(Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "targetColor", "Landroidx/compose/ui/graphics/Color;"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultSingleRowTopAppBarOverride implements SingleRowTopAppBarOverride {
    public static final int $stable;
    public static final DefaultSingleRowTopAppBarOverride INSTANCE;

    static {
        DefaultSingleRowTopAppBarOverride.INSTANCE = new DefaultSingleRowTopAppBarOverride();
    }

    private DefaultSingleRowTopAppBarOverride() {
        super();
    }

    public void SingleRowTopAppBar(SingleRowTopAppBarOverrideScope arg38, Composer arg39, int arg40) {
        DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda4 v2_7;
        DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda2 v3_7;
        DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda1 v6_2;
        Modifier v3_6;
        DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda0 v7_1;
        Companion v3_5;
        State v3_4;
        int v12;
        int v3;
        SingleRowTopAppBarOverrideScope v0 = arg38;
        int v1 = arg40;
        int v2 = 0x7F677649;
        Composer v8 = arg39.startRestartGroup(v2);
        ComposerKt.sourceInformation(v8, "C(SingleRowTopAppBar)2520@118647L280,2531@119179L7,2528@118976L225,2536@119296L222,2574@120882L222,2580@121136L27,2581@121204L2,2570@120751L1724:AppBar.kt#uh7d8r");
        int v4 = 2;
        int v11 = 4;
        if((v1 & 6) == 0) {
            v3 = v8.changed(v0) ? v11 : v4;
            v12 = v3 | v1;
        }
        else {
            v12 = v1;
        }

        int v13 = 1;
        boolean v3_1 = (v12 & 3) != v4 ? true : false;
        if(v8.shouldExecute(v3_1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v12, -1, "androidx.compose.material3.DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar (AppBar.kt:2510)");
            }

            if(!Float.isNaN(v0.getExpandedHeight-D9Ej5fM()) && (Float.floatToRawIntBits(v0.getExpandedHeight-D9Ej5fM()) & 0x7FFFFFFF) < 0x7F800000) {
                TopAppBarColors v2_1 = v0.getColors();
                TopAppBarScrollBehavior v3_2 = v0.getScrollBehavior();
                String v15 = "CC(remember):AppBar.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v8, 1130584929, v15);
                v2 = v8.changed(v2_1) | v8.changed(v3_2);
                Object v3_3 = v8.rememberedValue();
                if(v2 != 0 || v3_3 == Composer.Companion.getEmpty()) {
                    v3_4 = SnapshotStateKt.derivedStateOf(new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$targetColor$2$1(v0));
                    v8.updateRememberedValue(v3_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                State v2_2 = SingleValueAnimationKt.animateColorAsState-euL9pac(DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$2(v3_4), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v8, 6), null, null, v8, 0, 12);
                ComposableLambda v23 = ComposableLambdaKt.rememberComposableLambda(0x9D1F3F12, true, new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$actionsRow$1(v0), v8, 54);
                Continuation v4_1 = null;
                if(v0.getScrollBehavior() == null || (v0.getScrollBehavior().isPinned())) {
                    v8.startReplaceGroup(690108113);
                    v8.endReplaceGroup();
                    v3_5 = Modifier.Companion;
                }
                else {
                    v8.startReplaceGroup(0x291870E6);
                    ComposerKt.sourceInformation(v8, "2550@119886L107,2550@119863L130,2553@120031L312");
                    v3_5 = Modifier.Companion;
                    Orientation v26 = Orientation.Vertical;
                    ComposerKt.sourceInformationMarkerStart(v8, 1130624404, v15);
                    int v5 = v12 & 14;
                    int v6 = v5 == v11 ? 1 : 0;
                    Object v7 = v8.rememberedValue();
                    if(v6 != 0 || v7 == Composer.Companion.getEmpty()) {
                        v7_1 = new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda0(v0);
                        v8.updateRememberedValue(v7_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    DraggableState v25 = DraggableKt.rememberDraggableState(((Function1)v7_1), v8, 0);
                    Companion v24 = v3_5;
                    ComposerKt.sourceInformationMarkerStart(v8, 0x43640881, v15);
                    v3 = v5 == v11 ? 1 : 0;
                    Object v5_1 = v8.rememberedValue();
                    if(v3 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                        DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1 v5_2 = new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1(v0, v4_1);
                        v8.updateRememberedValue(v5_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    v3_6 = DraggableKt.draggable$default(((Modifier)v24), v25, v26, false, null, false, null, v5_1, false, 0xBC, null);
                    v8.endReplaceGroup();
                }

                v3_6 = v0.getModifier().then(v3_6);
                ComposerKt.sourceInformationMarkerStart(v8, 1130656391, v15);
                boolean v5_3 = v8.changed(v2_2);
                Object v6_1 = v8.rememberedValue();
                if((v5_3) || v6_1 == Composer.Companion.getEmpty()) {
                    v6_2 = new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda1(v2_2);
                    v8.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                Modifier v2_3 = DrawModifierKt.drawBehind(v3_6, ((Function1)v6_2));
                ComposerKt.sourceInformationMarkerStart(v8, 1130664324, v15);
                v3_3 = v8.rememberedValue();
                if(v3_3 == Composer.Companion.getEmpty()) {
                    v3_7 = new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda2();
                    v8.updateRememberedValue(v3_7);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v2_3 = SemanticsModifierKt.semantics$default(v2_3, false, ((Function1)v3_7), 1, v4_1);
                Unit v3_8 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(v8, 1130666475, v15);
                Object v4_2 = v8.rememberedValue();
                if(v4_2 == Composer.Companion.getEmpty()) {
                    DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1 v4_3 = DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1.INSTANCE;
                    v8.updateRememberedValue(v4_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                v2_3 = SuspendingPointerInputFilterKt.pointerInput(v2_3, v3_8, ((PointerInputEventHandler)v4_2));
                ComposerKt.sourceInformationMarkerStart(v8, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy v3_9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                v4 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
                CompositionLocalMap v5_4 = v8.getCurrentCompositionLocalMap();
                v2_3 = ComposedModifierKt.materializeModifier(v8, v2_3);
                Function0 v6_3 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                Updater.set-impl(v6_4, v3_9, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v6_4, v5_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v3_10 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v6_4.getInserting()) || !Intrinsics.areEqual(v6_4.rememberedValue(), Integer.valueOf(v4))) {
                    v6_4.updateRememberedValue(Integer.valueOf(v4));
                    v6_4.apply(Integer.valueOf(v4), v3_10);
                }

                Updater.set-impl(v6_4, v2_3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v8, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v8, 0xB87D84CE, "C2589@121570L45,2598@122100L6,2583@121231L1234:AppBar.kt#uh7d8r");
                v3_6 = AppBarKt.adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, v0.getWindowInsets())), v0.getScrollBehavior());
                ComposerKt.sourceInformationMarkerStart(v8, 0xDCA95B90, v15);
                if((v12 & 14) == v11) {
                }
                else {
                    v13 = 0;
                }

                Object v2_4 = v8.rememberedValue();
                if(v13 != 0 || v2_4 == Composer.Companion.getEmpty()) {
                    DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda3 v2_5 = new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda3(v0);
                    v8.updateRememberedValue(v2_5);
                }

                v4_2 = v2_4;
                ComposerKt.sourceInformationMarkerEnd(v8);
                long v5_5 = v0.getColors().getNavigationIconContentColor-0d7_KjU();
                long v9 = v0.getColors().getTitleContentColor-0d7_KjU();
                long v11_1 = v0.getColors().getActionIconContentColor-0d7_KjU();
                long v16 = v9;
                v9 = v0.getColors().getSubtitleContentColor-0d7_KjU();
                Function2 v13_1 = v0.getTitle();
                TextStyle v14 = v0.getTitleTextStyle();
                Function2 v2_6 = v0.getSubtitle();
                long v17 = v16;
                TextStyle v16_1 = v0.getSubtitleTextStyle();
                HorizontalOrVertical v7_2 = Arrangement.INSTANCE.getCenter();
                Horizontal v19 = v0.getTitleHorizontalAlignment();
                Function2 v22 = v0.getNavigationIcon();
                float v24_1 = v0.getExpandedHeight-D9Ej5fM();
                Function2 v39 = v2_6;
                ComposerKt.sourceInformationMarkerStart(v8, 0xDCA99DA9, v15);
                v2_4 = v8.rememberedValue();
                if(v2_4 == Composer.Companion.getEmpty()) {
                    v2_7 = new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda4();
                    v8.updateRememberedValue(v2_7);
                }

                ComposerKt.sourceInformationMarkerEnd(v8);
                AppBarKt.TopAppBarLayout-lyUyIHI(v3_6, ((FloatProducer)v4_2), v5_5, v17, v9, v11_1, v13_1, v14, v39, v16_1, v2_7, v7_2, v19, 0, false, v22, ((Function2)v23), v24_1, v8, 0, 1600566);
                v8 = v8;
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                v8.endNode();
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                ComposerKt.sourceInformationMarkerEnd(v8);
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_313;
                }

                ComposerKt.traceEventEnd();
                goto label_313;
            }

            throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
        }
        else {
            v8.skipToGroupEnd();
        }

    label_313:
        ScopeUpdateScope v2_8 = v8.endRestartGroup();
        if(v2_8 != null) {
            v2_8.updateScope(new DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda5(this, v0, v1));
        }
    }

    static final float SingleRowTopAppBar$lambda$15$lambda$12$lambda$11(SingleRowTopAppBarOverrideScope arg0) {
        TopAppBarScrollBehavior v0 = arg0.getScrollBehavior();
        if(v0 != null) {
            TopAppBarState v0_1 = v0.getState();
            if(v0_1 != null) {
                return v0_1.getHeightOffset();
            }
        }

        return 0;
    }

    static final float SingleRowTopAppBar$lambda$15$lambda$14$lambda$13() {
        return 1f;
    }

    static final Unit SingleRowTopAppBar$lambda$16(DefaultSingleRowTopAppBarOverride arg0, SingleRowTopAppBarOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.SingleRowTopAppBar(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final long SingleRowTopAppBar$lambda$2(State arg2) {
        return arg2.getValue().unbox-impl();
    }

    static final Unit SingleRowTopAppBar$lambda$4$lambda$3(SingleRowTopAppBarOverrideScope arg1, float arg2) {
        TopAppBarState v1 = arg1.getScrollBehavior().getState();
        v1.setHeightOffset(v1.getHeightOffset() + arg2);
        return Unit.INSTANCE;
    }

    static final Unit SingleRowTopAppBar$lambda$7$lambda$6(State arg13, DrawScope arg14) {
        long v1 = arg13.getValue().unbox-impl();
        if(!Color.equals-impl0(v1, Color.Companion.getUnspecified-0d7_KjU())) {
            DrawScope.drawRect-n-J9OG0$default(arg14, v1, 0, 0, 0f, null, null, 0, 0x7E, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit SingleRowTopAppBar$lambda$9$lambda$8(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setTraversalGroup(arg1, true);
        return Unit.INSTANCE;
    }
}

