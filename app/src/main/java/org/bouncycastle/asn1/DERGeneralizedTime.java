package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.util.Strings;

public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(byte[] arg1) {
        super(arg1);
    }

    public DERGeneralizedTime(String arg1) {
        super(arg1);
    }

    public DERGeneralizedTime(Date arg1) {
        super(arg1);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 24, this.getDERTime());
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.getDERTime().length);
    }

    private byte[] getDERTime() {
        byte[] v3;
        byte[] v0;
        byte v1 = 90;
        if(this.contents[this.contents.length - 1] == v1) {
            if(!this.hasMinutes()) {
                v0 = new byte[this.contents.length + 4];
                System.arraycopy(this.contents, 0, v0, 0, this.contents.length - 1);
                System.arraycopy(Strings.toByteArray("0000Z"), 0, v0, this.contents.length - 1, 5);
                return v0;
            }

            if(!this.hasSeconds()) {
                v0 = new byte[this.contents.length + 2];
                System.arraycopy(this.contents, 0, v0, 0, this.contents.length - 1);
                System.arraycopy(Strings.toByteArray("00Z"), 0, v0, this.contents.length - 1, 3);
                return v0;
            }

            if(this.hasFractionalSeconds()) {
                int v0_1;
                for(v0_1 = this.contents.length - 2; v0_1 > 0; --v0_1) {
                    if(this.contents[v0_1] != 0x30) {
                        break;
                    }
                }

                if(this.contents[v0_1] == 46) {
                    v3 = new byte[v0_1 + 1];
                    System.arraycopy(this.contents, 0, v3, 0, v0_1);
                    v3[v0_1] = v1;
                    return v3;
                }

                v3 = new byte[v0_1 + 2];
                ++v0_1;
                System.arraycopy(this.contents, 0, v3, 0, v0_1);
                v3[v0_1] = v1;
                return v3;
            }

            return this.contents;
        }

        return this.contents;
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

