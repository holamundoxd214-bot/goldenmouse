package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager$SimpleOnPageChangeListener;
import androidx.viewpager.widget.ViewPager;
import com.TryJeanPc.goldenmouse.GameInfo;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001:\u0003%&\'B=\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0014\u0010\t\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0015\u001A\u00020\u000B2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0006\u0010\u001A\u001A\u00020\u000BJ\u0018\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u0019H\u0014J0\u0010\u001E\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020\u00192\u0006\u0010$\u001A\u00020\u0019H\u0014R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000E\u001A\n \u0010*\u0004\u0018\u00010\u000F0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001A\n \u0010*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "games", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "selectedPackage", "", "onItemClick", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "content", "Landroid/view/View;", "kotlin.jvm.PlatformType", "pager", "Landroidx/viewpager/widget/ViewPager;", "indicator", "Lcom/TryJeanPc/goldenmouse/gamespace/RedMagicIndicatorView;", "submitGames", "value", "updateIndicator", "page", "", "release", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "Pages", "Card", "Cards", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCompactGrid extends ViewGroup {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid$Card;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Card extends ViewHolder {
        private final ImageView icon;
        private final TextView name;

        public Card(View arg3) {
            Intrinsics.checkNotNullParameter(arg3, "view");
            super(arg3);
            View v0 = arg3.findViewById(id.gspace_compact_icon);
            Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
            this.icon = ((ImageView)v0);
            arg3 = arg3.findViewById(id.gspace_compact_name);
            Intrinsics.checkNotNullExpressionValue(arg3, "findViewById(...)");
            this.name = ((TextView)arg3);
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final TextView getName() {
            return this.name;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0004H\u0016J\u0018\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0004H\u0016J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0004H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid$Cards;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid$Card;", "page", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid;I)V", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Cards extends Adapter {
        private final int page;

        public Cards(GoldenCompactGrid arg1, int arg2) {
            GoldenCompactGrid.this = arg1;
            super();
            this.page = arg2;
        }

        public int getItemCount() {
            return Math.min(9, GoldenCompactGrid.this.games.size() + 1 - this.page * 9);
        }

        public void onBindViewHolder(ViewHolder arg1, int arg2) {
            this.onBindViewHolder(((Card)arg1), arg2);
        }

        public void onBindViewHolder(Card arg4, int arg5) {
            String v1;
            Intrinsics.checkNotNullParameter(arg4, "holder");
            Object v5 = CollectionsKt.getOrNull(GoldenCompactGrid.this.games, arg5 + this.page * 9);
            TextView v0 = arg4.getName();
            if(v5 != null) {
                v1 = ((GameInfo)v5).getName();
                if(v1 != null) {
                }
                else {
                    goto label_13;
                }
            }
            else {
            label_13:
                v1 = GoldenCompactGrid.this.getContext().getString(string.gspace_add_game);
                Intrinsics.checkNotNullExpressionValue(v1, "getString(...)");
            }

            v0.setText(((CharSequence)v1));
            if(v5 == null) {
                arg4.getIcon().setImageResource(drawable.gspace_rm_add_game_icon);
            }
            else {
                arg4.getIcon().setImageDrawable(((GameInfo)v5).getIcon());
            }

            arg4.itemView.setContentDescription(arg4.getName().getText());
            arg4.itemView.setOnClickListener(new GoldenCompactGrid$Cards$$ExternalSyntheticLambda0(GoldenCompactGrid.this, ((GameInfo)v5)));
        }

        static final void onBindViewHolder$lambda$2(GoldenCompactGrid arg1, GameInfo arg2, View arg3) {
            if((arg1.isShown()) && (arg3.isAttachedToWindow())) {
                arg1.onItemClick.invoke(arg2);
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
            return this.onCreateViewHolder(arg1, arg2);
        }

        public Card onCreateViewHolder(ViewGroup arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "parent");
            View v1 = LayoutInflater.from(GoldenCompactGrid.this.getContext()).inflate(layout.gspace_rm_entrance, arg2, false);
            Drawable v2 = v1.getBackground().mutate();
            v2.setColorFilter(new ColorMatrixColorFilter(new float[]{0.768296f, 0.228311f, 0.527998f, -0.081399f, 0f, 0.605535f, -0.476366f, 0.743106f, -0.030066f, 0f, 0.303056f, -1.277643f, 0.889895f, 0.052786f, 0f, 0.472606f, 1.029612f, -0.106566f, 0.487059f, 0f}));
            v1.setBackground(v2);
            Intrinsics.checkNotNullExpressionValue(v1, "apply(...)");
            return new Card(v1);
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0005H\u0016J \u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid$Pages;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "(Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCompactGrid;)V", "getCount", "", "isViewFromObject", "", "view", "Landroid/view/View;", "item", "", "instantiateItem", "container", "Landroid/view/ViewGroup;", "position", "destroyItem", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Pages extends PagerAdapter {
        public Pages(GoldenCompactGrid arg1) {
            GoldenCompactGrid.this = arg1;
            super();
        }

        public void destroyItem(ViewGroup arg1, int arg2, Object arg3) {
            Intrinsics.checkNotNullParameter(arg1, "container");
            Intrinsics.checkNotNullParameter(arg3, "item");
            arg3.setAdapter(null);
            arg1.removeView(((View)arg3));
        }

        public int getCount() {
            return (GoldenCompactGrid.this.games.size() + 9) / 9;
        }

        public Object instantiateItem(ViewGroup arg5, int arg6) {
            Intrinsics.checkNotNullParameter(arg5, "container");
            RecyclerView v0 = new RecyclerView(GoldenCompactGrid.this.getContext());
            GoldenCompactGrid v4 = GoldenCompactGrid.this;
            v0.setTag(Integer.valueOf(arg6));
            v0.setLayoutManager(new GridLayoutManager(v0.getContext(), 3));
            v0.addItemDecoration(new GoldenCompactGrid$Pages$instantiateItem$page$1$1());
            v0.setOverScrollMode(2);
            v0.setItemAnimator(null);
            v0.setAdapter(new Cards(v4, arg6));
            arg5.addView(v0);
            return v0;
        }

        public boolean isViewFromObject(View arg1, Object arg2) {
            Intrinsics.checkNotNullParameter(arg1, "view");
            Intrinsics.checkNotNullParameter(arg2, "item");
            if(arg1 == (((View)arg2))) {
                return 1;
            }

            return 0;
        }
    }

    public static final int $stable = 8;
    private final View content;
    private List games;
    private final RedMagicIndicatorView indicator;
    private final Function1 onItemClick;
    private final ViewPager pager;

    static {
    }

    public GoldenCompactGrid(Context arg2, List arg3, String arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "games");
        Intrinsics.checkNotNullParameter(arg5, "onItemClick");
        super(arg2);
        this.games = arg3;
        this.onItemClick = arg5;
        View v2 = LayoutInflater.from(arg2).inflate(layout.gspace_rm_compact, this, false);
        this.content = v2;
        View v3 = v2.findViewById(id.gspace_compact_pages);
        this.pager = ((ViewPager)v3);
        this.indicator = v2.findViewById(id.gspace_compact_indicator);
        this.addView(v2);
        ((ViewPager)v3).addOnPageChangeListener(new SimpleOnPageChangeListener() {
            public void onPageSelected(int arg1) {
                GoldenCompactGrid.access$updateIndicator(GoldenCompactGrid.this, arg1);
            }
        });
        this.submitGames(this.games);
        Iterator v1 = this.games.iterator();
        int v2_1 = 0;
        while(true) {
            if(!v1.hasNext()) {
                break;
            }
            else if(Intrinsics.areEqual(v1.next().getPackageName(), arg4)) {
            }
            else {
                ++v2_1;
                continue;
            }

            goto label_40;
        }

        v2_1 = -1;
    label_40:
        ((ViewPager)v3).setCurrentItem(RangesKt.coerceAtLeast(v2_1, 0) / 9, false);
    }

    public static final List access$getGames$p(GoldenCompactGrid arg0) {
        return arg0.games;
    }

    public static final Function1 access$getOnItemClick$p(GoldenCompactGrid arg0) {
        return arg0.onItemClick;
    }

    public static final void access$updateIndicator(GoldenCompactGrid arg0, int arg1) {
        arg0.updateIndicator(arg1);
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        this.content.layout(0, 0, this.content.getMeasuredWidth(), this.content.getMeasuredHeight());
        float v1 = RangesKt.coerceAtMost(Math.min((((float)this.getWidth())) / (((float)this.content.getMeasuredWidth())), (((float)this.getHeight())) / (((float)this.content.getMeasuredHeight()))), 1f);
        this.content.setPivotX(0f);
        this.content.setPivotY(0f);
        this.content.setScaleX(v1);
        this.content.setScaleY(v1);
        this.content.setTranslationX(((((float)this.getWidth())) - (((float)this.content.getMeasuredWidth())) * v1) / 2f);
        this.content.setTranslationY(((((float)this.getHeight())) - (((float)this.content.getMeasuredHeight())) * v1) / 2f);
    }

    protected void onMeasure(int arg2, int arg3) {
        this.setMeasuredDimension(View$MeasureSpec.getSize(arg2), View$MeasureSpec.getSize(arg3));
        this.content.measure(View$MeasureSpec.makeMeasureSpec(this.content.getLayoutParams().width, 0x40000000), View$MeasureSpec.makeMeasureSpec(this.content.getLayoutParams().height, 0x40000000));
    }

    public final void release() {
        this.pager.clearOnPageChangeListeners();
        this.pager.setAdapter(null);
    }

    public final void submitGames(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "value");
        int v0 = this.pager.getCurrentItem();
        this.games = arg3;
        this.pager.setAdapter(new Pages(this));
        RedMagicIndicatorView v3 = this.indicator;
        PagerAdapter v1 = this.pager.getAdapter();
        Intrinsics.checkNotNull(v1);
        v3.setIndicatorCount(v1.getCount());
        ViewPager v3_1 = this.pager;
        v1 = v3_1.getAdapter();
        Intrinsics.checkNotNull(v1);
        v3_1.setCurrentItem(RangesKt.coerceAtMost(v0, v1.getCount() - 1), false);
        this.updateIndicator(this.pager.getCurrentItem());
    }

    private final void updateIndicator(int arg4) {
        this.indicator.setCurrentIndicator(arg4);
        ViewPager v0 = this.pager;
        Context v1 = this.getContext();
        int v2 = string.gspace_grid_page;
        Integer v4 = Integer.valueOf(arg4 + 1);
        PagerAdapter v3 = this.pager.getAdapter();
        Intrinsics.checkNotNull(v3);
        v0.setContentDescription(v1.getString(v2, new Object[]{v4, Integer.valueOf(v3.getCount())}));
    }
}

