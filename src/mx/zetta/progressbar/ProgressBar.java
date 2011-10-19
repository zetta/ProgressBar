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
        String percString = padLeft(percentage.toString(), 5)+"%";
        Integer totalSize = size+8;
        if(!isNew)
        {
            for(int i = totalSize; i > 0; i--)
            {
                System.out.print("\b");
            }
        }
        for(int j = 0; j <= size; j++)
        {
            if(j <= (current/total)*size )
            {
                System.out.print("^[[42m ^[[0m");
            }else
            {
                System.out.print("^[[47m ^[[0m");
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


/*

    $perc = round(($current/$total)*100,2);        //Percentage round off for a more clean, consistent look 
    for($i=strlen($perc); $i<=4; $i++) $perc = ' '.$perc;    // percent indicator must be four characters, if shorter, add some spaces 

    $total_size = $size + $i + 3; 
    // if it's not first go, remove the previous bar 
    if(!$new_bar) { 
        for($place = $total_size; $place > 0; $place--) echo "\x08";    // echo a backspace (hex:08) to remove the previous character 
    } 
     
    $bars[$label]=$current; //saves bar status for next call 
    // output the progess bar as it should be 
    for($place = 0; $place <= $size; $place++) { 
        if($place <= ($current / $total * $size)) echo '^[[42m ^[[0m';    // output green spaces if we're finished through this point 
        else echo '^[[47m ^[[0m';                    // or grey spaces if not 
    } 

    // end a bar with a percent indicator 
    echo " $perc%"; 
    if($current == $total) { 
        unset($bars[$label]); 
    } 

*/



