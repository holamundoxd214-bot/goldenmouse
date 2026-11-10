package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001A\u00020\nX\u008A\u0084\u0002"}, d2={"Landroidx/compose/material3/DefaultTwoRowsTopAppBarOverride;", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "<init>", "()V", "TwoRowsTopAppBar", "", "Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "(Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "hideTopRowSemantics", ""}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultTwoRowsTopAppBarOverride implements TwoRowsTopAppBarOverride {
    public static final int $stable;
    public static final DefaultTwoRowsTopAppBarOverride INSTANCE;

    static {
        DefaultTwoRowsTopAppBarOverride.INSTANCE = new DefaultTwoRowsTopAppBarOverride();
    }

    private DefaultTwoRowsTopAppBarOverride() {
        super();
    }

    public void TwoRowsTopAppBar(TwoRowsTopAppBarOverrideScope arg44, Composer arg45, int arg46) {
        Composer v25;
        Modifier v5_3;
        Object v14;
        Companion v5_2;
        DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda2 v12_2;
        DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarContainerColor$1$1 v11_1;
        DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda0 v10_1;
        int v4;
        TwoRowsTopAppBarOverrideScope v0 = arg44;
        int v2 = -1640665680;
        Composer v3 = arg45.startRestartGroup(v2);
        ComposerKt.sourceInformation(v3, "C(TwoRowsTopAppBar)2742@128485L7,2749@128976L50,2750@129062L52,2754@129209L222,2761@129460L60,2762@129552L34,2766@129813L117,2797@131033L44,2798@131109L27,2799@131177L2,2793@130902L3154:AppBar.kt#uh7d8r");
        int v5 = 2;
        int v6 = 4;
        if((arg46 & 6) == 0) {
            v4 = v3.changed(v0) ? v6 : v5;
            v4 |= arg46;
        }
        else {
            v4 = arg46;
        }

        boolean v5_1 = (v4 & 3) != v5 ? true : false;
        if(v3.shouldExecute(v5_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar (AppBar.kt:2732)");
            }

            if(!Float.isNaN(v0.getCollapsedHeight-D9Ej5fM())) {
                v5 = 0x7FFFFFFF;
                int v7 = 0x7F800000;
                if((Float.floatToRawIntBits(v0.getCollapsedHeight-D9Ej5fM()) & v5) < v7) {
                    if(!Float.isNaN(v0.getExpandedHeight-D9Ej5fM()) && (Float.floatToRawIntBits(v0.getExpandedHeight-D9Ej5fM()) & v5) < v7) {
                        if(Dp.compareTo-0680j_4(v0.getExpandedHeight-D9Ej5fM(), v0.getCollapsedHeight-D9Ej5fM()) >= 0) {
                            ProvidableCompositionLocal v2_1 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object v2_2 = v3.consume(((CompositionLocal)v2_1));
                            ComposerKt.sourceInformationMarkerEnd(v3);
                            v2 = ((Density)v2_2).roundToPx-0680j_4(v0.getTitleBottomPadding-D9Ej5fM());
                            String v7_1 = "CC(remember):AppBar.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart(v3, 0xE6914A42, v7_1);
                            v4 &= 14;
                            v5 = v4 == v6 ? 1 : 0;
                            Object v10 = v3.rememberedValue();
                            if(v5 != 0 || v10 == Composer.Companion.getEmpty()) {
                                v10_1 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda0(v0);
                                v3.updateRememberedValue(v10_1);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            ComposerKt.sourceInformationMarkerStart(v3, 0xE6915504, v7_1);
                            v5 = v4 == v6 ? 1 : 0;
                            v5 |= v3.changed(v10_1);
                            Object v11 = v3.rememberedValue();
                            if(v5 != 0 || v11 == Composer.Companion.getEmpty()) {
                                v11_1 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarContainerColor$1$1(v0, ((Function0)v10_1));
                                v3.updateRememberedValue(v11_1);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            ComposableLambda v23 = ComposableLambdaKt.rememberComposableLambda(0xB081C139, true, new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$actionsRow$1(v0), v3, 54);
                            ComposerKt.sourceInformationMarkerStart(v3, -426670388, v7_1);
                            v5_1 = v3.changed(v10_1);
                            Object v12 = v3.rememberedValue();
                            if((v5_1) || v12 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda1 v12_1 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda1(((Function0)v10_1));
                                v3.updateRememberedValue(v12_1);
                            }

                            Object v17 = v12;
                            ComposerKt.sourceInformationMarkerEnd(v3);
                            ComposerKt.sourceInformationMarkerStart(v3, -426667470, v7_1);
                            v5_1 = v3.changed(v10_1);
                            v12 = v3.rememberedValue();
                            if((v5_1) || v12 == Composer.Companion.getEmpty()) {
                                v12_2 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda2(((Function0)v10_1));
                                v3.updateRememberedValue(v12_2);
                            }

                            Object v28 = v12_2;
                            ComposerKt.sourceInformationMarkerEnd(v3);
                            ComposerKt.sourceInformationMarkerStart(v3, -426659035, v7_1);
                            v5_1 = v3.changed(v10_1);
                            v12 = v3.rememberedValue();
                            if((v5_1) || v12 == Composer.Companion.getEmpty()) {
                                State v12_3 = SnapshotStateKt.derivedStateOf(new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda3(((Function0)v10_1)));
                                v3.updateRememberedValue(v12_3);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            int v29 = DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$13(((State)v12)) ^ 1;
                            Continuation v10_2 = null;
                            if(v0.getScrollBehavior() == null || (v0.getScrollBehavior().isPinned())) {
                                v3.startReplaceGroup(-340499894);
                                v3.endReplaceGroup();
                                v5_2 = Modifier.Companion;
                            }
                            else {
                                v3.startReplaceGroup(-341140385);
                                ComposerKt.sourceInformation(v3, "2777@130356L107,2777@130333L130,2780@130501L312");
                                v5_2 = Modifier.Companion;
                                Orientation v32 = Orientation.Vertical;
                                ComposerKt.sourceInformationMarkerStart(v3, 0xE691F6FB, v7_1);
                                int v13 = v4 == v6 ? 1 : 0;
                                v14 = v3.rememberedValue();
                                if(v13 != 0 || v14 == Composer.Companion.getEmpty()) {
                                    DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda4 v14_1 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda4(v0);
                                    v3.updateRememberedValue(v14_1);
                                }

                                ComposerKt.sourceInformationMarkerEnd(v3);
                                DraggableState v31 = DraggableKt.rememberDraggableState(((Function1)v14), v3, 0);
                                Companion v30 = v5_2;
                                ComposerKt.sourceInformationMarkerStart(v3, 0xE69209E8, v7_1);
                                v5 = v4 == v6 ? 1 : 0;
                                Object v13_1 = v3.rememberedValue();
                                if(v5 != 0 || v13_1 == Composer.Companion.getEmpty()) {
                                    DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 v13_2 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(v0, v10_2);
                                    v3.updateRememberedValue(v13_2);
                                }

                                ComposerKt.sourceInformationMarkerEnd(v3);
                                v5_3 = DraggableKt.draggable$default(((Modifier)v30), v31, v32, false, null, false, null, v13_1, false, 0xBC, null);
                                v3.endReplaceGroup();
                            }

                            v5_3 = v0.getModifier().then(v5_3);
                            ComposerKt.sourceInformationMarkerStart(v3, -426620068, v7_1);
                            boolean v13_3 = v3.changed(v11_1);
                            v14 = v3.rememberedValue();
                            if((v13_3) || v14 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda5 v14_2 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda5(((Function0)v11_1));
                                v3.updateRememberedValue(v14_2);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            v5_3 = DrawModifierKt.drawBehind(v5_3, ((Function1)v14));
                            ComposerKt.sourceInformationMarkerStart(v3, 0xE69254CB, v7_1);
                            v11 = v3.rememberedValue();
                            if(v11 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda6 v11_2 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda6();
                                v3.updateRememberedValue(v11_2);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            v5_3 = SemanticsModifierKt.semantics$default(v5_3, false, ((Function1)v11), 1, v10_2);
                            Unit v10_3 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(v3, -426615502, v7_1);
                            v11 = v3.rememberedValue();
                            if(v11 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1 v11_3 = DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1.INSTANCE;
                                v3.updateRememberedValue(v11_3);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            v5_3 = SuspendingPointerInputFilterKt.pointerInput(v5_3, v10_3, ((PointerInputEventHandler)v11));
                            ComposerKt.sourceInformationMarkerStart(v3, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy v10_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            String v13_4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                            ComposerKt.sourceInformationMarkerStart(v3, -1323940314, v13_4);
                            int v14_3 = ComposablesKt.getCurrentCompositeKeyHash(v3, 0);
                            CompositionLocalMap v15 = v3.getCurrentCompositionLocalMap();
                            v5_3 = ComposedModifierKt.materializeModifier(v3, v5_3);
                            Function0 v6_1 = ComposeUiNode.Companion.getConstructor();
                            String v11_4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart(v3, 0xD6BD0031, v11_4);
                            if(!(v3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }

                            v3.startReusableNode();
                            if(v3.getInserting()) {
                                v3.createNode(v6_1);
                            }
                            else {
                                v3.useNode();
                            }

                            Composer v6_2 = Updater.constructor-impl(v3);
                            Updater.set-impl(v6_2, v10_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(v6_2, v15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 v8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if((v6_2.getInserting()) || !Intrinsics.areEqual(v6_2.rememberedValue(), Integer.valueOf(v14_3))) {
                                v6_2.updateRememberedValue(Integer.valueOf(v14_3));
                                v6_2.apply(Integer.valueOf(v14_3), v8);
                            }

                            Updater.set-impl(v6_2, v5_3, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(v3, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                            ComposerKt.sourceInformationMarkerStart(v3, 0xB101BF3F, "C2801@131204L2842:AppBar.kt#uh7d8r");
                            ComposerKt.sourceInformationMarkerStart(v3, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            v5_2 = Modifier.Companion;
                            MeasurePolicy v6_3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v3, 0);
                            ComposerKt.sourceInformationMarkerStart(v3, -1323940314, v13_4);
                            int v8_1 = ComposablesKt.getCurrentCompositeKeyHash(v3, 0);
                            CompositionLocalMap v10_5 = v3.getCurrentCompositionLocalMap();
                            v5_3 = ComposedModifierKt.materializeModifier(v3, ((Modifier)v5_2));
                            Function0 v13_5 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(v3, 0xD6BD0031, v11_4);
                            if(!(v3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }

                            v3.startReusableNode();
                            if(v3.getInserting()) {
                                v3.createNode(v13_5);
                            }
                            else {
                                v3.useNode();
                            }

                            Composer v11_5 = Updater.constructor-impl(v3);
                            Updater.set-impl(v11_5, v6_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(v11_5, v10_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 v6_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if((v11_5.getInserting()) || !Intrinsics.areEqual(v11_5.rememberedValue(), Integer.valueOf(v8_1))) {
                                v11_5.updateRememberedValue(Integer.valueOf(v8_1));
                                v11_5.apply(Integer.valueOf(v8_1), v6_4);
                            }

                            Updater.set-impl(v11_5, v5_3, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(v3, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
                            ComposerKt.sourceInformationMarkerStart(v3, 0xF40BA07C, "C2807@131523L6,2802@131229L1260,2833@133025L45,2825@132506L1526:AppBar.kt#uh7d8r");
                            v5_3 = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, v0.getWindowInsets()));
                            ComposerKt.sourceInformationMarkerStart(v3, 1379010106, v7_1);
                            Object v6_5 = v3.rememberedValue();
                            if(v6_5 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda7 v6_6 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda7();
                                v3.updateRememberedValue(v6_6);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            int v18 = v4;
                            int v45 = v2;
                            AppBarKt.TopAppBarLayout-lyUyIHI(v5_3, v6_5, v0.getColors().getNavigationIconContentColor-0d7_KjU(), v0.getColors().getTitleContentColor-0d7_KjU(), v0.getColors().getSubtitleContentColor-0d7_KjU(), v0.getColors().getActionIconContentColor-0d7_KjU(), v0.getSmallTitle(), v0.getSmallTitleTextStyle(), v0.getSmallSubtitle(), v0.getSmallSubtitleTextStyle(), ((Function0)v17), Arrangement.INSTANCE.getCenter(), v0.getTitleHorizontalAlignment(), 0, DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$13(v12), v0.getNavigationIcon(), ((Function2)v23), v0.getCollapsedHeight-D9Ej5fM(), v3, 0, 0x180C30);
                            v3 = v3;
                            Modifier v4_1 = AppBarKt.adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, WindowInsetsKt.only-bOOhFvg(v0.getWindowInsets(), WindowInsetsSides.Companion.getHorizontal-JoeWqyM()))), v0.getScrollBehavior());
                            ComposerKt.sourceInformationMarkerStart(v3, 1379058209, v7_1);
                            v8_1 = v18 == 4 ? 1 : 0;
                            Object v1 = v3.rememberedValue();
                            if(v8_1 != 0 || v1 == Composer.Companion.getEmpty()) {
                                DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda8 v1_1 = new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda8(v0);
                                v3.updateRememberedValue(v1_1);
                            }

                            ComposerKt.sourceInformationMarkerEnd(v3);
                            v25 = v3;
                            AppBarKt.TopAppBarLayout-lyUyIHI(v4_1, v1, v0.getColors().getNavigationIconContentColor-0d7_KjU(), v0.getColors().getTitleContentColor-0d7_KjU(), v0.getColors().getSubtitleContentColor-0d7_KjU(), v0.getColors().getActionIconContentColor-0d7_KjU(), v0.getTitle(), v0.getTitleTextStyle(), v0.getSubtitle(), v0.getSubtitleTextStyle(), v28, Arrangement.INSTANCE.getBottom(), v0.getTitleHorizontalAlignment(), v45, v29, ComposableSingletons$AppBarKt.INSTANCE.getLambda$-2101264077$material3(), ComposableSingletons$AppBarKt.INSTANCE.getLambda$37575796$material3(), Dp.constructor-impl(v0.getExpandedHeight-D9Ej5fM() - v0.getCollapsedHeight-D9Ej5fM()), v25, 0, 0x1B0030);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            v25.endNode();
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            v25.endNode();
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            ComposerKt.sourceInformationMarkerEnd(v25);
                            if(!ComposerKt.isTraceInProgress()) {
                                goto label_507;
                            }

                            ComposerKt.traceEventEnd();
                            goto label_507;
                        }
                        else {
                            throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
                        }
                    }

                    throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
                }
            }

            throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
        }
        else {
            v25 = v3;
            v25.skipToGroupEnd();
        }

    label_507:
        ScopeUpdateScope v1_2 = v25.endRestartGroup();
        if(v1_2 != null) {
            v1_2.updateScope(new DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda9(this, v0, arg46));
        }
    }

    static final float TwoRowsTopAppBar$lambda$10$lambda$9(Function0 arg1) {
        return 1f - arg1.invoke().floatValue();
    }

    static final boolean TwoRowsTopAppBar$lambda$12$lambda$11(Function0 arg1) {
        if(arg1.invoke().floatValue() < 0.5f) {
            return 1;
        }

        return 0;
    }

    private static final boolean TwoRowsTopAppBar$lambda$13(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit TwoRowsTopAppBar$lambda$15$lambda$14(TwoRowsTopAppBarOverrideScope arg1, float arg2) {
        TopAppBarState v1 = arg1.getScrollBehavior().getState();
        v1.setHeightOffset(v1.getHeightOffset() + arg2);
        return Unit.INSTANCE;
    }

    static final Unit TwoRowsTopAppBar$lambda$18$lambda$17(Function0 arg13, DrawScope arg14) {
        DrawScope.drawRect-n-J9OG0$default(arg14, arg13.invoke().unbox-impl(), 0, 0, 0f, null, null, 0, 0x7E, null);
        return Unit.INSTANCE;
    }

    static final Unit TwoRowsTopAppBar$lambda$20$lambda$19(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setTraversalGroup(arg1, true);
        return Unit.INSTANCE;
    }

    static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22() {
        return 0;
    }

    static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(TwoRowsTopAppBarOverrideScope arg0) {
        TopAppBarScrollBehavior v0 = arg0.getScrollBehavior();
        if(v0 != null) {
            TopAppBarState v0_1 = v0.getState();
            if(v0_1 != null) {
                return v0_1.getHeightOffset();
            }
        }

        return 0;
    }

    static final Unit TwoRowsTopAppBar$lambda$28(DefaultTwoRowsTopAppBarOverride arg0, TwoRowsTopAppBarOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.TwoRowsTopAppBar(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final float TwoRowsTopAppBar$lambda$5$lambda$4(TwoRowsTopAppBarOverrideScope arg0) {
        TopAppBarScrollBehavior v0 = arg0.getScrollBehavior();
        if(v0 != null) {
            TopAppBarState v0_1 = v0.getState();
            if(v0_1 != null) {
                return v0_1.getCollapsedFraction();
            }
        }

        return 0;
    }

    static final float TwoRowsTopAppBar$lambda$8$lambda$7(Function0 arg1) {
        return AppBarKt.getTopTitleAlphaEasing().transform(arg1.invoke().floatValue());
    }
}

