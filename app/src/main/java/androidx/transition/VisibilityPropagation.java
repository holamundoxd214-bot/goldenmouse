package androidx.transition;

import android.view.View;

public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String[] VISIBILITY_PROPAGATION_VALUES;

    static {
        VisibilityPropagation.VISIBILITY_PROPAGATION_VALUES = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};
    }

    public VisibilityPropagation() {
        super();
    }

    public void captureValues(TransitionValues arg6) {
        Integer v0_1;
        View v5 = arg6.view;
        Object v0 = arg6.values.get("android:visibility:visibility");
        if(v0 == null) {
            v0_1 = Integer.valueOf(v5.getVisibility());
        }

        arg6.values.put("android:visibilityPropagation:visibility", v0_1);
        int[] v1 = new int[2];
        v5.getLocationOnScreen(v1);
        int v3 = v1[0] + Math.round(v5.getTranslationX());
        v1[0] = v3;
        v1[0] = v3 + v5.getWidth() / 2;
        v3 = v1[1] + Math.round(v5.getTranslationY());
        v1[1] = v3;
        v1[1] = v3 + v5.getHeight() / 2;
        arg6.values.put("android:visibilityPropagation:center", v1);
    }

    public String[] getPropagationProperties() {
        return VisibilityPropagation.VISIBILITY_PROPAGATION_VALUES;
    }

    private static int getViewCoordinate(TransitionValues arg2, int arg3) {
        int v0 = -1;
        if(arg2 == null) {
            return v0;
        }

        Object v2 = arg2.values.get("android:visibilityPropagation:center");
        if(v2 == null) {
            return v0;
        }

        return v2[arg3];
    }

    public int getViewVisibility(TransitionValues arg2) {
        int v1 = 8;
        if(arg2 == null) {
            return v1;
        }

        Object v2 = arg2.values.get("android:visibilityPropagation:visibility");
        if(v2 == null) {
            return v1;
        }

        return ((Integer)v2).intValue();
    }

    public int getViewX(TransitionValues arg1) {
        return VisibilityPropagation.getViewCoordinate(arg1, 0);
    }

    public int getViewY(TransitionValues arg1) {
        return VisibilityPropagation.getViewCoordinate(arg1, 1);
    }
}

