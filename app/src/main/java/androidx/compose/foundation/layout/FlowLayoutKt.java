package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntList;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Aq\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000E2\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001Ag\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001Aq\u0010\u0016\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u001A2\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001C\u001Ag\u0010\u0016\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001D\u001A%\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u000BH\u0001¢\u0006\u0002\u0010!\u001A=\u0010\"\u001A\u00020#2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020%H\u0001¢\u0006\u0002\u0010&\u001A%\u0010\'\u001A\u00020\u001F2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u000BH\u0001¢\u0006\u0002\u0010(\u001A=\u0010)\u001A\u00020#2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020%H\u0001¢\u0006\u0002\u0010*\u001AT\u0010+\u001A\u00020\u000B2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001A\u001F\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B00¢\u0006\u0002\b\u00132\u0006\u00101\u001A\u00020\u000B2\u0006\u00102\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u000BH\u0082\b\u001A\u0091\u0001\u00103\u001A\u00020\u000B2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001A\u001F\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B00¢\u0006\u0002\b\u00132#\u00104\u001A\u001F\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B00¢\u0006\u0002\b\u00132\u0006\u00101\u001A\u00020\u000B2\u0006\u00102\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020%H\u0083\b\u001A[\u00106\u001A\u0002072\f\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u0002092\u0006\u0010;\u001A\u00020\u000B2\u0006\u00102\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020%H\u0002¢\u0006\u0002\u0010<\u001A\u0096\u0001\u00106\u001A\u0002072\f\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001A\u001F\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B00¢\u0006\u0002\b\u00132#\u00104\u001A\u001F\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B00¢\u0006\u0002\b\u00132\u0006\u0010;\u001A\u00020\u000B2\u0006\u00102\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001AY\u0010>\u001A\u00020?*\u00020@2\u0006\u0010A\u001A\u00020B2\f\u0010C\u001A\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020G2\u0006\u0010I\u001A\u00020J2\u0006\u0010 \u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001A\u001E\u0010M\u001A\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001A\u0004\u0018\u00010OH\u0002\u001A\u001C\u0010P\u001A\u00020\u000B*\u00020.2\u0006\u0010Q\u001A\u00020R2\u0006\u00104\u001A\u00020\u000BH\u0000\u001A\u001C\u0010S\u001A\u00020\u000B*\u00020.2\u0006\u0010Q\u001A\u00020R2\u0006\u0010/\u001A\u00020\u000BH\u0000\u001A9\u0010Z\u001A\u000207*\u00020E2\u0006\u0010A\u001A\u00020B2\u0006\u0010I\u001A\u00020[2\u0014\u0010\\\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001AQ\u0010`\u001A\u00020?*\u00020@2\u0006\u0010I\u001A\u00020J2\u0006\u0010a\u001A\u00020\u000B2\u0006\u0010b\u001A\u00020\u000B2\u0006\u0010:\u001A\u0002092\f\u0010c\u001A\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001A\u00020B2\u0006\u0010f\u001A\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001A\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bV\u0010W\"\u0014\u0010X\u001A\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bY\u0010W¨\u0006i"}, d2={"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;

    public static Unit $r8$lambda$8JbKy0dDyVuM_f3DJOzcbYgtsJA(Function3 arg0, Composer arg1, int arg2) {
        return FlowLayoutKt.FlowRow$lambda$1$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$CgcNSR0il339LbPf3mdQTkycL3Q(Function3 arg0, Composer arg1, int arg2) {
        return FlowLayoutKt.FlowColumn$lambda$1$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$Kc7bJd5tREFKFppce-e7ySj_q9Y(ObjectRef arg0, Placeable arg1) {
        return FlowLayoutKt.breakDownItems_di9J0FM$lambda$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$LXm4t8g0OSYK1Cs41NRTzBPHLBg(ObjectRef arg0, Placeable arg1) {
        return FlowLayoutKt.breakDownItems_di9J0FM$lambda$2$0(arg0, arg1);
    }

    static {
        FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.Companion.vertical$foundation_layout(Alignment.Companion.getTop());
        FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.Companion.horizontal$foundation_layout(Alignment.Companion.getStart());
    }

    @Deprecated(message="The overflow parameter has been deprecated") public static final void FlowColumn(Modifier arg22, Vertical arg23, Horizontal arg24, androidx.compose.ui.Alignment$Horizontal arg25, int arg26, int arg27, FlowColumnOverflow arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        Vertical v2_2;
        FlowColumnOverflow v7_2;
        Companion v1_3;
        int v6_3;
        Horizontal v3_2;
        ArrayList v4_2;
        Composer v7_1;
        Composer v16;
        Horizontal v11_1;
        Modifier v0_4;
        int v19;
        int v15;
        int v14;
        int v13;
        androidx.compose.ui.Alignment$Horizontal v12;
        int v11;
        int v7;
        Vertical v6;
        int v4;
        Function3 v8 = arg29;
        int v9 = arg31;
        Composer v1 = arg30.startRestartGroup(-1944405121);
        ComposerKt.sourceInformation(v1, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)214@9466L53,216@9552L234,225@9840L294,231@10139L75:FlowLayout.kt#2w3rfo");
        int v2 = arg32 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v1.changed(arg22) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        int v5 = arg32 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_39;
        }
        else if((v9 & 0x30) == 0) {
            v6 = arg23;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_39:
            v6 = arg23;
        }

        v7 = arg32 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v11 = v1.changed(arg24) ? 0x100 : 0x80;
            v4 |= v11;
        }

        v11 = arg32 & 8;
        if(v11 != 0) {
            v4 |= 0xC00;
            goto label_69;
        }
        else if((v9 & 0xC00) == 0) {
            v12 = arg25;
            v13 = v1.changed(v12) ? 0x800 : 0x400;
            v4 |= v13;
        }
        else {
        label_69:
            v12 = arg25;
        }

        v13 = arg32 & 16;
        if(v13 != 0) {
            v4 |= 0x6000;
            goto label_84;
        }
        else if((v9 & 0x6000) == 0) {
            v14 = arg26;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_84:
            v14 = arg26;
        }

        v15 = arg32 & 0x20;
        int v17 = 0x30000;
        if(v15 != 0) {
            v4 |= v17;
        }
        else {
            int v0 = arg27;
            if((v9 & v17) == 0) {
                v17 = v1.changed(v0) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = arg32 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v4 |= v18;
        }
        else {
            FlowColumnOverflow v0_1 = arg28;
            if((v9 & v18) == 0) {
                v19 = v1.changed(v0_1) ? 0x100000 : 0x80000;
                v4 |= v19;
            }
        }

        if((v9 & 0xC00000) == 0) {
            v19 = v1.changedInstance(v8) ? 0x800000 : 0x400000;
            v4 |= v19;
        }

        v19 = v2;
        boolean v0_2 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            if(v19 != 0) {
                Companion v0_3 = Modifier.Companion;
            }
            else {
                v0_4 = arg22;
            }

            Vertical v10 = v5 != 0 ? Arrangement.INSTANCE.getTop() : v6;
            if(v7 != 0) {
                int v21 = v11;
                v11_1 = Arrangement.INSTANCE.getStart();
                v2 = v21;
            }
            else {
                v2 = v11;
                v11_1 = arg24;
            }

            if(v2 != 0) {
                v12 = Alignment.Companion.getStart();
            }

            v2 = 0x7FFFFFFF;
            v13 = v13 != 0 ? v2 : v14;
            v14 = v15 != 0 ? v2 : arg27;
            FlowColumnOverflow v2_1 = v17 != 0 ? FlowColumnOverflow.Companion.getClip() : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1944405121, v4, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
            }

            String v6_1 = "CC(remember):FlowLayout.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 0xF05A13D4, v6_1);
            v5 = 0x380000 & v4;
            v7 = v5 == 0x100000 ? 1 : 0;
            Object v15_1 = v1.rememberedValue();
            if(v7 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                FlowLayoutOverflowState v15_2 = v2_1.createOverflowState$foundation_layout();
                v1.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v16 = v1;
            MultiContentMeasurePolicy v1_1 = FlowLayoutKt.columnMeasurementMultiContentHelper(v10, v11_1, v12, v13, v14, ((FlowLayoutOverflowState)v15_1), v16, v4 >> 3 & 0xFFFE);
            v7_1 = v16;
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xF05A4385, v6_1);
            int v3 = v5 == 0x100000 ? 1 : 0;
            v5 = (0x1C00000 & v4) == 0x800000 ? 1 : 0;
            v3 |= v5;
            v4 = (v4 & 0x70000) == 0x20000 ? 1 : 0;
            v3 |= v4;
            Object v4_1 = v7_1.rememberedValue();
            if(v3 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                v4_2 = new ArrayList();
                ((List)v4_2).add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new FlowLayoutKt$$ExternalSyntheticLambda0(v8)));
                v2_1.addOverflowComposables$foundation_layout(((FlowLayoutOverflowState)v15_1), ((List)v4_2));
                v7_1.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x5365E06C, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
            Function2 v3_1 = LayoutKt.combineAsVirtualLayouts(((List)v4_2));
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x116F97CA, "CC(remember):Layout.kt#9igjgp");
            boolean v4_3 = v7_1.changed(v1_1);
            Object v5_1 = v7_1.rememberedValue();
            if((v4_3) || v5_1 == Composer.Companion.getEmpty()) {
                MeasurePolicy v5_2 = MultiContentMeasurePolicyKt.createMeasurePolicy(v1_1);
                v7_1.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v1_2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v7_1, 0));
            CompositionLocalMap v4_4 = v7_1.getCurrentCompositionLocalMap();
            Modifier v6_2 = ComposedModifierKt.materializeModifier(v7_1, v0_4);
            Function0 v15_3 = ComposeUiNode.Companion.getConstructor();
            Companion v16_1 = ((Companion)v0_4);
            int v22 = v1_2;
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v7_1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v7_1.startReusableNode();
            if(v7_1.getInserting()) {
                v7_1.createNode(v15_3);
            }
            else {
                v7_1.useNode();
            }

            Composer v0_5 = Updater.constructor-impl(v7_1);
            Updater.set-impl(v0_5, v5_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_5, v4_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v0_5, Integer.valueOf(v22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v0_5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v0_5, v6_2, ComposeUiNode.Companion.getSetModifier());
            v3_1.invoke(v7_1, Integer.valueOf(0));
            v7_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v11_1;
            v5 = v13;
            v6_3 = v14;
            v1_3 = v16_1;
            v16 = v7_1;
            v7_2 = v2_1;
            v2_2 = v10;
        }
        else {
            v7_1 = v1;
            v7_1.skipToGroupEnd();
            Modifier v1_4 = arg22;
            v3_2 = arg24;
            v2_2 = v6;
            v16 = v7_1;
            v5 = v14;
            v6_3 = arg27;
            v7_2 = arg28;
        }

        androidx.compose.ui.Alignment$Horizontal v4_5 = v12;
        ScopeUpdateScope v11_2 = v16.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new FlowLayoutKt$$ExternalSyntheticLambda1(((Modifier)v1_3), v2_2, v3_2, v4_5, v5, v6_3, v7_2, v8, v9, arg32));
        }
    }

    public static final void FlowColumn(Modifier arg21, Vertical arg22, Horizontal arg23, androidx.compose.ui.Alignment$Horizontal arg24, int arg25, int arg26, Function3 arg27, Composer arg28, int arg29, int arg30) {
        Modifier v1_2;
        int v6_1;
        androidx.compose.ui.Alignment$Horizontal v4_1;
        Horizontal v3_1;
        Vertical v2_1;
        Composer v17;
        androidx.compose.ui.Alignment$Horizontal v12_1;
        int v0_2;
        Vertical v10_1;
        int v20;
        Companion v9;
        int v16;
        int v14;
        int v13;
        int v12;
        int v10;
        int v7;
        Vertical v6;
        Modifier v3;
        int v4;
        int v8 = arg29;
        Composer v1 = arg28.startRestartGroup(0x51C4B3FB);
        ComposerKt.sourceInformation(v1, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,content)271@11939L226:FlowLayout.kt#2w3rfo");
        int v2 = arg30 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg21;
        }
        else if((v8 & 6) == 0) {
            v3 = arg21;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg21;
            v4 = v8;
        }

        int v5 = arg30 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg22;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg22;
        }

        v7 = arg30 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
        }
        else if((v8 & 0x180) == 0) {
            v10 = v1.changed(arg23) ? 0x100 : 0x80;
            v4 |= v10;
        }

        v10 = arg30 & 8;
        if(v10 != 0) {
            v4 |= 0xC00;
        }
        else if((v8 & 0xC00) == 0) {
            v12 = v1.changed(arg24) ? 0x800 : 0x400;
            v4 |= v12;
        }

        v12 = arg30 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_83;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg25;
            v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_83:
            v13 = arg25;
        }

        v14 = arg30 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v4 |= v15;
            goto label_99;
        }
        else if((v15 & v8) == 0) {
            v15 = arg26;
            v16 = v1.changed(v15) ? 0x20000 : 0x10000;
            v4 |= v16;
        }
        else {
        label_99:
            v15 = arg26;
        }

        v16 = 0x180000;
        Function3 v0 = arg27;
        if((v8 & v16) == 0) {
            int v18 = v1.changedInstance(v0) ? 0x100000 : 0x80000;
            v4 |= v18;
        }

        int v28 = v2;
        boolean v0_1 = (v4 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0_1, v4 & 1)) {
            if(v28 != 0) {
                v9 = Modifier.Companion;
            }
            else {
                Modifier v9_1 = v3;
            }

            if(v5 != 0) {
                v20 = v10;
                v10_1 = Arrangement.INSTANCE.getTop();
                v0_2 = v20;
            }
            else {
                v0_2 = v10;
                v10_1 = v6;
            }

            Horizontal v11 = v7 != 0 ? Arrangement.INSTANCE.getStart() : arg23;
            if(v0_2 != 0) {
                v20 = v12;
                v12_1 = Alignment.Companion.getStart();
                v0_2 = v20;
            }
            else {
                v0_2 = v12;
                v12_1 = arg24;
            }

            v2 = 0x7FFFFFFF;
            if(v0_2 != 0) {
                v13 = v2;
            }

            v14 = v14 != 0 ? v2 : v15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x51C4B3FB, v4, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
            }

            v17 = v1;
            FlowLayoutKt.FlowColumn(((Modifier)v9), v10_1, v11, v12_1, v13, v14, FlowColumnOverflow.Companion.getClip(), arg27, v17, v4 & 14 | v16 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4 | 0x70000 & v4 | v4 << 3 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v1_1 = v9;
            v2_1 = v10_1;
            v3_1 = v11;
            v4_1 = v12_1;
            v6_1 = v14;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v4_1 = arg24;
            v1_2 = v3;
            v2_1 = v6;
            v6_1 = v15;
            v3_1 = arg23;
        }

        v5 = v13;
        ScopeUpdateScope v10_2 = v17.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new FlowLayoutKt$$ExternalSyntheticLambda2(v1_2, v2_1, v3_1, v4_1, v5, v6_1, arg27, v8, arg30));
        }
    }

    private static final Unit FlowColumn$lambda$1$0(Function3 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "C227@10017L9:FlowLayout.kt#2w3rfo");
        boolean v0 = (arg5 & 3) != 2 ? true : false;
        if(arg4.shouldExecute(v0, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1720407857, arg5, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:227)");
            }

            arg3.invoke(FlowColumnScopeInstance.INSTANCE, arg4, Integer.valueOf(6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_26;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg4.skipToGroupEnd();
        }

    label_26:
        return Unit.INSTANCE;
    }

    static final Unit FlowColumn$lambda$2(Modifier arg12, Vertical arg13, Horizontal arg14, androidx.compose.ui.Alignment$Horizontal arg15, int arg16, int arg17, FlowColumnOverflow arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        FlowLayoutKt.FlowColumn(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit FlowColumn$lambda$3(Modifier arg11, Vertical arg12, Horizontal arg13, androidx.compose.ui.Alignment$Horizontal arg14, int arg15, int arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        FlowLayoutKt.FlowColumn(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    @Deprecated(message="The overflow parameter has been deprecated") public static final void FlowRow(Modifier arg22, Horizontal arg23, Vertical arg24, androidx.compose.ui.Alignment$Vertical arg25, int arg26, int arg27, FlowRowOverflow arg28, Function3 arg29, Composer arg30, int arg31, int arg32) {
        Horizontal v2_2;
        FlowRowOverflow v7_2;
        Companion v1_3;
        int v6_3;
        Vertical v3_2;
        Composer v7_1;
        Composer v16;
        FlowLayoutOverflowState v15_2;
        Vertical v11_1;
        Modifier v0_4;
        int v19;
        int v15;
        int v14;
        int v13;
        androidx.compose.ui.Alignment$Vertical v12;
        int v11;
        int v7;
        Horizontal v6;
        int v4;
        Function3 v8 = arg29;
        int v9 = arg31;
        Composer v1 = arg30.startRestartGroup(0x8B60C71F);
        ComposerKt.sourceInformation(v1, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)100@4511L53,102@4597L226,111@4877L291,118@5174L75:FlowLayout.kt#2w3rfo");
        int v2 = arg32 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v1.changed(arg22) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        int v5 = arg32 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_39;
        }
        else if((v9 & 0x30) == 0) {
            v6 = arg23;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_39:
            v6 = arg23;
        }

        v7 = arg32 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v11 = v1.changed(arg24) ? 0x100 : 0x80;
            v4 |= v11;
        }

        v11 = arg32 & 8;
        if(v11 != 0) {
            v4 |= 0xC00;
            goto label_69;
        }
        else if((v9 & 0xC00) == 0) {
            v12 = arg25;
            v13 = v1.changed(v12) ? 0x800 : 0x400;
            v4 |= v13;
        }
        else {
        label_69:
            v12 = arg25;
        }

        v13 = arg32 & 16;
        if(v13 != 0) {
            v4 |= 0x6000;
            goto label_84;
        }
        else if((v9 & 0x6000) == 0) {
            v14 = arg26;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_84:
            v14 = arg26;
        }

        v15 = arg32 & 0x20;
        int v17 = 0x30000;
        if(v15 != 0) {
            v4 |= v17;
        }
        else {
            int v0 = arg27;
            if((v9 & v17) == 0) {
                v17 = v1.changed(v0) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = arg32 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v4 |= v18;
        }
        else {
            FlowRowOverflow v0_1 = arg28;
            if((v9 & v18) == 0) {
                v19 = v1.changed(v0_1) ? 0x100000 : 0x80000;
                v4 |= v19;
            }
        }

        if((v9 & 0xC00000) == 0) {
            v19 = v1.changedInstance(v8) ? 0x800000 : 0x400000;
            v4 |= v19;
        }

        v19 = v2;
        boolean v0_2 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            if(v19 != 0) {
                Companion v0_3 = Modifier.Companion;
            }
            else {
                v0_4 = arg22;
            }

            Horizontal v10 = v5 != 0 ? Arrangement.INSTANCE.getStart() : v6;
            if(v7 != 0) {
                int v21 = v11;
                v11_1 = Arrangement.INSTANCE.getTop();
                v2 = v21;
            }
            else {
                v2 = v11;
                v11_1 = arg24;
            }

            if(v2 != 0) {
                v12 = Alignment.Companion.getTop();
            }

            v2 = 0x7FFFFFFF;
            v13 = v13 != 0 ? v2 : v14;
            v14 = v15 != 0 ? v2 : arg27;
            FlowRowOverflow v2_1 = v17 != 0 ? FlowRowOverflow.Companion.getClip() : arg28;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x8B60C71F, v4, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
            }

            String v6_1 = "CC(remember):FlowLayout.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 910931156, v6_1);
            v5 = 0x380000 & v4;
            v7 = v5 == 0x100000 ? 1 : 0;
            Object v15_1 = v1.rememberedValue();
            if(v7 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = v2_1.createOverflowState$foundation_layout();
                v1.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v16 = v1;
            MultiContentMeasurePolicy v1_1 = FlowLayoutKt.rowMeasurementMultiContentHelper(v10, v11_1, v12, v13, v14, v15_2, v16, v4 >> 3 & 0xFFFE);
            v7_1 = v16;
            ComposerKt.sourceInformationMarkerStart(v7_1, 910943106, v6_1);
            int v3 = v5 == 0x100000 ? 1 : 0;
            v5 = (0x1C00000 & v4) == 0x800000 ? 1 : 0;
            v3 |= v5;
            v4 = (v4 & 0x70000) == 0x20000 ? 1 : 0;
            v3 |= v4;
            Object v4_1 = v7_1.rememberedValue();
            if(v3 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                ArrayList v4_2 = new ArrayList();
                ((List)v4_2).add(ComposableLambdaKt.composableLambdaInstance(0xB8E5046F, true, new FlowLayoutKt$$ExternalSyntheticLambda6(v8)));
                v2_1.addOverflowComposables$foundation_layout(v15_2, ((List)v4_2));
                v7_1.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x5365E06C, "CC(Layout)P(!1,2)172@7176L62,169@7062L183:Layout.kt#80mrfh");
            Function2 v3_1 = LayoutKt.combineAsVirtualLayouts(((List)v4_1));
            ComposerKt.sourceInformationMarkerStart(v7_1, 0x116F97CA, "CC(remember):Layout.kt#9igjgp");
            boolean v4_3 = v7_1.changed(v1_1);
            Object v5_1 = v7_1.rememberedValue();
            if((v4_3) || v5_1 == Composer.Companion.getEmpty()) {
                MeasurePolicy v5_2 = MultiContentMeasurePolicyKt.createMeasurePolicy(v1_1);
                v7_1.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v1_2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v7_1, 0));
            CompositionLocalMap v4_4 = v7_1.getCurrentCompositionLocalMap();
            Modifier v6_2 = ComposedModifierKt.materializeModifier(v7_1, v0_4);
            Function0 v15_3 = ComposeUiNode.Companion.getConstructor();
            Companion v16_1 = ((Companion)v0_4);
            int v22 = v1_2;
            ComposerKt.sourceInformationMarkerStart(v7_1, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v7_1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v7_1.startReusableNode();
            if(v7_1.getInserting()) {
                v7_1.createNode(v15_3);
            }
            else {
                v7_1.useNode();
            }

            Composer v0_5 = Updater.constructor-impl(v7_1);
            Updater.set-impl(v0_5, v5_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_5, v4_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v0_5, Integer.valueOf(v22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v0_5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v0_5, v6_2, ComposeUiNode.Companion.getSetModifier());
            v3_1.invoke(v7_1, Integer.valueOf(0));
            v7_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            ComposerKt.sourceInformationMarkerEnd(v7_1);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v11_1;
            v5 = v13;
            v6_3 = v14;
            v1_3 = v16_1;
            v16 = v7_1;
            v7_2 = v2_1;
            v2_2 = v10;
        }
        else {
            v7_1 = v1;
            v7_1.skipToGroupEnd();
            Modifier v1_4 = arg22;
            v3_2 = arg24;
            v2_2 = v6;
            v16 = v7_1;
            v5 = v14;
            v6_3 = arg27;
            v7_2 = arg28;
        }

        androidx.compose.ui.Alignment$Vertical v4_5 = v12;
        ScopeUpdateScope v11_2 = v16.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new FlowLayoutKt$$ExternalSyntheticLambda7(((Modifier)v1_3), v2_2, v3_2, v4_5, v5, v6_3, v7_2, v8, v9, arg32));
        }
    }

    public static final void FlowRow(Modifier arg21, Horizontal arg22, Vertical arg23, androidx.compose.ui.Alignment$Vertical arg24, int arg25, int arg26, Function3 arg27, Composer arg28, int arg29, int arg30) {
        int v6_1;
        androidx.compose.ui.Alignment$Vertical v4_1;
        Vertical v3_1;
        Horizontal v2_1;
        Companion v1_1;
        Composer v17;
        androidx.compose.ui.Alignment$Vertical v12_1;
        int v0_2;
        Horizontal v10_1;
        int v20;
        Modifier v9_1;
        int v16;
        int v14;
        int v13;
        int v12;
        int v10;
        int v7;
        Horizontal v6;
        Modifier v3;
        int v4;
        int v8 = arg29;
        Composer v1 = arg28.startRestartGroup(-1303174015);
        ComposerKt.sourceInformation(v1, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,content)162@7315L215:FlowLayout.kt#2w3rfo");
        int v2 = arg30 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg21;
        }
        else if((v8 & 6) == 0) {
            v3 = arg21;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg21;
            v4 = v8;
        }

        int v5 = arg30 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg22;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg22;
        }

        v7 = arg30 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
        }
        else if((v8 & 0x180) == 0) {
            v10 = v1.changed(arg23) ? 0x100 : 0x80;
            v4 |= v10;
        }

        v10 = arg30 & 8;
        if(v10 != 0) {
            v4 |= 0xC00;
        }
        else if((v8 & 0xC00) == 0) {
            v12 = v1.changed(arg24) ? 0x800 : 0x400;
            v4 |= v12;
        }

        v12 = arg30 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_83;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg25;
            v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_83:
            v13 = arg25;
        }

        v14 = arg30 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v4 |= v15;
            goto label_99;
        }
        else if((v15 & v8) == 0) {
            v15 = arg26;
            v16 = v1.changed(v15) ? 0x20000 : 0x10000;
            v4 |= v16;
        }
        else {
        label_99:
            v15 = arg26;
        }

        v16 = 0x180000;
        Function3 v0 = arg27;
        if((v8 & v16) == 0) {
            int v18 = v1.changedInstance(v0) ? 0x100000 : 0x80000;
            v4 |= v18;
        }

        int v28 = v2;
        boolean v0_1 = (v4 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0_1, v4 & 1)) {
            if(v28 != 0) {
                Companion v9 = Modifier.Companion;
            }
            else {
                v9_1 = v3;
            }

            if(v5 != 0) {
                v20 = v10;
                v10_1 = Arrangement.INSTANCE.getStart();
                v0_2 = v20;
            }
            else {
                v0_2 = v10;
                v10_1 = v6;
            }

            Vertical v11 = v7 != 0 ? Arrangement.INSTANCE.getTop() : arg23;
            if(v0_2 != 0) {
                v20 = v12;
                v12_1 = Alignment.Companion.getTop();
                v0_2 = v20;
            }
            else {
                v0_2 = v12;
                v12_1 = arg24;
            }

            v2 = 0x7FFFFFFF;
            if(v0_2 != 0) {
                v13 = v2;
            }

            v14 = v14 != 0 ? v2 : v15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1303174015, v4, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
            }

            v17 = v1;
            FlowLayoutKt.FlowRow(v9_1, v10_1, v11, v12_1, v13, v14, FlowRowOverflow.Companion.getClip(), arg27, v17, v4 & 14 | v16 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4 | 0x70000 & v4 | v4 << 3 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Companion)v9_1);
            v2_1 = v10_1;
            v3_1 = v11;
            v4_1 = v12_1;
            v6_1 = v14;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v4_1 = arg24;
            Modifier v1_2 = v3;
            v2_1 = v6;
            v6_1 = v15;
            v3_1 = arg23;
        }

        v5 = v13;
        ScopeUpdateScope v10_2 = v17.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new FlowLayoutKt$$ExternalSyntheticLambda8(((Modifier)v1_1), v2_1, v3_1, v4_1, v5, v6_1, arg27, v8, arg30));
        }
    }

    private static final Unit FlowRow$lambda$1$0(Function3 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformation(arg4, "C113@5051L9:FlowLayout.kt#2w3rfo");
        boolean v0 = (arg5 & 3) != 2 ? true : false;
        if(arg4.shouldExecute(v0, arg5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB8E5046F, arg5, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:113)");
            }

            arg3.invoke(FlowRowScopeInstance.INSTANCE, arg4, Integer.valueOf(6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_26;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg4.skipToGroupEnd();
        }

    label_26:
        return Unit.INSTANCE;
    }

    static final Unit FlowRow$lambda$2(Modifier arg12, Horizontal arg13, Vertical arg14, androidx.compose.ui.Alignment$Vertical arg15, int arg16, int arg17, FlowRowOverflow arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        FlowLayoutKt.FlowRow(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit FlowRow$lambda$3(Modifier arg11, Horizontal arg12, Vertical arg13, androidx.compose.ui.Alignment$Vertical arg14, int arg15, int arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        FlowLayoutKt.FlowRow(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final long access$intrinsicCrossAxisSize(List arg0, int[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, FlowLayoutOverflowState arg8) {
        return FlowLayoutKt.intrinsicCrossAxisSize(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static final MeasureResult breakDownItems-di9J0FM(MeasureScope arg54, FlowLineMeasurePolicy arg55, Iterator arg56, float arg57, float arg58, long arg59, int arg61, int arg62, FlowLayoutOverflowState arg63) {
        int[] v5_2;
        FlowLineMeasurePolicy v7_1;
        long v1_5;
        MeasureScope v0_5;
        int[] v11_3;
        int v11_2;
        MutableIntObjectMap v8_2;
        MutableIntList v0_3;
        MutableIntList v5_1;
        int v0_1;
        IntIntPair v48;
        Integer v4_2;
        int v4_1;
        MutableIntObjectMap v20_1;
        int v45;
        Float v1_4;
        MutableIntList v30;
        int v15_1;
        WrapEllipsisInfo v1_1;
        Object v40_1;
        Integer v40;
        MeasureScope v6 = arg54;
        FlowLineMeasurePolicy v13 = arg55;
        Iterator v0 = arg56;
        MutableVector v14 = new MutableVector(new MeasureResult[16], 0);
        int v1 = Constraints.getMaxWidth-impl(arg59);
        int v2 = Constraints.getMinWidth-impl(arg59);
        int v3 = Constraints.getMaxHeight-impl(arg59);
        MutableIntObjectMap v4 = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList v7 = new ArrayList();
        int v5 = ((int)(((float)Math.ceil(((double)v6.toPx-0680j_4(arg57))))));
        int v8 = ((int)(((float)Math.ceil(((double)v6.toPx-0680j_4(arg58))))));
        long v16 = OrientationIndependentConstraints.constructor-impl(0, v1, 0, v3);
        long v9 = OrientationIndependentConstraints.copy-yUG9Ft0$default(v16, 0, 0, 0, 0, 14, null);
        long v25 = v16;
        LayoutOrientation v11 = v13.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        v9 = OrientationIndependentConstraints.toBoxConstraints-OenEA2s(v9, v11);
        ObjectRef v11_1 = new ObjectRef();
        FlowLineInfo v12 = (v0 instanceof ContextualFlowItemIterator) ? new FlowLineInfo(0, 0, v6.toDp-u2uoSUM(v1), v6.toDp-u2uoSUM(v3), null) : null;
        Measurable v15 = !v0.hasNext() ? null : FlowLayoutKt.safeNext(v0, v12);
        int v28 = v2;
        IntIntPair v34 = v15 != null ? IntIntPair.box-impl(FlowLayoutKt.measureAndCache-rqJ1uqs(v15, v13, v9, new FlowLayoutKt$$ExternalSyntheticLambda4(v11_1))) : null;
        Integer v2_1 = v34 != null ? Integer.valueOf(IntIntPair.getFirst-impl(v34.unbox-impl())) : null;
        if(v34 != null) {
            v40 = Integer.valueOf(IntIntPair.getSecond-impl(v34.unbox-impl()));
        }
        else {
            v40_1 = null;
        }

        Integer v41 = v2_1;
        int v23 = v8;
        Measurable v27 = v15;
        MutableIntList v2_2 = new MutableIntList(0, 1, null);
        MutableVector v42 = v14;
        MutableIntList v14_1 = new MutableIntList(0, 1, null);
        MutableIntSet v8_1 = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks v43 = new FlowLayoutBuildingBlocks(arg61, arg63, arg59, arg62, v5, v23, null);
        v5 = v5;
        WrapInfo v17 = v43.getWrapInfo-OpUlnko(v0.hasNext(), 0, IntIntPair.constructor-impl(v1, v3), v34, 0, 0, 0, false, false);
        if(v17.isLastItemInContainer()) {
            boolean v18 = v34 != null ? true : false;
            int v21 = v1;
            v1_1 = v43.getWrapEllipsisInfo(v17, v18, -1, 0, v21, 0);
            v15_1 = v21;
        }
        else {
            v15_1 = v1;
            v1_1 = null;
        }

        WrapEllipsisInfo v57 = v1_1;
        MutableIntList v21_1 = v2_2;
        int v22 = v5;
        int v16_1 = v15_1;
        WrapInfo v19 = v17;
        v1 = v28;
        v2 = 0;
        v5 = 0;
        int v20 = 0;
        int v29 = 0;
        int v46 = 0;
        int v50 = 0;
        int v17_1 = v3;
        MutableIntSet v28_1 = v8_1;
        v8 = v17_1;
        Measurable v3_1 = v27;
        int v27_1 = 0;
        while(!v19.isLastItemInContainer()) {
            if(v3_1 == null) {
                break;
            }

            Intrinsics.checkNotNull(v41);
            int v19_1 = v41.intValue();
            Intrinsics.checkNotNull(v40_1);
            v30 = v14_1;
            int v31 = v15_1;
            v15_1 = v20 + v19_1;
            int v51 = Math.max(v5, ((Integer)v40_1).intValue());
            v5 = v16_1 - v19_1;
            int v14_2 = v2 + 1;
            v16_1 = v1;
            arg63.setItemShown$foundation_layout(v14_2);
            ((List)v7).add(v3_1);
            v4.set(v2, v11_1.element);
            Object v1_2 = v3_1.getParentData();
            if((v1_2 instanceof RowColumnParentData)) {
            }
            else {
                v1_2 = null;
            }

            if(v1_2 != null) {
                FlowLayoutData v1_3 = ((RowColumnParentData)v1_2).getFlowLayoutData();
                if(v1_3 != null) {
                    v1_4 = Float.valueOf(v1_3.getFillCrossAxisFraction());
                }
                else {
                    goto label_181;
                }
            }
            else {
            label_181:
                v1_4 = null;
            }

            if(v1_4 != null) {
                v29 = 1;
            }

            v1 = v14_2 - v27_1;
            v3 = v1 < arg61 ? 1 : 0;
            if(v12 != null) {
                if(v3 != 0) {
                    v45 = v1;
                    v1 = v46;
                }
                else {
                    v45 = v1;
                    v1 = v46 + 1;
                }

                v2 = v3 != 0 ? v45 : 0;
                if(v3 != 0) {
                    v19_1 = v5 - v22;
                    arg62 = v3;
                    v3 = v19_1 < 0 ? 0 : v19_1;
                }
                else {
                    arg62 = v3;
                    v3 = v31;
                }

                float v3_2 = v6.toDp-u2uoSUM(v3);
                if(arg62 != 0) {
                    v20_1 = v4;
                    v4_1 = v8;
                }
                else {
                    v19_1 = v8 - v51 - v23;
                    v20_1 = v4;
                    v4_1 = v19_1 < 0 ? 0 : v19_1;
                }

                v12.update-4j6BHR0$foundation_layout(v1, v2, v3_2, v6.toDp-u2uoSUM(v4_1));
            }
            else {
                v45 = v1;
                v20_1 = v4;
            }

            v3_1 = !v0.hasNext() ? null : FlowLayoutKt.safeNext(v0, v12);
            v1_2 = null;
            v11_1.element = v1_2;
            IntIntPair v2_3 = v3_1 != null ? IntIntPair.box-impl(FlowLayoutKt.measureAndCache-rqJ1uqs(v3_1, v13, v9, new FlowLayoutKt$$ExternalSyntheticLambda5(v11_1))) : ((IntIntPair)v1_2);
            if(v2_3 != null) {
                v4_2 = Integer.valueOf(IntIntPair.getFirst-impl(v2_3.unbox-impl()) + v22);
            }
            else {
                Object v4_3 = v1_2;
            }

            if(v2_3 != null) {
                v40 = Integer.valueOf(IntIntPair.getSecond-impl(v2_3.unbox-impl()));
            }
            else {
                v40_1 = v1_2;
            }

            boolean v44 = v0.hasNext();
            int v49 = v46;
            long v46_1 = IntIntPair.constructor-impl(v5, v8);
            if(v2_3 == null) {
                v48 = ((IntIntPair)v1_2);
            }
            else {
                Intrinsics.checkNotNull(v4_2);
                v1 = v4_2.intValue();
                Intrinsics.checkNotNull(v40_1);
                v48 = IntIntPair.box-impl(IntIntPair.constructor-impl(v1, ((Integer)v40_1).intValue()));
            }

            WrapInfo v44_1 = v43.getWrapInfo-OpUlnko(v44, v45, v46_1, v48, v49, v50, v51, false, false);
            v0_1 = v51;
            if(v44_1.isLastItemInLine()) {
                v8 = v31;
                v1 = Math.min(Math.max(v16_1, v15_1), v8);
                int v47 = v50 + v0_1;
                v46 = v49;
                v49 = v45;
                boolean v45_1 = v2_3 != null ? true : false;
                WrapEllipsisInfo v2_4 = v43.getWrapEllipsisInfo(v44_1, v45_1, v46, v47, v5, v49);
                v5_1 = v30;
                v15_1 = v46;
                v5_1.add(v0_1);
                MutableIntSet v0_2 = v28_1;
                if(v29 != 0) {
                    v0_2.plusAssign(v15_1);
                }

                v16_1 = v17_1 - v47 - v23;
                v28_1 = v0_2;
                v0_3 = v21_1;
                v0_3.add(v14_2);
                v4_2 = v4_2 != null ? Integer.valueOf(v4_2.intValue() - v22) : null;
                v46 = v15_1 + 1;
                v50 = v47 + v23;
                v41 = v4_2;
                v31 = v8;
                v27_1 = v14_2;
                v15_1 = 0;
                v29 = 0;
                v51 = 0;
                v4_1 = v1;
                v1_1 = v2_4;
                v8 = v16_1;
                v16_1 = v31;
            }
            else {
                v51 = v0_1;
                int v48_1 = v5;
                v1 = v16_1;
                v0_3 = v21_1;
                v5_1 = v30;
                v41 = v4_2;
                v16_1 = v48_1;
                v46 = v49;
                v4_1 = v1;
                v1_1 = v57;
            }

            v21_1 = v0_3;
            v57 = v1_1;
            v28_1 = v28_1;
            v1 = v4_1;
            v2 = v14_2;
            v4 = v20_1;
            v19 = v44_1;
            v0 = arg56;
            v14_1 = v5_1;
            v20 = v15_1;
            v15_1 = v31;
            v5 = v51;
        }

        v20_1 = v4;
        v5_1 = v14_1;
        v0_3 = v21_1;
        MutableIntSet v2_5 = v28_1;
        if(v57 != null) {
            ((List)v7).add(v57.getEllipsis());
            v8_2 = v20_1;
            v8_2.set(((List)v7).size() - 1, v57.getPlaceable());
            MutableIntList v3_3 = v0_3;
            v4_1 = ((IntList)v3_3)._size - 1;
            if(v57.getPlaceEllipsisOnLastContentLine()) {
                v3 = ((IntList)v3_3)._size - 1;
                v5_1.set(v4_1, Math.max(v5_1.get(v4_1), IntIntPair.getSecond-impl(v57.getEllipsisSize-OO21N7I())));
                v0_3.set(v3, v0_3.last() + 1);
            }
            else {
                v5_1.add(IntIntPair.getSecond-impl(v57.getEllipsisSize-OO21N7I()));
                Boolean.valueOf(v0_3.add(v0_3.last() + 1));
            }
        }
        else {
            v8_2 = v20_1;
        }

        v3 = ((List)v7).size();
        Placeable[] v4_4 = new Placeable[v3];
        int v9_1;
        for(v9_1 = 0; v9_1 < v3; ++v9_1) {
            v4_4[v9_1] = v8_2.get(v9_1);
        }

        int[] v8_3 = new int[((IntList)v0_3)._size];
        int[] v14_3 = new int[((IntList)v0_3)._size];
        int[] v15_2 = ((IntList)v0_3).content;
        v0_1 = ((IntList)v0_3)._size;
        v9_1 = 0;
        int v12_1 = 0;
        v16_1 = 0;
        while(v12_1 < v0_1) {
            int v10 = v15_2[v12_1];
            v3 = v5_1.get(v12_1);
            if(!v2_5.contains(v12_1)) {
                v11_2 = 0x7FFFFFFF;
                v3 = Constraints.getMaxHeight-impl(v25) == v11_2 ? v11_2 : Constraints.getMaxHeight-impl(v25) - v16_1;
            }

            v11_2 = v0_1;
            v28_1 = v2_5;
            v17_1 = v11_2;
            v11_3 = v8_3;
            Placeable[] v8_4 = v4_4;
            v30 = v5_1;
            MeasureResult v0_4 = RowColumnMeasurePolicyKt.measure(v13, v1, Constraints.getMinHeight-impl(v25), Constraints.getMaxWidth-impl(v25), v3, v22, v6, ((List)v7), v8_4, v9_1, v10, v11_3, v12_1);
            if(v13.isHorizontal()) {
                v2 = v0_4.getWidth();
                v3 = v0_4.getHeight();
            }
            else {
                v2 = v0_4.getHeight();
                v3 = v0_4.getWidth();
            }

            v14_3[v12_1] = v3;
            v16_1 += v3;
            v1 = Math.max(v1, v2);
            v42.add(v0_4);
            ++v12_1;
            v4_4 = v8_4;
            v9_1 = v10;
            v8_3 = v11_3;
            v0_1 = v17_1;
            v2_5 = v28_1;
            v5_1 = v30;
            v6 = arg54;
        }

        v11_3 = v8_3;
        MutableVector v6_1 = v42;
        if(v6_1.getSize() == 0) {
            v3 = 0;
            v4_1 = 0;
            v0_5 = arg54;
            v1_5 = arg59;
            v8_3 = v11_3;
            v7_1 = v13;
            v5_2 = v14_3;
        }
        else {
            v3 = v1;
            v4_1 = v16_1;
            v0_5 = arg54;
            v8_3 = v11_3;
            v7_1 = v13;
            v5_2 = v14_3;
            v1_5 = arg59;
        }

        return FlowLayoutKt.placeHelper-BmaY500(v0_5, v1_5, v3, v4_1, v5_2, v6_1, v7_1, v8_3);
    }

    private static final Unit breakDownItems_di9J0FM$lambda$0$0(ObjectRef arg0, Placeable arg1) {
        arg0.element = arg1;
        return Unit.INSTANCE;
    }

    private static final Unit breakDownItems_di9J0FM$lambda$2$0(ObjectRef arg0, Placeable arg1) {
        arg0.element = arg1;
        return Unit.INSTANCE;
    }

    public static final MeasurePolicy columnMeasurementHelper(Vertical arg17, Horizontal arg18, int arg19, Composer arg20, int arg21) {
        FlowLayoutKt$columnMeasurementHelper$1$1 v2_2;
        Composer v0 = arg20;
        int v1 = arg21;
        int v3 = -2013098357;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(columnMeasurementHelper)N(verticalArrangement,horizontalArrangement,maxItemsInMainAxis)501@19939L850:FlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, -1852231075, "CC(remember):FlowLayout.kt#9igjgp");
        v3 = 4;
        int v4 = 0;
        Vertical v9 = arg17;
        int v2 = (v1 & 14 ^ 6) > v3 && (v0.changed(v9)) || (v1 & 6) == v3 ? 1 : 0;
        int v6 = 0x20;
        Horizontal v8 = arg18;
        v3 = (v1 & 0x70 ^ 0x30) > v6 && (v0.changed(v8)) || (v1 & 0x30) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x100;
        int v13 = arg19;
        if((v1 & 0x380 ^ 0x180) > v6 && (v0.changed(v13)) || (v1 & 0x180) == v6) {
            v4 = 1;
        }

        v1 = v2 | v4;
        Object v2_1 = v0.rememberedValue();
        if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = new FlowLayoutKt$columnMeasurementHelper$1$1(new FlowMeasurePolicy(false, v8, v9, v9.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START, v8.getSpacing-D9Ej5fM(), v13, 0x7FFFFFFF, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout(), null));
            v0.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((MeasurePolicy)v2_2);
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Vertical arg18, Horizontal arg19, androidx.compose.ui.Alignment$Horizontal arg20, int arg21, int arg22, FlowLayoutOverflowState arg23, Composer arg24, int arg25) {
        androidx.compose.ui.Alignment$Horizontal v0 = arg20;
        Composer v1 = arg24;
        int v2 = arg25;
        int v4 = -308635847;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(columnMeasurementMultiContentHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState)529@21138L715:FlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
        }

        ComposerKt.sourceInformationMarkerStart(v1, -246294460, "CC(remember):FlowLayout.kt#9igjgp");
        v4 = 4;
        int v5 = 0;
        Vertical v10 = arg18;
        int v3 = (v2 & 14 ^ 6) > v4 && (v1.changed(v10)) || (v2 & 6) == v4 ? 1 : 0;
        int v7 = 0x20;
        Horizontal v9 = arg19;
        v4 = (v2 & 0x70 ^ 0x30) > v7 && (v1.changed(v9)) || (v2 & 0x30) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x100;
        v4 = (v2 & 0x380 ^ 0x180) > v7 && (v1.changed(v0)) || (v2 & 0x180) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x800;
        int v14 = arg21;
        v4 = (v2 & 0x1C00 ^ 0xC00) > v7 && (v1.changed(v14)) || (v2 & 0xC00) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x4000;
        int v15 = arg22;
        if((0xE000 & v2 ^ 0x6000) > v7 && (v1.changed(v15)) || (v2 & 0x6000) == v7) {
            v5 = 1;
        }

        v2 = v3 | v5;
        FlowLayoutOverflowState v3_1 = arg23;
        v2 |= v1.changed(v3_1);
        Object v4_1 = v1.rememberedValue();
        if(v2 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            FlowMeasurePolicy v7_1 = new FlowMeasurePolicy(false, v9, v10, v10.getSpacing-D9Ej5fM(), CrossAxisAlignment.Companion.horizontal$foundation_layout(v0), v9.getSpacing-D9Ej5fM(), v14, v15, v3_1, null);
            v1.updateRememberedValue(v7_1);
            FlowMeasurePolicy v4_2 = v7_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return ((MultiContentMeasurePolicy)v4_1);
    }

    public static final int crossAxisMin(IntrinsicMeasurable arg0, boolean arg1, int arg2) {
        if(arg1) {
            return arg0.minIntrinsicHeight(arg2);
        }

        return arg0.minIntrinsicWidth(arg2);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final long intrinsicCrossAxisSize(List arg25, int[] arg26, int[] arg27, int arg28, int arg29, int arg30, int arg31, int arg32, FlowLayoutOverflowState arg33) {
        List v0 = arg25;
        int v1 = arg28;
        if(v0.isEmpty()) {
            return IntIntPair.constructor-impl(0, 0);
        }

        int v2 = 0x7FFFFFFF;
        FlowLayoutBuildingBlocks v9 = new FlowLayoutBuildingBlocks(arg31, arg33, OrientationIndependentConstraints.constructor-impl(0, v1, 0, v2), arg32, arg29, arg30, null);
        Object v4 = CollectionsKt.getOrNull(v0, 0);
        int v5 = v4 != null ? arg27[0] : 0;
        int v6 = v4 != null ? arg26[0] : 0;
        boolean v8 = true;
        boolean v10 = v0.size() > 1 ? true : false;
        long v12 = IntIntPair.constructor-impl(v1, v2);
        IntIntPair v7 = null;
        IntIntPair v14 = v4 == null ? v7 : IntIntPair.box-impl(IntIntPair.constructor-impl(v6, v5));
        int v16 = 0;
        if(v9.getWrapInfo-OpUlnko(v10, 0, v12, v14, 0, 0, 0, false, false).isLastItemInContainer()) {
            if(v4 != null) {
            }
            else {
                v8 = false;
            }

            IntIntPair v0_1 = arg33.ellipsisSize-F35zm-w$foundation_layout(v8, 0, 0);
            int v0_2 = v0_1 != null ? IntIntPair.getSecond-impl(v0_1.unbox-impl()) : 0;
            return IntIntPair.constructor-impl(v0_2, 0);
        }

        int v4_1 = v0.size();
        int v13 = v1;
        int v11 = 0;
        int v14_1 = 0;
        int v20 = 0;
        int v12_1 = 0;
        int v10_1 = 0;
        while(v11 < v4_1) {
            v6 = v13 - v6;
            v13 = v11 + 1;
            int v17 = Math.max(v10_1, v5);
            Object v5_1 = CollectionsKt.getOrNull(v0, v13);
            v10_1 = v5_1 != null ? arg27[v13] : 0;
            v14_1 = v5_1 != null ? arg26[v13] + arg29 : 0;
            boolean v11_1 = v11 + 2 < v0.size() ? true : false;
            boolean v19 = v11_1;
            int v18 = v13;
            v11 = v13 - v20;
            int v15 = v12_1;
            v12 = IntIntPair.constructor-impl(v6, v2);
            IntIntPair v21 = v5_1 == null ? v7 : IntIntPair.box-impl(IntIntPair.constructor-impl(v14_1, v10_1));
            int v22 = v18;
            int v23 = v10_1;
            IntIntPair v24 = v21;
            int v21_1 = v14_1;
            WrapInfo v10_2 = v9.getWrapInfo-OpUlnko(v19, v11, v12, v24, v15, v16, v17, false, false);
            if(v10_2.isLastItemInLine()) {
                v13 = v16 + (v17 + arg30);
                v12_1 = v15;
                v15 = v11;
                v11_1 = v5_1 != null ? true : false;
                WrapEllipsisInfo v5_2 = v9.getWrapEllipsisInfo(v10_2, v11_1, v12_1, v13, v6, v15);
                v14_1 = v21_1 - arg29;
                ++v12_1;
                if(v10_2.isLastItemInContainer()) {
                    if(v5_2 != null) {
                        long v0_3 = v5_2.getEllipsisSize-OO21N7I();
                        if(!v5_2.getPlaceEllipsisOnLastContentLine()) {
                            v13 += IntIntPair.getSecond-impl(v0_3) + arg30;
                        }
                    }

                    v16 = v13;
                    v14_1 = v22;
                    break;
                }

                v10_1 = 0;
                v16 = v13;
                v6 = v14_1;
                v20 = v22;
                v13 = v1;
            }
            else {
                v13 = v6;
                v12_1 = v15;
                v10_1 = v17;
                v6 = v21_1;
            }

            v11 = v22;
            v14_1 = v11;
            v5 = v23;
        }

        return IntIntPair.constructor-impl(v16 - arg30, v14_1);
    }

    private static final long intrinsicCrossAxisSize(List arg24, Function3 arg25, Function3 arg26, int arg27, int arg28, int arg29, int arg30, int arg31, FlowLayoutOverflowState arg32) {
        int v11;
        List v0 = arg24;
        Function3 v1 = arg25;
        Function3 v2 = arg26;
        int v3 = arg27;
        boolean v4 = v0.isEmpty();
        Integer v6 = Integer.valueOf(0);
        if(v4) {
            return IntIntPair.constructor-impl(0, 0);
        }

        int v4_1 = 0x7FFFFFFF;
        FlowLayoutBuildingBlocks v12 = new FlowLayoutBuildingBlocks(arg30, arg32, OrientationIndependentConstraints.constructor-impl(0, v3, 0, v4_1), arg31, arg28, arg29, null);
        Object v7 = CollectionsKt.getOrNull(v0, 0);
        int v8 = v7 != null ? v2.invoke(v7, v6, Integer.valueOf(v3)).intValue() : 0;
        int v6_1 = v7 != null ? v1.invoke(v7, v6, Integer.valueOf(v8)).intValue() : 0;
        boolean v10 = true;
        boolean v13 = v0.size() > 1 ? true : false;
        long v15 = IntIntPair.constructor-impl(v3, v4_1);
        IntIntPair v17 = v7 == null ? null : IntIntPair.box-impl(IntIntPair.constructor-impl(v6_1, v8));
        int v19 = 0;
        int v20 = 0;
        if(v12.getWrapInfo-OpUlnko(v13, 0, v15, v17, 0, 0, 0, false, false).isLastItemInContainer()) {
            if(v7 != null) {
            }
            else {
                v10 = false;
            }

            IntIntPair v0_1 = arg32.ellipsisSize-F35zm-w$foundation_layout(v10, 0, 0);
            int v0_2 = v0_1 != null ? IntIntPair.getSecond-impl(v0_1.unbox-impl()) : 0;
            return IntIntPair.constructor-impl(v0_2, 0);
        }

        int v7_1 = v0.size();
        int v14 = v3;
        int v13_1 = 0;
        int v16 = 0;
        int v23 = 0;
        int v15_1 = 0;
        while(true) {
            v11 = v20;
            if(v13_1 >= v7_1) {
                break;
            }

            v6_1 = v14 - v6_1;
            v14 = v13_1 + 1;
            v20 = Math.max(v11, v8);
            Object v8_1 = CollectionsKt.getOrNull(v0, v14);
            int v5 = v8_1 != null ? v2.invoke(v8_1, Integer.valueOf(v14), Integer.valueOf(v3)).intValue() : 0;
            int v9 = v8_1 != null ? v1.invoke(v8_1, Integer.valueOf(v14), Integer.valueOf(v5)).intValue() + arg28 : 0;
            v13 = v13_1 + 2 < v0.size() ? true : false;
            v11 = v14;
            v14 -= v23;
            int v18 = v15_1;
            v15 = IntIntPair.constructor-impl(v6_1, v4_1);
            v17 = v8_1 == null ? null : IntIntPair.box-impl(IntIntPair.constructor-impl(v9, v5));
            WrapInfo v13_2 = v12.getWrapInfo-OpUlnko(v13, v14, v15, v17, v18, v19, v20, false, false);
            if(v13_2.isLastItemInLine()) {
                v16 = v19 + (v20 + arg29);
                v15_1 = v18;
                v18 = v14;
                boolean v14_1 = v8_1 != null ? true : false;
                WrapEllipsisInfo v6_2 = v12.getWrapEllipsisInfo(v13_2, v14_1, v15_1, v16, v6_1, v18);
                v9 -= arg28;
                ++v15_1;
                if(v13_2.isLastItemInContainer()) {
                    if(v6_2 != null) {
                        long v0_3 = v6_2.getEllipsisSize-OO21N7I();
                        if(!v6_2.getPlaceEllipsisOnLastContentLine()) {
                            v16 += IntIntPair.getSecond-impl(v0_3) + arg29;
                        }
                    }

                    v19 = v16;
                    goto label_158;
                }

                v14 = v3;
                v23 = v11;
                v19 = v16;
                v20 = 0;
            }
            else {
                v14 = v6_1;
                v15_1 = v18;
            }

            v6_1 = v9;
            v8 = v5;
            v13_1 = v11;
            v16 = v13_1;
        }

        v11 = v16;
    label_158:
        return IntIntPair.constructor-impl(v19 - arg29, v11);
    }

    public static final int mainAxisMin(IntrinsicMeasurable arg0, boolean arg1, int arg2) {
        if(arg1) {
            return arg0.minIntrinsicWidth(arg2);
        }

        return arg0.minIntrinsicHeight(arg2);
    }

    private static final int maxIntrinsicMainAxisSize(List arg9, Function3 arg10, int arg11, int arg12, int arg13) {
        int v0 = arg9.size();
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(v2 < v0) {
            int v6 = arg10.invoke(arg9.get(v2), Integer.valueOf(v2), Integer.valueOf(arg11)).intValue() + arg12;
            int v7 = v2 + 1;
            if(v7 - v4 == arg13 || v7 == arg9.size()) {
                v3 = Math.max(v3, v5 + v6 - arg12);
                v5 = 0;
                v4 = v2;
            }
            else {
                v5 += v6;
            }

            v2 = v7;
        }

        return v3;
    }

    public static final long measureAndCache-rqJ1uqs(Measurable arg3, FlowLineMeasurePolicy arg4, long arg5, Function1 arg7) {
        Float v1_2;
        Measurable v0 = arg3;
        if(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v0))) == 0f) {
            RowColumnParentData v1 = RowColumnImplKt.getRowColumnParentData(((IntrinsicMeasurable)v0));
            if(v1 != null) {
                FlowLayoutData v1_1 = v1.getFlowLayoutData();
                if(v1_1 != null) {
                    v1_2 = Float.valueOf(v1_1.getFillCrossAxisFraction());
                }
                else {
                    goto label_12;
                }
            }
            else {
            label_12:
                v1_2 = null;
            }

            if(v1_2 != null) {
                goto label_20;
            }

            Placeable v3 = arg3.measure-BRTryo0(arg5);
            arg7.invoke(v3);
            return IntIntPair.constructor-impl(arg4.mainAxisSize(v3), arg4.crossAxisSize(v3));
        }

    label_20:
        int v3_1 = FlowLayoutKt.mainAxisMin(((IntrinsicMeasurable)v0), arg4.isHorizontal(), 0x7FFFFFFF);
        return IntIntPair.constructor-impl(v3_1, FlowLayoutKt.crossAxisMin(((IntrinsicMeasurable)v0), arg4.isHorizontal(), v3_1));
    }

    private static final int minIntrinsicMainAxisSize(List arg16, Function3 arg17, Function3 arg18, int arg19, int arg20, int arg21, int arg22, int arg23, FlowLayoutOverflowState arg24) {
        int v12;
        List v0 = arg16;
        int v9 = arg19;
        int v6 = arg22;
        int v7 = arg23;
        if(v0.isEmpty()) {
            return 0;
        }

        int v3 = v0.size();
        int[] v1 = new int[v3];
        int v4 = v0.size();
        int[] v2 = new int[v4];
        int v8 = v0.size();
        int v10;
        for(v10 = 0; v10 < v8; ++v10) {
            Object v11 = v0.get(v10);
            v12 = arg17.invoke(v11, Integer.valueOf(v10), Integer.valueOf(v9)).intValue();
            v1[v10] = v12;
            v2[v10] = arg18.invoke(v11, Integer.valueOf(v10), Integer.valueOf(v12)).intValue();
        }

        v8 = 0x7FFFFFFF;
        if(v7 != v8 && v6 != v8) {
            v8 = v6 * v7;
        }

        int v11_1 = 1;
        if(v8 >= v0.size() || arg24.getType$foundation_layout() != OverflowType.ExpandOrCollapseIndicator) {
            if(v8 >= v0.size() && v7 >= arg24.getMinLinesToShowCollapse$foundation_layout() && arg24.getType$foundation_layout() == OverflowType.ExpandOrCollapseIndicator) {
            label_46:
                v10 = 1;
                goto label_57;
            }

            v10 = 0;
        }
        else if(arg24.getType$foundation_layout() == OverflowType.ExpandIndicator) {
            goto label_46;
        }
        else {
            goto label_46;
        }

    label_57:
        v10 = Math.min(v8 - v10, v0.size());
        v8 = ArraysKt.sum(v1) + (v0.size() - 1) * arg20;
        if(v4 == 0) {
            goto label_118;
        }

        v4 = v2[0];
        v12 = ArraysKt.getLastIndex(v2);
        if(1 <= v12) {
            int v13 = 1;
            goto label_70;
        label_118:
            throw new NoSuchElementException();
            while(true) {
            label_70:
                int v14 = v2[v13];
                if(v4 < v14) {
                    v4 = v14;
                }

                if(v13 == v12) {
                    break;
                }

                ++v13;
            }
        }

        if(v3 != 0) {
            v3 = v1[0];
            int v5 = ArraysKt.getLastIndex(v1);
            if(1 <= v5) {
                while(true) {
                    v12 = v1[v11_1];
                    if(v3 < v12) {
                        v3 = v12;
                    }

                    if(v11_1 == v5) {
                        break;
                    }

                    ++v11_1;
                }
            }

            v11_1 = v3;
            v12 = v8;
            while(v11_1 <= v12) {
                if(v4 == v9) {
                }
                else {
                    v3 = (v11_1 + v12) / 2;
                    long v13_1 = FlowLayoutKt.intrinsicCrossAxisSize(v0, v1, v2, v3, arg20, arg21, v6, v7, arg24);
                    v4 = IntIntPair.getFirst-impl(v13_1);
                    int v0_1 = IntIntPair.getSecond-impl(v13_1);
                    if(v4 > v9 || v0_1 < v10) {
                        v11_1 = v3 + 1;
                        if(v11_1 > v12) {
                            return v11_1;
                        }
                    }
                    else if(v4 < v9) {
                        v12 = v3 - 1;
                    }
                    else {
                        return v3;
                    }

                    v0 = arg16;
                    v6 = arg22;
                    v7 = arg23;
                    v8 = v3;
                    continue;
                }

                return v8;
            }

            return v8;
        }

        throw new NoSuchElementException();
    }

    public static final MeasureResult placeHelper-BmaY500(MeasureScope arg8, long arg9, int arg11, int arg12, int[] arg13, MutableVector arg14, FlowLineMeasurePolicy arg15, int[] arg16) {
        int v3;
        boolean v0 = arg15.isHorizontal();
        Vertical v1 = arg15.getVerticalArrangement();
        Horizontal v2 = arg15.getHorizontalArrangement();
        if(v0) {
            arg12 += arg8.roundToPx-0680j_4(v1.getSpacing-D9Ej5fM()) * (arg14.getSize() - 1);
            int v2_1 = Constraints.getMinHeight-impl(arg9);
            v3 = Constraints.getMaxHeight-impl(arg9);
            if(arg12 < v2_1) {
                arg12 = v2_1;
            }

            if(arg12 > v3) {
            }
            else {
                v3 = arg12;
            }

            v1.arrange(arg8, v3, arg13, arg16);
        }
        else {
            int[] v7 = arg16;
            arg12 += arg8.roundToPx-0680j_4(v2.getSpacing-D9Ej5fM()) * (arg14.getSize() - 1);
            int v1_1 = Constraints.getMinHeight-impl(arg9);
            v3 = Constraints.getMaxHeight-impl(arg9);
            if(arg12 < v1_1) {
                arg12 = v1_1;
            }

            int v4 = arg12 > v3 ? v3 : arg12;
            v2.arrange(arg8, v4, arg13, arg8.getLayoutDirection(), v7);
            v3 = v4;
        }

        arg12 = Constraints.getMinWidth-impl(arg9);
        int v9 = Constraints.getMaxWidth-impl(arg9);
        if(arg11 < arg12) {
            arg11 = arg12;
        }

        if(arg11 > v9) {
        }
        else {
            v9 = arg11;
        }

        if(v0) {
            arg11 = v9;
            arg12 = v3;
        }
        else {
            arg12 = v9;
            arg11 = v3;
        }

        return MeasureScope.layout$default(arg8, arg11, arg12, null, new FlowLayoutKt$$ExternalSyntheticLambda3(arg14), 4, null);
    }

    static final Unit placeHelper_BmaY500$lambda$2(MutableVector arg2, PlacementScope arg3) {
        Object[] v3 = arg2.content;
        int v2 = arg2.getSize();
        int v0;
        for(v0 = 0; v0 < v2; ++v0) {
            v3[v0].placeChildren();
        }

        return Unit.INSTANCE;
    }

    public static final MeasurePolicy rowMeasurementHelper(Horizontal arg17, Vertical arg18, int arg19, Composer arg20, int arg21) {
        Composer v0 = arg20;
        int v1 = arg21;
        int v3 = 0x582BA447;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rowMeasurementHelper)N(horizontalArrangement,verticalArrangement,maxItemsInMainAxis)440@17697L893:FlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
        }

        ComposerKt.sourceInformationMarkerStart(v0, -70006556, "CC(remember):FlowLayout.kt#9igjgp");
        v3 = 4;
        int v4 = 0;
        Horizontal v8 = arg17;
        int v2 = (v1 & 14 ^ 6) > v3 && (v0.changed(v8)) || (v1 & 6) == v3 ? 1 : 0;
        int v6 = 0x20;
        Vertical v9 = arg18;
        v3 = (v1 & 0x70 ^ 0x30) > v6 && (v0.changed(v9)) || (v1 & 0x30) == v6 ? 1 : 0;
        v2 |= v3;
        v6 = 0x100;
        int v13 = arg19;
        if((v1 & 0x380 ^ 0x180) > v6 && (v0.changed(v13)) || (v1 & 0x180) == v6) {
            v4 = 1;
        }

        v1 = v2 | v4;
        Object v2_1 = v0.rememberedValue();
        if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            FlowLayoutKt$rowMeasurementHelper$1$1 v2_2 = new FlowLayoutKt$rowMeasurementHelper$1$1(new FlowMeasurePolicy(true, v8, v9, v8.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP, v9.getSpacing-D9Ej5fM(), v13, 0x7FFFFFFF, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout(), null));
            v0.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((MeasurePolicy)v2_1);
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Horizontal arg18, Vertical arg19, androidx.compose.ui.Alignment$Vertical arg20, int arg21, int arg22, FlowLayoutOverflowState arg23, Composer arg24, int arg25) {
        androidx.compose.ui.Alignment$Vertical v0 = arg20;
        Composer v1 = arg24;
        int v2 = arg25;
        int v4 = -2010142641;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(rowMeasurementMultiContentHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState)471@18969L708:FlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
        }

        ComposerKt.sourceInformationMarkerStart(v1, 0x3AE6FAF3, "CC(remember):FlowLayout.kt#9igjgp");
        v4 = 4;
        int v5 = 0;
        Horizontal v9 = arg18;
        int v3 = (v2 & 14 ^ 6) > v4 && (v1.changed(v9)) || (v2 & 6) == v4 ? 1 : 0;
        int v7 = 0x20;
        Vertical v10 = arg19;
        v4 = (v2 & 0x70 ^ 0x30) > v7 && (v1.changed(v10)) || (v2 & 0x30) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x100;
        v4 = (v2 & 0x380 ^ 0x180) > v7 && (v1.changed(v0)) || (v2 & 0x180) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x800;
        int v14 = arg21;
        v4 = (v2 & 0x1C00 ^ 0xC00) > v7 && (v1.changed(v14)) || (v2 & 0xC00) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x4000;
        int v15 = arg22;
        if((0xE000 & v2 ^ 0x6000) > v7 && (v1.changed(v15)) || (v2 & 0x6000) == v7) {
            v5 = 1;
        }

        v2 = v3 | v5;
        FlowLayoutOverflowState v3_1 = arg23;
        v2 |= v1.changed(v3_1);
        Object v4_1 = v1.rememberedValue();
        if(v2 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            FlowMeasurePolicy v7_1 = new FlowMeasurePolicy(true, v9, v10, v9.getSpacing-D9Ej5fM(), CrossAxisAlignment.Companion.vertical$foundation_layout(v0), v10.getSpacing-D9Ej5fM(), v14, v15, v3_1, null);
            v1.updateRememberedValue(v7_1);
            FlowMeasurePolicy v4_2 = v7_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return ((MultiContentMeasurePolicy)v4_1);
    }

    private static final Measurable safeNext(Iterator arg1, FlowLineInfo arg2) {
        try {
            if((arg1 instanceof ContextualFlowItemIterator)) {
                Intrinsics.checkNotNull(arg2);
                return ((ContextualFlowItemIterator)arg1).getNext$foundation_layout(arg2);
            }

            return arg1.next();
        }
        catch(IndexOutOfBoundsException ) {
            return null;
        }
    }
}

