import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlotPoints extends JPanel {

    private int[][] points;

    public PlotPoints(int[][] points) {
        this.points = points;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        for (int[] point : points) {
            g.fillOval(point[0], point[1], 4, 4);
        }
    }

    public static void main(String[] args) {
        int[][] points = {{50, 50}, {100, 100}, {150, 150}, {200, 50}};
        PlotPoints plot = new PlotPoints(points);

        JFrame frame = new JFrame();
        frame.setTitle("Plot Points");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(plot);
        frame.setVisible(true);
    }
}

