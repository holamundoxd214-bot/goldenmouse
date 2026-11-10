package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.layout.Ruler;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0014J\u0019\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\u0014H\u0086\u0002J\u0011\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0015\u001A\u00020\bH\u0086\u0002J8\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001F2 \u0010 \u001A\u001C\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000F\u0018\u00010!J\u0006\u0010\"\u001A\u00020\u0018R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\b0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/ui/node/RulerTrackingMap;", "", "<init>", "()V", "size", "", "rulers", "", "Landroidx/compose/ui/layout/Ruler;", "[Landroidx/compose/ui/layout/Ruler;", "values", "", "accessFlags", "", "layoutNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "Landroidx/compose/ui/node/LayoutNode;", "newRulers", "getOrDefault", "", "ruler", "defaultValue", "set", "", "value", "contains", "", "notifyChanged", "isLookingAhead", "node", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "clear", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RulerTrackingMap {
    private byte[] accessFlags;
    private MutableScatterSet layoutNodes;
    private final MutableScatterSet newRulers;
    private Ruler[] rulers;
    private int size;
    private float[] values;

    public RulerTrackingMap() {
        super();
        this.rulers = new Ruler[0x20];
        this.values = new float[0x20];
        this.accessFlags = new byte[0x20];
        this.layoutNodes = ScatterSetKt.mutableScatterSetOf();
        this.newRulers = ScatterSetKt.mutableScatterSetOf();
    }

    public final void clear() {
        int v0 = this.size;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            this.rulers[v2] = null;
            this.values[v2] = NaNf;
            this.accessFlags[v2] = 0;
        }

        this.size = 0;
    }

    public final boolean contains(Ruler arg1) {
        return ArraysKt.contains(this.rulers, arg1);
    }

    public final float getOrDefault(Ruler arg2, float arg3) {
        int v2 = ArraysKt.indexOf(this.rulers, arg2);
        if(v2 < 0) {
            return arg3;
        }

        return this.values[v2];
    }

    public final void notifyChanged(boolean arg23, LookaheadCapablePlaceable arg24, MutableScatterMap arg25) {
        int v25;
        int v9;
        long v16;
        int v15;
        byte v5_4;
        Object v5_3;
        int v5;
        RulerTrackingMap v0 = this;
        MutableScatterMap v1 = arg25;
        int v2 = v0.size;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            v5 = v0.accessFlags[v4];
            if(v5 == 3) {
                MutableScatterSet v5_1 = v0.newRulers;
                Ruler v6 = v0.rulers[v4];
                Intrinsics.checkNotNull(v6);
                v5_1.plusAssign(v6);
            }
            else if(v5 != 0 && v1 != null) {
                Ruler v5_2 = v0.rulers[v4];
                Intrinsics.checkNotNull(v5_2);
                v5_3 = v1.remove(v5_2);
                if(v5_3 != null) {
                    v0.layoutNodes.plusAssign(((ScatterSet)v5_3));
                }
            }
        }

        int v1_1 = v0.size;
        v2 = 0;
        v4 = 0;
        while(true) {
            v5_4 = 2;
            if(v2 >= v1_1) {
                break;
            }

            byte[] v6_1 = v0.accessFlags;
            if(v6_1[v2] == v5_4) {
                ++v4;
            }
            else if(v4 > 0) {
                v0.rulers[v2 - v4] = v0.rulers[v2];
            }

            v6_1[v2] = v5_4;
            ++v2;
        }

        v1_1 = v0.size;
        for(v2 = v1_1 - v4; v2 < v1_1; ++v2) {
            v0.rulers[v2] = null;
        }

        v0.size -= v4;
        LookaheadCapablePlaceable v1_2 = arg24.getParent();
        MutableScatterSet v2_1 = v0.newRulers;
        Object[] v4_1 = ((ScatterSet)v2_1).elements;
        long[] v2_2 = ((ScatterSet)v2_1).metadata;
        int v6_2 = v2_2.length - v5_4;
        int v11 = 7;
        long v12 = -9187201950435737472L;
        int v14 = 8;
        if(v6_2 >= 0) {
            v15 = 0;
            v16 = 0x80;
            goto label_68;
        }
        else {
            int v20 = v11;
            v16 = 0x80;
            long v18 = 0xFF;
            goto label_117;
            while(true) {
            label_68:
                long v7 = v2_2[v15];
                v18 = 0xFF;
                if((~v7 << v11 & v7 & v12) != v12) {
                    v9 = 8 - (~(v15 - v6_2) >>> 0x1F);
                    int v10 = 0;
                    while(v10 < v9) {
                        if((v7 & v18) < v16) {
                            v25 = v5_4;
                            v5_3 = v4_1[(v15 << 3) + v10];
                            v20 = v11;
                            LookaheadCapablePlaceable v11_1 = v1_2 == null ? arg24 : v1_2;
                            v11_1.invalidateChildrenOfDefiningRuler$ui(((Ruler)v5_3));
                        }
                        else {
                            v25 = v5_4;
                            v20 = v11;
                        }

                        v7 >>= v14;
                        ++v10;
                        v5 = v25;
                        v11 = v20;
                    }

                    v25 = v5_4;
                    v20 = v11;
                    if(v9 != v14) {
                        break;
                    }
                }
                else {
                    v25 = v5_4;
                    v20 = v11;
                }

                if(v15 == v6_2) {
                    break;
                }

                ++v15;
                v5 = v25;
                v11 = v20;
            }
        }

    label_117:
        v0.newRulers.clear();
        MutableScatterSet v1_3 = v0.layoutNodes;
        Object[] v2_3 = ((ScatterSet)v1_3).elements;
        long[] v1_4 = ((ScatterSet)v1_3).metadata;
        v4 = v1_4.length - 2;
        if(v4 >= 0) {
            for(v5 = 0; true; ++v5) {
                long v6_3 = v1_4[v5];
                if((~v6_3 << v20 & v6_3 & v12) != v12) {
                    int v8 = 8 - (~(v5 - v4) >>> 0x1F);
                    for(v9 = 0; v9 < v8; ++v9) {
                        if((v6_3 & v18) < v16) {
                            Object v10_1 = v2_3[(v5 << 3) + v9].get();
                            if(v10_1 != null) {
                                if(arg23) {
                                    ((LayoutNode)v10_1).requestLookaheadRelayout$ui(false);
                                }
                                else {
                                    ((LayoutNode)v10_1).requestRelayout$ui(false);
                                }
                            }
                        }

                        v6_3 >>= v14;
                    }

                    if(v8 != v14) {
                        break;
                    }
                }

                if(v5 == v4) {
                    break;
                }
            }
        }

        v0.layoutNodes.clear();
    }

    public final void set(Ruler arg6, float arg7) {
        int v0 = ArraysKt.indexOf(this.rulers, arg6);
        if(v0 < 0) {
            v0 = this.size;
            Ruler[] v2 = this.rulers;
            if(v0 == v2.length) {
                int v3 = v0 * 2;
                Object[] v2_1 = Arrays.copyOf(((Object[])v2), v3);
                Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
                this.rulers = ((Ruler[])v2_1);
                float[] v2_2 = Arrays.copyOf(this.values, v3);
                Intrinsics.checkNotNullExpressionValue(v2_2, "copyOf(...)");
                this.values = v2_2;
                byte[] v2_3 = Arrays.copyOf(this.accessFlags, v3);
                Intrinsics.checkNotNullExpressionValue(v2_3, "copyOf(...)");
                this.accessFlags = v2_3;
            }

            this.rulers[v0] = arg6;
            this.accessFlags[v0] = 3;
            this.values[v0] = arg7;
            ++this.size;
            return;
        }

        float[] v6 = this.values;
        if(v6[v0] == arg7) {
            byte[] v5 = this.accessFlags;
            if(v5[v0] == 2) {
                v5[v0] = 0;
            }

            return;
        }

        v6[v0] = arg7;
        this.accessFlags[v0] = 1;
    }
}

