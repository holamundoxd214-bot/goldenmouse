package com.TryJeanPc.goldenmouse.macro.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001&BK\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u001A\u0010\u000B\u001A\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r\u0012\u0004\u0012\u00020\u000F0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u001F\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u0007H\u0002J\u0006\u0010!\u001A\u00020\u000FJ\b\u0010\"\u001A\u00020\u000FH\u0002J\u0018\u0010#\u001A\u00020\u000F2\u000E\u0010$\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rH\u0002J\u0006\u0010%\u001A\u00020\u000FR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000B\u001A\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r\u0012\u0004\u0012\u00020\u000F0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroCoordinatePicker;", "", "context", "Landroid/content/Context;", "manager", "Landroid/view/WindowManager;", "type", "", "cutoutMode", "actionType", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "onFinished", "Lkotlin/Function1;", "", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroPoint;", "", "<init>", "(Landroid/content/Context;Landroid/view/WindowManager;IILcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;Lkotlin/jvm/functions/Function1;)V", "density", "", "points", "", "root", "Landroid/widget/FrameLayout;", "cross", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroCoordinatePicker$CrossView;", "caption", "Landroid/widget/TextView;", "attached", "", "finished", "dp", "n", "show", "updateCaption", "finish", "result", "close", "CrossView", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroCoordinatePicker {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0013H\u0014J\u0010\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00020\u0019H\u0014J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\b\u0010\u001E\u001A\u00020\u001BH\u0016R\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001E\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroCoordinatePicker$CrossView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "", "xPoint", "getXPoint", "()F", "yPoint", "getYPoint", "paint", "Landroid/graphics/Paint;", "radius", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "performClick", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class CrossView extends View {
        private final Paint paint;
        private final float radius;
        private float xPoint;
        private float yPoint;

        public CrossView(Context arg4) {
            Intrinsics.checkNotNullParameter(arg4, "context");
            super(arg4);
            Paint v4 = new Paint(1);
            v4.setColor(Color.rgb(0xFF, 210, 26));
            v4.setStrokeWidth(2f * this.getResources().getDisplayMetrics().density);
            this.paint = v4;
            this.radius = 18f * this.getResources().getDisplayMetrics().density;
        }

        public final float getXPoint() {
            return this.xPoint;
        }

        public final float getYPoint() {
            return this.yPoint;
        }

        protected void onDraw(Canvas arg15) {
            Intrinsics.checkNotNullParameter(arg15, "canvas");
            arg15.drawLine(this.xPoint - this.radius, this.yPoint, this.xPoint + this.radius, this.yPoint, this.paint);
            arg15.drawLine(this.xPoint, this.yPoint - this.radius, this.xPoint, this.yPoint + this.radius, this.paint);
            this.paint.setStyle(Paint$Style.STROKE);
            arg15.drawCircle(this.xPoint, this.yPoint, this.radius / 2f, this.paint);
            this.paint.setStyle(Paint$Style.FILL);
            this.paint.setTextSize(12f * this.getResources().getDisplayMetrics().scaledDensity);
            arg15.drawText((((int)this.xPoint)) + ", " + (((int)this.yPoint)), RangesKt.coerceAtMost(this.xPoint, ((float)RangesKt.coerceAtLeast(this.getWidth() - 140, 0))), RangesKt.coerceAtLeast(this.yPoint - this.radius - 8f, 18f), this.paint);
        }

        protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
            if(arg3 == 0) {
                this.xPoint = (((float)arg1)) / 2f;
                this.yPoint = (((float)arg2)) / 2f;
            }
        }

        public boolean onTouchEvent(MotionEvent arg6) {
            Intrinsics.checkNotNullParameter(arg6, "event");
            if(CollectionsKt.listOf(new Integer[]{Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(1)}).contains(Integer.valueOf(arg6.getActionMasked()))) {
                this.xPoint = RangesKt.coerceIn(arg6.getX(), 0f, ((float)RangesKt.coerceAtLeast(this.getWidth() - 1, 0)));
                this.yPoint = RangesKt.coerceIn(arg6.getY(), 0f, ((float)RangesKt.coerceAtLeast(this.getHeight() - 1, 0)));
                this.invalidate();
                if(arg6.getActionMasked() == 1) {
                    this.performClick();
                }
            }

            return 1;
        }

        public boolean performClick() {
            super.performClick();
            return 1;
        }
    }

    public static final int $stable = 8;
    private final MacroActionType actionType;
    private boolean attached;
    private final TextView caption;
    private final Context context;
    private final CrossView cross;
    private final int cutoutMode;
    private final float density;
    private boolean finished;
    private final WindowManager manager;
    private final Function1 onFinished;
    private final List points;
    private final FrameLayout root;
    private final int type;

    static {
    }

    public MacroCoordinatePicker(Context arg2, WindowManager arg3, int arg4, int arg5, MacroActionType arg6, Function1 arg7) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "manager");
        Intrinsics.checkNotNullParameter(arg6, "actionType");
        Intrinsics.checkNotNullParameter(arg7, "onFinished");
        super();
        this.context = arg2;
        this.manager = arg3;
        this.type = arg4;
        this.cutoutMode = arg5;
        this.actionType = arg6;
        this.onFinished = arg7;
        this.density = arg2.getResources().getDisplayMetrics().density;
        this.points = new ArrayList();
        this.root = new FrameLayout(arg2);
        this.cross = new CrossView(arg2);
        this.caption = new TextView(arg2);
    }

    public final void close() {
        if(this.attached) {
            try {
                this.manager.removeViewImmediate(this.root);
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }

            this.attached = false;
        }
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.density));
    }

    private final void finish(List arg2) {
        if(this.finished) {
            return;
        }

        this.finished = true;
        this.close();
        this.onFinished.invoke(arg2);
    }

    public final void show() {
        this.root.addView(this.cross, new FrameLayout$LayoutParams(-1, -1));
        this.caption.setTextColor(Color.rgb(0xFF, 210, 26));
        this.caption.setBackgroundResource(drawable.bg_status);
        this.caption.setGravity(17);
        this.caption.setTextSize(14f);
        this.caption.setPadding(this.dp(12), this.dp(8), this.dp(12), this.dp(8));
        FrameLayout v0 = this.root;
        TextView v1 = this.caption;
        FrameLayout$LayoutParams v2 = new FrameLayout$LayoutParams(-2, -2, 49);
        v2.topMargin = this.dp(16);
        v0.addView(((View)v1), ((ViewGroup$LayoutParams)v2));
        this.updateCaption();
        MacroCoordinatePicker.show$button(this, "CANCELAR", 0x800003, new MacroCoordinatePicker$$ExternalSyntheticLambda0(this));
        MacroCoordinatePicker.show$button(this, "OK", 0x800005, new MacroCoordinatePicker$$ExternalSyntheticLambda1(this));
        this.root.setFocusableInTouchMode(true);
        this.root.setOnKeyListener(new MacroCoordinatePicker$$ExternalSyntheticLambda2(this));
        WindowManager$LayoutParams v3 = new WindowManager$LayoutParams(-1, -1, this.type, 0x300, -3);
        if(Build$VERSION.SDK_INT >= 28) {
            v3.layoutInDisplayCutoutMode = this.cutoutMode;
        }

        try {
            this.manager.addView(this.root, ((ViewGroup$LayoutParams)v3));
            this.attached = true;
            this.root.requestFocus();
            Context v0_1 = this.root.getContext();
            Intrinsics.checkNotNullExpressionValue(v0_1, "getContext(...)");
            CursorOverlayOrderKt.bringCursorAboveWindow(v0_1);
            return;
        }
        catch(Exception ) {
            this.finish(null);
            return;
        }
    }

    private static final void show$button(MacroCoordinatePicker arg3, String arg4, int arg5, Function0 arg6) {
        TextView v0 = new TextView(arg3.context);
        v0.setText(arg4);
        v0.setTextSize(16f);
        v0.setGravity(17);
        String v1 = "OK";
        int v2 = Intrinsics.areEqual(arg4, v1) ? 0xFF000000 : -1;
        v0.setTextColor(v2);
        if(Intrinsics.areEqual(arg4, v1)) {
            v0.setBackgroundColor(Color.rgb(0xFF, 210, 26));
        }
        else {
            v0.setBackgroundResource(drawable.bg_setting);
        }

        v0.setOnClickListener(new MacroCoordinatePicker$$ExternalSyntheticLambda3(arg6));
        FrameLayout v4 = arg3.root;
        FrameLayout$LayoutParams v6 = new FrameLayout$LayoutParams(arg3.dp(110), arg3.dp(0x30), arg5 | 80);
        v6.bottomMargin = arg3.dp(24);
        v6.leftMargin = arg3.dp(24);
        v6.rightMargin = arg3.dp(24);
        v4.addView(((View)v0), ((ViewGroup$LayoutParams)v6));
    }

    static final void show$button$lambda$2$lambda$1(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    static final Unit show$lambda$4(MacroCoordinatePicker arg1) {
        arg1.finish(null);
        return Unit.INSTANCE;
    }

    static final Unit show$lambda$5(MacroCoordinatePicker arg6) {
        int[] v0 = new int[2];
        arg6.cross.getLocationOnScreen(v0);
        arg6.points.add(new MacroPoint(arg6.cross.getXPoint() + (((float)v0[0])), arg6.cross.getYPoint() + (((float)v0[1]))));
        if(arg6.actionType != MacroActionType.SWIPE || arg6.points.size() != 1) {
            arg6.finish(CollectionsKt.toList(arg6.points));
        }
        else {
            arg6.updateCaption();
        }

        return Unit.INSTANCE;
    }

    static final boolean show$lambda$6(MacroCoordinatePicker arg0, View arg1, int arg2, KeyEvent arg3) {
        if(arg2 == 4) {
            if(arg3.getAction() == 1) {
                arg0.finish(null);
            }

            return 1;
        }

        return 0;
    }

    private final void updateCaption() {
        String v3;
        TextView v0 = this.caption;
        if(this.actionType != MacroActionType.SWIPE) {
            v3 = this.actionType.getLabel() + ": mueve la cruz → OK";
        }
        else if(this.points.isEmpty()) {
            v3 = "Deslizar: punto inicial → OK";
        }
        else {
            v3 = "Deslizar: punto final → OK";
        }

        v0.setText(((CharSequence)v3));
    }
}

