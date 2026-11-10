package androidx.transition;

import android.os.Build$VERSION;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TransitionManager {
    class MultiListener implements View$OnAttachStateChangeListener, ViewTreeObserver$OnPreDrawListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        MultiListener(Transition arg1, ViewGroup arg2) {
            super();
            this.mTransition = arg1;
            this.mSceneRoot = arg2;
        }

        public boolean onPreDraw() {
            this.removeListeners();
            if(!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                return 1;
            }

            ArrayMap v0 = TransitionManager.getRunningTransitions();
            Object v2 = v0.get(this.mSceneRoot);
            ArrayList v3 = null;
            if(v2 == null) {
                ArrayList v2_1 = new ArrayList();
                v0.put(this.mSceneRoot, v2_1);
            }
            else if(((ArrayList)v2).size() > 0) {
                v3 = new ArrayList(((Collection)v2));
            }

            ((ArrayList)v2).add(this.mTransition);
            this.mTransition.addListener(new TransitionListenerAdapter(v0) {
                public void onTransitionEnd(Transition arg3) {
                    this.val$runningTransitions.get(MultiListener.this.mSceneRoot).remove(arg3);
                    arg3.removeListener(((TransitionListener)this));
                }
            });
            this.mTransition.captureValues(this.mSceneRoot, false);
            if(v3 != null) {
                Iterator v0_1 = v3.iterator();
                while(v0_1.hasNext()) {
                    v0_1.next().resume(this.mSceneRoot);
                }
            }

            this.mTransition.playTransition(this.mSceneRoot);
            return 1;
        }

        public void onViewAttachedToWindow(View arg1) {
        }

        public void onViewDetachedFromWindow(View arg3) {
            this.removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            Object v3 = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if(v3 != null && ((ArrayList)v3).size() > 0) {
                Iterator v3_1 = ((ArrayList)v3).iterator();
                while(v3_1.hasNext()) {
                    v3_1.next().resume(this.mSceneRoot);
                }
            }

            this.mTransition.clearValues(true);
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
            this.mSceneRoot.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        }
    }

    private static final String LOG_TAG = "TransitionManager";
    private ArrayMap mScenePairTransitions;
    private ArrayMap mSceneTransitions;
    private static Transition sDefaultTransition;
    static ArrayList sPendingTransitions;
    private static ThreadLocal sRunningTransitions;

    static {
        TransitionManager.sDefaultTransition = new AutoTransition();
        TransitionManager.sRunningTransitions = new ThreadLocal();
        TransitionManager.sPendingTransitions = new ArrayList();
    }

    public TransitionManager() {
        super();
        this.mSceneTransitions = new ArrayMap();
        this.mScenePairTransitions = new ArrayMap();
    }

    public static void beginDelayedTransition(ViewGroup arg1, Transition arg2) {
        if(!TransitionManager.sPendingTransitions.contains(arg1) && (arg1.isLaidOut())) {
            TransitionManager.sPendingTransitions.add(arg1);
            if(arg2 == null) {
                arg2 = TransitionManager.sDefaultTransition;
            }

            arg2 = arg2.clone();
            TransitionManager.sceneChangeSetup(arg1, arg2);
            Scene.setCurrentScene(arg1, null);
            TransitionManager.sceneChangeRunTransition(arg1, arg2);
        }
    }

    public static void beginDelayedTransition(ViewGroup arg1) {
        TransitionManager.beginDelayedTransition(arg1, null);
    }

    private static void changeScene(Scene arg3, Transition arg4) {
        ViewGroup v0 = arg3.getSceneRoot();
        if(!TransitionManager.sPendingTransitions.contains(v0)) {
            Scene v1 = Scene.getCurrentScene(v0);
            if(arg4 == null) {
                if(v1 != null) {
                    v1.exit();
                }

                arg3.enter();
                return;
            }
            else {
                TransitionManager.sPendingTransitions.add(v0);
                arg4 = arg4.clone();
                if(v1 != null && (v1.isCreatedFromLayoutResource())) {
                    arg4.setCanRemoveViews(true);
                }

                TransitionManager.sceneChangeSetup(v0, arg4);
                arg3.enter();
                TransitionManager.sceneChangeRunTransition(v0, arg4);
            }
        }
    }

    public static TransitionSeekController controlDelayedTransition(ViewGroup arg3, Transition arg4) {
        Scene v1 = null;
        if(!TransitionManager.sPendingTransitions.contains(arg3) && (arg3.isLaidOut())) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else if(arg4.isSeekingSupported()) {
                TransitionManager.sPendingTransitions.add(arg3);
                arg4 = arg4.clone();
                TransitionSet v0 = new TransitionSet();
                v0.addTransition(arg4);
                TransitionManager.sceneChangeSetup(arg3, ((Transition)v0));
                Scene.setCurrentScene(arg3, v1);
                TransitionManager.sceneChangeRunTransition(arg3, ((Transition)v0));
                arg3.invalidate();
                return v0.createSeekController();
            }
            else {
                throw new IllegalArgumentException("The Transition must support seeking.");
            }
        }

        return ((TransitionSeekController)v1);
    }

    public static TransitionSeekController createSeekController(Scene arg5, Transition arg6) {
        ViewGroup v0 = arg5.getSceneRoot();
        if(arg6.isSeekingSupported()) {
            TransitionSeekController v2 = null;
            if(TransitionManager.sPendingTransitions.contains(v0)) {
                return v2;
            }

            Scene v1 = Scene.getCurrentScene(v0);
            if(v0.isLaidOut()) {
                if(Build$VERSION.SDK_INT < 34) {
                }
                else {
                    TransitionManager.sPendingTransitions.add(v0);
                    arg6 = arg6.clone();
                    TransitionSet v2_1 = new TransitionSet();
                    v2_1.addTransition(arg6);
                    if(v1 != null && (v1.isCreatedFromLayoutResource())) {
                        v2_1.setCanRemoveViews(true);
                    }

                    TransitionManager.sceneChangeSetup(v0, ((Transition)v2_1));
                    arg5.enter();
                    TransitionManager.sceneChangeRunTransition(v0, ((Transition)v2_1));
                    return v2_1.createSeekController();
                }
            }

            if(v1 != null) {
                v1.exit();
            }

            arg5.enter();
            return v2;
        }

        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    public static void endTransitions(ViewGroup arg3) {
        TransitionManager.sPendingTransitions.remove(arg3);
        Object v0 = TransitionManager.getRunningTransitions().get(arg3);
        if(v0 != null && !((ArrayList)v0).isEmpty()) {
            ArrayList v1 = new ArrayList(((Collection)v0));
            int v0_1;
            for(v0_1 = v1.size() - 1; v0_1 >= 0; --v0_1) {
                v1.get(v0_1).forceToEnd(arg3);
            }
        }
    }

    static ArrayMap getRunningTransitions() {
        Object v0 = TransitionManager.sRunningTransitions.get();
        if(v0 != null) {
            v0 = ((WeakReference)v0).get();
            if(v0 != null) {
                return ((ArrayMap)v0);
            }
        }

        ArrayMap v0_1 = new ArrayMap();
        TransitionManager.sRunningTransitions.set(new WeakReference(v0_1));
        return v0_1;
    }

    private Transition getTransition(Scene arg3) {
        Scene v0 = Scene.getCurrentScene(arg3.getSceneRoot());
        if(v0 != null) {
            Object v1 = this.mScenePairTransitions.get(arg3);
            if(v1 != null) {
                Object v0_1 = ((ArrayMap)v1).get(v0);
                if(v0_1 != null) {
                    return ((Transition)v0_1);
                }
            }
        }

        Object v2 = this.mSceneTransitions.get(arg3);
        if(v2 != null) {
            return ((Transition)v2);
        }

        return TransitionManager.sDefaultTransition;
    }

    public static void go(Scene arg1) {
        TransitionManager.changeScene(arg1, TransitionManager.sDefaultTransition);
    }

    public static void go(Scene arg0, Transition arg1) {
        TransitionManager.changeScene(arg0, arg1);
    }

    private static void sceneChangeRunTransition(ViewGroup arg1, Transition arg2) {
        if(arg2 != null && arg1 != null) {
            MultiListener v0 = new MultiListener(arg2, arg1);
            arg1.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)v0));
            arg1.getViewTreeObserver().addOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)v0));
        }
    }

    private static void sceneChangeSetup(ViewGroup arg2, Transition arg3) {
        Object v0 = TransitionManager.getRunningTransitions().get(arg2);
        if(v0 != null && ((ArrayList)v0).size() > 0) {
            Iterator v0_1 = ((ArrayList)v0).iterator();
            while(v0_1.hasNext()) {
                v0_1.next().pause(((View)arg2));
            }
        }

        if(arg3 != null) {
            arg3.captureValues(arg2, true);
        }

        Scene v2 = Scene.getCurrentScene(arg2);
        if(v2 != null) {
            v2.exit();
        }
    }

    public void setTransition(Scene arg1, Transition arg2) {
        this.mSceneTransitions.put(arg1, arg2);
    }

    public void setTransition(Scene arg2, Scene arg3, Transition arg4) {
        ArrayMap v0_1;
        Object v0 = this.mScenePairTransitions.get(arg3);
        if(v0 == null) {
            v0_1 = new ArrayMap();
            this.mScenePairTransitions.put(arg3, v0_1);
        }

        v0_1.put(arg2, arg4);
    }

    public void transitionTo(Scene arg1) {
        TransitionManager.changeScene(arg1, this.getTransition(arg1));
    }
}

