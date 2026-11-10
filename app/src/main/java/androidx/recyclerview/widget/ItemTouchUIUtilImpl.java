package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$id;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE;

    static {
        ItemTouchUIUtilImpl.INSTANCE = new ItemTouchUIUtilImpl();
    }

    ItemTouchUIUtilImpl() {
        super();
    }

    public void clearView(View arg2) {
        Object v1 = arg2.getTag(id.item_touch_helper_previous_elevation);
        if((v1 instanceof Float)) {
            ViewCompat.setElevation(arg2, ((Float)v1).floatValue());
        }

        arg2.setTag(id.item_touch_helper_previous_elevation, null);
        arg2.setTranslationX(0f);
        arg2.setTranslationY(0f);
    }

    private static float findMaxElevation(RecyclerView arg5, View arg6) {
        int v0 = arg5.getChildCount();
        float v1 = 0f;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = arg5.getChildAt(v2);
            if(v3 == arg6) {
            }
            else {
                float v3_1 = ViewCompat.getElevation(v3);
                if(v3_1 > v1) {
                    v1 = v3_1;
                }
            }
        }

        return v1;
    }

    public void onDraw(Canvas arg1, RecyclerView arg2, View arg3, float arg4, float arg5, int arg6, boolean arg7) {
        if((arg7) && arg3.getTag(id.item_touch_helper_previous_elevation) == null) {
            Float v0 = Float.valueOf(ViewCompat.getElevation(arg3));
            ViewCompat.setElevation(arg3, ItemTouchUIUtilImpl.findMaxElevation(arg2, arg3) + 1f);
            arg3.setTag(id.item_touch_helper_previous_elevation, v0);
        }

        arg3.setTranslationX(arg4);
        arg3.setTranslationY(arg5);
    }

    public void onDrawOver(Canvas arg1, RecyclerView arg2, View arg3, float arg4, float arg5, int arg6, boolean arg7) {
    }

    public void onSelected(View arg1) {
    }
}

