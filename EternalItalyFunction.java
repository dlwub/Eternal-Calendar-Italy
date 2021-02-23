
package eternalcalendaritaly;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Object;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;


public class EternalItalyFunction {  
    
    public static int day_of_date(String m)
    {
        int r = (count_date(m)- 2)%7;        
        return r;
    }    
    
    public static String print_date(int d, int m, int y)
    {
        String day, mo, q;
        if (d==0)
        {
            day = Integer.toString(30);
            mo = String.format("%02d",m);            
            q = String.format("%04d",y);
        }
        else
        {
            day = String.format("%02d",d);
            mo = String.format("%02d",m+1);
            q = String.format("%04d",y);
        }
        String date = day + mo + q;        
        return date;        
    } 
    
    public static String date_of_days(int m)
    {
        int mo = 0;
        int d = 0;
        int i = 1;
        String date;
        while (m > 365)
        {
            m-=365;
            i+=1;
            if ((i+1)%4==0)
            {
                if (m > 366)
                {
                    m-=366;
                    i+=1;
                }
                else
                {
                    mo = m/30;
                    d = m%30; 
                    date = print_date(d, mo, i);
                    return date;
                }
            }
        }
        mo = m/30;
        d = m%30;
        date = print_date(d, mo, i);
        return date;        
    }
    
    public static int days_of_month(String m, int i)
    {
        int [] l = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ( (Integer.parseInt(m.substring(4)) < 1582)| (Integer.parseInt(m.substring(4))==1582 & Integer.parseInt(m.substring(2,4))<10) 
        |(Integer.parseInt(m.substring(4))==1582 & Integer.parseInt(m.substring(2,4)) ==10 & Integer.parseInt(m.substring(0,2))<5))
        {
            if (Integer.parseInt(m.substring(4))%4 ==0)
            {
                l[1] = 29;                
            }            
            else
            {
            }
        }
        else
        {
            if (Integer.parseInt(m.substring(4))%4==0)
            {
                if ((Integer.parseInt(m.substring(4))%100!=0) | (Integer.parseInt(m.substring(4))%100==0 & Integer.parseInt(m.substring(4))%400==0))
                {
                    l[1] = 29;
                }
                else
                {                    
                }
            }
            else
            {
            }
        }
        return l[i];
    }
    
    public static int count_date(String m)
    {
        int count=0;
        if ( (Integer.parseInt(m.substring(4)) < 1582)| (Integer.parseInt(m.substring(4))==1582 & Integer.parseInt(m.substring(2,4))<10) 
        |(Integer.parseInt(m.substring(4))==1582 & Integer.parseInt(m.substring(2,4)) ==10 & Integer.parseInt(m.substring(0,2))<5))
        {
            for (int i=0; i < Integer.parseInt(m.substring(2,4))-1; i++)
            {
                count = count + days_of_month(m, i);
            }
            int date_count = (Integer.parseInt(m.substring(4))-1)*365 + (Integer.parseInt(m.substring(4))-1)/4 + count 
                    +  Integer.parseInt(m.substring(0,2)); 
            return date_count;
        }
        else
        {            
            for (int i=0; i <(Integer.parseInt(m.substring(2,4)))-1; i++)
            {
                count = count + days_of_month(m, i);
            }
            int k = Integer.parseInt(m.substring(4))-1599;
            int r = k/100;
            int t = r/4;
            int z = r-t;
            int date_count = (Integer.parseInt(m.substring(4))-1)*365 + (Integer.parseInt(m.substring(4))-1)/4 
                + count + Integer.parseInt(m.substring(0,2))-10-z;
            return date_count;
        }
    }   
    
    public static String[] easter_goodfriday(String m)
    {
        int [] f = {31,28,31,30,31,30,31,31,30,31,30,31};
        int a_0, b_0, c_0, d_0, e_0, f_0, g_0, h_0, i_0, k_0, l_0, m_0, mo_0, p_0;
        String[] easter = new String[2];
        a_0 = Integer.parseInt(m.substring(0,4))%19;
        b_0 = Integer.parseInt(m.substring(0,4))/100;
        c_0 = Integer.parseInt(m.substring(0,4))%100;
        d_0 = b_0/4;
        e_0 = b_0%4;
        f_0 = (b_0 + 8)/25;
        g_0 = (b_0 - f_0 + 1)/3;
        h_0 = (19*a_0 + b_0 - d_0 - g_0 + 15)%30;
        i_0 = c_0/4;
        k_0 = c_0%4;
        l_0 = (32 + 2*e_0 + 2*i_0 - h_0 - k_0)%7;
        m_0 = (a_0 + 11*h_0 + 22*l_0)/451;
        mo_0 = (h_0 + l_0 - 7*m_0 + 114)/31;
        p_0 = (h_0 + l_0 - 7*m_0 + 114)%31;
        if (p_0 >=2){
            easter[0] = String.format("%02d", p_0 - 1) + String.format("%02d", mo_0) + String.format("%04d", Integer.parseInt(m)); /*Good Friday */ 
        }
        else{
            easter[0] = String.format("%02d", f[mo_0 - 2] + p_0 - 1) + String.format("%02d", mo_0 - 1) + String.format("%04d", Integer.parseInt(m)); /*Good Friday */
        }
        easter[1] = String.format("%02d", p_0 + 1) + String.format("%02d", mo_0) + String.format("%04d", Integer.parseInt(m));        
        return easter;
    }
    
    public static int work_days(String date_1, String date_2)
    {
        int date1 = count_date(date_1);
        int date2 = count_date(date_2);
        int no_days = date2 - date1 + 1;
        int q = no_days / 7;
        int r = no_days % 7;
        int z = day_of_date(date_1);
        int week_ends = 0;
        if (r == 0)
            week_ends = 0;
        else if (z == 0)
            week_ends = 1;
        else if (z + r < 7)
            week_ends = 0;
        else if (z + r == 7)
            week_ends = 1;
        else if (z+r > 7)
            week_ends = 2;
        int work_days = no_days - 2*q - week_ends;        
        return work_days;
    }
    
    public static Object[] holiday_list(String date_1, String date_2)
    {
        int workdays = work_days(date_1, date_2);         
        ArrayList<String> holidays = new ArrayList<String>();        
        int days_1 = count_date(date_1);
        int days_2 = count_date(date_2);         
        
        int i = 0;        
        while ((Integer.parseInt(date_1.substring(4))+i) <= (Integer.parseInt(date_2.substring(4))))
        {
            int k = Integer.parseInt(date_1.substring(4))+i;
            String easterMonday;
            String s = String.format("%04d",k);            
            int date1 = count_date("0101" + s);
            int date2 = count_date("0601" + s);
            int date3 = count_date("2504" + s);
            int date4 = count_date("0105" + s);
            int date5 = count_date("0206" + s);
            int date6 = count_date("1508" + s);
            int date7 = count_date("0111" + s);
            int date8 = count_date("0812" + s);
            int date9 = count_date("2512" + s);
            int date10 = count_date("2612" + s);            
            
            String [] easter = easter_goodfriday(s);
            if (days_1 <= count_date(easter[0]) && count_date(easter[0]) <=days_2)
                holidays.add(easter[0] + "Venerdi santo");
            if (days_1 <= count_date(easter[1]) && count_date(easter[1]) <=days_2)
                holidays.add(easter[1] + "Pasqua");
            if (Integer.parseInt(easter[1].substring(0,2)) < days_of_month(easter[1],Integer.parseInt(easter[1].substring(2,4))-1))
            {
                easterMonday = String.format("%02d",Integer.parseInt(easter[1].substring(0,2))+1) + easter[1].substring(2);                              
            }
            else
            {
                easterMonday = "01" + String.format("%02d",Integer.parseInt(easter[1].substring(2,4))+1) + easter[1].substring(4);                
            }
            if (days_1 <= count_date(easterMonday) && count_date(easterMonday) <=days_2)
                holidays.add(easterMonday + "Pasquetta");
            if ((days_1 <= date1)&& (date1 <= days_2))
                holidays.add("0101" + s + "Capodanno");
            if ((days_1 <= date2) && (date2 <= days_2))
                holidays.add("0601" + s + "Epifania");            
            if ((days_1 <= date6) && (date6 <= days_2))
                holidays.add("1508" + s + "Ferragosto");
            if ((days_1 <= date9) && (date9 <= days_2))
                holidays.add("2512" + s + "Natale");           
            if (k > 1945)
            {
                if ((days_1 <= date3) && (date3 <= days_2))
                    holidays.add("2504" + s + "Festa della Liberazione");
            }
            if (k > 1945)
            {
                if ((days_1 <= date4) && (date4 <= days_2))
                    holidays.add("0105" + s + "Festa del Lavoro");
            }
            if (k > 1946)
            {
                if ((days_1 <= date5) && (date5 <= days_2))
                    holidays.add("0206" + s + "Festa della Repubblica");
            }
            if (k > 835)
            {
                if ((days_1 <= date7) && (date7 <= days_2))
                    holidays.add("0111" + s + "Tutti i santi");
            }
            if (k > 1708)
            {
                if ((days_1 <= date8) && (date8 <= days_2))
                    holidays.add("0812" + s + "Immacolata Concezione");
            }
            if ((days_1 <= date10) && (date10 <= days_2))
                holidays.add("2612" + s + "Santo Stefano");
            
            i+=1;           
        }        
        
        for ( int a = 0; a < holidays.size(); a++ )
        {
            String temp = holidays.get(a);
            holidays.set(a, temp.substring(4,8) + temp.substring(2,4) + temp.substring(0,2) + temp.substring(8));
        }
        
        for (int k = 0; k < holidays.size(); k++)
        {
            for (int a=0; a < holidays.size()-1; a++)
            {
                int z = compare(holidays.get(a),holidays.get(a+1));
                if(z>0)
                {
                    String temp = holidays.get(a);
                    holidays.set(a,holidays.get(a+1));
                    holidays.set(a+1,temp);  
                }
            }
        }        
                
        for ( int a = 0; a < holidays.size(); a++ )
        {
            String temp = holidays.get(a);
            holidays.set(a, temp.substring(6,8) + temp.substring(4,6) + temp.substring(0,4) + temp.substring(8));
        }
        
        for (String holiday:holidays)
        {
            if((day_of_date(holiday.substring(0,8))!=0)&&(day_of_date(holiday.substring(0,8)))!=6)
            { 
                workdays-=1; 
            }            
        }        
        Object[] work_holiday = new Object[2];
        work_holiday [0] = workdays;        
        work_holiday [1] = holidays;
        return work_holiday;
    }
    
    public static int compare(String s1, String s2)
    {
        return s1.substring(2).compareTo(s2.substring(2));
    }    
    
    public static String get_Month(int n) 
    {
        String [] month_name = {"gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno",
            "luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre"};
        return month_name[n-1];
    }
    
    public static String get_CurrentDate()
    {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyy");
        String date = ft.format(d);
        return date;
    }
    
    public static void show_CurrentMonth() throws InterruptedException
    {
        String date = get_CurrentDate();        
        display_Month(date); 
        display_Images();
    }
    
    public static void display_Month(String s)
    {
        String[] S = create_date(s);
        String date1 = S[0];
        String date2 = S[1];
        int mo = Integer.parseInt(S[2]);
        int d = Integer.parseInt(S[3]);
                
        JButton [] buttons = {EternalCalendarItaly.jButton9, EternalCalendarItaly.jButton10,EternalCalendarItaly.jButton11,
                            EternalCalendarItaly.jButton12, EternalCalendarItaly.jButton13, EternalCalendarItaly.jButton14,
                            EternalCalendarItaly.jButton15, EternalCalendarItaly.jButton16, EternalCalendarItaly.jButton17,
                            EternalCalendarItaly.jButton18, EternalCalendarItaly.jButton19, EternalCalendarItaly.jButton20,
                            EternalCalendarItaly.jButton21, EternalCalendarItaly.jButton22, EternalCalendarItaly.jButton23,
                            EternalCalendarItaly.jButton24, EternalCalendarItaly.jButton25, EternalCalendarItaly.jButton26,
                            EternalCalendarItaly.jButton27, EternalCalendarItaly.jButton28, EternalCalendarItaly.jButton29,
                            EternalCalendarItaly.jButton30, EternalCalendarItaly.jButton31, EternalCalendarItaly.jButton32,
                            EternalCalendarItaly.jButton33, EternalCalendarItaly.jButton34, EternalCalendarItaly.jButton35,
                            EternalCalendarItaly.jButton36, EternalCalendarItaly.jButton37, EternalCalendarItaly.jButton38,
                            EternalCalendarItaly.jButton39, EternalCalendarItaly.jButton40, EternalCalendarItaly.jButton41,
                            EternalCalendarItaly.jButton42, EternalCalendarItaly.jButton43, EternalCalendarItaly.jButton44,
                            EternalCalendarItaly.jButton45};        
        
        for (int k = 0; k < buttons.length; k++)
        {
            buttons[k].setText(" ");
            buttons[k].setEnabled(true);
            buttons[k].setBackground(null);
            buttons[k].setBorderPainted(true);
        }
        
        int [] weekEnds = {0,6,7,13,14,20,21,27,28,34,35};
        for(int w:weekEnds)
        {
            buttons[w].setBackground(Color.red);
        }
        
        Object[] work_holidays = holiday_list(date1,date2);
        ArrayList<String> holidays = new ArrayList<String>();
        holidays = (ArrayList)work_holidays[1]; 
        int r = day_of_date(date1);
        int m = 1;
        int j = days_of_month(date1, mo-1);
        while (m<=j)
        {
            buttons[m+r-1].setText(String.valueOf(m));
            if (m==d)
            {
              buttons[d+r-1].setBackground(Color.green);  
            }            
            for(String holiday:holidays)
            {
                if (Integer.parseInt(holiday.substring(0,2))==m)
                {
                    buttons[m +r-1].setBackground(Color.red); 
                } 
            }
        
            m++;
        }        
        
        for (int n = 0; n < r; n++)
        {
            buttons[n].setBackground(null);
            buttons[n].setEnabled(false); 
            buttons[n].setText("");
            buttons[n].setBorderPainted(false);
        }
        
        for (int k = 36; k >= j+r;k--)
        {
            buttons[k].setBackground(null);
            buttons[k].setEnabled(false); 
            buttons[k].setText("");
            buttons[k].setBorderPainted(false);
        }
        display_holidays(date1, date2, 0); 
    }
        
    public static void display_holidays(String date1, String date2, int id)
    {
        Font myFont2 = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
        JLabel[] labels1 = {EternalCalendarItaly.jLabel3, EternalCalendarItaly.jLabel4, EternalCalendarItaly.jLabel5,
                  EternalCalendarItaly.jLabel6, EternalCalendarItaly.jLabel7, EternalCalendarItaly.jLabel8,
                  EternalCalendarItaly.jLabel9, EternalCalendarItaly.jLabel10, EternalCalendarItaly.jLabel11};                  
        JLabel[] labels2 = {EternalCalendarItaly.jLabel19, EternalCalendarItaly.jLabel20, EternalCalendarItaly.jLabel21,
                  EternalCalendarItaly.jLabel22, EternalCalendarItaly.jLabel23, EternalCalendarItaly.jLabel24,
                  EternalCalendarItaly.jLabel25, EternalCalendarItaly.jLabel26, EternalCalendarItaly.jLabel27,
                  EternalCalendarItaly.jLabel28, EternalCalendarItaly.jLabel29, EternalCalendarItaly.jLabel30,
                  EternalCalendarItaly.jLabel31, EternalCalendarItaly.jLabel32};
        
        Object[] work_holidays = holiday_list(date1,date2);        
        ArrayList<String> holidays = new ArrayList<String>();
        holidays = (ArrayList)work_holidays[1];        
        if (id==0)
        {
            for (int k =0; k < labels1.length; k++)
            {
                labels1[k].setForeground(Color.red);
                labels1[k].setFont(myFont2); 
                labels1[k].setText(" "); 
            }
            
            labels1[0].setText(get_Month(Integer.parseInt(date1.substring(2,4)))
                    + " " + Integer.parseInt(date1.substring(4)));           
            labels1[8].setText(String.valueOf(work_holidays[0]) + "   giorni di lavoro");            
            
            for (int k =0; k < Math.min(holidays.size(),7); k++)
            {
                labels1[k+1].setText(get_Month(Integer.parseInt(holidays.get(k).substring(2,4)))
                    + " " + Integer.parseInt(holidays.get(k).substring(0,2)) + " - "
                    + holidays.get(k).substring(8));    
            }          
        }
        else
        {
            for (int k =0; k < labels2.length; k++)
            {
                labels2[k].setForeground(Color.red);
                labels2[k].setFont(myFont2); 
                labels2[k].setText(" "); 
            }
            
            labels2[13].setText(String.valueOf(work_holidays[0]));
            
            for (int k =0; k < Math.min(holidays.size(),13); k++)
            {
                labels2[k].setText(get_Month(Integer.parseInt(holidays.get(k).substring(2,4)))
                    + " " + Integer.parseInt(holidays.get(k).substring(0,2)) + " - "
                    + holidays.get(k).substring(8));    
            }          
        }
        
    }
    
    public static String[] create_date(String s)
    {
        String date1 = "", date2 = "", mo = "", year = " ";
        int [] t = {31,28,31,30,31,30,31,31,30,31,30,31};
        int d = 0;
        String[] S = new String[4];
        if (s.length()==8)
        {
            d = Integer.parseInt(s.substring(0,2));
            mo = s.substring(2,4);
            year = s.substring(4);
        }
        else if(s.length()==6)
        { 
            mo = s.substring(0,2);
            year = s.substring(2); 
        }        
        date1 = "01" + mo + year; 
        if (Integer.parseInt(year)%4==0)
        {
            if ((Integer.parseInt(year)%100!=0) | (Integer.parseInt(year)%100==0 & Integer.parseInt(year)%400==0))
            {
                t[1] = 29;
            }
        }
        
        date2 = String.format("%02d",t[Integer.parseInt(mo)-1]) + mo + year;                
        S[0]=date1;
        S[1]=date2;
        S[2]= mo;
        S[3]= String.format("%02d", d);
        
        return S;
    }
    
    public static void display_Images() throws InterruptedException {
        Random generator = new Random();
        String[] images = {"BBS.jpg", "UniCredit.jpg", "BU.jpg",  "BBS.png", "UniCredit2.jpg", "BU2.jpg"};
        JLabel[] labels = {EternalCalendarItaly.jLabel12, EternalCalendarItaly.jLabel33, EternalCalendarItaly.jLabel34};
        int num = generator.nextInt(images.length);
        while (true) {
            ImageIcon icon = new ImageIcon(EternalCalendarItaly.class.getResource(images[num]));
            Image icon1 = icon.getImage();
            for (int k = 0; k < labels.length; k++) {
                Image icon2 = getScaledImage(icon1, labels[k].getWidth(), labels[k].getHeight());
                labels[k].setIcon(new ImageIcon(icon2));

            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                for (int k = 0; k < labels.length; k++) {
                    labels[k].setText("Interrupted!");
                }

            }
            num = (num + 1) % images.length;
        }
    }    
    
    public static Image getScaledImage(Image srcImg, int w, int h)
    {
        BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);        
        Graphics2D g2 = buffImg.createGraphics();        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);       
        g2.drawImage(srcImg, 0, 0, w, h, null);                     
        return buffImg;       
    } 
    
    SwingWorker worker = new SwingWorkerImpl();

    private static class SwingWorkerImpl extends SwingWorker<String, Object> 
    {

        public SwingWorkerImpl()
        {
            
        }
        
        protected String doInBackground() throws Exception
        {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
}




