package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface MenuProvider {
    void onCreateMenu(Menu arg1, MenuInflater arg2);

    default void onMenuClosed(Menu arg1) {
    }

    boolean onMenuItemSelected(MenuItem arg1);

    default void onPrepareMenu(Menu arg1) {
    }
}

