import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter implements ActionListener {

    JFrame frame = new JFrame();
    JButton changebtn = new JButton("Convert");
    JButton resetButton = new JButton("Reset");
    JTextField fromtextfield = new JTextField();
    JLabel tolabelAnsFiller = new JLabel();
    JLabel fromlabel = new JLabel("From");
    JLabel tolabel = new JLabel("To");
    JLabel messageLabel = new JLabel();
    JMenuBar menuBar;
    JMenu fromMenu, toMenu;
    JMenuItem inrF, dhrF, inrT, dhrT, usdF, usdT, omrF, omrT, qarT, qarF;

    CurrencyConverter() {

        fromlabel.setBounds(50, 100, 75, 25);
        tolabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));

        fromtextfield.setBounds(125, 100, 200, 25);
        tolabelAnsFiller.setBounds(125, 150, 200, 25);

        changebtn.setBounds(125, 200, 100, 25);
        changebtn.setFocusable(false);
        changebtn.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        // ------ menubar------
        menuBar = new JMenuBar();
        fromMenu = new JMenu("From");
        toMenu = new JMenu("To");
        // AFTthis
        inrF = new JMenuItem("INR");
        inrF.addActionListener(this);
        fromMenu.add(inrF);
        inrT = new JMenuItem("INR");
        inrT.addActionListener(this);
        toMenu.add(inrT);

        dhrF = new JMenuItem("DHS");
        dhrF.addActionListener(this);
        fromMenu.add(dhrF);
        dhrT = new JMenuItem("DHS");
        dhrT.addActionListener(this);
        toMenu.add(dhrT);

        usdF = new JMenuItem("USD");
        usdF.addActionListener(this);
        fromMenu.add(usdF);
        usdT = new JMenuItem("USD");
        usdT.addActionListener(this);
        toMenu.add(usdT);

        omrF = new JMenuItem("OMR");
        omrF.addActionListener(this);
        fromMenu.add(omrF);
        omrT = new JMenuItem("OMR");
        omrT.addActionListener(this);
        toMenu.add(omrT);

        qarF = new JMenuItem("QAR");
        qarF.addActionListener(this);
        fromMenu.add(qarF);
        qarT = new JMenuItem("QAR");
        qarT.addActionListener(this);
        toMenu.add(qarT);

        // BFRthis
        menuBar.add(fromMenu);
        menuBar.add(toMenu);
        // ------ /menubar------
        frame.setJMenuBar(menuBar);
        frame.add(fromlabel);
        frame.add(tolabel);
        frame.add(messageLabel);
        frame.add(fromtextfield);
        frame.add(tolabelAnsFiller);
        frame.add(changebtn);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            fromtextfield.setText("");
            tolabelAnsFiller.setText("");
            fromlabel.setText("From");
            tolabel.setText("To");
        }

        if (e.getSource() == inrF) {
            fromlabel.setText("Rupees");
        }
        if (e.getSource() == inrT) {
            tolabel.setText("Rupees");
        }

        if (e.getSource() == dhrF) {
            fromlabel.setText("Dirham");
        }
        if (e.getSource() == dhrT) {
            tolabel.setText("Dirham");
        }

        if (e.getSource() == usdF) {
            fromlabel.setText("Dollar");
        }
        if (e.getSource() == usdT) {
            tolabel.setText("Dollar");
        }

        if (e.getSource() == omrF) {
            fromlabel.setText("Omani Rial");
        }
        if (e.getSource() == omrT) {
            tolabel.setText("Omani Rial");
        }

        if (e.getSource() == qarF) {
            fromlabel.setText("Qatar Rial");
        }
        if (e.getSource() == qarT) {
            tolabel.setText("Qatar Rial");
        }

        if (e.getSource() == changebtn) {
            String f = fromlabel.getText().toString();
            String t = tolabel.getText().toString();
            if (f == "From" || t == "To") {
                messageLabel.setText("Select Conversion From Menus");
            }
            int val = Integer.parseInt(fromtextfield.getText().toString());
            float con = 0;
            if (f == t) {
                con = val;
            } else if (f == "Dirham") {
                if (t == "Rupees") {
                    con = (float) (val * 20.25);
                } else if (t == "Dollar") {
                    con = (float) (val * 0.27);
                } else if (t == "Omani Rial") {
                    con = (float) (val * 195.00);
                } else if (t == "Qatar Rial") {
                    con = (float) (val * 20.00);
                }

            } else if (f == "Rupees") {
                if (t == "Dirham") {
                    con = (float) (val * 0.049);
                } else if (t == "Dollar") {
                    con = (float) (val * 0.013);
                } else if (t == "Omani Rial") {
                    con = (float) (val * 195.00);
                } else if (t == "Qatar Rial") {
                    con = (float) (val * 20.00);
                }
            } else if (f == "Dollar") {
                if (t == "Rupees") {
                    con = (float) (val * 74.40);
                } else if (t == "Dirham") {
                    con = (float) (val * 3.67);
                } else if (t == "Omani Rial") {
                    con = (float) (val * 195.00);
                } else if (t == "Qatar Rial") {
                    con = (float) (val * 20.00);
                }

            } else if (f == "Omani Rial") {
                if (t == "Rupees") {
                    con = (float) (val * 195);
                } else if (t == "Dirham") {
                    con = (float) (val * 3.67);
                } else if (t == "Dollar") {
                    con = (float) (val * 0.27);
                } else if (t == "Qatar Rial") {
                    con = (float) (val * 20.00);
                }

            } else if (f == "Qatar Rial") {
                if (t == "Rupees") {
                    con = (float) (val * 195);
                } else if (t == "Dirham") {
                    con = (float) (val * 3.67);
                } else if (t == "Dollar") {
                    con = (float) (val * 0.27);
                } else if (t == "Omani Rial") {
                    con = (float) (val * 195.00);
                }

            }
            tolabelAnsFiller.setText("" + con + "");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
