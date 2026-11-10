package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint$Align;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001F\u001A\u00020\u0007H\u0014J\b\u0010 \u001A\u00020\u0007H\u0014J\u0018\u0010!\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020$H\u0014J\u0010\u0010%\u001A\u00020\u00072\u0006\u0010#\u001A\u00020$H\u0014J\b\u0010&\u001A\u00020\u0007H\u0002J\u000E\u0010\'\u001A\u00020\u00072\u0006\u0010(\u001A\u00020\u0006J\u0006\u0010)\u001A\u00020\u0007J\u0010\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020,H\u0016J\u0010\u0010-\u001A\u00020\f2\u0006\u0010+\u001A\u00020,H\u0016J\u0010\u0010.\u001A\u00020\u00072\u0006\u0010/\u001A\u000200H\u0014R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TeclaEditorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "onTeclaAsignada", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "teclaTexto", "mostrarCursor", "", "density", "", "handlerAnim", "Landroid/os/Handler;", "blinkReady", "blinkAttached", "blinkWindowShown", "blinkRunning", "blinkRunnable", "com/TryJeanPc/goldenmouse/controls/TeclaEditorView$blinkRunnable$1", "Lcom/TryJeanPc/goldenmouse/controls/TeclaEditorView$blinkRunnable$1;", "bgPaint", "Landroid/graphics/Paint;", "borderPaint", "textPaint", "cursorPaint", "boundsRect", "Landroid/graphics/RectF;", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "", "onWindowVisibilityChanged", "reconcileBlink", "recibirTecla", "tecla", "solicitarFocoTeclado", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onGenericMotionEvent", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TeclaEditorView extends View {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\b\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TeclaEditorView$Companion;", "", "<init>", "()V", "resolverNombreBotonRaton", "", "event", "Landroid/view/MotionEvent;", "resolverNombreScroll", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final String resolverNombreBotonRaton(MotionEvent arg3) {
            Intrinsics.checkNotNullParameter(arg3, "event");
            int v2 = arg3.getActionMasked();
            String v1 = null;
            if(v2 != 11 && v2 != 0 && v2 != 5) {
                return v1;
            }

            v2 = arg3.getActionButton() != 0 ? arg3.getActionButton() : arg3.getButtonState();
            if((v2 & 2) != 0) {
                return "MOUSE_RIGHT";
            }

            if((v2 & 4) != 0) {
                return "MOUSE_MIDDLE";
            }

            if((v2 & 8) != 0) {
                return "MOUSE_SIDE_1";
            }

            if((v2 & 16) != 0) {
                return "MOUSE_SIDE_2";
            }

            return v1;
        }

        public final String resolverNombreScroll(MotionEvent arg4) {
            Intrinsics.checkNotNullParameter(arg4, "event");
            String v1 = null;
            if(arg4.getActionMasked() != 8) {
                return v1;
            }

            float v3 = arg4.getAxisValue(9);
            if(v3 == 0f) {
                v3 = arg4.getAxisValue(26);
            }

            if(v3 > 0f) {
                return "SCROLL_UP";
            }

            if(v3 < 0f) {
                return "SCROLL_DOWN";
            }

            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Paint bgPaint;
    private boolean blinkAttached;
    private boolean blinkReady;
    private final TeclaEditorView$blinkRunnable$1 blinkRunnable;
    private boolean blinkRunning;
    private boolean blinkWindowShown;
    private final Paint borderPaint;
    private final RectF boundsRect;
    private final Paint cursorPaint;
    private final float density;
    private final Handler handlerAnim;
    private boolean mostrarCursor;
    private final Function1 onTeclaAsignada;
    private String teclaTexto;
    private final Paint textPaint;

    static {
        TeclaEditorView.Companion = new Companion(null);
        TeclaEditorView.$stable = 8;
    }

    public TeclaEditorView(Context arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        Intrinsics.checkNotNullParameter(arg6, "onTeclaAsignada");
        super(arg5);
        this.onTeclaAsignada = arg6;
        this.teclaTexto = "";
        this.mostrarCursor = true;
        float v5 = arg5.getResources().getDisplayMetrics().density;
        this.density = v5;
        this.handlerAnim = new Handler(Looper.getMainLooper());
        this.blinkRunnable = new TeclaEditorView$blinkRunnable$1(this);
        Paint v0 = new Paint(1);
        v0.setColor(Color.parseColor("#1B222D"));
        v0.setStyle(Paint$Style.FILL);
        this.bgPaint = v0;
        v0 = new Paint(1);
        v0.setColor(Color.parseColor("#4C749F"));
        v0.setStyle(Paint$Style.STROKE);
        v0.setStrokeWidth(v5 * 1.5f);
        this.borderPaint = v0;
        v0 = new Paint(1);
        v0.setColor(-1);
        v0.setTextAlign(Paint$Align.CENTER);
        v0.setTextSize(15f * v5);
        v0.setFakeBoldText(true);
        this.textPaint = v0;
        v0 = new Paint(1);
        v0.setColor(-1);
        v0.setStyle(Paint$Style.STROKE);
        v0.setStrokeWidth(v5 * 1.5f);
        v0.setStrokeCap(Paint$Cap.ROUND);
        this.cursorPaint = v0;
        this.boundsRect = new RectF();
        this.blinkReady = true;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
    }

    public static final boolean access$getBlinkRunning$p(TeclaEditorView arg0) {
        return arg0.blinkRunning;
    }

    public static final Handler access$getHandlerAnim$p(TeclaEditorView arg0) {
        return arg0.handlerAnim;
    }

    public static final boolean access$getMostrarCursor$p(TeclaEditorView arg0) {
        return arg0.mostrarCursor;
    }

    public static final void access$setMostrarCursor$p(TeclaEditorView arg0, boolean arg1) {
        arg0.mostrarCursor = arg1;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean v0 = true;
        this.blinkAttached = true;
        if(this.getWindowVisibility() == 0) {
        }
        else {
            v0 = false;
        }

        this.blinkWindowShown = v0;
        this.reconcileBlink();
    }

    protected void onDetachedFromWindow() {
        this.blinkAttached = false;
        this.reconcileBlink();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg15) {
        Intrinsics.checkNotNullParameter(arg15, "canvas");
        super.onDraw(arg15);
        float v1 = 2f;
        float v0 = this.borderPaint.getStrokeWidth() / v1;
        this.boundsRect.set(v0, v0, (((float)this.getWidth())) - v0, (((float)this.getHeight())) - v0);
        float v2 = this.density * 3f;
        arg15.drawRoundRect(this.boundsRect, v2, v2, this.bgPaint);
        arg15.drawRoundRect(this.boundsRect, v2, v2, this.borderPaint);
        float v3 = (((float)this.getWidth())) / v1;
        v0 = (((float)this.getHeight())) / v1;
        if(this.teclaTexto.length() != 0) {
            Canvas v2_1 = arg15;
            Rect v15 = new Rect();
            this.textPaint.getTextBounds(this.teclaTexto, 0, this.teclaTexto.length(), v15);
            float v4 = (((float)v15.height())) / v1 + v0;
            float v5 = this.density;
            v4 -= 0.5f * v5;
            v5 = this.mostrarCursor ? -(v5 * v1) : 0f;
            v3 += v5;
            v2_1.drawText(this.teclaTexto, v3, v4, this.textPaint);
            if(!this.mostrarCursor) {
                return;
            }

            float v9 = v3 + (((float)v15.width())) / v1 + this.density * 2.5f;
            float v15_1 = RangesKt.coerceAtLeast((((float)v15.height())) / v1, this.density * 6f);
            v2_1.drawLine(v9, v0 - v15_1, v9, v0 + v15_1, this.cursorPaint);
        }
        else if(this.mostrarCursor) {
            v2 = this.density * 7f;
            arg15.drawLine(v3, v0 - v2, v3, v0 + v2, this.cursorPaint);
            return;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        Companion v0 = TeclaEditorView.Companion;
        String v1 = v0.resolverNombreBotonRaton(arg3);
        if(v1 == null) {
            v1 = v0.resolverNombreScroll(arg3);
        }

        if(v1 != null) {
            this.recibirTecla(v1);
            return 1;
        }

        return super.onGenericMotionEvent(arg3);
    }

    public boolean onTouchEvent(MotionEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        String v0 = TeclaEditorView.Companion.resolverNombreBotonRaton(arg2);
        if(v0 != null) {
            this.recibirTecla(v0);
            return 1;
        }

        return super.onTouchEvent(arg2);
    }

    protected void onVisibilityChanged(View arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "changedView");
        super.onVisibilityChanged(arg2, arg3);
        this.reconcileBlink();
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        boolean v1 = arg1 == 0 ? true : false;
        this.blinkWindowShown = v1;
        this.reconcileBlink();
    }

    public final void recibirTecla(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "tecla");
        arg2 = StringsKt.trim(((CharSequence)arg2)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg2, "toUpperCase(...)");
        this.teclaTexto = arg2;
        this.invalidate();
        this.onTeclaAsignada.invoke(arg2);
    }

    private final void reconcileBlink() {
        boolean v0;
        if(!this.blinkReady) {
        }
        else {
            v0 = !this.blinkAttached || !this.blinkWindowShown || !this.isShown() ? false : true;
            if(this.blinkRunning != v0) {
                goto label_15;
            }
        }

        return;
    label_15:
        this.blinkRunning = v0;
        Handler v1 = this.handlerAnim;
        TeclaEditorView$blinkRunnable$1 v2 = this.blinkRunnable;
        if(v0) {
            v1.post(((Runnable)v2));
            return;
        }

        v1.removeCallbacks(((Runnable)v2));
    }

    public final void solicitarFocoTeclado() {
        this.requestFocus();
    }
}

