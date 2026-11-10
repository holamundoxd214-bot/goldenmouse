package org.bouncycastle.crypto;

public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean arg1, CipherParameters arg2) throws IllegalArgumentException;

    int processBlock(byte[] arg1, int arg2, byte[] arg3, int arg4) throws DataLengthException, IllegalStateException;

    void reset();
}

