package com.TryJeanPc.goldenmouse.controls;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u0012J$\u0010\u0013\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u0012H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\r¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher;", "", "owner", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "active", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher$Hit;", "offsetX", "", "offsetY", "isBodyGesture", "", "()Z", "dispatch", "event", "Landroid/view/MotionEvent;", "body", "Lkotlin/Function1;", "deliver", "Hit", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorHitDispatcher {
    @Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006J\u0010\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0002J*\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\u0007H\u0002J\u0018\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u001F\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0002\b\u0019J \u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u0016H\u0002R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher$Companion;", "", "<init>", "()V", "enabled", "Ljava/util/WeakHashMap;", "Landroid/view/ViewGroup;", "", "installFallback", "", "canvas", "precise", "event", "Landroid/view/MotionEvent;", "resolve", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher$Hit;", "x", "", "y", "visibleTo", "ancestor", "view", "Landroid/view/View;", "matrixTo", "Landroid/graphics/Matrix;", "matrixTo$app", "frontOrder", "", "owner", "a", "b", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final boolean access$precise(Companion arg0, MotionEvent arg1) {
            return arg0.precise(arg1);
        }

        public static final Hit access$resolve(Companion arg0, ViewGroup arg1, float arg2, float arg3, boolean arg4) {
            return arg0.resolve(arg1, arg2, arg3, arg4);
        }

        public static final boolean access$visibleTo(Companion arg0, ViewGroup arg1, View arg2) {
            return arg0.visibleTo(arg1, arg2);
        }

        private final int frontOrder(ViewGroup arg4, View arg5, View arg6) {
            List v3 = Companion.frontOrder$path(arg4, arg5);
            List v4 = Companion.frontOrder$path(arg4, arg6);
            int v5 = Math.min(v3.size(), v4.size());
            int v0;
            for(v0 = 0; v0 < v5; ++v0) {
                if(v3.get(v0) != v4.get(v0)) {
                    v5 = Float.compare(v4.get(v0).getZ(), v3.get(v0).getZ());
                    if(v5 != 0) {
                        return v5;
                    }

                    ViewParent v5_1 = v3.get(v0).getParent();
                    if((v5_1 instanceof ViewGroup)) {
                    }
                    else {
                        v5_1 = null;
                    }

                    if(v5_1 == null) {
                        return 0;
                    }

                    return Intrinsics.compare(((ViewGroup)v5_1).indexOfChild(v4.get(v0)), ((ViewGroup)v5_1).indexOfChild(v3.get(v0)));
                }
            }

            return Intrinsics.compare(v4.size(), v3.size());
        }

        private static final List frontOrder$path(ViewGroup arg2, View arg3) {
            ArrayList v0 = new ArrayList();
            do {
                if((((ViewGroup)arg3)) == arg2) {
                    break;
                }

                v0.add(0, arg3);
                ViewParent v3 = ((View)v3).getParent();
                if((v3 instanceof View)) {
                }
                else {
                    ViewGroup v3_1 = null;
                }
            }
            while((((ViewParent)v3_1)) != null);

            return ((List)v0);
        }

        public final void installFallback(ViewGroup arg2) {
            Intrinsics.checkNotNullParameter(arg2, "canvas");
            if(EditorHitDispatcher.enabled.put(arg2, Boolean.valueOf(true)) != null) {
                return;
            }

            arg2.setOnTouchListener(new EditorHitDispatcher$Companion$$ExternalSyntheticLambda0(new ObjectRef(), arg2));
        }

        static final boolean installFallback$lambda$0(ObjectRef arg5, ViewGroup arg6, View arg7, MotionEvent arg8) {
            boolean v7_5;
            Object v7_3;
            Object v0 = null;
            if(arg8.getActionMasked() == 0) {
                Companion v7 = EditorHitDispatcher.Companion;
                float v1 = arg8.getX();
                float v2 = arg8.getY();
                Companion v3 = EditorHitDispatcher.Companion;
                Intrinsics.checkNotNull(arg8);
                Hit v7_1 = v7.resolve(arg6, v1, v2, v3.precise(arg8));
                if(v7_1 != null) {
                    ViewGroup v7_2 = v7_1.getOwner();
                }
                else {
                    v7_3 = v0;
                }

                arg5.element = v7_3;
            }

            v7_3 = arg5.element;
            if(v7_3 == null) {
                return 0;
            }

            Matrix v2_1 = new Matrix();
            Matrix v6 = EditorHitDispatcher.Companion.matrixTo$app(arg6, v7_3);
            if(v6 != null && (v6.invert(v2_1))) {
                MotionEvent v6_1 = MotionEvent.obtain(arg8);
                int v1_1 = 3;
                try {
                    v6_1.transform(v2_1);
                    v7_5 = ((ViewGroup)v7_3).dispatchTouchEvent(v6_1);
                    if(arg8.getActionMasked() == 0 && !v7_5) {
                        arg5.element = v0;
                    }
                }
                catch(Throwable v7_4) {
                    v6_1.recycle();
                    if(arg8.getActionMasked() == 1 || arg8.getActionMasked() == v1_1) {
                        arg5.element = v0;
                    }

                    throw v7_4;
                }

                v6_1.recycle();
                if(arg8.getActionMasked() != 1) {
                    if(arg8.getActionMasked() == v1_1) {
                    }
                    else {
                        return v7_5;
                    }
                }

                arg5.element = v0;
                return v7_5;
            }

            arg5.element = v0;
            return 0;
        }

        public final Matrix matrixTo$app(ViewGroup arg4, View arg5) {
            Intrinsics.checkNotNullParameter(arg4, "ancestor");
            Intrinsics.checkNotNullParameter(arg5, "view");
            Matrix v3 = new Matrix();
            while((((ViewGroup)arg5)) != arg4) {
                ViewParent v0 = arg5.getParent();
                Matrix v2 = null;
                if((v0 instanceof ViewGroup)) {
                }
                else {
                    v0 = ((ViewParent)v2);
                }

                if(v0 == null) {
                    return v2;
                }

                v3.postConcat(arg5.getMatrix());
                v3.postTranslate(((float)(arg5.getLeft() - ((ViewGroup)v0).getScrollX())), ((float)(arg5.getTop() - ((ViewGroup)v0).getScrollY())));
                ViewParent v5 = v0;
            }

            return v3;
        }

        private final boolean precise(MotionEvent arg2) {
            if(!arg2.isFromSource(0x2002)) {
                if(arg2.getToolType(0) == 3) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        private final Hit resolve(ViewGroup arg18, float arg19, float arg20, boolean arg21) {
            Object v6;
            Object v7;
            List v2;
            Iterator v2_2;
            ArrayList v4;
            Companion v0 = this;
            ViewGroup v1 = arg18;
            int v3 = 0;
            if(!(v1 instanceof EditorHitRegionProvider) || (EditorHitDispatcher.enabled.containsKey(v1))) {
                IntRange v2_1 = RangesKt.until(0, v1.getChildCount());
                v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_1), 10));
                v2_2 = ((Iterable)v2_1).iterator();
                while(v2_2.hasNext()) {
                    ((Collection)v4).add(v1.getChildAt(v2_2.nextInt()));
                }

                v2 = CollectionsKt.sortedWith(((Iterable)v4), new EditorHitDispatcher$Companion$resolve$$inlined$thenByDescending$1(new EditorHitDispatcher$Companion$resolve$$inlined$compareByDescending$1(), v1));
            }
            else {
                v2 = CollectionsKt.listOf(v1);
            }

            v4 = new ArrayList();
            v2_2 = v2.iterator();
            while(true) {
            label_32:
                if(!v2_2.hasNext()) {
                    goto label_142;
                }

                Object v5 = v2_2.next();
                v7 = null;
                v6 = (v5 instanceof EditorHitRegionProvider) ? v5 : v7;
                if(v6 == null) {
                    continue;
                }

                if((v5 instanceof ViewGroup)) {
                    v7 = v5;
                }

                if(v7 != null) {
                    break;
                }
            }

            Iterator v5_1 = CollectionsKt.sortedWith(((EditorHitRegionProvider)v6).editorHitRegions(), new EditorHitDispatcher$Companion$$ExternalSyntheticLambda2(new EditorHitDispatcher$Companion$$ExternalSyntheticLambda1(((ViewGroup)v7)))).iterator();
            goto label_55;
        label_142:
            return EditorHitPolicy.INSTANCE.resolve(v4, arg21);
            while(true) {
            label_55:
                if(!v5_1.hasNext()) {
                    goto label_32;
                }

                v6 = v5_1.next();
                if(!v0.visibleTo(v1, ((EditorHitRegion)v6).getView())) {
                    continue;
                }

                if(((EditorHitRegion)v6).getView().getWidth() <= 0) {
                    continue;
                }

                if(((EditorHitRegion)v6).getView().getHeight() <= 0) {
                    continue;
                }

                Matrix v8 = v0.matrixTo$app(v1, ((EditorHitRegion)v6).getView());
                if(v8 == null) {
                    continue;
                }

                Matrix v9 = new Matrix();
                if(!v8.invert(v9)) {
                    continue;
                }

                float[] v11 = new float[2];
                v11[v3] = arg19;
                boolean v12 = true;
                v11[1] = arg20;
                v9.mapPoints(v11);
                float[] v9_1 = new float[]{1f, 0f, 0f, 1f};
                v8.mapVectors(v9_1);
                int v15 = v3;
                ArrayList v16 = v4;
                float v3_1 = ((float)Math.hypot(((double)v9_1[v3]), ((double)v9_1[1])));
                float v4_1 = ((float)Math.hypot(((double)v9_1[2]), ((double)v9_1[3])));
                float v8_1 = ((EditorHitRegion)v6).getShape().distance(v11[v15], v11[1], ((float)((EditorHitRegion)v6).getView().getWidth()), ((float)((EditorHitRegion)v6).getView().getHeight())) * Math.min(v3_1, v4_1);
                v3_1 = EditorHitPolicy.INSTANCE.touchTolerance(Math.min((((float)((EditorHitRegion)v6).getView().getWidth())) * v3_1, (((float)((EditorHitRegion)v6).getView().getHeight())) * v4_1), ((EditorHitRegion)v6).getMinimumTouchDp() * v1.getResources().getDisplayMetrics().density);
                v4 = v16;
                if(v8_1 > 0f) {
                }
                else {
                    v12 = ((boolean)v15);
                }

                ((Collection)v4).add(new EditorHitCandidate(new Hit(((ViewGroup)v7), ((EditorHitRegion)v6), v12), v8_1, v3_1, ((EditorHitRegion)v6).getVisibleFigure()));
                v3 = v15;
                v4 = v16;
            }
        }

        static final int resolve$lambda$4(ViewGroup arg1, EditorHitRegion arg2, EditorHitRegion arg3) {
            return EditorHitDispatcher.Companion.frontOrder(arg1, arg2.getView(), arg3.getView());
        }

        static final int resolve$lambda$5(Function2 arg0, Object arg1, Object arg2) {
            return arg0.invoke(arg1, arg2).intValue();
        }

        private final boolean visibleTo(ViewGroup arg3, View arg4) {
            do {
                if(arg4.getVisibility() != 0) {
                    return 0;
                }

                if(arg4.getAlpha() <= 0f) {
                    return 0;
                }

                if(!arg4.isEnabled()) {
                }
                else if((((ViewGroup)arg4)) == arg3) {
                    return 1;
                }
                else {
                    ViewParent v2 = arg4.getParent();
                    if((v2 instanceof View)) {
                    }
                    else {
                        v2 = null;
                    }

                    ViewParent v4 = v2;
                    if(v4 != null) {
                        continue;
                    }
                }

                return 0;
            }
            while(true);

            return 0;
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00072\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitDispatcher$Hit;", "", "owner", "Landroid/view/ViewGroup;", "region", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "halo", "", "<init>", "(Landroid/view/ViewGroup;Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;Z)V", "getOwner", "()Landroid/view/ViewGroup;", "getRegion", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "getHalo", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Hit {
        private final boolean halo;
        private final ViewGroup owner;
        private final EditorHitRegion region;

        public Hit(ViewGroup arg2, EditorHitRegion arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg2, "owner");
            Intrinsics.checkNotNullParameter(arg3, "region");
            super();
            this.owner = arg2;
            this.region = arg3;
            this.halo = arg4;
        }

        public final ViewGroup component1() {
            return this.owner;
        }

        public final EditorHitRegion component2() {
            return this.region;
        }

        public final boolean component3() {
            return this.halo;
        }

        public final Hit copy(ViewGroup arg1, EditorHitRegion arg2, boolean arg3) {
            Intrinsics.checkNotNullParameter(arg1, "owner");
            Intrinsics.checkNotNullParameter(arg2, "region");
            return new Hit(arg1, arg2, arg3);
        }

        public static Hit copy$default(Hit arg0, ViewGroup arg1, EditorHitRegion arg2, boolean arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.owner;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.region;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.halo;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Hit)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Hit)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.owner, ((Hit)arg5).owner)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.region, ((Hit)arg5).region)) {
                return 0;
            }

            if(this.halo != ((Hit)arg5).halo) {
                return 0;
            }

            return 1;
        }

        public final boolean getHalo() {
            return this.halo;
        }

        public final ViewGroup getOwner() {
            return this.owner;
        }

        public final EditorHitRegion getRegion() {
            return this.region;
        }

        public int hashCode() {
            return (this.owner.hashCode() * 0x1F + this.region.hashCode()) * 0x1F + Boolean.hashCode(this.halo);
        }

        public String toString() {
            return "Hit(owner=" + this.owner + ", region=" + this.region + ", halo=" + this.halo + ")";
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private Hit active;
    private static final WeakHashMap enabled;
    private float offsetX;
    private float offsetY;
    private final ViewGroup owner;

    static {
        EditorHitDispatcher.Companion = new Companion(null);
        EditorHitDispatcher.$stable = 8;
        EditorHitDispatcher.enabled = new WeakHashMap();
    }

    public EditorHitDispatcher(ViewGroup arg2) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        super();
        this.owner = arg2;
    }

    public static final WeakHashMap access$getEnabled$cp() {
        return EditorHitDispatcher.enabled;
    }

    private final boolean deliver(MotionEvent arg4, Function1 arg5) {
        boolean v3_1;
        Hit v0 = this.active;
        if(v0 != null) {
            EditorHitRegion v0_1 = v0.getRegion();
            if(v0_1 != null) {
                View v0_2 = v0_1.getReceiver();
                if(v0_2 == null) {
                }
                else {
                    Matrix v5 = new Matrix();
                    Matrix v1 = EditorHitDispatcher.Companion.matrixTo$app(this.owner, v0_2);
                    if(v1 != null && (v1.invert(v5))) {
                        arg4 = MotionEvent.obtain(arg4);
                        try {
                            arg4.transform(v5);
                            arg4.offsetLocation(this.offsetX, this.offsetY);
                            v3_1 = v0_2.dispatchTouchEvent(arg4);
                        }
                        catch(Throwable v3) {
                            arg4.recycle();
                            throw v3;
                        }

                        arg4.recycle();
                        return v3_1;
                    }

                    return 0;
                }
            }
        }

        return arg5.invoke(arg4).booleanValue();
    }

    public final boolean dispatch(MotionEvent arg11, Function1 arg12) {
        MotionEvent v5_4;
        Hit v0_3;
        Matrix v5_2;
        ViewGroup v0_2;
        Intrinsics.checkNotNullParameter(arg11, "event");
        Intrinsics.checkNotNullParameter(arg12, "body");
        int v1 = 3;
        Hit v3 = null;
        boolean v4 = false;
        if(arg11.getActionMasked() == 0) {
            if(this.active != null) {
                MotionEvent v0 = MotionEvent.obtain(arg11);
                try {
                    v0.setAction(v1);
                    Intrinsics.checkNotNull(v0);
                    this.deliver(v0, arg12);
                }
                catch(Throwable v11) {
                    v0.recycle();
                    this.active = v3;
                    throw v11;
                }

                v0.recycle();
                this.active = v3;
            }

            ViewParent v0_1 = this.owner.getParent();
            if((v0_1 instanceof ViewGroup)) {
            }
            else {
                v0_1 = ((ViewParent)v3);
            }

            if(v0_1 != null) {
                if(EditorHitDispatcher.enabled.containsKey(v0_1)) {
                }
                else {
                    v0_1 = ((ViewParent)v3);
                }

                if(v0_1 != null) {
                    goto label_37;
                }

                goto label_36;
            }
            else {
            label_36:
                v0_2 = this.owner;
            }

        label_37:
            float v5 = arg11.getX();
            float v6 = arg11.getY();
            int v7 = 2;
            float[] v8 = new float[v7];
            v8[0] = v5;
            v8[1] = v6;
            ViewGroup v5_1 = this.owner;
            if((((ViewParent)v0_2)) != (((ViewParent)v5_1))) {
                v5_2 = EditorHitDispatcher.Companion.matrixTo$app(v0_2, ((View)v5_1));
                if(v5_2 != null) {
                    v5_2.mapPoints(v8);
                }
                else {
                    return 0;
                }
            }

            Companion v5_3 = EditorHitDispatcher.Companion;
            v0_3 = Companion.access$resolve(v5_3, v0_2, v8[0], v8[1], Companion.access$precise(v5_3, arg11));
            if(v0_3 == null) {
                return 0;
            }

            if(v0_3.getOwner() != this.owner) {
                return 0;
            }

            this.active = v0_3;
            this.offsetX = 0f;
            this.offsetY = 0f;
            View v6_1 = v0_3.getRegion().getReceiver();
            if(v6_1 == null) {
                goto label_97;
            }

            if(!v0_3.getHalo()) {
                goto label_97;
            }

            float v0_4 = arg11.getX();
            float v8_1 = arg11.getY();
            float[] v7_1 = new float[v7];
            v7_1[0] = v0_4;
            v7_1[1] = v8_1;
            Matrix v0_5 = new Matrix();
            v5_2 = v5_3.matrixTo$app(this.owner, v6_1);
            if(v5_2 == null) {
                goto label_97;
            }

            if(!v5_2.invert(v0_5)) {
                goto label_97;
            }

            v0_5.mapPoints(v7_1);
            this.offsetX = (((float)v6_1.getWidth())) / 2f - v7_1[0];
            this.offsetY = (((float)v6_1.getHeight())) / 2f - v7_1[1];
        }

    label_97:
        v0_3 = this.active;
        if(v0_3 == null) {
            return 0;
        }

        boolean v0_6 = Companion.access$visibleTo(EditorHitDispatcher.Companion, this.owner, v0_3.getRegion().getView());
        if(!v0_6) {
            v5_4 = MotionEvent.obtain(arg11);
            v5_4.setAction(v1);
        }
        else {
            v5_4 = ((MotionEvent)v3);
        }

        MotionEvent v6_2 = v5_4 == null ? arg11 : v5_4;
        try {
            boolean v12_1 = this.deliver(v6_2, arg12);
            if(arg11.getActionMasked() == 0 && !v12_1) {
                this.active = v3;
            }

            if(v12_1) {
            }
            else if(arg11.getActionMasked() == 0) {
                goto label_123;
            }
        }
        catch(Throwable v12) {
            if(v5_4 != null) {
                v5_4.recycle();
            }

            if(!v0_6 || arg11.getActionMasked() == 1 || arg11.getActionMasked() == v1) {
                this.active = v3;
            }

            throw v12;
        }

        v4 = true;
    label_123:
        if(v5_4 != null) {
            v5_4.recycle();
        }

        if((v0_6) && arg11.getActionMasked() != 1) {
            if(arg11.getActionMasked() == v1) {
            }
            else {
                return v4;
            }
        }

        this.active = v3;
        return v4;
    }

    public final boolean isBodyGesture() {
        View v0_2;
        Hit v0 = this.active;
        if(v0 != null) {
            EditorHitRegion v0_1 = v0.getRegion();
            if(v0_1 != null) {
                v0_2 = v0_1.getReceiver();
            }
            else {
                goto label_6;
            }
        }
        else {
        label_6:
            v0_2 = null;
        }

        if(v0_2 == null && this.active != null) {
            return 1;
        }

        return 0;
    }
}

