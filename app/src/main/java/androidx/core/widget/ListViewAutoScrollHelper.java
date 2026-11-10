package androidx.core.widget;

import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(ListView arg1) {
        super(((View)arg1));
        this.mTarget = arg1;
    }

    public boolean canTargetScrollHorizontally(int arg1) {
        return 0;
    }

    public boolean canTargetScrollVertically(int arg7) {
        ListView v6 = this.mTarget;
        int v0 = v6.getCount();
        if(v0 == 0) {
            return 0;
        }

        int v2 = v6.getChildCount();
        int v3 = v6.getFirstVisiblePosition();
        int v4 = v3 + v2;
        if(arg7 > 0) {
            if(v4 >= v0 && v6.getChildAt(v2 - 1).getBottom() <= v6.getHeight()) {
                return 0;
            }
        }
        else if(arg7 >= 0) {
            return 0;
        }
        else if(v3 <= 0 && v6.getChildAt(0).getTop() >= 0) {
            return 0;
        }

        return 1;
    }

    public void scrollTargetBy(int arg1, int arg2) {
        this.mTarget.scrollListBy(arg2);
    }
}

