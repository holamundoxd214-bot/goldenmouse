package com.TryJeanPc.goldenmouse.controls;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.SeekBar$OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$style;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing$Binding;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing;
import com.TryJeanPc.goldenmouse.ui.WindowSizingConfig;
import com.TryJeanPc.goldenmouse.ui.WindowType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002!\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u007F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0014\u0010\u0012\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00050\u00132\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00132\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ4\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0012\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0013H\u0002¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickComponentSettingsDialog;", "", "<init>", "()V", "show", "", "context", "Landroid/content/Context;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "currentBindings", "", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "keysVisible", "", "onPreviewRadius", "Lkotlin/Function1;", "", "onToggleKeysVisible", "onSave", "Lcom/TryJeanPc/goldenmouse/controls/JoystickSettingsEdit;", "show$app", "configureRadioWindow", "dialog", "Landroid/app/Dialog;", "configureRadioWindow$app", "setupKeyDialog", "slot", "currentKey", "onKeySelected", "EditorPreview", "Form", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickComponentSettingsDialog {
    @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u000B¢\u0006\u0002\u0010\u0019J&\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\u000BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickComponentSettingsDialog$EditorPreview;", "", "view", "Landroid/view/View;", "canvas", "Landroid/widget/FrameLayout;", "geometry", "Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry;", "<init>", "(Landroid/view/View;Landroid/widget/FrameLayout;Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry;)V", "originalX", "", "originalY", "originalWidth", "", "originalHeight", "originalScreen", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "positionObserver", "Landroid/view/ViewTreeObserver;", "pendingPosition", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "showRadius", "", "radius", "(Ljava/lang/Float;)V", "setGeometry", "width", "height", "x", "y", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorPreview {
        public static final int $stable = 8;
        private final FrameLayout canvas;
        private final EditorControlGeometry geometry;
        private final int originalHeight;
        private final ControlVisualState originalScreen;
        private final int originalWidth;
        private final float originalX;
        private final float originalY;
        private ViewTreeObserver$OnGlobalLayoutListener pendingPosition;
        private ViewTreeObserver positionObserver;
        private final View view;

        static {
        }

        public EditorPreview(View arg3, FrameLayout arg4, EditorControlGeometry arg5) {
            ControlVisualState v4_1;
            Intrinsics.checkNotNullParameter(arg3, "view");
            Intrinsics.checkNotNullParameter(arg4, "canvas");
            super();
            this.view = arg3;
            this.canvas = arg4;
            this.geometry = arg5;
            this.originalX = arg3.getX();
            this.originalY = arg3.getY();
            this.originalWidth = arg3.getLayoutParams().width;
            this.originalHeight = arg3.getLayoutParams().height;
            Object v4 = null;
            if(arg5 != null) {
                v4_1 = EditorControlGeometry.snapshot$default(arg5, arg3, false, 2, v4);
            }

            this.originalScreen = v4_1;
        }

        public EditorPreview(View arg1, FrameLayout arg2, EditorControlGeometry arg3, int arg4, DefaultConstructorMarker arg5) {
            if((arg4 & 4) != 0) {
                arg3 = null;
            }

            this(arg1, arg2, arg3);
        }

        public static final FrameLayout access$getCanvas$p(EditorPreview arg0) {
            return arg0.canvas;
        }

        public static final ViewTreeObserver$OnGlobalLayoutListener access$getPendingPosition$p(EditorPreview arg0) {
            return arg0.pendingPosition;
        }

        public static final View access$getView$p(EditorPreview arg0) {
            return arg0.view;
        }

        public static final void access$setPendingPosition$p(EditorPreview arg0, ViewTreeObserver$OnGlobalLayoutListener arg1) {
            arg0.pendingPosition = arg1;
        }

        public static final void access$setPositionObserver$p(EditorPreview arg0, ViewTreeObserver arg1) {
            arg0.positionObserver = arg1;
        }

        public final void setGeometry(int arg9, int arg10, float arg11, float arg12) {
            if(this.view.getParent() != this.canvas) {
                return;
            }

            EditorControlGeometry v2 = this.geometry;
            if(v2 != null) {
                v2.resizeAndPlaceLocal(this.view, arg9, arg10, arg11, arg12);
                return;
            }

            int v4 = arg9;
            int v5 = arg10;
            float v6 = arg11;
            float v7 = arg12;
            ViewTreeObserver$OnGlobalLayoutListener v9 = this.pendingPosition;
            if(v9 != null) {
                ViewTreeObserver v10 = this.positionObserver;
                if(v10 != null) {
                    if(v10.isAlive()) {
                    }
                    else {
                        v10 = null;
                    }

                    if(v10 == null) {
                        goto label_28;
                    }

                    v10.removeOnGlobalLayoutListener(v9);
                }
            }

        label_28:
            ViewTreeObserver v9_1 = this.view.getViewTreeObserver();
            JoystickComponentSettingsDialog$EditorPreview$setGeometry$listener$1 v10_1 = new JoystickComponentSettingsDialog$EditorPreview$setGeometry$listener$1(this, v9_1, v6, v7);
            this.pendingPosition = ((ViewTreeObserver$OnGlobalLayoutListener)v10_1);
            this.positionObserver = v9_1;
            v9_1.addOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)v10_1));
            View v9_2 = this.view;
            ViewGroup$LayoutParams v10_2 = v9_2.getLayoutParams();
            v10_2.width = v4;
            v10_2.height = v5;
            v9_2.setLayoutParams(v10_2);
            this.view.setX(v6);
            this.view.setY(v7);
            this.view.requestLayout();
        }

        public final void showRadius(Float arg6) {
            if(arg6 == null) {
                if(this.originalScreen != null && this.geometry != null) {
                    View v6 = this.view;
                    ViewGroup$LayoutParams v0 = v6.getLayoutParams();
                    v0.width = this.originalWidth;
                    v0.height = this.originalHeight;
                    v6.setLayoutParams(v0);
                    this.geometry.place(this.view, this.originalScreen.getX(), this.originalScreen.getY());
                    return;
                }

                this.setGeometry(this.originalWidth, this.originalHeight, this.originalX, this.originalY);
                return;
            }

            int v6_1 = ((int)(arg6.floatValue() * 3f));
            int[] v0_1 = new int[2];
            this.canvas.getLocationOnScreen(v0_1);
            DisplayMetrics v1 = this.view.getResources().getDisplayMetrics();
            this.setGeometry(v6_1, v6_1, RangesKt.coerceAtLeast((((float)(Math.min(this.canvas.getWidth(), v1.widthPixels - (((int)(300f * v1.density))) - v0_1[0]) - v6_1))) / 2f, 0f), RangesKt.coerceAtLeast((((float)(this.canvas.getHeight() - v6_1))) / 2f, 0f));
        }
    }

    @Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0014\u0010\u000E\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000F\u0012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u000F\u0012\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u000F\u0012\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012,\u0010\u0017\u001A(\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00110\u000F\u0012\u0004\u0012\u00020\u00110\u0018\u0012\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u000F¢\u0006\u0004\b\u001A\u0010\u001BJ\b\u00108\u001A\u00020\u0011H\u0002J\u0010\u00109\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u0010H\u0002J\u0010\u0010:\u001A\u00020\r2\u0006\u0010;\u001A\u00020(H\u0002J;\u0010<\u001A\u0004\u0018\u00010\u00102\u0006\u0010;\u001A\u00020(2\u0006\u0010=\u001A\u00020\u00102\u0012\u0010>\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000F2\u0006\u0010?\u001A\u00020\nH\u0002¢\u0006\u0002\u0010@J\'\u0010A\u001A\u0004\u0018\u00010B2\u0006\u0010;\u001A\u00020(2\u0006\u0010=\u001A\u00020B2\u0006\u0010C\u001A\u00020BH\u0002¢\u0006\u0002\u0010DJ\b\u0010E\u001A\u00020\u0011H\u0002J)\u0010F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00162\u0006\u0010G\u001A\u00020\u00032\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0000¢\u0006\u0002\bIJ\u0010\u0010J\u001A\u00020\u00112\u0006\u0010K\u001A\u00020\rH\u0002J\u0006\u0010L\u001A\u00020\u0011R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00110\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0017\u001A(\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00110\u000F\u0012\u0004\u0012\u00020\u00110\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u001D\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\r@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u000E\u0010\u001F\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010&\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\'\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001A\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001A\n )*\u0004\u0018\u00010000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001A\n )*\u0004\u0018\u00010000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001A\n )*\u0004\u0018\u00010303X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u00104\u001A\u0010\u0012\f\u0012\n )*\u0004\u0018\u0001030305X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00106\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0705X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/JoystickComponentSettingsDialog$Form;", "", "root", "Landroid/view/View;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;", "originalBindings", "", "", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "originalKeysVisible", "", "onPreviewRadius", "Lkotlin/Function1;", "", "", "onToggleKeysVisible", "onSave", "Lcom/TryJeanPc/goldenmouse/controls/JoystickSettingsEdit;", "onClose", "Lkotlin/Function0;", "onSelectKey", "Lkotlin/Function3;", "onAdjustRadius", "<init>", "(Landroid/view/View;Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;Lcom/TryJeanPc/goldenmouse/profile/JoystickComponent;Ljava/util/Map;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "value", "isClosed", "()Z", "radioActive", "bindings", "", "radius", "diagonal", "preset", "", "initialTexts", "x", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "y", "speed", "pause", "smoothing", "initialRadius", "sprint", "Landroid/widget/Switch;", "socd", "radiusText", "Landroid/widget/TextView;", "presets", "", "directions", "Lkotlin/Triple;", "renderDirections", "number", "changed", "field", "readFloat", "original", "valid", "error", "(Landroid/widget/EditText;FLkotlin/jvm/functions/Function1;Ljava/lang/String;)Ljava/lang/Float;", "readTime", "", "maximum", "(Landroid/widget/EditText;JJ)Ljava/lang/Long;", "apply", "bindRadioContent", "content", "onCloseRadio", "bindRadioContent$app", "finish", "applied", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Form {
        public static final int $stable = 8;
        private final Map bindings;
        private float diagonal;
        private final List directions;
        private final EditText initialRadius;
        private final Map initialTexts;
        private boolean isClosed;
        private final Function1 onAdjustRadius;
        private final Function0 onClose;
        private final Function1 onPreviewRadius;
        private final Function1 onSave;
        private final Function3 onSelectKey;
        private final Function1 onToggleKeysVisible;
        private final Map originalBindings;
        private final boolean originalKeysVisible;
        private final EditText pause;
        private final ComponentPlacement placement;
        private int preset;
        private final List presets;
        private boolean radioActive;
        private float radius;
        private final TextView radiusText;
        private final View root;
        private final JoystickComponent settings;
        private final EditText smoothing;
        private final Switch socd;
        private final EditText speed;
        private final Switch sprint;
        private final EditText x;
        private final EditText y;

        static {
        }

        public Form(View arg4, ComponentPlacement arg5, JoystickComponent arg6, Map arg7, boolean arg8, Function1 arg9, Function1 arg10, Function1 arg11, Function0 arg12, Function3 arg13, Function1 arg14) {
            Object v5_1;
            Iterator v4_2;
            Intrinsics.checkNotNullParameter(arg4, "root");
            Intrinsics.checkNotNullParameter(arg5, "placement");
            Intrinsics.checkNotNullParameter(arg6, "settings");
            Intrinsics.checkNotNullParameter(arg7, "originalBindings");
            Intrinsics.checkNotNullParameter(arg9, "onPreviewRadius");
            Intrinsics.checkNotNullParameter(arg10, "onToggleKeysVisible");
            Intrinsics.checkNotNullParameter(arg11, "onSave");
            Intrinsics.checkNotNullParameter(arg12, "onClose");
            Intrinsics.checkNotNullParameter(arg13, "onSelectKey");
            Intrinsics.checkNotNullParameter(arg14, "onAdjustRadius");
            super();
            this.root = arg4;
            this.placement = arg5;
            this.settings = arg6;
            this.originalBindings = arg7;
            this.originalKeysVisible = arg8;
            this.onPreviewRadius = arg9;
            this.onToggleKeysVisible = arg10;
            this.onSave = arg11;
            this.onClose = arg12;
            this.onSelectKey = arg13;
            this.onAdjustRadius = arg14;
            this.bindings = MapsKt.toMutableMap(arg7);
            this.radius = arg6.getRadius();
            this.diagonal = arg6.getDiagonalAngleDeg();
            int v5 = 2;
            this.preset = v5;
            this.initialTexts = new LinkedHashMap();
            this.x = arg4.findViewById(id.editPosicionJoystickX);
            this.y = arg4.findViewById(id.editPosicionJoystickY);
            this.speed = arg4.findViewById(id.editVelocidadAlcanceJoystick);
            this.pause = arg4.findViewById(id.editPausaCentroJoystick);
            this.smoothing = arg4.findViewById(id.editSuavizadoJoystick);
            this.initialRadius = arg4.findViewById(id.editRadioInicioJoystick);
            this.sprint = arg4.findViewById(id.switchSprintJoystick);
            this.socd = arg4.findViewById(id.switchSocdJoystick);
            this.radiusText = arg4.findViewById(id.txtRadioBaseJoystick);
            int v4 = 3;
            Integer[] v6 = new Integer[v4];
            int v8 = 0;
            v6[0] = Integer.valueOf(id.btnDireccionWASD);
            v6[1] = Integer.valueOf(id.btnDireccionFlechas);
            v6[v5] = Integer.valueOf(id.btnDireccionPersonalizado);
            List v6_1 = CollectionsKt.listOf(((Object[])v6));
            int v10 = 10;
            ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6_1), v10));
            Iterator v6_2 = ((Iterable)v6_1).iterator();
            while(v6_2.hasNext()) {
                ((Collection)v7).add(this.root.findViewById(v6_2.next().intValue()));
            }

            this.presets = ((List)v7);
            int v6_3 = 4;
            Triple[] v7_1 = new Triple[v6_3];
            String v14 = "UP";
            v7_1[0] = new Triple(v14, Integer.valueOf(id.btnTeclaArribaJoystick), "ARRIBA");
            String v0 = "LEFT";
            v7_1[1] = new Triple(v0, Integer.valueOf(id.btnTeclaIzquierdaJoystick), "IZQUIERDA");
            String v1 = "DOWN";
            v7_1[v5] = new Triple(v1, Integer.valueOf(id.btnTeclaAbajoJoystick), "ABAJO");
            String v2 = "RIGHT";
            v7_1[v4] = new Triple(v2, Integer.valueOf(id.btnTeclaDerechaJoystick), "DERECHA");
            this.directions = CollectionsKt.listOf(((Object[])v7_1));
            EditText[] v7_2 = new EditText[v5];
            v7_2[0] = this.x;
            v7_2[1] = this.y;
            Iterator v7_3 = CollectionsKt.listOf(((Object[])v7_2)).iterator();
            while(v7_3.hasNext()) {
                v7_3.next().setInputType(0x3002);
            }

            this.initialRadius.setInputType(0x2002);
            Pair[] v7_4 = new Pair[6];
            v7_4[0] = TuplesKt.to(this.x, this.number(this.placement.getX()));
            v7_4[1] = TuplesKt.to(this.y, this.number(this.placement.getY()));
            v7_4[v5] = TuplesKt.to(this.speed, this.number(this.settings.getMovementSpeed()));
            v7_4[v4] = TuplesKt.to(this.pause, String.valueOf(this.settings.getActivationTimeMs()));
            v7_4[v6_3] = TuplesKt.to(this.smoothing, String.valueOf(this.settings.getSmoothingMs()));
            v7_4[5] = TuplesKt.to(this.initialRadius, this.number(this.settings.getRadius1() * 100f));
            v7_3 = CollectionsKt.listOf(((Object[])v7_4)).iterator();
            while(v7_3.hasNext()) {
                Object v11 = v7_3.next();
                Object v12 = ((Pair)v11).component1();
                ((EditText)v12).setText(((Pair)v11).component2());
                ((EditText)v12).setShowSoftInputOnFocus(false);
                this.initialTexts.put(Integer.valueOf(((EditText)v12).getId()), ((EditText)v12).getText().toString());
            }

            this.radiusText.setText(this.number(this.radius) + " px");
            this.sprint.setChecked(this.settings.getSprintEnabled());
            this.socd.setChecked(this.settings.getSocdEnabled());
            View v7_5 = this.root.findViewById(id.switchMostrarTeclasJoystick);
            ((Switch)v7_5).setChecked(this.originalKeysVisible);
            ((Switch)v7_5).setOnCheckedChangeListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda15(this));
            v7_5 = this.root.findViewById(id.switchAjustesAvanzadosJoystick);
            View v11_1 = this.root.findViewById(id.groupAjustesAvanzadosJoystick);
            int v12_1 = ((Switch)v7_5).isChecked() ? 0 : 8;
            v11_1.setVisibility(v12_1);
            ((Switch)v7_5).setOnCheckedChangeListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda1(this, v11_1));
            v7_5 = this.root.findViewById(id.txtAnguloDiagonalJoystick);
            v11_1 = this.root.findViewById(id.seekAnguloDiagonalJoystick);
            ((SeekBar)v11_1).setMin(v10);
            ((SeekBar)v11_1).setMax(75);
            ((SeekBar)v11_1).setProgress(RangesKt.coerceIn(MathKt.roundToInt(this.settings.getDiagonalAngleDeg()), v10, 75));
            ((TextView)v7_5).setText(this.number(this.diagonal) + "°");
            ((SeekBar)v11_1).setOnSeekBarChangeListener(new SeekBar$OnSeekBarChangeListener(((TextView)v7_5)) {
                public void onProgressChanged(SeekBar arg1, int arg2, boolean arg3) {
                    if(!Form.this.isClosed()) {
                        Form.access$setDiagonal$p(Form.this, ((float)arg2));
                        this.$angle.setText(arg2 + "°");
                    }
                }

                public void onStartTrackingTouch(SeekBar arg1) {
                }

                public void onStopTrackingTouch(SeekBar arg1) {
                }
            });
            List v7_6 = this.directions;
            ArrayList v11_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7_6), v10));
            v7_3 = ((Iterable)v7_6).iterator();
            while(v7_3.hasNext()) {
                Object v10_1 = this.bindings.get(v7_3.next().getFirst());
                if(v10_1 != null) {
                    String v10_2 = ((InputBinding)v10_1).displayName();
                }
                else {
                    v10_1 = null;
                }

                ((Collection)v11_2).add(v10_1);
            }

            String[] v7_7 = new String[v6_3];
            v7_7[0] = "W";
            v7_7[1] = "A";
            v7_7[v5] = "S";
            v7_7[v4] = "D";
            if(Intrinsics.areEqual(v11_2, CollectionsKt.listOf(((Object[])v7_7)))) {
                v5 = 0;
            }
            else {
                String[] v6_4 = new String[v6_3];
                v6_4[0] = v14;
                v6_4[1] = v0;
                v6_4[v5] = v1;
                v6_4[v4] = v2;
                List v4_1 = CollectionsKt.zip(((Iterable)v11_2), CollectionsKt.listOf(((Object[])v6_4)));
                if(!(v4_1 instanceof Collection) || !v4_1.isEmpty()) {
                    v4_2 = ((Iterable)v4_1).iterator();
                    while(v4_2.hasNext()) {
                        Object v6_5 = v4_2.next();
                        Object v7_8 = ((Pair)v6_5).component1();
                        v6_5 = ((Pair)v6_5).component2();
                        if(Intrinsics.areEqual(v7_8, v6_5)) {
                            continue;
                        }

                        if(Intrinsics.areEqual(v7_8, "DPAD_" + (((String)v6_5)))) {
                            continue;
                        }
                        else {
                            goto label_331;
                        }
                    }
                }
                else {
                }

                v5 = 1;
            }

        label_331:
            this.preset = v5;
            v4_2 = this.presets.iterator();
            while(v4_2.hasNext()) {
                v5_1 = v4_2.next();
                v6_3 = v8 + 1;
                if(v8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                ((TextView)v5_1).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda2(this, v8));
                v8 = v6_3;
            }

            v4_2 = this.directions.iterator();
            while(v4_2.hasNext()) {
                v5_1 = v4_2.next();
                this.root.findViewById(((Triple)v5_1).component2().intValue()).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda3(this, ((Triple)v5_1).component3(), ((Triple)v5_1).component1()));
            }

            this.renderDirections();
            this.root.findViewById(id.btnAjustarRadioJoystick).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda4(this));
            this.root.findViewById(id.btnCancelarJoystick).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda5(this));
            this.root.findViewById(id.btnAplicarJoystick).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda6(this));
        }

        static final void _init_$lambda$13(Form arg0, View arg1) {
            if(!arg0.isClosed && !arg0.radioActive) {
                arg0.onAdjustRadius.invoke(arg0);
            }
        }

        static final void _init_$lambda$14(Form arg0, View arg1) {
            arg0.close();
        }

        static final void _init_$lambda$15(Form arg0, View arg1) {
            arg0.apply();
        }

        static final void _init_$lambda$3(Form arg1, CompoundButton arg2, boolean arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<unused var>");
            if(!arg1.isClosed) {
                arg1.onToggleKeysVisible.invoke(Boolean.valueOf(arg3));
            }
        }

        static final void _init_$lambda$4(Form arg1, View arg2, CompoundButton arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg3, "<unused var>");
            if(!arg1.isClosed) {
                int v1 = arg4 ? 0 : 8;
                arg2.setVisibility(v1);
            }
        }

        public static final Function1 access$getOnPreviewRadius$p(Form arg0) {
            return arg0.onPreviewRadius;
        }

        public static final String access$number(Form arg0, float arg1) {
            return arg0.number(arg1);
        }

        public static final void access$setDiagonal$p(Form arg0, float arg1) {
            arg0.diagonal = arg1;
        }

        private final void apply() {
            Float v23;
            Float v17;
            Float v16;
            Form v0 = this;
            if(!v0.isClosed) {
                if(v0.radioActive) {
                }
                else {
                    EditText v1 = v0.x;
                    Intrinsics.checkNotNullExpressionValue(v1, "x");
                    String v4 = "Introduce una coordenada finita";
                    Float v1_1 = v0.readFloat(v1, v0.placement.getX(), new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda7(), v4);
                    if(v1_1 != null) {
                        float v6 = v1_1.floatValue();
                        v1 = v0.y;
                        Intrinsics.checkNotNullExpressionValue(v1, "y");
                        v1_1 = v0.readFloat(v1, v0.placement.getY(), new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda8(), v4);
                        if(v1_1 != null) {
                            float v7 = v1_1.floatValue();
                            v1 = v0.speed;
                            Intrinsics.checkNotNullExpressionValue(v1, "speed");
                            v1_1 = v0.readFloat(v1, v0.settings.getMovementSpeed(), new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda9(), "El alcance debe ser positivo y finito");
                            if(v1_1 != null) {
                                float v8 = v1_1.floatValue();
                                v1 = v0.pause;
                                Intrinsics.checkNotNullExpressionValue(v1, "pause");
                                Long v1_2 = v0.readTime(v1, v0.settings.getActivationTimeMs(), 10000);
                                if(v1_2 != null) {
                                    long v9 = v1_2.longValue();
                                    v1 = v0.smoothing;
                                    Intrinsics.checkNotNullExpressionValue(v1, "smoothing");
                                    v1_2 = v0.readTime(v1, v0.settings.getSmoothingMs(), 1000);
                                    if(v1_2 != null) {
                                        long v1_3 = v1_2.longValue();
                                        EditText v3 = v0.initialRadius;
                                        v4 = "initialRadius";
                                        Intrinsics.checkNotNullExpressionValue(v3, v4);
                                        float v11 = 100f;
                                        Float v3_1 = v0.readFloat(v3, v0.settings.getRadius1() * v11, new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda10(), "Usa de 10 a 100 %");
                                        if(v3_1 != null) {
                                            float v3_2 = v3_1.floatValue();
                                            Float v5 = Float.valueOf(v6);
                                            int v12 = 0;
                                            int v6_1 = Float.compare(v5.floatValue(), v0.placement.getX()) == 0 ? 1 : 0;
                                            Object v14 = null;
                                            if(v6_1 == 0) {
                                            }
                                            else {
                                                v5 = ((Float)v14);
                                            }

                                            if(v5 != null) {
                                                v5 = Float.valueOf(((float)MathKt.roundToInt(v5.floatValue())));
                                                v6_1 = v5.floatValue() == v0.placement.getX() ? 1 : 0;
                                                if(v6_1 != 0) {
                                                    goto label_101;
                                                }

                                                v16 = v5;
                                            }
                                            else {
                                            label_101:
                                                v16 = ((Float)v14);
                                            }

                                            v5 = Float.valueOf(v7);
                                            v6_1 = v5.floatValue() == v0.placement.getY() ? 1 : 0;
                                            if(v6_1 == 0) {
                                            }
                                            else {
                                                v5 = ((Float)v14);
                                            }

                                            if(v5 != null) {
                                                v5 = Float.valueOf(((float)MathKt.roundToInt(v5.floatValue())));
                                                v6_1 = v5.floatValue() == v0.placement.getY() ? 1 : 0;
                                                if(v6_1 != 0) {
                                                    goto label_130;
                                                }

                                                v17 = v5;
                                            }
                                            else {
                                            label_130:
                                                v17 = ((Float)v14);
                                            }

                                            v5 = Float.valueOf(v0.radius);
                                            v6_1 = v5.floatValue() == v0.settings.getRadius() ? 1 : 0;
                                            Float v18 = v6_1 == 0 ? v5 : ((Float)v14);
                                            v5 = Float.valueOf(v8);
                                            v6_1 = v5.floatValue() == v0.settings.getMovementSpeed() ? 1 : 0;
                                            Float v19 = v6_1 == 0 ? v5 : ((Float)v14);
                                            Long v5_1 = Long.valueOf(v9);
                                            Long v20 = v5_1.longValue() != v0.settings.getActivationTimeMs() ? v5_1 : ((Long)v14);
                                            v5 = Float.valueOf(v0.diagonal);
                                            v6_1 = v5.floatValue() == v0.settings.getDiagonalAngleDeg() ? 1 : 0;
                                            Float v21 = v6_1 == 0 ? v5 : ((Float)v14);
                                            v1_2 = Long.valueOf(v1_3);
                                            boolean v2 = v1_2.longValue() != v0.settings.getSmoothingMs() ? true : false;
                                            Long v22 = Boolean.valueOf(v2).booleanValue() ? v1_2 : ((Long)v14);
                                            v1 = v0.initialRadius;
                                            Intrinsics.checkNotNullExpressionValue(v1, v4);
                                            if(!v0.changed(v1) || v3_2 == v0.settings.getRadius1() * v11) {
                                            label_216:
                                                v23 = ((Float)v14);
                                            }
                                            else {
                                                v1_1 = Float.valueOf(v3_2 / v11);
                                                if(v1_1.floatValue() == v0.settings.getRadius1()) {
                                                    v12 = 1;
                                                }

                                                if(v12 != 0) {
                                                    goto label_216;
                                                }

                                                v23 = v1_1;
                                            }

                                            Boolean v1_4 = Boolean.valueOf(v0.sprint.isChecked());
                                            Boolean v24 = v1_4.booleanValue() != v0.settings.getSprintEnabled() ? v1_4 : ((Boolean)v14);
                                            v1_4 = Boolean.valueOf(v0.socd.isChecked());
                                            Boolean v25 = v1_4.booleanValue() != v0.settings.getSocdEnabled() ? v1_4 : ((Boolean)v14);
                                            Map v1_5 = v0.bindings;
                                            LinkedHashMap v2_1 = new LinkedHashMap();
                                            Iterator v1_6 = v1_5.entrySet().iterator();
                                            while(v1_6.hasNext()) {
                                                Object v3_3 = v1_6.next();
                                                if(Intrinsics.areEqual(((Map$Entry)v3_3).getValue(), v0.originalBindings.get(((Map$Entry)v3_3).getKey()))) {
                                                    continue;
                                                }

                                                ((Map)v2_1).put(((Map$Entry)v3_3).getKey(), ((Map$Entry)v3_3).getValue());
                                            }

                                            JoystickSettingsEdit v15 = new JoystickSettingsEdit(v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v2_1);
                                            if(v15.isEmpty()) {
                                                v0.onPreviewRadius.invoke(v14);
                                                v0.finish(true);
                                                return;
                                            }

                                            if(!v0.onSave.invoke(v15).booleanValue()) {
                                                return;
                                            }

                                            v0.finish(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        static final boolean apply$lambda$19(float arg0) {
            return 1;
        }

        static final boolean apply$lambda$20(float arg0) {
            return 1;
        }

        static final boolean apply$lambda$21(float arg1) {
            if(arg1 > 0f) {
                return 1;
            }

            return 0;
        }

        static final boolean apply$lambda$22(float arg2) {
            if(Float.compare(10f, arg2) <= 0 && arg2 <= 100f) {
                return 1;
            }

            return 0;
        }

        public final Function0 bindRadioContent$app(View arg9, Function0 arg10) {
            Intrinsics.checkNotNullParameter(arg9, "content");
            Intrinsics.checkNotNullParameter(arg10, "onCloseRadio");
            if(!this.isClosed && !this.radioActive) {
                this.radioActive = true;
                float v5 = this.radius;
                FloatRef v4 = new FloatRef();
                v4.element = this.radius;
                BooleanRef v2 = new BooleanRef();
                View v0 = arg9.findViewById(id.txtRadioJoystickValor);
                View v1 = arg9.findViewById(id.seekRadioJoystick);
                ((SeekBar)v1).setMin(20);
                ((SeekBar)v1).setMax(300);
                ((SeekBar)v1).setProgress(RangesKt.coerceIn(MathKt.roundToInt(this.radius), 20, 300));
                ((TextView)v0).setText(this.number(this.radius));
                this.onPreviewRadius.invoke(Float.valueOf(this.radius));
                ((SeekBar)v1).setOnSeekBarChangeListener(new JoystickComponentSettingsDialog$Form$bindRadioContent$1(v2, this, v4, ((TextView)v0)));
                arg9.findViewById(id.btnCancelarRadio).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda11(v2, this, v4, v5, arg10));
                arg9.findViewById(id.btnAplicarRadio).setOnClickListener(new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda12(v2, this, v4, v5, arg10));
                return new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda13(v2, this, v4, v5, arg10);
            }

            throw new IllegalStateException("Check failed.");
        }

        private static final void bindRadioContent$finishRadio(BooleanRef arg2, Form arg3, FloatRef arg4, float arg5, Function0 arg6, boolean arg7) {
            if(arg2.element) {
                return;
            }

            int v0 = 1;
            arg2.element = true;
            arg3.radioActive = false;
            if(!arg3.isClosed) {
                if(arg7) {
                    arg5 = arg4.element;
                }

                arg3.radius = arg5;
                arg3.radiusText.setText(arg3.number(arg5) + " px");
                Function1 v4 = arg3.onPreviewRadius;
                Float v5 = Float.valueOf(arg3.radius);
                if(v5.floatValue() == arg3.settings.getRadius()) {
                }
                else {
                    v0 = 0;
                }

                if(v0 == 0) {
                }
                else {
                    Object v5_1 = null;
                }

                v4.invoke(v5);
            }

            arg6.invoke();
        }

        static final void bindRadioContent$lambda$37(BooleanRef arg0, Form arg1, FloatRef arg2, float arg3, Function0 arg4, View arg5) {
            Form.bindRadioContent$finishRadio(arg0, arg1, arg2, arg3, arg4, false);
        }

        static final void bindRadioContent$lambda$38(BooleanRef arg0, Form arg1, FloatRef arg2, float arg3, Function0 arg4, View arg5) {
            Form.bindRadioContent$finishRadio(arg0, arg1, arg2, arg3, arg4, true);
        }

        static final Unit bindRadioContent$lambda$39(BooleanRef arg6, Form arg7, FloatRef arg8, float arg9, Function0 arg10) {
            Form.bindRadioContent$finishRadio(arg6, arg7, arg8, arg9, arg10, false);
            return Unit.INSTANCE;
        }

        private final boolean changed(EditText arg2) {
            return Intrinsics.areEqual(arg2.getText().toString(), MapsKt.getValue(this.initialTexts, Integer.valueOf(arg2.getId()))) ^ 1;
        }

        public final void close() {
            this.finish(false);
        }

        private final void finish(boolean arg2) {
            if(this.isClosed) {
                return;
            }

            this.isClosed = true;
            if(!arg2) {
                this.onPreviewRadius.invoke(null);
                this.onToggleKeysVisible.invoke(Boolean.valueOf(this.originalKeysVisible));
            }

            this.onClose.invoke();
        }

        public final boolean isClosed() {
            return this.isClosed;
        }

        static final void lambda$12$lambda$11(Form arg2, String arg3, String arg4, View arg5) {
            if(!arg2.isClosed && arg2.preset == 2) {
                arg2.onSelectKey.invoke(arg3, arg2.bindings.get(arg4), new JoystickComponentSettingsDialog$Form$$ExternalSyntheticLambda14(arg2, arg4));
            }
        }

        static final Unit lambda$12$lambda$11$lambda$10(Form arg2, String arg3, InputBinding arg4) {
            Intrinsics.checkNotNullParameter(arg4, "selected");
            if(!arg2.isClosed && arg2.preset == 2) {
                arg2.bindings.put(arg3, arg4);
                arg2.renderDirections();
            }

            return Unit.INSTANCE;
        }

        static final void lambda$9$lambda$8(Form arg4, int arg5, View arg6) {
            List v5_1;
            String[] v5;
            if(!arg4.isClosed) {
                arg4.preset = arg5;
                int v6 = 2;
                if(arg5 != v6) {
                    int v0 = 3;
                    int v3 = 4;
                    if(arg5 == 0) {
                        v5 = new String[v3];
                        v5[0] = "W";
                        v5[1] = "A";
                        v5[v6] = "S";
                        v5[v0] = "D";
                        v5_1 = CollectionsKt.listOf(((Object[])v5));
                    }
                    else {
                        v5 = new String[v3];
                        v5[0] = "UP";
                        v5[1] = "LEFT";
                        v5[v6] = "DOWN";
                        v5[v0] = "RIGHT";
                        v5_1 = CollectionsKt.listOf(((Object[])v5));
                    }

                    Iterator v5_2 = CollectionsKt.zip(arg4.directions, ((Iterable)v5_1)).iterator();
                    while(v5_2.hasNext()) {
                        Object v6_1 = v5_2.next();
                        arg4.bindings.put(((Pair)v6_1).component1().getFirst(), InputBinding.Companion.keyboard(((Pair)v6_1).component2()));
                    }
                }

                arg4.renderDirections();
            }
        }

        private final String number(float arg2) {
            if(Math.abs(arg2) <= 3.402823E+38f) {
                String v1 = VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.valueOf(arg2))).toPlainString();
                Intrinsics.checkNotNull(v1);
                return v1;
            }

            return String.valueOf(arg2);
        }

        private final Float readFloat(EditText arg3, float arg4, Function1 arg5, String arg6) {
            CharSequence v0 = null;
            arg3.setError(v0);
            if(!this.changed(arg3)) {
                return Float.valueOf(arg4);
            }

            Float v2 = StringsKt.toFloatOrNull(arg3.getText().toString());
            if(v2 != null && Math.abs(v2.floatValue()) <= 3.402823E+38f) {
                if(!arg5.invoke(v2).booleanValue()) {
                }
                else {
                    return v2;
                }
            }

            arg3.setError(((CharSequence)arg6));
            return ((Float)v0);
        }

        private final Long readTime(EditText arg4, long arg5, long arg7) {
            CharSequence v0 = null;
            arg4.setError(v0);
            if(!this.changed(arg4)) {
                return Long.valueOf(arg5);
            }

            Long v3 = StringsKt.toLongOrNull(arg4.getText().toString());
            if(v3 != null) {
                if(!new LongRange(0, arg7).contains(v3.longValue())) {
                }
                else {
                    return v3;
                }
            }

            arg4.setError("Usa de 0 a " + arg7 + " ms");
            return ((Long)v0);
        }

        private final void renderDirections() {
            String v3_1;
            Object v3;
            Iterator v0 = this.presets.iterator();
            int v2;
            for(v2 = 0; true; v2 = v5) {
                boolean v4 = true;
                if(!v0.hasNext()) {
                    break;
                }

                v3 = v0.next();
                int v5 = v2 + 1;
                if(v2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                if(this.preset == v2) {
                }
                else {
                    v4 = false;
                }

                ((TextView)v3).setSelected(v4);
                int v4_1 = this.preset == v2 ? drawable.bg_view_button_gold : drawable.bg_vista_premium_field;
                ((TextView)v3).setBackgroundResource(v4_1);
                String v2_1 = this.preset == v2 ? "#111111" : "#ECECEC";
                ((TextView)v3).setTextColor(Color.parseColor(v2_1));
            }

            v0 = this.directions.iterator();
            while(v0.hasNext()) {
                Object v2_2 = v0.next();
                v3 = ((Triple)v2_2).component1();
                View v2_3 = this.root.findViewById(((Triple)v2_2).component2().intValue());
                v3 = this.bindings.get(v3);
                if(v3 != null) {
                    v3_1 = ((InputBinding)v3).displayName();
                    if(v3_1 != null) {
                    }
                    else {
                        goto label_47;
                    }
                }
                else {
                label_47:
                    v3_1 = "SIN ASIGNAR";
                }

                ((TextView)v2_3).setText(((CharSequence)v3_1));
                boolean v3_2 = this.preset == 2 ? true : false;
                ((TextView)v2_3).setEnabled(v3_2);
            }
        }
    }

    public static final int $stable;
    public static final JoystickComponentSettingsDialog INSTANCE;

    static {
        JoystickComponentSettingsDialog.INSTANCE = new JoystickComponentSettingsDialog();
    }

    private JoystickComponentSettingsDialog() {
        super();
    }

    public final void configureRadioWindow$app(Dialog arg5) {
        Intrinsics.checkNotNullParameter(arg5, "dialog");
        Window v4 = arg5.getWindow();
        if(v4 == null) {
            return;
        }

        DisplayMetrics v5 = arg5.getContext().getResources().getDisplayMetrics();
        int v0 = ((int)(8f * v5.density));
        v4.setBackgroundDrawable(new ColorDrawable(0));
        v4.setType(0x7F6);
        v4.clearFlags(2);
        v4.setDimAmount(0f);
        v4.setGravity(0x800015);
        WindowManager$LayoutParams v2 = v4.getAttributes();
        v2.x = v0;
        v4.setAttributes(v2);
        v4.setLayout(Math.min(((int)(284f * v5.density)), v5.widthPixels - v0 * 2), -2);
    }

    private final Dialog setupKeyDialog(Context arg11, String arg12, String arg13, Function1 arg14) {
        JoystickComponentSettingsDialog$$ExternalSyntheticLambda9 v10 = new JoystickComponentSettingsDialog$$ExternalSyntheticLambda9(arg11);
        Dialog v0 = new Dialog(arg11);
        v0.requestWindowFeature(1);
        LinearLayout v2 = new LinearLayout(arg11);
        v2.setOrientation(1);
        v2.setGravity(17);
        Integer v4 = Integer.valueOf(20);
        int v5 = ((Function1)v10).invoke(v4).intValue();
        Integer v6 = Integer.valueOf(16);
        v2.setPadding(v5, ((Function1)v10).invoke(v6).intValue(), ((Function1)v10).invoke(v4).intValue(), ((Function1)v10).invoke(v6).intValue());
        GradientDrawable v4_1 = new GradientDrawable();
        v4_1.setShape(0);
        v4_1.setColor(Color.parseColor("#1E1E1E"));
        v4_1.setStroke(((Function1)v10).invoke(Integer.valueOf(1)).intValue(), Color.parseColor("#FFD700"));
        v6 = Integer.valueOf(12);
        v4_1.setCornerRadius(((float)((Function1)v10).invoke(v6).intValue()));
        v2.setBackground(((Drawable)v4_1));
        TextView v4_2 = new TextView(arg11);
        v4_2.setText("Presiona una tecla para: " + arg12);
        v4_2.setTextColor(-1);
        v4_2.setTextSize(14f);
        v4_2.setTypeface(Typeface.DEFAULT_BOLD);
        v4_2.setPadding(0, 0, 0, ((Function1)v10).invoke(v6).intValue());
        EditText v8 = new EditText(arg11);
        v8.setText(((CharSequence)arg13));
        v8.setTextColor(Color.parseColor("#FFD700"));
        v8.setTextSize(20f);
        v8.setGravity(17);
        v8.setTypeface(Typeface.DEFAULT_BOLD);
        GradientDrawable v13 = new GradientDrawable();
        v13.setShape(0);
        v13.setColor(Color.parseColor("#292929"));
        v13.setCornerRadius(((float)((Function1)v10).invoke(Integer.valueOf(8)).intValue()));
        v8.setBackground(((Drawable)v13));
        v8.setLayoutParams(new LinearLayout$LayoutParams(((Function1)v10).invoke(Integer.valueOf(120)).intValue(), ((Function1)v10).invoke(Integer.valueOf(0x30)).intValue()));
        v8.setSelectAllOnFocus(true);
        v8.setOnKeyListener(new JoystickComponentSettingsDialog$$ExternalSyntheticLambda10(v8, arg14, v0));
        Button v13_1 = new Button(arg11);
        v13_1.setText("CERRAR");
        v13_1.setTextSize(12f);
        v13_1.setTypeface(Typeface.DEFAULT_BOLD);
        v13_1.setTextColor(0xFF000000);
        GradientDrawable v11 = new GradientDrawable();
        v11.setShape(0);
        v11.setColor(-1);
        v11.setCornerRadius(((float)((Function1)v10).invoke(Integer.valueOf(14)).intValue()));
        v13_1.setBackground(((Drawable)v11));
        LinearLayout$LayoutParams v11_1 = new LinearLayout$LayoutParams(((Function1)v10).invoke(Integer.valueOf(90)).intValue(), ((Function1)v10).invoke(Integer.valueOf(0x20)).intValue());
        v11_1.topMargin = ((Function1)v10).invoke(v6).intValue();
        v13_1.setLayoutParams(((ViewGroup$LayoutParams)v11_1));
        v13_1.setOnClickListener(new JoystickComponentSettingsDialog$$ExternalSyntheticLambda1(v0));
        v2.addView(((View)v4_2));
        v2.addView(v8);
        v2.addView(((View)v13_1));
        v0.setContentView(((View)v2));
        Window v10_1 = v0.getWindow();
        if(v10_1 != null) {
            v10_1.setBackgroundDrawable(new ColorDrawable(0));
        }

        v10_1 = v0.getWindow();
        if(v10_1 != null) {
            v10_1.setType(0x7F6);
        }

        SessionOverlayWindowsKt.showSessionDialog(v0);
        Context v10_2 = v0.getContext();
        Intrinsics.checkNotNullExpressionValue(v10_2, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v10_2);
        v8.requestFocus();
        return v0;
    }

    static final boolean setupKeyDialog$lambda$15$lambda$14(EditText arg0, Function1 arg1, Dialog arg2, View arg3, int arg4, KeyEvent arg5) {
        if(arg5.getAction() == 0) {
            String v3 = KeyEvent.keyCodeToString(arg4);
            Intrinsics.checkNotNullExpressionValue(v3, "keyCodeToString(...)");
            v3 = StringsKt.removePrefix(v3, "KEYCODE_");
            arg0.setText(v3);
            arg1.invoke(v3);
            arg2.dismiss();
            return 1;
        }

        return 0;
    }

    static final void setupKeyDialog$lambda$19$lambda$18(Dialog arg0, View arg1) {
        arg0.dismiss();
    }

    static final int setupKeyDialog$lambda$9(Context arg0, int arg1) {
        return ((int)((((float)arg1)) * arg0.getResources().getDisplayMetrics().density));
    }

    public final void show$app(Context arg15, ComponentPlacement arg16, JoystickComponent arg17, Map arg18, boolean arg19, Function1 arg20, Function1 arg21, Function1 arg22) {
        Intrinsics.checkNotNullParameter(arg15, "context");
        ComponentPlacement v3 = arg16;
        Intrinsics.checkNotNullParameter(v3, "placement");
        JoystickComponent v4 = arg17;
        Intrinsics.checkNotNullParameter(v4, "settings");
        Map v5 = arg18;
        Intrinsics.checkNotNullParameter(v5, "currentBindings");
        Function1 v7 = arg20;
        Intrinsics.checkNotNullParameter(v7, "onPreviewRadius");
        Function1 v8 = arg21;
        Intrinsics.checkNotNullParameter(v8, "onToggleKeysVisible");
        Function1 v9 = arg22;
        Intrinsics.checkNotNullParameter(v9, "onSave");
        Dialog v0 = new Dialog(arg15);
        v0.requestWindowFeature(1);
        Window v1 = v0.getWindow();
        if(v1 != null) {
            v1.setWindowAnimations(style.VistaJoystickWindowAnimations);
        }

        View v2 = LayoutInflater.from(arg15).inflate(layout.configurar_joystick, null);
        ObjectRef v1_1 = new ObjectRef();
        ObjectRef v6 = new ObjectRef();
        Intrinsics.checkNotNull(v2);
        v0.setOnDismissListener(new JoystickComponentSettingsDialog$$ExternalSyntheticLambda4(new Form(v2, v3, v4, v5, arg19, v7, v8, v9, new JoystickComponentSettingsDialog$$ExternalSyntheticLambda0(v1_1, v6, v0), new JoystickComponentSettingsDialog$$ExternalSyntheticLambda2(v1_1, arg15), new JoystickComponentSettingsDialog$$ExternalSyntheticLambda3(arg15, v6, v0))));
        v0.setContentView(v2);
        Window v14 = v0.getWindow();
        if(v14 != null) {
            v14.setBackgroundDrawable(new ColorDrawable(0));
        }

        v14 = v0.getWindow();
        if(v14 != null) {
            v14.setType(0x7F6);
        }

        v14 = v0.getWindow();
        if(v14 != null) {
            v14.setGravity(17);
        }

        Binding v14_1 = AdaptiveWindowSizing.INSTANCE.bind(v0, WindowType.LARGE_FORM, new WindowSizingConfig(null, null, 0, 0, Integer.valueOf(840), null, null, Float.valueOf(0.94f), 0x6F, null), true);
        SessionOverlayWindowsKt.showSessionDialog(v0);
        v14_1.refresh();
        Context v14_2 = v0.getContext();
        Intrinsics.checkNotNullExpressionValue(v14_2, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v14_2);
    }

    static final Unit show$lambda$0(ObjectRef arg0, ObjectRef arg1, Dialog arg2) {
        Object v0 = arg0.element;
        if(v0 != null) {
            ((Dialog)v0).dismiss();
        }

        v0 = arg1.element;
        if(v0 != null) {
            ((Dialog)v0).dismiss();
        }

        arg2.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit show$lambda$2(ObjectRef arg2, Context arg3, String arg4, InputBinding arg5, Function1 arg6) {
        String v5;
        Intrinsics.checkNotNullParameter(arg4, "slot");
        Intrinsics.checkNotNullParameter(arg6, "selected");
        Object v0 = arg2.element;
        if(v0 != null) {
            ((Dialog)v0).dismiss();
        }

        JoystickComponentSettingsDialog v0_1 = JoystickComponentSettingsDialog.INSTANCE;
        if(arg5 != null) {
            v5 = arg5.displayName();
            if(v5 == null) {
                goto label_11;
            }
        }
        else {
        label_11:
            v5 = "SIN ASIGNAR";
        }

        arg2.element = v0_1.setupKeyDialog(arg3, arg4, v5, new JoystickComponentSettingsDialog$$ExternalSyntheticLambda8(arg6));
        return Unit.INSTANCE;
    }

    static final Unit show$lambda$2$lambda$1(Function1 arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        InputBinding v2 = InputBinding.Companion.fromDisplayName(arg2);
        if(v2 != null) {
            arg1.invoke(v2);
        }

        return Unit.INSTANCE;
    }

    static final Unit show$lambda$6(Context arg5, ObjectRef arg6, Dialog arg7, Form arg8) {
        Intrinsics.checkNotNullParameter(arg8, "owner");
        Dialog v0 = new Dialog(arg5);
        v0.requestWindowFeature(1);
        View v2 = LayoutInflater.from(arg5).inflate(layout.dialog_radio_joystick, null);
        Intrinsics.checkNotNull(v2);
        Function0 v3 = arg8.bindRadioContent$app(v2, new JoystickComponentSettingsDialog$$ExternalSyntheticLambda5(v0));
        v0.setContentView(v2);
        JoystickComponentSettingsDialog v2_1 = JoystickComponentSettingsDialog.INSTANCE;
        v2_1.configureRadioWindow$app(v0);
        v0.setOnCancelListener(new JoystickComponentSettingsDialog$$ExternalSyntheticLambda6(v3));
        v0.setOnDismissListener(new JoystickComponentSettingsDialog$$ExternalSyntheticLambda7(v3, arg6, arg8, arg7));
        arg6.element = v0;
        SessionOverlayWindowsKt.hideSessionDialog(arg7);
        try {
            SessionOverlayWindowsKt.showSessionDialog(v0);
            v2_1.configureRadioWindow$app(v0);
            Context v6 = v0.getContext();
            Intrinsics.checkNotNullExpressionValue(v6, "getContext(...)");
            CursorOverlayOrderKt.bringCursorAboveWindow(v6);
        }
        catch(Exception ) {
            v3.invoke();
            if(!arg8.isClosed()) {
                SessionOverlayWindowsKt.showSessionDialog(arg7);
            }

            Toast.makeText(arg5, "No se pudo abrir Radio Base", 1).show();
        }

        return Unit.INSTANCE;
    }

    static final Unit show$lambda$6$lambda$3(Dialog arg0) {
        arg0.dismiss();
        return Unit.INSTANCE;
    }

    static final void show$lambda$6$lambda$4(Function0 arg0, DialogInterface arg1) {
        arg0.invoke();
    }

    static final void show$lambda$6$lambda$5(Function0 arg0, ObjectRef arg1, Form arg2, Dialog arg3, DialogInterface arg4) {
        arg0.invoke();
        arg1.element = null;
        if(!arg2.isClosed()) {
            SessionOverlayWindowsKt.showSessionDialog(arg3);
            Context v0 = arg3.getContext();
            Intrinsics.checkNotNullExpressionValue(v0, "getContext(...)");
            CursorOverlayOrderKt.bringCursorAboveWindow(v0);
        }
    }

    static final void show$lambda$7(Form arg0, DialogInterface arg1) {
        arg0.close();
    }
}

