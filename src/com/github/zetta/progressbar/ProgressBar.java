/*
 * Clase 
 */

package com.github.zetta.progressbar;

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
    private Integer lastSize = 0;
    private DecimalFormat format = new DecimalFormat("#,###,###,###.00");

    public ProgressBar(Integer total)
    {
        this.isNew = true;
        this.total = (float) total;
        this.current = (float) 0;
    }

    public void restart(float total)
    {
        this.total = total;
        this.restart();
    }
    
    public void restart()
    {
        this.isNew = true;
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
        String percString = padLeft(percentage, 6)+"%";
        //String percString = padLeft(percentage.toString(), 6)+"%";
        //String percString = percentage.toString()+"%";
        //Integer totalSize = size+8;
        if(!isNew)
        {
            for(int i = lastSize; i > 0; i--)
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
        lastSize = size+ 10 + percString.length(); // hrmmm no le atino
        if(current == total)
            System.out.print("\n");
        isNew = false;
    }



    private String padLeft(Double number, int length)
    {
        return String.format("%" + length + ".2f", number);
    }

}
