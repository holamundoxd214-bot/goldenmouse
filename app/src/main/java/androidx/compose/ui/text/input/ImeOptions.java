package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,BO\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010BG\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\u000F\u0010\u0011B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000F\u0010\u0012JU\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b \u0010!JM\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\"\u0010#JA\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001A\u00020\u00032\b\u0010\'\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001A\u00020)H\u0016J\b\u0010*\u001A\u00020+H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001A\u00020\n¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u001A\u0010\u0016R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006-"}, d2={"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSingleLine", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getAutoCorrect", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "copy", "copy-wBHncE4", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ImeOptions {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final ImeOptions Default;
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    static {
        ImeOptions.Companion = new Companion(null);
        ImeOptions.Default = new ImeOptions(false, 0, false, 0, 0, null, null, 0x7F, null);
    }

    public ImeOptions(boolean arg1, int arg2, boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, LocaleList arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public ImeOptions(boolean arg9, int arg10, boolean arg11, int arg12, int arg13, PlatformImeOptions arg14, LocaleList arg15, int arg16, DefaultConstructorMarker arg17) {
        boolean v0 = (arg16 & 1) != 0 ? false : arg9;
        int v1 = (arg16 & 2) != 0 ? KeyboardCapitalization.Companion.getNone-IUNYP9k() : arg10;
        boolean v2 = (arg16 & 4) != 0 ? true : arg11;
        int v3 = (arg16 & 8) != 0 ? KeyboardType.Companion.getText-PjHm6EE() : arg12;
        int v4 = (arg16 & 16) != 0 ? ImeAction.Companion.getDefault-eUduSuo() : arg13;
        PlatformImeOptions v5 = (arg16 & 0x20) != 0 ? null : arg14;
        LocaleList v6 = (arg16 & 0x40) != 0 ? LocaleList.Companion.getEmpty() : arg15;
        this(v0, v1, v2, v3, v4, v5, v6, null);
    }

    private ImeOptions(boolean arg11, int arg12, boolean arg13, int arg14, int arg15) {
        this(arg11, arg12, arg13, arg14, arg15, null, null, 0x40, null);
    }

    public ImeOptions(boolean arg8, int arg9, boolean arg10, int arg11, int arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 2) != 0) {
            arg9 = KeyboardCapitalization.Companion.getNone-IUNYP9k();
        }

        int v2 = arg9;
        if((arg13 & 8) != 0) {
            arg11 = KeyboardType.Companion.getText-PjHm6EE();
        }

        int v4 = arg11;
        if((arg13 & 16) != 0) {
            arg12 = ImeAction.Companion.getDefault-eUduSuo();
        }

        this(false, v2, true, v4, arg12, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new constructor that takes optional platformImeOptions parameter.") public ImeOptions(boolean arg1, int arg2, boolean arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private ImeOptions(boolean arg11, int arg12, boolean arg13, int arg14, int arg15, PlatformImeOptions arg16) {
        this(arg11, arg12, arg13, arg14, arg15, arg16, LocaleList.Companion.getEmpty(), null);
    }

    public ImeOptions(boolean arg8, int arg9, boolean arg10, int arg11, int arg12, PlatformImeOptions arg13, int arg14, DefaultConstructorMarker arg15) {
        boolean v0 = (arg14 & 1) != 0 ? false : arg8;
        int v1 = (arg14 & 2) != 0 ? KeyboardCapitalization.Companion.getNone-IUNYP9k() : arg9;
        boolean v2 = (arg14 & 4) != 0 ? true : arg10;
        int v3 = (arg14 & 8) != 0 ? KeyboardType.Companion.getText-PjHm6EE() : arg11;
        int v4 = (arg14 & 16) != 0 ? ImeAction.Companion.getDefault-eUduSuo() : arg12;
        PlatformImeOptions v5 = (arg14 & 0x20) != 0 ? null : arg13;
        this(v0, v1, v2, v3, v4, v5, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new constructor that takes optional hintLocales parameter.") public ImeOptions(boolean arg1, int arg2, boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private ImeOptions(boolean arg1, int arg2, boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, LocaleList arg7) {
        super();
        this.singleLine = arg1;
        this.capitalization = arg2;
        this.autoCorrect = arg3;
        this.keyboardType = arg4;
        this.imeAction = arg5;
        this.platformImeOptions = arg6;
        this.hintLocales = arg7;
    }

    public static final ImeOptions access$getDefault$cp() {
        return ImeOptions.Default;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new copy function that takes optional hintLocales parameter.") public final ImeOptions copy-YTHSh70(boolean arg10, int arg11, boolean arg12, int arg13, int arg14, PlatformImeOptions arg15) {
        return new ImeOptions(arg10, arg11, arg12, arg13, arg14, arg15, this.hintLocales, null);
    }

    public static ImeOptions copy-YTHSh70$default(ImeOptions arg0, boolean arg1, int arg2, boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.singleLine;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.capitalization;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.autoCorrect;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.keyboardType;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.imeAction;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.platformImeOptions;
        }

        return arg0.copy-YTHSh70(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new copy function that takes optional platformImeOptions parameter.") public final ImeOptions copy-uxg59PA(boolean arg10, int arg11, boolean arg12, int arg13, int arg14) {
        return new ImeOptions(arg10, arg11, arg12, arg13, arg14, this.platformImeOptions, this.hintLocales, null);
    }

    public static ImeOptions copy-uxg59PA$default(ImeOptions arg0, boolean arg1, int arg2, boolean arg3, int arg4, int arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.singleLine;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.capitalization;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.autoCorrect;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.keyboardType;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.imeAction;
        }

        return arg0.copy-uxg59PA(arg1, arg2, arg3, arg4, arg5);
    }

    public final ImeOptions copy-wBHncE4(boolean arg10, int arg11, boolean arg12, int arg13, int arg14, PlatformImeOptions arg15, LocaleList arg16) {
        return new ImeOptions(arg10, arg11, arg12, arg13, arg14, arg15, arg16, null);
    }

    public static ImeOptions copy-wBHncE4$default(ImeOptions arg0, boolean arg1, int arg2, boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, LocaleList arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.singleLine;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.capitalization;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.autoCorrect;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.keyboardType;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.imeAction;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.platformImeOptions;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.hintLocales;
        }

        return arg0.copy-wBHncE4(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((ImeOptions)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ImeOptions)) {
            return 0;
        }

        if(this.singleLine != ((ImeOptions)arg5).singleLine) {
            return 0;
        }

        if(!KeyboardCapitalization.equals-impl0(this.capitalization, ((ImeOptions)arg5).capitalization)) {
            return 0;
        }

        if(this.autoCorrect != ((ImeOptions)arg5).autoCorrect) {
            return 0;
        }

        if(!KeyboardType.equals-impl0(this.keyboardType, ((ImeOptions)arg5).keyboardType)) {
            return 0;
        }

        if(!ImeAction.equals-impl0(this.imeAction, ((ImeOptions)arg5).imeAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformImeOptions, ((ImeOptions)arg5).platformImeOptions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.hintLocales, ((ImeOptions)arg5).hintLocales)) {
            return 0;
        }

        return 1;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public final int getCapitalization-IUNYP9k() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    public final int getImeAction-eUduSuo() {
        return this.imeAction;
    }

    public final int getKeyboardType-PjHm6EE() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        int v0 = ((((Boolean.hashCode(this.singleLine) * 0x1F + KeyboardCapitalization.hashCode-impl(this.capitalization)) * 0x1F + Boolean.hashCode(this.autoCorrect)) * 0x1F + KeyboardType.hashCode-impl(this.keyboardType)) * 0x1F + ImeAction.hashCode-impl(this.imeAction)) * 0x1F;
        PlatformImeOptions v1 = this.platformImeOptions;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (v0 + v1_1) * 0x1F + this.hintLocales.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.toString-impl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.toString-impl(this.keyboardType) + ", imeAction=" + ImeAction.toString-impl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + ", hintLocales=" + this.hintLocales + ')';
    }
}

