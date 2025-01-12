package UI;

import com.sun.nio.sctp.SendFailedNotification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAtmUI {
    char uniChar = '\u20A6';
    JFrame Frame = new JFrame("window");
    JLabel Pin = new JLabel(" Enter Your Pin:");
    JTextField PinField = new JTextField();
    JButton Login = new JButton("Validate");

    public void mainUI() {
        Frame.setSize(450, 300);
        Frame.setLayout(new GridLayout(2, 2));
        Frame.setVisible(true);
        Frame.setLocationRelativeTo(null);
        Frame.setTitle("Applex Bank Of Nigeria");

        Frame.add(Pin);
        Frame.add(PinField);
        Frame.add(Login);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float userID = (Float.parseFloat(PinField.getText()));
                if (userID == 5555) {
                    accountTypeUI();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid User Pin, Please Try again");
                }
            }
        });

    }

    JFrame Frame2 = new JFrame("window");

    JButton accountTypeSavings = new JButton("Savings Account");
    JButton accountTypeCurrent = new JButton("Current Account");

    public void accountTypeUI() {
        Frame2.setSize(450, 500);
        Frame2.setLayout(new GridLayout(2, 1));
        Frame2.setVisible(true);
        Frame2.setLocationRelativeTo(null);
        Frame2.setTitle("Account Type");

        Frame2.add(accountTypeSavings);
        Frame2.add(accountTypeCurrent);
        Frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        accountTypeSavings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savingsUI();
            }
        });
       accountTypeCurrent.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                currentUI();
            }
        });
    }
    JFrame FrameSavings = new JFrame("window");
    JLabel Balance = new JLabel("Available Balance: "+uniChar+"100000");
    JButton depositSavings = new JButton("Deposit");
    JButton withdrawSavings = new JButton("Withdraw");

    public void savingsUI() {
        FrameSavings.setSize(450, 500);
        FrameSavings.setLayout(new GridLayout(3, 1));
        FrameSavings.setVisible(true);
        FrameSavings.setLocationRelativeTo(null);
        FrameSavings.setTitle("Applex | Account: Savings");

        FrameSavings.add(Balance);
        FrameSavings.add(depositSavings);
        FrameSavings.add(withdrawSavings);
        FrameSavings.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        depositSavings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositSavingsUI();
            }
        });
        withdrawSavings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawSavingsUI();
            }
        });
    }
    JFrame FrameDepositSave = new JFrame("window");
    JButton DepositSave = new JButton("Deposit");
    JLabel AmountDepSave = new JLabel( " Enter Deposit Amount:");
    JTextField AmountFieldDepSave = new JTextField();

    public void depositSavingsUI(){
        FrameDepositSave.setSize(450, 500);
        FrameDepositSave.setLayout(new GridLayout(3, 1));
        FrameDepositSave.setVisible(true);
        FrameDepositSave.setLocationRelativeTo(null);
        FrameDepositSave.setTitle("Applex | Account : Deposit");

        FrameDepositSave.add(AmountDepSave);
        FrameDepositSave.add(AmountFieldDepSave);
        FrameDepositSave.add(DepositSave);
        FrameDepositSave.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DepositSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankAtm assObj = new BankAtm();
                float answer = assObj.balance1(Float.parseFloat(AmountFieldDepSave.getText()));
                JOptionPane.showMessageDialog(null, "You new balance " +uniChar+answer);
            }
        });
    }

    JFrame FrameWithdrawSave = new JFrame("window");
    JButton WithdrawSave = new JButton("Withdraw");
    JLabel AmountWithSave = new JLabel(" Enter Withdrawal Amount:");
    JTextField AmountFieldWithSave = new JTextField();

    public void withdrawSavingsUI() {
        FrameWithdrawSave.setSize(450, 500);
        FrameWithdrawSave.setLayout(new GridLayout(3, 1));
        FrameWithdrawSave.setVisible(true);
        FrameWithdrawSave.setLocationRelativeTo(null);
        FrameWithdrawSave.setTitle("Applex | Account:Withdrawal");

        FrameWithdrawSave.add(AmountWithSave);
        FrameWithdrawSave.add(AmountFieldWithSave);
        FrameWithdrawSave.add(WithdrawSave);
        FrameWithdrawSave.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        WithdrawSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankAtm assObj = new BankAtm();
                float WithdrawSave = (Float.parseFloat(AmountFieldWithSave.getText()));
                float solution = assObj.withdrawalBalance(Float.parseFloat(AmountFieldWithSave.getText()));
                if (WithdrawSave > 30000) {
                    JOptionPane.showMessageDialog(null, "You have Exceeded Your Withdrawal limit, Your limit is:" + uniChar + "20000");
                } else {
                    JOptionPane.showMessageDialog(null, "User Balance " + uniChar + solution +
                            "\nThanks For Using Applex Bank");
                    savingsUI();
                }
            }
        });
    }

