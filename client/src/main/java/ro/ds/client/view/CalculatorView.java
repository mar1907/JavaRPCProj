package ro.ds.client.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textYear;
	private JTextField textEngineSize;
	private JTextField textPrice;
	private JButton btnTax;
    private JButton btnPrice;
    private JTextField textTax;
    private JTextField textSellingPrice;

    public CalculatorView() {
		setTitle("Car calculator");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(300, 100, 564, 208);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertNewStudent = new JLabel("Car");
		lblInsertNewStudent.setBounds(10, 11, 120, 14);
		contentPane.add(lblInsertNewStudent);

		JLabel lblFirstname = new JLabel("Fabrication year");
		lblFirstname.setBounds(10, 36, 120, 14);
		contentPane.add(lblFirstname);

		JLabel lblLastname = new JLabel("Engine size");
		lblLastname.setBounds(10, 61, 120, 14);
		contentPane.add(lblLastname);

		JLabel lblMail = new JLabel("Purchasing price");
		lblMail.setBounds(10, 86, 120, 14);
		contentPane.add(lblMail);

		textYear = new JTextField();
		textYear.setBounds(139, 33, 120, 20);
		contentPane.add(textYear);
		textYear.setColumns(10);

		textEngineSize = new JTextField();
		textEngineSize.setBounds(139, 58, 120, 20);
		contentPane.add(textEngineSize);
		textEngineSize.setColumns(10);

		textPrice = new JTextField();
		textPrice.setBounds(139, 83, 120, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);

		btnTax = new JButton("Compute tax");
		btnTax.setBounds(10, 113, 120, 23);
		contentPane.add(btnTax);
		
		btnPrice = new JButton("Selling price");
		btnPrice.setBounds(139, 112, 120, 25);
		contentPane.add(btnPrice);
		
		JLabel lblNewLabel = new JLabel("Tax");
		lblNewLabel.setBounds(320, 35, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selling price");
		lblNewLabel_1.setBounds(320, 60, 81, 16);
		contentPane.add(lblNewLabel_1);

        textTax = new JTextField();
		textTax.setEditable(false);
		textTax.setBounds(413, 32, 116, 22);
		contentPane.add(textTax);
		textTax.setColumns(10);

        textSellingPrice = new JTextField();
		textSellingPrice.setEditable(false);
		textSellingPrice.setBounds(413, 57, 116, 22);
		contentPane.add(textSellingPrice);
		textSellingPrice.setColumns(10);
	}

	public void addBtnPriceActionListener(ActionListener e) {
		btnPrice.addActionListener(e);
	}

	public void addBtnTaxActionListener(ActionListener e) {
		btnTax.addActionListener(e);
	}

	public String getYear() {
		return textYear.getText();
	}

	public String getEngineSize() {
		return textEngineSize.getText();
	}

	public String getPurchasingPrice() {
		return textPrice.getText();
	}

	public void clearInput() {
		textYear.setText("");
		textEngineSize.setText("");
		textPrice.setText("");
	}

	public void clearOutput() {
        textTax.setText("");
        textSellingPrice.setText("");
    }

    public void setTax(double tax) {
        textTax.setText(tax + "");
    }

    public void setSellingPrice(double sellingPrice) {
        textSellingPrice.setText(sellingPrice + "");
    }
}
