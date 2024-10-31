package com.desarrollosoftware.mutantes.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    private static final Set<Character> ALLOWED_CHARACTERS = Set.of('A','C','G','T');


    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {

        if (dna == null || dna.length == 0) return false;
        int n = dna.length;

        for (String str : dna) {
            if (str == null || n != str.length()) return false;

            for (char c : str.toCharArray()) {
                if (!ALLOWED_CHARACTERS.contains(c)) return false;

            }
        }


        return true;
    }
}
