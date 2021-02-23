
package eternalcalendaritaly;

public class EternalItalyTest {

    public static void main(String[] args) throws InterruptedException 
    {
        EternalCalendarItaly eternalItaly = new EternalCalendarItaly();
        eternalItaly.setDefaultCloseOperation( EternalCalendarItaly.EXIT_ON_CLOSE );
        eternalItaly.setSize( 620, 600 ); 
        eternalItaly.setVisible( true );
        EternalItalyFunction.show_CurrentMonth();       
    }
    
}


