package com.TryJeanPc.goldenmouse.macro.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010=\u001A\u00020\u00112\u0006\u0010>\u001A\u00020 J\u0006\u0010?\u001A\u00020\u0011J\b\u0010E\u001A\u00020\u0011H\u0002J\b\u0010F\u001A\u00020\u0010H\u0002J\b\u0010G\u001A\u00020\u0011H\u0002J\u0017\u0010H\u001A\u00020)2\b\u0010I\u001A\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010JJ\u0010\u0010K\u001A\u00020L2\u0006\u0010M\u001A\u000200H\u0002J\u001A\u0010N\u001A\u0004\u0018\u0001002\u0006\u0010O\u001A\u00020 2\u0006\u0010P\u001A\u00020 H\u0002J\u0010\u0010Q\u001A\u00020\u00112\u0006\u0010R\u001A\u00020SH\u0014J\u0010\u0010T\u001A\u0002042\u0006\u0010U\u001A\u00020VH\u0016J\b\u0010W\u001A\u000204H\u0016R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR&\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00110\u001AX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010/\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00101\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u000204X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u000204X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u000204X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00108\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b9\u0010:R\u000E\u0010;\u001A\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001A\u0004\u0018\u00010AX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010B\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006X"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroTimelineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "model", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;", "getModel", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;", "setModel", "(Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;)V", "onEdit", "Lkotlin/Function1;", "", "", "getOnEdit", "()Lkotlin/jvm/functions/Function1;", "setOnEdit", "(Lkotlin/jvm/functions/Function1;)V", "onOptions", "getOnOptions", "setOnOptions", "onConflict", "Lkotlin/Function0;", "getOnConflict", "()Lkotlin/jvm/functions/Function0;", "setOnConflict", "(Lkotlin/jvm/functions/Function0;)V", "density", "", "scale", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroTimelineScale;", "labelWidth", "rulerHeight", "rowHeight", "paint", "Landroid/graphics/Paint;", "gold", "", "verticalOffset", "downX", "downY", "downOffsetX", "downOffsetY", "pressed", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "preview", "edge", "rulerGesture", "", "moved", "longPressed", "slop", "zoom", "getZoom", "()F", "detector", "Landroid/view/GestureDetector;", "setZoom", "value", "refresh", "indexedDraft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "trackRows", "", "lastActionEndMs", "updateDraftIndex", "horizon", "clampOffsets", "row", "track", "(Ljava/lang/Integer;)I", "bounds", "Landroid/graphics/RectF;", "a", "hit", "x", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroTimelineView extends View {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[MacroActionType.values().length];
            try {
                v0[MacroActionType.TAP.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[MacroActionType.SWIPE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[MacroActionType.DELAY.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[MacroActionType.LONG_PRESS.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final float density;
    private final GestureDetector detector;
    private float downOffsetX;
    private float downOffsetY;
    private float downX;
    private float downY;
    private int edge;
    private final int gold;
    private MacroDraft indexedDraft;
    private final float labelWidth;
    private long lastActionEndMs;
    private boolean longPressed;
    private MacroEditorModel model;
    private boolean moved;
    private Function0 onConflict;
    private Function1 onEdit;
    private Function1 onOptions;
    private final Paint paint;
    private MacroEditAction pressed;
    private MacroEditAction preview;
    private final float rowHeight;
    private boolean rulerGesture;
    private final float rulerHeight;
    private final MacroTimelineScale scale;
    private final int slop;
    private Map trackRows;
    private float verticalOffset;

    static {
    }

    public MacroTimelineView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public MacroTimelineView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public MacroTimelineView(Context arg4, AttributeSet arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        super(arg4, arg5);
        this.model = new MacroEditorModel(null, 1, null);
        this.onEdit = new MacroTimelineView$$ExternalSyntheticLambda0();
        this.onOptions = new MacroTimelineView$$ExternalSyntheticLambda1();
        this.onConflict = new MacroTimelineView$$ExternalSyntheticLambda2();
        float v5 = this.getResources().getDisplayMetrics().density;
        this.density = v5;
        this.scale = new MacroTimelineScale(v5);
        this.labelWidth = 72f * v5;
        this.rulerHeight = 28f * v5;
        this.rowHeight = v5 * 46f;
        this.paint = new Paint(1);
        this.gold = Color.rgb(0xFF, 210, 26);
        this.slop = ViewConfiguration.get(arg4).getScaledTouchSlop();
        this.detector = new GestureDetector(arg4, new MacroTimelineView$detector$1(this));
        this.setClickable(true);
        this.setFocusable(true);
        this.setContentDescription("Línea de tiempo de la macro");
        this.trackRows = MapsKt.emptyMap();
    }

    public static final boolean access$getMoved$p(MacroTimelineView arg0) {
        return arg0.moved;
    }

    public static final MacroEditAction access$getPressed$p(MacroTimelineView arg0) {
        return arg0.pressed;
    }

    public static final MacroEditAction access$hit(MacroTimelineView arg0, float arg1, float arg2) {
        return arg0.hit(arg1, arg2);
    }

    public static final void access$setLongPressed$p(MacroTimelineView arg0, boolean arg1) {
        arg0.longPressed = arg1;
    }

    private final RectF bounds(MacroEditAction arg8) {
        float v0 = this.labelWidth + this.scale.toPixel(arg8.getStartMs());
        float v1 = this.rulerHeight + (((float)this.row(arg8.getTrack()))) * this.rowHeight - this.verticalOffset + this.density * 6f;
        return new RectF(v0, v1, Math.max(this.density * 3f, (((float)arg8.getDurationMs())) * this.scale.getPixelsPerMs()) + v0, this.rowHeight + v1 - this.density * 12f);
    }

    private final void clampOffsets() {
        this.scale.setOffsetPx(RangesKt.coerceIn(this.scale.getOffsetPx(), 0f, RangesKt.coerceAtLeast((((float)this.horizon())) * this.scale.getPixelsPerMs() - (((float)this.getWidth())) + this.labelWidth, 0f)));
        this.verticalOffset = RangesKt.coerceIn(this.verticalOffset, 0f, RangesKt.coerceAtLeast((((float)(this.model.getDraft().getTracks().size() + 1))) * this.rowHeight - (((float)this.getHeight())) + this.rulerHeight, 0f));
    }

    public final MacroEditorModel getModel() {
        return this.model;
    }

    public final Function0 getOnConflict() {
        return this.onConflict;
    }

    public final Function1 getOnEdit() {
        return this.onEdit;
    }

    public final Function1 getOnOptions() {
        return this.onOptions;
    }

    public final float getZoom() {
        return this.scale.getZoom();
    }

    private final MacroEditAction hit(float arg5, float arg6) {
        Object v1_1;
        Object v2;
        MacroEditAction v1 = null;
        if(Float.compare(arg5, this.labelWidth) >= 0) {
            if(arg6 < this.rulerHeight) {
            }
            else {
                Iterator v0 = CollectionsKt.asReversed(this.model.getDraft().getActions()).iterator();
                do {
                    if(v0.hasNext()) {
                        v2 = v0.next();
                        if(!this.bounds(v2).contains(arg5, arg6)) {
                            continue;
                        }

                        break;
                    }

                    goto label_20;
                }
                while(true);

                v1_1 = v2;
            }
        }

    label_20:
        return ((MacroEditAction)v1_1);
    }

    private final long horizon() {
        this.updateDraftIndex();
        return RangesKt.coerceAtMost(Math.max(5000, Math.max(this.model.getSelectedTimeMs(), this.lastActionEndMs) + 2000), 86400000);
    }

    static final Unit onConflict$lambda$2() {
        return Unit.INSTANCE;
    }

    protected void onDraw(Canvas arg24) {
        RectF v14_1;
        Object v11_1;
        float v19;
        float v14;
        int v13_1;
        int v11;
        float v2_3;
        int v6;
        float v17;
        float v16;
        String v3_1;
        Long v2_1;
        long v10;
        MacroTimelineView v0 = this;
        Canvas v1 = arg24;
        Intrinsics.checkNotNullParameter(v1, "canvas");
        super.onDraw(arg24);
        v1.drawColor(Color.rgb(16, 16, 16));
        v0.paint.setStyle(Paint$Style.FILL);
        v0.paint.setStrokeWidth(v0.density);
        v0.paint.setTextSize(v0.getResources().getDisplayMetrics().scaledDensity * 10f);
        int v7 = 23;
        v0.paint.setColor(Color.rgb(v7, v7, v7));
        v1.drawRect(0f, 0f, ((float)v0.getWidth()), v0.rulerHeight, v0.paint);
        float v3 = v0.density * 90f / v0.scale.getPixelsPerMs();
        int v2 = 12;
        long[] v4 = new long[]{10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 30000, 60000};
        int v5 = 0;
        while(true) {
            if(v5 < v2) {
                v10 = v4[v5];
                if((((float)v10)) >= v3) {
                    v2_1 = Long.valueOf(v10);
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_50;
        }

        v2_1 = null;
    label_50:
        long v2_2 = v2_1 != null ? v2_1.longValue() : 60000;
        v10 = v2_2;
        v2_2 = v0.scale.toTime(0f) / v10 * v10;
        v1.save();
        v1.clipRect(v0.labelWidth, 0f, ((float)v0.getWidth()), ((float)v0.getHeight()));
        long v13 = v2_2;
        while(true) {
            v3_1 = "format(...)";
            v16 = 1000f;
            v17 = 4f;
            v6 = 0x30;
            if(Long.compare(v13, v0.horizon()) <= 0) {
                v2_3 = v0.labelWidth + v0.scale.toPixel(v13);
                if(v2_3 <= (((float)v0.getWidth()))) {
                    v0.paint.setColor(Color.rgb(v6, v6, v6));
                    String v4_1 = v3_1;
                    v1.drawLine(v2_3, v0.rulerHeight, v2_3, ((float)v0.getHeight()), v0.paint);
                    v0.paint.setColor(0xFFCCCCCC);
                    v3_1 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf((((float)v13)) / v16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(v3_1, v4_1);
                    v1.drawText(v3_1, v2_3 + v17 * v0.density, 18f * v0.density, v0.paint);
                    v13 += v10;
                    continue;
                }
            }

            break;
        }

        String v8 = v3_1;
        int v9 = 0xFFCCCCCC;
        float v18 = 18f;
        int v10_1 = v0.model.getDraft().getTracks().size();
        if(v10_1 >= 0) {
            v11 = 0;
            goto label_130;
        }
        else {
            v13_1 = v6;
            goto label_160;
            while(true) {
            label_130:
                v2_3 = v0.rulerHeight + (((float)v11)) * v0.rowHeight - v0.verticalOffset;
                v0.paint.setColor(Color.rgb(v6, v6, v6));
                v13_1 = v6;
                v1.drawLine(v0.labelWidth, v0.rowHeight + v2_3, ((float)v0.getWidth()), v2_3 + v0.rowHeight, v0.paint);
                if(v11 != v10_1) {
                    ++v11;
                    v6 = v13_1;
                    continue;
                }

                break;
            }
        }

    label_160:
        v1.save();
        v1.clipRect(v0.labelWidth, v0.rulerHeight, ((float)v0.getWidth()), ((float)v0.getHeight()));
        Iterator v10_2 = v0.model.getDraft().getActions().iterator();
        while(true) {
            v14 = 2f;
            if(!v10_2.hasNext()) {
                break;
            }

            Object v2_4 = v10_2.next();
            MacroEditAction v3_2 = v0.preview;
            if(v3_2 != null) {
                if(v3_2.getId() == ((MacroEditAction)v2_4).getId()) {
                }
                else {
                    v3_2 = null;
                }

                if(v3_2 == null) {
                    goto label_186;
                }

                MacroEditAction v2_5 = v3_2;
            }

        label_186:
            RectF v3_3 = v0.bounds(((MacroEditAction)v2_4));
            if(v3_3.right < v0.labelWidth) {
                continue;
            }

            if(v3_3.left > (((float)v0.getWidth()))) {
                continue;
            }

            if(v3_3.bottom < v0.rulerHeight) {
                continue;
            }

            if(v3_3.top > (((float)v0.getHeight()))) {
                continue;
            }

            v0.paint.setStyle(Paint$Style.FILL);
            Paint v4_2 = v0.paint;
            v5 = WhenMappings.$EnumSwitchMapping$0[((MacroEditAction)v2_4).getType().ordinal()];
            if(v5 == 1) {
                v19 = 6f;
                v5 = Color.rgb(40, 105, 190);
            }
            else if(v5 == 2) {
                v19 = 6f;
                v5 = Color.rgb(38, 0x87, 77);
            }
            else if(v5 == 3) {
                v19 = 6f;
                v5 = Color.rgb(0x72, 58, 0xA0);
            }
            else if(v5 == 4) {
                v19 = 6f;
                v5 = Color.rgb(0xC0, 85, 0x20);
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            v4_2.setColor(v5);
            v1.drawRoundRect(v3_3, v17 * v0.density, v0.density * v17, v0.paint);
            long v4_3 = ((MacroEditAction)v2_4).getId();
            Long v6_1 = v0.model.getSelectedActionId();
            if(v6_1 == null) {
                goto label_316;
            }
            else if(v4_3 == v6_1.longValue()) {
                v0.paint.setStyle(Paint$Style.STROKE);
                v0.paint.setStrokeWidth(v14 * v0.density);
                v0.paint.setColor(v0.gold);
                v1.drawRoundRect(v3_3, v17 * v0.density, v0.density * v17, v0.paint);
                v0.paint.setStyle(Paint$Style.FILL);
                v11_1 = v2_4;
                v14_1 = v3_3;
                v1.drawRect(v3_3.left, v3_3.top + v0.density * 8f, v3_3.left + v0.density * 3f, v3_3.bottom - v0.density * 8f, v0.paint);
                v1 = arg24;
                v1.drawRect(v14_1.right - 3f * v0.density, v0.density * 8f + v14_1.top, v14_1.right, v14_1.bottom - v0.density * 8f, v0.paint);
            }
            else {
            label_316:
                v11_1 = v2_4;
                v14_1 = v3_3;
            }

            v1.save();
            v1.clipRect(v14_1);
            v0.paint.setColor(-1);
            v1.drawText(((MacroEditAction)v11_1).getType().getLabel(), v14_1.left + v19 * v0.density, v14_1.centerY() + v0.density * v17, v0.paint);
            v1.restore();
        }

        v19 = 6f;
        v1.restore();
        v0.paint.setColor(v0.gold);
        v0.paint.setStrokeWidth(v0.density * v14);
        v2_3 = v0.labelWidth + v0.scale.toPixel(v0.model.getSelectedTimeMs());
        v1.drawLine(v2_3, v0.rulerHeight, v2_3, ((float)v0.getHeight()), v0.paint);
        arg24.restore();
        v0.paint.setStyle(Paint$Style.FILL);
        v0.paint.setColor(Color.rgb(v7, v7, v7));
        v1 = arg24;
        v1.drawRect(0f, v0.rulerHeight, v0.labelWidth, ((float)v0.getHeight()), v0.paint);
        v1.save();
        v1.clipRect(0f, v0.rulerHeight, v0.labelWidth, ((float)v0.getHeight()));
        v7 = v0.model.getDraft().getTracks().size();
        if(v7 >= 0) {
            for(v10_1 = 0; true; ++v10_1) {
                v2_3 = v0.rulerHeight + (((float)v10_1)) * v0.rowHeight - v0.verticalOffset;
                v0.paint.setColor(v9);
                v3_1 = v10_1 == 0 ? "Global" : "Dedo " + v0.model.getDraft().getTracks().get(v10_1 - 1);
                v1.drawText(v3_1, v19 * v0.density, v0.rowHeight / v14 + v2_3 + v0.density * v17, v0.paint);
                v0.paint.setColor(Color.rgb(v13_1, v13_1, v13_1));
                v1.drawLine(0f, v2_3 + v0.rowHeight, v0.labelWidth, v0.rowHeight + v2_3, v0.paint);
                if(v10_1 == v7) {
                    break;
                }
            }
        }

        v1.restore();
        v0.paint.setColor(v0.gold);
        v0.paint.setTextSize(v0.getResources().getDisplayMetrics().scaledDensity * 9f);
        String v2_6 = String.format(Locale.US, "%.3f s", Arrays.copyOf(new Object[]{Float.valueOf((((float)v0.model.getSelectedTimeMs())) / v16)}, 1));
        Intrinsics.checkNotNullExpressionValue(v2_6, v8);
        v1.drawText(v2_6, v17 * v0.density, v18 * v0.density, v0.paint);
    }

    static final Unit onEdit$lambda$0(long arg0) {
        return Unit.INSTANCE;
    }

    static final Unit onOptions$lambda$1(long arg0) {
        return Unit.INSTANCE;
    }

    public boolean onTouchEvent(MotionEvent arg22) {
        ViewParent v1_1;
        Integer v5_1;
        long v2_2;
        long v13;
        MacroTimelineView v0 = this;
        MotionEvent v1 = arg22;
        Intrinsics.checkNotNullParameter(v1, "event");
        v0.detector.onTouchEvent(v1);
        int v2 = v1.getActionMasked();
        int v3 = -1;
        int v4 = 0;
        MacroEditAction v5 = null;
        if(v2 == 0) {
            ViewParent v2_3 = v0.getParent();
            if(v2_3 != null) {
                v2_3.requestDisallowInterceptTouchEvent(true);
            }

            v0.downX = v1.getX();
            v0.downY = v1.getY();
            v0.downOffsetX = v0.scale.getOffsetPx();
            v0.downOffsetY = v0.verticalOffset;
            v0.pressed = v0.hit(v1.getX(), v1.getY());
            v0.preview = v5;
            v0.moved = false;
            v0.longPressed = false;
            boolean v2_4 = v1.getY() >= v0.rulerHeight || v1.getX() < v0.labelWidth ? false : true;
            v0.rulerGesture = v2_4;
            MacroEditAction v2_5 = v0.pressed;
            if(v2_5 != null) {
                RectF v2_6 = v0.bounds(v2_5);
                float v7 = Math.min(8f * v0.density, v2_6.width() / 3f);
                if(v1.getX() - v2_6.left < v7) {
                }
                else if(v2_6.right - v1.getX() < v7) {
                    v3 = 1;
                }
                else {
                    v3 = 0;
                }

                v4 = v3;
            }

            v0.edge = v4;
            MacroEditorModel v2_7 = v0.model;
            MacroEditAction v3_1 = v0.pressed;
            if(v3_1 != null) {
                Long v5_3 = Long.valueOf(v3_1.getId());
            }

            v2_7.setSelectedActionId(((Long)v5));
            if(v0.rulerGesture) {
                v0.model.selectTime(v0.scale.toTime(v1.getX() - v0.labelWidth));
            }

            v0.invalidate();
        }
        else if(v2 == 1) {
            if(!v0.longPressed && (v0.moved)) {
                MacroEditAction v1_3 = v0.preview;
                if(v1_3 != null && !MacroEditorModel.edit$default(v0.model, v1_3.getId(), v1_3.getStartMs(), v1_3.getDurationMs(), v1_3.getTrack(), null, 16, null)) {
                    v0.onConflict.invoke();
                }
            }

            if(!v0.moved) {
                v0.performClick();
            }

            v0.preview = v5;
            v0.pressed = v5;
            v1_1 = v0.getParent();
            if(v1_1 != null) {
                v1_1.requestDisallowInterceptTouchEvent(false);
            }

            v0.refresh();
        }
        else if(v2 == 2) {
            if(v0.longPressed) {
                return 1;
            }

            float v2_1 = v1.getX() - v0.downX;
            float v4_1 = v1.getY() - v0.downY;
            if(Math.abs(v2_1) > (((float)v0.slop)) || Math.abs(v4_1) > (((float)v0.slop))) {
                v0.moved = true;
            }

            MacroEditAction v8 = v0.pressed;
            if(v0.rulerGesture) {
                v0.model.selectTime(v0.scale.toTime(v1.getX() - v0.labelWidth));
            }
            else {
                if(v8 != null && (v0.moved)) {
                    long v9 = ((long)(v2_1 / v0.scale.getPixelsPerMs()));
                    v2 = v0.edge;
                    long v11 = 86400000;
                    if(v2 == v3) {
                        v13 = RangesKt.coerceIn(v8.getStartMs() + v9, 0, v8.getEndMs() - 1);
                    }
                    else {
                        v13 = v8.getStartMs();
                        if(v2 == 0) {
                            v13 = RangesKt.coerceIn(v13 + v9, 0, v11 - v8.getDurationMs());
                        }
                    }

                    v2 = v0.edge;
                    if(v2 == v3) {
                        v2_2 = v8.getEndMs() - v13;
                    }
                    else if(v2 != 1) {
                        v2_2 = v8.getDurationMs();
                    }
                    else {
                        v2_2 = RangesKt.coerceIn(v8.getDurationMs() + v9, 1, v11 - v13);
                    }

                    int v1_2 = ((int)(((float)Math.floor(((double)((v1.getY() - v0.rulerHeight + v0.verticalOffset) / v0.rowHeight))))));
                    if(v0.edge != 0) {
                        v5_1 = v8.getTrack();
                    }
                    else {
                        if(v1_2 == 0 && v8.getType() == MacroActionType.DELAY) {
                            goto label_106;
                        }

                        if(1 <= v1_2 && v1_2 <= v0.model.getDraft().getTracks().size()) {
                            Object v5_2 = v0.model.getDraft().getTracks().get(v1_2 - 1);
                            goto label_106;
                        }

                        v5_1 = v8.getTrack();
                    }

                label_106:
                    Integer v16 = ((Integer)v5);
                    v0.preview = MacroEditAction.copy$default(v8, 0, null, v13, v2_2, v16, null, 35, null);
                    goto label_148;
                }

                if(!v0.moved) {
                    goto label_148;
                }

                v0.scale.setOffsetPx(v0.downOffsetX - v2_1);
                v0.verticalOffset = v0.downOffsetY - v4_1;
                v0.clampOffsets();
            }

        label_148:
            v0.invalidate();
        }
        else if(v2 != 3) {
        }
        else {
            v0.preview = v5;
            v0.pressed = v5;
            v1_1 = v0.getParent();
            if(v1_1 != null) {
                v1_1.requestDisallowInterceptTouchEvent(false);
            }

            v0.invalidate();
        }

        return 1;
    }

    public boolean performClick() {
        super.performClick();
        return 1;
    }

    public final void refresh() {
        this.clampOffsets();
        this.invalidate();
    }

    private final int row(Integer arg2) {
        this.updateDraftIndex();
        if(arg2 == null) {
            return 0;
        }

        Object v1 = this.trackRows.get(arg2);
        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        return 0;
    }

    public final void setModel(MacroEditorModel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.model = arg2;
    }

    public final void setOnConflict(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onConflict = arg2;
    }

    public final void setOnEdit(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onEdit = arg2;
    }

    public final void setOnOptions(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.onOptions = arg2;
    }

    public final void setZoom(float arg6) {
        this.scale.setZoom(arg6, this.model.getSelectedTimeMs(), RangesKt.coerceAtLeast((((float)this.getWidth())) - this.labelWidth, 1f));
        this.clampOffsets();
        this.invalidate();
    }

    private final void updateDraftIndex() {
        Long v1_2;
        MacroDraft v0 = this.model.getDraft();
        if(this.indexedDraft == v0) {
            return;
        }

        Iterable v1 = CollectionsKt.withIndex(v0.getTracks());
        LinkedHashMap v3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(v1, 10)), 16));
        Iterator v1_1 = v1.iterator();
        while(v1_1.hasNext()) {
            Object v2 = v1_1.next();
            Pair v2_1 = TuplesKt.to(((IndexedValue)v2).getValue(), Integer.valueOf(((IndexedValue)v2).getIndex() + 1));
            ((Map)v3).put(v2_1.getFirst(), v2_1.getSecond());
        }

        this.trackRows = ((Map)v3);
        v1_1 = v0.getActions().iterator();
        if(!v1_1.hasNext()) {
            v1_2 = null;
        }
        else {
            Long v2_2;
            for(v2_2 = Long.valueOf(v1_1.next().getEndMs()); v1_1.hasNext(); v2_2 = v3_1) {
                Long v3_1 = Long.valueOf(v1_1.next().getEndMs());
                if(((Comparable)v2_2).compareTo(v3_1) >= 0) {
                    continue;
                }
            }

            v1_2 = v2_2;
        }

        long v1_3 = v1_2 != null ? v1_2.longValue() : 0;
        this.lastActionEndMs = v1_3;
        this.indexedDraft = v0;
    }
}

