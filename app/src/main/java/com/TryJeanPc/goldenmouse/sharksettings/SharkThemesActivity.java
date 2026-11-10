package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageOnly;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.lifecycle.LifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import com.TryJeanPc.goldenmouse.gamespace.GoldenGameSpaceActivity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001A\u00020\nH\u0014J\b\u0010\u000E\u001A\u00020\nH\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/SharkThemesActivity;", "Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsScreen;", "<init>", "()V", "cropPhoto", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "choosePhoto", "Landroidx/activity/result/PickVisualMediaRequest;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "returnToGameSpace", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SharkThemesActivity extends SharkSettingsScreen {
    public static final int $stable = 8;
    private final ActivityResultLauncher choosePhoto;
    private final ActivityResultLauncher cropPhoto;

    static {
    }

    public SharkThemesActivity() {
        super(layout.shark_settings_themes, string.shark_settings_themes_title);
        this.cropPhoto = this.registerForActivityResult(new StartActivityForResult(), new SharkThemesActivity$$ExternalSyntheticLambda0(this));
        this.choosePhoto = this.registerForActivityResult(new PickVisualMedia(), new SharkThemesActivity$$ExternalSyntheticLambda1(this));
    }

    public static final void access$returnToGameSpace(SharkThemesActivity arg0) {
        arg0.returnToGameSpace();
    }

    static final void choosePhoto$lambda$1(SharkThemesActivity arg3, Uri arg4) {
        if(arg4 != null) {
            ActivityResultLauncher v0 = arg3.cropPhoto;
            Intent v3 = new Intent(((Context)arg3), WallpaperCropActivity.class).setData(arg4).addFlags(1);
            Intrinsics.checkNotNullExpressionValue(v3, "addFlags(...)");
            v0.launch(v3);
        }
    }

    static final void cropPhoto$lambda$0(SharkThemesActivity arg1, ActivityResult arg2) {
        Intrinsics.checkNotNullParameter(arg2, "result");
        if(arg2.getResultCode() == -1) {
            arg1.returnToGameSpace();
        }
    }

    protected void onCreate(Bundle arg6) {
        super.onCreate(arg6);
        View v6 = this.findViewById(id.shark_settings_album_row);
        View v0 = this.findViewById(id.shark_settings_album);
        View v1 = this.findViewById(id.shark_settings_default);
        this.findViewById(id.shark_settings_default_preview).setColorFilter(new ColorMatrixColorFilter(new float[]{0.18f, 0.58f, 0.12f, 0f, 0f, 0.16f, 0.46f, 0.1f, 0f, 0f, 0.14f, 0.3f, 0.08f, 0f, 0f, 0f, 0f, 0f, 1f, 0f}));
        v0.setOnClickListener(new SharkThemesActivity$$ExternalSyntheticLambda2(this));
        v1.setOnClickListener(new SharkThemesActivity$$ExternalSyntheticLambda3(v1, this, v0));
        v6.addOnLayoutChangeListener(new SharkThemesActivity$$ExternalSyntheticLambda4(v6, this, v0, v1));
    }

    static final void onCreate$lambda$2(SharkThemesActivity arg6, View arg7) {
        arg6.choosePhoto.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default(ImageOnly.INSTANCE, 0, false, null, 14, null));
    }

    static final void onCreate$lambda$3(View arg6, SharkThemesActivity arg7, View arg8, View arg9) {
        arg6.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(arg7), null, null, new SharkThemesActivity$onCreate$2$1(arg8, arg6, arg7, null), 3, null);
    }

    static final void onCreate$lambda$5(View arg0, SharkThemesActivity arg1, View arg2, View arg3, View arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        int v0 = RangesKt.coerceAtLeast(((int)(((((float)(arg7 - arg5 - arg0.getPaddingLeft() - arg0.getPaddingRight()))) - 20f * arg1.getResources().getDisplayMetrics().density) / 3f)), 1);
        int v4 = v0 * 1080 / 2400;
        Iterator v1 = CollectionsKt.listOf(new View[]{arg2, arg3}).iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            if(((View)v2).getLayoutParams().width == v0 && ((View)v2).getLayoutParams().height == v4) {
                continue;
            }

            ViewGroup$LayoutParams v3 = ((View)v2).getLayoutParams();
            v3.width = v0;
            v3.height = v4;
            ((View)v2).setLayoutParams(v3);
        }
    }

    protected void onResume() {
        super.onResume();
        boolean v0 = GameSpaceWallpaperStore.INSTANCE.selected(this) != null ? true : false;
        this.findViewById(id.shark_settings_album).setSelected(v0);
        this.findViewById(id.shark_settings_default).setSelected((((int)v0)) ^ 1);
    }

    private final void returnToGameSpace() {
        this.startActivity(new Intent(this, GoldenGameSpaceActivity.class).addFlags(0x24000000));
    }
}

