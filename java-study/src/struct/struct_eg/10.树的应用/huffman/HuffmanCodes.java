package com.bjpowernode.huffman;

import org.jcp.xml.dsig.internal.dom.DOMExcC14NMethod;
import sun.security.krb5.internal.crypto.Des;

import javax.lang.model.element.VariableElement;
import java.util.*;

/**
 * @company: 北京动力节点
 * @author:韩国庆
 */
public class HuffmanCodes {

    /**
     * 1、需要统计字母所出现的次数
     * 2、创建赫夫曼树
     * 3、获取赫夫曼编码
     * 4、数据压缩
     */

    private static Map<Byte, String> huffmanCode = new HashMap<>();

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {

        String string = "I'm hanguoqing. What's your name";
        byte[] bytes = string.getBytes();

        List<NodeCode> nodeWeight = getNodeWeight(bytes);

        NodeCode root = createHuffmanTree(nodeWeight);

        Map<Byte, String> huffmanCodes = createHuffmanCodes(root);
        System.out.println("生成的赫夫曼编号：" + huffmanCodes);

        byte[] zip = zip(bytes, huffmanCodes);
        System.out.println("压缩后的数组:" + Arrays.toString(zip));

        byte[] decode = decode(huffmanCode, zip);
        System.out.println(new String(decode));


    }

    /**
     * @param huffmanCode
     * @param huffmanBytes
     * @return 97:1010     1010:97
     */
    public static byte[] decode(Map<Byte, String> huffmanCode, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();// 100100101001001001001010....
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            /*boolean flg = false;
            if (i==huffmanBytes.length-1){
                flg = true;
            }*/
            boolean flg = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToString(!flg, b));
        }

        //10000101
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> bytes = new ArrayList<>();

        //10010010 1001001001001010....
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flg = true;
            Byte b = null;
            while (flg) {

                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);

                if (b == null) {
                    count++;
                } else {
                    flg = false;
                    bytes.add(b);
                }
            }

            i += count;

        }


        byte[] buff = new byte[bytes.size()];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = bytes.get(i);


        }

        return buff;

    }

    /**
     * 把文本-->二进制数组 ---->赫夫曼编码 二进制字符串 ----> 压缩数组
     * 如何把数据进行解压
     * [-52, -72, 5, 110, -73, -94, -81, -16, 61, -42, -107, 124, 100,78 , 0]
     */

    public static String byteToString(boolean isPepair, byte b) {
        /**
         * b: 占 8个二进制位
         * int: 占32个二进制位
         * 正数时需要补高8位，负数的时候不需要补
         */
        int temp = b;
        if (isPepair) {
            temp |= 256;//256  10000000  | 00000001 = 10000001
        }

        String string = Integer.toBinaryString(temp);
        if (isPepair) {
            return string.substring(string.length() - 8);
        } else {
            return string;
        }
    }


    /**
     * 统计字符串所出现的次数
     * 返回集合  [NodeCode{data=32,weight=4},NodeCode{data=33,weight=5}]
     */
    public static List<NodeCode> getNodeWeight(byte[] bytes) {

        List<NodeCode> nodeCodes = new ArrayList<>();

        //每一个byte出现的次数，使用一个map集合   key=byte，value=weight
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = counts.get(aByte);
            if (count == null) {
                counts.put(aByte, 1);
            } else {
                counts.put(aByte, count + 1);
            }

        }

        /**
         * 把每一个map对象转Node对象，存放在集合中
         */
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodeCodes.add(new NodeCode(entry.getKey(), entry.getValue()));
        }
        return nodeCodes;
    }

    /**
     * 创建赫夫曼树
     */

    public static NodeCode createHuffmanTree(List<NodeCode> nodeCodes) {
        /**
         * 循环处理
         */
        while (nodeCodes.size() > 1) {
            //排序  从小到大
            Collections.sort(nodeCodes);

            //找到最小的两个元素(节点)
            NodeCode leftNode = nodeCodes.get(0);
            NodeCode rightNode = nodeCodes.get(1);

            //两个最小节点weight相加，生成一个新的节点
            NodeCode root = new NodeCode(leftNode.weight + rightNode.weight);

            //将新的节点作为父节点，构成一个新的二叉树
            root.left = leftNode;
            root.right = rightNode;

            nodeCodes.remove(leftNode);
            nodeCodes.remove(rightNode);

            nodeCodes.add(root);

        }
        return nodeCodes.get(0);
    }

    /**
     * 获取赫夫曼编码
     * 1. 往左取0 ，往右取1
     * a:101
     * b:01000
     * <p>
     * 完整赫夫曼编码  10101000
     * StringBuilder codes :用来拼接完整的赫夫曼编码
     * Map 用来存储叶子结点路径 key=32  value 101        (32,101),(33,01000)
     */
    public static void getHuffmanCode(NodeCode nodeCode, String code, StringBuilder stringBuilder) {
        StringBuilder newString = new StringBuilder(stringBuilder);
        newString.append(code);

        if (nodeCode != null) {
            if (nodeCode.data == null) {
                //向左递归
                getHuffmanCode(nodeCode.left, "0", newString);

                //向右递归
                getHuffmanCode(nodeCode.right, "1", newString);
            } else {
                huffmanCode.put(nodeCode.data, newString.toString());
            }
        }


    }

    /**
     * 设置统一入口
     */
    public static Map<Byte, String> createHuffmanCodes(NodeCode root) {
        if (root == null) {
            return null;
        }
        //处理左子树
        getHuffmanCode(root.left, "0", stringBuilder);
        //处理右子树
        getHuffmanCode(root.right, "1", stringBuilder);

        return huffmanCode;
    }

    /**
     * 数据压缩
     * 01100011 00001011 00011001 1101010010 011010
     */

    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        //用来拼接所有叶子节点路径
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCode.get(b));
        }
        System.out.println(stringBuilder.toString());
        int length;
        if (stringBuilder.length() % 8 == 0) {
            length = stringBuilder.length() / 8;
        } else {
            length = stringBuilder.length() / 8 + 1;
        }

        //压缩数据的数组
        byte[] huffmanCodeBytes = new byte[length];

        //01100011 00001011 00011001 1101010010 011010 ...        25
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str;
            if (i + 8 > stringBuilder.length()) {
                str = stringBuilder.substring(i);
            } else {
                str = stringBuilder.substring(i, i + 8);
            }

            huffmanCodeBytes[index] = (byte) Integer.parseInt(str, 2);
            index++;
        }
        return huffmanCodeBytes;
    }


}
