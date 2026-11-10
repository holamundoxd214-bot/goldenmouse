package com.TryJeanPc.goldenmouse.controls;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00010B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0018\u0010\u0004\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001A\u00020\u0017H\u0002J\b\u0010\u0018\u001A\u0004\u0018\u00010\u000FJ2\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001A0\u00062\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u0007J\'\u0010\u001F\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001A¢\u0006\u0002\u0010!J\u001C\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010 \u001A\u00020\fH\u0002J\u001E\u0010#\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AJ\u001E\u0010$\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AJ.\u0010%\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AJ\u0006\u0010&\u001A\u00020\u0011J\u000E\u0010&\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\fJ \u0010&\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\u0006\u0010\'\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0018\u0010(\u001A\u00020)2\u0006\u0010 \u001A\u00020\f2\b\b\u0002\u0010*\u001A\u00020+J \u0010,\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\f2\u0006\u0010\'\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0018\u0010-\u001A\u00020+2\u0006\u0010.\u001A\u00020\f2\u0006\u0010/\u001A\u00020\fH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00061"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry;", "", "canvas", "Landroid/view/ViewGroup;", "screenSize", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V", "centers", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry$Center;", "lastSurface", "Lcom/TryJeanPc/goldenmouse/controls/EditorPositionPolicy$Rect;", "onSurfaceChanged", "", "getOnSurfaceChanged", "()Lkotlin/jvm/functions/Function0;", "setOnSurfaceChanged", "(Lkotlin/jvm/functions/Function0;)V", "origin", "", "surface", "constrain", "", "x", "y", "width", "height", "bind", "view", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;)V", "size", "place", "moveLocal", "resizeAndPlaceLocal", "refresh", "bounds", "snapshot", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "constrainToSurface", "", "recoverAccessories", "visible", "owner", "child", "Center", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorControlGeometry {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry$Center;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Center {
        private final float x;
        private final float y;

        public Center(float arg1, float arg2) {
            super();
            this.x = arg1;
            this.y = arg2;
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final Center copy(float arg1, float arg2) {
            return new Center(arg1, arg2);
        }

        public static Center copy$default(Center arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Center)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Center)) {
                return 0;
            }

            if(Float.compare(this.x, ((Center)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((Center)arg5).y) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
        }

        public String toString() {
            return "Center(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    public static final int $stable = 8;
    private final ViewGroup canvas;
    private final WeakHashMap centers;
    private Rect lastSurface;
    private Function0 onSurfaceChanged;
    private final Function0 screenSize;

    static {
    }

    public EditorControlGeometry(ViewGroup arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "canvas");
        Intrinsics.checkNotNullParameter(arg3, "screenSize");
        super();
        this.canvas = arg2;
        this.screenSize = arg3;
        this.centers = new WeakHashMap();
        this.onSurfaceChanged = new EditorControlGeometry$$ExternalSyntheticLambda1();
        arg2.addOnLayoutChangeListener(new EditorControlGeometry$$ExternalSyntheticLambda2(this));
        arg2.getViewTreeObserver().addOnPreDrawListener(new EditorControlGeometry$$ExternalSyntheticLambda3(this));
    }

    static final void _init_$lambda$1(EditorControlGeometry arg0, View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        arg0.refresh();
    }

    static final boolean _init_$lambda$2(EditorControlGeometry arg0) {
        arg0.refresh();
        return 1;
    }

    public final void bind(View arg5, Float arg6, Float arg7) {
        Intrinsics.checkNotNullParameter(arg5, "view");
        if(arg6 != null && arg7 != null) {
            this.centers.put(arg5, new Center(arg6.floatValue() + this.size(arg5).getFirst().floatValue() / 2f, arg7.floatValue() + this.size(arg5).getSecond().floatValue() / 2f));
        }

        arg5.addOnLayoutChangeListener(new EditorControlGeometry$$ExternalSyntheticLambda0(this, arg5));
        this.refresh(arg5);
    }

    static final void bind$lambda$5(EditorControlGeometry arg0, View arg1, View arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        arg0.refresh(arg1);
    }

    public final Pair constrain(float arg8, float arg9, int arg10, int arg11) {
        float v3;
        float v2;
        float v1 = 3.402823E+38f;
        if(Math.abs(arg8) <= v1 && Math.abs(arg9) <= v1 && arg10 > 0 && arg11 > 0) {
            Rect v6 = this.surface();
            if(v6 != null) {
                v2 = arg8;
                v3 = arg9;
                Pair v7 = EditorPositionPolicy.INSTANCE.position(v2, v3, arg10, arg11, v6);
                if(v7 == null) {
                }
                else {
                    return v7;
                }
            }
            else {
                v2 = arg8;
                v3 = arg9;
            }

            return TuplesKt.to(Float.valueOf(v2), Float.valueOf(v3));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Function0 getOnSurfaceChanged() {
        return this.onSurfaceChanged;
    }

    public final void moveLocal(View arg3, float arg4, float arg5) {
        Intrinsics.checkNotNullParameter(arg3, "view");
        int[] v0 = this.origin();
        this.place(arg3, arg4 + (((float)v0[0])), arg5 + (((float)v0[1])));
    }

    static final Unit onSurfaceChanged$lambda$0() {
        return Unit.INSTANCE;
    }

    private final int[] origin() {
        int[] v0 = new int[2];
        if(this.canvas.isAttachedToWindow()) {
            this.canvas.getLocationOnScreen(v0);
        }

        return v0;
    }

    public final void place(View arg6, float arg7, float arg8) {
        Intrinsics.checkNotNullParameter(arg6, "view");
        Pair v0 = this.size(arg6);
        int v1 = v0.component1().intValue();
        int v0_1 = v0.component2().intValue();
        float v3 = 3.402823E+38f;
        if(Math.abs(arg7) <= v3 && Math.abs(arg8) <= v3) {
            Pair v7 = this.constrain(arg7, arg8, v1, v0_1);
            this.centers.put(arg6, new Center(v7.getFirst().floatValue() + (((float)v1)) / 2f, v7.getSecond().floatValue() + (((float)v0_1)) / 2f));
            this.refresh(arg6);
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void recoverAccessories(View arg19, Rect arg20, int[] arg21) {
        float v7_1;
        int v9;
        String v8;
        Object v7;
        Object v6;
        EditorControlGeometry v0 = this;
        View v1 = arg19;
        View v2 = (v1 instanceof EditorHitRegionProvider) ? v1 : null;
        if(v2 == null) {
        }
        else if(v1.getWidth() > 0) {
            if(v1.getHeight() <= 0) {
            }
            else {
                List v2_1 = ((EditorHitRegionProvider)v2).editorHitRegions();
                ArrayList v4 = new ArrayList();
                Iterator v5 = ((Iterable)v2_1).iterator();
                while(v5.hasNext()) {
                    v6 = v5.next();
                    v7 = v6;
                    if(((EditorHitRegion)v7).getReceiver() == null) {
                        continue;
                    }

                    if(!v0.visible(v1, ((EditorHitRegion)v7).getView())) {
                        continue;
                    }

                    if(((EditorHitRegion)v7).getView().getWidth() <= 0) {
                        continue;
                    }

                    if(((EditorHitRegion)v7).getView().getHeight() <= 0) {
                        continue;
                    }

                    ((Collection)v4).add(v6);
                }

                if(((List)v4).isEmpty()) {
                }
                else {
                    ArrayList v5_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4), 10));
                    Iterator v6_1 = ((Iterable)v4).iterator();
                    while(true) {
                        v8 = "null cannot be cast to non-null type android.view.View";
                        v9 = 2;
                        if(v6_1.hasNext()) {
                            v7 = v6_1.next();
                            View v13 = ((EditorHitRegion)v7).getReceiver();
                            Intrinsics.checkNotNull(v13);
                            RectF v14 = new RectF(0f, 0f, ((float)((EditorHitRegion)v7).getView().getWidth()), ((float)((EditorHitRegion)v7).getView().getHeight()));
                            Matrix v3 = EditorHitDispatcher.Companion.matrixTo$app(v0.canvas, ((EditorHitRegion)v7).getView());
                            if(v3 == null) {
                            }
                            else {
                                v3.mapRect(v14);
                                float v3_1 = v13.getTranslationX();
                                v7_1 = v13.getTranslationY();
                                float[] v9_1 = new float[v9];
                                v9_1[0] = v3_1;
                                v9_1[1] = v7_1;
                                Companion v3_2 = EditorHitDispatcher.Companion;
                                ViewGroup v7_2 = v0.canvas;
                                ViewParent v10 = v13.getParent();
                                Intrinsics.checkNotNull(v10, v8);
                                v3 = v3_2.matrixTo$app(v7_2, ((View)v10));
                                if(v3 != null) {
                                    v3.mapVectors(v9_1);
                                    v14.offset(-v9_1[0], -v9_1[1]);
                                    ((Collection)v5_1).add(new Rect(v14.left, v14.top, v14.right, v14.bottom));
                                    continue;
                                }
                            }
                        }
                        else {
                            break;
                        }

                        return;
                    }

                    Rect v3_3 = new Rect(arg20.getLeft() - (((float)arg21[0])), arg20.getTop() - (((float)arg21[1])), arg20.getRight() - (((float)arg21[0])), arg20.getBottom() - (((float)arg21[1])));
                    Iterator v2_2 = ((Iterable)v2_1).iterator();
                    do {
                        if(v2_2.hasNext()) {
                            v6 = v2_2.next();
                            v7 = v6;
                            if(((EditorHitRegion)v7).getReceiver() != null) {
                                continue;
                            }

                            if(!((EditorHitRegion)v7).getVisibleFigure()) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_122;
                        }
                    }
                    while(true);

                    Object v17 = v6;
                    goto label_123;
                label_122:
                    v17 = null;
                label_123:
                    if(v17 == null) {
                        return;
                    }

                    RectF v2_3 = new RectF(0f, 0f, ((float)((EditorHitRegion)v17).getView().getWidth()), ((float)((EditorHitRegion)v17).getView().getHeight()));
                    Matrix v6_2 = EditorHitDispatcher.Companion.matrixTo$app(v0.canvas, ((EditorHitRegion)v17).getView());
                    if(v6_2 == null) {
                        return;
                    }

                    v6_2.mapRect(v2_3);
                    float v6_3 = v0.canvas.getResources().getDisplayMetrics().density * 24f;
                    v7_1 = v1.getX() + (((float)v1.getWidth())) / 2f;
                    float v10_1 = v1.getY() + (((float)v1.getHeight())) / 2f;
                    List v1_1 = EditorPositionPolicy.INSTANCE.accessories(v3_3, new Rect(Math.max(v2_3.left, v7_1 - v6_3), Math.max(v2_3.top, v10_1 - v6_3), Math.min(v2_3.right, v7_1 + v6_3), Math.min(v2_3.bottom, v10_1 + v6_3)), ((List)v5_1), v0.canvas.getResources().getDisplayMetrics().density * 4f);
                    v2_2 = ((Iterable)v4).iterator();
                    int v3_4;
                    for(v3_4 = 0; v2_2.hasNext(); v3_4 = v6_4) {
                        Object v4_1 = v2_2.next();
                        int v6_4 = v3_4 + 1;
                        if(v3_4 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }

                        View v4_2 = ((EditorHitRegion)v4_1).getReceiver();
                        Intrinsics.checkNotNull(v4_2);
                        Matrix v7_3 = new Matrix();
                        Companion v10_2 = EditorHitDispatcher.Companion;
                        ViewGroup v13_1 = v0.canvas;
                        ViewParent v14_1 = v4_2.getParent();
                        Intrinsics.checkNotNull(v14_1, v8);
                        Matrix v10_3 = v10_2.matrixTo$app(v13_1, ((View)v14_1));
                        if(v10_3 != null && (v10_3.invert(v7_3))) {
                            v10_1 = v1_1.get(v3_4).getLeft() - ((List)v5_1).get(v3_4).getLeft();
                            float v13_2 = v1_1.get(v3_4).getTop() - ((List)v5_1).get(v3_4).getTop();
                            float[] v3_5 = new float[v9];
                            v3_5[0] = v10_1;
                            v3_5[1] = v13_2;
                            v7_3.mapVectors(v3_5);
                            v4_2.setTranslationX(v3_5[0]);
                            v4_2.setTranslationY(v3_5[1]);
                        }
                    }
                }
            }
        }
    }

    public final void refresh() {
        Rect v0 = this.surface();
        if(v0 == null) {
        }
        else {
            int[] v1 = this.origin();
            Rect v2 = this.lastSurface;
            int v3 = 0;
            int v2_1 = v2 == null || (Intrinsics.areEqual(v2, v0)) ? 0 : 1;
            this.lastSurface = v0;
            int v4 = this.canvas.getChildCount();
            while(v3 < v4) {
                View v5 = this.canvas.getChildAt(v3);
                if((v5 instanceof ControlVisual)) {
                    this.refresh(v5, v0, v1);
                }

                ++v3;
            }

            if(v2_1 == 0) {
                return;
            }

            this.onSurfaceChanged.invoke();
        }
    }

    public final void refresh(View arg3) {
        Rect v0;
        Intrinsics.checkNotNullParameter(arg3, "view");
        if(arg3.getParent() != this.canvas) {
        }
        else {
            v0 = this.surface();
            if(v0 == null) {
                return;
            }

            goto label_9;
        }

        return;
    label_9:
        this.refresh(arg3, v0, this.origin());
    }

    private final void refresh(View arg11, Rect arg12, int[] arg13) {
        Pair v0 = this.size(arg11);
        int v5 = v0.component1().intValue();
        int v6 = v0.component2().intValue();
        WeakHashMap v0_1 = this.centers;
        Object v1 = ((Map)v0_1).get(arg11);
        float v8 = 2f;
        if(v1 == null) {
            Center v1_1 = new Center((arg12.getLeft() + arg12.getRight()) / v8, (arg12.getTop() + arg12.getBottom()) / v8);
            ((Map)v0_1).put(arg11, v1_1);
        }

        EditorPositionPolicy v2 = EditorPositionPolicy.INSTANCE;
        float v9 = (((float)v5)) / v8;
        float v3 = ((Center)v1).getX() - v9;
        float v0_2 = ((Center)v1).getY();
        float v1_2 = (((float)v6)) / v8;
        Rect v7 = arg12;
        Pair v12 = v2.position(v3, v0_2 - v1_2, v5, v6, v7);
        v0_2 = v12.getFirst().floatValue() + v9 - (((float)arg13[0]));
        Integer v2_1 = Integer.valueOf(arg11.getWidth());
        Integer v4 = null;
        if(v2_1.intValue() > 0) {
        }
        else {
            v2_1 = v4;
        }

        if(v2_1 != null) {
            v5 = v2_1.intValue();
        }

        arg11.setX(v0_2 - (((float)v5)) / v8);
        float v12_1 = v12.getSecond().floatValue() + v1_2 - (((float)arg13[1]));
        Integer v0_3 = Integer.valueOf(arg11.getHeight());
        if(v0_3.intValue() > 0) {
            v4 = v0_3;
        }

        if(v4 != null) {
            v6 = v4.intValue();
        }

        arg11.setY(v12_1 - (((float)v6)) / v8);
        this.recoverAccessories(arg11, v7, arg13);
    }

    public final void resizeAndPlaceLocal(View arg2, int arg3, int arg4, float arg5, float arg6) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        ViewGroup$LayoutParams v0 = arg2.getLayoutParams();
        v0.width = arg3;
        v0.height = arg4;
        arg2.setLayoutParams(v0);
        this.moveLocal(arg2, arg5, arg6);
    }

    public final void setOnSurfaceChanged(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onSurfaceChanged = arg2;
    }

    private final Pair size(View arg5) {
        Integer v4 = Integer.valueOf(arg5.getLayoutParams().width);
        Integer v1 = null;
        if(v4.intValue() > 0) {
        }
        else {
            v4 = v1;
        }

        int v4_1 = v4 != null ? v4.intValue() : arg5.getWidth();
        v4 = Integer.valueOf(RangesKt.coerceAtLeast(v4_1, 1));
        Integer v2 = Integer.valueOf(arg5.getLayoutParams().height);
        if(v2.intValue() > 0) {
            v1 = v2;
        }

        int v5 = v1 != null ? v1.intValue() : arg5.getHeight();
        return TuplesKt.to(v4, Integer.valueOf(RangesKt.coerceAtLeast(v5, 1)));
    }

    public final ControlVisualState snapshot(View arg11, boolean arg12) {
        Intrinsics.checkNotNullParameter(arg11, "view");
        this.refresh(arg11);
        ControlVisualState v1 = arg11.obtenerEstado();
        Pair v0 = this.size(arg11);
        int v5 = v0.component1().intValue();
        int v6 = v0.component2().intValue();
        int[] v0_1 = this.origin();
        Object v2 = this.centers.get(arg11);
        float v3 = 2f;
        float v4 = v2 != null ? ((Center)v2).getX() - (((float)v5)) / v3 : arg11.getX() + (((float)v0_1[0]));
        Float v4_1 = Float.valueOf(v4);
        float v11 = v2 != null ? ((Center)v2).getY() - (((float)v6)) / v3 : arg11.getY() + (((float)v0_1[1]));
        Pair v11_1 = TuplesKt.to(v4_1, Float.valueOf(v11));
        if(arg12) {
            v11_1 = this.constrain(v11_1.getFirst().floatValue(), v11_1.getSecond().floatValue(), v5, v6);
        }

        return ControlVisualState.copy$default(v1, null, v11_1.getFirst().floatValue(), v11_1.getSecond().floatValue(), v5, v6, null, 33, null);
    }

    public static ControlVisualState snapshot$default(EditorControlGeometry arg0, View arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.snapshot(arg1, true);
    }

    public final Rect surface() {
        int[] v0 = this.origin();
        Object v1 = this.screenSize.invoke();
        return EditorPositionPolicy.INSTANCE.surface(this.canvas.getWidth(), this.canvas.getHeight(), v0[0], v0[1], ((Pair)v1).getFirst().intValue(), ((Pair)v1).getSecond().intValue());
    }

    private final boolean visible(View arg2, View arg3) {
        do {
            if(arg3 == arg2) {
                return 1;
            }

            if(arg3.getVisibility() != 0) {
                return 0;
            }

            ViewParent v1 = arg3.getParent();
            if((v1 instanceof View)) {
            }
            else {
                v1 = null;
            }

            ViewParent v3 = v1;
        }
        while(v3 != null);

        return 0;
    }
}

