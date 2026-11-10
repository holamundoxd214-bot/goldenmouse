package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FB=\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u000E\u0010\u0012J\u0018\u0010\'\u001A\u00020(2\u0006\u0010\u0004\u001A\u00020(2\u0006\u0010)\u001A\u00020(H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001D\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u001B\u0010\u0017\u001A\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0019\u0010\u001AR\u001B\u0010\u001D\u001A\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001F\u0010\u001C\u001A\u0004\b\u001E\u0010\u001AR\u001A\u0010 \u001A\b\u0012\u0004\u0012\u00020!0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0016R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006*"}, d2={"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getPlaceholders", "()Ljava/util/List;", "minIntrinsicWidth", "", "getMinIntrinsicWidth", "()F", "minIntrinsicWidth$delegate", "Lkotlin/Lazy;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "maxIntrinsicWidth$delegate", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text", "hasStaleResolvedFonts", "", "getHasStaleResolvedFonts", "()Z", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    public static final int $stable = 8;
    private final AnnotatedString annotatedString;
    private final List infoList;
    private final Lazy maxIntrinsicWidth$delegate;
    private final Lazy minIntrinsicWidth$delegate;
    private final List placeholders;

    static {
    }

    public MultiParagraphIntrinsics(AnnotatedString arg19, TextStyle arg20, List arg21, Density arg22, Resolver arg23) {
        MultiParagraphIntrinsics v0 = this;
        AnnotatedString v1 = arg19;
        super();
        v0.annotatedString = v1;
        v0.placeholders = arg21;
        v0.minIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiParagraphIntrinsics$$ExternalSyntheticLambda0(v0));
        v0.maxIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiParagraphIntrinsics$$ExternalSyntheticLambda1(v0));
        ParagraphStyle v2 = arg20.toParagraphStyle();
        List v3 = AnnotatedStringKt.normalizedParagraphStyles(v1, v2);
        ArrayList v4 = new ArrayList(v3.size());
        int v5 = v3.size();
        int v6 = 0;
        while(v6 < v5) {
            Object v7 = v3.get(v6);
            ArrayList v8 = v4;
            AnnotatedString v9 = AnnotatedStringKt.substringWithoutParagraphStyles(v1, ((Range)v7).getStart(), ((Range)v7).getEnd());
            ParagraphStyle v10 = MultiParagraphIntrinsics.access$resolveTextDirection(v0, ((Range)v7).getItem(), v2);
            String v12 = v9.getText();
            TextStyle v10_1 = arg20.merge(v10);
            List v9_1 = v9.getAnnotations$ui_text();
            if(v9_1 == null) {
                v9_1 = CollectionsKt.emptyList();
            }

            ((Collection)v8).add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(v12, v10_1, v9_1, arg22, arg23, MultiParagraphIntrinsicsKt.access$getLocalPlaceholders(v0.getPlaceholders(), ((Range)v7).getStart(), ((Range)v7).getEnd())), ((Range)v7).getStart(), ((Range)v7).getEnd()));
            ++v6;
            v1 = arg19;
        }

        v0.infoList = ((List)v4);
    }

    @Deprecated(message="Font.ResourceLoader is deprecated, call with fontFamilyResolver", replaceWith="<_subannotation>") public MultiParagraphIntrinsics(AnnotatedString arg1, TextStyle arg2, List arg3, Density arg4, ResourceLoader arg5) {
        this(arg1, arg2, arg3, arg4, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(arg5));
    }

    public static final ParagraphStyle access$resolveTextDirection(MultiParagraphIntrinsics arg0, ParagraphStyle arg1, ParagraphStyle arg2) {
        return arg0.resolveTextDirection(arg1, arg2);
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public boolean getHasStaleResolvedFonts() {
        List v4 = this.infoList;
        int v0 = v4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v4.get(v2).getIntrinsics().getHasStaleResolvedFonts()) {
                return 1;
            }
        }

        return 0;
    }

    public final List getInfoList$ui_text() {
        return this.infoList;
    }

    public float getMaxIntrinsicWidth() {
        return this.maxIntrinsicWidth$delegate.getValue().floatValue();
    }

    public float getMinIntrinsicWidth() {
        return this.minIntrinsicWidth$delegate.getValue().floatValue();
    }

    public final List getPlaceholders() {
        return this.placeholders;
    }

    static final float maxIntrinsicWidth_delegate$lambda$0(MultiParagraphIntrinsics arg7) {
        Object v7_1;
        List v7 = arg7.infoList;
        if(v7.isEmpty()) {
            v7_1 = null;
        }
        else {
            Object v0 = v7.get(0);
            float v1 = v0.getIntrinsics().getMaxIntrinsicWidth();
            int v2 = CollectionsKt.getLastIndex(v7);
            int v3 = 1;
            if(1 <= v2) {
                while(true) {
                    Object v4 = v7.get(v3);
                    float v5 = v4.getIntrinsics().getMaxIntrinsicWidth();
                    if(Float.compare(v1, v5) < 0) {
                        v0 = v4;
                        v1 = v5;
                    }

                    if(v3 == v2) {
                        break;
                    }

                    ++v3;
                }
            }

            v7_1 = v0;
        }

        if(v7_1 != null) {
            ParagraphIntrinsics v7_2 = ((ParagraphIntrinsicInfo)v7_1).getIntrinsics();
            if(v7_2 != null) {
                return v7_2.getMaxIntrinsicWidth();
            }
        }

        return 0;
    }

    static final float minIntrinsicWidth_delegate$lambda$0(MultiParagraphIntrinsics arg7) {
        Object v7_1;
        List v7 = arg7.infoList;
        if(v7.isEmpty()) {
            v7_1 = null;
        }
        else {
            Object v0 = v7.get(0);
            float v1 = v0.getIntrinsics().getMinIntrinsicWidth();
            int v2 = CollectionsKt.getLastIndex(v7);
            int v3 = 1;
            if(1 <= v2) {
                while(true) {
                    Object v4 = v7.get(v3);
                    float v5 = v4.getIntrinsics().getMinIntrinsicWidth();
                    if(Float.compare(v1, v5) < 0) {
                        v0 = v4;
                        v1 = v5;
                    }

                    if(v3 == v2) {
                        break;
                    }

                    ++v3;
                }
            }

            v7_1 = v0;
        }

        if(v7_1 != null) {
            ParagraphIntrinsics v7_2 = ((ParagraphIntrinsicInfo)v7_1).getIntrinsics();
            if(v7_2 != null) {
                return v7_2.getMinIntrinsicWidth();
            }
        }

        return 0;
    }

    private final ParagraphStyle resolveTextDirection(ParagraphStyle arg14, ParagraphStyle arg15) {
        if(!TextDirection.equals-impl0(arg14.getTextDirection-s_7X-co(), TextDirection.Companion.getUnspecified-s_7X-co())) {
            return arg14;
        }

        return ParagraphStyle.copy-ykzQM6k$default(arg14, 0, arg15.getTextDirection-s_7X-co(), 0, null, null, null, 0, 0, null, 509, null);
    }
}

