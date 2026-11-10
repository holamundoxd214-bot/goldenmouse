package androidx.compose.foundation.text.contextmenu.internal;

import android.view.View;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001A@\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0014\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000B\u001A3\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00052\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\f\u0010\u0012\u001A\u0004\u0018\u00010\u000FX\u008A\u008E\u0002"}, d2={"ProvidePlatformTextContextMenuToolbar", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "callbackInjector", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "platformTextContextMenuToolbarProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "coordinatesProvider", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "foundation", "layoutCoordinates"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTextContextMenuToolbarProvider_androidKt {
    public static LayoutCoordinates $r8$lambda$1XOrx0Zehz_hBe70jkvF4LIaGZc(MutableState arg0) {
        return AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$4$0(arg0);
    }

    public static DisposableEffectResult $r8$lambda$DJuQVQMbJ_932mGbtw8rtPlbGVM(AndroidTextContextMenuToolbarProvider arg0, DisposableEffectScope arg1) {
        return AndroidTextContextMenuToolbarProvider_androidKt.platformTextContextMenuToolbarProvider$lambda$1$0(arg0, arg1);
    }

    public static Unit $r8$lambda$PilCvhZydSfRkHnrO-CmE_zAGic(MutableState arg0, LayoutCoordinates arg1) {
        return AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$5$0$0(arg0, arg1);
    }

    public static final void ProvidePlatformTextContextMenuToolbar(Modifier arg7, Function1 arg8, Function2 arg9, Composer arg10, int arg11, int arg12) {
        AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda3 v1_3;
        Companion v7;
        int v3;
        int v2;
        int v0 = 0x2E032B74;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(ProvidePlatformTextContextMenuToolbar)N(modifier,callbackInjector,content)84@3717L270,92@4090L47,91@4016L181,96@4283L189,96@4203L269:AndroidTextContextMenuToolbarProvider.android.kt#18dpbw");
        int v1 = arg12 & 1;
        if(v1 != 0) {
            v2 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            v2 = arg10.changed(arg7) ? 4 : 2;
            v2 |= arg11;
        }
        else {
            v2 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v3 = arg10.changedInstance(arg8) ? 0x20 : 16;
            v2 |= v3;
        }

        if((arg11 & 0x180) == 0) {
            v3 = arg10.changedInstance(arg9) ? 0x100 : 0x80;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v7 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar (AndroidTextContextMenuToolbarProvider.android.kt:83)");
            }

            String v1_1 = "CC(remember):AndroidTextContextMenuToolbarProvider.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg10, -1176093790, v1_1);
            Object v0_1 = arg10.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                MutableState v0_2 = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
                arg10.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            ComposerKt.sourceInformationMarkerStart(arg10, -1176082077, v1_1);
            Object v1_2 = arg10.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda3(((MutableState)v0_1));
                arg10.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            CompositionLocalKt.CompositionLocalProvider(TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider().provides(AndroidTextContextMenuToolbarProvider_androidKt.platformTextContextMenuToolbarProvider(((Function0)v1_3), arg8, arg10, v2 & 0x70 | 6, 0)), ComposableLambdaKt.rememberComposableLambda(0xEEA50034, true, new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda4(((Modifier)v7), ((MutableState)v0_1), arg9), arg10, 54), arg10, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_92;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_92:
        Modifier v2_1 = ((Modifier)v7);
        ScopeUpdateScope v7_1 = arg10.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda5(v2_1, arg8, arg9, arg11, arg12));
        }
    }

    public static final void ProvidePlatformTextContextMenuToolbar(Modifier arg7, Function2 arg8, Composer arg9, int arg10, int arg11) {
        Function2 v3;
        Companion v7;
        int v1;
        int v0 = 2064964257;
        Composer v4 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(ProvidePlatformTextContextMenuToolbar)N(modifier,content)67@3059L62:AndroidTextContextMenuToolbarProvider.android.kt#18dpbw");
        int v9 = arg11 & 1;
        if(v9 != 0) {
            v1 = arg10 | 6;
        }
        else if((arg10 & 6) == 0) {
            v1 = v4.changed(arg7) ? 4 : 2;
            v1 |= arg10;
        }
        else {
            v1 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v2 = v4.changedInstance(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v2_1, v1 & 1)) {
            if(v9 != 0) {
                v7 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar (AndroidTextContextMenuToolbarProvider.android.kt:66)");
            }

            int v5 = v1 & 14 | 0x30 | v1 << 3 & 0x380;
            Modifier v1_1 = ((Modifier)v7);
            v3 = arg8;
            AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(v1_1, null, v3, v4, v5, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg7 = v1_1;
        }
        else {
            v3 = arg8;
            v4.skipToGroupEnd();
        }

        ScopeUpdateScope v8 = v4.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(arg7, v3, arg10, arg11));
        }
    }

    static final Unit ProvidePlatformTextContextMenuToolbar$lambda$0(Modifier arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }

    private static final LayoutCoordinates ProvidePlatformTextContextMenuToolbar$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void ProvidePlatformTextContextMenuToolbar$lambda$3(MutableState arg0, LayoutCoordinates arg1) {
        arg0.setValue(arg1);
    }

    private static final LayoutCoordinates ProvidePlatformTextContextMenuToolbar$lambda$4$0(MutableState arg0) {
        LayoutCoordinates v0 = AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$2(arg0);
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    static final Unit ProvidePlatformTextContextMenuToolbar$lambda$5(Modifier arg5, MutableState arg6, Function2 arg7, Composer arg8, int arg9) {
        AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda1 v9_1;
        ComposerKt.sourceInformation(arg8, "C99@4395L26,97@4293L173:AndroidTextContextMenuToolbarProvider.android.kt#18dpbw");
        boolean v0 = (arg9 & 3) != 2 ? true : false;
        if(arg8.shouldExecute(v0, arg9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEEA50034, arg9, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvidePlatformTextContextMenuToolbar.<anonymous> (AndroidTextContextMenuToolbarProvider.android.kt:97)");
            }

            ComposerKt.sourceInformationMarkerStart(arg8, -647638706, "CC(remember):AndroidTextContextMenuToolbarProvider.android.kt#9igjgp");
            Object v9 = arg8.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                v9_1 = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda1(arg6);
                arg8.updateRememberedValue(v9_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg8);
            arg5 = OnGloballyPositionedModifierKt.onGloballyPositioned(arg5, ((Function1)v9_1));
            ComposerKt.sourceInformationMarkerStart(arg8, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(arg8, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            arg9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg8, 0));
            CompositionLocalMap v0_1 = arg8.getCurrentCompositionLocalMap();
            arg5 = ComposedModifierKt.materializeModifier(arg8, arg5);
            Function0 v1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg8, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg8.startReusableNode();
            if(arg8.getInserting()) {
                arg8.createNode(v1);
            }
            else {
                arg8.useNode();
            }

            Composer v1_1 = Updater.constructor-impl(arg8);
            Updater.set-impl(v1_1, v6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_1, v0_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v1_1, Integer.valueOf(arg9), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v1_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v1_1, arg5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg8, -1683055520, "C101@4447L9:AndroidTextContextMenuToolbarProvider.android.kt#18dpbw");
            arg7.invoke(arg8, Integer.valueOf(0));
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            arg8.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_96;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_96:
        return Unit.INSTANCE;
    }

    private static final Unit ProvidePlatformTextContextMenuToolbar$lambda$5$0$0(MutableState arg0, LayoutCoordinates arg1) {
        AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar$lambda$3(arg0, arg1);
        return Unit.INSTANCE;
    }

    static final Unit ProvidePlatformTextContextMenuToolbar$lambda$6(Modifier arg6, Function1 arg7, Function2 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final TextContextMenuProvider platformTextContextMenuToolbarProvider(Function0 arg2, Function1 arg3, Composer arg4, int arg5, int arg6) {
        int v1 = 549805508;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(platformTextContextMenuToolbarProvider)N(coordinatesProvider,callbackInjector)111@4729L7,113@4764L121,117@4918L73,117@4891L100:AndroidTextContextMenuToolbarProvider.android.kt#18dpbw");
        if((arg6 & 2) != 0) {
            arg3 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.text.contextmenu.internal.platformTextContextMenuToolbarProvider (AndroidTextContextMenuToolbarProvider.android.kt:110)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        String v0 = "CC(remember):AndroidTextContextMenuToolbarProvider.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg4, 0x4E51E9D, v0);
        boolean v6 = arg4.changed(v5_1);
        Object v1_1 = arg4.rememberedValue();
        if((v6) || v1_1 == Composer.Companion.getEmpty()) {
            AndroidTextContextMenuToolbarProvider v1_2 = new AndroidTextContextMenuToolbarProvider(((View)v5_1), arg3, arg2);
            arg4.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x4E531AD, v0);
        boolean v2 = arg4.changedInstance(v1_1);
        Object v3 = arg4.rememberedValue();
        if((v2) || v3 == Composer.Companion.getEmpty()) {
            AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda2 v3_1 = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda2(((AndroidTextContextMenuToolbarProvider)v1_1));
            arg4.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        EffectsKt.DisposableEffect(v1_1, ((Function1)v3), arg4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((TextContextMenuProvider)v1_1);
    }

    private static final DisposableEffectResult platformTextContextMenuToolbarProvider$lambda$1$0(AndroidTextContextMenuToolbarProvider arg0, DisposableEffectScope arg1) {
        arg0.start();
        return new AndroidTextContextMenuToolbarProvider_androidKt$platformTextContextMenuToolbarProvider$lambda$1$0$$inlined$onDispose$1(arg0);
    }
}

