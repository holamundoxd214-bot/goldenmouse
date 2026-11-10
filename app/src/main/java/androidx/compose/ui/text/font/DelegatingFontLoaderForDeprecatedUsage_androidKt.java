package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¨\u0006\u0006"}, d2={"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontResourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DelegatingFontLoaderForDeprecatedUsage_androidKt {
    @Deprecated(message="This exists to bridge existing Font.ResourceLoader APIs, and should be removed with them", replaceWith="<_subannotation>") public static final Resolver createFontFamilyResolver(ResourceLoader arg8) {
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForDeprecatedUsage(arg8), null, null, null, null, 30, null);
    }

    @Deprecated(message="This exists to bridge existing Font.ResourceLoader subclasses to be used as aFontFamily.ResourceLoader during upgrade.", replaceWith="<_subannotation>") public static final Resolver createFontFamilyResolver(ResourceLoader arg8, Context arg9) {
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForBridgeUsage(arg8, arg9.getApplicationContext()), null, null, null, null, 30, null);
    }
}

