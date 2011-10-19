/*
 * Clase 
 */

package mx.zetta.progressbar;

import java.text.NumberFormat;

/**
 * 
 * @author zetta
 */
public class ProgressBar {

    private Float total;
    private Float current;
    private boolean isNew = true;
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    public ProgressBar(Integer total)
    {
        this.isNew = true;
        this.total = (float) total;
        this.current = (float) 0;
    }

    public void step(Integer current)
    {
        this.current = (float) current;
        printCurrentBar();
    }

    public void step()
    {
        this.current++;
        printCurrentBar();
    }

    private void printCurrentBar()
    {
        //System.out.println((float)total);
        //System.out.println((float)current);

        Float percentage = (current/total) *100;

        //System.out.println();

        //Float percentage =  new Float((current/total)*100);
        //System.out.println((float)current/(float)total);
        System.out.println("--------------");
    }

}
