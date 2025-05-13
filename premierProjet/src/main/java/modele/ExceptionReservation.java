package modele;

public class ExceptionReservation extends Exception {
  private int chCodeErreur ;
  public ExceptionReservation(int parCodeErreur){
    chCodeErreur = parCodeErreur;
  }

  public int getCodeErreur(){

    return chCodeErreur;
  }
}
