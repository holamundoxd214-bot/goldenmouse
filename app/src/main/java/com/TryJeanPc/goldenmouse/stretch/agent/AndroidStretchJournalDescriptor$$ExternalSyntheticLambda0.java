package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.jvm.functions.Function0;

public final class AndroidStretchJournalDescriptor$$ExternalSyntheticLambda0 implements Function0 {
    public AndroidStretchJournalDescriptor$$ExternalSyntheticLambda0(FileInputStream arg1, FileOutputStream arg2, ParcelFileDescriptor arg3, FileChannel arg4, String arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke() {
        return AndroidStretchJournalDescriptor.adopt$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

