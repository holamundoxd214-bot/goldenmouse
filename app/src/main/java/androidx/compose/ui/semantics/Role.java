package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/semantics/Role;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Role {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2={"Landroidx/compose/ui/semantics/Role$Companion;", "", "<init>", "()V", "Button", "Landroidx/compose/ui/semantics/Role;", "getButton-o7Vup1c", "()I", "I", "Checkbox", "getCheckbox-o7Vup1c", "Switch", "getSwitch-o7Vup1c", "RadioButton", "getRadioButton-o7Vup1c", "Tab", "getTab-o7Vup1c", "Image", "getImage-o7Vup1c", "DropdownList", "getDropdownList-o7Vup1c", "ValuePicker", "getValuePicker-o7Vup1c", "Carousel", "getCarousel-o7Vup1c", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getButton-o7Vup1c() {
            return Role.Button;
        }

        public final int getCarousel-o7Vup1c() {
            return Role.Carousel;
        }

        public final int getCheckbox-o7Vup1c() {
            return Role.Checkbox;
        }

        public final int getDropdownList-o7Vup1c() {
            return Role.DropdownList;
        }

        public final int getImage-o7Vup1c() {
            return Role.Image;
        }

        public final int getRadioButton-o7Vup1c() {
            return Role.RadioButton;
        }

        public final int getSwitch-o7Vup1c() {
            return Role.Switch;
        }

        public final int getTab-o7Vup1c() {
            return Role.Tab;
        }

        public final int getValuePicker-o7Vup1c() {
            return Role.ValuePicker;
        }
    }

    private static final int Button;
    private static final int Carousel;
    private static final int Checkbox;
    public static final Companion Companion;
    private static final int DropdownList;
    private static final int Image;
    private static final int RadioButton;
    private static final int Switch;
    private static final int Tab;
    private static final int ValuePicker;
    private final int value;

    static {
        Role.Companion = new Companion(null);
        Role.Button = Role.constructor-impl(0);
        Role.Checkbox = Role.constructor-impl(1);
        Role.Switch = Role.constructor-impl(2);
        Role.RadioButton = Role.constructor-impl(3);
        Role.Tab = Role.constructor-impl(4);
        Role.Image = Role.constructor-impl(5);
        Role.DropdownList = Role.constructor-impl(6);
        Role.ValuePicker = Role.constructor-impl(7);
        Role.Carousel = Role.constructor-impl(8);
    }

    private Role(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getButton$cp() {
        return Role.Button;
    }

    public static final int access$getCarousel$cp() {
        return Role.Carousel;
    }

    public static final int access$getCheckbox$cp() {
        return Role.Checkbox;
    }

    public static final int access$getDropdownList$cp() {
        return Role.DropdownList;
    }

    public static final int access$getImage$cp() {
        return Role.Image;
    }

    public static final int access$getRadioButton$cp() {
        return Role.RadioButton;
    }

    public static final int access$getSwitch$cp() {
        return Role.Switch;
    }

    public static final int access$getTab$cp() {
        return Role.Tab;
    }

    public static final int access$getValuePicker$cp() {
        return Role.ValuePicker;
    }

    public static final Role box-impl(int arg1) {
        return new Role(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Role.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof Role)) {
            return 0;
        }

        if(arg2 != ((Role)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Role.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return Role.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(Role.equals-impl0(arg1, Role.Button)) {
            return "Button";
        }

        if(Role.equals-impl0(arg1, Role.Checkbox)) {
            return "Checkbox";
        }

        if(Role.equals-impl0(arg1, Role.Switch)) {
            return "Switch";
        }

        if(Role.equals-impl0(arg1, Role.RadioButton)) {
            return "RadioButton";
        }

        if(Role.equals-impl0(arg1, Role.Tab)) {
            return "Tab";
        }

        if(Role.equals-impl0(arg1, Role.Image)) {
            return "Image";
        }

        if(Role.equals-impl0(arg1, Role.DropdownList)) {
            return "DropdownList";
        }

        if(Role.equals-impl0(arg1, Role.ValuePicker)) {
            return "Picker";
        }

        if(Role.equals-impl0(arg1, Role.Carousel)) {
            return "Carousel";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

