package cn.jcasex.demo.collections.bitmap;

import java.io.Serializable;

/**
 * BitMap实现
 * @version $Id: BitMap.java, v 0.1 2020年02月05日 19:42 bobo.wu Exp $
 */
public class BitMap {

    private final static int ADDRESS_BITS_PER_WORD = 5;

    /**BitMap能运算数字的最大长度*/
    private long maxSize;

    /**
     * bits实际的存储映射数据，byte=8bit;
     **/
    private byte[] bits;

    public BitMap(long maxSize) {
        this.maxSize = maxSize;
        // 根据长度算出，所需数组大小
        bits = new byte[(int) (maxSize/8+1)];
    }

    /**
     * 计算出
     * @param value
     * @return
     */
    private static IndexPair getIndex(int value) {
        return new IndexPair(value >> 8,value & 0x07);
    }

    public boolean getBit(int value) {
        IndexPair index = getIndex(value);
        int bit = bits[index.getByteIndex()]>>index.getBitIndex() & 0x1;
        return bit != 0;
    }

    public void setBit(int value) {
        IndexPair index = getIndex(value);
        bits[index.getByteIndex()] |= 1 << index.getBitIndex();
    }

    public void clearBit(int bitIndex) {
        // TODO
    }
}

class IndexPair {
    int byteIndex;
    int bitIndex;

    public IndexPair(int byteIndex,int bitIndex){
        this.byteIndex =byteIndex;
        this.bitIndex=bitIndex;
    }

    /**
     * Getter method for property <tt>byteIndex</tt>.
     *
     * @return property value of byteIndex
     */
    public int getByteIndex() {
        return byteIndex;
    }

    /**
     * Getter method for property <tt>bitIndex</tt>.
     *
     * @return property value of bitIndex
     */
    public int getBitIndex() {
        return bitIndex;
    }
}