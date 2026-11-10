package com.TryJeanPc.goldenmouse.gamespace;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.TryJeanPc.goldenmouse.GameInfo;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$string;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u001A\u001A\u00020\n2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010+\u001A\u00020\nH\u0014J\b\u0010,\u001A\u00020\nH\u0002J\u0018\u0010-\u001A\u00020\n2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020/H\u0014J0\u00101\u001A\u00020\n2\u0006\u00102\u001A\u00020\"2\u0006\u00103\u001A\u00020/2\u0006\u00104\u001A\u00020/2\u0006\u00105\u001A\u00020/2\u0006\u00106\u001A\u00020/H\u0014J\u0010\u00107\u001A\u00020\n2\u0006\u00108\u001A\u000209H\u0014J\u0010\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020/H\u0002J\u000E\u0010=\u001A\u00020\n2\u0006\u0010>\u001A\u00020\"J\b\u0010?\u001A\u00020\nH\u0002J\b\u0010@\u001A\u00020\nH\u0002J\b\u0010A\u001A\u00020\nH\u0014R\"\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\"\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000ER\"\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000ER\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020*X\u0082.¢\u0006\u0002\n\u0000¨\u0006B"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenSpaceLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onAddGame", "Lkotlin/Function0;", "", "getOnAddGame", "()Lkotlin/jvm/functions/Function0;", "setOnAddGame", "(Lkotlin/jvm/functions/Function0;)V", "onSelectionChanged", "getOnSelectionChanged", "setOnSelectionChanged", "onCompactGameClick", "getOnCompactGameClick", "setOnCompactGameClick", "games", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "compactGrid", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid;", "submitGames", "profileWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "sceneScale", "", "sceneLeft", "sceneTop", "entered", "", "gamesReady", "sceneRunning", "entryAnimator", "Landroid/animation/ValueAnimator;", "carousel", "Landroidx/recyclerview/widget/RecyclerView;", "platform", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenPlatformView;", "onFinishInflate", "switchViewMode", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "bounds", "Landroid/graphics/RectF;", "id", "setRunning", "running", "startEntranceIfReady", "finishEntrance", "onDetachedFromWindow", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenSpaceLayout extends ViewGroup {
    public static final int $stable = 8;
    private RecyclerView carousel;
    private GoldenCompactGrid compactGrid;
    private boolean entered;
    private ValueAnimator entryAnimator;
    private List games;
    private boolean gamesReady;
    private Function0 onAddGame;
    private Function0 onCompactGameClick;
    private Function0 onSelectionChanged;
    private GoldenPlatformView platform;
    private WindowInsetsCompat profileWindowInsets;
    private float sceneLeft;
    private boolean sceneRunning;
    private float sceneScale;
    private float sceneTop;

    static {
    }

    public GoldenSpaceLayout(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenSpaceLayout(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenSpaceLayout(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.games = CollectionsKt.emptyList();
        this.sceneScale = 1f;
        this.setClipChildren(false);
        this.setClipToPadding(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new GoldenSpaceLayout$$ExternalSyntheticLambda4(this));
    }

    static final WindowInsetsCompat _init_$lambda$0(GoldenSpaceLayout arg3, View arg4, WindowInsetsCompat arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<unused var>");
        Intrinsics.checkNotNullParameter(arg5, "insets");
        if(!Intrinsics.areEqual(arg3.profileWindowInsets, arg5)) {
            arg3.profileWindowInsets = arg5;
            arg3.requestLayout();
        }

        Insets v4 = arg5.getInsets(Type.displayCutout() | Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(v4, "getInsets(...)");
        if(arg3.getPaddingLeft() == v4.left && arg3.getPaddingTop() == v4.top && arg3.getPaddingRight() == v4.right) {
            if(arg3.getPaddingBottom() != v4.bottom) {
            }
            else {
                return arg5;
            }
        }

        arg3.setPadding(v4.left, v4.top, v4.right, v4.bottom);
        return arg5;
    }

    public static final void access$finishEntrance(GoldenSpaceLayout arg0) {
        arg0.finishEntrance();
    }

    public static final ValueAnimator access$getEntryAnimator$p(GoldenSpaceLayout arg0) {
        return arg0.entryAnimator;
    }

    public static final GoldenPlatformView access$getPlatform$p(GoldenSpaceLayout arg0) {
        return arg0.platform;
    }

    public static final void access$setEntered$p(GoldenSpaceLayout arg0, boolean arg1) {
        arg0.entered = arg1;
    }

    private final RectF bounds(int arg6) {
        float v0 = 875f;
        float v1 = 2340f;
        float v2 = 225f;
        if(arg6 == id.gspace_carousel) {
            return new RectF(0f, v2, v1, v0);
        }

        if(arg6 == id.gspace_compact_grid) {
            return new RectF(105f, v2, 2235f, v0);
        }

        if(arg6 == id.gspace_logo) {
            return new RectF(705f, 0f, 1635f, 138f);
        }

        v0 = 129f;
        v2 = 39f;
        float v4 = 90f;
        if(arg6 == id.gspace_search) {
            return new RectF(v4, v2, 426f, v0);
        }

        if(arg6 == id.gspace_mode) {
            return new RectF(456f, v2, 546f, v0);
        }

        if(arg6 == id.gspace_profile) {
            return new RectF(2052f, 48f, 2132f, 120f);
        }

        v0 = 1042f;
        v2 = 970f;
        if(arg6 == id.gspace_fan) {
            return new RectF(v4, v2, 390f, v0);
        }

        if(arg6 == id.gspace_led) {
            return new RectF(1950f, v2, 2250f, v0);
        }

        return new RectF(0f, 0f, v1, 1080f);
    }

    protected void dispatchDraw(Canvas arg4) {
        Intrinsics.checkNotNullParameter(arg4, "canvas");
        arg4.save();
        arg4.clipRect(0, 0, this.getWidth(), this.getHeight());
        super.dispatchDraw(arg4);
        arg4.restore();
    }

    private final void finishEntrance() {
        RecyclerView v2_1;
        RecyclerView v0 = this.carousel;
        String v1 = "carousel";
        ValueAnimator v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((RecyclerView)v2);
        }

        LayoutManager v0_1 = v0.getLayoutManager();
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        ((GoldenCarouselLayoutManager)v0_1).setEntrance(0f);
        this.entryAnimator = v2;
        RecyclerView v4 = this.carousel;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
        }
        else {
            v2_1 = v4;
        }

        v2_1.requestLayout();
    }

    public final Function0 getOnAddGame() {
        return this.onAddGame;
    }

    public final Function0 getOnCompactGameClick() {
        return this.onCompactGameClick;
    }

    public final Function0 getOnSelectionChanged() {
        return this.onSelectionChanged;
    }

    protected void onDetachedFromWindow() {
        ValueAnimator v0 = this.entryAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        super.onDetachedFromWindow();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.findViewById(id.gspace_stage).setColorFilter(new ColorMatrixColorFilter(new float[]{0.18f, 0.58f, 0.12f, 0f, 0f, 0.16f, 0.46f, 0.1f, 0f, 0f, 0.14f, 0.3f, 0.08f, 0f, 0f, 0f, 0f, 0f, 1f, 0f}));
        View v0 = this.findViewById(id.gspace_platform);
        Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
        this.platform = ((GoldenPlatformView)v0);
        v0 = this.findViewById(id.gspace_carousel);
        Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
        this.carousel = ((RecyclerView)v0);
        GoldenCarouselLayoutManager v0_1 = new GoldenCarouselLayoutManager();
        float v1 = this.isInEditMode() ? 0f : 1f;
        v0_1.setEntrance(v1);
        v0_1.setOnSelectionChanged(new GoldenSpaceLayout$$ExternalSyntheticLambda0(this));
        RecyclerView v1_1 = this.carousel;
        String v2 = "carousel";
        ItemAnimator v3 = null;
        if(v1_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v1_1 = ((RecyclerView)v3);
        }

        v1_1.setLayoutManager(v0_1);
        v1_1 = this.carousel;
        if(v1_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v1_1 = ((RecyclerView)v3);
        }

        Context v5 = this.getContext();
        Intrinsics.checkNotNullExpressionValue(v5, "getContext(...)");
        v1_1.setAdapter(new GoldenGameAdapter(v5, new GoldenSpaceLayout$$ExternalSyntheticLambda1(this)));
        v1_1 = this.carousel;
        if(v1_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v1_1 = ((RecyclerView)v3);
        }

        v1_1.setItemAnimator(v3);
        v1_1 = this.carousel;
        if(v1_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v1_1 = ((RecyclerView)v3);
        }

        v1_1.setHasFixedSize(true);
        v1_1 = this.carousel;
        if(v1_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            RecyclerView v3_1 = v1_1;
        }

        ((RecyclerView)v3).addOnScrollListener(new GoldenSpaceLayout$onFinishInflate$2(this, v0_1));
        this.findViewById(id.gspace_fan).setSelected(true);
        this.findViewById(id.gspace_shark_grid).setOnClickListener(new GoldenSpaceLayout$$ExternalSyntheticLambda2(this));
    }

    static final Unit onFinishInflate$lambda$2$lambda$1(GoldenSpaceLayout arg0) {
        Function0 v0 = arg0.onSelectionChanged;
        if(v0 != null) {
            v0.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit onFinishInflate$lambda$3(GoldenSpaceLayout arg0) {
        Function0 v0 = arg0.onAddGame;
        if(v0 != null) {
            v0.invoke();
        }

        return Unit.INSTANCE;
    }

    static final void onFinishInflate$lambda$4(GoldenSpaceLayout arg0, View arg1) {
        arg0.switchViewMode();
    }

    protected void onLayout(boolean arg17, int arg18, int arg19, int arg20, int arg21) {
        RecyclerView v10;
        List v12_4;
        float v6_4;
        View v6_2;
        RecyclerView v6_1;
        int v5_1;
        int v6;
        GoldenSpaceLayout v0 = this;
        int v1 = v0.getChildCount();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            View v4 = v0.getChildAt(v3);
            if(v4.getId() == id.gspace_shark_grid) {
                float v5 = v0.getResources().getDisplayMetrics().density;
                v6 = MathKt.roundToInt((((float)(v0.getMeasuredWidth() - v0.getPaddingRight()))) - 36.360001f * v5);
                v5_1 = MathKt.roundToInt((((float)(v0.getMeasuredHeight() - v0.getPaddingBottom()))) - v5 * 18.18f);
                v4.layout(v6 - v4.getMeasuredWidth(), v5_1 - v4.getMeasuredHeight(), v6, v5_1);
            }
            else if(v4.getId() == id.gspace_topbar) {
                v4.layout(0, 0, v4.getMeasuredWidth(), v4.getMeasuredHeight());
            }
            else if(v4.getId() == id.gspace_stage) {
                v4.layout(0, 0, v0.getMeasuredWidth(), v0.getMeasuredHeight());
            }
            else {
                RectF v5_2 = v0.bounds(v4.getId());
                String v8 = "platform";
                String v9 = "carousel";
                if(v4.getId() == id.gspace_fan || v4.getId() == id.gspace_led) {
                    v6 = MathKt.roundToInt((((float)(v0.getMeasuredHeight() - v0.getPaddingBottom()))) - (1080f - v5_2.top) * v0.sceneScale);
                }
                else {
                    v6_1 = v0.carousel;
                    if(v6_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v9);
                        v6_2 = null;
                    }

                    if(v4 != (((View)v6_1))) {
                        GoldenPlatformView v6_3 = v0.platform;
                        if(v6_3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v8);
                            v6_2 = null;
                        }

                        if(v4 == v6_2) {
                            goto label_75;
                        }

                        if(v4 == v0.compactGrid) {
                            goto label_75;
                        }

                        v6_4 = ((float)v0.getPaddingTop());
                    }
                    else {
                    label_75:
                        v6_4 = v0.sceneTop;
                    }

                    v6 = MathKt.roundToInt(v6_4 + v5_2.top * v0.sceneScale);
                }

                int v7 = v4.getId();
                int v12 = 2;
                if(v7 == id.gspace_profile) {
                    v5_1 = MathKt.roundToInt(v0.getResources().getDisplayMetrics().density * 10f);
                    int[] v7_1 = new int[v12];
                    v0.getLocationInWindow(v7_1);
                    int v11 = v0.getMeasuredWidth() - v5_1;
                    WindowInsetsCompat v12_1 = v0.profileWindowInsets;
                    if(v12_1 != null) {
                        Insets v12_2 = v12_1.getInsets(Type.systemBars());
                        if(v12_2 != null) {
                            v12 = v12_2.right;
                        }
                        else {
                            goto label_114;
                        }
                    }
                    else {
                    label_114:
                        v12 = 0;
                    }

                    v11 -= v12;
                    v12_1 = v0.profileWindowInsets;
                    if(v12_1 != null) {
                        DisplayCutoutCompat v12_3 = v12_1.getDisplayCutout();
                        if(v12_3 != null) {
                            v12_4 = v12_3.getBoundingRects();
                        }
                        else {
                            goto label_122;
                        }
                    }
                    else {
                    label_122:
                        v12_4 = null;
                    }

                    if(v12_4 == null) {
                        v12_4 = CollectionsKt.emptyList();
                    }

                    Iterator v12_5 = CollectionsKt.sortedWith(((Iterable)v12_4), new GoldenSpaceLayout$onLayout$$inlined$sortedByDescending$1()).iterator();
                    while(v12_5.hasNext()) {
                        Object v13 = v12_5.next();
                        if(v7_1[1] + v6 >= ((Rect)v13).bottom) {
                            continue;
                        }

                        if(v4.getMeasuredHeight() + v6 + v7_1[1] <= ((Rect)v13).top) {
                            continue;
                        }

                        if(v7_1[0] + v11 <= ((Rect)v13).left) {
                            continue;
                        }

                        if(v11 - v4.getMeasuredWidth() + v7_1[0] >= ((Rect)v13).right) {
                            continue;
                        }

                        v11 = ((Rect)v13).left - v7_1[0] - v5_1;
                    }

                    v5_1 = RangesKt.coerceAtLeast(v11 - v4.getMeasuredWidth(), 0);
                }
                else {
                    if(v7 == id.gspace_carousel) {
                        v5_1 = 0;
                        goto label_179;
                    }

                    if(v7 == id.gspace_platform) {
                        v5_1 = (v0.getMeasuredWidth() - v4.getMeasuredWidth()) / v12;
                        goto label_179;
                    }

                    v5_1 = MathKt.roundToInt(v0.sceneLeft + v5_2.left * v0.sceneScale);
                }

            label_179:
                GoldenPlatformView v7_2 = v0.platform;
                if(v7_2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v8);
                    View v7_3 = null;
                }

                float v7_4 = v4 == (((View)v7_2)) ? (((float)(v0.getMeasuredWidth() - v4.getMeasuredWidth()))) / 2f - (((float)v5_1)) : 0f;
                v4.setTranslationX(v7_4);
                v4.layout(v5_1, v6, v4.getMeasuredWidth() + v5_1, v4.getMeasuredHeight() + v6);
                RecyclerView v5_3 = v0.carousel;
                if(v5_3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    View v5_4 = null;
                }

                if(v4 != (((View)v5_3))) {
                    goto label_225;
                }

                RecyclerView v4_1 = v0.carousel;
                if(v4_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v4_1 = null;
                }

                v6_1 = v0.carousel;
                if(v6_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v6_1 = null;
                }

                v6 = v6_1.getWidth();
                RecyclerView v7_5 = v0.carousel;
                if(v7_5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v10 = null;
                }
                else {
                    v10 = v7_5;
                }

                v4_1.setClipBounds(new Rect(0, 0, v6, v10.getHeight()));
            }

        label_225:
        }

        v0.startEntranceIfReady();
    }

    protected void onMeasure(int arg10, int arg11) {
        View v6_1;
        arg10 = View$MeasureSpec.getSize(arg10);
        arg11 = View$MeasureSpec.getSize(arg11);
        this.setMeasuredDimension(arg10, arg11);
        this.sceneScale = CarouselGeometry.INSTANCE.fit(((float)(arg10 - this.getPaddingLeft() - this.getPaddingRight())), ((float)(arg11 - this.getPaddingTop() - this.getPaddingBottom())));
        this.sceneLeft = (((float)this.getPaddingLeft())) + ((((float)(arg10 - this.getPaddingLeft() - this.getPaddingRight()))) - this.sceneScale * 2340f) / 2f;
        float v0 = RangesKt.coerceAtLeast((((float)(arg11 - this.getPaddingTop() - this.getPaddingBottom()))) - this.sceneScale * 1080f, 0f) / 2f;
        this.sceneTop = (((float)this.getPaddingTop())) + v0 - Math.min(v0, this.bounds(id.gspace_logo).height() * this.sceneScale / 2f);
        RecyclerView v0_1 = this.carousel;
        RecyclerView v1 = null;
        String v2 = "carousel";
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0_1 = v1;
        }

        LayoutManager v0_2 = v0_1.getLayoutManager();
        Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        ((GoldenCarouselLayoutManager)v0_2).setSceneScale(this.sceneScale);
        int v0_3 = this.getChildCount();
        int v3;
        for(v3 = 0; v3 < v0_3; ++v3) {
            View v4 = this.getChildAt(v3);
            int v7 = 0x40000000;
            if(v4.getId() == id.gspace_shark_grid) {
                int v5 = MathKt.roundToInt(this.getResources().getDisplayMetrics().density * 43.639999f);
                v4.measure(View$MeasureSpec.makeMeasureSpec(v5, v7), View$MeasureSpec.makeMeasureSpec(v5, v7));
            }
            else if(v4.getId() == id.gspace_topbar) {
                v4.measure(View$MeasureSpec.makeMeasureSpec(arg10, v7), View$MeasureSpec.makeMeasureSpec(MathKt.roundToInt(this.getResources().getDisplayMetrics().density * 64f), v7));
            }
            else if(v4.getId() == id.gspace_stage) {
                v4.measure(View$MeasureSpec.makeMeasureSpec(arg10, v7), View$MeasureSpec.makeMeasureSpec(arg11, v7));
            }
            else {
                RectF v5_1 = this.bounds(v4.getId());
                RecyclerView v6 = this.carousel;
                if(v6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v6_1 = ((View)v1);
                }

                int v6_2 = v4 == v6_1 ? arg10 : MathKt.roundToInt(v5_1.width() * this.sceneScale);
                v4.measure(View$MeasureSpec.makeMeasureSpec(v6_2, v7), View$MeasureSpec.makeMeasureSpec(MathKt.roundToInt(v5_1.height() * this.sceneScale), v7));
            }
        }
    }

    public final void setOnAddGame(Function0 arg1) {
        this.onAddGame = arg1;
    }

    public final void setOnCompactGameClick(Function0 arg1) {
        this.onCompactGameClick = arg1;
    }

    public final void setOnSelectionChanged(Function0 arg1) {
        this.onSelectionChanged = arg1;
    }

    public final void setRunning(boolean arg3) {
        GoldenPlatformView v0 = this.platform;
        if(v0 == null) {
        }
        else {
            RecyclerView v1 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platform");
                v0 = ((GoldenPlatformView)v1);
            }

            v0.setRunning(arg3);
            this.sceneRunning = arg3;
            if((arg3) && !this.entered) {
                this.requestLayout();
            }

            if(arg3) {
                return;
            }

            this.entered = true;
            ValueAnimator v3 = this.entryAnimator;
            if(v3 != null) {
                v3.cancel();
            }

            this.finishEntrance();
            RecyclerView v2 = this.carousel;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carousel");
            }
            else {
                v1 = v2;
            }

            v1.stopScroll();
        }
    }

    private final void startEntranceIfReady() {
        if(!this.entered && (this.sceneRunning) && (this.gamesReady) && !this.isInEditMode()) {
            RecyclerView v0 = this.carousel;
            RecyclerView v1 = null;
            String v2 = "carousel";
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0 = v1;
            }

            if(v0.getChildCount() == 0) {
                return;
            }

            v0 = this.carousel;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0 = v1;
            }

            if(v0.hasPendingAdapterUpdates()) {
                return;
            }

            this.entered = true;
            v0 = this.carousel;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
            }
            else {
                v1 = v0;
            }

            LayoutManager v0_1 = v1.getLayoutManager();
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
            ValueAnimator v1_1 = ValueAnimator.ofFloat(new float[]{1f, 0f});
            v1_1.setDuration(320);
            v1_1.setInterpolator(new PathInterpolator(0.3f, 0.1f, 0.3f, 1f));
            v1_1.addUpdateListener(new GoldenSpaceLayout$$ExternalSyntheticLambda3(((GoldenCarouselLayoutManager)v0_1)));
            v1_1.addListener(new GoldenSpaceLayout$startEntranceIfReady$1$2(this));
            this.entryAnimator = v1_1;
            if(v1_1 == null) {
                return;
            }

            v1_1.start();
        }
    }

    static final void startEntranceIfReady$lambda$10$lambda$9(GoldenCarouselLayoutManager arg1, ValueAnimator arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        Object v2 = arg2.getAnimatedValue();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Float");
        arg1.setEntrance(((Float)v2).floatValue());
    }

    public final void submitGames(List arg5) {
        Intrinsics.checkNotNullParameter(arg5, "games");
        RecyclerView v0 = this.carousel;
        RecyclerView v1 = null;
        String v2 = "carousel";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0.stopScroll();
        v0 = this.carousel;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        Adapter v0_1 = v0.getAdapter();
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameAdapter");
        RecyclerView v3 = this.carousel;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v3;
        }

        LayoutManager v1_1 = v1.getLayoutManager();
        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        v2 = ((GoldenGameAdapter)v0_1).keyAt(((GoldenCarouselLayoutManager)v1_1).getSelectedPosition());
        ((GoldenGameAdapter)v0_1).submitGames(arg5);
        ((GoldenCarouselLayoutManager)v1_1).retainSelection(((GoldenGameAdapter)v0_1).positionOf(v2));
        this.games = arg5;
        GoldenCompactGrid v0_2 = this.compactGrid;
        if(v0_2 != null) {
            v0_2.submitGames(arg5);
        }

        this.gamesReady = true;
        if(!this.entered) {
            this.requestLayout();
        }
    }

    private final void switchViewMode() {
        RecyclerView v0 = this.carousel;
        String v1 = "carousel";
        RecyclerView v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = v2;
        }

        LayoutManager v0_1 = v0.getLayoutManager();
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenCarouselLayoutManager");
        if(this.gamesReady) {
            RecyclerView v3 = this.carousel;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = v2;
            }

            if(v3.hasPendingAdapterUpdates()) {
                return;
            }

            if(((GoldenCarouselLayoutManager)v0_1).getEntrance() != 0f) {
                return;
            }

            v3 = this.carousel;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = v2;
            }

            if(v3.getScrollState() != 0) {
                return;
            }

            GoldenCompactGrid v3_1 = this.compactGrid;
            if(v3_1 == null) {
                v3 = this.carousel;
                if(v3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v3 = v2;
                }

                Adapter v3_2 = v3.getAdapter();
                Intrinsics.checkNotNull(v3_2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameAdapter");
                GameInfo v4 = ((GoldenGameAdapter)v3_2).gameAt(((GoldenCarouselLayoutManager)v0_1).getSelectedPosition());
                String v4_1 = v4 != null ? v4.getPackageName() : ((String)v2);
                Context v6 = this.getContext();
                Intrinsics.checkNotNullExpressionValue(v6, "getContext(...)");
                GoldenCompactGrid v5 = new GoldenCompactGrid(v6, this.games, v4_1, new GoldenSpaceLayout$$ExternalSyntheticLambda5(this, ((GoldenGameAdapter)v3_2), ((GoldenCarouselLayoutManager)v0_1)));
                v5.setId(id.gspace_compact_grid);
                v0 = this.carousel;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v0 = v2;
                }

                v5.setElevation(v0.getElevation());
                this.addView(v5);
                this.compactGrid = v5;
                v0 = this.carousel;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                }
                else {
                    v2 = v0;
                }

                v2.setVisibility(4);
            }
            else {
                v3_1.release();
                this.removeView(((View)v3_1));
                this.compactGrid = ((GoldenCompactGrid)v2);
                v0 = this.carousel;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                }
                else {
                    v2 = v0;
                }

                v2.setVisibility(0);
            }

            View v0_2 = this.findViewById(id.gspace_shark_grid);
            Context v1_1 = this.getContext();
            int v9 = this.compactGrid == null ? string.gspace_show_grid : string.gspace_show_carousel;
            v0_2.setContentDescription(v1_1.getString(v9));
        }
    }

    static final Unit switchViewMode$lambda$5(GoldenSpaceLayout arg2, GoldenGameAdapter arg3, GoldenCarouselLayoutManager arg4, GameInfo arg5) {
        Function0 v2;
        if(arg5 == null) {
            v2 = arg2.onAddGame;
            if(v2 != null) {
                v2.invoke();
            }
        }
        else {
            int v0 = arg3.positionOf(arg5.getPackageName());
            GameInfo v3 = arg3.gameAt(Integer.valueOf(v0));
            if(v3 != null) {
                String v3_1 = v3.getPackageName();
            }
            else {
                Object v3_2 = null;
            }

            if(!Intrinsics.areEqual(v3_2, arg5.getPackageName())) {
                goto label_20;
            }

            arg4.retainSelection(v0);
            v2 = arg2.onCompactGameClick;
            if(v2 == null) {
                goto label_20;
            }

            v2.invoke();
        }

    label_20:
        return Unit.INSTANCE;
    }
}

