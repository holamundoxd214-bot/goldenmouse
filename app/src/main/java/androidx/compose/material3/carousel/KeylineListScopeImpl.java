package androidx.compose.material3.carousel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J&\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0007J%\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u0005H\u0002JT\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D2\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00072\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u001DH\u0002J\u0018\u0010!\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u0007H\u0002J \u0010#\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0007H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "<init>", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createWithPivot", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "findLastFocalIndex", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "isCutoffLeft", "offset", "isCutoffRight", "TmpKeyline", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeylineListScopeImpl implements KeylineListScope {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2={"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "<init>", "(FZ)V", "getSize", "()F", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public TmpKeyline(float arg1, boolean arg2) {
            super();
            this.size = arg1;
            this.isAnchor = arg2;
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float arg1, boolean arg2) {
            return new TmpKeyline(arg1, arg2);
        }

        public static TmpKeyline copy$default(TmpKeyline arg0, float arg1, boolean arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.size;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.isAnchor;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((TmpKeyline)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof TmpKeyline)) {
                return 0;
            }

            if(Float.compare(this.size, ((TmpKeyline)arg5).size) != 0) {
                return 0;
            }

            if(this.isAnchor != ((TmpKeyline)arg5).isAnchor) {
                return 0;
            }

            return 1;
        }

        public final float getSize() {
            return this.size;
        }

        public int hashCode() {
            return Float.hashCode(this.size) * 0x1F + Boolean.hashCode(this.isAnchor);
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }
    }

    private int firstFocalIndex;
    private float focalItemSize;
    private int pivotIndex;
    private float pivotOffset;
    private final List tmpKeylines;

    public KeylineListScopeImpl() {
        super();
        this.firstFocalIndex = -1;
        this.pivotIndex = -1;
        this.tmpKeylines = new ArrayList();
    }

    public void add(float arg3, boolean arg4) {
        this.tmpKeylines.add(new TmpKeyline(arg3, arg4));
        if(arg3 > this.focalItemSize) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = arg3;
        }
    }

    private final List createKeylinesWithPivot(int arg28, float arg29, int arg30, int arg31, float arg32, float arg33, float arg34, List arg35) {
        boolean v23;
        float v20;
        float v26;
        float v22;
        int v7;
        Object v3_1;
        float v9;
        float v3;
        KeylineListScopeImpl v0 = this;
        int v1 = arg28;
        float v4 = arg29;
        int v10 = arg30;
        int v11 = arg31;
        float v12 = arg33;
        List v13 = arg35;
        Object v2 = v13.get(v1);
        ArrayList v14 = new ArrayList();
        float v16 = 2f;
        if(v0.isCutoffLeft(((TmpKeyline)v2).getSize(), v4)) {
            v3 = v4 - ((TmpKeyline)v2).getSize() / v16;
            goto label_18;
        }
        else if(v0.isCutoffRight(((TmpKeyline)v2).getSize(), v4, v12)) {
            v3 = ((TmpKeyline)v2).getSize() / v16 + v4 - v12;
        label_18:
            v9 = v3;
            v3_1 = v2;
        }
        else {
            v3_1 = v2;
            v9 = 0f;
        }

        Object v5 = v3_1;
        v3 = ((TmpKeyline)v5).getSize();
        boolean v6 = false;
        if(v10 > v1 || v1 > v11) {
            v7 = 0;
        }
        else {
            v7 = 0;
            v6 = true;
        }

        int v15 = v7;
        ((List)v14).add(new Keyline(v3, v4, arg29, v6, ((TmpKeyline)v5).isAnchor(), true, v9));
        float v2_1 = arg32 / v16;
        v3 = arg29 - v2_1 - arg34;
        Iterator v4_1 = RangesKt.downTo(v1 - 1, v15).iterator();
        float v5_1;
        for(v5_1 = v3; v4_1.hasNext(); v5_1 -= arg32 + arg34) {
            int v6_1 = v4_1.nextInt();
            Object v7_1 = v13.get(v6_1);
            float v8 = v3 - ((TmpKeyline)v7_1).getSize() / v16;
            v22 = v5_1 - v2_1;
            v26 = v0.isCutoffLeft(((TmpKeyline)v7_1).getSize(), v8) ? Math.abs(v8 - ((TmpKeyline)v7_1).getSize() / v16) : 0f;
            v20 = ((TmpKeyline)v7_1).getSize();
            v23 = v10 > v6_1 || v6_1 > v11 ? ((boolean)v15) : true;
            ((List)v14).add(v15, new Keyline(v20, v8, v22, v23, ((TmpKeyline)v7_1).isAnchor(), false, v26));
            v3 -= ((TmpKeyline)v7_1).getSize() + arg34;
        }

        v3 = arg29 + v2_1 + arg34;
        Iterator v1_1 = RangesKt.until(v1 + 1, v13.size()).iterator();
        for(v4 = v3; v1_1.hasNext(); v4 += arg32 + arg34) {
            int v5_2 = v1_1.nextInt();
            Object v6_2 = v13.get(v5_2);
            float v7_2 = ((TmpKeyline)v6_2).getSize() / v16 + v3;
            v22 = v4 + v2_1;
            v26 = v0.isCutoffRight(((TmpKeyline)v6_2).getSize(), v7_2, v12) ? ((TmpKeyline)v6_2).getSize() / v16 + v7_2 - v12 : 0f;
            v20 = ((TmpKeyline)v6_2).getSize();
            v23 = v10 > v5_2 || v5_2 > v11 ? ((boolean)v15) : true;
            ((List)v14).add(new Keyline(v20, v7_2, v22, v23, ((TmpKeyline)v6_2).isAnchor(), false, v26));
            v3 += ((TmpKeyline)v6_2).getSize() + arg34;
        }

        return ((List)v14);
    }

    public final KeylineList createWithAlignment-waks0t8(float arg10, float arg11, int arg12) {
        float v0_1;
        float v3;
        int v4 = this.findLastFocalIndex();
        int v1 = v4 - this.firstFocalIndex;
        this.pivotIndex = this.firstFocalIndex;
        float v2 = 2f;
        if(CarouselAlignment.equals-impl0(arg12, CarouselAlignment.Companion.getCenter-NUL3oTo())) {
            float v12 = 0f;
            if(arg11 == 0f) {
            }
            else {
                int v0 = v1 % 2;
                if(v0 + (((v0 ^ 2) & (-v0 | v0)) >> 0x1F & 2) == 0) {
                }
                else {
                    v12 = arg11 / v2;
                }
            }

            v3 = this.focalItemSize;
            v0_1 = arg10 / v2 - v3 / v2 * (((float)v1)) - v12;
        }
        else {
            boolean v12_1 = CarouselAlignment.equals-impl0(arg12, CarouselAlignment.Companion.getEnd-NUL3oTo());
            v3 = this.focalItemSize;
            if(v12_1) {
                v0_1 = arg10 - v3 / v2;
                goto label_40;
            }

            v0_1 = v3 / v2;
        }

    label_40:
        this.pivotOffset = v0_1;
        return new KeylineList(this.createKeylinesWithPivot(this.pivotIndex, v0_1, this.firstFocalIndex, v4, v3, arg10, arg11, this.tmpKeylines));
    }

    public final KeylineList createWithPivot(float arg10, float arg11, int arg12, float arg13) {
        return new KeylineList(this.createKeylinesWithPivot(arg12, arg13, this.firstFocalIndex, this.findLastFocalIndex(), this.focalItemSize, arg10, arg11, this.tmpKeylines));
    }

    private final int findLastFocalIndex() {
        int v0;
        for(v0 = this.firstFocalIndex; v0 < CollectionsKt.getLastIndex(this.tmpKeylines); v0 = v2) {
            int v2 = v0 + 1;
            if(this.tmpKeylines.get(v2).getSize() != this.focalItemSize) {
                return v0;
            }
        }

        return v0;
    }

    private final boolean isCutoffLeft(float arg2, float arg3) {
        arg2 /= 2f;
        if(arg3 - arg2 < 0f && arg3 + arg2 > 0f) {
            return 1;
        }

        return 0;
    }

    private final boolean isCutoffRight(float arg1, float arg2, float arg3) {
        arg1 /= 2f;
        if(arg2 - arg1 < arg3 && arg2 + arg1 > arg3) {
            return 1;
        }

        return 0;
    }
}

