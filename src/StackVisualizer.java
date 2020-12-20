import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StackVisualizer implements Runnable {
    private final JFrame frame;
    private final JPanel myCanvas;
    private final JTextField NumberTextField;
    private MyStack stack;

    public class MyCanvasPanel extends JPanel {

        public MyCanvasPanel() {
        }

        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            int h = 0;

            if (stack == null) {
                h = (this.getHeight() - 25);
                g.drawString("Minimum# in Stack: ", 3 * this.getWidth() / 4 - 70, 20);

                g.drawString("MinStack:", 3 * this.getWidth() / 4 - 70, this.getHeight() - 10);
                g.drawRect(this.getWidth() / 4, h, 100, 20);
                g.drawString("null", this.getWidth() / 4 + 10, h + 15);
                g.drawLine(this.getWidth() / 4 + 50, h, this.getWidth() / 4 + 50, h - 10);


                g.drawString("Stack:", this.getWidth() / 4 - 50, this.getHeight() - 10);
                g.drawRect(3 * this.getWidth() / 4, h, 100, 20);
                g.drawString("null", 3 * this.getWidth() / 4 + 10, h + 15);
                g.drawLine(3 * this.getWidth() / 4 + 50, h, 3 * this.getWidth() / 4 + 50, h - 10);
            } else {

                int[] arrayStack = stack.getStackArray();
                int[] arrayMinStack = stack.getMinStackArray();

                g.drawString("Minimum# in Stack: " + stack.min, 3 * this.getWidth() / 4 - 70, 20);

                g.drawString("Stack:", this.getWidth() / 4 - 50, this.getHeight() - 10);
                if (stack.size >= 1) {
                    for (int i = 0; i < stack.size; i++) {
                        h = (this.getHeight() - 25) - (i * 20) - (i * 10);
                        g.drawRect(this.getWidth() / 4, h, 100, 20);
                        g.drawString(String.valueOf(arrayStack[i]), this.getWidth() / 4 + 10, h + 15);
                        g.drawLine(this.getWidth() / 4 + 50, h, this.getWidth() / 4 + 50, h - 10);
                    }
                }


                g.drawString("MinStack:", 3 * this.getWidth() / 4 - 70, this.getHeight() - 10);
                if (stack.minStackSize >= 1) {
                    for (int i = 0; i < stack.minStackSize; i++) {
                        h = (this.getHeight() - 25) - (i * 20) - (i * 10);
                        g.drawRect(3 * this.getWidth() / 4, h, 100, 20);
                        g.drawString(String.valueOf(arrayMinStack[i]), 3 * this.getWidth() / 4 + 10, h + 15);
                        g.drawLine(3 * this.getWidth() / 4 + 50, h, 3 * this.getWidth() / 4 + 50, h - 10);
                    }
                }
            }
        }

    }

    private class TogglePushAction extends AbstractAction {

        private static final long serialVersionUID = 1L;

        private TogglePushAction(final String name) {
            super(name);
        }

        @Override
        public void actionPerformed(final ActionEvent e) {
            if (stack == null){
                stack = new MyStack();
                myCanvas.repaint();
            }

            stack.push(Integer.parseInt(NumberTextField.getText()));

            myCanvas.repaint();
        }

    }

    private class TogglePopAction extends AbstractAction {

        private static final long serialVersionUID = 1L;

        private TogglePopAction(final String name) {
            super(name);
        }

        @Override
        public void actionPerformed(final ActionEvent e) {

            if (stack.size == 1){
                stack = null;
            }
            else if (stack.head != null) stack.pop();

            myCanvas.repaint();
        }

    }

    public StackVisualizer() {
        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame = new JFrame();
        frame.setTitle("Trivial paintComponent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myCanvas = new MyCanvasPanel();

        frame.add(myCanvas, BorderLayout.CENTER);

        frame.add(btnPnl, BorderLayout.SOUTH);
        JButton pushButton = new JButton(new TogglePushAction("Push"));
        JButton popButton = new JButton(new TogglePopAction("Pop"));
        NumberTextField = new JTextField(8);

        btnPnl.add(pushButton);
        btnPnl.add(popButton);
        btnPnl.add(NumberTextField);

    }

    @Override
    public void run() {
        frame.setBounds(16, 16, 640, 480);
        frame.setVisible(true);
    }

    public static void main(final String[] args) throws Exception {
        final StackVisualizer application = new StackVisualizer();
        application.run();
    }
}