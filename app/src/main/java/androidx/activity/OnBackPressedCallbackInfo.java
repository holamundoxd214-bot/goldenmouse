package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001A\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001A\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Landroidx/activity/OnBackPressedCallbackInfo;", "Landroidx/navigationevent/NavigationEventInfo;", "callback", "Landroidx/activity/OnBackPressedCallback;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/activity/OnBackPressedCallback;Landroidx/lifecycle/LifecycleOwner;)V", "getCallback", "()Landroidx/activity/OnBackPressedCallback;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class OnBackPressedCallbackInfo extends NavigationEventInfo {
    private final OnBackPressedCallback callback;
    private final LifecycleOwner owner;

    public OnBackPressedCallbackInfo(OnBackPressedCallback arg2, LifecycleOwner arg3) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        super();
        this.callback = arg2;
        this.owner = arg3;
    }

    public OnBackPressedCallbackInfo(OnBackPressedCallback arg1, LifecycleOwner arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public final OnBackPressedCallback component1() {
        return this.callback;
    }

    public final LifecycleOwner component2() {
        return this.owner;
    }

    public final OnBackPressedCallbackInfo copy(OnBackPressedCallback arg1, LifecycleOwner arg2) {
        Intrinsics.checkNotNullParameter(arg1, "callback");
        return new OnBackPressedCallbackInfo(arg1, arg2);
    }

    public static OnBackPressedCallbackInfo copy$default(OnBackPressedCallbackInfo arg0, OnBackPressedCallback arg1, LifecycleOwner arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.callback;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.owner;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((OnBackPressedCallbackInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof OnBackPressedCallbackInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.callback, ((OnBackPressedCallbackInfo)arg5).callback)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.owner, ((OnBackPressedCallbackInfo)arg5).owner)) {
            return 0;
        }

        return 1;
    }

    public final OnBackPressedCallback getCallback() {
        return this.callback;
    }

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    public int hashCode() {
        int v0 = this.callback.hashCode() * 0x1F;
        LifecycleOwner v1 = this.owner;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.callback + ", owner=" + this.owner + ')';
    }
}

