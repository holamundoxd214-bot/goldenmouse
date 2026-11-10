package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001As\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00012\b\b\u0002\u0010\u0013\u001A\u00020\u00012\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"ceilToIntPx", "", "", "updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextDelegateKt {
    public static final int ceilToIntPx(float arg2) {
        return Math.round(((float)Math.ceil(((double)arg2))));
    }

    public static final TextDelegate updateTextDelegate-rm0N8CA(TextDelegate arg12, AnnotatedString arg13, TextStyle arg14, Density arg15, Resolver arg16, boolean arg17, int arg18, int arg19, int arg20, List arg21) {
        Resolver v9;
        List v10;
        int v5;
        int v4;
        int v7;
        boolean v6;
        if(!Intrinsics.areEqual(arg12.getText(), arg13) || !Intrinsics.areEqual(arg12.getStyle(), arg14)) {
            v9 = arg16;
            v6 = arg17;
        label_43:
            v7 = arg18;
        label_44:
            v4 = arg19;
        label_45:
            v5 = arg20;
        label_46:
            v10 = arg21;
        }
        else {
            v6 = arg17;
            if(arg12.getSoftWrap() == v6) {
                v7 = arg18;
                if(TextOverflow.equals-impl0(arg12.getOverflow-gIe3tQ8(), v7)) {
                    v4 = arg19;
                    if(arg12.getMaxLines() == v4) {
                        v5 = arg20;
                        if(arg12.getMinLines() == v5 && (Intrinsics.areEqual(arg12.getDensity(), arg15))) {
                            v10 = arg21;
                            if(Intrinsics.areEqual(arg12.getPlaceholders(), v10)) {
                                v9 = arg16;
                                if(arg12.getFontFamilyResolver() != v9) {
                                    goto label_47;
                                }
                                else {
                                    return arg12;
                                }
                            }
                            else {
                                v9 = arg16;
                                goto label_47;
                            }
                        }

                        v9 = arg16;
                        goto label_46;
                    }
                    else {
                        v9 = arg16;
                        goto label_45;
                    }
                }
                else {
                    v9 = arg16;
                    goto label_44;
                }
            }
            else {
                v9 = arg16;
                goto label_43;
            }
        }

    label_47:
        return new TextDelegate(arg13, arg14, v4, v5, v6, v7, arg15, v9, v10, null);
    }

    public static TextDelegate updateTextDelegate-rm0N8CA$default(TextDelegate arg1, AnnotatedString arg2, TextStyle arg3, Density arg4, Resolver arg5, boolean arg6, int arg7, int arg8, int arg9, List arg10, int arg11, Object arg12) {
        if((arg11 & 0x40) != 0) {
            arg7 = TextOverflow.Companion.getClip-gIe3tQ8();
        }

        if((arg11 & 0x80) != 0) {
            arg8 = 0x7FFFFFFF;
        }

        return TextDelegateKt.updateTextDelegate-rm0N8CA(arg1, arg2, arg3, arg4, arg5, true, arg7, arg8, 1, arg10);
    }
}

