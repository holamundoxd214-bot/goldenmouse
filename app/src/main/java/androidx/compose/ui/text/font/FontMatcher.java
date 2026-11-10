package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJF\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\tH\u0080\b¢\u0006\u0002\b\u0013J+\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\u0016J+\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001A\u00020\u00172\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\u0018¨\u0006\u0019"}, d2={"Landroidx/compose/ui/text/font/FontMatcher;", "", "<init>", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontList", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontMatcher {
    public static final int $stable;

    static {
    }

    public FontMatcher() {
        super();
    }

    public final List filterByClosestWeight$ui_text(List arg8, FontWeight arg9, boolean arg10, FontWeight arg11, FontWeight arg12) {
        FontWeight v5;
        List v7 = arg8;
        int v0 = ((Collection)v7).size();
        FontWeight v1 = null;
        int v2 = 0;
        FontWeight v3 = v1;
        int v4 = 0;
        while(true) {
            if(v4 < v0) {
                v5 = arg8.get(v4).getWeight();
                if(arg11 == null || v5.compareTo(arg11) >= 0) {
                    if(arg12 != null && v5.compareTo(arg12) > 0) {
                        goto label_30;
                    }

                    if(v5.compareTo(arg9) < 0) {
                        if(v1 != null && v5.compareTo(v1) <= 0) {
                            goto label_30;
                        }

                        v1 = v5;
                        goto label_30;
                    }

                    if(v5.compareTo(arg9) <= 0) {
                        break;
                    }

                    if(v3 != null && v5.compareTo(v3) >= 0) {
                        goto label_30;
                    }

                    v3 = v5;
                }
                else {
                }

            label_30:
                ++v4;
                continue;
            }

            goto label_34;
        }

        v1 = v5;
        v3 = v1;
    label_34:
        if(arg10) {
            if(v1 == null) {
                goto label_39;
            }
        }
        else if(v3 == null) {
        }
        else {
        label_39:
            v1 = v3;
        }

        ArrayList v9 = new ArrayList(arg8.size());
        int v7_1 = ((Collection)v7).size();
        while(v2 < v7_1) {
            Object v10 = arg8.get(v2);
            if(Intrinsics.areEqual(v10.getWeight(), v1)) {
                v9.add(v10);
            }

            ++v2;
        }

        return ((List)v9);
    }

    public static List filterByClosestWeight$ui_text$default(FontMatcher arg5, List arg6, FontWeight arg7, boolean arg8, FontWeight arg9, FontWeight arg10, int arg11, Object arg12) {
        FontWeight v3;
        FontWeight v12 = null;
        if((arg11 & 4) != 0) {
            arg9 = v12;
        }

        if((arg11 & 8) != 0) {
            arg10 = v12;
        }

        List v5 = arg6;
        arg11 = ((Collection)v5).size();
        int v0 = 0;
        FontWeight v1 = v12;
        int v2 = 0;
        while(true) {
            if(v2 < arg11) {
                v3 = arg6.get(v2).getWeight();
                if(arg9 == null || v3.compareTo(arg9) >= 0) {
                    if(arg10 != null && v3.compareTo(arg10) > 0) {
                        goto label_36;
                    }

                    if(v3.compareTo(arg7) < 0) {
                        if(v12 != null && v3.compareTo(v12) <= 0) {
                            goto label_36;
                        }

                        v12 = v3;
                        goto label_36;
                    }

                    if(v3.compareTo(arg7) <= 0) {
                        break;
                    }

                    if(v1 != null && v3.compareTo(v1) >= 0) {
                        goto label_36;
                    }

                    v1 = v3;
                }
                else {
                }

            label_36:
                ++v2;
                continue;
            }

            goto label_40;
        }

        v12 = v3;
        v1 = v12;
    label_40:
        if(arg8) {
            if(v12 == null) {
                goto label_45;
            }
        }
        else if(v1 == null) {
        }
        else {
        label_45:
            v12 = v1;
        }

        ArrayList v7 = new ArrayList(arg6.size());
        int v5_1 = ((Collection)v5).size();
        while(v0 < v5_1) {
            Object v8 = arg6.get(v0);
            if(Intrinsics.areEqual(v8.getWeight(), v12)) {
                v7.add(v8);
            }

            ++v0;
        }

        return ((List)v7);
    }

    public final List matchFont-RetOiIg(List arg9, FontWeight arg10, int arg11) {
        Object v0_2;
        FontWeight v6;
        FontWeight v1_1;
        List v8_1;
        ArrayList v9;
        Object v5;
        ArrayList v8 = new ArrayList(arg9.size());
        List v0 = arg9;
        int v1 = ((Collection)v0).size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = arg9.get(v3);
            v5 = v4;
            if((Intrinsics.areEqual(((Font)v5).getWeight(), arg10)) && (FontStyle.equals-impl0(((Font)v5).getStyle-_-LCdwA(), arg11))) {
                v8.add(v4);
            }
        }

        if(!v8.isEmpty()) {
            return ((List)v8);
        }

        v8 = new ArrayList(arg9.size());
        int v0_1 = ((Collection)v0).size();
        for(v1 = 0; v1 < v0_1; ++v1) {
            Object v3_1 = arg9.get(v1);
            if(FontStyle.equals-impl0(v3_1.getStyle-_-LCdwA(), arg11)) {
                v8.add(v3_1);
            }
        }

        if(((Collection)v8).isEmpty()) {
        }
        else {
            v9 = v8;
        }

        FontWeight v11 = null;
        if(arg10.compareTo(FontWeight.Companion.getW400()) < 0) {
            v8_1 = ((List)v9);
            v0_1 = ((Collection)v8_1).size();
            v1_1 = v11;
            v3 = 0;
            goto label_52;
        }

        if(arg10.compareTo(FontWeight.Companion.getW500()) > 0) {
            v8_1 = ((List)v9);
            v0_1 = ((Collection)v8_1).size();
            v1_1 = v11;
            v3 = 0;
            goto label_97;
        }

        FontWeight v8_2 = FontWeight.Companion.getW500();
        v0 = ((List)v9);
        v1 = ((Collection)v0).size();
        FontWeight v4_1 = v11;
        FontWeight v5_1 = v4_1;
        v3 = 0;
        while(true) {
            if(v3 < v1) {
                v6 = ((List)v9).get(v3).getWeight();
                if(v8_2 != null && v6.compareTo(v8_2) > 0) {
                }
                else if(v6.compareTo(arg10) < 0) {
                    if(v4_1 != null && v6.compareTo(v4_1) <= 0) {
                        goto label_162;
                    }

                    v4_1 = v6;
                }
                else {
                    if(v6.compareTo(arg10) <= 0) {
                        break;
                    }

                    if(v5_1 != null && v6.compareTo(v5_1) >= 0) {
                        goto label_162;
                    }

                    v5_1 = v6;
                }

            label_162:
                ++v3;
                continue;
            }

            goto label_166;
        }

        v4_1 = v6;
        v5_1 = v4_1;
    label_166:
        if(v5_1 == null) {
        }
        else {
            v4_1 = v5_1;
        }

        v8 = new ArrayList(((List)v9).size());
        v1 = ((Collection)v0).size();
        for(v3 = 0; v3 < v1; ++v3) {
            v5 = ((List)v9).get(v3);
            if(Intrinsics.areEqual(v5.getWeight(), v4_1)) {
                v8.add(v5);
            }
        }

        if(((Collection)v8).isEmpty()) {
            v8_2 = FontWeight.Companion.getW500();
            v1 = ((Collection)v0).size();
            FontWeight v3_2 = v11;
            int v4_2 = 0;
            while(true) {
                if(v4_2 < v1) {
                    v5_1 = ((List)v9).get(v4_2).getWeight();
                    if(v8_2 != null && v5_1.compareTo(v8_2) < 0) {
                    }
                    else if(v5_1.compareTo(arg10) < 0) {
                        if(v11 != null && v5_1.compareTo(v11) <= 0) {
                            goto label_211;
                        }

                        v11 = v5_1;
                    }
                    else {
                        if(v5_1.compareTo(arg10) <= 0) {
                            break;
                        }

                        if(v3_2 != null && v5_1.compareTo(v3_2) >= 0) {
                            goto label_211;
                        }

                        v3_2 = v5_1;
                    }

                label_211:
                    ++v4_2;
                    continue;
                }

                goto label_215;
            }

            v11 = v5_1;
            v3_2 = v11;
        label_215:
            if(v3_2 == null) {
            }
            else {
                v11 = v3_2;
            }

            v8 = new ArrayList(((List)v9).size());
            int v10 = ((Collection)v0).size();
            while(v2 < v10) {
                v0_2 = ((List)v9).get(v2);
                if(Intrinsics.areEqual(v0_2.getWeight(), v11)) {
                    v8.add(v0_2);
                }

                ++v2;
            }
        }

        return ((List)v8);
        while(true) {
        label_97:
            if(v3 < v0_1) {
                v4_1 = ((List)v9).get(v3).getWeight();
                if(v4_1.compareTo(arg10) < 0) {
                    if(v11 != null && v4_1.compareTo(v11) <= 0) {
                        goto label_113;
                    }

                    v11 = v4_1;
                }
                else {
                    if(v4_1.compareTo(arg10) <= 0) {
                        break;
                    }

                    if(v1_1 != null && v4_1.compareTo(v1_1) >= 0) {
                        goto label_113;
                    }

                    v1_1 = v4_1;
                }

            label_113:
                ++v3;
                continue;
            }

            goto label_117;
        }

        v11 = v4_1;
        v1_1 = v11;
    label_117:
        if(v1_1 == null) {
        }
        else {
            v11 = v1_1;
        }

        ArrayList v10_1 = new ArrayList(((List)v9).size());
        int v8_3 = ((Collection)v8_1).size();
        while(v2 < v8_3) {
            v0_2 = ((List)v9).get(v2);
            if(Intrinsics.areEqual(v0_2.getWeight(), v11)) {
                v10_1.add(v0_2);
            }

            ++v2;
        }

        return ((List)v10_1);
        while(true) {
        label_52:
            if(v3 < v0_1) {
                v4_1 = ((List)v9).get(v3).getWeight();
                if(v4_1.compareTo(arg10) < 0) {
                    if(v11 != null && v4_1.compareTo(v11) <= 0) {
                        goto label_68;
                    }

                    v11 = v4_1;
                }
                else {
                    if(v4_1.compareTo(arg10) <= 0) {
                        break;
                    }

                    if(v1_1 != null && v4_1.compareTo(v1_1) >= 0) {
                        goto label_68;
                    }

                    v1_1 = v4_1;
                }

            label_68:
                ++v3;
                continue;
            }

            goto label_72;
        }

        v11 = v4_1;
        v1_1 = v11;
    label_72:
        if(v11 == null) {
            v11 = v1_1;
        }

        v10_1 = new ArrayList(((List)v9).size());
        v8_3 = ((Collection)v8_1).size();
        while(v2 < v8_3) {
            v0_2 = ((List)v9).get(v2);
            if(Intrinsics.areEqual(v0_2.getWeight(), v11)) {
                v10_1.add(v0_2);
            }

            ++v2;
        }

        return ((List)v10_1);
    }

    public final List matchFont-RetOiIg(FontFamily arg2, FontWeight arg3, int arg4) {
        if((arg2 instanceof FontListFontFamily)) {
            return this.matchFont-RetOiIg(((FontListFontFamily)arg2), arg3, arg4);
        }

        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    public final List matchFont-RetOiIg(FontListFontFamily arg1, FontWeight arg2, int arg3) {
        return this.matchFont-RetOiIg(arg1.getFonts(), arg2, arg3);
    }
}

