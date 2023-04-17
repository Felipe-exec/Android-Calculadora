package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual;
    private TextView textViewResultado; //recebe a resposta final
    private TextView textViewUltimaExpressao; //tem a expressão final
    private String expressao = "";
    private boolean fimConta = false;
    private Double resultado = 0.0;

    private Button buttonUmID, buttonDoisID, buttonTresID, buttonQuatroID, buttonCincoID,
            buttonSeisID, buttonSeteID, buttonOitoID, buttonNoveID, buttonZeroID, buttonVirgulaID, buttonSomaID, buttonSubtracaoID,
            buttonPorcentoID, buttonMultiplicacaoID, buttonDivisaoID, buttonResetID, buttonDeleteID;

    private boolean isUltimoCaractereOperador(String expressao) {
        String ultimoCaractere = expressao.substring(expressao.length() - 1);
        return ultimoCaractere.equals("+") || ultimoCaractere.equals("-") || ultimoCaractere.equals("*") || ultimoCaractere.equals("/") || ultimoCaractere.equals("%");
    }

    private void resetarVariaveisSeNecessario() {
        if (fimConta) {
            textViewResultado.setText("");
            textViewUltimaExpressao.setText("");
            resultado = 0.0;
            fimConta = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonIgual.setOnClickListener(this);

        buttonZeroID = findViewById(R.id.buttonZeroID);

        buttonUmID = findViewById(R.id.buttonUmID);

        buttonDoisID = findViewById(R.id.buttonDoisID);

        buttonTresID = findViewById(R.id.buttonTresID);

        buttonQuatroID = findViewById(R.id.buttonQuatroID);

        buttonCincoID = findViewById(R.id.buttonCincoID);

        buttonSeisID = findViewById(R.id.buttonSeisID);

        buttonSeteID = findViewById(R.id.buttonSeteID);

        buttonOitoID = findViewById(R.id.buttonOitoID);

        buttonNoveID = findViewById(R.id.buttonNoveID);

        buttonVirgulaID = findViewById(R.id.buttonVirgulaID);


        buttonSomaID = findViewById(R.id.buttonSomaID);


        buttonSubtracaoID = findViewById(R.id.buttonSubtracaoID);


        buttonPorcentoID = findViewById(R.id.buttonPorcentoID);


        buttonMultiplicacaoID = findViewById(R.id.buttonMultiplicacaoID);


        buttonDivisaoID = findViewById(R.id.buttonDivisaoID);
        buttonResetID = findViewById(R.id.buttonResetID);
        buttonDeleteID = findViewById(R.id.buttonDeleteID);

        buttonUmID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("1");
            }
        });

        buttonDoisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("2");
            }
        });

        buttonTresID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("3");
            }
        });

        buttonQuatroID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("4");
            }
        });

        buttonCincoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("5");
            }
        });

        buttonSeisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("6");
            }
        });

        buttonSeteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("7");
            }
        });

        buttonOitoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("8");
            }
        });

        buttonNoveID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("9");
            }
        });

        buttonZeroID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetarVariaveisSeNecessario();
                textViewUltimaExpressao.append("0");
            }
        });

        buttonVirgulaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if(expressao.substring(expressao.length() - 1).equals(".")){
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.append(".");
            }
        });

        buttonSomaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if (isUltimoCaractereOperador(expressao)) {
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.setText(resultado != 0 ? resultado + "+" : expressao + "+");
            }
        });

        buttonSubtracaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if (isUltimoCaractereOperador(expressao)) {
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.setText(resultado != 0 ? resultado + "-" : expressao + "-");
            }
        });


        buttonMultiplicacaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if (isUltimoCaractereOperador(expressao)) {
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.setText(resultado != 0 ? resultado + "*" : expressao + "*");
            }
        });

        buttonDivisaoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if (isUltimoCaractereOperador(expressao)) {
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.setText(resultado != 0 ? resultado + "/" : expressao + "/");
            }
        });

        buttonPorcentoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                expressao = textViewUltimaExpressao.getText().toString();
                if (isUltimoCaractereOperador(expressao)) {
                    buttonDeleteID.performClick();
                }
                textViewUltimaExpressao.setText(resultado != 0 ? resultado + "%" : expressao + "%");
            }
        });

        buttonResetID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
                resultado = 0.0;
            }
        });

        buttonDeleteID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fimConta = false;
                resultado = 0.0;
                expressao = textViewUltimaExpressao.getText().toString();
                if (expressao.length() > 0) {
                    expressao = expressao.substring(0, expressao.length() - 1);
                    textViewUltimaExpressao.setText(expressao);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonIgualID) {
            String calculo = textViewUltimaExpressao.getText().toString();
            fimConta = true;
            try {
                Calculable calc = new ExpressionBuilder(calculo).build();
                resultado = calc.calculate();
                textViewResultado.setText(resultado.toString());
            } catch (Exception e) {
                Log.e(TAG, "Erro ao avaliar a expressão: " + calculo, e);
                textViewResultado.setText("Erro");
            }
        }
    }
}


