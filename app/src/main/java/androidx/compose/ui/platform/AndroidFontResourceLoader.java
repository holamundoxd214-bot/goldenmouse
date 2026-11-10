package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="Replaced with PlatformFontLoader during the introduction of async fonts, all usages should be replaced", replaceWith="<_subannotation>") @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AndroidFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFontResourceLoader implements ResourceLoader {
    public static final int $stable = 8;
    private final Context context;

    static {
    }

    public AndroidFontResourceLoader(Context arg1) {
        super();
        this.context = arg1;
    }

    @Deprecated(message="Replaced by FontFamily.Resolver, this method should not be called", replaceWith="<_subannotation>") public Typeface load(Font arg3) {
        if((arg3 instanceof ResourceFont)) {
            return AndroidFontResourceLoaderHelper.INSTANCE.create(this.context, ((ResourceFont)arg3).getResId());
        }

        throw new IllegalArgumentException("Unknown font type: " + arg3);
    }

    public Object load(Font arg1) {
        return this.load(arg1);
    }
}

