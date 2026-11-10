package com.TryJeanPc.goldenmouse.controls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007J:\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u000E2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005J2\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0018\u001A\u00020\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorPositionPolicy;", "", "<init>", "()V", "surface", "Lcom/TryJeanPc/goldenmouse/controls/EditorPositionPolicy$Rect;", "canvasWidth", "", "canvasHeight", "originX", "originY", "screenWidth", "screenHeight", "position", "Lkotlin/Pair;", "", "x", "y", "width", "height", "accessories", "", "anchor", "original", "gap", "Rect", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorPositionPolicy {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0000J\u000E\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0000J\u0016\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J1\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001E\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\nR\u0011\u0010\u000E\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\nR\u0011\u0010\u0010\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\n¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorPositionPolicy$Rect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "width", "getWidth", "height", "getHeight", "contains", "", "other", "overlaps", "at", "x", "y", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Rect {
        public static final int $stable;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        static {
        }

        public Rect(float arg1, float arg2, float arg3, float arg4) {
            super();
            this.left = arg1;
            this.top = arg2;
            this.right = arg3;
            this.bottom = arg4;
        }

        public final Rect at(float arg3, float arg4) {
            return new Rect(arg3, arg4, this.getWidth() + arg3, this.getHeight() + arg4);
        }

        public final float component1() {
            return this.left;
        }

        public final float component2() {
            return this.top;
        }

        public final float component3() {
            return this.right;
        }

        public final float component4() {
            return this.bottom;
        }

        public final boolean contains(Rect arg3) {
            Intrinsics.checkNotNullParameter(arg3, "other");
            if(arg3.left >= this.left && arg3.top >= this.top && arg3.right <= this.right && arg3.bottom <= this.bottom) {
                return 1;
            }

            return 0;
        }

        public final Rect copy(float arg1, float arg2, float arg3, float arg4) {
            return new Rect(arg1, arg2, arg3, arg4);
        }

        public static Rect copy$default(Rect arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.left;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.top;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.right;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.bottom;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((Rect)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Rect)) {
                return 0;
            }

            if(Float.compare(this.left, ((Rect)arg5).left) != 0) {
                return 0;
            }

            if(Float.compare(this.top, ((Rect)arg5).top) != 0) {
                return 0;
            }

            if(Float.compare(this.right, ((Rect)arg5).right) != 0) {
                return 0;
            }

            if(Float.compare(this.bottom, ((Rect)arg5).bottom) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getBottom() {
            return this.bottom;
        }

        public final float getHeight() {
            return this.bottom - this.top;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getTop() {
            return this.top;
        }

        public final float getWidth() {
            return this.right - this.left;
        }

        public int hashCode() {
            return ((Float.hashCode(this.left) * 0x1F + Float.hashCode(this.top)) * 0x1F + Float.hashCode(this.right)) * 0x1F + Float.hashCode(this.bottom);
        }

        public final boolean overlaps(Rect arg3) {
            Intrinsics.checkNotNullParameter(arg3, "other");
            if(this.left < arg3.right && this.right > arg3.left && this.top < arg3.bottom && this.bottom > arg3.top) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            return "Rect(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    public static final int $stable;
    public static final EditorPositionPolicy INSTANCE;

    static {
        EditorPositionPolicy.INSTANCE = new EditorPositionPolicy();
    }

    private EditorPositionPolicy() {
        super();
    }

    public final List accessories(Rect arg19, Rect arg20, List arg21, float arg22) {
        float v8_4;
        Object v5_1;
        Object v10_1;
        Object v8_3;
        Iterator v11;
        Float[] v15;
        Object v14;
        Iterator v1_1;
        ArrayList v2_2;
        Rect v0 = arg19;
        List v1 = arg21;
        Intrinsics.checkNotNullParameter(v0, "surface");
        Rect v3 = arg20;
        Intrinsics.checkNotNullParameter(v3, "anchor");
        Intrinsics.checkNotNullParameter(v1, "original");
        List v2 = v1;
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return v1;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        while(v2_1.hasNext()) {
            if(!v0.contains(v2_1.next())) {
                v2_2 = new ArrayList();
                v1_1 = v1.iterator();
                goto label_25;
            }

            v0 = arg19;
        }

        return v1;
    label_25:
        while(v1_1.hasNext()) {
            Object v4 = v1_1.next();
            ArrayList v6 = v2_2;
            List v5 = CollectionsKt.plus(CollectionsKt.listOf(v3), ((Iterable)v6));
            int v7 = 3;
            Float[] v8 = new Float[v7];
            v8[0] = Float.valueOf(((Rect)v4).getLeft());
            v8[1] = Float.valueOf(v0.getLeft());
            int v12 = 2;
            v8[v12] = Float.valueOf(v0.getRight() - ((Rect)v4).getWidth());
            List v8_1 = CollectionsKt.listOf(((Object[])v8));
            ArrayList v9 = new ArrayList();
            Iterator v13 = ((Iterable)v5).iterator();
            while(v13.hasNext()) {
                v14 = v13.next();
                v15 = new Float[v12];
                v15[0] = Float.valueOf(((Rect)v14).getLeft() - ((Rect)v4).getWidth() - arg22);
                v15[1] = Float.valueOf(((Rect)v14).getRight() + arg22);
                CollectionsKt.addAll(((Collection)v9), CollectionsKt.listOf(((Object[])v15)));
            }

            v8_1 = CollectionsKt.plus(((Collection)v8_1), ((Iterable)v9));
            Float[] v7_1 = new Float[v7];
            v7_1[0] = Float.valueOf(((Rect)v4).getTop());
            v7_1[1] = Float.valueOf(v0.getTop());
            v7_1[v12] = Float.valueOf(v0.getBottom() - ((Rect)v4).getHeight());
            List v7_2 = CollectionsKt.listOf(((Object[])v7_1));
            v9 = new ArrayList();
            v13 = ((Iterable)v5).iterator();
            while(v13.hasNext()) {
                v14 = v13.next();
                v15 = new Float[v12];
                v15[0] = Float.valueOf(((Rect)v14).getTop() - ((Rect)v4).getHeight() - arg22);
                v15[1] = Float.valueOf(((Rect)v14).getBottom() + arg22);
                CollectionsKt.addAll(((Collection)v9), CollectionsKt.listOf(((Object[])v15)));
            }

            v7_2 = CollectionsKt.plus(((Collection)v7_2), ((Iterable)v9));
            v9 = new ArrayList();
            Iterator v8_2 = ((Iterable)v8_1).iterator();
            while(v8_2.hasNext()) {
                float v10 = v8_2.next().floatValue();
                ArrayList v12_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v7_2, 10));
                v11 = v7_2.iterator();
                while(v11.hasNext()) {
                    ((Collection)v12_1).add(((Rect)v4).at(RangesKt.coerceIn(v10, v0.getLeft(), Math.max(v0.getLeft(), v0.getRight() - ((Rect)v4).getWidth())), RangesKt.coerceIn(v11.next().floatValue(), arg19.getTop(), Math.max(arg19.getTop(), arg19.getBottom() - ((Rect)v4).getHeight()))));
                    v1_1 = v1_1;
                    v0 = arg19;
                }

                CollectionsKt.addAll(((Collection)v9), ((Iterable)v12_1));
                v0 = arg19;
            }

            Iterator v18 = v1_1;
            ArrayList v0_1 = v2_2;
            ArrayList v1_2 = new ArrayList();
            Iterator v7_3 = ((Iterable)v9).iterator();
            while(true) {
            label_149:
                if(!v7_3.hasNext()) {
                    goto label_168;
                }

                v8_3 = v7_3.next();
                v10_1 = v8_3;
                if(!(v5 instanceof Collection) || !v5.isEmpty()) {
                    v11 = ((Iterable)v5).iterator();
                    do {
                        if(v11.hasNext()) {
                            if(!((Rect)v10_1).overlaps(v11.next())) {
                                continue;
                            }

                            break;
                        }

                        goto label_166;
                    }
                    while(true);

                    continue;
                }
                else {
                }

                break;
            }

        label_166:
            ((Collection)v1_2).add(v8_3);
            goto label_149;
        label_168:
            v1_1 = ((Iterable)v1_2).iterator();
            Object v7_4 = null;
            if(!v1_1.hasNext()) {
                v5_1 = v7_4;
            }
            else {
                v5_1 = v1_1.next();
                if(!v1_1.hasNext()) {
                }
                else {
                    v8_4 = EditorPositionPolicy.accessories$distance(((Rect)v4), v5_1);
                    do {
                        v10_1 = v1_1.next();
                        float v11_1 = EditorPositionPolicy.accessories$distance(((Rect)v4), v10_1);
                        if(Float.compare(v8_4, v11_1) > 0) {
                            v5_1 = v10_1;
                            v8_4 = v11_1;
                        }

                        if(v1_1.hasNext()) {
                            continue;
                        }

                        break;
                    }
                    while(true);
                }
            }

            if(v5_1 == null) {
                v1_2 = new ArrayList();
                Iterator v5_2 = ((Iterable)v9).iterator();
                while(true) {
                label_193:
                    if(v5_2.hasNext()) {
                        v8_3 = v5_2.next();
                        v10_1 = v8_3;
                        if(!(v6 instanceof Collection) || !v6.isEmpty()) {
                            v11 = ((Iterable)v6).iterator();
                            do {
                                if(v11.hasNext()) {
                                    if(!((Rect)v10_1).overlaps(v11.next())) {
                                        continue;
                                    }

                                    break;
                                }

                                goto label_210;
                            }
                            while(true);

                            continue;
                        }
                        else {
                        }

                        break;
                    }
                    else {
                        goto label_212;
                    }
                }

            label_210:
                ((Collection)v1_2).add(v8_3);
                goto label_193;
            label_212:
                v1_1 = ((Iterable)v1_2).iterator();
                if(!v1_1.hasNext()) {
                }
                else {
                    v7_4 = v1_1.next();
                    if(!v1_1.hasNext()) {
                    }
                    else {
                        float v5_3 = EditorPositionPolicy.accessories$distance(((Rect)v4), v7_4);
                        do {
                            Object v6_1 = v1_1.next();
                            v8_4 = EditorPositionPolicy.accessories$distance(((Rect)v4), v6_1);
                            if(Float.compare(v5_3, v8_4) > 0) {
                                v7_4 = v6_1;
                                v5_3 = v8_4;
                            }

                            if(v1_1.hasNext()) {
                                continue;
                            }

                            break;
                        }
                        while(true);
                    }
                }

                v5_1 = v7_4;
                if(v5_1 != null) {
                    goto label_255;
                }

                v1_1 = ((Iterable)v9).iterator();
                if(v1_1.hasNext()) {
                    v5_1 = v1_1.next();
                    if(!v1_1.hasNext()) {
                        goto label_255;
                    }

                    float v6_2 = EditorPositionPolicy.accessories$distance(((Rect)v4), v5_1);
                    do {
                        v7_4 = v1_1.next();
                        v8_4 = EditorPositionPolicy.accessories$distance(((Rect)v4), v7_4);
                        if(Float.compare(v6_2, v8_4) > 0) {
                            v5_1 = v7_4;
                            v6_2 = v8_4;
                        }
                    }
                    while(v1_1.hasNext());

                    goto label_255;
                }

                throw new NoSuchElementException();
            }

        label_255:
            ((Collection)v0_1).add(v5_1);
            v1_1 = v18;
            v0 = arg19;
        }

        return ((List)v2_2);
    }

    private static final float accessories$distance(Rect arg3, Rect arg4) {
        return (arg4.getLeft() - arg3.getLeft()) * (arg4.getLeft() - arg3.getLeft()) + (arg4.getTop() - arg3.getTop()) * (arg4.getTop() - arg3.getTop());
    }

    public final Pair position(float arg4, float arg5, int arg6, int arg7, Rect arg8) {
        Intrinsics.checkNotNullParameter(arg8, "surface");
        float v0 = 3.402823E+38f;
        String v1 = "Failed requirement.";
        if(Float.compare(Math.abs(arg4), v0) <= 0 && Math.abs(arg5) <= v0 && arg6 > 0 && arg7 > 0) {
            v0 = 1f;
            if(arg8.getWidth() >= v0 && arg8.getHeight() >= v0) {
                float v3 = (((float)arg6)) / 2f;
                Float v3_1 = Float.valueOf(RangesKt.coerceIn(arg4 + v3, arg8.getLeft(), arg8.getRight() - v0) - v3);
                arg4 = (((float)arg7)) / 2f;
                return TuplesKt.to(v3_1, Float.valueOf(RangesKt.coerceIn(arg5 + arg4, arg8.getTop(), arg8.getBottom() - v0) - arg4));
            }

            throw new IllegalArgumentException(v1.toString());
        }

        throw new IllegalArgumentException(v1.toString());
    }

    public final Rect surface(int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        Rect v3 = null;
        if(arg4 > 0 && arg5 > 0 && arg8 > 0) {
            if(arg9 <= 0) {
            }
            else {
                float v6 = ((float)arg6);
                float v7 = ((float)arg7);
                Rect v0 = new Rect(Math.max(0f, v6), Math.max(0f, v7), Math.min(((float)arg8), v6 + (((float)arg4))), Math.min(((float)arg9), v7 + (((float)arg5))));
                float v5 = 1f;
                if(v0.getWidth() >= v5 && v0.getHeight() >= v5) {
                    return v0;
                }
            }
        }

        return v3;
    }
}

