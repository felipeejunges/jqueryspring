package br.com.felipejunges.simplespring.services;

import br.com.felipejunges.simplespring.domain.Registro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistroService {

    public List<Registro> findAll() {

        JSONParser jsonParser = new JSONParser();
        List<Registro> registros = new ArrayList<Registro>();

        try {
            JSONArray jsonArray = (JSONArray)jsonParser.parse(new FileReader("json/data.json"));
            for(Object obj : jsonArray) {
                JSONObject registro = (JSONObject) obj;

                long id = (long) registro.get("id");
                String dateTime = (String) registro.get("dataTime");
                String mate = (String) registro.get("mate");
                long total_weight = (long) registro.get("total_weight");
                long axle_number = (long) registro.get("axle_number");
                boolean overloaded = (boolean) registro.get("overloaded");
                String formFactor = (String) registro.get("formFactor");
                String sanpshot1 = (String) registro.get("sanpshot1");

                registros.add(new Registro(id, dateTime, mate, total_weight, axle_number, overloaded, formFactor, sanpshot1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public Registro find(int id) {
        Registro registro = null;
        List<Registro> registros = findAll();
        for(Registro reg : registros) {
            if(reg.getId() == id) {
                registro = reg;
                break;
            }
        }
        return registro;
    }
}
