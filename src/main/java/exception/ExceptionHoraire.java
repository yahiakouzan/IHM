package exception;

import java.lang.Exception;

public class ExceptionHoraire extends Exception {
    private int chCodeErreur ;
    public ExceptionHoraire(int parCodeErreur){
        chCodeErreur = parCodeErreur;}

    public int getCodeErreur(){
        return chCodeErreur;
    }

}
