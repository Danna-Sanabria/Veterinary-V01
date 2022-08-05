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
    private String pathAppointment;
    public static final String pathAppointmentResidence = ".\\resources\\dataMedicalAppointmentResidence.json";

    public JsonConvert() {
        path = ".\\resources\\dataPets.json";
        pathAppointment = ".\\resources\\dataMedicalAppointmentPresencial.json";
    }

    public String medicalToJson(ArrayList<MedicalAppointment> medical) {
        Gson gson = new Gson();
        return gson.toJson(medical);
    }

    public void saveMedicalAppoimentsPresencial(ArrayList<MedicalAppointment> MedicalAppointment) throws IOException {
        FileWriter file = new FileWriter(pathAppointment);
        file.write(medicalToJson(MedicalAppointment));
        file.close();
    }

    public void saveMedicalAppoimentsResidence(ArrayList<MedicalAppointment> MedicalAppointment) throws IOException {
        FileWriter file = new FileWriter(pathAppointmentResidence);
        file.write(medicalToJson(MedicalAppointment));
        file.close();
    }

    public ArrayList<MedicalAppointment> readMedicalPresencial() throws IOException {
        FileReader file = new FileReader(pathAppointment);
        return jsonReaderMedical(file);
    }

    public ArrayList<MedicalAppointment> readMedicalResidence() throws IOException {
        FileReader file = new FileReader(pathAppointmentResidence);
        return jsonReaderMedical(file);
    }

    public ArrayList<MedicalAppointment> jsonReaderMedical(FileReader file) throws IOException {
        JsonReader reader = new Gson().newJsonReader(file);
        Gson gson = new Gson();
        ArrayList<MedicalAppointment> medicalList = gson.fromJson(reader, new TypeToken<ArrayList<MedicalAppointment>>() {
        }.getType());
        file.close();
        return medicalList;
    }
}

