package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Vibrator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/platform/HapticDefaults;", "", "<init>", "()V", "isPremiumVibratorEnabled", "", "context", "Landroid/content/Context;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HapticDefaults {
    public static final int $stable;
    public static final HapticDefaults INSTANCE;

    static {
        HapticDefaults.INSTANCE = new HapticDefaults();
    }

    private HapticDefaults() {
        super();
    }

    public final boolean isPremiumVibratorEnabled(Context arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F && (arg3.getSystemService(Vibrator.class).areAllPrimitivesSupported(new int[]{1, 7, 2}))) {
            return 1;
        }

        return 0;
    }
}

