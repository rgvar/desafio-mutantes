package com.desarrollosoftware.mutantes.services;


import org.springframework.stereotype.Service;

@Service
public class DnaAnalysisService {

    public boolean isMutant(String[] dna) {
        int mutationsSequences = 0;
        int mutationsRequired = 2;

        for (int i=0; i<dna.length; i++) {
            for (int j=0; j<dna.length; j++) {

                if (checkHorizontalRec(dna, i, j, 1) == 4)
                    mutationsSequences++;
                if (checkVerticalRec(dna, i, j, 1) == 4)
                    mutationsSequences++;
                if (checkDiagonalLeftRec(dna, i, j, 1) == 4)
                    mutationsSequences++;
                if (checkDiagonalRightRec(dna, i, j, 1) == 4)
                    mutationsSequences++;

                if (mutationsSequences >= mutationsRequired)
                    return true;

            }
        }

        return false;
    }


    private int checkHorizontalRec(String[] dna, int fila, int col, int n) {
        if (n == 4)
            return n;
        else if (col == dna.length-1)
            return 0;
        else if (dna[fila].charAt(col) == dna[fila].charAt(col+1))
            return checkHorizontalRec(dna, fila, col+1, n+1);
        else
            return 0;
    }
    private int checkVerticalRec(String[] dna, int fila, int col, int n) {
        if (n == 4)
            return n;
        else if (fila == dna.length-1)
            return 0;
        else if (dna[fila].charAt(col) == dna[fila+1].charAt(col))
            return checkVerticalRec(dna, fila+1, col, n+1);
        else
            return 0;
    }
    private int checkDiagonalLeftRec(String[] dna, int fila, int col, int n) {
        if (n == 4)
            return n;
        else if (col == dna.length-1 || fila == dna.length-1)
            return 0;
        else if (dna[fila].charAt(col) == dna[fila+1].charAt(col+1))
            return checkDiagonalLeftRec(dna, fila+1, col+1, n+1);
        else
            return 0;
    }
    private int checkDiagonalRightRec(String[] dna, int fila, int col, int n) {
        if (n == 4)
            return n;
        else if (col == 0 || fila == dna.length-1)
            return 0;
        else if (dna[fila].charAt(col) == dna[fila+1].charAt(col-1))
            return checkDiagonalRightRec(dna, fila+1, col-1, n+1);
        else
            return 0;
    }
}
