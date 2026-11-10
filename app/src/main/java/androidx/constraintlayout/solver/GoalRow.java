package androidx.constraintlayout.solver;

public class GoalRow extends ArrayRow {
    public GoalRow(Cache arg1) {
        super(arg1);
    }

    public void addError(SolverVariable arg1) {
        super.addError(arg1);
        --arg1.usageInRowCount;
    }
}

