import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlotPointsFromCSV extends JPanel {

    private int[][] points;

    public PlotPointsFromCSV(String csvFile) {
        this.points = readCSV(csvFile);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        for (int[] point : points) {
            g.fillOval(point[0], point[1], 5, 5);
        }
    }

    private int[][] readCSV(String csvFile) {
        List<int[]> data = new ArrayList<>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // skip the header row
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                int x = (int)(Float.parseFloat(values[0]) * 100);
                int y = (int)(Float.parseFloat(values[1]) * 100);
                data.add(new int[] {x, y});
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        PlotPointsFromCSV plot = new PlotPointsFromCSV("iris.csv");

        JFrame frame = new JFrame();
        frame.setTitle("Plot Points");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(plot);
        frame.setVisible(true);
    }
}
