package androidx.core.view;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A5\u0010\u0000\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\b\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\t\u001A\u00020\n*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\u000B\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\f\u001A\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001A5\u0010\r\u001A\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u000E\u001A\u00020\u000F2\b\b\u0003\u0010\u0010\u001A\u00020\u000F2\b\b\u0003\u0010\u0011\u001A\u00020\u000F2\b\b\u0003\u0010\u0012\u001A\u00020\u000FH\u0086\b\u001A5\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0014\u001A\u00020\u000F2\b\b\u0003\u0010\u0010\u001A\u00020\u000F2\b\b\u0003\u0010\u0015\u001A\u00020\u000F2\b\b\u0003\u0010\u0012\u001A\u00020\u000FH\u0086\b\u001A\u0017\u0010\u0016\u001A\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0017\u001A\u00020\u000FH\u0086\b\u001A(\u0010\u0018\u001A\u00020\u0019*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u001B2\u000E\b\u0004\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u001CH\u0086\bø\u0001\u0000\u001A \u0010\u001D\u001A\u00020\u0019*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u001C\u001A\u0014\u0010\u001E\u001A\u00020\u001F*\u00020\u00022\b\b\u0002\u0010 \u001A\u00020!\u001A)\u0010,\u001A\u00020\u0001*\u00020\u00022\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b/H\u0086\bø\u0001\u0000\u001A:\u0010,\u001A\u00020\u0001\"\n\b\u0000\u00100\u0018\u0001*\u00020.*\u00020\u00022\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b/H\u0087\bø\u0001\u0000¢\u0006\u0002\b1\"*\u0010$\u001A\u00020#*\u00020\u00022\u0006\u0010\"\u001A\u00020#8Æ\u0002@Æ\u0002X\u0086\u000E¢\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'\"*\u0010(\u001A\u00020#*\u00020\u00022\u0006\u0010\"\u001A\u00020#8Æ\u0002@Æ\u0002X\u0086\u000E¢\u0006\f\u001A\u0004\b(\u0010%\"\u0004\b)\u0010\'\"*\u0010*\u001A\u00020#*\u00020\u00022\u0006\u0010\"\u001A\u00020#8Æ\u0002@Æ\u0002X\u0086\u000E¢\u0006\f\u001A\u0004\b*\u0010%\"\u0004\b+\u0010\'\"\u0016\u00102\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b3\u00104\"\u0016\u00105\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b6\u00104\"\u0016\u00107\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b8\u00104\"\u0016\u00109\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b:\u00104\"\u0016\u0010;\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b<\u00104\"\u0016\u0010=\u001A\u00020\u000F*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b>\u00104\"\u001B\u0010?\u001A\b\u0012\u0004\u0012\u00020A0@*\u00020\u00028F¢\u0006\u0006\u001A\u0004\bB\u0010C\"\u001B\u0010D\u001A\b\u0012\u0004\u0012\u00020\u00020@*\u00020\u00028F¢\u0006\u0006\u001A\u0004\bE\u0010C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, d2={"doOnNextLayout", "", "Landroid/view/View;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "doOnAttach", "doOnDetach", "updatePaddingRelative", "start", "", "top", "end", "bottom", "updatePadding", "left", "right", "setPadding", "size", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "value", "", "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isGone", "setGone", "updateLayoutParams", "block", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "T", "updateLayoutParamsTyped", "marginLeft", "getMarginLeft", "(Landroid/view/View;)I", "marginTop", "getMarginTop", "marginRight", "getMarginRight", "marginBottom", "getMarginBottom", "marginStart", "getMarginStart", "marginEnd", "getMarginEnd", "ancestors", "Lkotlin/sequences/Sequence;", "Landroid/view/ViewParent;", "getAncestors", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "allViews", "getAllViews", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewKt {
    public static final void doOnAttach(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        if(arg1.isAttachedToWindow()) {
            arg2.invoke(arg1);
            return;
        }

        arg1.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(arg1, arg2));
    }

    public static final void doOnDetach(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        if(!arg1.isAttachedToWindow()) {
            arg2.invoke(arg1);
            return;
        }

        arg1.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(arg1, arg2));
    }

    public static final void doOnLayout(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        if((arg1.isLaidOut()) && !arg1.isLayoutRequested()) {
            arg2.invoke(arg1);
            return;
        }

        arg1.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(arg2));
    }

    public static final void doOnNextLayout(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        arg1.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(arg2));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        OneShotPreDrawListener v1 = OneShotPreDrawListener.add(arg1, new ViewKt$doOnPreDraw$1(arg2, arg1));
        Intrinsics.checkNotNullExpressionValue(v1, "add(...)");
        return v1;
    }

    public static final Bitmap drawToBitmap(View arg3, Bitmap$Config arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "config");
        if(arg3.isLaidOut()) {
            Bitmap v4 = Bitmap.createBitmap(arg3.getWidth(), arg3.getHeight(), arg4);
            Intrinsics.checkNotNullExpressionValue(v4, "createBitmap(...)");
            Canvas v0 = new Canvas(v4);
            v0.translate(-(((float)arg3.getScrollX())), -(((float)arg3.getScrollY())));
            arg3.draw(v0);
            return v4;
        }

        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static Bitmap drawToBitmap$default(View arg0, Bitmap$Config arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Bitmap$Config.ARGB_8888;
        }

        return ViewKt.drawToBitmap(arg0, arg1);
    }

    public static final Sequence getAllViews(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return SequencesKt.sequence(new ViewKt$allViews$1(arg2, null));
    }

    public static final Sequence getAncestors(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.generateSequence(arg1.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((ViewGroup$MarginLayoutParams)v1).bottomMargin;
        }

        return 0;
    }

    public static final int getMarginEnd(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
            return ((ViewGroup$MarginLayoutParams)v1).getMarginEnd();
        }

        return 0;
    }

    public static final int getMarginLeft(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((ViewGroup$MarginLayoutParams)v1).leftMargin;
        }

        return 0;
    }

    public static final int getMarginRight(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((ViewGroup$MarginLayoutParams)v1).rightMargin;
        }

        return 0;
    }

    public static final int getMarginStart(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
            return ((ViewGroup$MarginLayoutParams)v1).getMarginStart();
        }

        return 0;
    }

    public static final int getMarginTop(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof ViewGroup$MarginLayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((ViewGroup$MarginLayoutParams)v1).topMargin;
        }

        return 0;
    }

    public static final boolean isGone(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.getVisibility() == 8) {
            return 1;
        }

        return 0;
    }

    public static final boolean isInvisible(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.getVisibility() == 4) {
            return 1;
        }

        return 0;
    }

    public static final boolean isVisible(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    public static final Runnable postDelayed(View arg1, long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        ViewKt$postDelayed$runnable$1 v0 = new ViewKt$postDelayed$runnable$1(arg4);
        arg1.postDelayed(((Runnable)v0), arg2);
        return ((Runnable)v0);
    }

    public static final Runnable postOnAnimationDelayed(View arg1, long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        ViewKt$$ExternalSyntheticLambda0 v0 = new ViewKt$$ExternalSyntheticLambda0(arg4);
        arg1.postOnAnimationDelayed(((Runnable)v0), arg2);
        return ((Runnable)v0);
    }

    static final void postOnAnimationDelayed$lambda$0(Function0 arg0) {
        arg0.invoke();
    }

    public static final void setGone(View arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg2 ? 8 : 0;
        arg1.setVisibility(v2);
    }

    public static final void setInvisible(View arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg2 ? 4 : 0;
        arg1.setVisibility(v2);
    }

    public static final void setPadding(View arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setPadding(arg2, arg2, arg2, arg2);
    }

    public static final void setVisible(View arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg2 ? 0 : 8;
        arg1.setVisibility(v2);
    }

    public static final void updateLayoutParams(View arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        ViewGroup$LayoutParams v0 = arg1.getLayoutParams();
        if(v0 != null) {
            arg2.invoke(v0);
            arg1.setLayoutParams(v0);
            return;
        }

        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void updateLayoutParamsTyped(View arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        arg4.invoke(v0);
        arg3.setLayoutParams(v0);
    }

    public static final void updatePadding(View arg1, int arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setPadding(arg2, arg3, arg4, arg5);
    }

    public static void updatePadding$default(View arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.getPaddingLeft();
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.getPaddingTop();
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.getPaddingRight();
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.getPaddingBottom();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        arg0.setPadding(arg1, arg2, arg3, arg4);
    }

    public static final void updatePaddingRelative(View arg1, int arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setPaddingRelative(arg2, arg3, arg4, arg5);
    }

    public static void updatePaddingRelative$default(View arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.getPaddingStart();
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.getPaddingTop();
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.getPaddingEnd();
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.getPaddingBottom();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        arg0.setPaddingRelative(arg1, arg2, arg3, arg4);
    }
}

