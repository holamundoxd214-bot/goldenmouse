package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B}\u0012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"2\b\u0010#\u001A\u0004\u0018\u00010$J\u001A\u0010%\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"2\b\u0010#\u001A\u0004\u0018\u00010$J\u001A\u0010&\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"2\b\u0010\'\u001A\u0004\u0018\u00010(J\u0006\u0010)\u001A\u00020\u0004J\u0015\u0010*\u001A\u00020\u00042\u0006\u0010#\u001A\u00020$H\u0001¢\u0006\u0002\b+J\u001D\u0010,\u001A\u00020\u00042\u0006\u0010#\u001A\u00020$2\u0006\u0010\'\u001A\u00020-H\u0000¢\u0006\u0002\b.J(\u0010/\u001A\u00020\u00042\u0006\u0010#\u001A\u00020$2\u0006\u0010\'\u001A\u00020-2\u000E\u00100\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002R\u0019\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u000F\"\u0004\b\u0018\u0010\u0016R\"\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u000F\"\u0004\b\u001A\u0010\u0016R\"\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u000F\"\u0004\b\u001C\u0010\u0016R\"\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u000F\"\u0004\b\u001E\u0010\u0016¨\u00061"}, d2={"Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "", "onActionModeDestroy", "Lkotlin/Function0;", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnActionModeDestroy", "()Lkotlin/jvm/functions/Function0;", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "setRect", "(Landroidx/compose/ui/geometry/Rect;)V", "getOnCopyRequested", "setOnCopyRequested", "(Lkotlin/jvm/functions/Function0;)V", "getOnPasteRequested", "setOnPasteRequested", "getOnCutRequested", "setOnCutRequested", "getOnSelectAllRequested", "setOnSelectAllRequested", "getOnAutofillRequested", "setOnAutofillRequested", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "updateMenuItems", "updateMenuItems$ui", "addMenuItem", "Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "addMenuItem$ui", "addOrRemoveMenuItem", "callback", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextActionModeCallback {
    public static final int $stable = 8;
    private final Function0 onActionModeDestroy;
    private Function0 onAutofillRequested;
    private Function0 onCopyRequested;
    private Function0 onCutRequested;
    private Function0 onPasteRequested;
    private Function0 onSelectAllRequested;
    private Rect rect;

    static {
    }

    public TextActionModeCallback(Function0 arg2, Rect arg3, Function0 arg4, Function0 arg5, Function0 arg6, Function0 arg7, Function0 arg8, int arg9, DefaultConstructorMarker arg10) {
        Function0 v0 = null;
        if((arg9 & 1) != 0) {
            arg2 = v0;
        }

        if((arg9 & 2) != 0) {
            arg3 = Rect.Companion.getZero();
        }

        if((arg9 & 4) != 0) {
            arg4 = v0;
        }

        if((arg9 & 8) != 0) {
            arg5 = v0;
        }

        if((arg9 & 16) != 0) {
            arg6 = v0;
        }

        if((arg9 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg9 & 0x40) != 0) {
            arg8 = v0;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public TextActionModeCallback() {
        this(null, null, null, null, null, null, null, 0x7F, null);
    }

    public TextActionModeCallback(Function0 arg1, Rect arg2, Function0 arg3, Function0 arg4, Function0 arg5, Function0 arg6, Function0 arg7) {
        super();
        this.onActionModeDestroy = arg1;
        this.rect = arg2;
        this.onCopyRequested = arg3;
        this.onPasteRequested = arg4;
        this.onCutRequested = arg5;
        this.onSelectAllRequested = arg6;
        this.onAutofillRequested = arg7;
    }

    public final void addMenuItem$ui(Menu arg3, MenuItemOption arg4) {
        arg3.add(0, arg4.getId(), arg4.getOrder(), arg4.getTitleResource()).setShowAsAction(1);
    }

    private final void addOrRemoveMenuItem(Menu arg2, MenuItemOption arg3, Function0 arg4) {
        if(arg4 != null && arg2.findItem(arg3.getId()) == null) {
            this.addMenuItem$ui(arg2, arg3);
            return;
        }

        if(arg4 == null && arg2.findItem(arg3.getId()) != null) {
            arg2.removeItem(arg3.getId());
        }
    }

    public final Function0 getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    public final Function0 getOnAutofillRequested() {
        return this.onAutofillRequested;
    }

    public final Function0 getOnCopyRequested() {
        return this.onCopyRequested;
    }

    public final Function0 getOnCutRequested() {
        return this.onCutRequested;
    }

    public final Function0 getOnPasteRequested() {
        return this.onPasteRequested;
    }

    public final Function0 getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final boolean onActionItemClicked(ActionMode arg2, MenuItem arg3) {
        Function0 v1;
        Intrinsics.checkNotNull(arg3);
        int v3 = arg3.getItemId();
        if(v3 == MenuItemOption.Copy.getId()) {
            v1 = this.onCopyRequested;
            if(v1 != null) {
                v1.invoke();
            }
        }
        else if(v3 == MenuItemOption.Paste.getId()) {
            v1 = this.onPasteRequested;
            if(v1 != null) {
                v1.invoke();
            }
        }
        else if(v3 == MenuItemOption.Cut.getId()) {
            v1 = this.onCutRequested;
            if(v1 != null) {
                v1.invoke();
            }
        }
        else if(v3 == MenuItemOption.SelectAll.getId()) {
            v1 = this.onSelectAllRequested;
            if(v1 != null) {
                v1.invoke();
            }
        }
        else if(v3 == MenuItemOption.Autofill.getId()) {
            v1 = this.onAutofillRequested;
            if(v1 != null) {
                v1.invoke();
            }
        }
        else {
            return 0;
        }

        if(arg2 != null) {
            arg2.finish();
        }

        return 1;
    }

    public final boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
        if(arg2 != null) {
            if(arg1 != null) {
                if(this.onCopyRequested != null) {
                    this.addMenuItem$ui(arg2, MenuItemOption.Copy);
                }

                if(this.onPasteRequested != null) {
                    this.addMenuItem$ui(arg2, MenuItemOption.Paste);
                }

                if(this.onCutRequested != null) {
                    this.addMenuItem$ui(arg2, MenuItemOption.Cut);
                }

                if(this.onSelectAllRequested != null) {
                    this.addMenuItem$ui(arg2, MenuItemOption.SelectAll);
                }

                if(this.onAutofillRequested != null) {
                    this.addMenuItem$ui(arg2, MenuItemOption.Autofill);
                }

                return 1;
            }

            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode".toString());
        }

        throw new IllegalArgumentException("onCreateActionMode requires a non-null menu".toString());
    }

    public final void onDestroyActionMode() {
        Function0 v0 = this.onActionModeDestroy;
        if(v0 != null) {
            v0.invoke();
        }
    }

    public final boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else {
                this.updateMenuItems$ui(arg2);
                return 1;
            }
        }

        return 0;
    }

    public final void setOnAutofillRequested(Function0 arg1) {
        this.onAutofillRequested = arg1;
    }

    public final void setOnCopyRequested(Function0 arg1) {
        this.onCopyRequested = arg1;
    }

    public final void setOnCutRequested(Function0 arg1) {
        this.onCutRequested = arg1;
    }

    public final void setOnPasteRequested(Function0 arg1) {
        this.onPasteRequested = arg1;
    }

    public final void setOnSelectAllRequested(Function0 arg1) {
        this.onSelectAllRequested = arg1;
    }

    public final void setRect(Rect arg1) {
        this.rect = arg1;
    }

    public final void updateMenuItems$ui(Menu arg3) {
        this.addOrRemoveMenuItem(arg3, MenuItemOption.Copy, this.onCopyRequested);
        this.addOrRemoveMenuItem(arg3, MenuItemOption.Paste, this.onPasteRequested);
        this.addOrRemoveMenuItem(arg3, MenuItemOption.Cut, this.onCutRequested);
        this.addOrRemoveMenuItem(arg3, MenuItemOption.SelectAll, this.onSelectAllRequested);
        this.addOrRemoveMenuItem(arg3, MenuItemOption.Autofill, this.onAutofillRequested);
    }
}

