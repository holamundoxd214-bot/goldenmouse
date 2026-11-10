package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.TryJeanPc.goldenmouse.R$drawable;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001A\u00020\u0014H\u0014J\u0010\u0010\u0015\u001A\u00020\u00142\u0006\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u0016\u001A\u00020\u0014H\u0002J\u0010\u0010\u0017\u001A\u00020\u00142\u0006\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u0018\u001A\u00020\u0014H\u0014R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/GameSpaceWallpaperView;", "Landroid/widget/ImageView;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "owner", "Landroidx/lifecycle/LifecycleOwner;", "originalFilter", "Landroid/graphics/ColorFilter;", "originalFilterCaptured", "", "loadedPath", "", "loadJob", "Lkotlinx/coroutines/Job;", "onAttachedToWindow", "", "onStart", "showDefault", "onStop", "onDetachedFromWindow", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameSpaceWallpaperView extends ImageView implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    private Job loadJob;
    private String loadedPath;
    private ColorFilter originalFilter;
    private boolean originalFilterCaptured;
    private LifecycleOwner owner;

    static {
    }

    public GameSpaceWallpaperView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GameSpaceWallpaperView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GameSpaceWallpaperView(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
    }

    public static final void access$setLoadedPath$p(GameSpaceWallpaperView arg0, String arg1) {
        arg0.loadedPath = arg1;
    }

    public static final void access$showDefault(GameSpaceWallpaperView arg0) {
        arg0.showDefault();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(!this.originalFilterCaptured) {
            this.originalFilter = this.getColorFilter();
            this.originalFilterCaptured = true;
        }

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
        Job v0 = this.loadJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        LifecycleOwner v0_1 = this.owner;
        if(v0_1 != null) {
            Lifecycle v0_2 = v0_1.getLifecycle();
            if(v0_2 != null) {
                v0_2.removeObserver(this);
            }
        }

        this.owner = ((LifecycleOwner)v1);
        super.onDetachedFromWindow();
    }

    public void onPause(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onPause(arg1);
    }

    public void onResume(LifecycleOwner arg1) {
        DefaultLifecycleObserver.super.onResume(arg1);
    }

    public void onStart(LifecycleOwner arg10) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg10, "owner");
        GameSpaceWallpaperStore v0 = GameSpaceWallpaperStore.INSTANCE;
        Context v1 = this.getContext();
        Intrinsics.checkNotNullExpressionValue(v1, "getContext(...)");
        File v0_1 = v0.selected(v1);
        CancellationException v1_1 = null;
        if(v0_1 != null) {
            String v2 = v0_1.getAbsolutePath();
        }
        else {
            v2_1 = v1_1;
        }

        Job v3 = this.loadJob;
        if(v3 != null) {
            DefaultImpls.cancel$default(v3, v1_1, 1, v1_1);
        }

        if(Intrinsics.areEqual(v2_1, this.loadedPath)) {
            return;
        }

        if(v0_1 == null) {
            this.showDefault();
            return;
        }

        this.loadJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(arg10), null, null, new GameSpaceWallpaperView$onStart$1(this, ((String)v2_1), v0_1, ((Continuation)v1_1)), 3, null);
    }

    public void onStop(LifecycleOwner arg2) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        Job v1 = this.loadJob;
        if(v1 != null) {
            DefaultImpls.cancel$default(v1, null, 1, null);
        }
    }

    private final void showDefault() {
        this.setImageResource(drawable.gspace_stage);
        this.setColorFilter(this.originalFilter);
        this.loadedPath = null;
    }
}

