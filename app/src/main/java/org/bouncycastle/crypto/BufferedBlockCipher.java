package org.bouncycastle.crypto;

public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected boolean forEncryption;
    protected MultiBlockCipher mbCipher;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    BufferedBlockCipher() {
        super();
    }

    public BufferedBlockCipher(BlockCipher arg6) {
        super();
        this.cipher = arg6;
        if((arg6 instanceof MultiBlockCipher)) {
            this.mbCipher = arg6;
            this.buf = new byte[arg6.getMultiBlockSize()];
        }
        else {
            this.mbCipher = null;
            this.buf = new byte[arg6.getBlockSize()];
        }

        boolean v0 = false;
        this.bufOff = 0;
        String v1 = arg6.getAlgorithmName();
        int v2 = v1.indexOf(0x2F) + 1;
        boolean v4 = v2 <= 0 || !v1.startsWith("PGP", v2) ? false : true;
        this.pgpCFB = v4;
        if(!v4) {
            if((arg6 instanceof StreamCipher)) {
            }
            else {
                if(v2 > 0 && (v1.startsWith("OpenPGP", v2))) {
                    v0 = true;
                }

                this.partialBlockOkay = v0;
                return;
            }
        }

        this.partialBlockOkay = true;
    }

    public int doFinal(byte[] arg10, int arg11) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int v10;
        int v8;
        byte[] v7;
        int v6;
        int v1;
        try {
            int v0_1 = this.bufOff;
            if(arg11 + v0_1 > arg10.length) {
                goto label_48;
            }

            v1 = 0;
            if(v0_1 != 0) {
                MultiBlockCipher v2 = this.mbCipher;
                if(v2 != null) {
                    v6 = v0_1 / v2.getBlockSize();
                    v7 = arg10;
                    v8 = arg11;
                    v10 = this.mbCipher.processBlocks(this.buf, 0, v6, v7, v8);
                    v6 *= this.mbCipher.getBlockSize();
                }
                else {
                    v7 = arg10;
                    v8 = arg11;
                    v10 = 0;
                    v6 = 0;
                }

                if(this.bufOff != v6) {
                    if(this.partialBlockOkay) {
                        this.cipher.processBlock(this.buf, v6, this.buf, v6);
                        System.arraycopy(this.buf, v6, v7, v8 + v10, this.bufOff - v6);
                        v10 += this.bufOff - v6;
                        this.bufOff = 0;
                    }
                    else {
                        throw new DataLengthException("data not block size aligned");
                    }
                }

                goto label_45;
            }

            goto label_46;
        }
        catch(Throwable v0) {
            goto label_54;
        }

    label_45:
        v1 = v10;
    label_46:
        this.reset();
        return v1;
        try {
        label_48:
            throw new OutputLengthException("output buffer too short for doFinal()");
        }
        catch(Throwable v0) {
        label_54:
            this.reset();
            throw v0;
        }
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int arg2) {
        int v1;
        if(!this.pgpCFB || !this.forEncryption) {
            v1 = this.bufOff;
        }
        else {
            arg2 += this.bufOff;
            v1 = this.cipher.getBlockSize() + 2;
        }

        return arg2 + v1;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int arg3) {
        int v2;
        int v0_1;
        arg3 += this.bufOff;
        if(this.pgpCFB) {
            boolean v0 = this.forEncryption;
            byte[] v1 = this.buf;
            if(v0) {
                v0_1 = arg3 % v1.length - (this.cipher.getBlockSize() + 2);
            }
            else {
                v2 = v1.length;
                goto label_18;
            }
        }
        else {
            v2 = this.buf.length;
        label_18:
            v0_1 = arg3 % v2;
        }

        return arg3 - v0_1;
    }

    public void init(boolean arg1, CipherParameters arg2) throws IllegalArgumentException {
        this.forEncryption = arg1;
        this.reset();
        this.cipher.init(arg1, arg2);
    }

    private int processBuffer(byte[] arg8, int arg9) {
        this.bufOff = 0;
        MultiBlockCipher v1 = this.mbCipher;
        if(v1 != null) {
            return v1.processBlocks(this.buf, 0, this.buf.length / v1.getBlockSize(), arg8, arg9);
        }

        return this.cipher.processBlock(this.buf, 0, arg8, arg9);
    }

    public int processByte(byte arg4, byte[] arg5, int arg6) throws DataLengthException, IllegalStateException {
        byte[] v0 = this.buf;
        int v1 = this.bufOff;
        int v2 = v1 + 1;
        this.bufOff = v2;
        v0[v1] = arg4;
        if(v2 == v0.length) {
            return this.processBuffer(arg5, arg6);
        }

        return 0;
    }

    public int processBytes(byte[] arg12, int arg13, int arg14, byte[] arg15, int arg16) throws DataLengthException, IllegalStateException {
        int v3;
        byte[] v2_1;
        int v2;
        int v7 = arg16;
        if(arg14 >= 0) {
            int v8 = this.getBlockSize();
            int v4 = this.getUpdateOutputSize(arg14);
            if(v4 > 0) {
                if(v4 + v7 <= arg15.length) {
                }
                else {
                    throw new OutputLengthException("output buffer too short");
                }
            }

            byte[] v4_1 = this.buf;
            int v6 = v4_1.length;
            int v9 = this.bufOff;
            v6 -= v9;
            int v10 = 0;
            if(arg14 > v6) {
                if(v9 != 0) {
                    System.arraycopy(arg12, arg13, v4_1, v9, v6);
                    v2 = arg13 + v6;
                    v9 = arg14 - v6;
                }
                else {
                    v2 = arg13;
                    v9 = arg14;
                }

                if(arg12 == arg15) {
                    byte[] v1 = new byte[v9];
                    System.arraycopy(arg15, v2, v1, 0, v9);
                    v2_1 = v1;
                    v3 = 0;
                }
                else {
                    v3 = v2;
                    v2_1 = arg12;
                }

                if(this.bufOff != 0) {
                    v10 = this.processBuffer(arg15, v7);
                }

                MultiBlockCipher v1_1 = this.mbCipher;
                if(v1_1 != null) {
                    v4 = this.mbCipher.getMultiBlockSize() / v8 * (v9 / v1_1.getMultiBlockSize());
                    if(v4 > 0) {
                        v10 += this.mbCipher.processBlocks(v2_1, v3, v4, arg15, v7 + v10);
                        v4 *= v8;
                        v9 -= v4;
                        v3 += v4;
                    }
                    else {
                    }

                    goto label_69;
                }

                while(v9 > this.buf.length) {
                    v10 += this.cipher.processBlock(v2_1, v3, arg15, v7 + v10);
                    v9 -= v8;
                    v3 += v8;
                }
            }
            else {
                v2_1 = arg12;
                v3 = arg13;
                v9 = arg14;
            }

        label_69:
            System.arraycopy(v2_1, v3, this.buf, this.bufOff, v9);
            int v1_2 = this.bufOff + v9;
            this.bufOff = v1_2;
            if(v1_2 == this.buf.length) {
                v10 += this.processBuffer(arg15, v7 + v10);
            }

            return v10;
        }

        throw new IllegalArgumentException("Can\'t have a negative input length!");
    }

    public void reset() {
        int v1;
        for(v1 = 0; true; ++v1) {
            byte[] v2 = this.buf;
            if(v1 >= v2.length) {
                break;
            }

            v2[v1] = 0;
        }

        this.bufOff = 0;
        this.cipher.reset();
    }
}

