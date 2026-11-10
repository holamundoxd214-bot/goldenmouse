package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

public abstract class FragmentTransitionImpl {
    public FragmentTransitionImpl() {
        super();
    }

    public abstract void addTarget(Object arg1, View arg2);

    public abstract void addTargets(Object arg1, ArrayList arg2);

    public abstract void beginDelayedTransition(ViewGroup arg1, Object arg2);

    protected static void bfsAddViewChildren(List arg6, View arg7) {
        int v0 = arg6.size();
        if(FragmentTransitionImpl.containedBeforeIndex(arg6, arg7, v0)) {
        }
        else {
            if(ViewCompat.getTransitionName(arg7) != null) {
                arg6.add(arg7);
            }

            int v7;
            for(v7 = v0; v7 < arg6.size(); ++v7) {
                Object v1 = arg6.get(v7);
                if((v1 instanceof ViewGroup)) {
                    int v2 = ((ViewGroup)v1).getChildCount();
                    int v3;
                    for(v3 = 0; v3 < v2; ++v3) {
                        View v4 = ((ViewGroup)v1).getChildAt(v3);
                        if(!FragmentTransitionImpl.containedBeforeIndex(arg6, v4, v0) && ViewCompat.getTransitionName(v4) != null) {
                            arg6.add(v4);
                        }
                    }
                }
            }
        }
    }

    public abstract boolean canHandle(Object arg1);

    void captureTransitioningViews(ArrayList arg4, View arg5) {
        if(arg5.getVisibility() == 0) {
            if(!(arg5 instanceof ViewGroup)) {
                arg4.add(arg5);
            }
            else if(ViewGroupCompat.isTransitionGroup(((ViewGroup)arg5))) {
                arg4.add(arg5);
                return;
            }
            else {
                int v0 = ((ViewGroup)arg5).getChildCount();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    this.captureTransitioningViews(arg4, ((ViewGroup)arg5).getChildAt(v1));
                }
            }
        }
    }

    public abstract Object cloneTransition(Object arg1);

    private static boolean containedBeforeIndex(List arg3, View arg4, int arg5) {
        int v1;
        for(v1 = 0; v1 < arg5; ++v1) {
            if(arg3.get(v1) == arg4) {
                return 1;
            }
        }

        return 0;
    }

    static String findKeyForValue(Map arg2, String arg3) {
        Object v0;
        Iterator v2 = arg2.entrySet().iterator();
        do {
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
        }
        while(!arg3.equals(((Map$Entry)v0).getValue()));

        return ((Map$Entry)v0).getKey();
    }

    void findNamedViews(Map arg4, View arg5) {
        if(arg5.getVisibility() == 0) {
            String v0 = ViewCompat.getTransitionName(arg5);
            if(v0 != null) {
                arg4.put(v0, arg5);
            }

            if(!(arg5 instanceof ViewGroup)) {
                return;
            }

            int v0_1 = ((ViewGroup)arg5).getChildCount();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.findNamedViews(arg4, ((ViewGroup)arg5).getChildAt(v1));
            }
        }
    }

    protected void getBoundsOnScreen(View arg4, Rect arg5) {
        if(!ViewCompat.isAttachedToWindow(arg4)) {
            return;
        }

        RectF v3 = new RectF();
        v3.set(0f, 0f, ((float)arg4.getWidth()), ((float)arg4.getHeight()));
        arg4.getMatrix().mapRect(v3);
        v3.offset(((float)arg4.getLeft()), ((float)arg4.getTop()));
        ViewParent v0;
        for(v0 = arg4.getParent(); (v0 instanceof View); v0 = ((View)v0).getParent()) {
            v3.offset(((float)(-((View)v0).getScrollX())), ((float)(-((View)v0).getScrollY())));
            ((View)v0).getMatrix().mapRect(v3);
            v3.offset(((float)((View)v0).getLeft()), ((float)((View)v0).getTop()));
        }

        int[] v0_1 = new int[2];
        arg4.getRootView().getLocationOnScreen(v0_1);
        v3.offset(((float)v0_1[0]), ((float)v0_1[1]));
        arg5.set(Math.round(v3.left), Math.round(v3.top), Math.round(v3.right), Math.round(v3.bottom));
    }

    protected static boolean isNullOrEmpty(List arg0) {
        if(arg0 != null) {
            if(arg0.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public abstract Object mergeTransitionsInSequence(Object arg1, Object arg2, Object arg3);

    public abstract Object mergeTransitionsTogether(Object arg1, Object arg2, Object arg3);

    ArrayList prepareSetNameOverridesReordered(ArrayList arg5) {
        ArrayList v4 = new ArrayList();
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg5.get(v1);
            v4.add(ViewCompat.getTransitionName(((View)v2)));
            ViewCompat.setTransitionName(((View)v2), null);
        }

        return v4;
    }

    public abstract void removeTarget(Object arg1, View arg2);

    public abstract void replaceTargets(Object arg1, ArrayList arg2, ArrayList arg3);

    public abstract void scheduleHideFragmentView(Object arg1, View arg2, ArrayList arg3);

    void scheduleNameReset(ViewGroup arg2, ArrayList arg3, Map arg4) {
        OneShotPreDrawListener.add(((View)arg2), new Runnable(arg3, arg4) {
            public void run() {
                int v0 = this.val$sharedElementsIn.size();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    Object v2 = this.val$sharedElementsIn.get(v1);
                    ViewCompat.setTransitionName(((View)v2), this.val$nameOverrides.get(ViewCompat.getTransitionName(((View)v2))));
                }
            }
        });
    }

    public abstract void scheduleRemoveTargets(Object arg1, Object arg2, ArrayList arg3, Object arg4, ArrayList arg5, Object arg6, ArrayList arg7);

    public abstract void setEpicenter(Object arg1, View arg2);

    public abstract void setEpicenter(Object arg1, Rect arg2);

    public void setListenerForTransitionEnd(Fragment arg1, Object arg2, CancellationSignal arg3, Runnable arg4) {
        arg4.run();
    }

    void setNameOverridesOrdered(View arg2, ArrayList arg3, Map arg4) {
        OneShotPreDrawListener.add(arg2, new Runnable(arg3, arg4) {
            public void run() {
                int v0 = this.val$sharedElementsIn.size();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    Object v2 = this.val$sharedElementsIn.get(v1);
                    String v3 = ViewCompat.getTransitionName(((View)v2));
                    if(v3 != null) {
                        ViewCompat.setTransitionName(((View)v2), FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, v3));
                    }
                }
            }
        });
    }

    void setNameOverridesReordered(View arg9, ArrayList arg10, ArrayList arg11, ArrayList arg12, Map arg13) {
        int v2 = arg11.size();
        ArrayList v6 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < v2; ++v1) {
            Object v3 = arg10.get(v1);
            String v4 = ViewCompat.getTransitionName(((View)v3));
            v6.add(v4);
            if(v4 == null) {
            }
            else {
                ViewCompat.setTransitionName(((View)v3), null);
                v3 = arg13.get(v4);
                int v5 = 0;
                while(v5 < v2) {
                    if(((String)v3).equals(arg12.get(v5))) {
                        ViewCompat.setTransitionName(arg11.get(v5), v4);
                    }
                    else {
                        ++v5;
                        continue;
                    }

                    break;
                }
            }
        }

        OneShotPreDrawListener.add(arg9, new Runnable(v2, arg11, arg12, arg10, v6) {
            public void run() {
                int v0;
                for(v0 = 0; v0 < this.val$numSharedElements; ++v0) {
                    ViewCompat.setTransitionName(this.val$sharedElementsIn.get(v0), this.val$inNames.get(v0));
                    ViewCompat.setTransitionName(this.val$sharedElementsOut.get(v0), this.val$outNames.get(v0));
                }
            }
        });
    }

    public abstract void setSharedElementTargets(Object arg1, View arg2, ArrayList arg3);

    public abstract void swapSharedElementTargets(Object arg1, ArrayList arg2, ArrayList arg3);

    public abstract Object wrapTransitionInSet(Object arg1);
}

