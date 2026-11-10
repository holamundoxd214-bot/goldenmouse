package androidx.appcompat.view.menu;

import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.app.AlertDialog;

class MenuDialogHelper implements DialogInterface$OnClickListener, DialogInterface$OnDismissListener, DialogInterface$OnKeyListener, Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder arg1) {
        super();
        this.mMenu = arg1;
    }

    public void dismiss() {
        AlertDialog v0 = this.mDialog;
        if(v0 != null) {
            v0.dismiss();
        }
    }

    public void onClick(DialogInterface arg1, int arg2) {
        this.mMenu.performItemAction(this.mPresenter.getAdapter().getItem(arg2), 0);
    }

    public void onCloseMenu(MenuBuilder arg2, boolean arg3) {
        if((arg3) || arg2 == this.mMenu) {
            this.dismiss();
        }

        Callback v1 = this.mPresenterCallback;
        if(v1 != null) {
            v1.onCloseMenu(arg2, arg3);
        }
    }

    public void onDismiss(DialogInterface arg2) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    public boolean onKey(DialogInterface arg3, int arg4, KeyEvent arg5) {
        if(arg4 == 82 || arg4 == 4) {
            if(arg5.getAction() == 0 && arg5.getRepeatCount() == 0) {
                Window v3 = this.mDialog.getWindow();
                if(v3 != null) {
                    View v3_1 = v3.getDecorView();
                    if(v3_1 != null) {
                        KeyEvent$DispatcherState v3_2 = v3_1.getKeyDispatcherState();
                        if(v3_2 != null) {
                            v3_2.startTracking(arg5, this);
                            return 1;
                        }
                        else {
                            goto label_35;
                        }
                    }
                    else {
                        goto label_35;
                    }
                }
                else {
                    goto label_35;
                }
            }

            if(arg5.getAction() != 1) {
                goto label_35;
            }

            if(arg5.isCanceled()) {
                goto label_35;
            }

            Window v0 = this.mDialog.getWindow();
            if(v0 == null) {
                goto label_35;
            }

            View v0_1 = v0.getDecorView();
            if(v0_1 == null) {
                goto label_35;
            }

            KeyEvent$DispatcherState v0_2 = v0_1.getKeyDispatcherState();
            if(v0_2 == null) {
                goto label_35;
            }

            if(!v0_2.isTracking(arg5)) {
                goto label_35;
            }

            this.mMenu.close(true);
            arg3.dismiss();
            return 1;
        }

    label_35:
        return this.mMenu.performShortcut(arg4, arg5, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder arg1) {
        Callback v0 = this.mPresenterCallback;
        if(v0 != null) {
            return v0.onOpenSubMenu(arg1);
        }

        return 0;
    }

    public void setPresenterCallback(Callback arg1) {
        this.mPresenterCallback = arg1;
    }

    public void show(IBinder arg6) {
        MenuBuilder v0 = this.mMenu;
        Builder v1 = new Builder(v0.getContext());
        ListMenuPresenter v2 = new ListMenuPresenter(v1.getContext(), layout.abc_list_menu_item_layout);
        this.mPresenter = v2;
        v2.setCallback(((Callback)this));
        this.mMenu.addMenuPresenter(this.mPresenter);
        v1.setAdapter(this.mPresenter.getAdapter(), ((DialogInterface$OnClickListener)this));
        View v2_1 = v0.getHeaderView();
        if(v2_1 != null) {
            v1.setCustomTitle(v2_1);
        }
        else {
            v1.setIcon(v0.getHeaderIcon()).setTitle(v0.getHeaderTitle());
        }

        v1.setOnKeyListener(((DialogInterface$OnKeyListener)this));
        AlertDialog v0_1 = v1.create();
        this.mDialog = v0_1;
        v0_1.setOnDismissListener(((DialogInterface$OnDismissListener)this));
        WindowManager$LayoutParams v0_2 = this.mDialog.getWindow().getAttributes();
        v0_2.type = 1003;
        if(arg6 != null) {
            v0_2.token = arg6;
        }

        v0_2.flags |= 0x20000;
        this.mDialog.show();
    }
}

