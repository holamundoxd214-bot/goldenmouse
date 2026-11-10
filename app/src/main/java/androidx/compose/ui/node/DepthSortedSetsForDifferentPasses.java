package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0003J\u000E\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\fJ\u0016\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\fJX\u0010\u0013\u001A\u00020\u000F2M\b\u0004\u0010\u0014\u001AG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000F0\u0015H\u0086\bJ\u0006\u0010\u0019\u001A\u00020\u0003J\u0006\u0010\u001D\u001A\u00020\u0003R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001A\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2={"Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "", "extraAssertions", "", "<init>", "(Z)V", "lookaheadAndAncestorMeasureSet", "Landroidx/compose/ui/node/DepthSortedSet;", "lookaheadAndAncestorPlaceSet", "approachSet", "contains", "node", "Landroidx/compose/ui/node/LayoutNode;", "affectsLookahead", "add", "", "invalidation", "Landroidx/compose/ui/node/Invalidation;", "remove", "popEach", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "relayoutNeeded", "isEmpty", "affectsLookaheadMeasure", "getAffectsLookaheadMeasure", "()Z", "isNotEmpty", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DepthSortedSetsForDifferentPasses {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Invalidation.values().length];
            try {
                v0[Invalidation.LookaheadMeasurement.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Invalidation.LookaheadPlacement.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Invalidation.Measurement.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Invalidation.Placement.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final DepthSortedSet approachSet;
    private final DepthSortedSet lookaheadAndAncestorMeasureSet;
    private final DepthSortedSet lookaheadAndAncestorPlaceSet;

    static {
    }

    public DepthSortedSetsForDifferentPasses(boolean arg2) {
        super();
        this.lookaheadAndAncestorMeasureSet = new DepthSortedSet(arg2);
        this.lookaheadAndAncestorPlaceSet = new DepthSortedSet(arg2);
        this.approachSet = new DepthSortedSet(arg2);
    }

    public static final DepthSortedSet access$getApproachSet$p(DepthSortedSetsForDifferentPasses arg0) {
        return arg0.approachSet;
    }

    public static final DepthSortedSet access$getLookaheadAndAncestorMeasureSet$p(DepthSortedSetsForDifferentPasses arg0) {
        return arg0.lookaheadAndAncestorMeasureSet;
    }

    public static final DepthSortedSet access$getLookaheadAndAncestorPlaceSet$p(DepthSortedSetsForDifferentPasses arg0) {
        return arg0.lookaheadAndAncestorPlaceSet;
    }

    public final void add(LayoutNode arg2, Invalidation arg3) {
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v3 != 1) {
            if(v3 != 2) {
                if(v3 != 3) {
                    if(v3 == 4) {
                        if(arg2.getLookaheadRoot$ui() != null) {
                            this.approachSet.add(arg2);
                            return;
                        }

                        this.lookaheadAndAncestorPlaceSet.add(arg2);
                        return;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                if(arg2.getLookaheadRoot$ui() != null) {
                    this.approachSet.add(arg2);
                    return;
                }

                this.lookaheadAndAncestorMeasureSet.add(arg2);
                return;
            }

            this.lookaheadAndAncestorPlaceSet.add(arg2);
            this.approachSet.add(arg2);
            return;
        }

        this.lookaheadAndAncestorMeasureSet.add(arg2);
        this.approachSet.add(arg2);
    }

    public final boolean contains(LayoutNode arg2) {
        if(!this.lookaheadAndAncestorMeasureSet.contains(arg2) && !this.lookaheadAndAncestorPlaceSet.contains(arg2)) {
            if(this.approachSet.contains(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean contains(LayoutNode arg5, boolean arg6) {
        int v0 = arg5.getLookaheadRoot$ui() == null ? 1 : 0;
        int v3 = (this.lookaheadAndAncestorMeasureSet.contains(arg5)) || (this.lookaheadAndAncestorPlaceSet.contains(arg5)) ? 1 : 0;
        if(arg6) {
            if(v0 == 0 && v3 != 0) {
                return 1;
            }

            return 0;
        }

        if(v0 != 0 && v3 != 0 || (this.approachSet.contains(arg5))) {
            return 1;
        }

        return 0;
    }

    public final boolean getAffectsLookaheadMeasure() {
        if(!this.approachSet.isEmpty() && !this.lookaheadAndAncestorMeasureSet.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public final boolean isEmpty() {
        if((this.lookaheadAndAncestorMeasureSet.isEmpty()) && (this.approachSet.isEmpty()) && (this.lookaheadAndAncestorPlaceSet.isEmpty())) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        return this.isEmpty() ^ 1;
    }

    public final void popEach(Function3 arg6) {
        LayoutNode v0;
        while(true) {
            boolean v1 = true;
            boolean v2 = false;
            if(!this.lookaheadAndAncestorMeasureSet.isEmpty()) {
                v0 = this.lookaheadAndAncestorMeasureSet.pop();
                if(v0.getLookaheadRoot$ui() != null) {
                }
                else {
                    v1 = false;
                }

                v2 = v1;
                v1 = false;
            }
            else {
                if(!this.lookaheadAndAncestorPlaceSet.isEmpty()) {
                    v0 = this.lookaheadAndAncestorPlaceSet.pop();
                    if(v0.getLookaheadRoot$ui() == null) {
                        goto label_29;
                    }

                    v2 = true;
                    goto label_29;
                }

                if(this.approachSet.isEmpty()) {
                    return;
                }

                v0 = this.approachSet.pop();
            }

        label_29:
            arg6.invoke(v0, Boolean.valueOf(v2), Boolean.valueOf(v1));
        }
    }

    public final boolean remove(LayoutNode arg3) {
        boolean v0 = this.lookaheadAndAncestorMeasureSet.remove(arg3);
        boolean v1 = this.lookaheadAndAncestorPlaceSet.remove(arg3);
        if(!this.approachSet.remove(arg3) && !v0) {
            if(v1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

