package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KBU\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010BS\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0012B1\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u000F\u0010\u0013B=\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u000F\u0010\u0014J\u0017\u00106\u001A\u0002072\b\b\u0002\u00108\u001A\u00020\u0005H\u0000¢\u0006\u0002\b9J[\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b;\u0010<J[\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b;\u0010=JC\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b>\u0010?J7\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b@\u0010AJ\u0013\u0010B\u001A\u00020\u00052\b\u0010C\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010D\u001A\u00020EH\u0016J\b\u0010F\u001A\u00020GH\u0016J\u0010\u0010H\u001A\u00020\u00002\b\u0010C\u001A\u0004\u0018\u00010\u0000J\u0017\u0010I\u001A\u00020\u00002\b\u0010C\u001A\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\bJR\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u001B\u0010\u0016R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u001C\u0010\u0016R\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0015\u0010\f\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001F\u0010\u0019R\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u001A\u0010\u0011\u001A\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u001A\u0010&\u001A\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\'\u0010#\u001A\u0004\b(\u0010%R\u0014\u0010)\u001A\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010%R\u0014\u0010+\u001A\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b,\u0010\u0016R\u0014\u0010-\u001A\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b.\u0010\u0016R\u0014\u0010/\u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b0\u0010\u0016R\u0014\u00101\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b2\u0010%R\u0014\u00103\u001A\u00020\u000E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b4\u0010!R\u0014\u00105\u001A\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b5\u0010%¨\u0006L"}, d2={"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrectEnabled", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCapitalization-IUNYP9k", "()I", "I", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation", "hintLocalesOrDefault", "getHintLocalesOrDefault", "isCompletelyUnspecified", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation", "copy", "copy-INvB4aQ", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "hashCode", "", "toString", "", "merge", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class KeyboardOptions {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\b¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation$annotations", "getSecureTextField$foundation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        public static void getDefault$annotations() {
        }

        public final KeyboardOptions getSecureTextField$foundation() {
            return KeyboardOptions.SecureTextField;
        }

        public static void getSecureTextField$foundation$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final KeyboardOptions Default;
    private static final KeyboardOptions SecureTextField;
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    static {
        KeyboardOptions.Companion = new Companion(null);
        KeyboardOptions.Default = new KeyboardOptions(0, null, 0, 0, null, null, null, 0x7F, null);
        KeyboardOptions.SecureTextField = new KeyboardOptions(0, Boolean.valueOf(false), KeyboardType.Companion.getPassword-PjHm6EE(), 0, null, null, null, 0x79, null);
    }

    public KeyboardOptions(int arg9, Boolean arg10, int arg11, int arg12, PlatformImeOptions arg13, Boolean arg14, LocaleList arg15, int arg16, DefaultConstructorMarker arg17) {
        int v0 = (arg16 & 1) != 0 ? KeyboardCapitalization.Companion.getUnspecified-IUNYP9k() : arg9;
        LocaleList v2 = null;
        Boolean v1 = (arg16 & 2) != 0 ? ((Boolean)v2) : arg10;
        int v3 = (arg16 & 4) != 0 ? KeyboardType.Companion.getUnspecified-PjHm6EE() : arg11;
        int v4 = (arg16 & 8) != 0 ? ImeAction.Companion.getUnspecified-eUduSuo() : arg12;
        PlatformImeOptions v5 = (arg16 & 16) != 0 ? ((PlatformImeOptions)v2) : arg13;
        Boolean v6 = (arg16 & 0x20) != 0 ? ((Boolean)v2) : arg14;
        if((arg16 & 0x40) != 0) {
        }
        else {
            v2 = arg15;
        }

        this(v0, v1, v3, v4, v5, v6, v2, null);
    }

    private KeyboardOptions(int arg1, Boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, Boolean arg6, LocaleList arg7) {
        super();
        this.capitalization = arg1;
        this.autoCorrectEnabled = arg2;
        this.keyboardType = arg3;
        this.imeAction = arg4;
        this.platformImeOptions = arg5;
        this.showKeyboardOnFocus = arg6;
        this.hintLocales = arg7;
    }

    public KeyboardOptions(int arg1, Boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, Boolean arg6, LocaleList arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private KeyboardOptions(int arg11, boolean arg12, int arg13, int arg14) {
        this(arg11, Boolean.valueOf(arg12), arg13, arg14, null, null, null, 0x60, null);
    }

    public KeyboardOptions(int arg7, boolean arg8, int arg9, int arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 1) != 0) {
            arg7 = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
        }

        int v1 = arg7;
        if((arg11 & 2) != 0) {
            arg8 = KeyboardOptions.Default.getAutoCorrectOrDefault();
        }

        boolean v2 = arg8;
        if((arg11 & 4) != 0) {
            arg9 = KeyboardType.Companion.getUnspecified-PjHm6EE();
        }

        int v3 = arg9;
        if((arg11 & 8) != 0) {
            arg10 = ImeAction.Companion.getDefault-eUduSuo();
        }

        this(v1, v2, v3, arg10, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new constructor that takes optional platformImeOptions parameter.") public KeyboardOptions(int arg1, boolean arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private KeyboardOptions(int arg11, boolean arg12, int arg13, int arg14, PlatformImeOptions arg15) {
        this(arg11, Boolean.valueOf(arg12), arg13, arg14, arg15, Boolean.valueOf(KeyboardOptions.Default.getShowKeyboardOnFocusOrDefault$foundation()), null, 0x40, null);
    }

    public KeyboardOptions(int arg8, boolean arg9, int arg10, int arg11, PlatformImeOptions arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 1) != 0) {
            arg8 = KeyboardCapitalization.Companion.getNone-IUNYP9k();
        }

        int v1 = arg8;
        if((arg13 & 2) != 0) {
            arg9 = KeyboardOptions.Default.getAutoCorrectOrDefault();
        }

        boolean v2 = arg9;
        if((arg13 & 4) != 0) {
            arg10 = KeyboardType.Companion.getText-PjHm6EE();
        }

        int v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = ImeAction.Companion.getDefault-eUduSuo();
        }

        int v4 = arg11;
        if((arg13 & 16) != 0) {
            arg12 = null;
        }

        this(v1, v2, v3, v4, arg12, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compat") public KeyboardOptions(int arg1, boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private KeyboardOptions(int arg10, boolean arg11, int arg12, int arg13, PlatformImeOptions arg14, Boolean arg15, LocaleList arg16) {
        this(arg10, Boolean.valueOf(arg11), arg12, arg13, arg14, arg15, arg16, null);
    }

    public KeyboardOptions(int arg10, boolean arg11, int arg12, int arg13, PlatformImeOptions arg14, Boolean arg15, LocaleList arg16, int arg17, DefaultConstructorMarker arg18) {
        if((arg17 & 1) != 0) {
            arg10 = KeyboardCapitalization.Companion.getUnspecified-IUNYP9k();
        }

        int v1 = arg10;
        if((arg17 & 4) != 0) {
            arg12 = KeyboardType.Companion.getUnspecified-PjHm6EE();
        }

        int v3 = arg12;
        if((arg17 & 8) != 0) {
            arg13 = ImeAction.Companion.getUnspecified-eUduSuo();
        }

        int v4 = arg13;
        PlatformImeOptions v12 = null;
        PlatformImeOptions v5 = (arg17 & 16) != 0 ? v12 : arg14;
        Boolean v6 = (arg17 & 0x20) != 0 ? ((Boolean)v12) : arg15;
        LocaleList v7 = (arg17 & 0x40) != 0 ? ((LocaleList)v12) : arg16;
        this(v1, arg11, v3, v4, v5, v6, v7, null);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith="<_subannotation>") public KeyboardOptions(int arg1, boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, Boolean arg6, LocaleList arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final KeyboardOptions access$getDefault$cp() {
        return KeyboardOptions.Default;
    }

    public static final KeyboardOptions access$getSecureTextField$cp() {
        return KeyboardOptions.SecureTextField;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the new copy function that takes optional platformImeOptions parameter.") public final KeyboardOptions copy-3m2b7yw(int arg10, boolean arg11, int arg12, int arg13) {
        return new KeyboardOptions(arg10, Boolean.valueOf(arg11), arg12, arg13, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    public static KeyboardOptions copy-3m2b7yw$default(KeyboardOptions arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.capitalization;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.getAutoCorrectOrDefault();
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.keyboardType;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.imeAction;
        }

        return arg0.copy-3m2b7yw(arg1, arg2, arg3, arg4);
    }

    public final KeyboardOptions copy-INvB4aQ(int arg10, Boolean arg11, int arg12, int arg13, PlatformImeOptions arg14, Boolean arg15, LocaleList arg16) {
        return new KeyboardOptions(arg10, arg11, arg12, arg13, arg14, arg15, arg16, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith="<_subannotation>") public final KeyboardOptions copy-INvB4aQ(int arg10, boolean arg11, int arg12, int arg13, PlatformImeOptions arg14, Boolean arg15, LocaleList arg16) {
        return new KeyboardOptions(arg10, Boolean.valueOf(arg11), arg12, arg13, arg14, arg15, arg16, null);
    }

    public static KeyboardOptions copy-INvB4aQ$default(KeyboardOptions arg1, int arg2, Boolean arg3, int arg4, int arg5, PlatformImeOptions arg6, Boolean arg7, LocaleList arg8, int arg9, Object arg10) {
        KeyboardOptions v3;
        Boolean v5;
        int v7;
        int v6;
        Boolean v9;
        PlatformImeOptions v8;
        LocaleList v10;
        if((arg9 & 1) != 0) {
            arg2 = arg1.capitalization;
        }

        if((arg9 & 2) != 0) {
            arg3 = arg1.autoCorrectEnabled;
        }

        if((arg9 & 4) != 0) {
            arg4 = arg1.keyboardType;
        }

        if((arg9 & 8) != 0) {
            arg5 = arg1.imeAction;
        }

        if((arg9 & 16) != 0) {
            arg6 = arg1.platformImeOptions;
        }

        Boolean v0 = null;
        if((arg9 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg9 & 0x40) != 0) {
            v10 = ((LocaleList)v0);
            v8 = arg6;
            v9 = arg7;
            v6 = arg4;
            v7 = arg5;
            arg4 = arg2;
            v5 = arg3;
            v3 = arg1;
        }
        else {
            v10 = arg8;
            v9 = arg7;
            v7 = arg5;
            v8 = arg6;
            v5 = arg3;
            v6 = arg4;
            v3 = arg1;
            arg4 = arg2;
        }

        return v3.copy-INvB4aQ(arg4, v5, v6, v7, v8, v9, v10);
    }

    public static KeyboardOptions copy-INvB4aQ$default(KeyboardOptions arg0, int arg1, boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, Boolean arg6, LocaleList arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.capitalization;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.getAutoCorrectOrDefault();
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.keyboardType;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.imeAction;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.platformImeOptions;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = Boolean.valueOf(arg0.getShowKeyboardOnFocusOrDefault$foundation());
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.hintLocales;
        }

        return arg0.copy-INvB4aQ(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final KeyboardOptions copy-ij11fho(int arg10, boolean arg11, int arg12, int arg13, PlatformImeOptions arg14) {
        return new KeyboardOptions(arg10, Boolean.valueOf(arg11), arg12, arg13, arg14, this.showKeyboardOnFocus, this.hintLocales, null);
    }

    public static KeyboardOptions copy-ij11fho$default(KeyboardOptions arg0, int arg1, boolean arg2, int arg3, int arg4, PlatformImeOptions arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.capitalization;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.getAutoCorrectOrDefault();
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.keyboardType;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.imeAction;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.platformImeOptions;
        }

        return arg0.copy-ij11fho(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((KeyboardOptions)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof KeyboardOptions)) {
            return 0;
        }

        if(!KeyboardCapitalization.equals-impl0(this.capitalization, ((KeyboardOptions)arg5).capitalization)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.autoCorrectEnabled, ((KeyboardOptions)arg5).autoCorrectEnabled)) {
            return 0;
        }

        if(!KeyboardType.equals-impl0(this.keyboardType, ((KeyboardOptions)arg5).keyboardType)) {
            return 0;
        }

        if(!ImeAction.equals-impl0(this.imeAction, ((KeyboardOptions)arg5).imeAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformImeOptions, ((KeyboardOptions)arg5).platformImeOptions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.showKeyboardOnFocus, ((KeyboardOptions)arg5).showKeyboardOnFocus)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.hintLocales, ((KeyboardOptions)arg5).hintLocales)) {
            return 0;
        }

        return 1;
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation(KeyboardOptions arg13) {
        if(arg13 != null && !arg13.isCompletelyUnspecified()) {
            if(Intrinsics.areEqual(arg13, this)) {
            }
            else if(this.isCompletelyUnspecified()) {
                return arg13;
            }
            else {
                KeyboardCapitalization v0 = KeyboardCapitalization.box-impl(this.capitalization);
                ImeAction v2 = null;
                if(!KeyboardCapitalization.equals-impl0(v0.unbox-impl(), KeyboardCapitalization.Companion.getUnspecified-IUNYP9k())) {
                }
                else {
                    v0 = ((KeyboardCapitalization)v2);
                }

                int v0_1 = v0 != null ? v0.unbox-impl() : arg13.capitalization;
                int v4 = v0_1;
                Boolean v0_2 = this.autoCorrectEnabled;
                if(v0_2 == null) {
                    v0_2 = arg13.autoCorrectEnabled;
                }

                Boolean v5 = v0_2;
                KeyboardType v0_3 = KeyboardType.box-impl(this.keyboardType);
                if(!KeyboardType.equals-impl0(v0_3.unbox-impl(), KeyboardType.Companion.getUnspecified-PjHm6EE())) {
                }
                else {
                    v0_3 = ((KeyboardType)v2);
                }

                v0_1 = v0_3 != null ? v0_3.unbox-impl() : arg13.keyboardType;
                int v6 = v0_1;
                ImeAction v0_4 = ImeAction.box-impl(this.imeAction);
                if(!ImeAction.equals-impl0(v0_4.unbox-impl(), ImeAction.Companion.getUnspecified-eUduSuo())) {
                    v2 = v0_4;
                }

                v0_1 = v2 != null ? v2.unbox-impl() : arg13.imeAction;
                int v7 = v0_1;
                PlatformImeOptions v0_5 = this.platformImeOptions;
                if(v0_5 == null) {
                    v0_5 = arg13.platformImeOptions;
                }

                PlatformImeOptions v8 = v0_5;
                v0_2 = this.showKeyboardOnFocus;
                if(v0_2 == null) {
                    v0_2 = arg13.showKeyboardOnFocus;
                }

                Boolean v9 = v0_2;
                LocaleList v12 = this.hintLocales;
                if(v12 == null) {
                    v12 = arg13.hintLocales;
                }

                return new KeyboardOptions(v4, v5, v6, v7, v8, v9, v12, null);
            }
        }

        return this;
    }

    public final boolean getAutoCorrect() {
        return this.getAutoCorrectOrDefault();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Please use the autoCorrectEnabled property.") public static void getAutoCorrect$annotations() {
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean v0 = this.autoCorrectEnabled;
        if(v0 != null) {
            return v0.booleanValue();
        }

        return 1;
    }

    public final int getCapitalization-IUNYP9k() {
        return this.capitalization;
    }

    private final int getCapitalizationOrDefault-IUNYP9k() {
        KeyboardCapitalization v2 = KeyboardCapitalization.box-impl(this.capitalization);
        if(!KeyboardCapitalization.equals-impl0(v2.unbox-impl(), KeyboardCapitalization.Companion.getUnspecified-IUNYP9k())) {
        }
        else {
            v2 = null;
        }

        if(v2 != null) {
            return v2.unbox-impl();
        }

        return KeyboardCapitalization.Companion.getNone-IUNYP9k();
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList v0 = this.hintLocales;
        if(v0 == null) {
            v0 = LocaleList.Companion.getEmpty();
        }

        return v0;
    }

    public final int getImeAction-eUduSuo() {
        return this.imeAction;
    }

    public final int getImeActionOrDefault-eUduSuo$foundation() {
        ImeAction v2 = ImeAction.box-impl(this.imeAction);
        if(!ImeAction.equals-impl0(v2.unbox-impl(), ImeAction.Companion.getUnspecified-eUduSuo())) {
        }
        else {
            v2 = null;
        }

        if(v2 != null) {
            return v2.unbox-impl();
        }

        return ImeAction.Companion.getDefault-eUduSuo();
    }

    public final int getKeyboardType-PjHm6EE() {
        return this.keyboardType;
    }

    private final int getKeyboardTypeOrDefault-PjHm6EE() {
        KeyboardType v2 = KeyboardType.box-impl(this.keyboardType);
        if(!KeyboardType.equals-impl0(v2.unbox-impl(), KeyboardType.Companion.getUnspecified-PjHm6EE())) {
        }
        else {
            v2 = null;
        }

        if(v2 != null) {
            return v2.unbox-impl();
        }

        return KeyboardType.Companion.getText-PjHm6EE();
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final boolean getShouldShowKeyboardOnFocus() {
        Boolean v0 = this.showKeyboardOnFocus;
        if(v0 != null) {
            return v0.booleanValue();
        }

        return 1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Included for binary compatibility. Use showKeyboardOnFocus.") public static void getShouldShowKeyboardOnFocus$annotations() {
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation() {
        Boolean v0 = this.showKeyboardOnFocus;
        if(v0 != null) {
            return v0.booleanValue();
        }

        return 1;
    }

    public int hashCode() {
        int v0 = KeyboardCapitalization.hashCode-impl(this.capitalization) * 0x1F;
        Boolean v1 = this.autoCorrectEnabled;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (((v0 + v1_1) * 0x1F + KeyboardType.hashCode-impl(this.keyboardType)) * 0x1F + ImeAction.hashCode-impl(this.imeAction)) * 0x1F;
        PlatformImeOptions v1_2 = this.platformImeOptions;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.showKeyboardOnFocus;
        v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        LocaleList v3 = this.hintLocales;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    private final boolean isCompletelyUnspecified() {
        if((KeyboardCapitalization.equals-impl0(this.capitalization, KeyboardCapitalization.Companion.getUnspecified-IUNYP9k())) && this.autoCorrectEnabled == null && (KeyboardType.equals-impl0(this.keyboardType, KeyboardType.Companion.getUnspecified-PjHm6EE())) && (ImeAction.equals-impl0(this.imeAction, ImeAction.Companion.getUnspecified-eUduSuo())) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null) {
            return 1;
        }

        return 0;
    }

    public final KeyboardOptions merge(KeyboardOptions arg1) {
        if(arg1 != null) {
            arg1 = arg1.fillUnspecifiedValuesWith$foundation(this);
            if(arg1 == null) {
            }
            else {
                return arg1;
            }
        }

        return this;
    }

    public final ImeOptions toImeOptions$foundation(boolean arg10) {
        return new ImeOptions(arg10, this.getCapitalizationOrDefault-IUNYP9k(), this.getAutoCorrectOrDefault(), this.getKeyboardTypeOrDefault-PjHm6EE(), this.getImeActionOrDefault-eUduSuo$foundation(), this.platformImeOptions, this.getHintLocalesOrDefault(), null);
    }

    public static ImeOptions toImeOptions$foundation$default(KeyboardOptions arg0, boolean arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ImeOptions.Companion.getDefault().getSingleLine();
        }

        return arg0.toImeOptions$foundation(arg1);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.toString-impl(this.capitalization) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + KeyboardType.toString-impl(this.keyboardType) + ", imeAction=" + ImeAction.toString-impl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }
}

