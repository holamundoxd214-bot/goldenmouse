package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J7\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00130\u001A2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00130\u001A2\u0006\u0010#\u001A\u00020\u0012H\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "<init>", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "getPlatformFontLoader$ui_text", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontFamilyResolverImpl implements Resolver {
    public static final int $stable = 8;
    private final Function1 createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    public static Unit $r8$lambda$9Qm9DZbhOse2Hc4fMyNBL__D5ZI(Immutable arg0) {
        return FontFamilyResolverImpl.preload$lambda$1$0(arg0);
    }

    public static Unit $r8$lambda$wcGwO_lN9j0aDVBccAfzvxeQggA(Immutable arg0) {
        return FontFamilyResolverImpl.preload$lambda$1$1(arg0);
    }

    static {
    }

    public FontFamilyResolverImpl(PlatformFontLoader arg7, PlatformResolveInterceptor arg8, TypefaceRequestCache arg9, FontListFontFamilyTypefaceAdapter arg10, PlatformFontFamilyTypefaceAdapter arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 2) != 0) {
            arg8 = PlatformResolveInterceptor.Companion.getDefault$ui_text();
        }

        PlatformResolveInterceptor v2 = arg8;
        if((arg12 & 4) != 0) {
            arg9 = FontFamilyResolverKt.getGlobalTypefaceRequestCache();
        }

        TypefaceRequestCache v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, null);
        }

        FontListFontFamilyTypefaceAdapter v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = new PlatformFontFamilyTypefaceAdapter();
        }

        this(arg7, v2, v3, v4, arg11);
    }

    public FontFamilyResolverImpl(PlatformFontLoader arg1, PlatformResolveInterceptor arg2, TypefaceRequestCache arg3, FontListFontFamilyTypefaceAdapter arg4, PlatformFontFamilyTypefaceAdapter arg5) {
        super();
        this.platformFontLoader = arg1;
        this.platformResolveInterceptor = arg2;
        this.typefaceRequestCache = arg3;
        this.fontListFontFamilyTypefaceAdapter = arg4;
        this.platformFamilyTypefaceAdapter = arg5;
        this.createDefaultTypeface = new FontFamilyResolverImpl$$ExternalSyntheticLambda2(this);
    }

    static final Object createDefaultTypeface$lambda$0(FontFamilyResolverImpl arg8, TypefaceRequest arg9) {
        return arg8.resolve(TypefaceRequest.copy-e1PVR60$default(arg9, null, null, 0, 0, null, 30, null)).getValue();
    }

    public final PlatformFontLoader getPlatformFontLoader$ui_text() {
        return this.platformFontLoader;
    }

    public Object preload(FontFamily arg13, Continuation arg14) {
        Object v13;
        int v2;
        Continuation v0;
        if((arg14 instanceof FontFamilyResolverImpl$preload$1)) {
            v0 = arg14;
            v2 = 0x80000000;
            if((((FontFamilyResolverImpl$preload$1)v0).label & v2) != 0) {
                ((FontFamilyResolverImpl$preload$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FontFamilyResolverImpl$preload$1 v0_1 = new FontFamilyResolverImpl$preload$1(this, arg14);
        }

        Object v14 = ((FontFamilyResolverImpl$preload$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FontFamilyResolverImpl$preload$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            if(!(arg13 instanceof FontListFontFamily)) {
                return Unit.INSTANCE;
            }
            else {
                FontListFontFamilyTypefaceAdapter v14_1 = this.fontListFontFamilyTypefaceAdapter;
                PlatformFontLoader v2_1 = this.platformFontLoader;
                ((FontFamilyResolverImpl$preload$1)v0).L$0 = arg13;
                ((FontFamilyResolverImpl$preload$1)v0).label = 1;
                if(v14_1.preload(arg13, v2_1, v0) == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            v13 = ((FontFamilyResolverImpl$preload$1)v0).L$0;
            ResultKt.throwOnFailure(v14);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v14_2 = ((FontFamily)v13).getFonts();
        ArrayList v0_2 = new ArrayList(v14_2.size());
        int v1_1 = v14_2.size();
        for(v2 = 0; v2 < v1_1; ++v2) {
            Object v3 = v14_2.get(v2);
            v0_2.add(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(((FontFamily)v13)), this.platformResolveInterceptor.interceptFontWeight(((Font)v3).getWeight()), this.platformResolveInterceptor.interceptFontStyle-T2F_aPo(((Font)v3).getStyle-_-LCdwA()), FontSynthesis.Companion.getAll-GVVA2EU(), this.platformFontLoader.getCacheKey(), null));
        }

        this.typefaceRequestCache.preWarmCache(((List)v0_2), new FontFamilyResolverImpl$$ExternalSyntheticLambda3(this));
        return Unit.INSTANCE;
    }

    static final TypefaceResult preload$lambda$1(FontFamilyResolverImpl arg4, TypefaceRequest arg5) {
        TypefaceResult v0 = arg4.fontListFontFamilyTypefaceAdapter.resolve(arg5, arg4.platformFontLoader, new FontFamilyResolverImpl$$ExternalSyntheticLambda0(), arg4.createDefaultTypeface);
        if(v0 == null) {
            TypefaceResult v4 = arg4.platformFamilyTypefaceAdapter.resolve(arg5, arg4.platformFontLoader, new FontFamilyResolverImpl$$ExternalSyntheticLambda1(), arg4.createDefaultTypeface);
            if(v4 != null) {
                return v4;
            }

            throw new IllegalStateException("Could not load font");
        }

        return v0;
    }

    private static final Unit preload$lambda$1$0(Immutable arg0) {
        return Unit.INSTANCE;
    }

    private static final Unit preload$lambda$1$1(Immutable arg0) {
        return Unit.INSTANCE;
    }

    private final State resolve(TypefaceRequest arg3) {
        return this.typefaceRequestCache.runCached(arg3, new FontFamilyResolverImpl$$ExternalSyntheticLambda4(this, arg3));
    }

    static final TypefaceResult resolve$lambda$0(FontFamilyResolverImpl arg3, TypefaceRequest arg4, Function1 arg5) {
        TypefaceResult v0 = arg3.fontListFontFamilyTypefaceAdapter.resolve(arg4, arg3.platformFontLoader, arg5, arg3.createDefaultTypeface);
        if(v0 == null) {
            TypefaceResult v3 = arg3.platformFamilyTypefaceAdapter.resolve(arg4, arg3.platformFontLoader, arg5, arg3.createDefaultTypeface);
            if(v3 != null) {
                return v3;
            }

            throw new IllegalStateException("Could not load font");
        }

        return v0;
    }

    public State resolve-DPcqOEQ(FontFamily arg8, FontWeight arg9, int arg10, int arg11) {
        return this.resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(arg8), this.platformResolveInterceptor.interceptFontWeight(arg9), this.platformResolveInterceptor.interceptFontStyle-T2F_aPo(arg10), this.platformResolveInterceptor.interceptFontSynthesis-Mscr08Y(arg11), this.platformFontLoader.getCacheKey(), null));
    }
}

