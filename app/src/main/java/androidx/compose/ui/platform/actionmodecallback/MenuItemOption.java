package androidx.compose.ui.platform.actionmodecallback;

import android.os.Build$VERSION;
import androidx.compose.ui.R$string;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0007R\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\u0011"}, d2={"Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "Copy", "Paste", "Cut", "SelectAll", "Autofill", "titleResource", "getTitleResource", "order", "getOrder", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum MenuItemOption {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[MenuItemOption.values().length];
            try {
                v0[MenuItemOption.Copy.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[MenuItemOption.Paste.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[MenuItemOption.Cut.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[MenuItemOption.SelectAll.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[MenuItemOption.Autofill.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static final enum MenuItemOption Autofill;
    public static final enum MenuItemOption Copy;
    public static final enum MenuItemOption Cut;
    public static final enum MenuItemOption Paste;
    public static final enum MenuItemOption SelectAll;
    private final int id;
    private final int order;

    private static final MenuItemOption[] $values() {
        return new MenuItemOption[]{MenuItemOption.Copy, MenuItemOption.Paste, MenuItemOption.Cut, MenuItemOption.SelectAll, MenuItemOption.Autofill};
    }

    static {
        MenuItemOption.Copy = new MenuItemOption("Copy", 0, 0);
        MenuItemOption.Paste = new MenuItemOption("Paste", 1, 1);
        MenuItemOption.Cut = new MenuItemOption("Cut", 2, 2);
        MenuItemOption.SelectAll = new MenuItemOption("SelectAll", 3, 3);
        MenuItemOption.Autofill = new MenuItemOption("Autofill", 4, 4);
        MenuItemOption[] v0 = MenuItemOption.$values();
        MenuItemOption.$VALUES = v0;
        MenuItemOption.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private MenuItemOption(String arg1, int arg2, int arg3) {
        super(arg1, arg2);
        this.id = arg3;
        this.order = arg3;
    }

    public static EnumEntries getEntries() {
        return MenuItemOption.$ENTRIES;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTitleResource() {
        int v1 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v1 != 1) {
            if(v1 != 2) {
                if(v1 != 3) {
                    if(v1 != 4) {
                        if(v1 == 5) {
                            if(Build$VERSION.SDK_INT <= 26) {
                                return string.androidx_compose_ui_autofill;
                            }

                            return 0x104001A;
                        }

                        throw new NoWhenBranchMatchedException();
                    }

                    return 0x104000D;
                }

                return 0x1040003;
            }

            return 0x104000B;
        }

        return 0x1040001;
    }

    public static MenuItemOption valueOf(String arg1) {
        return Enum.valueOf(MenuItemOption.class, arg1);
    }

    public static MenuItemOption[] values() {
        return MenuItemOption.$VALUES.clone();
    }
}

