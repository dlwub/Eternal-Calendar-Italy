
package eternalcalendaritaly;
import static eternalcalendaritaly.EternalItalyFunction.count_date;
import static eternalcalendaritaly.EternalItalyFunction.create_date;
import static eternalcalendaritaly.EternalItalyFunction.get_CurrentDate;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class EternalCalendarItaly extends JFrame {
    
    private GroupLayout jPanel1Layout, jPanel2Layout, jPanel3Layout;     
    private JPanel jPanel1, jPanel2, jPanel3;    
    private JTabbedPane jTabbedPane; 
    private JTextArea jTextArea;
    private JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    private JCheckBox jCheckBox1, jCheckBox2;
    public static JButton jButton1, jButton2, jButton3, jButton4, jButton5, 
            jButton6, jButton7, jButton8, jButton9, jButton10, jButton11, 
            jButton12, jButton13, jButton14, jButton15, jButton16, jButton17,
            jButton18, jButton19, jButton20, jButton21, jButton22, jButton23, 
            jButton24, jButton25, jButton26, jButton27, jButton28, jButton29,
            jButton30, jButton31, jButton32, jButton33, jButton34, jButton35, 
            jButton36, jButton37, jButton38, jButton39, jButton40, jButton41,
            jButton42, jButton43, jButton44, jButton45;   
    public static JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, 
            jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13,
            jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20,
            jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27,
            jLabel28, jLabel29, jLabel30, jLabel31, jLabel32, jLabel33, jLabel34;
    
   
    public EternalCalendarItaly()
    {
        super( "Calendario Eterno l'Italia" );        
        Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
        Font myFont1 = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 16);
        super.setFont(myFont);
        jTabbedPane = new JTabbedPane();        
        jPanel1 = new JPanel();        
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jTextArea = new JTextArea("\nCalendario Eterno l'Italia consente di vedere il mese corrente o qualsiasi mese in \nun anno tra "
                + "il 0001 e il 9999, l'elenco delle feste e numero di giorni lavorativi del\nmese. Per visualizzare mese corrente, "
                + "aprendo il programma è sufficiente. \nPer vedere qualsiasi altro mese in un anno, inserire nel box intitolato 'aaaa' "
                + "l'anno\n(4 cifre) e nella casella titolo 'mm' del mese (2 cifre) nella prima pagina. Quindi \npremere il tasto titolo 'Mostra'.\n\n" 
                + "       Eternal Calendar Italia permette anche di vedere l'elenco delle feste e numero\ndi giorni lavorativi tra due giorni. "
                + "Per fare ciò, inserire la data di inizio e la data di\nfine, rispettivamente, nelle due caselle nella seconda pagina"
                + " (intitolato \"Lista delle\nfeste\"). Allora o controllare la casella dal titolo \"Vacanze\" o la casella "
                + "\"Numero di\ngiorni di lavoro\".\n\n\n\t         Developed by: D.L.W\n\t\u00a9Copyright 2016•All Rights Reserved");
        jTextArea.setEditable(false);
        jTextArea.setFont(myFont);        
        jTextField1 = new JTextField(); 
        jTextField1.setFont(myFont);
        jTextField2 = new JTextField();
        jTextField2.setFont(myFont);
        jTextField3 = new JTextField();
        jTextField3.setToolTipText("8 cifre(ggmmaaaa)");
        jTextField3.setFont(myFont);
        UIManager.put("ToolTip.font", myFont);        
        jTextField4 = new JTextField();
        jTextField4.setToolTipText("8 cifre(ggmmaaaa)");
        jTextField4.setFont(myFont);
        CheckBoxHandler handler = new CheckBoxHandler();
        jButton1 = new JButton("Mostra");
        jButton1.setFont(myFont);
        jButton1.addActionListener(
                new ActionListener() 
                {
                    public void actionPerformed( ActionEvent event)
                    {
                        try {
                            int mo = Integer.parseInt(jTextField1.getText());
                            int year = Integer.parseInt(jTextField2.getText());
                            if (((1 <=mo)&&(mo<=12))&&((1<=year)&&(year<=9999)))
                            {
                                String date = EternalItalyFunction.get_CurrentDate();                                
                                if ((Integer.parseInt(date.substring(2,4))==mo)&&
                                        (Integer.parseInt(date.substring(4))==year))
                                {
                                    EternalItalyFunction.display_Month(date);                                    
                                }
                                else
                                {
                                    EternalItalyFunction.display_Month(String.format("%02d",mo)+String.format("%04d",year));                                    
                                }
                                    
                            }
                        } 
                        catch(NumberFormatException e)
                        {
                            UIManager.put("OptionPane.messageFont", myFont1);
                            JOptionPane.showMessageDialog(null,"Si prega di inserire di nuovo!", "Messaggio!", JOptionPane.WARNING_MESSAGE);                            
                        } 
                    }
                }
                    );
        jButton2 = new JButton("Dom");        
        jButton2.setFont(myFont1);
        jButton2.setOpaque(true);
        jButton2.setBackground(Color.blue);
        jButton3 = new JButton("Lun");
        jButton3.setFont(myFont1);
        jButton3.setOpaque(true);
        jButton3.setBackground(Color.blue);
        jButton4 = new JButton("Mar");
        jButton4.setFont(myFont1);
        jButton4.setOpaque(true);
        jButton4.setBackground(Color.blue);
        jButton5 = new JButton("Mer");
        jButton5.setFont(myFont1);
        jButton5.setOpaque(true);
        jButton5.setBackground(Color.blue);
        jButton6 = new JButton("Gio");
        jButton6.setFont(myFont1);
        jButton6.setOpaque(true);
        jButton6.setBackground(Color.blue);
        jButton7 = new JButton("Ven");
        jButton7.setFont(myFont1);
        jButton7.setOpaque(true);
        jButton7.setBackground(Color.blue);
        jButton8 = new JButton("Sab");
        jButton8.setFont(myFont1);
        jButton8.setOpaque(true);
        jButton8.setBackground(Color.blue);
        jButton9 = new JButton();        
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jButton14 = new JButton();
        jButton15 = new JButton();
        jButton16 = new JButton();
        jButton17 = new JButton();
        jButton18 = new JButton();
        jButton19 = new JButton();
        jButton20 = new JButton();
        jButton21 = new JButton();
        jButton22 = new JButton();
        jButton23 = new JButton();
        jButton24 = new JButton();
        jButton25 = new JButton();
        jButton26 = new JButton();
        jButton27 = new JButton();
        jButton28 = new JButton();
        jButton29 = new JButton();
        jButton30 = new JButton();
        jButton31 = new JButton();
        jButton32 = new JButton();
        jButton33 = new JButton();
        jButton34 = new JButton();
        jButton35 = new JButton();
        jButton36 = new JButton();
        jButton37 = new JButton();
        jButton38 = new JButton();
        jButton39 = new JButton();
        jButton40 = new JButton();
        jButton41 = new JButton();
        jButton42 = new JButton();
        jButton43 = new JButton();
        jButton44 = new JButton();
        jButton45 = new JButton();
        jCheckBox1 = new JCheckBox("Vacanze");
        jCheckBox1.setFont(myFont);
        jCheckBox1.addItemListener( handler );        
        jCheckBox2 = new JCheckBox("Numero di giorni di lavoro");
        jCheckBox2.setFont(myFont); 
        jCheckBox2.addItemListener( handler );        
        jLabel1 = new JLabel("mm", SwingConstants.CENTER);
        jLabel1.setFont(myFont);
        jLabel2 = new JLabel("aaaa", SwingConstants.CENTER);
        jLabel2.setFont(myFont);
        jLabel3 = new JLabel();        
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();       
        jLabel10 = new JLabel();           
        jLabel11 = new JLabel();        
        jLabel12 = new JLabel(); 
        jLabel13 = new JLabel("ggmmaaaa", SwingConstants.RIGHT);
        jLabel13.setFont(myFont);
        jLabel14 = new JLabel("ggmmaaaa", SwingConstants.CENTER);
        jLabel14.setFont(myFont);
        jLabel15 = new JLabel("Tra", SwingConstants.RIGHT);
        jLabel15.setFont(myFont);
        jLabel16 = new JLabel("e",SwingConstants.CENTER);
        jLabel16.setFont(myFont);
        jLabel17 = new JLabel("");
        jLabel17.setFont(myFont);
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        jLabel28 = new JLabel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jPanel1Layout = new GroupLayout(jPanel1);
        jPanel2Layout = new GroupLayout(jPanel2);
        jPanel3Layout = new GroupLayout(jPanel3);
        jPanel1.setLayout(jPanel1Layout); 
        jPanel2.setLayout(jPanel2Layout);
        jPanel3.setLayout(jPanel3Layout);
        jPanel1Layout.setAutoCreateGaps(false);
        jPanel1Layout.setAutoCreateContainerGaps(false);
        jPanel2Layout.setAutoCreateGaps(true);
        jPanel2Layout.setAutoCreateContainerGaps(true);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3,GroupLayout.PREFERRED_SIZE, 220,GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4)
                                        .addComponent(jButton5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addComponent(jButton10)
                                        .addComponent(jButton11)
                                        .addComponent(jButton12))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton16)
                                        .addComponent(jButton17)
                                        .addComponent(jButton18)
                                        .addComponent(jButton19))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton23)
                                        .addComponent(jButton24)
                                        .addComponent(jButton25)
                                        .addComponent(jButton26))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton30)
                                        .addComponent(jButton31)
                                        .addComponent(jButton32)
                                        .addComponent(jButton33))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton37)
                                        .addComponent(jButton38)
                                        .addComponent(jButton39)
                                        .addComponent(jButton40))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton44)
                                        .addComponent(jButton45))
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jLabel1, jLabel2, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2,GroupLayout.PREFERRED_SIZE, 50,GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField1, jTextField2, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2,GroupLayout.PREFERRED_SIZE, 50,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField2, jButton1, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jButton8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton13)
                                .addComponent(jButton14)
                                .addComponent(jButton15))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton20)
                                .addComponent(jButton21)
                                .addComponent(jButton22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton27)
                                .addComponent(jButton28)
                                .addComponent(jButton29))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton34)
                                .addComponent(jButton35)
                                .addComponent(jButton36))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton41)
                                .addComponent(jButton42)
                                .addComponent(jButton43))
                        .addComponent(jLabel12,GroupLayout.PREFERRED_SIZE, 245,GroupLayout.PREFERRED_SIZE))
                
        );
        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL,jButton1, jButton2, jButton3, jButton4, jButton5,
                jButton6, jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13, 
                jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton20, jButton21,
                jButton22, jButton23, jButton24, jButton25, jButton26, jButton27, jButton28, jButton29,
                jButton30, jButton31, jButton32, jButton33, jButton34, jButton35, jButton36, jButton37,
                jButton38, jButton39, jButton40, jButton41, jButton42, jButton43, jButton44, jButton45);
        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL,jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8,
                jLabel9, jLabel10, jLabel11);                
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jButton1,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(jTextField1, jLabel3, LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(jLabel3,jButton2,LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2,GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                                .addComponent(jButton5)
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jButton8))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton9)
                                .addComponent(jButton10)
                                .addComponent(jButton11)
                                .addComponent(jButton12)
                                .addComponent(jButton13)
                                .addComponent(jButton14)
                                .addComponent(jButton15))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton16)
                                .addComponent(jButton17)
                                .addComponent(jButton18)
                                .addComponent(jButton19)
                                .addComponent(jButton20)
                                .addComponent(jButton21)
                                .addComponent(jButton22))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton23)
                                .addComponent(jButton24)
                                .addComponent(jButton25)
                                .addComponent(jButton26)
                                .addComponent(jButton27)
                                .addComponent(jButton28)
                                .addComponent(jButton29))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton30)
                                .addComponent(jButton31)
                                .addComponent(jButton32)
                                .addComponent(jButton33)
                                .addComponent(jButton34)
                                .addComponent(jButton35)
                                .addComponent(jButton36))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton37)
                                .addComponent(jButton38)
                                .addComponent(jButton39)
                                .addComponent(jButton40)
                                .addComponent(jButton41)
                                .addComponent(jButton42)
                                .addComponent(jButton43))
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton44)
                                .addComponent(jButton45))
                        .addPreferredGap(jButton44,jLabel4,LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(jLabel4,jLabel5,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(jLabel5,jLabel6,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(jLabel6,jLabel7,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(jLabel7,jLabel8,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(jLabel8,jLabel9,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(jLabel9,jLabel10,LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(jLabel10,jLabel11,LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11))
                                .addComponent(jLabel12,GroupLayout.PREFERRED_SIZE, 200,GroupLayout.PREFERRED_SIZE))           
        );
        
        jPanel1Layout.linkSize(SwingConstants.VERTICAL, jButton2, jButton3, jButton4, jButton5,
                jButton6, jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13, 
                jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton20, jButton21,
                jButton22, jButton23, jButton24, jButton25, jButton26, jButton27, jButton28, jButton29,
                jButton30, jButton31, jButton32, jButton33, jButton34, jButton35, jButton36, jButton37,
                jButton38, jButton39, jButton40, jButton41, jButton42, jButton43, jButton44, jButton45);
        jPanel1Layout.linkSize(SwingConstants.VERTICAL,jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8,
                jLabel9, jLabel10, jLabel11); 
        
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createSequentialGroup()
                        .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13,GroupLayout.PREFERRED_SIZE, 170,GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15,GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3)
                                        .addComponent(jLabel16,GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE ))
                                .addComponent(jCheckBox1)                                
                                .addComponent(jLabel18,GroupLayout.PREFERRED_SIZE, 220,GroupLayout.PREFERRED_SIZE)                                
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30)
                                .addComponent(jLabel31)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox2)
                                        .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 50,GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup()
                                        .addComponent(jLabel14)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField4)
                                                .addComponent(jLabel17))
                                        .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 280,GroupLayout.PREFERRED_SIZE))
        );                        
                 
        jPanel2Layout.linkSize(SwingConstants.HORIZONTAL,jLabel13, jLabel14, jTextField3, jTextField4); 
        jPanel2Layout.linkSize(SwingConstants.HORIZONTAL,jLabel18, jLabel19, jLabel20, jLabel21, jLabel22,
                jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31); 
        
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3)
                                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4)
                                .addComponent(jLabel17))
                        .addComponent(jCheckBox1)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(jLabel18, jLabel19, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(jLabel19, jLabel20, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(jLabel20, jLabel21, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(jLabel21, jLabel22, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(jLabel22, jLabel23, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(jLabel23, jLabel24, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(jLabel24, jLabel25, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(jLabel25, jLabel26, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(jLabel26, jLabel27, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(jLabel27, jLabel28, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(jLabel28, jLabel29, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(jLabel28, jLabel30, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30)
                                        .addPreferredGap(jLabel30, jLabel31, LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel31))
                                .addComponent(jLabel33,GroupLayout.PREFERRED_SIZE, 400,GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jLabel32,GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE))
                        ); 
        
        jPanel2Layout.linkSize(SwingConstants.VERTICAL,jLabel18, jLabel19, jLabel20, jLabel21, jLabel22,
                jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31);
        
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createSequentialGroup()
                        .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jTextArea,GroupLayout.PREFERRED_SIZE, 580,GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34,GroupLayout.PREFERRED_SIZE, 580,GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createSequentialGroup()
                        .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextArea,GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(jTextArea, jLabel34, LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34,GroupLayout.PREFERRED_SIZE, 200,GroupLayout.PREFERRED_SIZE)
        ); 
        
        jTabbedPane.setFont(myFont);       
        jTabbedPane.addTab( "Calendario", null,jPanel1, "" );        
        jTabbedPane.addTab( "Lista delle feste", null, jPanel2, "" );
        jTabbedPane.addTab( "Spiegazione", null, jPanel3, "" );     
        add( jTabbedPane );
    } 
    private class CheckBoxHandler implements ItemListener
    {
        public void itemStateChanged( ItemEvent event )
        {
            if(jCheckBox1.isSelected() | jCheckBox2.isSelected())
            {
                try {                    
                    String d1 =jTextField3.getText();
                    String d2 =jTextField4.getText();
                    
                    if ((d1.length()==8)&&(d2.length()==8))
                    {
                        if(((1<=Integer.parseInt(d1.substring(0,2))&&Integer.parseInt(d1.substring(0,2))
                                <=EternalItalyFunction.days_of_month(d1,Integer.parseInt(d1.substring(2,4))-1))
                                &&(1<=Integer.parseInt(d1.substring(2,4))&&(Integer.parseInt(d1.substring(2,4))<=12))                                
                                &&(1<=Integer.parseInt(d1.substring(4))&& Integer.parseInt(d1.substring(4))<=9999))                                
                                &&(((1<=Integer.parseInt(d2.substring(0,2))&&Integer.parseInt(d2.substring(0,2))
                                <=EternalItalyFunction.days_of_month(d2,Integer.parseInt(d2.substring(2,4))-1))
                                &&(1<=Integer.parseInt(d2.substring(2,4))&&(Integer.parseInt(d2.substring(2,4))<=12)))
                                &&(1<=Integer.parseInt(d2.substring(4))&& Integer.parseInt(d2.substring(4))<=9999)))
                            if (EternalItalyFunction.count_date(d1)<=EternalItalyFunction.count_date(d2))
                                EternalItalyFunction.display_holidays(d1, d2, 1);
                    }
                } 
                catch(NumberFormatException e)
                {
                    Font myFont2 = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
                    UIManager.put("OptionPane.messageFont", myFont2);
                    JOptionPane.showMessageDialog(null,"Si prega di inserire di nuovo!", "Messaggio!", JOptionPane.WARNING_MESSAGE);  
                }
            }
        }
    }
    
}       




