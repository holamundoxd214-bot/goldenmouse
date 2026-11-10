package androidx.compose.ui.graphics.colorspace;

public final class Rgb$Companion$$ExternalSyntheticLambda2 implements DoubleFunction {
    public Rgb$Companion$$ExternalSyntheticLambda2(TransferParameters arg1) {
        super();
        this.f$0 = arg1;
    }

    public final double invoke(double arg1) {
        return Companion.generateEotf$lambda$2(this.f$0, arg1);
    }
}

