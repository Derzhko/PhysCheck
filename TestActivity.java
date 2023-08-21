package com.example.physcheck;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends Activity implements View.OnClickListener {
    int popitki = 10;
    String names [] = {"Путь","Координата","Ускорение","Угловая скорость","Масса","Равнодействующая сила","Сила тяжести","Сила трения",
            "Сила упругости","Закон Архимеда","Закон всемирного тяготения","Момент силы","Давление твердых тел","Давление в жидкостях","Гидравлический пресс","Механическая работа","Мощность","КПД","Кинетическая энергия",
            "Потенциальная энергия","Количество теплоты","Теплота сгорания","Теплота парообразования",
            "Тепловое действие тока","Работа тока","Мощность тока","Энергия пружины","Закон сохранения энергии",
            "Импульс","Закон сохранения импульса","Первый закон термодинамики","Внутренняя энергия газа","Энергия газа",
            "Давление идеального газа","Закон Менделеева-Клайперона","Изотермический процесс","Изобарический процесс",
            "Изохорический процесс","Закон Ома","Сопротивление проводника","Заряд","Закон Кулона","Напряженность поля","Электроемкость","Потенциал поля","Энергия конденсатора",
            "ЭДС","Закон электролиза"};
    String formuls [] = {"S=Vt","x=x0+V0t+at2/2","а=V-V0/t","w= 2π/T","m=pv","F=ma","F=mg","F=мN","Fупр=-kx","F=pжVтg","F=Gm1m2/R2",
            "M=Fl","p=F/S","p=pgh","F1/F2=S2/S1","A=FScosa","N=A/t","КПД=Ап/Aз100%=Qп/Qз100%","E=mv^2/2","E=mgh","Q=cm(t2-t1 )",
            "Q=qm","Q=Lm","Q=I2Rt","A=IUt","P=A/t=UI","E=kx^2/2","E=Ek+Ep+Eвн","p=mv","mv1+mv2=mv1'=+mv2'",
            "DU = A + Q = Q – A¢; Q = DU + A¢","U = 3m/2M × RT","E = 3/2kT = mu2/2","P = 1/3ru2 = 2/3nE = nkT",
            "PV/T = m/M . R = nR = const","T = const; P1V1 = P2V2; P1/P2 = V2/V1","P = const; V1/V2 = T1/T2; V1 = V0(1 + a(t1 - t0)); a = DV/V0Dt",
            "V = const; P1/P2 = T1/T2; P1 = P0(1 + g(t1 - t0)); g = DP/P0Dt","I=U/R","R=pl/s","q=It=A/U","F=k|q1||q2|/r^2","E=kq/r^2","С=q/U",
            "j = W/q = kq/r","W=qU/2=q^2/(2C)=CU^2/2","e = Aст/q","m = kq = kIDt"};

    TextView tvtrue, tvfalse, tv1, tv2, tv3, tv4, tventer;
    Random rndposition = new Random();
    Random rndindex = new Random();
    Random rndother = new Random();
    String otherformuls[] = new String [names.length];
    int position;
    int index;
    int itrue, ifalse;
    TextView arrTv [];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tvtrue = findViewById(R.id.tvtrue);
        tvfalse = findViewById(R.id.tvfalse);
        tventer= findViewById(R.id.tventer);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        arrTv = new TextView[]{tv1, tv2, tv3, tv4};
        change();
    }

    private void change(){
        if (popitki > 0){
            position = rndposition.nextInt(4);
            index = rndindex.nextInt(names.length);
            tvtrue.setText("Верно: "+ String.valueOf(itrue));
            tvfalse.setText("Ошибок: "+String.valueOf(ifalse));
            for (int i = 0; i < otherformuls.length; i++) {
                if (i!=index)
                    otherformuls[i]=formuls[i];
            }
            tventer.setText(names[index]);
            arrTv[position].setText(formuls[index]);
            for (int i = 0; i < arrTv.length; i++) {
                if (arrTv[i] != arrTv[position])
                    arrTv[i].setText(otherformuls[rndother.nextInt(names.length)]);
            }

            popitki--;
        }
        else{
            if (itrue>=8) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Поздравляем!")
                        .setMessage("Вы превосходно знаете физику")
                        .setIcon(R.drawable.detii)
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else if(itrue>=5 && itrue<8){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Поздравляем!")
                        .setMessage("Вы хорошо знаете физику, но нужно ботать")
                        .setIcon(R.drawable.nope)
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Тихий ужас!")
                        .setMessage("Хватить бездельничать. УЧИ ФИЗИКУ!!!(Щевелёв А.А.)")
                        .setIcon(R.drawable.cry)
                        .setCancelable(false)
                        .setNegativeButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == arrTv[position].getId())
            itrue++;
        else
            ifalse++;
        change();
    }
}
