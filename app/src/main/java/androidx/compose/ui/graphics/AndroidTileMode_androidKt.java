package androidx.compose.ui.graphics;

import android.graphics.Shader$TileMode;
import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0011\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0011\u0010\u0005\u001A\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001A\u000F\u0010\t\u001A\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTileMode_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Shader$TileMode.values().length];
            try {
                v0[Shader$TileMode.CLAMP.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Shader$TileMode.MIRROR.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Shader$TileMode.REPEAT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final boolean isSupported-0vamqd0(int arg2) {
        if(Build$VERSION.SDK_INT < 0x1F) {
            if(!TileMode.equals-impl0(arg2, TileMode.Companion.getDecal-3opZhB0())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final Shader$TileMode toAndroidTileMode-0vamqd0(int arg1) {
        if(TileMode.equals-impl0(arg1, TileMode.Companion.getClamp-3opZhB0())) {
            return Shader$TileMode.CLAMP;
        }

        if(TileMode.equals-impl0(arg1, TileMode.Companion.getRepeated-3opZhB0())) {
            return Shader$TileMode.REPEAT;
        }

        if(TileMode.equals-impl0(arg1, TileMode.Companion.getMirror-3opZhB0())) {
            return Shader$TileMode.MIRROR;
        }

        if(TileMode.equals-impl0(arg1, TileMode.Companion.getDecal-3opZhB0())) {
            if(Build$VERSION.SDK_INT >= 0x1F) {
                return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
            }

            return Shader$TileMode.CLAMP;
        }

        return Shader$TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader$TileMode arg2) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(Build$VERSION.SDK_INT >= 0x1F && arg2 == Shader$TileMode.DECAL) {
                        return TileModeVerificationHelper.INSTANCE.getComposeTileModeDecal-3opZhB0();
                    }

                    return TileMode.Companion.getClamp-3opZhB0();
                }

                return TileMode.Companion.getRepeated-3opZhB0();
            }

            return TileMode.Companion.getMirror-3opZhB0();
        }

        return TileMode.Companion.getClamp-3opZhB0();
    }
}

