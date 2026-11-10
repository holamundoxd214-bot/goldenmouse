package com.TryJeanPc.goldenmouse.controls;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\t\u0010\u001A\u001A\u00020\nHÆ\u0003J=\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\n2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/controls/EditorHitRegion;", "", "view", "Landroid/view/View;", "shape", "Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "receiver", "minimumTouchDp", "", "visibleFigure", "", "<init>", "(Landroid/view/View;Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;Landroid/view/View;FZ)V", "getView", "()Landroid/view/View;", "getShape", "()Lcom/TryJeanPc/goldenmouse/controls/EditorHitShape;", "getReceiver", "getMinimumTouchDp", "()F", "getVisibleFigure", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorHitRegion {
    public static final int $stable = 8;
    private final float minimumTouchDp;
    private final View receiver;
    private final EditorHitShape shape;
    private final View view;
    private final boolean visibleFigure;

    static {
    }

    public EditorHitRegion(View arg7, EditorHitShape arg8, View arg9, float arg10, boolean arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 2) != 0) {
            arg8 = EditorHitShapes.INSTANCE.getRectangle();
        }

        EditorHitShape v2 = arg8;
        if((arg12 & 4) != 0) {
            arg9 = null;
        }

        View v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = 48f;
        }

        this(arg7, v2, v3, arg10, true);
    }

    public EditorHitRegion(View arg2, EditorHitShape arg3, View arg4, float arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        Intrinsics.checkNotNullParameter(arg3, "shape");
        super();
        this.view = arg2;
        this.shape = arg3;
        this.receiver = arg4;
        this.minimumTouchDp = arg5;
        this.visibleFigure = arg6;
    }

    public final View component1() {
        return this.view;
    }

    public final EditorHitShape component2() {
        return this.shape;
    }

    public final View component3() {
        return this.receiver;
    }

    public final float component4() {
        return this.minimumTouchDp;
    }

    public final boolean component5() {
        return this.visibleFigure;
    }

    public final EditorHitRegion copy(View arg7, EditorHitShape arg8, View arg9, float arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg7, "view");
        Intrinsics.checkNotNullParameter(arg8, "shape");
        return new EditorHitRegion(arg7, arg8, arg9, arg10, arg11);
    }

    public static EditorHitRegion copy$default(EditorHitRegion arg0, View arg1, EditorHitShape arg2, View arg3, float arg4, boolean arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.view;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.shape;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.receiver;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.minimumTouchDp;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.visibleFigure;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((EditorHitRegion)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EditorHitRegion)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.view, ((EditorHitRegion)arg5).view)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((EditorHitRegion)arg5).shape)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.receiver, ((EditorHitRegion)arg5).receiver)) {
            return 0;
        }

        if(Float.compare(this.minimumTouchDp, ((EditorHitRegion)arg5).minimumTouchDp) != 0) {
            return 0;
        }

        if(this.visibleFigure != ((EditorHitRegion)arg5).visibleFigure) {
            return 0;
        }

        return 1;
    }

    public final float getMinimumTouchDp() {
        return this.minimumTouchDp;
    }

    public final View getReceiver() {
        return this.receiver;
    }

    public final EditorHitShape getShape() {
        return this.shape;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean getVisibleFigure() {
        return this.visibleFigure;
    }

    public int hashCode() {
        int v0 = (this.view.hashCode() * 0x1F + this.shape.hashCode()) * 0x1F;
        View v1 = this.receiver;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return ((v0 + v1_1) * 0x1F + Float.hashCode(this.minimumTouchDp)) * 0x1F + Boolean.hashCode(this.visibleFigure);
    }

    public String toString() {
        return "EditorHitRegion(view=" + this.view + ", shape=" + this.shape + ", receiver=" + this.receiver + ", minimumTouchDp=" + this.minimumTouchDp + ", visibleFigure=" + this.visibleFigure + ")";
    }
}

