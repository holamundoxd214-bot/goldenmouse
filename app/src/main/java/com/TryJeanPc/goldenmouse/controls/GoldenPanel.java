package com.TryJeanPc.goldenmouse.controls;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader$TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0010J\u0016\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0010J\u001E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0007J\u001E\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0019J \u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0010H\u0002J\u001E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u001EJ\u001C\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u00102\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u000E0!J\u001C\u0010\"\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u000E0!R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/GoldenPanel;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "density", "", "dp", "Lkotlin/Function1;", "", "container", "Landroid/widget/LinearLayout;", "title", "", "text", "", "card", "sectionTitle", "textInCard", "parent", "value", "field", "Landroid/widget/EditText;", "fieldInt", "", "createField", "switch", "Landroid/widget/Switch;", "checked", "", "button", "action", "Lkotlin/Function0;", "show", "apply", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class GoldenPanel {
    private final LinearLayout container;
    private final Context context;
    private final float density;
    private final Function1 dp;

    public GoldenPanel(Context arg8) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        super();
        this.context = arg8;
        this.density = arg8.getResources().getDisplayMetrics().density;
        GoldenPanel$$ExternalSyntheticLambda0 v0 = new GoldenPanel$$ExternalSyntheticLambda0(this);
        this.dp = ((Function1)v0);
        LinearLayout v1 = new LinearLayout(arg8);
        v1.setOrientation(1);
        Integer v2 = Integer.valueOf(16);
        v1.setPadding(((Function1)v0).invoke(v2).intValue(), ((Function1)v0).invoke(Integer.valueOf(20)).intValue(), ((Function1)v0).invoke(v2).intValue(), ((Function1)v0).invoke(Integer.valueOf(24)).intValue());
        GradientDrawable v3 = new GradientDrawable();
        v3.setShape(0);
        v3.setColor(Color.parseColor("#121212"));
        v3.setStroke(((Function1)v0).invoke(Integer.valueOf(1)).intValue(), Color.parseColor("#FFD700"));
        v3.setCornerRadius(((float)((Function1)v0).invoke(v2).intValue()));
        v1.setBackground(((Drawable)v3));
        this.container = v1;
    }

    public final void button(String arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "title");
        Intrinsics.checkNotNullParameter(arg6, "action");
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setGravity(17);
        v0.setPadding(0, this.dp.invoke(Integer.valueOf(10)).intValue(), 0, this.dp.invoke(Integer.valueOf(4)).intValue());
        Button v1 = new Button(this.context);
        v1.setText(((CharSequence)arg5));
        v1.setTextColor(0xFF000000);
        v1.setTextSize(13f);
        v1.setTypeface(Typeface.DEFAULT_BOLD);
        GradientDrawable v5 = new GradientDrawable();
        v5.setShape(0);
        v5.setColor(Color.parseColor("#FFD700"));
        v5.setCornerRadius(((float)this.dp.invoke(Integer.valueOf(20)).intValue()));
        v1.setBackground(((Drawable)v5));
        v1.setLayoutParams(new LinearLayout$LayoutParams(-1, this.dp.invoke(Integer.valueOf(40)).intValue()));
        v1.setOnClickListener(new GoldenPanel$$ExternalSyntheticLambda3(arg6));
        v0.addView(((View)v1));
        this.container.addView(((View)v0));
    }

    static final void button$lambda$21$lambda$20(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    public final LinearLayout card(String arg8) {
        Intrinsics.checkNotNullParameter(arg8, "sectionTitle");
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(1);
        Function1 v2 = this.dp;
        Integer v3 = Integer.valueOf(14);
        int v2_1 = v2.invoke(v3).intValue();
        Function1 v4 = this.dp;
        Integer v5 = Integer.valueOf(12);
        v0.setPadding(v2_1, v4.invoke(v5).intValue(), this.dp.invoke(v3).intValue(), this.dp.invoke(v5).intValue());
        GradientDrawable v2_2 = new GradientDrawable();
        v2_2.setShape(0);
        v2_2.setColor(Color.parseColor("#1A1A1A"));
        v2_2.setStroke(this.dp.invoke(Integer.valueOf(1)).intValue(), Color.parseColor("#2A2A2A"));
        v2_2.setCornerRadius(((float)this.dp.invoke(Integer.valueOf(10)).intValue()));
        v0.setBackground(((Drawable)v2_2));
        LinearLayout$LayoutParams v1 = new LinearLayout$LayoutParams(-1, -2);
        v1.bottomMargin = this.dp.invoke(v5).intValue();
        v0.setLayoutParams(((ViewGroup$LayoutParams)v1));
        TextView v1_1 = new TextView(this.context);
        v1_1.setText(((CharSequence)arg8));
        v1_1.setTextSize(12f);
        v1_1.setTypeface(Typeface.create("sans-serif-medium", 0));
        v1_1.setTextColor(Color.parseColor("#FFD700"));
        v1_1.setLetterSpacing(0.04f);
        v1_1.setPadding(0, 0, 0, this.dp.invoke(Integer.valueOf(8)).intValue());
        v0.addView(((View)v1_1));
        this.container.addView(v0);
        return v0;
    }

    private final EditText createField(LinearLayout arg7, String arg8, String arg9) {
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(0);
        v0.setGravity(16);
        Function1 v3 = this.dp;
        Integer v4 = Integer.valueOf(4);
        v0.setPadding(0, v3.invoke(v4).intValue(), 0, this.dp.invoke(v4).intValue());
        TextView v3_1 = new TextView(this.context);
        v3_1.setText(((CharSequence)arg8));
        v3_1.setTextSize(13f);
        v3_1.setTypeface(Typeface.DEFAULT_BOLD);
        v3_1.setTextColor(Color.parseColor("#DDDDDD"));
        v3_1.setGravity(16);
        v3_1.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        EditText v8 = new EditText(this.context);
        v8.setText(((CharSequence)arg9));
        v8.setTextColor(-1);
        v8.setTextSize(14f);
        v8.setGravity(17);
        v8.setIncludeFontPadding(false);
        v8.setSingleLine(true);
        GradientDrawable v2 = new GradientDrawable();
        v2.setShape(0);
        v2.setColor(Color.parseColor("#242424"));
        v2.setStroke(this.dp.invoke(Integer.valueOf(1)).intValue(), Color.parseColor("#3A3A3A"));
        Function1 v9 = this.dp;
        Integer v1 = Integer.valueOf(6);
        v2.setCornerRadius(((float)v9.invoke(v1).intValue()));
        v8.setBackground(((Drawable)v2));
        v9 = this.dp;
        Integer v2_1 = Integer.valueOf(8);
        v8.setPadding(v9.invoke(v2_1).intValue(), this.dp.invoke(v1).intValue(), this.dp.invoke(v2_1).intValue(), this.dp.invoke(v1).intValue());
        v8.setLayoutParams(new LinearLayout$LayoutParams(this.dp.invoke(Integer.valueOf(100)).intValue(), this.dp.invoke(Integer.valueOf(34)).intValue()));
        v8.setInputType(0x2002);
        v0.addView(((View)v3_1));
        v0.addView(v8);
        arg7.addView(((View)v0));
        return v8;
    }

    static final int dp$lambda$0(GoldenPanel arg0, int arg1) {
        return ((int)((((float)arg1)) * arg0.density));
    }

    public final EditText field(LinearLayout arg2, String arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        Intrinsics.checkNotNullParameter(arg3, "title");
        return this.createField(arg2, arg3, String.valueOf(arg4));
    }

    public final EditText fieldInt(LinearLayout arg2, String arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        Intrinsics.checkNotNullParameter(arg3, "title");
        return this.createField(arg2, arg3, String.valueOf(arg4));
    }

    public final void show(Context arg18, Function0 arg19) {
        Context v1 = arg18;
        Intrinsics.checkNotNullParameter(v1, "context");
        Intrinsics.checkNotNullParameter(arg19, "apply");
        Dialog v3 = new Dialog(v1);
        v3.requestWindowFeature(1);
        LinearLayout v5 = new LinearLayout(v1);
        v5.setGravity(17);
        v5.setOrientation(0);
        v5.setPadding(0, this.dp.invoke(Integer.valueOf(16)).intValue(), 0, 0);
        Button v8 = new Button(v1);
        v8.setText("CANCELAR");
        v8.setTextColor(0xFF000000);
        v8.setTextSize(13f);
        v8.setTypeface(Typeface.DEFAULT_BOLD);
        GradientDrawable v11 = new GradientDrawable();
        v11.setShape(0);
        v11.setColor(-1);
        Function1 v13 = this.dp;
        Integer v14 = Integer.valueOf(20);
        v11.setCornerRadius(((float)v13.invoke(v14).intValue()));
        v8.setBackground(((Drawable)v11));
        v13 = this.dp;
        Integer v15 = Integer.valueOf(120);
        int v13_1 = v13.invoke(v15).intValue();
        Function1 v6 = this.dp;
        Integer v12 = Integer.valueOf(40);
        LinearLayout$LayoutParams v11_1 = new LinearLayout$LayoutParams(v13_1, v6.invoke(v12).intValue());
        v6 = this.dp;
        Integer v13_2 = Integer.valueOf(12);
        v11_1.setMarginEnd(v6.invoke(v13_2).intValue());
        v8.setLayoutParams(((ViewGroup$LayoutParams)v11_1));
        v8.setOnClickListener(new GoldenPanel$$ExternalSyntheticLambda1(v3));
        Button v6_1 = new Button(v1);
        v6_1.setText("APLICAR");
        v6_1.setTextColor(0xFF000000);
        v6_1.setTextSize(13f);
        v6_1.setTypeface(Typeface.DEFAULT_BOLD);
        GradientDrawable v9 = new GradientDrawable();
        v9.setShape(0);
        v9.setColor(Color.parseColor("#FFD700"));
        v9.setCornerRadius(((float)this.dp.invoke(v14).intValue()));
        v6_1.setBackground(((Drawable)v9));
        v6_1.setLayoutParams(new LinearLayout$LayoutParams(this.dp.invoke(v15).intValue(), this.dp.invoke(v12).intValue()));
        v6_1.setOnClickListener(new GoldenPanel$$ExternalSyntheticLambda2(arg19, v3));
        v5.addView(((View)v8));
        v5.addView(((View)v6_1));
        this.container.addView(((View)v5));
        ScrollView v2 = new ScrollView(v1);
        v2.setFillViewport(true);
        Function1 v4 = this.dp;
        Integer v5_1 = Integer.valueOf(8);
        v2.setPadding(v4.invoke(v5_1).intValue(), this.dp.invoke(v13_2).intValue(), this.dp.invoke(v5_1).intValue(), this.dp.invoke(v13_2).intValue());
        v2.setClipToPadding(false);
        int v5_2 = -2;
        v2.addView(this.container, new FrameLayout$LayoutParams(-1, v5_2));
        v3.setContentView(((View)v2));
        Window v0 = v3.getWindow();
        if(v0 != null) {
            v0.setBackgroundDrawable(new ColorDrawable(0));
        }

        v0 = v3.getWindow();
        if(v0 != null) {
            v0.setLayout(((int)((((double)v1.getResources().getDisplayMetrics().widthPixels)) * 0.94)), v5_2);
        }

        v0 = v3.getWindow();
        if(v0 != null) {
            v0.setType(0x7F6);
        }

        v0 = v3.getWindow();
        if(v0 != null) {
            v0.setGravity(17);
        }

        SessionOverlayWindowsKt.showSessionDialog(v3);
        Context v0_1 = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v0_1);
    }

    static final void show$lambda$26$lambda$25(Dialog arg0, View arg1) {
        arg0.dismiss();
    }

    static final void show$lambda$29$lambda$28(Function0 arg0, Dialog arg1, View arg2) {
        arg0.invoke();
        arg1.dismiss();
    }

    public final Switch switch(LinearLayout arg6, String arg7, boolean arg8) {
        Intrinsics.checkNotNullParameter(arg6, "parent");
        Intrinsics.checkNotNullParameter(arg7, "title");
        LinearLayout v0 = new LinearLayout(this.context);
        v0.setOrientation(0);
        v0.setGravity(16);
        Function1 v2 = this.dp;
        Integer v3 = Integer.valueOf(4);
        v0.setPadding(0, v2.invoke(v3).intValue(), 0, this.dp.invoke(v3).intValue());
        TextView v2_1 = new TextView(this.context);
        v2_1.setText(((CharSequence)arg7));
        v2_1.setTextSize(13f);
        v2_1.setTypeface(Typeface.DEFAULT_BOLD);
        v2_1.setTextColor(Color.parseColor("#DDDDDD"));
        v2_1.setLayoutParams(new LinearLayout$LayoutParams(0, -2, 1f));
        Switch v7 = new Switch(this.context);
        v7.setChecked(arg8);
        v0.addView(((View)v2_1));
        v0.addView(v7);
        arg6.addView(((View)v0));
        return v7;
    }

    public final void textInCard(LinearLayout arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "parent");
        Intrinsics.checkNotNullParameter(arg4, "value");
        TextView v0 = new TextView(this.context);
        v0.setText(((CharSequence)arg4));
        v0.setTextSize(13f);
        v0.setTypeface(Typeface.DEFAULT_BOLD);
        v0.setTextColor(-1);
        Function1 v4 = this.dp;
        Integer v1 = Integer.valueOf(4);
        v0.setPadding(0, v4.invoke(v1).intValue(), 0, this.dp.invoke(v1).intValue());
        arg3.addView(((View)v0));
    }

    public final void title(String arg12) {
        Intrinsics.checkNotNullParameter(arg12, "text");
        TextView v0 = new TextView(this.context);
        v0.setText(((CharSequence)arg12));
        v0.setTextSize(18f);
        v0.setGravity(17);
        v0.setTypeface(Typeface.create("sans-serif-black", 0));
        v0.setLetterSpacing(0.06f);
        v0.setShadowLayer(6f, 0f, 4f, Color.parseColor("#AA000000"));
        v0.setPadding(0, 0, 0, this.dp.invoke(Integer.valueOf(6)).intValue());
        v0.getPaint().setShader(new LinearGradient(0f, 0f, 0f, v0.getTextSize() * 1.2f, new int[]{Color.parseColor("#FFF4CC"), Color.parseColor("#FFB700")}, null, Shader$TileMode.CLAMP));
        this.container.addView(((View)v0));
        View v0_1 = new View(this.context);
        LinearLayout$LayoutParams v1 = new LinearLayout$LayoutParams(this.dp.invoke(Integer.valueOf(140)).intValue(), this.dp.invoke(Integer.valueOf(2)).intValue());
        v1.gravity = 17;
        v1.bottomMargin = this.dp.invoke(Integer.valueOf(16)).intValue();
        v0_1.setLayoutParams(((ViewGroup$LayoutParams)v1));
        v0_1.setBackground(new GradientDrawable(GradientDrawable$Orientation.LEFT_RIGHT, new int[]{0, Color.parseColor("#FFD700"), 0}));
        this.container.addView(v0_1);
    }
}

