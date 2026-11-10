package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u000E\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001A\u00020\u0011H\u0014J\u0010\u0010\u0012\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020\nH\u0016J\u0010\u0010\u0013\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u0014\u001A\u00020\u0011H\u0002J\b\u0010\u0015\u001A\u00020\u0011H\u0014J\u0010\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0002R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000F¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenSharkTopBar;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "owner", "Landroidx/lifecycle/LifecycleOwner;", "listening", "", "batteryReceiver", "com/TryJeanPc/goldenmouse/gamespace/GoldenSharkTopBar$batteryReceiver$1", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenSharkTopBar$batteryReceiver$1;", "onAttachedToWindow", "", "onStart", "onStop", "stopListening", "onDetachedFromWindow", "updateBattery", "intent", "Landroid/content/Intent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenSharkTopBar extends FrameLayout implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    private final GoldenSharkTopBar$batteryReceiver$1 batteryReceiver;
    private boolean listening;
    private LifecycleOwner owner;

    static {
    }

    public GoldenSharkTopBar(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenSharkTopBar(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenSharkTopBar(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.batteryReceiver = new GoldenSharkTopBar$batteryReceiver$1(this);
        FrameLayout.inflate(arg2, layout.golden_shark_topbar, ((ViewGroup)this));
    }

    public static final void access$updateBattery(GoldenSharkTopBar arg0, Intent arg1) {
        arg0.updateBattery(arg1);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleOwner v0 = ViewTreeLifecycleOwner.get(this);
        this.owner = v0;
        if(v0 != null) {
            Lifecycle v0_1 = v0.getLifecycle();
            if(v0_1 != null) {
                v0_1.addObserver(((LifecycleObserver)this));
            }
        }
    }

    public void onCreate(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onCreate(arg1);
    }

    public void onDestroy(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onDestroy(arg1);
    }

    protected void onDetachedFromWindow() {
        Drawable v0 = this.findViewById(id.gspace_shark_user).getDrawable();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable)v0).stop();
        this.stopListening();
        LifecycleOwner v0_1 = this.owner;
        if(v0_1 != null) {
            Lifecycle v0_2 = v0_1.getLifecycle();
            if(v0_2 != null) {
                v0_2.removeObserver(this);
            }
        }

        this.owner = null;
        super.onDetachedFromWindow();
    }

    public void onPause(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onPause(arg1);
    }

    public void onResume(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onResume(arg1);
    }

    public void onStart(LifecycleOwner arg4) {
        Intrinsics.checkNotNullParameter(arg4, "owner");
        Drawable v4 = this.findViewById(id.gspace_shark_user).getDrawable();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable)v4).start();
        if(this.listening) {
            return;
        }

        Intent v4_1 = ContextCompat.registerReceiver(this.getContext(), this.batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 4);
        if(v4_1 != null) {
            this.updateBattery(v4_1);
        }

        this.listening = true;
    }

    public void onStop(LifecycleOwner arg2) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        Drawable v2 = this.findViewById(id.gspace_shark_user).getDrawable();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable)v2).stop();
        this.stopListening();
    }

    private final void stopListening() {
        if(!this.listening) {
            return;
        }

        this.getContext().unregisterReceiver(this.batteryReceiver);
        this.listening = false;
    }

    private final void updateBattery(Intent arg8) {
        int v0 = arg8.getIntExtra("level", -1);
        int v2 = 0;
        int v1 = arg8.getIntExtra("scale", 0);
        if(v0 >= 0) {
            if(v1 <= 0) {
            }
            else {
                v0 = RangesKt.coerceIn(((int)((((long)v0)) * 100 / (((long)v1)))), 0, 100);
                int v3 = 1;
                v1 = arg8.getIntExtra("status", 1);
                if(v1 != 2 && (v1 != 5 || arg8.getIntExtra("plugged", 0) == 0)) {
                    v3 = 0;
                }

                this.findViewById(id.gspace_shark_battery_icon).setPercent(v0);
                this.findViewById(id.gspace_shark_battery_percent).setText(v0 + "%");
                View v8 = this.findViewById(id.gspace_shark_charging);
                if(v3 != 0) {
                }
                else {
                    v2 = 8;
                }

                v8.setVisibility(v2);
                v8 = this.findViewById(id.gspace_shark_battery);
                String v0_1 = this.getContext().getString(string.gspace_shark_battery, new Object[]{Integer.valueOf(v0)});
                String v7 = v3 != 0 ? ", " + this.getContext().getString(string.gspace_shark_charging) : "";
                v8.setContentDescription(v0_1 + v7);
            }
        }
    }
}

