package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\u0010\u0010\u0019\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001A\u0010\u0012J\u0010\u0010\u001B\u001A\u00020\tHÆ\u0003¢\u0006\u0004\b\u001C\u0010\u0012J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÆ\u0003JF\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\u001F\u0010 J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001A\u00020%HÖ\u0001J\t\u0010&\u001A\u00020\'HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006("}, d2={"Landroidx/compose/ui/text/font/TypefaceRequest;", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resourceLoaderCacheKey", "<init>", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-_-LCdwA", "()I", "I", "getFontSynthesis-GVVA2EU", "getResourceLoaderCacheKey", "()Ljava/lang/Object;", "component1", "component2", "component3", "component3-_-LCdwA", "component4", "component4-GVVA2EU", "component5", "copy", "copy-e1PVR60", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;IILjava/lang/Object;)Landroidx/compose/ui/text/font/TypefaceRequest;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TypefaceRequest {
    public static final int $stable = 8;
    private final FontFamily fontFamily;
    private final int fontStyle;
    private final int fontSynthesis;
    private final FontWeight fontWeight;
    private final Object resourceLoaderCacheKey;

    static {
    }

    public TypefaceRequest(FontFamily arg1, FontWeight arg2, int arg3, int arg4, Object arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private TypefaceRequest(FontFamily arg1, FontWeight arg2, int arg3, int arg4, Object arg5) {
        super();
        this.fontFamily = arg1;
        this.fontWeight = arg2;
        this.fontStyle = arg3;
        this.fontSynthesis = arg4;
        this.resourceLoaderCacheKey = arg5;
    }

    public final FontFamily component1() {
        return this.fontFamily;
    }

    public final FontWeight component2() {
        return this.fontWeight;
    }

    public final int component3-_-LCdwA() {
        return this.fontStyle;
    }

    public final int component4-GVVA2EU() {
        return this.fontSynthesis;
    }

    public final Object component5() {
        return this.resourceLoaderCacheKey;
    }

    public final TypefaceRequest copy-e1PVR60(FontFamily arg8, FontWeight arg9, int arg10, int arg11, Object arg12) {
        return new TypefaceRequest(arg8, arg9, arg10, arg11, arg12, null);
    }

    public static TypefaceRequest copy-e1PVR60$default(TypefaceRequest arg0, FontFamily arg1, FontWeight arg2, int arg3, int arg4, Object arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.fontFamily;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.fontWeight;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.fontStyle;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.fontSynthesis;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.resourceLoaderCacheKey;
        }

        return arg0.copy-e1PVR60(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((TypefaceRequest)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TypefaceRequest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamily, ((TypefaceRequest)arg5).fontFamily)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontWeight, ((TypefaceRequest)arg5).fontWeight)) {
            return 0;
        }

        if(!FontStyle.equals-impl0(this.fontStyle, ((TypefaceRequest)arg5).fontStyle)) {
            return 0;
        }

        if(!FontSynthesis.equals-impl0(this.fontSynthesis, ((TypefaceRequest)arg5).fontSynthesis)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.resourceLoaderCacheKey, ((TypefaceRequest)arg5).resourceLoaderCacheKey)) {
            return 0;
        }

        return 1;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final int getFontStyle-_-LCdwA() {
        return this.fontStyle;
    }

    public final int getFontSynthesis-GVVA2EU() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Object getResourceLoaderCacheKey() {
        return this.resourceLoaderCacheKey;
    }

    public int hashCode() {
        FontFamily v0 = this.fontFamily;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 = (((v0_1 * 0x1F + this.fontWeight.hashCode()) * 0x1F + FontStyle.hashCode-impl(this.fontStyle)) * 0x1F + FontSynthesis.hashCode-impl(this.fontSynthesis)) * 0x1F;
        Object v3 = this.resourceLoaderCacheKey;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + FontStyle.toString-impl(this.fontStyle) + ", fontSynthesis=" + FontSynthesis.toString-impl(this.fontSynthesis) + ", resourceLoaderCacheKey=" + this.resourceLoaderCacheKey + ')';
    }
}

