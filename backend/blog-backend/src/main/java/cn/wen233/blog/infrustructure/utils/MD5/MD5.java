package cn.wen233.blog.infrustructure.utils.MD5;

import java.security.MessageDigest;

/**
 * @author: huu
 * @date: 2020/4/7 18:14
 * @description:
 */

import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMD5(String plainText, int length) {
        try {
            //获取MD5实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            //此处传入要加密的byte类型值
            md.update(plainText.getBytes());
            //此处得到的是md5加密后的byte类型值
            byte[] digest = md.digest();
            /*
               下边的运算就是自己添加的一些二次小加密，记住这个千万不能弄错乱，
                   否则在解密的时候，你会发现值不对的（举例：在注册的时候加密方式是一种，
                在我们登录的时候是不是还需要加密它的密码然后和数据库的进行比对，但是
            最后我们发现，明明密码对啊，就是打不到预期效果，这时候你就要想一下，你是否
             有改动前后的加密方式）
            */
            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    sb.append(0);
                }
                //通过Integer.toHexString方法把值变为16进制
                sb.append(Integer.toHexString(i));
            }
            //从下标0开始，length目的是截取多少长度的值
            return sb.toString().substring(0, length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String s = "123456";
        System.out.println(MD5.getMD5(s, 32));
    }
}
