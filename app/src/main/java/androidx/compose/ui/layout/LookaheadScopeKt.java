package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A0\u0010\u0000\u001A\u00020\u00012!\u0010\u0002\u001A\u001D\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001A \u0001\u0010\t\u001A\u00020\n*\u00020\n2!\u0010\u000B\u001A\u001D\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u00100\u00032.\b\u0002\u0010\u0011\u001A(\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u00072A\u0010\u0016\u001A=\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u001A\u0012\u0013\u0012\u00110\u001B¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u001D0\u0017¢\u0006\u0002\b\u0007\u001A\u0012\u0010\u001F\u001A\u00020\u0014*\u00020\u00042\u0006\u0010 \u001A\u00020\u0014\u001A3\u0010!\u001A\u00020\"*\u00020\u00042\u0006\u0010#\u001A\u00020\u00142\u0006\u0010 \u001A\u00020\u00142\u0006\u0010$\u001A\u00020\"2\u0006\u0010%\u001A\u00020\u0010H\u0000¢\u0006\u0004\b&\u0010\'\"4\u0010\u001E\u001A(\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2={"LookaheadScope", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "approachLayout", "Landroidx/compose/ui/Modifier;", "isMeasurementApproachInProgress", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "lookaheadSize", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoordinates", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "defaultPlacementApproachInProgress", "lookaheadScopeCoordinates", "sourceCoordinates", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-Fgt4K4Q", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LookaheadScopeKt {
    private static final Function2 defaultPlacementApproachInProgress;

    static {
        LookaheadScopeKt.defaultPlacementApproachInProgress = LookaheadScopeKt$defaultPlacementApproachInProgress$1.INSTANCE;
    }

    public static final void LookaheadScope(Function3 arg5, Composer arg6, int arg7) {
        LookaheadScopeKt$LookaheadScope$1$1 v2_4;
        LookaheadScopeImpl v0_2;
        int v1;
        int v0 = 0x1A55E779;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(LookaheadScope)50@2121L33,52@2224L32,51@2159L429:LookaheadScope.kt#80mrfh");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg5) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:49)");
            }

            String v2_2 = "CC(remember):LookaheadScope.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg6, 0xDC79F9BA, v2_2);
            Object v0_1 = arg6.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new LookaheadScopeImpl(null, 1, null);
                arg6.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            ComposerKt.sourceInformationMarkerStart(arg6, 0xDC7A0699, v2_2);
            Object v2_3 = arg6.rememberedValue();
            if(v2_3 == Composer.Companion.getEmpty()) {
                v2_4 = LookaheadScopeKt$LookaheadScope$1$1.INSTANCE;
                arg6.updateRememberedValue(v2_4);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            ComposerKt.sourceInformationMarkerStart(arg6, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg6.startReusableNode();
            if(arg6.getInserting()) {
                arg6.createNode(((Function0)v2_4));
            }
            else {
                arg6.useNode();
            }

            Composer v2_5 = Updater.constructor-impl(arg6);
            Updater.init-impl(v2_5, LookaheadScopeKt$LookaheadScope$2$1.INSTANCE);
            Updater.set-impl(v2_5, v0_2, LookaheadScopeKt$LookaheadScope$2$2.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(arg6, 0x923F1F1F, "C60@2570L9:LookaheadScope.kt#80mrfh");
            arg5.invoke(v0_2, arg6, Integer.valueOf(v1 << 3 & 0x70));
            ComposerKt.sourceInformationMarkerEnd(arg6);
            arg6.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_83;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_83:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new LookaheadScopeKt$LookaheadScope$4(arg5, arg7));
        }
    }

    public static final Function2 access$getDefaultPlacementApproachInProgress$p() {
        return LookaheadScopeKt.defaultPlacementApproachInProgress;
    }

    public static final Modifier approachLayout(Modifier arg1, Function1 arg2, Function2 arg3, Function3 arg4) {
        return arg1.then(new ApproachLayoutElement(arg4, arg2, arg3));
    }

    public static Modifier approachLayout$default(Modifier arg0, Function1 arg1, Function2 arg2, Function3 arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = LookaheadScopeKt.defaultPlacementApproachInProgress;
        }

        return LookaheadScopeKt.approachLayout(arg0, arg1, arg2, arg3);
    }

    public static final long localLookaheadPositionOf-Fgt4K4Q(LookaheadScope arg0, LayoutCoordinates arg1, LayoutCoordinates arg2, long arg3, boolean arg5) {
        arg1 = arg0.toLookaheadCoordinates(arg1);
        LayoutCoordinates v0 = arg0.toLookaheadCoordinates(arg2);
        if((arg1 instanceof LookaheadLayoutCoordinates)) {
            return ((LookaheadLayoutCoordinates)arg1).localPositionOf-S_NoaFU(v0, arg3, arg5);
        }

        if((v0 instanceof LookaheadLayoutCoordinates)) {
            return Offset.constructor-impl(((LookaheadLayoutCoordinates)v0).localPositionOf-S_NoaFU(arg1, arg3, arg5) ^ -9223372034707292160L);
        }

        return arg1.localPositionOf-S_NoaFU(arg1, arg3, arg5);
    }

    public static final LayoutCoordinates lookaheadScopeCoordinates(LookaheadScope arg1, LayoutCoordinates arg2) {
        if((arg2 instanceof LookaheadCapablePlaceable)) {
            return arg1.getLookaheadScopeCoordinates(((LookaheadCapablePlaceable)arg2).getPlacementScope());
        }

        throw new IllegalArgumentException("Invalid LayoutCoordinates: " + arg2.toString());
    }
}

