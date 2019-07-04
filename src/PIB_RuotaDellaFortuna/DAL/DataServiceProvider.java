package PIB_RuotaDellaFortuna.DAL;

import PIB_RuotaDellaFortuna.Domain.User;

import java.util.HashMap;
import java.sql.*;
import java.util.Properties;
import org.postgresql.*;
import org.postgresql.core.SqlCommand;

public class DataServiceProvider implements IDataService {
    private Connection sqlConnection;

    public Connection getSqlConnection(){
        return sqlConnection;
    }
    public DataServiceProvider(String url,String user,String psw)throws SQLException {
        sqlConnection = openConnection(url, user, psw);
        System.out.println("Connesso al Db: " + sqlConnection.getCatalog());
    }
    private Connection openConnection(String url,String user,String psw) throws SQLException {
        Properties props= new Properties();
        props.setProperty("user", user);
        props.setProperty("password", psw);

        Connection conn= DriverManager.getConnection(url, props);
        return conn;
    }
    @Override
    public void saveNewUser(User ux) throws SQLException {
        Statement statement= null;
        String strUser= ux.getCodice()+","+ux.getNome()+","+ux.getCognome()+","+ux.getEmail()+","+ux.getUsername()+","+ux.getPassword()+","+ux.getPuntiTotali_accumulati();
        String sqlQuery= "INSERT INTO Users (idUser,nome,cognome,email,username,psw,PuntiTotaliAccumulati) VALUE("+strUser+");";

        statement= sqlConnection.createStatement();
        statement.executeQuery(sqlQuery);


    }
    @Override
    public HashMap<Integer, User> downloadUsersList() throws SQLException {
        HashMap<Integer,User> UsersList= new HashMap<>();
        Statement statement= null;

        String sqlQuery= "SELECT * FROM Users ";
        try {
            statement = sqlConnection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                User userDb= new User();
                userDb.setCodice(rs.getInt("idUser"));
                userDb.setNome(rs.getString("nome"));
                userDb.setCognome(rs.getString("cognome"));
                userDb.setEmail(rs.getString("email"));
                userDb.setUsername(rs.getString("username"));
                userDb.setPassword(rs.getString("psw"));
                userDb.setPuntiTotali_accumulati(rs.getInt("PuntiTotaliAccoumulati"));
                UsersList.put(userDb.getCodice(),userDb);
            }
            return UsersList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(statement!= null)
                statement.close();
            return new HashMap<>();
        }

    }
}
