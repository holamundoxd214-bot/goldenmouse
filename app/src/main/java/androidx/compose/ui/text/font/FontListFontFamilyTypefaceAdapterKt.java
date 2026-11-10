package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AR\u0010\u0000\u001A\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2={"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontListFontFamilyTypefaceAdapterKt {
    public static final Pair access$firstImmediatelyAvailable(List arg0, TypefaceRequest arg1, AsyncTypefaceCache arg2, PlatformFontLoader arg3, Function1 arg4) {
        return FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(arg0, arg1, arg2, arg3, arg4);
    }

    private static final Pair firstImmediatelyAvailable(List arg16, TypefaceRequest arg17, AsyncTypefaceCache arg18, PlatformFontLoader arg19, Function1 arg20) {
        List v15_1;
        Object v0_3;
        Key v0_2;
        Object v4;
        List v1 = arg16;
        TypefaceRequest v2 = arg17;
        PlatformFontLoader v5 = arg19;
        Function1 v10 = arg20;
        int v11 = v1.size();
        Object v12 = null;
        Object v15 = v12;
        int v14;
        for(v14 = 0; true; ++v14) {
            if(v14 >= v11) {
                goto label_147;
            }

            v4 = v1.get(v14);
            int v0 = ((Font)v4).getLoadingStrategy-PKNRLFQ();
            if(!FontLoadingStrategy.equals-impl0(v0, FontLoadingStrategy.Companion.getBlocking-PKNRLFQ())) {
                goto label_57;
            }

            SynchronizedObject v1_1 = arg18.cacheLock;
            __monitor_enter(v1_1);
            try {
                v0_2 = new Key(((Font)v4), v5.getCacheKey());
                Object v3 = arg18.resultCache.get(v0_2);
                if(v3 == null) {
                    v3 = arg18.permanentCache.get(v0_2);
                }

                if(v3 == null) {
                    goto label_33;
                }

                v0_3 = ((AsyncTypefaceResult)v3).unbox-impl();
            }
            catch(Throwable v0_1) {
                goto label_55;
            }

            __monitor_exit(v1_1);
            goto label_46;
        label_33:
            goto label_34;
        label_55:
            __monitor_exit(v1_1);
            throw v0_1;
        label_34:
            __monitor_exit(v1_1);
            try {
                v0_3 = v5.loadBlocking(((Font)v4));
            }
            catch(Exception ) {
                v0_3 = v10.invoke(v2);
            }

            Object v6 = v0_3;
            AsyncTypefaceCache.put$default(arg18, ((Font)v4), v5, v6, false, 8, null);
            v0_3 = v6;
        label_46:
            if(v0_3 == null) {
                v0_3 = v10.invoke(v2);
            }

            return TuplesKt.to(v15, FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(v2.getFontSynthesis-GVVA2EU(), v0_3, ((Font)v4), v2.getFontWeight(), v2.getFontStyle-_-LCdwA()));
        label_57:
            if(!FontLoadingStrategy.equals-impl0(v0, FontLoadingStrategy.Companion.getOptionalLocal-PKNRLFQ())) {
                goto label_109;
            }

            SynchronizedObject v3_1 = arg18.cacheLock;
            __monitor_enter(v3_1);
            try {
                v0_2 = new Key(((Font)v4), v5.getCacheKey());
                v6 = arg18.resultCache.get(v0_2);
                if(v6 == null) {
                    v6 = arg18.permanentCache.get(v0_2);
                }

                if(v6 == null) {
                    goto label_76;
                }

                v0_3 = ((AsyncTypefaceResult)v6).unbox-impl();
            }
            catch(Throwable v0_1) {
                goto label_107;
            }

            __monitor_exit(v3_1);
            goto label_97;
        label_76:
            goto label_77;
        label_107:
            __monitor_exit(v3_1);
            throw v0_1;
        label_77:
            __monitor_exit(v3_1);
            try {
                v0_3 = Result.constructor-impl(v5.loadBlocking(((Font)v4)));
            }
            catch(Throwable v0_1) {
                v0_3 = Result.constructor-impl(ResultKt.createFailure(v0_1));
            }

            v6 = Result.isFailure-impl(v0_3) ? v12 : v0_3;
            AsyncTypefaceCache.put$default(arg18, ((Font)v4), v5, v6, false, 8, null);
            v0_3 = v6;
        label_97:
            if(v0_3 == null) {
                goto label_137;
            }

            return TuplesKt.to(v15, FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(v2.getFontSynthesis-GVVA2EU(), v0_3, ((Font)v4), v2.getFontWeight(), v2.getFontStyle-_-LCdwA()));
        label_109:
            if(!FontLoadingStrategy.equals-impl0(v0, FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
                break;
            }

            AsyncTypefaceResult v0_4 = arg18.get-1ASDuI8(((Font)v4), v5);
            if(v0_4 == null) {
                if((((List)v15)) == null) {
                    v15_1 = CollectionsKt.mutableListOf(new Font[]{v4});
                    goto label_137;
                }

                v15_1.add(v4);
                goto label_137;
            }

            if(!AsyncTypefaceResult.isPermanentFailure-impl(v0_4.unbox-impl()) && v0_4.unbox-impl() != null) {
                return TuplesKt.to(v15_1, FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(v2.getFontSynthesis-GVVA2EU(), v0_4.unbox-impl(), ((Font)v4), v2.getFontWeight(), v2.getFontStyle-_-LCdwA()));
            }

        label_137:
        }

        throw new IllegalStateException("Unknown font type " + v4);
    label_147:
        return TuplesKt.to(v15_1, v10.invoke(v2));
    }
}

