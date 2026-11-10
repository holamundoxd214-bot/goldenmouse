package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.TryJeanPc.goldenmouse.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenIconView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenIconView extends View {
    public static final int $stable = 8;
    private final Paint paint;
    private final Path path;
    private final RectF rect;

    static {
    }

    public GoldenIconView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenIconView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenIconView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.paint = new Paint(1);
        this.path = new Path();
        this.rect = new RectF();
    }

    protected void onDraw(Canvas arg23) {
        float v13;
        float v9;
        String v2_1;
        GoldenIconView v0 = this;
        Canvas v1 = arg23;
        Intrinsics.checkNotNullParameter(v1, "canvas");
        super.onDraw(arg23);
        Object v2 = v0.getTag();
        String v3 = "menu";
        if(v2 != null) {
            v2_1 = v2.toString();
            if(v2_1 == null) {
                goto label_10;
            }
        }
        else {
        label_10:
            v2_1 = v3;
        }

        String v4 = "search";
        boolean v5 = Intrinsics.areEqual(v2_1, v4);
        String v6 = "grid";
        boolean v7 = Intrinsics.areEqual(v2_1, v6);
        float v8 = 90f;
        if(v5) {
            v9 = 336f;
            goto label_18;
        }
        else if(v7) {
            v13 = v8;
        }
        else {
            v9 = 80f;
        label_18:
            v13 = v9;
        }

        if(!v5) {
            if(v7) {
            }
            else {
                v8 = 72f;
            }
        }

        v1.save();
        v1.scale((((float)v0.getWidth())) / v13, (((float)v0.getHeight())) / v8);
        v9 = 2f;
        v0.rect.set(v9, v9, v13 - v9, v8 - v9);
        v0.paint.setStyle(Paint$Style.FILL);
        float v18 = v8;
        v0.paint.setShader(new LinearGradient(0f, 0f, 0f, v18, 0xFF0B0C0E, -15132390, Shader$TileMode.CLAMP));
        RectF v8_1 = v0.rect;
        float v19 = 7f;
        float v10 = 45f;
        float v11 = (v5) || (v7) ? v10 : v19;
        float v12 = (v5) || (v7) ? v10 : v19;
        v1.drawRoundRect(v8_1, v11, v12, v0.paint);
        v0.paint.setStyle(Paint$Style.STROKE);
        v0.paint.setStrokeWidth(2.8f);
        v0.paint.setShader(new LinearGradient(0f, 0f, v13, v18, GoldenChromeViewsKt.edgeColors, null, Shader$TileMode.CLAMP));
        v8_1 = v0.rect;
        v10 = (v5) || (v7) ? 45f : v19;
        float v5_1 = (v5) || (v7) ? 45f : v19;
        v1.drawRoundRect(v8_1, v10, v5_1, v0.paint);
        v0.paint.setShader(null);
        v0.paint.setColor(0xFFDFD9CB);
        v0.paint.setStrokeWidth(4.4f);
        v0.paint.setStrokeCap(Paint$Cap.ROUND);
        v0.paint.setStrokeJoin(Paint$Join.ROUND);
        v0.path.reset();
        float v7_1 = 36f;
        v8 = 22f;
        v10 = 17f;
        v12 = 40f;
        v13 = 42f;
        float v14 = 24f;
        switch(v2_1.hashCode()) {
            case -906336856: {
                if(!v2_1.equals(v4)) {
                    goto label_346;
                }

                v1.drawCircle(43f, v13, v10, v0.paint);
                v1.drawLine(55f, 55f, 68f, 68f, v0.paint);
                v0.paint.setStyle(Paint$Style.FILL);
                v0.paint.setColor(0xFFAAA69E);
                v0.paint.setTextSize(35f);
                v0.paint.setTypeface(Typeface.create("sans-serif", 0));
                v1.drawText(v0.getContext().getString(string.gspace_search), 75f, 59f, v0.paint);
                break;
            }
            case -309425751: {
                if(!v2_1.equals("profile")) {
                    goto label_346;
                }

                v1.drawCircle(v12, 25f, 10f, v0.paint);
                v0.path.moveTo(v8, 56f);
                v0.path.cubicTo(22f, 34f, 58f, 34f, 58f, 56f);
                v1.drawPath(v0.path, v0.paint);
                break;
            }
            case 3127582: {
                if(!v2_1.equals("exit")) {
                    goto label_346;
                }

                v0.path.moveTo(32f, 18f);
                v0.path.lineTo(20f, 18f);
                v0.path.lineTo(20f, 54f);
                v0.path.lineTo(32f, 54f);
                v1.drawPath(v0.path, v0.paint);
                v1.drawLine(34f, 36f, 60f, 36f, v0.paint);
                v0.path.reset();
                v0.path.moveTo(48f, v14);
                v0.path.lineTo(60f, v7_1);
                v0.path.lineTo(48f, 48f);
                v1.drawPath(v0.path, v0.paint);
                break;
            }
            case 3181382: {
                if(!v2_1.equals(v6)) {
                    goto label_346;
                }

                int v2_2;
                for(v2_2 = 0; v2_2 < 2; ++v2_2) {
                    int v3_1;
                    for(v3_1 = 0; v3_1 < 2; ++v3_1) {
                        v5_1 = (((float)v3_1)) * v14;
                        v7_1 = (((float)v2_2)) * v14;
                        v0.rect.set(v5_1 + v14, v7_1 + v14, v5_1 + v12, v7_1 + v12);
                        v1.drawRoundRect(v0.rect, 4f, 4f, v0.paint);
                    }
                }
            }
            case 3347807: {
                if(!v2_1.equals(v3)) {
                    goto label_346;
                }

                v1.drawLine(23f, 23f, 58f, 23f, v0.paint);
                arg23.drawLine(23f, 36f, 58f, 36f, v0.paint);
                arg23.drawLine(23f, 49f, 45f, 49f, v0.paint);
                v1 = arg23;
                break;
            }
            case 109770977: {
                if(!v2_1.equals("store")) {
                    goto label_346;
                }

                v0.path.moveTo(21f, v8);
                v0.path.cubicTo(21f, 51f, 59f, 51f, 59f, 22f);
                v1.drawPath(v0.path, v0.paint);
                break;
            }
            case 637428636: {
                if(!v2_1.equals("controller")) {
                    goto label_346;
                }

                v0.paint.setStyle(Paint$Style.FILL);
                v0.rect.set(34f, v10, 46f, 30f);
                v1.drawRoundRect(v0.rect, v9, v9, v0.paint);
                v0.rect.set(34f, v13, 46f, 55f);
                v1.drawRoundRect(v0.rect, v9, v9, v0.paint);
                v0.rect.set(15f, 30f, 29f, v13);
                v1.drawRoundRect(v0.rect, v9, v9, v0.paint);
                v0.rect.set(51f, 30f, 65f, v13);
                v1.drawRoundRect(v0.rect, v9, v9, v0.paint);
                v1.save();
                v1.rotate(45f, v12, v7_1);
                arg23.drawRect(33f, 29f, 47f, 43f, v0.paint);
                v1 = arg23;
                v1.restore();
                break;
            }
            default: {
                break;
            }
        }

    label_346:
        v1.restore();
    }
}

