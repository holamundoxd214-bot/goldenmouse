package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0011\bF\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\n\u001A\u00020\u000BH\u0096\u0080\u0004R\u0015\u0010\u0004\u001A\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\f"}, d2={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "<init>", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class Lambda implements Serializable, FunctionBase {
    private final int arity;

    public Lambda(int arg1) {
        super();
        this.arity = arg1;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String v1 = Reflection.renderLambdaToString(this);
        Intrinsics.checkNotNullExpressionValue(v1, "renderLambdaToString(...)");
        return v1;
    }
}

