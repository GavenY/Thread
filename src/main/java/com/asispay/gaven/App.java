package com.asispay.gaven;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "模拟蛋糕制作销售过程" );

        int max = 20;
        int min = 5;
        int current = 0;




        while(true){
            while(current<max){

                current++;
                System.out.println("制作，蛋糕制作数量+1，现有数量"+current);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (current>min){
                current--;
                System.out.println("销售，蛋糕制作数量-1，现有数量"+current);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
