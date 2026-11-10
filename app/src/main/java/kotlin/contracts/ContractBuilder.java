package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001A\u00020\u0003H§\u0080\u0004J\u0014\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001H§\u0080\u0004J\n\u0010\u0005\u001A\u00020\u0006H§\u0080\u0004J(\u0010\u0007\u001A\u00020\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\t0\u000B2\b\b\u0002\u0010\f\u001A\u00020\rH§\u0080\u0004J\u0016\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0004\u001A\u00020\u0006H§\u0084\u0004J\"\u0010\u0011\u001A\u00020\u0012\"\u0004\b\u0000\u0010\t*\u00020\u00102\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\t0\u000BH§\u0084\u0004¨\u0006\u0013"}, d2={"Lkotlin/contracts/ContractBuilder;", "", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "implies", "", "", "holdsIn", "Lkotlin/contracts/HoldsIn;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface ContractBuilder {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static CallsInPlace callsInPlace$default(ContractBuilder arg0, Function arg1, InvocationKind arg2, int arg3, Object arg4) {
            if(arg4 == null) {
                if((arg3 & 2) != 0) {
                    arg2 = InvocationKind.UNKNOWN;
                }

                return arg0.callsInPlace(arg1, arg2);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    CallsInPlace callsInPlace(Function arg1, InvocationKind arg2);

    HoldsIn holdsIn(boolean arg1, Function arg2);

    void implies(boolean arg1, ReturnsNotNull arg2);

    Returns returns();

    Returns returns(Object arg1);

    ReturnsNotNull returnsNotNull();
}

