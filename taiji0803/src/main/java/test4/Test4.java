package test4;

public class Test4 {

    public static void main(String[] args) {
        // 定义一个整型数组，长度为10
        int[] nums = new int[10];
        //通过循环给数组赋值
        for (int i = 0; i < nums.length; i++) {
            // 产生10以内的随机数
            int x = (int) (Math.random()*100);
            nums[i] = x;// 为元素赋值
        }
        Test4 test4 = new Test4();
        test4.maxNum(nums);
        test4.minNum(nums);
        test4.pingjun(nums);
        test4.maopao(nums);

    }
    public void maxNum(int[] nums){
        int max = nums[0];
        for (int i = 1 ; i<nums.length;i++){
            if (max < nums[i]){
                max = nums[i];
            }
        }
        System.out.println("最大值" + max);
    }
    public void minNum(int[] nums){
        int min = nums[0];
        for (int i = 1 ; i<nums.length;i++){
            if (min > nums[i]){
                min = nums[i];
            }
        }
        System.out.println("最小值"+min);
    }
    public void pingjun (int[] nums){
        int sum = 0;
        for (int i = 0 ; i<nums.length ; i++){
            sum += nums[i];
        }
        System.out.println("平均值"+sum/nums.length);
    }
    public void maopao(int[] nums){
        //冒泡排序
        int i , j ;
        for(i=0;i<nums.length-1;i++)
        {
            for(j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println("从小到大排序后的结果是:");
        for(i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
}
