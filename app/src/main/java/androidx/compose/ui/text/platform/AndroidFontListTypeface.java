package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="This is not supported after downloadable fonts.") @Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000  2\u00020\u0001:\u0001 B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\b\u0011\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001A\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2={"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "<init>", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFontListTypeface implements AndroidTypeface {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "<init>", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private final FontFamily fontFamily;
    private static final FontMatcher fontMatcher;
    private final FontMatcher fontMatcher$1;
    private final Map loadedTypefaces;

    static {
        AndroidFontListTypeface.Companion = new Companion(null);
        AndroidFontListTypeface.$stable = 8;
        AndroidFontListTypeface.fontMatcher = new FontMatcher();
    }

    public AndroidFontListTypeface(FontListFontFamily arg1, Context arg2, List arg3, FontMatcher arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        if((arg5 & 8) != 0) {
            arg4 = AndroidFontListTypeface.fontMatcher;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public AndroidFontListTypeface(FontListFontFamily arg9, Context arg10, List arg11, FontMatcher arg12) {
        ArrayList v1_1;
        Object v4;
        super();
        this.fontMatcher$1 = arg12;
        List v12 = arg9.getFonts();
        ArrayList v0 = new ArrayList(v12.size());
        int v1 = v12.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v4 = v12.get(v3);
            if(FontLoadingStrategy.equals-impl0(v4.getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getBlocking-PKNRLFQ())) {
                v0.add(v4);
            }
        }

        if(arg11 != null) {
            ArrayList v12_1 = new ArrayList(arg11.size());
            v1 = arg11.size();
            for(v3 = 0; v3 < v1; ++v3) {
                v4 = arg11.get(v3);
                v12_1.add(CollectionsKt.firstOrNull(this.fontMatcher$1.matchFont-RetOiIg(((List)v0), ((Pair)v4).component1(), ((Pair)v4).component2().unbox-impl())));
            }

            arg11 = ListUtilsKt.fastFilterNotNull(((List)v12_1));
            if(arg11 != null) {
                MutableScatterSet v12_2 = new MutableScatterSet(arg11.size());
                v1_1 = new ArrayList(arg11.size());
                v3 = arg11.size();
                int v4_1;
                for(v4_1 = 0; v4_1 < v3; ++v4_1) {
                    Object v5 = arg11.get(v4_1);
                    if(v12_2.add(v5)) {
                        v1_1.add(v5);
                    }
                }
            }
            else {
                goto label_62;
            }
        }
        else {
        label_62:
            v1_1 = null;
        }

        if(v1_1 == null) {
        }
        else {
            v0 = v1_1;
        }

        ArrayList v11 = v0;
        if(((Collection)v11).isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Could not match font");
        }

        LinkedHashMap v12_3 = new LinkedHashMap();
        int v11_1 = ((Collection)v11).size();
        while(v2 < v11_1) {
            Object v1_2 = ((List)v0).get(v2);
            try {
                ((Map)v12_3).put(v1_2, AndroidTypefaceCache.INSTANCE.getOrCreate(arg10, ((Font)v1_2)));
            }
            catch(Exception ) {
                InlineClassHelperKt.throwIllegalStateException("Cannot create Typeface from " + v1_2);
            }

            ++v2;
        }

        this.loadedTypefaces = ((Map)v12_3);
        this.fontFamily = ((FontFamily)arg9);
    }

    public static final FontMatcher access$getFontMatcher$cp() {
        return AndroidFontListTypeface.fontMatcher;
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    public Typeface getNativeTypeface-PYhJU0U(FontWeight arg4, int arg5, int arg6) {
        Object v0 = CollectionsKt.firstOrNull(this.fontMatcher$1.matchFont-RetOiIg(new ArrayList(this.loadedTypefaces.keySet()), arg4, arg5));
        if(v0 != null) {
            Object v3 = this.loadedTypefaces.get(v0);
            if(v3 != null) {
                v3 = FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(arg6, v3, ((Font)v0), arg4, arg5);
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type android.graphics.Typeface");
                return ((Typeface)v3);
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Could not load typeface");
            throw new KotlinNothingValueException();
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Could not load font");
        throw new KotlinNothingValueException();
    }
}

