package projetGMAO2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface2 extends JPanel {

    private JFrame parentFrame;
    private JLabel labelImage;
    private ImageIcon icon;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    Interface2 panel = new Interface2(frame);
                    frame.setContentPane(panel);
                    frame.setBounds(100, 100, 800, 600);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interface2(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());

        // Load the image
        icon = new ImageIcon(getClass().getResource("/Images/télécharger.jpeg"));
        if (icon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
            System.out.println("Error loading image. Check the path.");
            return;
        }

        // Add the JLabel for the image
        labelImage = new JLabel(icon);
        labelImage.setHorizontalAlignment(JLabel.CENTER);
        labelImage.setVerticalAlignment(JLabel.CENTER);
        this.add(labelImage, BorderLayout.CENTER);

        // Add component listener to resize image when the panel is resized
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > 0 && getHeight() > 0) {
                    resizeImage();
                }
            }
        });
    }

    private void resizeImage() {
        Dimension size = this.getSize();
        Image image = icon.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        labelImage.setIcon(new ImageIcon(image));
        labelImage.setSize(size);
    }

    private void switchPanel(JPanel panel) {
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(panel);
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    public void setVisible(boolean visible) {
        parentFrame.setVisible(visible);
    }
}
