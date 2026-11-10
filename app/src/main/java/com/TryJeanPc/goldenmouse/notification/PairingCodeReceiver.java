package com.TryJeanPc.goldenmouse.notification;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/notification/PairingCodeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PairingCodeReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    static {
    }

    public PairingCodeReceiver() {
        super();
    }

    public void onReceive(Context arg9, Intent arg10) {
        String v10_2;
        Intrinsics.checkNotNullParameter(arg9, "context");
        Intrinsics.checkNotNullParameter(arg10, "intent");
        if(Intrinsics.areEqual(arg10.getAction(), "GOLDEN_PAIRING_CODE")) {
            Bundle v10 = RemoteInput.getResultsFromIntent(arg10);
            Continuation v0 = null;
            if(v10 != null) {
                CharSequence v10_1 = v10.getCharSequence("pairing_code");
                if(v10_1 != null) {
                    v10_2 = v10_1.toString();
                }
                else {
                    goto label_16;
                }
            }
            else {
            label_16:
                v10_2 = ((String)v0);
            }

            v10_2 = v10_2 != null ? StringsKt.trim(((CharSequence)v10_2)).toString() : ((String)v0);
            if(v10_2 != null && (new Regex("\\d{6}").matches(v10_2))) {
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PairingCodeReceiver$onReceive$1(arg9, v10_2, this.goAsync(), v0), 3, null);
                return;
            }

            Toast.makeText(arg9, "Introduce el código WiFi de 6 dígitos", 1).show();
        }
    }
}

