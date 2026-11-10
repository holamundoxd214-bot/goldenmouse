package com.TryJeanPc.goldenmouse.mapper;

import com.TryJeanPc.goldenmouse.input.InputEvent$Button;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyDown;
import com.TryJeanPc.goldenmouse.input.InputEvent$KeyUp;
import com.TryJeanPc.goldenmouse.input.InputEvent$MouseButton;
import com.TryJeanPc.goldenmouse.input.InputEvent;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u000E\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0015J\u0006\u0010\u0016\u001A\u00020\u0005J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\t\u0010\u001A\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000B¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "source", "Lcom/TryJeanPc/goldenmouse/mapper/InputBindingSource;", "code", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/mapper/InputBindingSource;Ljava/lang/String;)V", "getSource", "()Lcom/TryJeanPc/goldenmouse/mapper/InputBindingSource;", "getCode", "()Ljava/lang/String;", "normalizedCode", "getNormalizedCode", "equals", "", "other", "hashCode", "", "matches", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "displayName", "component1", "component2", "copy", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputBinding {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nJ\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u00052\u0006\u0010\f\u001A\u00020\rJ\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000F\u001A\u00020\u0007J\u0010\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0002¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/InputBinding$Companion;", "", "<init>", "()V", "keyboard", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "keyName", "", "mouse", "button", "Lcom/TryJeanPc/goldenmouse/input/InputEvent$Button;", "fromEvent", "event", "Lcom/TryJeanPc/goldenmouse/input/InputEvent;", "fromDisplayName", "value", "normalize", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final String access$normalize(Companion arg0, String arg1) {
            return arg0.normalize(arg1);
        }

        public final InputBinding fromDisplayName(String arg7) {
            Button v2_1;
            Intrinsics.checkNotNullParameter(arg7, "value");
            arg7 = this.normalize(arg7);
            InputBinding v1 = null;
            if(arg7.length() == 0) {
                return v1;
            }

            String v0 = "MOUSE_";
            String v3 = "BTN_";
            String v2 = StringsKt.removePrefix(StringsKt.removePrefix(arg7, v0), v3);
            switch(v2.hashCode()) {
                case -2021012075: {
                    if(!v2.equals("MIDDLE")) {
                        goto label_55;
                    }

                    v2_1 = Button.MIDDLE;
                    goto label_56;
                }
                case -1849235639: {
                    if(!v2.equals("SIDE_1")) {
                        goto label_55;
                    }

                label_47:
                    v2_1 = Button.SIDE_1;
                    goto label_56;
                }
                case -1849235638: {
                    if(!v2.equals("SIDE_2")) {
                        goto label_55;
                    }

                label_41:
                    v2_1 = Button.SIDE_2;
                    goto label_56;
                }
                case 2332679: {
                    if(v2.equals("LEFT")) {
                        goto label_35;
                    }

                    break;
                }
                case 77974012: {
                    if(!v2.equals("RIGHT")) {
                        goto label_55;
                    }

                    v2_1 = Button.RIGHT;
                    goto label_56;
                }
                case 78894522: {
                    if(v2.equals("SIDE1")) {
                        goto label_47;
                    }

                    break;
                }
                case 78894523: {
                    if(v2.equals("SIDE2")) {
                        goto label_41;
                    }

                    break;
                }
                default: {
                    break;
                }
            }

        label_55:
            v2_1 = ((Button)v1);
            goto label_56;
        label_35:
            v2_1 = Button.LEFT;
        label_56:
            int v5 = 2;
            if(!StringsKt.startsWith$default(arg7, v0, false, v5, v1)) {
                if(StringsKt.startsWith$default(arg7, v3, false, v5, v1)) {
                }
                else {
                    return this.keyboard(arg7);
                }
            }

            if(v2_1 != null) {
                return this.mouse(v2_1);
            }

            return v1;
        }

        public final InputBinding fromEvent(InputEvent arg2) {
            Intrinsics.checkNotNullParameter(arg2, "event");
            if((arg2 instanceof KeyDown)) {
                return this.keyboard(((KeyDown)arg2).getKeyName());
            }

            if((arg2 instanceof MouseButton)) {
                return this.mouse(((MouseButton)arg2).getButton());
            }

            return null;
        }

        public final InputBinding keyboard(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "keyName");
            return new InputBinding(InputBindingSource.KEYBOARD, arg2);
        }

        public final InputBinding mouse(Button arg2) {
            Intrinsics.checkNotNullParameter(arg2, "button");
            return new InputBinding(InputBindingSource.MOUSE, arg2.name());
        }

        private final String normalize(String arg1) {
            String v0 = StringsKt.trim(((CharSequence)arg1)).toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v0, "toUpperCase(...)");
            v0 = StringsKt.removePrefix(StringsKt.removePrefix(v0, "KEYCODE_"), "KEY_");
            if(Intrinsics.areEqual(v0, "SHIFT_LEFT")) {
                return "LEFTSHIFT";
            }

            if(Intrinsics.areEqual(v0, "SHIFT_RIGHT")) {
                v0 = "RIGHTSHIFT";
            }

            return v0;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final String code;
    private final String normalizedCode;
    private final InputBindingSource source;

    static {
        InputBinding.Companion = new Companion(null);
    }

    public InputBinding(InputBindingSource arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "code");
        super();
        this.source = arg2;
        this.code = arg3;
        this.normalizedCode = Companion.access$normalize(InputBinding.Companion, arg3);
    }

    public final InputBindingSource component1() {
        return this.source;
    }

    public final String component2() {
        return this.code;
    }

    public final InputBinding copy(InputBindingSource arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "code");
        return new InputBinding(arg1, arg2);
    }

    public static InputBinding copy$default(InputBinding arg0, InputBindingSource arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.source;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.code;
        }

        return arg0.copy(arg1, arg2);
    }

    public final String displayName() {
        InputBindingSource v0 = this.source;
        InputBindingSource v1 = InputBindingSource.MOUSE;
        String v2 = this.normalizedCode;
        if(v0 == v1) {
            v2 = "MOUSE_" + v2;
        }

        return v2;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof InputBinding)) && this.source == ((InputBinding)arg3).source && (Intrinsics.areEqual(this.normalizedCode, ((InputBinding)arg3).normalizedCode))) {
            return 1;
        }

        return 0;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getNormalizedCode() {
        return this.normalizedCode;
    }

    public final InputBindingSource getSource() {
        return this.source;
    }

    public int hashCode() {
        return this.source.hashCode() * 0x1F + this.normalizedCode.hashCode();
    }

    public final boolean matches(InputEvent arg5) {
        Intrinsics.checkNotNullParameter(arg5, "event");
        if((arg5 instanceof KeyDown)) {
            if(this.source == InputBindingSource.KEYBOARD && (Intrinsics.areEqual(this.normalizedCode, Companion.access$normalize(InputBinding.Companion, ((KeyDown)arg5).getKeyName())))) {
                return 1;
            }

            return 0;
        }

        if((arg5 instanceof KeyUp)) {
            if(this.source == InputBindingSource.KEYBOARD && (Intrinsics.areEqual(this.normalizedCode, Companion.access$normalize(InputBinding.Companion, ((KeyUp)arg5).getKeyName())))) {
                return 1;
            }

            return 0;
        }

        if(((arg5 instanceof MouseButton)) && this.source == InputBindingSource.MOUSE && (Intrinsics.areEqual(this.normalizedCode, ((MouseButton)arg5).getButton().name()))) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "InputBinding(source=" + this.source + ", code=" + this.code + ")";
    }
}

