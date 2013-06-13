/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.zetta.progressbar;

/**
 *
 * @author zetta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
           // esto es solo de prueba
        int max = Integer.parseInt(args[0]);
        ProgressBar pb = new ProgressBar(max);
        for(int i = 0; i <= max; i++)
        {
            //System.out.println(i);
            pb.step(i);
            Thread.currentThread().sleep(1000);
        }

    }

}
