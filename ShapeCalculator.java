package assignment6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeCalculator extends JFrame implements ActionListener {

    private JPanel panelShape;
    private JPanel panelOperation;
    private JPanel panelInput;

    private JRadioButton rbCircle;
    private JRadioButton rbRectangle;
    private JRadioButton rbSquare;

    private JCheckBox cbArea;
    private JCheckBox cbPerimeter;
    private JCheckBox cbCircumference;

    private JLabel lblRadius, lblLength, lblWidth, lblSide, lblResult;

    private JTextField txtRadius, txtLength, txtWidth, txtSide, txtResult;

    private JButton btnCalculate, btnExit;

    public ShapeCalculator() {
        setTitle("Shape Calculator");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelShape = new JPanel();
        panelShape.setBorder(BorderFactory.createTitledBorder("Select Shape"));

        rbCircle = new JRadioButton("Circle");
        rbRectangle = new JRadioButton("Rectangle");
        rbSquare = new JRadioButton("Square");

        ButtonGroup group = new ButtonGroup();
        group.add(rbCircle);
        group.add(rbRectangle);
        group.add(rbSquare);

        panelShape.add(rbCircle);
        panelShape.add(rbRectangle);
        panelShape.add(rbSquare);

        panelOperation = new JPanel();
        panelOperation.setBorder(BorderFactory.createTitledBorder("Select Operation"));

        cbArea = new JCheckBox("Area");
        cbPerimeter = new JCheckBox("Perimeter");
        cbCircumference = new JCheckBox("Circumference");

        panelOperation.add(cbArea);
        panelOperation.add(cbPerimeter);
        panelOperation.add(cbCircumference);

        panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(6, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input"));

        lblRadius = new JLabel("Radius:");
        lblLength = new JLabel("Length:");
        lblWidth = new JLabel("Width:");
        lblSide = new JLabel("Side:");
        lblResult = new JLabel("Result:");

        txtRadius = new JTextField();
        txtLength = new JTextField();
        txtWidth = new JTextField();
        txtSide = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);

        btnCalculate = new JButton("Calculate");
        btnExit = new JButton("Exit");

        panelInput.add(lblRadius); panelInput.add(txtRadius);
        panelInput.add(lblLength); panelInput.add(txtLength);
        panelInput.add(lblWidth); panelInput.add(txtWidth);
        panelInput.add(lblSide); panelInput.add(txtSide);
        panelInput.add(lblResult); panelInput.add(txtResult);
        panelInput.add(btnCalculate); panelInput.add(btnExit);

        add(panelShape, BorderLayout.NORTH);
        add(panelOperation, BorderLayout.CENTER);
        add(panelInput, BorderLayout.SOUTH);

        hideAllFields();

        rbCircle.addActionListener(this);
        rbRectangle.addActionListener(this);
        rbSquare.addActionListener(this);
        btnCalculate.addActionListener(this);
        btnExit.addActionListener(this);
    }

    private void hideAllFields() {
        lblRadius.setVisible(false); txtRadius.setVisible(false);
        lblLength.setVisible(false); txtLength.setVisible(false);
        lblWidth.setVisible(false); txtWidth.setVisible(false);
        lblSide.setVisible(false); txtSide.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rbCircle) {
            hideAllFields();
            lblRadius.setVisible(true);
            txtRadius.setVisible(true);

            cbArea.setEnabled(true);
            cbCircumference.setEnabled(true);
            cbPerimeter.setEnabled(false);
        }

        if (e.getSource() == rbRectangle) {
            hideAllFields();
            lblLength.setVisible(true);
            txtLength.setVisible(true);
            lblWidth.setVisible(true);
            txtWidth.setVisible(true);

            cbArea.setEnabled(true);
            cbPerimeter.setEnabled(true);
            cbCircumference.setEnabled(false);
        }

        if (e.getSource() == rbSquare) {
            hideAllFields();
            lblSide.setVisible(true);
            txtSide.setVisible(true);

            cbArea.setEnabled(true);
            cbPerimeter.setEnabled(true);
            cbCircumference.setEnabled(false);
        }

        if (e.getSource() == btnCalculate) {

            double result = 0;

            try {

                if (rbCircle.isSelected()) {
                    double r = Double.parseDouble(txtRadius.getText());

                    if (cbArea.isSelected())
                        result = Math.PI * r * r;

                    if (cbCircumference.isSelected())
                        result = 2 * Math.PI * r;
                }

                if (rbRectangle.isSelected()) {
                    double l = Double.parseDouble(txtLength.getText());
                    double w = Double.parseDouble(txtWidth.getText());

                    if (cbArea.isSelected())
                        result = l * w;

                    if (cbPerimeter.isSelected())
                        result = 2 * (l + w);
                }

                if (rbSquare.isSelected()) {
                    double s = Double.parseDouble(txtSide.getText());

                    if (cbArea.isSelected())
                        result = s * s;

                    if (cbPerimeter.isSelected())
                        result = 4 * s;
                }

                txtResult.setText(String.valueOf(result));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                        "Please enter valid numeric values.");
            }
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ShapeCalculator frame = new ShapeCalculator();
        frame.setVisible(true);
    }
}