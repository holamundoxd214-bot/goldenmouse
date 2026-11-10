package androidx.core.widget;

import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Av\u0010\u0000\u001A\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0003\u001A^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\bø\u0001\u0000\u001Av\u0010\u000E\u001A\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0003\u001A^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\r0\u0004H\u0086\bø\u0001\u0000\u001A7\u0010\u0010\u001A\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0003\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bø\u0001\u0000\u001A\u0083\u0002\u0010\u0013\u001A\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0014\u001A^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u0015\u001A^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0016\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2={"doBeforeTextChanged", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "action", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "doOnTextChanged", "before", "doAfterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "addTextChangedListener", "beforeTextChanged", "onTextChanged", "afterTextChanged", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView arg1, Function4 arg2, Function4 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(arg3, "onTextChanged");
        Intrinsics.checkNotNullParameter(arg4, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 v0 = new TextViewKt$addTextChangedListener$textWatcher$1(arg4, arg2, arg3);
        arg1.addTextChangedListener(((TextWatcher)v0));
        return ((TextWatcher)v0);
    }

    public static TextWatcher addTextChangedListener$default(TextView arg0, Function4 arg1, Function4 arg2, Function1 arg3, int arg4, Object arg5) {
        TextViewKt$addTextChangedListener$3 v3;
        TextViewKt$addTextChangedListener$2 v2;
        TextViewKt$addTextChangedListener$1 v1;
        if((arg4 & 1) != 0) {
            v1 = TextViewKt$addTextChangedListener$1.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            v2 = TextViewKt$addTextChangedListener$2.INSTANCE;
        }

        if((arg4 & 4) != 0) {
            v3 = TextViewKt$addTextChangedListener$3.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(v1, "beforeTextChanged");
        Intrinsics.checkNotNullParameter(v2, "onTextChanged");
        Intrinsics.checkNotNullParameter(v3, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 v4 = new TextViewKt$addTextChangedListener$textWatcher$1(((Function1)v3), ((Function4)v1), ((Function4)v2));
        arg0.addTextChangedListener(((TextWatcher)v4));
        return ((TextWatcher)v4);
    }

    public static final TextWatcher doAfterTextChanged(TextView arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 v0 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(arg2);
        arg1.addTextChangedListener(((TextWatcher)v0));
        return ((TextWatcher)v0);
    }

    public static final TextWatcher doBeforeTextChanged(TextView arg1, Function4 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 v0 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(arg2);
        arg1.addTextChangedListener(((TextWatcher)v0));
        return ((TextWatcher)v0);
    }

    public static final TextWatcher doOnTextChanged(TextView arg1, Function4 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 v0 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(arg2);
        arg1.addTextChangedListener(((TextWatcher)v0));
        return ((TextWatcher)v0);
    }
}

