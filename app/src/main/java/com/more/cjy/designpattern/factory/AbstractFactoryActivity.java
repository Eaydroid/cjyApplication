package com.more.cjy.designpattern.factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.more.cjy.R;
import com.more.cjy.designpattern.factory.car.Car;
import com.more.cjy.designpattern.factory.car.Carola;
import com.more.cjy.designpattern.factory.car.Jetta;
import com.more.cjy.designpattern.factory.car.Magotan;
import com.more.cjy.designpattern.factory.insurance.Insurance;
import com.more.cjy.designpattern.factory.insurance.PingAnInsurance;
import com.more.cjy.designpattern.factory.insurance.RenShouInsurance;

/**
 * @author cjy
 */
public class AbstractFactoryActivity extends Activity implements View.OnClickListener {
    private Button btnCreateJetta, btnCreateCarola, btnCreateMagotan, btnCreatePrado;
    private CarFactory volkswagenFactory, fawFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abctract_factory);

        btnCreateJetta = (Button) findViewById(R.id.btnCreateJetta);
        btnCreateJetta.setOnClickListener(this);
        btnCreateCarola = (Button) findViewById(R.id.btnCreateCarola);
        btnCreateCarola.setOnClickListener(this);
        btnCreateMagotan = (Button) findViewById(R.id.btnCreateMagotan);
        btnCreateMagotan.setOnClickListener(this);
        btnCreatePrado = (Button) findViewById(R.id.btnCreatePrado);
        btnCreatePrado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnCreateJetta:
                volkswagenFactory = new VolkswagenFactory();
                Jetta jetta = (Jetta) volkswagenFactory.createCar(Car.JETTA);
                Insurance insurance = new PingAnInsurance();
                jetta.setInsurance(insurance);
                break;
            case R.id.btnCreateCarola:
                fawFactory = new FAWFactory();
                Carola carola = (Carola) fawFactory.createCar(Car.CALOLA);
                carola.setInsurance(new RenShouInsurance());
                carola.drive();
                break;
            case R.id.btnCreateMagotan:
                volkswagenFactory = new VolkswagenFactory();
                Magotan magotan = (Magotan) volkswagenFactory.createCar(Magotan.class);
                magotan.drive();
                break;
            case R.id.btnCreatePrado:
                break;
        }
    }
}
