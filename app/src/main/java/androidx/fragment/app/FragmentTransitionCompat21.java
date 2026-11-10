package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition$EpicenterCallback;
import android.transition.Transition$TransitionListener;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransitionCompat21 extends FragmentTransitionImpl {
    FragmentTransitionCompat21() {
        super();
    }

    public void addTarget(Object arg1, View arg2) {
        if(arg1 != null) {
            ((Transition)arg1).addTarget(arg2);
        }
    }

    public void addTargets(Object arg4, ArrayList arg5) {
        if(arg4 == null) {
        }
        else {
            int v1 = 0;
            if((arg4 instanceof TransitionSet)) {
                int v0 = ((TransitionSet)arg4).getTransitionCount();
                while(v1 < v0) {
                    this.addTargets(((TransitionSet)arg4).getTransitionAt(v1), arg5);
                    ++v1;
                }
            }
            else if(!FragmentTransitionCompat21.hasSimpleTarget(((Transition)arg4)) && (FragmentTransitionCompat21.isNullOrEmpty(((Transition)arg4).getTargets()))) {
                int v3 = arg5.size();
                while(v1 < v3) {
                    ((Transition)arg4).addTarget(arg5.get(v1));
                    ++v1;
                }
            }
        }
    }

    public void beginDelayedTransition(ViewGroup arg1, Object arg2) {
        TransitionManager.beginDelayedTransition(arg1, ((Transition)arg2));
    }

    public boolean canHandle(Object arg1) {
        return arg1 instanceof Transition;
    }

    public Object cloneTransition(Object arg1) {
        if(arg1 != null) {
            return ((Transition)arg1).clone();
        }

        return null;
    }

    private static boolean hasSimpleTarget(Transition arg1) {
        if((FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetIds())) && (FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetNames()))) {
            if(!FragmentTransitionCompat21.isNullOrEmpty(arg1.getTargetTypes())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public Object mergeTransitionsInSequence(Object arg1, Object arg2, Object arg3) {
        if(arg1 != null && arg2 != null) {
            TransitionSet v1 = new TransitionSet().addTransition(((Transition)arg1)).addTransition(((Transition)arg2)).setOrdering(1);
        }
        else if(arg1 != null) {
        }
        else if(arg2 != null) {
            arg1 = arg2;
        }
        else {
            arg1 = null;
        }

        if(arg3 != null) {
            TransitionSet v0 = new TransitionSet();
            if(arg1 != null) {
                v0.addTransition(((Transition)arg1));
            }

            v0.addTransition(((Transition)arg3));
            return v0;
        }

        return arg1;
    }

    public Object mergeTransitionsTogether(Object arg1, Object arg2, Object arg3) {
        TransitionSet v0 = new TransitionSet();
        if(arg1 != null) {
            v0.addTransition(((Transition)arg1));
        }

        if(arg2 != null) {
            v0.addTransition(((Transition)arg2));
        }

        if(arg3 != null) {
            v0.addTransition(((Transition)arg3));
        }

        return v0;
    }

    public void removeTarget(Object arg1, View arg2) {
        if(arg1 != null) {
            ((Transition)arg1).removeTarget(arg2);
        }
    }

    public void replaceTargets(Object arg4, ArrayList arg5, ArrayList arg6) {
        int v1 = 0;
        if((arg4 instanceof TransitionSet)) {
            int v0 = ((TransitionSet)arg4).getTransitionCount();
            while(v1 < v0) {
                this.replaceTargets(((TransitionSet)arg4).getTransitionAt(v1), arg5, arg6);
                ++v1;
            }
        }
        else if(!FragmentTransitionCompat21.hasSimpleTarget(((Transition)arg4))) {
            List v3 = ((Transition)arg4).getTargets();
            if(v3 != null && v3.size() == arg5.size() && (v3.containsAll(((Collection)arg5)))) {
                int v3_1 = arg6 == null ? 0 : arg6.size();
                while(v1 < v3_1) {
                    ((Transition)arg4).addTarget(arg6.get(v1));
                    ++v1;
                }

                for(v3_1 = arg5.size() - 1; v3_1 >= 0; --v3_1) {
                    ((Transition)arg4).removeTarget(arg5.get(v3_1));
                }
            }
        }
    }

    public void scheduleHideFragmentView(Object arg2, View arg3, ArrayList arg4) {
        ((Transition)arg2).addListener(new Transition$TransitionListener(arg3, arg4) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg4) {
                arg4.removeListener(((Transition$TransitionListener)this));
                this.val$fragmentView.setVisibility(8);
                int v4 = this.val$exitingViews.size();
                int v1;
                for(v1 = 0; v1 < v4; ++v1) {
                    this.val$exitingViews.get(v1).setVisibility(0);
                }
            }

            public void onTransitionPause(Transition arg1) {
            }

            public void onTransitionResume(Transition arg1) {
            }

            public void onTransitionStart(Transition arg1) {
                arg1.removeListener(((Transition$TransitionListener)this));
                arg1.addListener(((Transition$TransitionListener)this));
            }
        });
    }

    public void scheduleRemoveTargets(Object arg9, Object arg10, ArrayList arg11, Object arg12, ArrayList arg13, Object arg14, ArrayList arg15) {
        ((Transition)arg9).addListener(new Transition$TransitionListener(arg10, arg11, arg12, arg13, arg14, arg15) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg1) {
                arg1.removeListener(((Transition$TransitionListener)this));
            }

            public void onTransitionPause(Transition arg1) {
            }

            public void onTransitionResume(Transition arg1) {
            }

            public void onTransitionStart(Transition arg4) {
                Object v4 = this.val$enterTransition;
                ArrayList v0 = null;
                if(v4 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(v4, this.val$enteringViews, v0);
                }

                v4 = this.val$exitTransition;
                if(v4 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(v4, this.val$exitingViews, v0);
                }

                v4 = this.val$sharedElementTransition;
                if(v4 != null) {
                    FragmentTransitionCompat21.this.replaceTargets(v4, this.val$sharedElementsIn, v0);
                }
            }
        });
    }

    public void setEpicenter(Object arg2, Rect arg3) {
        if(arg2 != null) {
            ((Transition)arg2).setEpicenterCallback(new Transition$EpicenterCallback(arg3) {
                public Rect onGetEpicenter(Transition arg1) {
                    Rect v1 = this.val$epicenter;
                    if(v1 != null) {
                        if(v1.isEmpty()) {
                        }
                        else {
                            return this.val$epicenter;
                        }
                    }

                    return null;
                }
            });
        }
    }

    public void setEpicenter(Object arg2, View arg3) {
        if(arg3 != null) {
            Rect v0 = new Rect();
            this.getBoundsOnScreen(arg3, v0);
            ((Transition)arg2).setEpicenterCallback(new Transition$EpicenterCallback(v0) {
                public Rect onGetEpicenter(Transition arg1) {
                    return this.val$epicenter;
                }
            });
        }
    }

    public void setListenerForTransitionEnd(Fragment arg1, Object arg2, CancellationSignal arg3, Runnable arg4) {
        ((Transition)arg2).addListener(new Transition$TransitionListener(arg4) {
            public void onTransitionCancel(Transition arg1) {
            }

            public void onTransitionEnd(Transition arg1) {
                this.val$transitionCompleteRunnable.run();
            }

            public void onTransitionPause(Transition arg1) {
            }

            public void onTransitionResume(Transition arg1) {
            }

            public void onTransitionStart(Transition arg1) {
            }
        });
    }

    public void setSharedElementTargets(Object arg5, View arg6, ArrayList arg7) {
        List v0 = ((TransitionSet)arg5).getTargets();
        v0.clear();
        int v1 = arg7.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            FragmentTransitionCompat21.bfsAddViewChildren(v0, arg7.get(v2));
        }

        v0.add(arg6);
        arg7.add(arg6);
        this.addTargets(arg5, arg7);
    }

    public void swapSharedElementTargets(Object arg2, ArrayList arg3, ArrayList arg4) {
        if(arg2 != null) {
            ((TransitionSet)arg2).getTargets().clear();
            ((TransitionSet)arg2).getTargets().addAll(((Collection)arg4));
            this.replaceTargets(arg2, arg3, arg4);
        }
    }

    public Object wrapTransitionInSet(Object arg1) {
        if(arg1 == null) {
            return null;
        }

        TransitionSet v0 = new TransitionSet();
        v0.addTransition(((Transition)arg1));
        return v0;
    }
}

