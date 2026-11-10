package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0088\u0001\u0010\u0000\u001A\u00020\u00012\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001AR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001A\u0090\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00142\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001AR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0015\u001Ae\u0010\u0016\u001A\u00020\u00172V\u0010\u0005\u001AR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\f\u0010\u001A\u001A\u0004\u0018\u00010\u000EX\u008A\u008E\u0002"}, d2={"ProvideBasicTextContextMenu", "", "providableCompositionLocal", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "contextMenu", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ParameterName;", "name", "session", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "dataProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "anchorLayoutCoordinates", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "basicTextContextMenuProvider", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "foundation", "layoutCoordinates"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTextContextMenuProviderKt {
    public static Unit $r8$lambda$OeYe2yNcm7irNVRRVCtNFXERuh4(MutableState arg0, LayoutCoordinates arg1) {
        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$4$0$0(arg0, arg1);
    }

    public static DisposableEffectResult $r8$lambda$TZ316ngMicl8KVssbj6fOLG2m0Q(BasicTextContextMenuProvider arg0, DisposableEffectScope arg1) {
        return BasicTextContextMenuProviderKt.basicTextContextMenuProvider$lambda$1$0(arg0, arg1);
    }

    public static LayoutCoordinates $r8$lambda$TsQiCOlE9SPto-h6JDg5iAJxOAw(MutableState arg0) {
        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$4$1$0$0(arg0);
    }

    public static final void ProvideBasicTextContextMenu(Modifier arg6, ProvidableCompositionLocal arg7, Function5 arg8, Function2 arg9, Composer arg10, int arg11) {
        MutableState v0_2;
        int v2;
        int v1;
        int v0 = -714464401;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(ProvideBasicTextContextMenu)N(modifier,providableCompositionLocal,contextMenu,content)81@3548L65,85@3634L41,86@3751L270,86@3680L341:BasicTextContextMenuProvider.kt#qzx0zs");
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg6) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(arg7) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg8) ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((arg11 & 0xC00) == 0) {
            v2 = arg10.changedInstance(arg9) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:80)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0x236F3D90, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
            Object v0_1 = arg10.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
                arg10.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            BasicTextContextMenuProvider v1_1 = BasicTextContextMenuProviderKt.basicTextContextMenuProvider(arg8, arg10, v1 >> 6 & 14);
            CompositionLocalKt.CompositionLocalProvider(arg7.provides(v1_1), ComposableLambdaKt.rememberComposableLambda(0x1059082F, true, new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda4(arg6, v0_2, arg9, v1_1), arg10, 54), arg10, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_82;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_82:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda5(arg6, arg7, arg8, arg9, arg11));
        }
    }

    public static final void ProvideBasicTextContextMenu(ProvidableCompositionLocal arg7, Function5 arg8, Function2 arg9, Composer arg10, int arg11) {
        Function2 v4;
        Function5 v3;
        ProvidableCompositionLocal v2;
        int v1;
        int v10;
        int v0 = 2072681886;
        Composer v5 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(ProvideBasicTextContextMenu)N(providableCompositionLocal,contextMenu,content)65@2975L87:BasicTextContextMenuProvider.kt#qzx0zs");
        if((arg11 & 6) == 0) {
            v10 = v5.changed(arg7) ? 4 : 2;
            v10 |= arg11;
        }
        else {
            v10 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v1 = v5.changedInstance(arg8) ? 0x20 : 16;
            v10 |= v1;
        }

        if((arg11 & 0x180) == 0) {
            v1 = v5.changedInstance(arg9) ? 0x100 : 0x80;
            v10 |= v1;
        }

        boolean v1_1 = (v10 & 0x93) != 0x92 ? true : false;
        if(v5.shouldExecute(v1_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:64)");
            }

            v10 <<= 3;
            v2 = arg7;
            v3 = arg8;
            v4 = arg9;
            BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(Modifier.Companion, v2, v3, v4, v5, v10 & 0x70 | 6 | v10 & 0x380 | v10 & 0x1C00);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_65;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2 = arg7;
            v3 = arg8;
            v4 = arg9;
            v5.skipToGroupEnd();
        }

    label_65:
        ScopeUpdateScope v7 = v5.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda0(v2, v3, v4, arg11));
        }
    }

    static final Unit ProvideBasicTextContextMenu$lambda$0(ProvidableCompositionLocal arg0, Function5 arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final LayoutCoordinates ProvideBasicTextContextMenu$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void ProvideBasicTextContextMenu$lambda$3(MutableState arg0, LayoutCoordinates arg1) {
        arg0.setValue(arg1);
    }

    static final Unit ProvideBasicTextContextMenu$lambda$4(Modifier arg7, MutableState arg8, Function2 arg9, BasicTextContextMenuProvider arg10, Composer arg11, int arg12) {
        ComposerKt.sourceInformation(arg11, "C89@3863L26,87@3761L254:BasicTextContextMenuProvider.kt#qzx0zs");
        boolean v0 = (arg12 & 3) != 2 ? true : false;
        if(arg11.shouldExecute(v0, arg12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1059082F, arg12, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu.<anonymous> (BasicTextContextMenuProvider.kt:87)");
            }

            String v0_1 = "CC(remember):BasicTextContextMenuProvider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg11, 1580713609, v0_1);
            Object v12 = arg11.rememberedValue();
            if(v12 == Composer.Companion.getEmpty()) {
                BasicTextContextMenuProviderKt$$ExternalSyntheticLambda2 v12_1 = new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda2(arg8);
                arg11.updateRememberedValue(v12_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg7 = OnGloballyPositionedModifierKt.onGloballyPositioned(arg7, ((Function1)v12));
            ComposerKt.sourceInformationMarkerStart(arg11, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v12_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(arg11, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg11, 0));
            CompositionLocalMap v2 = arg11.getCurrentCompositionLocalMap();
            arg7 = ComposedModifierKt.materializeModifier(arg11, arg7);
            Function0 v4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg11, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v4);
            }
            else {
                arg11.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v4_1, v12_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_1, v2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v4_1, Integer.valueOf(v1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v4_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v4_1, arg7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg11, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg11, -733481004, "C91@3915L9,92@3958L47,92@3946L59:BasicTextContextMenuProvider.kt#qzx0zs");
            arg9.invoke(arg11, Integer.valueOf(0));
            ComposerKt.sourceInformationMarkerStart(arg11, 0x27E14F44, v0_1);
            Object v7 = arg11.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                BasicTextContextMenuProviderKt$$ExternalSyntheticLambda3 v7_1 = new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda3(arg8);
                arg11.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg10.ContextMenu(((Function0)v7), arg11, 6);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_108;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_108:
        return Unit.INSTANCE;
    }

    private static final Unit ProvideBasicTextContextMenu$lambda$4$0$0(MutableState arg0, LayoutCoordinates arg1) {
        BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$3(arg0, arg1);
        return Unit.INSTANCE;
    }

    private static final LayoutCoordinates ProvideBasicTextContextMenu$lambda$4$1$0$0(MutableState arg0) {
        LayoutCoordinates v0 = BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$2(arg0);
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    static final Unit ProvideBasicTextContextMenu$lambda$5(Modifier arg6, ProvidableCompositionLocal arg7, Function5 arg8, Function2 arg9, int arg10, Composer arg11, int arg12) {
        BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    public static final BasicTextContextMenuProvider basicTextContextMenuProvider(Function5 arg4, Composer arg5, int arg6) {
        BasicTextContextMenuProvider v0_1;
        int v1 = 100861460;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(basicTextContextMenuProvider)N(contextMenu)107@4360L67,108@4459L35,108@4432L62:BasicTextContextMenuProvider.kt#qzx0zs");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.foundation.text.contextmenu.provider.basicTextContextMenuProvider (BasicTextContextMenuProvider.kt:106)");
        }

        String v1_1 = "CC(remember):BasicTextContextMenuProvider.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg5, 0x9159F897, v1_1);
        int v3 = 4;
        arg6 = (arg6 & 14 ^ 6) > v3 && (arg5.changed(arg4)) || (arg6 & 6) == v3 ? 1 : 0;
        Object v0 = arg5.rememberedValue();
        if(arg6 != 0 || v0 == Composer.Companion.getEmpty()) {
            v0_1 = new BasicTextContextMenuProvider(arg4);
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x915A04D7, v1_1);
        boolean v4 = arg5.changed(v0_1);
        Object v6 = arg5.rememberedValue();
        if((v4) || v6 == Composer.Companion.getEmpty()) {
            BasicTextContextMenuProviderKt$$ExternalSyntheticLambda1 v6_1 = new BasicTextContextMenuProviderKt$$ExternalSyntheticLambda1(v0_1);
            arg5.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        EffectsKt.DisposableEffect(v0_1, ((Function1)v6), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v0_1;
    }

    private static final DisposableEffectResult basicTextContextMenuProvider$lambda$1$0(BasicTextContextMenuProvider arg0, DisposableEffectScope arg1) {
        return new BasicTextContextMenuProviderKt$basicTextContextMenuProvider$lambda$1$0$$inlined$onDispose$1(arg0);
    }
}

