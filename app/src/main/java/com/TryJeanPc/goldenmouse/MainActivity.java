package com.TryJeanPc.goldenmouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.TryJeanPc.goldenmouse.gamespace.GoldenGameSpaceActivity;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/MainActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MainActivity extends Activity {
    public static final int $stable = 8;

    static {
    }

    public MainActivity() {
        super();
    }

    protected void onCreate(Bundle arg3) {
        super.onCreate(arg3);
        this.startActivity(new Intent(this, GoldenGameSpaceActivity.class).addFlags(0x24000000));
        this.finish();
    }
}

