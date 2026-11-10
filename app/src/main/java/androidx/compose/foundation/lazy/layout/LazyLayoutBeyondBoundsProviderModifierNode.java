package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutProviderModifierNode;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00014B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ:\u0010\u001B\u001A\u0004\u0018\u0001H\u001C\"\u0004\b\u0000\u0010\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0019\u0010\u001F\u001A\u0015\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u0001H\u001C0 ¢\u0006\u0002\b\"H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001A\u00020\n*\u00020\u001EH\u0002¢\u0006\u0004\b&\u0010\'J\u001F\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020)2\u0006\u0010\u001D\u001A\u00020\u001EH\u0002¢\u0006\u0004\b+\u0010,J\u001B\u0010-\u001A\u00020\n*\u00020)2\u0006\u0010\u001D\u001A\u00020\u001EH\u0002¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001A\u00020\n*\u00020\u001EH\u0002¢\u0006\u0004\b1\u0010\'J&\u00102\u001A\u0002032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u00065"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsProviderModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/layout/BeyondBoundsLayoutProviderModifierNode;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;)V", "beyondBoundsLayout", "getBeyondBoundsLayout", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isForward", "isForward-4vf7U8o", "(I)Z", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "update", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutBeyondBoundsProviderModifierNode extends Node implements BeyondBoundsLayout, BeyondBoundsLayoutProviderModifierNode, LayoutModifierNode {
    @Metadata(d1={"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsProviderModifierNode$Companion;", "", "<init>", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutDirection.Rtl.ordinal()] = 2;
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
    public static final Companion Companion;
    private LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private static final LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope;
    private Orientation orientation;
    private boolean reverseLayout;
    private LazyLayoutBeyondBoundsState state;

    static {
        LazyLayoutBeyondBoundsProviderModifierNode.Companion = new Companion(null);
        LazyLayoutBeyondBoundsProviderModifierNode.$stable = 8;
        LazyLayoutBeyondBoundsProviderModifierNode.emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1();
    }

    public LazyLayoutBeyondBoundsProviderModifierNode(LazyLayoutBeyondBoundsState arg1, LazyLayoutBeyondBoundsInfo arg2, boolean arg3, Orientation arg4) {
        super();
        this.state = arg1;
        this.beyondBoundsInfo = arg2;
        this.reverseLayout = arg3;
        this.orientation = arg4;
    }

    public static final boolean access$hasMoreContent-FR3nfPY(LazyLayoutBeyondBoundsProviderModifierNode arg0, Interval arg1, int arg2) {
        return arg0.hasMoreContent-FR3nfPY(arg1, arg2);
    }

    private final Interval addNextInterval-FR3nfPY(Interval arg2, int arg3) {
        int v0 = arg2.getStart();
        int v2 = arg2.getEnd();
        if(this.isForward-4vf7U8o(arg3)) {
            ++v2;
        }
        else {
            --v0;
        }

        return this.beyondBoundsInfo.addInterval(v0, v2);
    }

    public BeyondBoundsLayout getBeyondBoundsLayout() {
        return this;
    }

    private final boolean hasMoreContent-FR3nfPY(Interval arg3, int arg4) {
        if(this.isOppositeToOrientation-4vf7U8o(arg4)) {
            return 0;
        }

        if(this.isForward-4vf7U8o(arg4)) {
            if(arg3.getEnd() < this.state.getItemCount() - 1) {
                return 1;
            }

            return 0;
        }

        if(arg3.getStart() > 0) {
            return 1;
        }

        return 0;
    }

    private final boolean isForward-4vf7U8o(int arg5) {
        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getBefore-hoxUOeE())) {
            return 0;
        }

        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getAfter-hoxUOeE())) {
            return 1;
        }

        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getAbove-hoxUOeE())) {
            return this.reverseLayout;
        }

        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getBelow-hoxUOeE())) {
            if(!this.reverseLayout) {
                return 1;
            }

            return 0;
        }

        int v3 = 2;
        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getLeft-hoxUOeE())) {
            arg5 = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
            if(arg5 != 1) {
                if(arg5 == v3) {
                    if(!this.reverseLayout) {
                        return 1;
                    }

                    return 0;
                }

                throw new NoWhenBranchMatchedException();
            }

            return this.reverseLayout;
        }

        if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg5, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getRight-hoxUOeE())) {
            arg5 = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
            if(arg5 != 1) {
                if(arg5 == v3) {
                    return this.reverseLayout;
                }

                throw new NoWhenBranchMatchedException();
            }

            if(!this.reverseLayout) {
                return 1;
            }

            return 0;
        }

        LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
        throw new KotlinNothingValueException();
    }

    private final boolean isOppositeToOrientation-4vf7U8o(int arg4) {
        if(!androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getAbove-hoxUOeE())) {
            if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getBelow-hoxUOeE())) {
            }
            else {
                if(!androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getLeft-hoxUOeE())) {
                    if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getRight-hoxUOeE())) {
                    }
                    else {
                        if(!androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getBefore-hoxUOeE())) {
                            if(androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.equals-impl0(arg4, androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection.Companion.getAfter-hoxUOeE())) {
                            }
                            else {
                                LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                                throw new KotlinNothingValueException();
                            }
                        }

                        return 0;
                    }
                }

                if(this.orientation == Orientation.Vertical) {
                    return 1;
                }

                return 0;
            }
        }

        if(this.orientation == Orientation.Horizontal) {
            return 1;
        }

        return 0;
    }

    public Object layout-o7g1Pn8(int arg7, Function1 arg8) {
        if(this.state.getItemCount() > 0 && (this.state.getHasVisibleItems())) {
            if(!this.isAttached()) {
            }
            else {
                boolean v0 = this.isForward-4vf7U8o(arg7);
                LazyLayoutBeyondBoundsState v1 = this.state;
                int v0_1 = v0 ? v1.getLastPlacedIndex() : v1.getFirstPlacedIndex();
                ObjectRef v1_1 = new ObjectRef();
                v1_1.element = this.beyondBoundsInfo.addInterval(v0_1, v0_1);
                v0_1 = RangesKt.coerceAtMost(this.state.itemsPerViewport() * 2, this.state.getItemCount());
                Object v2 = null;
                int v3 = 0;
                while(v2 == null) {
                    if(!this.hasMoreContent-FR3nfPY(v1_1.element, arg7)) {
                        break;
                    }

                    if(v3 >= v0_1) {
                        break;
                    }

                    Interval v2_1 = this.addNextInterval-FR3nfPY(v1_1.element, arg7);
                    this.beyondBoundsInfo.removeInterval(v1_1.element);
                    v1_1.element = v2_1;
                    ++v3;
                    LayoutModifierNodeKt.remeasureSync(this);
                    v2 = arg8.invoke(new LazyLayoutBeyondBoundsProviderModifierNode$layout$2(this, v1_1, arg7));
                }

                this.beyondBoundsInfo.removeInterval(v1_1.element);
                LayoutModifierNodeKt.remeasureSync(((LayoutModifierNode)this));
                return v2;
            }
        }

        return arg8.invoke(LazyLayoutBeyondBoundsProviderModifierNode.emptyBeyondBoundsScope);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v7 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v7.getWidth(), v7.getHeight(), null, new LazyLayoutBeyondBoundsProviderModifierNode$$ExternalSyntheticLambda0(v7), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public final void update(LazyLayoutBeyondBoundsState arg1, LazyLayoutBeyondBoundsInfo arg2, boolean arg3, Orientation arg4) {
        this.state = arg1;
        this.beyondBoundsInfo = arg2;
        this.reverseLayout = arg3;
        this.orientation = arg4;
    }
}

