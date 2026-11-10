package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000E2\u00020\u0001:\u0002\r\u000ER\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/Font;", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "getStyle-_-LCdwA", "()I", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getLoadingStrategy-PKNRLFQ", "ResourceLoader", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Font {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/ui/text/font/Font$Companion;", "", "<init>", "()V", "MaximumAsyncTimeoutMillis", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static final long MaximumAsyncTimeoutMillis = 15000;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    @Deprecated(message="Replaced with FontFamily.Resolver during the introduction of async fonts, all usages should be replaced. Custom subclasses can be converted into a FontFamily.Resolver by calling createFontFamilyResolver(myFontFamilyResolver, context)") @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/Font$ResourceLoader;", "", "load", "font", "Landroidx/compose/ui/text/font/Font;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ResourceLoader {
        @Deprecated(message="Replaced by FontFamily.Resolver, this method should not be called", replaceWith="<_subannotation>") Object load(Font arg1);
    }

    public static final Companion Companion = null;
    public static final long MaximumAsyncTimeoutMillis = 15000;

    static {
        Font.Companion = Companion.$$INSTANCE;
    }

    default int getLoadingStrategy-PKNRLFQ() {
        return FontLoadingStrategy.Companion.getBlocking-PKNRLFQ();
    }

    int getStyle-_-LCdwA();

    FontWeight getWeight();
}

