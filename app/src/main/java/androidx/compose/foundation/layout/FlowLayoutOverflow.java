package androidx.compose.foundation.layout;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message="FlowLayout overflow is no longer maintained") @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u001BB\u0089\u0001\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u00120\b\u0002\u0010\u0007\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0015\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0016J.\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\t2\u0017\u0010\u0018\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F0\u0019H\u0000¢\u0006\u0002\b\u001AR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0007\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0010\u001A*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0002\b\u000F\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\u001C\u001D\u001E\u001F¨\u0006 "}, d2={"Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getType$foundation_layout", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "createOverflowState", "createOverflowState$foundation_layout", "addOverflowComposables", "list", "", "addOverflowComposables$foundation_layout", "OverflowType", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class FlowLayoutOverflow {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "", "<init>", "(Ljava/lang/String;I)V", "Visible", "Clip", "ExpandIndicator", "ExpandOrCollapseIndicator", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public enum OverflowType {
        public static final enum OverflowType Clip;
        public static final enum OverflowType ExpandIndicator;
        public static final enum OverflowType ExpandOrCollapseIndicator;
        public static final enum OverflowType Visible;

        private static final OverflowType[] $values() {
            return new OverflowType[]{OverflowType.Visible, OverflowType.Clip, OverflowType.ExpandIndicator, OverflowType.ExpandOrCollapseIndicator};
        }

        static {
            OverflowType.Visible = new OverflowType("Visible", 0);
            OverflowType.Clip = new OverflowType("Clip", 1);
            OverflowType.ExpandIndicator = new OverflowType("ExpandIndicator", 2);
            OverflowType.ExpandOrCollapseIndicator = new OverflowType("ExpandOrCollapseIndicator", 3);
            OverflowType[] v0 = OverflowType.$values();
            OverflowType.$VALUES = v0;
            OverflowType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private OverflowType(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return OverflowType.$ENTRIES;
        }

        public static OverflowType valueOf(String arg1) {
            return Enum.valueOf(OverflowType.class, arg1);
        }

        public static OverflowType[] values() {
            return OverflowType.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[OverflowType.values().length];
            try {
                v0[OverflowType.ExpandIndicator.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[OverflowType.ExpandOrCollapseIndicator.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable;
    private final Function1 collapseGetter;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private final Function1 seeMoreGetter;
    private final OverflowType type;

    static {
    }

    private FlowLayoutOverflow(OverflowType arg1, int arg2, int arg3, Function1 arg4, Function1 arg5) {
        super();
        this.type = arg1;
        this.minLinesToShowCollapse = arg2;
        this.minCrossAxisSizeToShowCollapse = arg3;
        this.seeMoreGetter = arg4;
        this.collapseGetter = arg5;
    }

    public FlowLayoutOverflow(OverflowType arg2, int arg3, int arg4, Function1 arg5, Function1 arg6, int arg7, DefaultConstructorMarker arg8) {
        Function1 v0 = null;
        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        if((arg7 & 16) != 0) {
            arg6 = v0;
        }

        this(arg2, 0, 0, arg5, arg6, null);
    }

    public FlowLayoutOverflow(OverflowType arg1, int arg2, int arg3, Function1 arg4, Function1 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public final void addOverflowComposables$foundation_layout(FlowLayoutOverflowState arg4, List arg5) {
        Function1 v0 = this.seeMoreGetter;
        Object v1 = null;
        Object v0_1 = v0 != null ? v0.invoke(arg4) : v1;
        Function1 v2 = this.collapseGetter;
        if(v2 != null) {
            v1 = v2.invoke(arg4);
        }

        int v3 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if(v3 == 1) {
            if(v0_1 == null) {
                return;
            }

            arg5.add(v0_1);
        }
        else if(v3 != 2) {
        }
        else {
            if(v0_1 != null) {
                arg5.add(v0_1);
            }

            if(v1 == null) {
                return;
            }

            arg5.add(v1);
            return;
        }
    }

    public final FlowLayoutOverflowState createOverflowState$foundation_layout() {
        return new FlowLayoutOverflowState(this.type, this.minLinesToShowCollapse, this.minCrossAxisSizeToShowCollapse);
    }

    public final OverflowType getType$foundation_layout() {
        return this.type;
    }
}

