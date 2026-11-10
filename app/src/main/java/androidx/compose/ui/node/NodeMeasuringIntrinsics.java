package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachIntrinsicsMeasureScope;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0006\u0017\u0018\u0019\u001A\u001B\u001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\rJ-\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J-\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0014J-\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00162\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\rJ-\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00162\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00162\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J-\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\u00162\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0014¨\u0006\u001D"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics;", "", "<init>", "()V", "minWidth", "", "measureBlock", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$ApproachMeasureBlock;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "h", "minWidth$ui", "minHeight", "w", "minHeight$ui", "maxWidth", "maxWidth$ui", "maxHeight", "maxHeight$ui", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$MeasureBlock;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "MeasureBlock", "ApproachMeasureBlock", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NodeMeasuringIntrinsics {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$ApproachMeasureBlock;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ApproachMeasureBlock {
        MeasureResult measure-3p2s80s(ApproachMeasureScope arg1, Measurable arg2, long arg3);
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016J\u0010\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016J\u0010\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u001BH\u0016J\u0010\u0010 \u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u001BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "<init>", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "getWidthHeight", "()Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultIntrinsicMeasurable implements Measurable {
        private final IntrinsicMeasurable measurable;
        private final IntrinsicMinMax minMax;
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable arg1, IntrinsicMinMax arg2, IntrinsicWidthHeight arg3) {
            super();
            this.measurable = arg1;
            this.minMax = arg2;
            this.widthHeight = arg3;
        }

        public final IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        public final IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        public Object getParentData() {
            return this.measurable.getParentData();
        }

        public final IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        public int maxIntrinsicHeight(int arg1) {
            return this.measurable.maxIntrinsicHeight(arg1);
        }

        public int maxIntrinsicWidth(int arg1) {
            return this.measurable.maxIntrinsicWidth(arg1);
        }

        public Placeable measure-BRTryo0(long arg5) {
            int v4_1;
            IntrinsicMeasurable v4;
            IntrinsicMinMax v0_1;
            IntrinsicWidthHeight v0 = this.widthHeight;
            IntrinsicWidthHeight v1 = IntrinsicWidthHeight.Width;
            IntrinsicMinMax v2 = this.minMax;
            int v3 = 0x7FFF;
            if(v0 == v1) {
                v0_1 = IntrinsicMinMax.Max;
                v4 = this.measurable;
                v4_1 = v2 == v0_1 ? v4.maxIntrinsicWidth(Constraints.getMaxHeight-impl(arg5)) : v4.minIntrinsicWidth(Constraints.getMaxHeight-impl(arg5));
                if(Constraints.getHasBoundedHeight-impl(arg5)) {
                    v3 = Constraints.getMaxHeight-impl(arg5);
                }

                return new EmptyPlaceable(v4_1, v3);
            }

            v0_1 = IntrinsicMinMax.Max;
            v4 = this.measurable;
            v4_1 = v2 == v0_1 ? v4.maxIntrinsicHeight(Constraints.getMaxWidth-impl(arg5)) : v4.minIntrinsicHeight(Constraints.getMaxWidth-impl(arg5));
            if(Constraints.getHasBoundedWidth-impl(arg5)) {
                v3 = Constraints.getMaxWidth-impl(arg5);
            }

            return new EmptyPlaceable(v3, v4_1);
        }

        public int minIntrinsicHeight(int arg1) {
            return this.measurable.minIntrinsicHeight(arg1);
        }

        public int minIntrinsicWidth(int arg1) {
            return this.measurable.minIntrinsicWidth(arg1);
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0096\u0002J:\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0019\u0010\u0010\u001A\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0011¢\u0006\u0002\b\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "width", "", "height", "<init>", "(II)V", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class EmptyPlaceable extends Placeable {
        public EmptyPlaceable(int arg5, int arg6) {
            super();
            this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)arg6)) & 0xFFFFFFFFL | (((long)arg5)) << 0x20));
        }

        public int get(AlignmentLine arg1) {
            return 0x80000000;
        }

        protected void placeAt-f8xVGno(long arg1, float arg3, Function1 arg4) {
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicMinMax;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum IntrinsicMinMax {
        public static final enum IntrinsicMinMax Max;
        public static final enum IntrinsicMinMax Min;

        private static final IntrinsicMinMax[] $values() {
            return new IntrinsicMinMax[]{IntrinsicMinMax.Min, IntrinsicMinMax.Max};
        }

        static {
            IntrinsicMinMax.Min = new IntrinsicMinMax("Min", 0);
            IntrinsicMinMax.Max = new IntrinsicMinMax("Max", 1);
            IntrinsicMinMax[] v0 = IntrinsicMinMax.$values();
            IntrinsicMinMax.$VALUES = v0;
            IntrinsicMinMax.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private IntrinsicMinMax(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return IntrinsicMinMax.$ENTRIES;
        }

        public static IntrinsicMinMax valueOf(String arg1) {
            return Enum.valueOf(IntrinsicMinMax.class, arg1);
        }

        public static IntrinsicMinMax[] values() {
            return IntrinsicMinMax.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$IntrinsicWidthHeight;", "", "<init>", "(Ljava/lang/String;I)V", "Width", "Height", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum IntrinsicWidthHeight {
        public static final enum IntrinsicWidthHeight Height;
        public static final enum IntrinsicWidthHeight Width;

        private static final IntrinsicWidthHeight[] $values() {
            return new IntrinsicWidthHeight[]{IntrinsicWidthHeight.Width, IntrinsicWidthHeight.Height};
        }

        static {
            IntrinsicWidthHeight.Width = new IntrinsicWidthHeight("Width", 0);
            IntrinsicWidthHeight.Height = new IntrinsicWidthHeight("Height", 1);
            IntrinsicWidthHeight[] v0 = IntrinsicWidthHeight.$values();
            IntrinsicWidthHeight.$VALUES = v0;
            IntrinsicWidthHeight.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private IntrinsicWidthHeight(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return IntrinsicWidthHeight.$ENTRIES;
        }

        public static IntrinsicWidthHeight valueOf(String arg1) {
            return Enum.valueOf(IntrinsicWidthHeight.class, arg1);
        }

        public static IntrinsicWidthHeight[] values() {
            return IntrinsicWidthHeight.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/node/NodeMeasuringIntrinsics$MeasureBlock;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MeasureBlock {
        MeasureResult measure-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3);
    }

    public static final int $stable;
    public static final NodeMeasuringIntrinsics INSTANCE;

    static {
        NodeMeasuringIntrinsics.INSTANCE = new NodeMeasuringIntrinsics();
    }

    private NodeMeasuringIntrinsics() {
        super();
    }

    public final int maxHeight$ui(MeasureBlock arg9, IntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new IntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, arg12, 0, 0, 13, null)).getHeight();
    }

    public final int maxHeight$ui(ApproachMeasureBlock arg9, ApproachIntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new ApproachIntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, arg12, 0, 0, 13, null)).getHeight();
    }

    public final int maxWidth$ui(MeasureBlock arg9, IntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new IntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, arg12, 7, null)).getWidth();
    }

    public final int maxWidth$ui(ApproachMeasureBlock arg9, ApproachIntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new ApproachIntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, arg12, 7, null)).getWidth();
    }

    public final int minHeight$ui(MeasureBlock arg9, IntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new IntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, arg12, 0, 0, 13, null)).getHeight();
    }

    public final int minHeight$ui(ApproachMeasureBlock arg9, ApproachIntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new ApproachIntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, arg12, 0, 0, 13, null)).getHeight();
    }

    public final int minWidth$ui(MeasureBlock arg9, IntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new IntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, arg12, 7, null)).getWidth();
    }

    public final int minWidth$ui(ApproachMeasureBlock arg9, ApproachIntrinsicMeasureScope arg10, IntrinsicMeasurable arg11, int arg12) {
        return arg9.measure-3p2s80s(new ApproachIntrinsicsMeasureScope(arg10, arg10.getLayoutDirection()), new DefaultIntrinsicMeasurable(arg11, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, arg12, 7, null)).getWidth();
    }
}

