/*
 * Clase 
 */

package mx.zetta.progressbar;

import java.text.DecimalFormat;


/**
 * 
 * @author zetta
 */
public class ProgressBar {

    private Float total;
    private Float current;
    private boolean isNew = true;
    private Integer size = 50;
    private DecimalFormat format = new DecimalFormat("#,###,###,###.00");

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

        Double percentage =  new Double(format.format((current/total)*100)).doubleValue();
        String percString = padLeft(percentage.toString(), 6)+"%";
        Integer totalSize = size+8;
        if(!isNew)
        {
            for(int i = totalSize; i > 0; i--)
            {
                System.out.print("\u0008");
            }
        }
        for(int j = 0; j <= size; j++)
        {
            if(j <= (current/total)*size )
            {
                System.out.print("\u001b[1;42m \u001b[0m");
            }else
            {
                System.out.print("\u001b[1;47m \u001b[0m");
            }
        }
        System.out.print(percString);
        if(current == total)
            System.out.print("\n");
        isNew = false;
    }

    
    private String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);  
    }

    private String padLeft(String s, int n) {
        return String.format("%1$#" + n + "s", s);  
    }
}
