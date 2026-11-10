package androidx.compose.ui.text.font;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.text.platform.DispatcherKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086@¢\u0006\u0002\u0010\u0010JB\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000F2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000B0\u00172\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001A0\u0017H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "<init>", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }

        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final CoroutineExceptionHandler DropExceptionHandler;
    private CoroutineScope asyncLoadScope;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private static final FontMatcher fontMatcher;

    public static Unit $r8$lambda$jVpNp1g4NPXUhV7kC_gm_6H5DIc(TypefaceRequest arg0) {
        return FontListFontFamilyTypefaceAdapter.preload$lambda$3$0(arg0);
    }

    static {
        FontListFontFamilyTypefaceAdapter.Companion = new Companion(null);
        FontListFontFamilyTypefaceAdapter.$stable = 8;
        FontListFontFamilyTypefaceAdapter.fontMatcher = new FontMatcher();
        FontListFontFamilyTypefaceAdapter.DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache arg1, CoroutineContext arg2, int arg3, DefaultConstructorMarker arg4) {
        EmptyCoroutineContext v2;
        if((arg3 & 1) != 0) {
            arg1 = new AsyncTypefaceCache();
        }

        if((arg3 & 2) != 0) {
            v2 = EmptyCoroutineContext.INSTANCE;
        }

        this(arg1, ((CoroutineContext)v2));
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache arg2, CoroutineContext arg3) {
        super();
        this.asyncTypefaceCache = arg2;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(FontListFontFamilyTypefaceAdapter.DropExceptionHandler.plus(DispatcherKt.getFontCacheManagementDispatcher()).plus(arg3).plus(SupervisorKt.SupervisorJob(arg3.get(Job.Key))));
    }

    public FontListFontFamilyTypefaceAdapter() {
        this(null, null, 3, null);
    }

    public static final AsyncTypefaceCache access$getAsyncTypefaceCache$p(FontListFontFamilyTypefaceAdapter arg0) {
        return arg0.asyncTypefaceCache;
    }

    public static final CoroutineExceptionHandler access$getDropExceptionHandler$cp() {
        return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
    }

    public static final FontMatcher access$getFontMatcher$cp() {
        return FontListFontFamilyTypefaceAdapter.fontMatcher;
    }

    public final Object preload(FontFamily arg15, PlatformFontLoader arg16, Continuation arg17) {
        PlatformFontLoader v7 = arg16;
        if(!(arg15 instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }

        List v8 = arg15.getFonts();
        List v0 = arg15.getFonts();
        ArrayList v2 = new ArrayList(v0.size());
        int v3 = v0.size();
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v6 = v0.get(v5);
            if(FontLoadingStrategy.equals-impl0(((Font)v6).getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
                v2.add(TuplesKt.to(((Font)v6).getWeight(), FontStyle.box-impl(((Font)v6).getStyle-_-LCdwA())));
            }
        }

        MutableScatterSet v0_1 = new MutableScatterSet(((List)v2).size());
        ArrayList v3_1 = new ArrayList(((List)v2).size());
        v5 = v2.size();
        int v6_1;
        for(v6_1 = 0; v6_1 < v5; ++v6_1) {
            Object v9 = ((List)v2).get(v6_1);
            if(v0_1.add(v9)) {
                v3_1.add(v9);
            }
        }

        ArrayList v9_1 = v3_1;
        ArrayList v10 = new ArrayList();
        int v11 = v9_1.size();
        int v12;
        for(v12 = 0; v12 < v11; ++v12) {
            Object v0_2 = ((List)v9_1).get(v12);
            Object v2_1 = ((Pair)v0_2).component1();
            v3 = ((Pair)v0_2).component2().unbox-impl();
            v0_2 = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(FontListFontFamilyTypefaceAdapter.fontMatcher.matchFont-RetOiIg(v8, ((FontWeight)v2_1), v3), new TypefaceRequest(arg15, ((FontWeight)v2_1), v3, FontSynthesis.Companion.getAll-GVVA2EU(), v7.getCacheKey(), null), this.asyncTypefaceCache, v7, new FontListFontFamilyTypefaceAdapter$$ExternalSyntheticLambda0()).component1();
            if(v0_2 != null) {
                ((List)v10).add(CollectionsKt.first(((List)v0_2)));
            }
        }

        Object v14 = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(((List)v10), this, v7, null), arg17);
        if(v14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v14;
        }

        return Unit.INSTANCE;
    }

    private static final Unit preload$lambda$3$0(TypefaceRequest arg0) {
        return Unit.INSTANCE;
    }

    public TypefaceResult resolve(TypefaceRequest arg10, PlatformFontLoader arg11, Function1 arg12, Function1 arg13) {
        TypefaceResult v1 = null;
        if(!(arg10.getFontFamily() instanceof FontListFontFamily)) {
            return v1;
        }

        Pair v13 = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(FontListFontFamilyTypefaceAdapter.fontMatcher.matchFont-RetOiIg(arg10.getFontFamily().getFonts(), arg10.getFontWeight(), arg10.getFontStyle-_-LCdwA()), arg10, this.asyncTypefaceCache, arg11, arg13);
        Object v3 = v13.component1();
        Object v4 = v13.component2();
        if(v3 == null) {
            return new Immutable(v4, false, 2, ((DefaultConstructorMarker)v1));
        }

        AsyncFontListLoader v2 = new AsyncFontListLoader(((List)v3), v4, arg10, this.asyncTypefaceCache, arg12, arg11);
        BuildersKt.launch$default(this.asyncLoadScope, null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(v2, ((Continuation)v1)), 1, null);
        return new Async(v2);
    }
}

