package com.jwt.dataStructures.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {
    //储存由原始二维数组变为稀疏数组后的数组
    private static int sparse[][] = null;

    public static void main(String[] args) {
        chessArrayToSparseArr();
        sparseArrToChessArray();
    }

    /**
     * 将原始二维数组变为稀疏数组
     */
    public static void chessArrayToSparseArr(){
        //创建一个原始的二维数组11*11
        int chessArr1[][] = new int[10][11];
        // 0:表示没有棋子,1表示黑子,2表蓝子,随机添加几个数据放入数组中
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将原始二维数组转为稀疏数组的思路
        //1.稀疏数组有sum+1行(sum为有效数据的个数)3列(分别为原始数据的行,列,和有效数据值)
        //1.1先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //1.2创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //1.3给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //1.4遍历二维数组将非0数据放入稀疏数组对应的位置中
        //count用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        sparse = sparseArr;
        //输出稀疏数组的形式
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
    }

    /**
     * 将稀疏数组还原成原始二维数组
     */
    public static void sparseArrToChessArray(){
        //根据稀疏数组第一行的前两列创建原始二维数组
        int chessArr2[][] = new int [sparse[0][0]][sparse[0][1]];
        //从第二行遍历稀疏数组将值插入到原始数组中
        for (int i = 1; i < sparse.length; i++) {
          chessArr2[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
