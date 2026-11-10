package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State$Direction;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

public class BarrierReference extends HelperReference {
    class androidx.constraintlayout.solver.state.helpers.BarrierReference$1 {
        static {
            int[] v0 = new int[Direction.values().length];
            androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction = v0;
            try {
                v0[Direction.LEFT.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[Direction.START.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[Direction.RIGHT.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[Direction.END.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[Direction.TOP.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[Direction.BOTTOM.ordinal()] = 6;
                                    return;
                                }
                                catch(NoSuchFieldError ) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private Barrier mBarrierWidget;
    private Direction mDirection;
    private int mMargin;

    public BarrierReference(State arg2) {
        super(arg2, Helper.BARRIER);
    }

    public void apply() {
        this.getHelperWidget();
        int v1 = 0;
        switch(androidx.constraintlayout.solver.state.helpers.BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()]) {
            case 3: 
            case 4: {
                v1 = 1;
                break;
            }
            case 5: {
                v1 = 2;
                break;
            }
            case 6: {
                v1 = 3;
                break;
            }
            default: {
                break;
            }
        }

        this.mBarrierWidget.setBarrierType(v1);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    public HelperWidget getHelperWidget() {
        Barrier v0 = this.mBarrierWidget;
        if(v0 == null) {
            v0 = new Barrier();
            this.mBarrierWidget = v0;
        }

        return ((HelperWidget)v0);
    }

    public void margin(int arg1) {
        this.mMargin = arg1;
    }

    public void margin(Object arg2) {
        this.margin(this.mState.convertDimension(arg2));
    }

    public void setBarrierDirection(Direction arg1) {
        this.mDirection = arg1;
    }
}

