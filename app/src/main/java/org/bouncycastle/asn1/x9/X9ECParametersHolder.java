package org.bouncycastle.asn1.x9;

import org.bouncycastle.math.ec.ECCurve;

public abstract class X9ECParametersHolder {
    private ECCurve curve;
    private X9ECParameters params;

    public X9ECParametersHolder() {
        super();
    }

    protected ECCurve createCurve() {
        return this.createParameters().getCurve();
    }

    protected abstract X9ECParameters createParameters();

    public ECCurve getCurve() {
        ECCurve v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.curve;
            if(v0_1 == null) {
                v0_1 = this.createCurve();
                this.curve = v0_1;
            }
        }
        catch(Throwable v0) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_8;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public X9ECParameters getParameters() {
        X9ECParameters v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.params;
            if(v0_1 == null) {
                v0_1 = this.createParameters();
                this.params = v0_1;
            }
        }
        catch(Throwable v0) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_8;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }
}

