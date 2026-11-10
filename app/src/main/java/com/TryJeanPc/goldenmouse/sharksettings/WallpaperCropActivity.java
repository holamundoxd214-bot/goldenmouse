package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001A\u00020\u0007H\u0016J\u0010\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/WallpaperCropActivity;", "Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsScreen;", "<init>", "()V", "saving", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "showError", "message", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WallpaperCropActivity extends SharkSettingsScreen {
    public static final int $stable = 8;
    private boolean saving;

    static {
    }

    public WallpaperCropActivity() {
        super(layout.gamespace_wallpaper_crop, string.wallpaper_crop_title);
    }

    public static final void access$setSaving$p(WallpaperCropActivity arg0, boolean arg1) {
        arg0.saving = arg1;
    }

    public static final void access$showError(WallpaperCropActivity arg0, int arg1) {
        arg0.showError(arg1);
    }

    public void finish() {
        if(!this.saving) {
            super.finish();
        }
    }

    protected void onCreate(Bundle arg13) {
        super.onCreate(arg13);
        View v2 = this.findViewById(id.wallpaper_crop_view);
        View v3 = this.findViewById(id.wallpaper_crop_confirm);
        View v13 = this.findViewById(id.wallpaper_crop_cancel);
        View v5 = this.findViewById(id.wallpaper_crop_progress);
        v13.setOnClickListener(new WallpaperCropActivity$$ExternalSyntheticLambda0(this));
        Point v0 = new Point();
        this.getWindowManager().getDefaultDisplay().getRealSize(v0);
        float v1 = (((float)Math.max(v0.x, v0.y))) / (((float)RangesKt.coerceAtLeast(Math.min(v0.x, v0.y), 1)));
        v3.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WallpaperCropActivity$onCreate$2(this, ((WallpaperCropView)v2), v1, v3, v5, null), 3, null);
        v3.setOnClickListener(new WallpaperCropActivity$$ExternalSyntheticLambda1(this, ((WallpaperCropView)v2), v3, v13, v5));
    }

    static final void onCreate$lambda$0(WallpaperCropActivity arg0, View arg1) {
        arg0.finish();
    }

    static final void onCreate$lambda$2(WallpaperCropActivity arg8, WallpaperCropView arg9, View arg10, View arg11, View arg12, View arg13) {
        if(arg8.saving) {
            return;
        }

        Crop v5 = arg9.snapshot$app();
        arg8.saving = true;
        arg10.setEnabled(false);
        arg11.setEnabled(false);
        arg12.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(arg8), null, null, new WallpaperCropActivity$onCreate$3$1(arg8, arg10, arg11, arg12, v5, null), 3, null);
    }

    private final void showError(int arg2) {
        Toast.makeText(((Context)this), arg2, 1).show();
    }
}

