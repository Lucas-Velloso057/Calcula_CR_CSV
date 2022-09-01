package Main;

import Classes.Notas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //String path = "notas.csv";
        List<Notas> list = new ArrayList<Notas>();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\notas.csv"))) {
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] vect = line.split(",");

                Notas Aluno = new Notas(vect[0], vect[1], vect[2], Integer.parseInt(vect[3]), Integer.parseInt(vect[4]), vect[5]);
                list.add(Aluno);

                line = br.readLine();
            }
            Notas.CalculaCR(list);
            Notas.CalculaCRCursos(list);

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

