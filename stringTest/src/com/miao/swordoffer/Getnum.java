package com.miao.swordoffer;
//在其他数都出现k次的数组中找到只出现一次的数
public class Getnum {

    //找到只出现一次的数
    public static int OneceNum(int[]arr,int k)
    {
        //创建一个新的数组arr1[]
        int[]arr1=new int[32];
        for(int i=0;i<arr.length;i++)
        {
            setCurExc(arr1,arr[i],k);
        }
        //k进制的数转换成十进制的数
        int cur=GetNumFromKNum(arr1,k);
        return cur;

    }

    //获得中间的步骤,获得只出现一次的k进制数
    public static void setCurExc(int[]arr1,int value,int k)
    {
        //获取K进制数
        int[]res=getKNumFromNum(value,k);

        //实现无进位相加
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=(arr1[i]+res[i])%k;
        }

    }

    //将十进制的整数转换成k进制的数
    public static int[] getKNumFromNum(int value,int k)
    {
        //定义了一个大小为32的int型数组用来存放转换后的k进制数
        int[]res=new int[32];
        int index=0;
        while(value!=0)
        {
            res[index++]=value%k;
            value=value/k;
        }
        //返回数组res
        return res;
    }

    //将k进制的数转换成的十进制的整数
    public static int GetNumFromKNum(int[]e0,int k)
    {
        int res=0;
        for(int i=e0.length-1;i>=0;i--)
        {
            res=res*k+e0[i];
        }
        return res;
    }

    public static void main(String []args)
    {
        int[]arr={-1,-1,-1,2,2,2,3,3,3,-4,-4,-4,1101};
        //int[]arr={1,1,1,1,-2,-2,-2,-2,3,3,3,3,4,4,4,4,927};
        //k表示其他数出现的次数
        int k=3;
        //int k=4;
        System.out.println(OneceNum(arr,k));

    }
}
