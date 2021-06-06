/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mercadolibre.Magneto.service.impl;

import co.com.mercadolibre.Magneto.service.DnaService;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian David Soto Ramirez - 1112773254
 * @version 1
 */
@Service
public class DnaServiceImpl implements DnaService {

    public String[] dna;

    @Override
    public boolean isMutant(String[] dna) {
        this.dna = dna;
        
       //TODO falta validar que solo entre caractheres A, G, C, T

        return horizontalMatches(dna)
                + diagonals(arrayToMatrix(dna), dna.length)
                + diagonals(rotateMatrix(arrayToMatrix(dna), dna.length), dna.length)
                + vertical(rotateMatrix(arrayToMatrix(dna), dna.length)) > 1;
    }

    private int diagonals(String[][] matrix, int n) {

        String separator = ",";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if (k < n && j < n) {
                    result.append(matrix[k][j]);
                }
            }
            result.append(separator);
        }

        result.setLength(result.length() - separator.length());
        String[] string = result.toString().split(",");

        return horizontalMatches(string);
    }

    private  int horizontalMatches(String[] dna) {

        int val = 0;
        for (String compare : dna) {
            if (compare.contains("AAAA")) {
                val = val + 1;
            } else if (compare.contains("CCCC")) {
                val = val + 1;
            } else if (compare.contains("TTTT")) {
                val = val + 1;
            } else if (compare.contains("GGGG")) {
                val = val + 1;
            }
        }
        return val;
    }

    private  int vertical(String[][] matrix) {

        String separator = ",";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j]);

            }
            result.append(separator);
        }

        result.setLength(result.length() - separator.length());
        String[] string = result.toString().split(",");

        return horizontalMatches(string);
    }

    private  String[][] rotateMatrix(String[][] matrix, int n) {

        String[][] newMatrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    private  String[][] arrayToMatrix(String[] dna) {

        String[][] matrix = new String[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            matrix[i] = dna[i].split("(?!^)");
        }

        return matrix;
    }
}
