package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.compose.ui.Modifier$Node;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A,\u0010\u0000\u001A\u00020\u00012\u000E\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001A-\u0010\b\u001A\u0004\u0018\u00010\t*\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"compareEquals", "", "a", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "b", "", "", "nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NodeCoordinatorKt {
    public static final boolean access$compareEquals(MutableObjectIntMap arg0, Map arg1) {
        return NodeCoordinatorKt.compareEquals(arg0, arg1);
    }

    public static final Node access$nextUntil-hw7D004(DelegatableNode arg0, int arg1, int arg2) {
        return NodeCoordinatorKt.nextUntil-hw7D004(arg0, arg1, arg2);
    }

    private static final boolean compareEquals(MutableObjectIntMap arg14, Map arg15) {
        if(arg14 == null) {
            return 0;
        }

        if(arg14.getSize() != arg15.size()) {
            return 0;
        }

        Object[] v1 = ((ObjectIntMap)arg14).keys;
        int[] v2 = ((ObjectIntMap)arg14).values;
        long[] v14 = ((ObjectIntMap)arg14).metadata;
        int v3 = v14.length - 2;
        if(v3 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v14[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v3) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v4 << 3) + v9;
                            Object v11 = v1[v10];
                            v10 = v2[v10];
                            v11 = arg15.get(v11);
                            if(v11 == null) {
                            }
                            else {
                                if(((Integer)v11).intValue() != v10) {
                                    return 0;
                                }

                                goto label_43;
                            }

                            return 0;
                        }

                    label_43:
                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return 1;
                    }
                }

                if(v4 == v3) {
                    return 1;
                }
            }
        }

        return 1;
    }

    private static final Node nextUntil-hw7D004(DelegatableNode arg3, int arg4, int arg5) {
        Node v3 = arg3.getNode().getChild$ui();
        Node v0 = null;
        if(v3 == null) {
            return v0;
        }

        if((v3.getAggregateChildKindSet$ui() & arg4) == 0) {
            return v0;
        }

        while(v3 != null) {
            int v1 = v3.getKindSet$ui();
            if((v1 & arg5) != 0) {
                return v0;
            }

            if((v1 & arg4) != 0) {
                return v3;
            }

            v3 = v3.getChild$ui();
        }

        return v0;
    }
}

