package Classes;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    private String MATRICULA;
    private String COD_DISCIPLINA;
    private String COD_CURSO;
    private int NOTA;
    private int CARGA_HORARIA;
    private String ANO_SEMESTRE;

    public Notas(String matricula, String disc, String cod, int nota, int carga, String semestre) {
        this.MATRICULA = matricula;
        this.COD_DISCIPLINA = disc;
        this.COD_CURSO = cod;
        this.NOTA = nota;
        this.CARGA_HORARIA = carga;
        this.ANO_SEMESTRE = semestre;
    }


    public static void CalculaCR(List<Notas> array ){
        int SomaCargas = 0;
        int NotasCargas = 0;
        String aux = array.get(0).MATRICULA;
        int cont = -1;
        System.out.println("-------O CR dos alunos é: -------");

        for (Notas p : array){
            cont++;

            //Condicional para somar os valores de um mesmo curso
            if(p.MATRICULA.equals(aux) && array.size() != cont+1){
                SomaCargas += p.CARGA_HORARIA;
                NotasCargas += p.CARGA_HORARIA * p.NOTA;

            }else{
                System.out.println(aux + "  -  " + NotasCargas/SomaCargas);
                NotasCargas=0;
                SomaCargas=0;
                aux=p.getMATRICULA();
                SomaCargas += p.CARGA_HORARIA;
                NotasCargas += p.CARGA_HORARIA * p.NOTA;
            }
        }
        System.out.println("---------------------------------");
    }
    public static void CalculaCRCursos(List<Notas> array){           //Método para o cálculo de CR dos cursos

        array.sort(Comparator.comparing(t -> t.COD_CURSO));         //Ordenação do array com os dados do arquivo por ordem de Código do Curso

        int SomaCargas = 0;
        int NotasCargas = 0;

        String aux = array.get(0).COD_CURSO;


        System.out.println("-----Média de CR dos cursos -----");
        int cont = -1;

        //Calcula a média dos CR dos cursos e printa na tela
        for (Notas p : array) {
            cont++;

            //Condicional para somar os valores de um mesmo curso
            if (p.COD_CURSO.equals(aux) && array.size() != cont+1) {
                SomaCargas += p.CARGA_HORARIA;
                NotasCargas += p.CARGA_HORARIA * p.NOTA;

            //Condicional para printar na o resultado de cada curso e preparar os calculos do próximo curso
            }else{
                System.out.println(aux + "  -  " + NotasCargas / SomaCargas);
                NotasCargas = 0;
                SomaCargas = 0;
                aux = p.getCOD_CURSO();
                SomaCargas += p.CARGA_HORARIA;
                NotasCargas += p.CARGA_HORARIA * p.NOTA;
            }
        }
        System.out.println("-------------------------------");
    }

    public String getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(String MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public String getCOD_DISCIPLINA() {
        return COD_DISCIPLINA;
    }

    public void setCOD_DISCIPLINA(String COD_DISCIPLINA) {
        this.COD_DISCIPLINA = COD_DISCIPLINA;
    }

    public String getCOD_CURSO() {
        return COD_CURSO;
    }

    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    public int getNOTA() {
        return NOTA;
    }

    public void setNOTA(int NOTA) {
        this.NOTA = NOTA;
    }

    public int getCARGA_HORARIA() {
        return CARGA_HORARIA;
    }

    public void setCARGA_HORARIA(int CARGA_HORARIA) {
        this.CARGA_HORARIA = CARGA_HORARIA;
    }

    public String getANO_SEMESTRE() {
        return ANO_SEMESTRE;
    }

    public void setANO_SEMESTRE(String ANO_SEMESTRE) {
        this.ANO_SEMESTRE = ANO_SEMESTRE;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "MATRICULA='" + MATRICULA + '\'' +
                ", COD_DISCIPLINA='" + COD_DISCIPLINA + '\'' +
                ", COD_CURSO='" + COD_CURSO + '\'' +
                ", NOTA='" + NOTA + '\'' +
                ", CARGA_HORARIA='" + CARGA_HORARIA + '\'' +
                ", ANO_SEMESTRE='" + ANO_SEMESTRE + '\'' +
                '}';
    }
}
