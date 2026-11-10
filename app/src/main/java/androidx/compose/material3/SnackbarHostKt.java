package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A:\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0019\b\u0002\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001A\u001E\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0000\u001A:\u0010\u0012\u001A\u00020\u00012\b\u0010\u0013\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0017\u0010\u0014\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u0015\u001A9\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001B2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001E2\u0006\u0010\u001F\u001A\u00020\u000F2\u000E\b\u0002\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010!\u001A)\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001B2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001E2\u0006\u0010\u001F\u001A\u00020\u000FH\u0003¢\u0006\u0002\u0010#*b\b\u0002\u0010\u0016\"-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¨\u0006$"}, d2={"SnackbarHost", "", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "snackbar", "Lkotlin/Function1;", "Landroidx/compose/material3/SnackbarData;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutWithScale", "current", "content", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FadeInFadeOutTransition", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "onAnimationFinish", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SnackbarHostKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SnackbarDuration.values().length];
            try {
                v0[SnackbarDuration.Indefinite.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SnackbarDuration.Long.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[SnackbarDuration.Short.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private static final void FadeInFadeOutWithScale(SnackbarData arg16, Modifier arg17, Function3 arg18, Composer arg19, int arg20, int arg21) {
        FadeInFadeOutState v5_2;
        Modifier v6_2;
        int v8;
        Modifier v7;
        int v5;
        SnackbarData v1 = arg16;
        Function3 v3 = arg18;
        int v4 = arg20;
        int v0 = 0xC5BB7E8D;
        Composer v2 = arg19.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(FadeInFadeOutWithScale)N(current,modifier,content)327@12796L36,328@12849L48,380@15021L162:SnackbarHost.kt#uh7d8r");
        if((arg21 & 1) != 0) {
            v5 = v4 | 6;
        }
        else if((v4 & 6) == 0) {
            v5 = v2.changed(v1) ? 4 : 2;
            v5 |= v4;
        }
        else {
            v5 = v4;
        }

        int v6 = arg21 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_36;
        }
        else if((v4 & 0x30) == 0) {
            v7 = arg17;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_36:
            v7 = arg17;
        }

        if((arg21 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v4 & 0x180) == 0) {
            v8 = v2.changedInstance(v3) ? 0x100 : 0x80;
            v5 |= v8;
        }

        boolean v8_1 = (v5 & 0x93) != 0x92 ? true : false;
        if(v2.shouldExecute(v8_1, v5 & 1)) {
            if(v6 != 0) {
                Companion v6_1 = Modifier.Companion;
            }
            else {
                v6_2 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:326)");
            }

            String v0_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_snackbar_pane_title), v2, 0);
            ComposerKt.sourceInformationMarkerStart(v2, 1154887069, "CC(remember):SnackbarHost.kt#9igjgp");
            Object v5_1 = v2.rememberedValue();
            if(v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = new FadeInFadeOutState();
                v2.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v8 = 54;
            if(!Intrinsics.areEqual(v1, v5_2.getCurrent())) {
                v2.startReplaceGroup(0x44D63FF1);
                ComposerKt.sourceInformation(v2, "*337@13248L1752");
                v5_2.setCurrent(v1);
                List v7_1 = v5_2.getItems();
                ArrayList v9 = new ArrayList(v7_1.size());
                int v12 = v7_1.size();
                int v13;
                for(v13 = 0; v13 < v12; ++v13) {
                    v9.add(v7_1.get(v13).getKey());
                }

                v7_1 = CollectionsKt.toMutableList(((Collection)v9));
                if(!v7_1.contains(v1)) {
                    v7_1.add(v1);
                }

                v5_2.getItems().clear();
                v7_1 = ListUtilsKt.fastFilterNotNull(v7_1);
                List v9_1 = v5_2.getItems();
                v12 = v7_1.size();
                v13 = 0;
                while(v13 < v12) {
                    Object v14 = v7_1.get(v13);
                    ((Collection)v9_1).add(new FadeInFadeOutAnimationItem(v14, ComposableLambdaKt.rememberComposableLambda(-1952400805, true, new SnackbarHostKt$FadeInFadeOutWithScale$1$1(((SnackbarData)v14), v1, v5_2, v0_1), v2, v8)));
                    ++v13;
                    v0_1 = v0_1;
                }

                v2.endReplaceGroup();
            }
            else {
                v2.startReplaceGroup(0x56104D55);
                v2.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v0_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v9_2 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v7_2 = v2.getCurrentCompositionLocalMap();
            Modifier v10 = ComposedModifierKt.materializeModifier(v2, v6_2);
            Function0 v12_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v12_1);
            }
            else {
                v2.useNode();
            }

            Composer v12_2 = Updater.constructor-impl(v2);
            Updater.set-impl(v12_2, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v12_2, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v12_2.getInserting()) || !Intrinsics.areEqual(v12_2.rememberedValue(), Integer.valueOf(v9_2))) {
                v12_2.updateRememberedValue(Integer.valueOf(v9_2));
                v12_2.apply(Integer.valueOf(v9_2), v0_3);
            }

            Updater.set-impl(v12_2, v10, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v2, 0x5F1E994C, "C381@15059L21:SnackbarHost.kt#uh7d8r");
            v5_2.setScope(ComposablesKt.getCurrentRecomposeScope(v2, 0));
            v2.startReplaceGroup(0x8F74A05F);
            ComposerKt.sourceInformation(v2, "");
            List v0_4 = v5_2.getItems();
            v5 = v0_4.size();
            int v10_1;
            for(v10_1 = 0; v10_1 < v5; ++v10_1) {
                Object v7_3 = v0_4.get(v10_1);
                Object v9_3 = ((FadeInFadeOutAnimationItem)v7_3).component1();
                Function3 v7_4 = ((FadeInFadeOutAnimationItem)v7_3).component2();
                v2.startMovableGroup(1325010085, v9_3);
                ComposerKt.sourceInformation(v2, "382@15154L19,382@15146L27");
                v7_4.invoke(ComposableLambdaKt.rememberComposableLambda(0x8F1F076E, true, new SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(v3, ((SnackbarData)v9_3)), v2, v8), v2, Integer.valueOf(6));
                v2.endMovableGroup();
            }

            v2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_236;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v6_2 = v7;
        }

    label_236:
        ScopeUpdateScope v7_5 = v2.endRestartGroup();
        if(v7_5 != null) {
            v7_5.updateScope(new SnackbarHostKt$$ExternalSyntheticLambda2(v1, ((Companion)v6_2), v3, v4, arg21));
        }
    }

    static final Unit FadeInFadeOutWithScale$lambda$7(SnackbarData arg6, Modifier arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        SnackbarHostKt.FadeInFadeOutWithScale(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final void SnackbarHost(SnackbarHostState arg11, Modifier arg12, Function3 arg13, Composer arg14, int arg15, int arg16) {
        Function3 v3_3;
        Modifier v2_1;
        Companion v12;
        int v3;
        int v1;
        int v0 = 0xBFCD09EE;
        Composer v8 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(SnackbarHost)N(hostState,modifier,snackbar)222@9520L7,223@9568L349,223@9532L385,234@9922L135:SnackbarHost.kt#uh7d8r");
        if((arg16 & 1) != 0) {
            v1 = arg15 | 6;
        }
        else if((arg15 & 6) == 0) {
            v1 = v8.changed(arg11) ? 4 : 2;
            v1 |= arg15;
        }
        else {
            v1 = arg15;
        }

        int v2 = arg16 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((arg15 & 0x30) == 0) {
            v3 = v8.changed(arg12) ? 0x20 : 16;
            v1 |= v3;
        }

        v3 = arg16 & 4;
        if(v3 != 0) {
            v1 |= 0x180;
        }
        else if((arg15 & 0x180) == 0) {
            int v5 = v8.changedInstance(arg13) ? 0x100 : 0x80;
            v1 |= v5;
        }

        boolean v5_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(v8.shouldExecute(v5_1, v1 & 1)) {
            if(v2 != 0) {
                v12 = Modifier.Companion;
            }

            Modifier v6 = ((Modifier)v12);
            if(v3 != 0) {
                arg13 = ComposableSingletons$SnackbarHostKt.INSTANCE.getLambda$-1548712596$material3();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:220)");
            }

            SnackbarData v12_1 = arg11.getCurrentSnackbarData();
            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalAccessibilityManager();
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v8.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0xB271EB, "CC(remember):SnackbarHost.kt#9igjgp");
            v2 = v8.changed(v12_1) | v8.changedInstance(v0_2);
            Object v3_1 = v8.rememberedValue();
            if(v2 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                SnackbarHostKt$SnackbarHost$1$1 v3_2 = new SnackbarHostKt$SnackbarHost$1$1(v12_1, ((AccessibilityManager)v0_2), null);
                v8.updateRememberedValue(v3_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            EffectsKt.LaunchedEffect(v12_1, ((Function2)v3_1), v8, 0);
            Function3 v7 = arg13;
            SnackbarHostKt.FadeInFadeOutWithScale(arg11.getCurrentSnackbarData(), v6, v7, v8, v1 & 0x3F0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v6;
            v3_3 = v7;
        }
        else {
            v8.skipToGroupEnd();
            v2_1 = arg12;
            v3_3 = arg13;
        }

        ScopeUpdateScope v12_2 = v8.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new SnackbarHostKt$$ExternalSyntheticLambda0(arg11, v2_1, v3_3, arg15, arg16));
        }
    }

    static final Unit SnackbarHost$lambda$1(SnackbarHostState arg6, Modifier arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        SnackbarHostKt.SnackbarHost(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final State access$animatedOpacity(AnimationSpec arg0, boolean arg1, Function0 arg2, Composer arg3, int arg4, int arg5) {
        return SnackbarHostKt.animatedOpacity(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final State access$animatedScale(AnimationSpec arg0, boolean arg1, Composer arg2, int arg3) {
        return SnackbarHostKt.animatedScale(arg0, arg1, arg2, arg3);
    }

    private static final State animatedOpacity(AnimationSpec arg8, boolean arg9, Function0 arg10, Composer arg11, int arg12, int arg13) {
        Animatable v10_2;
        Object v10;
        int v1 = 0x5558E4EE;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(animatedOpacity)N(animation,visible,onAnimationFinish)404@15795L2,406@15833L49,407@15911L111,407@15887L135:SnackbarHost.kt#uh7d8r");
        String v0 = "CC(remember):SnackbarHost.kt#9igjgp";
        if((arg13 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg11, 0x62B37270, v0);
            v10 = arg11.rememberedValue();
            if(v10 == Composer.Companion.getEmpty()) {
                SnackbarHostKt$$ExternalSyntheticLambda1 v10_1 = new SnackbarHostKt$$ExternalSyntheticLambda1();
                arg11.updateRememberedValue(v10_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
        }

        Function0 v6 = ((Function0)v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:405)");
        }

        ComposerKt.sourceInformationMarkerStart(arg11, 0x62B3775F, v0);
        v10 = arg11.rememberedValue();
        if(v10 == Composer.Companion.getEmpty()) {
            float v13 = !arg9 ? 1f : 0f;
            v10_2 = AnimatableKt.Animatable$default(v13, 0f, 2, null);
            arg11.updateRememberedValue(v10_2);
        }

        Object v3 = v10_2;
        ComposerKt.sourceInformationMarkerEnd(arg11);
        Boolean v10_3 = Boolean.valueOf(arg9);
        ComposerKt.sourceInformationMarkerStart(arg11, 0x62B3815D, v0);
        boolean v13_1 = arg11.changedInstance(v3);
        v1 = 0;
        int v4 = 0x20;
        int v0_1 = (arg12 & 0x70 ^ 0x30) > v4 && (arg11.changed(arg9)) || (arg12 & 0x30) == v4 ? 1 : 0;
        arg13 = (((int)v13_1)) | v0_1 | arg11.changedInstance(arg8);
        v4 = 0x100;
        if((arg12 & 0x380 ^ 0x180) > v4 && (arg11.changed(v6)) || (arg12 & 0x180) == v4) {
            v1 = 1;
        }

        Object v0_2 = arg11.rememberedValue();
        if((arg13 | v1) != 0 || v0_2 == Composer.Companion.getEmpty()) {
            SnackbarHostKt$animatedOpacity$2$1 v0_3 = new SnackbarHostKt$animatedOpacity$2$1(((Animatable)v3), arg9, arg8, v6, null);
            arg11.updateRememberedValue(v0_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        EffectsKt.LaunchedEffect(v10_3, ((Function2)v0_2), arg11, arg12 >> 3 & 14);
        State v8 = ((Animatable)v3).asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        return v8;
    }

    static final Unit animatedOpacity$lambda$9$lambda$8() {
        return Unit.INSTANCE;
    }

    private static final State animatedScale(AnimationSpec arg6, boolean arg7, Composer arg8, int arg9) {
        SnackbarHostKt$animatedScale$1$1 v4_2;
        int v1 = 1966809761;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(animatedScale)N(animation,visible)416@16174L51,417@16254L85,417@16230L109:SnackbarHost.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:415)");
        }

        String v1_1 = "CC(remember):SnackbarHost.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg8, 0x12FD0DB4, v1_1);
        Object v0 = arg8.rememberedValue();
        Object v3 = null;
        if(v0 == Composer.Companion.getEmpty()) {
            float v0_1 = !arg7 ? 1f : 0.8f;
            Animatable v0_2 = AnimatableKt.Animatable$default(v0_1, 0f, 2, v3);
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Boolean v2 = Boolean.valueOf(arg7);
        ComposerKt.sourceInformationMarkerStart(arg8, 0x12FD17D6, v1_1);
        boolean v1_2 = arg8.changedInstance(v0);
        int v5 = 0x20;
        int v4 = (arg9 & 0x70 ^ 0x30) > v5 && (arg8.changed(arg7)) || (arg9 & 0x30) == v5 ? 1 : 0;
        v1 = (((int)v1_2)) | v4 | arg8.changedInstance(arg6);
        Object v4_1 = arg8.rememberedValue();
        if(v1 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            v4_2 = new SnackbarHostKt$animatedScale$1$1(((Animatable)v0), arg7, arg6, ((Continuation)v3));
            arg8.updateRememberedValue(v4_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        EffectsKt.LaunchedEffect(v2, ((Function2)v4_2), arg8, arg9 >> 3 & 14);
        State v6 = ((Animatable)v0).asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return v6;
    }

    public static final long toMillis(SnackbarDuration arg8, boolean arg9, AccessibilityManager arg10) {
        long v0;
        int v8 = WhenMappings.$EnumSwitchMapping$0[arg8.ordinal()];
        if(v8 == 1) {
            v0 = 0x7FFFFFFFFFFFFFFFL;
        }
        else if(v8 == 2) {
            v0 = 10000;
        }
        else if(v8 == 3) {
            v0 = 4000;
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        long v3 = v0;
        if(arg10 == null) {
            return v3;
        }

        return arg10.calculateRecommendedTimeoutMillis(v3, true, true, arg9);
    }
}

