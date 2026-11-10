package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

class StreamUtil {
    StreamUtil() {
        super();
    }

    static int findLimit(InputStream arg5) {
        long v3;
        if((arg5 instanceof LimitedInputStream)) {
            return ((LimitedInputStream)arg5).getLimit();
        }

        if((arg5 instanceof ASN1InputStream)) {
            return ((ASN1InputStream)arg5).getLimit();
        }

        if((arg5 instanceof ByteArrayInputStream)) {
            return ((ByteArrayInputStream)arg5).available();
        }

        long v1 = 0x7FFFFFFF;
        if((arg5 instanceof FileInputStream)) {
            try {
                FileChannel v5 = ((FileInputStream)arg5).getChannel();
                if(v5 != null) {
                    v3 = v5.size();
                }
                else {
                    goto label_19;
                }

                goto label_20;
            }
            catch(IOException ) {
                goto label_23;
            }

        label_19:
            v3 = v1;
        label_20:
            if(v3 >= v1) {
                goto label_23;
            }

            return ((int)v3);
        }

    label_23:
        v3 = Runtime.getRuntime().maxMemory();
        if(v3 > v1) {
            return 0x7FFFFFFF;
        }

        return ((int)v3);
    }
}

