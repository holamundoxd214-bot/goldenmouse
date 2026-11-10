package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Deprecated(level=DeprecationLevel.ERROR, message="RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com") @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u000F\u0010\u0002\u001A\u00020\u0003H\'¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001A\u00020\u0007H\'¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/material/ripple/RippleTheme;", "", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "Companion", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public interface RippleTheme {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/material/ripple/RippleTheme$Companion;", "", "<init>", "()V", "defaultRippleColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "lightTheme", "", "defaultRippleColor-5vOe2sY", "(JZ)J", "defaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "defaultRippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="The default ripple alpha varies between design system versions: this function technically implements the default used by the material library, but is not used by the material3 library. To remove confusion and link the defaults more strongly to the design system library, these default values have been moved to the material and material3 libraries. For material, use RippleDefaults#rippleAlpha. For material3, use RippleDefaults#RippleAlpha.") public final RippleAlpha defaultRippleAlpha-DxMtmZc(long arg1, boolean arg3) {
            if(arg3) {
                if((((double)ColorKt.luminance-8_81llA(arg1))) > 0.5) {
                    return RippleThemeKt.access$getLightThemeHighContrastRippleAlpha$p();
                }

                return RippleThemeKt.access$getLightThemeLowContrastRippleAlpha$p();
            }

            return RippleThemeKt.access$getDarkThemeRippleAlpha$p();
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="The default ripple color varies between design system versions: this function technically implements the default used by the material library, but is not used by the material3 library. To remove confusion and link the defaults more strongly to the design system library, these default values have been moved to the material and material3 libraries. For material, use RippleDefaults#rippleColor. For material3, use content color directly.") public final long defaultRippleColor-5vOe2sY(long arg5, boolean arg7) {
            float v4 = ColorKt.luminance-8_81llA(arg5);
            if(!arg7 && (((double)v4)) < 0.5) {
                return Color.Companion.getWhite-0d7_KjU();
            }

            return arg5;
        }
    }

    public static final Companion Companion;

    static {
        RippleTheme.Companion = Companion.$$INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com") long defaultColor-WaAFU9c(Composer arg1, int arg2);

    @Deprecated(level=DeprecationLevel.ERROR, message="RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com") RippleAlpha rippleAlpha(Composer arg1, int arg2);
}

