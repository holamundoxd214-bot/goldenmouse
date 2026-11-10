package com.TryJeanPc.goldenmouse.gamespace;

import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001A\u00020%H\u0016J\b\u0010&\u001A\u00020\'H\u0016J\u001C\u0010(\u001A\u00020\u00062\n\u0010)\u001A\u00060*R\u00020+2\u0006\u0010,\u001A\u00020-H\u0016J\b\u0010.\u001A\u00020\u0006H\u0002J$\u0010/\u001A\u00020\u00112\u0006\u00100\u001A\u00020\u00112\n\u0010)\u001A\u00060*R\u00020+2\u0006\u0010,\u001A\u00020-H\u0016J \u00101\u001A\u00020\u00062\u0006\u00102\u001A\u00020+2\u0006\u0010,\u001A\u00020-2\u0006\u00103\u001A\u00020\u0011H\u0016J\u000E\u00104\u001A\u00020\u00062\u0006\u00102\u001A\u00020+J\u000E\u00105\u001A\u00020\u00062\u0006\u00106\u001A\u00020\u0011R\"\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0015@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u001D\u001A\u00020\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0018\"\u0004\b\u001F\u0010\u001AR\u0014\u0010 \u001A\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0018R\u0014\u0010\"\u001A\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0018¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCarouselLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "<init>", "()V", "onSelectionChanged", "Lkotlin/Function0;", "", "getOnSelectionChanged", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionChanged", "(Lkotlin/jvm/functions/Function0;)V", "onGameClick", "getOnGameClick", "setOnGameClick", "position", "", "selectedPosition", "", "getSelectedPosition", "()Ljava/lang/Integer;", "value", "", "entrance", "getEntrance", "()F", "setEntrance", "(F)V", "rebound", "Landroid/view/animation/PathInterpolator;", "sceneScale", "getSceneScale", "setSceneScale", "scale", "getScale", "stride", "getStride", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollHorizontally", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "applyEntrance", "scrollHorizontallyBy", "dx", "smoothScrollToPosition", "view", "target", "snap", "retainSelection", "index", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCarouselLayoutManager extends LayoutManager {
    public static final int $stable = 8;
    private float entrance;
    private Function0 onGameClick;
    private Function0 onSelectionChanged;
    private double position;
    private final PathInterpolator rebound;
    private float sceneScale;

    static {
    }

    public GoldenCarouselLayoutManager() {
        super();
        this.rebound = new PathInterpolator(0.3f, 0.13f, 0.58f, 1f);
        this.sceneScale = 1f;
    }

    public static final double access$getPosition$p(GoldenCarouselLayoutManager arg2) {
        return arg2.position;
    }

    private final void applyEntrance() {
        if(this.getChildCount() == 0) {
        }
        else {
            float v7 = ((float)MathKt.roundToInt(this.getScale() * 1056f));
            float v8 = Math.max(this.getStride(), CarouselGeometry.INSTANCE.sideStride(((float)this.getWidth()), v7) + this.entrance * 400f * this.getScale());
            int v0 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                View v2 = this.getChildAt(v1);
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameCardView");
                float v5 = ((GoldenGameCardView)v2).getOffset();
                ((GoldenGameCardView)v2).setTranslationX(CarouselGeometry.INSTANCE.cardLeft(v5, ((float)this.getWidth()), v7, v8, this.getScale(), this.getItemCount()) - (((float)((GoldenGameCardView)v2).getLeft())));
                float v4 = 0f;
                float v6 = 1f;
                float v3 = RangesKt.coerceIn(3f - Math.abs(v5), 0f, v6);
                float v10 = 0.5f;
                if(Math.abs(v5) < v10) {
                    v6 -= this.entrance;
                }

                ((GoldenGameCardView)v2).setAlpha(v3 * v6);
                if(Math.abs(v5) < v10) {
                    v4 = this.getScale() * 100f * this.entrance;
                }

                ((GoldenGameCardView)v2).setTranslationY(v4);
            }
        }
    }

    public boolean canScrollHorizontally() {
        if(this.getItemCount() > 1) {
            return 1;
        }

        return 0;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public final float getEntrance() {
        return this.entrance;
    }

    public final Function0 getOnGameClick() {
        return this.onGameClick;
    }

    public final Function0 getOnSelectionChanged() {
        return this.onSelectionChanged;
    }

    private final float getScale() {
        return this.sceneScale;
    }

    public final float getSceneScale() {
        return this.sceneScale;
    }

    public final Integer getSelectedPosition() {
        return CarouselSelectionChanges.INSTANCE.selectedIndex(this.position, this.getItemCount());
    }

    private final float getStride() {
        return (this.entrance * 400f + 1110f) * this.getScale();
    }

    public void onLayoutChildren(Recycler arg14, State arg15) {
        Intrinsics.checkNotNullParameter(arg14, "recycler");
        Intrinsics.checkNotNullParameter(arg15, "state");
        if(arg15.isPreLayout()) {
            return;
        }

        if(this.getItemCount() != 0 && this.getWidth() != 0) {
            if(this.getHeight() == 0) {
            }
            else {
                this.position = CarouselGeometry.INSTANCE.wrapPosition(this.position, this.getItemCount());
                this.detachAndScrapAttachedViews(arg14);
                int v15 = MathKt.roundToInt(this.getScale() * 1056f);
                int v0 = MathKt.roundToInt(this.getScale() * 570f);
                float v7 = ((float)v15);
                float v8 = Math.max(this.getStride(), CarouselGeometry.INSTANCE.sideStride(((float)this.getWidth()), v7) + this.entrance * 400f * this.getScale());
                Iterator v1 = CollectionsKt.sortedWith(CarouselGeometry.INSTANCE.layoutSlots(this.position, this.getItemCount()), new GoldenCarouselLayoutManager$onLayoutChildren$$inlined$sortedByDescending$1(this)).iterator();
                while(true) {
                    float v3 = 0f;
                    if(!v1.hasNext()) {
                        break;
                    }

                    int v2 = v1.next().intValue();
                    float v5 = ((float)((((double)v2)) - this.position));
                    float v4 = CarouselGeometry.INSTANCE.cardLeft(v5, ((float)this.getWidth()), v7, v8, this.getScale(), this.getItemCount());
                    Pair v6 = CarouselGeometry.INSTANCE.projectedEdges(v5, v4, v7);
                    if(v6.getSecond().floatValue() < this.getScale() * -18f) {
                        continue;
                    }

                    if(v6.getFirst().floatValue() > (((float)this.getWidth())) + this.getScale() * 18f) {
                    }
                    else {
                        v2 = CarouselGeometry.INSTANCE.wrap(v2, this.getItemCount());
                        View v6_1 = arg14.getViewForPosition(v2);
                        Intrinsics.checkNotNull(v6_1, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameCardView");
                        this.addView(v6_1);
                        ((GoldenGameCardView)v6_1).measure(View$MeasureSpec.makeMeasureSpec(v15, 0x40000000), View$MeasureSpec.makeMeasureSpec(v0, 0x40000000));
                        int v9 = MathKt.roundToInt(v4);
                        int v10 = (this.getHeight() - v0) / 2;
                        ((GoldenGameCardView)v6_1).layout(v9, v10, v9 + v15, v10 + v0);
                        ((GoldenGameCardView)v6_1).setTranslationX(v4 - (((float)v9)));
                        ((GoldenGameCardView)v6_1).setElevation(RangesKt.coerceAtLeast(3f - Math.abs(v5), 0f) * 4f * this.getScale());
                        v4 = 1f;
                        ((GoldenGameCardView)v6_1).setAlpha(RangesKt.coerceIn(3f - Math.abs(v5), 0f, v4));
                        float v10_1 = 0.5f;
                        if(Math.abs(v5) < v10_1) {
                            ((GoldenGameCardView)v6_1).setAlpha(((GoldenGameCardView)v6_1).getAlpha() * (v4 - this.entrance));
                        }

                        if(Math.abs(v5) < v10_1) {
                            v3 = this.entrance * (this.getScale() * 100f);
                        }

                        ((GoldenGameCardView)v6_1).setTranslationY(v3);
                        ((GoldenGameCardView)v6_1).updateOffset(v5);
                        ((GoldenGameCardView)v6_1).setOnClickListener(new GoldenCarouselLayoutManager$$ExternalSyntheticLambda0(((GoldenGameCardView)v6_1), this, v2));
                    }
                }

                List v15_1 = arg14.getScrapList();
                Intrinsics.checkNotNullExpressionValue(v15_1, "getScrapList(...)");
                Iterator v15_2 = CollectionsKt.toList(((Iterable)v15_1)).iterator();
                while(v15_2.hasNext()) {
                    arg14.recycleView(v15_2.next().itemView);
                }

                if(this.entrance == 0f) {
                    return;
                }

                this.applyEntrance();
                return;
            }
        }

        this.removeAndRecycleAllViews(arg14);
    }

    static final void onLayoutChildren$lambda$1(GoldenGameCardView arg2, GoldenCarouselLayoutManager arg3, int arg4, View arg5) {
        ViewParent v5 = arg2.getParent();
        if((v5 instanceof RecyclerView)) {
        }
        else {
            v5 = null;
        }

        if(v5 == null) {
        }
        else if(((RecyclerView)v5).getScrollState() == 0 && arg3.entrance == 0f) {
            if(((RecyclerView)v5).hasPendingAdapterUpdates()) {
            }
            else if(Math.abs(arg2.getOffset()) >= 0.01f) {
                ((RecyclerView)v5).smoothScrollToPosition(arg4);
                return;
            }
            else {
                Adapter v2 = ((RecyclerView)v5).getAdapter();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.gamespace.GoldenGameAdapter");
                if(arg4 == 0) {
                    ((GoldenGameAdapter)v2).getOnAddGame().invoke();
                    return;
                }
                else if(((GoldenGameAdapter)v2).gameAt(Integer.valueOf(arg4)) != null) {
                    Function0 v2_1 = arg3.onGameClick;
                    if(v2_1 != null) {
                        v2_1.invoke();
                    }
                }
            }
        }
    }

    public final void retainSelection(int arg8) {
        this.position = CarouselGeometry.INSTANCE.wrapPosition((((double)arg8)) + (this.position - (((double)MathKt.roundToInt(this.position)))), this.getItemCount());
        this.requestLayout();
    }

    public int scrollHorizontallyBy(int arg18, Recycler arg19, State arg20) {
        GoldenCarouselLayoutManager v0 = this;
        Recycler v1 = arg19;
        State v2 = arg20;
        Intrinsics.checkNotNullParameter(v1, "recycler");
        Intrinsics.checkNotNullParameter(v2, "state");
        int v4 = 2;
        if(v0.getItemCount() >= v4) {
            if(v0.getStride() <= 0f) {
            }
            else {
                int v3 = arg18;
                double v9 = v0.position + (((double)v3)) / (((double)v0.getStride()));
                if(v0.getItemCount() == v4) {
                    v9 = RangesKt.coerceIn(v9, 0, 1);
                }

                double v14 = v9;
                if(v0.getItemCount() == v4) {
                    v3 = MathKt.roundToInt((v14 - v0.position) * (((double)v0.getStride())));
                }

                List v4_1 = CarouselSelectionChanges.INSTANCE.indices(v0.position, v14, v0.getItemCount());
                v0.position = CarouselGeometry.INSTANCE.wrapPosition(v14, v0.getItemCount());
                v0.onLayoutChildren(v1, v2);
                Iterator v1_1 = ((Iterable)v4_1).iterator();
                while(v1_1.hasNext()) {
                    v1_1.next().intValue();
                    Function0 v2_1 = v0.onSelectionChanged;
                    if(v2_1 == null) {
                        continue;
                    }

                    v2_1.invoke();
                }

                return v3;
            }
        }

        return 0;
    }

    public final void setEntrance(float arg1) {
        this.entrance = arg1;
        this.applyEntrance();
    }

    public final void setOnGameClick(Function0 arg1) {
        this.onGameClick = arg1;
    }

    public final void setOnSelectionChanged(Function0 arg1) {
        this.onSelectionChanged = arg1;
    }

    public final void setSceneScale(float arg1) {
        this.sceneScale = arg1;
    }

    public void smoothScrollToPosition(RecyclerView arg5, State arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "view");
        Intrinsics.checkNotNullParameter(arg6, "state");
        if(this.getItemCount() == 0) {
            return;
        }

        double v6 = (((double)CarouselGeometry.INSTANCE.wrap(arg7, this.getItemCount()))) - this.position;
        double v2 = 2;
        if(v6 > (((double)this.getItemCount())) / v2) {
            v6 -= ((double)this.getItemCount());
        }

        if(v6 < (((double)(-this.getItemCount()))) / v2) {
            v6 += ((double)this.getItemCount());
        }

        arg5.smoothScrollBy(MathKt.roundToInt(v6 * (((double)this.getStride()))), 0, this.rebound);
    }

    public final void snap(RecyclerView arg5) {
        Intrinsics.checkNotNullParameter(arg5, "view");
        if(this.getStride() > 0f) {
            if(this.getItemCount() < 2) {
            }
            else {
                int v0 = MathKt.roundToInt(((((double)MathKt.roundToInt(this.position))) - this.position) * (((double)this.getStride())));
                if(Math.abs(v0) > 1) {
                    arg5.smoothScrollBy(v0, 0, this.rebound);
                }
            }
        }
    }
}

