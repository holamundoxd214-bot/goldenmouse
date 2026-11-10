package androidx.constraintlayout.solver;

public class Cache {
    Pool arrayRowPool;
    SolverVariable[] mIndexedVariables;
    Pool optimizedArrayRowPool;
    Pool solverVariablePool;

    public Cache() {
        super();
        this.optimizedArrayRowPool = new SimplePool(0x100);
        this.arrayRowPool = new SimplePool(0x100);
        this.solverVariablePool = new SimplePool(0x100);
        this.mIndexedVariables = new SolverVariable[0x20];
    }
}

