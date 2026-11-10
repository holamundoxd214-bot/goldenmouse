package androidx.compose.ui.spatial;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\f\u001A\u00020\bH\u0082\bJ \u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u0005H\u0002J`\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\b\b\u0002\u0010\u0018\u001A\u00020\b2\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001A2\b\b\u0002\u0010\u001C\u001A\u00020\u001A2\b\b\u0002\u0010\u001D\u001A\u00020\bJN\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\b2\u0006\u0010 \u001A\u00020\b2\u0006\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AJ\u000E\u0010#\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\bJ.\u0010$\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bJ\u001E\u0010%\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AJ\u0016\u0010&\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\u001AJ.\u0010\'\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bJ6\u0010(\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\b2\u0006\u0010 \u001A\u00020\b2\u0006\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\bJ\u001E\u0010)\u001A\u00020\u000E2\u0006\u0010*\u001A\u00020\b2\u0006\u0010+\u001A\u00020\b2\u0006\u0010,\u001A\u00020\bJ \u0010)\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020.2\u0006\u0010+\u001A\u00020\b2\u0006\u0010,\u001A\u00020\bH\u0002J\u000E\u0010/\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\bJ4\u00100\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\b2$\u00101\u001A \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E02J(\u00103\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\b2\u0018\u00101\u001A\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000E04J\u000E\u00105\u001A\u00020.2\u0006\u0010\u0013\u001A\u00020\bJ\u0011\u00106\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\bH\u0086\u0002J\u000E\u00107\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\bJ\u000E\u00108\u001A\u00020.2\u0006\u0010\u0013\u001A\u00020\bJ=\u00109\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0:H\u0086\bJ=\u0010;\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0:H\u0086\bJ=\u0010<\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0:H\u0086\bJ5\u0010=\u001A\u00020\u000E2*\u00101\u001A&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0>H\u0086\bJ-\u00109\u001A\u00020\u000E2\u0006\u0010?\u001A\u00020\b2\u0006\u0010@\u001A\u00020\b2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0:H\u0086\bJ=\u0010A\u001A\u00020\u000E2\u0006\u0010B\u001A\u00020\b2*\u00101\u001A&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000E0>H\u0086\bJ5\u0010C\u001A\u00020D2\u0006\u0010E\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bH\u0000¢\u0006\u0002\bFJÇ\u0001\u0010G\u001A\u00020\u000E2\u0006\u0010E\u001A\u00020\b2\u0006\u0010H\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u008B\u0001\u00101\u001A\u0086\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000E0IH\u0086\bJ1\u0010M\u001A\u00020\b2\u0006\u0010E\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bH\u0086\bJ\u0006\u0010N\u001A\u00020\u000EJ\u0006\u0010O\u001A\u00020\u000EJ)\u0010P\u001A\u00020\u000E2\u001E\u00101\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000E0QH\u0086\bJ\u0006\u0010R\u001A\u00020SR\u0012\u0010\u0004\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001A\u00020\b8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006T"}, d2={"Landroidx/compose/ui/spatial/RectList;", "", "<init>", "()V", "items", "", "stack", "itemsSize", "", "size", "getSize", "()I", "allocateItemsIndex", "resizeStorage", "", "actualSize", "currentSize", "currentItems", "insert", "value", "l", "t", "r", "b", "parentId", "focusable", "", "gesturable", "hasCallbacks", "parentIndexInRectList", "insertBasedOnParentOffset", "offsetFromParentX", "offsetFromParentY", "width", "height", "remove", "update", "updateFlagsFor", "updateHasCallbacks", "move", "moveBasedOnParentOffset", "updateSubhierarchy", "id", "deltaX", "deltaY", "stackMeta", "", "markUpdated", "withRect", "block", "Lkotlin/Function4;", "withTopLeftBottomRight", "Lkotlin/Function2;", "getTopLeft", "contains", "indexOf", "metaFor", "forEachIntersection", "Lkotlin/Function1;", "forEachGesturableIntersection", "forEachFocusableIntersection", "forEachRect", "Lkotlin/Function5;", "x", "y", "forEachIntersectingRectWithValueAt", "index", "neighborsScoredByDistance", "", "searchAxis", "neighborsScoredByDistance$ui", "findKNearestNeighbors", "k", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "score", "findNearestNeighbor", "defragment", "clearUpdated", "forEachUpdatedRect", "Lkotlin/Function3;", "debugString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RectList {
    public static final int $stable = 8;
    public long[] items;
    public int itemsSize;
    public long[] stack;

    static {
    }

    public RectList() {
        super();
        this.items = new long[0xC0];
        this.stack = new long[0xC0];
    }

    private final int allocateItemsIndex() {
        long[] v0 = this.items;
        int v1 = this.itemsSize;
        int v2 = v1 + 3;
        this.itemsSize = v2;
        int v3 = v0.length;
        if(v3 <= v2) {
            this.resizeStorage(v3, v1, v0);
        }

        return v1;
    }

    public final void clearUpdated() {
        long[] v0 = this.items;
        int v7 = this.itemsSize;
        int v1;
        for(v1 = 0; v1 < v0.length - 2; v1 += 3) {
            if(v1 >= v7) {
                return;
            }

            int v2 = v1 + 2;
            v0[v2] &= -1152921504606846977L;
        }
    }

    public final boolean contains(int arg7) {
        int v0 = 0x1FFFFFF;
        arg7 &= v0;
        long[] v1 = this.items;
        int v6 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v6) {
                return 0;
            }

            if(((((int)v1[v3 + 2])) & v0) == arg7) {
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public final String debugString() {
        StringBuilder v0 = new StringBuilder();
        long[] v1 = this.items;
        int v15 = this.itemsSize;
        int v2;
        for(v2 = 0; v2 < v1.length - 2; v2 += 3) {
            if(v2 >= v15) {
                break;
            }

            StringBuilder v3 = v0.append("id=" + ((((int)v1[v2 + 2])) & 0x1FFFFFF) + ", rect=[" + (((int)(v1[v2] >> 0x20))) + ',' + (((int)v1[v2])) + ',' + (((int)(v1[v2 + 1] >> 0x20))) + ',' + (((int)v1[v2 + 1])) + "], parent=" + (0x1FFFFFF & (((int)(v1[v2 + 2] >> 25)))) + ", lastChildOffset=" + ((((int)(v1[v2 + 2] >> 50))) & 0x3FF) + ", updated=" + ((((int)(v1[v2 + 2] >> 60))) & 1) + ", focusable=" + ((((int)(v1[v2 + 2] >> 61))) & 1) + ", gesturable=" + ((((int)(v1[v2 + 2] >> 62))) & 1));
            Intrinsics.checkNotNullExpressionValue(v3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(v3.append('\n'), "append(...)");
        }

        String v15_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v15_1, "toString(...)");
        return v15_1;
    }

    public final void defragment() {
        long[] v0 = this.items;
        int v1 = this.itemsSize;
        long[] v2 = this.stack;
        int v3 = 0;
        int v4 = 0;
        while(v3 < v0.length - 2) {
            if(v4 >= v2.length - 2) {
                break;
            }

            if(v3 >= v1) {
                break;
            }

            int v5 = v3 + 2;
            if(v0[v5] != RectListKt.getTombStone()) {
                v2[v4] = v0[v3];
                v2[v4 + 1] = v0[v3 + 1];
                v2[v4 + 2] = v0[v5];
                v4 += 3;
            }

            v3 += 3;
        }

        this.itemsSize = v4;
        this.items = v2;
        this.stack = v0;
    }

    public final void findKNearestNeighbors(int arg23, int arg24, int arg25, int arg26, int arg27, int arg28, Function6 arg29) {
        int v0 = arg24;
        int[] v2 = this.neighborsScoredByDistance$ui(arg23, arg25, arg26, arg27, arg28);
        long[] v1 = this.items;
        int v4 = 1;
        int v5 = 0;
        int v6 = 0;
        while(v5 <= v0) {
            int v7 = 0x7FFFFFFF;
            int v8 = 0;
            while(v8 < v2.length) {
                int v9 = v2[v8];
                if(v9 > v4) {
                    v7 = Math.min(v7, v9);
                }

                if(v9 == v4) {
                    int v10 = v8 * 3;
                    arg23 = v4;
                    arg29.invoke(Integer.valueOf(v9), Integer.valueOf((((int)v1[v10 + 2])) & 0x1FFFFFF), Integer.valueOf(((int)(v1[v10] >> 0x20))), Integer.valueOf(((int)v1[v10])), Integer.valueOf(((int)(v1[v10 + 1] >> 0x20))), Integer.valueOf(((int)v1[v10 + 1])));
                    ++v6;
                    if(v6 == v0) {
                        return;
                    }
                }
                else {
                    arg23 = v4;
                }

                ++v8;
                v4 = arg23;
            }

            ++v5;
            v4 = v7;
        }
    }

    public final int findNearestNeighbor(int arg25, int arg26, int arg27, int arg28, int arg29) {
        long[] v1 = this.items;
        int v0 = this.itemsSize;
        int v2 = 0x7FFFFFFF;
        int v3 = -1;
        int v6 = v3;
        int v5;
        for(v5 = 0; v5 < v1.length - 2; v5 += 3) {
            if(v5 >= v0) {
                break;
            }

            int v9 = v5 + 1;
            int v7 = RectListKt.distanceScore(arg25, arg26, arg27, arg28, arg29, ((int)(v1[v5] >> 0x20)), ((int)v1[v5]), ((int)(v1[v9] >> 0x20)), ((int)v1[v9]));
            int v8 = 1;
            int v10 = v7 > 0 ? 1 : 0;
            if(v7 < v2) {
            }
            else {
                v8 = 0;
            }

            v8 &= v10;
            if(v8 != 0) {
                v2 = v7;
            }

            if(v8 != 0) {
                v6 = v9;
            }
        }

        if(v6 >= 0) {
            if(v6 >= v1.length) {
            }
            else {
                return (((int)v1[v6])) & 0x1FFFFFF;
            }
        }

        return v3;
    }

    public final void forEachFocusableIntersection(int arg11, int arg12, int arg13, int arg14, Function1 arg15) {
        long v0 = (((long)arg11)) << 0x20 | (((long)arg12)) & 0xFFFFFFFFL;
        long v11 = (((long)arg13)) << 0x20 | (((long)arg14)) & 0xFFFFFFFFL;
        long[] v13 = this.items;
        int v10 = this.itemsSize;
        for(arg14 = 0; arg14 < v13.length - 2; arg14 += 3) {
            if(arg14 >= v10) {
                return;
            }

            long v2 = v13[arg14 + 2];
            if(((((int)(v2 >> 61))) & 1) != 0 && ((v11 - v13[arg14] - 0x100000001L | v13[arg14 + 1] - v0 - 0x100000001L) & -9223372034707292160L) == 0) {
                arg15.invoke(Integer.valueOf((((int)v2)) & 0x1FFFFFF));
            }
        }
    }

    public final void forEachGesturableIntersection(int arg11, int arg12, int arg13, int arg14, Function1 arg15) {
        long v0 = (((long)arg11)) << 0x20 | (((long)arg12)) & 0xFFFFFFFFL;
        long v11 = (((long)arg13)) << 0x20 | (((long)arg14)) & 0xFFFFFFFFL;
        long[] v13 = this.items;
        int v10 = this.itemsSize;
        for(arg14 = 0; arg14 < v13.length - 2; arg14 += 3) {
            if(arg14 >= v10) {
                return;
            }

            long v2 = v13[arg14 + 2];
            if(((((int)(v2 >> 62))) & 1) != 0 && ((v11 - v13[arg14] - 0x100000001L | v13[arg14 + 1] - v0 - 0x100000001L) & -9223372034707292160L) == 0) {
                arg15.invoke(Integer.valueOf((((int)v2)) & 0x1FFFFFF));
            }
        }
    }

    public final void forEachIntersectingRectWithValueAt(int arg21, Function5 arg22) {
        int v1 = arg21;
        long[] v2 = this.items;
        int v0 = this.itemsSize;
        long v3 = v2[v1];
        long v5 = v2[v1 + 1];
        int v7;
        for(v7 = 0; v7 < v2.length - 2; v7 += 3) {
            if(v7 >= v0) {
                return;
            }

            if(v7 != v1) {
                long v8 = v2[v7];
                long v10 = v2[v7 + 1];
                if(((v5 - v8 - 0x100000001L | v10 - v3 - 0x100000001L) & -9223372034707292160L) == 0) {
                    arg22.invoke(Integer.valueOf(((int)(v8 >> 0x20))), Integer.valueOf(((int)v8)), Integer.valueOf(((int)(v10 >> 0x20))), Integer.valueOf(((int)v10)), Integer.valueOf((((int)v2[v7 + 2])) & 0x1FFFFFF));
                }
            }
        }
    }

    public final void forEachIntersection(int arg9, int arg10, int arg11, int arg12, Function1 arg13) {
        long v0 = (((long)arg9)) << 0x20 | (((long)arg10)) & 0xFFFFFFFFL;
        long v9 = (((long)arg11)) << 0x20 | (((long)arg12)) & 0xFFFFFFFFL;
        long[] v11 = this.items;
        int v8 = this.itemsSize;
        for(arg12 = 0; arg12 < v11.length - 2; arg12 += 3) {
            if(arg12 >= v8) {
                return;
            }

            if(((v9 - v11[arg12] - 0x100000001L | v11[arg12 + 1] - v0 - 0x100000001L) & -9223372034707292160L) == 0) {
                arg13.invoke(Integer.valueOf((((int)v11[arg12 + 2])) & 0x1FFFFFF));
            }
        }
    }

    public final void forEachIntersection(int arg9, int arg10, Function1 arg11) {
        long v9 = (((long)arg10)) & 0xFFFFFFFFL | (((long)arg9)) << 0x20;
        long[] v0 = this.items;
        int v8 = this.itemsSize;
        int v1;
        for(v1 = 0; v1 < v0.length - 2; v1 += 3) {
            if(v1 >= v8) {
                return;
            }

            if(((v9 - v0[v1] - 0x100000001L | v0[v1 + 1] - v9 - 0x100000001L) & -9223372034707292160L) == 0) {
                arg11.invoke(Integer.valueOf((((int)v0[v1 + 2])) & 0x1FFFFFF));
            }
        }
    }

    public final void forEachRect(Function5 arg14) {
        long[] v0 = this.items;
        int v13 = this.itemsSize;
        int v1;
        for(v1 = 0; v1 < v0.length - 2; v1 += 3) {
            if(v1 >= v13) {
                return;
            }

            arg14.invoke(Integer.valueOf((((int)v0[v1 + 2])) & 0x1FFFFFF), Integer.valueOf(((int)(v0[v1] >> 0x20))), Integer.valueOf(((int)v0[v1])), Integer.valueOf(((int)(v0[v1 + 1] >> 0x20))), Integer.valueOf(((int)v0[v1 + 1])));
        }
    }

    public final void forEachUpdatedRect(Function3 arg9) {
        long[] v0 = this.items;
        int v8 = this.itemsSize;
        int v1;
        for(v1 = 0; v1 < v0.length - 2; v1 += 3) {
            if(v1 >= v8) {
                return;
            }

            long v2 = v0[v1 + 2];
            if(((((int)(v2 >> 60))) & 1) != 0) {
                arg9.invoke(Integer.valueOf((((int)v2)) & 0x1FFFFFF), Long.valueOf(v0[v1]), Long.valueOf(v0[v1 + 1]));
            }
        }
    }

    public final int getSize() {
        return this.itemsSize / 3;
    }

    public final long getTopLeft(int arg6) {
        int v0 = 0x1FFFFFF;
        arg6 &= v0;
        long[] v1 = this.items;
        int v5 = this.itemsSize;
        int v2 = 0;
        while(v2 < v1.length - 2) {
            if(v2 >= v5) {
                return 0x7FFFFFFFFFFFFFFFL;
            }

            if(((((int)v1[v2 + 2])) & v0) == arg6) {
                return v1[v2];
            }
            else {
                v2 += 3;
                continue;
            }

            return 0x7FFFFFFFFFFFFFFFL;
        }

        return 0x7FFFFFFFFFFFFFFFL;
    }

    public final int indexOf(int arg6) {
        int v0 = 0x1FFFFFF;
        arg6 &= v0;
        long[] v1 = this.items;
        int v5 = this.itemsSize;
        int v2 = 0;
        while(v2 < v1.length - 2) {
            if(v2 >= v5) {
                return -1;
            }

            if(((((int)v1[v2 + 2])) & v0) == arg6) {
                return v2;
            }
            else {
                v2 += 3;
                continue;
            }

            return -1;
        }

        return -1;
    }

    public final void insert(int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, boolean arg16, boolean arg17, boolean arg18, int arg19) {
        long[] v0 = this.items;
        int v1 = this.itemsSize;
        int v2 = v1 + 3;
        this.itemsSize = v2;
        int v3 = v0.length;
        if(v3 <= v2) {
            this.resizeStorage(v3, v1, v0);
        }

        long[] v9 = this.items;
        v9[v1] = (((long)arg11)) << 0x20 | (((long)arg12)) & 0xFFFFFFFFL;
        v9[v1 + 1] = (((long)arg13)) << 0x20 | (((long)arg14)) & 0xFFFFFFFFL;
        int v0_1 = 0x3FF;
        arg12 = 50;
        int v4 = 0x1FFFFFF;
        int v5 = arg15 & v4;
        v9[v1 + 2] = (((long)arg18)) << 0x3F | (((long)arg17)) << 62 | (((long)arg16)) << 61 | 0x1000000000000000L | (((long)Math.min(0, v0_1))) << arg12 | (((long)v5)) << 25 | (((long)(arg10 & v4)));
        if(arg15 < 0) {
        }
        else {
            arg11 = arg19;
            for(arg10 = arg11 != -1 ? arg11 : v1 - 3; arg10 >= 0; arg10 += -3) {
                arg11 = arg10 + 2;
                long v2_1 = v9[arg11];
                if(((((int)v2_1)) & v4) == v5) {
                    v9[arg11] = (((long)Math.min((v1 - arg10) / 3, v0_1))) << arg12 | v2_1 & RectListKt.getEverythingButLastChildOffset();
                    return;
                }
            }
        }
    }

    public static void insert$default(RectList arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, boolean arg9, boolean arg10, boolean arg11, int arg12, int arg13, Object arg14) {
        int v0 = -1;
        if((arg13 & 0x20) != 0) {
            arg8 = v0;
        }

        if((arg13 & 0x200) != 0) {
            arg12 = v0;
        }

        arg2.insert(arg3, arg4, arg5, arg6, arg7, arg8, false, false, false, arg12);
    }

    public final void insertBasedOnParentOffset(int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, boolean arg18, boolean arg19, boolean arg20) {
        int v1 = 0x1FFFFFF;
        int v2 = arg12 & v1;
        long[] v3 = this.items;
        int v4 = this.itemsSize;
        int v10 = 0;
        while(v10 < v3.length - 2) {
            if(v10 >= v4) {
                return;
            }

            if(((((int)v3[v10 + 2])) & v1) == arg13) {
                v1 = (((int)(v3[v10] >> 0x20))) + arg14;
                int v3_1 = (((int)v3[v10])) + arg15;
                this.insert(v2, v1, v3_1, v1 + arg16, v3_1 + arg17, arg13, arg18, arg19, arg20, v10);
                return;
            }
            else {
                v10 += 3;
                continue;
            }

            return;
        }
    }

    public final void markUpdated(int arg9) {
        int v0 = 0x1FFFFFF;
        arg9 &= v0;
        long[] v1 = this.items;
        int v8 = this.itemsSize;
        int v2 = 0;
        while(v2 < v1.length - 2) {
            if(v2 >= v8) {
                return;
            }

            int v3 = v2 + 2;
            long v4 = v1[v3];
            if(((((int)v4)) & v0) == arg9) {
                v1[v3] = (v4 >> 0x3F & 1) << 60 | v4;
                return;
            }
            else {
                v2 += 3;
                continue;
            }

            return;
        }
    }

    public final long metaFor(int arg7) {
        int v0 = 0x1FFFFFF;
        arg7 &= v0;
        long[] v1 = this.items;
        int v6 = this.itemsSize;
        int v2 = 0;
        while(v2 < v1.length - 2) {
            if(v2 >= v6) {
                break;
            }

            long v3 = v1[v2 + 2];
            if(((((int)v3)) & v0) == arg7) {
                return v3;
            }
            else {
                v2 += 3;
                continue;
            }

            break;
        }

        return RectListKt.getTombStone();
    }

    public final void move(int arg21, int arg22, int arg23, int arg24, int arg25) {
        RectList v0 = this;
        int v1 = arg22;
        int v2 = arg23;
        int v3 = 0x1FFFFFF;
        int v4 = arg21 & v3;
        long[] v5 = v0.items;
        int v6 = v0.itemsSize;
        int v8 = 0;
        while(v8 < v5.length - 2) {
            if(v8 >= v6) {
                return;
            }

            int v9 = v8 + 2;
            long v10 = v5[v9];
            if(((((int)v10)) & v3) == v4) {
                long v12 = v5[v8];
                int v16 = v3;
                v5[v8] = (((long)v2)) & 0xFFFFFFFFL | (((long)v1)) << 0x20;
                int v19 = v8;
                v5[v8 + 1] = (((long)arg25)) & 0xFFFFFFFFL | (((long)arg24)) << 0x20;
                v5[v9] = (v10 >> 0x3F & 1) << 60 | v10;
                v1 -= ((int)(v12 >> 0x20));
                v2 -= ((int)v12);
                v4 = v1 != 0 ? 1 : 0;
                int v7 = v2 != 0 ? 1 : 0;
                if((v4 | v7) == 0) {
                    return;
                }

                v0.updateSubhierarchy(RectListKt.getEverythingButParentId() & v10 | (((long)(v19 + 3 & v16))) << 25, v1, v2);
                return;
            }
            else {
                v8 += 3;
                continue;
            }

            return;
        }
    }

    public final void moveBasedOnParentOffset(int arg20, int arg21, int arg22, int arg23, int arg24, int arg25) {
        long v13;
        int v12;
        RectList v0 = this;
        int v1 = 0x1FFFFFF;
        int v2 = arg20 & v1;
        long[] v3 = v0.items;
        int v4 = v0.itemsSize;
        int v5 = 0;
        while(v5 < v3.length - 2) {
            if(v5 >= v4) {
                return;
            }

            if(((((int)v3[v5 + 2])) & v1) == arg21) {
                int v6 = 0x20;
                int v10 = (((int)(v3[v5] >> v6))) + arg22;
                int v8 = (((int)v3[v5])) + arg23;
                int v9 = v10 + arg24;
                int v11 = v8 + arg25;
                do {
                    v5 += 3;
                    if(v5 < v3.length - 2 && v5 < v4) {
                        v12 = v5 + 2;
                        v13 = v3[v12];
                        if(((((int)v13)) & v1) != v2) {
                            continue;
                        }

                        break;
                    }

                    goto label_82;
                }
                while(true);

                int v15 = v1;
                v2 = v10 - (((int)(v3[v5] >> v6)));
                v1 = v8 - (((int)v3[v5]));
                v3[v5] = (((long)v8)) & 0xFFFFFFFFL | (((long)v10)) << v6;
                v3[v5 + 1] = (((long)v9)) << v6 | (((long)v11)) & 0xFFFFFFFFL;
                v3[v12] = (v13 >> 0x3F & 1) << 60 | v13;
                if(v2 == 0 && v1 == 0) {
                    return;
                }

                v0.updateSubhierarchy(RectListKt.getEverythingButParentId() & v13 | (((long)(v5 + 3 & v15))) << 25, v2, v1);
                return;
            }

        label_82:
            v5 += 3;
            v1 = v1;
            v3 = v3;
        }
    }

    public final int[] neighborsScoredByDistance$ui(int arg21, int arg22, int arg23, int arg24, int arg25) {
        long[] v1 = this.items;
        int v0 = this.itemsSize / 3;
        int[] v2 = new int[v0];
        int v3 = 0;
        while(v3 < v0) {
            int v4 = v3 * 3;
            if(v4 < 0) {
                return v2;
            }

            if(v4 >= v1.length - 1) {
            }
            else {
                v2[v3] = RectListKt.distanceScore(arg21, arg22, arg23, arg24, arg25, ((int)(v1[v4] >> 0x20)), ((int)v1[v4]), ((int)(v1[v4 + 1] >> 0x20)), ((int)v1[v4 + 1]));
                ++v3;
                continue;
            }

            return v2;
        }

        return v2;
    }

    public final boolean remove(int arg8) {
        int v0 = 0x1FFFFFF;
        arg8 &= v0;
        long[] v1 = this.items;
        int v7 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v7) {
                return 0;
            }

            int v4 = v3 + 2;
            if(((((int)v1[v4])) & v0) == arg8) {
                v1[v3] = -1;
                v1[v3 + 1] = -1;
                v1[v4] = RectListKt.getTombStone();
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    private final void resizeStorage(int arg1, int arg2, long[] arg3) {
        arg1 = Math.max(arg1 * 2, arg2 + 3);
        long[] v2 = Arrays.copyOf(arg3, arg1);
        Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
        this.items = v2;
        long[] v1 = Arrays.copyOf(this.stack, arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        this.stack = v1;
    }

    public final boolean update(int arg15, int arg16, int arg17, int arg18, int arg19) {
        int v0 = 0x1FFFFFF;
        int v1 = arg15 & v0;
        long[] v2 = this.items;
        int v14 = this.itemsSize;
        int v4 = 0;
        while(v4 < v2.length - 2) {
            if(v4 >= v14) {
                return 0;
            }

            int v5 = v4 + 2;
            long v6 = v2[v5];
            if(((((int)v6)) & v0) == v1) {
                v2[v4] = (((long)arg16)) << 0x20 | (((long)arg17)) & 0xFFFFFFFFL;
                v2[v4 + 1] = (((long)arg18)) << 0x20 | 0xFFFFFFFFL & (((long)arg19));
                v2[v5] = (v6 >> 0x3F & 1) << 60 | v6;
                return 1;
            }
            else {
                v4 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public final boolean updateFlagsFor(int arg9, boolean arg10, boolean arg11) {
        int v0 = 0x1FFFFFF;
        arg9 &= v0;
        long[] v1 = this.items;
        int v8 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v8) {
                return 0;
            }

            int v4 = v3 + 2;
            long v5 = v1[v4];
            if(((((int)v5)) & v0) == arg9) {
                v1[v4] = -6917529027641081857L & v5 | (((long)(((int)arg10)))) * 0x2000000000000000L | (((long)(((int)arg11)))) * 0x4000000000000000L;
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public final boolean updateHasCallbacks(int arg9, boolean arg10) {
        int v0 = 0x1FFFFFF;
        arg9 &= v0;
        long[] v1 = this.items;
        int v8 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v8) {
                return 0;
            }

            int v4 = v3 + 2;
            long v5 = v1[v4];
            if(((((int)v5)) & v0) == arg9) {
                v1[v4] = 0x6FFFFFFFFFFFFFFFL & v5 | (((long)(((int)arg10)))) * 0x1000000000000000L | (((long)(((int)arg10)))) * -9223372036854775808L;
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    private final void updateSubhierarchy(long arg23, int arg25, int arg26) {
        int v18;
        int v24;
        int v23;
        int v10;
        int v9;
        int v8;
        int v7;
        RectList v0 = this;
        long[] v1 = v0.items;
        long[] v2 = v0.stack;
        v0.getSize();
        v2[0] = arg23;
        int v3 = 1;
        do {
        label_7:
            if(v3 > 0) {
                --v3;
                v7 = 0x1FFFFFF;
                int v6 = (((int)v2[v3])) & v7;
                v8 = 25;
                v9 = (((int)(v2[v3] >> v8))) & v7;
                v10 = 50;
                int v5 = 0x3FF;
                int v4 = (((int)(v2[v3] >> v10))) & v5;
                v4 = v4 == v5 ? v0.itemsSize : v4 * 3 + v9;
                if(v9 < 0) {
                    return;
                }

                while(true) {
                label_28:
                    if(v9 >= v1.length - 2) {
                        goto label_7;
                    }

                    if(v9 >= v4) {
                        goto label_7;
                    }

                    goto label_32;
                }
            }

            return;
        }
        while(true);

    label_32:
        int v11 = v9 + 2;
        long v12 = v1[v11];
        if(((((int)(v12 >> v8))) & v7) == v6) {
            long v14 = v1[v9];
            int v16 = v9 + 1;
            v23 = v7;
            v24 = v8;
            long v7_1 = v1[v16];
            v18 = v10;
            v1[v9] = (((long)((((int)v14)) + arg26))) & 0xFFFFFFFFL | (((long)((((int)(v14 >> 0x20))) + arg25))) << 0x20;
            v1[v16] = (((long)((((int)v7_1)) + arg26))) & 0xFFFFFFFFL | (((long)((((int)(v7_1 >> 0x20))) + arg25))) << 0x20;
            v1[v11] = (v12 >> 0x3F & 1) << 60 | v12;
            if(((((int)(v12 >> v18))) & v5) > 0) {
                v2[v3] = RectListKt.getEverythingButParentId() & v12 | (((long)(v9 + 3 & v23))) << v24;
                ++v3;
            }
        }
        else {
            v23 = v7;
            v24 = v8;
            v18 = v10;
        }

        v9 += 3;
        v7 = v23;
        v8 = v24;
        v10 = v18;
        goto label_28;
    }

    public final void updateSubhierarchy(int arg5, int arg6, int arg7) {
        this.updateSubhierarchy((((long)Math.min(this.itemsSize / 3, 0x3FF))) << 50 | (((long)(arg5 & 0x1FFFFFF))), arg6, arg7);
    }

    public final boolean withRect(int arg8, Function4 arg9) {
        int v0 = 0x1FFFFFF;
        arg8 &= v0;
        long[] v1 = this.items;
        int v7 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v7) {
                return 0;
            }

            if(((((int)v1[v3 + 2])) & v0) == arg8) {
                arg9.invoke(Integer.valueOf(((int)(v1[v3] >> 0x20))), Integer.valueOf(((int)v1[v3])), Integer.valueOf(((int)(v1[v3 + 1] >> 0x20))), Integer.valueOf(((int)v1[v3 + 1])));
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public final boolean withTopLeftBottomRight(int arg7, Function2 arg8) {
        int v0 = 0x1FFFFFF;
        arg7 &= v0;
        long[] v1 = this.items;
        int v6 = this.itemsSize;
        int v3 = 0;
        while(v3 < v1.length - 2) {
            if(v3 >= v6) {
                return 0;
            }

            if(((((int)v1[v3 + 2])) & v0) == arg7) {
                arg8.invoke(Long.valueOf(v1[v3]), Long.valueOf(v1[v3 + 1]));
                return 1;
            }
            else {
                v3 += 3;
                continue;
            }

            return 0;
        }

        return 0;
    }
}

