package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message="ContextualFlowLayouts are no longer maintained") @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u00120\b\u0002\u0010\u0007\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextualFlowColumnOverflow extends FlowLayoutOverflow {
    @Deprecated(message="ContextualFlowLayouts are no longer maintained") @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001A\u00020\u00052\u001C\u0010\r\u001A\u0018\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000E¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013J_\u0010\u0014\u001A\u00020\u00052\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000E¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001C\u0010\u0015\u001A\u0018\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000E¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001BR\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow$Companion;", "", "<init>", "()V", "Visible", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "getVisible$annotations", "getVisible", "()Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Clip", "getClip$annotations", "getClip", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minColumnsToShowCollapse", "", "minWidthToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static Function2 $r8$lambda$-bfQgbx3w_eVB_LtFrXxVd_0Trc(Function3 arg0, FlowLayoutOverflowState arg1) {
            return Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$0(arg0, arg1);
        }

        public static Unit $r8$lambda$4n-odbOtTUpkc3kYklF1ZSBmsGI(FlowLayoutOverflowState arg0, Function3 arg1, Composer arg2, int arg3) {
            return Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$1$0(arg0, arg1, arg2, arg3);
        }

        public static Unit $r8$lambda$fgDiob43oc5TqlfaLq1mH3Mju0A(FlowLayoutOverflowState arg0, Function3 arg1, Composer arg2, int arg3) {
            return Companion.expandIndicator$lambda$0$0(arg0, arg1, arg2, arg3);
        }

        public static Function2 $r8$lambda$jdK7e9cffMn02Fw6ltS22ljlqZo(Function3 arg0, FlowLayoutOverflowState arg1) {
            return Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$1(arg0, arg1);
        }

        public static Unit $r8$lambda$pIMuEcMBTeYNueohciPL9xAwr5g(FlowLayoutOverflowState arg0, Function3 arg1, Composer arg2, int arg3) {
            return Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$0$0(arg0, arg1, arg2, arg3);
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ContextualFlowColumnOverflow expandIndicator(Function3 arg9) {
            return new ContextualFlowColumnOverflow(OverflowType.ExpandIndicator, 0, 0, new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda3(arg9), null, 22, null);
        }

        static final Function2 expandIndicator$lambda$0(Function3 arg1, FlowLayoutOverflowState arg2) {
            return ComposableLambdaKt.composableLambdaInstance(-800948529, true, new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda4(arg2, arg1));
        }

        private static final Unit expandIndicator$lambda$0$0(FlowLayoutOverflowState arg4, Function3 arg5, Composer arg6, int arg7) {
            ComposerKt.sourceInformation(arg6, "C505@23919L9:FlowLayoutOverflow.kt#2w3rfo");
            boolean v0 = (arg7 & 3) != 2 ? true : false;
            if(arg6.shouldExecute(v0, arg7 & 1)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-800948529, arg7, -1, "androidx.compose.foundation.layout.ContextualFlowColumnOverflow.Companion.expandIndicator.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:504)");
                }

                arg5.invoke(new ContextualFlowColumnOverflowScopeImpl(arg4), arg6, Integer.valueOf(0));
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_27;
                }

                ComposerKt.traceEventEnd();
            }
            else {
                arg6.skipToGroupEnd();
            }

        label_27:
            return Unit.INSTANCE;
        }

        public final ContextualFlowColumnOverflow expandOrCollapseIndicator--jt2gSs(Function3 arg13, Function3 arg14, int arg15, float arg16, Composer arg17, int arg18, int arg19) {
            ContextualFlowColumnOverflow v2_3;
            Composer v0 = arg17;
            int v1 = arg18;
            int v3 = 0xBA48F934;
            ComposerKt.sourceInformationMarkerStart(v0, v3, "C(expandOrCollapseIndicator)N(expandIndicator,collapseIndicator,minColumnsToShowCollapse,minWidthToShowCollapse:c#ui.unit.Dp)545@26090L7,546@26157L1124:FlowLayoutOverflow.kt#2w3rfo");
            int v4 = 1;
            int v7 = (arg19 & 4) != 0 ? 1 : arg15;
            float v2 = (arg19 & 8) != 0 ? Dp.constructor-impl(0f) : arg16;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.foundation.layout.ContextualFlowColumnOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:543)");
            }

            ProvidableCompositionLocal v3_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v3_2 = v0.consume(((CompositionLocal)v3_1));
            ComposerKt.sourceInformationMarkerEnd(v0);
            int v8 = ((Density)v3_2).roundToPx-0680j_4(v2);
            ComposerKt.sourceInformationMarkerStart(v0, 1274002808, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            v3 = 0x100;
            int v2_1 = (v1 & 0x380 ^ 0x180) > v3 && (v0.changed(v7)) || (v1 & 0x180) == v3 ? 1 : 0;
            v2_1 |= v0.changed(v8);
            int v6 = 4;
            v3 = (v1 & 14 ^ 6) > v6 && (v0.changed(arg13)) || (v1 & 6) == v6 ? 1 : 0;
            v2_1 |= v3;
            v6 = 0x20;
            if((v1 & 0x70 ^ 0x30) <= v6 || !v0.changed(arg14)) {
                if((v1 & 0x30) == v6) {
                }
                else {
                    v4 = 0;
                }
            }

            v1 = v2_1 | v4;
            Object v2_2 = v0.rememberedValue();
            if(v1 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                ContextualFlowColumnOverflow v5 = new ContextualFlowColumnOverflow(OverflowType.ExpandOrCollapseIndicator, v7, v8, new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda1(arg13), new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda2(arg14), null);
                v0.updateRememberedValue(v5);
                v2_3 = v5;
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
            return v2_3;
        }

        private static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$1$0(Function3 arg1, FlowLayoutOverflowState arg2) {
            return ComposableLambdaKt.composableLambdaInstance(0x1D7BF47C, true, new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda0(arg2, arg1));
        }

        private static final Unit expandOrCollapseIndicator__jt2gSs$lambda$1$0$0(FlowLayoutOverflowState arg4, Function3 arg5, Composer arg6, int arg7) {
            ComposerKt.sourceInformation(arg6, "C555@26552L17:FlowLayoutOverflow.kt#2w3rfo");
            boolean v0 = (arg7 & 3) != 2 ? true : false;
            if(arg6.shouldExecute(v0, arg7 & 1)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(0x1D7BF47C, arg7, -1, "androidx.compose.foundation.layout.ContextualFlowColumnOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:554)");
                }

                arg5.invoke(new ContextualFlowColumnOverflowScopeImpl(arg4), arg6, Integer.valueOf(0));
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_27;
                }

                ComposerKt.traceEventEnd();
            }
            else {
                arg6.skipToGroupEnd();
            }

        label_27:
            return Unit.INSTANCE;
        }

        private static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$1$1(Function3 arg1, FlowLayoutOverflowState arg2) {
            return ComposableLambdaKt.composableLambdaInstance(0x6D0B4583, true, new ContextualFlowColumnOverflow$Companion$$ExternalSyntheticLambda5(arg2, arg1));
        }

        private static final Unit expandOrCollapseIndicator__jt2gSs$lambda$1$1$0(FlowLayoutOverflowState arg4, Function3 arg5, Composer arg6, int arg7) {
            ComposerKt.sourceInformation(arg6, "C562@26829L19:FlowLayoutOverflow.kt#2w3rfo");
            boolean v0 = (arg7 & 3) != 2 ? true : false;
            if(arg6.shouldExecute(v0, arg7 & 1)) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(0x6D0B4583, arg7, -1, "androidx.compose.foundation.layout.ContextualFlowColumnOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:561)");
                }

                arg5.invoke(new ContextualFlowColumnOverflowScopeImpl(arg4), arg6, Integer.valueOf(0));
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_27;
                }

                ComposerKt.traceEventEnd();
            }
            else {
                arg6.skipToGroupEnd();
            }

        label_27:
            return Unit.INSTANCE;
        }

        public final ContextualFlowColumnOverflow getClip() {
            return ContextualFlowColumnOverflow.Clip;
        }

        public static void getClip$annotations() {
        }

        public final ContextualFlowColumnOverflow getVisible() {
            return ContextualFlowColumnOverflow.Visible;
        }

        public static void getVisible$annotations() {
        }
    }

    public static final int $stable;
    private static final ContextualFlowColumnOverflow Clip;
    public static final Companion Companion;
    private static final ContextualFlowColumnOverflow Visible;

    static {
        ContextualFlowColumnOverflow.Companion = new Companion(null);
        ContextualFlowColumnOverflow.Visible = new ContextualFlowColumnOverflow(OverflowType.Visible, 0, 0, null, null, 30, null);
        ContextualFlowColumnOverflow.Clip = new ContextualFlowColumnOverflow(OverflowType.Clip, 0, 0, null, null, 30, null);
    }

    ContextualFlowColumnOverflow(OverflowType arg2, int arg3, int arg4, Function1 arg5, Function1 arg6, int arg7, DefaultConstructorMarker arg8) {
        Function1 v0 = null;
        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        if((arg7 & 16) != 0) {
            arg6 = v0;
        }

        this(arg2, 0, 0, arg5, arg6);
    }

    private ContextualFlowColumnOverflow(OverflowType arg8, int arg9, int arg10, Function1 arg11, Function1 arg12) {
        super(arg8, arg9, arg10, arg11, arg12, null);
    }

    public ContextualFlowColumnOverflow(OverflowType arg1, int arg2, int arg3, Function1 arg4, Function1 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public static final ContextualFlowColumnOverflow access$getClip$cp() {
        return ContextualFlowColumnOverflow.Clip;
    }

    public static final ContextualFlowColumnOverflow access$getVisible$cp() {
        return ContextualFlowColumnOverflow.Visible;
    }
}

