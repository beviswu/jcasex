package cn.bevisoft.jcasex.common.enums;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5Encrypt {

    private static final String MD5_PREFIX = "jcasex.bevisoft.cn";  

    /**
     * 加密密码。
     * 
     * @param password
     *            要加密的密码
     * @return 经过加密的密码
     */
    public static String encode(String password) {
        return DigestUtils.md5Hex(MD5_PREFIX + DigestUtils.md5Hex(password));
    }


}
