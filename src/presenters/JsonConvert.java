package presenters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import models.MedicalAppointment;
import models.Pet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonConvert {

    private String PATH_DATA_PETS;
    private static final String PATH_APPOINTMENT_PRESENCIAL = ".\\resources\\dataMedicalAppointmentPresencial.json";
    private static final String PATH_APPOINTMENT_RESIDENCE = ".\\resources\\dataMedicalAppointmentResidence.json";

    public JsonConvert() {
        PATH_DATA_PETS = ".\\resources\\dataPets.json";
    }

    public String medicalToJson(ArrayList<MedicalAppointment> medical) {
        Gson gson = new Gson();
        return gson.toJson(medical);
    }

    public String petToJson(ArrayList<Pet> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public void saveListPet(ArrayList<Pet> listPet) throws IOException {
        FileWriter file = new FileWriter(PATH_DATA_PETS);
        file.write(petToJson(listPet));
        file.close();
    }

    public ArrayList<Pet> readDataPets() throws IOException {
        FileReader file = new FileReader(PATH_DATA_PETS);
        JsonReader reader = new Gson().newJsonReader(file);
        Gson gson = new Gson();
        ArrayList<Pet> petList = gson.fromJson(reader, new TypeToken<ArrayList<Pet>>() {
        }.getType());
        file.close();
        return petList;
    }

    public void saveMedicalAppoimentsPresencial(ArrayList<MedicalAppointment> MedicalAppointment) throws IOException {
        FileWriter file = new FileWriter(PATH_APPOINTMENT_PRESENCIAL);
        file.write(medicalToJson(MedicalAppointment));
        file.close();
    }

    public void saveMedicalAppoimentsResidence(ArrayList<MedicalAppointment> MedicalAppointment) throws IOException {
        FileWriter file = new FileWriter(PATH_APPOINTMENT_RESIDENCE);
        file.write(medicalToJson(MedicalAppointment));
        file.close();
    }

    public ArrayList<MedicalAppointment> readMedicalPresencial() throws IOException {
        FileReader file = new FileReader(PATH_APPOINTMENT_PRESENCIAL);
        return jsonReaderMedical(file);
    }

    public ArrayList<MedicalAppointment> readMedicalResidence() throws IOException {
        FileReader file = new FileReader(PATH_APPOINTMENT_RESIDENCE);
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

