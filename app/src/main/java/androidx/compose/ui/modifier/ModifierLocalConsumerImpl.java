package androidx.compose.ui.modifier;

import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0005H\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0016"}, d2={"Landroidx/compose/ui/modifier/ModifierLocalConsumerImpl;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "debugInspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getConsumer", "()Lkotlin/jvm/functions/Function1;", "onModifierLocalsUpdated", "scope", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ModifierLocalConsumerImpl extends InspectorValueInfo implements ModifierLocalConsumer {
    private final Function1 consumer;

    public ModifierLocalConsumerImpl(Function1 arg1, Function1 arg2) {
        super(arg2);
        this.consumer = arg1;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof ModifierLocalConsumerImpl)) && ((ModifierLocalConsumerImpl)arg2).consumer == this.consumer) {
            return 1;
        }

        return 0;
    }

    public final Function1 getConsumer() {
        return this.consumer;
    }

    public int hashCode() {
        return this.consumer.hashCode();
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope arg1) {
        this.consumer.invoke(arg1);
    }
}

