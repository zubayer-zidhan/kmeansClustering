import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlotPoints extends JPanel {

    private List<Record> records;

    public PlotPoints(List<Record> records) {
        this.records = records;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        
        for (Record record : records) {
            if (record.getClusterNumber() == 1) {
                g.setColor(Color.RED);
            } else if (record.getClusterNumber() == 2) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillOval((record.getIncome()*5)+300, (record.getScore()*5)+100, 5, 5);
        }
    }

    public void plotPoints(PlotPoints plot) {
        JFrame frame = new JFrame();
        frame.setTitle("Plot Points");
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(plot);
        frame.setVisible(true);
    }
}

