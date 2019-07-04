package PIB_RuotaDellaFortuna.Domain;

public class User {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getPuntiTotali_accumulati() {
        return puntiTotali_accumulati;
    }

    public void setPuntiTotali_accumulati(int puntiTotali_accumulati) {
        this.puntiTotali_accumulati = puntiTotali_accumulati;
    }

    String nome,Cognome,email,username,password;
    static int codice=0;
    int puntiTotali_accumulati;
}
