package androidx.compose.ui.graphics;

import android.graphics.Shader$TileMode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005J\r\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/ui/graphics/TileModeVerificationHelper;", "", "<init>", "()V", "getFrameworkTileModeDecal", "Landroid/graphics/Shader$TileMode;", "getComposeTileModeDecal", "Landroidx/compose/ui/graphics/TileMode;", "getComposeTileModeDecal-3opZhB0", "()I", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class TileModeVerificationHelper {
    public static final TileModeVerificationHelper INSTANCE;

    static {
        TileModeVerificationHelper.INSTANCE = new TileModeVerificationHelper();
    }

    private TileModeVerificationHelper() {
        super();
    }

    public final int getComposeTileModeDecal-3opZhB0() {
        return TileMode.Companion.getDecal-3opZhB0();
    }

    public final Shader$TileMode getFrameworkTileModeDecal() {
        return Shader$TileMode.DECAL;
    }
}

