package PIB_RuotaDellaFortuna.Domain;

public class AdminUser extends  User {
    public final String PERMESSI = "AdminRdF";
    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    String Parola;

}
