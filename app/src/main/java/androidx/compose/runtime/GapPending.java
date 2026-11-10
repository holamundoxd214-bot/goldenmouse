package androidx.compose.runtime;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.GroupInfo;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\u001B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u001C\u001A\u00020\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001J\u000E\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0004J\u0016\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u00062\u0006\u0010\'\u001A\u00020\u0006J\u001E\u0010(\u001A\u00020%2\u0006\u0010&\u001A\u00020\u00062\u0006\u0010\'\u001A\u00020\u00062\u0006\u0010)\u001A\u00020\u0006J\u0016\u0010*\u001A\u00020%2\u0006\u0010 \u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u0006J\u0016\u0010,\u001A\u00020\u001F2\u0006\u0010-\u001A\u00020\u00062\u0006\u0010.\u001A\u00020\u0006J\u000E\u0010/\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u0004J\u000E\u00100\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u0004J\u000E\u00101\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u0004R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\f\"\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\'\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00040\"8F¢\u0006\u0006\u001A\u0004\b#\u0010\n¨\u00062"}, d2={"Landroidx/compose/runtime/GapPending;", "", "keyInfos", "", "Landroidx/compose/runtime/composer/gapbuffer/KeyInfo;", "startIndex", "", "<init>", "(Ljava/util/List;I)V", "getKeyInfos", "()Ljava/util/List;", "getStartIndex", "()I", "groupIndex", "getGroupIndex", "setGroupIndex", "(I)V", "usedKeys", "groupInfos", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/composer/GroupInfo;", "keyMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "getKeyMap-fVlnmYg", "()Landroidx/collection/MutableScatterMap;", "keyMap$delegate", "Lkotlin/Lazy;", "getNext", "key", "dataKey", "recordUsed", "", "keyInfo", "used", "", "getUsed", "registerMoveSlot", "", "from", "to", "registerMoveNode", "count", "registerInsert", "insertIndex", "updateNodeCount", "group", "newCount", "slotPositionOf", "nodePositionOf", "updatedNodeCountOf", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class GapPending {
    private int groupIndex;
    private final MutableIntObjectMap groupInfos;
    private final List keyInfos;
    private final Lazy keyMap$delegate;
    private final int startIndex;
    private final List usedKeys;

    public GapPending(List arg7, int arg8) {
        super();
        this.keyInfos = arg7;
        this.startIndex = arg8;
        int v0 = 0;
        arg8 = arg8 >= 0 ? 1 : 0;
        if(arg8 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }

        this.usedKeys = new ArrayList();
        MutableIntObjectMap v8 = new MutableIntObjectMap(0, 1, null);
        int v7 = this.keyInfos.size();
        int v1 = 0;
        while(v0 < v7) {
            Object v2 = this.keyInfos.get(v0);
            v8.set(((KeyInfo)v2).getLocation(), new GroupInfo(v0, v1, ((KeyInfo)v2).getNodes()));
            v1 += ((KeyInfo)v2).getNodes();
            ++v0;
        }

        this.groupInfos = v8;
        this.keyMap$delegate = LazyKt.lazy(new GapPending$keyMap$2(this));
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final List getKeyInfos() {
        return this.keyInfos;
    }

    public final MutableScatterMap getKeyMap-fVlnmYg() {
        return this.keyMap$delegate.getValue().unbox-impl();
    }

    public final KeyInfo getNext(int arg2, Object arg3) {
        JoinedKey v0;
        if(arg3 != null) {
            v0 = new JoinedKey(Integer.valueOf(arg2), arg3);
        }
        else {
            Integer v0_1 = Integer.valueOf(arg2);
        }

        return MultiValueMap.removeFirst-impl(this.getKeyMap-fVlnmYg(), v0);
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final List getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(KeyInfo arg1) {
        Object v0 = this.groupInfos.get(arg1.getLocation());
        if(v0 != null) {
            return ((GroupInfo)v0).getNodeIndex();
        }

        return -1;
    }

    public final boolean recordUsed(KeyInfo arg1) {
        return this.usedKeys.add(arg1);
    }

    public final void registerInsert(KeyInfo arg4, int arg5) {
        this.groupInfos.set(arg4.getLocation(), new GroupInfo(-1, arg5, 0));
    }

    public final void registerMoveNode(int arg24, int arg25, int arg26) {
        int v8_1;
        long v21;
        int v20;
        int v5;
        long v17;
        long v15;
        int v13;
        long[] v0_2;
        MutableIntObjectMap v0_1;
        GapPending v0 = this;
        int v1 = arg24;
        int v2 = arg25;
        int v7 = 7;
        long v8 = -9187201950435737472L;
        int v11 = 8;
        if(v1 > v2) {
            v0_1 = v0.groupInfos;
            Object[] v12 = ((IntObjectMap)v0_1).values;
            v0_2 = ((IntObjectMap)v0_1).metadata;
            v13 = v0_2.length - 2;
            if(v13 >= 0) {
                int v14 = 0;
                v15 = 0x80;
                while(true) {
                    long v3 = v0_2[v14];
                    v17 = 0xFF;
                    if((~v3 << v7 & v3 & v8) != v8) {
                        v5 = 8 - (~(v14 - v13) >>> 0x1F);
                        int v6 = 0;
                        while(v6 < v5) {
                            if((v3 & v17) < v15) {
                                v20 = v7;
                                Object v7_1 = v12[(v14 << 3) + v6];
                                v21 = v8;
                                v8_1 = ((GroupInfo)v7_1).getNodeIndex();
                                if(v1 <= v8_1 && v8_1 < v1 + arg26) {
                                    ((GroupInfo)v7_1).setNodeIndex(v8_1 - v1 + v2);
                                    goto label_52;
                                }

                                if(v2 > v8_1) {
                                    goto label_52;
                                }

                                if(v8_1 >= v1) {
                                    goto label_52;
                                }

                                ((GroupInfo)v7_1).setNodeIndex(v8_1 + arg26);
                            }
                            else {
                                v20 = v7;
                                v21 = v8;
                            }

                        label_52:
                            v3 >>= v11;
                            ++v6;
                            v7 = v20;
                            v8 = v21;
                        }

                        v20 = v7;
                        v21 = v8;
                        if(v5 != v11) {
                            return;
                        }
                    }
                    else {
                        v20 = v7;
                        v21 = v8;
                    }

                    if(v14 == v13) {
                        return;
                    }

                    ++v14;
                    v7 = v20;
                    v8 = v21;
                }
            }
        }
        else {
            v20 = v7;
            v21 = v8;
            v15 = 0x80;
            v17 = 0xFF;
            if(v2 <= v1) {
                return;
            }

            v0_1 = v0.groupInfos;
            Object[] v3_1 = ((IntObjectMap)v0_1).values;
            v0_2 = ((IntObjectMap)v0_1).metadata;
            int v4 = v0_2.length - 2;
            if(v4 < 0) {
                return;
            }

            for(v5 = 0; true; ++v5) {
                long v6_1 = v0_2[v5];
                if((~v6_1 << v20 & v6_1 & v21) != v21) {
                    v8_1 = 8 - (~(v5 - v4) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v8_1; ++v9) {
                        if((v6_1 & v17) < v15) {
                            Object v12_1 = v3_1[(v5 << 3) + v9];
                            v13 = ((GroupInfo)v12_1).getNodeIndex();
                            if(v1 <= v13 && v13 < v1 + arg26) {
                                ((GroupInfo)v12_1).setNodeIndex(v13 - v1 + v2);
                                goto label_110;
                            }

                            if(v1 + 1 > v13) {
                                goto label_110;
                            }

                            if(v13 >= v2) {
                                goto label_110;
                            }

                            ((GroupInfo)v12_1).setNodeIndex(v13 - arg26);
                        }

                    label_110:
                        v6_1 >>= v11;
                    }

                    if(v8_1 != v11) {
                        return;
                    }
                }

                if(v5 == v4) {
                    return;
                }
            }
        }
    }

    public final void registerMoveSlot(int arg24, int arg25) {
        int v8_1;
        long v21;
        int v20;
        int v5;
        long v17;
        long v15;
        int v13;
        long[] v0_2;
        MutableIntObjectMap v0_1;
        GapPending v0 = this;
        int v1 = arg24;
        int v2 = arg25;
        int v7 = 7;
        long v8 = -9187201950435737472L;
        int v11 = 8;
        if(v1 > v2) {
            v0_1 = v0.groupInfos;
            Object[] v12 = ((IntObjectMap)v0_1).values;
            v0_2 = ((IntObjectMap)v0_1).metadata;
            v13 = v0_2.length - 2;
            if(v13 >= 0) {
                int v14 = 0;
                v15 = 0x80;
                while(true) {
                    long v3 = v0_2[v14];
                    v17 = 0xFF;
                    if((~v3 << v7 & v3 & v8) != v8) {
                        v5 = 8 - (~(v14 - v13) >>> 0x1F);
                        int v6 = 0;
                        while(v6 < v5) {
                            if((v3 & v17) < v15) {
                                v20 = v7;
                                Object v7_1 = v12[(v14 << 3) + v6];
                                v21 = v8;
                                v8_1 = ((GroupInfo)v7_1).getSlotIndex();
                                if(v8_1 == v1) {
                                    ((GroupInfo)v7_1).setSlotIndex(v2);
                                }
                                else if(v2 <= v8_1 && v8_1 < v1) {
                                    ((GroupInfo)v7_1).setSlotIndex(v8_1 + 1);
                                }
                            }
                            else {
                                v20 = v7;
                                v21 = v8;
                            }

                            v3 >>= v11;
                            ++v6;
                            v7 = v20;
                            v8 = v21;
                        }

                        v20 = v7;
                        v21 = v8;
                        if(v5 != v11) {
                            return;
                        }
                    }
                    else {
                        v20 = v7;
                        v21 = v8;
                    }

                    if(v14 == v13) {
                        return;
                    }

                    ++v14;
                    v7 = v20;
                    v8 = v21;
                }
            }
        }
        else {
            v20 = v7;
            v21 = v8;
            v15 = 0x80;
            v17 = 0xFF;
            if(v2 <= v1) {
                return;
            }

            v0_1 = v0.groupInfos;
            Object[] v3_1 = ((IntObjectMap)v0_1).values;
            v0_2 = ((IntObjectMap)v0_1).metadata;
            int v4 = v0_2.length - 2;
            if(v4 < 0) {
                return;
            }

            for(v5 = 0; true; ++v5) {
                long v6_1 = v0_2[v5];
                if((~v6_1 << v20 & v6_1 & v21) != v21) {
                    v8_1 = 8 - (~(v5 - v4) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v8_1; ++v9) {
                        if((v6_1 & v17) < v15) {
                            Object v12_1 = v3_1[(v5 << 3) + v9];
                            v13 = ((GroupInfo)v12_1).getSlotIndex();
                            if(v13 == v1) {
                                ((GroupInfo)v12_1).setSlotIndex(v2);
                            }
                            else if(v1 + 1 <= v13 && v13 < v2) {
                                ((GroupInfo)v12_1).setSlotIndex(v13 - 1);
                            }
                        }

                        v6_1 >>= v11;
                    }

                    if(v8_1 != v11) {
                        return;
                    }
                }

                if(v5 == v4) {
                    return;
                }
            }
        }
    }

    public final void setGroupIndex(int arg1) {
        this.groupIndex = arg1;
    }

    public final int slotPositionOf(KeyInfo arg1) {
        Object v0 = this.groupInfos.get(arg1.getLocation());
        if(v0 != null) {
            return ((GroupInfo)v0).getSlotIndex();
        }

        return -1;
    }

    public final boolean updateNodeCount(int arg18, int arg19) {
        GapPending v0 = this;
        int v1 = arg19;
        Object v2 = v0.groupInfos.get(arg18);
        if(v2 != null) {
            int v4 = ((GroupInfo)v2).getNodeIndex();
            int v5 = v1 - ((GroupInfo)v2).getNodeCount();
            ((GroupInfo)v2).setNodeCount(v1);
            if(v5 != 0) {
                MutableIntObjectMap v0_1 = v0.groupInfos;
                Object[] v1_1 = ((IntObjectMap)v0_1).values;
                long[] v0_2 = ((IntObjectMap)v0_1).metadata;
                int v6 = v0_2.length - 2;
                if(v6 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v0_2[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80) {
                                    Object v13 = v1_1[(v7 << 3) + v12];
                                    if(((GroupInfo)v13).getNodeIndex() >= v4 && !Intrinsics.areEqual(v13, v2)) {
                                        int v14 = ((GroupInfo)v13).getNodeIndex() + v5;
                                        if(v14 >= 0) {
                                            ((GroupInfo)v13).setNodeIndex(v14);
                                        }
                                    }
                                }

                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                return 1;
                            }
                        }

                        if(v7 == v6) {
                            return 1;
                        }
                    }
                }
            }

            return 1;
        }

        return 0;
    }

    public final int updatedNodeCountOf(KeyInfo arg2) {
        Object v1 = this.groupInfos.get(arg2.getLocation());
        if(v1 != null) {
            return ((GroupInfo)v1).getNodeCount();
        }

        return arg2.getNodes();
    }
}

