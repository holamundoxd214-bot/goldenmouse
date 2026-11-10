package androidx.compose.ui.graphics;

import android.graphics.Path$Direction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0006\u0010\u0000\u001A\u00020\u0001\u001A\n\u0010\u0002\u001A\u00020\u0001*\u00020\u0003\u001A\r\u0010\u0004\u001A\u00020\u0003*\u00020\u0001H\u0086\b\u001A\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000\u001A\f\u0010\t\u001A\u00020\n*\u00020\u000BH\u0002¨\u0006\f"}, d2={"Path", "Landroidx/compose/ui/graphics/Path;", "asComposePath", "Landroid/graphics/Path;", "asAndroidPath", "throwIllegalStateException", "", "message", "", "toPlatformPathDirection", "Landroid/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path$Direction;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidPath_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Direction.values().length];
            try {
                v0[Direction.CounterClockwise.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Direction.Clockwise.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final Path Path() {
        return new AndroidPath(null, 1, null);
    }

    public static final Path$Direction access$toPlatformPathDirection(Direction arg0) {
        return AndroidPath_androidKt.toPlatformPathDirection(arg0);
    }

    public static final android.graphics.Path asAndroidPath(Path arg1) {
        if((arg1 instanceof AndroidPath)) {
            return ((AndroidPath)arg1).getInternalPath();
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public static final Path asComposePath(android.graphics.Path arg1) {
        return new AndroidPath(arg1);
    }

    public static final void throwIllegalStateException(String arg1) {
        throw new IllegalStateException(arg1);
    }

    private static final Path$Direction toPlatformPathDirection(Direction arg1) {
        int v1 = WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()];
        if(v1 != 1) {
            if(v1 == 2) {
                return Path$Direction.CW;
            }

            throw new NoWhenBranchMatchedException();
        }

        return Path$Direction.CCW;
    }
}

