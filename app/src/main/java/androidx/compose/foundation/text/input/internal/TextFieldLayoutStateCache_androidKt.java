package androidx.compose.foundation.text.input.internal;

import android.os.Build$VERSION;
import androidx.compose.ui.text.style.TextDirection;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0019\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale arg2) {
        int v2 = Build$VERSION.SDK_INT >= 28 ? DigitDirectionalityApi28.INSTANCE.resolve(arg2) : DigitDirectionalityApi24.INSTANCE.resolve(arg2);
        if(v2 != 1) {
            if(v2 == 2) {
            }
            else {
                return TextDirection.Companion.getLtr-s_7X-co();
            }
        }

        return TextDirection.Companion.getRtl-s_7X-co();
    }
}

