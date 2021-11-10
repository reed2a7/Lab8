import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel enterGuess;
  JLabel guessResponse;
  JLabel lastGuess;
  Random r;
  int randomNum;

  GuessingGame() {
    Random r = new Random();
    randomNum = r.nextInt(101);

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");
    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");
    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);
    enterGuess = new JLabel("Enter your guess: ");
    guessResponse = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(enterGuess);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(guessResponse);
    frame.add(lastGuess);
    frame.add(playAgainButton);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    int guess = Integer.parseInt(userGuess.getText());
    if (ae.getActionCommand().equals("Guess")) {
      if(guess < randomNum) {
        guessResponse.setText("Too low!");
      }
      else if (guess > randomNum){
        guessResponse.setText("Too high!");
      } 
      else if(guess == randomNum){
        guessResponse.setText("You got it!");
      }
    lastGuess.setText("Last guess was " + guess); 
    }

    else if (ae.getActionCommand().equals("Play Again")) {
      guessResponse.setText("");
      lastGuess.setText("");
      randomNum = r.nextInt(101);
      userGuess.setText("");
    }

    else {
      guessResponse.setText("You pressed Enter. Pleasse press the Guess Button");
    }

  }

}