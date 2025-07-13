package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 800;

    int r = 0;
    int c = 0;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel optionPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    JButton restart = new JButton();
    JButton checkScore = new JButton();

    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    int playerXScore = 0;
    int playerOScore = 0;
    int turn = 0;
    boolean gameOver = false;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel, BorderLayout.CENTER);

        optionPanel.setLayout(new GridLayout(1,2));
        optionPanel.setBackground(Color.black);
        optionPanel.setPreferredSize(new Dimension(600, 50));
        frame.add(optionPanel, BorderLayout.SOUTH);

        restart.setBackground(Color.black);
        restart.setForeground(Color.white);
        restart.setFont(new Font("Arial",Font.PLAIN, 15));
        restart.setText("Restart");
        restart.setFocusable(false);

        checkScore.setBackground(Color.black);
        checkScore.setForeground(Color.white);
        checkScore.setFont(new Font("Arial",Font.PLAIN, 15));
        checkScore.setText("Check the score");
        checkScore.setFocusable(false);

        optionPanel.add(restart);
        optionPanel.add(checkScore);

        for (r = 0; r < 3 ; r++) {
            for(c = 0; c < 3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial",Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener( e -> {
                        JButton tile1 = (JButton) e.getSource();
                        if (gameOver) return;

                        if (tile1.getText().isEmpty()) {
                            tile1.setText(currentPlayer);
                            turn++;
                            checkWinner();
                            if (textLabel.getText().equals("Player " + currentPlayer + " won!!")) {
                                updateScore();
                                gameOver = true;
                            }
                        }
                        else
                            return;

                        if (currentPlayer.equals(playerX))
                            currentPlayer = playerO;
                        else
                            currentPlayer = playerX;
                    }
                );
            }
        }
        restart.addActionListener( e -> {
                currentPlayer = playerX;
                turn = 0;
                gameOver = false;
                textLabel.setFont(new Font("Arial", Font.BOLD,50));
                textLabel.setText("Tic-Tac-Toe");
                resetTheBoard();
        });

        checkScore.addActionListener( e ->{
            textLabel.setFont(new Font("Arial", Font.BOLD,30));
            textLabel.setText("Player X = " +playerXScore + "              Player O = " + playerOScore);
        });
    }

    public void checkWinner(){

        if (!board[0][0].getText().isEmpty() && board[0][0].getText().equals(board[0][1].getText()) && board[0][0].getText().equals(board[0][2].getText())) {
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (c = 0; c < 3; c++) {
                board[0][c].setBackground(Color.lightGray);
                board[0][c].setForeground(Color.green);
            }
        }

        else if (!board[1][0].getText().isEmpty() && board[1][0].getText().equals(board[1][1].getText()) && board[1][0].getText().equals(board[1][2].getText())) {
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (c = 0; c < 3; c++) {
                board[1][c].setBackground(Color.lightGray);
                board[1][c].setForeground(Color.green);
            }
        }

        else if (!board[2][0].getText().isEmpty() && board[2][0].getText().equals(board[2][1].getText()) && board[2][0].getText().equals(board[2][2].getText())) {
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (c = 0; c < 3; c++) {
                board[2][c].setBackground(Color.lightGray);
                board[2][c].setForeground(Color.green);
            }
        }

        else if (!board[0][0].getText().isEmpty() && board[0][0].getText().equals(board[1][0].getText()) && board[0][0].getText().equals(board[2][0].getText())) {
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (r = 0; r < 3; r++) {
                board[r][0].setBackground(Color.lightGray);
                board[r][0].setForeground(Color.green);
            }
        }

        else if (!board[0][1].getText().isEmpty() && board[0][1].getText().equals(board[1][1].getText()) && board[0][1].getText().equals(board[2][1].getText())){
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (r = 0; r < 3; r++) {
                board[r][1].setBackground(Color.lightGray);
                board[r][1].setForeground(Color.green);
            }
        }

        else if (!board[0][2].getText().isEmpty() && board[0][2].getText().equals(board[1][2].getText()) && board[0][2].getText().equals(board[2][2].getText())){
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (r = 0; r < 3; r++) {
                board[r][2].setBackground(Color.lightGray);
                board[r][2].setForeground(Color.green);
            }
        }

        else if (!board[0][0].getText().isEmpty() && board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText())){
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (r = 0; r < 3; r++) {
                    board[r][r].setBackground(Color.lightGray);
                    board[r][r].setForeground(Color.green);
            }
        }

        else if (!board[2][0].getText().isEmpty() && board[2][0].getText().equals(board[1][1].getText()) && board[2][0].getText().equals(board[0][2].getText())){
            textLabel.setText("Player " + currentPlayer + " won!!");
            for (r = 0; r < 3; r++) {
                board[2 - r][r].setBackground(Color.lightGray);
                board[2 - r][r].setForeground(Color.green);
            }
        }

        else if (turn == 9) {
            textLabel.setText("It's a tie!!");
            for ( r = 0; r < 3 ; r++) {
                for ( c = 0; c < 3; c++) {
                    board[r][c].setBackground(Color.black);
                    board[r][c].setForeground(Color.yellow);

                }
            }
        }
    }

    public void resetTheBoard() {

        for ( r = 0; r < 3 ; r++) {
            for (c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setBackground(Color.darkGray);
                board[r][c].setForeground(Color.white);
            }
        }
    }

    public void updateScore(){

        if (currentPlayer.equals(playerX))
            playerXScore++;
        else if (currentPlayer.equals(playerO))
            playerOScore++;
    }
}
