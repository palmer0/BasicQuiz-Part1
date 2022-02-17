package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, replyText;

  private String[] questionArray;
  private int questionIndex=0;
  private int[] replyArray;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();
  }


  private void initLayoutData() {
    questionArray=getResources().getStringArray(R.array.question_array);
    replyArray=getResources().getIntArray(R.array.reply_array);
  }


  private void linkLayoutComponents() {
    falseButton = findViewById(R.id.falseButton);
    trueButton = findViewById(R.id.trueButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);

    questionText = findViewById(R.id.questionText);
    replyText = findViewById(R.id.replyText);
  }

  private void initLayoutContent() {
    questionText.setText(questionArray[questionIndex]);
    replyText.setText(R.string.empty_text);

  }


  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onTrueButtonClicked(View view) {
    if(replyArray[questionIndex] == 1) {
      // correct
      replyText.setText(R.string.correct_text);
    } else {
      // incorrect
      replyText.setText(R.string.incorrect_text);
    }
  }

  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onFalseButtonClicked(View view) {
    if(replyArray[questionIndex] == 0) {
      // correct
      replyText.setText(R.string.correct_text);
    } else {
      // incorrect
      replyText.setText(R.string.incorrect_text);
    }
  }

  //TODO: implementar boton para pasar a siguiente pantalla
  public void onCheatButtonClicked(View view) {
    // no implementado
  }

  //TODO: impedir que podamos hacer click en el boton
  // si aun no hemos contestado a la pregunta
  public void onNextButtonClicked(View view) {
    questionIndex++;

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente
    //TODO: refactorizar en un método este codigo
    // por si queremos implementar otras opciones posibles
    if(questionIndex == questionArray.length) {
      questionIndex=0;
    }

    //TODO: refactorizar en un método este codigo repetido
    questionText.setText(questionArray[questionIndex]);
    replyText.setText(R.string.empty_text);
  }
}
