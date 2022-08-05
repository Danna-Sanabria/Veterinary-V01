package presenters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import models.MedicalAppointment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonConvert {

    private String path;
    private String pathAppoiment;

    public JsonConvert() {
        path = ".\\resources\\dataPets.json";
        pathAppoiment = ".\\resources\\dataMedicalAppoiment.json";
    }

    public String medicalToJson(ArrayList<MedicalAppointment> medical) {
        Gson gson = new Gson();
        return gson.toJson(medical);
    }

    public void saveMedicalAppoiments(ArrayList<MedicalAppointment> MedicalAppointment) throws IOException {
        System.out.println("pureuba");
        FileWriter file = new FileWriter(pathAppoiment);
        file.write(medicalToJson(MedicalAppointment));
        file.close();
    }

    public ArrayList<MedicalAppointment> readMedical() throws IOException {
        FileReader file = new FileReader(pathAppoiment);
        JsonReader reader = new Gson().newJsonReader(file);
        Gson gson = new Gson();
        ArrayList<MedicalAppointment> medicalList = gson.fromJson(reader, new TypeToken<ArrayList<MedicalAppointment>>() {
        }.getType());
        file.close();
        return medicalList;
    }

}

