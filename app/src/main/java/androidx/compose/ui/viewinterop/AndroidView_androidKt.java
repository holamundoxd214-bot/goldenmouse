package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AK\u0010\u0000\u001A\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\u0014\b\u0002\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\n\u001Ay\u0010\u0000\u001A\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\r\u001A1\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0011\u001A[\u0010\u0012\u001A\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0002¢\u0006\u0004\b \u0010!\u001A\u001C\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00020#\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0010H\u0002\"\"\u0010$\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b%¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'¨\u0006("}, d2={"AndroidView", "", "T", "Landroid/view/View;", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "onReset", "onRelease", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "NoOpUpdate", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidView_androidKt {
    private static final Function1 NoOpUpdate;

    static {
        AndroidView_androidKt.NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;
    }

    public static final void AndroidView(Function1 arg23, Modifier arg24, Function1 arg25, Function1 arg26, Function1 arg27, Composer arg28, int arg29, int arg30) {
        Composer v15;
        Function0 v0_3;
        Modifier v4_2;
        Function1 v12;
        int v11;
        Function1 v10;
        int v9;
        Function1 v8;
        int v7;
        Modifier v5;
        int v3;
        Function1 v1 = arg23;
        int v6 = arg29;
        int v0 = -180024211;
        Composer v2 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(AndroidView)P(!2,3)200@11866L27,202@12028L7,203@12083L7,210@12539L7,211@12610L7:AndroidView.android.kt#z33iqn");
        if((v6 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v3 = v6;
        }

        int v4 = arg30 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_31;
        }
        else if((v6 & 0x30) == 0) {
            v5 = arg24;
            v7 = v2.changed(v5) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_31:
            v5 = arg24;
        }

        v7 = arg30 & 4;
        if(v7 != 0) {
            v3 |= 0x180;
            goto label_46;
        }
        else if((v6 & 0x180) == 0) {
            v8 = arg25;
            v9 = v2.changedInstance(v8) ? 0x100 : 0x80;
            v3 |= v9;
        }
        else {
        label_46:
            v8 = arg25;
        }

        v9 = arg30 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_61;
        }
        else if((v6 & 0xC00) == 0) {
            v10 = arg26;
            v11 = v2.changedInstance(v10) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_61:
            v10 = arg26;
        }

        v11 = arg30 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_76;
        }
        else if((v6 & 0x6000) == 0) {
            v12 = arg27;
            int v13 = v2.changedInstance(v12) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_76:
            v12 = arg27;
        }

        boolean v13_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v13_1, v3 & 1)) {
            if(v4 != 0) {
                Companion v4_1 = Modifier.Companion;
            }
            else {
                v4_2 = v5;
            }

            if(v7 != 0) {
                v8 = null;
            }

            if(v9 != 0) {
                v10 = AndroidView_androidKt.NoOpUpdate;
            }

            if(v11 != 0) {
                v12 = AndroidView_androidKt.NoOpUpdate;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:199)");
            }

            int v17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v2, 0));
            Modifier v16 = ComposedModifierKt.materializeModifier(v2, FocusGroupNode_androidKt.focusInteropModifier(v4_2));
            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Object v18 = v0_2;
            v0_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Object v21 = v0_2;
            CompositionLocalMap v22 = v2.getCurrentCompositionLocalMap();
            v0_1 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Object v19 = v0_2;
            v0_1 = LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_2 = v2.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v2);
            Object v20 = v0_2;
            if(v8 != null) {
                v2.startReplaceGroup(0x4E50C9B8);
                ComposerKt.sourceInformation(v2, "215@12720L37,214@12654L845");
                v0_3 = AndroidView_androidKt.createAndroidViewNodeFactory(v1, v2, v3 & 14);
                ComposerKt.sourceInformationMarkerStart(v2, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if(!(v2.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }

                v2.startReusableNode();
                if(v2.getInserting()) {
                    v2.createNode(v0_3);
                }
                else {
                    v2.useNode();
                }

                v15 = Updater.constructor-impl(v2);
                AndroidView_androidKt.updateViewHolderParams-6NefGtU(v15, v16, v17, ((Density)v18), ((LifecycleOwner)v19), ((SavedStateRegistryOwner)v20), ((LayoutDirection)v21), v22);
                Updater.set-impl(v15, v8, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                Updater.set-impl(v15, v12, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                Updater.set-impl(v15, v10, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                v2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endReplaceGroup();
            }
            else {
                v2.startReplaceGroup(0x4E5DDECF);
                ComposerKt.sourceInformation(v2, "233@13579L37,232@13521L758");
                v0_3 = AndroidView_androidKt.createAndroidViewNodeFactory(v1, v2, v3 & 14);
                ComposerKt.sourceInformationMarkerStart(v2, 0x7076B8D0, "CC(ComposeNode)N(factory,update):Composables.kt#9igjgp");
                if(!(v2.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }

                v2.startNode();
                if(v2.getInserting()) {
                    v2.createNode(v0_3);
                }
                else {
                    v2.useNode();
                }

                v15 = Updater.constructor-impl(v2);
                AndroidView_androidKt.updateViewHolderParams-6NefGtU(v15, v16, v17, ((Density)v18), ((LifecycleOwner)v19), ((SavedStateRegistryOwner)v20), ((LayoutDirection)v21), v22);
                Updater.set-impl(v15, v12, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                Updater.set-impl(v15, v10, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                v2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v2);
                v2.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_198;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v4_2 = v5;
        }

    label_198:
        Function1 v3_1 = v8;
        Function1 v5_1 = v12;
        ScopeUpdateScope v8_1 = v2.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new AndroidView_androidKt$AndroidView$4(v1, ((Companion)v4_2), v3_1, v10, v5_1, v6, arg30));
        }
    }

    public static final void AndroidView(Function1 arg13, Modifier arg14, Function1 arg15, Composer arg16, int arg17, int arg18) {
        Function1 v3_1;
        Modifier v2_1;
        Companion v14;
        int v3;
        int v1;
        int v4 = arg17;
        int v0 = 0x95ADE287;
        Composer v10 = arg16.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(AndroidView)105@5485L92:AndroidView.android.kt#z33iqn");
        if((v4 & 6) == 0) {
            v1 = v10.changedInstance(arg13) ? 4 : 2;
            v1 |= v4;
        }
        else {
            v1 = v4;
        }

        int v2 = arg18 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((v4 & 0x30) == 0) {
            v3 = v10.changed(arg14) ? 0x20 : 16;
            v1 |= v3;
        }

        v3 = arg18 & 4;
        if(v3 != 0) {
            v1 |= 0x180;
        }
        else if((v4 & 0x180) == 0) {
            int v6 = v10.changedInstance(arg15) ? 0x100 : 0x80;
            v1 |= v6;
        }

        boolean v6_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(v10.shouldExecute(v6_1, v1 & 1)) {
            if(v2 != 0) {
                v14 = Modifier.Companion;
            }

            Modifier v6_2 = ((Modifier)v14);
            Function1 v9 = v3 != 0 ? AndroidView_androidKt.NoOpUpdate : arg15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:104)");
            }

            AndroidView_androidKt.AndroidView(arg13, v6_2, null, AndroidView_androidKt.NoOpUpdate, v9, v10, v1 & 14 | 0xC00 | v1 & 0x70 | 0xE000 & v1 << 6, 4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v6_2;
            v3_1 = v9;
        }
        else {
            v10.skipToGroupEnd();
            v2_1 = arg14;
            v3_1 = arg15;
        }

        ScopeUpdateScope v14_1 = v10.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new AndroidView_androidKt$AndroidView$1(arg13, v2_1, v3_1, v4, arg18));
        }
    }

    public static final ViewFactoryHolder access$requireViewFactoryHolder(LayoutNode arg0) {
        return AndroidView_androidKt.requireViewFactoryHolder(arg0);
    }

    private static final Function0 createAndroidViewNodeFactory(Function1 arg10, Composer arg11, int arg12) {
        AndroidView_androidKt$createAndroidViewNodeFactory$1$1 v0_2;
        int v1 = 2030558801;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(createAndroidViewNodeFactory)253@14425L27,254@14495L7,255@14529L28,256@14609L7,257@14647L7,259@14667L339:AndroidView.android.kt#z33iqn");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:252)");
        }

        int v0 = 0;
        int v8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg11, 0));
        ProvidableCompositionLocal v1_1 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_2 = arg11.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(arg11);
        Object v4 = v1_2;
        CompositionContext v6 = ComposablesKt.rememberCompositionContext(arg11, 0);
        v1_1 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v1_2 = arg11.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(arg11);
        Object v7 = v1_2;
        v1_1 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v1_2 = arg11.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(arg11);
        Object v9 = v1_2;
        ComposerKt.sourceInformationMarkerStart(arg11, 0x5689BC24, "CC(remember):AndroidView.android.kt#9igjgp");
        boolean v1_3 = arg11.changedInstance(v4);
        int v3 = 4;
        if((arg12 & 14 ^ 6) > v3 && (arg11.changed(arg10)) || (arg12 & 6) == v3) {
            v0 = 1;
        }

        arg12 = (((int)v1_3)) | v0 | arg11.changedInstance(v6) | arg11.changedInstance(v7) | arg11.changed(v8) | arg11.changedInstance(v9);
        Object v0_1 = arg11.rememberedValue();
        if(arg12 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new AndroidView_androidKt$createAndroidViewNodeFactory$1$1(((Context)v4), arg10, v6, ((SaveableStateRegistry)v7), v8, ((View)v9));
            arg11.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg11);
        return ((Function0)v0_2);
    }

    public static final Function1 getNoOpUpdate() {
        return AndroidView_androidKt.NoOpUpdate;
    }

    private static final ViewFactoryHolder requireViewFactoryHolder(LayoutNode arg0) {
        AndroidViewHolder v0 = arg0.getInteropViewFactoryHolder$ui();
        if(v0 != null) {
            return ((ViewFactoryHolder)v0);
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    private static final void updateViewHolderParams-6NefGtU(Composer arg1, Modifier arg2, int arg3, Density arg4, LifecycleOwner arg5, SavedStateRegistryOwner arg6, LayoutDirection arg7, CompositionLocalMap arg8) {
        Updater.set-impl(arg1, arg8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.set-impl(arg1, arg2, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.set-impl(arg1, arg4, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.set-impl(arg1, arg5, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.set-impl(arg1, arg6, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.set-impl(arg1, arg7, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        Updater.init-impl(arg1, Integer.valueOf(arg3), ComposeUiNode.Companion.getSetCompositeKeyHash());
    }
}

