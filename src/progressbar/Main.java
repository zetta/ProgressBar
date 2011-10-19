/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package progressbar;

import mx.zetta.progressbar.ProgressBar;

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
        ProgressBar pb = new ProgressBar(333);
        for(int i = 0; i <= 200; i++)
        {
            //System.out.println(i);
            pb.step(i);
            Thread.currentThread().sleep(333);
        }

    }

}
