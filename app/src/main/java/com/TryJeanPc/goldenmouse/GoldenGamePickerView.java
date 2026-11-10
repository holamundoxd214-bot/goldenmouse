package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u000289B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001A\u00020\u000EH\u0014J\b\u0010\"\u001A\u00020\u000EH\u0014J(\u0010#\u001A\u00020\u000E2\u0006\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%2\u0006\u0010(\u001A\u00020%H\u0014J0\u0010)\u001A\u00020\u000E2\u0006\u0010*\u001A\u00020\r2\u0006\u0010+\u001A\u00020%2\u0006\u0010,\u001A\u00020%2\u0006\u0010-\u001A\u00020%2\u0006\u0010.\u001A\u00020%H\u0014J\u0010\u0010/\u001A\u00020\r2\u0006\u00100\u001A\u000201H\u0016J,\u00102\u001A\u00020\u000E2\f\u00103\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\f\u00104\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\b\b\u0002\u00105\u001A\u00020\rJ\u0010\u00106\u001A\u00020\u000E2\u0006\u00107\u001A\u00020\u000BH\u0002R>\u0010\b\u001A&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f\u0012\u0004\u0012\u00020\u000E0\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u001D\u001A\u00060\u001ER\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onSelectionChange", "Lkotlin/Function2;", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "Lkotlin/Function1;", "", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function2;)V", "onBack", "Lkotlin/Function0;", "getOnBack", "()Lkotlin/jvm/functions/Function0;", "setOnBack", "(Lkotlin/jvm/functions/Function0;)V", "apps", "originalSelection", "confirmedSelection", "saving", "appsAdapter", "Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView$AppsAdapter;", "backTouchDelegate", "Landroid/view/TouchDelegate;", "onFinishInflate", "onAttachedToWindow", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onLayout", "changed", "l", "t", "r", "b", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "submitApps", "installedApps", "selectedGames", "loading", "toggle", "app", "AppRow", "AppsAdapter"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGamePickerView extends LinearLayout {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView$AppRow;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "action", "Lcom/TryJeanPc/goldenmouse/GoldenSharkGameSwitch;", "getAction", "()Lcom/TryJeanPc/goldenmouse/GoldenSharkGameSwitch;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class AppRow extends ViewHolder {
        private final GoldenSharkGameSwitch action;
        private final ImageView icon;
        private final TextView name;

        public AppRow(View arg3) {
            Intrinsics.checkNotNullParameter(arg3, "view");
            super(arg3);
            View v0 = arg3.findViewById(id.picker_app_icon);
            Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
            this.icon = ((ImageView)v0);
            v0 = arg3.findViewById(id.picker_app_name);
            Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
            this.name = ((TextView)v0);
            arg3 = arg3.findViewById(id.picker_app_switch);
            Intrinsics.checkNotNullExpressionValue(arg3, "findViewById(...)");
            this.action = ((GoldenSharkGameSwitch)arg3);
        }

        public final GoldenSharkGameSwitch getAction() {
            return this.action;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final TextView getName() {
            return this.name;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006H\u0016J\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u0006H\u0016¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView$AppsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView$AppRow;", "<init>", "(Lcom/TryJeanPc/goldenmouse/GoldenGamePickerView;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class AppsAdapter extends Adapter {
        public AppsAdapter(GoldenGamePickerView arg1) {
            GoldenGamePickerView.this = arg1;
            super();
        }

        public int getItemCount() {
            return GoldenGamePickerView.this.apps.size();
        }

        public void onBindViewHolder(ViewHolder arg1, int arg2) {
            this.onBindViewHolder(((AppRow)arg1), arg2);
        }

        public void onBindViewHolder(AppRow arg7, int arg8) {
            boolean v1_2;
            Intrinsics.checkNotNullParameter(arg7, "holder");
            Object v0 = GoldenGamePickerView.this.apps.get(arg8);
            List v1 = GoldenGamePickerView.this.confirmedSelection;
            int v4 = 0;
            if(!(v1 instanceof Collection) || !v1.isEmpty()) {
                Iterator v1_1 = ((Iterable)v1).iterator();
                do {
                    if(v1_1.hasNext()) {
                        if(!Intrinsics.areEqual(v1_1.next().getPackageName(), ((GameInfo)v0).getPackageName())) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_14;
                    }
                }
                while(true);

                v1_2 = true;
                goto label_25;
            label_14:
                v1_2 = false;
            }
            else {
                goto label_14;
            }

        label_25:
            arg7.getIcon().setImageDrawable(((GameInfo)v0).getIcon());
            arg7.getName().setText(((GameInfo)v0).getName());
            arg7.getAction().setOnCheckedChangeListener(null);
            arg7.getAction().setChecked(v1_2);
            arg7.getAction().jumpDrawablesToCurrentState();
            arg7.getAction().setEnabled(GoldenGamePickerView.this.saving ^ 1);
            arg7.getAction().setContentDescription(((GameInfo)v0).getName());
            arg7.itemView.setEnabled(1 ^ GoldenGamePickerView.this.saving);
            arg7.itemView.setSelected(v1_2);
            View v2 = arg7.itemView;
            Context v3 = GoldenGamePickerView.this.getContext();
            int v5 = v1_2 ? string.picker_remove_app : string.picker_add_app;
            v2.setContentDescription(v3.getString(v5, new Object[]{((GameInfo)v0).getName()}));
            GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda0 v2_1 = new GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda0(arg7, GoldenGamePickerView.this);
            arg7.getAction().setOnCheckedChangeListener(new GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda1(v1_2, arg7, ((View$OnClickListener)v2_1)));
            arg7.itemView.setOnClickListener(((View$OnClickListener)v2_1));
            View v7 = arg7.itemView.findViewById(id.picker_bottom_line);
            if(arg8 == CollectionsKt.getLastIndex(GoldenGamePickerView.this.apps)) {
            }
            else {
                v4 = 8;
            }

            v7.setVisibility(v4);
        }

        static final void onBindViewHolder$lambda$1(AppRow arg0, GoldenGamePickerView arg1, View arg2) {
            int v0 = arg0.getAdapterPosition();
            if(v0 != -1) {
                arg1.toggle(arg1.apps.get(v0));
            }
        }

        static final void onBindViewHolder$lambda$2(boolean arg0, AppRow arg1, View$OnClickListener arg2, CompoundButton arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg3, "button");
            arg3.setChecked(arg0);
            arg1.getAction().jumpDrawablesToCurrentState();
            arg2.onClick(((View)arg3));
        }

        public ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
            return this.onCreateViewHolder(arg1, arg2);
        }

        public AppRow onCreateViewHolder(ViewGroup arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg3, "parent");
            View v3 = LayoutInflater.from(arg3.getContext()).inflate(layout.gp_rm_add_row, arg3, false);
            Intrinsics.checkNotNullExpressionValue(v3, "inflate(...)");
            return new AppRow(v3);
        }
    }

    public static final int $stable = 8;
    private List apps;
    private final AppsAdapter appsAdapter;
    private TouchDelegate backTouchDelegate;
    private List confirmedSelection;
    private Function0 onBack;
    private Function2 onSelectionChange;
    private List originalSelection;
    private boolean saving;

    static {
    }

    public GoldenGamePickerView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenGamePickerView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenGamePickerView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.onSelectionChange = new GoldenGamePickerView$$ExternalSyntheticLambda4();
        this.onBack = new GoldenGamePickerView$$ExternalSyntheticLambda5();
        this.apps = CollectionsKt.emptyList();
        this.originalSelection = CollectionsKt.emptyList();
        this.confirmedSelection = CollectionsKt.emptyList();
        this.appsAdapter = new AppsAdapter(this);
    }

    public static final List access$getApps$p(GoldenGamePickerView arg0) {
        return arg0.apps;
    }

    public static final List access$getConfirmedSelection$p(GoldenGamePickerView arg0) {
        return arg0.confirmedSelection;
    }

    public static final boolean access$getSaving$p(GoldenGamePickerView arg0) {
        return arg0.saving;
    }

    public static final void access$toggle(GoldenGamePickerView arg0, GameInfo arg1) {
        arg0.toggle(arg1);
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        TouchDelegate v0 = this.backTouchDelegate;
        if(v0 == null || !v0.onTouchEvent(arg3)) {
            if(super.dispatchTouchEvent(arg3)) {
                return 1;
            }

            return 0;
        }
        else {
        }

        return 1;
    }

    public final Function0 getOnBack() {
        return this.onBack;
    }

    public final Function2 getOnSelectionChange() {
        return this.onSelectionChange;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets(((View)this));
    }

    static final Unit onBack$lambda$1() {
        return Unit.INSTANCE;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View v0 = this.findViewById(id.picker_header);
        View v1 = this.findViewById(id.picker_empty);
        ViewCompat.setOnApplyWindowInsetsListener(this, new GoldenGamePickerView$$ExternalSyntheticLambda2(v0, this, v1, new Rect(v1.getPaddingLeft(), v1.getPaddingTop(), v1.getPaddingRight(), v1.getPaddingBottom())));
        v0 = this.findViewById(id.picker_apps);
        ((RecyclerView)v0).setLayoutManager(new LinearLayoutManager(((RecyclerView)v0).getContext()));
        ((RecyclerView)v0).setAdapter(this.appsAdapter);
        ((RecyclerView)v0).setItemAnimator(null);
        ((RecyclerView)v0).setHasFixedSize(true);
        this.findViewById(id.picker_back).setOnClickListener(new GoldenGamePickerView$$ExternalSyntheticLambda3(this));
    }

    static final WindowInsetsCompat onFinishInflate$lambda$5(View arg16, GoldenGamePickerView arg17, View arg18, Rect arg19, View arg20, WindowInsetsCompat arg21) {
        int v5_2;
        int v12_2;
        int v7_2;
        int v9_2;
        Object v12;
        View v0 = arg16;
        GoldenGamePickerView v1 = arg17;
        Rect v2 = arg19;
        WindowInsetsCompat v3 = arg21;
        Intrinsics.checkNotNullParameter(arg20, "<unused var>");
        Intrinsics.checkNotNullParameter(v3, "insets");
        Insets v4 = v3.getInsets(Type.displayCutout() | Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(v4, "getInsets(...)");
        Insets v6 = v3.getInsets(Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(v6, "getInsets(...)");
        DisplayCutoutCompat v5 = v3.getDisplayCutout();
        List v7 = v5 != null ? v5.getBoundingRects() : null;
        if(v7 == null) {
            v7 = CollectionsKt.emptyList();
        }

        int v8 = v0.getBackground().getMinimumHeight() + v4.top;
        int v10 = 1;
        if(!v7.isEmpty()) {
            List v9 = v7;
            if(!(v9 instanceof Collection) || !v9.isEmpty()) {
                Iterator v9_1 = ((Iterable)v9).iterator();
                do {
                    if(v9_1.hasNext()) {
                        v12 = v9_1.next();
                        if(((Rect)v12).left >= v4.left) {
                            continue;
                        }

                        if(((Rect)v12).top >= v8) {
                            continue;
                        }

                        if(((Rect)v12).bottom <= 0) {
                            continue;
                        }

                        break;
                    }

                    goto label_52;
                }
                while(true);

                goto label_54;
            }
            else {
            }

        label_52:
            v9_2 = 0;
        }
        else {
        label_54:
            v9_2 = 1;
        }

        if(v1.getWidth() == 0 || (v7.isEmpty())) {
        label_81:
            v7_2 = 1;
        }
        else {
            if(!(v7 instanceof Collection) || !v7.isEmpty()) {
                Iterator v7_1 = ((Iterable)v7).iterator();
                do {
                    if(v7_1.hasNext()) {
                        v12 = v7_1.next();
                        if(((Rect)v12).right <= v1.getWidth() - v4.right) {
                            continue;
                        }

                        if(((Rect)v12).top >= v8) {
                            continue;
                        }

                        if(((Rect)v12).bottom <= 0) {
                            continue;
                        }

                        break;
                    }

                    goto label_79;
                }
                while(true);

                goto label_81;
            }
            else {
            }

        label_79:
            v7_2 = 0;
        }

        v8 = v6.left;
        if(v5 != null) {
            Insets v12_1 = v5.getWaterfallInsets();
            if(v12_1 != null) {
                v12_2 = v12_1.left;
            }
            else {
                goto label_88;
            }
        }
        else {
        label_88:
            v12_2 = 0;
        }

        v9_2 = v9_2 != 0 ? v4.left : 0;
        v8 = Math.max(v8, Math.max(v12_2, v9_2));
        int v6_1 = v6.right;
        if(v5 != null) {
            Insets v5_1 = v5.getWaterfallInsets();
            if(v5_1 != null) {
                v5_2 = v5_1.right;
            }
            else {
                goto label_101;
            }
        }
        else {
        label_101:
            v5_2 = 0;
        }

        v7_2 = v7_2 != 0 ? v4.right : 0;
        v5_2 = Math.max(v6_1, Math.max(v5_2, v7_2));
        if(v0.getPaddingLeft() == v8 && v0.getPaddingTop() == v4.top) {
            if(v0.getPaddingRight() != v5_2) {
            }
            else {
                v10 = 0;
            }
        }

        v0.setPadding(v8, v4.top, v5_2, 0);
        v0.setMinimumHeight(v0.getBackground().getMinimumHeight() + v4.top);
        v1.findViewById(id.picker_apps).setPadding(v4.left, 0, v4.right, v4.bottom);
        arg18.setPadding(v2.left + v4.left, v2.top, v2.right + v4.right, v2.bottom);
        if(v10 != 0) {
            v1.post(new GoldenGamePickerView$$ExternalSyntheticLambda0(v0));
        }

        return v3;
    }

    static final void onFinishInflate$lambda$5$lambda$4(View arg0) {
        arg0.requestLayout();
    }

    static final void onFinishInflate$lambda$7(GoldenGamePickerView arg0, View arg1) {
        arg0.onBack.invoke();
    }

    protected void onLayout(boolean arg2, int arg3, int arg4, int arg5, int arg6) {
        super.onLayout(arg2, arg3, arg4, arg5, arg6);
        View v2 = this.findViewById(id.picker_back);
        Rect v3 = new Rect();
        v2.getDrawingRect(v3);
        this.offsetDescendantRectToMyCoords(v2, v3);
        v3.bottom = Math.max(v3.bottom, v3.top + MathKt.roundToInt(this.getResources().getDisplayMetrics().density * 48f));
        TouchDelegate v4 = new TouchDelegate(v3, v2);
        this.backTouchDelegate = v4;
        this.setTouchDelegate(v4);
    }

    static final Unit onSelectionChange$lambda$0(List arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<unused var>");
        Intrinsics.checkNotNullParameter(arg2, "done");
        arg2.invoke(Boolean.valueOf(false));
        return Unit.INSTANCE;
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        ViewCompat.requestApplyInsets(((View)this));
    }

    public final void setOnBack(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onBack = arg2;
    }

    public final void setOnSelectionChange(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onSelectionChange = arg2;
    }

    public final void submitApps(List arg5, List arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg5, "installedApps");
        Intrinsics.checkNotNullParameter(arg6, "selectedGames");
        View v0 = this.findViewById(id.picker_empty);
        int v2 = 0;
        int v3 = 8;
        int v7 = !arg5.isEmpty() || (arg7) ? v3 : 0;
        v0.setVisibility(v7);
        View v7_1 = this.findViewById(id.picker_apps);
        if(arg5.isEmpty()) {
            v2 = v3;
        }

        v7_1.setVisibility(v2);
        if((Intrinsics.areEqual(this.apps, arg5)) && (Intrinsics.areEqual(this.originalSelection, arg6))) {
            return;
        }

        this.apps = CollectionsKt.toList(((Iterable)arg5));
        this.originalSelection = CollectionsKt.toList(((Iterable)arg6));
        this.confirmedSelection = CollectionsKt.toList(((Iterable)arg6));
        this.appsAdapter.notifyDataSetChanged();
    }

    public static void submitApps$default(GoldenGamePickerView arg0, List arg1, List arg2, boolean arg3, int arg4, Object arg5) {
        arg0.submitApps(arg1, arg2, false);
    }

    private final void toggle(GameInfo arg6) {
        List v1_1;
        if(this.saving) {
            return;
        }

        List v0 = this.confirmedSelection;
        if(!(v0 instanceof Collection) || !v0.isEmpty()) {
            Iterator v0_1 = ((Iterable)v0).iterator();
            do {
                if(v0_1.hasNext()) {
                    if(!Intrinsics.areEqual(v0_1.next().getPackageName(), arg6.getPackageName())) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_33;
                }
            }
            while(true);

            v0 = this.confirmedSelection;
            ArrayList v1 = new ArrayList();
            v0_1 = ((Iterable)v0).iterator();
            while(true) {
                if(v0_1.hasNext()) {
                    Object v2 = v0_1.next();
                    if(Intrinsics.areEqual(v2.getPackageName(), arg6.getPackageName())) {
                        continue;
                    }

                    ((Collection)v1).add(v2);
                    continue;
                }

                goto label_35;
            }

        label_33:
            v1_1 = CollectionsKt.plus(this.confirmedSelection, arg6);
        }
        else {
            goto label_33;
        }

    label_35:
        this.saving = true;
        this.appsAdapter.notifyItemRangeChanged(0, this.apps.size());
        this.onSelectionChange.invoke(v1_1, new GoldenGamePickerView$$ExternalSyntheticLambda1(this, v1_1));
    }

    static final Unit toggle$lambda$10(GoldenGamePickerView arg2, List arg3, boolean arg4) {
        if(arg4) {
            arg2.confirmedSelection = arg3;
        }

        arg2.saving = false;
        arg2.appsAdapter.notifyItemRangeChanged(0, arg2.apps.size());
        if(!arg4) {
            Toast.makeText(arg2.getContext(), string.picker_save_failed, 1).show();
        }

        return Unit.INSTANCE;
    }
}

