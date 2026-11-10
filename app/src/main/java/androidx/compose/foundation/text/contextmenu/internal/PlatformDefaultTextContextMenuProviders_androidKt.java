package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001A*\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001A(\u0010\b\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\f\u0010\u000B\u001A\u0004\u0018\u00010\fX\u008A\u008E\u0002"}, d2={"ProvideDefaultPlatformTextContextMenuProviders", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ProvideBothDefaultProviders", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformDefaultTextContextMenuProviders_androidKt {
    public static Unit $r8$lambda$8haxynKgiU3tXzvJLv8ZaY81pwo(MutableState arg0, LayoutCoordinates arg1) {
        return PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders$lambda$4$0$0(arg0, arg1);
    }

    public static LayoutCoordinates $r8$lambda$eI9cysUDbOm14_j1FqS1qfGfBFg(MutableState arg0) {
        return PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders$lambda$3$0(arg0);
    }

    private static final void ProvideBothDefaultProviders(Modifier arg11, Function2 arg12, Composer arg13, int arg14) {
        PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda0 v2_3;
        MutableState v0_2;
        int v2;
        int v0 = 0x2F1E7EC1;
        Composer v6 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(ProvideBothDefaultProviders)N(modifier,content)59@2599L270,65@2929L72,69@3030L32,70@3089L62,75@3331L254,72@3157L428:PlatformDefaultTextContextMenuProviders.android.kt#18dpbw");
        int v4 = 2;
        if((arg14 & 6) == 0) {
            v2 = v6.changed(arg11) ? 4 : v4;
            v2 |= arg14;
        }
        else {
            v2 = arg14;
        }

        if((arg14 & 0x30) == 0) {
            int v5 = v6.changedInstance(arg12) ? 0x20 : 16;
            v2 |= v5;
        }

        boolean v5_1 = (v2 & 19) != 18 ? true : false;
        if(v6.shouldExecute(v5_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideBothDefaultProviders (PlatformDefaultTextContextMenuProviders.android.kt:58)");
            }

            String v2_1 = "CC(remember):PlatformDefaultTextContextMenuProviders.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v6, 0xE179E20F, v2_1);
            Object v0_1 = v6.rememberedValue();
            Object v7 = null;
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = SnapshotStateKt.mutableStateOf(v7, SnapshotStateKt.neverEqualPolicy());
                v6.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            ComposerKt.sourceInformationMarkerStart(v6, -512095607, v2_1);
            Object v2_2 = v6.rememberedValue();
            if(v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda0(v0_2);
                v6.updateRememberedValue(v2_3);
            }

            Object v5_2 = v2_3;
            ComposerKt.sourceInformationMarkerEnd(v6);
            BasicTextContextMenuProvider v2_4 = DefaultTextContextMenuDropdownProvider_androidKt.defaultTextContextMenuDropdown(v6, 0);
            TextContextMenuProvider v7_1 = AndroidTextContextMenuToolbarProvider_androidKt.platformTextContextMenuToolbarProvider(((Function0)v5_2), ((Function1)v7), v6, 6, v4);
            ProvidedValue[] v10 = new ProvidedValue[v4];
            v10[0] = TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider().provides(v7_1);
            v10[1] = TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider().provides(v2_4);
            CompositionLocalKt.CompositionLocalProvider(v10, ComposableLambdaKt.rememberComposableLambda(0x3FD00381, true, new PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda1(arg11, v0_2, arg12, v2_4, ((Function0)v5_2)), v6, 54), v6, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_89;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_89:
        ScopeUpdateScope v0_3 = v6.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda2(arg11, arg12, arg14));
        }
    }

    private static final LayoutCoordinates ProvideBothDefaultProviders$lambda$1(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void ProvideBothDefaultProviders$lambda$2(MutableState arg0, LayoutCoordinates arg1) {
        arg0.setValue(arg1);
    }

    private static final LayoutCoordinates ProvideBothDefaultProviders$lambda$3$0(MutableState arg0) {
        LayoutCoordinates v0 = PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders$lambda$1(arg0);
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    static final Unit ProvideBothDefaultProviders$lambda$4(Modifier arg5, MutableState arg6, Function2 arg7, BasicTextContextMenuProvider arg8, Function0 arg9, Composer arg10, int arg11) {
        PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda4 v11_1;
        ComposerKt.sourceInformation(arg10, "C78@3443L26,76@3341L238:PlatformDefaultTextContextMenuProviders.android.kt#18dpbw");
        boolean v0 = (arg11 & 3) != 2 ? true : false;
        if(arg10.shouldExecute(v0, arg11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x3FD00381, arg11, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideBothDefaultProviders.<anonymous> (PlatformDefaultTextContextMenuProviders.android.kt:76)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, 0x8BDD355B, "CC(remember):PlatformDefaultTextContextMenuProviders.android.kt#9igjgp");
            Object v11 = arg10.rememberedValue();
            if(v11 == Composer.Companion.getEmpty()) {
                v11_1 = new PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda4(arg6);
                arg10.updateRememberedValue(v11_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            arg5 = OnGloballyPositionedModifierKt.onGloballyPositioned(arg5, ((Function1)v11_1));
            ComposerKt.sourceInformationMarkerStart(arg10, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(arg10, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            arg11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg10, 0));
            CompositionLocalMap v0_1 = arg10.getCurrentCompositionLocalMap();
            arg5 = ComposedModifierKt.materializeModifier(arg10, arg5);
            Function0 v1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg10, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg10.startReusableNode();
            if(arg10.getInserting()) {
                arg10.createNode(v1);
            }
            else {
                arg10.useNode();
            }

            Composer v1_1 = Updater.constructor-impl(arg10);
            Updater.set-impl(v1_1, v6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_1, v0_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v1_1, Integer.valueOf(arg11), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v1_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v1_1, arg5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg10, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg10, 2012781650, "C80@3495L9,81@3534L35:PlatformDefaultTextContextMenuProviders.android.kt#18dpbw");
            arg7.invoke(arg10, Integer.valueOf(0));
            arg8.ContextMenu(arg9, arg10, 6);
            ComposerKt.sourceInformationMarkerEnd(arg10);
            ComposerKt.sourceInformationMarkerEnd(arg10);
            arg10.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg10);
            ComposerKt.sourceInformationMarkerEnd(arg10);
            ComposerKt.sourceInformationMarkerEnd(arg10);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_98;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_98:
        return Unit.INSTANCE;
    }

    private static final Unit ProvideBothDefaultProviders$lambda$4$0$0(MutableState arg0, LayoutCoordinates arg1) {
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders$lambda$2(arg0, arg1);
        return Unit.INSTANCE;
    }

    static final Unit ProvideBothDefaultProviders$lambda$5(Modifier arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProvideDefaultPlatformTextContextMenuProviders(Modifier arg8, Function2 arg9, Composer arg10, int arg11, int arg12) {
        Companion v8;
        int v2;
        int v0 = 0x94B3C0E;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(ProvideDefaultPlatformTextContextMenuProviders)N(modifier,content)38@1661L7,39@1738L7:PlatformDefaultTextContextMenuProviders.android.kt#18dpbw");
        int v1 = arg12 & 1;
        if(v1 != 0) {
            v2 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            v2 = arg10.changed(arg8) ? 4 : 2;
            v2 |= arg11;
        }
        else {
            v2 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            int v3 = arg10.changedInstance(arg9) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(arg10.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v8 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultPlatformTextContextMenuProviders (PlatformDefaultTextContextMenuProviders.android.kt:37)");
            }

            ProvidableCompositionLocal v0_1 = TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider();
            v1 = 0x789C5F52;
            String v3_2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg10, v1, v3_2);
            Object v0_2 = arg10.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg10);
            v0 = v0_2 != null ? 1 : 0;
            ProvidableCompositionLocal v4 = TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider();
            ComposerKt.sourceInformationMarkerStart(arg10, v1, v3_2);
            Object v1_1 = arg10.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg10);
            v1 = v1_1 != null ? 1 : 0;
            if(v0 == 0 || v1 == 0) {
                if(v0 != 0) {
                    arg10.startReplaceGroup(-1976997706);
                    ComposerKt.sourceInformation(arg10, "46@2055L56");
                    AndroidTextContextMenuToolbarProvider_androidKt.ProvidePlatformTextContextMenuToolbar(((Modifier)v8), arg9, arg10, v2 & 0x7E, 0);
                    arg10.endReplaceGroup();
                    goto label_157;
                }

                if(v1 != 0) {
                    arg10.startReplaceGroup(0x8A2BB5B6);
                    ComposerKt.sourceInformation(arg10, "49@2207L56");
                    DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(((Modifier)v8), arg9, arg10, v2 & 0x7E);
                    arg10.endReplaceGroup();
                    goto label_157;
                }

                arg10.startReplaceGroup(-1976716505);
                ComposerKt.sourceInformation(arg10, "52@2332L46");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideBothDefaultProviders(((Modifier)v8), arg9, arg10, v2 & 0x7E);
                arg10.endReplaceGroup();
            }
            else {
                arg10.startReplaceGroup(0x8A2681AE);
                ComposerKt.sourceInformation(arg10, "43@1899L59");
                ComposerKt.sourceInformationMarkerStart(arg10, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy v0_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(arg10, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                v1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg10, 0));
                CompositionLocalMap v3_3 = arg10.getCurrentCompositionLocalMap();
                Modifier v4_1 = ComposedModifierKt.materializeModifier(arg10, ((Modifier)v8));
                Function0 v5 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(arg10, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if(!(arg10.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                arg10.startReusableNode();
                if(arg10.getInserting()) {
                    arg10.createNode(v5);
                }
                else {
                    arg10.useNode();
                }

                Composer v5_1 = Updater.constructor-impl(arg10);
                Updater.set-impl(v5_1, v0_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v5_1, v3_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(v5_1, Integer.valueOf(v1), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(v5_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v5_1, v4_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(arg10, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(arg10, 0xD425106D, "C43@1947L9:PlatformDefaultTextContextMenuProviders.android.kt#18dpbw");
                arg9.invoke(arg10, Integer.valueOf(v2 >> 3 & 14));
                ComposerKt.sourceInformationMarkerEnd(arg10);
                ComposerKt.sourceInformationMarkerEnd(arg10);
                arg10.endNode();
                ComposerKt.sourceInformationMarkerEnd(arg10);
                ComposerKt.sourceInformationMarkerEnd(arg10);
                ComposerKt.sourceInformationMarkerEnd(arg10);
                arg10.endReplaceGroup();
            }

        label_157:
            if(!ComposerKt.isTraceInProgress()) {
                goto label_162;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_162:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new PlatformDefaultTextContextMenuProviders_androidKt$$ExternalSyntheticLambda3(((Modifier)v8), arg9, arg11, arg12));
        }
    }

    static final Unit ProvideDefaultPlatformTextContextMenuProviders$lambda$1(Modifier arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }
}

