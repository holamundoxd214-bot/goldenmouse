package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\u001C\u0010\u0000\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0002¨\u0006\b"}, d2={"getChildrenOfVirtualChildren", "", "Landroidx/compose/ui/layout/Measurable;", "scope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "isInLookaheadPass", "", "Landroidx/compose/ui/node/LayoutNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MeasureScopeWithLayoutNodeKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutState.values().length];
            try {
                v0[LayoutState.LookaheadMeasuring.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutState.LookaheadLayingOut.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[LayoutState.Measuring.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[LayoutState.LayingOut.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[LayoutState.Idle.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final List getChildrenOfVirtualChildren(IntrinsicMeasureScope arg6) {
        Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type androidx.compose.ui.node.MeasureScopeWithLayoutNode");
        LayoutNode v6 = ((MeasureScopeWithLayoutNode)arg6).getLayoutNode();
        boolean v0 = MeasureScopeWithLayoutNodeKt.isInLookaheadPass(v6);
        List v6_1 = v6.getFoldedChildren$ui();
        ArrayList v1 = new ArrayList(v6_1.size());
        int v2 = v6_1.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = v6_1.get(v3);
            ArrayList v5 = v1;
            List v4_1 = v0 ? ((LayoutNode)v4).getChildLookaheadMeasurables$ui() : ((LayoutNode)v4).getChildMeasurables$ui();
            ((Collection)v5).add(v4_1);
        }

        return ((List)v1);
    }

    private static final boolean isInLookaheadPass(LayoutNode arg3) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.getLayoutState$ui().ordinal()];
        if(v0 != 1 && v0 != 2) {
            if(v0 != 3 && v0 != 4) {
                if(v0 == 5) {
                    arg3 = arg3.getParent$ui();
                    if(arg3 != null) {
                        return MeasureScopeWithLayoutNodeKt.isInLookaheadPass(arg3);
                    }
                    else {
                        throw new IllegalArgumentException("no parent for idle node".toString());
                    }
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            return 0;
        }

        return 1;
    }
}

