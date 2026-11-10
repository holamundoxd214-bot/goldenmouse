package com.TryJeanPc.goldenmouse.service;

import android.app.Dialog;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import com.TryJeanPc.goldenmouse.ui.WindowFocusPolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\nJ\u0018\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u000BH\u0016J\u0018\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u000BH\u0016J\u0010\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\nH\u0016J\u0010\u0010 \u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\nH\u0016J\u000E\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u000EJ\u000E\u0010#\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u000EJ\u000E\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020\u000FJ\u0006\u0010&\u001A\u00020\u0005J\u0011\u0010\'\u001A\n )*\u0004\u0018\u00010(0(H\u0097\u0001R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tj\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\tj\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u001A\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/service/SessionOverlayWindows;", "Landroid/view/WindowManager;", "delegate", "interactionChanged", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/WindowManager;Lkotlin/jvm/functions/Function0;)V", "roots", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/collections/LinkedHashMap;", "dialogs", "Landroid/app/Dialog;", "", "hidden", "suspended", "getSuspended", "()Z", "hasDialogs", "getHasDialogs", "failedDetachVisibility", "", "", "closed", "isManaged", "view", "addView", "params", "updateViewLayout", "removeView", "removeViewImmediate", "show", "dialog", "hide", "setSuspended", "value", "close", "getDefaultDisplay", "Landroid/view/Display;", "kotlin.jvm.PlatformType", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SessionOverlayWindows implements WindowManager {
    public static final int $stable = 8;
    private boolean closed;
    private final WindowManager delegate;
    private final LinkedHashMap dialogs;
    private final Map failedDetachVisibility;
    private boolean hidden;
    private final Function0 interactionChanged;
    private final LinkedHashMap roots;

    static {
    }

    public SessionOverlayWindows(WindowManager arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        Intrinsics.checkNotNullParameter(arg3, "interactionChanged");
        super();
        this.delegate = arg2;
        this.interactionChanged = arg3;
        this.roots = new LinkedHashMap();
        this.dialogs = new LinkedHashMap();
        this.hidden = true;
        this.failedDetachVisibility = new LinkedHashMap();
    }

    public SessionOverlayWindows(WindowManager arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        SessionOverlayWindows$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new SessionOverlayWindows$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function0)v2));
    }

    static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final LinkedHashMap access$getDialogs$p(SessionOverlayWindows arg0) {
        return arg0.dialogs;
    }

    public static final Function0 access$getInteractionChanged$p(SessionOverlayWindows arg0) {
        return arg0.interactionChanged;
    }

    public void addView(View arg2, ViewGroup$LayoutParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        Intrinsics.checkNotNullParameter(arg3, "params");
        if(this.closed) {
        }
        else {
            WindowFocusPolicy.INSTANCE.prepare(arg2);
            this.roots.put(arg2, arg3);
            if(!this.getSuspended() && arg2.getParent() == null) {
                this.delegate.addView(arg2, arg3);
            }
        }
    }

    public final void close() {
        this.closed = true;
        this.hidden = true;
        Set v0 = this.dialogs.keySet();
        String v1 = "<get-keys>(...)";
        Intrinsics.checkNotNullExpressionValue(v0, v1);
        Iterator v0_1 = CollectionsKt.toList(((Iterable)v0)).iterator();
        while(v0_1.hasNext()) {
            Object v2 = v0_1.next();
            try {
                ((Dialog)v2).dismiss();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_1) {
                Result.constructor-impl(ResultKt.createFailure(v2_1));
            }
        }

        this.dialogs.clear();
        v0 = this.roots.keySet();
        Intrinsics.checkNotNullExpressionValue(v0, v1);
        v0_1 = CollectionsKt.toList(((Iterable)v0)).iterator();
        while(v0_1.hasNext()) {
            Object v1_1 = v0_1.next();
            try {
                if(((View)v1_1).getParent() != null) {
                    this.delegate.removeViewImmediate(((View)v1_1));
                }

                v1_1 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v1_2) {
                v1_1 = Result.constructor-impl(ResultKt.createFailure(v1_2));
            }

            v1_2 = Result.exceptionOrNull-impl(v1_1);
            if(v1_2 == null) {
                continue;
            }

            Log.w("GOLDEN_HOME", "No se pudo retirar una ventana", v1_2);
        }

        this.roots.clear();
        this.failedDetachVisibility.clear();
        this.interactionChanged.invoke();
    }

    @Deprecated(message="Deprecated in Java") public Display getDefaultDisplay() {
        return this.delegate.getDefaultDisplay();
    }

    public final boolean getHasDialogs() {
        Collection v2 = this.dialogs.values();
        Intrinsics.checkNotNullExpressionValue(v2, "<get-values>(...)");
        if(v2.isEmpty()) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }

            Object v0 = v2_1.next();
            Intrinsics.checkNotNull(v0);
        }
        while(!((Boolean)v0).booleanValue());

        return 1;
    }

    public final boolean getSuspended() {
        return this.hidden;
    }

    public final void hide(Dialog arg3) {
        Intrinsics.checkNotNullParameter(arg3, "dialog");
        if(this.dialogs.containsKey(arg3)) {
            this.dialogs.put(arg3, Boolean.valueOf(false));
        }

        arg3.hide();
        this.interactionChanged.invoke();
    }

    public final boolean isManaged(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        return this.roots.containsKey(arg2);
    }

    public void removeView(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.removeViewImmediate(arg2);
    }

    public void removeViewImmediate(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.roots.remove(arg2);
        this.failedDetachVisibility.remove(arg2);
        if(arg2.getParent() != null) {
            this.delegate.removeViewImmediate(arg2);
        }
    }

    public final void setSuspended(boolean arg6) {
        Object v2_1;
        Object v0_1;
        Iterator v6_1;
        if(!this.closed && this.getSuspended() != arg6) {
            this.hidden = arg6;
            LinkedHashMap v0 = this.roots;
            String v1 = "GOLDEN_HOME";
            if(arg6) {
                Set v6 = v0.keySet();
                Intrinsics.checkNotNullExpressionValue(v6, "<get-keys>(...)");
                v6_1 = CollectionsKt.toList(((Iterable)v6)).iterator();
                while(v6_1.hasNext()) {
                    v0_1 = v6_1.next();
                    ((View)v0_1).animate().cancel();
                    try {
                        if(((View)v0_1).getParent() != null) {
                            this.delegate.removeViewImmediate(((View)v0_1));
                        }

                        v2_1 = Result.constructor-impl(Unit.INSTANCE);
                    }
                    catch(Throwable v2) {
                        v2_1 = Result.constructor-impl(ResultKt.createFailure(v2));
                    }

                    v2 = Result.exceptionOrNull-impl(v2_1);
                    if(v2 == null) {
                        continue;
                    }

                    this.failedDetachVisibility.put(v0_1, Integer.valueOf(((View)v0_1).getVisibility()));
                    ((View)v0_1).setVisibility(8);
                    Log.w(v1, "Ventana oculta tras fallo al retirarla", v2);
                }

                Iterator v5 = MapsKt.toMap(this.dialogs).entrySet().iterator();
                while(true) {
                    if(!v5.hasNext()) {
                        return;
                    }

                    Object v6_2 = v5.next();
                    v0_1 = ((Map$Entry)v6_2).getKey();
                    if(!((Map$Entry)v6_2).getValue().booleanValue()) {
                        continue;
                    }

                    ((Dialog)v0_1).hide();
                }
            }

            v6_1 = MapsKt.toMap(((Map)v0)).entrySet().iterator();
            while(v6_1.hasNext()) {
                v0_1 = v6_1.next();
                v2_1 = ((Map$Entry)v0_1).getKey();
                v0_1 = ((Map$Entry)v0_1).getValue();
                Object v3 = this.failedDetachVisibility.remove(v2_1);
                if(v3 != null) {
                    ((View)v2_1).setVisibility(((Number)v3).intValue());
                }

                try {
                    if(((View)v2_1).getParent() == null) {
                        WindowFocusPolicy.INSTANCE.prepare(((View)v2_1));
                        this.delegate.addView(((View)v2_1), ((ViewGroup$LayoutParams)v0_1));
                    }

                    v0_1 = Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v0_2) {
                    v0_1 = Result.constructor-impl(ResultKt.createFailure(v0_2));
                }

                v0_2 = Result.exceptionOrNull-impl(v0_1);
                if(v0_2 == null) {
                    continue;
                }

                Log.w(v1, "No se pudo restaurar una ventana", v0_2);
            }

            v6_1 = MapsKt.toMap(this.dialogs).entrySet().iterator();
            while(v6_1.hasNext()) {
                v0_1 = v6_1.next();
                v2_1 = ((Map$Entry)v0_1).getKey();
                if(!((Map$Entry)v0_1).getValue().booleanValue()) {
                    continue;
                }

                try {
                    WindowFocusPolicy.INSTANCE.prepare(((Dialog)v2_1));
                    ((Dialog)v2_1).show();
                    v0_1 = Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v0_2) {
                    v0_1 = Result.constructor-impl(ResultKt.createFailure(v0_2));
                }

                v0_2 = Result.exceptionOrNull-impl(v0_1);
                if(v0_2 == null) {
                    continue;
                }

                Log.w(v1, "No se pudo restaurar un diálogo", v0_2);
            }
        }
    }

    public final void show(Dialog arg3) {
        Intrinsics.checkNotNullParameter(arg3, "dialog");
        if(this.closed) {
        }
        else {
            if(!this.dialogs.containsKey(arg3)) {
                Window v0 = arg3.getWindow();
                if(v0 != null) {
                    View v0_1 = v0.getDecorView();
                    if(v0_1 != null) {
                        v0_1.addOnAttachStateChangeListener(new SessionOverlayWindows$show$1(this, arg3));
                    }
                }
            }

            this.dialogs.put(arg3, Boolean.valueOf(true));
            this.interactionChanged.invoke();
            try {
                WindowFocusPolicy.INSTANCE.prepare(arg3);
                arg3.show();
                if(!this.getSuspended()) {
                    return;
                }

                arg3.hide();
            }
            catch(Exception v0_2) {
                this.dialogs.remove(arg3);
                this.interactionChanged.invoke();
                throw v0_2;
            }
        }
    }

    public void updateViewLayout(View arg2, ViewGroup$LayoutParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        Intrinsics.checkNotNullParameter(arg3, "params");
        if(this.closed) {
        }
        else {
            if(this.roots.containsKey(arg2)) {
                this.roots.put(arg2, arg3);
            }

            if(this.getSuspended()) {
                return;
            }

            if(arg2.getParent() == null) {
                return;
            }

            this.delegate.updateViewLayout(arg2, arg3);
        }
    }
}

