package com.TryJeanPc.goldenmouse.sharksettings;

import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsControllerCompat;
import com.TryJeanPc.goldenmouse.R$anim;
import com.TryJeanPc.goldenmouse.R$id;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0014J\b\u0010\u000B\u001A\u00020\bH\u0014J\b\u0010\f\u001A\u00020\bH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsScreen;", "Landroidx/activity/ComponentActivity;", "layout", "", "title", "<init>", "(II)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "finish", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public abstract class SharkSettingsScreen extends ComponentActivity {
    public static final int $stable = 8;
    private final int layout;
    private final int title;

    static {
    }

    public SharkSettingsScreen(int arg1, int arg2) {
        super();
        this.layout = arg1;
        this.title = arg2;
    }

    public void finish() {
        super.finish();
        this.overridePendingTransition(0, anim.shark_settings_activity_down_out);
    }

    protected void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        this.setContentView(this.layout);
        this.findViewById(id.shark_settings_ir4s_toolbar_title).setText(this.title);
        this.findViewById(id.shark_settings_ir4s_toolbar_back_hotspot).setOnClickListener(new SharkSettingsScreen$$ExternalSyntheticLambda0(this));
    }

    static final void onCreate$lambda$0(SharkSettingsScreen arg0, View arg1) {
        arg0.finish();
    }

    protected void onResume() {
        super.onResume();
        WindowCompat.setDecorFitsSystemWindows(this.getWindow(), false);
        WindowInsetsControllerCompat v0 = new WindowInsetsControllerCompat(this.getWindow(), this.getWindow().getDecorView());
        v0.hide(Type.systemBars());
        v0.setSystemBarsBehavior(2);
    }
}

