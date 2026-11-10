package androidx.compose.ui.graphics.colorspace;

public final class Rgb$Companion$$ExternalSyntheticLambda1 implements DoubleFunction {
    public Rgb$Companion$$ExternalSyntheticLambda1(TransferParameters arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return Companion.generateEotf$lambda$1(this.f$0, arg1);
    }
}

