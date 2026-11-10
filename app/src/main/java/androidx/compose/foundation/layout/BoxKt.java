package androidx.compose.foundation.layout;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AJ\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000B¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001A\u001C\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000F2\u0006\u0010\u0011\u001A\u00020\u0007H\u0002\u001A\u0018\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001\u001A\u001D\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0017\u001A<\u0010\u0019\u001A\u00020\u0001*\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\"2\u0006\u0010\u0015\u001A\u00020\u0005H\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010$\"\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0018\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010%\u001A\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'\"\u001A\u0010(\u001A\u0004\u0018\u00010)*\u00020\u001E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+\"\u0018\u0010,\u001A\u00020\u0007*\u00020\u001E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b-\u0010.¨\u0006/"}, d2={"Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "cacheFor", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/MeasurePolicy;", "propagate", "Cache1", "Cache2", "maybeCachedBoxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "DefaultBoxMeasurePolicy", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "boxChildDataNode", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "matchesParentSize", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BoxKt {
    private static final MutableScatterMap Cache1;
    private static final MutableScatterMap Cache2;
    private static final MeasurePolicy DefaultBoxMeasurePolicy;
    private static final MeasurePolicy EmptyBoxMeasurePolicy;

    static {
        BoxKt.Cache1 = BoxKt.cacheFor(true);
        BoxKt.Cache2 = BoxKt.cacheFor(false);
        BoxKt.DefaultBoxMeasurePolicy = new BoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        BoxKt.EmptyBoxMeasurePolicy = BoxKt$EmptyBoxMeasurePolicy$1.INSTANCE;
    }

    public static final void Box(Modifier arg7, Composer arg8, int arg9) {
        int v1;
        int v0 = -211209833;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(Box)N(modifier)233@9541L66:Box.kt#2w3rfo");
        int v2 = 2;
        if((arg9 & 6) == 0) {
            v1 = arg8.changed(arg7) ? 4 : v2;
            v1 |= arg9;
        }
        else {
            v1 = arg9;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg8.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.layout.Box (Box.kt:232)");
            }

            MeasurePolicy v0_1 = BoxKt.EmptyBoxMeasurePolicy;
            ComposerKt.sourceInformationMarkerStart(arg8, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
            v1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg8, 0));
            Modifier v2_2 = ComposedModifierKt.materializeModifier(arg8, arg7);
            CompositionLocalMap v3 = arg8.getCurrentCompositionLocalMap();
            Function0 v4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg8, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(arg8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg8.startReusableNode();
            if(arg8.getInserting()) {
                arg8.createNode(v4);
            }
            else {
                arg8.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(arg8);
            Updater.set-impl(v4_1, v0_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_1, v3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.reconcile-impl(v4_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v4_1, v2_2, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v4_1, Integer.valueOf(v1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            arg8.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg8);
            ComposerKt.sourceInformationMarkerEnd(arg8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_77;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_77:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new BoxKt$$ExternalSyntheticLambda0(arg7, arg9));
        }
    }

    public static final void Box(Modifier arg3, Alignment arg4, boolean arg5, Function3 arg6, Composer arg7, int arg8, int arg9) {
        Companion v3;
        ComposerKt.sourceInformationMarkerStart(arg7, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        if((arg9 & 1) != 0) {
            v3 = Modifier.Companion;
        }

        if((arg9 & 2) != 0) {
            arg4 = Alignment.Companion.getTopStart();
        }

        MeasurePolicy v4 = BoxKt.maybeCachedBoxMeasurePolicy(arg4, false);
        ComposerKt.sourceInformationMarkerStart(arg7, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int v5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg7, 0));
        CompositionLocalMap v9 = arg7.getCurrentCompositionLocalMap();
        arg3 = ComposedModifierKt.materializeModifier(arg7, ((Modifier)v3));
        Function0 v0 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(arg7, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if(!(arg7.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg7.startReusableNode();
        if(arg7.getInserting()) {
            arg7.createNode(v0);
        }
        else {
            arg7.useNode();
        }

        Composer v0_1 = Updater.constructor-impl(arg7);
        Updater.set-impl(v0_1, v4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v0_1, v9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(v0_1, Integer.valueOf(v5), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(v0_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v0_1, arg3, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(arg7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        arg6.invoke(BoxScopeInstance.INSTANCE, arg7, Integer.valueOf(arg8 >> 6 & 0x70 | 6));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        arg7.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ComposerKt.sourceInformationMarkerEnd(arg7);
    }

    static final Unit Box$lambda$1(Modifier arg0, int arg1, Composer arg2, int arg3) {
        BoxKt.Box(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean access$getMatchesParentSize(Measurable arg0) {
        return BoxKt.getMatchesParentSize(arg0);
    }

    public static final void access$placeInBox(PlacementScope arg0, Placeable arg1, Measurable arg2, LayoutDirection arg3, int arg4, int arg5, Alignment arg6) {
        BoxKt.placeInBox(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final MutableScatterMap cacheFor(boolean arg4) {
        MutableScatterMap v0 = new MutableScatterMap(9);
        v0.set(Alignment.Companion.getTopStart(), new BoxMeasurePolicy(Alignment.Companion.getTopStart(), arg4));
        v0.set(Alignment.Companion.getTopCenter(), new BoxMeasurePolicy(Alignment.Companion.getTopCenter(), arg4));
        v0.set(Alignment.Companion.getTopEnd(), new BoxMeasurePolicy(Alignment.Companion.getTopEnd(), arg4));
        v0.set(Alignment.Companion.getCenterStart(), new BoxMeasurePolicy(Alignment.Companion.getCenterStart(), arg4));
        v0.set(Alignment.Companion.getCenter(), new BoxMeasurePolicy(Alignment.Companion.getCenter(), arg4));
        v0.set(Alignment.Companion.getCenterEnd(), new BoxMeasurePolicy(Alignment.Companion.getCenterEnd(), arg4));
        v0.set(Alignment.Companion.getBottomStart(), new BoxMeasurePolicy(Alignment.Companion.getBottomStart(), arg4));
        v0.set(Alignment.Companion.getBottomCenter(), new BoxMeasurePolicy(Alignment.Companion.getBottomCenter(), arg4));
        v0.set(Alignment.Companion.getBottomEnd(), new BoxMeasurePolicy(Alignment.Companion.getBottomEnd(), arg4));
        return v0;
    }

    private static final BoxChildDataNode getBoxChildDataNode(Measurable arg1) {
        Object v1 = arg1.getParentData();
        if((v1 instanceof BoxChildDataNode)) {
            return ((BoxChildDataNode)v1);
        }

        return null;
    }

    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return BoxKt.EmptyBoxMeasurePolicy;
    }

    private static final boolean getMatchesParentSize(Measurable arg0) {
        BoxChildDataNode v0 = BoxKt.getBoxChildDataNode(arg0);
        if(v0 != null) {
            return v0.getMatchParentSize();
        }

        return 0;
    }

    public static final MeasurePolicy maybeCachedBoxMeasurePolicy(Alignment arg1, boolean arg2) {
        BoxMeasurePolicy v0_2;
        MutableScatterMap v0 = arg2 ? BoxKt.Cache1 : BoxKt.Cache2;
        Object v0_1 = v0.get(arg1);
        if(v0_1 == null) {
            v0_2 = new BoxMeasurePolicy(arg1, arg2);
        }

        return ((MeasurePolicy)v0_2);
    }

    private static final void placeInBox(PlacementScope arg7, Placeable arg8, Measurable arg9, LayoutDirection arg10, int arg11, int arg12, Alignment arg13) {
        Alignment v0;
        BoxChildDataNode v9 = BoxKt.getBoxChildDataNode(arg9);
        if(v9 != null) {
            Alignment v9_1 = v9.getAlignment();
            if(v9_1 == null) {
                goto label_7;
            }
            else {
                v0 = v9_1;
            }
        }
        else {
        label_7:
            v0 = arg13;
        }

        PlacementScope.place-70tqf50$default(arg7, arg8, v0.align-KFBX0sM(IntSize.constructor-impl((((long)arg8.getWidth())) << 0x20 | (((long)arg8.getHeight())) & 0xFFFFFFFFL), IntSize.constructor-impl((((long)arg12)) & 0xFFFFFFFFL | (((long)arg11)) << 0x20), arg10), 0f, 2, null);
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment arg5, boolean arg6, Composer arg7, int arg8) {
        Object v5_1;
        int v1 = 56522820;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberBoxMeasurePolicy)N(alignment,propagateMinConstraints):Box.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:109)");
        }

        if(!Intrinsics.areEqual(arg5, Alignment.Companion.getTopStart()) || (arg6)) {
            arg7.startReplaceGroup(0xE90F175);
            ComposerKt.sourceInformation(arg7, "112@5069L121");
            ComposerKt.sourceInformationMarkerStart(arg7, 0xA5A1955D, "CC(remember):Box.kt#9igjgp");
            v1 = 0;
            int v3 = 4;
            int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
            int v4 = 0x20;
            if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
                v1 = 1;
            }

            arg8 = v0 | v1;
            Object v0_1 = arg7.rememberedValue();
            if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                BoxMeasurePolicy v0_2 = new BoxMeasurePolicy(arg5, arg6);
                arg7.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            arg7.endReplaceGroup();
            v5_1 = v0_1;
        }
        else {
            arg7.startReplaceGroup(0xE903737);
            arg7.endReplaceGroup();
            MeasurePolicy v5 = BoxKt.DefaultBoxMeasurePolicy;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((MeasurePolicy)v5_1);
    }
}

